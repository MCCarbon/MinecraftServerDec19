package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awl;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_hs implements class_ff {
   private String a = "";
   private String b = "";
   private int c;
   private class_hs.class_a_in_class_hs d;

   public class_hs() {
   }

   public class_hs(class_awl var1) {
      this.a = var1.e();
      this.b = var1.d().b();
      this.c = var1.c();
      this.d = class_hs.class_a_in_class_hs.a;
   }

   public class_hs(String var1) {
      this.a = var1;
      this.b = "";
      this.c = 0;
      this.d = class_hs.class_a_in_class_hs.b;
   }

   public class_hs(String var1, class_awj var2) {
      this.a = var1;
      this.b = var2.b();
      this.c = 0;
      this.d = class_hs.class_a_in_class_hs.b;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.c(40);
      this.d = (class_hs.class_a_in_class_hs)var1.a(class_hs.class_a_in_class_hs.class);
      this.b = var1.c(16);
      if(this.d != class_hs.class_a_in_class_hs.b) {
         this.c = var1.e();
      }

   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.a((Enum)this.d);
      var1.a(this.b);
      if(this.d != class_hs.class_a_in_class_hs.b) {
         var1.b(this.c);
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

   public static enum class_a_in_class_hs {
      a,
      b;
   }
}
