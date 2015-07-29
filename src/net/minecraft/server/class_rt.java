package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_po;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tp;
import net.minecraft.server.class_wv;

public class class_rt extends class_rm {
   private class_wv b;
   private class_wv c;
   private World d;
   private int e;
   class_tp a;

   public class_rt(class_wv var1) {
      this.b = var1;
      this.d = var1.o;
      this.a(3);
   }

   public boolean a() {
      if(this.b.l() != 0) {
         return false;
      } else if(this.b.bd().nextInt(500) != 0) {
         return false;
      } else {
         this.a = this.d.af().a(new class_cj(this.b), 0);
         if(this.a == null) {
            return false;
         } else if(this.f() && this.b.o(true)) {
            class_pr var1 = this.d.a((Class)class_wv.class, (class_awf)this.b.aT().b(8.0D, 3.0D, 8.0D), (class_pr)this.b);
            if(var1 == null) {
               return false;
            } else {
               this.c = (class_wv)var1;
               return this.c.l() == 0 && this.c.o(true);
            }
         } else {
            return false;
         }
      }
   }

   public void c() {
      this.e = 300;
      this.b.m(true);
   }

   public void d() {
      this.a = null;
      this.c = null;
      this.b.m(false);
   }

   public boolean b() {
      return this.e >= 0 && this.f() && this.b.l() == 0 && this.b.o(false);
   }

   public void e() {
      --this.e;
      this.b.q().a(this.c, 10.0F, 30.0F);
      if(this.b.h(this.c) > 2.25D) {
         this.b.u().a((class_pr)this.c, 0.25D);
      } else if(this.e == 0 && this.c.cB()) {
         this.g();
      }

      if(this.b.bd().nextInt(35) == 0) {
         this.d.a((class_pr)this.b, (byte)12);
      }

   }

   private boolean f() {
      if(!this.a.i()) {
         return false;
      } else {
         int var1 = (int)((double)((float)this.a.c()) * 0.35D);
         return this.a.e() < var1;
      }
   }

   private void g() {
      class_wv var1 = this.b.b((class_po)this.c);
      this.c.b(6000);
      this.b.b(6000);
      this.c.p(false);
      this.b.p(false);
      var1.b(-24000);
      var1.b(this.b.s, this.b.t, this.b.u, 0.0F, 0.0F);
      this.d.a((class_pr)var1);
      this.d.a((class_pr)var1, (byte)12);
   }
}
