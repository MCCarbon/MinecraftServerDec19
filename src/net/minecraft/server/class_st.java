package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_ow;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_rp;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_wv;

public class class_st extends class_rp {
   private int e;
   private class_wv f;

   public class_st(class_wv var1) {
      super(var1, class_wv.class, 3.0F, 0.02F);
      this.f = var1;
   }

   public void c() {
      super.c();
      if(this.f.cH() && this.b instanceof class_wv && ((class_wv)this.b).cI()) {
         this.e = 10;
      } else {
         this.e = 0;
      }

   }

   public void e() {
      super.e();
      if(this.e > 0) {
         --this.e;
         if(this.e == 0) {
            class_ow var1 = this.f.cF();

            for(int var2 = 0; var2 < var1.o_(); ++var2) {
               class_aas var3 = var1.a(var2);
               class_aas var4 = null;
               if(var3 != null) {
                  Item var5 = var3.b();
                  int var6;
                  if((var5 == Items.R || var5 == Items.bV || var5 == Items.bU) && var3.b > 3) {
                     var6 = var3.b / 2;
                     var3.b -= var6;
                     var4 = new class_aas(var5, var6, var3.i());
                  } else if(var5 == Items.Q && var3.b > 5) {
                     var6 = var3.b / 2 / 3 * 3;
                     int var7 = var6 / 3;
                     var3.b -= var6;
                     var4 = new class_aas(Items.R, var7, 0);
                  }

                  if(var3.b <= 0) {
                     var1.a(var2, (class_aas)null);
                  }
               }

               if(var4 != null) {
                  double var11 = this.f.t - 0.30000001192092896D + (double)this.f.aU();
                  class_vm var12 = new class_vm(this.f.o, this.f.s, var11, this.f.u, var4);
                  float var8 = 0.3F;
                  float var9 = this.f.aN;
                  float var10 = this.f.z;
                  var12.v = (double)(-class_nu.a(var9 / 180.0F * 3.1415927F) * class_nu.b(var10 / 180.0F * 3.1415927F) * var8);
                  var12.x = (double)(class_nu.b(var9 / 180.0F * 3.1415927F) * class_nu.b(var10 / 180.0F * 3.1415927F) * var8);
                  var12.w = (double)(-class_nu.a(var10 / 180.0F * 3.1415927F) * var8 + 0.1F);
                  var12.p();
                  this.f.o.a((class_pr)var12);
                  break;
               }
            }
         }
      }

   }
}
