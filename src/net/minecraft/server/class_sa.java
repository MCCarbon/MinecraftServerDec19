package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_rm;

public class class_sa extends class_rm {
   World a;
   class_qb b;
   class_qa c;
   int d;

   public class_sa(class_qb var1) {
      this.b = var1;
      this.a = var1.o;
      this.a(3);
   }

   public boolean a() {
      class_qa var1 = this.b.w();
      if(var1 == null) {
         return false;
      } else {
         this.c = var1;
         return true;
      }
   }

   public boolean b() {
      return !this.c.ai()?false:(this.b.h(this.c) > 225.0D?false:!this.b.u().m() || this.a());
   }

   public void d() {
      this.c = null;
      this.b.u().n();
   }

   public void e() {
      this.b.q().a(this.c, 30.0F, 30.0F);
      double var1 = (double)(this.b.J * 2.0F * this.b.J * 2.0F);
      double var3 = this.b.e(this.c.s, this.c.aT().b, this.c.u);
      double var5 = 0.8D;
      if(var3 > var1 && var3 < 16.0D) {
         var5 = 1.33D;
      } else if(var3 < 225.0D) {
         var5 = 0.6D;
      }

      this.b.u().a((class_pr)this.c, var5);
      this.d = Math.max(this.d - 1, 0);
      if(var3 <= var1) {
         if(this.d <= 0) {
            this.d = 20;
            this.b.r(this.c);
         }
      }
   }
}
