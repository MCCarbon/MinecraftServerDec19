package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_ahk;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amm;
import net.minecraft.server.class_amn;
import net.minecraft.server.class_amt;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_cl;
import net.minecraft.server.class_cn;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_cr;
import net.minecraft.server.class_oj;

public class class_aho extends class_ahk {
   private final class_cr P = new class_cn();

   protected class_cr a(class_aas var1) {
      return this.P;
   }

   public class_amg a(World var1, int var2) {
      return new class_amn();
   }

   protected void f(World var1, BlockPosition var2) {
      class_cl var3 = new class_cl(var1, var2);
      class_amm var4 = (class_amm)var3.h();
      if(var4 != null) {
         int var5 = var4.m();
         if(var5 < 0) {
            var1.b(1001, var2, 0);
         } else {
            class_aas var6 = var4.a(var5);
            if(var6 != null) {
               EnumDirection var7 = (EnumDirection)var1.p(var2).get(a);
               BlockPosition var8 = var2.shift(var7);
               class_oj var9 = class_amt.b(var1, (double)var8.getX(), (double)var8.getY(), (double)var8.getZ());
               class_aas var10;
               if(var9 == null) {
                  var10 = this.P.a(var3, var6);
                  if(var10 != null && var10.b <= 0) {
                     var10 = null;
                  }
               } else {
                  var10 = class_amt.a(var9, var6.k().a(1), var7.getOpposite());
                  if(var10 == null) {
                     var10 = var6.k();
                     if(--var10.b <= 0) {
                        var10 = null;
                     }
                  } else {
                     var10 = var6.k();
                  }
               }

               var4.a(var5, var10);
            }
         }
      }
   }
}
