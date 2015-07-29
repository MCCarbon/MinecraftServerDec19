package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_hy implements class_ff {
   private int a;
   private int b;

   public class_hy() {
   }

   public class_hy(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.e();
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.b(this.b);
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
