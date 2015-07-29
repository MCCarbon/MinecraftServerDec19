package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_awt;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_my;

public class class_mw extends class_my {
   private final class_aar a;

   public class_mw(String var1, String var2, class_eu var3, class_aar var4) {
      super(var1 + var2, var3);
      this.a = var4;
      int var5 = class_aar.b(var4);
      if(var5 != 0) {
         class_awt.a.put(var1 + var5, this.k());
      }

   }
}
