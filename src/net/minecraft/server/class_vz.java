package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_om;
import net.minecraft.server.class_on;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_wp;

public class class_vz extends class_wp {
   public class_vz(World var1) {
      super(var1);
      this.a(0.7F, 0.5F);
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(12.0D);
   }

   public boolean r(Entity var1) {
      if(super.r(var1)) {
         if(var1 instanceof EntityLiving) {
            byte var2 = 0;
            if(this.o.ab() == class_om.c) {
               var2 = 7;
            } else if(this.o.ab() == class_om.d) {
               var2 = 15;
            }

            if(var2 > 0) {
               ((EntityLiving)var1).c(new class_pl(class_pm.s, var2 * 20, 0));
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public class_qd a(class_on var1, class_qd var2) {
      return var2;
   }

   public float aU() {
      return 0.45F;
   }
}
