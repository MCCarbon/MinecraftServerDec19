package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.class_dw;
import net.minecraft.server.class_eb;
import net.minecraft.server.MathHelper;

public class class_dr extends class_eb.class_a_in_class_eb {
   private float b;

   class_dr() {
   }

   public class_dr(float var1) {
      this.b = var1;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeFloat(this.b);
   }

   void a(DataInput var1, int var2, class_dw var3) throws IOException {
      var3.a(96L);
      this.b = var1.readFloat();
   }

   public byte a() {
      return (byte)5;
   }

   public String toString() {
      return "" + this.b + "f";
   }

   public class_eb b() {
      return new class_dr(this.b);
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         class_dr var2 = (class_dr)var1;
         return this.b == var2.b;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ Float.floatToIntBits(this.b);
   }

   public long c() {
      return (long)this.b;
   }

   public int d() {
      return MathHelper.floor(this.b);
   }

   public short e() {
      return (short)(MathHelper.floor(this.b) & '\uffff');
   }

   public byte f() {
      return (byte)(MathHelper.floor(this.b) & 255);
   }

   public double g() {
      return (double)this.b;
   }

   public float h() {
      return this.b;
   }
}
