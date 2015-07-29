package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_aiq;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.CreativeTab;

public class class_akw extends class_aiq {
   public class_akw() {
      super(class_atk.B, false, class_atl.c);
      this.a(CreativeTab.c);
      this.L = 0.8F;
   }

   public void a(class_aen var1, class_cj var2, class_pr var3, float var4) {
      if(var3.ax()) {
         super.a(var1, var2, var3, var4);
      } else {
         var3.e(var4, 0.0F);
      }

   }

   public void a(class_aen var1, class_pr var2) {
      if(var2.ax()) {
         super.a(var1, var2);
      } else if(var2.w < 0.0D) {
         var2.w = -var2.w;
      }

   }

   public void a(class_aen var1, class_cj var2, class_pr var3) {
      if(Math.abs(var3.w) < 0.1D && !var3.ax()) {
         double var4 = 0.4D + Math.abs(var3.w) * 0.2D;
         var3.v *= var4;
         var3.x *= var4;
      }

      super.a(var1, var2, var3);
   }
}
