package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;
import net.minecraft.server.class_oo;

public class class_ja implements class_ff {
   private BlockPosition a;
   private EnumDirection b;
   private class_oo c;
   private float d;
   private float e;
   private float f;

   public void a(class_em var1) throws IOException {
      this.a = var1.c();
      this.b = (EnumDirection)var1.a(EnumDirection.class);
      this.c = (class_oo)var1.a(class_oo.class);
      this.d = (float)var1.readUnsignedByte() / 16.0F;
      this.e = (float)var1.readUnsignedByte() / 16.0F;
      this.f = (float)var1.readUnsignedByte() / 16.0F;
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.a((Enum)this.b);
      var1.a((Enum)this.c);
      var1.writeByte((int)(this.d * 16.0F));
      var1.writeByte((int)(this.e * 16.0F));
      var1.writeByte((int)(this.f * 16.0F));
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public BlockPosition a() {
      return this.a;
   }

   public EnumDirection b() {
      return this.b;
   }

   public class_oo c() {
      return this.c;
   }

   public float d() {
      return this.d;
   }

   public float e() {
      return this.e;
   }

   public float f() {
      return this.f;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
