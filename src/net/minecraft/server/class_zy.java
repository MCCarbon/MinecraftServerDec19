package net.minecraft.server;

import net.minecraft.server.class_a;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_ny;

public enum class_zy implements class_ny {
    a(0, 15, "white", "white", class_atl.j, class_a.p),
    b(1, 14, "orange", "orange", class_atl.q, class_a.g),
    c(2, 13, "magenta", "magenta", class_atl.r, class_a.l),
    d(3, 12, "light_blue", "lightBlue", class_atl.s, class_a.j),
    e(4, 11, "yellow", "yellow", class_atl.t, class_a.o),
    f(5, 10, "lime", "lime", class_atl.u, class_a.k),
    g(6, 9, "pink", "pink", class_atl.v, class_a.n),
    h(7, 8, "gray", "gray", class_atl.w, class_a.i),
    i(8, 7, "silver", "silver", class_atl.x, class_a.h),
    j(9, 6, "cyan", "cyan", class_atl.y, class_a.d),
    k(10, 5, "purple", "purple", class_atl.z, class_a.f),
    l(11, 4, "blue", "blue", class_atl.A, class_a.b),
    m(12, 3, "brown", "brown", class_atl.B, class_a.g),
    n(13, 2, "green", "green", class_atl.C, class_a.c),
    o(14, 1, "red", "red", class_atl.D, class_a.e),
    p(15, 0, "black", "black", class_atl.E, class_a.a);

   private static final class_zy[] q;
   private static final class_zy[] r;
   private final int s;
   private final int t;
   private final String u;
   private final String v;
   private final class_atl w;
   private final class_a x;

   private class_zy(int var3, int var4, String var5, String var6, class_atl var7, class_a var8) {
      this.s = var3;
      this.t = var4;
      this.u = var5;
      this.v = var6;
      this.w = var7;
      this.x = var8;
   }

   public int a() {
      return this.s;
   }

   public int b() {
      return this.t;
   }

   public String d() {
      return this.v;
   }

   public class_atl e() {
      return this.w;
   }

   public static class_zy a(int var0) {
      if(var0 < 0 || var0 >= r.length) {
         var0 = 0;
      }

      return r[var0];
   }

   public static class_zy b(int var0) {
      if(var0 < 0 || var0 >= q.length) {
         var0 = 0;
      }

      return q[var0];
   }

   public String toString() {
      return this.v;
   }

   public String l() {
      return this.u;
   }

   static {
      q = new class_zy[values().length];
      r = new class_zy[values().length];
      class_zy[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         class_zy var3 = var0[var2];
         q[var3.a()] = var3;
         r[var3.b()] = var3;
      }

   }
}
