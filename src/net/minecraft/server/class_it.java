package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_it implements class_ff {
   private float a;
   private float b;
   private boolean c;
   private boolean d;

   public void a(class_em var1) throws IOException {
      this.a = var1.readFloat();
      this.b = var1.readFloat();
      byte var2 = var1.readByte();
      this.c = (var2 & 1) > 0;
      this.d = (var2 & 2) > 0;
   }

   public void b(class_em var1) throws IOException {
      var1.writeFloat(this.a);
      var1.writeFloat(this.b);
      byte var2 = 0;
      if(this.c) {
         var2 = (byte)(var2 | 1);
      }

      if(this.d) {
         var2 = (byte)(var2 | 2);
      }

      var1.writeByte(var2);
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public float a() {
      return this.a;
   }

   public float b() {
      return this.b;
   }

   public boolean c() {
      return this.c;
   }

   public boolean d() {
      return this.d;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
