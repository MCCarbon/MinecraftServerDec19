package net.minecraft.server;

import java.util.Random;

public class BlockClay extends Block {
   private class_anp a;

   public BlockClay() {
      super(Material.CLAY);
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.CLAY_BALL;
   }

   public int getDropCount(Random var1) {
      return 4;
   }

   protected class_anp l() {
      if(this.a == null) {
         this.a = class_anq.a().a(new String[]{"##  ##", "##  ##", "  ##  ", " #### ", " #### ", " #  # "}).a('#', class_ano.a(class_ant.a(Blocks.CLAY))).b();
      }

      return this.a;
   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      super.onPlace(var1, var2, var3);
      this.e(var1, var2);
   }

   private void e(World var1, BlockPosition var2) {
      class_anp.class_b_in_class_anp var3 = this.l().a(var1, var2);
      if(var3 != null) {
         int var4;
         int var5;
         for(var4 = 0; var4 < this.l().c(); ++var4) {
            for(var5 = 0; var5 < this.l().b(); ++var5) {
               var1.setTypeAndData((BlockPosition)var3.a(var4, var5, 0).d(), (IBlockData)Blocks.AIR.getBlockData(), 2);
            }
         }

         if(!var1.isClientSide && var1.worldProvider instanceof class_apd) {
            class_apc var7 = ((class_apd)var1.worldProvider).s();
            if(var7 != null) {
               var7.e();
            }
         }

         for(var4 = 0; var4 < this.l().c(); ++var4) {
            for(var5 = 0; var5 < this.l().b(); ++var5) {
               class_ano var6 = var3.a(var4, var5, 0);
               var1.update(var6.d(), Blocks.AIR);
            }
         }
      }

   }
}
