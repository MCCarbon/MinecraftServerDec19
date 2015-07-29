package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_arn;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_aqn extends class_arn {
   private final class_anl a;
   private final class_anl b;

   public class_aqn(class_anl var1, class_anl var2) {
      super(false);
      this.b = var1;
      this.a = var2;
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      class_agj var4;
      while(((var4 = var1.p(var3).c()).v() == class_atk.a || var4.v() == class_atk.j) && var3.o() > 0) {
         var3 = var3.b();
      }

      class_agj var5 = var1.p(var3).c();
      if(var5 == class_agk.d || var5 == class_agk.c) {
         var3 = var3.a();
         this.a(var1, var3, this.b);

         for(int var6 = var3.o(); var6 <= var3.o() + 2; ++var6) {
            int var7 = var6 - var3.o();
            int var8 = 2 - var7;

            for(int var9 = var3.n() - var8; var9 <= var3.n() + var8; ++var9) {
               int var10 = var9 - var3.n();

               for(int var11 = var3.p() - var8; var11 <= var3.p() + var8; ++var11) {
                  int var12 = var11 - var3.p();
                  if(Math.abs(var10) != var8 || Math.abs(var12) != var8 || var2.nextInt(2) != 0) {
                     class_cj var13 = new class_cj(var9, var6, var11);
                     if(!var1.p(var13).c().q()) {
                        this.a(var1, var13, this.a);
                     }
                  }
               }
            }
         }
      }

      return true;
   }
}
