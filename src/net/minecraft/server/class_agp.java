package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahi;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateBoolean;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_xd;
import net.minecraft.server.CreativeTab;

public abstract class class_agp extends class_ahi {
   public static final BlockStateBoolean a = BlockStateBoolean.of("powered");
   private final boolean N;

   protected class_agp(boolean var1) {
      super(Material.ORIENTABLE);
      this.setBlockData(this.blockStateList.getFirst().set(FACING, EnumDirection.NORTH).set(a, Boolean.valueOf(false)));
      this.setTicking(true);
      this.setCreativeTab(CreativeTab.REDSTONE);
      this.N = var1;
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      return null;
   }

   public int tickInterval(World var1) {
      return this.N?30:20;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean canPlace(World var1, BlockPosition var2, EnumDirection var3) {
      return a(var1, var2, var3.opposite());
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      EnumDirection[] var3 = EnumDirection.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumDirection var6 = var3[var5];
         if(a(var1, var2, var6)) {
            return true;
         }
      }

      return false;
   }

   protected static boolean a(World var0, BlockPosition var1, EnumDirection var2) {
      BlockPosition var3 = var1.shift(var2);
      return var2 == EnumDirection.DOWN?World.a((IBlockAccess)var0, (BlockPosition)var3):var0.getType(var3).getBlock().isOccluding();
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return a(var1, var2, var3.opposite())?this.getBlockData().set(FACING, var3).set(a, Boolean.valueOf(false)):this.getBlockData().set(FACING, EnumDirection.DOWN).set(a, Boolean.valueOf(false));
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(this.e(var1, var2, var3) && !a(var1, var2, ((EnumDirection)var3.get(FACING)).opposite())) {
         this.dropNaturallyForSure(var1, var2, var3, 0);
         var1.setAir(var2);
      }

   }

   private boolean e(World var1, BlockPosition var2, IBlockData var3) {
      if(this.canPlace(var1, var2)) {
         return true;
      } else {
         this.dropNaturallyForSure(var1, var2, var3, 0);
         var1.setAir(var2);
         return false;
      }
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      this.d(var1.getType(var2));
   }

