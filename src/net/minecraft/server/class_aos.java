package net.minecraft.server;

import net.minecraft.server.class_aez;
import net.minecraft.server.class_afd;
import net.minecraft.server.class_aoi;
import net.minecraft.server.class_aom;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;

public class class_aos {
   public static class_aos.class_a_in_class_aos a(class_dn var0) {
      int var1 = var0.g("xPos");
      int var2 = var0.g("zPos");
      class_aos.class_a_in_class_aos var3 = new class_aos.class_a_in_class_aos(var1, var2);
      var3.g = var0.l("Blocks");
      var3.f = new class_aom(var0.l("Data"), 7);
      var3.e = new class_aom(var0.l("SkyLight"), 7);
      var3.d = new class_aom(var0.l("BlockLight"), 7);
      var3.c = var0.l("HeightMap");
      var3.b = var0.o("TerrainPopulated");
      var3.h = var0.c("Entities", 10);
      var3.i = var0.c("TileEntities", 10);
      var3.j = var0.c("TileTicks", 10);

      try {
         var3.a = var0.h("LastUpdate");
      } catch (ClassCastException var5) {
         var3.a = (long)var0.g("LastUpdate");
      }

      return var3;
   }

   public static void a(class_aos.class_a_in_class_aos var0, class_dn var1, class_afd var2) {
      var1.a("xPos", var0.k);
      var1.a("zPos", var0.l);
      var1.a("LastUpdate", var0.a);
      int[] var3 = new int[var0.c.length];

      for(int var4 = 0; var4 < var0.c.length; ++var4) {
         var3[var4] = var0.c[var4];
      }

      var1.a("HeightMap", var3);
      var1.a("TerrainPopulated", var0.b);
      class_du var16 = new class_du();

      int var7;
      int var8;
      for(int var5 = 0; var5 < 8; ++var5) {
         boolean var6 = true;

         for(var7 = 0; var7 < 16 && var6; ++var7) {
            for(var8 = 0; var8 < 16 && var6; ++var8) {
               for(int var9 = 0; var9 < 16; ++var9) {
                  int var10 = var7 << 11 | var9 << 7 | var8 + (var5 << 4);
                  byte var11 = var0.g[var10];
                  if(var11 != 0) {
                     var6 = false;
                     break;
                  }
               }
            }
         }

         if(!var6) {
            byte[] var19 = new byte[4096];
            class_aoi var20 = new class_aoi();
            class_aoi var21 = new class_aoi();
            class_aoi var22 = new class_aoi();

            for(int var23 = 0; var23 < 16; ++var23) {
               for(int var12 = 0; var12 < 16; ++var12) {
                  for(int var13 = 0; var13 < 16; ++var13) {
                     int var14 = var23 << 11 | var13 << 7 | var12 + (var5 << 4);
                     byte var15 = var0.g[var14];
                     var19[var12 << 8 | var13 << 4 | var23] = (byte)(var15 & 255);
                     var20.a(var23, var12, var13, var0.f.a(var23, var12 + (var5 << 4), var13));
                     var21.a(var23, var12, var13, var0.e.a(var23, var12 + (var5 << 4), var13));
                     var22.a(var23, var12, var13, var0.d.a(var23, var12 + (var5 << 4), var13));
                  }
               }
            }

            class_dn var24 = new class_dn();
            var24.a("Y", (byte)(var5 & 255));
            var24.a("Blocks", var19);
            var24.a("Data", var20.a());
            var24.a("SkyLight", var21.a());
            var24.a("BlockLight", var22.a());
            var16.a((class_eb)var24);
         }
      }

      var1.a((String)"Sections", (class_eb)var16);
      byte[] var17 = new byte[256];
      class_cj.class_a_in_class_cj var18 = new class_cj.class_a_in_class_cj();

      for(var7 = 0; var7 < 16; ++var7) {
         for(var8 = 0; var8 < 16; ++var8) {
            var18.c(var0.k << 4 | var7, 0, var0.l << 4 | var8);
            var17[var8 << 4 | var7] = (byte)(var2.a(var18, class_aez.ad).az & 255);
         }
      }

      var1.a("Biomes", var17);
      var1.a((String)"Entities", (class_eb)var0.h);
      var1.a((String)"TileEntities", (class_eb)var0.i);
      if(var0.j != null) {
         var1.a((String)"TileTicks", (class_eb)var0.j);
      }

   }

   public static class class_a_in_class_aos {
      public long a;
      public boolean b;
      public byte[] c;
      public class_aom d;
      public class_aom e;
      public class_aom f;
      public byte[] g;
      public class_du h;
      public class_du i;
      public class_du j;
      public final int k;
      public final int l;

      public class_a_in_class_aos(int var1, int var2) {
         this.k = var1;
         this.l = var2;
      }
   }
}
