package net.minecraft.server;

import java.util.List;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_ajd;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vk;
import net.minecraft.server.CreativeTab;

public class class_alx extends class_ago {
   protected class_alx() {
      float var1 = 0.5F;
      float var2 = 0.015625F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
      this.a(CreativeTab.c);
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_awf var4, List var5, class_pr var6) {
      if(var6 == null || !(var6 instanceof class_vk)) {
         super.a(var1, var2, var3, var4, var5, var6);
      }

   }

   public class_awf a(class_aen var1, class_cj var2, IBlockData var3) {
      return new class_awf((double)var2.n() + this.B, (double)var2.o() + this.C, (double)var2.p() + this.D, (double)var2.n() + this.E, (double)var2.o() + this.F, (double)var2.p() + this.G);
   }

   protected boolean c(Block var1) {
      return var1 == class_agk.j;
   }

   public boolean f(class_aen var1, class_cj var2, IBlockData var3) {
      if(var2.o() >= 0 && var2.o() < 256) {
         IBlockData var4 = var1.p(var2.b());
         return var4.getBlock().v() == class_atk.h && ((Integer)var4.get(class_ajd.b)).intValue() == 0;
      } else {
         return false;
      }
   }

   public int c(IBlockData var1) {
      return 0;
   }
}
