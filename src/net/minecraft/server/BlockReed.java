package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class BlockReed extends Block {
   public static final BlockStateInteger a = BlockStateInteger.of("age", 0, 15);

   protected BlockReed() {
      super(Material.PLANT);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
      float var1 = 0.375F;
      this.setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 1.0F, 0.5F + var1);
      this.setTicking(true);
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(var1.getType(var2.down()).getBlock() == Blocks.REEDS || this.e(var1, var2, var3)) {
         if(var1.isEmpty(var2.up())) {
            int var5;
            for(var5 = 1; var1.getType(var2.down(var5)).getBlock() == this; ++var5) {
               ;
            }

            if(var5 < 3) {
               int var6 = ((Integer)var3.get(a)).intValue();
               if(var6 == 15) {
                  var1.setTypeUpdate(var2.up(), this.getBlockData());
                  var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(0)), 4);
               } else {
                  var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(var6 + 1)), 4);
               }
            }
         }

      }
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      Block var3 = var1.getType(var2.down()).getBlock();
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
         } while(var1.getType(var2.shift(var5).down()).getBlock().getMaterial() != Material.WATER);

         return true;
      }
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   protected final boolean e(World var1, BlockPosition var2, IBlockData var3) {
      if(this.e(var1, var2)) {
         return true;
      } else {
         this.dropNaturallyForSure(var1, var2, var3, 0);
         var1.setAir(var2);
         return false;
      }
   }

   public boolean e(World var1, BlockPosition var2) {
      return this.canPlace(var1, var2);
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      return null;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.REEDS;
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

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
