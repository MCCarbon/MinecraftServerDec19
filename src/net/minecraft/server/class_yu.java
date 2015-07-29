package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_amp;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_ow;
import net.minecraft.server.class_xa;

public class class_yu extends class_ow {
   private class_amp a;

   public class_yu() {
      super("container.enderchest", false, 27);
   }

   public void a(class_amp var1) {
      this.a = var1;
   }

   public void a(class_du var1) {
      int var2;
      for(var2 = 0; var2 < this.o_(); ++var2) {
         this.a(var2, (class_aas)null);
      }

      for(var2 = 0; var2 < var1.c(); ++var2) {
         class_dn var3 = var1.b(var2);
         int var4 = var3.e("Slot") & 255;
         if(var4 >= 0 && var4 < this.o_()) {
            this.a(var4, class_aas.a(var3));
         }
      }

   }

   public class_du h() {
      class_du var1 = new class_du();

      for(int var2 = 0; var2 < this.o_(); ++var2) {
         class_aas var3 = this.a(var2);
         if(var3 != null) {
            class_dn var4 = new class_dn();
            var4.a("Slot", (byte)var2);
            var3.b(var4);
            var1.a((class_eb)var4);
         }
      }

      return var1;
   }

   public boolean a(class_xa var1) {
      return this.a != null && !this.a.a(var1)?false:super.a(var1);
   }

   public void b(class_xa var1) {
      if(this.a != null) {
         this.a.b();
      }

      super.b(var1);
   }

   public void c(class_xa var1) {
      if(this.a != null) {
         this.a.d();
      }

      super.c(var1);
      this.a = null;
   }
}
