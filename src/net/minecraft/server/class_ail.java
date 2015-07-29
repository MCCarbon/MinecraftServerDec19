package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;

public class class_ail extends class_agj {
   protected class_ail() {
      super(class_atk.c);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
      this.e(255);
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      return new class_awf((double)var2.n(), (double)var2.o(), (double)var2.p(), (double)(var2.n() + 1), (double)(var2.o() + 1), (double)(var2.p() + 1));
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return class_agk.d.a(class_agk.d.S().a(class_ahj.a, class_ahj.class_a_in_class_ahj.a), var2, var3);
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      super.a(var1, var2, var3, var4);
      if(var1.p(var2.a()).c().v().a()) {
         var1.a(var2, class_agk.d.S());
      }

   }
}
