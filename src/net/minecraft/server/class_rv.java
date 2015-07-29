package net.minecraft.server;

import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tm;
import net.minecraft.server.class_to;
import net.minecraft.server.class_tp;

public class class_rv extends class_rm {
   private class_qh a;
   private class_to b;
   private int c = -1;
   private int d = -1;

   public class_rv(class_qh var1) {
      this.a = var1;
      this.a(1);
   }

   public boolean a() {
      class_cj var1 = new class_cj(this.a);
      if((!this.a.o.x() || this.a.o.T() && !this.a.o.b(var1).e()) && !this.a.o.t.m()) {
         if(this.a.bd().nextInt(50) != 0) {
            return false;
         } else if(this.c != -1 && this.a.e((double)this.c, this.a.t, (double)this.d) < 4.0D) {
            return false;
         } else {
            class_tp var2 = this.a.o.af().a(var1, 14);
            if(var2 == null) {
               return false;
            } else {
               this.b = var2.c(var1);
               return this.b != null;
            }
         }
      } else {
         return false;
      }
   }

   public boolean b() {
      return !this.a.u().m();
   }

   public void c() {
      this.c = -1;
      class_cj var1 = this.b.e();
      int var2 = var1.n();
      int var3 = var1.o();
      int var4 = var1.p();
      if(this.a.b(var1) > 256.0D) {
         class_awh var5 = class_tm.a(this.a, 14, 3, new class_awh((double)var2 + 0.5D, (double)var3, (double)var4 + 0.5D));
         if(var5 != null) {
            this.a.u().a(var5.a, var5.b, var5.c, 1.0D);
         }
      } else {
         this.a.u().a((double)var2 + 0.5D, (double)var3, (double)var4 + 0.5D, 1.0D);
      }

   }

   public void d() {
      this.c = this.b.e().n();
      this.d = this.b.e().p();
      this.b = null;
   }
}
