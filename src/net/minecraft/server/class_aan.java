package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_abz;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_aan extends class_aar {
   public final int a;
   private final int b;
   private final float c;
   private final boolean d;
   private boolean k;
   private class_pl l;
   private float m;

   public class_aan(int var1, float var2, boolean var3) {
      this.a = 32;
      this.b = var1;
      this.d = var3;
      this.c = var2;
      this.a(class_zu.h);
   }

   public class_aan(int var1, boolean var2) {
      this(var1, 0.6F, var2);
   }

   public class_aas a(class_aas var1, class_aen var2, class_qa var3) {
      --var1.b;
      if(var3 instanceof class_xa) {
         class_xa var4 = (class_xa)var3;
         var4.cn().a(this, var1);
         var2.a((class_pr)var4, "random.burp", 0.5F, var2.s.nextFloat() * 0.1F + 0.9F);
         this.a(var1, var2, var4);
         var4.b(class_nc.ad[class_aar.b((class_aar)this)]);
      }

      return var1;
   }

   protected void a(class_aas var1, class_aen var2, class_xa var3) {
      if(!var2.D && this.l != null && var2.s.nextFloat() < this.m) {
         var3.c(new class_pl(this.l));
      }

   }

   public int e(class_aas var1) {
      return 32;
   }

   public class_abz f(class_aas var1) {
      return class_abz.b;
   }

   public class_or a(class_aas var1, class_aen var2, class_xa var3, class_oo var4) {
      if(var3.j(this.k)) {
         var3.c(var4);
         return new class_or(class_oq.a, var1);
      } else {
         return new class_or(class_oq.b, var1);
      }
   }

   public int h(class_aas var1) {
      return this.b;
   }

   public float i(class_aas var1) {
      return this.c;
   }

   public boolean g() {
      return this.d;
   }

   public class_aan a(class_pl var1, float var2) {
      this.l = var1;
      this.m = var2;
      return this;
   }

   public class_aan h() {
      this.k = true;
      return this;
   }
}
