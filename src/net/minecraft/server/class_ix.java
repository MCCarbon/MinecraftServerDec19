package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_ix implements class_ff {
   private class_cj a;
   private class_eu[] b;

   public void a(class_em var1) throws IOException {
      this.a = var1.c();
      this.b = new class_eu[4];

      for(int var2 = 0; var2 < 4; ++var2) {
         String var3 = var1.c(384);
         class_eu var4 = class_eu.class_a_in_class_eu.a(var3);
         this.b[var2] = var4;
      }

   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);

      for(int var2 = 0; var2 < 4; ++var2) {
         class_eu var3 = this.b[var2];
         String var4 = class_eu.class_a_in_class_eu.a(var3);
         var1.a(var4);
      }

   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public class_cj a() {
      return this.a;
   }

   public class_eu[] b() {
      return this.b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
