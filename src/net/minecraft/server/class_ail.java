package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahj;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;

public class class_ail extends Block {
   protected class_ail() {
      super(Material.c);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
      this.setLightOpacity(255);
   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      return new class_awf((double)var2.n(), (double)var2.o(), (double)var2.p(), (double)(var2.n() + 1), (double)(var2.o() + 1), (double)(var2.p() + 1));
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Blocks.DIRT.getDropType(Blocks.DIRT.getBlockData().set(class_ahj.a, class_ahj.class_a_in_class_ahj.a), var2, var3);
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      super.a(var1, var2, var3, var4);
      if(var1.p(var2.a()).getBlock().getMaterial().a()) {
         var1.a(var2, Blocks.DIRT.getBlockData());
      }

   }
}
