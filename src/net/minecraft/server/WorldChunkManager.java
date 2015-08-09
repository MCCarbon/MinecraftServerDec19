package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.WorldType;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_afa;
import net.minecraft.server.class_aua;
import net.minecraft.server.class_auc;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_e;

public class WorldChunkManager {
   private class_auc b;
   private class_auc c;
   private class_afa d;
   private List e;
   private String f;

   protected WorldChunkManager() {
      this.d = new class_afa(this);
      this.f = "";
      this.e = Lists.newArrayList();
      this.e.add(BiomeBase.FOREST);
      this.e.add(BiomeBase.PLAINS);
      this.e.add(BiomeBase.TAIGA);
      this.e.add(BiomeBase.TAIGA_HILLS);
      this.e.add(BiomeBase.FOREST_HILLS);
      this.e.add(BiomeBase.JUNGLE);
      this.e.add(BiomeBase.JUNGLE_HILLS);
   }

   public WorldChunkManager(long var1, WorldType var3, String var4) {
      this();
      this.f = var4;
      class_auc[] var5 = class_auc.a(var1, var3, var4);
      this.b = var5[0];
      this.c = var5[1];
   }

   public WorldChunkManager(World var1) {
      this(var1.K(), var1.Q().u(), var1.Q().B());
   }

   public List a() {
      return this.e;
   }

   public BiomeBase a(BlockPosition var1) {
      return this.a(var1, (BiomeBase)null);
   }

   public BiomeBase a(BlockPosition var1, BiomeBase var2) {
      return this.d.a(var1.getX(), var1.getZ(), var2);
   }

   public float[] a(float[] var1, int var2, int var3, int var4, int var5) {
      class_aua.a();
      if(var1 == null || var1.length < var4 * var5) {
         var1 = new float[var4 * var5];
      }

      int[] var6 = this.c.a(var2, var3, var4, var5);

      for(int var7 = 0; var7 < var4 * var5; ++var7) {
         try {
            float var8 = (float)BiomeBase.a(var6[var7], BiomeBase.ad).h() / 65536.0F;
            if(var8 > 1.0F) {
               var8 = 1.0F;
            }

            var1[var7] = var8;
         } catch (Throwable var11) {
            class_b var9 = class_b.a(var11, "Invalid Biome id");
            class_c var10 = var9.a("DownfallBlock");
            var10.a((String)"biome id", (Object)Integer.valueOf(var7));
            var10.a((String)"downfalls[] size", (Object)Integer.valueOf(var1.length));
            var10.a((String)"x", (Object)Integer.valueOf(var2));
            var10.a((String)"z", (Object)Integer.valueOf(var3));
            var10.a((String)"w", (Object)Integer.valueOf(var4));
            var10.a((String)"h", (Object)Integer.valueOf(var5));
            throw new class_e(var9);
         }
      }

      return var1;
   }

   public BiomeBase[] a(BiomeBase[] var1, int var2, int var3, int var4, int var5) {
      class_aua.a();
      if(var1 == null || var1.length < var4 * var5) {
         var1 = new BiomeBase[var4 * var5];
      }

      int[] var6 = this.b.a(var2, var3, var4, var5);

      try {
         for(int var7 = 0; var7 < var4 * var5; ++var7) {
            var1[var7] = BiomeBase.a(var6[var7], BiomeBase.ad);
         }

         return var1;
      } catch (Throwable var10) {
         class_b var8 = class_b.a(var10, "Invalid Biome id");
         class_c var9 = var8.a("RawBiomeBlock");
         var9.a((String)"biomes[] size", (Object)Integer.valueOf(var1.length));
         var9.a((String)"x", (Object)Integer.valueOf(var2));
         var9.a((String)"z", (Object)Integer.valueOf(var3));
         var9.a((String)"w", (Object)Integer.valueOf(var4));
         var9.a((String)"h", (Object)Integer.valueOf(var5));
         throw new class_e(var8);
      }
   }

   public BiomeBase[] b(BiomeBase[] var1, int var2, int var3, int var4, int var5) {
      return this.a(var1, var2, var3, var4, var5, true);
   }

   public BiomeBase[] a(BiomeBase[] var1, int var2, int var3, int var4, int var5, boolean var6) {
      class_aua.a();
      if(var1 == null || var1.length < var4 * var5) {
         var1 = new BiomeBase[var4 * var5];
      }

      if(var6 && var4 == 16 && var5 == 16 && (var2 & 15) == 0 && (var3 & 15) == 0) {
         BiomeBase[] var9 = this.d.c(var2, var3);
         System.arraycopy(var9, 0, var1, 0, var4 * var5);
         return var1;
      } else {
         int[] var7 = this.c.a(var2, var3, var4, var5);

         for(int var8 = 0; var8 < var4 * var5; ++var8) {
            var1[var8] = BiomeBase.a(var7[var8], BiomeBase.ad);
         }

         return var1;
      }
   }

   public boolean a(int var1, int var2, int var3, List var4) {
      class_aua.a();
      int var5 = var1 - var3 >> 2;
      int var6 = var2 - var3 >> 2;
      int var7 = var1 + var3 >> 2;
      int var8 = var2 + var3 >> 2;
      int var9 = var7 - var5 + 1;
      int var10 = var8 - var6 + 1;
      int[] var11 = this.b.a(var5, var6, var9, var10);

      try {
         for(int var12 = 0; var12 < var9 * var10; ++var12) {
            BiomeBase var16 = BiomeBase.e(var11[var12]);
            if(!var4.contains(var16)) {
               return false;
            }
         }

         return true;
      } catch (Throwable var15) {
         class_b var13 = class_b.a(var15, "Invalid Biome id");
         class_c var14 = var13.a("Layer");
         var14.a((String)"Layer", (Object)this.b.toString());
         var14.a((String)"x", (Object)Integer.valueOf(var1));
         var14.a((String)"z", (Object)Integer.valueOf(var2));
         var14.a((String)"radius", (Object)Integer.valueOf(var3));
         var14.a((String)"allowed", (Object)var4);
         throw new class_e(var13);
      }
   }

   public BlockPosition a(int var1, int var2, int var3, List var4, Random var5) {
      class_aua.a();
      int var6 = var1 - var3 >> 2;
      int var7 = var2 - var3 >> 2;
      int var8 = var1 + var3 >> 2;
      int var9 = var2 + var3 >> 2;
      int var10 = var8 - var6 + 1;
      int var11 = var9 - var7 + 1;
      int[] var12 = this.b.a(var6, var7, var10, var11);
      BlockPosition var13 = null;
      int var14 = 0;

      for(int var15 = 0; var15 < var10 * var11; ++var15) {
         int var16 = var6 + var15 % var10 << 2;
         int var17 = var7 + var15 / var10 << 2;
         BiomeBase var18 = BiomeBase.e(var12[var15]);
         if(var4.contains(var18) && (var13 == null || var5.nextInt(var14 + 1) == 0)) {
            var13 = new BlockPosition(var16, 0, var17);
            ++var14;
         }
      }

      return var13;
   }

   public void b() {
      this.d.a();
   }
}
