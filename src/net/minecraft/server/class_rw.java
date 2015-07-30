package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_auv;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_tm;
import net.minecraft.server.class_to;
import net.minecraft.server.class_tp;

public class class_rw extends class_rm {
   private class_qh a;
   private double b;
   private class_auv c;
   private class_to d;
   private boolean e;
   private List f = Lists.newArrayList();

   public class_rw(class_qh var1, double var2, boolean var4) {
      this.a = var1;
      this.b = var2;
      this.e = var4;
      this.a(1);
      if(!(var1.u() instanceof class_tf)) {
         throw new IllegalArgumentException("Unsupported mob for MoveThroughVillageGoal");
      }
   }

   public boolean a() {
      this.f();
      if(this.e && this.a.o.x()) {
         return false;
      } else {
         class_tp var1 = this.a.o.af().a(new BlockPosition(this.a), 0);
         if(var1 == null) {
            return false;
         } else {
            this.d = this.a(var1);
            if(this.d == null) {
               return false;
            } else {
               class_tf var2 = (class_tf)this.a.u();
               boolean var3 = var2.g();
               var2.b(false);
               this.c = var2.a(this.d.d());
               var2.b(var3);
               if(this.c != null) {
                  return true;
               } else {
                  Vec3D var4 = class_tm.a(this.a, 10, 7, new Vec3D((double)this.d.d().getX(), (double)this.d.d().getY(), (double)this.d.d().getZ()));
                  if(var4 == null) {
                     return false;
                  } else {
                     var2.b(false);
                     this.c = this.a.u().a(var4.x, var4.y, var4.z);
                     var2.b(var3);
                     return this.c != null;
                  }
               }
            }
         }
      }
   }

   public boolean b() {
      if(this.a.u().m()) {
         return false;
      } else {
         float var1 = this.a.J + 4.0F;
         return this.a.b(this.d.d()) > (double)(var1 * var1);
      }
   }

   public void c() {
      this.a.u().a(this.c, this.b);
   }

   public void d() {
      if(this.a.u().m() || this.a.b(this.d.d()) < 16.0D) {
         this.f.add(this.d);
      }

   }

   private class_to a(class_tp var1) {
      class_to var2 = null;
      int var3 = Integer.MAX_VALUE;
      List var4 = var1.f();
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         class_to var6 = (class_to)var5.next();
         int var7 = var6.b(MathHelper.floor(this.a.s), MathHelper.floor(this.a.t), MathHelper.floor(this.a.u));
         if(var7 < var3 && !this.a(var6)) {
            var2 = var6;
            var3 = var7;
         }
      }

      return var2;
   }

   private boolean a(class_to var1) {
      Iterator var2 = this.f.iterator();

      class_to var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (class_to)var2.next();
      } while(!var1.d().equals(var3.d()));

      return true;
   }

   private void f() {
      if(this.f.size() > 15) {
         this.f.remove(0);
      }

   }
}
