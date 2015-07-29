package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_vc;

public class class_fo implements class_ff {
   private int a;
   private class_cj b;
   private class_cq c;
   private String d;

   public class_fo() {
   }

   public class_fo(class_vc var1) {
      this.a = var1.F();
      this.b = var1.n();
      this.c = var1.b;
      this.d = var1.c.B;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.d = var1.c(class_vc.class_a_in_class_vc.A);
      this.b = var1.c();
      this.c = class_cq.b(var1.readUnsignedByte());
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.a(this.d);
      var1.a(this.b);
      var1.writeByte(this.c.b());
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
