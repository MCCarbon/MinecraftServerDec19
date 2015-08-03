package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.class_aqg;
import net.minecraft.server.BlockPosition;

public class class_afe extends BiomeBase {
   public class_afe(int var1) {
      super(var1);
      this.au.clear();
      this.ak = BlockStainedGlassPane.SAND.getBlockData();
      this.al = BlockStainedGlassPane.SAND.getBlockData();
      this.as.A = -999;
      this.as.D = 2;
      this.as.F = 50;
      this.as.G = 10;
      this.au.clear();
   }

   public void a(World var1, Random var2, BlockPosition var3) {
      super.a(var1, var2, var3);
      if(var2.nextInt(1000) == 0) {
         int var4 = var2.nextInt(16) + 8;
         int var5 = var2.nextInt(16) + 8;
         BlockPosition var6 = var1.m(var3.add(var4, 0, var5)).up();
         (new class_aqg()).b(var1, var2, var6);
      }

   }
}
