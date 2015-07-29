package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_hj implements class_ff {
   private int a;
   private String b;

   public class_hj() {
   }

   public class_hj(int var1, class_awj var2) {
      this.a = var1;
      if(var2 == null) {
         this.b = "";
      } else {
         this.b = var2.b();
      }

   }

   public void a(class_em var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.c(16);
   }

   public void b(class_em var1) throws IOException {
      var1.writeByte(this.a);
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
