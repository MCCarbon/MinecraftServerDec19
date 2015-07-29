package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_abw;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agu;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fv;
import net.minecraft.server.class_gz;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_ou;
import net.minecraft.server.class_xa;

public class class_li {
   public class_aen a;
   public class_lh b;
   private class_aeq.class_a_in_class_aeq c;
   private boolean d;
   private int e;
   private class_cj f;
   private int g;
   private boolean h;
   private class_cj i;
   private int j;
   private int k;

   public class_li(class_aen var1) {
      this.c = class_aeq.class_a_in_class_aeq.a;
      this.f = class_cj.a;
      this.i = class_cj.a;
      this.k = -1;
      this.a = var1;
   }

   public void a(class_aeq.class_a_in_class_aeq var1) {
      this.c = var1;
      var1.a(this.b.bH);
      this.b.t();
      this.b.b.ap().a((class_ff)(new class_gz(class_gz.class_a_in_class_gz.b, new class_lh[]{this.b})));
   }

   public class_aeq.class_a_in_class_aeq b() {
      return this.c;
   }

   public boolean c() {
      return this.c.e();
   }

   public boolean d() {
      return this.c.d();
   }

   public void b(class_aeq.class_a_in_class_aeq var1) {
      if(this.c == class_aeq.class_a_in_class_aeq.a) {
         this.c = var1;
      }

      this.a(this.c);
   }

   public void a() {
      ++this.g;
      float var3;
      int var4;
      if(this.h) {
         int var1 = this.g - this.j;
         class_agj var2 = this.a.p(this.i).c();
         if(var2.v() == class_atk.a) {
            this.h = false;
         } else {
            var3 = var2.a((class_xa)this.b, (class_aen)this.b.o, (class_cj)this.i) * (float)(var1 + 1);
            var4 = (int)(var3 * 10.0F);
            if(var4 != this.k) {
               this.a.c(this.b.F(), this.i, var4);
               this.k = var4;
            }

            if(var3 >= 1.0F) {
               this.h = false;
               this.b(this.i);
            }
         }
      } else if(this.d) {
         class_agj var5 = this.a.p(this.f).c();
         if(var5.v() == class_atk.a) {
            this.a.c(this.b.F(), this.f, -1);
            this.k = -1;
            this.d = false;
         } else {
            int var6 = this.g - this.e;
            var3 = var5.a((class_xa)this.b, (class_aen)this.b.o, (class_cj)this.i) * (float)(var6 + 1);
            var4 = (int)(var3 * 10.0F);
            if(var4 != this.k) {
               this.a.c(this.b.F(), this.f, var4);
               this.k = var4;
            }
         }
      }

   }

   public void a(class_cj var1, class_cq var2) {
      if(this.d()) {
         if(!this.a.a((class_xa)null, (class_cj)var1, (class_cq)var2)) {
            this.b(var1);
         }

      } else {
         class_agj var3 = this.a.p(var1).c();
         if(this.c.c()) {
            if(this.c == class_aeq.class_a_in_class_aeq.e) {
               return;
            }

            if(!this.b.cp()) {
               class_aas var4 = this.b.bA();
               if(var4 == null) {
                  return;
               }

               if(!var4.c(var3)) {
                  return;
               }
            }
         }

         this.a.a((class_xa)null, (class_cj)var1, (class_cq)var2);
         this.e = this.g;
         float var6 = 1.0F;
         if(var3.v() != class_atk.a) {
            var3.a((class_aen)this.a, (class_cj)var1, (class_xa)this.b);
            var6 = var3.a((class_xa)this.b, (class_aen)this.b.o, (class_cj)var1);
         }

         if(var3.v() != class_atk.a && var6 >= 1.0F) {
            this.b(var1);
         } else {
            this.d = true;
            this.f = var1;
            int var5 = (int)(var6 * 10.0F);
            this.a.c(this.b.F(), var1, var5);
            this.k = var5;
         }

      }
   }

   public void a(class_cj var1) {
      if(var1.equals(this.f)) {
         int var2 = this.g - this.e;
         class_agj var3 = this.a.p(var1).c();
         if(var3.v() != class_atk.a) {
            float var4 = var3.a((class_xa)this.b, (class_aen)this.b.o, (class_cj)var1) * (float)(var2 + 1);
            if(var4 >= 0.7F) {
               this.d = false;
               this.a.c(this.b.F(), var1, -1);
               this.b(var1);
            } else if(!this.h) {
               this.d = false;
               this.h = true;
               this.i = var1;
               this.j = this.e;
            }
         }
      }

   }

