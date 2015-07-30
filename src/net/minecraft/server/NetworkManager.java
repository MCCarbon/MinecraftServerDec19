package net.minecraft.server;

import com.google.common.collect.Queues;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalEventLoopGroup;
import io.netty.channel.local.LocalServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.handler.timeout.TimeoutException;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GenericFutureListener;

import java.net.SocketAddress;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.crypto.SecretKey;

import net.minecraft.server.NetworkManager.class_a_in_class_ek;
import net.minecraft.server.class_eg;
import net.minecraft.server.class_eh;
import net.minecraft.server.class_ei;
import net.minecraft.server.class_ej;
import net.minecraft.server.EnumProtocol;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.Packet;
import net.minecraft.server.EnumProtocolDirection;
import net.minecraft.server.class_kj;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_ni;
import net.minecraft.server.LazyInitVar;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class NetworkManager extends SimpleChannelInboundHandler {
	private static final Logger LOGGER = LogManager.getLogger();
	public static final Marker a = MarkerManager.getMarker("NETWORK");
	public static final Marker b;
	public static final AttributeKey<EnumProtocol> c;
	public static final LazyInitVar d;
	public static final LazyInitVar e;
	public static final LazyInitVar f;
	private final EnumProtocolDirection h;
	private final Queue<class_a_in_class_ek> sendQueue = Queues.newConcurrentLinkedQueue();
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private Channel channel;
	private SocketAddress address;
	private PacketListener m;
	private IChatBaseComponent n;
	private boolean handledDisconnect;

	public NetworkManager(EnumProtocolDirection var1) {
		this.h = var1;
	}

	public void channelActive(ChannelHandlerContext var1) throws Exception {
		super.channelActive(var1);
		this.channel = var1.channel();
		this.address = this.channel.remoteAddress();

		try {
			this.a(EnumProtocol.HANDSHAKING);
		} catch (Throwable var3) {
			LOGGER.fatal((Object) var3);
		}

	}

	public void a(EnumProtocol var1) {
		this.channel.attr(c).set(var1);
		this.channel.config().setAutoRead(true);
		LOGGER.debug("Enabled auto read");
	}

	public void channelInactive(ChannelHandlerContext var1) throws Exception {
		this.a((IChatBaseComponent) (new class_fb("disconnect.endOfStream", new Object[0])));
	}

	public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception {
		class_fb var3;
		if (var2 instanceof TimeoutException) {
			var3 = new class_fb("disconnect.timeout", new Object[0]);
		} else {
			var3 = new class_fb("disconnect.genericReason", new Object[] { "Internal Exception: " + var2 });
		}

		this.a((IChatBaseComponent) var3);
	}

	protected void a(ChannelHandlerContext var1, Packet var2) throws Exception {
		if (this.channel.isOpen()) {
			try {
				var2.handle(this.m);
			} catch (class_kj var4) {
				;
			}
		}

	}

	public void setPacketListener(PacketListener var1) {
		Validate.notNull(var1, "packetListener", new Object[0]);
		LOGGER.debug("Set listener of {} to {}", new Object[] { this, var1 });
		this.m = var1;
	}

	public void a(Packet var1) {
		if (this.isActive()) {
			this.flushSendQueue();
			this.sendPacket((Packet) var1, (GenericFutureListener[]) null);
		} else {
			this.lock.writeLock().lock();

			try {
				this.sendQueue.add(new NetworkManager.class_a_in_class_ek(var1, (GenericFutureListener[]) null));
			} finally {
				this.lock.writeLock().unlock();
			}
		}

	}

	public void sendPacket(Packet packet, GenericFutureListener<?> listener, GenericFutureListener<?>... listeners) {
		if (this.isActive()) {
			this.flushSendQueue();
			this.sendPacket(packet, ArrayUtils.add(listeners, 0, listener));
		} else {
			this.lock.writeLock().lock();
			try {
				this.sendQueue.add(new NetworkManager.class_a_in_class_ek(packet, ArrayUtils.add(listeners, 0, listener)));
			} finally {
				this.lock.writeLock().unlock();
			}
		}
	}

	private void sendPacket(final Packet packet, final GenericFutureListener[] var2) {
		final EnumProtocol var3 = EnumProtocol.getForPacket(packet);
		final EnumProtocol var4 = (EnumProtocol) this.channel.attr(c).get();
		if (var4 != var3) {
			LOGGER.debug("Disabled auto read");
			this.channel.config().setAutoRead(false);
		}

		if (this.channel.eventLoop().inEventLoop()) {
			if (var3 != var4) {
				this.a(var3);
			}

			ChannelFuture var5 = this.channel.writeAndFlush(packet);
			if (var2 != null) {
				var5.addListeners(var2);
			}

			var5.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
		} else {
			this.channel.eventLoop().execute(new Runnable() {
				public void run() {
					if (var3 != var4) {
						NetworkManager.this.a(var3);
					}

					ChannelFuture var1x = NetworkManager.this.channel.writeAndFlush(packet);
					if (var2 != null) {
						var1x.addListeners(var2);
					}

					var1x.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
				}
			});
		}

	}

	private void flushSendQueue() {
		if (this.channel != null && this.channel.isOpen()) {
			this.lock.readLock().lock();
			try {
				while (!this.sendQueue.isEmpty()) {
					NetworkManager.class_a_in_class_ek var1 = (NetworkManager.class_a_in_class_ek) this.sendQueue.poll();
					this.sendPacket(var1.a, var1.b);
				}
			} finally {
				this.lock.readLock().unlock();
			}
		}
	}

	public void tick() {
		this.flushSendQueue();
		if (this.m instanceof class_kn) {
			((class_kn) this.m).c();
		}

		this.channel.flush();
	}

	public SocketAddress getAddress() {
		return this.address;
	}

	public void a(IChatBaseComponent var1) {
		if (this.channel.isOpen()) {
			this.channel.close().awaitUninterruptibly();
			this.n = var1;
		}

	}

	public boolean isLocal() {
		return this.channel instanceof LocalChannel || this.channel instanceof LocalServerChannel;
	}

	public void enableEncryption(SecretKey key) {
		this.channel.pipeline().addBefore("splitter", "decrypt", new class_eg(class_ni.a(2, key)));
		this.channel.pipeline().addBefore("prepender", "encrypt", new class_eh(class_ni.a(1, key)));
	}

	public boolean isActive() {
		return this.channel != null && this.channel.isOpen();
	}

	public boolean isPreparing() {
		return this.channel == null;
	}

	public PacketListener getPacketListener() {
		return this.m;
	}

	public IChatBaseComponent j() {
		return this.n;
	}

	public void disableAutoRead() {
		this.channel.config().setAutoRead(false);
	}

	public void a(int var1) {
		if (var1 >= 0) {
			if (this.channel.pipeline().get("decompress") instanceof class_ei) {
				((class_ei) this.channel.pipeline().get("decompress")).a(var1);
			} else {
				this.channel.pipeline().addBefore("decoder", "decompress", new class_ei(var1));
			}

			if (this.channel.pipeline().get("compress") instanceof class_ej) {
				((class_ej) this.channel.pipeline().get("decompress")).a(var1);
			} else {
				this.channel.pipeline().addBefore("encoder", "compress", new class_ej(var1));
			}
		} else {
			if (this.channel.pipeline().get("decompress") instanceof class_ei) {
				this.channel.pipeline().remove("decompress");
			}

			if (this.channel.pipeline().get("compress") instanceof class_ej) {
				this.channel.pipeline().remove("compress");
			}
		}

	}

	public void handleDisconnection() {
		if (this.channel != null && !this.channel.isOpen()) {
			if (!this.handledDisconnect) {
				this.handledDisconnect = true;
				if (this.j() != null) {
					this.getPacketListener().disconnect(this.j());
				} else if (this.getPacketListener() != null) {
					this.getPacketListener().disconnect(new class_fa("Disconnected"));
				}
			} else {
				LOGGER.warn("handleDisconnection() called twice");
			}

		}
	}

	// $FF: synthetic method
	protected void channelRead0(ChannelHandlerContext var1, Object var2) throws Exception {
		this.a(var1, (Packet) var2);
	}

	static {
		b = MarkerManager.getMarker("NETWORK_PACKETS", a);
		c = AttributeKey.valueOf("protocol");
		d = new LazyInitVar() {
			protected NioEventLoopGroup a() {
				return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Client IO #%d").setDaemon(true).build());
			}

			// $FF: synthetic method
			protected Object init() {
				return this.a();
			}
		};
		e = new LazyInitVar() {
			protected EpollEventLoopGroup a() {
				return new EpollEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Epoll Client IO #%d").setDaemon(true).build());
			}

			// $FF: synthetic method
			protected Object init() {
				return this.a();
			}
		};
		f = new LazyInitVar() {
			protected LocalEventLoopGroup a() {
				return new LocalEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Local Client IO #%d").setDaemon(true).build());
			}

			// $FF: synthetic method
			protected Object init() {
				return this.a();
			}
		};
	}

	static class class_a_in_class_ek {
		private final Packet a;
		private final GenericFutureListener[] b;

		public class_a_in_class_ek(Packet var1, GenericFutureListener... var2) {
			this.a = var1;
			this.b = var2;
		}
	}
}
