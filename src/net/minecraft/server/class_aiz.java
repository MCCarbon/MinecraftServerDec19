package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anx;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_zu;

public class class_aiz extends class_agj {
   public static final class_anx a;

   protected class_aiz() {
      super(class_atk.q);
      this.j(this.M.b().a(a, class_cq.c));
      this.a(class_zu.c);
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      this.a((class_aer)var1, (class_cj)var2);
      return super.a(var1, var2, var3);
   }

   public void a(class_aer var1, class_cj var2) {
      class_anl var3 = var1.p(var2);
      if(var3.c() == this) {
         float var4 = 0.1875F;
         switch(class_aiz.SyntheticClass_1.a[((class_cq)var3.b(a)).ordinal()]) {
         case 1:
            this.a(0.0F, 0.0F, 1.0F - var4, 1.0F, 1.0F, 1.0F);
            break;
         case 2:
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var4);
            break;
         case 3:
            this.a(1.0F - var4, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 4:
         default:
            this.a(0.0F, 0.0F, 0.0F, var4, 1.0F, 1.0F);
         }

      }
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean d(class_aen var1, class_cj var2) {
      return var1.p(var2.e()).c().x()?true:(var1.p(var2.f()).c().x()?true:(var1.p(var2.c()).c().x()?true:var1.p(var2.d()).c().x()));
   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      if(var3.k().c() && this.a(var1, var2, var3)) {
         return this.S().a(a, var3);
      } else {
         Iterator var9 = class_cq.class_c_in_class_cq.a.iterator();

         class_cq var10;
         do {
            if(!var9.hasNext()) {
               return this.S();
            }

            var10 = (class_cq)var9.next();
         } while(!this.a(var1, var2, var10));

         return this.S().a(a, var10);
      }
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      class_cq var5 = (class_cq)var3.b(a);
      if(!this.a(var1, var2, var5)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

      super.a(var1, var2, var3, var4);
   }

   protected boolean a(class_aen var1, class_cj var2, class_cq var3) {
      return var1.p(var2.a(var3.d())).c().x();
   }

   public class_anl a(int var1) {
      class_cq var2 = class_cq.a(var1);
      if(var2.k() == class_cq.class_a_in_class_cq.b) {
         var2 = class_cq.c;
      }

      return this.S().a(a, var2);
   }

   public int c(class_anl var1) {
      return ((class_cq)var1.b(a)).a();
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      return var1.c() != this?var1:var1.a(a, var2.a((class_cq)var1.b(a)));
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      return var1.c() != this?var1:this.a(var1, var2.a((class_cq)var1.b(a)));
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }

   static {
      a = class_aiv.O;
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_cq.values().length];

      static {
         try {
            a[class_cq.c.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_cq.d.ordinal()] = 2;
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
