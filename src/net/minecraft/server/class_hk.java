package net.minecraft.server;

import java.io.IOException;
import java.util.List;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;
import net.minecraft.server.class_qi;

public class class_hk implements class_ff {
   private int a;
   private List b;

   public class_hk() {
   }

   public class_hk(int var1, class_qi var2, boolean var3) {
      this.a = var1;
      if(var3) {
         this.b = var2.c();
      } else {
         this.b = var2.b();
      }

   }

   public void a(class_em var1) throws IOException {
      this.a = var1.e();
      this.b = class_qi.b(var1);
   }

   public void b(class_em var1) throws IOException {
      var1.b(this.a);
      class_qi.a(this.b, var1);
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