   public void e() {
      this.d = false;
      this.a.c(this.b.F(), this.f, -1);
   }

   private boolean c(class_cj var1) {
      class_anl var2 = this.a.p(var1);
      var2.c().a((class_aen)this.a, var1, (class_anl)var2, (class_xa)this.b);
      boolean var3 = this.a.g(var1);
      if(var3) {
         var2.c().d(this.a, var1, var2);
      }

      return var3;
   }

   public boolean b(class_cj var1) {
      if(this.c.d() && this.b.bA() != null && this.b.bA().b() instanceof class_abw) {
         return false;
      } else {
         class_anl var2 = this.a.p(var1);
         class_amg var3 = this.a.s(var1);
         if(this.c.c()) {
            if(this.c == class_aeq.class_a_in_class_aeq.e) {
               return false;
            }

            if(!this.b.cp()) {
               class_aas var4 = this.b.bA();
               if(var4 == null) {
                  return false;
               }

               if(!var4.c(var2.c())) {
                  return false;
               }
            }
         }

         this.a.a(this.b, 2001, var1, class_agj.f(var2));
         boolean var8 = this.c(var1);
         if(this.d()) {
            this.b.a.a((class_ff)(new class_fv(this.a, var1)));
         } else {
            class_aas var5 = this.b.bA();
            class_aas var6 = var5 == null?null:var5.k();
            boolean var7 = this.b.b((class_agj)var2.c());
            if(var5 != null) {
               var5.a(this.a, var2.c(), var1, this.b);
               if(var5.b == 0) {
                  this.b.a((class_oo)class_oo.a, (class_aas)null);
               }
            }

            if(var8 && var7) {
               var2.c().a(this.a, (class_xa)this.b, (class_cj)var1, (class_anl)var2, (class_amg)var3, (class_aas)var6);
            }
         }

         return var8;
      }
   }

   public class_oq a(class_xa var1, class_aen var2, class_aas var3, class_oo var4) {
      if(this.c == class_aeq.class_a_in_class_aeq.e) {
         return class_oq.b;
      } else {
         int var5 = var3.b;
         int var6 = var3.i();
         class_or var7 = var3.a(var2, var1, var4);
         class_aas var8 = (class_aas)var7.b();
         if(var8 != var3 || var8.b != var5 || var8.l() > 0 || var8.i() != var6) {
            var1.a((class_oo)var4, (class_aas)var8);
            if(this.d()) {
               var8.b = var5;
               if(var8.e()) {
                  var8.b(var6);
               }
            }

            if(var8.b == 0) {
               var1.a((class_oo)var4, (class_aas)null);
            }

            if(!var1.bS()) {
               ((class_lh)var1).a(var1.bq);
            }
         }

         return var7.a();
      }
   }

   public class_oq a(class_xa var1, class_aen var2, class_aas var3, class_oo var4, class_cj var5, class_cq var6, float var7, float var8, float var9) {
      if(this.c == class_aeq.class_a_in_class_aeq.e) {
         class_amg var14 = var2.s(var5);
         if(var14 instanceof class_ou) {
            class_agj var15 = var2.p(var5).c();
            class_ou var16 = (class_ou)var14;
            if(var16 instanceof class_ami && var15 instanceof class_agu) {
               var16 = ((class_agu)var15).f(var2, var5);
            }

            if(var16 != null) {
               var1.a((class_oj)var16);
               return class_oq.a;
            }
         } else if(var14 instanceof class_oj) {
            var1.a((class_oj)var14);
            return class_oq.a;
         }

         return class_oq.b;
      } else {
         if(!var1.ax() || var1.bA() == null) {
            class_anl var10 = var2.p(var5);
            if(var10.c().a(var2, var5, var10, var1, var4, var3, var6, var7, var8, var9)) {
               return class_oq.a;
            }
         }

         if(var3 == null) {
            return class_oq.b;
         } else if(this.d()) {
            int var13 = var3.i();
            int var11 = var3.b;
            class_oq var12 = var3.a(var1, var2, var5, var4, var6, var7, var8, var9);
            var3.b(var13);
            var3.b = var11;
            return var12;
         } else {
            return var3.a(var1, var2, var5, var4, var6, var7, var8, var9);
         }
      }
   }

   public void a(class_lg var1) {
      this.a = var1;
   }
}
