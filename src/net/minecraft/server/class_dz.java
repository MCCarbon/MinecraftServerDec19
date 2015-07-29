package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.class_dw;
import net.minecraft.server.class_eb;

public class class_dz extends class_eb.class_a_in_class_eb {
   private short b;

   public class_dz() {
   }

   public class_dz(short var1) {
      this.b = var1;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeShort(this.b);
   }

   void a(DataInput var1, int var2, class_dw var3) throws IOException {
      var3.a(80L);
      this.b = var1.readShort();
   }

   public byte a() {
      return (byte)2;
   }

   public String toString() {
      return "" + this.b + "s";
   }

   public class_eb b() {
      return new class_dz(this.b);
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         class_dz var2 = (class_dz)var1;
         return this.b == var2.b;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.b;
   }

   public long c() {
      return (long)this.b;
   }

   public int d() {
      return this.b;
   }

   public short e() {
      return this.b;
   }

   public byte f() {
      return (byte)(this.b & 255);
   }

   public double g() {
      return (double)this.b;
   }

   public float h() {
      return (float)this.b;
   }
}
