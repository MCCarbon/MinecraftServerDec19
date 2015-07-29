package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_pr;

public class class_hh implements class_ff {
   public int a;

   public class_hh() {
   }

   public class_hh(class_pr var1) {
      this.a = var1.F();
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
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
