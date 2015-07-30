package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;

public class class_akn extends Block {
   public static final class_anz a = class_anz.a("age", 0, 15);

   protected class_akn() {
      super(Material.PLANT);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
      float var1 = 0.375F;
      this.setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 1.0F, 0.5F + var1);
      this.setTicking(true);
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(var1.p(var2.shiftDown()).getBlock() == Blocks.REEDS || this.e(var1, var2, var3)) {
         if(var1.d(var2.shiftUp())) {
            int var5;
            for(var5 = 1; var1.p(var2.shiftDown(var5)).getBlock() == this; ++var5) {
               ;
            }

            if(var5 < 3) {
               int var6 = ((Integer)var3.get(a)).intValue();
               if(var6 == 15) {
                  var1.a(var2.shiftUp(), this.getBlockData());
                  var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(0)), 4);
               } else {
                  var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(var6 + 1)), 4);
               }
            }
         }

      }
   }

   public boolean d(World var1, BlockPosition var2) {
      Block var3 = var1.p(var2.shiftDown()).getBlock();
      if(var3 == this) {
         return true;
      } else if(var3 != Blocks.GRASS && var3 != Blocks.DIRT && var3 != Blocks.SAND) {
         return false;
      } else {
         Iterator var4 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

         EnumDirection var5;
         do {
            if(!var4.hasNext()) {
               return false;
            }

            var5 = (EnumDirection)var4.next();
         } while(var1.p(var2.shift(var5).shiftDown()).getBlock().getMaterial() != Material.WATER);

         return true;
      }
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   protected final boolean e(World var1, BlockPosition var2, IBlockData var3) {
      if(this.e(var1, var2)) {
         return true;
      } else {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      }
   }

   public boolean e(World var1, BlockPosition var2) {
      return this.d(var1, var2);
   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
      return null;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.aL;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
