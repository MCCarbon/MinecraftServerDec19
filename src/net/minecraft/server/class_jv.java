package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ju;

public class class_jv implements class_ff {
   private long a;

   public void a(class_em var1) throws IOException {
      this.a = var1.readLong();
   }

   public void b(class_em var1) throws IOException {
      var1.writeLong(this.a);
   }

   public void a(class_ju var1) {
      var1.a(this);
   }

   public long a() {
      return this.a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ju)var1);
   }
}
