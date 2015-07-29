package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.class_amv;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_od;
import net.minecraft.server.class_oj;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_ara extends class_aql {
   private static final Logger a = LogManager.getLogger();
   private static final String[] b = new String[]{"Skeleton", "Zombie", "Zombie", "Spider"};
   private static final List c;

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      boolean var4 = true;
      int var5 = var2.nextInt(2) + 2;
      int var6 = -var5 - 1;
      int var7 = var5 + 1;
      boolean var8 = true;
      boolean var9 = true;
      int var10 = var2.nextInt(2) + 2;
      int var11 = -var10 - 1;
      int var12 = var10 + 1;
      int var13 = 0;

      int var14;
      int var15;
      int var16;
      class_cj var17;
      for(var14 = var6; var14 <= var7; ++var14) {
         for(var15 = -1; var15 <= 4; ++var15) {
            for(var16 = var11; var16 <= var12; ++var16) {
               var17 = var3.a(var14, var15, var16);
               class_atk var18 = var1.p(var17).getBlock().v();
               boolean var19 = var18.a();
               if(var15 == -1 && !var19) {
                  return false;
               }

               if(var15 == 4 && !var19) {
                  return false;
               }

               if((var14 == var6 || var14 == var7 || var16 == var11 || var16 == var12) && var15 == 0 && var1.d(var17) && var1.d(var17.a())) {
                  ++var13;
               }
            }
         }
      }

      if(var13 >= 1 && var13 <= 5) {
         for(var14 = var6; var14 <= var7; ++var14) {
            for(var15 = 3; var15 >= -1; --var15) {
               for(var16 = var11; var16 <= var12; ++var16) {
                  var17 = var3.a(var14, var15, var16);
                  if(var14 != var6 && var15 != -1 && var16 != var11 && var14 != var7 && var15 != 4 && var16 != var12) {
                     if(var1.p(var17).getBlock() != class_agk.ae) {
                        var1.g(var17);
                     }
                  } else if(var17.o() >= 0 && !var1.p(var17.b()).getBlock().v().a()) {
                     var1.g(var17);
                  } else if(var1.p(var17).getBlock().v().a() && var1.p(var17).getBlock() != class_agk.ae) {
                     if(var15 == -1 && var2.nextInt(4) != 0) {
                        var1.a((class_cj)var17, (IBlockData)class_agk.Y.S(), 2);
                     } else {
                        var1.a((class_cj)var17, (IBlockData)class_agk.e.S(), 2);
                     }
                  }
               }
            }
         }

         for(var14 = 0; var14 < 2; ++var14) {
            for(var15 = 0; var15 < 3; ++var15) {
               var16 = var3.n() + var2.nextInt(var5 * 2 + 1) - var5;
               int var24 = var3.o();
               int var25 = var3.p() + var2.nextInt(var10 * 2 + 1) - var10;
               class_cj var26 = new class_cj(var16, var24, var25);
               if(var1.d(var26)) {
                  int var20 = 0;
                  Iterator var21 = class_cq.class_c_in_class_cq.a.iterator();

                  while(var21.hasNext()) {
                     class_cq var22 = (class_cq)var21.next();
                     if(var1.p(var26.a(var22)).getBlock().v().a()) {
                        ++var20;
                     }
                  }

                  if(var20 == 1) {
                     var1.a((class_cj)var26, (IBlockData)class_agk.ae.f(var1, var26, class_agk.ae.S()), 2);
                     List var27 = class_od.a(c, new class_od[]{class_aau.cg.b(var2)});
                     class_amg var28 = var1.s(var26);
                     if(var28 instanceof class_ami) {
                        class_od.a(var2, var27, (class_oj)((class_ami)var28), 8);
                     }
                     break;
                  }
               }
            }
         }

         var1.a((class_cj)var3, (IBlockData)class_agk.ac.S(), 2);
         class_amg var23 = var1.s(var3);
         if(var23 instanceof class_amv) {
            ((class_amv)var23).b().a(this.a(var2));
         } else {
            a.error("Failed to fetch mob spawner entity at (" + var3.n() + ", " + var3.o() + ", " + var3.p() + ")");
         }

         return true;
      } else {
         return false;
      }
   }

   private String a(Random var1) {
      return b[var1.nextInt(b.length)];
   }

   static {
      c = Lists.newArrayList((Object[])(new class_od[]{new class_od(class_aau.aC, 0, 1, 1, 10), new class_od(class_aau.l, 0, 1, 4, 10), new class_od(class_aau.R, 0, 1, 1, 10), new class_od(class_aau.Q, 0, 1, 4, 10), new class_od(class_aau.J, 0, 1, 4, 10), new class_od(class_aau.H, 0, 1, 4, 10), new class_od(class_aau.ay, 0, 1, 1, 10), new class_od(class_aau.aq, 0, 1, 1, 1), new class_od(class_aau.aE, 0, 1, 4, 10), new class_od(class_aau.ct, 0, 1, 1, 4), new class_od(class_aau.cu, 0, 1, 1, 4), new class_od(class_aau.cr, 0, 1, 1, 10), new class_od(class_aau.co, 0, 1, 1, 2), new class_od(class_aau.cn, 0, 1, 1, 5), new class_od(class_aau.cp, 0, 1, 1, 1)}));
   }
}
