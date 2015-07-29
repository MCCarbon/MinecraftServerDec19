package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_zu;
import net.minecraft.server.class_zy;

public class class_amc extends class_agj {
   public static final class_any a = class_any.a("color", class_zy.class);

   protected class_amc() {
      super(class_atk.r);
      this.j(this.M.b().a(a, class_zy.a));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
      this.a(true);
      this.a(class_zu.c);
      this.b(0);
   }

   public class_atl g(class_anl var1) {
      return ((class_zy)var1.b(a)).e();
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public void j() {
      this.b(0);
   }

   public void a(class_aer var1, class_cj var2) {
      this.b(0);
   }

   protected void b(int var1) {
      byte var2 = 0;
      float var3 = (float)(1 * (1 + var2)) / 16.0F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
   }

   public boolean d(class_aen var1, class_cj var2) {
      return super.d(var1, var2) && this.e(var1, var2);
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      this.e(var1, var2, var3);
   }

   private boolean e(class_aen var1, class_cj var2, class_anl var3) {
      if(!this.e(var1, var2)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      } else {
         return true;
      }
   }

   private boolean e(class_aen var1, class_cj var2) {
      return !var1.d(var2.b());
   }

   public int a(class_anl var1) {
      return ((class_zy)var1.b(a)).a();
   }

   public class_anl a(int var1) {
      return this.S().a(a, class_zy.b(var1));
   }

   public int c(class_anl var1) {
      return ((class_zy)var1.b(a)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }
}
