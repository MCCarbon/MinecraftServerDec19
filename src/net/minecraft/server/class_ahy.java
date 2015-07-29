package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahd;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_alg;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;

public class class_ahy extends class_agj {
   public static final class_anz a = class_anz.a("moisture", 0, 7);

   protected class_ahy() {
      super(class_atk.c);
      this.j(this.M.b().a(a, Integer.valueOf(0)));
      this.a(true);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
      this.e(255);
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      return new class_awf((double)var2.n(), (double)var2.o(), (double)var2.p(), (double)(var2.n() + 1), (double)(var2.o() + 1), (double)(var2.p() + 1));
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      int var5 = ((Integer)var3.b(a)).intValue();
      if(!this.f(var1, var2) && !var1.C(var2.a())) {
         if(var5 > 0) {
            var1.a((class_cj)var2, (class_anl)var3.a(a, Integer.valueOf(var5 - 1)), 2);
         } else if(!this.e(var1, var2)) {
            var1.a(var2, class_agk.d.S());
         }
      } else if(var5 < 7) {
         var1.a((class_cj)var2, (class_anl)var3.a(a, Integer.valueOf(7)), 2);
      }

   }

   public void a(class_aen var1, class_cj var2, class_pr var3, float var4) {
      if(var3 instanceof class_qa) {
         if(!var1.D && var1.s.nextFloat() < var4 - 0.5F) {
            if(!(var3 instanceof class_xa) && !var1.R().b("mobGriefing")) {
               return;
            }

            var1.a(var2, class_agk.d.S());
         }

         super.a(var1, var2, var3, var4);
      }
   }

   private boolean e(class_aen var1, class_cj var2) {
      class_agj var3 = var1.p(var2.a()).c();
      return var3 instanceof class_ahd || var3 instanceof class_alg;
   }

   private boolean f(class_aen var1, class_cj var2) {
      Iterator var3 = class_cj.b(var2.a(-4, 0, -4), var2.a(4, 1, 4)).iterator();

      class_cj.class_a_in_class_cj var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (class_cj.class_a_in_class_cj)var3.next();
      } while(var1.p(var4).c().v() != class_atk.h);

      return true;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      super.a(var1, var2, var3, var4);
      if(var1.p(var2.a()).c().v().a()) {
         var1.a(var2, class_agk.d.S());
      }

   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return class_agk.d.a(class_agk.d.S().a(class_ahj.a, class_ahj.class_a_in_class_ahj.a), var2, var3);
   }

   public class_anl a(int var1) {
      return this.S().a(a, Integer.valueOf(var1 & 7));
   }

   public int c(class_anl var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }
}
