package net.minecraft.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalServerChannel;
import io.netty.handler.timeout.TimeoutException;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.net.SocketAddress;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.crypto.SecretKey;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import com.google.common.collect.Queues;

public class NetworkManager extends SimpleChannelInboundHandler<Packet<PacketListener>> {

	private static final Logger LOGGER = LogManager.getLogger();
	public static final Marker NETWORK_MARKER = MarkerManager.getMarker("NETWORK");
	public static final Marker NETWORK_MARKER_PACKETS = MarkerManager.getMarker("NETWORK_PACKETS", NETWORK_MARKER);
	public static final AttributeKey<EnumProtocol> PROTOCOL = AttributeKey.valueOf("protocol");

	private final Queue<QueuedPacket> sendQueue = Queues.newConcurrentLinkedQueue();
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private Channel channel;
	private SocketAddress address;
	private PacketListener packetListener;
	private IChatBaseComponent disconnectMessage;
	private boolean handledDisconnect;

	public NetworkManager(EnumProtocolDirection direction) {
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		channel = ctx.channel();
		address = channel.remoteAddress();

		try {
			setProtocol(EnumProtocol.HANDSHAKING);
		} catch (Throwable var3) {
			LOGGER.fatal(var3);
		}
	}

	public void setProtocol(EnumProtocol protocol) {
		channel.attr(PROTOCOL).set(protocol);
		channel.config().setAutoRead(true);
		LOGGER.debug("Enabled auto read");
	}

