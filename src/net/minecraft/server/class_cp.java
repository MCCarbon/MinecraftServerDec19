package net.minecraft.server;

import net.minecraft.server.class_dd;

public class class_cp extends class_dd {
   private final Object a;

   public class_cp(Object var1) {
      this.a = var1;
   }

   public Object c(Object var1) {
      Object var2 = super.c(var1);
      return var2 == null?this.a:var2;
   }
}
