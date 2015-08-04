package net.minecraft.server;

import net.minecraft.server.EntityCreature;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tf;

public class class_sm extends class_rm {
   private EntityCreature a;

   public class_sm(EntityCreature var1) {
      this.a = var1;
   }

   public boolean a() {
      return this.a.o.x();
   }

   public void c() {
      ((class_tf)this.a.u()).e(true);
   }

   public void d() {
      ((class_tf)this.a.u()).e(false);
   }
}
