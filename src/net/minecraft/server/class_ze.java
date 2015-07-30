package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ale;
import net.minecraft.server.class_alw;
import net.minecraft.server.class_ame;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.class_dn;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.ItemBlock;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zy;

public class class_ze extends ItemBlock {
   public class_ze() {
      super(Blocks.STANDING_BANNER);
      this.h = 16;
      this.a(CreativeTab.c);
      this.a(true);
      this.e(0);
   }

   public class_oq a(class_aas var1, class_xa var2, World var3, BlockPosition var4, class_oo var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 == EnumDirection.DOWN) {
         return class_oq.b;
      } else if(!var3.p(var4).getBlock().getMaterial().isBuildable()) {
         return class_oq.b;
      } else {
         var4 = var4.shift(var6);
         if(!var2.a(var4, var6, var1)) {
            return class_oq.b;
         } else if(!Blocks.STANDING_BANNER.d(var3, var4)) {
            return class_oq.b;
         } else if(var3.D) {
            return class_oq.a;
         } else {
            if(var6 == EnumDirection.UP) {
               int var10 = MathHelper.floor((double)((var2.y + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
               var3.a((BlockPosition)var4, (IBlockData)Blocks.STANDING_BANNER.getBlockData().set(class_ale.a, Integer.valueOf(var10)), 3);
            } else {
               var3.a((BlockPosition)var4, (IBlockData)Blocks.WALL_BANNER.getBlockData().set(class_alw.a, var6), 3);
            }

            --var1.b;
            class_amg var11 = var3.s(var4);
            if(var11 instanceof class_ame) {
               ((class_ame)var11).a(var1);
            }

            return class_oq.a;
         }
      }
   }

   public String a(class_aas var1) {
      String var2 = "item.banner.";
      class_zy var3 = this.h(var1);
      var2 = var2 + var3.d() + ".name";
      return LocaleI18n.get(var2);
   }

   private class_zy h(class_aas var1) {
      class_dn var2 = var1.a("BlockEntityTag", false);
      class_zy var3 = null;
      if(var2 != null && var2.d("Base")) {
         var3 = class_zy.a(var2.g("Base"));
      } else {
         var3 = class_zy.a(var1.i());
      }

      return var3;
   }
}
