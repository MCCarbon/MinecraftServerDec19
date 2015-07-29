package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_aky;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zg;

public class class_abr extends class_zg {
   public class_abr(Block var1) {
      super(var1);
      this.e(0);
      this.a(true);
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(var1.b == 0) {
         return class_oq.b;
      } else if(!var2.a(var4, var6, var1)) {
         return class_oq.b;
      } else {
         IBlockData var10 = var3.p(var4);
         Block var11 = var10.getBlock();
         class_cj var12 = var4;
         if((var6 != class_cq.b || var11 != this.a) && !var11.a(var3, var4)) {
            var12 = var4.a(var6);
            var10 = var3.p(var12);
            var11 = var10.getBlock();
         }

         if(var11 == this.a) {
            int var13 = ((Integer)var10.get(class_aky.a)).intValue();
            if(var13 <= 7) {
               IBlockData var14 = var10.set(class_aky.a, Integer.valueOf(var13 + 1));
               class_awf var15 = this.a.a(var3, var12, var14);
               if(var15 != null && var3.b(var15) && var3.a((class_cj)var12, (IBlockData)var14, 2)) {
                  var3.a((double)((float)var12.n() + 0.5F), (double)((float)var12.o() + 0.5F), (double)((float)var12.p() + 0.5F), this.a.H.b(), (this.a.H.d() + 1.0F) / 2.0F, this.a.H.e() * 0.8F);
                  --var1.b;
                  return class_oq.a;
               }
            }
         }

         return super.a(var1, var2, var3, var12, var5, var6, var7, var8, var9);
      }
   }

   public int a(int var1) {
      return var1;
   }
}
