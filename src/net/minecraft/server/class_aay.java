package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_abz;
import net.minecraft.server.World;
import net.minecraft.server.StatisticList;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.UseResult;
import net.minecraft.server.class_or;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_aay extends Item {
   public class_aay() {
      this.d(1);
      this.a(CreativeTab.MISC);
   }

   public ItemStack a(ItemStack var1, World var2, EntityLiving var3) {
      if(var3 instanceof EntityHuman && !((EntityHuman)var3).abilities.instabuild) {
         --var1.count;
      }

      if(!var2.isClientSide) {
         var3.bl();
      }

      if(var3 instanceof EntityHuman) {
         ((EntityHuman)var3).b(StatisticList.ad[Item.getId((Item)this)]);
      }

      return var1.count <= 0?new ItemStack(Items.ay):var1;
   }

   public int e(ItemStack var1) {
      return 32;
   }

   public class_abz f(ItemStack var1) {
      return class_abz.DRINK;
   }

   public class_or a(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      var3.c(var4);
      return new class_or(UseResult.SUCCESS, var1);
   }
}
