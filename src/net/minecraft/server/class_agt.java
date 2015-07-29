package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_abe;
import net.minecraft.server.class_acf;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_ame;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_za;
import net.minecraft.server.class_ze;

public class class_agt extends class_agj {
   public static final class_anz a = class_anz.a("level", 0, 3);

   public class_agt() {
      super(class_atk.f, class_atl.m);
      this.j(this.M.b().a(a, Integer.valueOf(0)));
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_awf var4, List var5, class_pr var6) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      float var7 = 0.125F;
      this.a(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.j();
   }

   public void j() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_pr var4) {
      int var5 = ((Integer)var3.b(a)).intValue();
      float var6 = (float)var2.o() + (6.0F + (float)(3 * var5)) / 16.0F;
      if(!var1.D && var4.av() && var5 > 0 && var4.aT().b <= (double)var6) {
         var4.N();
         this.a(var1, var2, var3, var5 - 1);
      }

   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else if(var6 == null) {
         return true;
      } else {
         int var11 = ((Integer)var3.b(a)).intValue();
         class_aar var12 = var6.b();
         if(var12 == class_aau.az) {
            if(var11 < 3) {
               if(!var4.bH.d) {
                  var4.a((class_oo)var5, (class_aas)(new class_aas(class_aau.ay)));
               }

               var4.b(class_nc.I);
               this.a(var1, var2, var3, 3);
            }

            return true;
         } else {
            class_aas var14;
            if(var12 == class_aau.bD) {
               if(var11 > 0) {
                  if(!var4.bH.d) {
                     var14 = class_abe.a(new class_aas(class_aau.bB), class_acf.a);
                     var4.b(class_nc.J);
                     if(--var6.b == 0) {
                        var4.a((class_oo)var5, (class_aas)var14);
                     } else if(!var4.bp.a(var14)) {
                        var4.a(var14, false);
                     } else if(var4 instanceof class_lh) {
                        ((class_lh)var4).a(var4.bq);
                     }
                  }

                  this.a(var1, var2, var3, var11 - 1);
               }

               return true;
            } else {
               if(var11 > 0 && var12 instanceof class_za) {
                  class_za var13 = (class_za)var12;
                  if(var13.d() == class_za.class_a_in_class_za.a && var13.d_(var6)) {
                     var13.c(var6);
                     this.a(var1, var2, var3, var11 - 1);
                     var4.b(class_nc.K);
                     return true;
                  }
               }

               if(var11 > 0 && var12 instanceof class_ze && class_ame.c(var6) > 0) {
                  var14 = var6.k();
                  var14.b = 1;
                  class_ame.e(var14);
                  var4.b(class_nc.L);
                  if(var4.bH.d) {
                     --var6.b;
                  }

                  if(var6.b == 0) {
                     var4.a((class_oo)var5, (class_aas)var14);
                  } else if(!var4.bp.a(var14)) {
                     var4.a(var14, false);
                  } else if(var4 instanceof class_lh) {
                     ((class_lh)var4).a(var4.bq);
                  }

                  if(!var4.bH.d) {
                     this.a(var1, var2, var3, var11 - 1);
                  }

                  return true;
               } else {
                  return false;
               }
            }
         }
      }
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, int var4) {
      var1.a((class_cj)var2, (class_anl)var3.a(a, Integer.valueOf(class_nu.a(var4, 0, 3))), 2);
      var1.e(var2, this);
   }

   public void k(class_aen var1, class_cj var2) {
      if(var1.s.nextInt(20) == 1) {
         class_anl var3 = var1.p(var2);
         if(((Integer)var3.b(a)).intValue() < 3) {
            var1.a((class_cj)var2, (class_anl)var3.a(a), 2);
         }

      }
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return class_aau.bJ;
   }

   public boolean Q() {
      return true;
   }

   public int l(class_aen var1, class_cj var2) {
      return ((Integer)var1.p(var2).b(a)).intValue();
   }

   public class_anl a(int var1) {
      return this.S().a(a, Integer.valueOf(var1));
   }

   public int c(class_anl var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }
}
