package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.BlockContainer;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityEnderPortal;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.Entity;

public class class_ahs extends BlockContainer {
   protected class_ahs(Material var1) {
      super(var1);
      this.setLightLevel(1.0F);
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityEnderPortal();
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      float var3 = 0.0625F;
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
   }

   public void addBBIfInsideInputBB(World var1, BlockPosition var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public int getDropCount(Random var1) {
      return 0;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Entity var4) {
      if(var4.m == null && var4.l == null && !var1.isClientSide) {
         var4.c(1);
      }

   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.COLOR30;
   }
}
