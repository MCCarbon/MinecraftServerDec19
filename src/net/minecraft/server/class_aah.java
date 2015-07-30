package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_aah extends Item {
   public class_aah() {
      this.a(CreativeTab.f);
   }

   public class_oq a(class_aas var1, class_xa var2, World var3, BlockPosition var4, class_oo var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var3.D) {
         return class_oq.a;
      } else {
         var4 = var4.shift(var6);
         if(!var2.a(var4, var6, var1)) {
            return class_oq.b;
         } else {
            if(var3.p(var4).getBlock().getMaterial() == Material.AIR) {
               var3.a((double)var4.getX() + 0.5D, (double)var4.getY() + 0.5D, (double)var4.getZ() + 0.5D, "item.fireCharge.use", 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
               var3.a(var4, Blocks.FIRE.getBlockData());
            }

            if(!var2.bH.d) {
               --var1.b;
            }

            return class_oq.a;
         }
      }
   }
}
