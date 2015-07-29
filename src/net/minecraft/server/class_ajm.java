package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.CreativeTab;

public class class_ajm extends Block {
   public class_ajm() {
      super(Material.e);
      this.a(CreativeTab.b);
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.K;
   }
}
