package net.minecraft.server;

import java.util.Random;

public class BlockLightstone extends Block {
   public BlockLightstone(Material var1) {
      super(var1);
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public int getDropCount(int var1, Random var2) {
      return MathHelper.clamp(this.getDropCount(var2) + var2.nextInt(var1 + 1), 1, 4);
   }

   public int getDropCount(Random var1) {
      return 2 + var1.nextInt(3);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.GLOWSTONE_DUST;
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.COLOR3;
   }
}
