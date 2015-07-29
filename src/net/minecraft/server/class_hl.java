package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_pr;

public class class_hl implements class_ff {
   private int a;
   private int b;
   private int c;

   public class_hl() {
   }

   public class_hl(int var1, class_pr var2, class_pr var3) {
      this.a = var1;
      this.b = var2.F();
      this.c = var3 != null?var3.F():-1;
   }

   public void a(class_em var1) throws IOException {
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.a = var1.readUnsignedByte();
   }

   public void b(class_em var1) throws IOException {
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeByte(this.a);
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
