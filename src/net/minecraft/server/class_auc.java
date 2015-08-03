package net.minecraft.server;

import java.util.concurrent.Callable;
import net.minecraft.server.class_aes;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_api;
import net.minecraft.server.class_ato;
import net.minecraft.server.class_atp;
import net.minecraft.server.class_atq;
import net.minecraft.server.class_atr;
import net.minecraft.server.class_ats;
import net.minecraft.server.class_att;
import net.minecraft.server.class_atu;
import net.minecraft.server.class_aty;
import net.minecraft.server.class_aub;
import net.minecraft.server.class_aud;
import net.minecraft.server.class_aue;
import net.minecraft.server.class_auf;
import net.minecraft.server.class_aug;
import net.minecraft.server.class_auh;
import net.minecraft.server.class_aui;
import net.minecraft.server.class_auj;
import net.minecraft.server.class_auk;
import net.minecraft.server.class_auo;
import net.minecraft.server.class_aup;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.class_e;

public abstract class class_auc {
   private long c;
   protected class_auc a;
   private long d;
   protected long b;

   public static class_auc[] a(long var0, class_aes var2, String var3) {
      class_aub var4 = new class_aub(1L);
      class_aty var13 = new class_aty(2000L, var4);
      class_atq var14 = new class_atq(1L, var13);
      class_aup var15 = new class_aup(2001L, var14);
      var14 = new class_atq(2L, var15);
      var14 = new class_atq(50L, var14);
      var14 = new class_atq(70L, var14);
      class_auf var16 = new class_auf(2L, var14);
      class_ats var17 = new class_ats(2L, var16);
      var14 = new class_atq(3L, var17);
      class_atp var18 = new class_atp(2L, var14, class_atp.class_a_in_class_atp.a);
      var18 = new class_atp(2L, var18, class_atp.class_a_in_class_atp.b);
      var18 = new class_atp(3L, var18, class_atp.class_a_in_class_atp.c);
      var15 = new class_aup(2002L, var18);
      var15 = new class_aup(2003L, var15);
      var14 = new class_atq(4L, var15);
      class_atr var20 = new class_atr(5L, var14);
      class_ato var23 = new class_ato(4L, var20);
      class_auc var26 = class_aup.b(1000L, var23, 0);
      class_api var5 = null;
      int var6 = 4;
      int var7 = var6;
      if(var2 == class_aes.f && !var3.isEmpty()) {
         var5 = class_api.class_a_in_class_api.a(var3).b();
         var6 = var5.G;
         var7 = var5.H;
      }

      if(var2 == class_aes.d) {
         var6 = 6;
      }

      class_auc var8 = class_aup.b(1000L, var26, 0);
      class_aug var19 = new class_aug(100L, var8);
      class_atu var9 = new class_atu(200L, var26, var2, var3);
      class_auc var21 = class_aup.b(1000L, var9, 2);
      class_att var24 = new class_att(1000L, var21);
      class_auc var10 = class_aup.b(1000L, var19, 2);
      class_aue var27 = new class_aue(1000L, var24, var10);
      var8 = class_aup.b(1000L, var19, 2);
      var8 = class_aup.b(1000L, var8, var7);
      class_auh var22 = new class_auh(1L, var8);
      class_auk var25 = new class_auk(1000L, var22);
      Object var28 = new class_aud(1001L, var27);

      for(int var11 = 0; var11 < var6; ++var11) {
         var28 = new class_aup((long)(1000 + var11), (class_auc)var28);
         if(var11 == 0) {
            var28 = new class_atq(3L, (class_auc)var28);
         }

         if(var11 == 1 || var6 == 1) {
            var28 = new class_auj(1000L, (class_auc)var28);
         }
      }

      class_auk var29 = new class_auk(1000L, (class_auc)var28);
      class_aui var30 = new class_aui(100L, var29, var25);
      class_auo var12 = new class_auo(10L, var30);
      var30.a(var0);
      var12.a(var0);
      return new class_auc[]{var30, var12, var30};
   }

   public class_auc(long var1) {
      this.b = var1;
      this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
      this.b += var1;
      this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
      this.b += var1;
      this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
      this.b += var1;
   }

   public void a(long var1) {
      this.c = var1;
      if(this.a != null) {
         this.a.a(var1);
      }

      this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
      this.c += this.b;
      this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
      this.c += this.b;
      this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
      this.c += this.b;
   }

   public void a(long var1, long var3) {
      this.d = this.c;
      this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
      this.d += var1;
      this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
      this.d += var3;
      this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
      this.d += var1;
      this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
      this.d += var3;
   }

   protected int a(int var1) {
      int var2 = (int)((this.d >> 24) % (long)var1);
      if(var2 < 0) {
         var2 += var1;
      }

      this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
      this.d += this.c;
      return var2;
   }

   public abstract int[] a(int var1, int var2, int var3, int var4);

   protected static boolean a(int var0, int var1) {
      if(var0 == var1) {
         return true;
      } else if(var0 != BiomeBase.ab.az && var0 != BiomeBase.ac.az) {
         final BiomeBase var2 = BiomeBase.e(var0);
         final BiomeBase var3 = BiomeBase.e(var1);

         try {
            return var2 != null && var3 != null?var2.a(var3):false;
         } catch (Throwable var7) {
            class_b var5 = class_b.a(var7, "Comparing biomes");
            class_c var6 = var5.a("Biomes being compared");
            var6.a((String)"Biome STICK ID", (Object)Integer.valueOf(var0));
            var6.a((String)"Biome BOWL ID", (Object)Integer.valueOf(var1));
            var6.a("Biome STICK", new Callable() {
               public String a() throws Exception {
                  return String.valueOf(var2);
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            var6.a("Biome BOWL", new Callable() {
               public String a() throws Exception {
                  return String.valueOf(var3);
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            throw new class_e(var5);
         }
      } else {
         return var1 == BiomeBase.ab.az || var1 == BiomeBase.ac.az;
      }
   }

   protected static boolean b(int var0) {
      return var0 == BiomeBase.p.az || var0 == BiomeBase.N.az || var0 == BiomeBase.z.az;
   }

   protected int a(int... var1) {
      return var1[this.a(var1.length)];
   }

   protected int b(int var1, int var2, int var3, int var4) {
      return var2 == var3 && var3 == var4?var2:(var1 == var2 && var1 == var3?var1:(var1 == var2 && var1 == var4?var1:(var1 == var3 && var1 == var4?var1:(var1 == var2 && var3 != var4?var1:(var1 == var3 && var2 != var4?var1:(var1 == var4 && var2 != var3?var1:(var2 == var3 && var1 != var4?var2:(var2 == var4 && var1 != var3?var2:(var3 == var4 && var1 != var2?var3:this.a(new int[]{var1, var2, var3, var4}))))))))));
   }
}
