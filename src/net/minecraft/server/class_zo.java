package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.StatisticList;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_ud;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_zo extends Item {
   public class_zo() {
      this.a(CreativeTab.TRANSPORTATION);
      this.d(1);
      this.e(25);
   }

   public class_or a(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      if(var3.aw() && var3.vehicle instanceof class_ud) {
         class_ud var5 = (class_ud)var3.vehicle;
         if(var5.cB().h() && var1.j() - var1.i() >= 7) {
            var5.cB().g();
            var1.a(7, (EntityLiving)var3);
            if(var1.count == 0) {
               ItemStack var6 = new ItemStack(Items.aT);
               var6.setTag(var1.getTag());
               return new class_or(class_oq.a, var6);
            }

            return new class_or(class_oq.a, var1);
         }
      }

      var3.b(StatisticList.ad[Item.getId((Item)this)]);
      return new class_or(class_oq.b, var1);
   }
}
