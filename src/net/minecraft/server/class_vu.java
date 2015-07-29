package net.minecraft.server;

import net.minecraft.server.class_aee;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vn;

public class class_vu extends class_vn {
   private final class_aee a = new class_aee() {
      public void a(int var1) {
         class_vu.this.o.a((class_pr)class_vu.this, (byte)((byte)var1));
      }

      public class_aen a() {
         return class_vu.this.o;
      }

      public class_cj b() {
         return new class_cj(class_vu.this);
      }
   };

   public class_vu(class_aen var1) {
      super(var1);
   }

   public class_vu(class_aen var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public class_vn.class_a_in_class_vn s() {
      return class_vn.class_a_in_class_vn.e;
   }

   public IBlockData u() {
      return class_agk.ac.S();
   }

   protected void a(class_dn var1) {
      super.a(var1);
      this.a.a(var1);
   }

   protected void b(class_dn var1) {
      super.b(var1);
      this.a.b(var1);
   }

   public void t_() {
      super.t_();
      this.a.c();
   }
}
