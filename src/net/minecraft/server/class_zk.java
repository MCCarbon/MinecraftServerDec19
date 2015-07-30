package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Material;
import net.minecraft.server.class_awg;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_nc;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_zk extends Item {
   public class_zk() {
      this.a(CreativeTab.k);
   }

   public class_or a(class_aas var1, World var2, class_xa var3, EnumUsedHand var4) {
      class_awg var5 = this.a(var2, var3, true);
      if(var5 == null) {
         return new class_or(class_oq.b, var1);
      } else {
         if(var5.a == class_awg.class_a_in_class_awg.b) {
            BlockPosition var6 = var5.a();
            if(!var2.a(var3, var6)) {
               return new class_or(class_oq.b, var1);
            }

            if(!var3.a(var6.shift(var5.b), var5.b, var1)) {
               return new class_or(class_oq.b, var1);
            }

            if(var2.p(var6).getBlock().getMaterial() == Material.WATER) {
               --var1.b;
               var3.b(class_nc.ad[Item.getId((Item)this)]);
               if(var1.b <= 0) {
                  return new class_or(class_oq.a, new class_aas(Items.bB));
               }

               if(!var3.bp.a(new class_aas(Items.bB))) {
                  var3.a(new class_aas(Items.bB), false);
               }

               return new class_or(class_oq.a, var1);
            }
         }

         return new class_or(class_oq.b, var1);
      }
   }
}
