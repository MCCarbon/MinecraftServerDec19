package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_aio;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zg;

public class class_abq extends class_zg {
   private final class_aio b;
   private final class_aio c;

   public class_abq(class_agj var1, class_aio var2, class_aio var3) {
      super(var1);
      this.b = var2;
      this.c = var3;
      this.e(0);
      this.a(true);
   }

   public int a(int var1) {
      return var1;
   }

   public String e_(class_aas var1) {
      return this.b.b(var1.i());
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(var1.b == 0) {
         return class_oq.b;
      } else if(!var2.a(var4.a(var6), var6, var1)) {
         return class_oq.b;
      } else {
         Object var10 = this.b.a(var1);
         class_anl var11 = var3.p(var4);
         if(var11.c() == this.b) {
            class_aoa var12 = this.b.n();
            Comparable var13 = var11.b(var12);
            class_aio.class_a_in_class_aio var14 = (class_aio.class_a_in_class_aio)var11.b(class_aio.a);
            if((var6 == class_cq.b && var14 == class_aio.class_a_in_class_aio.b || var6 == class_cq.a && var14 == class_aio.class_a_in_class_aio.a) && var13 == var10) {
               class_anl var15 = this.c.S().a(var12, var13);
               if(var3.b(this.c.a(var3, var4, var15)) && var3.a((class_cj)var4, (class_anl)var15, 3)) {
                  var3.a((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), this.c.H.b(), (this.c.H.d() + 1.0F) / 2.0F, this.c.H.e() * 0.8F);
                  --var1.b;
               }

               return class_oq.a;
            }
         }

         return this.a(var1, var3, var4.a(var6), var10)?class_oq.a:super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }
   }

   private boolean a(class_aas var1, class_aen var2, class_cj var3, Object var4) {
      class_anl var5 = var2.p(var3);
      if(var5.c() == this.b) {
         Comparable var6 = var5.b(this.b.n());
         if(var6 == var4) {
            class_anl var7 = this.c.S().a(this.b.n(), var6);
            if(var2.b(this.c.a(var2, var3, var7)) && var2.a((class_cj)var3, (class_anl)var7, 3)) {
               var2.a((double)((float)var3.n() + 0.5F), (double)((float)var3.o() + 0.5F), (double)((float)var3.p() + 0.5F), this.c.H.b(), (this.c.H.d() + 1.0F) / 2.0F, this.c.H.e() * 0.8F);
               --var1.b;
            }

            return true;
         }
      }

      return false;
   }
}
