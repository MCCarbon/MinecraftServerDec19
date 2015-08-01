package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_alu;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateBoolean;
import net.minecraft.server.class_aqy;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;

public class class_aqw extends class_aqy {
   public class_aqw(boolean var1, int var2, int var3, IBlockData var4, IBlockData var5) {
      super(var1, var2, var3, var4, var5);
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      int var4 = this.a(var2);
      if(!this.a(var1, var2, var3, var4)) {
         return false;
      } else {
         this.c(var1, var3.up(var4), 2);

         for(int var5 = var3.getY() + var4 - 2 - var2.nextInt(4); var5 > var3.getY() + var4 / 2; var5 -= 2 + var2.nextInt(4)) {
            float var6 = var2.nextFloat() * 3.1415927F * 2.0F;
            int var7 = var3.getX() + (int)(0.5F + MathHelper.cos(var6) * 4.0F);
            int var8 = var3.getZ() + (int)(0.5F + MathHelper.sin(var6) * 4.0F);

            int var9;
            for(var9 = 0; var9 < 5; ++var9) {
               var7 = var3.getX() + (int)(1.5F + MathHelper.cos(var6) * (float)var9);
               var8 = var3.getZ() + (int)(1.5F + MathHelper.sin(var6) * (float)var9);
               this.a(var1, new BlockPosition(var7, var5 - 3 + var9 / 2, var8), this.b);
            }

            var9 = 1 + var2.nextInt(2);
            int var10 = var5;

            for(int var11 = var5 - var9; var11 <= var10; ++var11) {
               int var12 = var11 - var10;
               this.b(var1, new BlockPosition(var7, var11, var8), 1 - var12);
            }
         }

         for(int var13 = 0; var13 < var4; ++var13) {
            BlockPosition var14 = var3.up(var13);
            if(this.a(var1.getType(var14).getBlock())) {
               this.a(var1, var14, this.b);
               if(var13 > 0) {
                  this.a(var1, var2, var14.west(), class_alu.N);
                  this.a(var1, var2, var14.north(), class_alu.O);
               }
            }

            if(var13 < var4 - 1) {
               BlockPosition var15 = var14.east();
               if(this.a(var1.getType(var15).getBlock())) {
                  this.a(var1, var15, this.b);
                  if(var13 > 0) {
                     this.a(var1, var2, var15.east(), class_alu.P);
                     this.a(var1, var2, var15.north(), class_alu.O);
                  }
               }

               BlockPosition var16 = var14.south().east();
               if(this.a(var1.getType(var16).getBlock())) {
                  this.a(var1, var16, this.b);
                  if(var13 > 0) {
                     this.a(var1, var2, var16.east(), class_alu.P);
                     this.a(var1, var2, var16.south(), class_alu.b);
                  }
               }

               BlockPosition var17 = var14.south();
               if(this.a(var1.getType(var17).getBlock())) {
                  this.a(var1, var17, this.b);
                  if(var13 > 0) {
                     this.a(var1, var2, var17.west(), class_alu.N);
                     this.a(var1, var2, var17.south(), class_alu.b);
                  }
               }
            }
         }

         return true;
      }
   }

   private void a(World var1, Random var2, BlockPosition var3, BlockStateBoolean var4) {
      if(var2.nextInt(3) > 0 && var1.isEmpty(var3)) {
         this.a(var1, var3, Blocks.VINE.getBlockData().set(var4, Boolean.valueOf(true)));
      }

   }

   private void c(World var1, BlockPosition var2, int var3) {
      byte var4 = 2;

      for(int var5 = -var4; var5 <= 0; ++var5) {
         this.a(var1, var2.up(var5), var3 + 1 - var5);
      }

   }
}
