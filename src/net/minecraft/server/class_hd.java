package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_hd implements class_ff {
   private String a;
   private String b;

   public class_hd() {
   }

   public class_hd(String var1, String var2) {
      this.a = var1;
      this.b = var2;
      if(var2.length() > 40) {
         throw new IllegalArgumentException("Hash is too long (max 40, was " + var2.length() + ")");
      }
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.c(32767);
      this.b = var1.c(40);
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.a(this.b);
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
