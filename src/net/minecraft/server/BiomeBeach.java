package net.minecraft.server;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.Blocks;

public class BiomeBeach extends BiomeBase {
   public BiomeBeach(int var1) {
      super(var1);
      this.au.clear();
      this.ak = Blocks.SAND.getBlockData();
      this.al = Blocks.SAND.getBlockData();
      this.as.A = -999;
      this.as.D = 0;
      this.as.F = 0;
      this.as.G = 0;
   }
}
