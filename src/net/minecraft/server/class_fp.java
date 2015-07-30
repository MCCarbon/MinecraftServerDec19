package net.minecraft.server;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_xa;

public class class_fp implements class_ff {
   private int a;
   private UUID b;
   private int c;
   private int d;
   private int e;
   private byte f;
   private byte g;
   private class_qi h;
   private List i;

   public class_fp() {
   }

   public class_fp(class_xa var1) {
      this.a = var1.F();
      this.b = var1.cf().getId();
      this.c = MathHelper.floor(var1.s * 32.0D);
      this.d = MathHelper.floor(var1.t * 32.0D);
      this.e = MathHelper.floor(var1.u * 32.0D);
      this.f = (byte)((int)(var1.y * 256.0F / 360.0F));
      this.g = (byte)((int)(var1.z * 256.0F / 360.0F));
      this.h = var1.H();
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.g();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.f = var1.readByte();
      this.g = var1.readByte();
      this.i = class_qi.b(var1);
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.a(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeByte(this.f);
      var1.writeByte(this.g);
      this.h.a(var1);
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
