package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_aet;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_aml;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_ahe extends class_agd {
   public static final class_anz a = class_anz.a("power", 0, 15);
   private final boolean b;

   public class_ahe(boolean var1) {
      super(class_atk.d);
      this.b = var1;
      this.j(this.M.b().a(a, Integer.valueOf(0)));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
      this.a(class_zu.d);
      this.c(0.2F);
      this.a(f);
      this.c("daylightDetector");
   }

   public void a(class_aer var1, class_cj var2) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
   }

   public int a(class_aer var1, class_cj var2, class_anl var3, class_cq var4) {
      return ((Integer)var3.b(a)).intValue();
   }

   public void f(class_aen var1, class_cj var2) {
      if(!var1.t.m()) {
         class_anl var3 = var1.p(var2);
         int var4 = var1.b(class_aet.a, var2) - var1.ac();
         float var5 = var1.d(1.0F);
         float var6 = var5 < 3.1415927F?0.0F:6.2831855F;
         var5 += (var6 - var5) * 0.2F;
         var4 = Math.round((float)var4 * class_nu.b(var5));
         var4 = class_nu.a(var4, 0, 15);
         if(this.b) {
            var4 = 15 - var4;
         }

         if(((Integer)var3.b(a)).intValue() != var4) {
            var1.a((class_cj)var2, (class_anl)var3.a(a, Integer.valueOf(var4)), 3);
         }

      }
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var4.cp()) {
         if(var1.D) {
            return true;
         } else {
            if(this.b) {
               var1.a((class_cj)var2, (class_anl)class_agk.cl.S().a(a, var3.b(a)), 4);
               class_agk.cl.f(var1, var2);
            } else {
               var1.a((class_cj)var2, (class_anl)class_agk.cm.S().a(a, var3.b(a)), 4);
               class_agk.cm.f(var1, var2);
            }

            return true;
         }
      } else {
         return super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return class_aar.a((class_agj)class_agk.cl);
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public int b() {
      return 3;
   }

   public boolean i() {
      return true;
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_aml();
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
