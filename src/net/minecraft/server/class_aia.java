package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.BlockDirectional;
import net.minecraft.server.BlockWood;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateBoolean;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_aia extends BlockDirectional {
   public static final BlockStateBoolean a = BlockStateBoolean.of("open");
   public static final BlockStateBoolean b = BlockStateBoolean.of("powered");
   public static final BlockStateBoolean N = BlockStateBoolean.of("in_wall");

   public class_aia(BlockWood.EnumLogVariant var1) {
      super(Material.WOOD, var1.getMapColor());
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)));
      this.setCreativeTab(CreativeTab.REDSTONE);
   }

   public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
      EnumDirection.EnumAxis var4 = ((EnumDirection)var1.get(FACING)).getAxis();
      if(var4 == EnumDirection.EnumAxis.Z && (var2.getType(var3.west()).getBlock() == BlockStainedGlassPane.COBBLESTONE_WALL || var2.getType(var3.east()).getBlock() == BlockStainedGlassPane.COBBLESTONE_WALL) || var4 == EnumDirection.EnumAxis.X && (var2.getType(var3.north()).getBlock() == BlockStainedGlassPane.COBBLESTONE_WALL || var2.getType(var3.south()).getBlock() == BlockStainedGlassPane.COBBLESTONE_WALL)) {
         var1 = var1.set(N, Boolean.valueOf(true));
      }

      return var1;
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      return var1.getBlock() != this?var1:var1.set(FACING, var2.a((EnumDirection)var1.get(FACING)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(FACING)));
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      return var1.getType(var2.down()).getBlock().getMaterial().isBuildable()?super.canPlace(var1, var2):false;
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      if(((Boolean)var3.get(a)).booleanValue()) {
         return null;
      } else {
         EnumDirection.EnumAxis var4 = ((EnumDirection)var3.get(FACING)).getAxis();
         return var4 == EnumDirection.EnumAxis.Z?new AxisAlignedBB((double)var2.getX(), (double)var2.getY(), (double)((float)var2.getZ() + 0.375F), (double)(var2.getX() + 1), (double)((float)var2.getY() + 1.5F), (double)((float)var2.getZ() + 0.625F)):new AxisAlignedBB((double)((float)var2.getX() + 0.375F), (double)var2.getY(), (double)var2.getZ(), (double)((float)var2.getX() + 0.625F), (double)((float)var2.getY() + 1.5F), (double)(var2.getZ() + 1));
      }
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      EnumDirection.EnumAxis var3 = ((EnumDirection)var1.getType(var2).get(FACING)).getAxis();
      if(var3 == EnumDirection.EnumAxis.Z) {
         this.setSizes(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
      } else {
         this.setSizes(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
      }

   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isPassable(IBlockAccess var1, BlockPosition var2) {
      return ((Boolean)var1.getType(var2).get(a)).booleanValue();
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.getBlockData().set(FACING, var8.aR()).set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false));
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(((Boolean)var3.get(a)).booleanValue()) {
         var3 = var3.set(a, Boolean.valueOf(false));
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 2);
      } else {
         EnumDirection var11 = EnumDirection.fromAngle((double)var4.y);
         if(var3.get(FACING) == var11.opposite()) {
            var3 = var3.set(FACING, var11);
         }

         var3 = var3.set(a, Boolean.valueOf(true));
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 2);
      }

      var1.a(var4, ((Boolean)var3.get(a)).booleanValue()?1003:1006, var2, 0);
      return true;
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!var1.isClientSide) {
         boolean var5 = var1.isBlockIndirectlyPowered(var2);
         if(var5 || var4.isPowerSource()) {
            if(var5 && !((Boolean)var3.get(a)).booleanValue() && !((Boolean)var3.get(b)).booleanValue()) {
               var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(true)).set(b, Boolean.valueOf(true)), 2);
               var1.a((EntityHuman)null, 1003, var2, 0);
            } else if(!var5 && ((Boolean)var3.get(a)).booleanValue() && ((Boolean)var3.get(b)).booleanValue()) {
               var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)), 2);
               var1.a((EntityHuman)null, 1006, var2, 0);
            } else if(var5 != ((Boolean)var3.get(b)).booleanValue()) {
               var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(b, Boolean.valueOf(var5)), 2);
            }
         }

      }
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(FACING, EnumDirection.getByHorizontalId(var1)).set(a, Boolean.valueOf((var1 & 4) != 0)).set(b, Boolean.valueOf((var1 & 8) != 0));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(FACING)).getHorizontalId();
      if(((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 8;
      }

      if(((Boolean)var1.get(a)).booleanValue()) {
         var3 |= 4;
      }

      return var3;
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{FACING, a, b, N});
   }
}
