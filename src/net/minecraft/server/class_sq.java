package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_sq extends class_rm {
   private EntityVillager a;
   private EntityVillagerGolem b;
   private int c;
   private boolean d;

   public class_sq(EntityVillager var1) {
      this.a = var1;
      this.a(3);
   }

   public boolean a() {
      if(this.a.l() >= 0) {
         return false;
      } else if(!this.a.o.x()) {
         return false;
      } else {
         List var1 = this.a.o.getEntities(EntityVillagerGolem.class, this.a.aT().grow(6.0D, 2.0D, 6.0D));
         if(var1.isEmpty()) {
            return false;
         } else {
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
               EntityVillagerGolem var3 = (EntityVillagerGolem)var2.next();
               if(var3.cB() > 0) {
                  this.b = var3;
                  break;
               }
            }

            return this.b != null;
         }
      }
   }

   public boolean b() {
      return this.b.cB() > 0;
   }

   public void c() {
      this.c = this.a.bd().nextInt(320);
      this.d = false;
      this.b.u().n();
   }

   public void d() {
      this.b = null;
      this.a.u().n();
   }

   public void e() {
      this.a.q().a(this.b, 30.0F, 30.0F);
      if(this.b.cB() == this.c) {
         this.a.u().a((Entity)this.b, 0.5D);
         this.d = true;
      }

      if(this.d && this.a.h(this.b) < 4.0D) {
         this.b.a(false);
         this.a.u().n();
      }

   }
}
