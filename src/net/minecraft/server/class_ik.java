package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_ik implements class_ff {
   private int a;
   private int b;
   private int c;
   private short d;
   private class_aas e;
   private int f;

   public void a(class_ic var1) {
      var1.a(this);
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.readShort();
      this.c = var1.readByte();
      this.d = var1.readShort();
      this.f = var1.readByte();
      this.e = var1.i();
   }

   public void b(class_em var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.writeByte(this.c);
      var1.writeShort(this.d);
      var1.writeByte(this.f);
      var1.a(this.e);
   }

   public int a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }

   public int c() {
      return this.c;
   }

   public short d() {
      return this.d;
   }

   public class_aas e() {
      return this.e;
   }

   public int f() {
      return this.f;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
