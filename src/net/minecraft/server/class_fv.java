package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_fv implements class_ff {
   private class_cj a;
   private class_anl b;

   public class_fv() {
   }

   public class_fv(class_aen var1, class_cj var2) {
      this.a = var2;
      this.b = var1.p(var2);
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.c();
      this.b = (class_anl)class_agj.d.a(var1.e());
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.b(class_agj.d.a(this.b));
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
