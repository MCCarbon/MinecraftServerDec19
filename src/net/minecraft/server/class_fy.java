package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_fy implements class_ff {
   private String[] a;

   public class_fy() {
   }

   public class_fy(String[] var1) {
      this.a = var1;
   }

   public void a(class_em var1) throws IOException {
      this.a = new String[var1.e()];

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         this.a[var2] = var1.c(32767);
      }

   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a.length);
      String[] var2 = this.a;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         var1.a(var5);
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
