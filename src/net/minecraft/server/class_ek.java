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
import net.minecraft.server.class_eg;
import net.minecraft.server.class_eh;
import net.minecraft.server.class_ei;
import net.minecraft.server.class_ej;
import net.minecraft.server.class_el;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fg;
import net.minecraft.server.class_kj;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_ni;
import net.minecraft.server.class_nq;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class class_ek extends SimpleChannelInboundHandler {
   private static final Logger g = LogManager.getLogger();
   public static final Marker a = MarkerManager.getMarker("NETWORK");
   public static final Marker b;
   public static final AttributeKey c;
   public static final class_nq d;
   public static final class_nq e;
   public static final class_nq f;
   private final class_fg h;
   private final Queue i = Queues.newConcurrentLinkedQueue();
   private final ReentrantReadWriteLock j = new ReentrantReadWriteLock();
   private Channel k;
   private SocketAddress l;
   private class_ep m;
   private class_eu n;
   private boolean o;
   private boolean p;

   public class_ek(class_fg var1) {
      this.h = var1;
   }

   public void channelActive(ChannelHandlerContext var1) throws Exception {
      super.channelActive(var1);
      this.k = var1.channel();
      this.l = this.k.remoteAddress();

      try {
         this.a(class_el.a);
      } catch (Throwable var3) {
         g.fatal((Object)var3);
      }

   }

   public void a(class_el var1) {
      this.k.attr(c).set(var1);
      this.k.config().setAutoRead(true);
      g.debug("Enabled auto read");
   }

   public void channelInactive(ChannelHandlerContext var1) throws Exception {
      this.a((class_eu)(new class_fb("disconnect.endOfStream", new Object[0])));
   }

   public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception {
      class_fb var3;
      if(var2 instanceof TimeoutException) {
         var3 = new class_fb("disconnect.timeout", new Object[0]);
      } else {
         var3 = new class_fb("disconnect.genericReason", new Object[]{"Internal Exception: " + var2});
      }

      this.a((class_eu)var3);
   }

   protected void a(ChannelHandlerContext var1, class_ff var2) throws Exception {
      if(this.k.isOpen()) {
         try {
            var2.a(this.m);
         } catch (class_kj var4) {
            ;
         }
      }

   }

   public void a(class_ep var1) {
      Validate.notNull(var1, "packetListener", new Object[0]);
      g.debug("Set listener of {} to {}", new Object[]{this, var1});
      this.m = var1;
   }

   public void a(class_ff var1) {
      if(this.g()) {
         this.m();
         this.a((class_ff)var1, (GenericFutureListener[])null);
      } else {
         this.j.writeLock().lock();

         try {
            this.i.add(new class_ek.class_a_in_class_ek(var1, (GenericFutureListener[])null));
         } finally {
            this.j.writeLock().unlock();
         }
      }

   }

   public void a(class_ff var1, GenericFutureListener var2, GenericFutureListener... var3) {
      if(this.g()) {
         this.m();
         this.a(var1, (GenericFutureListener[])ArrayUtils.add(var3, 0, var2));
      } else {
         this.j.writeLock().lock();

         try {
            this.i.add(new class_ek.class_a_in_class_ek(var1, (GenericFutureListener[])ArrayUtils.add(var3, 0, var2)));
         } finally {
            this.j.writeLock().unlock();
         }
      }

   }

   private void a(final class_ff var1, final GenericFutureListener[] var2) {
      final class_el var3 = class_el.a(var1);
      final class_el var4 = (class_el)this.k.attr(c).get();
      if(var4 != var3) {
         g.debug("Disabled auto read");
         this.k.config().setAutoRead(false);
      }

      if(this.k.eventLoop().inEventLoop()) {
         if(var3 != var4) {
            this.a(var3);
         }

         ChannelFuture var5 = this.k.writeAndFlush(var1);
         if(var2 != null) {
            var5.addListeners(var2);
         }

         var5.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
      } else {
         this.k.eventLoop().execute(new Runnable() {
            public void run() {
               if(var3 != var4) {
                  class_ek.this.a(var3);
               }

               ChannelFuture var1x = class_ek.this.k.writeAndFlush(var1);
               if(var2 != null) {
                  var1x.addListeners(var2);
               }

               var1x.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
            }
         });
      }

   }

   private void m() {
      if(this.k != null && this.k.isOpen()) {
         this.j.readLock().lock();

         try {
            while(!this.i.isEmpty()) {
               class_ek.class_a_in_class_ek var1 = (class_ek.class_a_in_class_ek)this.i.poll();
               this.a(var1.a, var1.b);
            }
         } finally {
            this.j.readLock().unlock();
         }

      }
   }

   public void a() {
      this.m();
      if(this.m instanceof class_kn) {
         ((class_kn)this.m).c();
      }

      this.k.flush();
   }

   public SocketAddress b() {
      return this.l;
   }

   public void a(class_eu var1) {
      if(this.k.isOpen()) {
         this.k.close().awaitUninterruptibly();
         this.n = var1;
      }

   }

   public boolean c() {
      return this.k instanceof LocalChannel || this.k instanceof LocalServerChannel;
   }

   public void a(SecretKey var1) {
      this.o = true;
      this.k.pipeline().addBefore("splitter", "decrypt", new class_eg(class_ni.a(2, var1)));
      this.k.pipeline().addBefore("prepender", "encrypt", new class_eh(class_ni.a(1, var1)));
   }

   public boolean g() {
      return this.k != null && this.k.isOpen();
   }

   public boolean h() {
      return this.k == null;
   }

   public class_ep i() {
      return this.m;
   }

   public class_eu j() {
      return this.n;
   }

   public void k() {
      this.k.config().setAutoRead(false);
   }

   public void a(int var1) {
      if(var1 >= 0) {
         if(this.k.pipeline().get("decompress") instanceof class_ei) {
            ((class_ei)this.k.pipeline().get("decompress")).a(var1);
         } else {
            this.k.pipeline().addBefore("decoder", "decompress", new class_ei(var1));
         }

         if(this.k.pipeline().get("compress") instanceof class_ej) {
            ((class_ej)this.k.pipeline().get("decompress")).a(var1);
         } else {
            this.k.pipeline().addBefore("encoder", "compress", new class_ej(var1));
         }
      } else {
         if(this.k.pipeline().get("decompress") instanceof class_ei) {
            this.k.pipeline().remove("decompress");
         }

         if(this.k.pipeline().get("compress") instanceof class_ej) {
            this.k.pipeline().remove("compress");
         }
      }

   }

   public void l() {
      if(this.k != null && !this.k.isOpen()) {
         if(!this.p) {
            this.p = true;
            if(this.j() != null) {
               this.i().a(this.j());
            } else if(this.i() != null) {
               this.i().a(new class_fa("Disconnected"));
            }
         } else {
            g.warn("handleDisconnection() called twice");
         }

      }
   }

   // $FF: synthetic method
   protected void channelRead0(ChannelHandlerContext var1, Object var2) throws Exception {
      this.a(var1, (class_ff)var2);
   }

   static {
      b = MarkerManager.getMarker("NETWORK_PACKETS", a);
      c = AttributeKey.valueOf("protocol");
      d = new class_nq() {
         protected NioEventLoopGroup a() {
            return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Client IO #%d").setDaemon(true).build());
         }

         // $FF: synthetic method
         protected Object b() {
            return this.a();
         }
      };
      e = new class_nq() {
         protected EpollEventLoopGroup a() {
            return new EpollEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Epoll Client IO #%d").setDaemon(true).build());
         }

         // $FF: synthetic method
         protected Object b() {
            return this.a();
         }
      };
      f = new class_nq() {
         protected LocalEventLoopGroup a() {
            return new LocalEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Local Client IO #%d").setDaemon(true).build());
         }

         // $FF: synthetic method
         protected Object b() {
            return this.a();
         }
      };
   }

   static class class_a_in_class_ek {
      private final class_ff a;
      private final GenericFutureListener[] b;

      public class_a_in_class_ek(class_ff var1, GenericFutureListener... var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
