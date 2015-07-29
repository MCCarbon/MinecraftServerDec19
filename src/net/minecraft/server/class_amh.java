package net.minecraft.server;

import java.util.Arrays;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_ace;
import net.minecraft.server.class_agn;
import net.minecraft.server.class_amu;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_oz;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yd;

public class class_amh extends class_amu implements class_kn, class_oz {
   private static final int[] a = new int[]{3};
   private static final int[] f = new int[]{0, 1, 2};
   private class_aas[] g = new class_aas[4];
   private int h;
   private boolean[] i;
   private Item j;
   private String k;

   public String e_() {
      return this.l_()?this.k:"container.brewing";
   }

   public boolean l_() {
      return this.k != null && !this.k.isEmpty();
   }

   public void a(String var1) {
      this.k = var1;
   }

   public int o_() {
      return this.g.length;
   }

   public void c() {
      boolean var1 = this.n();
      boolean var2 = this.h > 0;
      if(var2) {
         --this.h;
         boolean var3 = this.h == 0;
         if(var3 && var1) {
            this.o();
            this.p_();
         } else if(!var1) {
            this.h = 0;
            this.p_();
         } else if(this.j != this.g[3].b()) {
            this.h = 0;
            this.p_();
         }
      } else if(var1) {
         this.h = 400;
         this.j = this.g[3].b();
      }

      if(!this.b.D) {
         boolean[] var6 = this.m();
         if(!Arrays.equals(var6, this.i)) {
            this.i = var6;
            IBlockData var4 = this.b.p(this.v());
            if(!(var4.getBlock() instanceof class_agn)) {
               return;
            }

            for(int var5 = 0; var5 < class_agn.a.length; ++var5) {
               var4 = var4.set(class_agn.a[var5], Boolean.valueOf(var6[var5]));
            }

            this.b.a((class_cj)this.c, (IBlockData)var4, 2);
         }
      }

   }

   public boolean[] m() {
      boolean[] var1 = new boolean[3];

      for(int var2 = 0; var2 < 3; ++var2) {
         if(this.g[var2] != null) {
            var1[var2] = true;
         }
      }

      return var1;
   }

   private boolean n() {
      if(this.g[3] != null && this.g[3].b > 0) {
         class_aas var1 = this.g[3];
         if(!class_ace.a(var1)) {
            return false;
         } else {
            for(int var2 = 0; var2 < 3; ++var2) {
               class_aas var3 = this.g[var2];
               if(var3 != null && class_ace.a(var3, var1)) {
                  return true;
               }
            }

            return false;
         }
      } else {
         return false;
      }
   }

   private void o() {
      class_aas var1 = this.g[3];

      for(int var2 = 0; var2 < 3; ++var2) {
         this.g[var2] = class_ace.d(var1, this.g[var2]);
      }

      if(var1.b().r()) {
         this.g[3] = new class_aas(var1.b().q());
      } else {
         --this.g[3].b;
         if(this.g[3].b <= 0) {
            this.g[3] = null;
         }
      }

   }

   public void a(class_dn var1) {
      super.a(var1);
      class_du var2 = var1.c("Items", 10);
      this.g = new class_aas[this.o_()];

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         class_dn var4 = var2.b(var3);
         byte var5 = var4.e("Slot");
         if(var5 >= 0 && var5 < this.g.length) {
            this.g[var5] = class_aas.a(var4);
         }
      }

      this.h = var1.f("BrewTime");
      if(var1.b("CustomName", 8)) {
         this.k = var1.k("CustomName");
      }

   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("BrewTime", (short)this.h);
      class_du var2 = new class_du();

      for(int var3 = 0; var3 < this.g.length; ++var3) {
         if(this.g[var3] != null) {
            class_dn var4 = new class_dn();
            var4.a("Slot", (byte)var3);
            this.g[var3].b(var4);
            var2.a((class_eb)var4);
         }
      }

      var1.a((String)"Items", (class_eb)var2);
      if(this.l_()) {
         var1.a("CustomName", this.k);
      }

   }

   public class_aas a(int var1) {
      return var1 >= 0 && var1 < this.g.length?this.g[var1]:null;
   }

   public class_aas a(int var1, int var2) {
      if(var1 >= 0 && var1 < this.g.length) {
         class_aas var3 = this.g[var1];
         this.g[var1] = null;
         return var3;
      } else {
         return null;
      }
   }

   public class_aas b(int var1) {
      if(var1 >= 0 && var1 < this.g.length) {
         class_aas var2 = this.g[var1];
         this.g[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, class_aas var2) {
      if(var1 >= 0 && var1 < this.g.length) {
         this.g[var1] = var2;
      }

   }

   public int q_() {
      return 64;
   }

   public boolean a(class_xa var1) {
      return this.b.s(this.c) != this?false:var1.e((double)this.c.n() + 0.5D, (double)this.c.o() + 0.5D, (double)this.c.p() + 0.5D) <= 64.0D;
   }

   public void b(class_xa var1) {
   }

   public void c(class_xa var1) {
   }

   public boolean b(int var1, class_aas var2) {
      if(var1 == 3) {
         return class_ace.a(var2);
      } else {
         Item var3 = var2.b();
         return var3 == Items.bB || var3 == Items.bD;
      }
   }

   public int[] a(class_cq var1) {
      return var1 == class_cq.b?a:f;
   }

   public boolean a(int var1, class_aas var2, class_cq var3) {
      return this.b(var1, var2);
   }

   public boolean b(int var1, class_aas var2, class_cq var3) {
      return true;
   }

   public String k() {
      return "minecraft:brewing_stand";
   }

   public class_xz a(class_wz var1, class_xa var2) {
      return new class_yd(var1, this);
   }

   public int a_(int var1) {
      switch(var1) {
      case 0:
         return this.h;
      default:
         return 0;
      }
   }

   public void b(int var1, int var2) {
      switch(var1) {
      case 0:
         this.h = var2;
      default:
      }
   }

   public int g() {
      return 1;
   }

   public void l() {
      Arrays.fill(this.g, (Object)null);
   }
}
