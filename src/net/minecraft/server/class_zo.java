package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_nc;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_ud;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_zo extends Item {
   public class_zo() {
      this.a(CreativeTab.e);
      this.d(1);
      this.e(25);
   }

   public class_or a(class_aas var1, World var2, class_xa var3, EnumUsedHand var4) {
      if(var3.aw() && var3.m instanceof class_ud) {
         class_ud var5 = (class_ud)var3.m;
         if(var5.cB().h() && var1.j() - var1.i() >= 7) {
            var5.cB().g();
            var1.a(7, (class_qa)var3);
            if(var1.b == 0) {
               class_aas var6 = new class_aas(Items.aT);
               var6.d(var1.o());
               return new class_or(class_oq.a, var6);
            }

            return new class_or(class_oq.a, var1);
         }
      }

      var3.b(class_nc.ad[Item.getId((Item)this)]);
      return new class_or(class_oq.b, var1);
   }
}
