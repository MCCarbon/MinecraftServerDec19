package net.minecraft.server;

import net.minecraft.server.class_aaq;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_abw;
import net.minecraft.server.class_aco;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aih;
import net.minecraft.server.class_amu;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oz;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yk;
import net.minecraft.server.class_yl;
import net.minecraft.server.class_zg;
import net.minecraft.server.class_zv;

public class class_amr extends class_amu implements class_kn, class_oz {
   private static final int[] a = new int[]{0};
   private static final int[] f = new int[]{2, 1};
   private static final int[] g = new int[]{1};
   private class_aas[] h = new class_aas[3];
   private int i;
   private int j;
   private int k;
   private int l;
   private String m;

   public int o_() {
      return this.h.length;
   }

   public class_aas a(int var1) {
      return this.h[var1];
   }

   public class_aas a(int var1, int var2) {
      if(this.h[var1] != null) {
         class_aas var3;
         if(this.h[var1].b <= var2) {
            var3 = this.h[var1];
            this.h[var1] = null;
            return var3;
         } else {
            var3 = this.h[var1].a(var2);
            if(this.h[var1].b == 0) {
               this.h[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public class_aas b(int var1) {
      if(this.h[var1] != null) {
         class_aas var2 = this.h[var1];
         this.h[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, class_aas var2) {
      boolean var3 = var2 != null && var2.a(this.h[var1]) && class_aas.a(var2, this.h[var1]);
      this.h[var1] = var2;
      if(var2 != null && var2.b > this.q_()) {
         var2.b = this.q_();
      }

      if(var1 == 0 && !var3) {
         this.l = this.a(var2);
         this.k = 0;
         this.p_();
      }

   }

   public String e_() {
      return this.l_()?this.m:"container.furnace";
   }

   public boolean l_() {
      return this.m != null && !this.m.isEmpty();
   }

   public void a(String var1) {
      this.m = var1;
   }

   public void a(class_dn var1) {
      super.a(var1);
      class_du var2 = var1.c("Items", 10);
      this.h = new class_aas[this.o_()];

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         class_dn var4 = var2.b(var3);
         byte var5 = var4.e("Slot");
         if(var5 >= 0 && var5 < this.h.length) {
            this.h[var5] = class_aas.a(var4);
         }
      }

      this.i = var1.f("BurnTime");
      this.k = var1.f("CookTime");
      this.l = var1.f("CookTimeTotal");
      this.j = b(this.h[1]);
      if(var1.b("CustomName", 8)) {
         this.m = var1.k("CustomName");
      }

   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("BurnTime", (short)this.i);
      var1.a("CookTime", (short)this.k);
      var1.a("CookTimeTotal", (short)this.l);
      class_du var2 = new class_du();

      for(int var3 = 0; var3 < this.h.length; ++var3) {
         if(this.h[var3] != null) {
            class_dn var4 = new class_dn();
            var4.a("Slot", (byte)var3);
            this.h[var3].b(var4);
            var2.a((class_eb)var4);
         }
      }

      var1.a((String)"Items", (class_eb)var2);
      if(this.l_()) {
         var1.a("CustomName", this.m);
      }

   }

   public int q_() {
      return 64;
   }

   public boolean m() {
      return this.i > 0;
   }

   public void c() {
      boolean var1 = this.m();
      boolean var2 = false;
      if(this.m()) {
         --this.i;
      }

      if(!this.b.D) {
         if(!this.m() && (this.h[1] == null || this.h[0] == null)) {
            if(!this.m() && this.k > 0) {
               this.k = class_nu.a(this.k - 2, 0, this.l);
            }
         } else {
            if(!this.m() && this.o()) {
               this.j = this.i = b(this.h[1]);
               if(this.m()) {
                  var2 = true;
                  if(this.h[1] != null) {
                     --this.h[1].b;
                     if(this.h[1].b == 0) {
                        class_aar var3 = this.h[1].b().q();
                        this.h[1] = var3 != null?new class_aas(var3):null;
                     }
                  }
               }
            }

            if(this.m() && this.o()) {
               ++this.k;
               if(this.k == this.l) {
                  this.k = 0;
                  this.l = this.a(this.h[0]);
                  this.n();
                  var2 = true;
               }
            } else {
               this.k = 0;
            }
         }

         if(var1 != this.m()) {
            var2 = true;
            class_aih.a(this.m(), this.b, this.c);
         }
      }

      if(var2) {
         this.p_();
      }

   }

   public int a(class_aas var1) {
      return 200;
   }

   private boolean o() {
      if(this.h[0] == null) {
         return false;
      } else {
         class_aas var1 = class_aco.a().a(this.h[0]);
         return var1 == null?false:(this.h[2] == null?true:(!this.h[2].a(var1)?false:(this.h[2].b < this.q_() && this.h[2].b < this.h[2].c()?true:this.h[2].b < var1.c())));
      }
   }

   public void n() {
      if(this.o()) {
         class_aas var1 = class_aco.a().a(this.h[0]);
         if(this.h[2] == null) {
            this.h[2] = var1.k();
         } else if(this.h[2].b() == var1.b()) {
            ++this.h[2].b;
         }

         if(this.h[0].b() == class_aar.a(class_agk.v) && this.h[0].i() == 1 && this.h[1] != null && this.h[1].b() == class_aau.ay) {
            this.h[1] = new class_aas(class_aau.az);
         }

         --this.h[0].b;
         if(this.h[0].b <= 0) {
            this.h[0] = null;
         }

      }
   }

   public static int b(class_aas var0) {
      if(var0 == null) {
         return 0;
      } else {
         class_aar var1 = var0.b();
         if(var1 instanceof class_zg && Block.a(var1) != class_agk.a) {
            Block var2 = Block.a(var1);
            if(var2 == class_agk.bM) {
               return 150;
            }

            if(var2.v() == class_atk.d) {
               return 300;
            }

            if(var2 == class_agk.cA) {
               return 16000;
            }
         }

         return var1 instanceof class_zv && ((class_zv)var1).h().equals("WOOD")?200:(var1 instanceof class_abw && ((class_abw)var1).h().equals("WOOD")?200:(var1 instanceof class_aaq && ((class_aaq)var1).g().equals("WOOD")?200:(var1 == class_aau.A?100:(var1 == class_aau.j?1600:(var1 == class_aau.aA?20000:(var1 == class_aar.a(class_agk.g)?100:(var1 == class_aau.bx?2400:0)))))));
      }
   }

   public static boolean c(class_aas var0) {
      return b(var0) > 0;
   }

   public boolean a(class_xa var1) {
      return this.b.s(this.c) != this?false:var1.e((double)this.c.n() + 0.5D, (double)this.c.o() + 0.5D, (double)this.c.p() + 0.5D) <= 64.0D;
   }

   public void b(class_xa var1) {
   }

   public void c(class_xa var1) {
   }

   public boolean b(int var1, class_aas var2) {
      return var1 == 2?false:(var1 != 1?true:c(var2) || class_yk.c_(var2));
   }

   public int[] a(class_cq var1) {
      return var1 == class_cq.a?f:(var1 == class_cq.b?a:g);
   }

   public boolean a(int var1, class_aas var2, class_cq var3) {
      return this.b(var1, var2);
   }

   public boolean b(int var1, class_aas var2, class_cq var3) {
      if(var3 == class_cq.a && var1 == 1) {
         class_aar var4 = var2.b();
         if(var4 != class_aau.az && var4 != class_aau.ay) {
            return false;
         }
      }

      return true;
   }

   public String k() {
      return "minecraft:furnace";
   }

   public class_xz a(class_wz var1, class_xa var2) {
      return new class_yl(var1, this);
   }

   public int a_(int var1) {
      switch(var1) {
      case 0:
         return this.i;
      case 1:
         return this.j;
      case 2:
         return this.k;
      case 3:
         return this.l;
      default:
         return 0;
      }
   }

   public void b(int var1, int var2) {
      switch(var1) {
      case 0:
         this.i = var2;
         break;
      case 1:
         this.j = var2;
         break;
      case 2:
         this.k = var2;
         break;
      case 3:
         this.l = var2;
      }

   }

   public int g() {
      return 4;
   }

   public void l() {
      for(int var1 = 0; var1 < this.h.length; ++var1) {
         this.h[var1] = null;
      }

   }
}
