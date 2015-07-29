package net.minecraft.server;

public class class_ave {
   private byte a;
   private byte b;
   private byte c;
   private byte d;

   public class_ave(byte var1, byte var2, byte var3, byte var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public class_ave(class_ave var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
   }

   public byte a() {
      return this.a;
   }

   public byte b() {
      return this.b;
   }

   public byte c() {
      return this.c;
   }

   public byte d() {
      return this.d;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof class_ave)) {
         return false;
      } else {
         class_ave var2 = (class_ave)var1;
         return this.a != var2.a?false:(this.d != var2.d?false:(this.b != var2.b?false:this.c == var2.c));
      }
   }

   public int hashCode() {
      byte var1 = this.a;
      int var2 = 31 * var1 + this.b;
      var2 = 31 * var2 + this.c;
      var2 = 31 * var2 + this.d;
      return var2;
   }
}
