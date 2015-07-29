package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_aiy extends class_agd {
   public static final class_anw a = class_anw.a("has_record");

   protected class_aiy() {
      super(class_atk.d, class_atl.l);
      this.j(this.M.b().a(a, Boolean.valueOf(false)));
      this.a(class_zu.c);
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(((Boolean)var3.b(a)).booleanValue()) {
         this.e(var1, var2, var3);
         var3 = var3.a(a, Boolean.valueOf(false));
         var1.a((class_cj)var2, (class_anl)var3, 2);
         return true;
      } else {
         return false;
      }
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_aas var4) {
      if(!var1.D) {
         class_amg var5 = var1.s(var2);
         if(var5 instanceof class_aiy.class_a_in_class_aiy) {
            ((class_aiy.class_a_in_class_aiy)var5).a(new class_aas(var4.b(), 1, var4.i()));
            var1.a((class_cj)var2, (class_anl)var3.a(a, Boolean.valueOf(true)), 2);
         }
      }
   }

   private void e(class_aen var1, class_cj var2, class_anl var3) {
      if(!var1.D) {
         class_amg var4 = var1.s(var2);
         if(var4 instanceof class_aiy.class_a_in_class_aiy) {
            class_aiy.class_a_in_class_aiy var5 = (class_aiy.class_a_in_class_aiy)var4;
            class_aas var6 = var5.a();
            if(var6 != null) {
               var1.b(1005, var2, 0);
               var1.a((class_cj)var2, (String)null);
               var5.a((class_aas)null);
               float var7 = 0.7F;
               double var8 = (double)(var1.s.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
               double var10 = (double)(var1.s.nextFloat() * var7) + (double)(1.0F - var7) * 0.2D + 0.6D;
               double var12 = (double)(var1.s.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
               class_aas var14 = var6.k();
               class_vm var15 = new class_vm(var1, (double)var2.n() + var8, (double)var2.o() + var10, (double)var2.p() + var12, var14);
               var15.p();
               var1.a((class_pr)var15);
            }
         }
      }
   }

   public void b(class_aen var1, class_cj var2, class_anl var3) {
      this.e(var1, var2, var3);
      super.b(var1, var2, var3);
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, float var4, int var5) {
      if(!var1.D) {
         super.a(var1, var2, var3, var4, 0);
      }
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_aiy.class_a_in_class_aiy();
   }

   public boolean Q() {
      return true;
   }

   public int l(class_aen var1, class_cj var2) {
      class_amg var3 = var1.s(var2);
      if(var3 instanceof class_aiy.class_a_in_class_aiy) {
         class_aas var4 = ((class_aiy.class_a_in_class_aiy)var3).a();
         if(var4 != null) {
            return class_aar.b(var4.b()) + 1 - class_aar.b(class_aau.ct);
         }
      }

      return 0;
   }

   public int b() {
      return 3;
   }

   public class_anl a(int var1) {
      return this.S().a(a, Boolean.valueOf(var1 > 0));
   }

   public int c(class_anl var1) {
      return ((Boolean)var1.b(a)).booleanValue()?1:0;
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }

   public static class class_a_in_class_aiy extends class_amg {
      private class_aas a;

      public void a(class_dn var1) {
         super.a(var1);
         if(var1.b("RecordItem", 10)) {
            this.a(class_aas.a(var1.n("RecordItem")));
         } else if(var1.g("Record") > 0) {
            this.a(new class_aas(class_aar.c(var1.g("Record"))));
         }

      }

      public void b(class_dn var1) {
         super.b(var1);
         if(this.a() != null) {
            var1.a((String)"RecordItem", (class_eb)this.a().b(new class_dn()));
         }

      }

      public class_aas a() {
         return this.a;
      }

      public void a(class_aas var1) {
         this.a = var1;
         this.p_();
      }
   }
}
