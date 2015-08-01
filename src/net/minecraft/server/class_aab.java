package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.StatisticList;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_xp;
import net.minecraft.server.CreativeTab;

public class class_aab extends Item {
   public class_aab() {
      this.h = 16;
      this.a(CreativeTab.MATERIALS);
   }

   public class_or a(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      if(!var3.bH.instabuild) {
         --var1.count;
      }

      var2.a((Entity)var3, "random.bow", 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
      if(!var2.isClientSide) {
         class_xp var5 = new class_xp(var2, var3);
         var5.a(var3.z, var3.y, 0.0F, 1.5F, 1.0F);
         var2.addEntity((Entity)var5);
      }

      var3.b(StatisticList.ad[Item.getId((Item)this)]);
      return new class_or(class_oq.a, var1);
   }
}
