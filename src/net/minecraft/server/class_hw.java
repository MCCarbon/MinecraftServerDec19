package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_hw implements class_ff {
   private class_aen a;
   private class_cj b;
   private class_eu[] c;

   public class_hw() {
   }

   public class_hw(class_aen var1, class_cj var2, class_eu[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = new class_eu[]{var3[0], var3[1], var3[2], var3[3]};
   }

   public void a(class_em var1) throws IOException {
      this.b = var1.c();
      this.c = new class_eu[4];

      for(int var2 = 0; var2 < 4; ++var2) {
         this.c[var2] = var1.d();
      }

   }

   public void b(class_em var1) throws IOException {
      var1.a(this.b);

      for(int var2 = 0; var2 < 4; ++var2) {
         var1.a(this.c[var2]);
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
