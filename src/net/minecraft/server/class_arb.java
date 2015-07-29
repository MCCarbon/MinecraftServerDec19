package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_ans;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;

public class class_arb extends class_aql {
   private final IBlockData a;
   private final int b;
   private final Predicate c;

   public class_arb(IBlockData var1, int var2) {
      this(var1, var2, class_ans.a(Blocks.STONE));
   }

   public class_arb(IBlockData var1, int var2, Predicate var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public boolean b(World var1, Random var2, class_cj var3) {
      float var4 = var2.nextFloat() * 3.1415927F;
      double var5 = (double)((float)(var3.n() + 8) + class_nu.a(var4) * (float)this.b / 8.0F);
      double var7 = (double)((float)(var3.n() + 8) - class_nu.a(var4) * (float)this.b / 8.0F);
      double var9 = (double)((float)(var3.p() + 8) + class_nu.b(var4) * (float)this.b / 8.0F);
      double var11 = (double)((float)(var3.p() + 8) - class_nu.b(var4) * (float)this.b / 8.0F);
      double var13 = (double)(var3.o() + var2.nextInt(3) - 2);
      double var15 = (double)(var3.o() + var2.nextInt(3) - 2);

      for(int var17 = 0; var17 < this.b; ++var17) {
         float var18 = (float)var17 / (float)this.b;
         double var19 = var5 + (var7 - var5) * (double)var18;
         double var21 = var13 + (var15 - var13) * (double)var18;
         double var23 = var9 + (var11 - var9) * (double)var18;
         double var25 = var2.nextDouble() * (double)this.b / 16.0D;
         double var27 = (double)(class_nu.a(3.1415927F * var18) + 1.0F) * var25 + 1.0D;
         double var29 = (double)(class_nu.a(3.1415927F * var18) + 1.0F) * var25 + 1.0D;
         int var31 = class_nu.c(var19 - var27 / 2.0D);
         int var32 = class_nu.c(var21 - var29 / 2.0D);
         int var33 = class_nu.c(var23 - var27 / 2.0D);
         int var34 = class_nu.c(var19 + var27 / 2.0D);
         int var35 = class_nu.c(var21 + var29 / 2.0D);
         int var36 = class_nu.c(var23 + var27 / 2.0D);

         for(int var37 = var31; var37 <= var34; ++var37) {
            double var38 = ((double)var37 + 0.5D - var19) / (var27 / 2.0D);
            if(var38 * var38 < 1.0D) {
               for(int var40 = var32; var40 <= var35; ++var40) {
                  double var41 = ((double)var40 + 0.5D - var21) / (var29 / 2.0D);
                  if(var38 * var38 + var41 * var41 < 1.0D) {
                     for(int var43 = var33; var43 <= var36; ++var43) {
                        double var44 = ((double)var43 + 0.5D - var23) / (var27 / 2.0D);
                        if(var38 * var38 + var41 * var41 + var44 * var44 < 1.0D) {
                           class_cj var46 = new class_cj(var37, var40, var43);
                           if(this.c.apply(var1.p(var46))) {
                              var1.a((class_cj)var46, (IBlockData)this.a, 2);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return true;
   }
}
