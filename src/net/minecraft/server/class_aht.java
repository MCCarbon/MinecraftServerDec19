package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anx;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;

public class class_aht extends class_agj {
   public static final class_anx a;
   public static final class_anw b;

   public class_aht() {
      super(class_atk.e, class_atl.C);
      this.j(this.M.b().a(a, class_cq.c).a(b, Boolean.valueOf(false)));
   }

   public boolean c() {
      return false;
   }

   public void j() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_awf var4, List var5, class_pr var6) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      if(((Boolean)var1.p(var2).b(b)).booleanValue()) {
         this.a(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
         super.a(var1, var2, var3, var4, var5, var6);
      }

      this.j();
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return null;
   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.S().a(a, var8.aR().d()).a(b, Boolean.valueOf(false));
   }

   public boolean Q() {
      return true;
   }

   public int l(class_aen var1, class_cj var2) {
      return ((Boolean)var1.p(var2).b(b)).booleanValue()?15:0;
   }

   public class_anl a(int var1) {
      return this.S().a(b, Boolean.valueOf((var1 & 4) != 0)).a(a, class_cq.b(var1 & 3));
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_cq)var1.b(a)).b();
      if(((Boolean)var1.b(b)).booleanValue()) {
         var3 |= 4;
      }

      return var3;
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      return var1.c() != this?var1:var1.a(a, var2.a((class_cq)var1.b(a)));
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      return var1.c() != this?var1:this.a(var1, var2.a((class_cq)var1.b(a)));
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a, b});
   }

   static {
      a = class_aiv.O;
      b = class_anw.a("eye");
   }
}
