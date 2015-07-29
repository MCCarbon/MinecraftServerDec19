package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_jg;

public class class_jj implements class_ff {
   private int a;

   public class_jj() {
   }

   public class_jj(int var1) {
      this.a = var1;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
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
