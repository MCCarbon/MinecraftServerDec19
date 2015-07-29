package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_nz;
import net.minecraft.server.class_oc;
import net.minecraft.server.class_on;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pt;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_vn;

public abstract class class_aee {
   private int a = 20;
   private String b = "Pig";
   private final List c = Lists.newArrayList();
   private class_aee.class_a_in_class_aee d;
   private double e;
   private double f;
   private int g = 200;
   private int h = 800;
   private int i = 4;
   private class_pr j;
   private int k = 6;
   private int l = 16;
   private int m = 4;

   private String f() {
      if(this.i() == null) {
         if(this.b != null && this.b.equals("Minecart")) {
            this.b = "MinecartRideable";
         }

         return this.b;
      } else {
         return this.i().d;
      }
   }

   public void a(String var1) {
      this.b = var1;
   }

   private boolean g() {
      class_cj var1 = this.b();
      return this.a().b((double)var1.n() + 0.5D, (double)var1.o() + 0.5D, (double)var1.p() + 0.5D, (double)this.l);
   }

   public void c() {
      if(this.g()) {
         class_cj var1 = this.b();
         double var6;
         if(this.a().D) {
            double var13 = (double)((float)var1.n() + this.a().s.nextFloat());
            double var14 = (double)((float)var1.o() + this.a().s.nextFloat());
            var6 = (double)((float)var1.p() + this.a().s.nextFloat());
            this.a().a(class_cy.l, var13, var14, var6, 0.0D, 0.0D, 0.0D, new int[0]);
            this.a().a(class_cy.A, var13, var14, var6, 0.0D, 0.0D, 0.0D, new int[0]);
            if(this.a > 0) {
               --this.a;
            }

            this.f = this.e;
            this.e = (this.e + (double)(1000.0F / ((float)this.a + 200.0F))) % 360.0D;
         } else {
            if(this.a == -1) {
               this.h();
            }

            if(this.a > 0) {
               --this.a;
               return;
            }

            boolean var2 = false;
            int var3 = 0;

            while(true) {
               if(var3 >= this.i) {
                  if(var2) {
                     this.h();
                  }
                  break;
               }

               class_pr var4 = class_pt.a(this.f(), this.a());
               if(var4 == null) {
                  return;
               }

               int var5 = this.a().a(var4.getClass(), (new class_awf((double)var1.n(), (double)var1.o(), (double)var1.p(), (double)(var1.n() + 1), (double)(var1.o() + 1), (double)(var1.p() + 1))).b((double)this.m, (double)this.m, (double)this.m)).size();
               if(var5 >= this.k) {
                  this.h();
                  return;
               }

               var6 = (double)var1.n() + (this.a().s.nextDouble() - this.a().s.nextDouble()) * (double)this.m + 0.5D;
               double var8 = (double)(var1.o() + this.a().s.nextInt(3) - 1);
               double var10 = (double)var1.p() + (this.a().s.nextDouble() - this.a().s.nextDouble()) * (double)this.m + 0.5D;
               class_qb var12 = var4 instanceof class_qb?(class_qb)var4:null;
               var4.b(var6, var8, var10, this.a().s.nextFloat() * 360.0F, 0.0F);
               if(var12 == null || var12.cf() && var12.cg()) {
                  this.a(var4, true);
                  this.a().b(2004, var1, 0);
                  if(var12 != null) {
                     var12.A();
                  }

                  var2 = true;
               }

               ++var3;
            }
         }

      }
   }

   private class_pr a(class_pr var1, boolean var2) {
      if(this.i() != null) {
         class_dn var3 = new class_dn();
         var1.d(var3);
         Iterator var4 = this.i().c.c().iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            class_eb var6 = this.i().c.b(var5);
            var3.a(var5, var6.b());
         }

         var1.f(var3);
         if(var1.o != null && var2) {
            var1.o.a(var1);
         }

         class_dn var12;
         for(class_pr var11 = var1; var3.b("Riding", 10); var3 = var12) {
            var12 = var3.n("Riding");
            class_pr var13 = class_pt.a(var12.k("id"), var1.o);
            if(var13 != null) {
               class_dn var7 = new class_dn();
               var13.d(var7);
               Iterator var8 = var12.c().iterator();

               while(var8.hasNext()) {
                  String var9 = (String)var8.next();
                  class_eb var10 = var12.b(var9);
                  var7.a(var9, var10.b());
               }

               var13.f(var7);
               var13.b(var11.s, var11.t, var11.u, var11.y, var11.z);
               if(var1.o != null && var2) {
                  var1.o.a(var13);
               }

               var11.a(var13);
            }

            var11 = var13;
         }
      } else if(var1 instanceof class_qa && var1.o != null && var2) {
         if(var1 instanceof class_qb) {
            ((class_qb)var1).a((class_on)var1.o.E(new class_cj(var1)), (class_qd)null);
         }

         var1.o.a(var1);
      }

