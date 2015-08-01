package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockPlant;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateInteger;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.CreativeTab;

public class class_ajl extends BlockPlant {
   public static final BlockStateInteger a = BlockStateInteger.of("age", 0, 3);

   protected class_ajl() {
      super(Material.PLANT, MaterialMapColor.COLOR29);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
      this.setTicking(true);
      float var1 = 0.5F;
      this.setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
      this.setCreativeTab((CreativeTab)null);
   }

   protected boolean c(Block var1) {
      return var1 == Blocks.SOUL_SAND;
   }

   public boolean f(World var1, BlockPosition var2, IBlockData var3) {
      return this.c(var1.getType(var2.down()).getBlock());
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      int var5 = ((Integer)var3.get(a)).intValue();
      if(var5 < 3 && var4.nextInt(10) == 0) {
         var3 = var3.set(a, Integer.valueOf(var5 + 1));
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 2);
      }

      super.tick(var1, var2, var3, var4);
   }

   public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
      if(!var1.isClientSide) {
         int var6 = 1;
         if(((Integer)var3.get(a)).intValue() >= 3) {
            var6 = 2 + var1.random.nextInt(3);
            if(var5 > 0) {
               var6 += var1.random.nextInt(var5 + 1);
            }
         }

         for(int var7 = 0; var7 < var6; ++var7) {
            dropItem(var1, var2, new ItemStack(Items.bA));
         }

      }
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return null;
   }

   public int getDropCount(Random var1) {
      return 0;
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
