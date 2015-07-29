package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_gm implements class_ff {
   public static final String[] a = new String[]{"tile.bed.notValid"};
   private int b;
   private float c;

   public class_gm() {
   }

   public class_gm(int var1, float var2) {
      this.b = var1;
      this.c = var2;
   }

   public void a(class_em var1) throws IOException {
      this.b = var1.readUnsignedByte();
      this.c = var1.readFloat();
   }

   public void b(class_em var1) throws IOException {
      var1.writeByte(this.b);
      var1.writeFloat(this.c);
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
