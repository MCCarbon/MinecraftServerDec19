package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.class_aeu;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_on;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_tp;
import net.minecraft.server.class_wr;
import net.minecraft.server.class_xa;

public class class_tq {
   private World a;
   private boolean b;
   private int c = -1;
   private int d;
   private int e;
   private class_tp f;
   private int g;
   private int h;
   private int i;

   public class_tq(World var1) {
      this.a = var1;
   }

   public void a() {
      if(this.a.x()) {
         this.c = 0;
      } else if(this.c != 2) {
         if(this.c == 0) {
            float var1 = this.a.c(0.0F);
            if((double)var1 < 0.5D || (double)var1 > 0.501D) {
               return;
            }

            this.c = this.a.s.nextInt(10) == 0?1:2;
            this.b = false;
            if(this.c == 2) {
               return;
            }
         }

         if(this.c != -1) {
            if(!this.b) {
               if(!this.b()) {
                  return;
               }

               this.b = true;
            }

            if(this.e > 0) {
               --this.e;
            } else {
               this.e = 2;
               if(this.d > 0) {
                  this.c();
                  --this.d;
               } else {
                  this.c = 2;
               }

            }
         }
      }
   }

   private boolean b() {
      List var1 = this.a.j;
      Iterator var2 = var1.iterator();

      class_awh var11;
      do {
         do {
            do {
               do {
                  do {
                     class_xa var3;
                     do {
                        if(!var2.hasNext()) {
                           return false;
                        }

                        var3 = (class_xa)var2.next();
                     } while(var3.v());

                     this.f = this.a.af().a(new class_cj(var3), 1);
                  } while(this.f == null);
               } while(this.f.c() < 10);
            } while(this.f.d() < 20);
         } while(this.f.e() < 20);

         class_cj var4 = this.f.a();
         float var5 = (float)this.f.b();
         boolean var6 = false;

         for(int var7 = 0; var7 < 10; ++var7) {
            float var8 = this.a.s.nextFloat() * 3.1415927F * 2.0F;
            this.g = var4.n() + (int)((double)(class_nu.b(var8) * var5) * 0.9D);
            this.h = var4.o();
            this.i = var4.p() + (int)((double)(class_nu.a(var8) * var5) * 0.9D);
            var6 = false;
            Iterator var9 = this.a.af().b().iterator();

            while(var9.hasNext()) {
               class_tp var10 = (class_tp)var9.next();
               if(var10 != this.f && var10.a(new class_cj(this.g, this.h, this.i))) {
                  var6 = true;
                  break;
               }
            }

            if(!var6) {
               break;
            }
         }

         if(var6) {
            return false;
         }

         var11 = this.a(new class_cj(this.g, this.h, this.i));
      } while(var11 == null);

      this.e = 0;
      this.d = 20;
      return true;
   }

   private boolean c() {
      class_awh var1 = this.a(new class_cj(this.g, this.h, this.i));
      if(var1 == null) {
         return false;
      } else {
         class_wr var2;
         try {
            var2 = new class_wr(this.a);
            var2.a((class_on)this.a.E(new class_cj(var2)), (class_qd)null);
            var2.n(false);
         } catch (Exception var4) {
            var4.printStackTrace();
            return false;
         }

         var2.b(var1.a, var1.b, var1.c, this.a.s.nextFloat() * 360.0F, 0.0F);
         this.a.a((class_pr)var2);
         class_cj var3 = this.f.a();
         var2.a(var3, this.f.b());
         return true;
      }
   }

   private class_awh a(class_cj var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         class_cj var3 = var1.a(this.a.s.nextInt(16) - 8, this.a.s.nextInt(6) - 3, this.a.s.nextInt(16) - 8);
         if(this.f.a(var3) && class_aeu.a(class_qb.class_a_in_class_qb.a, this.a, var3)) {
            return new class_awh((double)var3.n(), (double)var3.o(), (double)var3.p());
         }
      }

      return null;
   }
}
