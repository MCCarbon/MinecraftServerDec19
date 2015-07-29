package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.class_dw;
import net.minecraft.server.class_eb;

public class class_dm extends class_eb.class_a_in_class_eb {
   private byte b;

   class_dm() {
   }

   public class_dm(byte var1) {
      this.b = var1;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeByte(this.b);
   }

   void a(DataInput var1, int var2, class_dw var3) throws IOException {
      var3.a(72L);
      this.b = var1.readByte();
   }

   public byte a() {
      return (byte)1;
   }

   public String toString() {
      return "" + this.b + "b";
   }

   public class_eb b() {
      return new class_dm(this.b);
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         class_dm var2 = (class_dm)var1;
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
      return (short)this.b;
   }

   public byte f() {
      return this.b;
   }

   public double g() {
      return (double)this.b;
   }

   public float h() {
      return (float)this.b;
   }
}
