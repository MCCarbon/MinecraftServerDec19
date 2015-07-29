package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aax;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_avf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_uz;
import net.minecraft.server.class_xa;

public class class_va extends class_uz {
   private static final int c = class_qi.a(class_va.class);
   private static final int d = class_qi.a(class_va.class);
   private float e = 1.0F;

   public class_va(class_aen var1) {
      super(var1);
   }

   public class_va(class_aen var1, class_cj var2, class_cq var3) {
      super(var1, var2);
      this.a((class_cq)var3);
   }

   protected void h() {
      this.H().a(c, 5);
      this.H().a(d, Byte.valueOf((byte)0));
   }

   public float ao() {
      return 0.0F;
   }

   public boolean a(class_pc var1, float var2) {
      if(this.b((class_pc)var1)) {
         return false;
      } else if(!var1.c() && this.o() != null) {
         if(!this.o.D) {
            this.a(var1.j(), false);
            this.a((class_aas)null);
         }

         return true;
      } else {
         return super.a(var1, var2);
      }
   }

   public int l() {
      return 12;
   }

   public int m() {
      return 12;
   }

   public void b(class_pr var1) {
      this.a(var1, true);
   }

   public void a(class_pr var1, boolean var2) {
      if(this.o.R().b("doEntityDrops")) {
         class_aas var3 = this.o();
         if(var1 instanceof class_xa) {
            class_xa var4 = (class_xa)var1;
            if(var4.bH.d) {
               this.b(var3);
               return;
            }
         }

         if(var2) {
            this.a(new class_aas(class_aau.bS), 0.0F);
         }

         if(var3 != null && this.V.nextFloat() < this.e) {
            var3 = var3.k();
            this.b(var3);
            this.a(var3, 0.0F);
         }

      }
   }

   private void b(class_aas var1) {
      if(var1 != null) {
         if(var1.b() == class_aau.bf) {
            class_avf var2 = ((class_aax)var1.b()).a(var1, this.o);
            var2.h.remove("frame-" + this.F());
         }

         var1.a((class_va)null);
      }
   }

   public class_aas o() {
      return this.H().f(c);
   }

   public void a(class_aas var1) {
      this.a(var1, true);
   }

   private void a(class_aas var1, boolean var2) {
      if(var1 != null) {
         var1 = var1.k();
         var1.b = 1;
         var1.a(this);
      }

      this.H().b(c, var1);
      this.H().i(c);
      if(var2 && this.a != null) {
         this.o.e(this.a, class_agk.a);
      }

   }

   public int p() {
      return this.H().a(d);
   }

   public void a(int var1) {
      this.a(var1, true);
   }

   private void a(int var1, boolean var2) {
      this.H().b(d, Byte.valueOf((byte)(var1 % 8)));
      if(var2 && this.a != null) {
         this.o.e(this.a, class_agk.a);
      }

   }

   public void b(class_dn var1) {
      if(this.o() != null) {
         var1.a((String)"Item", (class_eb)this.o().b(new class_dn()));
         var1.a("ItemRotation", (byte)this.p());
         var1.a("ItemDropChance", this.e);
      }

      super.b(var1);
   }

   public void a(class_dn var1) {
      class_dn var2 = var1.n("Item");
      if(var2 != null && !var2.c_()) {
         this.a(class_aas.a(var2), false);
         this.a(var1.e("ItemRotation"), false);
         if(var1.b("ItemDropChance", 99)) {
            this.e = var1.i("ItemDropChance");
         }

         if(var1.d("Direction")) {
            this.a(this.p() * 2, false);
         }
      }

      super.a(var1);
   }

   public boolean a(class_xa var1, class_aas var2, class_oo var3) {
      if(this.o() == null) {
         if(var2 != null && !this.o.D) {
            this.a(var2);
            if(!var1.bH.d) {
               --var2.b;
            }
         }
      } else if(!this.o.D) {
         this.a(this.p() + 1);
      }

      return true;
   }

   public int q() {
      return this.o() == null?0:this.p() % 8 + 1;
   }
}
