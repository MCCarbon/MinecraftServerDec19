package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;

public class class_fk implements class_ff {
   private int a;
   private UUID b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private int l;

   public class_fk() {
   }

   public class_fk(class_pr var1, int var2) {
      this(var1, var2, 0);
   }

   public class_fk(class_pr var1, int var2, int var3) {
      this.a = var1.F();
      this.b = var1.aM();
      this.c = class_nu.c(var1.s * 32.0D);
      this.d = class_nu.c(var1.t * 32.0D);
      this.e = class_nu.c(var1.u * 32.0D);
      this.i = class_nu.d(var1.z * 256.0F / 360.0F);
      this.j = class_nu.d(var1.y * 256.0F / 360.0F);
      this.k = var2;
      this.l = var3;
      double var4 = 3.9D;
      this.f = (int)(class_nu.a(var1.v, -3.9D, 3.9D) * 8000.0D);
      this.g = (int)(class_nu.a(var1.w, -3.9D, 3.9D) * 8000.0D);
      this.h = (int)(class_nu.a(var1.x, -3.9D, 3.9D) * 8000.0D);
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.g();
      this.k = var1.readByte();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.i = var1.readByte();
      this.j = var1.readByte();
      this.l = var1.readInt();
      this.f = var1.readShort();
      this.g = var1.readShort();
      this.h = var1.readShort();
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.a(this.b);
      var1.writeByte(this.k);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeByte(this.i);
      var1.writeByte(this.j);
      var1.writeInt(this.l);
      var1.writeShort(this.f);
      var1.writeShort(this.g);
      var1.writeShort(this.h);
   }

   public void a(class_fj var1) {
      var1.a(this);
   }

   public void a(int var1) {
      this.c = var1;
   }

   public void b(int var1) {
      this.d = var1;
   }

   public void c(int var1) {
      this.e = var1;
   }

   public void d(int var1) {
      this.f = var1;
   }

   public void e(int var1) {
      this.g = var1;
   }

   public void f(int var1) {
      this.h = var1;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_fj)var1);
   }
}
