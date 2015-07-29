package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aoc;
import net.minecraft.server.class_aoe;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_avk;
import net.minecraft.server.class_avo;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_nv;
import net.minecraft.server.class_tr;

public class class_la extends class_lg {
   private class_lg a;

   public class_la(MinecraftServer var1, class_avo var2, int var3, class_lg var4, class_nv var5) {
      super(var1, var2, new class_avk(var4.Q()), var3, var5);
      this.a = var4;
      var4.ag().a(new class_aoc() {
         public void a(class_aoe var1, double var2) {
            class_la.this.ag().a(var2);
         }

         public void a(class_aoe var1, double var2, double var4, long var6) {
            class_la.this.ag().a(var2, var4, var6);
         }

         public void a(class_aoe var1, double var2, double var4) {
            class_la.this.ag().c(var2, var4);
         }

         public void a(class_aoe var1, int var2) {
            class_la.this.ag().b(var2);
         }

         public void b(class_aoe var1, int var2) {
            class_la.this.ag().c(var2);
         }

         public void b(class_aoe var1, double var2) {
            class_la.this.ag().c(var2);
         }

         public void c(class_aoe var1, double var2) {
            class_la.this.ag().b(var2);
         }
      });
   }

   protected void a() {
   }

   public class_aen b() {
      this.z = this.a.U();
      this.C = this.a.aa();
      String var1 = class_tr.a(this.t);
      class_tr var2 = (class_tr)this.z.a(class_tr.class, var1);
      if(var2 == null) {
         this.A = new class_tr(this);
         this.z.a((String)var1, (class_avd)this.A);
      } else {
         this.A = var2;
         this.A.a((class_aen)this);
      }

      return this;
   }

   public void c() {
      this.t.q();
   }
}
