package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anx;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oi;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ol;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_ou;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_uc;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_zu;

public class class_agu extends class_agd {
   public static final class_anx a;
   public final int b;

   protected class_agu(int var1) {
      super(class_atk.d);
      this.j(this.M.b().a(a, class_cq.c));
      this.b = var1;
      this.a(class_zu.c);
      this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public int b() {
      return 2;
   }

   public void a(class_aer var1, class_cj var2) {
      if(var1.p(var2.c()).c() == this) {
         this.a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
      } else if(var1.p(var2.d()).c() == this) {
         this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
      } else if(var1.p(var2.e()).c() == this) {
         this.a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      } else if(var1.p(var2.f()).c() == this) {
         this.a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
      } else {
         this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      }

   }

   public void c(class_aen var1, class_cj var2, class_anl var3) {
      this.e(var1, var2, var3);
      Iterator var4 = class_cq.class_c_in_class_cq.a.iterator();

      while(var4.hasNext()) {
         class_cq var5 = (class_cq)var4.next();
         class_cj var6 = var2.a(var5);
         class_anl var7 = var1.p(var6);
         if(var7.c() == this) {
            this.e(var1, var6, var7);
         }
      }

   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.S().a(a, var8.aR());
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_qa var4, class_aas var5) {
      class_cq var6 = class_cq.b(class_nu.c((double)(var4.y * 4.0F / 360.0F) + 0.5D) & 3).d();
      var3 = var3.a(a, var6);
      class_cj var7 = var2.c();
      class_cj var8 = var2.d();
      class_cj var9 = var2.e();
      class_cj var10 = var2.f();
      boolean var11 = this == var1.p(var7).c();
      boolean var12 = this == var1.p(var8).c();
      boolean var13 = this == var1.p(var9).c();
      boolean var14 = this == var1.p(var10).c();
      if(!var11 && !var12 && !var13 && !var14) {
         var1.a((class_cj)var2, (class_anl)var3, 3);
      } else if(var6.k() == class_cq.class_a_in_class_cq.a && (var11 || var12)) {
         if(var11) {
            var1.a((class_cj)var7, (class_anl)var3, 3);
         } else {
            var1.a((class_cj)var8, (class_anl)var3, 3);
         }

         var1.a((class_cj)var2, (class_anl)var3, 3);
      } else if(var6.k() == class_cq.class_a_in_class_cq.c && (var13 || var14)) {
         if(var13) {
            var1.a((class_cj)var9, (class_anl)var3, 3);
         } else {
            var1.a((class_cj)var10, (class_anl)var3, 3);
         }

         var1.a((class_cj)var2, (class_anl)var3, 3);
      }

      if(var5.s()) {
         class_amg var15 = var1.s(var2);
         if(var15 instanceof class_ami) {
            ((class_ami)var15).a(var5.q());
         }
      }

   }

   public class_anl e(class_aen var1, class_cj var2, class_anl var3) {
      if(var1.D) {
         return var3;
      } else {
         class_anl var4 = var1.p(var2.c());
         class_anl var5 = var1.p(var2.d());
         class_anl var6 = var1.p(var2.e());
         class_anl var7 = var1.p(var2.f());
         class_cq var8 = (class_cq)var3.b(a);
         class_agj var9 = var4.c();
         class_agj var10 = var5.c();
         class_agj var11 = var6.c();
         class_agj var12 = var7.c();
         if(var9 != this && var10 != this) {
            boolean var21 = var9.q();
            boolean var22 = var10.q();
            if(var11 == this || var12 == this) {
               class_cj var23 = var11 == this?var2.e():var2.f();
               class_anl var24 = var1.p(var23.c());
               class_anl var25 = var1.p(var23.d());
               var8 = class_cq.d;
               class_cq var26;
               if(var11 == this) {
                  var26 = (class_cq)var6.b(a);
               } else {
                  var26 = (class_cq)var7.b(a);
               }

               if(var26 == class_cq.c) {
                  var8 = class_cq.c;
               }

               class_agj var19 = var24.c();
               class_agj var20 = var25.c();
               if((var21 || var19.q()) && !var22 && !var20.q()) {
                  var8 = class_cq.d;
               }

               if((var22 || var20.q()) && !var21 && !var19.q()) {
                  var8 = class_cq.c;
               }
            }
         } else {
            class_cj var13 = var9 == this?var2.c():var2.d();
            class_anl var14 = var1.p(var13.e());
            class_anl var15 = var1.p(var13.f());
            var8 = class_cq.f;
            class_cq var16;
            if(var9 == this) {
               var16 = (class_cq)var4.b(a);
            } else {
               var16 = (class_cq)var5.b(a);
            }

            if(var16 == class_cq.e) {
               var8 = class_cq.e;
            }

            class_agj var17 = var14.c();
            class_agj var18 = var15.c();
            if((var11.q() || var17.q()) && !var12.q() && !var18.q()) {
               var8 = class_cq.f;
            }

            if((var12.q() || var18.q()) && !var11.q() && !var17.q()) {
               var8 = class_cq.e;
            }
         }

         var3 = var3.a(a, var8);
         var1.a((class_cj)var2, (class_anl)var3, 3);
         return var3;
      }
   }

   public class_anl f(class_aen var1, class_cj var2, class_anl var3) {
      class_cq var4 = null;
      Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

      while(var5.hasNext()) {
         class_cq var6 = (class_cq)var5.next();
         class_anl var7 = var1.p(var2.a(var6));
         if(var7.c() == this) {
            return var3;
         }

         if(var7.c().q()) {
            if(var4 != null) {
               var4 = null;
               break;
            }

            var4 = var6;
         }
      }

      if(var4 != null) {
         return var3.a(a, var4.d());
      } else {
         class_cq var8 = (class_cq)var3.b(a);
         if(var1.p(var2.a(var8)).c().q()) {
            var8 = var8.d();
         }

         if(var1.p(var2.a(var8)).c().q()) {
            var8 = var8.e();
         }

         if(var1.p(var2.a(var8)).c().q()) {
            var8 = var8.d();
         }

         return var3.a(a, var8);
      }
   }

   public boolean d(class_aen var1, class_cj var2) {
      int var3 = 0;
      class_cj var4 = var2.e();
      class_cj var5 = var2.f();
      class_cj var6 = var2.c();
      class_cj var7 = var2.d();
      if(var1.p(var4).c() == this) {
         if(this.m(var1, var4)) {
            return false;
         }

         ++var3;
      }

      if(var1.p(var5).c() == this) {
         if(this.m(var1, var5)) {
            return false;
         }

         ++var3;
      }

      if(var1.p(var6).c() == this) {
         if(this.m(var1, var6)) {
            return false;
         }

         ++var3;
      }

      if(var1.p(var7).c() == this) {
         if(this.m(var1, var7)) {
            return false;
         }

         ++var3;
      }

      return var3 <= 1;
   }

   private boolean m(class_aen var1, class_cj var2) {
      if(var1.p(var2).c() != this) {
         return false;
      } else {
         Iterator var3 = class_cq.class_c_in_class_cq.a.iterator();

         class_cq var4;
         do {
            if(!var3.hasNext()) {
               return false;
            }

            var4 = (class_cq)var3.next();
         } while(var1.p(var2.a(var4)).c() != this);

         return true;
      }
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      super.a(var1, var2, var3, var4);
      class_amg var5 = var1.s(var2);
      if(var5 instanceof class_ami) {
         var5.E();
      }

   }

   public void b(class_aen var1, class_cj var2, class_anl var3) {
      class_amg var4 = var1.s(var2);
      if(var4 instanceof class_oj) {
         class_ol.a(var1, var2, (class_oj)var4);
         var1.e(var2, this);
      }

      super.b(var1, var2, var3);
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_ou var11 = this.f(var1, var2);
         if(var11 != null) {
            var4.a((class_oj)var11);
            if(this.b == 0) {
               var4.b(class_nc.aa);
            } else if(this.b == 1) {
               var4.b(class_nc.U);
            }
         }

         return true;
      }
   }

