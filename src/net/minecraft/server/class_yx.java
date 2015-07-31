package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_xa;

public class class_yx {
   private final int a;
   public final class_oj d;
   public int e;
   public int f;
   public int g;

   public class_yx(class_oj var1, int var2, int var3, int var4) {
      this.d = var1;
      this.a = var2;
      this.f = var3;
      this.g = var4;
   }

   public void a(ItemStack var1, ItemStack var2) {
      if(var1 != null && var2 != null) {
         if(var1.getItem() == var2.getItem()) {
            int var3 = var2.count - var1.count;
            if(var3 > 0) {
               this.a(var1, var3);
            }

         }
      }
   }

   protected void a(ItemStack var1, int var2) {
   }

   protected void c(ItemStack var1) {
   }

   public void a(class_xa var1, ItemStack var2) {
      this.f();
   }

   public boolean a(ItemStack var1) {
      return true;
   }

   public ItemStack d() {
      return this.d.a(this.a);
   }

   public boolean e() {
      return this.d() != null;
   }

   public void d(ItemStack var1) {
      this.d.a(this.a, var1);
      this.f();
   }

   public void f() {
      this.d.p_();
   }

   public int a() {
      return this.d.q_();
   }

   public int b(ItemStack var1) {
      return this.a();
   }

   public ItemStack a(int var1) {
      return this.d.a(this.a, var1);
   }

   public boolean a(class_oj var1, int var2) {
      return var1 == this.d && var2 == this.a;
   }

   public boolean a(class_xa var1) {
      return true;
   }
}