      return var1;
   }

   private void h() {
      if(this.h <= this.g) {
         this.a = this.g;
      } else {
         int var10003 = this.h - this.g;
         this.a = this.g + this.a().s.nextInt(var10003);
      }

      if(!this.c.isEmpty()) {
         this.a((class_aee.class_a_in_class_aee)class_oc.a(this.a().s, this.c));
      }

      this.a(1);
   }

   public void a(class_dn var1) {
      this.b = var1.k("EntityId");
      this.a = var1.f("Delay");
      this.c.clear();
      if(var1.b("SpawnPotentials", 9)) {
         class_du var2 = var1.c("SpawnPotentials", 10);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            this.c.add(new class_aee.class_a_in_class_aee(var2.b(var3)));
         }
      }

      if(var1.b("SpawnData", 10)) {
         this.a(new class_aee.class_a_in_class_aee(var1.n("SpawnData"), this.b));
      } else {
         this.a((class_aee.class_a_in_class_aee)null);
      }

      if(var1.b("MinSpawnDelay", 99)) {
         this.g = var1.f("MinSpawnDelay");
         this.h = var1.f("MaxSpawnDelay");
         this.i = var1.f("SpawnCount");
      }

      if(var1.b("MaxNearbyEntities", 99)) {
         this.k = var1.f("MaxNearbyEntities");
         this.l = var1.f("RequiredPlayerRange");
      }

      if(var1.b("SpawnRange", 99)) {
         this.m = var1.f("SpawnRange");
      }

      if(this.a() != null) {
         this.j = null;
      }

   }

   public void b(class_dn var1) {
      String var2 = this.f();
      if(!class_nz.b(var2)) {
         var1.a("EntityId", var2);
         var1.a("Delay", (short)this.a);
         var1.a("MinSpawnDelay", (short)this.g);
         var1.a("MaxSpawnDelay", (short)this.h);
         var1.a("SpawnCount", (short)this.i);
         var1.a("MaxNearbyEntities", (short)this.k);
         var1.a("RequiredPlayerRange", (short)this.l);
         var1.a("SpawnRange", (short)this.m);
         if(this.i() != null) {
            var1.a("SpawnData", this.i().c.b());
         }

         if(this.i() != null || !this.c.isEmpty()) {
            class_du var3 = new class_du();
            if(!this.c.isEmpty()) {
               Iterator var4 = this.c.iterator();

               while(var4.hasNext()) {
                  class_aee.class_a_in_class_aee var5 = (class_aee.class_a_in_class_aee)var4.next();
                  var3.a((class_eb)var5.a());
               }
            } else {
               var3.a((class_eb)this.i().a());
            }

            var1.a((String)"SpawnPotentials", (class_eb)var3);
         }

      }
   }

   public boolean b(int var1) {
      if(var1 == 1 && this.a().D) {
         this.a = this.g;
         return true;
      } else {
         return false;
      }
   }

   private class_aee.class_a_in_class_aee i() {
      return this.d;
   }

   public void a(class_aee.class_a_in_class_aee var1) {
      this.d = var1;
   }

   public abstract void a(int var1);

   public abstract class_aen a();

   public abstract class_cj b();

   public class class_a_in_class_aee extends class_oc.class_a_in_class_oc {
      private final class_dn c;
      private final String d;

      public class_a_in_class_aee(class_dn var2) {
         this(var2.n("Properties"), var2.k("Type"), var2.g("Weight"));
      }

      public class_a_in_class_aee(class_dn var2, String var3) {
         this(var2, var3, 1);
      }

      private class_a_in_class_aee(class_dn var2, String var3, int var4) {
         super(var4);
         if(var3.equals("Minecart")) {
            if(var2 != null) {
               var3 = class_vn.class_a_in_class_vn.a(var2.g("Type")).b();
            } else {
               var3 = "MinecartRideable";
            }
         }

         this.c = var2;
         this.d = var3;
      }

      public class_dn a() {
         class_dn var1 = new class_dn();
         var1.a((String)"Properties", (class_eb)this.c);
         var1.a("Type", this.d);
         var1.a("Weight", this.a);
         return var1;
      }
   }
}
