package net.minecraft.server;

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

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import com.google.common.collect.Queues;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class class_ek extends SimpleChannelInboundHandler {
	private static final Logger g = LogManager.getLogger();
	public static final Marker a = MarkerManager.getMarker("NETWORK");
	public static final Marker b;
	public static final AttributeKey c;
	public static final class_nw d;
	public static final class_nw e;
	public static final class_nw f;
	private final EnumProtocolDirection h;
	private final Queue i = Queues.newConcurrentLinkedQueue();
	private final ReentrantReadWriteLock j = new ReentrantReadWriteLock();
	private Channel k;
	private SocketAddress l;
	private PacketListener m;
	private IChatBaseComponent n;
	private boolean o;
	private boolean p;

	public class_ek(EnumProtocolDirection var1) {
		h = var1;
	}

	@Override
	public void channelActive(ChannelHandlerContext var1) throws Exception {
		super.channelActive(var1);
		k = var1.channel();
		l = k.remoteAddress();

		try {
			this.a(EnumProtocol.HANDSHAKING);
		} catch (Throwable var3) {
			g.fatal(var3);
		}

	}

	public void a(EnumProtocol var1) {
		k.attr(c).set(var1);
		k.config().setAutoRead(true);
		g.debug("Enabled auto read");
	}

	@Override
	public void channelInactive(ChannelHandlerContext var1) throws Exception {
		this.a((new class_fb("disconnect.endOfStream", new Object[0])));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception {
		class_fb var3;
		if (var2 instanceof TimeoutException) {
			var3 = new class_fb("disconnect.timeout", new Object[0]);
		} else {
			var3 = new class_fb("disconnect.genericReason", new Object[] { "Internal Exception: " + var2 });
		}

		this.a(var3);
	}

	protected void a(ChannelHandlerContext var1, Packet var2) throws Exception {
		if (k.isOpen()) {
			try {
				var2.handle(m);
			} catch (class_ko var4) {
				;
			}
		}

	}

	public void a(PacketListener var1) {
		Validate.notNull(var1, "packetListener", new Object[0]);
		g.debug("Set listener of {} to {}", new Object[] { this, var1 });
		m = var1;
	}

	public void a(Packet var1) {
		if (g()) {
			m();
			this.a(var1, (GenericFutureListener[]) null);
		} else {
			j.writeLock().lock();

			try {
				i.add(new class_ek.class_a_in_class_ek(var1, (GenericFutureListener[]) null));
			} finally {
				j.writeLock().unlock();
			}
		}

	}

	public void a(Packet var1, GenericFutureListener var2, GenericFutureListener... var3) {
		if (g()) {
			m();
			this.a(var1, ArrayUtils.add(var3, 0, var2));
		} else {
			j.writeLock().lock();

			try {
				i.add(new class_ek.class_a_in_class_ek(var1, ArrayUtils.add(var3, 0, var2)));
			} finally {
				j.writeLock().unlock();
			}
		}

	}

	private void a(final Packet var1, final GenericFutureListener[] var2) {
		final EnumProtocol var3 = EnumProtocol.a(var1);
		final EnumProtocol var4 = (EnumProtocol) k.attr(c).get();
		if (var4 != var3) {
			g.debug("Disabled auto read");
			k.config().setAutoRead(false);
		}

		if (k.eventLoop().inEventLoop()) {
			if (var3 != var4) {
				this.a(var3);
			}

			ChannelFuture var5 = k.writeAndFlush(var1);
			if (var2 != null) {
				var5.addListeners(var2);
			}

			var5.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
		} else {
			k.eventLoop().execute(new Runnable() {
				@Override
				public void run() {
					if (var3 != var4) {
						class_ek.this.a(var3);
					}

					ChannelFuture var1x = k.writeAndFlush(var1);
					if (var2 != null) {
						var1x.addListeners(var2);
					}

					var1x.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
				}
			});
		}

	}

	private void m() {
		if ((k != null) && k.isOpen()) {
			j.readLock().lock();

			try {
				while (!i.isEmpty()) {
					class_ek.class_a_in_class_ek var1 = (class_ek.class_a_in_class_ek) i.poll();
					this.a(var1.a, var1.b);
				}
			} finally {
				j.readLock().unlock();
			}

		}
	}

	public void a() {
		m();
		if (m instanceof class_ks) {
			((class_ks) m).c();
		}

		k.flush();
	}

	public SocketAddress b() {
		return l;
	}

	public void a(IChatBaseComponent var1) {
		if (k.isOpen()) {
			k.close().awaitUninterruptibly();
			n = var1;
		}

	}

	public boolean c() {
		return (k instanceof LocalChannel) || (k instanceof LocalServerChannel);
	}

	public void a(SecretKey var1) {
		o = true;
		k.pipeline().addBefore("splitter", "decrypt", new class_eg(class_no.a(2, var1)));
		k.pipeline().addBefore("prepender", "encrypt", new class_eh(class_no.a(1, var1)));
	}

	public boolean g() {
		return (k != null) && k.isOpen();
	}

	public boolean h() {
		return k == null;
	}

	public PacketListener i() {
		return m;
	}

	public IChatBaseComponent j() {
		return n;
	}

	public void k() {
		k.config().setAutoRead(false);
	}

	public void a(int var1) {
		if (var1 >= 0) {
			if (k.pipeline().get("decompress") instanceof class_ei) {
				((class_ei) k.pipeline().get("decompress")).a(var1);
			} else {
				k.pipeline().addBefore("decoder", "decompress", new class_ei(var1));
			}

			if (k.pipeline().get("compress") instanceof class_ej) {
				((class_ej) k.pipeline().get("decompress")).a(var1);
			} else {
				k.pipeline().addBefore("encoder", "compress", new class_ej(var1));
			}
		} else {
			if (k.pipeline().get("decompress") instanceof class_ei) {
				k.pipeline().remove("decompress");
			}

			if (k.pipeline().get("compress") instanceof class_ej) {
				k.pipeline().remove("compress");
			}
		}

	}

	public void l() {
		if ((k != null) && !k.isOpen()) {
			if (!p) {
				p = true;
				if (j() != null) {
					i().a(j());
				} else if (i() != null) {
					i().a(new class_fa("Disconnected"));
				}
			} else {
				g.warn("handleDisconnection() called twice");
			}

		}
	}

	// $FF: synthetic method
	@Override
	protected void channelRead0(ChannelHandlerContext var1, Object var2) throws Exception {
		this.a(var1, (Packet) var2);
	}

	static {
		b = MarkerManager.getMarker("NETWORK_PACKETS", a);
		c = AttributeKey.valueOf("protocol");
		d = new class_nw() {
			protected NioEventLoopGroup a() {
				return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Client IO #%d").setDaemon(true).build());
			}

			// $FF: synthetic method
			@Override
			protected Object b() {
				return this.a();
			}
		};
		e = new class_nw() {
			protected EpollEventLoopGroup a() {
				return new EpollEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Epoll Client IO #%d").setDaemon(true).build());
			}

			// $FF: synthetic method
			@Override
			protected Object b() {
				return this.a();
			}
		};
		f = new class_nw() {
			protected LocalEventLoopGroup a() {
				return new LocalEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Local Client IO #%d").setDaemon(true).build());
			}

			// $FF: synthetic method
			@Override
			protected Object b() {
				return this.a();
			}
		};
	}

	static class class_a_in_class_ek {
		private final Packet a;
		private final GenericFutureListener[] b;

		public class_a_in_class_ek(Packet var1, GenericFutureListener... var2) {
			a = var1;
			b = var2;
		}
	}
}
