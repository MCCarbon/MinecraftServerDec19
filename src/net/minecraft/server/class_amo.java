package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_op;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yj;

public class class_amo extends class_amg implements class_kn, class_op {
   public int a;
   public float f;
   public float g;
   public float h;
   public float i;
   public float j;
   public float k;
   public float l;
   public float m;
   public float n;
   private static Random o = new Random();
   private String p;

   public void b(class_dn var1) {
      super.b(var1);
      if(this.l_()) {
         var1.a("CustomName", this.p);
      }

   }

   public void a(class_dn var1) {
      super.a(var1);
      if(var1.b("CustomName", 8)) {
         this.p = var1.k("CustomName");
      }

   }

   public void c() {
      this.k = this.j;
      this.m = this.l;
      class_xa var1 = this.b.a((double)((float)this.c.n() + 0.5F), (double)((float)this.c.o() + 0.5F), (double)((float)this.c.p() + 0.5F), 3.0D);
      if(var1 != null) {
         double var2 = var1.s - (double)((float)this.c.n() + 0.5F);
         double var4 = var1.u - (double)((float)this.c.p() + 0.5F);
         this.n = (float)class_nu.b(var4, var2);
         this.j += 0.1F;
         if(this.j < 0.5F || o.nextInt(40) == 0) {
            float var6 = this.h;

            do {
               this.h += (float)(o.nextInt(4) - o.nextInt(4));
            } while(var6 == this.h);
         }
      } else {
         this.n += 0.02F;
         this.j -= 0.1F;
      }

      while(this.l >= 3.1415927F) {
         this.l -= 6.2831855F;
      }

      while(this.l < -3.1415927F) {
         this.l += 6.2831855F;
      }

      while(this.n >= 3.1415927F) {
         this.n -= 6.2831855F;
      }

      while(this.n < -3.1415927F) {
         this.n += 6.2831855F;
      }

      float var7;
      for(var7 = this.n - this.l; var7 >= 3.1415927F; var7 -= 6.2831855F) {
         ;
      }

      while(var7 < -3.1415927F) {
         var7 += 6.2831855F;
      }

      this.l += var7 * 0.4F;
      this.j = class_nu.a(this.j, 0.0F, 1.0F);
      ++this.a;
      this.g = this.f;
      float var3 = (this.h - this.f) * 0.4F;
      float var8 = 0.2F;
      var3 = class_nu.a(var3, -var8, var8);
      this.i += (var3 - this.i) * 0.9F;
      this.f += this.i;
   }

   public String e_() {
      return this.l_()?this.p:"container.enchant";
   }

   public boolean l_() {
      return this.p != null && !this.p.isEmpty();
   }

   public void a(String var1) {
      this.p = var1;
   }

   public class_eu f_() {
      return (class_eu)(this.l_()?new class_fa(this.e_()):new class_fb(this.e_(), new Object[0]));
   }

   public class_xz a(class_wz var1, class_xa var2) {
      return new class_yj(var1, this.b, this.c);
   }

   public String k() {
      return "minecraft:enchanting_table";
   }
}
