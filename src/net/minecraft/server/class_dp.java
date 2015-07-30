package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.class_dw;
import net.minecraft.server.class_eb;
import net.minecraft.server.MathHelper;

public class class_dp extends class_eb.class_a_in_class_eb {
   private double b;

   class_dp() {
   }

   public class_dp(double var1) {
      this.b = var1;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeDouble(this.b);
   }

   void a(DataInput var1, int var2, class_dw var3) throws IOException {
      var3.a(128L);
      this.b = var1.readDouble();
   }

   public byte a() {
      return (byte)6;
   }

   public String toString() {
      return "" + this.b + "d";
   }

   public class_eb b() {
      return new class_dp(this.b);
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         class_dp var2 = (class_dp)var1;
         return this.b == var2.b;
      } else {
         return false;
      }
   }

   public int hashCode() {
      long var1 = Double.doubleToLongBits(this.b);
      return super.hashCode() ^ (int)(var1 ^ var1 >>> 32);
   }

   public long c() {
      return (long)Math.floor(this.b);
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
      return this.b;
   }

   public float h() {
      return (float)this.b;
   }
}
