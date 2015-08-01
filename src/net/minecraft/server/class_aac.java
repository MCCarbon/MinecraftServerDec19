package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_avf;
import net.minecraft.server.StatisticList;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_zt;
import net.minecraft.server.CreativeTab;

public class class_aac extends class_zt {
   protected class_aac() {
      this.a(CreativeTab.MISC);
   }

   public class_or a(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      ItemStack var5 = new ItemStack(Items.bf, 1, var2.b("map"));
      String var6 = "map_" + var5.i();
      class_avf var7 = new class_avf(var6);
      var2.a((String)var6, (class_avd)var7);
      var7.e = 0;
      var7.a(var3.s, var3.u, var7.e);
      var7.d = (byte)var2.worldProvider.p().a();
      var7.c();
      --var1.count;
      if(var1.count <= 0) {
         return new class_or(class_oq.a, var5);
      } else {
         if(!var3.bp.a(var5.clone())) {
            var3.a(var5, false);
         }

         var3.b(StatisticList.ad[Item.getId((Item)this)]);
         return new class_or(class_oq.a, var1);
      }
   }
}
