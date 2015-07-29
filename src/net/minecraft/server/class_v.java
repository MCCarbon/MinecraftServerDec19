package net.minecraft.server;

import java.util.List;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;

public class class_v extends class_i {
   public String c() {
      return "testforblocks";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.compare.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 9) {
         throw new class_cf("commands.compare.usage", new Object[0]);
      } else {
         var1.a(class_n.class_a_in_class_n.b, 0);
         class_cj var3 = a(var1, var2, 0, false);
         class_cj var4 = a(var1, var2, 3, false);
         class_cj var5 = a(var1, var2, 6, false);
         class_arw var6 = new class_arw(var3, var4);
         class_arw var7 = new class_arw(var5, var5.a(var6.b()));
         int var8 = var6.c() * var6.d() * var6.e();
         if(var8 > 524288) {
            throw new class_bz("commands.compare.tooManyBlocks", new Object[]{Integer.valueOf(var8), Integer.valueOf(524288)});
         } else if(var6.b >= 0 && var6.e < 256 && var7.b >= 0 && var7.e < 256) {
            class_aen var9 = var1.e();
            if(var9.a(var6) && var9.a(var7)) {
               boolean var10 = false;
               if(var2.length > 9 && var2[9].equals("masked")) {
                  var10 = true;
               }

               var8 = 0;
               class_cj var11 = new class_cj(var7.a - var6.a, var7.b - var6.b, var7.c - var6.c);
               class_cj.class_a_in_class_cj var12 = new class_cj.class_a_in_class_cj();
               class_cj.class_a_in_class_cj var13 = new class_cj.class_a_in_class_cj();

               for(int var14 = var6.c; var14 <= var6.f; ++var14) {
                  for(int var15 = var6.b; var15 <= var6.e; ++var15) {
                     for(int var16 = var6.a; var16 <= var6.d; ++var16) {
                        var12.c(var16, var15, var14);
                        var13.c(var16 + var11.n(), var15 + var11.o(), var14 + var11.p());
                        boolean var17 = false;
                        class_anl var18 = var9.p(var12);
                        if(!var10 || var18.c() != class_agk.a) {
                           if(var18 == var9.p(var13)) {
                              class_amg var19 = var9.s(var12);
                              class_amg var20 = var9.s(var13);
                              if(var19 != null && var20 != null) {
                                 class_dn var21 = new class_dn();
                                 var19.b(var21);
                                 var21.p("x");
                                 var21.p("y");
                                 var21.p("z");
                                 class_dn var22 = new class_dn();
                                 var20.b(var22);
                                 var22.p("x");
                                 var22.p("y");
                                 var22.p("z");
                                 if(!var21.equals(var22)) {
                                    var17 = true;
                                 }
                              } else if(var19 != null) {
                                 var17 = true;
                              }
                           } else {
                              var17 = true;
                           }

                           ++var8;
                           if(var17) {
                              throw new class_bz("commands.compare.failed", new Object[0]);
                           }
                        }
                     }
                  }
               }

               var1.a(class_n.class_a_in_class_n.b, var8);
               a(var1, this, "commands.compare.success", new Object[]{Integer.valueOf(var8)});
            } else {
               throw new class_bz("commands.compare.outOfWorld", new Object[0]);
            }
         } else {
            throw new class_bz("commands.compare.outOfWorld", new Object[0]);
         }
      }
   }

   public List a(class_m var1, String[] var2, class_cj var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length > 3 && var2.length <= 6?a(var2, 3, var3):(var2.length > 6 && var2.length <= 9?a(var2, 6, var3):(var2.length == 10?a(var2, new String[]{"masked", "all"}):null)));
   }
}
