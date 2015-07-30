package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anb;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_pr;

public class class_ahs extends class_agd {
   protected class_ahs(Material var1) {
      super(var1);
      this.setLightLevel(1.0F);
   }

   public class_amg a(World var1, int var2) {
      return new class_anb();
   }

   public void a(class_aer var1, BlockPosition var2) {
      float var3 = 0.0625F;
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_awf var4, List var5, class_pr var6) {
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public int a(Random var1) {
      return 0;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_pr var4) {
      if(var4.m == null && var4.l == null && !var1.D) {
         var4.c(1);
      }

   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.COLOR30;
   }
}
