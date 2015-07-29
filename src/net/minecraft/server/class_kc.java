package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.io.PrintStream;
import java.util.Random;
import java.util.UUID;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_abt;
import net.minecraft.server.class_acd;
import net.minecraft.server.class_ace;
import net.minecraft.server.class_adi;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahk;
import net.minecraft.server.class_aib;
import net.minecraft.server.class_ajd;
import net.minecraft.server.class_akd;
import net.minecraft.server.class_akv;
import net.minecraft.server.class_alo;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amm;
import net.minecraft.server.class_amy;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_ck;
import net.minecraft.server.class_cn;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cr;
import net.minecraft.server.class_cz;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dy;
import net.minecraft.server.class_kb;
import net.minecraft.server.class_kh;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_nz;
import net.minecraft.server.class_pk;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_vk;
import net.minecraft.server.class_vw;
import net.minecraft.server.class_xd;
import net.minecraft.server.class_xg;
import net.minecraft.server.class_xi;
import net.minecraft.server.class_xl;
import net.minecraft.server.class_xm;
import net.minecraft.server.class_xn;
import net.minecraft.server.class_xp;
import net.minecraft.server.class_xr;
import net.minecraft.server.class_xs;
import net.minecraft.server.class_xt;
import net.minecraft.server.class_zn;
import net.minecraft.server.class_zy;
import net.minecraft.server.class_zz;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_kc {
   private static final PrintStream a;
   private static boolean b;
   private static final Logger c;

   public static boolean a() {
      return b;
   }

   static void b() {
      class_ahk.N.a(class_aau.g, new class_kb() {
         protected class_xi a(class_aen var1, class_cz var2, class_aas var3) {
            class_xd var4 = new class_xd(var1, var2.a(), var2.b(), var2.c());
            var4.c = 1;
            return var4;
         }
      });
      class_ahk.N.a(class_aau.i, new class_kb() {
         protected class_xi a(class_aen var1, class_cz var2, class_aas var3) {
            class_xt var4 = new class_xt(var1, var2.a(), var2.b(), var2.c(), var3);
            var4.c = 1;
            return var4;
         }
      });
      class_ahk.N.a(class_aau.h, new class_kb() {
         protected class_xi a(class_aen var1, class_cz var2, class_aas var3) {
            class_xn var4 = new class_xn(var1, var2.a(), var2.b(), var2.c());
            var4.c = 1;
            return var4;
         }
      });
      class_ahk.N.a(class_aau.aR, new class_kb() {
         protected class_xi a(class_aen var1, class_cz var2, class_aas var3) {
            return new class_xp(var1, var2.a(), var2.b(), var2.c());
         }
      });
      class_ahk.N.a(class_aau.aF, new class_kb() {
         protected class_xi a(class_aen var1, class_cz var2, class_aas var3) {
            return new class_xm(var1, var2.a(), var2.b(), var2.c());
         }
      });
      class_ahk.N.a(class_aau.bN, new class_kb() {
         protected class_xi a(class_aen var1, class_cz var2, class_aas var3) {
            return new class_xr(var1, var2.a(), var2.b(), var2.c());
         }

         protected float a() {
            return super.a() * 0.5F;
         }

         protected float b() {
            return super.b() * 1.25F;
         }
      });
      class_ahk.N.a(class_aau.bC, new class_cr() {
         private final class_cn b = new class_cn();

         public class_aas a(class_ck var1, final class_aas var2) {
            return (new class_kb() {
               protected class_xi a(class_aen var1, class_cz var2x, class_aas var3) {
                  return new class_xs(var1, var2x.a(), var2x.b(), var2x.c(), var2.k());
               }

               protected float a() {
                  return super.a() * 0.5F;
               }

               protected float b() {
                  return super.b() * 1.25F;
               }
            }).a(var1, var2);
         }
      });
      class_ahk.N.a(class_aau.bM, new class_cn() {
         public class_aas b(class_ck var1, class_aas var2) {
            class_cq var3 = class_ahk.b(var1.f());
            double var4 = var1.a() + (double)var3.g();
            double var6 = (double)((float)var1.d().o() + 0.2F);
            double var8 = var1.c() + (double)var3.i();
            class_pr var10 = class_abt.a(var1.i(), var2.i(), var4, var6, var8);
            if(var10 instanceof class_qa && var2.s()) {
               ((class_qb)var10).a((String)var2.q());
            }

            var2.a(1);
            return var2;
         }
      });
      class_ahk.N.a(class_aau.ce, new class_cn() {
         public class_aas b(class_ck var1, class_aas var2) {
            class_cq var3 = class_ahk.b(var1.f());
            double var4 = var1.a() + (double)var3.g();
            double var6 = (double)((float)var1.d().o() + 0.2F);
            double var8 = var1.c() + (double)var3.i();
            class_xg var10 = new class_xg(var1.i(), var4, var6, var8, var2);
            var1.i().a((class_pr)var10);
            var2.a(1);
            return var2;
         }

         protected void a(class_ck var1) {
            var1.i().b(1002, var1.d(), 0);
         }
      });
      class_ahk.N.a(class_aau.bO, new class_cn() {
         public class_aas b(class_ck var1, class_aas var2) {
            class_cq var3 = class_ahk.b(var1.f());
            class_cz var4 = class_ahk.a(var1);
            double var5 = var4.a() + (double)((float)var3.g() * 0.3F);
            double var7 = var4.b() + (double)((float)var3.h() * 0.3F);
            double var9 = var4.c() + (double)((float)var3.i() * 0.3F);
            class_aen var11 = var1.i();
            Random var12 = var11.s;
            double var13 = var12.nextGaussian() * 0.05D + (double)var3.g();
            double var15 = var12.nextGaussian() * 0.05D + (double)var3.h();
            double var17 = var12.nextGaussian() * 0.05D + (double)var3.i();
            var11.a((class_pr)(new class_xl(var11, var5, var7, var9, var13, var15, var17)));
            var2.a(1);
            return var2;
         }

         protected void a(class_ck var1) {
            var1.i().b(1009, var1.d(), 0);
         }
      });
      class_ahk.N.a(class_aau.aG, new class_cn() {
         private final class_cn b = new class_cn();

         public class_aas b(class_ck var1, class_aas var2) {
            class_cq var3 = class_ahk.b(var1.f());
            class_aen var4 = var1.i();
            double var5 = var1.a() + (double)((float)var3.g() * 1.125F);
            double var7 = var1.b() + (double)((float)var3.h() * 1.125F);
            double var9 = var1.c() + (double)((float)var3.i() * 1.125F);
            class_cj var11 = var1.d().a(var3);
            class_atk var12 = var4.p(var11).c().v();
            double var13;
            if(class_atk.h.equals(var12)) {
               var13 = 1.0D;
            } else {
               if(!class_atk.a.equals(var12) || !class_atk.h.equals(var4.p(var11.b()).c().v())) {
                  return this.b.a(var1, var2);
               }

               var13 = 0.0D;
            }

            class_vk var15 = new class_vk(var4, var5, var7 + var13, var9);
            var4.a((class_pr)var15);
            var2.a(1);
            return var2;
         }

         protected void a(class_ck var1) {
            var1.i().b(1000, var1.d(), 0);
         }
      });
      class_cn var0 = new class_cn() {
         private final class_cn b = new class_cn();

         public class_aas b(class_ck var1, class_aas var2) {
            class_zn var3 = (class_zn)var2.b();
            class_cj var4 = var1.d().a(class_ahk.b(var1.f()));
            if(var3.a(var1.i(), var4)) {
               var2.a(class_aau.ay);
               var2.b = 1;
               return var2;
            } else {
               return this.b.a(var1, var2);
            }
         }
      };
      class_ahk.N.a(class_aau.aA, var0);
      class_ahk.N.a(class_aau.az, var0);
      class_ahk.N.a(class_aau.ay, new class_cn() {
         private final class_cn b = new class_cn();

         public class_aas b(class_ck var1, class_aas var2) {
            class_aen var3 = var1.i();
            class_cj var4 = var1.d().a(class_ahk.b(var1.f()));
            class_anl var5 = var3.p(var4);
            class_agj var6 = var5.c();
            class_atk var7 = var6.v();
            class_aar var8;
            if(class_atk.h.equals(var7) && var6 instanceof class_ajd && ((Integer)var5.b(class_ajd.b)).intValue() == 0) {
               var8 = class_aau.az;
            } else {
               if(!class_atk.i.equals(var7) || !(var6 instanceof class_ajd) || ((Integer)var5.b(class_ajd.b)).intValue() != 0) {
                  return super.b(var1, var2);
               }

               var8 = class_aau.aA;
            }

            var3.g(var4);
            if(--var2.b == 0) {
               var2.a(var8);
               var2.b = 1;
            } else if(((class_amm)var1.h()).a(new class_aas(var8)) < 0) {
               this.b.a(var1, new class_aas(var8));
            }

            return var2;
         }
      });
      class_ahk.N.a(class_aau.d, new class_cn() {
         private boolean b = true;

         protected class_aas b(class_ck var1, class_aas var2) {
            class_aen var3 = var1.i();
            class_cj var4 = var1.d().a(class_ahk.b(var1.f()));
            if(var3.d(var4)) {
               var3.a(var4, class_agk.ab.S());
               if(var2.a(1, (Random)var3.s)) {
                  var2.b = 0;
               }
            } else if(var3.p(var4).c() == class_agk.W) {
               class_agk.W.d(var3, var4, class_agk.W.S().a(class_alo.a, Boolean.valueOf(true)));
               var3.g(var4);
            } else {
               this.b = false;
            }

            return var2;
         }

         protected void a(class_ck var1) {
            if(this.b) {
               var1.i().b(1000, var1.d(), 0);
            } else {
               var1.i().b(1001, var1.d(), 0);
            }

         }
      });
      class_ahk.N.a(class_aau.aY, new class_cn() {
         private boolean b = true;

         protected class_aas b(class_ck var1, class_aas var2) {
            if(class_zy.a == class_zy.a(var2.i())) {
               class_aen var3 = var1.i();
               class_cj var4 = var1.d().a(class_ahk.b(var1.f()));
               if(class_zz.a(var2, var3, var4)) {
                  if(!var3.D) {
                     var3.b(2005, var4, 0);
                  }
               } else {
                  this.b = false;
               }

               return var2;
            } else {
               return super.b(var1, var2);
            }
         }

         protected void a(class_ck var1) {
            if(this.b) {
               var1.i().b(1000, var1.d(), 0);
            } else {
               var1.i().b(1001, var1.d(), 0);
            }

         }
      });
      class_ahk.N.a(class_aar.a(class_agk.W), new class_cn() {
         protected class_aas b(class_ck var1, class_aas var2) {
            class_aen var3 = var1.i();
            class_cj var4 = var1.d().a(class_ahk.b(var1.f()));
            class_vw var5 = new class_vw(var3, (double)var4.n() + 0.5D, (double)var4.o(), (double)var4.p() + 0.5D, (class_qa)null);
            var3.a((class_pr)var5);
            var3.a((class_pr)var5, "game.tnt.primed", 1.0F, 1.0F);
            --var2.b;
            return var2;
         }
      });
      class_ahk.N.a(class_aau.ca, new class_cn() {
         private boolean b = true;

         protected class_aas b(class_ck var1, class_aas var2) {
            class_aen var3 = var1.i();
            class_cq var4 = class_ahk.b(var1.f());
            class_cj var5 = var1.d().a(var4);
            class_akv var6 = class_agk.ce;
            if(var3.d(var5) && var6.b(var3, var5, var2)) {
               if(!var3.D) {
                  var3.a((class_cj)var5, (class_anl)var6.S().a(class_akv.a, class_cq.b), 3);
                  class_amg var7 = var3.s(var5);
                  if(var7 instanceof class_amy) {
                     if(var2.i() == 3) {
                        GameProfile var8 = null;
                        if(var2.n()) {
                           class_dn var9 = var2.o();
                           if(var9.b("SkullOwner", 10)) {
                              var8 = class_dy.a(var9.n("SkullOwner"));
                           } else if(var9.b("SkullOwner", 8)) {
                              String var10 = var9.k("SkullOwner");
                              if(!class_nz.b(var10)) {
                                 var8 = new GameProfile((UUID)null, var10);
                              }
                           }
                        }

                        ((class_amy)var7).a(var8);
                     } else {
                        ((class_amy)var7).a(var2.i());
                     }

                     ((class_amy)var7).b(var4.d().b() * 4);
                     class_agk.ce.a(var3, var5, (class_amy)var7);
                  }

                  --var2.b;
               }
            } else {
               this.b = false;
            }

            return var2;
         }

         protected void a(class_ck var1) {
            if(this.b) {
               var1.i().b(1000, var1.d(), 0);
            } else {
               var1.i().b(1001, var1.d(), 0);
            }

         }
      });
      class_ahk.N.a(class_aar.a(class_agk.aU), new class_cn() {
         private boolean b = true;

         protected class_aas b(class_ck var1, class_aas var2) {
            class_aen var3 = var1.i();
            class_cj var4 = var1.d().a(class_ahk.b(var1.f()));
            class_akd var5 = (class_akd)class_agk.aU;
            if(var3.d(var4) && var5.e(var3, var4)) {
               if(!var3.D) {
                  var3.a((class_cj)var4, (class_anl)var5.S(), 3);
               }

               --var2.b;
            } else {
               this.b = false;
            }

            return var2;
         }

         protected void a(class_ck var1) {
            if(this.b) {
               var1.i().b(1000, var1.d(), 0);
            } else {
               var1.i().b(1001, var1.d(), 0);
            }

         }
      });
   }

   public static void c() {
      if(!b) {
         b = true;
         if(c.isDebugEnabled()) {
            d();
         }

         class_agj.U();
         class_aib.l();
         class_pk.k();
         class_adi.e();
         class_aar.t();
         class_acd.c();
         class_ace.a();
         class_nc.a();
         b();
      }
   }

   private static void d() {
      System.setErr(new class_kh("STDERR", System.err));
      System.setOut(new class_kh("STDOUT", a));
   }

   static {
      a = System.out;
      b = false;
      c = LogManager.getLogger();
   }
}
