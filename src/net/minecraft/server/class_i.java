package net.minecraft.server;

import com.google.common.base.Functions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_ca;
import net.minecraft.server.class_cb;
import net.minecraft.server.class_cd;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_h;
import net.minecraft.server.class_jz;
import net.minecraft.server.class_k;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_m;
import net.minecraft.server.class_o;
import net.minecraft.server.class_pr;

public abstract class class_i implements class_k {
   private static class_h a;

   public int a() {
      return 4;
   }

   public List b() {
      return Collections.emptyList();
   }

   public boolean a(class_m var1) {
      return var1.a(this.a(), this.c());
   }

   public List a(class_m var1, String[] var2, class_cj var3) {
      return null;
   }

   public static int a(String var0) throws class_cb {
      try {
         return Integer.parseInt(var0);
      } catch (NumberFormatException var2) {
         throw new class_cb("commands.generic.num.invalid", new Object[]{var0});
      }
   }

   public static int a(String var0, int var1) throws class_cb {
      return a(var0, var1, Integer.MAX_VALUE);
   }

   public static int a(String var0, int var1, int var2) throws class_cb {
      int var3 = a(var0);
      if(var3 < var1) {
         throw new class_cb("commands.generic.num.tooSmall", new Object[]{Integer.valueOf(var3), Integer.valueOf(var1)});
      } else if(var3 > var2) {
         throw new class_cb("commands.generic.num.tooBig", new Object[]{Integer.valueOf(var3), Integer.valueOf(var2)});
      } else {
         return var3;
      }
   }

   public static long b(String var0) throws class_cb {
      try {
         return Long.parseLong(var0);
      } catch (NumberFormatException var2) {
         throw new class_cb("commands.generic.num.invalid", new Object[]{var0});
      }
   }

   public static long a(String var0, long var1, long var3) throws class_cb {
      long var5 = b(var0);
      if(var5 < var1) {
         throw new class_cb("commands.generic.num.tooSmall", new Object[]{Long.valueOf(var5), Long.valueOf(var1)});
      } else if(var5 > var3) {
         throw new class_cb("commands.generic.num.tooBig", new Object[]{Long.valueOf(var5), Long.valueOf(var3)});
      } else {
         return var5;
      }
   }

   public static class_cj a(class_m var0, String[] var1, int var2, boolean var3) throws class_cb {
      class_cj var4 = var0.c();
      return new class_cj(b((double)var4.n(), var1[var2], -30000000, 30000000, var3), b((double)var4.o(), var1[var2 + 1], 0, 256, false), b((double)var4.p(), var1[var2 + 2], -30000000, 30000000, var3));
   }

   public static double c(String var0) throws class_cb {
      try {
         double var1 = Double.parseDouble(var0);
         if(!Doubles.isFinite(var1)) {
            throw new class_cb("commands.generic.num.invalid", new Object[]{var0});
         } else {
            return var1;
         }
      } catch (NumberFormatException var3) {
         throw new class_cb("commands.generic.num.invalid", new Object[]{var0});
      }
   }

   public static double a(String var0, double var1) throws class_cb {
      return a(var0, var1, Double.MAX_VALUE);
   }

   public static double a(String var0, double var1, double var3) throws class_cb {
      double var5 = c(var0);
      if(var5 < var1) {
         throw new class_cb("commands.generic.double.tooSmall", new Object[]{Double.valueOf(var5), Double.valueOf(var1)});
      } else if(var5 > var3) {
         throw new class_cb("commands.generic.double.tooBig", new Object[]{Double.valueOf(var5), Double.valueOf(var3)});
      } else {
         return var5;
      }
   }

