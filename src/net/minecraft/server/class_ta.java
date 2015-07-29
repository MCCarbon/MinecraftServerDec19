package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.class_qj;
import net.minecraft.server.class_sz;

public class class_ta extends class_sz {
   private class_qj g;

   public class_ta(class_qj var1, Class var2, boolean var3, Predicate var4) {
      super(var1, var2, 10, var3, false, var4);
      this.g = var1;
   }

   public boolean a() {
      return !this.g.cA() && super.a();
   }
}
