package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aok;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_aew implements class_aer {
   protected int a;
   protected int b;
   protected class_aok[][] c;
   protected boolean d;
   protected class_aen e;

   public class_aew(class_aen var1, class_cj var2, class_cj var3, int var4) {
      this.e = var1;
      this.a = var2.n() - var4 >> 4;
      this.b = var2.p() - var4 >> 4;
      int var5 = var3.n() + var4 >> 4;
      int var6 = var3.p() + var4 >> 4;
      this.c = new class_aok[var5 - this.a + 1][var6 - this.b + 1];
      this.d = true;

      int var7;
      int var8;
      for(var7 = this.a; var7 <= var5; ++var7) {
         for(var8 = this.b; var8 <= var6; ++var8) {
            this.c[var7 - this.a][var8 - this.b] = var1.a(var7, var8);
         }
      }

      for(var7 = var2.n() >> 4; var7 <= var3.n() >> 4; ++var7) {
         for(var8 = var2.p() >> 4; var8 <= var3.p() >> 4; ++var8) {
            class_aok var9 = this.c[var7 - this.a][var8 - this.b];
            if(var9 != null && !var9.c(var2.o(), var3.o())) {
               this.d = false;
            }
         }
      }

   }

   public class_amg s(class_cj var1) {
      int var2 = (var1.n() >> 4) - this.a;
      int var3 = (var1.p() >> 4) - this.b;
      return this.c[var2][var3].a(var1, class_aok.class_a_in_class_aok.a);
   }

   public IBlockData p(class_cj var1) {
      if(var1.o() >= 0 && var1.o() < 256) {
         int var2 = (var1.n() >> 4) - this.a;
         int var3 = (var1.p() >> 4) - this.b;
         if(var2 >= 0 && var2 < this.c.length && var3 >= 0 && var3 < this.c[var2].length) {
            class_aok var4 = this.c[var2][var3];
            if(var4 != null) {
               return var4.g(var1);
            }
         }
      }

      return class_agk.a.S();
   }

   public boolean d(class_cj var1) {
      return this.p(var1).getBlock().v() == class_atk.a;
   }

   public int a(class_cj var1, class_cq var2) {
      IBlockData var3 = this.p(var1);
      return var3.getBlock().b((class_aer)this, var1, var3, (class_cq)var2);
   }
}
