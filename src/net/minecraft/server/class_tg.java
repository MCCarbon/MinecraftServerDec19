package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_aew;
import net.minecraft.server.class_auv;
import net.minecraft.server.class_auw;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_wl;

public abstract class class_tg {
   protected class_qb b;
   protected class_aen c;
   protected class_auv d;
   protected double e;
   private final class_ql a;
   private int f;
   private int g;
   private class_awh h = new class_awh(0.0D, 0.0D, 0.0D);
   private float i = 1.0F;
   private final class_auw j;

   public class_tg(class_qb var1, class_aen var2) {
      this.b = var1;
      this.c = var2;
      this.a = var1.a((class_qk)class_wl.b);
      this.j = this.a();
   }

   protected abstract class_auw a();

   public void a(double var1) {
      this.e = var1;
   }

   public float i() {
      return (float)this.a.e();
   }

   public final class_auv a(double var1, double var3, double var5) {
      return this.a(new class_cj(class_nu.c(var1), (int)var3, class_nu.c(var5)));
   }

   public class_auv a(class_cj var1) {
      if(!this.b()) {
         return null;
      } else {
         float var2 = this.i();
         this.c.B.a("pathfind");
         class_cj var3 = new class_cj(this.b);
         int var4 = (int)(var2 + 8.0F);
         class_aew var5 = new class_aew(this.c, var3.a(-var4, -var4, -var4), var3.a(var4, var4, var4), 0);
         class_auv var6 = this.j.a((class_aer)var5, (class_pr)this.b, (class_cj)var1, var2);
         this.c.B.b();
         return var6;
      }
   }

   public boolean a(double var1, double var3, double var5, double var7) {
      class_auv var9 = this.a((double)class_nu.c(var1), (double)((int)var3), (double)class_nu.c(var5));
      return this.a(var9, var7);
   }

   public void a(float var1) {
      this.i = var1;
   }

   public class_auv a(class_pr var1) {
      if(!this.b()) {
         return null;
      } else {
         float var2 = this.i();
         this.c.B.a("pathfind");
         class_cj var3 = (new class_cj(this.b)).a();
         int var4 = (int)(var2 + 16.0F);
         class_aew var5 = new class_aew(this.c, var3.a(-var4, -var4, -var4), var3.a(var4, var4, var4), 0);
         class_auv var6 = this.j.a((class_aer)var5, (class_pr)this.b, (class_pr)var1, var2);
         this.c.B.b();
         return var6;
      }
   }

   public boolean a(class_pr var1, double var2) {
      class_auv var4 = this.a(var1);
      return var4 != null?this.a(var4, var2):false;
   }

   public boolean a(class_auv var1, double var2) {
      if(var1 == null) {
         this.d = null;
         return false;
      } else {
         if(!var1.a(this.d)) {
            this.d = var1;
         }

         this.d();
         if(this.d.d() == 0) {
            return false;
         } else {
            this.e = var2;
            class_awh var4 = this.c();
            this.g = this.f;
            this.h = var4;
            return true;
         }
      }
   }

   public class_auv j() {
      return this.d;
   }

   public void k() {
      ++this.f;
      if(!this.m()) {
         class_awh var1;
         if(this.b()) {
            this.l();
         } else if(this.d != null && this.d.e() < this.d.d()) {
            var1 = this.c();
            class_awh var2 = this.d.a(this.b, this.d.e());
            if(var1.b > var2.b && !this.b.C && class_nu.c(var1.a) == class_nu.c(var2.a) && class_nu.c(var1.c) == class_nu.c(var2.c)) {
               this.d.c(this.d.e() + 1);
            }
         }

         if(!this.m()) {
            var1 = this.d.a((class_pr)this.b);
            if(var1 != null) {
               class_awf var8 = (new class_awf(var1.a, var1.b, var1.c, var1.a, var1.b, var1.c)).b(0.5D, 0.5D, 0.5D);
               List var3 = this.c.a((class_pr)this.b, (class_awf)var8.a(0.0D, -1.0D, 0.0D));
               double var4 = -1.0D;
               var8 = var8.c(0.0D, 1.0D, 0.0D);

               class_awf var7;
               for(Iterator var6 = var3.iterator(); var6.hasNext(); var4 = var7.b(var8, var4)) {
                  var7 = (class_awf)var6.next();
               }

               this.b.r().a(var1.a, var1.b + var4, var1.c, this.e);
            }
         }
      }
   }

   protected void l() {
      class_awh var1 = this.c();
      int var2 = this.d.d();

      for(int var3 = this.d.e(); var3 < this.d.d(); ++var3) {
         if(this.d.a(var3).b != (int)var1.b) {
            var2 = var3;
            break;
         }
      }

      float var8 = this.b.J * this.b.J * this.i;

      int var4;
      for(var4 = this.d.e(); var4 < var2; ++var4) {
         class_awh var5 = this.d.a(this.b, var4);
         if(var1.g(var5) < (double)var8) {
            this.d.c(var4 + 1);
         }
      }

      var4 = class_nu.f(this.b.J);
      int var9 = (int)this.b.K + 1;
      int var6 = var4;

      for(int var7 = var2 - 1; var7 >= this.d.e(); --var7) {
         if(this.a(var1, this.d.a(this.b, var7), var4, var9, var6)) {
            this.d.c(var7);
            break;
         }
      }

      this.a(var1);
   }

   protected void a(class_awh var1) {
      if(this.f - this.g > 100) {
         if(var1.g(this.h) < 2.25D) {
            this.n();
         }

         this.g = this.f;
         this.h = var1;
      }

   }

   public boolean m() {
      return this.d == null || this.d.b();
   }

   public void n() {
      this.d = null;
   }

   protected abstract class_awh c();

   protected abstract boolean b();

   protected boolean o() {
      return this.b.V() || this.b.ab();
   }

   protected void d() {
   }

   protected abstract boolean a(class_awh var1, class_awh var2, int var3, int var4, int var5);
}
