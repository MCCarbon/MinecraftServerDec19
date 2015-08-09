package net.minecraft.server;

public class BiomeEnd extends BiomeBase {
   public BiomeEnd(int var1) {
      super(var1);
      this.at.clear();
      this.au.clear();
      this.av.clear();
      this.aw.clear();
      this.at.add(new BiomeBase.BiomeMeta(EntityEnderman.class, 10, 4, 4));
      this.ak = Blocks.DIRT.getBlockData();
      this.al = Blocks.DIRT.getBlockData();
      this.as = new class_afx();
   }
}
