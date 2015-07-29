package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;
import net.minecraft.server.class_pz;
import net.minecraft.server.class_xa;

public class class_ih implements class_ff {
   private String a;
   private int b;
   private class_xa.class_b_in_class_xa c;
   private boolean d;
   private int e;
   private class_pz f;

   public void a(class_em var1) throws IOException {
      this.a = var1.c(7);
      this.b = var1.readByte();
      this.c = (class_xa.class_b_in_class_xa)var1.a(class_xa.class_b_in_class_xa.class);
      this.d = var1.readBoolean();
      this.e = var1.readUnsignedByte();
      this.f = (class_pz)var1.a(class_pz.class);
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.writeByte(this.b);
      var1.a((Enum)this.c);
      var1.writeBoolean(this.d);
      var1.writeByte(this.e);
      var1.a((Enum)this.f);
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public String a() {
      return this.a;
   }

   public class_xa.class_b_in_class_xa c() {
      return this.c;
   }

   public boolean d() {
      return this.d;
   }

   public int e() {
      return this.e;
   }

   public class_pz f() {
      return this.f;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
