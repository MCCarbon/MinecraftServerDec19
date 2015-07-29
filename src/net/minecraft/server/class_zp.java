package net.minecraft.server;

import net.minecraft.server.class_aan;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_wb;

public class class_zp extends class_aan {
   public class_zp(int var1, float var2) {
      super(var1, var2, false);
   }

   public class_aas a(class_aas var1, class_aen var2, class_qa var3) {
      class_aas var4 = super.a(var1, var2, var3);

      for(int var5 = 0; var5 < 16; ++var5) {
         double var6 = var3.s + (var3.bd().nextDouble() - 0.5D) * 64.0D;
         double var8 = var3.t + (double)(var3.bd().nextInt(64) - 32);
         double var10 = var3.u + (var3.bd().nextDouble() - 0.5D) * 64.0D;
         if(class_wb.a(var3, var6, var8, var10)) {
            break;
         }
      }

      return var4;
   }
}
