package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agg;
import net.minecraft.server.class_aiq;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_zu;
import net.minecraft.server.class_zy;

public class class_alb extends class_aiq {
   public static final class_any a = class_any.a("color", class_zy.class);

   public class_alb(class_atk var1) {
      super(var1, false);
      this.j(this.M.b().a(a, class_zy.a));
      this.a((class_zu)class_zu.b);
   }

   public int a(class_anl var1) {
      return ((class_zy)var1.b(a)).a();
   }

   public class_atl g(class_anl var1) {
      return ((class_zy)var1.b(a)).e();
   }

   public int a(Random var1) {
      return 0;
   }

   protected boolean K() {
      return true;
   }

   public boolean d() {
      return false;
   }

   public class_anl a(int var1) {
      return this.S().a(a, class_zy.b(var1));
   }

   public void c(class_aen var1, class_cj var2, class_anl var3) {
      if(!var1.D) {
         class_agg.f(var1, var2);
      }

   }

   public void b(class_aen var1, class_cj var2, class_anl var3) {
      if(!var1.D) {
         class_agg.f(var1, var2);
      }

   }

   public int c(class_anl var1) {
      return ((class_zy)var1.b(a)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }
}
