package net.minecraft.server;

public class BiomeMushrooms extends BiomeBase {
   public BiomeMushrooms(int var1) {
      super(var1);
      this.as.A = -100;
      this.as.B = -100;
      this.as.C = -100;
      this.as.E = 1;
      this.as.K = 1;
      this.ak = Blocks.MYCELIM.getBlockData();
      this.at.clear();
      this.au.clear();
      this.av.clear();
      this.au.add(new BiomeBase.BiomeMeta(EntityMushroomCow.class, 8, 4, 8));
   }
}
