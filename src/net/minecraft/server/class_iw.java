package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_iw implements class_ff {
   private int a;
   private class_aas b;

   public void a(class_ic var1) {
      var1.a(this);
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.readShort();
      this.b = var1.i();
   }

   public void b(class_em var1) throws IOException {
      var1.writeShort(this.a);
      var1.a(this.b);
   }

   public int a() {
      return this.a;
   }

   public class_aas b() {
      return this.b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
