package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dc;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_uy;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_zb extends Item {
   public class_zb() {
      this.a(CreativeTab.c);
   }

   public class_oq a(class_aas var1, class_xa var2, World var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(var6 == class_cq.a) {
         return class_oq.b;
      } else {
         boolean var10 = var3.p(var4).getBlock().isReplaceable(var3, var4);
         class_cj var11 = var10?var4:var4.a(var6);
         if(!var2.a(var11, var6, var1)) {
            return class_oq.b;
         } else {
            class_cj var12 = var11.a();
            boolean var13 = !var3.d(var11) && !var3.p(var11).getBlock().isReplaceable(var3, var11);
            var13 |= !var3.d(var12) && !var3.p(var12).getBlock().isReplaceable(var3, var12);
            if(var13) {
               return class_oq.b;
            } else {
               double var14 = (double)var11.n();
               double var16 = (double)var11.o();
               double var18 = (double)var11.p();
               List var20 = var3.b((class_pr)null, (class_awf)class_awf.a(var14, var16, var18, var14 + 1.0D, var16 + 2.0D, var18 + 1.0D));
               if(!var20.isEmpty()) {
                  return class_oq.b;
               } else {
                  if(!var3.D) {
                     var3.g(var11);
                     var3.g(var12);
                     class_uy var21 = new class_uy(var3, var14 + 0.5D, var16, var18 + 0.5D);
                     float var22 = (float)class_nu.d((class_nu.g(var2.y - 180.0F) + 22.5F) / 45.0F) * 45.0F;
                     var21.b(var14 + 0.5D, var16, var18 + 0.5D, var22, 0.0F);
                     this.a(var21, var3.s);
                     class_dn var23 = var1.o();
                     if(var23 != null && var23.b("EntityTag", 10)) {
                        class_dn var24 = new class_dn();
                        var21.d(var24);
                        var24.a(var23.n("EntityTag"));
                        var21.f(var24);
                     }

                     var3.a((class_pr)var21);
                  }

                  --var1.b;
                  return class_oq.a;
               }
            }
         }
      }
   }

   private void a(class_uy var1, Random var2) {
      class_dc var3 = var1.u();
      float var5 = var2.nextFloat() * 5.0F;
      float var6 = var2.nextFloat() * 20.0F - 10.0F;
      class_dc var4 = new class_dc(var3.b() + var5, var3.c() + var6, var3.d());
      var1.a(var4);
      var3 = var1.v();
      var5 = var2.nextFloat() * 10.0F - 5.0F;
      var4 = new class_dc(var3.b(), var3.c() + var5, var3.d());
      var1.b(var4);
   }
}
