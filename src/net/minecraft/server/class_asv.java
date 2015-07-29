package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amz;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_asu;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_df;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dp;
import net.minecraft.server.class_dt;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pt;
import net.minecraft.server.class_vc;
import net.minecraft.server.class_xa;

public class class_asv {
   private final List a = Lists.newArrayList();
   private final List b = Lists.newArrayList();
   private class_cj c = new class_cj(0, 0, 0);
   private String d = "?";

   public class_cj a() {
      return this.c;
   }

   public void a(String var1) {
      this.d = var1;
   }

   public String b() {
      return this.d;
   }

   public void a(class_aen var1, class_cj var2, class_cj var3, boolean var4) {
      if(var3.n() >= 1 && var3.o() >= 1 && var3.p() >= 1) {
         class_cj var5 = var2.a((class_df)var3).a(-1, -1, -1);
         ArrayList var6 = Lists.newArrayList();
         ArrayList var7 = Lists.newArrayList();
         ArrayList var8 = Lists.newArrayList();
         class_cj var9 = new class_cj(Math.min(var2.n(), var5.n()), Math.min(var2.o(), var5.o()), Math.min(var2.p(), var5.p()));
         class_cj var10 = new class_cj(Math.max(var2.n(), var5.n()), Math.max(var2.o(), var5.o()), Math.max(var2.p(), var5.p()));
         this.c = var3;
         Iterator var11 = class_cj.b(var9, var10).iterator();

         while(true) {
            while(var11.hasNext()) {
               class_cj.class_a_in_class_cj var12 = (class_cj.class_a_in_class_cj)var11.next();
               class_cj var13 = var12.b(var9);
               class_anl var14 = var1.p(var12);
               class_amg var15 = var1.s(var12);
               if(var15 != null) {
                  class_dn var16 = new class_dn();
                  var15.b(var16);
                  var16.p("x");
                  var16.p("y");
                  var16.p("z");
                  var7.add(new class_asv.class_a_in_class_asv(var13, var14, var16, null));
               } else if(!var14.c().q() && !var14.c().d()) {
                  var8.add(new class_asv.class_a_in_class_asv(var13, var14, (class_dn)null, null));
               } else {
                  var6.add(new class_asv.class_a_in_class_asv(var13, var14, (class_dn)null, null));
               }
            }

            this.a.clear();
            this.a.addAll(var6);
            this.a.addAll(var7);
            this.a.addAll(var8);
            if(var4) {
               this.a(var1, var9, var10.a(1, 1, 1));
            } else {
               this.b.clear();
            }

            return;
         }
      }
   }

