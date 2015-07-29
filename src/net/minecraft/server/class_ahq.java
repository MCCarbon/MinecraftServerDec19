package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amo;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_op;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_ahq extends class_agd {
   protected class_ahq() {
      super(class_atk.e, class_atl.D);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
      this.e(0);
      this.a(class_zu.c);
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public int b() {
      return 3;
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_amo();
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         if(var11 instanceof class_amo) {
            var4.a((class_op)((class_amo)var11));
         }

         return true;
      }
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_qa var4, class_aas var5) {
      super.a(var1, var2, var3, var4, var5);
      if(var5.s()) {
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_amo) {
            ((class_amo)var6).a(var5.q());
         }
      }

   }
}
