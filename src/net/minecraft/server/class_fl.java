package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_px;

public class class_fl implements class_ff {
   private int a;
   private int b;
   private int c;
   private int d;
   private int e;

   public class_fl() {
   }

   public class_fl(class_px var1) {
      this.a = var1.F();
      this.b = MathHelper.floor(var1.s * 32.0D);
      this.c = MathHelper.floor(var1.t * 32.0D);
      this.d = MathHelper.floor(var1.u * 32.0D);
      this.e = var1.j();
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readShort();
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeShort(this.e);
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
