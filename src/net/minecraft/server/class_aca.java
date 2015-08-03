package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_abx;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.BlockFluids;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.StatisticList;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.EntityHuman;

public class class_aca extends class_abx {
   public class_aca(Block var1) {
      super(var1, false);
   }

   public class_or a(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      MovingObjectPosition var5 = this.a(var2, var3, true);
      if(var5 == null) {
         return new class_or(class_oq.b, var1);
      } else {
         if(var5.a == MovingObjectPosition.class_a_in_class_awg.b) {
            BlockPosition var6 = var5.a();
            if(!var2.a(var3, var6)) {
               return new class_or(class_oq.b, var1);
            }

            if(!var3.a(var6.shift(var5.b), var5.b, var1)) {
               return new class_or(class_oq.b, var1);
            }

            BlockPosition var7 = var6.up();
            IBlockData var8 = var2.getType(var6);
            if(var8.getBlock().getMaterial() == Material.WATER && ((Integer)var8.get(BlockFluids.LEVEL)).intValue() == 0 && var2.isEmpty(var7)) {
               var2.setTypeUpdate(var7, BlockStainedGlassPane.WATERLILY.getBlockData());
               if(!var3.bH.instabuild) {
                  --var1.count;
               }

               var3.b(StatisticList.ad[Item.getId((Item)this)]);
               return new class_or(class_oq.a, var1);
            }
         }

         return new class_or(class_oq.b, var1);
      }
   }
}
