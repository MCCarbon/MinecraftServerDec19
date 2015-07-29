package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_rm;

public class class_ri extends class_rm {
   private class_qh a;
   private double b;
   private double c;
   private double d;
   private double e;
   private class_aen f;

   public class_ri(class_qh var1, double var2) {
      this.a = var1;
      this.e = var2;
      this.f = var1.o;
      this.a(1);
   }

   public boolean a() {
      if(!this.f.x()) {
         return false;
      } else if(!this.a.av()) {
         return false;
      } else if(!this.f.i(new class_cj(this.a.s, this.a.aT().b, this.a.u))) {
         return false;
      } else {
         class_awh var1 = this.f();
         if(var1 == null) {
            return false;
         } else {
            this.b = var1.a;
            this.c = var1.b;
            this.d = var1.c;
            return true;
         }
      }
   }

   public boolean b() {
      return !this.a.u().m();
   }

   public void c() {
      this.a.u().a(this.b, this.c, this.d, this.e);
   }

   private class_awh f() {
      Random var1 = this.a.bd();
      class_cj var2 = new class_cj(this.a.s, this.a.aT().b, this.a.u);

      for(int var3 = 0; var3 < 10; ++var3) {
         class_cj var4 = var2.a(var1.nextInt(20) - 10, var1.nextInt(6) - 3, var1.nextInt(20) - 10);
         if(!this.f.i(var4) && this.a.a(var4) < 0.0F) {
            return new class_awh((double)var4.n(), (double)var4.o(), (double)var4.p());
         }
      }

      return null;
   }
}
