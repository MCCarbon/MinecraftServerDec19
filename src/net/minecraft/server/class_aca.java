package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_abx;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ajd;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.class_awg;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_nc;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_xa;

public class class_aca extends class_abx {
   public class_aca(Block var1) {
      super(var1, false);
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

            BlockPosition var7 = var6.shiftUp();
            IBlockData var8 = var2.p(var6);
            if(var8.getBlock().getMaterial() == Material.WATER && ((Integer)var8.get(class_ajd.b)).intValue() == 0 && var2.d(var7)) {
               var2.a(var7, Blocks.WATERLILY.getBlockData());
               if(!var3.bH.d) {
                  --var1.b;
               }

               var3.b(class_nc.ad[Item.getId((Item)this)]);
               return new class_or(class_oq.a, var1);
            }
         }

         return new class_or(class_oq.b, var1);
      }
   }
}
