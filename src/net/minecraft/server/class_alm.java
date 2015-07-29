package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_ahm;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_xa;

public class class_alm extends class_ago implements class_agl {
   public static final class_any a = class_any.a("type", class_alm.class_a_in_class_alm.class);

   protected class_alm() {
      super(class_atk.l);
      this.j(this.M.b().a(a, class_alm.class_a_in_class_alm.a));
      float var1 = 0.4F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
   }

   public boolean f(class_aen var1, class_cj var2, class_anl var3) {
      return this.c(var1.p(var2.b()).c());
   }

   public boolean a(class_aen var1, class_cj var2) {
      return true;
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return var2.nextInt(8) == 0?class_aau.P:null;
   }

   public int a(int var1, Random var2) {
      return 1 + var2.nextInt(var1 * 2 + 1);
   }

   public void a(class_aen var1, class_xa var2, class_cj var3, class_anl var4, class_amg var5, class_aas var6) {
      if(!var1.D && var6 != null && var6.b() == class_aau.bg) {
         var2.b(class_nc.ab[class_agj.a((class_agj)this)]);
         a(var1, var3, new class_aas(class_agk.H, 1, ((class_alm.class_a_in_class_alm)var4.b(a)).a()));
      } else {
         super.a(var1, var2, var3, var4, var5, var6);
      }

   }

   public int j(class_aen var1, class_cj var2) {
      class_anl var3 = var1.p(var2);
      return var3.c().c(var3);
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, boolean var4) {
      return var3.b(a) != class_alm.class_a_in_class_alm.a;
   }

   public boolean a(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      return true;
   }

   public void b(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      class_ahm.class_b_in_class_ahm var5 = class_ahm.class_b_in_class_ahm.c;
      if(var4.b(a) == class_alm.class_a_in_class_alm.c) {
         var5 = class_ahm.class_b_in_class_ahm.d;
      }

      if(class_agk.cF.d(var1, var3)) {
         class_agk.cF.a(var1, var3, var5, 2);
      }

   }

   public class_anl a(int var1) {
      return this.S().a(a, class_alm.class_a_in_class_alm.a(var1));
   }

   public int c(class_anl var1) {
      return ((class_alm.class_a_in_class_alm)var1.b(a)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }

   public static enum class_a_in_class_alm implements class_ny {
      a(0, "dead_bush"),
      b(1, "tall_grass"),
      c(2, "fern");

      private static final class_alm.class_a_in_class_alm[] d;
      private final int e;
      private final String f;

      private class_a_in_class_alm(int var3, String var4) {
         this.e = var3;
         this.f = var4;
      }

      public int a() {
         return this.e;
      }

      public String toString() {
         return this.f;
      }

      public static class_alm.class_a_in_class_alm a(int var0) {
         if(var0 < 0 || var0 >= d.length) {
            var0 = 0;
         }

         return d[var0];
      }

      public String l() {
         return this.f;
      }

      static {
         d = new class_alm.class_a_in_class_alm[values().length];
         class_alm.class_a_in_class_alm[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_alm.class_a_in_class_alm var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }
   }
}
