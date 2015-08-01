package net.minecraft.server;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import net.minecraft.server.World;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_afc;
import net.minecraft.server.class_aqk;
import net.minecraft.server.class_ari;
import net.minecraft.server.BlockPosition;

public class class_afx extends class_afc {
   private static final LoadingCache M;
   private final class_ari N = new class_ari();
   private final class_aqk O = new class_aqk(false);

   protected void a(BiomeBase var1) {
      this.a();
      class_ari.class_a_in_class_ari[] var2 = a(this.a);
      class_ari.class_a_in_class_ari[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_ari.class_a_in_class_ari var6 = var3[var5];
         if(var6.a(this.c)) {
            this.N.a(var6);
            this.N.b(this.a, this.b, this.a.m(new BlockPosition(var6.a(), 0, var6.b())));
         }
      }

      if(this.c.getX() == class_aqk.b.getX() && this.c.getZ() == class_aqk.b.getZ()) {
         this.O.b(this.a, this.b, this.a.m(class_aqk.a));
      }

   }

   public static class_ari.class_a_in_class_ari[] a(World var0) {
      Random var1 = new Random(var0.K());
      long var2 = var1.nextLong() & 65535L;
      return (class_ari.class_a_in_class_ari[])M.getUnchecked(Long.valueOf(var2));
   }

   static {
      M = CacheBuilder.newBuilder().expireAfterWrite(5L, TimeUnit.MINUTES).build(new class_afx.class_a_in_class_afx());
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
   }

   static class class_a_in_class_afx extends CacheLoader {
      private class_a_in_class_afx() {
      }

      public class_ari.class_a_in_class_ari[] a(Long var1) throws Exception {
         ArrayList var2 = Lists.newArrayList((Iterable)ContiguousSet.create(Range.closedOpen(Integer.valueOf(0), Integer.valueOf(10)), DiscreteDomain.integers()));
         Collections.shuffle(var2, new Random(var1.longValue()));
         class_ari.class_a_in_class_ari[] var3 = new class_ari.class_a_in_class_ari[10];

         for(int var4 = 0; var4 < 10; ++var4) {
            int var5 = (int)(42.0D * Math.cos(2.0D * (-3.141592653589793D + 0.3141592653589793D * (double)var4)));
            int var6 = (int)(42.0D * Math.sin(2.0D * (-3.141592653589793D + 0.3141592653589793D * (double)var4)));
            int var7 = ((Integer)var2.get(var4)).intValue();
            var3[var4] = new class_ari.class_a_in_class_ari(var5, var6, 2 + var7 / 3, 12 + var7 * 3, var7 > 5);
         }

         return var3;
      }

      // $FF: synthetic method
      public Object load(Object var1) throws Exception {
         return this.a((Long)var1);
      }

      // $FF: synthetic method
      class_a_in_class_afx(class_afx.SyntheticClass_1 var1) {
         this();
      }
   }
}
