package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tw;

public class class_rl extends class_rm {
   class_tw a;
   class_tw b;
   double c;
   private int d;

   public class_rl(class_tw var1, double var2) {
      this.a = var1;
      this.c = var2;
   }

   public boolean a() {
      if(this.a.l() >= 0) {
         return false;
      } else {
         List var1 = this.a.o.a(this.a.getClass(), this.a.aT().b(8.0D, 4.0D, 8.0D));
         class_tw var2 = null;
         double var3 = Double.MAX_VALUE;
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            class_tw var6 = (class_tw)var5.next();
            if(var6.l() >= 0) {
               double var7 = this.a.h(var6);
               if(var7 <= var3) {
                  var3 = var7;
                  var2 = var6;
               }
            }
         }

         if(var2 == null) {
            return false;
         } else if(var3 < 9.0D) {
            return false;
         } else {
            this.b = var2;
            return true;
         }
      }
   }

   public boolean b() {
      if(this.a.l() >= 0) {
         return false;
      } else if(!this.b.ai()) {
         return false;
      } else {
         double var1 = this.a.h(this.b);
         return var1 >= 9.0D && var1 <= 256.0D;
      }
   }

   public void c() {
      this.d = 0;
   }

   public void d() {
      this.b = null;
   }

   public void e() {
      if(--this.d <= 0) {
         this.d = 10;
         this.a.u().a((class_pr)this.b, this.c);
      }
   }
}
