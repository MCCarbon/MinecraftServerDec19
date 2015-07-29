package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awt;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_hq implements class_ff {
   private String a;
   private String b;
   private class_awt.class_a_in_class_awt c;
   private int d;

   public class_hq() {
   }

   public class_hq(class_awj var1, int var2) {
      this.a = var1.b();
      this.b = var1.d();
      this.c = var1.c().c();
      this.d = var2;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.c(16);
      this.d = var1.readByte();
      if(this.d == 0 || this.d == 2) {
         this.b = var1.c(32);
         this.c = class_awt.class_a_in_class_awt.a(var1.c(16));
      }

   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.writeByte(this.d);
      if(this.d == 0 || this.d == 2) {
         var1.a(this.b);
         var1.a(this.c.a());
      }

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
