package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.CreativeTab;

public class class_ago extends Block {
   protected class_ago() {
      this(Material.k);
   }

   protected class_ago(Material var1) {
      this(var1, var1.getMapColor());
   }

   protected class_ago(Material var1, MaterialMapColor var2) {
      super(var1, var2);
      this.setTicking(true);
      float var3 = 0.2F;
      this.setSizes(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
      this.a(CreativeTab.c);
   }

   public boolean d(World var1, class_cj var2) {
      return super.d(var1, var2) && this.c(var1.p(var2.b()).getBlock());
   }

   protected boolean c(Block var1) {
      return var1 == Blocks.GRASS || var1 == Blocks.DIRT || var1 == Blocks.FARMLAND;
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      super.a(var1, var2, var3, var4);
      this.e(var1, var2, var3);
   }

   public void b(World var1, class_cj var2, IBlockData var3, Random var4) {
      this.e(var1, var2, var3);
   }

   protected void e(World var1, class_cj var2, IBlockData var3) {
      if(!this.f(var1, var2, var3)) {
         this.b(var1, var2, var3, 0);
         var1.a((class_cj)var2, (IBlockData)Blocks.AIR.getBlockData(), 3);
      }

   }

   public boolean f(World var1, class_cj var2, IBlockData var3) {
      return this.c(var1.p(var2.b()).getBlock());
   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      return null;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }
}
