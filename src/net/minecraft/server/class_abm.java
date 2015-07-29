package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zv;

public class class_abm extends class_zv {
   private static final Set c;

   public class_abm(class_aar.class_a_in_class_aar var1) {
      super(1.0F, var1, c);
   }

   public boolean b(class_agj var1) {
      return var1 == class_agk.aH?true:var1 == class_agk.aJ;
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(!var2.a(var4.a(var6), var6, var1)) {
         return class_oq.b;
      } else {
         class_anl var10 = var3.p(var4);
         class_agj var11 = var10.c();
         if(var6 != class_cq.a && var3.p(var4.a()).c().v() == class_atk.a) {
            if(var11 != class_agk.c) {
               return class_oq.b;
            } else {
               class_anl var12 = class_agk.da.S();
               class_agj var13 = var12.c();
               var3.a((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), var13.H.c(), (var13.H.d() + 1.0F) / 2.0F, var13.H.e() * 0.8F);
               if(var3.D) {
                  return class_oq.a;
               } else {
                  var3.a(var4, var12);
                  var1.a(1, (class_qa)var2);
                  return class_oq.b;
               }
            }
         } else {
            return class_oq.b;
         }
      }
   }

   static {
      c = Sets.newHashSet((Object[])(new class_agj[]{class_agk.aL, class_agk.d, class_agk.ak, class_agk.c, class_agk.n, class_agk.bw, class_agk.m, class_agk.aJ, class_agk.aH, class_agk.aW, class_agk.da}));
   }
}
