package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_om;

public class class_fx implements class_ff {
   private class_om a;
   private boolean b;

   public class_fx() {
   }

   public class_fx(class_om var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(class_fj var1) {
      var1.a(this);
   }

   public void a(class_em var1) throws IOException {
      this.a = class_om.a(var1.readUnsignedByte());
   }

   public void b(class_em var1) throws IOException {
      var1.writeByte(this.a.a());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_fj)var1);
   }
}
