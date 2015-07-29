package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_hb implements class_ff {
   private int[] a;

   public class_hb() {
   }

   public class_hb(int... var1) {
      this.a = var1;
   }

   public void a(class_em var1) throws IOException {
      this.a = new int[var1.e()];

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         this.a[var2] = var1.e();
      }

   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a.length);

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         var1.b(this.a[var2]);
      }

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
