package net.minecraft.server;

import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_ajd;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vk;
import net.minecraft.server.CreativeTab;

public class class_alx extends class_ago {
   protected class_alx() {
      float var1 = 0.5F;
      float var2 = 0.015625F;
      this.setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
      this.a(CreativeTab.c);
   }

   public void a(World var1, class_cj var2, IBlockData var3, class_awf var4, List var5, class_pr var6) {
      if(var6 == null || !(var6 instanceof class_vk)) {
         super.a(var1, var2, var3, var4, var5, var6);
      }

   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      return new class_awf((double)var2.n() + this.minX, (double)var2.o() + this.minY, (double)var2.p() + this.minZ, (double)var2.n() + this.maxX, (double)var2.o() + this.maxY, (double)var2.p() + this.maxZ);
   }

   protected boolean c(Block var1) {
      return var1 == Blocks.WATER;
   }

   public boolean f(World var1, class_cj var2, IBlockData var3) {
      if(var2.o() >= 0 && var2.o() < 256) {
         IBlockData var4 = var1.p(var2.b());
         return var4.getBlock().getMaterial() == Material.h && ((Integer)var4.get(class_ajd.b)).intValue() == 0;
      } else {
         return false;
      }
   }

   public int toLegacyData(IBlockData var1) {
      return 0;
   }
}
