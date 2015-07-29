package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aht;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xe;
import net.minecraft.server.class_zu;

public class class_aae extends class_aar {
   public class_aae() {
      this.a(class_zu.f);
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      class_anl var10 = var3.p(var4);
      if(var2.a(var4.a(var6), var6, var1) && var10.c() == class_agk.bG && !((Boolean)var10.b(class_aht.b)).booleanValue()) {
         if(var3.D) {
            return class_oq.a;
         } else {
            var3.a((class_cj)var4, (class_anl)var10.a(class_aht.b, Boolean.valueOf(true)), 2);
            var3.e(var4, class_agk.bG);
            --var1.b;

            for(int var11 = 0; var11 < 16; ++var11) {
               double var12 = (double)((float)var4.n() + (5.0F + g.nextFloat() * 6.0F) / 16.0F);
               double var14 = (double)((float)var4.o() + 0.8125F);
               double var16 = (double)((float)var4.p() + (5.0F + g.nextFloat() * 6.0F) / 16.0F);
               double var18 = 0.0D;
               double var20 = 0.0D;
               double var22 = 0.0D;
               var3.a(class_cy.l, var12, var14, var16, var18, var20, var22, new int[0]);
            }

            class_cq var24 = (class_cq)var10.b(class_aht.a);
            int var25 = 0;
            int var13 = 0;
            boolean var26 = false;
            boolean var15 = true;
            class_cq var27 = var24.e();

            for(int var17 = -2; var17 <= 2; ++var17) {
               class_cj var29 = var4.a(var27, var17);
               class_anl var19 = var3.p(var29);
               if(var19.c() == class_agk.bG) {
                  if(!((Boolean)var19.b(class_aht.b)).booleanValue()) {
                     var15 = false;
                     break;
                  }

                  var13 = var17;
                  if(!var26) {
                     var25 = var17;
                     var26 = true;
                  }
               }
            }

            if(var15 && var13 == var25 + 2) {
               class_cj var28 = var4.a(var24, 4);

               int var30;
               for(var30 = var25; var30 <= var13; ++var30) {
                  class_cj var31 = var28.a(var27, var30);
                  class_anl var33 = var3.p(var31);
                  if(var33.c() != class_agk.bG || !((Boolean)var33.b(class_aht.b)).booleanValue()) {
                     var15 = false;
                     break;
                  }
               }

               int var32;
               class_cj var34;
               for(var30 = var25 - 1; var30 <= var13 + 1; var30 += 4) {
                  var28 = var4.a(var27, var30);

                  for(var32 = 1; var32 <= 3; ++var32) {
                     var34 = var28.a(var24, var32);
                     class_anl var21 = var3.p(var34);
                     if(var21.c() != class_agk.bG || !((Boolean)var21.b(class_aht.b)).booleanValue()) {
                        var15 = false;
                        break;
                     }
                  }
               }

               if(var15) {
                  for(var30 = var25; var30 <= var13; ++var30) {
                     var28 = var4.a(var27, var30);

                     for(var32 = 1; var32 <= 3; ++var32) {
                        var34 = var28.a(var24, var32);
                        var3.a((class_cj)var34, (class_anl)class_agk.bF.S(), 2);
                     }
                  }
               }
            }

            return class_oq.a;
         }
      } else {
         return class_oq.b;
      }
   }

   public class_or a(class_aas var1, class_aen var2, class_xa var3, class_oo var4) {
      class_awg var5 = this.a(var2, var3, false);
      if(var5 != null && var5.a == class_awg.class_a_in_class_awg.b && var2.p(var5.a()).c() == class_agk.bG) {
         return new class_or(class_oq.a, var1);
      } else {
         if(!var2.D) {
            class_cj var6 = var2.a("Stronghold", new class_cj(var3));
            if(var6 != null) {
               class_xe var7 = new class_xe(var2, var3.s, var3.t, var3.u);
               var7.a(var6);
               var2.a((class_pr)var7);
               var2.a((class_pr)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
               var2.a((class_xa)null, 1002, new class_cj(var3), 0);
               if(!var3.bH.d) {
                  --var1.b;
               }

               var3.b(class_nc.ad[class_aar.b((class_aar)this)]);
               return new class_or(class_oq.a, var1);
            }
         }

         return new class_or(class_oq.b, var1);
      }
   }
}
