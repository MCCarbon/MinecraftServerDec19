package net.minecraft.server;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pt;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qi;

public class class_fn implements class_ff {
   private int a;
   private UUID b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private byte j;
   private byte k;
   private byte l;
   private class_qi m;
   private List n;

   public class_fn() {
   }

   public class_fn(class_qa var1) {
      this.a = var1.F();
      this.b = var1.aM();
      this.c = (byte)class_pt.a(var1);
      this.d = class_nu.c(var1.s * 32.0D);
      this.e = class_nu.c(var1.t * 32.0D);
      this.f = class_nu.c(var1.u * 32.0D);
      this.j = (byte)((int)(var1.y * 256.0F / 360.0F));
      this.k = (byte)((int)(var1.z * 256.0F / 360.0F));
      this.l = (byte)((int)(var1.aN * 256.0F / 360.0F));
      double var2 = 3.9D;
      double var4 = var1.v;
      double var6 = var1.w;
      double var8 = var1.x;
      if(var4 < -var2) {
         var4 = -var2;
      }

      if(var6 < -var2) {
         var6 = -var2;
      }

      if(var8 < -var2) {
         var8 = -var2;
      }

      if(var4 > var2) {
         var4 = var2;
      }

      if(var6 > var2) {
         var6 = var2;
      }

      if(var8 > var2) {
         var8 = var2;
      }

      this.g = (int)(var4 * 8000.0D);
      this.h = (int)(var6 * 8000.0D);
      this.i = (int)(var8 * 8000.0D);
      this.m = var1.H();
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.g();
      this.c = var1.readByte() & 255;
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.f = var1.readInt();
      this.j = var1.readByte();
      this.k = var1.readByte();
      this.l = var1.readByte();
      this.g = var1.readShort();
      this.h = var1.readShort();
      this.i = var1.readShort();
      this.n = class_qi.b(var1);
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.a(this.b);
      var1.writeByte(this.c & 255);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeInt(this.f);
      var1.writeByte(this.j);
      var1.writeByte(this.k);
      var1.writeByte(this.l);
      var1.writeShort(this.g);
      var1.writeShort(this.h);
      var1.writeShort(this.i);
      this.m.a(var1);
   }

   public void a(class_fj var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_fj)var1);
   }
}
