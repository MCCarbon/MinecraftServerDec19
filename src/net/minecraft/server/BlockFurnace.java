package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.BlockContainer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockDirectional;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityFurnace;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateDirection;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.StatisticList;
import net.minecraft.server.IInventory;
import net.minecraft.server.class_ol;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;

public class BlockFurnace extends BlockContainer {
   public static final BlockStateDirection a;
   private final boolean b;
   private static boolean N;

   protected BlockFurnace(boolean var1) {
      super(Material.STONE);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH));
      this.b = var1;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getItemOf(Blocks.FURNACE);
   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      this.e(var1, var2, var3);
   }

   private void e(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.isClientSide) {
         Block var4 = var1.getType(var2.north()).getBlock();
         Block var5 = var1.getType(var2.south()).getBlock();
         Block var6 = var1.getType(var2.west()).getBlock();
         Block var7 = var1.getType(var2.east()).getBlock();
         EnumDirection var8 = (EnumDirection)var3.get(a);
         if(var8 == EnumDirection.NORTH && var4.isFullBlock() && !var5.isFullBlock()) {
            var8 = EnumDirection.SOUTH;
         } else if(var8 == EnumDirection.SOUTH && var5.isFullBlock() && !var4.isFullBlock()) {
            var8 = EnumDirection.NORTH;
         } else if(var8 == EnumDirection.WEST && var6.isFullBlock() && !var7.isFullBlock()) {
            var8 = EnumDirection.EAST;
         } else if(var8 == EnumDirection.EAST && var7.isFullBlock() && !var6.isFullBlock()) {
            var8 = EnumDirection.WEST;
         }

         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, var8), 2);
      }
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.isClientSide) {
         return true;
      } else {
         TileEntity var11 = var1.getTileEntity(var2);
         if(var11 instanceof TileEntityFurnace) {
            var4.openContainer((IInventory)((TileEntityFurnace)var11));
            var4.b(StatisticList.Y);
         }

         return true;
      }
   }

   public static void a(boolean var0, World var1, BlockPosition var2) {
      IBlockData var3 = var1.getType(var2);
      TileEntity var4 = var1.getTileEntity(var2);
      N = true;
      if(var0) {
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)Blocks.LIT_FURNACE.getBlockData().set(a, var3.get(a)), 3);
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)Blocks.LIT_FURNACE.getBlockData().set(a, var3.get(a)), 3);
      } else {
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)Blocks.FURNACE.getBlockData().set(a, var3.get(a)), 3);
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)Blocks.FURNACE.getBlockData().set(a, var3.get(a)), 3);
      }

      N = false;
      if(var4 != null) {
         var4.setValid();
         var1.a(var2, var4);
      }

   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityFurnace();
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.getBlockData().set(a, var8.aR().opposite());
   }

   public void postPlace(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, var4.aR().opposite()), 2);
      if(var5.hasDisplayName()) {
         TileEntity var6 = var1.getTileEntity(var2);
         if(var6 instanceof TileEntityFurnace) {
            ((TileEntityFurnace)var6).a(var5.getDisplayName());
         }
      }

   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      if(!N) {
         TileEntity var4 = var1.getTileEntity(var2);
         if(var4 instanceof TileEntityFurnace) {
            class_ol.a(var1, (BlockPosition)var2, (TileEntityFurnace)var4);
            var1.updateAdjacentComparators(var2, this);
         }
      }

      super.remove(var1, var2, var3);
   }

   public boolean isComplexRedstone() {
      return true;
   }

   public int getRedstonePower(World var1, BlockPosition var2) {
      return Container.a(var1.getTileEntity(var2));
   }

   public int getRenderType() {
      return 3;
   }

   public IBlockData fromLegacyData(int var1) {
      EnumDirection var2 = EnumDirection.getById(var1);
      if(var2.getAxis() == EnumDirection.EnumAxis.Y) {
         var2 = EnumDirection.NORTH;
      }

      return this.getBlockData().set(a, var2);
   }

   public int toLegacyData(IBlockData var1) {
      return ((EnumDirection)var1.get(a)).getId();
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(a)));
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   static {
      a = BlockDirectional.FACING;
   }
}
