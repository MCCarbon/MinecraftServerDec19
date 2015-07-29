package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_zu;

public abstract class class_agf extends class_agj {
   protected final boolean a;

   public static boolean e(class_aen var0, class_cj var1) {
      return d(var0.p(var1));
   }

   public static boolean d(class_anl var0) {
      class_agj var1 = var0.c();
      return var1 == class_agk.av || var1 == class_agk.D || var1 == class_agk.E || var1 == class_agk.cs;
   }

   protected class_agf(boolean var1) {
      super(class_atk.q);
      this.a = var1;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.a(class_zu.e);
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public class_awg a(class_aen var1, class_cj var2, class_awh var3, class_awh var4) {
      this.a(var1, var2);
      return super.a(var1, var2, var3, var4);
   }

   public void a(class_aer var1, class_cj var2) {
      class_anl var3 = var1.p(var2);
      class_agf.class_b_in_class_agf var4 = var3.c() == this?(class_agf.class_b_in_class_agf)var3.b(this.n()):null;
      if(var4 != null && var4.c()) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      }

   }

   public boolean d() {
      return false;
   }

   public boolean d(class_aen var1, class_cj var2) {
      return class_aen.a((class_aer)var1, (class_cj)var2.b());
   }

   public void c(class_aen var1, class_cj var2, class_anl var3) {
      if(!var1.D) {
         var3 = this.a(var1, var2, var3, true);
         if(this.a) {
            this.a(var1, var2, (class_anl)var3, (class_agj)this);
         }
      }

   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      if(!var1.D) {
         class_agf.class_b_in_class_agf var5 = (class_agf.class_b_in_class_agf)var3.b(this.n());
         boolean var6 = false;
         if(!class_aen.a((class_aer)var1, (class_cj)var2.b())) {
            var6 = true;
         }

         if(var5 == class_agf.class_b_in_class_agf.c && !class_aen.a((class_aer)var1, (class_cj)var2.f())) {
            var6 = true;
         } else if(var5 == class_agf.class_b_in_class_agf.d && !class_aen.a((class_aer)var1, (class_cj)var2.e())) {
            var6 = true;
         } else if(var5 == class_agf.class_b_in_class_agf.e && !class_aen.a((class_aer)var1, (class_cj)var2.c())) {
            var6 = true;
         } else if(var5 == class_agf.class_b_in_class_agf.f && !class_aen.a((class_aer)var1, (class_cj)var2.d())) {
            var6 = true;
         }

         if(var6) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         } else {
            this.b(var1, var2, var3, var4);
         }

      }
   }

   protected void b(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
   }

   protected class_anl a(class_aen var1, class_cj var2, class_anl var3, boolean var4) {
      return var1.D?var3:(new class_agf.class_a_in_class_agf(var1, var2, var3)).a(var1.z(var2), var4).b();
   }

   public int k() {
      return 0;
   }

   public void b(class_aen var1, class_cj var2, class_anl var3) {
      super.b(var1, var2, var3);
      if(((class_agf.class_b_in_class_agf)var3.b(this.n())).c()) {
         var1.c((class_cj)var2.a(), (class_agj)this);
      }

      if(this.a) {
         var1.c((class_cj)var2, (class_agj)this);
         var1.c((class_cj)var2.b(), (class_agj)this);
      }

   }

   public abstract class_aoa n();

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_agf.class_b_in_class_agf.values().length];

      static {
         try {
            a[class_agf.class_b_in_class_agf.a.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.b.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.c.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.d.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.e.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.f.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.g.ordinal()] = 7;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.h.ordinal()] = 8;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.i.ordinal()] = 9;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.j.ordinal()] = 10;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_b_in_class_agf implements class_ny {
      a(0, "north_south"),
      b(1, "east_west"),
      c(2, "ascending_east"),
      d(3, "ascending_west"),
      e(4, "ascending_north"),
      f(5, "ascending_south"),
      g(6, "south_east"),
      h(7, "south_west"),
      i(8, "north_west"),
      j(9, "north_east");

      private static final class_agf.class_b_in_class_agf[] k;
      private final int l;
      private final String m;

      private class_b_in_class_agf(int var3, String var4) {
         this.l = var3;
         this.m = var4;
      }

      public int a() {
         return this.l;
      }

      public String toString() {
         return this.m;
      }

      public boolean c() {
         return this == e || this == c || this == f || this == d;
      }

      public static class_agf.class_b_in_class_agf a(int var0) {
         if(var0 < 0 || var0 >= k.length) {
            var0 = 0;
         }

         return k[var0];
      }

      public String l() {
         return this.m;
      }

      static {
         k = new class_agf.class_b_in_class_agf[values().length];
         class_agf.class_b_in_class_agf[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_agf.class_b_in_class_agf var3 = var0[var2];
            k[var3.a()] = var3;
         }

      }
   }

   public class class_a_in_class_agf {
      private final class_aen b;
      private final class_cj c;
      private final class_agf d;
      private class_anl e;
      private final boolean f;
      private final List g = Lists.newArrayList();

      public class_a_in_class_agf(class_aen var2, class_cj var3, class_anl var4) {
         this.b = var2;
         this.c = var3;
         this.e = var4;
         this.d = (class_agf)var4.c();
         class_agf.class_b_in_class_agf var5 = (class_agf.class_b_in_class_agf)var4.b(class_agf.this.n());
         this.f = this.d.a;
         this.a(var5);
      }

      private void a(class_agf.class_b_in_class_agf var1) {
         this.g.clear();
         switch(class_agf.SyntheticClass_1.a[var1.ordinal()]) {
         case 1:
            this.g.add(this.c.c());
            this.g.add(this.c.d());
            break;
         case 2:
            this.g.add(this.c.e());
            this.g.add(this.c.f());
            break;
         case 3:
            this.g.add(this.c.e());
            this.g.add(this.c.f().a());
            break;
         case 4:
            this.g.add(this.c.e().a());
            this.g.add(this.c.f());
            break;
         case 5:
            this.g.add(this.c.c().a());
            this.g.add(this.c.d());
            break;
         case 6:
            this.g.add(this.c.c());
            this.g.add(this.c.d().a());
            break;
         case 7:
            this.g.add(this.c.f());
            this.g.add(this.c.d());
            break;
         case 8:
            this.g.add(this.c.e());
            this.g.add(this.c.d());
            break;
         case 9:
            this.g.add(this.c.e());
            this.g.add(this.c.c());
            break;
         case 10:
            this.g.add(this.c.f());
            this.g.add(this.c.c());
         }

      }

      private void c() {
         for(int var1 = 0; var1 < this.g.size(); ++var1) {
            class_agf.class_a_in_class_agf var2 = this.b((class_cj)this.g.get(var1));
            if(var2 != null && var2.a(this)) {
               this.g.set(var1, var2.c);
            } else {
               this.g.remove(var1--);
            }
         }

      }

      private boolean a(class_cj var1) {
         return class_agf.e(this.b, var1) || class_agf.e(this.b, var1.a()) || class_agf.e(this.b, var1.b());
      }

      private class_agf.class_a_in_class_agf b(class_cj var1) {
         class_anl var3 = this.b.p(var1);
         if(class_agf.d(var3)) {
            return class_agf.this.new class_a_in_class_agf(this.b, var1, var3);
         } else {
            class_cj var2 = var1.a();
            var3 = this.b.p(var2);
            if(class_agf.d(var3)) {
               return class_agf.this.new class_a_in_class_agf(this.b, var2, var3);
            } else {
               var2 = var1.b();
               var3 = this.b.p(var2);
               return class_agf.d(var3)?class_agf.this.new class_a_in_class_agf(this.b, var2, var3):null;
            }
         }
      }

      private boolean a(class_agf.class_a_in_class_agf var1) {
         return this.c(var1.c);
      }

      private boolean c(class_cj var1) {
         for(int var2 = 0; var2 < this.g.size(); ++var2) {
            class_cj var3 = (class_cj)this.g.get(var2);
            if(var3.n() == var1.n() && var3.p() == var1.p()) {
               return true;
            }
         }

         return false;
      }

      protected int a() {
         int var1 = 0;
         Iterator var2 = class_cq.class_c_in_class_cq.a.iterator();

         while(var2.hasNext()) {
            class_cq var3 = (class_cq)var2.next();
            if(this.a(this.c.a(var3))) {
               ++var1;
            }
         }

         return var1;
      }

      private boolean b(class_agf.class_a_in_class_agf var1) {
         return this.a(var1) || this.g.size() != 2;
      }

      private void c(class_agf.class_a_in_class_agf var1) {
         this.g.add(var1.c);
         class_cj var2 = this.c.c();
         class_cj var3 = this.c.d();
         class_cj var4 = this.c.e();
         class_cj var5 = this.c.f();
         boolean var6 = this.c(var2);
         boolean var7 = this.c(var3);
         boolean var8 = this.c(var4);
         boolean var9 = this.c(var5);
         class_agf.class_b_in_class_agf var10 = null;
         if(var6 || var7) {
            var10 = class_agf.class_b_in_class_agf.a;
         }

         if(var8 || var9) {
            var10 = class_agf.class_b_in_class_agf.b;
         }

         if(!this.f) {
            if(var7 && var9 && !var6 && !var8) {
               var10 = class_agf.class_b_in_class_agf.g;
            }

            if(var7 && var8 && !var6 && !var9) {
               var10 = class_agf.class_b_in_class_agf.h;
            }

            if(var6 && var8 && !var7 && !var9) {
               var10 = class_agf.class_b_in_class_agf.i;
            }

            if(var6 && var9 && !var7 && !var8) {
               var10 = class_agf.class_b_in_class_agf.j;
            }
         }

         if(var10 == class_agf.class_b_in_class_agf.a) {
            if(class_agf.e(this.b, var2.a())) {
               var10 = class_agf.class_b_in_class_agf.e;
            }

            if(class_agf.e(this.b, var3.a())) {
               var10 = class_agf.class_b_in_class_agf.f;
            }
         }

         if(var10 == class_agf.class_b_in_class_agf.b) {
            if(class_agf.e(this.b, var5.a())) {
               var10 = class_agf.class_b_in_class_agf.c;
            }

            if(class_agf.e(this.b, var4.a())) {
               var10 = class_agf.class_b_in_class_agf.d;
            }
         }

         if(var10 == null) {
            var10 = class_agf.class_b_in_class_agf.a;
         }

         this.e = this.e.a(this.d.n(), var10);
         this.b.a((class_cj)this.c, (class_anl)this.e, 3);
      }

      private boolean d(class_cj var1) {
         class_agf.class_a_in_class_agf var2 = this.b(var1);
         if(var2 == null) {
            return false;
         } else {
            var2.c();
            return var2.b(this);
         }
      }

      public class_agf.class_a_in_class_agf a(boolean var1, boolean var2) {
         class_cj var3 = this.c.c();
         class_cj var4 = this.c.d();
         class_cj var5 = this.c.e();
         class_cj var6 = this.c.f();
         boolean var7 = this.d(var3);
         boolean var8 = this.d(var4);
         boolean var9 = this.d(var5);
         boolean var10 = this.d(var6);
         class_agf.class_b_in_class_agf var11 = null;
         if((var7 || var8) && !var9 && !var10) {
            var11 = class_agf.class_b_in_class_agf.a;
         }

         if((var9 || var10) && !var7 && !var8) {
            var11 = class_agf.class_b_in_class_agf.b;
         }

         if(!this.f) {
            if(var8 && var10 && !var7 && !var9) {
               var11 = class_agf.class_b_in_class_agf.g;
            }

            if(var8 && var9 && !var7 && !var10) {
               var11 = class_agf.class_b_in_class_agf.h;
            }

            if(var7 && var9 && !var8 && !var10) {
               var11 = class_agf.class_b_in_class_agf.i;
            }

            if(var7 && var10 && !var8 && !var9) {
               var11 = class_agf.class_b_in_class_agf.j;
            }
         }

         if(var11 == null) {
            if(var7 || var8) {
               var11 = class_agf.class_b_in_class_agf.a;
            }

            if(var9 || var10) {
               var11 = class_agf.class_b_in_class_agf.b;
            }

            if(!this.f) {
               if(var1) {
                  if(var8 && var10) {
                     var11 = class_agf.class_b_in_class_agf.g;
                  }

                  if(var9 && var8) {
                     var11 = class_agf.class_b_in_class_agf.h;
                  }

                  if(var10 && var7) {
                     var11 = class_agf.class_b_in_class_agf.j;
                  }

                  if(var7 && var9) {
                     var11 = class_agf.class_b_in_class_agf.i;
                  }
               } else {
                  if(var7 && var9) {
                     var11 = class_agf.class_b_in_class_agf.i;
                  }

                  if(var10 && var7) {
                     var11 = class_agf.class_b_in_class_agf.j;
                  }

                  if(var9 && var8) {
                     var11 = class_agf.class_b_in_class_agf.h;
                  }

                  if(var8 && var10) {
                     var11 = class_agf.class_b_in_class_agf.g;
                  }
               }
            }
         }

         if(var11 == class_agf.class_b_in_class_agf.a) {
            if(class_agf.e(this.b, var3.a())) {
               var11 = class_agf.class_b_in_class_agf.e;
            }

            if(class_agf.e(this.b, var4.a())) {
               var11 = class_agf.class_b_in_class_agf.f;
            }
         }

         if(var11 == class_agf.class_b_in_class_agf.b) {
            if(class_agf.e(this.b, var6.a())) {
               var11 = class_agf.class_b_in_class_agf.c;
            }

            if(class_agf.e(this.b, var5.a())) {
               var11 = class_agf.class_b_in_class_agf.d;
            }
         }

         if(var11 == null) {
            var11 = class_agf.class_b_in_class_agf.a;
         }

         this.a(var11);
         this.e = this.e.a(this.d.n(), var11);
         if(var2 || this.b.p(this.c) != this.e) {
            this.b.a((class_cj)this.c, (class_anl)this.e, 3);

            for(int var12 = 0; var12 < this.g.size(); ++var12) {
               class_agf.class_a_in_class_agf var13 = this.b((class_cj)this.g.get(var12));
               if(var13 != null) {
                  var13.c();
                  if(var13.b(this)) {
                     var13.c(this);
                  }
               }
            }
         }

         return this;
      }

      public class_anl b() {
         return this.e;
      }
   }
}
