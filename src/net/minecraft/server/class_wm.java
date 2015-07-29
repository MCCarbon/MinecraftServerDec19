package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ajh;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pd;
import net.minecraft.server.class_qf;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_ru;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sw;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_wi;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;

public class class_wm extends class_wi {
   private class_wm.class_b_in_class_wm a;

   public class_wm(class_aen var1) {
      super(var1);
      this.a(0.4F, 0.3F);
      this.i.a(1, new class_rj(this));
      this.i.a(3, this.a = new class_wm.class_b_in_class_wm(this));
      this.i.a(4, new class_ru(this, class_xa.class, 1.0D, false));
      this.i.a(5, new class_wm.class_a_in_class_wm(this));
      this.bn.a(1, new class_sw(this, true, new Class[0]));
      this.bn.a(2, new class_sz(this, class_xa.class, true));
   }

   public double am() {
      return 0.2D;
   }

   public float aU() {
      return 0.1F;
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(8.0D);
      this.a(class_wl.d).a(0.25D);
      this.a(class_wl.e).a(1.0D);
   }

   protected boolean s_() {
      return false;
   }

   protected String C() {
      return "mob.silverfish.say";
   }

   protected String bp() {
      return "mob.silverfish.hit";
   }

   protected String bq() {
      return "mob.silverfish.kill";
   }

   public boolean a(class_pc var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         if(var1 instanceof class_pd || var1 == class_pc.l) {
            this.a.f();
         }

         return super.a(var1, var2);
      }
   }

   protected void a(class_cj var1, class_agj var2) {
      this.a("mob.silverfish.step", 0.15F, 1.0F);
   }

   protected class_aar D() {
      return null;
   }

   public void t_() {
      this.aL = this.y;
      super.t_();
   }

   public float a(class_cj var1) {
      return this.o.p(var1.b()).c() == class_agk.b?10.0F:super.a(var1);
   }

   protected boolean n_() {
      return true;
   }

   public boolean cf() {
      if(super.cf()) {
         class_xa var1 = this.o.a(this, 5.0D);
         return var1 == null;
      } else {
         return false;
      }
   }

   public class_qf bz() {
      return class_qf.c;
   }

   static class class_a_in_class_wm extends class_si {
      private final class_wm a;
      private class_cq b;
      private boolean c;

      public class_a_in_class_wm(class_wm var1) {
         super(var1, 1.0D, 10);
         this.a = var1;
         this.a(1);
      }

      public boolean a() {
         if(this.a.w() != null) {
            return false;
         } else if(!this.a.u().m()) {
            return false;
         } else {
            Random var1 = this.a.bd();
            if(var1.nextInt(10) == 0) {
               this.b = class_cq.a(var1);
               class_cj var2 = (new class_cj(this.a.s, this.a.t + 0.5D, this.a.u)).a(this.b);
               class_anl var3 = this.a.o.p(var2);
               if(class_ajh.d(var3)) {
                  this.c = true;
                  return true;
               }
            }

            this.c = false;
            return super.a();
         }
      }

      public boolean b() {
         return this.c?false:super.b();
      }

      public void c() {
         if(!this.c) {
            super.c();
         } else {
            class_aen var1 = this.a.o;
            class_cj var2 = (new class_cj(this.a.s, this.a.t + 0.5D, this.a.u)).a(this.b);
            class_anl var3 = var1.p(var2);
            if(class_ajh.d(var3)) {
               var1.a((class_cj)var2, (class_anl)class_agk.be.S().a(class_ajh.a, class_ajh.class_a_in_class_ajh.a(var3)), 3);
               this.a.A();
               this.a.J();
            }

         }
      }
   }

   static class class_b_in_class_wm extends class_rm {
      private class_wm a;
      private int b;

      public class_b_in_class_wm(class_wm var1) {
         this.a = var1;
      }

      public void f() {
         if(this.b == 0) {
            this.b = 20;
         }

      }

      public boolean a() {
         return this.b > 0;
      }

      public void e() {
         --this.b;
         if(this.b <= 0) {
            class_aen var1 = this.a.o;
            Random var2 = this.a.bd();
            class_cj var3 = new class_cj(this.a);

            for(int var4 = 0; var4 <= 5 && var4 >= -5; var4 = var4 <= 0?1 - var4:0 - var4) {
               for(int var5 = 0; var5 <= 10 && var5 >= -10; var5 = var5 <= 0?1 - var5:0 - var5) {
                  for(int var6 = 0; var6 <= 10 && var6 >= -10; var6 = var6 <= 0?1 - var6:0 - var6) {
                     class_cj var7 = var3.a(var5, var4, var6);
                     class_anl var8 = var1.p(var7);
                     if(var8.c() == class_agk.be) {
                        if(var1.R().b("mobGriefing")) {
                           var1.b(var7, true);
                        } else {
                           var1.a((class_cj)var7, (class_anl)((class_ajh.class_a_in_class_ajh)var8.b(class_ajh.a)).d(), 3);
                        }

                        if(var2.nextBoolean()) {
                           return;
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
