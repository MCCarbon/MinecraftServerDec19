package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_pr;

public class class_iz implements class_ff {
   private UUID a;

   public class_iz() {
   }

   public class_iz(UUID var1) {
      this.a = var1;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.g();
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public class_pr a(class_lg var1) {
      return var1.a(this.a);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
