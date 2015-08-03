package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateInteger;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.CreativeTab;

public class BlockCactus extends Block {
   public static final BlockStateInteger a = BlockStateInteger.of("age", 0, 15);

   protected BlockCactus() {
      super(Material.CACTUS);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
      this.setTicking(true);
      this.setCreativeTab(CreativeTab.DECORATIONS);
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      BlockPosition var5 = var2.up();
      if(var1.isEmpty(var5)) {
         int var6;
         for(var6 = 1; var1.getType(var2.down(var6)).getBlock() == this; ++var6) {
            ;
         }

         if(var6 < 3) {
            int var7 = ((Integer)var3.get(a)).intValue();
            if(var7 == 15) {
               var1.setTypeUpdate(var5, this.getBlockData());
               IBlockData var8 = var3.set(a, Integer.valueOf(0));
               var1.setTypeAndData((BlockPosition)var2, (IBlockData)var8, 4);
               this.doPhysics(var1, var5, var8, (Block)this);
            } else {
               var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(var7 + 1)), 4);
            }

         }
      }
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      float var4 = 0.0625F;
      return new AxisAlignedBB((double)((float)var2.getX() + var4), (double)var2.getY(), (double)((float)var2.getZ() + var4), (double)((float)(var2.getX() + 1) - var4), (double)((float)(var2.getY() + 1) - var4), (double)((float)(var2.getZ() + 1) - var4));
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      return super.canPlace(var1, var2)?this.e(var1, var2):false;
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!this.e(var1, var2)) {
         var1.setAir(var2, true);
      }

   }

   public boolean e(World var1, BlockPosition var2) {
      Iterator var3 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

      while(var3.hasNext()) {
         EnumDirection var4 = (EnumDirection)var3.next();
         if(var1.getType(var2.shift(var4)).getBlock().getMaterial().isBuildable()) {
            return false;
         }
      }

      Block var5 = var1.getType(var2.down()).getBlock();
      return var5 == BlockStainedGlassPane.CACTUS || var5 == BlockStainedGlassPane.SAND;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Entity var4) {
      var4.a(class_pc.h, 1.0F);
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
