package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_ir implements class_ff {
   private class_cj a;
   private class_cq b;
   private class_ir.class_a_in_class_ir c;

   public void a(class_em var1) throws IOException {
      this.c = (class_ir.class_a_in_class_ir)var1.a(class_ir.class_a_in_class_ir.class);
      this.a = var1.c();
      this.b = class_cq.a(var1.readUnsignedByte());
   }

   public void b(class_em var1) throws IOException {
      var1.a((Enum)this.c);
      var1.a(this.a);
      var1.writeByte(this.b.a());
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public class_cj a() {
      return this.a;
   }

   public class_cq b() {
      return this.b;
   }

   public class_ir.class_a_in_class_ir c() {
      return this.c;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }

   public static enum class_a_in_class_ir {
      a,
      b,
      c,
      d,
      e,
      f,
      g;
   }
}
