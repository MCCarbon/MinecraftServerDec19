package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;
import net.minecraft.server.class_wy;

public class class_iq implements class_ff {
   private boolean a;
   private boolean b;
   private boolean c;
   private boolean d;
   private float e;
   private float f;

   public class_iq() {
   }

   public class_iq(class_wy var1) {
      this.a(var1.a);
      this.b(var1.b);
      this.c(var1.c);
      this.d(var1.d);
      this.a(var1.a());
      this.b(var1.b());
   }

   public void a(class_em var1) throws IOException {
      byte var2 = var1.readByte();
      this.a((var2 & 1) > 0);
      this.b((var2 & 2) > 0);
      this.c((var2 & 4) > 0);
      this.d((var2 & 8) > 0);
      this.a(var1.readFloat());
      this.b(var1.readFloat());
   }

   public void b(class_em var1) throws IOException {
      byte var2 = 0;
      if(this.a()) {
         var2 = (byte)(var2 | 1);
      }

      if(this.b()) {
         var2 = (byte)(var2 | 2);
      }

      if(this.c()) {
         var2 = (byte)(var2 | 4);
      }

      if(this.d()) {
         var2 = (byte)(var2 | 8);
      }

      var1.writeByte(var2);
      var1.writeFloat(this.e);
      var1.writeFloat(this.f);
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public boolean a() {
      return this.a;
   }

   public void a(boolean var1) {
      this.a = var1;
   }

   public boolean b() {
      return this.b;
   }

   public void b(boolean var1) {
      this.b = var1;
   }

   public boolean c() {
      return this.c;
   }

   public void c(boolean var1) {
      this.c = var1;
   }

   public boolean d() {
      return this.d;
   }

   public void d(boolean var1) {
      this.d = var1;
   }

   public void a(float var1) {
      this.e = var1;
   }

   public void b(float var1) {
      this.f = var1;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
