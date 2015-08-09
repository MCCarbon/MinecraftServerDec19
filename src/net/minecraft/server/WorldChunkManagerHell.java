package net.minecraft.server;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.WorldChunkManager;
import net.minecraft.server.BlockPosition;

public class WorldChunkManagerHell extends WorldChunkManager {
   private BiomeBase b;
   private float c;

   public WorldChunkManagerHell(BiomeBase var1, float var2) {
      this.b = var1;
      this.c = var2;
   }

   public BiomeBase a(BlockPosition var1) {
      return this.b;
   }

   public BiomeBase[] a(BiomeBase[] var1, int var2, int var3, int var4, int var5) {
      if(var1 == null || var1.length < var4 * var5) {
         var1 = new BiomeBase[var4 * var5];
      }

      Arrays.fill(var1, 0, var4 * var5, this.b);
      return var1;
   }

   public float[] a(float[] var1, int var2, int var3, int var4, int var5) {
      if(var1 == null || var1.length < var4 * var5) {
         var1 = new float[var4 * var5];
      }

      Arrays.fill(var1, 0, var4 * var5, this.c);
      return var1;
   }

   public BiomeBase[] b(BiomeBase[] var1, int var2, int var3, int var4, int var5) {
      if(var1 == null || var1.length < var4 * var5) {
         var1 = new BiomeBase[var4 * var5];
      }

      Arrays.fill(var1, 0, var4 * var5, this.b);
      return var1;
   }

   public BiomeBase[] a(BiomeBase[] var1, int var2, int var3, int var4, int var5, boolean var6) {
      return this.b(var1, var2, var3, var4, var5);
   }

   public BlockPosition a(int var1, int var2, int var3, List var4, Random var5) {
      return var4.contains(this.b)?new BlockPosition(var1 - var3 + var5.nextInt(var3 * 2 + 1), 0, var2 - var3 + var5.nextInt(var3 * 2 + 1)):null;
   }

   public boolean a(int var1, int var2, int var3, List var4) {
      return var4.contains(this.b);
   }
}
