package net.minecraft.server;

import net.minecraft.server.Vec3D;
import net.minecraft.server.EntityCreature;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tm;

public class class_se extends class_rm {
   private EntityCreature b;
   protected double a;
   private double c;
   private double d;
   private double e;

   public class_se(EntityCreature var1, double var2) {
      this.b = var1;
      this.a = var2;
      this.a(1);
   }

   public boolean a() {
      if(this.b.be() == null && !this.b.av()) {
         return false;
      } else {
         Vec3D var1 = class_tm.a(this.b, 5, 4);
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

   public void c() {
      this.b.u().a(this.c, this.d, this.e, this.a);
   }

   public boolean b() {
      return !this.b.u().m();
   }
}
