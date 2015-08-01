package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.class_nc;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xp;
import net.minecraft.server.CreativeTab;

public class class_aab extends Item {
   public class_aab() {
      this.h = 16;
      this.a(CreativeTab.l);
   }

   public class_or a(ItemStack var1, World var2, class_xa var3, EnumUsedHand var4) {
      if(!var3.bH.instabuild) {
         --var1.count;
      }

      var2.a((class_pr)var3, "random.bow", 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
      if(!var2.D) {
         class_xp var5 = new class_xp(var2, var3);
         var5.a(var3.z, var3.y, 0.0F, 1.5F, 1.0F);
         var2.a((class_pr)var5);
      }

      var3.b(class_nc.ad[Item.getId((Item)this)]);
      return new class_or(class_oq.a, var1);
   }
}
