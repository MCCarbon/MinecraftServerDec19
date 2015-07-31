package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_akk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_qa;

public abstract class class_ahh extends class_aiv {
   protected final boolean N;

   protected class_ahh(boolean var1) {
      super(Material.ORIENTABLE);
      this.N = var1;
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean d(World var1, BlockPosition var2) {
      return World.a((class_aer)var1, (BlockPosition)var2.shiftDown())?super.d(var1, var2):false;
   }

   public boolean e(World var1, BlockPosition var2) {
      return World.a((class_aer)var1, (BlockPosition)var2.shiftDown());
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Random var4) {
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(!this.b((class_aer) var1, var2, var3)) {
         boolean var5 = this.e(var1, var2, var3);
         if(this.N && !var5) {
            var1.a((BlockPosition)var2, (IBlockData)this.k(var3), 2);
         } else if(!this.N) {
            var1.a((BlockPosition)var2, (IBlockData)this.e(var3), 2);
            if(!var5) {
               var1.a(var2, this.e(var3).getBlock(), this.m(var3), -1);
            }
         }

      }
   }

   protected boolean l(IBlockData var1) {
      return this.N;
   }

   public int b(class_aer var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return this.a(var1, var2, var3, var4);
   }

   public int a(class_aer var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return !this.l(var3)?0:(var3.get(O) == var4?this.a(var1, var2, var3):0);
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(this.e(var1, var2)) {
         this.g(var1, var2, var3);
      } else {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         EnumDirection[] var5 = EnumDirection.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            EnumDirection var8 = var5[var7];
            var1.c((BlockPosition)var2.shift(var8), (Block)this);
         }

      }
   }

   protected void g(World var1, BlockPosition var2, IBlockData var3) {
      if(!this.b((class_aer) var1, var2, var3)) {
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

   public boolean b(class_aer var1, BlockPosition var2, IBlockData var3) {
      return false;
   }

   protected boolean e(World var1, BlockPosition var2, IBlockData var3) {
      return this.f(var1, var2, var3) > 0;
   }

   protected int f(World var1, BlockPosition var2, IBlockData var3) {
      EnumDirection var4 = (EnumDirection)var3.get(O);
      BlockPosition var5 = var2.shift(var4);
      int var6 = var1.c(var5, var4);
      if(var6 >= 15) {
         return var6;
      } else {
         IBlockData var7 = var1.p(var5);
         return Math.max(var6, var7.getBlock() == Blocks.REDSTONE_WIRE?((Integer)var7.get(class_akk.P)).intValue():0);
      }
   }

   protected int c(class_aer var1, BlockPosition var2, IBlockData var3) {
      EnumDirection var4 = (EnumDirection)var3.get(O);
      EnumDirection var5 = var4.rotateY();
      EnumDirection var6 = var4.rotateYCCW();
      return Math.max(this.c(var1, var2.shift(var5), var5), this.c(var1, var2.shift(var6), var6));
   }

   protected int c(class_aer var1, BlockPosition var2, EnumDirection var3) {
      IBlockData var4 = var1.p(var2);
      Block var5 = var4.getBlock();
      return this.c(var5)?(var5 == Blocks.REDSTONE_WIRE?((Integer)var4.get(class_akk.P)).intValue():var1.a(var2, var3)):0;
   }

   public boolean isPowerSource() {
      return true;
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.getBlockData().set(O, var8.aR().getOpposite());
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, ItemStack var5) {
      if(this.e(var1, var2, var3)) {
         var1.a((BlockPosition)var2, (Block)this, 1);
      }

   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      this.h(var1, var2, var3);
   }

   protected void h(World var1, BlockPosition var2, IBlockData var3) {
      EnumDirection var4 = (EnumDirection)var3.get(O);
      BlockPosition var5 = var2.shift(var4.getOpposite());
      var1.d(var5, this);
      var1.a((BlockPosition)var5, (Block)this, (EnumDirection)var4);
   }

   public void d(World var1, BlockPosition var2, IBlockData var3) {
      if(this.N) {
         EnumDirection[] var4 = EnumDirection.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            EnumDirection var7 = var4[var6];
            var1.c((BlockPosition)var2.shift(var7), (Block)this);
         }
      }

      super.d(var1, var2, var3);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   protected boolean c(Block var1) {
      return var1.isPowerSource();
   }

   protected int a(class_aer var1, BlockPosition var2, IBlockData var3) {
      return 15;
   }

   public static boolean d(Block var0) {
      return Blocks.UNPOWERED_REPEATER.e(var0) || Blocks.UNPOWERED_COMPARATOR.e(var0);
   }

   public boolean e(Block var1) {
      return var1 == this.e(this.getBlockData()).getBlock() || var1 == this.k(this.getBlockData()).getBlock();
   }

   public boolean i(World var1, BlockPosition var2, IBlockData var3) {
      EnumDirection var4 = ((EnumDirection)var3.get(O)).getOpposite();
      BlockPosition var5 = var2.shift(var4);
      return d(var1.p(var5).getBlock())?var1.p(var5).get(O) != var4:false;
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
