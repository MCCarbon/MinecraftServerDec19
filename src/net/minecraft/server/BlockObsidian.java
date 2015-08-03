package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.CreativeTab;

public class BlockObsidian extends Block {
   public BlockObsidian() {
      super(Material.STONE);
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getItemOf(Blocks.OBSIDIAN);
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.COLOR30;
   }
}
