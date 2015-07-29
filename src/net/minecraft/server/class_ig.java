package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_ig implements class_ff {
   private class_ig.class_a_in_class_ig a;

   public class_ig() {
   }

   public class_ig(class_ig.class_a_in_class_ig var1) {
      this.a = var1;
   }

   public void a(class_em var1) throws IOException {
      this.a = (class_ig.class_a_in_class_ig)var1.a(class_ig.class_a_in_class_ig.class);
   }

   public void b(class_em var1) throws IOException {
      var1.a((Enum)this.a);
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public class_ig.class_a_in_class_ig a() {
      return this.a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }

   public static enum class_a_in_class_ig {
      a,
      b,
      c;
   }
}