   public static boolean d(String var0) throws class_bz {
      if(!var0.equals("true") && !var0.equals("1")) {
         if(!var0.equals("false") && !var0.equals("0")) {
            throw new class_bz("commands.generic.boolean.invalid", new Object[]{var0});
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public static class_lh b(class_m var0) throws class_cd {
      if(var0 instanceof class_lh) {
         return (class_lh)var0;
      } else {
         throw new class_cd("You must specify which player you wish to perform this action on.", new Object[0]);
      }
   }

   public static class_lh a(class_m var0, String var1) throws class_cd {
      class_lh var2 = class_o.a(var0, var1);
      if(var2 == null) {
         try {
            var2 = MinecraftServer.N().ap().a(UUID.fromString(var1));
         } catch (IllegalArgumentException var4) {
            ;
         }
      }

      if(var2 == null) {
         var2 = MinecraftServer.N().ap().a(var1);
      }

      if(var2 == null) {
         throw new class_cd();
      } else {
         return var2;
      }
   }

   public static class_pr b(class_m var0, String var1) throws class_ca {
      return a(var0, var1, class_pr.class);
   }

   public static class_pr a(class_m var0, String var1, Class var2) throws class_ca {
      Object var3 = class_o.a(var0, var1, var2);
      MinecraftServer var4 = MinecraftServer.N();
      if(var3 == null) {
         var3 = var4.ap().a(var1);
      }

      if(var3 == null) {
         try {
            UUID var5 = UUID.fromString(var1);
            var3 = var4.a(var5);
            if(var3 == null) {
               var3 = var4.ap().a(var5);
            }
         } catch (IllegalArgumentException var6) {
            throw new class_ca("commands.generic.entity.invalidUuid", new Object[0]);
         }
      }

      if(var3 != null && var2.isAssignableFrom(var3.getClass())) {
         return (class_pr)var3;
      } else {
         throw new class_ca();
      }
   }

   public static List c(class_m var0, String var1) throws class_ca {
      return (List)(class_o.b(var1)?class_o.b(var0, var1, class_pr.class):Lists.newArrayList((Object[])(new class_pr[]{b(var0, var1)})));
   }

   public static String d(class_m var0, String var1) throws class_cd {
      try {
         return a(var0, var1).e_();
      } catch (class_cd var3) {
         if(class_o.b(var1)) {
            throw var3;
         } else {
            return var1;
         }
      }
   }

   public static String e(class_m var0, String var1) throws class_ca {
      try {
         return a(var0, var1).e_();
      } catch (class_cd var5) {
         try {
            return b(var0, var1).aM().toString();
         } catch (class_ca var4) {
            if(class_o.b(var1)) {
               throw var4;
            } else {
               return var1;
            }
         }
      }
   }

   public static class_eu a(class_m var0, String[] var1, int var2) throws class_cd {
      return b(var0, var1, var2, false);
   }

   public static class_eu b(class_m var0, String[] var1, int var2, boolean var3) throws class_cd {
      class_fa var4 = new class_fa("");

      for(int var5 = var2; var5 < var1.length; ++var5) {
         if(var5 > var2) {
            var4.a(" ");
         }

         Object var6 = new class_fa(var1[var5]);
         if(var3) {
            class_eu var7 = class_o.b(var0, var1[var5]);
            if(var7 == null) {
               if(class_o.b(var1[var5])) {
                  throw new class_cd();
               }
            } else {
               var6 = var7;
            }
         }

         var4.a((class_eu)var6);
      }

      return var4;
   }

   public static String a(String[] var0, int var1) {
      StringBuilder var2 = new StringBuilder();

      for(int var3 = var1; var3 < var0.length; ++var3) {
         if(var3 > var1) {
            var2.append(" ");
         }

         String var4 = var0[var3];
         var2.append(var4);
      }

      return var2.toString();
   }

   public static class_i.class_a_in_class_i a(double var0, String var2, boolean var3) throws class_cb {
      return a(var0, var2, -30000000, 30000000, var3);
   }

   public static class_i.class_a_in_class_i a(double var0, String var2, int var3, int var4, boolean var5) throws class_cb {
      boolean var6 = var2.startsWith("~");
      if(var6 && Double.isNaN(var0)) {
         throw new class_cb("commands.generic.num.invalid", new Object[]{Double.valueOf(var0)});
      } else {
         double var7 = 0.0D;
         if(!var6 || var2.length() > 1) {
            boolean var9 = var2.contains(".");
            if(var6) {
               var2 = var2.substring(1);
            }

            var7 += c(var2);
            if(!var9 && !var6 && var5) {
               var7 += 0.5D;
            }
         }

         if(var3 != 0 || var4 != 0) {
            if(var7 < (double)var3) {
               throw new class_cb("commands.generic.double.tooSmall", new Object[]{Double.valueOf(var7), Integer.valueOf(var3)});
            }

            if(var7 > (double)var4) {
               throw new class_cb("commands.generic.double.tooBig", new Object[]{Double.valueOf(var7), Integer.valueOf(var4)});
            }
         }

         return new class_i.class_a_in_class_i(var7 + (var6?var0:0.0D), var7, var6);
      }
   }

   public static double b(double var0, String var2, boolean var3) throws class_cb {
      return b(var0, var2, -30000000, 30000000, var3);
   }

   public static double b(double var0, String var2, int var3, int var4, boolean var5) throws class_cb {
      boolean var6 = var2.startsWith("~");
      if(var6 && Double.isNaN(var0)) {
         throw new class_cb("commands.generic.num.invalid", new Object[]{Double.valueOf(var0)});
      } else {
         double var7 = var6?var0:0.0D;
         if(!var6 || var2.length() > 1) {
            boolean var9 = var2.contains(".");
            if(var6) {
               var2 = var2.substring(1);
            }

            var7 += c(var2);
            if(!var9 && !var6 && var5) {
               var7 += 0.5D;
            }
         }

         if(var3 != 0 || var4 != 0) {
            if(var7 < (double)var3) {
               throw new class_cb("commands.generic.double.tooSmall", new Object[]{Double.valueOf(var7), Integer.valueOf(var3)});
            }

            if(var7 > (double)var4) {
               throw new class_cb("commands.generic.double.tooBig", new Object[]{Double.valueOf(var7), Integer.valueOf(var4)});
            }
         }

         return var7;
      }
   }

   public static class_aar f(class_m var0, String var1) throws class_cb {
      class_jz var2 = new class_jz(var1);
      class_aar var3 = (class_aar)class_aar.e.c(var2);
      if(var3 == null) {
         throw new class_cb("commands.give.item.notFound", new Object[]{var2});
      } else {
         return var3;
      }
   }

   public static class_agj g(class_m var0, String var1) throws class_cb {
      class_jz var2 = new class_jz(var1);
      if(!class_agj.c.d(var2)) {
         throw new class_cb("commands.give.block.notFound", new Object[]{var2});
      } else {
         class_agj var3 = (class_agj)class_agj.c.c(var2);
         if(var3 == null) {
            throw new class_cb("commands.give.block.notFound", new Object[]{var2});
         } else {
            return var3;
         }
      }
   }

   public static String a(Object[] var0) {
      StringBuilder var1 = new StringBuilder();

      for(int var2 = 0; var2 < var0.length; ++var2) {
         String var3 = var0[var2].toString();
         if(var2 > 0) {
            if(var2 == var0.length - 1) {
               var1.append(" and ");
            } else {
               var1.append(", ");
            }
         }

         var1.append(var3);
      }

      return var1.toString();
   }

   public static class_eu a(List var0) {
      class_fa var1 = new class_fa("");

      for(int var2 = 0; var2 < var0.size(); ++var2) {
         if(var2 > 0) {
            if(var2 == var0.size() - 1) {
               var1.a(" and ");
            } else if(var2 > 0) {
               var1.a(", ");
            }
         }

         var1.a((class_eu)var0.get(var2));
      }

      return var1;
   }

   public static String a(Collection var0) {
      return a(var0.toArray(new String[var0.size()]));
   }

   public static List a(String[] var0, int var1, class_cj var2) {
      if(var2 == null) {
         return null;
      } else {
         int var4 = var0.length - 1;
         String var3;
         if(var4 == var1) {
            var3 = Integer.toString(var2.n());
         } else if(var4 == var1 + 1) {
            var3 = Integer.toString(var2.o());
         } else {
            if(var4 != var1 + 2) {
               return null;
            }

            var3 = Integer.toString(var2.p());
         }

         return Lists.newArrayList((Object[])(new String[]{var3}));
      }
   }

   public static List b(String[] var0, int var1, class_cj var2) {
      if(var2 == null) {
         return null;
      } else {
         int var4 = var0.length - 1;
         String var3;
         if(var4 == var1) {
            var3 = Integer.toString(var2.n());
         } else {
            if(var4 != var1 + 1) {
               return null;
            }

            var3 = Integer.toString(var2.p());
         }

         return Lists.newArrayList((Object[])(new String[]{var3}));
      }
   }

   public static boolean a(String var0, String var1) {
      return var1.regionMatches(true, 0, var0, 0, var0.length());
   }

   public static List a(String[] var0, String... var1) {
      return a((String[])var0, (Collection)Arrays.asList(var1));
   }

   public static List a(String[] var0, Collection var1) {
      String var2 = var0[var0.length - 1];
      ArrayList var3 = Lists.newArrayList();
      if(!var1.isEmpty()) {
         Iterator var4 = Iterables.transform(var1, Functions.toStringFunction()).iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            if(a(var2, var5)) {
               var3.add(var5);
            }
         }

         if(var3.isEmpty()) {
            var4 = var1.iterator();

            while(var4.hasNext()) {
               Object var6 = var4.next();
               if(var6 instanceof class_jz && a(var2, ((class_jz)var6).a())) {
                  var3.add(String.valueOf(var6));
               }
            }
         }
      }

      return var3;
   }

   public boolean b(String[] var1, int var2) {
      return false;
   }

   public static void a(class_m var0, class_k var1, String var2, Object... var3) {
      a(var0, var1, 0, var2, var3);
   }

   public static void a(class_m var0, class_k var1, int var2, String var3, Object... var4) {
      if(a != null) {
         a.a(var0, var1, var2, var3, var4);
      }

   }

   public static void a(class_h var0) {
      a = var0;
   }

   public int a(class_k var1) {
      return this.c().compareTo(var1.c());
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((class_k)var1);
   }

   public static class class_a_in_class_i {
      private final double a;
      private final double b;
      private final boolean c;

      protected class_a_in_class_i(double var1, double var3, boolean var5) {
         this.a = var1;
         this.b = var3;
         this.c = var5;
      }

      public double a() {
         return this.a;
      }

      public double b() {
         return this.b;
      }

      public boolean c() {
         return this.c;
      }
   }
}
