package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ajh;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aph;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_arb;
import net.minecraft.server.class_ark;
import net.minecraft.server.class_cj;

public class class_aff extends class_aez {
   private class_aql aD;
   private class_ark aE;
   private int aF;
   private int aG;
   private int aH;
   private int aI;

   protected class_aff(int var1, boolean var2) {
      super(var1);
      this.aD = new class_arb(class_agk.be.S().set(class_ajh.a, class_ajh.class_a_in_class_ajh.a), 9);
      this.aE = new class_ark(false);
      this.aF = 0;
      this.aG = 1;
      this.aH = 2;
      this.aI = this.aF;
      if(var2) {
         this.as.A = 3;
         this.aI = this.aG;
      }

   }

   public class_apw a(Random var1) {
      return (class_apw)(var1.nextInt(3) > 0?this.aE:super.a(var1));
   }

   public void a(class_aen var1, Random var2, class_cj var3) {
      super.a(var1, var2, var3);
      int var4 = 3 + var2.nextInt(6);

      int var5;
      int var6;
      int var7;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var2.nextInt(16);
         var7 = var2.nextInt(28) + 4;
         int var8 = var2.nextInt(16);
         class_cj var9 = var3.a(var6, var7, var8);
         if(var1.p(var9).getBlock() == class_agk.b) {
            var1.a((class_cj)var9, (IBlockData)class_agk.bP.S(), 2);
         }
      }

      for(var4 = 0; var4 < 7; ++var4) {
         var5 = var2.nextInt(16);
         var6 = var2.nextInt(64);
         var7 = var2.nextInt(16);
         this.aD.b(var1, var2, var3.a(var5, var6, var7));
      }

   }

   public void a(class_aen var1, Random var2, class_aph var3, int var4, int var5, double var6) {
      this.ak = class_agk.c.S();
      this.al = class_agk.d.S();
      if((var6 < -1.0D || var6 > 2.0D) && this.aI == this.aH) {
         this.ak = class_agk.n.S();
         this.al = class_agk.n.S();
      } else if(var6 > 1.0D && this.aI != this.aG) {
         this.ak = class_agk.b.S();
         this.al = class_agk.b.S();
      }

      this.b(var1, var2, var3, var4, var5, var6);
   }

   private class_aff b(class_aez var1) {
      this.aI = this.aH;
      this.a(var1.ai, true);
      this.a(var1.ah + " M");
      this.a(new class_aez.class_a_in_class_aez(var1.an, var1.ao));
      this.a(var1.ap, var1.aq);
      return this;
   }

   protected class_aez d(int var1) {
      return (new class_aff(var1, false)).b(this);
   }
}
