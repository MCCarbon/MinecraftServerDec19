package net.minecraft.server;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_afd;
import net.minecraft.server.BlockPosition;

public class class_afg extends class_afd {
   private class_aez b;
   private float c;

   public class_afg(class_aez var1, float var2) {
      this.b = var1;
      this.c = var2;
   }

   public class_aez a(BlockPosition var1) {
      return this.b;
   }

   public class_aez[] a(class_aez[] var1, int var2, int var3, int var4, int var5) {
      if(var1 == null || var1.length < var4 * var5) {
         var1 = new class_aez[var4 * var5];
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

   public class_aez[] b(class_aez[] var1, int var2, int var3, int var4, int var5) {
      if(var1 == null || var1.length < var4 * var5) {
         var1 = new class_aez[var4 * var5];
      }

      Arrays.fill(var1, 0, var4 * var5, this.b);
      return var1;
   }

   public class_aez[] a(class_aez[] var1, int var2, int var3, int var4, int var5, boolean var6) {
      return this.b(var1, var2, var3, var4, var5);
   }

   public BlockPosition a(int var1, int var2, int var3, List var4, Random var5) {
      return var4.contains(this.b)?new BlockPosition(var1 - var3 + var5.nextInt(var3 * 2 + 1), 0, var2 - var3 + var5.nextInt(var3 * 2 + 1)):null;
   }

   public boolean a(int var1, int var2, int var3, List var4) {
      return var4.contains(this.b);
   }
}
