package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_ie implements class_ff {
   private String a;

   public class_ie() {
   }

   public class_ie(String var1) {
      if(var1.length() > 100) {
         var1 = var1.substring(0, 100);
      }

      this.a = var1;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.c(100);
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public String a() {
      return this.a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
