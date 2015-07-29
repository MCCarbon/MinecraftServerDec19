package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aio;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_zu;

public abstract class class_alk extends class_aio {
   public static final class_anw b = class_anw.a("seamless");
   public static final class_any N = class_any.a("variant", class_alk.class_a_in_class_alk.class);

   public class_alk() {
      super(class_atk.e);
      class_anl var1 = this.M.b();
      if(this.l()) {
         var1 = var1.a(b, Boolean.valueOf(false));
      } else {
         var1 = var1.a(a, class_aio.class_a_in_class_aio.b);
      }

      this.j(var1.a(N, class_alk.class_a_in_class_alk.a));
      this.a((class_zu)class_zu.b);
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return class_aar.a((class_agj)class_agk.U);
   }

   public String b(int var1) {
      return super.a() + "." + class_alk.class_a_in_class_alk.a(var1).d();
   }

   public class_aoa n() {
      return N;
   }

   public Object a(class_aas var1) {
      return class_alk.class_a_in_class_alk.a(var1.i() & 7);
   }

   public class_anl a(int var1) {
      class_anl var2 = this.S().a(N, class_alk.class_a_in_class_alk.a(var1 & 7));
      if(this.l()) {
         var2 = var2.a(b, Boolean.valueOf((var1 & 8) != 0));
      } else {
         var2 = var2.a(a, (var1 & 8) == 0?class_aio.class_a_in_class_aio.b:class_aio.class_a_in_class_aio.a);
      }

      return var2;
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_alk.class_a_in_class_alk)var1.b(N)).a();
      if(this.l()) {
         if(((Boolean)var1.b(b)).booleanValue()) {
            var3 |= 8;
         }
      } else if(var1.b(a) == class_aio.class_a_in_class_aio.a) {
         var3 |= 8;
      }

      return var3;
   }

   protected class_anm e() {
      return this.l()?new class_anm(this, new class_aoa[]{b, N}):new class_anm(this, new class_aoa[]{a, N});
   }

   public int a(class_anl var1) {
      return ((class_alk.class_a_in_class_alk)var1.b(N)).a();
   }

   public class_atl g(class_anl var1) {
      return ((class_alk.class_a_in_class_alk)var1.b(N)).c();
   }

   public static enum class_a_in_class_alk implements class_ny {
       a(0, class_atl.m, "stone"),
       b(1, class_atl.d, "sandstone", "sand"),
       c(2, class_atl.o, "wood_old", "wood"),
       d(3, class_atl.m, "cobblestone", "cobble"),
       e(4, class_atl.D, "brick"),
       f(5, class_atl.m, "stone_brick", "smoothStoneBrick"),
       g(6, class_atl.K, "nether_brick", "netherBrick"),
       h(7, class_atl.p, "quartz");

      private static final class_alk.class_a_in_class_alk[] i;
      private final int j;
      private final class_atl k;
      private final String l;
      private final String m;

      private class_a_in_class_alk(int var3, class_atl var4, String var5) {
         this(var3, var4, var5, var5);
      }

      private class_a_in_class_alk(int var3, class_atl var4, String var5, String var6) {
         this.j = var3;
         this.k = var4;
         this.l = var5;
         this.m = var6;
      }

      public int a() {
         return this.j;
      }

      public class_atl c() {
         return this.k;
      }

      public String toString() {
         return this.l;
      }

      public static class_alk.class_a_in_class_alk a(int var0) {
         if(var0 < 0 || var0 >= i.length) {
            var0 = 0;
         }

         return i[var0];
      }

      public String l() {
         return this.l;
      }

      public String d() {
         return this.m;
      }

      static {
         i = new class_alk.class_a_in_class_alk[values().length];
         class_alk.class_a_in_class_alk[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_alk.class_a_in_class_alk var3 = var0[var2];
            i[var3.a()] = var3;
         }

      }
   }
}
