package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_aia extends class_aiv {
   public static final class_anw a = class_anw.a("open");
   public static final class_anw b = class_anw.a("powered");
   public static final class_anw N = class_anw.a("in_wall");

   public class_aia(class_ajw.class_a_in_class_ajw var1) {
      super(class_atk.d, var1.c());
      this.j(this.M.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)));
      this.a(class_zu.d);
   }

   public class_anl a(class_anl var1, class_aer var2, class_cj var3) {
      class_cq.class_a_in_class_cq var4 = ((class_cq)var1.b(O)).k();
      if(var4 == class_cq.class_a_in_class_cq.c && (var2.p(var3.e()).c() == class_agk.bZ || var2.p(var3.f()).c() == class_agk.bZ) || var4 == class_cq.class_a_in_class_cq.a && (var2.p(var3.c()).c() == class_agk.bZ || var2.p(var3.d()).c() == class_agk.bZ)) {
         var1 = var1.a(N, Boolean.valueOf(true));
      }

      return var1;
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      return var1.c() != this?var1:var1.a(O, var2.a((class_cq)var1.b(O)));
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      return var1.c() != this?var1:this.a(var1, var2.a((class_cq)var1.b(O)));
   }

   public boolean d(class_aen var1, class_cj var2) {
      return var1.p(var2.b()).c().v().a()?super.d(var1, var2):false;
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      if(((Boolean)var3.b(a)).booleanValue()) {
         return null;
      } else {
         class_cq.class_a_in_class_cq var4 = ((class_cq)var3.b(O)).k();
         return var4 == class_cq.class_a_in_class_cq.c?new class_awf((double)var2.n(), (double)var2.o(), (double)((float)var2.p() + 0.375F), (double)(var2.n() + 1), (double)((float)var2.o() + 1.5F), (double)((float)var2.p() + 0.625F)):new class_awf((double)((float)var2.n() + 0.375F), (double)var2.o(), (double)var2.p(), (double)((float)var2.n() + 0.625F), (double)((float)var2.o() + 1.5F), (double)(var2.p() + 1));
      }
   }

   public void a(class_aer var1, class_cj var2) {
      class_cq.class_a_in_class_cq var3 = ((class_cq)var1.p(var2).b(O)).k();
      if(var3 == class_cq.class_a_in_class_cq.c) {
         this.a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
      } else {
         this.a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
      }

   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean b(class_aer var1, class_cj var2) {
      return ((Boolean)var1.p(var2).b(a)).booleanValue();
   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.S().a(O, var8.aR()).a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false));
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(((Boolean)var3.b(a)).booleanValue()) {
         var3 = var3.a(a, Boolean.valueOf(false));
         var1.a((class_cj)var2, (class_anl)var3, 2);
      } else {
         class_cq var11 = class_cq.a((double)var4.y);
         if(var3.b(O) == var11.d()) {
            var3 = var3.a(O, var11);
         }

         var3 = var3.a(a, Boolean.valueOf(true));
         var1.a((class_cj)var2, (class_anl)var3, 2);
      }

      var1.a(var4, ((Boolean)var3.b(a)).booleanValue()?1003:1006, var2, 0);
      return true;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      if(!var1.D) {
         boolean var5 = var1.z(var2);
         if(var5 || var4.i()) {
            if(var5 && !((Boolean)var3.b(a)).booleanValue() && !((Boolean)var3.b(b)).booleanValue()) {
               var1.a((class_cj)var2, (class_anl)var3.a(a, Boolean.valueOf(true)).a(b, Boolean.valueOf(true)), 2);
               var1.a((class_xa)null, 1003, var2, 0);
            } else if(!var5 && ((Boolean)var3.b(a)).booleanValue() && ((Boolean)var3.b(b)).booleanValue()) {
               var1.a((class_cj)var2, (class_anl)var3.a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)), 2);
               var1.a((class_xa)null, 1006, var2, 0);
            } else if(var5 != ((Boolean)var3.b(b)).booleanValue()) {
               var1.a((class_cj)var2, (class_anl)var3.a(b, Boolean.valueOf(var5)), 2);
            }
         }

      }
   }

   public class_anl a(int var1) {
      return this.S().a(O, class_cq.b(var1)).a(a, Boolean.valueOf((var1 & 4) != 0)).a(b, Boolean.valueOf((var1 & 8) != 0));
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_cq)var1.b(O)).b();
      if(((Boolean)var1.b(b)).booleanValue()) {
         var3 |= 8;
      }

      if(((Boolean)var1.b(a)).booleanValue()) {
         var3 |= 4;
      }

      return var3;
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{O, a, b, N});
   }
}
