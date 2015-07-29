package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ale;
import net.minecraft.server.class_alw;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amx;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zg;
import net.minecraft.server.CreativeTab;

public class class_abn extends class_aar {
   public class_abn() {
      this.h = 16;
      this.a(CreativeTab.c);
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
         } else if(!class_agk.an.d(var3, var4)) {
            return class_oq.b;
         } else if(var3.D) {
            return class_oq.a;
         } else {
            if(var6 == class_cq.b) {
               int var10 = class_nu.c((double)((var2.y + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
               var3.a((class_cj)var4, (IBlockData)class_agk.an.S().set(class_ale.a, Integer.valueOf(var10)), 3);
            } else {
               var3.a((class_cj)var4, (IBlockData)class_agk.ax.S().set(class_alw.a, var6), 3);
            }

            --var1.b;
            class_amg var11 = var3.s(var4);
            if(var11 instanceof class_amx && !class_zg.a(var3, var2, var4, var1)) {
               var2.a((class_amx)var11);
            }

            return class_oq.a;
         }
      }
   }
}
