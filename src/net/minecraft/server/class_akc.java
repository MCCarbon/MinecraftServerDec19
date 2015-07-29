package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_di;
import net.minecraft.server.class_ny;
import net.minecraft.server.CreativeTab;

public class class_akc extends Block {
   public static final class_any a = class_any.a("variant", class_akc.class_a_in_class_akc.class);
   public static final int b;
   public static final int N;
   public static final int O;

   public class_akc() {
      super(class_atk.e);
      this.j(this.M.b().set(a, class_akc.class_a_in_class_akc.a));
      this.a(CreativeTab.b);
   }

   public String f() {
      return class_di.a(this.a() + "." + class_akc.class_a_in_class_akc.a.c() + ".name");
   }

   public class_atl g(IBlockData var1) {
      return var1.get(a) == class_akc.class_a_in_class_akc.a?class_atl.y:class_atl.G;
   }

   public int a(IBlockData var1) {
      return ((class_akc.class_a_in_class_akc)var1.get(a)).a();
   }

   public int c(IBlockData var1) {
      return ((class_akc.class_a_in_class_akc)var1.get(a)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a});
   }

   public IBlockData a(int var1) {
      return this.S().set(a, class_akc.class_a_in_class_akc.a(var1));
   }

   static {
      b = class_akc.class_a_in_class_akc.a.a();
      N = class_akc.class_a_in_class_akc.b.a();
      O = class_akc.class_a_in_class_akc.c.a();
   }

   public static enum class_a_in_class_akc implements class_ny {
      a(0, "prismarine", "rough"),
      b(1, "prismarine_bricks", "bricks"),
      c(2, "dark_prismarine", "dark");

      private static final class_akc.class_a_in_class_akc[] d;
      private final int e;
      private final String f;
      private final String g;

      private class_a_in_class_akc(int var3, String var4, String var5) {
         this.e = var3;
         this.f = var4;
         this.g = var5;
      }

      public int a() {
         return this.e;
      }

      public String toString() {
         return this.f;
      }

      public static class_akc.class_a_in_class_akc a(int var0) {
         if(var0 < 0 || var0 >= d.length) {
            var0 = 0;
         }

         return d[var0];
      }

      public String l() {
         return this.f;
      }

      public String c() {
         return this.g;
      }

      static {
         d = new class_akc.class_a_in_class_akc[values().length];
         class_akc.class_a_in_class_akc[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_akc.class_a_in_class_akc var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }
   }
}
