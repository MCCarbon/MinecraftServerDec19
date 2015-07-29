package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahx;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vl;
import net.minecraft.server.class_xa;

public class class_ahn extends Block {
   public class_ahn() {
      super(class_atk.D, class_atl.E);
      this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
   }

   public void c(class_aen var1, class_cj var2, IBlockData var3) {
      var1.a((class_cj)var2, (Block)this, this.a(var1));
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      var1.a((class_cj)var2, (Block)this, this.a(var1));
   }

   public void b(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
      this.e(var1, var2);
   }

   private void e(class_aen var1, class_cj var2) {
      if(class_ahx.e(var1, var2.b()) && var2.o() >= 0) {
         byte var3 = 32;
         if(!class_ahx.N && var1.a(var2.a(-var3, -var3, -var3), var2.a(var3, var3, var3))) {
            var1.a((class_pr)(new class_vl(var1, (double)((float)var2.n() + 0.5F), (double)var2.o(), (double)((float)var2.p() + 0.5F), this.S())));
         } else {
            var1.g(var2);

            class_cj var4;
            for(var4 = var2; class_ahx.e(var1, var4) && var4.o() > 0; var4 = var4.b()) {
               ;
            }

            if(var4.o() > 0) {
               var1.a((class_cj)var4, (IBlockData)this.S(), 2);
            }
         }

      }
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      this.f(var1, var2);
      return true;
   }

   public void a(class_aen var1, class_cj var2, class_xa var3) {
      this.f(var1, var2);
   }

   private void f(class_aen var1, class_cj var2) {
      IBlockData var3 = var1.p(var2);
      if(var3.getBlock() == this) {
         for(int var4 = 0; var4 < 1000; ++var4) {
            class_cj var5 = var2.a(var1.s.nextInt(16) - var1.s.nextInt(16), var1.s.nextInt(8) - var1.s.nextInt(8), var1.s.nextInt(16) - var1.s.nextInt(16));
            if(var1.p(var5).getBlock().J == class_atk.a) {
               if(var1.D) {
                  for(int var6 = 0; var6 < 128; ++var6) {
                     double var7 = var1.s.nextDouble();
                     float var9 = (var1.s.nextFloat() - 0.5F) * 0.2F;
                     float var10 = (var1.s.nextFloat() - 0.5F) * 0.2F;
                     float var11 = (var1.s.nextFloat() - 0.5F) * 0.2F;
                     double var12 = (double)var5.n() + (double)(var2.n() - var5.n()) * var7 + (var1.s.nextDouble() - 0.5D) * 1.0D + 0.5D;
                     double var14 = (double)var5.o() + (double)(var2.o() - var5.o()) * var7 + var1.s.nextDouble() * 1.0D - 0.5D;
                     double var16 = (double)var5.p() + (double)(var2.p() - var5.p()) * var7 + (var1.s.nextDouble() - 0.5D) * 1.0D + 0.5D;
                     var1.a(class_cy.y, var12, var14, var16, (double)var9, (double)var10, (double)var11, new int[0]);
                  }
               } else {
                  var1.a((class_cj)var5, (IBlockData)var3, 2);
                  var1.g(var2);
               }

               return;
            }
         }

      }
   }

   public int a(class_aen var1) {
      return 5;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }
}
