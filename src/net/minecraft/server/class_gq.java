package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_gq implements class_ff {
   private int a;
   private class_cj b;
   private int c;
   private boolean d;

   public class_gq() {
   }

   public class_gq(int var1, class_cj var2, int var3, boolean var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.readInt();
      this.b = var1.c();
      this.c = var1.readInt();
      this.d = var1.readBoolean();
   }

   public void b(class_em var1) throws IOException {
      var1.writeInt(this.a);
      var1.a(this.b);
      var1.writeInt(this.c);
      var1.writeBoolean(this.d);
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
