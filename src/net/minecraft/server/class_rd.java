package net.minecraft.server;

import net.minecraft.server.class_agj;
import net.minecraft.server.class_ahl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_om;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_rg;

public class class_rd extends class_rg {
   private int g;
   private int h = -1;

   public class_rd(class_qb var1) {
      super(var1);
   }

   public boolean a() {
      if(!super.a()) {
         return false;
      } else if(!this.a.o.R().b("mobGriefing")) {
         return false;
      } else {
         class_ahl var10000 = this.c;
         return !class_ahl.f(this.a.o, this.b);
      }
   }

   public void c() {
      super.c();
      this.g = 0;
   }

   public boolean b() {
      double var1 = this.a.b((class_cj)this.b);
      boolean var3;
      if(this.g <= 240) {
         class_ahl var10000 = this.c;
         if(!class_ahl.f(this.a.o, this.b) && var1 < 4.0D) {
            var3 = true;
            return var3;
         }
      }

      var3 = false;
      return var3;
   }

   public void d() {
      super.d();
      this.a.o.c(this.a.F(), this.b, -1);
   }

   public void e() {
      super.e();
      if(this.a.bd().nextInt(20) == 0) {
         this.a.o.b(1010, this.b, 0);
      }

      ++this.g;
      int var1 = (int)((float)this.g / 240.0F * 10.0F);
      if(var1 != this.h) {
         this.a.o.c(this.a.F(), this.b, var1);
         this.h = var1;
      }

      if(this.g == 240 && this.a.o.ab() == class_om.d) {
         this.a.o.g(this.b);
         this.a.o.b(1012, this.b, 0);
         this.a.o.b(2001, this.b, class_agj.a((class_agj)this.c));
      }

   }
}
