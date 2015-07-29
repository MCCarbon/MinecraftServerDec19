package net.minecraft.server;

import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_ajz extends Block {
   public class_ajz(Material var1, MaterialMapColor var2) {
      super(var1, var2);
   }

   public boolean isPowerSource() {
      return true;
   }

   public int a(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      return 15;
   }
}
