package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amx;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_xa;

public class class_aku extends class_agd {
   protected class_aku() {
      super(class_atk.d);
      float var1 = 0.25F;
      float var2 = 1.0F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
   }

   public class_awf a(class_aen var1, class_cj var2, IBlockData var3) {
      return null;
   }

   public boolean d() {
      return false;
   }

   public boolean b(class_aer var1, class_cj var2) {
      return true;
   }

   public boolean c() {
      return false;
   }

   public boolean g() {
      return true;
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_amx();
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aau.ar;
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         return var11 instanceof class_amx?((class_amx)var11).b(var4):false;
      }
   }

   public boolean d(class_aen var1, class_cj var2) {
      return !this.e(var1, var2) && super.d(var1, var2);
   }
}
