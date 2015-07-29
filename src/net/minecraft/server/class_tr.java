package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahl;
import net.minecraft.server.class_aoy;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_to;
import net.minecraft.server.class_tp;

public class class_tr extends class_avd {
   private class_aen b;
   private final List c = Lists.newArrayList();
   private final List d = Lists.newArrayList();
   private final List e = Lists.newArrayList();
   private int f;

   public class_tr(String var1) {
      super(var1);
   }

   public class_tr(class_aen var1) {
      super(a(var1.t));
      this.b = var1;
      this.c();
   }

   public void a(class_aen var1) {
      this.b = var1;
      Iterator var2 = this.e.iterator();

      while(var2.hasNext()) {
         class_tp var3 = (class_tp)var2.next();
         var3.a(var1);
      }

   }

   public void a(class_cj var1) {
      if(this.c.size() <= 64) {
         if(!this.e(var1)) {
            this.c.add(var1);
         }

      }
   }

   public void a() {
      ++this.f;
      Iterator var1 = this.e.iterator();

      while(var1.hasNext()) {
         class_tp var2 = (class_tp)var1.next();
         var2.a(this.f);
      }

      this.e();
      this.f();
      this.g();
      if(this.f % 400 == 0) {
         this.c();
      }

   }

   private void e() {
      Iterator var1 = this.e.iterator();

      while(var1.hasNext()) {
         class_tp var2 = (class_tp)var1.next();
         if(var2.g()) {
            var1.remove();
            this.c();
         }
      }

   }

   public List b() {
      return this.e;
   }

   public class_tp a(class_cj var1, int var2) {
      class_tp var3 = null;
      double var4 = 3.4028234663852886E38D;
      Iterator var6 = this.e.iterator();

      while(var6.hasNext()) {
         class_tp var7 = (class_tp)var6.next();
         double var8 = var7.a().i(var1);
         if(var8 < var4) {
            float var10 = (float)(var2 + var7.b());
            if(var8 <= (double)(var10 * var10)) {
               var3 = var7;
               var4 = var8;
            }
         }
      }

      return var3;
   }

   private void f() {
      if(!this.c.isEmpty()) {
         this.b((class_cj)this.c.remove(0));
      }
   }

   private void g() {
      for(int var1 = 0; var1 < this.d.size(); ++var1) {
         class_to var2 = (class_to)this.d.get(var1);
         class_tp var3 = this.a(var2.d(), 32);
         if(var3 == null) {
            var3 = new class_tp(this.b);
            this.e.add(var3);
            this.c();
         }

         var3.a(var2);
      }

      this.d.clear();
   }

   private void b(class_cj var1) {
      byte var2 = 16;
      byte var3 = 4;
      byte var4 = 16;

      for(int var5 = -var2; var5 < var2; ++var5) {
         for(int var6 = -var3; var6 < var3; ++var6) {
            for(int var7 = -var4; var7 < var4; ++var7) {
               class_cj var8 = var1.a(var5, var6, var7);
               if(this.f(var8)) {
                  class_to var9 = this.c(var8);
                  if(var9 == null) {
                     this.d(var8);
                  } else {
                     var9.a(this.f);
                  }
               }
            }
         }
      }

   }

   private class_to c(class_cj var1) {
      Iterator var2 = this.d.iterator();

      class_to var3;
      do {
         if(!var2.hasNext()) {
            var2 = this.e.iterator();

            class_to var4;
            do {
               if(!var2.hasNext()) {
                  return null;
               }

               class_tp var5 = (class_tp)var2.next();
               var4 = var5.e(var1);
            } while(var4 == null);

            return var4;
         }

         var3 = (class_to)var2.next();
      } while(var3.d().n() != var1.n() || var3.d().p() != var1.p() || Math.abs(var3.d().o() - var1.o()) > 1);

      return var3;
   }

   private void d(class_cj var1) {
      class_cq var2 = class_ahl.h(this.b, var1);
      class_cq var3 = var2.d();
      int var4 = this.a(var1, var2, 5);
      int var5 = this.a(var1, var3, var4 + 1);
      if(var4 != var5) {
         this.d.add(new class_to(var1, var4 < var5?var2:var3, this.f));
      }

   }

   private int a(class_cj var1, class_cq var2, int var3) {
      int var4 = 0;

      for(int var5 = 1; var5 <= 5; ++var5) {
         if(this.b.i(var1.a(var2, var5))) {
            ++var4;
            if(var4 >= var3) {
               return var4;
            }
         }
      }

      return var4;
   }

   private boolean e(class_cj var1) {
      Iterator var2 = this.c.iterator();

      class_cj var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (class_cj)var2.next();
      } while(!var3.equals(var1));

      return true;
   }

   private boolean f(class_cj var1) {
      Block var2 = this.b.p(var1).getBlock();
      return var2 instanceof class_ahl?var2.v() == class_atk.d:false;
   }

   public void a(class_dn var1) {
      this.f = var1.g("Tick");
      class_du var2 = var1.c("Villages", 10);

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         class_dn var4 = var2.b(var3);
         class_tp var5 = new class_tp();
         var5.a(var4);
         this.e.add(var5);
      }

   }

   public void b(class_dn var1) {
      var1.a("Tick", this.f);
      class_du var2 = new class_du();
      Iterator var3 = this.e.iterator();

      while(var3.hasNext()) {
         class_tp var4 = (class_tp)var3.next();
         class_dn var5 = new class_dn();
         var4.b(var5);
         var2.a((class_eb)var5);
      }

      var1.a((String)"Villages", (class_eb)var2);
   }

   public static String a(class_aoy var0) {
      return "villages" + var0.p().c();
   }
}
