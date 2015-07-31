package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_aco;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_px;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_yx;

public class class_ym extends class_yx {
   private class_xa a;
   private int b;

   public class_ym(class_xa var1, class_oj var2, int var3, int var4, int var5) {
      super(var2, var3, var4, var5);
      this.a = var1;
   }

   public boolean a(ItemStack var1) {
      return false;
   }

   public ItemStack a(int var1) {
      if(this.e()) {
         this.b += Math.min(var1, this.d().count);
      }

      return super.a(var1);
   }

   public void a(class_xa var1, ItemStack var2) {
      this.c(var2);
      super.a(var1, var2);
   }

   protected void a(ItemStack var1, int var2) {
      this.b += var2;
      this.c(var1);
   }

   protected void c(ItemStack var1) {
      var1.a(this.a.o, this.a, this.b);
      if(!this.a.o.D) {
         int var2 = this.b;
         float var3 = class_aco.a().b(var1);
         int var4;
         if(var3 == 0.0F) {
            var2 = 0;
         } else if(var3 < 1.0F) {
            var4 = MathHelper.floor((float)var2 * var3);
            if(var4 < MathHelper.ceil((float)var2 * var3) && Math.random() < (double)((float)var2 * var3 - (float)var4)) {
               ++var4;
            }

            var2 = var4;
         }

         while(var2 > 0) {
            var4 = class_px.a(var2);
            var2 -= var4;
            this.a.o.a((class_pr)(new class_px(this.a.o, this.a.s, this.a.t + 0.5D, this.a.u + 0.5D, var4)));
         }
      }

      this.b = 0;
      if(var1.getItem() == Items.l) {
         this.a.b((class_my)class_mt.k);
      }

      if(var1.getItem() == Items.aX) {
         this.a.b((class_my)class_mt.p);
      }

   }
}
