package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_ud;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_abi extends Item {
   public class_abi() {
      this.h = 1;
      this.a(CreativeTab.TRANSPORTATION);
   }

   public boolean a(ItemStack var1, EntityHuman var2, EntityLiving var3, EnumUsedHand var4) {
      if(var3 instanceof class_ud) {
         class_ud var5 = (class_ud)var3;
         if(!var5.cA() && !var5.j_()) {
            var5.m(true);
            var5.o.a((Entity)var5, "mob.horse.leather", 0.5F, 1.0F);
            --var1.count;
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
      this.a(var1, (EntityHuman)null, var2, EnumUsedHand.MAIN_HAND);
      return true;
   }
}
