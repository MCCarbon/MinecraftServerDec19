package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_aic;
import net.minecraft.server.class_alm;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_zu;

public class class_aik extends class_agj implements class_agl {
   public static final class_anw a = class_anw.a("snowy");

   protected class_aik() {
      super(class_atk.b);
      this.j(this.M.b().a(a, Boolean.valueOf(false)));
      this.a(true);
      this.a(class_zu.b);
   }

   public class_anl a(class_anl var1, class_aer var2, class_cj var3) {
      class_agj var4 = var2.p(var3.a()).c();
      return var1.a(a, Boolean.valueOf(var4 == class_agk.aJ || var4 == class_agk.aH));
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(!var1.D) {
         if(var1.l(var2.a()) < 4 && var1.p(var2.a()).c().r() > 2) {
            var1.a(var2, class_agk.d.S());
         } else {
            if(var1.l(var2.a()) >= 9) {
               for(int var5 = 0; var5 < 4; ++var5) {
                  class_cj var6 = var2.a(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
                  class_agj var7 = var1.p(var6.a()).c();
                  class_anl var8 = var1.p(var6);
                  if(var8.c() == class_agk.d && var8.b(class_ahj.a) == class_ahj.class_a_in_class_ahj.a && var1.l(var6.a()) >= 4 && var7.r() <= 2) {
                     var1.a(var6, class_agk.c.S());
                  }
               }
            }

         }
      }
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return class_agk.d.a(class_agk.d.S().a(class_ahj.a, class_ahj.class_a_in_class_ahj.a), var2, var3);
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, boolean var4) {
      return true;
   }

   public boolean a(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      return true;
   }

   public void b(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      class_cj var5 = var3.a();

      label38:
      for(int var6 = 0; var6 < 128; ++var6) {
         class_cj var7 = var5;

         for(int var8 = 0; var8 < var6 / 16; ++var8) {
            var7 = var7.a(var2.nextInt(3) - 1, (var2.nextInt(3) - 1) * var2.nextInt(3) / 2, var2.nextInt(3) - 1);
            if(var1.p(var7.b()).c() != class_agk.c || var1.p(var7).c().x()) {
               continue label38;
            }
         }

         if(var1.p(var7).c().J == class_atk.a) {
            if(var2.nextInt(8) == 0) {
               class_aic.class_a_in_class_aic var11 = var1.b(var7).a(var2, var7);
               class_aic var9 = var11.a().a();
               class_anl var10 = var9.S().a(var9.n(), var11);
               if(var9.f(var1, var7, var10)) {
                  var1.a((class_cj)var7, (class_anl)var10, 3);
               }
            } else {
               class_anl var12 = class_agk.H.S().a(class_alm.a, class_alm.class_a_in_class_alm.b);
               if(class_agk.H.f(var1, var7, var12)) {
                  var1.a((class_cj)var7, (class_anl)var12, 3);
               }
            }
         }
      }

   }

   public int c(class_anl var1) {
      return 0;
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }
}
