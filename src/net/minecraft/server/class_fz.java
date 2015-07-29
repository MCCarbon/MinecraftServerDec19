package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_fz implements class_ff {
   private class_eu a;
   private byte b;

   public class_fz() {
   }

   public class_fz(class_eu var1) {
      this(var1, (byte)1);
   }

   public class_fz(class_eu var1, byte var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.d();
      this.b = var1.readByte();
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.writeByte(this.b);
   }

   public void a(class_fj var1) {
      var1.a(this);
   }

   public boolean b() {
      return this.b == 1 || this.b == 2;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_fj)var1);
   }
}
