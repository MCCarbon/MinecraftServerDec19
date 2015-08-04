package net.minecraft.server;

import java.util.Random;

public class BlockSeaLantern extends Block {
   public BlockSeaLantern(Material var1) {
      super(var1);
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public int getDropCount(Random var1) {
      return 2 + var1.nextInt(2);
   }

   public int getDropCount(int var1, Random var2) {
      return MathHelper.clamp(this.getDropCount(var2) + var2.nextInt(var1 + 1), 1, 5);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.PRISMARINE_CRYSTALS;
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.COLOR15;
   }

   protected boolean canApplySilkTouch() {
      return true;
   }
}
