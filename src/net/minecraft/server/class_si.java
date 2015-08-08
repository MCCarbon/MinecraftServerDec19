package net.minecraft.server;

import net.minecraft.server.Vec3D;
import net.minecraft.server.EntityCreature;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tm;

public class class_si extends class_rm {
   private EntityCreature a;
   private double b;
   private double c;
   private double d;
   private double e;
   private int f;
   private boolean g;

   public class_si(EntityCreature var1, double var2) {
      this(var1, var2, 120);
   }

   public class_si(EntityCreature var1, double var2, int var4) {
      this.a = var1;
      this.e = var2;
      this.f = var4;
      this.a(1);
   }

   public boolean a() {
      if(!this.g) {
         if(this.a.bi() >= 100) {
            return false;
         }

         if(this.a.getRandom().nextInt(this.f) != 0) {
            return false;
         }
      }

      Vec3D var1 = class_tm.a(this.a, 10, 7);
      if(var1 == null) {
         return false;
      } else {
         this.b = var1.x;
         this.c = var1.y;
         this.d = var1.z;
         this.g = false;
         return true;
      }
   }

   public boolean b() {
      return !this.a.u().m();
   }

   public void c() {
      this.a.u().a(this.b, this.c, this.d, this.e);
   }

   public void f() {
      this.g = true;
   }

   public void b(int var1) {
      this.f = var1;
   }
}
