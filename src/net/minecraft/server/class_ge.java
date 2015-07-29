package net.minecraft.server;

import java.io.IOException;
import java.util.List;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_ge implements class_ff {
   private int a;
   private class_aas[] b;

   public class_ge() {
   }

   public class_ge(int var1, List var2) {
      this.a = var1;
      this.b = new class_aas[var2.size()];

      for(int var3 = 0; var3 < this.b.length; ++var3) {
         class_aas var4 = (class_aas)var2.get(var3);
         this.b[var3] = var4 == null?null:var4.k();
      }

   }

   public void a(class_em var1) throws IOException {
      this.a = var1.readUnsignedByte();
      short var2 = var1.readShort();
      this.b = new class_aas[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.b[var3] = var1.i();
      }

   }

   public void b(class_em var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b.length);
      class_aas[] var2 = this.b;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_aas var5 = var2[var4];
         var1.a(var5);
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
