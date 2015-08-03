package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.List;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.BlockContainer;
import net.minecraft.server.Block;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityHopper;
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
import net.minecraft.server.StatisticList;
import net.minecraft.server.IInventory;
import net.minecraft.server.class_ol;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;
import net.minecraft.server.CreativeTab;

public class BlockHopper extends BlockContainer {
   public static final BlockStateDirection a = BlockStateDirection.of("facing", new Predicate() {
      public boolean a(EnumDirection var1) {
         return var1 != EnumDirection.UP;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((EnumDirection)var1);
      }
   });
   public static final BlockStateBoolean b = BlockStateBoolean.of("enabled");

   public BlockHopper() {
      super(Material.ORE, MaterialMapColor.COLOR12);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.DOWN).set(b, Boolean.valueOf(true)));
      this.setCreativeTab(CreativeTab.REDSTONE);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void addBBIfInsideInputBB(World var1, BlockPosition var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      float var7 = 0.125F;
      this.setSizes(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      this.setSizes(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      this.setSizes(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      EnumDirection var9 = var3.opposite();
      if(var9 == EnumDirection.UP) {
         var9 = EnumDirection.DOWN;
      }

      return this.getBlockData().set(a, var9).set(b, Boolean.valueOf(true));
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityHopper();
   }

   public void postPlace(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      super.postPlace(var1, var2, var3, var4, var5);
      if(var5.hasDisplayName()) {
         TileEntity var6 = var1.getTileEntity(var2);
         if(var6 instanceof TileEntityHopper) {
            ((TileEntityHopper)var6).a(var5.getDisplayName());
         }
      }

   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      this.e(var1, var2, var3);
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.isClientSide) {
         return true;
      } else {
         TileEntity var11 = var1.getTileEntity(var2);
         if(var11 instanceof TileEntityHopper) {
            var4.openContainer((IInventory)((TileEntityHopper)var11));
            var4.b(StatisticList.P);
         }

         return true;
      }
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   private void e(World var1, BlockPosition var2, IBlockData var3) {
      boolean var4 = !var1.isBlockIndirectlyPowered(var2);
      if(var4 != ((Boolean)var3.get(b)).booleanValue()) {
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(b, Boolean.valueOf(var4)), 4);
      }

   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      TileEntity var4 = var1.getTileEntity(var2);
      if(var4 instanceof TileEntityHopper) {
         class_ol.a(var1, (BlockPosition)var2, (TileEntityHopper)var4);
         var1.e(var2, this);
      }

      super.remove(var1, var2, var3);
   }

   public int getRenderType() {
      return 3;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public static EnumDirection b(int var0) {
      return EnumDirection.getById(var0 & 7);
   }

   public static boolean f(int var0) {
      return (var0 & 8) != 8;
   }

   public boolean isComplexRedstone() {
      return true;
   }

   public int getRedstonePower(World var1, BlockPosition var2) {
      return Container.a(var1.getTileEntity(var2));
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, b(var1)).set(b, Boolean.valueOf(f(var1)));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(a)).getId();
      if(!((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 8;
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
}
