package net.minecraft.server;

import com.google.common.collect.Multimap;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_abz;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qm;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_abw extends class_aar {
   private float a;
   private final class_aar.class_a_in_class_aar b;

   public class_abw(class_aar.class_a_in_class_aar var1) {
      this.b = var1;
      this.h = 1;
      this.e(var1.a());
      this.a(class_zu.j);
      this.a = 4.0F + var1.c();
   }

   public float g() {
      return this.b.c();
   }

   public float a(class_aas var1, class_agj var2) {
      if(var2 == class_agk.G) {
         return 15.0F;
      } else {
         class_atk var3 = var2.v();
         return var3 != class_atk.k && var3 != class_atk.l && var3 != class_atk.v && var3 != class_atk.j && var3 != class_atk.C?1.0F:1.5F;
      }
   }

   public boolean a(class_aas var1, class_qa var2, class_qa var3) {
      var1.a(1, (class_qa)var3);
      return true;
   }

   public boolean a(class_aas var1, class_aen var2, class_agj var3, class_cj var4, class_qa var5) {
      if((double)var3.g(var2, var4) != 0.0D) {
         var1.a(2, (class_qa)var5);
      }

      return true;
   }

   public class_abz f(class_aas var1) {
      return class_abz.d;
   }

   public int e(class_aas var1) {
      return 72000;
   }

   public class_or a(class_aas var1, class_aen var2, class_xa var3, class_oo var4) {
      var3.c(var4);
      return new class_or(class_oq.a, var1);
   }

   public boolean b(class_agj var1) {
      return var1 == class_agk.G;
   }

   public int c() {
      return this.b.e();
   }

   public String h() {
      return this.b.toString();
   }

   public boolean a(class_aas var1, class_aas var2) {
      return this.b.f() == var2.b()?true:super.a(var1, var2);
   }

   public Multimap a(class_pw var1) {
      Multimap var2 = super.a(var1);
      if(var1 == class_pw.a) {
         var2.put(class_wl.e.a(), new class_qm(f, "Weapon modifier", (double)this.a, 0));
      }

      return var2;
   }
}
