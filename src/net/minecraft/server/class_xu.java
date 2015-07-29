package net.minecraft.server;

import net.minecraft.server.class_aej;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_om;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_uw;
import net.minecraft.server.class_xf;

public class class_xu extends class_xf {
   private static final int e = class_qi.a(class_xu.class);

   public class_xu(class_aen var1) {
      super(var1);
      this.a(0.3125F, 0.3125F);
   }

   public class_xu(class_aen var1, class_qa var2, double var3, double var5, double var7) {
      super(var1, var2, var3, var5, var7);
      this.a(0.3125F, 0.3125F);
   }

   protected float j() {
      return this.l()?0.73F:super.j();
   }

   public boolean av() {
      return false;
   }

   public float a(class_aej var1, class_aen var2, class_cj var3, class_anl var4) {
      float var5 = super.a(var1, var2, var3, var4);
      class_agj var6 = var4.c();
      if(this.l() && class_uw.a(var6)) {
         var5 = Math.min(0.8F, var5);
      }

      return var5;
   }

   protected void a(class_awg var1) {
      if(!this.o.D) {
         if(var1.d != null) {
            if(this.a != null) {
               if(var1.d.a(class_pc.a(this.a), 8.0F)) {
                  if(!var1.d.ai()) {
                     this.a.h(5.0F);
                  } else {
                     this.a(this.a, var1.d);
                  }
               }
            } else {
               var1.d.a(class_pc.l, 5.0F);
            }

            if(var1.d instanceof class_qa) {
               byte var2 = 0;
               if(this.o.ab() == class_om.c) {
                  var2 = 10;
               } else if(this.o.ab() == class_om.d) {
                  var2 = 40;
               }

               if(var2 > 0) {
                  ((class_qa)var1.d).c(new class_pl(class_pm.t, 20 * var2, 1));
               }
            }
         }

         this.o.a(this, this.s, this.t, this.u, 1.0F, false, this.o.R().b("mobGriefing"));
         this.J();
      }

   }

   public boolean ad() {
      return false;
   }

   public boolean a(class_pc var1, float var2) {
      return false;
   }

   protected void h() {
      this.ac.a(e, Byte.valueOf((byte)0));
   }

   public boolean l() {
      return this.ac.a(e) == 1;
   }

   public void a(boolean var1) {
      this.ac.b(e, Byte.valueOf((byte)(var1?1:0)));
   }
}
