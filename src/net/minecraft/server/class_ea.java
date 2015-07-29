package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.class_dw;
import net.minecraft.server.class_eb;

public class class_ea extends class_eb {
   private String b;

   public class_ea() {
      this.b = "";
   }

   public class_ea(String var1) {
      this.b = var1;
      if(var1 == null) {
         throw new IllegalArgumentException("Empty string not allowed");
      }
   }

   void a(DataOutput var1) throws IOException {
      var1.writeUTF(this.b);
   }

   void a(DataInput var1, int var2, class_dw var3) throws IOException {
      var3.a(288L);
      this.b = var1.readUTF();
      var3.a((long)(16 * this.b.length()));
   }

   public byte a() {
      return (byte)8;
   }

   public String toString() {
      return "\"" + this.b.replace("\"", "\\\"") + "\"";
   }

   public class_eb b() {
      return new class_ea(this.b);
   }

   public boolean c_() {
      return this.b.isEmpty();
   }

   public boolean equals(Object var1) {
      if(!super.equals(var1)) {
         return false;
      } else {
         class_ea var2 = (class_ea)var1;
         return this.b == null && var2.b == null || this.b != null && this.b.equals(var2.b);
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.b.hashCode();
   }

   public String a_() {
      return this.b;
   }
}
