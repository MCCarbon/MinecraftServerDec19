package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_agh;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_rx;
import net.minecraft.server.class_uc;

public class class_sb extends class_rx {
   private final class_uc c;

   public class_sb(class_uc var1, double var2) {
      super(var1, var2, 8);
      this.c = var1;
   }

   public boolean a() {
      return this.c.cA() && !this.c.cC() && super.a();
   }

   public boolean b() {
      return super.b();
   }

   public void c() {
      super.c();
      this.c.cE().a(false);
   }

   public void d() {
      super.d();
      this.c.o(false);
   }

   public void e() {
      super.e();
      this.c.cE().a(false);
      if(!this.f()) {
         this.c.o(false);
      } else if(!this.c.cC()) {
         this.c.o(true);
      }

   }

   protected boolean a(class_aen var1, class_cj var2) {
      if(!var1.d(var2.a())) {
         return false;
      } else {
         class_anl var3 = var1.p(var2);
         class_agj var4 = var3.c();
         if(var4 == class_agk.ae) {
            class_amg var5 = var1.s(var2);
            if(var5 instanceof class_ami && ((class_ami)var5).l < 1) {
               return true;
            }
         } else {
            if(var4 == class_agk.am) {
               return true;
            }

            if(var4 == class_agk.C && var3.b(class_agh.a) != class_agh.class_a_in_class_agh.a) {
               return true;
            }
         }

         return false;
      }
   }
}
