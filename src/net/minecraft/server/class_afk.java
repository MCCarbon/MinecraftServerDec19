package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_aez;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_ajs;
import net.minecraft.server.class_ajt;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_alm;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_aqn;
import net.minecraft.server.class_aqw;
import net.minecraft.server.class_aqz;
import net.minecraft.server.class_arm;
import net.minecraft.server.class_arn;
import net.minecraft.server.class_aro;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_tx;
import net.minecraft.server.class_uc;

public class class_afk extends class_aez {
   private boolean aD;
   private static final IBlockData aE;
   private static final IBlockData aF;
   private static final IBlockData aG;

   public class_afk(int var1, boolean var2) {
      super(var1);
      this.aD = var2;
      if(var2) {
         this.as.A = 2;
      } else {
         this.as.A = 50;
      }

      this.as.C = 25;
      this.as.B = 4;
      if(!var2) {
         this.at.add(new class_aez.class_c_in_class_aez(class_uc.class, 2, 1, 1));
      }

      this.au.add(new class_aez.class_c_in_class_aez(class_tx.class, 10, 4, 4));
   }

   public class_apw a(Random var1) {
      return (class_apw)(var1.nextInt(10) == 0?this.aB:(var1.nextInt(2) == 0?new class_aqn(aE, aG):(!this.aD && var1.nextInt(3) == 0?new class_aqw(false, 10, 20, aE, aF):new class_arn(false, 4 + var1.nextInt(7), aE, aF, true))));
   }

   public class_aql b(Random var1) {
      return var1.nextInt(4) == 0?new class_arm(class_alm.class_a_in_class_alm.c):new class_arm(class_alm.class_a_in_class_alm.b);
   }

   public void a(World var1, Random var2, class_cj var3) {
      super.a(var1, var2, var3);
      int var4 = var2.nextInt(16) + 8;
      int var5 = var2.nextInt(16) + 8;
      int var6 = var2.nextInt(var1.m(var3.a(var4, 0, var5)).o() * 2);
      (new class_aqz()).b(var1, var2, var3.a(var4, var6, var5));
      class_aro var9 = new class_aro();

      for(var5 = 0; var5 < 50; ++var5) {
         var6 = var2.nextInt(16) + 8;
         boolean var7 = true;
         int var8 = var2.nextInt(16) + 8;
         var9.b(var1, var2, var3.a(var6, 128, var8));
      }

   }

   static {
      aE = Blocks.LOG.getBlockData().set(class_ajt.b, class_ajw.class_a_in_class_ajw.d);
      aF = Blocks.LEAVES.getBlockData().set(class_ajs.Q, class_ajw.class_a_in_class_ajw.d).set(class_aja.b, Boolean.valueOf(false));
      aG = Blocks.LEAVES.getBlockData().set(class_ajs.Q, class_ajw.class_a_in_class_ajw.a).set(class_aja.b, Boolean.valueOf(false));
   }
}
