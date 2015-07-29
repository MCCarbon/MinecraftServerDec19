package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_xa;

public class class_ahf extends class_ago {
   protected class_ahf() {
      super(class_atk.l);
      float var1 = 0.4F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
   }

   public class_atl g(IBlockData var1) {
      return class_atl.o;
   }

   protected boolean c(Block var1) {
      return var1 == class_agk.m || var1 == class_agk.cz || var1 == class_agk.cu || var1 == class_agk.d;
   }

   public boolean a(class_aen var1, class_cj var2) {
      return true;
   }

   public int a(Random var1) {
      return var1.nextInt(3);
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aau.A;
   }

   public void a(class_aen var1, class_xa var2, class_cj var3, IBlockData var4, class_amg var5, class_aas var6) {
      if(!var1.D && var6 != null && var6.b() == class_aau.bg) {
         var2.b(class_nc.ab[Block.getId((Block)this)]);
         a(var1, var3, new class_aas(class_agk.I, 1, 0));
      } else {
         super.a(var1, var2, var3, var4, var5, var6);
      }

   }
}
