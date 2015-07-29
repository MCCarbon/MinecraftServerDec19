package net.minecraft.server;

import com.google.common.base.Predicates;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aio;
import net.minecraft.server.class_akq;
import net.minecraft.server.class_alk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_ant;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_aqg extends class_aql {
   private static final class_ant a;
   private final IBlockData b;
   private final IBlockData c;
   private final IBlockData d;

   public class_aqg() {
      this.b = class_agk.U.S().set(class_alk.N, class_alk.class_a_in_class_alk.b).set(class_aio.a, class_aio.class_a_in_class_aio.b);
      this.c = class_agk.A.S();
      this.d = class_agk.i.S();
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      while(var1.d(var3) && var3.o() > 2) {
         var3 = var3.b();
      }

      if(!a.a(var1.p(var3))) {
         return false;
      } else {
         int var4;
         int var5;
         for(var4 = -2; var4 <= 2; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               if(var1.d(var3.a(var4, -1, var5)) && var1.d(var3.a(var4, -2, var5))) {
                  return false;
               }
            }
         }

         for(var4 = -1; var4 <= 0; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               for(int var6 = -2; var6 <= 2; ++var6) {
                  var1.a((class_cj)var3.a(var5, var4, var6), (IBlockData)this.c, 2);
               }
            }
         }

         var1.a((class_cj)var3, (IBlockData)this.d, 2);
         Iterator var7 = class_cq.class_c_in_class_cq.a.iterator();

         while(var7.hasNext()) {
            class_cq var8 = (class_cq)var7.next();
            var1.a((class_cj)var3.a(var8), (IBlockData)this.d, 2);
         }

         for(var4 = -2; var4 <= 2; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               if(var4 == -2 || var4 == 2 || var5 == -2 || var5 == 2) {
                  var1.a((class_cj)var3.a(var4, 1, var5), (IBlockData)this.c, 2);
               }
            }
         }

         var1.a((class_cj)var3.a(2, 1, 0), (IBlockData)this.b, 2);
         var1.a((class_cj)var3.a(-2, 1, 0), (IBlockData)this.b, 2);
         var1.a((class_cj)var3.a(0, 1, 2), (IBlockData)this.b, 2);
         var1.a((class_cj)var3.a(0, 1, -2), (IBlockData)this.b, 2);

         for(var4 = -1; var4 <= 1; ++var4) {
            for(var5 = -1; var5 <= 1; ++var5) {
               if(var4 == 0 && var5 == 0) {
                  var1.a((class_cj)var3.a(var4, 4, var5), (IBlockData)this.c, 2);
               } else {
                  var1.a((class_cj)var3.a(var4, 4, var5), (IBlockData)this.b, 2);
               }
            }
         }

         for(var4 = 1; var4 <= 3; ++var4) {
            var1.a((class_cj)var3.a(-1, var4, -1), (IBlockData)this.c, 2);
            var1.a((class_cj)var3.a(-1, var4, 1), (IBlockData)this.c, 2);
            var1.a((class_cj)var3.a(1, var4, -1), (IBlockData)this.c, 2);
            var1.a((class_cj)var3.a(1, var4, 1), (IBlockData)this.c, 2);
         }

         return true;
      }
   }

   static {
      a = class_ant.a((Block)class_agk.m).a(class_akq.a, Predicates.equalTo(class_akq.class_a_in_class_akq.a));
   }
}
