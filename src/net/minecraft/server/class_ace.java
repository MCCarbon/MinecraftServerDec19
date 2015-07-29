package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aak;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_abe;
import net.minecraft.server.class_acd;
import net.minecraft.server.class_acf;

public class class_ace {
   private static final List a = Lists.newArrayList();
   private static final List b = Lists.newArrayList();
   private static final List c = Lists.newArrayList();
   private static final Predicate d = new Predicate() {
      public boolean a(class_aas var1) {
         Iterator var2 = class_ace.c.iterator();

         class_ace.class_a_in_class_ace var3;
         do {
            if(!var2.hasNext()) {
               return false;
            }

            var3 = (class_ace.class_a_in_class_ace)var2.next();
         } while(!var3.a(var1));

         return true;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_aas)var1);
      }
   };

   public static boolean a(class_aas var0) {
      return b(var0) || c(var0);
   }

   protected static boolean b(class_aas var0) {
      int var1 = 0;

      for(int var2 = b.size(); var1 < var2; ++var1) {
         if(((class_ace.class_b_in_class_ace)b.get(var1)).b.apply(var0)) {
            return true;
         }
      }

      return false;
   }

   protected static boolean c(class_aas var0) {
      int var1 = 0;

      for(int var2 = a.size(); var1 < var2; ++var1) {
         if(((class_ace.class_b_in_class_ace)a.get(var1)).b.apply(var0)) {
            return true;
         }
      }

      return false;
   }

   public static boolean a(class_aas var0, class_aas var1) {
      return !d.apply(var0)?false:b(var0, var1) || c(var0, var1);
   }

   protected static boolean b(class_aas var0, class_aas var1) {
      class_aar var2 = var0.b();
      int var3 = 0;

      for(int var4 = b.size(); var3 < var4; ++var3) {
         class_ace.class_b_in_class_ace var5 = (class_ace.class_b_in_class_ace)b.get(var3);
         if(var5.a == var2 && var5.b.apply(var1)) {
            return true;
         }
      }

      return false;
   }

   protected static boolean c(class_aas var0, class_aas var1) {
      class_acd var2 = class_abe.i(var0);
      int var3 = 0;

      for(int var4 = a.size(); var3 < var4; ++var3) {
         class_ace.class_b_in_class_ace var5 = (class_ace.class_b_in_class_ace)a.get(var3);
         if(var5.a == var2 && var5.b.apply(var1)) {
            return true;
         }
      }

      return false;
   }

   public static class_aas d(class_aas var0, class_aas var1) {
      if(var1 != null) {
         class_acd var2 = class_abe.i(var1);
         class_aar var3 = var1.b();
         int var4 = 0;

         int var5;
         class_ace.class_b_in_class_ace var6;
         for(var5 = b.size(); var4 < var5; ++var4) {
            var6 = (class_ace.class_b_in_class_ace)b.get(var4);
            if(var6.a == var3 && var6.b.apply(var0)) {
               return class_abe.a(new class_aas((class_aar)var6.c), var2);
            }
         }

         var4 = 0;

         for(var5 = a.size(); var4 < var5; ++var4) {
            var6 = (class_ace.class_b_in_class_ace)a.get(var4);
            if(var6.a == var2 && var6.b.apply(var0)) {
               return class_abe.a(new class_aas(var3), (class_acd)var6.c);
            }
         }
      }

      return var1;
   }

   public static void a() {
      class_ace.class_a_in_class_ace var0 = new class_ace.class_a_in_class_ace(class_aau.bA);
      class_ace.class_a_in_class_ace var1 = new class_ace.class_a_in_class_ace(class_aau.bZ);
      class_ace.class_a_in_class_ace var2 = new class_ace.class_a_in_class_ace(class_aau.aE);
      class_ace.class_a_in_class_ace var3 = new class_ace.class_a_in_class_ace(class_aau.bF);
      class_ace.class_a_in_class_ace var4 = new class_ace.class_a_in_class_ace(class_aau.bt);
      class_ace.class_a_in_class_ace var5 = new class_ace.class_a_in_class_ace(class_aau.aV);
      class_ace.class_a_in_class_ace var6 = new class_ace.class_a_in_class_ace(class_aau.bH);
      class_ace.class_a_in_class_ace var7 = new class_ace.class_a_in_class_ace(class_aau.ba);
      class_ace.class_a_in_class_ace var8 = new class_ace.class_a_in_class_ace(class_aau.aW, class_aak.class_a_in_class_aak.d.a());
      class_ace.class_a_in_class_ace var9 = new class_ace.class_a_in_class_ace(class_aau.bL);
      class_ace.class_a_in_class_ace var10 = new class_ace.class_a_in_class_ace(class_aau.bE);
      class_ace.class_a_in_class_ace var11 = new class_ace.class_a_in_class_ace(class_aau.by);
      class_ace.class_a_in_class_ace var12 = new class_ace.class_a_in_class_ace(class_aau.bG);
      a(new class_ace.class_a_in_class_ace(class_aau.bB));
      a(new class_ace.class_a_in_class_ace(class_aau.bC));
      a(class_aau.bB, new class_ace.class_a_in_class_ace(class_aau.J), class_aau.bC);
      a((class_acd)class_acf.a, (Predicate)var9, (class_acd)class_acf.b);
      a((class_acd)class_acf.a, (Predicate)var11, (class_acd)class_acf.b);
      a((class_acd)class_acf.a, (Predicate)var4, (class_acd)class_acf.b);
      a((class_acd)class_acf.a, (Predicate)var12, (class_acd)class_acf.b);
      a((class_acd)class_acf.a, (Predicate)var10, (class_acd)class_acf.b);
      a((class_acd)class_acf.a, (Predicate)var7, (class_acd)class_acf.b);
      a((class_acd)class_acf.a, (Predicate)var6, (class_acd)class_acf.b);
      a((class_acd)class_acf.a, (Predicate)var5, (class_acd)class_acf.c);
      a((class_acd)class_acf.a, (Predicate)var2, (class_acd)class_acf.b);
      a((class_acd)class_acf.a, (Predicate)var0, (class_acd)class_acf.d);
      a((class_acd)class_acf.d, (Predicate)var1, (class_acd)class_acf.e);
      a((class_acd)class_acf.e, (Predicate)var2, (class_acd)class_acf.f);
      a((class_acd)class_acf.e, (Predicate)var3, (class_acd)class_acf.g);
      a((class_acd)class_acf.f, (Predicate)var3, (class_acd)class_acf.h);
      a((class_acd)class_acf.g, (Predicate)var2, (class_acd)class_acf.h);
      a((class_acd)class_acf.d, (Predicate)var6, (class_acd)class_acf.l);
      a((class_acd)class_acf.l, (Predicate)var2, (class_acd)class_acf.m);
      a((class_acd)class_acf.d, (Predicate)var4, (class_acd)class_acf.i);
      a((class_acd)class_acf.i, (Predicate)var2, (class_acd)class_acf.j);
      a((class_acd)class_acf.i, (Predicate)var5, (class_acd)class_acf.k);
      a((class_acd)class_acf.i, (Predicate)var3, (class_acd)class_acf.q);
      a((class_acd)class_acf.j, (Predicate)var3, (class_acd)class_acf.r);
      a((class_acd)class_acf.q, (Predicate)var2, (class_acd)class_acf.r);
      a((class_acd)class_acf.n, (Predicate)var3, (class_acd)class_acf.q);
      a((class_acd)class_acf.o, (Predicate)var3, (class_acd)class_acf.r);
      a((class_acd)class_acf.d, (Predicate)var7, (class_acd)class_acf.n);
      a((class_acd)class_acf.n, (Predicate)var2, (class_acd)class_acf.o);
      a((class_acd)class_acf.n, (Predicate)var5, (class_acd)class_acf.p);
      a((class_acd)class_acf.d, (Predicate)var8, (class_acd)class_acf.s);
      a((class_acd)class_acf.s, (Predicate)var2, (class_acd)class_acf.t);
      a((class_acd)class_acf.d, (Predicate)var9, (class_acd)class_acf.u);
      a((class_acd)class_acf.u, (Predicate)var5, (class_acd)class_acf.v);
      a((class_acd)class_acf.u, (Predicate)var3, (class_acd)class_acf.w);
      a((class_acd)class_acf.v, (Predicate)var3, (class_acd)class_acf.x);
      a((class_acd)class_acf.w, (Predicate)var5, (class_acd)class_acf.x);
      a((class_acd)class_acf.y, (Predicate)var3, (class_acd)class_acf.w);
      a((class_acd)class_acf.z, (Predicate)var3, (class_acd)class_acf.w);
      a((class_acd)class_acf.A, (Predicate)var3, (class_acd)class_acf.x);
      a((class_acd)class_acf.d, (Predicate)var10, (class_acd)class_acf.y);
      a((class_acd)class_acf.y, (Predicate)var2, (class_acd)class_acf.z);
      a((class_acd)class_acf.y, (Predicate)var5, (class_acd)class_acf.A);
      a((class_acd)class_acf.d, (Predicate)var11, (class_acd)class_acf.B);
      a((class_acd)class_acf.B, (Predicate)var2, (class_acd)class_acf.C);
      a((class_acd)class_acf.B, (Predicate)var5, (class_acd)class_acf.D);
      a((class_acd)class_acf.d, (Predicate)var12, (class_acd)class_acf.E);
      a((class_acd)class_acf.E, (Predicate)var2, (class_acd)class_acf.F);
      a((class_acd)class_acf.E, (Predicate)var5, (class_acd)class_acf.G);
      a((class_acd)class_acf.a, (Predicate)var3, (class_acd)class_acf.H);
      a((class_acd)class_acf.H, (Predicate)var2, (class_acd)class_acf.I);
   }

   private static void a(class_abe var0, class_ace.class_a_in_class_ace var1, class_abe var2) {
      b.add(new class_ace.class_b_in_class_ace(var0, var1, var2));
   }

   private static void a(class_ace.class_a_in_class_ace var0) {
      c.add(var0);
   }

   private static void a(class_acd var0, Predicate var1, class_acd var2) {
      a.add(new class_ace.class_b_in_class_ace(var0, var1, var2));
   }

   static class class_a_in_class_ace implements Predicate {
      private final class_aar a;
      private final int b;

      public class_a_in_class_ace(class_aar var1) {
         this(var1, -1);
      }

      public class_a_in_class_ace(class_aar var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      public boolean a(class_aas var1) {
         return var1 != null && var1.b() == this.a && (this.b == -1 || this.b == var1.i());
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_aas)var1);
      }
   }

   static class class_b_in_class_ace {
      final Object a;
      final Predicate b;
      final Object c;

      public class_b_in_class_ace(Object var1, Predicate var2, Object var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }
}
