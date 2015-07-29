package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import net.minecraft.server.class_dw;
import net.minecraft.server.class_eb;

public class class_ds extends class_eb {
   private int[] b;

   class_ds() {
   }

   public class_ds(int[] var1) {
      this.b = var1;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeInt(this.b.length);

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         var1.writeInt(this.b[var2]);
      }

   }

   void a(DataInput var1, int var2, class_dw var3) throws IOException {
      var3.a(192L);
      int var4 = var1.readInt();
      var3.a((long)(32 * var4));
      this.b = new int[var4];

      for(int var5 = 0; var5 < var4; ++var5) {
         this.b[var5] = var1.readInt();
      }

   }

   public byte a() {
      return (byte)11;
   }

   public String toString() {
      String var1 = "[";
      int[] var2 = this.b;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var2[var4];
         var1 = var1 + var5 + ",";
      }

      return var1 + "]";
   }

   public class_eb b() {
      int[] var1 = new int[this.b.length];
      System.arraycopy(this.b, 0, var1, 0, this.b.length);
      return new class_ds(var1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1)?Arrays.equals(this.b, ((class_ds)var1).b):false;
   }

   public int hashCode() {
      return super.hashCode() ^ Arrays.hashCode(this.b);
   }

   public int[] c() {
      return this.b;
   }
}
