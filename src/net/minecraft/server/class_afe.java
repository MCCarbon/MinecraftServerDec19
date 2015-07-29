package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_aez;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aqg;
import net.minecraft.server.class_cj;

public class class_afe extends class_aez {
   public class_afe(int var1) {
      super(var1);
      this.au.clear();
      this.ak = Blocks.SAND.getBlockData();
      this.al = Blocks.SAND.getBlockData();
      this.as.A = -999;
      this.as.D = 2;
      this.as.F = 50;
      this.as.G = 10;
      this.au.clear();
   }

   public void a(World var1, Random var2, class_cj var3) {
      super.a(var1, var2, var3);
      if(var2.nextInt(1000) == 0) {
         int var4 = var2.nextInt(16) + 8;
         int var5 = var2.nextInt(16) + 8;
         class_cj var6 = var1.m(var3.a(var4, 0, var5)).a();
         (new class_aqg()).b(var1, var2, var6);
      }

   }
}
