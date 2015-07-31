package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_abz;
import net.minecraft.server.World;
import net.minecraft.server.class_nc;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_aay extends Item {
   public class_aay() {
      this.d(1);
      this.a(CreativeTab.f);
   }

   public ItemStack a(ItemStack var1, World var2, class_qa var3) {
      if(var3 instanceof class_xa && !((class_xa)var3).bH.d) {
         --var1.count;
      }

      if(!var2.D) {
         var3.bl();
      }

      if(var3 instanceof class_xa) {
         ((class_xa)var3).b(class_nc.ad[Item.getId((Item)this)]);
      }

      return var1.count <= 0?new ItemStack(Items.ay):var1;
   }

   public int e(ItemStack var1) {
      return 32;
   }

   public class_abz f(ItemStack var1) {
      return class_abz.DRINK;
   }

   public class_or a(ItemStack var1, World var2, class_xa var3, EnumUsedHand var4) {
      var3.c(var4);
      return new class_or(class_oq.a, var1);
   }
}
