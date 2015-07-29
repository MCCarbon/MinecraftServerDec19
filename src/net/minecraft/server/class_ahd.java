package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_ahy;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_zu;

public class class_ahd extends class_ago implements class_agl {
   public static final class_anz b = class_anz.a("age", 0, 7);

   protected class_ahd() {
      this.j(this.M.b().a(this.l(), Integer.valueOf(0)));
      this.a(true);
      float var1 = 0.5F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
      this.a((class_zu)null);
      this.c(0.0F);
      this.a(h);
      this.M();
   }

   protected boolean c(class_agj var1) {
      return var1 == class_agk.ak;
   }

   protected class_anz l() {
      return b;
   }

   public int n() {
      return 7;
   }

   protected int d(class_anl var1) {
      return ((Integer)var1.b(this.l())).intValue();
   }

   public class_anl b(int var1) {
      return this.S().a(this.l(), Integer.valueOf(var1));
   }

   public boolean e(class_anl var1) {
      return ((Integer)var1.b(this.l())).intValue() >= this.n();
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      super.b(var1, var2, var3, var4);
      if(var1.l(var2.a()) >= 9) {
         int var5 = this.d(var3);
         if(var5 < this.n()) {
            float var6 = a(this, var1, var2);
            if(var4.nextInt((int)(25.0F / var6) + 1) == 0) {
               var1.a((class_cj)var2, (class_anl)this.b(var5 + 1), 2);
            }
         }
      }

   }

   public void g(class_aen var1, class_cj var2, class_anl var3) {
      int var4 = this.d(var3) + this.b(var1);
      int var5 = this.n();
      if(var4 > var5) {
         var4 = var5;
      }

      var1.a((class_cj)var2, (class_anl)this.b(var4), 2);
   }

   protected int b(class_aen var1) {
      return class_nu.a((Random)var1.s, 2, 5);
   }

   protected static float a(class_agj var0, class_aen var1, class_cj var2) {
      float var3 = 1.0F;
      class_cj var4 = var2.b();

      for(int var5 = -1; var5 <= 1; ++var5) {
         for(int var6 = -1; var6 <= 1; ++var6) {
            float var7 = 0.0F;
            class_anl var8 = var1.p(var4.a(var5, 0, var6));
            if(var8.c() == class_agk.ak) {
               var7 = 1.0F;
               if(((Integer)var8.b(class_ahy.a)).intValue() > 0) {
                  var7 = 3.0F;
               }
            }

            if(var5 != 0 || var6 != 0) {
               var7 /= 4.0F;
            }

            var3 += var7;
         }
      }

      class_cj var12 = var2.c();
      class_cj var13 = var2.d();
      class_cj var15 = var2.e();
      class_cj var14 = var2.f();
      boolean var9 = var0 == var1.p(var15).c() || var0 == var1.p(var14).c();
      boolean var10 = var0 == var1.p(var12).c() || var0 == var1.p(var13).c();
      if(var9 && var10) {
         var3 /= 2.0F;
      } else {
         boolean var11 = var0 == var1.p(var15.c()).c() || var0 == var1.p(var14.c()).c() || var0 == var1.p(var14.d()).c() || var0 == var1.p(var15.d()).c();
         if(var11) {
            var3 /= 2.0F;
         }
      }

      return var3;
   }

   public boolean f(class_aen var1, class_cj var2, class_anl var3) {
      return (var1.k(var2) >= 8 || var1.i(var2)) && this.c(var1.p(var2.b()).c());
   }

   protected class_aar o() {
      return class_aau.P;
   }

   protected class_aar p() {
      return class_aau.Q;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, 0);
      if(!var1.D) {
         int var6 = this.d(var3);
         if(var6 >= this.n()) {
            int var7 = 3 + var5;

            for(int var8 = 0; var8 < var7; ++var8) {
               if(var1.s.nextInt(15) <= var6) {
                  a(var1, var2, new class_aas(this.o()));
               }
            }
         }

      }
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return this.e(var1)?this.p():this.o();
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, boolean var4) {
      return !this.e(var3);
   }

   public boolean a(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      return true;
   }

   public void b(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      this.g(var1, var3, var4);
   }

   public class_anl a(int var1) {
      return this.b(var1);
   }

   public int c(class_anl var1) {
      return this.d(var1);
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{b});
   }
}
