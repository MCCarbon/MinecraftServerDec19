package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_alo;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_apd;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;

public class class_aib extends Block {
   public static final class_anz a = class_anz.a("age", 0, 15);
   public static final class_anw b = class_anw.a("north");
   public static final class_anw N = class_anw.a("east");
   public static final class_anw O = class_anw.a("south");
   public static final class_anw P = class_anw.a("west");
   public static final class_anw Q = class_anw.a("up");
   private final Map R = Maps.newIdentityHashMap();
   private final Map S = Maps.newIdentityHashMap();

   public IBlockData a(IBlockData var1, class_aer var2, BlockPosition var3) {
      return !World.a(var2, var3.shiftDown()) && !Blocks.FIRE.e(var2, var3.shiftDown())?var1.set(b, Boolean.valueOf(this.e(var2, var3.shiftNorth()))).set(N, Boolean.valueOf(this.e(var2, var3.shiftEast()))).set(O, Boolean.valueOf(this.e(var2, var3.shiftSouth()))).set(P, Boolean.valueOf(this.e(var2, var3.shiftWest()))).set(Q, Boolean.valueOf(this.e(var2, var3.shiftUp()))):this.getBlockData();
   }

   protected class_aib() {
      super(Material.FIRE);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)).set(P, Boolean.valueOf(false)).set(Q, Boolean.valueOf(false)));
      this.setTicking(true);
   }

   public static void l() {
      Blocks.FIRE.a(Blocks.PLANKS, 5, 20);
      Blocks.FIRE.a(Blocks.DOUBLE_WOODEN_SLAB, 5, 20);
      Blocks.FIRE.a(Blocks.WOODEN_SLAB, 5, 20);
      Blocks.FIRE.a(Blocks.FENCE_GATE, 5, 20);
      Blocks.FIRE.a(Blocks.SPRUCE_FENCE_GATE, 5, 20);
      Blocks.FIRE.a(Blocks.BIRCH_FENCE_GATE, 5, 20);
      Blocks.FIRE.a(Blocks.JUGLE_FENCE_GATE, 5, 20);
      Blocks.FIRE.a(Blocks.DARK_OAK_FENCE_GATE, 5, 20);
      Blocks.FIRE.a(Blocks.ACACIA_FENCE_GATE, 5, 20);
      Blocks.FIRE.a(Blocks.FENCE, 5, 20);
      Blocks.FIRE.a(Blocks.SPRUCE_FENCE, 5, 20);
      Blocks.FIRE.a(Blocks.BIRCH_FENCE, 5, 20);
      Blocks.FIRE.a(Blocks.JUNGLE_FENCE, 5, 20);
      Blocks.FIRE.a(Blocks.DARK_OAK_FENCE, 5, 20);
      Blocks.FIRE.a(Blocks.ACACIA_FENCE, 5, 20);
      Blocks.FIRE.a(Blocks.OAK_STAIRS, 5, 20);
      Blocks.FIRE.a(Blocks.BIRCH_STAIRS, 5, 20);
      Blocks.FIRE.a(Blocks.SPRUCE_STAIRS, 5, 20);
      Blocks.FIRE.a(Blocks.JUNGKE_STAIRS, 5, 20);
      Blocks.FIRE.a(Blocks.LOG, 5, 5);
      Blocks.FIRE.a(Blocks.LOG2, 5, 5);
      Blocks.FIRE.a(Blocks.LEAVES, 30, 60);
      Blocks.FIRE.a(Blocks.LEAVES2, 30, 60);
      Blocks.FIRE.a(Blocks.BOOKSHELF, 30, 20);
      Blocks.FIRE.a(Blocks.TNT, 15, 100);
      Blocks.FIRE.a(Blocks.TALLGRASS, 60, 100);
      Blocks.FIRE.a(Blocks.DOUBLE_PLANT, 60, 100);
      Blocks.FIRE.a(Blocks.YELLOW_FLOWER, 60, 100);
      Blocks.FIRE.a(Blocks.RED_FLOWER, 60, 100);
      Blocks.FIRE.a(Blocks.DEADBUSH, 60, 100);
      Blocks.FIRE.a(Blocks.WOOL, 30, 60);
      Blocks.FIRE.a(Blocks.VINE, 15, 100);
      Blocks.FIRE.a(Blocks.COAL_BLOCK, 5, 5);
      Blocks.FIRE.a(Blocks.HAY_BLOCK, 60, 20);
      Blocks.FIRE.a(Blocks.CARPET, 60, 20);
   }

   public void a(Block var1, int var2, int var3) {
      this.R.put(var1, Integer.valueOf(var2));
      this.S.put(var1, Integer.valueOf(var3));
   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
      return null;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public int a(Random var1) {
      return 0;
   }

   public int a(World var1) {
      return 30;
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(var1.R().b("doFireTick")) {
         if(!this.d(var1, var2)) {
            var1.g(var2);
         }

         Block var5 = var1.p(var2.shiftDown()).getBlock();
         boolean var6 = var5 == Blocks.NETHERRACK;
         if(var1.t instanceof class_apd && var5 == Blocks.BEDROCK) {
            var6 = true;
         }

         if(!var6 && var1.T() && this.e(var1, var2)) {
            var1.g(var2);
         } else {
            int var7 = ((Integer)var3.get(a)).intValue();
            if(var7 < 15) {
               var3 = var3.set(a, Integer.valueOf(var7 + var4.nextInt(3) / 2));
               var1.a((BlockPosition)var2, (IBlockData)var3, 4);
            }

            var1.a((BlockPosition)var2, (Block)this, this.a(var1) + var4.nextInt(10));
            if(!var6) {
               if(!this.f(var1, var2)) {
                  if(!World.a((class_aer)var1, (BlockPosition)var2.shiftDown()) || var7 > 3) {
                     var1.g(var2);
                  }

                  return;
               }

               if(!this.e((class_aer)var1, var2.shiftDown()) && var7 == 15 && var4.nextInt(4) == 0) {
                  var1.g(var2);
                  return;
               }
            }

            boolean var8 = var1.D(var2);
            byte var9 = 0;
            if(var8) {
               var9 = -50;
            }

            this.a(var1, var2.shiftEast(), 300 + var9, var4, var7);
            this.a(var1, var2.shiftWest(), 300 + var9, var4, var7);
            this.a(var1, var2.shiftDown(), 250 + var9, var4, var7);
            this.a(var1, var2.shiftUp(), 250 + var9, var4, var7);
            this.a(var1, var2.shiftNorth(), 300 + var9, var4, var7);
            this.a(var1, var2.shiftSouth(), 300 + var9, var4, var7);

            for(int var10 = -1; var10 <= 1; ++var10) {
               for(int var11 = -1; var11 <= 1; ++var11) {
                  for(int var12 = -1; var12 <= 4; ++var12) {
                     if(var10 != 0 || var12 != 0 || var11 != 0) {
                        int var13 = 100;
                        if(var12 > 1) {
                           var13 += (var12 - 1) * 100;
                        }

                        BlockPosition var14 = var2.add(var10, var12, var11);
                        int var15 = this.m(var1, var14);
                        if(var15 > 0) {
                           int var16 = (var15 + 40 + var1.ab().a() * 7) / (var7 + 30);
                           if(var8) {
                              var16 /= 2;
                           }

                           if(var16 > 0 && var4.nextInt(var13) <= var16 && (!var1.T() || !this.e(var1, var14))) {
                              int var17 = var7 + var4.nextInt(5) / 4;
                              if(var17 > 15) {
                                 var17 = 15;
                              }

                              var1.a((BlockPosition)var14, (IBlockData)var3.set(a, Integer.valueOf(var17)), 3);
                           }
                        }
                     }
                  }
               }
            }

         }
      }
   }

   protected boolean e(World var1, BlockPosition var2) {
      return var1.C(var2) || var1.C(var2.shiftWest()) || var1.C(var2.shiftEast()) || var1.C(var2.shiftNorth()) || var1.C(var2.shiftSouth());
   }

   public boolean P() {
      return false;
   }

   private int c(Block var1) {
      Integer var2 = (Integer)this.S.get(var1);
      return var2 == null?0:var2.intValue();
   }

   private int d(Block var1) {
      Integer var2 = (Integer)this.R.get(var1);
      return var2 == null?0:var2.intValue();
   }

   private void a(World var1, BlockPosition var2, int var3, Random var4, int var5) {
      int var6 = this.c(var1.p(var2).getBlock());
      if(var4.nextInt(var3) < var6) {
         IBlockData var7 = var1.p(var2);
         if(var4.nextInt(var5 + 10) < 5 && !var1.C(var2)) {
            int var8 = var5 + var4.nextInt(5) / 4;
            if(var8 > 15) {
               var8 = 15;
            }

            var1.a((BlockPosition)var2, (IBlockData)this.getBlockData().set(a, Integer.valueOf(var8)), 3);
         } else {
            var1.g(var2);
         }

         if(var7.getBlock() == Blocks.TNT) {
            Blocks.TNT.d(var1, var2, var7.set(class_alo.a, Boolean.valueOf(true)));
         }
      }

   }

   private boolean f(World var1, BlockPosition var2) {
      EnumDirection[] var3 = EnumDirection.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumDirection var6 = var3[var5];
         if(this.e((class_aer)var1, var2.shift(var6))) {
            return true;
         }
      }

      return false;
   }

   private int m(World var1, BlockPosition var2) {
      if(!var1.d(var2)) {
         return 0;
      } else {
         int var3 = 0;
         EnumDirection[] var4 = EnumDirection.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            EnumDirection var7 = var4[var6];
            var3 = Math.max(this.d(var1.p(var2.shift(var7)).getBlock()), var3);
         }

         return var3;
      }
   }

   public boolean C() {
      return false;
   }

   public boolean e(class_aer var1, BlockPosition var2) {
      return this.d(var1.p(var2).getBlock()) > 0;
   }

   public boolean d(World var1, BlockPosition var2) {
      return World.a((class_aer)var1, (BlockPosition)var2.shiftDown()) || this.f(var1, var2);
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!World.a((class_aer)var1, (BlockPosition)var2.shiftDown()) && !this.f(var1, var2)) {
         var1.g(var2);
      }

   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      if(var1.t.p().a() > 0 || !Blocks.PORTAL.e(var1, var2)) {
         if(!World.a((class_aer)var1, (BlockPosition)var2.shiftDown()) && !this.f(var1, var2)) {
            var1.g(var2);
         } else {
            var1.a((BlockPosition)var2, (Block)this, this.a(var1) + var1.s.nextInt(10));
         }
      }
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.COLOR5;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b, N, O, P, Q});
   }
}
