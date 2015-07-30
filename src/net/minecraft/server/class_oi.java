package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ot;
import net.minecraft.server.class_ou;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yf;

public class class_oi implements class_ou {
   private String a;
   private class_ou b;
   private class_ou c;

   public class_oi(String var1, class_ou var2, class_ou var3) {
      this.a = var1;
      if(var2 == null) {
         var2 = var3;
      }

      if(var3 == null) {
         var3 = var2;
      }

      this.b = var2;
      this.c = var3;
      if(var2.r_()) {
         var3.a(var2.i());
      } else if(var3.r_()) {
         var2.a(var3.i());
      }

   }

   public int o_() {
      return this.b.o_() + this.c.o_();
   }

   public boolean a(class_oj var1) {
      return this.b == var1 || this.c == var1;
   }

   public String e_() {
      return this.b.l_()?this.b.e_():(this.c.l_()?this.c.e_():this.a);
   }

   public boolean l_() {
      return this.b.l_() || this.c.l_();
   }

   public IChatBaseComponent f_() {
      return (IChatBaseComponent)(this.l_()?new class_fa(this.e_()):new class_fb(this.e_(), new Object[0]));
   }

   public class_aas a(int var1) {
      return var1 >= this.b.o_()?this.c.a(var1 - this.b.o_()):this.b.a(var1);
   }

   public class_aas a(int var1, int var2) {
      return var1 >= this.b.o_()?this.c.a(var1 - this.b.o_(), var2):this.b.a(var1, var2);
   }

   public class_aas b(int var1) {
      return var1 >= this.b.o_()?this.c.b(var1 - this.b.o_()):this.b.b(var1);
   }

   public void a(int var1, class_aas var2) {
      if(var1 >= this.b.o_()) {
         this.c.a(var1 - this.b.o_(), var2);
      } else {
         this.b.a(var1, var2);
      }

   }

   public int q_() {
      return this.b.q_();
   }

   public void p_() {
      this.b.p_();
      this.c.p_();
   }

   public boolean a(class_xa var1) {
      return this.b.a(var1) && this.c.a(var1);
   }

   public void b(class_xa var1) {
      this.b.b(var1);
      this.c.b(var1);
   }

   public void c(class_xa var1) {
      this.b.c(var1);
      this.c.c(var1);
   }

   public boolean b(int var1, class_aas var2) {
      return true;
   }

   public int a_(int var1) {
      return 0;
   }

   public void b(int var1, int var2) {
   }

   public int g() {
      return 0;
   }

   public boolean r_() {
      return this.b.r_() || this.c.r_();
   }

   public void a(class_ot var1) {
      this.b.a(var1);
      this.c.a(var1);
   }

   public class_ot i() {
      return this.b.i();
   }

   public String k() {
      return this.b.k();
   }

   public class_xz a(class_wz var1, class_xa var2) {
      return new class_yf(var1, this, var2);
   }

   public void l() {
      this.b.l();
      this.c.l();
   }
}
