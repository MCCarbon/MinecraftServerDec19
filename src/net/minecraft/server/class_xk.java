package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.World;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dy;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xj;

public class class_xk extends class_pr {
   private class_qa a;
   private class_pr b;
   private class_cq c;
   private int d;
   private double e;
   private double f;
   private double g;
   private UUID h;
   private class_cj i;
   private UUID as;
   private class_cj at;

   public class_xk(World var1) {
      super(var1);
      this.a(0.3125F, 0.3125F);
      this.T = true;
   }

   public class_xk(World var1, class_qa var2, class_pr var3, class_cq.class_a_in_class_cq var4) {
      this(var1);
      this.a = var2;
      class_cj var5 = new class_cj(var2);
      double var6 = (double)var5.n() + 0.5D;
      double var8 = (double)var5.o() + 0.5D;
      double var10 = (double)var5.p() + 0.5D;
      this.b(var6, var8, var10, this.y, this.z);
      this.b = var3;
      this.c = class_cq.b;
      this.a(var4);
   }

   protected void b(class_dn var1) {
      class_cj var2;
      class_dn var3;
      if(this.a != null) {
         var2 = new class_cj(this.a);
         var3 = class_dy.a(this.a.aM());
         var3.a("X", var2.n());
         var3.a("Y", var2.o());
         var3.a("Z", var2.p());
         var1.a((String)"Owner", (class_eb)var3);
      }

      if(this.b != null) {
         var2 = new class_cj(this.b);
         var3 = class_dy.a(this.b.aM());
         var3.a("X", var2.n());
         var3.a("Y", var2.o());
         var3.a("Z", var2.p());
         var1.a((String)"Target", (class_eb)var3);
      }

      if(this.c != null) {
         var1.a("Dir", this.c.a());
      }

      var1.a("Steps", this.d);
      var1.a("TXD", this.e);
      var1.a("TYD", this.f);
      var1.a("TZD", this.g);
   }

   protected void a(class_dn var1) {
      this.d = var1.g("Steps");
      this.e = var1.j("TXD");
      this.f = var1.j("TYD");
      this.g = var1.j("TZD");
      if(var1.b("Dir", 99)) {
         this.c = class_cq.a(var1.g("Dir"));
      }

      class_dn var2;
      if(var1.b("Owner", 10)) {
         var2 = var1.n("Owner");
         this.h = class_dy.b(var2);
         this.i = new class_cj(var2.g("X"), var2.g("Y"), var2.g("Z"));
      }

      if(var1.b("Target", 10)) {
         var2 = var1.n("Target");
         this.as = class_dy.b(var2);
         this.at = new class_cj(var2.g("X"), var2.g("Y"), var2.g("Z"));
      }

   }

   protected void h() {
   }

   private class_cq j() {
      return this.c;
   }

   private void a(class_cq var1) {
      this.c = var1;
   }

   private void a(class_cq.class_a_in_class_cq var1) {
      double var3 = 0.5D;
      class_cj var2;
      if(this.b != null) {
         var3 = (double)this.b.K * 0.5D;
         var2 = new class_cj(this.b.s, this.b.t + var3, this.b.u);
      } else {
         var2 = (new class_cj(this)).b();
      }

      double var5 = (double)var2.n() + 0.5D;
      double var7 = (double)var2.o() + var3;
      double var9 = (double)var2.p() + 0.5D;
      if(var2.d(this.s, this.t, this.u) >= 4.0D) {
         class_cj var11 = new class_cj(this);
         ArrayList var12 = Lists.newArrayList();
         if(var1 != class_cq.class_a_in_class_cq.a) {
            if(var11.n() < var2.n() && this.o.d(var11.f())) {
               var12.add(class_cq.f);
            } else if(var11.n() > var2.n() && this.o.d(var11.e())) {
               var12.add(class_cq.e);
            }
         }

         if(var1 != class_cq.class_a_in_class_cq.b) {
            if(var11.o() < var2.o() && this.o.d(var11.a())) {
               var12.add(class_cq.b);
            } else if(var11.o() > var2.o() && this.o.d(var11.b())) {
               var12.add(class_cq.a);
            }
         }

         if(var1 != class_cq.class_a_in_class_cq.c) {
            if(var11.p() < var2.p() && this.o.d(var11.d())) {
               var12.add(class_cq.d);
            } else if(var11.p() > var2.p() && this.o.d(var11.c())) {
               var12.add(class_cq.c);
            }
         }

         class_cq var13 = class_cq.a(this.V);
         if(!var12.isEmpty()) {
            var13 = (class_cq)var12.get(this.V.nextInt(var12.size()));
         } else {
            for(int var14 = 5; !this.o.d(var11.a(var13)) && var14 > 0; --var14) {
               var13 = class_cq.a(this.V);
            }
         }

         var5 = this.s + (double)var13.g();
         var7 = this.t + (double)var13.h();
         var9 = this.u + (double)var13.i();
         this.a(var13);
      } else {
         this.a((class_cq)null);
      }

      double var19 = var5 - this.s;
      double var20 = var7 - this.t;
      double var15 = var9 - this.u;
      double var17 = (double)class_nu.a(var19 * var19 + var20 * var20 + var15 * var15);
      this.e = var19 / var17 * 0.15D;
      this.f = var20 / var17 * 0.15D;
      this.g = var15 / var17 * 0.15D;
      this.ai = true;
      this.d = 10 + this.V.nextInt(5) * 10;
   }

