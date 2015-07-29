package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.Material;

public class class_alq extends Block {
   protected boolean R;

   protected class_alq(Material var1, boolean var2) {
      super(var1);
      this.R = var2;
   }

   public boolean isOpaqueCube() {
      return false;
   }
}
