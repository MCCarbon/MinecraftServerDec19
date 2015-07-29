package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_iu implements class_ff {
   private String a;
   private class_iu.class_a_in_class_iu b;

   public void a(class_em var1) throws IOException {
      this.a = var1.c(40);
      this.b = (class_iu.class_a_in_class_iu)var1.a(class_iu.class_a_in_class_iu.class);
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.a((Enum)this.b);
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }

   public static enum class_a_in_class_iu {
      a,
      b,
      c,
      d;
   }
}
