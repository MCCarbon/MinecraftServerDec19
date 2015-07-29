package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;
import net.minecraft.server.class_oo;

public class class_jb implements class_ff {
   private class_oo a;

   public class_jb() {
   }

   public class_jb(class_oo var1) {
      this.a = var1;
   }

   public void a(class_em var1) throws IOException {
      this.a = (class_oo)var1.a(class_oo.class);
   }

   public void b(class_em var1) throws IOException {
      var1.a((Enum)this.a);
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public class_oo a() {
      return this.a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
