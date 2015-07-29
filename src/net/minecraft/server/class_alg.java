package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_ahd;
import net.minecraft.server.class_alp;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anx;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_zu;

public class class_alg extends class_ago implements class_agl {
   public static final class_anz a = class_anz.a("age", 0, 7);
   public static final class_anx b;
   private final class_agj N;

   protected class_alg(class_agj var1) {
      this.j(this.M.b().a(a, Integer.valueOf(0)).a(b, class_cq.b));
      this.N = var1;
      this.a(true);
      float var2 = 0.125F;
      this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, 0.25F, 0.5F + var2);
      this.a((class_zu)null);
   }

   public class_anl a(class_anl var1, class_aer var2, class_cj var3) {
      var1 = var1.a(b, class_cq.b);
      Iterator var4 = class_cq.class_c_in_class_cq.a.iterator();

      while(var4.hasNext()) {
         class_cq var5 = (class_cq)var4.next();
         if(var2.p(var3.a(var5)).c() == this.N) {
            var1 = var1.a(b, var5);
            break;
         }
      }

      return var1;
   }

   protected boolean c(class_agj var1) {
      return var1 == class_agk.ak;
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      super.b(var1, var2, var3, var4);
      if(var1.l(var2.a()) >= 9) {
         float var5 = class_ahd.a(this, var1, var2);
         if(var4.nextInt((int)(25.0F / var5) + 1) == 0) {
            int var6 = ((Integer)var3.b(a)).intValue();
            if(var6 < 7) {
               var3 = var3.a(a, Integer.valueOf(var6 + 1));
               var1.a((class_cj)var2, (class_anl)var3, 2);
            } else {
               Iterator var7 = class_cq.class_c_in_class_cq.a.iterator();

               while(var7.hasNext()) {
                  class_cq var8 = (class_cq)var7.next();
                  if(var1.p(var2.a(var8)).c() == this.N) {
                     return;
                  }
               }

               var2 = var2.a(class_cq.class_c_in_class_cq.a.a(var4));
               class_agj var9 = var1.p(var2.b()).c();
               if(var1.p(var2).c().J == class_atk.a && (var9 == class_agk.ak || var9 == class_agk.d || var9 == class_agk.c)) {
                  var1.a(var2, this.N.S());
               }
            }
         }

      }
   }

   public void g(class_aen var1, class_cj var2, class_anl var3) {
      int var4 = ((Integer)var3.b(a)).intValue() + class_nu.a((Random)var1.s, 2, 5);
      var1.a((class_cj)var2, (class_anl)var3.a(a, Integer.valueOf(Math.min(7, var4))), 2);
   }

   public void j() {
      float var1 = 0.125F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
   }

   public void a(class_aer var1, class_cj var2) {
      this.F = (double)((float)(((Integer)var1.p(var2).b(a)).intValue() * 2 + 2) / 16.0F);
      float var3 = 0.125F;
      this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, (float)this.F, 0.5F + var3);
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if(!var1.D) {
         class_aar var6 = this.l();
         if(var6 != null) {
            int var7 = ((Integer)var3.b(a)).intValue();

            for(int var8 = 0; var8 < 3; ++var8) {
               if(var1.s.nextInt(15) <= var7) {
                  a(var1, var2, new class_aas(var6));
               }
            }

         }
      }
   }

   protected class_aar l() {
      return this.N == class_agk.aU?class_aau.bi:(this.N == class_agk.bk?class_aau.bj:null);
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return null;
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, boolean var4) {
      return ((Integer)var3.b(a)).intValue() != 7;
   }

   public boolean a(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      return true;
   }

   public void b(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      this.g(var1, var3, var4);
   }

   public class_anl a(int var1) {
      return this.S().a(a, Integer.valueOf(var1));
   }

   public int c(class_anl var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a, b});
   }

   static {
      b = class_alp.a;
   }
}
