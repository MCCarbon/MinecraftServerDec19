package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_fs implements class_ff {
   private int a;
   private class_cj b;
   private int c;

   public class_fs() {
   }

   public class_fs(int var1, class_cj var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.c();
      this.c = var1.readUnsignedByte();
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.a(this.b);
      var1.writeByte(this.c);
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
