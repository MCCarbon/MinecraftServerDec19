package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_od;
import net.minecraft.server.class_oj;

public class class_aqa extends class_aql {
   private final List a;
   private final int b;

   public class_aqa(List var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      Block var4;
      while(((var4 = var1.p(var3).getBlock()).v() == class_atk.a || var4.v() == class_atk.j) && var3.o() > 1) {
         var3 = var3.b();
      }

      if(var3.o() < 1) {
         return false;
      } else {
         var3 = var3.a();

         for(int var5 = 0; var5 < 4; ++var5) {
            class_cj var6 = var3.a(var2.nextInt(4) - var2.nextInt(4), var2.nextInt(3) - var2.nextInt(3), var2.nextInt(4) - var2.nextInt(4));
            if(var1.d(var6) && class_aen.a((class_aer)var1, (class_cj)var6.b())) {
               var1.a((class_cj)var6, (IBlockData)class_agk.ae.S(), 2);
               class_amg var7 = var1.s(var6);
               if(var7 instanceof class_ami) {
                  class_od.a(var2, this.a, (class_oj)((class_ami)var7), this.b);
               }

               class_cj var8 = var6.f();
               class_cj var9 = var6.e();
               class_cj var10 = var6.c();
               class_cj var11 = var6.d();
               if(var1.d(var9) && class_aen.a((class_aer)var1, (class_cj)var9.b())) {
                  var1.a((class_cj)var9, (IBlockData)class_agk.aa.S(), 2);
               }

               if(var1.d(var8) && class_aen.a((class_aer)var1, (class_cj)var8.b())) {
                  var1.a((class_cj)var8, (IBlockData)class_agk.aa.S(), 2);
               }

               if(var1.d(var10) && class_aen.a((class_aer)var1, (class_cj)var10.b())) {
                  var1.a((class_cj)var10, (IBlockData)class_agk.aa.S(), 2);
               }

               if(var1.d(var11) && class_aen.a((class_aer)var1, (class_cj)var11.b())) {
                  var1.a((class_cj)var11, (IBlockData)class_agk.aa.S(), 2);
               }

               return true;
            }
         }

         return false;
      }
   }
}
