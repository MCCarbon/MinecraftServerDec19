package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
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
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.class_e;
import net.minecraft.server.class_ek;
import net.minecraft.server.class_en;
import net.minecraft.server.class_eo;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_eq;
import net.minecraft.server.class_er;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fg;
import net.minecraft.server.class_gi;
import net.minecraft.server.class_ll;
import net.minecraft.server.class_lp;
import net.minecraft.server.class_nq;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_ln {
	private static final Logger e = LogManager.getLogger();
	public static final class_nq a = new class_nq() {
		protected NioEventLoopGroup a() {
			return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Server IO #%d").setDaemon(true).build());
		}

		// $FF: synthetic method
		protected Object b() {
			return this.a();
		}
	};
	public static final class_nq b = new class_nq() {
		protected EpollEventLoopGroup a() {
			return new EpollEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Epoll Server IO #%d").setDaemon(true).build());
		}

		// $FF: synthetic method
		protected Object b() {
			return this.a();
		}
	};
	public static final class_nq c = new class_nq() {
		protected LocalEventLoopGroup a() {
			return new LocalEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Local Server IO #%d").setDaemon(true).build());
		}

		// $FF: synthetic method
		protected Object b() {
			return this.a();
		}
	};
	private final MinecraftServer f;
	public volatile boolean d;
	private final List g = Collections.synchronizedList(Lists.newArrayList());
	private final List h = Collections.synchronizedList(Lists.newArrayList());

	public class_ln(MinecraftServer var1) {
		this.f = var1;
		this.d = true;
	}

	public void a(InetAddress var1, int var2) throws IOException {
		List var3 = this.g;
		synchronized (this.g) {
			Class var4;
			class_nq var5;
			if (Epoll.isAvailable() && this.f.ai()) {
				var4 = EpollServerSocketChannel.class;
				var5 = b;
				e.info("Using epoll channel type");
			} else {
				var4 = NioServerSocketChannel.class;
				var5 = a;
				e.info("Using default channel type");
			}

			this.g.add(((ServerBootstrap) ((ServerBootstrap) (new ServerBootstrap()).channel(var4)).childHandler(new ChannelInitializer() {
				protected void initChannel(Channel var1) throws Exception {
					try {
						var1.config().setOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(true));
					} catch (ChannelException var3) {
						;
					}

					var1.pipeline().addLast((String) "timeout", (ChannelHandler) (new ReadTimeoutHandler(30))).addLast((String) "legacy_query", (ChannelHandler) (new class_ll(class_ln.this))).addLast((String) "splitter", (ChannelHandler) (new class_eq())).addLast((String) "decoder", (ChannelHandler) (new class_en(class_fg.a))).addLast((String) "prepender", (ChannelHandler) (new class_er())).addLast((String) "encoder", (ChannelHandler) (new class_eo(class_fg.b)));
					class_ek var2 = new class_ek(class_fg.a);
					class_ln.this.h.add(var2);
					var1.pipeline().addLast((String) "packet_handler", (ChannelHandler) var2);
					var2.a((class_ep) (new class_lp(class_ln.this.f, var2)));
				}
			}).group((EventLoopGroup) var5.c()).localAddress(var1, var2)).bind().syncUninterruptibly());
		}
	}

	public void b() {
		this.d = false;
		Iterator var1 = this.g.iterator();

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
		List var1 = this.h;
		synchronized (this.h) {
			Iterator var2 = this.h.iterator();

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
							final class_ek cvar3 = var3;
							if (var3.c()) {
								class_b var10 = class_b.a(var8, "Ticking memory connection");
								class_c var6 = var10.a("Ticking connection");
								var6.a("Connection", new Callable() {
									public String a() throws Exception {
										return cvar3.toString();
									}

									// $FF: synthetic method
									public Object call() throws Exception {
										return this.a();
									}
								});
								throw new class_e(var10);
							}

							e.warn((String) ("Failed to handle packet for " + var3.b()), (Throwable) var8);
							final class_fa var5 = new class_fa("Internal server error");
							var3.a(new class_gi(var5), new GenericFutureListener() {
								public void operationComplete(Future var1) throws Exception {
									cvar3.a((class_eu) var5);
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
		return this.f;
	}
}
