package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_ip implements class_ff {
   protected double a;
   protected double b;
   protected double c;
   protected float d;
   protected float e;
   protected boolean f;
   protected boolean g;
   protected boolean h;

   public void a(class_ic var1) {
      var1.a(this);
   }

   public void a(class_em var1) throws IOException {
      this.f = var1.readUnsignedByte() != 0;
   }

   public void b(class_em var1) throws IOException {
      var1.writeByte(this.f?1:0);
   }

   public double a() {
      return this.a;
   }

   public double b() {
      return this.b;
   }

   public double c() {
      return this.c;
   }

   public float d() {
      return this.d;
   }

   public float e() {
      return this.e;
   }

   public boolean f() {
      return this.f;
   }

   public boolean g() {
      return this.g;
   }

   public boolean h() {
      return this.h;
   }

   public void a(boolean var1) {
      this.g = var1;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }

   public static class class_c_in_class_ip extends class_ip {
      public class_c_in_class_ip() {
         this.h = true;
      }

      public void a(class_em var1) throws IOException {
         this.d = var1.readFloat();
         this.e = var1.readFloat();
         super.a(var1);
      }

      public void b(class_em var1) throws IOException {
         var1.writeFloat(this.d);
         var1.writeFloat(this.e);
         super.b(var1);
      }

      // $FF: synthetic method
      // $FF: bridge method
      public void a(class_ep var1) {
         super.a((class_ic)var1);
      }
   }

   public static class class_a_in_class_ip extends class_ip {
      public class_a_in_class_ip() {
         this.g = true;
      }

      public void a(class_em var1) throws IOException {
         this.a = var1.readDouble();
         this.b = var1.readDouble();
         this.c = var1.readDouble();
         super.a(var1);
      }

      public void b(class_em var1) throws IOException {
         var1.writeDouble(this.a);
         var1.writeDouble(this.b);
         var1.writeDouble(this.c);
         super.b(var1);
      }

      // $FF: synthetic method
      // $FF: bridge method
      public void a(class_ep var1) {
         super.a((class_ic)var1);
      }
   }

   public static class class_b_in_class_ip extends class_ip {
      public class_b_in_class_ip() {
         this.g = true;
         this.h = true;
      }

      public void a(class_em var1) throws IOException {
         this.a = var1.readDouble();
         this.b = var1.readDouble();
         this.c = var1.readDouble();
         this.d = var1.readFloat();
         this.e = var1.readFloat();
         super.a(var1);
      }

      public void b(class_em var1) throws IOException {
         var1.writeDouble(this.a);
         var1.writeDouble(this.b);
         var1.writeDouble(this.c);
         var1.writeFloat(this.d);
         var1.writeFloat(this.e);
         super.b(var1);
      }

      // $FF: synthetic method
      // $FF: bridge method
      public void a(class_ep var1) {
         super.a((class_ic)var1);
      }
   }
}
