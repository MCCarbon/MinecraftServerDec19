package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_pk;

public class class_hc implements class_ff {
   private int a;
   private class_pk b;

   public class_hc() {
   }

   public class_hc(int var1, class_pk var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.b = class_pk.a(var1.readUnsignedByte());
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.writeByte(class_pk.a(this.b));
   }

   public void a(class_fj var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_fj)var1);
   }
}
