package net.minecraft.server;

import net.minecraft.server.Vec3D;
import net.minecraft.server.Entity;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tm;
import net.minecraft.server.class_tz;
import net.minecraft.server.EntityHuman;

public class class_sn extends class_rm {
   private class_tz a;
   private double b;
   private double c;
   private double d;
   private double e;

   public class_sn(class_tz var1, double var2) {
      this.a = var1;
      this.b = var2;
      this.a(1);
   }

   public boolean a() {
      if(!this.a.cD() && this.a.l != null) {
         Vec3D var1 = class_tm.a(this.a, 5, 4);
         if(var1 == null) {
            return false;
         } else {
            this.c = var1.x;
            this.d = var1.y;
            this.e = var1.z;
            return true;
         }
      } else {
         return false;
      }
   }

   public void c() {
      this.a.u().a(this.c, this.d, this.e, this.b);
   }

   public boolean b() {
      return !this.a.u().m() && this.a.l != null;
   }

   public void e() {
      if(this.a.bd().nextInt(50) == 0) {
         if(this.a.l instanceof EntityHuman) {
            int var1 = this.a.cR();
            int var2 = this.a.cX();
            if(var2 > 0 && this.a.bd().nextInt(var2) < var1) {
               this.a.f((EntityHuman)this.a.l);
               this.a.o.a((Entity)this.a, (byte)7);
               return;
            }

            this.a.p(5);
         }

         this.a.l.a((Entity)null);
         this.a.l = null;
         this.a.dl();
         this.a.o.a((Entity)this.a, (byte)6);
      }

   }
}
