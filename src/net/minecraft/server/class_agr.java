package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_xa;

public class class_agr extends class_agj {
   public static final class_anz a = class_anz.a("bites", 0, 6);

   protected class_agr() {
      super(class_atk.F);
      this.j(this.M.b().a(a, Integer.valueOf(0)));
      this.a(true);
   }

   public void a(class_aer var1, class_cj var2) {
      float var3 = 0.0625F;
      float var4 = (float)(1 + ((Integer)var1.p(var2).b(a)).intValue() * 2) / 16.0F;
      float var5 = 0.5F;
      this.a(var4, 0.0F, var3, 1.0F - var3, var5, 1.0F - var3);
   }

   public void j() {
      float var1 = 0.0625F;
      float var2 = 0.5F;
      this.a(var1, 0.0F, var1, 1.0F - var1, var2, 1.0F - var1);
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      float var4 = 0.0625F;
      float var5 = (float)(1 + ((Integer)var3.b(a)).intValue() * 2) / 16.0F;
      float var6 = 0.5F;
      return new class_awf((double)((float)var2.n() + var5), (double)var2.o(), (double)((float)var2.p() + var4), (double)((float)(var2.n() + 1) - var4), (double)((float)var2.o() + var6), (double)((float)(var2.p() + 1) - var4));
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      this.b(var1, var2, var3, var4);
      return true;
   }

   public void a(class_aen var1, class_cj var2, class_xa var3) {
      this.b(var1, var2, var1.p(var2), var3);
   }

   private void b(class_aen var1, class_cj var2, class_anl var3, class_xa var4) {
      if(var4.j(false)) {
         var4.b(class_nc.H);
         var4.cn().a(2, 0.1F);
         int var5 = ((Integer)var3.b(a)).intValue();
         if(var5 < 6) {
            var1.a((class_cj)var2, (class_anl)var3.a(a, Integer.valueOf(var5 + 1)), 3);
         } else {
            var1.g(var2);
         }

      }
   }

   public boolean d(class_aen var1, class_cj var2) {
      return super.d(var1, var2)?this.e(var1, var2):false;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      if(!this.e(var1, var2)) {
         var1.g(var2);
      }

   }

   private boolean e(class_aen var1, class_cj var2) {
      return var1.p(var2.b()).c().v().a();
   }

   public int a(Random var1) {
      return 0;
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return null;
   }

   public class_anl a(int var1) {
      return this.S().a(a, Integer.valueOf(var1));
   }

   public int c(class_anl var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }

   public int l(class_aen var1, class_cj var2) {
      return (7 - ((Integer)var1.p(var2).b(a)).intValue()) * 2;
   }

   public boolean Q() {
      return true;
   }
}
