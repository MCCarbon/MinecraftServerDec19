package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_akn extends class_agj {
   public static final class_anz a = class_anz.a("age", 0, 15);

   protected class_akn() {
      super(class_atk.k);
      this.j(this.M.b().a(a, Integer.valueOf(0)));
      float var1 = 0.375F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 1.0F, 0.5F + var1);
      this.a(true);
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(var1.p(var2.b()).c() == class_agk.aM || this.e(var1, var2, var3)) {
         if(var1.d(var2.a())) {
            int var5;
            for(var5 = 1; var1.p(var2.c(var5)).c() == this; ++var5) {
               ;
            }

            if(var5 < 3) {
               int var6 = ((Integer)var3.b(a)).intValue();
               if(var6 == 15) {
                  var1.a(var2.a(), this.S());
                  var1.a((class_cj)var2, (class_anl)var3.a(a, Integer.valueOf(0)), 4);
               } else {
                  var1.a((class_cj)var2, (class_anl)var3.a(a, Integer.valueOf(var6 + 1)), 4);
               }
            }
         }

      }
   }

   public boolean d(class_aen var1, class_cj var2) {
      class_agj var3 = var1.p(var2.b()).c();
      if(var3 == this) {
         return true;
      } else if(var3 != class_agk.c && var3 != class_agk.d && var3 != class_agk.m) {
         return false;
      } else {
         Iterator var4 = class_cq.class_c_in_class_cq.a.iterator();

         class_cq var5;
         do {
            if(!var4.hasNext()) {
               return false;
            }

            var5 = (class_cq)var4.next();
         } while(var1.p(var2.a(var5).b()).c().v() != class_atk.h);

         return true;
      }
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      this.e(var1, var2, var3);
   }

   protected final boolean e(class_aen var1, class_cj var2, class_anl var3) {
      if(this.e(var1, var2)) {
         return true;
      } else {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      }
   }

   public boolean e(class_aen var1, class_cj var2) {
      return this.d(var1, var2);
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      return null;
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return class_aau.aL;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
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
