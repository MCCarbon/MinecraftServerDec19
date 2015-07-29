package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_gb implements class_ff {
   private int a;
   private short b;
   private boolean c;

   public class_gb() {
   }

   public class_gb(int var1, short var2, boolean var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(class_fj var1) {
      var1.a(this);
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.readUnsignedByte();
      this.b = var1.readShort();
      this.c = var1.readBoolean();
   }

   public void b(class_em var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.writeBoolean(this.c);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_fj)var1);
   }
}
