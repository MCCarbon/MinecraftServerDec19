package net.minecraft.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.local.LocalEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class class_ls {
	private static final Logger e = LogManager.getLogger();
	public static final class_nw a = new class_nw() {
		protected NioEventLoopGroup a() {
			return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Server IO #%d").setDaemon(true).build());
		}

		// $FF: synthetic method
		@Override
		protected Object b() {
			return this.a();
		}
	};
	public static final class_nw b = new class_nw() {
		protected EpollEventLoopGroup a() {
			return new EpollEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Epoll Server IO #%d").setDaemon(true).build());
		}

		// $FF: synthetic method
		@Override
		protected Object b() {
			return this.a();
		}
	};
	public static final class_nw c = new class_nw() {
		protected LocalEventLoopGroup a() {
			return new LocalEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Local Server IO #%d").setDaemon(true).build());
		}

		// $FF: synthetic method
		@Override
		protected Object b() {
			return this.a();
		}
	};
	private final MinecraftServer f;
	public volatile boolean d;
	private final List g = Collections.synchronizedList(Lists.newArrayList());
	private final List h = Collections.synchronizedList(Lists.newArrayList());

	public class_ls(MinecraftServer var1) {
		f = var1;
		d = true;
	}

	public void a(InetAddress var1, int var2) throws IOException {
		List var3 = g;
		synchronized (g) {
			Class var4;
			class_nw var5;
			if (Epoll.isAvailable() && f.ak()) {
				var4 = EpollServerSocketChannel.class;
				var5 = b;
				e.info("Using epoll channel type");
			} else {
				var4 = NioServerSocketChannel.class;
				var5 = a;
				e.info("Using default channel type");
			}

			g.add((new ServerBootstrap()).channel(var4).childHandler(new ChannelInitializer() {
				@Override
				protected void initChannel(Channel var1) throws Exception {
					try {
						var1.config().setOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(true));
					} catch (ChannelException var3) {
						;
					}

					var1.pipeline().addLast("timeout", (new ReadTimeoutHandler(30))).addLast("legacy_query", (new class_lq(class_ls.this))).addLast("splitter", (new class_eq())).addLast("decoder", (new class_en(EnumProtocolDirection.SERVERBOUND))).addLast("prepender", (new class_er())).addLast("encoder", (new class_eo(EnumProtocolDirection.CLIENTBOUND)));
					class_ek var2 = new class_ek(EnumProtocolDirection.SERVERBOUND);
					h.add(var2);
					var1.pipeline().addLast("packet_handler", var2);
					var2.a((new HandShakeListener(f, var2)));
				}
			}).group((EventLoopGroup) var5.c()).localAddress(var1, var2).bind().syncUninterruptibly());
		}
	}

	public void b() {
		d = false;
		Iterator var1 = g.iterator();

		while (var1.hasNext()) {
			ChannelFuture var2 = (ChannelFuture) var1.next();

			try {
				var2.channel().close().sync();
			} catch (InterruptedException var4) {
				e.error("Interrupted whilst closing channel");
			}
		}

	}

	public void c() {
		List var1 = h;
		synchronized (h) {
			Iterator var2 = h.iterator();

			while (true) {
				while (true) {
					class_ek var3;
					do {
						if (!var2.hasNext()) {
							return;
						}

						var3 = (class_ek) var2.next();
					} while (var3.h());

					if (!var3.g()) {
						var2.remove();
						var3.l();
					} else {
						try {
							var3.a();
						} catch (Exception var8) {
							final class_ek vvar3 = var3;
							if (var3.c()) {
								class_b var10 = class_b.a(var8, "Ticking memory connection");
								class_c var6 = var10.a("Ticking connection");
								var6.a("Connection", new Callable() {
									public String a() throws Exception {
										return vvar3.toString();
									}

									// $FF: synthetic method
									@Override
									public Object call() throws Exception {
										return this.a();
									}
								});
								throw new class_e(var10);
							}

							e.warn("Failed to handle packet for " + var3.b(), var8);
							final class_fa var5 = new class_fa("Internal server error");
							var3.a(new class_gj(var5), new GenericFutureListener() {
								@Override
								public void operationComplete(Future var1) throws Exception {
									vvar3.a(var5);
								}
							}, new GenericFutureListener[0]);
							var3.k();
						}
					}
				}
			}
		}
	}

	public MinecraftServer d() {
		return f;
	}
}
