package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_adz;
import net.minecraft.server.class_aea;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_yr;
import net.minecraft.server.class_yx;

public class class_yt extends class_yx {
   private final class_yr a;
   private class_xa b;
   private int c;
   private final class_adz h;

   public class_yt(class_xa var1, class_adz var2, class_yr var3, int var4, int var5, int var6) {
      super(var3, var4, var5, var6);
      this.b = var1;
      this.h = var2;
      this.a = var3;
   }

   public boolean a(class_aas var1) {
      return false;
   }

   public class_aas a(int var1) {
      if(this.e()) {
         this.c += Math.min(var1, this.d().b);
      }

      return super.a(var1);
   }

   protected void a(class_aas var1, int var2) {
      this.c += var2;
      this.c(var1);
   }

   protected void c(class_aas var1) {
      var1.a(this.b.o, this.b, this.c);
      this.c = 0;
   }

   public void a(class_xa var1, class_aas var2) {
      this.c(var2);
      class_aea var3 = this.a.i();
      if(var3 != null) {
         class_aas var4 = this.a.a(0);
         class_aas var5 = this.a.a(1);
         if(this.a(var3, var4, var5) || this.a(var3, var5, var4)) {
            this.h.a(var3);
            var1.b(class_nc.G);
            if(var4 != null && var4.b <= 0) {
               var4 = null;
            }

            if(var5 != null && var5.b <= 0) {
               var5 = null;
            }

            this.a.a(0, var4);
            this.a.a(1, var5);
         }
      }

   }

   private boolean a(class_aea var1, class_aas var2, class_aas var3) {
      class_aas var4 = var1.a();
      class_aas var5 = var1.b();
      if(var2 != null && var2.b() == var4.b()) {
         if(var5 != null && var3 != null && var5.b() == var3.b()) {
            var2.b -= var4.b;
            var3.b -= var5.b;
            return true;
         }

         if(var5 == null && var3 == null) {
            var2.b -= var4.b;
            return true;
         }
      }

      return false;
   }
}
