package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_auw;
import net.minecraft.server.class_auy;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_tg;

public class class_ti extends class_tg {
   public class_ti(class_qb var1, class_aen var2) {
      super(var1, var2);
   }

   protected class_auw a() {
      return new class_auw(new class_auy());
   }

   protected boolean b() {
      return this.o();
   }

   protected class_awh c() {
      return new class_awh(this.b.s, this.b.t + (double)this.b.K * 0.5D, this.b.u);
   }

   protected void l() {
      class_awh var1 = this.c();
      float var2 = this.b.J * this.b.J;
      byte var3 = 6;
      if(var1.g(this.d.a(this.b, this.d.e())) < (double)var2) {
         this.d.a();
      }

      for(int var4 = Math.min(this.d.e() + var3, this.d.d() - 1); var4 > this.d.e(); --var4) {
         class_awh var5 = this.d.a(this.b, var4);
         if(var5.g(var1) <= 36.0D && this.a(var1, var5, 0, 0, 0)) {
            this.d.c(var4);
            break;
         }
      }

      this.a(var1);
   }

   protected void d() {
      super.d();
   }

   protected boolean a(class_awh var1, class_awh var2, int var3, int var4, int var5) {
      class_awg var6 = this.c.a(var1, new class_awh(var2.a, var2.b + (double)this.b.K * 0.5D, var2.c), false, true, false);
      return var6 == null || var6.a == class_awg.class_a_in_class_awg.a;
   }
}
