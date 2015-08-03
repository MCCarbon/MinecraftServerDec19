package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockDirectional;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateBoolean;
import net.minecraft.server.BlockStateDirection;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;

public class BlockEnderPortalFrame extends Block {
   public static final BlockStateDirection a;
   public static final BlockStateBoolean b;

   public BlockEnderPortalFrame() {
      super(Material.STONE, MaterialMapColor.COLOR28);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH).set(b, Boolean.valueOf(false)));
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public void j() {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
   }

   public void addBBIfInsideInputBB(World var1, BlockPosition var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      if(((Boolean)var1.getType(var2).get(b)).booleanValue()) {
         this.setSizes(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
         super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      }

      this.j();
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return null;
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.getBlockData().set(a, var8.aR().opposite()).set(b, Boolean.valueOf(false));
   }

   public boolean isComplexRedstone() {
      return true;
   }

   public int getRedstonePower(World var1, BlockPosition var2) {
      return ((Boolean)var1.getType(var2).get(b)).booleanValue()?15:0;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(b, Boolean.valueOf((var1 & 4) != 0)).set(a, EnumDirection.getByHorizontalId(var1 & 3));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(a)).getHorizontalId();
      if(((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 4;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(a)));
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b});
   }

   static {
      a = BlockDirectional.FACING;
      b = BlockStateBoolean.of("eye");
   }
}
