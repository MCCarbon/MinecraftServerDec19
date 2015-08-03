package net.minecraft.server;

import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockPlant;
import net.minecraft.server.BlockFluids;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.Entity;
import net.minecraft.server.class_vk;
import net.minecraft.server.CreativeTab;

public class class_alx extends BlockPlant {
   protected class_alx() {
      float var1 = 0.5F;
      float var2 = 0.015625F;
      this.setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
      this.setCreativeTab(CreativeTab.DECORATIONS);
   }

   public void addBBIfInsideInputBB(World var1, BlockPosition var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      if(var6 == null || !(var6 instanceof class_vk)) {
         super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      }

   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      return new AxisAlignedBB((double)var2.getX() + this.minX, (double)var2.getY() + this.minY, (double)var2.getZ() + this.minZ, (double)var2.getX() + this.maxX, (double)var2.getY() + this.maxY, (double)var2.getZ() + this.maxZ);
   }

   protected boolean c(Block var1) {
      return var1 == Blocks.WATER;
   }

   public boolean f(World var1, BlockPosition var2, IBlockData var3) {
      if(var2.getY() >= 0 && var2.getY() < 256) {
         IBlockData var4 = var1.getType(var2.down());
         return var4.getBlock().getMaterial() == Material.WATER && ((Integer)var4.get(BlockFluids.LEVEL)).intValue() == 0;
      } else {
         return false;
      }
   }

   public int toLegacyData(IBlockData var1) {
      return 0;
   }
}
