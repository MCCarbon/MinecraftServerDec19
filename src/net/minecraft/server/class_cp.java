package net.minecraft.server;

import net.minecraft.server.RegistrySimple;

public class class_cp extends RegistrySimple {
   private final Object a;

   public class_cp(Object var1) {
      this.a = var1;
   }

   public Object c(Object var1) {
      Object var2 = super.get(var1);
      return var2 == null?this.a:var2;
   }
}
