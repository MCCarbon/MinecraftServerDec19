package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_afd;
import net.minecraft.server.class_ns;

public class class_afa {
   private final class_afd a;
   private long b;
   private class_ns c = new class_ns();
   private List d = Lists.newArrayList();

   public class_afa(class_afd var1) {
      this.a = var1;
   }

   public class_afa.class_a_in_class_afa a(int var1, int var2) {
      var1 >>= 4;
      var2 >>= 4;
      long var3 = (long)var1 & 4294967295L | ((long)var2 & 4294967295L) << 32;
      class_afa.class_a_in_class_afa var5 = (class_afa.class_a_in_class_afa)this.c.a(var3);
      if(var5 == null) {
         var5 = new class_afa.class_a_in_class_afa(var1, var2);
         this.c.a(var3, var5);
         this.d.add(var5);
      }

      var5.e = MinecraftServer.az();
      return var5;
   }

   public BiomeBase a(int var1, int var2, BiomeBase var3) {
      BiomeBase var4 = this.a(var1, var2).a(var1, var2);
      return var4 == null?var3:var4;
   }

   public void a() {
      long var1 = MinecraftServer.az();
      long var3 = var1 - this.b;
      if(var3 > 7500L || var3 < 0L) {
         this.b = var1;

         for(int var5 = 0; var5 < this.d.size(); ++var5) {
            class_afa.class_a_in_class_afa var6 = (class_afa.class_a_in_class_afa)this.d.get(var5);
            long var7 = var1 - var6.e;
            if(var7 > 30000L || var7 < 0L) {
               this.d.remove(var5--);
               long var9 = (long)var6.c & 4294967295L | ((long)var6.d & 4294967295L) << 32;
               this.c.d(var9);
            }
         }
      }

   }

   public BiomeBase[] c(int var1, int var2) {
      return this.a(var1, var2).b;
   }

   public class class_a_in_class_afa {
      public float[] a = new float[256];
      public BiomeBase[] b = new BiomeBase[256];
      public int c;
      public int d;
      public long e;

      public class_a_in_class_afa(int var2, int var3) {
         this.c = var2;
         this.d = var3;
         class_afa.this.a.a((float[])this.a, var2 << 4, var3 << 4, 16, 16);
         class_afa.this.a.a(this.b, var2 << 4, var3 << 4, 16, 16, false);
      }

      public BiomeBase a(int var1, int var2) {
         return this.b[var1 & 15 | (var2 & 15) << 4];
      }
   }
}
