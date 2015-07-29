package net.minecraft.server;

import net.minecraft.server.class_aer;
import net.minecraft.server.class_agf;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahl;
import net.minecraft.server.class_ahz;
import net.minecraft.server.class_aia;
import net.minecraft.server.class_alv;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_aut;
import net.minecraft.server.class_auu;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;

public class class_auz extends class_auu {
   private boolean f;
   private boolean g;
   private boolean h;
   private boolean i;
   private boolean j;

   public void a(class_aer var1, class_pr var2) {
      super.a(var1, var2);
      this.j = this.h;
   }

   public void a() {
      super.a();
      this.h = this.j;
   }

   public class_aut a(class_pr var1) {
      int var2;
      if(this.i && var1.V()) {
         var2 = (int)var1.aT().b;
         class_cj.class_a_in_class_cj var3 = new class_cj.class_a_in_class_cj(class_nu.c(var1.s), var2, class_nu.c(var1.u));

         for(class_agj var4 = this.a.p(var3).c(); var4 == class_agk.i || var4 == class_agk.j; var4 = this.a.p(var3).c()) {
            ++var2;
            var3.c(class_nu.c(var1.s), var2, class_nu.c(var1.u));
         }

         this.h = false;
      } else {
         var2 = class_nu.c(var1.aT().b + 0.5D);
      }

      return this.a(class_nu.c(var1.aT().a), var2, class_nu.c(var1.aT().c));
   }

   public class_aut a(class_pr var1, double var2, double var4, double var6) {
      return this.a(class_nu.c(var2 - (double)(var1.J / 2.0F)), class_nu.c(var4), class_nu.c(var6 - (double)(var1.J / 2.0F)));
   }

   public int a(class_aut[] var1, class_pr var2, class_aut var3, class_aut var4, float var5) {
      int var6 = 0;
      byte var7 = 0;
      if(this.a(var2, var3.a, var3.b + 1, var3.c) == 1) {
         var7 = 1;
      }

      class_aut var8 = this.a(var2, var3.a, var3.b, var3.c + 1, var7);
      class_aut var9 = this.a(var2, var3.a - 1, var3.b, var3.c, var7);
      class_aut var10 = this.a(var2, var3.a + 1, var3.b, var3.c, var7);
      class_aut var11 = this.a(var2, var3.a, var3.b, var3.c - 1, var7);
      if(var8 != null && !var8.i && var8.a(var4) < var5) {
         var1[var6++] = var8;
      }

      if(var9 != null && !var9.i && var9.a(var4) < var5) {
         var1[var6++] = var9;
      }

      if(var10 != null && !var10.i && var10.a(var4) < var5) {
         var1[var6++] = var10;
      }

      if(var11 != null && !var11.i && var11.a(var4) < var5) {
         var1[var6++] = var11;
      }

      return var6;
   }

   private class_aut a(class_pr var1, int var2, int var3, int var4, int var5) {
      class_aut var6 = null;
      int var7 = this.a(var1, var2, var3, var4);
      if(var7 == 2) {
         return this.a(var2, var3, var4);
      } else {
         if(var7 == 1) {
            var6 = this.a(var2, var3, var4);
         }

         if(var6 == null && var5 > 0 && var7 != -3 && var7 != -4 && this.a(var1, var2, var3 + var5, var4) == 1) {
            var6 = this.a(var2, var3 + var5, var4);
            var3 += var5;
         }

         if(var6 != null) {
            int var8 = 0;

            int var9;
            for(var9 = 0; var3 > 0; var6 = this.a(var2, var3, var4)) {
               var9 = this.a(var1, var2, var3 - 1, var4);
               if(this.h && var9 == -1) {
                  return null;
               }

               if(var9 != 1) {
                  break;
               }

               if(var8++ >= var1.aG()) {
                  return null;
               }

               --var3;
               if(var3 <= 0) {
                  return null;
               }
            }

            if(var9 == -2) {
               return null;
            }
         }

         return var6;
      }
   }

   private int a(class_pr var1, int var2, int var3, int var4) {
      return a(this.a, var1, var2, var3, var4, this.c, this.d, this.e, this.h, this.g, this.f);
   }

   public static int a(class_aer var0, class_pr var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, boolean var9, boolean var10) {
      boolean var11 = false;
      class_cj var12 = new class_cj(var1);
      class_cj.class_a_in_class_cj var13 = new class_cj.class_a_in_class_cj();

      for(int var14 = var2; var14 < var2 + var5; ++var14) {
         for(int var15 = var3; var15 < var3 + var6; ++var15) {
            for(int var16 = var4; var16 < var4 + var7; ++var16) {
               var13.c(var14, var15, var16);
               class_agj var17 = var0.p(var13).c();
               if(var17.v() != class_atk.a) {
                  if(var17 != class_agk.bd && var17 != class_agk.cw) {
                     if(var17 != class_agk.i && var17 != class_agk.j) {
                        if(!var10 && var17 instanceof class_ahl && var17.v() == class_atk.d) {
                           return 0;
                        }
                     } else {
                        if(var8) {
                           return -1;
                        }

                        var11 = true;
                     }
                  } else {
                     var11 = true;
                  }

                  if(var1.o.p(var13).c() instanceof class_agf) {
                     if(!(var1.o.p(var12).c() instanceof class_agf) && !(var1.o.p(var12.b()).c() instanceof class_agf)) {
                        return -3;
                     }
                  } else if(!var17.b(var0, var13) && (!var9 || !(var17 instanceof class_ahl) || var17.v() != class_atk.d)) {
                     if(var17 instanceof class_ahz || var17 instanceof class_aia || var17 instanceof class_alv) {
                        return -3;
                     }

                     if(var17 == class_agk.bd || var17 == class_agk.cw) {
                        return -4;
                     }

                     class_atk var18 = var17.v();
                     if(var18 != class_atk.i) {
                        return 0;
                     }

                     if(!var1.ab()) {
                        return -2;
                     }
                  }
               }
            }
         }
      }

      return var11?2:1;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public void b(boolean var1) {
      this.g = var1;
   }

   public void c(boolean var1) {
      this.h = var1;
   }

   public void d(boolean var1) {
      this.i = var1;
   }

   public boolean b() {
      return this.f;
   }

   public boolean d() {
      return this.i;
   }

   public boolean e() {
      return this.h;
   }
}
