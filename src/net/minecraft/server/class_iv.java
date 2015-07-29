package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_iv implements class_ff {
   private int a;

   public void a(class_em var1) throws IOException {
      this.a = var1.readShort();
   }

   public void b(class_em var1) throws IOException {
      var1.writeShort(this.a);
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public int a() {
      return this.a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
