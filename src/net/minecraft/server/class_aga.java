package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahx;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anx;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_op;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_vl;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yb;
import net.minecraft.server.class_zu;

public class class_aga extends class_ahx {
   public static final class_anx a;
   public static final class_anz b;

   protected class_aga() {
      super(class_atk.g);
      this.j(this.M.b().a(a, class_cq.c).a(b, Integer.valueOf(0)));
      this.e(0);
      this.a((class_zu)class_zu.c);
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      class_cq var9 = var8.aR().e();
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8).a(a, var9).a(b, Integer.valueOf(var7 >> 2));
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(!var1.D) {
         var4.a((class_op)(new class_aga.class_a_in_class_aga(var1, var2)));
      }

      return true;
   }

   public int a(class_anl var1) {
      return ((Integer)var1.b(b)).intValue();
   }

   public void a(class_aer var1, class_cj var2) {
      class_cq var3 = (class_cq)var1.p(var2).b(a);
      if(var3.k() == class_cq.class_a_in_class_cq.a) {
         this.a(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
      } else {
         this.a(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
      }

   }

   protected void a(class_vl var1) {
      var1.a(true);
   }

   public void a_(class_aen var1, class_cj var2) {
      var1.b(1022, var2, 0);
   }

   public class_anl a(int var1) {
      return this.S().a(a, class_cq.b(var1 & 3)).a(b, Integer.valueOf((var1 & 15) >> 2));
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_cq)var1.b(a)).b();
      var3 |= ((Integer)var1.b(b)).intValue() << 2;
      return var3;
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      return var1.c() != this?var1:var1.a(a, var2.a((class_cq)var1.b(a)));
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a, b});
   }

   static {
      a = class_aiv.O;
      b = class_anz.a("damage", 0, 2);
   }

   public static class class_a_in_class_aga implements class_op {
      private final class_aen a;
      private final class_cj b;

      public class_a_in_class_aga(class_aen var1, class_cj var2) {
         this.a = var1;
         this.b = var2;
      }

      public String e_() {
         return "anvil";
      }

      public boolean l_() {
         return false;
      }

      public class_eu f_() {
         return new class_fb(class_agk.cf.a() + ".name", new Object[0]);
      }

      public class_xz a(class_wz var1, class_xa var2) {
         return new class_yb(var1, this.a, this.b, var2);
      }

      public String k() {
         return "minecraft:anvil";
      }
   }
}
