package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vi;

public class class_fm implements class_ff {
   private int a;
   private int b;
   private int c;
   private int d;
   private int e;

   public class_fm() {
   }

   public class_fm(class_pr var1) {
      this.a = var1.F();
      this.b = class_nu.c(var1.s * 32.0D);
      this.c = class_nu.c(var1.t * 32.0D);
      this.d = class_nu.c(var1.u * 32.0D);
      if(var1 instanceof class_vi) {
         this.e = 1;
      }

   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.e = var1.readByte();
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readInt();
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.writeByte(this.e);
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
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