   private void d(IBlockData var1) {
      EnumDirection var2 = (EnumDirection)var1.get(FACING);
      boolean var3 = ((Boolean)var1.get(a)).booleanValue();
      float var4 = 0.25F;
      float var5 = 0.375F;
      float var6 = (float)(var3?1:2) / 16.0F;
      float var7 = 0.125F;
      float var8 = 0.1875F;
      switch(class_agp.SyntheticClass_1.a[var2.ordinal()]) {
      case 1:
         this.setSizes(0.0F, 0.375F, 0.3125F, var6, 0.625F, 0.6875F);
         break;
      case 2:
         this.setSizes(1.0F - var6, 0.375F, 0.3125F, 1.0F, 0.625F, 0.6875F);
         break;
      case 3:
         this.setSizes(0.3125F, 0.375F, 0.0F, 0.6875F, 0.625F, var6);
         break;
      case 4:
         this.setSizes(0.3125F, 0.375F, 1.0F - var6, 0.6875F, 0.625F, 1.0F);
         break;
      case 5:
         this.setSizes(0.3125F, 0.0F, 0.375F, 0.6875F, 0.0F + var6, 0.625F);
         break;
      case 6:
         this.setSizes(0.3125F, 1.0F - var6, 0.375F, 0.6875F, 1.0F, 0.625F);
      }

   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(((Boolean)var3.get(a)).booleanValue()) {
         return true;
      } else {
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(true)), 3);
         var1.b(var2, var2);
         var1.a((double)var2.getX() + 0.5D, (double)var2.getY() + 0.5D, (double)var2.getZ() + 0.5D, "random.click", 0.3F, 0.6F);
         this.c(var1, var2, (EnumDirection)var3.get(FACING));
         var1.a((BlockPosition)var2, (Block)this, this.tickInterval(var1));
         return true;
      }
   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      if(((Boolean)var3.get(a)).booleanValue()) {
         this.c(var1, var2, (EnumDirection)var3.get(FACING));
      }

      super.remove(var1, var2, var3);
   }

   public int a(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return ((Boolean)var3.get(a)).booleanValue()?15:0;
   }

   public int b(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return !((Boolean)var3.get(a)).booleanValue()?0:(var3.get(FACING) == var4?15:0);
   }

   public boolean isPowerSource() {
      return true;
   }

   public void randomTick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(!var1.isClientSide) {
         if(((Boolean)var3.get(a)).booleanValue()) {
            if(this.N) {
               this.f(var1, var2, var3);
            } else {
               var1.setTypeUpdate(var2, var3.set(a, Boolean.valueOf(false)));
               this.c(var1, var2, (EnumDirection)var3.get(FACING));
               var1.a((double)var2.getX() + 0.5D, (double)var2.getY() + 0.5D, (double)var2.getZ() + 0.5D, "random.click", 0.3F, 0.5F);
               var1.b(var2, var2);
            }

         }
      }
   }

   public void j() {
      float var1 = 0.1875F;
      float var2 = 0.125F;
      float var3 = 0.125F;
      this.setSizes(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Entity var4) {
      if(!var1.isClientSide) {
         if(this.N) {
            if(!((Boolean)var3.get(a)).booleanValue()) {
               this.f(var1, var2, var3);
            }
         }
      }
   }

   private void f(World var1, BlockPosition var2, IBlockData var3) {
      this.d(var3);
      List var4 = var1.getEntities(class_xd.class, new AxisAlignedBB((double)var2.getX() + this.minX, (double)var2.getY() + this.minY, (double)var2.getZ() + this.minZ, (double)var2.getX() + this.maxX, (double)var2.getY() + this.maxY, (double)var2.getZ() + this.maxZ));
      boolean var5 = !var4.isEmpty();
      boolean var6 = ((Boolean)var3.get(a)).booleanValue();
      if(var5 && !var6) {
         var1.setTypeUpdate(var2, var3.set(a, Boolean.valueOf(true)));
         this.c(var1, var2, (EnumDirection)var3.get(FACING));
         var1.b(var2, var2);
         var1.a((double)var2.getX() + 0.5D, (double)var2.getY() + 0.5D, (double)var2.getZ() + 0.5D, "random.click", 0.3F, 0.6F);
      }

      if(!var5 && var6) {
         var1.setTypeUpdate(var2, var3.set(a, Boolean.valueOf(false)));
         this.c(var1, var2, (EnumDirection)var3.get(FACING));
         var1.b(var2, var2);
         var1.a((double)var2.getX() + 0.5D, (double)var2.getY() + 0.5D, (double)var2.getZ() + 0.5D, "random.click", 0.3F, 0.5F);
      }

      if(var5) {
         var1.a((BlockPosition)var2, (Block)this, this.tickInterval(var1));
      }

   }

   private void c(World var1, BlockPosition var2, EnumDirection var3) {
      var1.c((BlockPosition)var2, (Block)this);
      var1.c((BlockPosition)var2.shift(var3.opposite()), (Block)this);
   }

   public IBlockData fromLegacyData(int var1) {
      EnumDirection var2;
      switch(var1 & 7) {
      case 0:
         var2 = EnumDirection.DOWN;
         break;
      case 1:
         var2 = EnumDirection.EAST;
         break;
      case 2:
         var2 = EnumDirection.WEST;
         break;
      case 3:
         var2 = EnumDirection.SOUTH;
         break;
      case 4:
         var2 = EnumDirection.NORTH;
         break;
      case 5:
      default:
         var2 = EnumDirection.UP;
      }

      return this.getBlockData().set(FACING, var2).set(a, Boolean.valueOf((var1 & 8) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      int var2;
      switch(class_agp.SyntheticClass_1.a[((EnumDirection)var1.get(FACING)).ordinal()]) {
      case 1:
         var2 = 1;
         break;
      case 2:
         var2 = 2;
         break;
      case 3:
         var2 = 3;
         break;
      case 4:
         var2 = 4;
         break;
      case 5:
      default:
         var2 = 5;
         break;
      case 6:
         var2 = 0;
      }

      if(((Boolean)var1.get(a)).booleanValue()) {
         var2 |= 8;
      }

      return var2;
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      return var1.getBlock() != this?var1:var1.set(FACING, var2.a((EnumDirection)var1.get(FACING)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(FACING)));
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{FACING, a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumDirection.values().length];

      static {
         try {
            a[EnumDirection.EAST.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[EnumDirection.WEST.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[EnumDirection.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[EnumDirection.NORTH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.UP.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.DOWN.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
