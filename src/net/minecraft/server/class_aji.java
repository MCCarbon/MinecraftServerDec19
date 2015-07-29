package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_aqr;
import net.minecraft.server.class_cj;

public class class_aji extends class_ago implements class_agl {
   protected class_aji() {
      float var1 = 0.2F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
      this.a(true);
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(var4.nextInt(25) == 0) {
         int var5 = 5;
         boolean var6 = true;
         Iterator var7 = class_cj.b(var2.a(-4, -1, -4), var2.a(4, 1, 4)).iterator();

         while(var7.hasNext()) {
            class_cj var8 = (class_cj)var7.next();
            if(var1.p(var8).c() == this) {
               --var5;
               if(var5 <= 0) {
                  return;
               }
            }
         }

         class_cj var9 = var2.a(var4.nextInt(3) - 1, var4.nextInt(2) - var4.nextInt(2), var4.nextInt(3) - 1);

         for(int var10 = 0; var10 < 4; ++var10) {
            if(var1.d(var9) && this.f(var1, var9, this.S())) {
               var2 = var9;
            }

            var9 = var2.a(var4.nextInt(3) - 1, var4.nextInt(2) - var4.nextInt(2), var4.nextInt(3) - 1);
         }

         if(var1.d(var9) && this.f(var1, var9, this.S())) {
            var1.a((class_cj)var9, (class_anl)this.S(), 2);
         }
      }

   }

   public boolean d(class_aen var1, class_cj var2) {
      return super.d(var1, var2) && this.f(var1, var2, this.S());
   }

   protected boolean c(class_agj var1) {
      return var1.q();
   }

   public boolean f(class_aen var1, class_cj var2, class_anl var3) {
      if(var2.o() >= 0 && var2.o() < 256) {
         class_anl var4 = var1.p(var2.b());
         return var4.c() == class_agk.bw?true:(var4.c() == class_agk.d && var4.b(class_ahj.a) == class_ahj.class_a_in_class_ahj.c?true:var1.k(var2) < 13 && this.c(var4.c()));
      } else {
         return false;
      }
   }

   public boolean d(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      var1.g(var2);
      class_aqr var5 = null;
      if(this == class_agk.P) {
         var5 = new class_aqr(class_agk.bg);
      } else if(this == class_agk.Q) {
         var5 = new class_aqr(class_agk.bh);
      }

      if(var5 != null && var5.b(var1, var4, var2)) {
         return true;
      } else {
         var1.a((class_cj)var2, (class_anl)var3, 3);
         return false;
      }
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, boolean var4) {
      return true;
   }

   public boolean a(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      return (double)var2.nextFloat() < 0.4D;
   }

   public void b(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      this.d(var1, var3, var4, var2);
   }
}
