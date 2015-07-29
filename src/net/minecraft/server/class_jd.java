package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_el;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_je;

public class class_jd implements class_ff {
   private int a;
   private String b;
   private int c;
   private class_el d;

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.c(255);
      this.c = var1.readUnsignedShort();
      this.d = class_el.a(var1.e());
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.a(this.b);
      var1.writeShort(this.c);
      var1.b(this.d.a());
   }

   public void a(class_je var1) {
      var1.a(this);
   }

   public class_el a() {
      return this.d;
   }

   public int b() {
      return this.a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_je)var1);
   }
}
