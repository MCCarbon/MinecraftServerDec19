package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anb;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;

public class class_ahs extends class_agd {
   protected class_ahs(class_atk var1) {
      super(var1);
      this.a(1.0F);
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_anb();
   }

   public void a(class_aer var1, class_cj var2) {
      float var3 = 0.0625F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_awf var4, List var5, class_pr var6) {
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public int a(Random var1) {
      return 0;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_pr var4) {
      if(var4.m == null && var4.l == null && !var1.D) {
         var4.c(1);
      }

   }

   public class_atl g(class_anl var1) {
      return class_atl.E;
   }
}
