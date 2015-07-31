package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.class_agf;
import net.minecraft.server.class_ahk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_ck;
import net.minecraft.server.class_cn;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_cr;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_aaz extends Item {
   private static final class_cr a = new class_cn() {
      private final class_cn b = new class_cn();

      public ItemStack b(class_ck var1, ItemStack var2) {
         EnumDirection var3 = class_ahk.b(var1.f());
         World var4 = var1.i();
         double var5 = var1.a() + (double)var3.getAdjacentX() * 1.125D;
         double var7 = Math.floor(var1.b()) + (double)var3.getAdjacentY();
         double var9 = var1.c() + (double)var3.getAdjacentZ() * 1.125D;
         BlockPosition var11 = var1.d().shift(var3);
         IBlockData var12 = var4.p(var11);
         class_agf.class_b_in_class_agf var13 = var12.getBlock() instanceof class_agf?(class_agf.class_b_in_class_agf)var12.get(((class_agf)var12.getBlock()).n()):class_agf.class_b_in_class_agf.a;
         double var14;
         if(class_agf.d(var12)) {
            if(var13.c()) {
               var14 = 0.6D;
            } else {
               var14 = 0.1D;
            }
         } else {
            if(var12.getBlock().getMaterial() != Material.AIR || !class_agf.d(var4.p(var11.shiftDown()))) {
               return this.b.a(var1, var2);
            }

            IBlockData var16 = var4.p(var11.shiftDown());
            class_agf.class_b_in_class_agf var17 = var16.getBlock() instanceof class_agf?(class_agf.class_b_in_class_agf)var16.get(((class_agf)var16.getBlock()).n()):class_agf.class_b_in_class_agf.a;
            if(var3 != EnumDirection.DOWN && var17.c()) {
               var14 = -0.4D;
            } else {
               var14 = -0.9D;
            }
         }

         class_vn var18 = class_vn.a(var4, var5, var7 + var14, var9, ((class_aaz)var2.getItem()).b);
         if(var2.hasDisplayName()) {
            var18.a(var2.getDisplayName());
         }

         var4.a((class_pr)var18);
         var2.a(1);
         return var2;
      }

      protected void a(class_ck var1) {
         var1.i().b(1000, var1.d(), 0);
      }
   };
   private final class_vn.class_a_in_class_vn b;

   public class_aaz(class_vn.class_a_in_class_vn var1) {
      this.h = 1;
      this.b = var1;
      this.a(CreativeTab.e);
      class_ahk.N.register(this, a);
   }

   public class_oq a(ItemStack var1, class_xa var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      IBlockData var10 = var3.p(var4);
      if(class_agf.d(var10)) {
         if(!var3.D) {
            class_agf.class_b_in_class_agf var11 = var10.getBlock() instanceof class_agf?(class_agf.class_b_in_class_agf)var10.get(((class_agf)var10.getBlock()).n()):class_agf.class_b_in_class_agf.a;
            double var12 = 0.0D;
            if(var11.c()) {
               var12 = 0.5D;
            }

            class_vn var14 = class_vn.a(var3, (double)var4.getX() + 0.5D, (double)var4.getY() + 0.0625D + var12, (double)var4.getZ() + 0.5D, this.b);
            if(var1.hasDisplayName()) {
               var14.a(var1.getDisplayName());
            }

            var3.a((class_pr)var14);
         }

         --var1.count;
         return class_oq.a;
      } else {
         return class_oq.b;
      }
   }
}
