package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_pr;

public class class_ang extends class_amg implements class_kn {
   private class_anl a;
   private class_cq f;
   private boolean g;
   private boolean h;
   private float i;
   private float j;
   private List k = Lists.newArrayList();

   public class_ang() {
   }

   public class_ang(class_anl var1, class_cq var2, boolean var3, boolean var4) {
      this.a = var1;
      this.f = var2;
      this.g = var3;
      this.h = var4;
   }

   public class_anl b() {
      return this.a;
   }

   public int u() {
      return 0;
   }

   public boolean d() {
      return this.g;
   }

   public class_cq e() {
      return this.f;
   }

   public float a(float var1) {
      if(var1 > 1.0F) {
         var1 = 1.0F;
      }

      return this.j + (this.i - this.j) * var1;
   }

   private void a(float var1, float var2) {
      if(this.g) {
         var1 = 1.0F - var1;
      } else {
         --var1;
      }

      class_awf var3 = class_agk.M.a(this.b, this.c, this.a, var1, this.f);
      if(var3 != null) {
         List var4 = this.b.b((class_pr)null, (class_awf)var3);
         if(!var4.isEmpty()) {
            this.k.addAll(var4);
            Iterator var5 = this.k.iterator();

            while(true) {
               while(var5.hasNext()) {
                  class_pr var6 = (class_pr)var5.next();
                  if(this.a.c() == class_agk.cE && this.g) {
                     switch(class_ang.SyntheticClass_1.a[this.f.k().ordinal()]) {
                     case 1:
                        var6.v = (double)this.f.g();
                        break;
                     case 2:
                        var6.w = (double)this.f.h();
                        break;
                     case 3:
                        var6.x = (double)this.f.i();
                     }
                  } else {
                     var6.d((double)(var2 * (float)this.f.g()), (double)(var2 * (float)this.f.h()), (double)(var2 * (float)this.f.i()));
                  }
               }

               this.k.clear();
               break;
            }
         }
      }

   }

   public void h() {
      if(this.j < 1.0F && this.b != null) {
         this.j = this.i = 1.0F;
         this.b.t(this.c);
         this.y();
         if(this.b.p(this.c).c() == class_agk.M) {
            this.b.a((class_cj)this.c, (class_anl)this.a, 3);
            this.b.d(this.c, this.a.c());
         }
      }

   }

   public void c() {
      this.j = this.i;
      if(this.j >= 1.0F) {
         this.a(1.0F, 0.25F);
         this.b.t(this.c);
         this.y();
         if(this.b.p(this.c).c() == class_agk.M) {
            this.b.a((class_cj)this.c, (class_anl)this.a, 3);
            this.b.d(this.c, this.a.c());
         }

      } else {
         this.i += 0.5F;
         if(this.i >= 1.0F) {
            this.i = 1.0F;
         }

         if(this.g) {
            this.a(this.i, this.i - this.j + 0.0625F);
         }

      }
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.a = class_agj.c(var1.g("blockId")).a(var1.g("blockData"));
      this.f = class_cq.a(var1.g("facing"));
      this.j = this.i = var1.i("progress");
      this.g = var1.o("extending");
   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("blockId", class_agj.a(this.a.c()));
      var1.a("blockData", this.a.c().c(this.a));
      var1.a("facing", this.f.a());
      var1.a("progress", this.j);
      var1.a("extending", this.g);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_cq.class_a_in_class_cq.values().length];

      static {
         try {
            a[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_cq.class_a_in_class_cq.b.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.class_a_in_class_cq.c.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
