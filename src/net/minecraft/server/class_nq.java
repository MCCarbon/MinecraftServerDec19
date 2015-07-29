package net.minecraft.server;

public abstract class class_nq {
   private Object a;
   private boolean b = false;

   public Object c() {
      if(!this.b) {
         this.b = true;
         this.a = this.b();
      }

      return this.a;
   }

   protected abstract Object b();
}
