package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockDirectional;
import net.minecraft.server.class_akk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EntityLiving;

public abstract class class_ahh extends BlockDirectional {
   protected final boolean N;

   protected class_ahh(boolean var1) {
      super(Material.ORIENTABLE);
      this.N = var1;
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      return World.a((IBlockAccess)var1, (BlockPosition)var2.down())?super.canPlace(var1, var2):false;
   }

   public boolean e(World var1, BlockPosition var2) {
      return World.a((IBlockAccess)var1, (BlockPosition)var2.down());
   }

   public void randomTick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(!this.b((IBlockAccess) var1, var2, var3)) {
         boolean var5 = this.e(var1, var2, var3);
         if(this.N && !var5) {
            var1.setTypeAndData((BlockPosition)var2, (IBlockData)this.k(var3), 2);
         } else if(!this.N) {
            var1.setTypeAndData((BlockPosition)var2, (IBlockData)this.e(var3), 2);
            if(!var5) {
               var1.a(var2, this.e(var3).getBlock(), this.m(var3), -1);
            }
         }

      }
   }

   protected boolean l(IBlockData var1) {
      return this.N;
   }

   public int b(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return this.a(var1, var2, var3, var4);
   }

   public int a(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return !this.l(var3)?0:(var3.get(FACING) == var4?this.a(var1, var2, var3):0);
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(this.e(var1, var2)) {
         this.g(var1, var2, var3);
      } else {
         this.dropNaturallyForSure(var1, var2, var3, 0);
         var1.setAir(var2);
         EnumDirection[] var5 = EnumDirection.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            EnumDirection var8 = var5[var7];
            var1.c((BlockPosition)var2.shift(var8), (Block)this);
         }

      }
   }

   protected void g(World var1, BlockPosition var2, IBlockData var3) {
      if(!this.b((IBlockAccess) var1, var2, var3)) {
         boolean var4 = this.e(var1, var2, var3);
         if((this.N && !var4 || !this.N && var4) && !var1.a((BlockPosition)var2, (Block)this)) {
            byte var5 = -1;
            if(this.i(var1, var2, var3)) {
               var5 = -3;
            } else if(this.N) {
               var5 = -2;
            }

            var1.a(var2, this, this.d(var3), var5);
         }

      }
   }

   public boolean b(IBlockAccess var1, BlockPosition var2, IBlockData var3) {
      return false;
   }

   protected boolean e(World var1, BlockPosition var2, IBlockData var3) {
      return this.f(var1, var2, var3) > 0;
   }

   protected int f(World var1, BlockPosition var2, IBlockData var3) {
      EnumDirection var4 = (EnumDirection)var3.get(FACING);
      BlockPosition var5 = var2.shift(var4);
      int var6 = var1.c(var5, var4);
      if(var6 >= 15) {
         return var6;
      } else {
         IBlockData var7 = var1.getType(var5);
         return Math.max(var6, var7.getBlock() == Blocks.REDSTONE_WIRE?((Integer)var7.get(class_akk.P)).intValue():0);
      }
   }

   protected int c(IBlockAccess var1, BlockPosition var2, IBlockData var3) {
      EnumDirection var4 = (EnumDirection)var3.get(FACING);
      EnumDirection var5 = var4.rotateY();
      EnumDirection var6 = var4.rotateYCCW();
      return Math.max(this.c(var1, var2.shift(var5), var5), this.c(var1, var2.shift(var6), var6));
   }

   protected int c(IBlockAccess var1, BlockPosition var2, EnumDirection var3) {
      IBlockData var4 = var1.getType(var2);
      Block var5 = var4.getBlock();
      return this.c(var5)?(var5 == Blocks.REDSTONE_WIRE?((Integer)var4.get(class_akk.P)).intValue():var1.a(var2, var3)):0;
   }

   public boolean isPowerSource() {
      return true;
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.getBlockData().set(FACING, var8.aR().opposite());
   }

   public void postPlace(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      if(this.e(var1, var2, var3)) {
         var1.a((BlockPosition)var2, (Block)this, 1);
      }

   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      this.h(var1, var2, var3);
   }

   protected void h(World var1, BlockPosition var2, IBlockData var3) {
      EnumDirection var4 = (EnumDirection)var3.get(FACING);
      BlockPosition var5 = var2.shift(var4.opposite());
      var1.d(var5, this);
      var1.a((BlockPosition)var5, (Block)this, (EnumDirection)var4);
   }

   public void postBreak(World var1, BlockPosition var2, IBlockData var3) {
      if(this.N) {
         EnumDirection[] var4 = EnumDirection.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            EnumDirection var7 = var4[var6];
            var1.c((BlockPosition)var2.shift(var7), (Block)this);
         }
      }

      super.postBreak(var1, var2, var3);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   protected boolean c(Block var1) {
      return var1.isPowerSource();
   }

   protected int a(IBlockAccess var1, BlockPosition var2, IBlockData var3) {
      return 15;
   }

   public static boolean d(Block var0) {
      return Blocks.UNPOWERED_REPEATER.e(var0) || Blocks.UNPOWERED_COMPARATOR.e(var0);
   }

   public boolean e(Block var1) {
      return var1 == this.e(this.getBlockData()).getBlock() || var1 == this.k(this.getBlockData()).getBlock();
   }

   public boolean i(World var1, BlockPosition var2, IBlockData var3) {
      EnumDirection var4 = ((EnumDirection)var3.get(FACING)).opposite();
      BlockPosition var5 = var2.shift(var4);
      return d(var1.getType(var5).getBlock())?var1.getType(var5).get(FACING) != var4:false;
   }

   protected int m(IBlockData var1) {
      return this.d(var1);
   }

   protected abstract int d(IBlockData var1);

   protected abstract IBlockData e(IBlockData var1);

   protected abstract IBlockData k(IBlockData var1);

   public boolean b(Block var1) {
      return this.e(var1);
   }
}
