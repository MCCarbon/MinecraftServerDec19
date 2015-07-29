package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_hu implements class_ff {
   private long a;
   private long b;

   public class_hu() {
   }

   public class_hu(long var1, long var3, boolean var5) {
      this.a = var1;
      this.b = var3;
      if(!var5) {
         this.b = -this.b;
         if(this.b == 0L) {
            this.b = -1L;
         }
      }

   }

   public void a(class_em var1) throws IOException {
      this.a = var1.readLong();
      this.b = var1.readLong();
   }

   public void b(class_em var1) throws IOException {
      var1.writeLong(this.a);
      var1.writeLong(this.b);
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
