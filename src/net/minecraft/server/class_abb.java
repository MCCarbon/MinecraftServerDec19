package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_abb extends Item {
   public class_abb() {
      this.a(CreativeTab.i);
   }

   public boolean a(ItemStack var1, class_xa var2, class_qa var3, EnumUsedHand var4) {
      if(!var1.hasDisplayName()) {
         return false;
      } else if(var3 instanceof class_qb) {
         class_qb var5 = (class_qb)var3;
         var5.a((String)var1.getDisplayName());
         var5.cl();
         --var1.count;
         return true;
      } else {
         return super.a(var1, var2, var3, var4);
      }
   }
}
