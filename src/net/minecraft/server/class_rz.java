package net.minecraft.server;

import net.minecraft.server.Vec3D;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityCreature;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tm;

public class class_rz extends class_rm {
   private EntityCreature a;
   private EntityLiving b;
   private double c;
   private double d;
   private double e;
   private double f;
   private float g;

   public class_rz(EntityCreature var1, double var2, float var4) {
      this.a = var1;
      this.f = var2;
      this.g = var4;
      this.a(1);
   }

   public boolean a() {
      this.b = this.a.w();
      if(this.b == null) {
         return false;
      } else if(this.b.h(this.a) > (double)(this.g * this.g)) {
         return false;
      } else {
         Vec3D var1 = class_tm.a(this.a, 16, 7, new Vec3D(this.b.locX, this.b.locY, this.b.locZ));
         if(var1 == null) {
            return false;
         } else {
            this.c = var1.x;
            this.d = var1.y;
            this.e = var1.z;
            return true;
         }
      }
   }

   public boolean b() {
      return !this.a.u().m() && this.b.isAlive() && this.b.h(this.a) < (double)(this.g * this.g);
   }

   public void d() {
      this.b = null;
   }

   public void c() {
      this.a.u().a(this.c, this.d, this.e, this.f);
   }
}
