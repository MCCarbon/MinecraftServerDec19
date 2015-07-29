package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;

public class class_aqt extends class_aql {
   public boolean b(World var1, Random var2, class_cj var3) {
      while(var1.d(var3) && var3.o() > 2) {
         var3 = var3.b();
      }

      if(var1.p(var3).getBlock() != Blocks.SNOW) {
         return false;
      } else {
         var3 = var3.b(var2.nextInt(4));
         int var4 = var2.nextInt(4) + 7;
         int var5 = var4 / 4 + var2.nextInt(2);
         if(var5 > 1 && var2.nextInt(60) == 0) {
            var3 = var3.b(10 + var2.nextInt(30));
         }

         int var6;
         int var8;
         for(var6 = 0; var6 < var4; ++var6) {
            float var7 = (1.0F - (float)var6 / (float)var4) * (float)var5;
            var8 = class_nu.f(var7);

            for(int var9 = -var8; var9 <= var8; ++var9) {
               float var10 = (float)class_nu.a(var9) - 0.25F;

               for(int var11 = -var8; var11 <= var8; ++var11) {
                  float var12 = (float)class_nu.a(var11) - 0.25F;
                  if((var9 == 0 && var11 == 0 || var10 * var10 + var12 * var12 <= var7 * var7) && (var9 != -var8 && var9 != var8 && var11 != -var8 && var11 != var8 || var2.nextFloat() <= 0.75F)) {
                     Block var13 = var1.p(var3.a(var9, var6, var11)).getBlock();
                     if(var13.getMaterial() == Material.a || var13 == Blocks.DIRT || var13 == Blocks.SNOW || var13 == Blocks.ICE) {
                        this.a(var1, var3.a(var9, var6, var11), Blocks.PACKED_ICE.getBlockData());
                     }

                     if(var6 != 0 && var8 > 1) {
                        var13 = var1.p(var3.a(var9, -var6, var11)).getBlock();
                        if(var13.getMaterial() == Material.a || var13 == Blocks.DIRT || var13 == Blocks.SNOW || var13 == Blocks.ICE) {
                           this.a(var1, var3.a(var9, -var6, var11), Blocks.PACKED_ICE.getBlockData());
                        }
                     }
                  }
               }
            }
         }

         var6 = var5 - 1;
         if(var6 < 0) {
            var6 = 0;
         } else if(var6 > 1) {
            var6 = 1;
         }

         for(int var14 = -var6; var14 <= var6; ++var14) {
            for(var8 = -var6; var8 <= var6; ++var8) {
               class_cj var15 = var3.a(var14, -1, var8);
               int var16 = 50;
               if(Math.abs(var14) == 1 && Math.abs(var8) == 1) {
                  var16 = var2.nextInt(5);
               }

               while(var15.o() > 50) {
                  Block var17 = var1.p(var15).getBlock();
                  if(var17.getMaterial() != Material.a && var17 != Blocks.DIRT && var17 != Blocks.SNOW && var17 != Blocks.ICE && var17 != Blocks.PACKED_ICE) {
                     break;
                  }

                  this.a(var1, var15, Blocks.PACKED_ICE.getBlockData());
                  var15 = var15.b();
                  --var16;
                  if(var16 <= 0) {
                     var15 = var15.c(var2.nextInt(5) + 1);
                     var16 = var2.nextInt(5);
                  }
               }
            }
         }

         return true;
      }
   }
}
