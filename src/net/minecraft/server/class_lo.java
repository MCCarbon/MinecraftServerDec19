package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.util.concurrent.Futures;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.EnumChatFormat;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_acb;
import net.minecraft.server.class_acc;
import net.minecraft.server.class_aed;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amj;
import net.minecraft.server.class_amx;
import net.minecraft.server.class_amz;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.Vec3D;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_e;
import net.minecraft.server.class_ea;
import net.minecraft.server.class_eb;
import net.minecraft.server.NetworkManager;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_f;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.Packet;
import net.minecraft.server.class_fh;
import net.minecraft.server.class_fi;
import net.minecraft.server.class_fv;
import net.minecraft.server.class_fy;
import net.minecraft.server.PacketPlayOutChat;
import net.minecraft.server.class_gb;
import net.minecraft.server.class_gi;
import net.minecraft.server.PacketPlayOutKeepAlive;
import net.minecraft.server.class_he;
import net.minecraft.server.class_hz;
import net.minecraft.server.PacketListenerPlayIn;
import net.minecraft.server.class_id;
import net.minecraft.server.PacketPlayInChat;
import net.minecraft.server.class_ig;
import net.minecraft.server.class_ih;
import net.minecraft.server.class_ii;
import net.minecraft.server.class_ij;
import net.minecraft.server.class_ik;
import net.minecraft.server.class_il;
import net.minecraft.server.class_im;
import net.minecraft.server.PacketPlayInUseEntity;
import net.minecraft.server.PacketPlayInKeepAlive;
import net.minecraft.server.PacketPlayInFlying;
import net.minecraft.server.class_iq;
import net.minecraft.server.PacketPlayInBlockDig;
import net.minecraft.server.class_is;
import net.minecraft.server.class_it;
import net.minecraft.server.class_iu;
import net.minecraft.server.class_iv;
import net.minecraft.server.class_iw;
import net.minecraft.server.class_ix;
import net.minecraft.server.class_iy;
import net.minecraft.server.class_iz;
import net.minecraft.server.class_ja;
import net.minecraft.server.PacketPlayInUseItem;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_m;
import net.minecraft.server.class_mc;
import net.minecraft.server.class_mf;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.class_no;
import net.minecraft.server.class_oj;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_px;
import net.minecraft.server.class_tz;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_vp;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xd;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yb;
import net.minecraft.server.class_yc;
import net.minecraft.server.class_ys;
import net.minecraft.server.class_yx;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_lo implements PacketListenerPlayIn, class_kn {
   private static final Logger c = LogManager.getLogger();
   public final NetworkManager a;
   private final MinecraftServer d;
   public class_lh b;
   private int e;
   private int f;
   private int g;
   private boolean h;
   private int i;
   private long j;
   private long k;
   private int l;
   private int m;
   private class_no n = new class_no();
   private double o;
   private double p;
   private double q;
   private boolean r = true;

   public class_lo(MinecraftServer var1, NetworkManager var2, class_lh var3) {
      this.d = var1;
      this.a = var2;
      var2.setPacketListener((PacketListener)this);
      this.b = var3;
      var3.a = this;
   }

   public void c() {
      this.h = false;
      ++this.e;
      this.d.c.a("keepAlive");
      if((long)this.e - this.k > 40L) {
         this.k = (long)this.e;
         this.j = this.d();
         this.i = (int)this.j;
         this.a((Packet)(new PacketPlayOutKeepAlive(this.i)));
      }

      this.d.c.b();
      if(this.l > 0) {
         --this.l;
      }

      if(this.m > 0) {
         --this.m;
      }

      if(this.b.D() > 0L && this.d.aA() > 0 && MinecraftServer.az() - this.b.D() > (long)(this.d.aA() * 1000 * 60)) {
         this.c("You have been idle for too long!");
      }

   }

   public NetworkManager a() {
      return this.a;
   }

   public void c(String var1) {
      final class_fa var2 = new class_fa(var1);
      this.a.sendPacket(new class_gi(var2), new GenericFutureListener() {
         public void operationComplete(Future var1) throws Exception {
            class_lo.this.a.a((IChatBaseComponent)var2);
         }
      }, new GenericFutureListener[0]);
      this.a.disableAutoRead();
      Futures.getUnchecked(this.d.a(new Runnable() {
         public void run() {
            class_lo.this.a.handleDisconnection();
         }
      }));
   }

   public void handle(class_it var1) {
      class_fh.a(var1, this, this.b.u());
      this.b.a(var1.a(), var1.b(), var1.c(), var1.d());
   }

   private boolean b(PacketPlayInFlying var1) {
      return !Doubles.isFinite(var1.getX()) || !Doubles.isFinite(var1.getY()) || !Doubles.isFinite(var1.getZ()) || !Floats.isFinite(var1.getPitch()) || !Floats.isFinite(var1.getYaw());
   }

   public void handle(PacketPlayInFlying var1) {
      class_fh.a(var1, this, this.b.u());
      if(this.b(var1)) {
         this.c("Invalid move packet received");
      } else {
         class_lg var2 = this.d.a(this.b.am);
         this.h = true;
         if(!this.b.i) {
            double var3 = this.b.s;
            double var5 = this.b.t;
            double var7 = this.b.u;
            double var9 = 0.0D;
            double var11 = var1.getX() - this.o;
            double var13 = var1.getY() - this.p;
            double var15 = var1.getZ() - this.q;
            if(var1.hasPos()) {
               var9 = var11 * var11 + var13 * var13 + var15 * var15;
               if(!this.r && var9 < 0.25D) {
                  this.r = true;
               }
            }

            if(this.r) {
               this.f = this.e;
               double var19;
               double var21;
               double var23;
               if(this.b.m != null) {
                  float var44 = this.b.y;
                  float var18 = this.b.z;
                  this.b.m.al();
                  var19 = this.b.s;
                  var21 = this.b.t;
                  var23 = this.b.u;
                  if(var1.hasLook()) {
                     var44 = var1.getYaw();
                     var18 = var1.getPitch();
                  }

                  this.b.C = var1.isOnGround();
                  this.b.l();
                  this.b.a(var19, var21, var23, var44, var18);
                  if(this.b.m != null) {
                     this.b.m.al();
                  }

                  this.d.ap().d(this.b);
                  if(this.b.m != null) {
                     if(var9 > 4.0D) {
                        class_pr var45 = this.b.m;
                        this.b.a.a((Packet)(new class_hz(var45)));
                        this.a(this.b.s, this.b.t, this.b.u, this.b.y, this.b.z);
                     }

                     this.b.m.ai = true;
                  }

                  if(this.r) {
                     this.o = this.b.s;
                     this.p = this.b.t;
                     this.q = this.b.u;
                  }

                  var2.g(this.b);
                  return;
               }

               if(this.b.bK()) {
                  this.b.l();
                  this.b.a(this.o, this.p, this.q, this.b.y, this.b.z);
                  var2.g(this.b);
                  return;
               }

               double var17 = this.b.t;
               this.o = this.b.s;
               this.p = this.b.t;
               this.q = this.b.u;
               var19 = this.b.s;
               var21 = this.b.t;
               var23 = this.b.u;
               float var25 = this.b.y;
               float var26 = this.b.z;
               if(var1.hasPos() && var1.getY() == -999.0D) {
                  var1.setHasPos(false);
               }

               if(var1.hasPos()) {
                  var19 = var1.getX();
                  var21 = var1.getY();
                  var23 = var1.getZ();
                  if(Math.abs(var1.getX()) > 3.0E7D || Math.abs(var1.getZ()) > 3.0E7D) {
                     this.c("Illegal position");
                     return;
                  }
               }

               if(var1.hasLook()) {
                  var25 = var1.getYaw();
                  var26 = var1.getPitch();
               }

               this.b.l();
               this.b.a(this.o, this.p, this.q, var25, var26);
               if(!this.r) {
                  return;
               }

               double var27 = var19 - this.b.s;
               double var29 = var21 - this.b.t;
               double var31 = var23 - this.b.u;
               double var33 = this.b.v * this.b.v + this.b.w * this.b.w + this.b.x * this.b.x;
               double var35 = var27 * var27 + var29 * var29 + var31 * var31;
               if(var35 - var33 > 100.0D && (!this.d.T() || !this.d.S().equals(this.b.e_()))) {
                  c.warn(this.b.e_() + " moved too quickly! " + var27 + "," + var29 + "," + var31 + " (" + var27 + ", " + var29 + ", " + var31 + ")");
                  this.a(this.o, this.p, this.q, this.b.y, this.b.z);
                  return;
               }

               float var37 = 0.0625F;
               boolean var38 = var2.a((class_pr)this.b, (class_awf)this.b.aT().d((double)var37, (double)var37, (double)var37)).isEmpty();
               if(this.b.C && !var1.isOnGround() && var29 > 0.0D) {
                  this.b.bG();
               }

               this.b.d(var27, var29, var31);
               this.b.C = var1.isOnGround();
               double var39 = var29;
               var27 = var19 - this.b.s;
               var29 = var21 - this.b.t;
               if(var29 > -0.5D || var29 < 0.5D) {
                  var29 = 0.0D;
               }

               var31 = var23 - this.b.u;
               var35 = var27 * var27 + var29 * var29 + var31 * var31;
               boolean var41 = false;
               if(var35 > 0.0625D && !this.b.bK() && !this.b.c.d()) {
                  var41 = true;
                  c.warn(this.b.e_() + " moved wrongly!");
               }

               this.b.a(var19, var21, var23, var25, var26);
               this.b.k(this.b.s - var3, this.b.t - var5, this.b.u - var7);
               if(!this.b.T) {
                  boolean var42 = var2.a((class_pr)this.b, (class_awf)this.b.aT().d((double)var37, (double)var37, (double)var37)).isEmpty();
                  if(var38 && (var41 || !var42) && !this.b.bK()) {
                     this.a(this.o, this.p, this.q, var25, var26);
                     return;
                  }
               }

               class_awf var43 = this.b.aT().b((double)var37, (double)var37, (double)var37).a(0.0D, -0.55D, 0.0D);
               if (!(this.d.ak() || this.b.bH.c || var2.c(var43) || this.b.a(class_pm.y))) {
                  if(var39 >= -0.03125D) {
                     ++this.g;
                     if(this.g > 80) {
                        c.warn(this.b.e_() + " was kicked for floating too long!");
                        this.c("Flying is not enabled on this server");
                        return;
                     }
                  }
               } else {
                  this.g = 0;
               }

               this.b.C = var1.isOnGround();
               this.d.ap().d(this.b);
               this.b.a(this.b.t - var17, var1.isOnGround());
            } else if(this.e - this.f > 20) {
               this.a(this.o, this.p, this.q, this.b.y, this.b.z);
            }

         }
      }
   }

   public void a(double var1, double var3, double var5, float var7, float var8) {
      this.a(var1, var3, var5, var7, var8, Collections.emptySet());
   }

   public void a(double var1, double var3, double var5, float var7, float var8, Set var9) {
      this.r = false;
      this.o = var1;
      this.p = var3;
      this.q = var5;
      if(var9.contains(class_fi.class_a_in_class_fi.a)) {
         this.o += this.b.s;
      }

      if(var9.contains(class_fi.class_a_in_class_fi.b)) {
         this.p += this.b.t;
      }

      if(var9.contains(class_fi.class_a_in_class_fi.c)) {
         this.q += this.b.u;
      }

      float var10 = var7;
      float var11 = var8;
      if(var9.contains(class_fi.class_a_in_class_fi.d)) {
         var10 = var7 + this.b.y;
      }

      if(var9.contains(class_fi.class_a_in_class_fi.e)) {
         var11 = var8 + this.b.z;
      }

      this.b.a(this.o, this.p, this.q, var10, var11);
      this.b.a.a((Packet)(new class_fi(var1, var3, var5, var7, var8, var9)));
   }

   public void handle(PacketPlayInBlockDig var1) {
      class_fh.a(var1, this, this.b.u());
      class_lg var2 = this.d.a(this.b.am);
      BlockPosition var3 = var1.getPosition();
      this.b.z();
      switch(class_lo.SyntheticClass_1.a[var1.getDigType().ordinal()]) {
      case 1:
         if(!this.b.v()) {
            class_aas var12 = this.b.b((EnumUsedHand)EnumUsedHand.OFF_HAND);
            this.b.a((EnumUsedHand)EnumUsedHand.OFF_HAND, (class_aas)this.b.b((EnumUsedHand)EnumUsedHand.MAIN_HAND));
            this.b.a((EnumUsedHand)EnumUsedHand.MAIN_HAND, (class_aas)var12);
         }

         return;
      case 2:
         if(!this.b.v()) {
            this.b.a(false);
         }

         return;
      case 3:
         if(!this.b.v()) {
            this.b.a(true);
         }

         return;
      case 4:
         this.b.bY();
         return;
      case 5:
      case 6:
      case 7:
         double var4 = this.b.s - ((double)var3.getX() + 0.5D);
         double var6 = this.b.t - ((double)var3.getY() + 0.5D) + 1.5D;
         double var8 = this.b.u - ((double)var3.getZ() + 0.5D);
         double var10 = var4 * var4 + var6 * var6 + var8 * var8;
         if(var10 > 36.0D) {
            return;
         } else if(var3.getY() >= this.d.an()) {
            return;
         } else {
            if(var1.getDigType() == PacketPlayInBlockDig.EnumPlayerDigType.START_DESTROY_BLOCK) {
               if(!this.d.a((World)var2, (BlockPosition)var3, (class_xa)this.b) && var2.ag().a(var3)) {
                  this.b.c.a(var3, var1.getFace());
               } else {
                  this.b.a.a((Packet)(new class_fv(var2, var3)));
               }
            } else {
               if(var1.getDigType() == PacketPlayInBlockDig.EnumPlayerDigType.STOP_DESTROY_BLOCK) {
                  this.b.c.a(var3);
               } else if(var1.getDigType() == PacketPlayInBlockDig.EnumPlayerDigType.ABORT_DESTROY_BLOCK) {
                  this.b.c.e();
               }

               if(var2.p(var3).getBlock().getMaterial() != Material.AIR) {
                  this.b.a.a((Packet)(new class_fv(var2, var3)));
               }
            }

            return;
         }
      default:
         throw new IllegalArgumentException("Invalid player action");
      }
   }

   public void handle(class_ja var1) {
      class_fh.a(var1, this, this.b.u());
      class_lg var2 = this.d.a(this.b.am);
      EnumUsedHand var3 = var1.c();
      class_aas var4 = this.b.b((EnumUsedHand)var3);
      BlockPosition var5 = var1.a();
      EnumDirection var6 = var1.b();
      this.b.z();
      if(var5.getY() >= this.d.an() - 1 && (var6 == EnumDirection.UP || var5.getY() >= this.d.an())) {
         class_fb var7 = new class_fb("build.tooHigh", new Object[]{Integer.valueOf(this.d.an())});
         var7.b().a(EnumChatFormat.RED);
         this.b.a.a((Packet)(new PacketPlayOutChat(var7)));
      } else if(this.r && this.b.e((double)var5.getX() + 0.5D, (double)var5.getY() + 0.5D, (double)var5.getZ() + 0.5D) < 64.0D && !this.d.a((World)var2, (BlockPosition)var5, (class_xa)this.b) && var2.ag().a(var5)) {
         this.b.c.a(this.b, var2, var4, var3, var5, var6, var1.d(), var1.e(), var1.f());
      }

      this.b.a.a((Packet)(new class_fv(var2, var5)));
      this.b.a.a((Packet)(new class_fv(var2, var5.shift(var6))));
      var4 = this.b.b((EnumUsedHand)var3);
      if(var4 != null && var4.b == 0) {
         this.b.a((EnumUsedHand)var3, (class_aas)null);
         var4 = null;
      }

   }

   public void handle(PacketPlayInUseItem var1) {
      class_fh.a(var1, this, this.b.u());
      class_lg var2 = this.d.a(this.b.am);
      EnumUsedHand var3 = var1.getActiveHand();
      class_aas var4 = this.b.b((EnumUsedHand)var3);
      this.b.z();
      if(var4 != null) {
         this.b.c.a(this.b, var2, var4, var3);
         var4 = this.b.b((EnumUsedHand)var3);
         if(var4 != null && var4.b == 0) {
            this.b.a((EnumUsedHand)var3, (class_aas)null);
            var4 = null;
         }

      }
   }

   public void handle(class_iz var1) {
      class_fh.a(var1, this, this.b.u());
      if(this.b.v()) {
         class_pr var2 = null;
         class_lg[] var3 = this.d.d;
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            class_lg var6 = var3[var5];
            if(var6 != null) {
               var2 = var1.a(var6);
               if(var2 != null) {
                  break;
               }
            }
         }

         if(var2 != null) {
            this.b.e(this.b);
            this.b.a((class_pr)null);
            if(var2.o != this.b.o) {
               class_lg var7 = this.b.u();
               class_lg var8 = (class_lg)var2.o;
               this.b.am = var2.am;
               this.a((Packet)(new class_he(this.b.am, var7.ab(), var7.Q().u(), this.b.c.b())));
               var7.f(this.b);
               this.b.I = false;
               this.b.b(var2.s, var2.t, var2.u, var2.y, var2.z);
               if(this.b.ai()) {
                  var7.a((class_pr)this.b, false);
                  var8.a((class_pr)this.b);
                  var8.a((class_pr)this.b, false);
               }

               this.b.a((World)var8);
               this.d.ap().a(this.b, var7);
               this.b.a(var2.s, var2.t, var2.u);
               this.b.c.a(var8);
               this.d.ap().b(this.b, var8);
               this.d.ap().f(this.b);
            } else {
               this.b.a(var2.s, var2.t, var2.u);
            }
         }
      }

   }

   public void handle(class_iu var1) {
   }

   public void disconnect(IChatBaseComponent var1) {
      c.info(this.b.e_() + " lost connection: " + var1);
      this.d.aH();
      class_fb var2 = new class_fb("multiplayer.player.left", new Object[]{this.b.f_()});
      var2.b().a(EnumChatFormat.YELLOW);
      this.d.ap().a((IChatBaseComponent)var2);
      this.b.q();
      this.d.ap().e(this.b);
      if(this.d.T() && this.b.e_().equals(this.d.S())) {
         c.info("Stopping singleplayer server as player logged out");
         this.d.w();
      }

   }

   public void a(final Packet var1) {
      if(var1 instanceof PacketPlayOutChat) {
         PacketPlayOutChat var2 = (PacketPlayOutChat)var1;
         class_xa.class_b_in_class_xa var3 = this.b.y();
         if(var3 == class_xa.class_b_in_class_xa.c) {
            return;
         }

         if(var3 == class_xa.class_b_in_class_xa.b && !var2.b()) {
            return;
         }
      }

      try {
         this.a.a(var1);
      } catch (Throwable var5) {
         class_b var6 = class_b.a(var5, "Sending packet");
         class_c var4 = var6.a("Packet being sent");
         var4.a("Packet class", new Callable() {
            public String a() throws Exception {
               return var1.getClass().getCanonicalName();
            }

            // $FF: synthetic method
            public Object call() throws Exception {
               return this.a();
            }
         });
         throw new class_e(var6);
      }
   }

   public void handle(class_iv var1) {
      class_fh.a(var1, this, this.b.u());
      if(var1.a() >= 0 && var1.a() < class_wz.i()) {
         this.b.bp.d = var1.a();
         this.b.z();
      } else {
         c.warn(this.b.e_() + " tried to set an invalid carried item");
      }
   }

   public void handle(PacketPlayInChat var1) {
      class_fh.a(var1, this, this.b.u());
      if(this.b.y() == class_xa.class_b_in_class_xa.c) {
         class_fb var4 = new class_fb("chat.cannotSend", new Object[0]);
         var4.b().a(EnumChatFormat.RED);
         this.a((Packet)(new PacketPlayOutChat(var4)));
      } else {
         this.b.z();
         String var2 = var1.getMessage();
         var2 = StringUtils.normalizeSpace(var2);

         for(int var3 = 0; var3 < var2.length(); ++var3) {
            if(!class_f.a(var2.charAt(var3))) {
               this.c("Illegal characters in chat");
               return;
            }
         }

         if(var2.startsWith("/")) {
            this.d(var2);
         } else {
            class_fb var5 = new class_fb("chat.type.text", new Object[]{this.b.f_(), var2});
            this.d.ap().a(var5, false);
         }

         this.l += 20;
         if(this.l > 200 && !this.d.ap().h(this.b.cf())) {
            this.c("disconnect.spam");
         }

      }
   }

   private void d(String var1) {
      this.d.P().a(this.b, var1);
   }

   public void handle(class_iy var1) {
      class_fh.a(var1, this, this.b.u());
      this.b.z();
      this.b.a((EnumUsedHand)var1.a());
   }

   public void handle(class_is var1) {
      class_fh.a(var1, this, this.b.u());
      this.b.z();
      switch(class_lo.SyntheticClass_1.b[var1.b().ordinal()]) {
      case 1:
         this.b.c(true);
         break;
      case 2:
         this.b.c(false);
         break;
      case 3:
         this.b.d(true);
         break;
      case 4:
         this.b.d(false);
         break;
      case 5:
         this.b.a(false, true, true);
         this.r = false;
         break;
      case 6:
         if(this.b.m instanceof class_tz) {
            ((class_tz)this.b.m).q(var1.c());
         }
         break;
      case 7:
         if(this.b.m instanceof class_tz) {
            ((class_tz)this.b.m).c(this.b);
         }
         break;
      default:
         throw new IllegalArgumentException("Invalid client command!");
      }

   }

   public void handle(PacketPlayInUseEntity var1) {
      class_fh.a(var1, this, this.b.u());
      class_lg var2 = this.d.a(this.b.am);
      class_pr var3 = var1.getEntity((World)var2);
      this.b.z();
      if(var3 != null) {
         boolean var4 = this.b.t(var3);
         double var5 = 36.0D;
         if(!var4) {
            var5 = 9.0D;
         }

         if(this.b.h(var3) < var5) {
            EnumUsedHand var7;
            class_aas var8;
            if(var1.getUseAction() == PacketPlayInUseEntity.EnumEntityUseAction.INTERACT) {
               var7 = var1.getUsedHand();
               var8 = this.b.b((EnumUsedHand)var7);
               this.b.a(var3, var8, var7);
            } else if(var1.getUseAction() == PacketPlayInUseEntity.EnumEntityUseAction.INTERACT_AT) {
               var7 = var1.getUsedHand();
               var8 = this.b.b((EnumUsedHand)var7);
               var3.a((class_xa)this.b, (Vec3D)var1.getInteractAt(), (class_aas)var8, (EnumUsedHand)var7);
            } else if(var1.getUseAction() == PacketPlayInUseEntity.EnumEntityUseAction.ATTACK) {
               if(var3 instanceof class_vm || var3 instanceof class_px || var3 instanceof class_xd || var3 == this.b) {
                  this.c("Attempting to attack an invalid entity");
                  this.d.f("Player " + this.b.e_() + " tried to attack an invalid entity");
                  return;
               }

               this.b.f(var3);
            }
         }
      }

   }

   public void handle(class_ig var1) {
      class_fh.a(var1, this, this.b.u());
      this.b.z();
      class_ig.class_a_in_class_ig var2 = var1.a();
      switch(class_lo.SyntheticClass_1.c[var2.ordinal()]) {
      case 1:
         if(this.b.i) {
            this.b = this.d.ap().a(this.b, 0, true);
         } else if(this.b.u().Q().t()) {
            if(this.d.T() && this.b.e_().equals(this.d.S())) {
               this.b.a.c("You have died. Game over, man, it\'s game over!");
               this.d.aa();
            } else {
               class_mf var3 = new class_mf(this.b.cf(), (Date)null, "(You just lost the game)", (Date)null, "Death in Hardcore");
               this.d.ap().h().a((class_mc)var3);
               this.b.a.c("You have died. Game over, man, it\'s game over!");
            }
         } else {
            if(this.b.bo() > 0.0F) {
               return;
            }

            this.b = this.d.ap().a(this.b, 0, false);
         }
         break;
      case 2:
         this.b.A().a(this.b);
         break;
      case 3:
         this.b.b((class_my)class_mt.f);
      }

   }

   public void handle(class_il var1) {
      class_fh.a(var1, this, this.b.u());
      this.b.p();
   }

   public void handle(class_ik var1) {
      class_fh.a(var1, this, this.b.u());
      this.b.z();
      if(this.b.br.d == var1.a() && this.b.br.c(this.b)) {
         if(this.b.v()) {
            ArrayList var2 = Lists.newArrayList();

            for(int var3 = 0; var3 < this.b.br.c.size(); ++var3) {
               var2.add(((class_yx)this.b.br.c.get(var3)).d());
            }

            this.b.a((class_xz)this.b.br, (List)var2);
         } else {
            class_aas var5 = this.b.br.a(var1.b(), var1.c(), var1.f(), this.b);
            if(class_aas.b(var1.e(), var5)) {
               this.b.a.a((Packet)(new class_gb(var1.a(), var1.d(), true)));
               this.b.g = true;
               this.b.br.b();
               this.b.o();
               this.b.g = false;
            } else {
               this.n.a(this.b.br.d, Short.valueOf(var1.d()));
               this.b.a.a((Packet)(new class_gb(var1.a(), var1.d(), false)));
               this.b.br.a(this.b, false);
               ArrayList var6 = Lists.newArrayList();

               for(int var4 = 0; var4 < this.b.br.c.size(); ++var4) {
                  var6.add(((class_yx)this.b.br.c.get(var4)).d());
               }

               this.b.a((class_xz)this.b.br, (List)var6);
            }
         }
      }

   }

   public void handle(class_ij var1) {
      class_fh.a(var1, this, this.b.u());
      this.b.z();
      if(this.b.br.d == var1.a() && this.b.br.c(this.b) && !this.b.v()) {
         this.b.br.a((class_xa)this.b, var1.b());
         this.b.br.b();
      }

   }

   public void handle(class_iw var1) {
      class_fh.a(var1, this, this.b.u());
      if(this.b.c.d()) {
         boolean var2 = var1.a() < 0;
         class_aas var3 = var1.b();
         if(var3 != null && var3.n() && var3.o().b("BlockEntityTag", 10)) {
            class_dn var4 = var3.o().n("BlockEntityTag");
            if(var4.d("x") && var4.d("y") && var4.d("z")) {
               BlockPosition var5 = new BlockPosition(var4.g("x"), var4.g("y"), var4.g("z"));
               class_amg var6 = this.b.o.s(var5);
               if(var6 != null) {
                  class_dn var7 = new class_dn();
                  var6.b(var7);
                  var7.p("x");
                  var7.p("y");
                  var7.p("z");
                  var3.a((String)"BlockEntityTag", (class_eb)var7);
               }
            }
         }

         boolean var8 = var1.a() >= 1 && var1.a() <= 45;
         boolean var9 = var3 == null || var3.b() != null;
         boolean var10 = var3 == null || var3.i() >= 0 && var3.b <= 64 && var3.b > 0;
         if(var8 && var9 && var10) {
            if(var3 == null) {
               this.b.bq.a(var1.a(), (class_aas)null);
            } else {
               this.b.bq.a(var1.a(), var3);
            }

            this.b.bq.a(this.b, true);
         } else if(var2 && var9 && var10 && this.m < 200) {
            this.m += 20;
            class_vm var11 = this.b.a((class_aas)var3, true);
            if(var11 != null) {
               var11.j();
            }
         }
      }

   }

   public void handle(class_ii var1) {
      class_fh.a(var1, this, this.b.u());
      Short var2 = (Short)this.n.a(this.b.br.d);
      if(var2 != null && var1.b() == var2.shortValue() && this.b.br.d == var1.a() && !this.b.br.c(this.b) && !this.b.v()) {
         this.b.br.a(this.b, true);
      }

   }

   public void handle(class_ix var1) {
      class_fh.a(var1, this, this.b.u());
      this.b.z();
      class_lg var2 = this.d.a(this.b.am);
      BlockPosition var3 = var1.a();
      if(var2.e(var3)) {
         class_amg var4 = var2.s(var3);
         if(!(var4 instanceof class_amx)) {
            return;
         }

         class_amx var5 = (class_amx)var4;
         if(!var5.b() || var5.c() != this.b) {
            this.d.f("Player " + this.b.e_() + " just tried to change non-editable sign");
            return;
         }

         IChatBaseComponent[] var6 = var1.b();

         for(int var7 = 0; var7 < var6.length; ++var7) {
            var5.a[var7] = new class_fa(EnumChatFormat.stripFormatting(var6[var7].c()));
         }

         var5.p_();
         var2.h(var3);
      }

   }

   public void handle(PacketPlayInKeepAlive var1) {
      if(var1.getKeepAliveId() == this.i) {
         int var2 = (int)(this.d() - this.j);
         this.b.h = (this.b.h * 3 + var2) / 4;
      }

   }

   private long d() {
      return System.nanoTime() / 1000000L;
   }

   public void handle(class_iq var1) {
      class_fh.a(var1, this, this.b.u());
      this.b.bH.b = var1.b() && this.b.bH.c;
   }

   public void handle(class_id var1) {
      class_fh.a(var1, this, this.b.u());
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = this.d.a((class_m)this.b, (String)var1.a(), (BlockPosition)var1.b()).iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         var2.add(var4);
      }

      this.b.a.a((Packet)(new class_fy((String[])var2.toArray(new String[var2.size()]))));
   }

   public void handle(class_ih var1) {
      class_fh.a(var1, this, this.b.u());
      this.b.a(var1);
   }

   public void handle(class_im var1) {
      class_fh.a(var1, this, this.b.u());
      class_aas var67;
      class_aas var72;
      PacketDataSerializer var61;
      if("MC|BEdit".equals(var1.a())) {
         var61 = new PacketDataSerializer(Unpooled.wrappedBuffer((ByteBuf)var1.b()));

         try {
            var67 = var61.i();
            if(var67 != null) {
               if(!class_acb.b(var67.o())) {
                  throw new IOException("Invalid book tag!");
               }

               var72 = this.b.bA();
               if(var72 == null) {
                  return;
               }

               if(var67.b() == Items.bP && var67.b() == var72.b()) {
                  var72.a((String)"pages", (class_eb)var67.o().c("pages", 8));
               }

               return;
            }
         } catch (Exception var57) {
            c.error((String)"Couldn\'t handle book info", (Throwable)var57);
            return;
         } finally {
            var61.release();
         }

         return;
      } else if("MC|BSign".equals(var1.a())) {
         var61 = new PacketDataSerializer(Unpooled.wrappedBuffer((ByteBuf)var1.b()));

         try {
            var67 = var61.i();
            if(var67 == null) {
               return;
            }

            if(!class_acc.b(var67.o())) {
               throw new IOException("Invalid book tag!");
            }

            var72 = this.b.bA();
            if(var72 != null) {
               if(var67.b() == Items.bQ && var72.b() == Items.bP) {
                  var72.a((String)"author", (class_eb)(new class_ea(this.b.e_())));
                  var72.a((String)"title", (class_eb)(new class_ea(var67.o().k("title"))));
                  var72.a((String)"pages", (class_eb)var67.o().c("pages", 8));
                  var72.a(Items.bQ);
               }

               return;
            }
         } catch (Exception var59) {
            c.error((String)"Couldn\'t sign book", (Throwable)var59);
            return;
         } finally {
            var61.release();
         }

         return;
      } else if("MC|TrSel".equals(var1.a())) {
         try {
            int var2 = var1.b().readInt();
            class_xz var3 = this.b.br;
            if(var3 instanceof class_ys) {
               ((class_ys)var3).d(var2);
            }
         } catch (Exception var56) {
            c.error((String)"Couldn\'t select trade", (Throwable)var56);
         }
      } else if("MC|AdvCdm".equals(var1.a())) {
         if(!this.d.al()) {
            this.b.a((IChatBaseComponent)(new class_fb("advMode.notEnabled", new Object[0])));
         } else if(this.b.a(2, "") && this.b.bH.d) {
            var61 = var1.b();

            try {
               byte var63 = var61.readByte();
               class_aed var4 = null;
               if(var63 == 0) {
                  class_amg var5 = this.b.o.s(new BlockPosition(var61.readInt(), var61.readInt(), var61.readInt()));
                  if(var5 instanceof class_amj) {
                     var4 = ((class_amj)var5).b();
                  }
               } else if(var63 == 1) {
                  class_pr var69 = this.b.o.getEntityById(var61.readInt());
                  if(var69 instanceof class_vp) {
                     var4 = ((class_vp)var69).j();
                  }
               }

               String var71 = var61.readString(var61.readableBytes());
               boolean var6 = var61.readBoolean();
               if(var4 != null) {
                  var4.a(var71);
                  var4.a(var6);
                  if(!var6) {
                     var4.b((IChatBaseComponent)null);
                  }

                  var4.h();
                  this.b.a((IChatBaseComponent)(new class_fb("advMode.setCommand.success", new Object[]{var71})));
               }
            } catch (Exception var54) {
               c.error((String)"Couldn\'t set command block", (Throwable)var54);
            } finally {
               var61.release();
            }
         } else {
            this.b.a((IChatBaseComponent)(new class_fb("advMode.notAllowed", new Object[0])));
         }
      } else if("MC|Beacon".equals(var1.a())) {
         if(this.b.br instanceof class_yc) {
            try {
               var61 = var1.b();
               int var64 = var61.readInt();
               int var68 = var61.readInt();
               class_yc var73 = (class_yc)this.b.br;
               class_yx var74 = var73.a(0);
               if(var74.e()) {
                  var74.a(1);
                  class_oj var7 = var73.e();
                  var7.b(1, var64);
                  var7.b(2, var68);
                  var7.p_();
               }
            } catch (Exception var53) {
               c.error((String)"Couldn\'t set beacon", (Throwable)var53);
            }
         }
      } else if("MC|ItemName".equals(var1.a())) {
         if(this.b.br instanceof class_yb) {
            class_yb var62 = (class_yb)this.b.br;
            if(var1.b() != null && var1.b().readableBytes() >= 1) {
               String var65 = class_f.a(var1.b().readString(32767));
               if(var65.length() <= 30) {
                  var62.a(var65);
               }
            } else {
               var62.a("");
            }
         }
      } else if("MC|Struct".equals(var1.a())) {
         var61 = var1.b();

         try {
            if(this.b.a(4, "") && this.b.bH.d) {
               BlockPosition var66 = new BlockPosition(var61.readInt(), var61.readInt(), var61.readInt());
               class_amg var70 = this.b.o.s(var66);
               if(var70 instanceof class_amz) {
                  class_amz var75 = (class_amz)var70;
                  byte var76 = var61.readByte();
                  String var77 = var61.readString(32);
                  var75.a(class_amz.class_a_in_class_amz.valueOf(var77));
                  var75.a(var61.readString(64));
                  var75.b(new BlockPosition(var61.readInt(), var61.readInt(), var61.readInt()));
                  var75.c(new BlockPosition(var61.readInt(), var61.readInt(), var61.readInt()));
                  String var8 = var61.readString(32);
                  var75.a(Block.class_a_in_class_agj.valueOf(var8));
                  String var9 = var61.readString(32);
                  var75.a(Block.class_c_in_class_agj.valueOf(var9));
                  var75.b(var61.readString(128));
                  var75.a(var61.readBoolean());
                  if(var76 == 2) {
                     if(var75.m()) {
                        this.b.b((IChatBaseComponent)(new class_fa("Structure saved")));
                     } else {
                        this.b.b((IChatBaseComponent)(new class_fa("Structure NOT saved")));
                     }
                  } else if(var76 == 3) {
                     if(var75.n()) {
                        this.b.b((IChatBaseComponent)(new class_fa("Structure loaded")));
                     } else {
                        this.b.b((IChatBaseComponent)(new class_fa("Structure prepared")));
                     }
                  } else if(var76 == 4 && var75.l()) {
                     this.b.b((IChatBaseComponent)(new class_fa("Size detected")));
                  }

                  var75.p_();
                  this.b.o.h(var66);
               }
            }
         } catch (Exception var51) {
            c.error((String)"Couldn\'t set structure block", (Throwable)var51);
         } finally {
            var61.release();
         }
      }

   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c = new int[class_ig.class_a_in_class_ig.values().length];

      static {
         try {
            c[class_ig.class_a_in_class_ig.a.ordinal()] = 1;
         } catch (NoSuchFieldError var17) {
            ;
         }

         try {
            c[class_ig.class_a_in_class_ig.b.ordinal()] = 2;
         } catch (NoSuchFieldError var16) {
            ;
         }

         try {
            c[class_ig.class_a_in_class_ig.c.ordinal()] = 3;
         } catch (NoSuchFieldError var15) {
            ;
         }

         b = new int[class_is.class_a_in_class_is.values().length];

         try {
            b[class_is.class_a_in_class_is.a.ordinal()] = 1;
         } catch (NoSuchFieldError var14) {
            ;
         }

         try {
            b[class_is.class_a_in_class_is.b.ordinal()] = 2;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            b[class_is.class_a_in_class_is.d.ordinal()] = 3;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            b[class_is.class_a_in_class_is.e.ordinal()] = 4;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            b[class_is.class_a_in_class_is.c.ordinal()] = 5;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            b[class_is.class_a_in_class_is.f.ordinal()] = 6;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            b[class_is.class_a_in_class_is.g.ordinal()] = 7;
         } catch (NoSuchFieldError var8) {
            ;
         }

         a = new int[PacketPlayInBlockDig.EnumPlayerDigType.values().length];

         try {
            a[PacketPlayInBlockDig.EnumPlayerDigType.SWAP_HELD_ITEMS.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            a[PacketPlayInBlockDig.EnumPlayerDigType.DROP_ITEM.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[PacketPlayInBlockDig.EnumPlayerDigType.DROP_ALL_ITEMS.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[PacketPlayInBlockDig.EnumPlayerDigType.RELEASE_USE_ITEM.ordinal()] = 4;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[PacketPlayInBlockDig.EnumPlayerDigType.START_DESTROY_BLOCK.ordinal()] = 5;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[PacketPlayInBlockDig.EnumPlayerDigType.ABORT_DESTROY_BLOCK.ordinal()] = 6;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[PacketPlayInBlockDig.EnumPlayerDigType.STOP_DESTROY_BLOCK.ordinal()] = 7;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
