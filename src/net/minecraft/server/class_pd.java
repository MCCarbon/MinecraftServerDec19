package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;

public class class_pd extends class_pc {
   protected class_pr q;
   private boolean r = false;

   public class_pd(String var1, class_pr var2) {
      super(var1);
      this.q = var2;
   }

   public class_pd v() {
      this.r = true;
      return this;
   }

   public boolean w() {
      return this.r;
   }

   public class_pr j() {
      return this.q;
   }

   public class_eu b(class_qa var1) {
      class_aas var2 = this.q instanceof class_qa?((class_qa)this.q).bA():null;
      String var3 = "death.attack." + this.p;
      String var4 = var3 + ".item";
      return var2 != null && var2.s() && LocaleI18n.c(var4)?new class_fb(var4, new Object[]{var1.f_(), this.q.f_(), var2.B()}):new class_fb(var3, new Object[]{var1.f_(), this.q.f_()});
   }

   public boolean r() {
      return this.q != null && this.q instanceof class_qa && !(this.q instanceof class_xa);
   }
}
