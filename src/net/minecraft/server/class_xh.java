package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xf;

public class class_xh extends class_xf {
   public int e = 1;

   public class_xh(World var1) {
      super(var1);
   }

   public class_xh(World var1, class_qa var2, double var3, double var5, double var7) {
      super(var1, var2, var3, var5, var7);
   }

   protected void a(class_awg var1) {
      if(!this.o.D) {
         if(var1.d != null) {
            var1.d.a(class_pc.a((class_xf)this, (class_pr)this.a), 6.0F);
            this.a(this.a, var1.d);
         }

         boolean var2 = this.o.R().b("mobGriefing");
         this.o.a((class_pr)null, this.s, this.t, this.u, (float)this.e, var2, var2);
         this.J();
      }

   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("ExplosionPower", this.e);
   }

   public void a(class_dn var1) {
      super.a(var1);
      if(var1.b("ExplosionPower", 99)) {
         this.e = var1.g("ExplosionPower");
      }

   }
}
