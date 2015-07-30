package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_ahy;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;
import net.minecraft.server.CreativeTab;

public class class_ahd extends class_ago implements class_agl {
   public static final class_anz b = class_anz.a("age", 0, 7);

   protected class_ahd() {
      this.setBlockData(this.blockStateList.getFirst().set(this.l(), Integer.valueOf(0)));
      this.setTicking(true);
      float var1 = 0.5F;
      this.setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
      this.a((CreativeTab)null);
      this.setStrength(0.0F);
      this.setStepSound(STEP_SOUND_GRASS);
      this.disableBreakStat();
   }

   protected boolean c(Block var1) {
      return var1 == Blocks.FARMLAND;
   }

   protected class_anz l() {
      return b;
   }

   public int n() {
      return 7;
   }

   protected int d(IBlockData var1) {
      return ((Integer)var1.get(this.l())).intValue();
   }

   public IBlockData b(int var1) {
      return this.getBlockData().set(this.l(), Integer.valueOf(var1));
   }

   public boolean e(IBlockData var1) {
      return ((Integer)var1.get(this.l())).intValue() >= this.n();
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      super.b(var1, var2, var3, var4);
      if(var1.l(var2.shiftUp()) >= 9) {
         int var5 = this.d(var3);
         if(var5 < this.n()) {
            float var6 = a(this, var1, var2);
            if(var4.nextInt((int)(25.0F / var6) + 1) == 0) {
               var1.a((BlockPosition)var2, (IBlockData)this.b(var5 + 1), 2);
            }
         }
      }

   }

   public void g(World var1, BlockPosition var2, IBlockData var3) {
      int var4 = this.d(var3) + this.b(var1);
      int var5 = this.n();
      if(var4 > var5) {
         var4 = var5;
      }

      var1.a((BlockPosition)var2, (IBlockData)this.b(var4), 2);
   }

   protected int b(World var1) {
      return MathHelper.getRandomIntInRange((Random)var1.s, 2, 5);
   }

   protected static float a(Block var0, World var1, BlockPosition var2) {
      float var3 = 1.0F;
      BlockPosition var4 = var2.shiftDown();

      for(int var5 = -1; var5 <= 1; ++var5) {
         for(int var6 = -1; var6 <= 1; ++var6) {
            float var7 = 0.0F;
            IBlockData var8 = var1.p(var4.add(var5, 0, var6));
            if(var8.getBlock() == Blocks.FARMLAND) {
               var7 = 1.0F;
               if(((Integer)var8.get(class_ahy.a)).intValue() > 0) {
                  var7 = 3.0F;
               }
            }

            if(var5 != 0 || var6 != 0) {
               var7 /= 4.0F;
            }

            var3 += var7;
         }
      }

      BlockPosition var12 = var2.shiftNorth();
      BlockPosition var13 = var2.shiftSouth();
      BlockPosition var15 = var2.shiftWest();
      BlockPosition var14 = var2.shiftEast();
      boolean var9 = var0 == var1.p(var15).getBlock() || var0 == var1.p(var14).getBlock();
      boolean var10 = var0 == var1.p(var12).getBlock() || var0 == var1.p(var13).getBlock();
      if(var9 && var10) {
         var3 /= 2.0F;
      } else {
         boolean var11 = var0 == var1.p(var15.shiftNorth()).getBlock() || var0 == var1.p(var14.shiftNorth()).getBlock() || var0 == var1.p(var14.shiftSouth()).getBlock() || var0 == var1.p(var15.shiftSouth()).getBlock();
         if(var11) {
            var3 /= 2.0F;
         }
      }

      return var3;
   }

   public boolean f(World var1, BlockPosition var2, IBlockData var3) {
      return (var1.k(var2) >= 8 || var1.i(var2)) && this.c(var1.p(var2.shiftDown()).getBlock());
   }

   protected Item o() {
      return Items.P;
   }

   protected Item p() {
      return Items.Q;
   }

   public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
      super.dropNaturally(var1, var2, var3, var4, 0);
      if(!var1.D) {
         int var6 = this.d(var3);
         if(var6 >= this.n()) {
            int var7 = 3 + var5;

            for(int var8 = 0; var8 < var7; ++var8) {
               if(var1.s.nextInt(15) <= var6) {
                  a(var1, var2, new class_aas(this.o()));
               }
            }
         }

      }
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return this.e(var1)?this.p():this.o();
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, boolean var4) {
      return !this.e(var3);
   }

   public boolean a(World var1, Random var2, BlockPosition var3, IBlockData var4) {
      return true;
   }

   public void b(World var1, Random var2, BlockPosition var3, IBlockData var4) {
      this.g(var1, var3, var4);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.b(var1);
   }

   public int toLegacyData(IBlockData var1) {
      return this.d(var1);
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{b});
   }
}
