package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_is implements class_ff {
   private int a;
   private class_is.class_a_in_class_is b;
   private int c;

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.b = (class_is.class_a_in_class_is)var1.a(class_is.class_a_in_class_is.class);
      this.c = var1.e();
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      var1.a((Enum)this.b);
      var1.b(this.c);
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public class_is.class_a_in_class_is b() {
      return this.b;
   }

   public int c() {
      return this.c;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }

   public static enum class_a_in_class_is {
      a,
      b,
      c,
      d,
      e,
      f,
      g;
   }
}
