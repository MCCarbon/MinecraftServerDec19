package net.minecraft.server;

import net.minecraft.server.class_aut;
import net.minecraft.server.class_auv;
import net.minecraft.server.class_awp;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qg;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;
import org.apache.commons.lang3.StringUtils;

public abstract class class_td extends class_rm {
   protected final class_qh e;
   protected boolean f;
   private boolean a;
   private int b;
   private int c;
   private int d;

   public class_td(class_qh var1, boolean var2) {
      this(var1, var2, false);
   }

   public class_td(class_qh var1, boolean var2, boolean var3) {
      this.e = var1;
      this.f = var2;
      this.a = var3;
   }

   public boolean b() {
      class_qa var1 = this.e.w();
      if(var1 == null) {
         return false;
      } else if(!var1.ai()) {
         return false;
      } else {
         class_awp var2 = this.e.bP();
         class_awp var3 = var1.bP();
         if(var2 != null && var3 == var2) {
            return false;
         } else {
            double var4 = this.f();
            if(this.e.h(var1) > var4 * var4) {
               return false;
            } else {
               if(this.f) {
                  if(this.e.v().a(var1)) {
                     this.d = 0;
                  } else if(++this.d > 60) {
                     return false;
                  }
               }

               return !(var1 instanceof class_xa) || !((class_xa)var1).bH.a;
            }
         }
      }
   }

   protected double f() {
      class_ql var1 = this.e.a(class_wl.b);
      return var1 == null?16.0D:var1.e();
   }

   public void c() {
      this.b = 0;
      this.c = 0;
      this.d = 0;
   }

   public void d() {
      this.e.d((class_qa)null);
   }

   public static boolean a(class_qb var0, class_qa var1, boolean var2, boolean var3) {
      if(var1 == null) {
         return false;
      } else if(var1 == var0) {
         return false;
      } else if(!var1.ai()) {
         return false;
      } else if(!var0.a(var1.getClass())) {
         return false;
      } else if(var0.c(var1)) {
         return false;
      } else {
         if(var0 instanceof class_qg && StringUtils.isNotEmpty(((class_qg)var0).b())) {
            if(var1 instanceof class_qg && ((class_qg)var0).b().equals(((class_qg)var1).b())) {
               return false;
            }

            if(var1 == ((class_qg)var0).m_()) {
               return false;
            }
         } else if(var1 instanceof class_xa && !var2 && ((class_xa)var1).bH.a) {
            return false;
         }

         return !var3 || var0.v().a(var1);
      }
   }

   protected boolean a(class_qa var1, boolean var2) {
      if(!a(this.e, var1, var2, this.f)) {
         return false;
      } else if(!this.e.e(new class_cj(var1))) {
         return false;
      } else {
         if(this.a) {
            if(--this.c <= 0) {
               this.b = 0;
            }

            if(this.b == 0) {
               this.b = this.a(var1)?1:2;
            }

            if(this.b == 2) {
               return false;
            }
         }

         return true;
      }
   }

   private boolean a(class_qa var1) {
      this.c = 10 + this.e.bd().nextInt(5);
      class_auv var2 = this.e.u().a((class_pr)var1);
      if(var2 == null) {
         return false;
      } else {
         class_aut var3 = var2.c();
         if(var3 == null) {
            return false;
         } else {
            int var4 = var3.a - class_nu.c(var1.s);
            int var5 = var3.c - class_nu.c(var1.u);
            return (double)(var4 * var4 + var5 * var5) <= 2.25D;
         }
      }
   }
}
