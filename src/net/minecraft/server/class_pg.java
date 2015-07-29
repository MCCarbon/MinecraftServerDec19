package net.minecraft.server;

import net.minecraft.server.class_pk;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qo;

public class class_pg extends class_pk {
   protected class_pg(boolean var1, int var2) {
      super(var1, var2);
   }

   public void a(class_qa var1, class_qo var2, int var3) {
      var1.m(var1.bO() - (float)(4 * (var3 + 1)));
      super.a(var1, var2, var3);
   }

   public void b(class_qa var1, class_qo var2, int var3) {
      var1.m(var1.bO() + (float)(4 * (var3 + 1)));
      super.b(var1, var2, var3);
   }
}
