package net.minecraft.server;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.Iterator;
import net.minecraft.server.World;
import net.minecraft.server.class_ano;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_df;

public class class_anp {
   private final Predicate[][][] a;
   private final int b;
   private final int c;
   private final int d;

   public class_anp(Predicate[][][] var1) {
      this.a = var1;
      this.b = var1.length;
      if(this.b > 0) {
         this.c = var1[0].length;
         if(this.c > 0) {
            this.d = var1[0][0].length;
         } else {
            this.d = 0;
         }
      } else {
         this.c = 0;
         this.d = 0;
      }

   }

   public int a() {
      return this.b;
   }

   public int b() {
      return this.c;
   }

   public int c() {
      return this.d;
   }

   private class_anp.class_b_in_class_anp a(class_cj var1, class_cq var2, class_cq var3, LoadingCache var4) {
      for(int var5 = 0; var5 < this.d; ++var5) {
         for(int var6 = 0; var6 < this.c; ++var6) {
            for(int var7 = 0; var7 < this.b; ++var7) {
               if(!this.a[var7][var6][var5].apply(var4.getUnchecked(a(var1, var2, var3, var5, var6, var7)))) {
                  return null;
               }
            }
         }
      }

      return new class_anp.class_b_in_class_anp(var1, var2, var3, var4, this.d, this.c, this.b);
   }

   public class_anp.class_b_in_class_anp a(World var1, class_cj var2) {
      LoadingCache var3 = a(var1, false);
      int var4 = Math.max(Math.max(this.d, this.c), this.b);
      Iterator var5 = class_cj.a(var2, var2.a(var4 - 1, var4 - 1, var4 - 1)).iterator();

      while(var5.hasNext()) {
         class_cj var6 = (class_cj)var5.next();
         class_cq[] var7 = class_cq.values();
         int var8 = var7.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            class_cq var10 = var7[var9];
            class_cq[] var11 = class_cq.values();
            int var12 = var11.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               class_cq var14 = var11[var13];
               if(var14 != var10 && var14 != var10.d()) {
                  class_anp.class_b_in_class_anp var15 = this.a(var6, var10, var14, var3);
                  if(var15 != null) {
                     return var15;
                  }
               }
            }
         }
      }

      return null;
   }

   public static LoadingCache a(World var0, boolean var1) {
      return CacheBuilder.newBuilder().build(new class_anp.class_a_in_class_anp(var0, var1));
   }

   protected static class_cj a(class_cj var0, class_cq var1, class_cq var2, int var3, int var4, int var5) {
      if(var1 != var2 && var1 != var2.d()) {
         class_df var6 = new class_df(var1.g(), var1.h(), var1.i());
         class_df var7 = new class_df(var2.g(), var2.h(), var2.i());
         class_df var8 = var6.d(var7);
         return var0.a(var7.n() * -var4 + var8.n() * var3 + var6.n() * var5, var7.o() * -var4 + var8.o() * var3 + var6.o() * var5, var7.p() * -var4 + var8.p() * var3 + var6.p() * var5);
      } else {
         throw new IllegalArgumentException("Invalid forwards & up combination");
      }
   }

   public static class class_b_in_class_anp {
      private final class_cj a;
      private final class_cq b;
      private final class_cq c;
      private final LoadingCache d;
      private final int e;
      private final int f;
      private final int g;

      public class_b_in_class_anp(class_cj var1, class_cq var2, class_cq var3, LoadingCache var4, int var5, int var6, int var7) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
      }

      public class_cj a() {
         return this.a;
      }

      public class_cq b() {
         return this.b;
      }

      public class_cq c() {
         return this.c;
      }

      public int d() {
         return this.e;
      }

      public int e() {
         return this.f;
      }

      public class_ano a(int var1, int var2, int var3) {
         return (class_ano)this.d.getUnchecked(class_anp.a(this.a, this.b(), this.c(), var1, var2, var3));
      }

      public String toString() {
         return Objects.toStringHelper((Object)this).add("up", this.c).add("forwards", this.b).add("frontTopLeft", this.a).toString();
      }
   }

   static class class_a_in_class_anp extends CacheLoader {
      private final World a;
      private final boolean b;

      public class_a_in_class_anp(World var1, boolean var2) {
         this.a = var1;
         this.b = var2;
      }

      public class_ano a(class_cj var1) throws Exception {
         return new class_ano(this.a, var1, this.b);
      }

      // $FF: synthetic method
      public Object load(Object var1) throws Exception {
         return this.a((class_cj)var1);
      }
   }
}
