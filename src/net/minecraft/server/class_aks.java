package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_ajs;
import net.minecraft.server.class_ajt;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_apx;
import net.minecraft.server.class_apy;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_aqw;
import net.minecraft.server.class_aqx;
import net.minecraft.server.class_arf;
import net.minecraft.server.class_arh;
import net.minecraft.server.class_ark;
import net.minecraft.server.class_arn;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_di;
import net.minecraft.server.class_zu;

public class class_aks extends class_ago implements class_agl {
   public static final class_any a = class_any.a("type", class_ajw.class_a_in_class_ajw.class);
   public static final class_anz b = class_anz.a("stage", 0, 1);

   protected class_aks() {
      this.j(this.M.b().a(a, class_ajw.class_a_in_class_ajw.a).a(b, Integer.valueOf(0)));
      float var1 = 0.4F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
      this.a(class_zu.c);
   }

   public String f() {
      return class_di.a(this.a() + "." + class_ajw.class_a_in_class_ajw.a.d() + ".name");
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(!var1.D) {
         super.b(var1, var2, var3, var4);
         if(var1.l(var2.a()) >= 9 && var4.nextInt(7) == 0) {
            this.d(var1, var2, var3, var4);
         }

      }
   }

   public void d(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(((Integer)var3.b(b)).intValue() == 0) {
         var1.a((class_cj)var2, (class_anl)var3.a(b), 4);
      } else {
         this.e(var1, var2, var3, var4);
      }

   }

   public void e(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      Object var5 = var4.nextInt(10) == 0?new class_apx(true):new class_arn(true);
      int var6 = 0;
      int var7 = 0;
      boolean var8 = false;
      class_anl var9;
      switch(class_aks.SyntheticClass_1.a[((class_ajw.class_a_in_class_ajw)var3.b(a)).ordinal()]) {
      case 1:
         label68:
         for(var6 = 0; var6 >= -1; --var6) {
            for(var7 = 0; var7 >= -1; --var7) {
               if(this.a(var1, var2, var6, var7, class_ajw.class_a_in_class_ajw.b)) {
                  var5 = new class_aqx(false, var4.nextBoolean());
                  var8 = true;
                  break label68;
               }
            }
         }

         if(!var8) {
            var7 = 0;
            var6 = 0;
            var5 = new class_ark(true);
         }
         break;
      case 2:
         var5 = new class_apy(true, false);
         break;
      case 3:
         var9 = class_agk.r.S().a(class_ajt.b, class_ajw.class_a_in_class_ajw.d);
         class_anl var10 = class_agk.t.S().a(class_ajs.Q, class_ajw.class_a_in_class_ajw.d).a(class_aja.b, Boolean.valueOf(false));

         label82:
         for(var6 = 0; var6 >= -1; --var6) {
            for(var7 = 0; var7 >= -1; --var7) {
               if(this.a(var1, var2, var6, var7, class_ajw.class_a_in_class_ajw.d)) {
                  var5 = new class_aqw(true, 10, 20, var9, var10);
                  var8 = true;
                  break label82;
               }
            }
         }

         if(!var8) {
            var7 = 0;
            var6 = 0;
            var5 = new class_arn(true, 4 + var4.nextInt(7), var9, var10, false);
         }
         break;
      case 4:
         var5 = new class_arh(true);
         break;
      case 5:
         label96:
         for(var6 = 0; var6 >= -1; --var6) {
            for(var7 = 0; var7 >= -1; --var7) {
               if(this.a(var1, var2, var6, var7, class_ajw.class_a_in_class_ajw.f)) {
                  var5 = new class_arf(true);
                  var8 = true;
                  break label96;
               }
            }
         }

         if(!var8) {
            return;
         }
      case 6:
      }

      var9 = class_agk.a.S();
      if(var8) {
         var1.a((class_cj)var2.a(var6, 0, var7), (class_anl)var9, 4);
         var1.a((class_cj)var2.a(var6 + 1, 0, var7), (class_anl)var9, 4);
         var1.a((class_cj)var2.a(var6, 0, var7 + 1), (class_anl)var9, 4);
         var1.a((class_cj)var2.a(var6 + 1, 0, var7 + 1), (class_anl)var9, 4);
      } else {
         var1.a((class_cj)var2, (class_anl)var9, 4);
      }

      if(!((class_aql)var5).b(var1, var4, var2.a(var6, 0, var7))) {
         if(var8) {
            var1.a((class_cj)var2.a(var6, 0, var7), (class_anl)var3, 4);
            var1.a((class_cj)var2.a(var6 + 1, 0, var7), (class_anl)var3, 4);
            var1.a((class_cj)var2.a(var6, 0, var7 + 1), (class_anl)var3, 4);
            var1.a((class_cj)var2.a(var6 + 1, 0, var7 + 1), (class_anl)var3, 4);
         } else {
            var1.a((class_cj)var2, (class_anl)var3, 4);
         }
      }

   }

   private boolean a(class_aen var1, class_cj var2, int var3, int var4, class_ajw.class_a_in_class_ajw var5) {
      return this.a(var1, var2.a(var3, 0, var4), var5) && this.a(var1, var2.a(var3 + 1, 0, var4), var5) && this.a(var1, var2.a(var3, 0, var4 + 1), var5) && this.a(var1, var2.a(var3 + 1, 0, var4 + 1), var5);
   }

   public boolean a(class_aen var1, class_cj var2, class_ajw.class_a_in_class_ajw var3) {
      class_anl var4 = var1.p(var2);
      return var4.c() == this && var4.b(a) == var3;
   }

   public int a(class_anl var1) {
      return ((class_ajw.class_a_in_class_ajw)var1.b(a)).a();
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, boolean var4) {
      return true;
   }

   public boolean a(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      return (double)var1.s.nextFloat() < 0.45D;
   }

   public void b(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      this.d(var1, var3, var4, var2);
   }

   public class_anl a(int var1) {
      return this.S().a(a, class_ajw.class_a_in_class_ajw.a(var1 & 7)).a(b, Integer.valueOf((var1 & 8) >> 3));
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_ajw.class_a_in_class_ajw)var1.b(a)).a();
      var3 |= ((Integer)var1.b(b)).intValue() << 3;
      return var3;
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a, b});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_ajw.class_a_in_class_ajw.values().length];

      static {
         try {
            a[class_ajw.class_a_in_class_ajw.b.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_ajw.class_a_in_class_ajw.c.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_ajw.class_a_in_class_ajw.d.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_ajw.class_a_in_class_ajw.e.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_ajw.class_a_in_class_ajw.f.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_ajw.class_a_in_class_ajw.a.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
