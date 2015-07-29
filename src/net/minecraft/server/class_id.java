package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;
import org.apache.commons.lang3.StringUtils;

public class class_id implements class_ff {
   private String a;
   private class_cj b;

   public class_id() {
   }

   public class_id(String var1) {
      this(var1, (class_cj)null);
   }

   public class_id(String var1, class_cj var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(class_em var1) throws IOException {
      this.a = var1.c(32767);
      boolean var2 = var1.readBoolean();
      if(var2) {
         this.b = var1.c();
      }

   }

   public void b(class_em var1) throws IOException {
      var1.a(StringUtils.substring(this.a, 0, 32767));
      boolean var2 = this.b != null;
      var1.writeBoolean(var2);
      if(var2) {
         var1.a(this.b);
      }

   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public String a() {
      return this.a;
   }

   public class_cj b() {
      return this.b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
