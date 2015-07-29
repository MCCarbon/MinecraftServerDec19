package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.class_dw;
import net.minecraft.server.class_eb;

public class class_dt extends class_eb.class_a_in_class_eb {
   private int b;

   class_dt() {
   }

   public class_dt(int var1) {
      this.b = var1;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeInt(this.b);
   }

   void a(DataInput var1, int var2, class_dw var3) throws IOException {
      var3.a(96L);
      this.b = var1.readInt();
   }

   public byte a() {
      return (byte)3;
   }

   public String toString() {
      return "" + this.b;
   }

   public class_eb b() {
      return new class_dt(this.b);
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         class_dt var2 = (class_dt)var1;
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
      return (short)(this.b & '\uffff');
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
