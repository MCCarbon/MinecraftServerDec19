package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;

public class class_aiq extends Block {
   private boolean a;

   protected class_aiq(Material var1, boolean var2) {
      this(var1, var2, var1.getMapColor());
   }

   protected class_aiq(Material var1, boolean var2, MaterialMapColor var3) {
      super(var1, var3);
      this.a = var2;
   }

   public boolean isOpaqueCube() {
      return false;
   }
}
