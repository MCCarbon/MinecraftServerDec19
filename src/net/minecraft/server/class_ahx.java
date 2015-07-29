package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vl;
import net.minecraft.server.class_zu;

public class class_ahx extends class_agj {
   public static boolean N;

   public class_ahx() {
      super(class_atk.p);
      this.a((class_zu)class_zu.b);
   }

   public class_ahx(class_atk var1) {
      super(var1);
   }

   public void c(class_aen var1, class_cj var2, class_anl var3) {
      var1.a((class_cj)var2, (class_agj)this, this.a(var1));
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      var1.a((class_cj)var2, (class_agj)this, this.a(var1));
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(!var1.D) {
         this.f(var1, var2);
      }

   }

   private void f(class_aen var1, class_cj var2) {
      if(e(var1, var2.b()) && var2.o() >= 0) {
         byte var3 = 32;
         if(!N && var1.a(var2.a(-var3, -var3, -var3), var2.a(var3, var3, var3))) {
            if(!var1.D) {
               class_vl var5 = new class_vl(var1, (double)var2.n() + 0.5D, (double)var2.o(), (double)var2.p() + 0.5D, var1.p(var2));
               this.a(var5);
               var1.a((class_pr)var5);
            }
         } else {
            var1.g(var2);

            class_cj var4;
            for(var4 = var2.b(); e(var1, var4) && var4.o() > 0; var4 = var4.b()) {
               ;
            }

            if(var4.o() > 0) {
               var1.a(var4.a(), this.S());
            }
         }

      }
   }

   protected void a(class_vl var1) {
   }

   public int a(class_aen var1) {
      return 2;
   }

   public static boolean e(class_aen var0, class_cj var1) {
      class_agj var2 = var0.p(var1).c();
      class_atk var3 = var2.J;
      return var2 == class_agk.ab || var3 == class_atk.a || var3 == class_atk.h || var3 == class_atk.i;
   }

   public void a_(class_aen var1, class_cj var2) {
   }
}
