package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_aez;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_ahm;
import net.minecraft.server.class_alm;
import net.minecraft.server.class_aph;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_apz;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_aqx;
import net.minecraft.server.class_arc;
import net.minecraft.server.class_ark;
import net.minecraft.server.class_arm;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_ul;

public class class_afv extends class_aez {
   private static final class_arc aD = new class_arc();
   private static final class_ark aE = new class_ark(false);
   private static final class_aqx aF = new class_aqx(false, false);
   private static final class_aqx aG = new class_aqx(false, true);
   private static final class_apz aH;
   private int aI;

   public class_afv(int var1, int var2) {
      super(var1);
      this.aI = var2;
      this.au.add(new class_aez.class_c_in_class_aez(class_ul.class, 8, 4, 4));
      this.as.A = 10;
      if(var2 != 1 && var2 != 2) {
         this.as.C = 1;
         this.as.E = 1;
      } else {
         this.as.C = 7;
         this.as.D = 1;
         this.as.E = 3;
      }

   }

   public class_apw a(Random var1) {
      return (class_apw)((this.aI == 1 || this.aI == 2) && var1.nextInt(3) == 0?(this.aI != 2 && var1.nextInt(13) != 0?aF:aG):(var1.nextInt(3) == 0?aD:aE));
   }

   public class_aql b(Random var1) {
      return var1.nextInt(5) > 0?new class_arm(class_alm.class_a_in_class_alm.c):new class_arm(class_alm.class_a_in_class_alm.b);
   }

   public void a(World var1, Random var2, class_cj var3) {
      int var4;
      int var5;
      int var6;
      int var7;
      if(this.aI == 1 || this.aI == 2) {
         var4 = var2.nextInt(3);

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var2.nextInt(16) + 8;
            var7 = var2.nextInt(16) + 8;
            class_cj var8 = var1.m(var3.a(var6, 0, var7));
            aH.b(var1, var2, var8);
         }
      }

      ag.a(class_ahm.class_b_in_class_ahm.d);

      for(var4 = 0; var4 < 7; ++var4) {
         var5 = var2.nextInt(16) + 8;
         var6 = var2.nextInt(16) + 8;
         var7 = var2.nextInt(var1.m(var3.a(var5, 0, var6)).o() + 32);
         ag.b(var1, var2, var3.a(var5, var7, var6));
      }

      super.a(var1, var2, var3);
   }

   public void a(World var1, Random var2, class_aph var3, int var4, int var5, double var6) {
      if(this.aI == 1 || this.aI == 2) {
         this.ak = Blocks.GRASS.getBlockData();
         this.al = Blocks.DIRT.getBlockData();
         if(var6 > 1.75D) {
            this.ak = Blocks.DIRT.getBlockData().set(class_ahj.a, class_ahj.class_a_in_class_ahj.b);
         } else if(var6 > -0.95D) {
            this.ak = Blocks.DIRT.getBlockData().set(class_ahj.a, class_ahj.class_a_in_class_ahj.c);
         }
      }

      this.b(var1, var2, var3, var4, var5, var6);
   }

   protected class_aez d(int var1) {
      return this.az == class_aez.V.az?(new class_afv(var1, 2)).a(5858897, true).a("Mega Spruce Taiga").a(5159473).a(0.25F, 0.8F).a(new class_aez.class_a_in_class_aez(this.an, this.ao)):super.d(var1);
   }

   static {
      aH = new class_apz(Blocks.MOSSY_COBBLESTONE, 0);
   }
}
