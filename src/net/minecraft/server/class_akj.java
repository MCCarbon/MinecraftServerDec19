package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;

public class class_akj extends Block {
   private final boolean a;

   public class_akj(boolean var1) {
      super(class_atk.e);
      if(var1) {
         this.a(true);
      }

      this.a = var1;
   }

   public int a(class_aen var1) {
      return 30;
   }

   public void a(class_aen var1, class_cj var2, class_xa var3) {
      this.e(var1, var2);
      super.a(var1, var2, var3);
   }

   public void a(class_aen var1, class_cj var2, class_pr var3) {
      this.e(var1, var2);
      super.a(var1, var2, var3);
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      this.e(var1, var2);
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   private void e(class_aen var1, class_cj var2) {
      this.f(var1, var2);
      if(this == class_agk.aC) {
         var1.a(var2, class_agk.aD.S());
      }

   }

   public void b(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
      if(this == class_agk.aD) {
         var1.a(var2, class_agk.aC.S());
      }

   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aau.aE;
   }

   public int a(int var1, Random var2) {
      return this.a(var2) + var2.nextInt(var1 + 1);
   }

   public int a(Random var1) {
      return 4 + var1.nextInt(2);
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if(this.a(var3, var1.s, var5) != class_aar.a((Block)this)) {
         int var6 = 1 + var1.s.nextInt(5);
         this.b(var1, var2, var6);
      }

   }

   private void f(class_aen var1, class_cj var2) {
      Random var3 = var1.s;
      double var4 = 0.0625D;

      for(int var6 = 0; var6 < 6; ++var6) {
         double var7 = (double)((float)var2.n() + var3.nextFloat());
         double var9 = (double)((float)var2.o() + var3.nextFloat());
         double var11 = (double)((float)var2.p() + var3.nextFloat());
         if(var6 == 0 && !var1.p(var2.a()).getBlock().c()) {
            var9 = (double)var2.o() + var4 + 1.0D;
         }

         if(var6 == 1 && !var1.p(var2.b()).getBlock().c()) {
            var9 = (double)var2.o() - var4;
         }

         if(var6 == 2 && !var1.p(var2.d()).getBlock().c()) {
            var11 = (double)var2.p() + var4 + 1.0D;
         }

         if(var6 == 3 && !var1.p(var2.c()).getBlock().c()) {
            var11 = (double)var2.p() - var4;
         }

         if(var6 == 4 && !var1.p(var2.f()).getBlock().c()) {
            var7 = (double)var2.n() + var4 + 1.0D;
         }

         if(var6 == 5 && !var1.p(var2.e()).getBlock().c()) {
            var7 = (double)var2.n() - var4;
         }

         if(var7 < (double)var2.n() || var7 > (double)(var2.n() + 1) || var9 < 0.0D || var9 > (double)(var2.o() + 1) || var11 < (double)var2.p() || var11 > (double)(var2.p() + 1)) {
            var1.a(class_cy.E, var7, var9, var11, 0.0D, 0.0D, 0.0D, new int[0]);
         }
      }

   }

   protected class_aas i(IBlockData var1) {
      return new class_aas(class_agk.aC);
   }
}