   public class_ou f(class_aen var1, class_cj var2) {
      class_amg var3 = var1.s(var2);
      if(!(var3 instanceof class_ami)) {
         return null;
      } else {
         Object var4 = (class_ami)var3;
         if(this.n(var1, var2)) {
            return null;
         } else {
            Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

            while(true) {
               while(true) {
                  class_cq var6;
                  class_amg var9;
                  do {
                     class_cj var7;
                     class_agj var8;
                     do {
                        if(!var5.hasNext()) {
                           return (class_ou)var4;
                        }

                        var6 = (class_cq)var5.next();
                        var7 = var2.a(var6);
                        var8 = var1.p(var7).c();
                     } while(var8 != this);

                     if(this.n(var1, var7)) {
                        return null;
                     }

                     var9 = var1.s(var7);
                  } while(!(var9 instanceof class_ami));

                  if(var6 != class_cq.e && var6 != class_cq.c) {
                     var4 = new class_oi("container.chestDouble", (class_ou)var4, (class_ami)var9);
                  } else {
                     var4 = new class_oi("container.chestDouble", (class_ami)var9, (class_ou)var4);
                  }
               }
            }
         }
      }
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_ami();
   }

   public boolean i() {
      return this.b == 1;
   }

   public int a(class_aer var1, class_cj var2, class_anl var3, class_cq var4) {
      if(!this.i()) {
         return 0;
      } else {
         int var5 = 0;
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_ami) {
            var5 = ((class_ami)var6).l;
         }

         return class_nu.a(var5, 0, 15);
      }
   }

   public int b(class_aer var1, class_cj var2, class_anl var3, class_cq var4) {
      return var4 == class_cq.b?this.a(var1, var2, var3, var4):0;
   }

   private boolean n(class_aen var1, class_cj var2) {
      return this.o(var1, var2) || this.p(var1, var2);
   }

   private boolean o(class_aen var1, class_cj var2) {
      return var1.p(var2.a()).c().x();
   }

   private boolean p(class_aen var1, class_cj var2) {
      Iterator var3 = var1.a(class_uc.class, new class_awf((double)var2.n(), (double)(var2.o() + 1), (double)var2.p(), (double)(var2.n() + 1), (double)(var2.o() + 2), (double)(var2.p() + 1))).iterator();

      class_uc var5;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         class_pr var4 = (class_pr)var3.next();
         var5 = (class_uc)var4;
      } while(!var5.cC());

      return true;
   }

   public boolean Q() {
      return true;
   }

   public int l(class_aen var1, class_cj var2) {
      return class_xz.b((class_oj)this.f(var1, var2));
   }

   public class_anl a(int var1) {
      class_cq var2 = class_cq.a(var1);
      if(var2.k() == class_cq.class_a_in_class_cq.b) {
         var2 = class_cq.c;
      }

      return this.S().a(a, var2);
   }

   public int c(class_anl var1) {
      return ((class_cq)var1.b(a)).a();
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      return var1.c() != this?var1:var1.a(a, var2.a((class_cq)var1.b(a)));
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      return var1.c() != this?var1:this.a(var1, var2.a((class_cq)var1.b(a)));
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }

   static {
      a = class_aiv.O;
   }
}