	@Override
	public void channelInactive(ChannelHandlerContext var1) throws Exception {
		close((new class_fb("disconnect.endOfStream")));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception {
		class_fb message;
		if (var2 instanceof TimeoutException) {
			message = new class_fb("disconnect.timeout");
		} else {
			message = new class_fb("disconnect.genericReason", new Object[] { "Internal Exception: " + var2 });
		}

		close(message);
	}

	protected void channelRead0(ChannelHandlerContext var1, Packet<PacketListener> packet) throws Exception {
		if (channel.isOpen()) {
			try {
				packet.handle(packetListener);
			} catch (class_kj var4) {
			}
		}
	}

	public void setPacketListener(PacketListener var1) {
		Validate.notNull(var1, "packetListener");
		LOGGER.debug("Set listener of {} to {}", new Object[] { this, var1 });
		packetListener = var1;
	}

	public void sendPacket(Packet<? extends PacketListener> packet) {
		if (isActive()) {
			flushSendQueue();
			this.sendPacket(packet, (GenericFutureListener<? extends Future<? super Void>>[]) null);
		} else {
			lock.writeLock().lock();

			try {
				sendQueue.add(new NetworkManager.QueuedPacket(packet, (GenericFutureListener<? extends Future<? super Void>>[]) null));
			} finally {
				lock.writeLock().unlock();
			}
		}

	}

	@SuppressWarnings("unchecked")
	public void sendPacket(Packet<? extends PacketListener> packet, GenericFutureListener<? extends Future<? super Void>> listener, GenericFutureListener<? extends Future<? super Void>>... listeners) {
		if (isActive()) {
			flushSendQueue();
			this.sendPacket(packet, ArrayUtils.add(listeners, 0, listener));
		} else {
			lock.writeLock().lock();
			try {
				sendQueue.add(new NetworkManager.QueuedPacket(packet, ArrayUtils.add(listeners, 0, listener)));
			} finally {
				lock.writeLock().unlock();
			}
		}
	}

	private void sendPacket(final Packet<? extends PacketListener> packet, final GenericFutureListener<? extends Future<? super Void>>[] listeners) {
		final EnumProtocol packetProtocol = EnumProtocol.getForPacket(packet);
		final EnumProtocol currentProtocol = channel.attr(PROTOCOL).get();
		if (currentProtocol != packetProtocol) {
			LOGGER.debug("Disabled auto read");
			channel.config().setAutoRead(false);
		}

		if (channel.eventLoop().inEventLoop()) {
			if (packetProtocol != currentProtocol) {
				setProtocol(packetProtocol);
			}

			ChannelFuture future = channel.writeAndFlush(packet);
			if (listeners != null) {
				future.addListeners(listeners);
			}

			future.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
		} else {
			channel.eventLoop().execute(new Runnable() {
				@Override
				public void run() {
					if (packetProtocol != currentProtocol) {
						NetworkManager.this.setProtocol(packetProtocol);
					}

					ChannelFuture future = channel.writeAndFlush(packet);
					if (listeners != null) {
						future.addListeners(listeners);
					}

					future.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
				}
			});
		}
	}

	private void flushSendQueue() {
		if ((channel != null) && channel.isOpen()) {
			lock.readLock().lock();
			try {
				while (!sendQueue.isEmpty()) {
					NetworkManager.QueuedPacket var1 = sendQueue.poll();
					this.sendPacket(var1.packet, var1.listeners);
				}
			} finally {
				lock.readLock().unlock();
			}
		}
	}

	public void tick() {
		flushSendQueue();
		if (packetListener instanceof ITickAble) {
			((ITickAble) packetListener).tick();
		}

		channel.flush();
	}

	public SocketAddress getAddress() {
		return address;
	}

	public void close(IChatBaseComponent message) {
		if (channel.isOpen()) {
			channel.close().awaitUninterruptibly();
			disconnectMessage = message;
		}
	}

	public boolean isLocal() {
		return (channel instanceof LocalChannel) || (channel instanceof LocalServerChannel);
	}

	public void enableEncryption(SecretKey key) {
		channel.pipeline().addBefore("splitter", "decrypt", new class_eg(MinecraftEncryption.getCipher(2, key)));
		channel.pipeline().addBefore("prepender", "encrypt", new class_eh(MinecraftEncryption.getCipher(1, key)));
	}

	public boolean isActive() {
		return (channel != null) && channel.isOpen();
	}

	public boolean isPreparing() {
		return channel == null;
	}

	public PacketListener getPacketListener() {
		return packetListener;
	}

	public IChatBaseComponent getDisconnectMessage() {
		return disconnectMessage;
	}

	public void disableAutoRead() {
		channel.config().setAutoRead(false);
	}

	public void setCompression(int threshold) {
		if (threshold >= 0) {
			if (channel.pipeline().get("decompress") instanceof class_ei) {
				((class_ei) channel.pipeline().get("decompress")).a(threshold);
			} else {
				channel.pipeline().addBefore("decoder", "decompress", new class_ei(threshold));
			}

			if (channel.pipeline().get("compress") instanceof class_ej) {
				((class_ej) channel.pipeline().get("decompress")).a(threshold);
			} else {
				channel.pipeline().addBefore("encoder", "compress", new class_ej(threshold));
			}
		} else {
			if (channel.pipeline().get("decompress") instanceof class_ei) {
				channel.pipeline().remove("decompress");
			}

			if (channel.pipeline().get("compress") instanceof class_ej) {
				channel.pipeline().remove("compress");
			}
		}

	}

	public void handleDisconnection() {
		if ((channel != null) && !channel.isOpen()) {
			if (!handledDisconnect) {
				handledDisconnect = true;
				if (getDisconnectMessage() != null) {
					getPacketListener().disconnect(getDisconnectMessage());
				} else if (getPacketListener() != null) {
					getPacketListener().disconnect(new class_fa("Disconnected"));
				}
			} else {
				LOGGER.warn("handleDisconnection() called twice");
			}

		}
	}

	static class QueuedPacket {
		private final Packet<? extends PacketListener> packet;
		private final GenericFutureListener<? extends Future<? super Void>>[] listeners;

		@SafeVarargs
		public QueuedPacket(Packet<? extends PacketListener> packet, GenericFutureListener<? extends Future<? super Void>>... listeners) {
			this.packet = packet;
			this.listeners = listeners;
		}
	}

}
