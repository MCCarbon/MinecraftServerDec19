package net.minecraft.server;

import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EntityCreature;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tm;

public class class_ry extends class_rm {
   private EntityCreature a;
   private double b;
   private double c;
   private double d;
   private double e;

   public class_ry(EntityCreature var1, double var2) {
      this.a = var1;
      this.e = var2;
      this.a(1);
   }

   public boolean a() {
      if(this.a.cv()) {
         return false;
      } else {
         BlockPosition var1 = this.a.cw();
         Vec3D var2 = class_tm.a(this.a, 16, 7, new Vec3D((double)var1.getX(), (double)var1.getY(), (double)var1.getZ()));
         if(var2 == null) {
            return false;
         } else {
            this.b = var2.x;
            this.c = var2.y;
            this.d = var2.z;
            return true;
         }
      }
   }

   public boolean b() {
      return !this.a.u().m();
   }

   public void c() {
      this.a.u().a(this.b, this.c, this.d, this.e);
   }
}
