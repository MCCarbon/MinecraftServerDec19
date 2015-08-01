package net.minecraft.server;

import net.minecraft.server.class_adi;
import net.minecraft.server.class_adj;
import net.minecraft.server.Enchantment;
import net.minecraft.server.class_pw;

public class class_adq extends class_adi {
   protected class_adq(class_adi.class_a_in_class_adi var1, class_adj var2, class_pw... var3) {
      super(var1, var2, var3);
      if(var2 == class_adj.h) {
         this.c("lootBonusDigger");
      } else if(var2 == class_adj.i) {
         this.c("lootBonusFishing");
      } else {
         this.c("lootBonus");
      }

   }

   public int a(int var1) {
      return 15 + (var1 - 1) * 9;
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 3;
   }

   public boolean a(class_adi var1) {
      return super.a(var1) && var1 != Enchantment.q;
   }
}
