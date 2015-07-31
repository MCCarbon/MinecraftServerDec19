package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_agv extends Block {
   public static final class_anz a = class_anz.a("age", 0, 5);

   protected class_agv() {
      super(Material.PLANT);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
      this.a(CreativeTab.c);
      this.setTicking(true);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return null;
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(!this.e(var1, var2)) {
         var1.b(var2, true);
      } else if(var1.d(var2.shiftUp())) {
         int var5 = ((Integer)var3.get(a)).intValue();
         if(var5 < 5 && var4.nextInt(1) == 0) {
            boolean var6 = false;
            boolean var7 = false;
            Block var8 = var1.p(var2.shiftDown()).getBlock();
            int var9;
            if(var8 == Blocks.END_STONE) {
               var6 = true;
            } else if(var8 != Blocks.CHORUS_PLANT) {
               if(var8 == Blocks.AIR) {
                  var6 = true;
               }
            } else {
               var9 = 1;

               int var10;
               for(var10 = 0; var10 < 4; ++var10) {
                  Block var11 = var1.p(var2.shiftDown(var9 + 1)).getBlock();
                  if(var11 != Blocks.CHORUS_PLANT) {
                     if(var11 == Blocks.END_STONE) {
                        var7 = true;
                     }
                     break;
                  }

                  ++var9;
               }

               var10 = 4;
               if(var7) {
                  ++var10;
               }

               if(var9 < 2 || var4.nextInt(var10) >= var9) {
                  var6 = true;
               }
            }

            if(var6 && a(var1, var2.shiftUp(), (EnumDirection)null) && var1.d(var2.shiftUp(2))) {
               var1.a((BlockPosition)var2, (IBlockData)Blocks.CHORUS_PLANT.getBlockData(), 2);
               var1.a((BlockPosition)var2.shiftUp(), (IBlockData)this.getBlockData().set(a, Integer.valueOf(var5)), 2);
            } else if(var5 < 4) {
               var9 = var4.nextInt(4);
               boolean var15 = false;
               if(var7) {
                  ++var9;
               }

               for(int var14 = 0; var14 < var9; ++var14) {
                  EnumDirection var12 = EnumDirection.EnumDirectionLimit.HORIZONTAL.getRandomDirection(var4);
                  BlockPosition var13 = var2.shift(var12);
                  if(var1.d(var13) && var1.d(var13.shiftDown()) && a(var1, var13, var12.getOpposite())) {
                     var1.a((BlockPosition)var13, (IBlockData)this.getBlockData().set(a, Integer.valueOf(var5 + 1)), 2);
                     var15 = true;
                  }
               }

               if(var15) {
                  var1.a((BlockPosition)var2, (IBlockData)Blocks.CHORUS_PLANT.getBlockData(), 2);
               } else {
                  var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(5)), 2);
               }
            } else if(var5 == 4) {
               var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(5)), 2);
            }
         }
      }

   }

   private static boolean a(World var0, BlockPosition var1, EnumDirection var2) {
      Iterator var3 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

      EnumDirection var4;
      do {
         if(!var3.hasNext()) {
            return true;
         }

         var4 = (EnumDirection)var3.next();
      } while(var4 == var2 || var0.d(var1.shift(var4)));

      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean d(World var1, BlockPosition var2) {
      return super.d(var1, var2)?this.e(var1, var2):false;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!this.e(var1, var2)) {
         var1.a((BlockPosition)var2, (Block)this, 1);
      }

   }

   public boolean e(World var1, BlockPosition var2) {
      Block var3 = var1.p(var2.shiftDown()).getBlock();
      if(var3 != Blocks.CHORUS_PLANT && var3 != Blocks.END_STONE) {
         if(var3 == Blocks.AIR) {
            int var4 = 0;
            Iterator var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

            while(var5.hasNext()) {
               EnumDirection var6 = (EnumDirection)var5.next();
               Block var7 = var1.p(var2.shift(var6)).getBlock();
               if(var7 == Blocks.CHORUS_PLANT) {
                  ++var4;
               } else if(var7 != Blocks.AIR) {
                  return false;
               }
            }

            return var4 == 1;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public void a(World var1, class_xa var2, BlockPosition var3, IBlockData var4, class_amg var5, ItemStack var6) {
      super.a(var1, var2, var3, var4, var5, var6);
      a(var1, var3, (ItemStack)(new ItemStack(Item.getByBlock((Block)this))));
   }

   protected ItemStack i(IBlockData var1) {
      return null;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      super.c(var1, var2, var3);
   }

   public static void a(World var0, BlockPosition var1, Random var2, int var3) {
      var0.a((BlockPosition)var1, (IBlockData)Blocks.CHORUS_PLANT.getBlockData(), 2);
      a(var0, var1, var2, var1, var3, 0);
   }

   private static void a(World var0, BlockPosition var1, Random var2, BlockPosition var3, int var4, int var5) {
      int var6 = var2.nextInt(4) + 1;
      if(var5 == 0) {
         ++var6;
      }

      for(int var7 = 0; var7 < var6; ++var7) {
         BlockPosition var8 = var1.shiftUp(var7 + 1);
         if(!a(var0, var8, (EnumDirection)null)) {
            return;
         }

         var0.a((BlockPosition)var8, (IBlockData)Blocks.CHORUS_PLANT.getBlockData(), 2);
      }

      boolean var12 = false;
      if(var5 < 4) {
         int var13 = var2.nextInt(4);
         if(var5 == 0) {
            ++var13;
         }

         for(int var9 = 0; var9 < var13; ++var9) {
            EnumDirection var10 = EnumDirection.EnumDirectionLimit.HORIZONTAL.getRandomDirection(var2);
            BlockPosition var11 = var1.shiftUp(var6).shift(var10);
            if(Math.abs(var11.getX() - var3.getX()) < var4 && Math.abs(var11.getZ() - var3.getZ()) < var4 && var0.d(var11) && var0.d(var11.shiftDown()) && a(var0, var11, var10.getOpposite())) {
               var12 = true;
               var0.a((BlockPosition)var11, (IBlockData)Blocks.CHORUS_PLANT.getBlockData(), 2);
               a(var0, var11, var2, var3, var4, var5 + 1);
            }
         }
      }

      if(!var12) {
         var0.a((BlockPosition)var1.shiftUp(var6), (IBlockData)Blocks.CHORUS_FLOWER.getBlockData().set(a, Integer.valueOf(5)), 2);
      }

   }
}
