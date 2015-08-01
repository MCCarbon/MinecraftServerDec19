package net.minecraft.server;

import net.minecraft.server.class_ahe;
import net.minecraft.server.class_amg;
import net.minecraft.server.ITickAble;

public class class_aml extends class_amg implements ITickAble {
   public void tick() {
      if(this.b != null && !this.b.D && this.b.L() % 20L == 0L) {
         this.e = this.w();
         if(this.e instanceof class_ahe) {
            ((class_ahe)this.e).f(this.b, this.c);
         }
      }

   }
}
