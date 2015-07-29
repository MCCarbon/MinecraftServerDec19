package net.minecraft.server;

import net.minecraft.server.class_aeh;
import net.minecraft.server.Block;
import net.minecraft.server.class_arw;

public class class_asu {
   private Block.class_a_in_class_agj a;
   private Block.class_c_in_class_agj b;
   private boolean c;
   private boolean d;
   private class_aeh e;
   private class_arw f;
   private boolean g;

   public class_asu() {
      this(Block.class_a_in_class_agj.a, Block.class_c_in_class_agj.a, false, false, (class_arw)null);
   }

   public class_asu(Block.class_a_in_class_agj var1, Block.class_c_in_class_agj var2, boolean var3, boolean var4, class_arw var5) {
      this.b = var2;
      this.a = var1;
      this.c = var3;
      this.d = var4;
      this.e = null;
      this.f = var5;
      this.g = true;
   }

   public class_asu a() {
      return (new class_asu(this.a, this.b, this.c, this.d, this.f)).a(this.e).c(this.g);
   }

   public class_asu a(Block.class_a_in_class_agj var1) {
      this.a = var1;
      return this;
   }

   public class_asu a(Block.class_c_in_class_agj var1) {
      this.b = var1;
      return this;
   }

   public class_asu a(boolean var1) {
      this.c = var1;
      return this;
   }

   public class_asu b(boolean var1) {
      this.d = var1;
      return this;
   }

   public class_asu a(class_aeh var1) {
      this.e = var1;
      return this;
   }

   public class_asu a(class_arw var1) {
      this.f = var1;
      return this;
   }

   public Block.class_a_in_class_agj b() {
      return this.a;
   }

   public class_asu c(boolean var1) {
      this.g = var1;
      return this;
   }

   public Block.class_c_in_class_agj c() {
      return this.b;
   }

   public boolean e() {
      return this.c;
   }

   public boolean f() {
      return this.d;
   }

   public class_arw g() {
      if(this.f == null && this.e != null) {
         this.i();
      }

      return this.f;
   }

   public boolean h() {
      return this.g;
   }

   void i() {
      this.f = this.b(this.e);
   }

   private class_arw b(class_aeh var1) {
      if(var1 == null) {
         return null;
      } else {
         int var2 = var1.a * 16;
         int var3 = var1.b * 16;
         return new class_arw(var2, 0, var3, var2 + 16 - 1, 255, var3 + 16 - 1);
      }
   }

   // $FF: synthetic method
   public Object clone() throws CloneNotSupportedException {
      return this.a();
   }
}
