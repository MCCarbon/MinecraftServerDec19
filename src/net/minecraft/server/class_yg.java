package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;

public class class_yg implements class_oj {
   private final class_aas[] a;
   private final int b;
   private final int c;
   private final class_xz d;

   public class_yg(class_xz var1, int var2, int var3) {
      int var4 = var2 * var3;
      this.a = new class_aas[var4];
      this.d = var1;
      this.b = var2;
      this.c = var3;
   }

   public int o_() {
      return this.a.length;
   }

   public class_aas a(int var1) {
      return var1 >= this.o_()?null:this.a[var1];
   }

   public class_aas c(int var1, int var2) {
      return var1 >= 0 && var1 < this.b && var2 >= 0 && var2 <= this.c?this.a(var1 + var2 * this.b):null;
   }

   public String e_() {
      return "container.crafting";
   }

   public boolean l_() {
      return false;
   }

   public IChatBaseComponent f_() {
      return (IChatBaseComponent)(this.l_()?new class_fa(this.e_()):new class_fb(this.e_(), new Object[0]));
   }

   public class_aas b(int var1) {
      if(this.a[var1] != null) {
         class_aas var2 = this.a[var1];
         this.a[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public class_aas a(int var1, int var2) {
      if(this.a[var1] != null) {
         class_aas var3;
         if(this.a[var1].b <= var2) {
            var3 = this.a[var1];
            this.a[var1] = null;
            this.d.a((class_oj)this);
            return var3;
         } else {
            var3 = this.a[var1].a(var2);
            if(this.a[var1].b == 0) {
               this.a[var1] = null;
            }

            this.d.a((class_oj)this);
            return var3;
         }
      } else {
         return null;
      }
   }

   public void a(int var1, class_aas var2) {
      this.a[var1] = var2;
      this.d.a((class_oj)this);
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

   public void l() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

   }

   public int h() {
      return this.c;
   }

   public int i() {
      return this.b;
   }
}
