package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_ii implements class_ff {
   private int a;
   private short b;
   private boolean c;

   public void a(class_ic var1) {
      var1.a(this);
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.readShort();
      this.c = var1.readByte() != 0;
   }

   public void b(class_em var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.writeByte(this.c?1:0);
   }

   public int a() {
      return this.a;
   }

   public short b() {
      return this.b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
