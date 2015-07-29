package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ale;
import net.minecraft.server.class_alw;
import net.minecraft.server.class_ame;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_di;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zg;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zy;

public class class_ze extends class_zg {
   public class_ze() {
      super(class_agk.cK);
      this.h = 16;
      this.a(CreativeTab.c);
      this.a(true);
      this.e(0);
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(var6 == class_cq.a) {
         return class_oq.b;
      } else if(!var3.p(var4).getBlock().v().a()) {
         return class_oq.b;
      } else {
         var4 = var4.a(var6);
         if(!var2.a(var4, var6, var1)) {
            return class_oq.b;
         } else if(!class_agk.cK.d(var3, var4)) {
            return class_oq.b;
         } else if(var3.D) {
            return class_oq.a;
         } else {
            if(var6 == class_cq.b) {
               int var10 = class_nu.c((double)((var2.y + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
               var3.a((class_cj)var4, (IBlockData)class_agk.cK.S().set(class_ale.a, Integer.valueOf(var10)), 3);
            } else {
               var3.a((class_cj)var4, (IBlockData)class_agk.cL.S().set(class_alw.a, var6), 3);
            }

            --var1.b;
            class_amg var11 = var3.s(var4);
            if(var11 instanceof class_ame) {
               ((class_ame)var11).a(var1);
            }

            return class_oq.a;
         }
      }
   }

   public String a(class_aas var1) {
      String var2 = "item.banner.";
      class_zy var3 = this.h(var1);
      var2 = var2 + var3.d() + ".name";
      return class_di.a(var2);
   }

   private class_zy h(class_aas var1) {
      class_dn var2 = var1.a("BlockEntityTag", false);
      class_zy var3 = null;
      if(var2 != null && var2.d("Base")) {
         var3 = class_zy.a(var2.g("Base"));
      } else {
         var3 = class_zy.a(var1.i());
      }

      return var3;
   }
}
