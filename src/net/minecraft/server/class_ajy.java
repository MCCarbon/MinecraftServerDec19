package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_ahd;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_cj;

public class class_ajy extends class_ahd {
   protected class_aar o() {
      return class_aau.bV;
   }

   protected class_aar p() {
      return class_aau.bV;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if(!var1.D) {
         if(this.e(var3) && var1.s.nextInt(50) == 0) {
            a(var1, var2, new class_aas(class_aau.bX));
         }

      }
   }
}
