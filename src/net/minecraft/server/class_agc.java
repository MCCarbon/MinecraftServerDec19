package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;

public class class_agc extends Block {
   protected class_agc() {
      super(Material.I);
      this.setUnbreakable();
      this.setExplosionResist(6000001.0F);
      this.disableBreakStat();
      this.translucent = true;
   }

   public int getRenderType() {
      return -1;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public void a(World var1, class_cj var2, IBlockData var3, float var4, int var5) {
   }
}
