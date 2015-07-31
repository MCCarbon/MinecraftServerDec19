package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_pd;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;

public class class_pe extends class_pd {
   private class_pr r;

   public class_pe(String var1, class_pr var2, class_pr var3) {
      super(var1, var2);
      this.r = var3;
   }

   public class_pr i() {
      return this.q;
   }

   public class_pr j() {
      return this.r;
   }

   public IChatBaseComponent b(class_qa var1) {
      IChatBaseComponent var2 = this.r == null?this.q.f_():this.r.f_();
      ItemStack var3 = this.r instanceof class_qa?((class_qa)this.r).bA():null;
      String var4 = "death.attack." + this.p;
      String var5 = var4 + ".item";
      return var3 != null && var3.hasDisplayName() && LocaleI18n.c(var5)?new class_fb(var5, new Object[]{var1.f_(), var2, var3.B()}):new class_fb(var4, new Object[]{var1.f_(), var2});
   }
}
