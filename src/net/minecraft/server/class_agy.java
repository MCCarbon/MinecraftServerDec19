package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_ajt;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_zy;

public class class_agy extends class_aiv implements class_agl {
   public static final class_anz a = class_anz.a("age", 0, 2);

   public class_agy() {
      super(class_atk.k);
      this.j(this.M.b().a(O, class_cq.c).a(a, Integer.valueOf(0)));
      this.a(true);
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(!this.e(var1, var2, var3)) {
         this.f(var1, var2, var3);
      } else if(var1.s.nextInt(5) == 0) {
         int var5 = ((Integer)var3.b(a)).intValue();
         if(var5 < 2) {
            var1.a((class_cj)var2, (class_anl)var3.a(a, Integer.valueOf(var5 + 1)), 2);
         }
      }

   }

   public boolean e(class_aen var1, class_cj var2, class_anl var3) {
      var2 = var2.a((class_cq)var3.b(O));
      class_anl var4 = var1.p(var2);
      return var4.c() == class_agk.r && var4.b(class_ajt.b) == class_ajw.class_a_in_class_ajw.d;
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      this.a((class_aer)var1, (class_cj)var2);
      return super.a(var1, var2, var3);
   }

   public void a(class_aer var1, class_cj var2) {
      class_anl var3 = var1.p(var2);
      class_cq var4 = (class_cq)var3.b(O);
      int var5 = ((Integer)var3.b(a)).intValue();
      int var6 = 4 + var5 * 2;
      int var7 = 5 + var5 * 2;
      float var8 = (float)var6 / 2.0F;
      switch(class_agy.SyntheticClass_1.a[var4.ordinal()]) {
      case 1:
         this.a((8.0F - var8) / 16.0F, (12.0F - (float)var7) / 16.0F, (15.0F - (float)var6) / 16.0F, (8.0F + var8) / 16.0F, 0.75F, 0.9375F);
         break;
      case 2:
         this.a((8.0F - var8) / 16.0F, (12.0F - (float)var7) / 16.0F, 0.0625F, (8.0F + var8) / 16.0F, 0.75F, (1.0F + (float)var6) / 16.0F);
         break;
      case 3:
         this.a(0.0625F, (12.0F - (float)var7) / 16.0F, (8.0F - var8) / 16.0F, (1.0F + (float)var6) / 16.0F, 0.75F, (8.0F + var8) / 16.0F);
         break;
      case 4:
         this.a((15.0F - (float)var6) / 16.0F, (12.0F - (float)var7) / 16.0F, (8.0F - var8) / 16.0F, 0.9375F, 0.75F, (8.0F + var8) / 16.0F);
      }

   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      return var1.c() != this?var1:var1.a(O, var2.a((class_cq)var1.b(O)));
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      return var1.c() != this?var1:this.a(var1, var2.a((class_cq)var1.b(O)));
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_qa var4, class_aas var5) {
      class_cq var6 = class_cq.a((double)var4.y);
      var1.a((class_cj)var2, (class_anl)var3.a(O, var6), 2);
   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      if(!var3.k().c()) {
         var3 = class_cq.c;
      }

      return this.S().a(O, var3.d()).a(a, Integer.valueOf(0));
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      if(!this.e(var1, var2, var3)) {
         this.f(var1, var2, var3);
      }

   }

   private void f(class_aen var1, class_cj var2, class_anl var3) {
      var1.a((class_cj)var2, (class_anl)class_agk.a.S(), 3);
      this.b(var1, var2, var3, 0);
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, float var4, int var5) {
      int var6 = ((Integer)var3.b(a)).intValue();
      byte var7 = 1;
      if(var6 >= 2) {
         var7 = 3;
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         a(var1, var2, new class_aas(class_aau.aY, 1, class_zy.m.b()));
      }

   }

   public int j(class_aen var1, class_cj var2) {
      return class_zy.m.b();
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, boolean var4) {
      return ((Integer)var3.b(a)).intValue() < 2;
   }

   public boolean a(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      return true;
   }

   public void b(class_aen var1, Random var2, class_cj var3, class_anl var4) {
      var1.a((class_cj)var3, (class_anl)var4.a(a, Integer.valueOf(((Integer)var4.b(a)).intValue() + 1)), 2);
   }

   public class_anl a(int var1) {
      return this.S().a(O, class_cq.b(var1)).a(a, Integer.valueOf((var1 & 15) >> 2));
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_cq)var1.b(O)).b();
      var3 |= ((Integer)var1.b(a)).intValue() << 2;
      return var3;
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{O, a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_cq.values().length];

      static {
         try {
            a[class_cq.d.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_cq.c.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_cq.e.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.f.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
