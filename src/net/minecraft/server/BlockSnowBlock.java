package net.minecraft.server;

import java.util.Random;

public class class_akx extends Block {
   protected class_akx() {
      super(Material.SNOW_BLOCK);
      this.setTicking(true);
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.SNOWBALL;
   }

   public int getDropCount(Random var1) {
      return 4;
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(var1.b(class_aet.b, var2) > 11) {
         this.dropNaturallyForSure(var1, var2, var1.getType(var2), 0);
         var1.setAir(var2);
      }

   }
}
