package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_ft implements class_ff {
   private class_cj a;
   private int b;
   private class_dn c;

   public class_ft() {
   }

   public class_ft(class_cj var1, int var2, class_dn var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.c();
      this.b = var1.readUnsignedByte();
      this.c = var1.h();
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.writeByte((byte)this.b);
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
