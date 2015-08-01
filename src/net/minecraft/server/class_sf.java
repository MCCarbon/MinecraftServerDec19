package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.Vec3D;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tm;
import net.minecraft.server.class_wv;

public class class_sf extends class_rm {
   private class_wv a;
   private EntityLiving b;
   private double c;
   private int d;

   public class_sf(class_wv var1, double var2) {
      this.a = var1;
      this.c = var2;
      this.a(1);
   }

   public boolean a() {
      if(this.a.l() >= 0) {
         return false;
      } else if(this.a.bd().nextInt(400) != 0) {
         return false;
      } else {
         List var1 = this.a.o.getEntities(class_wv.class, this.a.aT().grow(6.0D, 3.0D, 6.0D));
         double var2 = Double.MAX_VALUE;
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            class_wv var5 = (class_wv)var4.next();
            if(var5 != this.a && !var5.cC() && var5.l() < 0) {
               double var6 = var5.h(this.a);
               if(var6 <= var2) {
                  var2 = var6;
                  this.b = var5;
               }
            }
         }

         if(this.b == null) {
            Vec3D var8 = class_tm.a(this.a, 16, 3);
            if(var8 == null) {
               return false;
            }
         }

         return true;
      }
   }

   public boolean b() {
      return this.d > 0;
   }

   public void c() {
      if(this.b != null) {
         this.a.n(true);
      }

      this.d = 1000;
   }

   public void d() {
      this.a.n(false);
      this.b = null;
   }

   public void e() {
      --this.d;
      if(this.b != null) {
         if(this.a.h(this.b) > 4.0D) {
            this.a.u().a((Entity)this.b, this.c);
         }
      } else if(this.a.u().m()) {
         Vec3D var1 = class_tm.a(this.a, 16, 3);
         if(var1 == null) {
            return;
         }

         this.a.u().a(var1.x, var1.y, var1.z, this.c);
      }

   }
}
