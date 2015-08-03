package net.minecraft.server;

import java.util.Random;

public class class_agm extends Block {
   public class_agm() {
      super(Material.WOOD);
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public int getDropCount(Random var1) {
      return 3;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.BOOK;
   }
}
