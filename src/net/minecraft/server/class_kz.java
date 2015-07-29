package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_gm;
import net.minecraft.server.class_li;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;

public class class_kz extends class_li {
   private boolean c;
   private boolean d;
   private int e;
   private int f;

   public class_kz(World var1) {
      super(var1);
   }

   public void a() {
      super.a();
      ++this.f;
      long var1 = this.a.L();
      long var3 = var1 / 24000L + 1L;
      if(!this.c && this.f > 20) {
         this.c = true;
         this.b.a.a((class_ff)(new class_gm(5, 0.0F)));
      }

      this.d = var1 > 120500L;
      if(this.d) {
         ++this.e;
      }

      if(var1 % 24000L == 500L) {
         if(var3 <= 6L) {
            this.b.a((class_eu)(new class_fb("demo.day." + var3, new Object[0])));
         }
      } else if(var3 == 1L) {
         if(var1 == 100L) {
            this.b.a.a((class_ff)(new class_gm(5, 101.0F)));
         } else if(var1 == 175L) {
            this.b.a.a((class_ff)(new class_gm(5, 102.0F)));
         } else if(var1 == 250L) {
            this.b.a.a((class_ff)(new class_gm(5, 103.0F)));
         }
      } else if(var3 == 5L && var1 % 24000L == 22000L) {
         this.b.a((class_eu)(new class_fb("demo.day.warning", new Object[0])));
      }

   }

   private void f() {
      if(this.e > 100) {
         this.b.a((class_eu)(new class_fb("demo.reminder", new Object[0])));
         this.e = 0;
      }

   }

   public void a(class_cj var1, class_cq var2) {
      if(this.d) {
         this.f();
      } else {
         super.a(var1, var2);
      }
   }

   public void a(class_cj var1) {
      if(!this.d) {
         super.a(var1);
      }
   }

   public boolean b(class_cj var1) {
      return this.d?false:super.b(var1);
   }

   public class_oq a(class_xa var1, World var2, class_aas var3, class_oo var4) {
      if(this.d) {
         this.f();
         return class_oq.b;
      } else {
         return super.a(var1, var2, var3, var4);
      }
   }

   public class_oq a(class_xa var1, World var2, class_aas var3, class_oo var4, class_cj var5, class_cq var6, float var7, float var8, float var9) {
      if(this.d) {
         this.f();
         return class_oq.b;
      } else {
         return super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }
   }
}
