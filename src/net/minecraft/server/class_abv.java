package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_abe;
import net.minecraft.server.World;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.StatisticList;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.UseResult;
import net.minecraft.server.class_or;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_xs;

public class class_abv extends class_abe {
   public String getLocalizedName(ItemStack var1) {
      return LocaleI18n.get("splash_" + i(var1).a());
   }

   public class_or a(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      if(!var3.abilities.instabuild) {
         --var1.count;
      }

      var2.a((Entity)var3, "random.bow", 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
      if(!var2.isClientSide) {
         class_xs var5 = new class_xs(var2, var3, var1);
         var5.a(var3.z, var3.y, -20.0F, 0.5F, 1.0F);
         var2.addEntity((Entity)var5);
      }

      var3.b(StatisticList.ad[Item.getId((Item)this)]);
      return new class_or(UseResult.SUCCESS, var1);
   }
}
