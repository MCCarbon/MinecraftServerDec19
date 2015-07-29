package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aed;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;

public class class_aha extends class_agd {
   public static final class_anw a = class_anw.a("triggered");

   public class_aha() {
      super(class_atk.f, class_atl.q);
      this.j(this.M.b().a(a, Boolean.valueOf(false)));
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_amj();
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      if(!var1.D) {
         boolean var5 = var1.z(var2);
         boolean var6 = ((Boolean)var3.b(a)).booleanValue();
         if(var5 && !var6) {
            var1.a((class_cj)var2, (class_anl)var3.a(a, Boolean.valueOf(true)), 4);
            var1.a((class_cj)var2, (class_agj)this, this.a(var1));
         } else if(!var5 && var6) {
            var1.a((class_cj)var2, (class_anl)var3.a(a, Boolean.valueOf(false)), 4);
         }
      }

   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      class_amg var5 = var1.s(var2);
      if(var5 instanceof class_amj) {
         ((class_amj)var5).b().a(var1);
         var1.e(var2, this);
      }

   }

   public int a(class_aen var1) {
      return 1;
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      class_amg var11 = var1.s(var2);
      return var11 instanceof class_amj?((class_amj)var11).b().a(var4):false;
   }

   public boolean Q() {
      return true;
   }

   public int l(class_aen var1, class_cj var2) {
      class_amg var3 = var1.s(var2);
      return var3 instanceof class_amj?((class_amj)var3).b().j():0;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_qa var4, class_aas var5) {
      class_amg var6 = var1.s(var2);
      if(var6 instanceof class_amj) {
         class_aed var7 = ((class_amj)var6).b();
         if(var5.s()) {
            var7.b(var5.q());
         }

         if(!var1.D) {
            var7.a(var1.R().b("sendCommandFeedback"));
         }

      }
   }

   public int a(Random var1) {
      return 0;
   }

   public int b() {
      return 3;
   }

   public class_anl a(int var1) {
      return this.S().a(a, Boolean.valueOf((var1 & 1) > 0));
   }

   public int c(class_anl var1) {
      int var2 = 0;
      if(((Boolean)var1.b(a)).booleanValue()) {
         var2 |= 1;
      }

      return var2;
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.S().a(a, Boolean.valueOf(false));
   }
}
