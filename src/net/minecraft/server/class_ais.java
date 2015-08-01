package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.CreativeTab;

public class class_ais extends Block {
   public class_ais() {
      super(Material.STONE);
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.COLOR16;
   }
}
