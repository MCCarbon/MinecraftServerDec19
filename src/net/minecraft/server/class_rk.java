package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qj;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_tg;
import net.minecraft.server.class_xa;

public class class_rk extends class_rm {
   private class_qj d;
   private class_qa e;
   class_aen a;
   private double f;
   private class_tg g;
   private int h;
   float b;
   float c;
   private boolean i;

   public class_rk(class_qj var1, double var2, float var4, float var5) {
      this.d = var1;
      this.a = var1.o;
      this.f = var2;
      this.g = var1.u();
      this.c = var4;
      this.b = var5;
      this.a(3);
      if(!(var1.u() instanceof class_tf)) {
         throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
      }
   }

   public boolean a() {
      class_qa var1 = this.d.cD();
      if(var1 == null) {
         return false;
      } else if(var1 instanceof class_xa && ((class_xa)var1).v()) {
         return false;
      } else if(this.d.cC()) {
         return false;
      } else if(this.d.h(var1) < (double)(this.c * this.c)) {
         return false;
      } else {
         this.e = var1;
         return true;
      }
   }

   public boolean b() {
      return !this.g.m() && this.d.h(this.e) > (double)(this.b * this.b) && !this.d.cC();
   }

   public void c() {
      this.h = 0;
      this.i = ((class_tf)this.d.u()).e();
      ((class_tf)this.d.u()).a(false);
   }

   public void d() {
      this.e = null;
      this.g.n();
      ((class_tf)this.d.u()).a(true);
   }

   private boolean a(class_cj var1) {
      class_anl var2 = this.a.p(var1);
      class_agj var3 = var2.c();
      return var3 == class_agk.a?true:!var3.d();
   }

   public void e() {
      this.d.q().a(this.e, 10.0F, (float)this.d.cd());
      if(!this.d.cC()) {
         if(--this.h <= 0) {
            this.h = 10;
            if(!this.g.a((class_pr)this.e, this.f)) {
               if(!this.d.cq()) {
                  if(this.d.h(this.e) >= 144.0D) {
                     int var1 = class_nu.c(this.e.s) - 2;
                     int var2 = class_nu.c(this.e.u) - 2;
                     int var3 = class_nu.c(this.e.aT().b);

                     for(int var4 = 0; var4 <= 4; ++var4) {
                        for(int var5 = 0; var5 <= 4; ++var5) {
                           if((var4 < 1 || var5 < 1 || var4 > 3 || var5 > 3) && class_aen.a((class_aer)this.a, (class_cj)(new class_cj(var1 + var4, var3 - 1, var2 + var5))) && this.a(new class_cj(var1 + var4, var3, var2 + var5)) && this.a(new class_cj(var1 + var4, var3 + 1, var2 + var5))) {
                              this.d.b((double)((float)(var1 + var4) + 0.5F), (double)var3, (double)((float)(var2 + var5) + 0.5F), this.d.y, this.d.z);
                              this.g.n();
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
}
