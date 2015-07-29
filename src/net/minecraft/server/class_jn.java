package net.minecraft.server;

import java.io.IOException;
import java.security.PrivateKey;
import javax.crypto.SecretKey;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_jl;
import net.minecraft.server.class_ni;

public class class_jn implements class_ff {
   private byte[] a = new byte[0];
   private byte[] b = new byte[0];

   public void a(class_em var1) throws IOException {
      this.a = var1.a();
      this.b = var1.a();
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.a(this.b);
   }

   public void a(class_jl var1) {
      var1.a(this);
   }

   public SecretKey a(PrivateKey var1) {
      return class_ni.a(var1, this.a);
   }

   public byte[] b(PrivateKey var1) {
      return var1 == null?this.b:class_ni.b(var1, this.b);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_jl)var1);
   }
}
