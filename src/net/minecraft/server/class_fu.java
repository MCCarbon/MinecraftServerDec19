package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.Block;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_fu implements class_ff {
   private class_cj a;
   private int b;
   private int c;
   private Block d;

   public class_fu() {
   }

   public class_fu(class_cj var1, Block var2, int var3, int var4) {
      this.a = var1;
      this.b = var3;
      this.c = var4;
      this.d = var2;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.c();
      this.b = var1.readUnsignedByte();
      this.c = var1.readUnsignedByte();
      this.d = Block.getById(var1.e() & 4095);
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.writeByte(this.b);
      var1.writeByte(this.c);
      var1.b(Block.getId(this.d) & 4095);
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
