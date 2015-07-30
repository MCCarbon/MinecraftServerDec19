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
import io.netty.channel.socket.ServerSocketChannel;
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

public class ServerConnection {

	private static final Logger logger = LogManager.getLogger();
	public static final LazyInitVar<NioEventLoopGroup> NIO_EVENT_LOOP_GROUP = new LazyInitVar<NioEventLoopGroup>() {
		@Override
		protected NioEventLoopGroup init() {
			return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Server IO #%d").setDaemon(true).build());
		}
	};
	public static final LazyInitVar<EpollEventLoopGroup> EPOLL_EVENT_LOOP_GROUP = new LazyInitVar<EpollEventLoopGroup>() {
		@Override
		protected EpollEventLoopGroup init() {
			return new EpollEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Epoll Server IO #%d").setDaemon(true).build());
		}
	};
	public static final LazyInitVar<LocalEventLoopGroup> LOCAL_EVENT_LOOP_GROUP = new LazyInitVar<LocalEventLoopGroup>() {
		@Override
		protected LocalEventLoopGroup init() {
			return new LocalEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Local Server IO #%d").setDaemon(true).build());
		}
	};

	public volatile boolean isRunning;
	private final MinecraftServer minecraftserver;
	private final List<ChannelFuture> channels = Collections.synchronizedList(Lists.<ChannelFuture> newArrayList());
	private final List<NetworkManager> networkManagers = Collections.synchronizedList(Lists.<NetworkManager> newArrayList());

	public ServerConnection(MinecraftServer server) {
		minecraftserver = server;
		isRunning = true;
	}

	public void initNetwork(InetAddress address, int port) throws IOException {
		synchronized (channels) {
			Class<? extends ServerSocketChannel> socketchannel;
			LazyInitVar<? extends EventLoopGroup> loopgroup;
			if (Epoll.isAvailable() && minecraftserver.ai()) {
				socketchannel = EpollServerSocketChannel.class;
				loopgroup = EPOLL_EVENT_LOOP_GROUP;
				logger.info("Using epoll channel type");
			} else {
				socketchannel = NioServerSocketChannel.class;
				loopgroup = NIO_EVENT_LOOP_GROUP;
				logger.info("Using default channel type");
			}

			channels.add((new ServerBootstrap().channel(socketchannel).childHandler(new ChannelInitializer<Channel>() {
				@Override
				protected void initChannel(Channel channel) throws Exception {
					try {
						channel.config().setOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(true));
					} catch (ChannelException e) {
					}

					channel.pipeline().addLast("timeout", (new ReadTimeoutHandler(30))).addLast("legacy_query", (new class_ll(ServerConnection.this))).addLast("splitter", (new class_eq())).addLast("decoder", (new class_en(EnumProtocolDirection.SERVERBOUND))).addLast("prepender", (new class_er())).addLast("encoder", (new class_eo(EnumProtocolDirection.CLIENTBOUND)));
					NetworkManager networkManager = new NetworkManager(EnumProtocolDirection.SERVERBOUND);
					networkManagers.add(networkManager);
					channel.pipeline().addLast("packet_handler", networkManager);
					networkManager.setPacketListener((new class_lp(minecraftserver, networkManager)));
				}
			}).group(loopgroup.get()).localAddress(address, port)).bind().syncUninterruptibly());
		}
	}

	public void shutdownNetwork() {
		isRunning = false;
		for (ChannelFuture future : channels) {
			try {
				future.channel().close().sync();
			} catch (InterruptedException var4) {
				logger.error("Interrupted whilst closing channel");
			}
		}
	}

	public void handleNetwork() {
		synchronized (networkManagers) {
			Iterator<NetworkManager> itreator = networkManagers.iterator();

			while (true) {
				NetworkManager networkManager;
				do {
					if (!itreator.hasNext()) {
						return;
					}
					networkManager = itreator.next();
				} while (networkManager.isPreparing());

				if (!networkManager.isActive()) {
					itreator.remove();
					networkManager.handleDisconnection();
				} else {
					try {
						networkManager.tick();
					} catch (Exception e) {
						final NetworkManager fNetworkManager = networkManager;
						if (networkManager.isLocal()) {
							class_b var10 = class_b.a(e, "Ticking memory connection");
							class_c var6 = var10.a("Ticking connection");
							var6.a("Connection", new Callable<String>() {
								public String call() throws Exception {
									return fNetworkManager.toString();
								}
							});
							throw new class_e(var10);
						}
						logger.warn("Failed to handle packet for " + networkManager.getAddress(), e);
						final class_fa var5 = new class_fa("Internal server error");
						networkManager.sendPacket(new class_gi(var5), new GenericFutureListener<Future<?>>() {
							@Override
							public void operationComplete(Future<?> var1) throws Exception {
								fNetworkManager.a(var5);
							}
						}, new GenericFutureListener[0]);
						networkManager.disableAutoRead();
					}
				}
			}
		}
	}

	public MinecraftServer getMinecraftServer() {
		return minecraftserver;
	}

}
