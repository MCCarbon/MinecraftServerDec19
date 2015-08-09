package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockDirt;
import net.minecraft.server.BlockLeaves;
import net.minecraft.server.BlockLeaves1;
import net.minecraft.server.BlockLog1;
import net.minecraft.server.BlockWood;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aqy;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;

public class class_aqx extends class_aqy {
   private static final IBlockData e;
   private static final IBlockData f;
   private static final IBlockData g;
   private boolean h;

   public class_aqx(boolean var1, boolean var2) {
      super(var1, 13, 15, e, f);
      this.h = var2;
   }

   public boolean generate(World var1, Random var2, BlockPosition var3) {
      int var4 = this.a(var2);
      if(!this.a(var1, var2, var3, var4)) {
         return false;
      } else {
         this.a(var1, var3.getX(), var3.getZ(), var3.getY() + var4, 0, var2);

         for(int var5 = 0; var5 < var4; ++var5) {
            Block var6 = var1.getType(var3.up(var5)).getBlock();
            if(var6.getMaterial() == Material.AIR || var6.getMaterial() == Material.LEAVES) {
               this.setTypeAndData(var1, var3.up(var5), this.b);
            }

            if(var5 < var4 - 1) {
               var6 = var1.getType(var3.add(1, var5, 0)).getBlock();
               if(var6.getMaterial() == Material.AIR || var6.getMaterial() == Material.LEAVES) {
                  this.setTypeAndData(var1, var3.add(1, var5, 0), this.b);
               }

               var6 = var1.getType(var3.add(1, var5, 1)).getBlock();
               if(var6.getMaterial() == Material.AIR || var6.getMaterial() == Material.LEAVES) {
                  this.setTypeAndData(var1, var3.add(1, var5, 1), this.b);
               }

               var6 = var1.getType(var3.add(0, var5, 1)).getBlock();
               if(var6.getMaterial() == Material.AIR || var6.getMaterial() == Material.LEAVES) {
                  this.setTypeAndData(var1, var3.add(0, var5, 1), this.b);
               }
            }
         }

         return true;
      }
   }

   private void a(World var1, int var2, int var3, int var4, int var5, Random var6) {
      int var7 = var6.nextInt(5) + (this.h?this.a:3);
      int var8 = 0;

      for(int var9 = var4 - var7; var9 <= var4; ++var9) {
         int var10 = var4 - var9;
         int var11 = var5 + MathHelper.floor((float)var10 / (float)var7 * 3.5F);
         this.a(var1, new BlockPosition(var2, var9, var3), var11 + (var10 > 0 && var11 == var8 && (var9 & 1) == 0?1:0));
         var8 = var11;
      }

   }

   public void a(World var1, Random var2, BlockPosition var3) {
      this.b(var1, var3.west().north());
      this.b(var1, var3.east(2).north());
      this.b(var1, var3.west().south(2));
      this.b(var1, var3.east(2).south(2));

      for(int var4 = 0; var4 < 5; ++var4) {
         int var5 = var2.nextInt(64);
         int var6 = var5 % 8;
         int var7 = var5 / 8;
         if(var6 == 0 || var6 == 7 || var7 == 0 || var7 == 7) {
            this.b(var1, var3.add(-3 + var6, 0, -3 + var7));
         }
      }

   }

   private void b(World var1, BlockPosition var2) {
      for(int var3 = -2; var3 <= 2; ++var3) {
         for(int var4 = -2; var4 <= 2; ++var4) {
            if(Math.abs(var3) != 2 || Math.abs(var4) != 2) {
               this.c(var1, var2.add(var3, 0, var4));
            }
         }
      }

   }

   private void c(World var1, BlockPosition var2) {
      for(int var3 = 2; var3 >= -3; --var3) {
         BlockPosition var4 = var2.up(var3);
         Block var5 = var1.getType(var4).getBlock();
         if(var5 == Blocks.GRASS || var5 == Blocks.DIRT) {
            this.setTypeAndData(var1, var4, g);
            break;
         }

         if(var5.getMaterial() != Material.AIR && var3 < 0) {
            break;
         }
      }

   }

   static {
      e = Blocks.LOG.getBlockData().set(BlockLog1.b, BlockWood.EnumLogVariant.SPRUCE);
      f = Blocks.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.SPRUCE).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
      g = Blocks.DIRT.getBlockData().set(BlockDirt.VARIANT, BlockDirt.EnumDirtVariant.PODZOL);
   }
}