   public void t_() {
      super.t_();
      if(!this.o.D) {
         List var1;
         Iterator var2;
         class_qa var3;
         if(this.b == null && this.as != null) {
            var1 = this.o.a(class_qa.class, new class_awf(this.at.a(-2, -2, -2), this.at.a(2, 2, 2)));
            var2 = var1.iterator();

            while(var2.hasNext()) {
               var3 = (class_qa)var2.next();
               if(var3.aM().equals(this.as)) {
                  this.b = var3;
                  break;
               }
            }

            this.as = null;
         }

         if(this.a == null && this.h != null) {
            var1 = this.o.a(class_qa.class, new class_awf(this.i.a(-2, -2, -2), this.i.a(2, 2, 2)));
            var2 = var1.iterator();

            while(var2.hasNext()) {
               var3 = (class_qa)var2.next();
               if(var3.aM().equals(this.h)) {
                  this.a = var3;
                  break;
               }
            }

            this.h = null;
         }

         if(this.b != null && !this.b.I) {
            this.e = class_nu.a(this.e * 1.025D, -1.0D, 1.0D);
            this.f = class_nu.a(this.f * 1.025D, -1.0D, 1.0D);
            this.g = class_nu.a(this.g * 1.025D, -1.0D, 1.0D);
            this.v += (this.e - this.v) * 0.2D;
            this.w += (this.f - this.w) * 0.2D;
            this.x += (this.g - this.x) * 0.2D;
         } else {
            this.w -= 0.04D;
         }

         class_awg var4 = class_xj.a(this, true, false, this.a);
         if(var4 != null) {
            this.a(var4);
         }
      }

      this.b(this.s + this.v, this.t + this.w, this.u + this.x);
      class_xj.a(this, 0.5F);
      if(!this.o.D) {
         if(this.b != null && !this.b.I) {
            if(this.d > 0) {
               --this.d;
               if(this.d == 0) {
                  this.a(this.c != null?this.c.k():null);
               }
            }

            class_cq var5 = this.j();
            if(var5 != null) {
               class_cj var6 = new class_cj(this);
               if(this.o.d(var6.a(var5), false)) {
                  this.a(var5.k());
               } else {
                  class_cj var7 = new class_cj(this.b);
                  if(var5.k() == class_cq.class_a_in_class_cq.a && var6.n() == var7.n() || var5.k() == class_cq.class_a_in_class_cq.c && var6.p() == var7.p() || var5.k() == class_cq.class_a_in_class_cq.b && var6.o() == var7.o()) {
                     this.a(var5.k());
                  }
               }
            }
         }
      } else {
         this.o.a(class_cy.R, this.s - this.v, this.t - this.w + 0.15D, this.u - this.x, 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   public boolean av() {
      return false;
   }

   public float c(float var1) {
      return 1.0F;
   }

   protected void a(class_awg var1) {
      if(var1.d != null) {
         boolean var2 = var1.d.a(class_pc.a((class_pr)this, (class_qa)this.a), 4.0F);
         if(var2) {
            this.a(this.a, var1.d);
            if(var1.d instanceof class_qa) {
               ((class_qa)var1.d).c(new class_pl(class_pm.y, 200));
            }
         }
      } else {
         ((class_lg)this.o).a(class_cy.b, this.s, this.t, this.u, 2, 0.2D, 0.2D, 0.2D, 0.0D, new int[0]);
         this.a("mob.irongolem.hit", 1.0F, 1.0F);
      }

      this.J();
   }

   public boolean ad() {
      return true;
   }

   public boolean a(class_pc var1, float var2) {
      if(!this.o.D) {
         this.a("mob.irongolem.hit", 1.0F, 1.0F);
         ((class_lg)this.o).a(class_cy.j, this.s, this.t, this.u, 15, 0.2D, 0.2D, 0.2D, 0.0D, new int[0]);
         this.J();
      }

      return true;
   }
}
