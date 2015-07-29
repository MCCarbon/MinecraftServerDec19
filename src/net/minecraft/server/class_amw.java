package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_nu;

public class class_amw extends class_amg {
   public byte a;
   public boolean f;

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("note", this.a);
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.a = var1.e("note");
      this.a = (byte)class_nu.a(this.a, 0, 24);
   }

   public void b() {
      this.a = (byte)((this.a + 1) % 25);
      this.p_();
   }

   public void a(class_aen var1, class_cj var2) {
      if(var1.p(var2.a()).getBlock().v() == class_atk.a) {
         class_atk var3 = var1.p(var2.b()).getBlock().v();
         byte var4 = 0;
         if(var3 == class_atk.e) {
            var4 = 1;
         }

         if(var3 == class_atk.p) {
            var4 = 2;
         }

         if(var3 == class_atk.s) {
            var4 = 3;
         }

         if(var3 == class_atk.d) {
            var4 = 4;
         }

         var1.c(var2, class_agk.B, var4, this.a);
      }
   }
}
