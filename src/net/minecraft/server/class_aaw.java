package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_zg;

public class class_aaw extends class_zg {
   private final class_aja b;

   public class_aaw(class_aja var1) {
      super(var1);
      this.b = var1;
      this.e(0);
      this.a(true);
   }

   public int a(int var1) {
      return var1 | 4;
   }

   public String e_(class_aas var1) {
      return super.a() + "." + this.b.b(var1.i()).d();
   }
}
