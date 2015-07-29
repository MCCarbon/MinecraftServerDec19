package net.minecraft.server;

import java.io.IOException;
import java.security.PublicKey;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_jg;
import net.minecraft.server.class_ni;

public class class_ji implements class_ff {
   private String a;
   private PublicKey b;
   private byte[] c;

   public class_ji() {
   }

   public class_ji(String var1, PublicKey var2, byte[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.c(20);
      this.b = class_ni.a(var1.a());
      this.c = var1.a();
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.a(this.b.getEncoded());
      var1.a(this.c);
   }

   public void a(class_jg var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_jg)var1);
   }
}
