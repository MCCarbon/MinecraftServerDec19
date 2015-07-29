package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_uq;

public class class_ari extends class_aql {
   private class_ari.class_a_in_class_ari a = null;

   public void a(class_ari.class_a_in_class_ari var1) {
      this.a = var1;
   }

   public boolean b(World var1, Random var2, class_cj var3) {
      if(this.a == null) {
         throw new IllegalStateException("Decoration requires priming with a spike");
      } else {
         Iterator var4 = class_cj.b(var3.a(-this.a.c(), -10, -this.a.c()), var3.a(this.a.c(), this.a.d() - 1, this.a.c())).iterator();

         while(var4.hasNext()) {
            class_cj.class_a_in_class_cj var5 = (class_cj.class_a_in_class_cj)var4.next();
            if(var5.c((double)var3.n(), (double)var5.o(), (double)var3.p()) <= (double)(this.a.c() * this.a.c() + 1)) {
               this.a(var1, var5, Blocks.OBSIDIAN.getBlockData());
            }
         }

         if(this.a.e()) {
            for(int var6 = -2; var6 <= 2; ++var6) {
               for(int var8 = -2; var8 <= 2; ++var8) {
                  if(class_nu.a(var6) == 2 || class_nu.a(var8) == 2) {
                     this.a(var1, var3.a(var6, this.a.d(), var8), Blocks.IRON_BARS.getBlockData());
                     this.a(var1, var3.a(var6, this.a.d() + 1, var8), Blocks.IRON_BARS.getBlockData());
                     this.a(var1, var3.a(var6, this.a.d() + 2, var8), Blocks.IRON_BARS.getBlockData());
                  }

                  this.a(var1, var3.a(var6, this.a.d() + 3, var8), Blocks.IRON_BARS.getBlockData());
               }
            }
         }

         class_uq var7 = new class_uq(var1);
         var7.b((double)((float)var3.n() + 0.5F), (double)(var3.o() + this.a.d() + 1), (double)((float)var3.p() + 0.5F), var2.nextFloat() * 360.0F, 0.0F);
         var1.a((class_pr)var7);
         this.a(var1, var3.b(this.a.d()), Blocks.BEDROCK.getBlockData());
         return true;
      }
   }

   public static class class_a_in_class_ari {
      private final int a;
      private final int b;
      private final int c;
      private final int d;
      private final boolean e;
      private final class_awf f;

      public class_a_in_class_ari(int var1, int var2, int var3, int var4, boolean var5) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = new class_awf((double)(var1 - var3), 0.0D, (double)(var2 - var3), (double)(var1 + var3), 256.0D, (double)(var2 + var3));
      }

      public boolean a(class_cj var1) {
         int var2 = this.a - this.c;
         int var3 = this.b - this.c;
         return var1.n() == (var2 & -16) && var1.p() == (var3 & -16);
      }

      public int a() {
         return this.a;
      }

      public int b() {
         return this.b;
      }

      public int c() {
         return this.c;
      }

      public int d() {
         return this.d;
      }

      public boolean e() {
         return this.e;
      }

      public class_awf f() {
         return this.f;
      }
   }
}
