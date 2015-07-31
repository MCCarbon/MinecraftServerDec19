package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_xa;

public class class_yv implements class_oj {
   private ItemStack[] a = new ItemStack[1];

   public int o_() {
      return 1;
   }

   public ItemStack a(int var1) {
      return this.a[0];
   }

   public String e_() {
      return "Result";
   }

   public boolean l_() {
      return false;
   }

   public IChatBaseComponent f_() {
      return (IChatBaseComponent)(this.l_()?new class_fa(this.e_()):new class_fb(this.e_(), new Object[0]));
   }

   public ItemStack a(int var1, int var2) {
      if(this.a[0] != null) {
         ItemStack var3 = this.a[0];
         this.a[0] = null;
         return var3;
      } else {
         return null;
      }
   }

   public ItemStack b(int var1) {
      if(this.a[0] != null) {
         ItemStack var2 = this.a[0];
         this.a[0] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, ItemStack var2) {
      this.a[0] = var2;
   }

   public int q_() {
      return 64;
   }

   public void p_() {
   }

   public boolean a(class_xa var1) {
      return true;
   }

   public void b(class_xa var1) {
   }

   public void c(class_xa var1) {
   }

   public boolean b(int var1, ItemStack var2) {
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

   public void l() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

   }
}