   private void a(class_aen var1, class_cj var2, class_cj var3) {
      List var4 = var1.a(class_pr.class, new class_awf(var2, var3), new Predicate() {
         public boolean a(class_pr var1) {
            return !(var1 instanceof class_xa);
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_pr)var1);
         }
      });
      this.b.clear();

      class_awh var7;
      class_dn var8;
      class_cj var9;
      for(Iterator var5 = var4.iterator(); var5.hasNext(); this.b.add(new class_asv.class_b_in_class_asv(var7, var9, var8, null))) {
         class_pr var6 = (class_pr)var5.next();
         var7 = new class_awh(var6.s - (double)var2.n(), var6.t - (double)var2.o(), var6.u - (double)var2.p());
         var8 = new class_dn();
         var6.d(var8);
         if(var6 instanceof class_vc) {
            var9 = ((class_vc)var6).n().b(var2);
         } else {
            var9 = new class_cj(var7);
         }
      }

   }

   public Map a(class_cj var1, class_asu var2) {
      HashMap var3 = Maps.newHashMap();
      class_arw var4 = var2.g();
      Iterator var5 = this.a.iterator();

      while(true) {
         class_asv.class_a_in_class_asv var6;
         class_cj var7;
         do {
            if(!var5.hasNext()) {
               return var3;
            }

            var6 = (class_asv.class_a_in_class_asv)var5.next();
            var7 = this.a(var2, var6.a).a((class_df)var1);
         } while(var4 != null && !var4.b((class_df)var7));

         class_anl var8 = var6.b;
         if(var8.c() == class_agk.dc && var6.c != null) {
            class_amz.class_a_in_class_amz var9 = class_amz.class_a_in_class_amz.valueOf(var6.c.k("mode"));
            if(var9 == class_amz.class_a_in_class_amz.d) {
               var3.put(var7, var6.c.k("metadata"));
            }
         }
      }
   }

   public class_cj a(class_asu var1, class_cj var2, class_asv var3, class_asu var4, class_cj var5) {
      class_cj var6 = this.a(var1, var2);
      class_cj var7 = var3.a(var4, var5);
      return var6.b(var7);
   }

   public class_cj a(class_asu var1, class_cj var2) {
      return this.a(var2, var1.b(), var1.c());
   }

   public void a(class_aen var1, class_cj var2, class_asu var3) {
      var3.i();
      this.b(var1, var2, var3);
   }

   public void b(class_aen var1, class_cj var2, class_asu var3) {
      if(!this.a.isEmpty() && this.c.n() >= 1 && this.c.o() >= 1 && this.c.p() >= 1) {
         class_arw var4 = var3.g();
         Iterator var5 = this.a.iterator();

         while(true) {
            class_asv.class_a_in_class_asv var6;
            class_agj var7;
            class_cj var8;
            do {
               do {
                  do {
                     if(!var5.hasNext()) {
                        var5 = this.a.iterator();

                        while(true) {
                           class_cj var12;
                           do {
                              do {
                                 if(!var5.hasNext()) {
                                    if(!var3.e()) {
                                       this.a(var1, var2, var3.b(), var3.c(), var4);
                                    }

                                    return;
                                 }

                                 var6 = (class_asv.class_a_in_class_asv)var5.next();
                              } while(var3.f() && var6.b.c() == class_agk.a);

                              var12 = this.a(var3, var6.a).a((class_df)var2);
                           } while(var4 != null && !var4.b((class_df)var12));

                           var1.b(var12, var6.b.c());
                           if(var6.c != null) {
                              class_amg var13 = var1.s(var12);
                              if(var13 != null) {
                                 var13.p_();
                              }
                           }
                        }
                     }

                     var6 = (class_asv.class_a_in_class_asv)var5.next();
                     var7 = var6.b.c();
                  } while(var3.f() && var7 == class_agk.a);
               } while(var3.h() && var7 == class_agk.dc);

               var8 = this.a(var3, var6.a).a((class_df)var2);
            } while(var4 != null && !var4.b((class_df)var8));

            class_anl var9 = var7.a(var6.b, var3.b());
            class_anl var10 = var7.a(var9, var3.c());
            class_amg var11;
            if(var6.c != null) {
               var11 = var1.s(var8);
               if(var11 != null) {
                  if(var11 instanceof class_oj) {
                     ((class_oj)var11).l();
                  }

                  var1.a((class_cj)var8, (class_anl)class_agk.cv.S(), 4);
               }
            }

            if(var1.a((class_cj)var8, (class_anl)var10, 2) && var6.c != null) {
               var11 = var1.s(var8);
               if(var11 != null) {
                  var6.c.a("x", var8.n());
                  var6.c.a("y", var8.o());
                  var6.c.a("z", var8.p());
                  var11.a(var6.c);
               }
            }
         }
      }
   }

   private void a(class_aen var1, class_cj var2, class_agj.class_a_in_class_agj var3, class_agj.class_c_in_class_agj var4, class_arw var5) {
      Iterator var6 = this.b.iterator();

      while(true) {
         class_asv.class_b_in_class_asv var7;
         class_cj var8;
         do {
            if(!var6.hasNext()) {
               return;
            }

            var7 = (class_asv.class_b_in_class_asv)var6.next();
            var8 = this.a(var7.b, var3, var4).a((class_df)var2);
         } while(var5 != null && !var5.b((class_df)var8));

         class_dn var9 = var7.c;
         class_awh var10 = this.a(var7.a, var3, var4);
         class_awh var11 = var10.b((double)var2.n(), (double)var2.o(), (double)var2.p());
         class_du var12 = new class_du();
         var12.a((class_eb)(new class_dp(var11.a)));
         var12.a((class_eb)(new class_dp(var11.b)));
         var12.a((class_eb)(new class_dp(var11.c)));
         var9.a((String)"Pos", (class_eb)var12);
         UUID var13 = UUID.randomUUID();
         var9.a("UUIDMost", var13.getMostSignificantBits());
         var9.a("UUIDLeast", var13.getLeastSignificantBits());

         class_pr var14;
         try {
            var14 = class_pt.a(var9, var1);
         } catch (Exception var16) {
            var14 = null;
         }

         if(var14 != null) {
            if(var14 instanceof class_vc) {
               var14.a(var3);
               var14.a(var4);
               var14.b((double)var8.n(), (double)var8.o(), (double)var8.p());
               var14.b(var11.a, var11.b, var11.c, var14.y, var14.z);
            } else {
               float var15 = var14.a(var3);
               var15 += var14.y - var14.a(var4);
               var14.b(var11.a, var11.b, var11.c, var15, var14.z);
            }

            var1.a(var14);
         }
      }
   }

   public class_cj a(class_agj.class_c_in_class_agj var1) {
      switch(class_asv.SyntheticClass_1.a[var1.ordinal()]) {
      case 1:
      case 2:
         return new class_cj(this.c.p(), this.c.o(), this.c.n());
      default:
         return this.c;
      }
   }

   private class_cj a(class_cj var1, class_agj.class_a_in_class_agj var2, class_agj.class_c_in_class_agj var3) {
      int var4 = var1.n();
      int var5 = var1.o();
      int var6 = var1.p();
      boolean var7 = true;
      switch(class_asv.SyntheticClass_1.b[var2.ordinal()]) {
      case 1:
         var6 = -var6;
         break;
      case 2:
         var4 = -var4;
         break;
      default:
         var7 = false;
      }

      switch(class_asv.SyntheticClass_1.a[var3.ordinal()]) {
      case 1:
         return new class_cj(var6, var5, -var4);
      case 2:
         return new class_cj(-var6, var5, var4);
      case 3:
         return new class_cj(-var4, var5, -var6);
      default:
         return var7?new class_cj(var4, var5, var6):var1;
      }
   }

   private class_awh a(class_awh var1, class_agj.class_a_in_class_agj var2, class_agj.class_c_in_class_agj var3) {
      double var4 = var1.a;
      double var6 = var1.b;
      double var8 = var1.c;
      boolean var10 = true;
      switch(class_asv.SyntheticClass_1.b[var2.ordinal()]) {
      case 1:
         var8 = 1.0D - var8;
         break;
      case 2:
         var4 = 1.0D - var4;
         break;
      default:
         var10 = false;
      }

      switch(class_asv.SyntheticClass_1.a[var3.ordinal()]) {
      case 1:
         return new class_awh(var8, var6, 1.0D - var4);
      case 2:
         return new class_awh(1.0D - var8, var6, var4);
      case 3:
         return new class_awh(1.0D - var4, var6, 1.0D - var8);
      default:
         return var10?new class_awh(var4, var6, var8):var1;
      }
   }

   public void a(class_dn var1) {
      class_du var2 = new class_du();

      class_dn var5;
      for(Iterator var3 = this.a.iterator(); var3.hasNext(); var2.a((class_eb)var5)) {
         class_asv.class_a_in_class_asv var4 = (class_asv.class_a_in_class_asv)var3.next();
         var5 = new class_dn();
         var5.a((String)"pos", (class_eb)this.a(new int[]{var4.a.n(), var4.a.o(), var4.a.p()}));
         var5.a("state", class_agj.f(var4.b));
         if(var4.c != null) {
            var5.a((String)"nbt", (class_eb)var4.c);
         }
      }

      class_du var7 = new class_du();

      class_dn var6;
      for(Iterator var8 = this.b.iterator(); var8.hasNext(); var7.a((class_eb)var6)) {
         class_asv.class_b_in_class_asv var9 = (class_asv.class_b_in_class_asv)var8.next();
         var6 = new class_dn();
         var6.a((String)"pos", (class_eb)this.a(new double[]{var9.a.a, var9.a.b, var9.a.c}));
         var6.a((String)"blockPos", (class_eb)this.a(new int[]{var9.b.n(), var9.b.o(), var9.b.p()}));
         if(var9.c != null) {
            var6.a((String)"nbt", (class_eb)var9.c);
         }
      }

      var1.a((String)"blocks", (class_eb)var2);
      var1.a((String)"entities", (class_eb)var7);
      var1.a((String)"size", (class_eb)this.a(new int[]{this.c.n(), this.c.o(), this.c.p()}));
      var1.a("version", (int)1);
      var1.a("author", this.d);
   }

   public void b(class_dn var1) {
      this.a.clear();
      this.b.clear();
      class_du var2 = var1.c("size", 3);
      this.c = new class_cj(var2.c(0), var2.c(1), var2.c(2));
      this.d = var1.k("author");
      class_du var3 = var1.c("blocks", 10);

      for(int var4 = 0; var4 < var3.c(); ++var4) {
         class_dn var5 = var3.b(var4);
         class_du var6 = var5.c("pos", 3);
         class_cj var7 = new class_cj(var6.c(0), var6.c(1), var6.c(2));
         int var8 = var5.g("state");
         class_anl var9 = class_agj.d(var8);
         class_dn var10;
         if(var5.d("nbt")) {
            var10 = var5.n("nbt");
         } else {
            var10 = null;
         }

         this.a.add(new class_asv.class_a_in_class_asv(var7, var9, var10, null));
      }

      class_du var12 = var1.c("entities", 10);

      for(int var13 = 0; var13 < var12.c(); ++var13) {
         class_dn var14 = var12.b(var13);
         class_du var15 = var14.c("pos", 6);
         class_awh var16 = new class_awh(var15.e(0), var15.e(1), var15.e(2));
         class_du var17 = var14.c("blockPos", 3);
         class_cj var18 = new class_cj(var17.c(0), var17.c(1), var17.c(2));
         if(var14.d("nbt")) {
            class_dn var11 = var14.n("nbt");
            this.b.add(new class_asv.class_b_in_class_asv(var16, var18, var11, null));
         }
      }

   }

   private class_du a(int... var1) {
      class_du var2 = new class_du();
      int[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int var6 = var3[var5];
         var2.a((class_eb)(new class_dt(var6)));
      }

      return var2;
   }

   private class_du a(double... var1) {
      class_du var2 = new class_du();
      double[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         var2.a((class_eb)(new class_dp(var6)));
      }

      return var2;
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[class_agj.class_a_in_class_agj.values().length];

      static {
         try {
            b[class_agj.class_a_in_class_agj.b.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[class_agj.class_a_in_class_agj.c.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[class_agj.class_c_in_class_agj.values().length];

         try {
            a[class_agj.class_c_in_class_agj.d.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_agj.class_c_in_class_agj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_agj.class_c_in_class_agj.c.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   static class class_b_in_class_asv {
      public final class_awh a;
      public final class_cj b;
      public final class_dn c;

      private class_b_in_class_asv(class_awh var1, class_cj var2, class_dn var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      // $FF: synthetic method
      class_b_in_class_asv(class_awh var1, class_cj var2, class_dn var3, Object var4) {
         this(var1, var2, var3);
      }
   }

   static class class_a_in_class_asv {
      public final class_cj a;
      public final class_anl b;
      public final class_dn c;

      private class_a_in_class_asv(class_cj var1, class_anl var2, class_dn var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      // $FF: synthetic method
      class_a_in_class_asv(class_cj var1, class_anl var2, class_dn var3, Object var4) {
         this(var1, var2, var3);
      }
   }
}
