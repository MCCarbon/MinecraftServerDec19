package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aia;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_di;
import net.minecraft.server.class_ny;
import net.minecraft.server.CreativeTab;

public class class_alv extends Block {
   public static final class_anw a = class_anw.a("up");
   public static final class_anw b = class_anw.a("north");
   public static final class_anw N = class_anw.a("east");
   public static final class_anw O = class_anw.a("south");
   public static final class_anw P = class_anw.a("west");
   public static final class_any Q = class_any.a("variant", class_alv.class_a_in_class_alv.class);

   public class_alv(Block var1) {
      super(var1.J);
      this.j(this.M.b().set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)).set(P, Boolean.valueOf(false)).set(Q, class_alv.class_a_in_class_alv.a));
      this.c(var1.w);
      this.b(var1.x / 3.0F);
      this.a(var1.H);
      this.a(CreativeTab.b);
   }

   public String f() {
      return class_di.a(this.a() + "." + class_alv.class_a_in_class_alv.a.c() + ".name");
   }

   public boolean d() {
      return false;
   }

   public boolean b(class_aer var1, class_cj var2) {
      return false;
   }

   public boolean c() {
      return false;
   }

   public void a(class_aer var1, class_cj var2) {
      boolean var3 = this.e(var1, var2.c());
      boolean var4 = this.e(var1, var2.d());
      boolean var5 = this.e(var1, var2.e());
      boolean var6 = this.e(var1, var2.f());
      float var7 = 0.25F;
      float var8 = 0.75F;
      float var9 = 0.25F;
      float var10 = 0.75F;
      float var11 = 1.0F;
      if(var3) {
         var9 = 0.0F;
      }

      if(var4) {
         var10 = 1.0F;
      }

      if(var5) {
         var7 = 0.0F;
      }

      if(var6) {
         var8 = 1.0F;
      }

      if(var3 && var4 && !var5 && !var6) {
         var11 = 0.8125F;
         var7 = 0.3125F;
         var8 = 0.6875F;
      } else if(!var3 && !var4 && var5 && var6) {
         var11 = 0.8125F;
         var9 = 0.3125F;
         var10 = 0.6875F;
      }

      this.a(var7, 0.0F, var9, var8, var11, var10);
   }

   public class_awf a(class_aen var1, class_cj var2, IBlockData var3) {
      this.a(var1, var2);
      this.F = 1.5D;
      return super.a(var1, var2, var3);
   }

   public boolean e(class_aer var1, class_cj var2) {
      Block var3 = var1.p(var2).getBlock();
      return var3 == class_agk.cv?false:(var3 != this && !(var3 instanceof class_aia)?(var3.J.k() && var3.d()?var3.J != class_atk.C:false):true);
   }

   public int a(IBlockData var1) {
      return ((class_alv.class_a_in_class_alv)var1.get(Q)).a();
   }

   public IBlockData a(int var1) {
      return this.S().set(Q, class_alv.class_a_in_class_alv.a(var1));
   }

   public int c(IBlockData var1) {
      return ((class_alv.class_a_in_class_alv)var1.get(Q)).a();
   }

   public IBlockData a(IBlockData var1, class_aer var2, class_cj var3) {
      boolean var4 = this.e(var2, var3.c());
      boolean var5 = this.e(var2, var3.f());
      boolean var6 = this.e(var2, var3.d());
      boolean var7 = this.e(var2, var3.e());
      boolean var8 = var4 && !var5 && var6 && !var7 || !var4 && var5 && !var6 && var7;
      return var1.set(a, Boolean.valueOf(!var8 || !var2.d(var3.a()))).set(b, Boolean.valueOf(var4)).set(N, Boolean.valueOf(var5)).set(O, Boolean.valueOf(var6)).set(P, Boolean.valueOf(var7));
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a, b, N, P, O, Q});
   }

   public static enum class_a_in_class_alv implements class_ny {
      a(0, "cobblestone", "normal"),
      b(1, "mossy_cobblestone", "mossy");

      private static final class_alv.class_a_in_class_alv[] c;
      private final int d;
      private final String e;
      private String f;

      private class_a_in_class_alv(int var3, String var4, String var5) {
         this.d = var3;
         this.e = var4;
         this.f = var5;
      }

      public int a() {
         return this.d;
      }

      public String toString() {
         return this.e;
      }

      public static class_alv.class_a_in_class_alv a(int var0) {
         if(var0 < 0 || var0 >= c.length) {
            var0 = 0;
         }

         return c[var0];
      }

      public String l() {
         return this.e;
      }

      public String c() {
         return this.f;
      }

      static {
         c = new class_alv.class_a_in_class_alv[values().length];
         class_alv.class_a_in_class_alv[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_alv.class_a_in_class_alv var3 = var0[var2];
            c[var3.a()] = var3;
         }

      }
   }
}
