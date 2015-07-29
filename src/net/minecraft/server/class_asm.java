package net.minecraft.server;

import net.minecraft.server.class_avd;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;

public class class_asm extends class_avd {
   private class_dn b = new class_dn();

   public class_asm(String var1) {
      super(var1);
   }

   public void a(class_dn var1) {
      this.b = var1.n("Features");
   }

   public void b(class_dn var1) {
      var1.a((String)"Features", (class_eb)this.b);
   }

   public void a(class_dn var1, int var2, int var3) {
      this.b.a((String)b(var2, var3), (class_eb)var1);
   }

   public static String b(int var0, int var1) {
      return "[" + var0 + "," + var1 + "]";
   }

   public class_dn a() {
      return this.b;
   }
}
