package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_gi implements class_ff {
   private class_eu a;

   public class_gi() {
   }

   public class_gi(class_eu var1) {
      this.a = var1;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.d();
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
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