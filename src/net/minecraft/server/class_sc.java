package net.minecraft.server;

import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Entity;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_uj;
import net.minecraft.server.class_wv;

public class class_sc extends class_rm {
   private class_uj a;
   private class_wv b;
   private int c;

   public class_sc(class_uj var1) {
      this.a = var1;
      this.a(3);
   }

   public boolean a() {
      if(!this.a.o.x()) {
         return false;
      } else if(this.a.bd().nextInt(8000) != 0) {
         return false;
      } else {
         this.b = (class_wv)this.a.o.a((Class)class_wv.class, (AxisAlignedBB)this.a.aT().grow(6.0D, 2.0D, 6.0D), (Entity)this.a);
         return this.b != null;
      }
   }

   public boolean b() {
      return this.c > 0;
   }

   public void c() {
      this.c = 400;
      this.a.a(true);
   }

   public void d() {
      this.a.a(false);
      this.b = null;
   }

   public void e() {
      this.a.q().a(this.b, 30.0F, 30.0F);
      --this.c;
   }
}
