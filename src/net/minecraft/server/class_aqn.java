package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_arn;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;

public class class_aqn extends class_arn {
   private final IBlockData a;
   private final IBlockData b;

   public class_aqn(IBlockData var1, IBlockData var2) {
      super(false);
      this.b = var1;
      this.a = var2;
   }

   public boolean b(World var1, Random var2, class_cj var3) {
      Block var4;
      while(((var4 = var1.p(var3).getBlock()).getMaterial() == Material.a || var4.getMaterial() == Material.j) && var3.o() > 0) {
         var3 = var3.b();
      }

      Block var5 = var1.p(var3).getBlock();
      if(var5 == Blocks.DIRT || var5 == Blocks.GRASS) {
         var3 = var3.a();
         this.a(var1, var3, this.b);

         for(int var6 = var3.o(); var6 <= var3.o() + 2; ++var6) {
            int var7 = var6 - var3.o();
            int var8 = 2 - var7;

            for(int var9 = var3.n() - var8; var9 <= var3.n() + var8; ++var9) {
               int var10 = var9 - var3.n();

               for(int var11 = var3.p() - var8; var11 <= var3.p() + var8; ++var11) {
                  int var12 = var11 - var3.p();
                  if(Math.abs(var10) != var8 || Math.abs(var12) != var8 || var2.nextInt(2) != 0) {
                     class_cj var13 = new class_cj(var9, var6, var11);
                     if(!var1.p(var13).getBlock().isFullBlock()) {
                        this.a(var1, var13, this.a);
                     }
                  }
               }
            }
         }
      }

      return true;
   }
}
