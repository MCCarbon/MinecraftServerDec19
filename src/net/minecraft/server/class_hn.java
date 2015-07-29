package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_pw;

public class class_hn implements class_ff {
   private int a;
   private class_pw b;
   private class_aas c;

   public class_hn() {
   }

   public class_hn(int var1, class_pw var2, class_aas var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3 == null?null:var3.k();
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.b = (class_pw)var1.a(class_pw.class);
      this.c = var1.i();
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.a((Enum)this.b);
      var1.a(this.c);
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
