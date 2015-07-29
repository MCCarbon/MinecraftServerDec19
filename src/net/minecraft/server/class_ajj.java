package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_zu;

public class class_ajj extends class_agj {
   public static final class_anw a = class_anw.a("snowy");

   protected class_ajj() {
      super(class_atk.b, class_atl.z);
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
            var1.a(var2, class_agk.d.S().a(class_ahj.a, class_ahj.class_a_in_class_ahj.a));
         } else {
            if(var1.l(var2.a()) >= 9) {
               for(int var5 = 0; var5 < 4; ++var5) {
                  class_cj var6 = var2.a(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
                  class_anl var7 = var1.p(var6);
                  class_agj var8 = var1.p(var6.a()).c();
                  if(var7.c() == class_agk.d && var7.b(class_ahj.a) == class_ahj.class_a_in_class_ahj.a && var1.l(var6.a()) >= 4 && var8.r() <= 2) {
                     var1.a(var6, this.S());
                  }
               }
            }

         }
      }
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return class_agk.d.a(class_agk.d.S().a(class_ahj.a, class_ahj.class_a_in_class_ahj.a), var2, var3);
   }

   public int c(class_anl var1) {
      return 0;
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }
}
