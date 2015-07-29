package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_zu;

public class class_akz extends class_agj {
   public class_akz() {
      super(class_atk.p, class_atl.B);
      this.a(class_zu.b);
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      float var4 = 0.125F;
      return new class_awf((double)var2.n(), (double)var2.o(), (double)var2.p(), (double)(var2.n() + 1), (double)((float)(var2.o() + 1) - var4), (double)(var2.p() + 1));
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_pr var4) {
      var4.v *= 0.4D;
      var4.x *= 0.4D;
   }
}
