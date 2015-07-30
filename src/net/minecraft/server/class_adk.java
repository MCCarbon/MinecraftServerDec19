package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_adi;
import net.minecraft.server.class_adl;
import net.minecraft.server.class_adm;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_g;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_oc;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qf;
import net.minecraft.server.class_xa;

public class class_adk {
   private static final Random a = new Random();
   private static final class_adk.class_e_in_class_adk b = new class_adk.class_e_in_class_adk();
   private static final class_adk.class_d_in_class_adk c = new class_adk.class_d_in_class_adk();
   private static final class_adk.class_b_in_class_adk d = new class_adk.class_b_in_class_adk();
   private static final class_adk.class_a_in_class_adk e = new class_adk.class_a_in_class_adk();

   public static int a(class_adi var0, class_aas var1) {
      if(var1 == null) {
         return 0;
      } else {
         class_du var2 = var1.p();
         if(var2 == null) {
            return 0;
         } else {
            for(int var3 = 0; var3 < var2.c(); ++var3) {
               class_adi var4 = class_adi.c(var2.b(var3).f("id"));
               short var5 = var2.b(var3).f("lvl");
               if(var4 == var0) {
                  return var5;
               }
            }

            return 0;
         }
      }
   }

   public static Map a(class_aas var0) {
      LinkedHashMap var1 = Maps.newLinkedHashMap();
      class_du var2 = var0.b() == Items.cg?Items.cg.h(var0):var0.p();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.c(); ++var3) {
            class_adi var4 = class_adi.c(var2.b(var3).f("id"));
            short var5 = var2.b(var3).f("lvl");
            var1.put(var4, Integer.valueOf(var5));
         }
      }

      return var1;
   }

   public static void a(Map var0, class_aas var1) {
      class_du var2 = new class_du();
      Iterator var3 = var0.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         class_adi var5 = (class_adi)var4.getKey();
         if(var5 != null) {
            int var6 = ((Integer)var4.getValue()).intValue();
            class_dn var7 = new class_dn();
            var7.a("id", (short)class_adi.b(var5));
            var7.a("lvl", (short)var6);
            var2.a((class_eb)var7);
            if(var1.b() == Items.cg) {
               Items.cg.a(var1, new class_adl(var5, var6));
            }
         }
      }

      if(var2.c_()) {
         if(var1.n()) {
            var1.o().p("ench");
         }
      } else if(var1.b() != Items.cg) {
         var1.a((String)"ench", (class_eb)var2);
      }

   }

   private static void a(class_adk.class_c_in_class_adk var0, class_aas var1) {
      if(var1 != null) {
         class_du var2 = var1.p();
         if(var2 != null) {
            for(int var3 = 0; var3 < var2.c(); ++var3) {
               short var4 = var2.b(var3).f("id");
               short var5 = var2.b(var3).f("lvl");
               if(class_adi.c(var4) != null) {
                  var0.a(class_adi.c(var4), var5);
               }
            }

         }
      }
   }

   private static void a(class_adk.class_c_in_class_adk var0, Iterable var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class_aas var3 = (class_aas)var2.next();
         a(var0, var3);
      }

   }

   public static int a(Iterable var0, class_pc var1) {
      b.a = 0;
      b.b = var1;
      a((class_adk.class_c_in_class_adk)b, (Iterable)var0);
      if(b.a > 25) {
         b.a = 25;
      } else if(b.a < 0) {
         b.a = 0;
      }

      return (b.a + 1 >> 1) + a.nextInt((b.a >> 1) + 1);
   }

   public static float a(class_aas var0, class_qf var1) {
      c.a = 0.0F;
      c.b = var1;
      a((class_adk.class_c_in_class_adk)c, (class_aas)var0);
      return c.a;
   }

   public static void a(class_qa var0, class_pr var1) {
      d.b = var1;
      d.a = var0;
      if(var0 != null) {
         a((class_adk.class_c_in_class_adk)d, (Iterable)var0.au());
      }

      if(var1 instanceof class_xa) {
         a((class_adk.class_c_in_class_adk)d, (class_aas)var0.bA());
      }

   }

   public static void b(class_qa var0, class_pr var1) {
      e.a = var0;
      e.b = var1;
      if(var0 != null) {
         a((class_adk.class_c_in_class_adk)e, (Iterable)var0.au());
      }

      if(var0 instanceof class_xa) {
         a((class_adk.class_c_in_class_adk)e, (class_aas)var0.bA());
      }

   }

   public static int a(class_adi var0, class_qa var1) {
      Iterable var2 = var0.a(var1);
      if(var2 == null) {
         return 0;
      } else {
         int var3 = 0;
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            class_aas var5 = (class_aas)var4.next();
            int var6 = a(var0, var5);
            if(var6 > var3) {
               var3 = var6;
            }
         }

         return var3;
      }
   }

   public static int a(class_qa var0) {
      return a(class_adm.m, var0);
   }

   public static int b(class_qa var0) {
      return a(class_adm.n, var0);
   }

   public static int c(class_qa var0) {
      return a(class_adm.f, var0);
   }

   public static int d(class_qa var0) {
      return a(class_adm.i, var0);
   }

   public static int e(class_qa var0) {
      return a(class_adm.p, var0);
   }

   public static int f(class_qa var0) {
      return a(class_adm.x, var0);
   }

   public static int g(class_qa var0) {
      return a(class_adm.y, var0);
   }

   public static int h(class_qa var0) {
      return a(class_adm.o, var0);
   }

   public static boolean i(class_qa var0) {
      return a(class_adm.g, var0) > 0;
   }

   public static class_aas b(class_adi var0, class_qa var1) {
      Iterator var2 = var1.au().iterator();

      class_aas var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (class_aas)var2.next();
      } while(var3 == null || a(var0, var3) <= 0);

      return var3;
   }

   public static int a(Random var0, int var1, int var2, class_aas var3) {
      Item var4 = var3.b();
      int var5 = var4.c();
      if(var5 <= 0) {
         return 0;
      } else {
         if(var2 > 15) {
            var2 = 15;
         }

         int var6 = var0.nextInt(8) + 1 + (var2 >> 1) + var0.nextInt(var2 + 1);
         return var1 == 0?Math.max(var6 / 3, 1):(var1 == 1?var6 * 2 / 3 + 1:Math.max(var6, var2 * 2));
      }
   }

   public static class_aas a(Random var0, class_aas var1, int var2) {
      boolean var3 = var1.b() == Items.aN;
      if(var3) {
         var1.a((Item)Items.cg);
      }

      List var4 = b(var0, var1, var2);
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         class_adl var6 = (class_adl)var5.next();
         if(var3) {
            Items.cg.a(var1, var6);
         } else {
            var1.a(var6.b, var6.c);
         }
      }

      return var1;
   }


   public static List<class_adl> b(Random random, class_aas aas, int n) {
       ArrayList arrayList = Lists.newArrayList();
       Item aar = aas.b();
       int n2 = aar.c();
       if (n2 <= 0) {
           return arrayList;
       }
       n+=1 + random.nextInt(n2 / 4 + 1) + random.nextInt(n2 / 4 + 1);
       float f = (random.nextFloat() + random.nextFloat() - 1.0f) * 0.15f;
       List list = class_adk.a((int)(n = MathHelper.clamp((int)Math.round((float)n + (float)n * f), (int)1, (int)Integer.MAX_VALUE)), (class_aas)aas);
       if (list.isEmpty()) return arrayList;
       arrayList.add(class_oc.a((Random)random, list));
       while (random.nextInt(50) <= n) {
           class_adk.a((List)list, (class_adl)((class_adl)class_g.a((List)arrayList)));
           if (list.isEmpty()) {
               return arrayList;
           }
           arrayList.add(class_oc.a((Random)random, list));
           n/=2;
       }
       return arrayList;
   }

   public static void a(List var0, class_adl var1) {
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         if(!var1.b.a(((class_adl)var2.next()).b)) {
            var2.remove();
         }
      }

   }

   public static List a(int var0, class_aas var1) {
      ArrayList var2 = Lists.newArrayList();
      Item var3 = var1.b();
      boolean var4 = var1.b() == Items.aN;
      Iterator var5 = class_adi.b.iterator();

      while(true) {
         class_adi var6;
         do {
            if(!var5.hasNext()) {
               return var2;
            }

            var6 = (class_adi)var5.next();
         } while(!var6.c.a(var3) && !var4);

         for(int var7 = var6.d(); var7 <= var6.b(); ++var7) {
            if(var0 >= var6.a(var7) && var0 <= var6.b(var7)) {
               var2.add(new class_adl(var6, var7));
            }
         }
      }
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
   }

   static final class class_a_in_class_adk implements class_adk.class_c_in_class_adk {
      public class_qa a;
      public class_pr b;

      private class_a_in_class_adk() {
      }

      public void a(class_adi var1, int var2) {
         var1.a(this.a, this.b, var2);
      }

      // $FF: synthetic method
      class_a_in_class_adk(class_adk.SyntheticClass_1 var1) {
         this();
      }
   }

   static final class class_b_in_class_adk implements class_adk.class_c_in_class_adk {
      public class_qa a;
      public class_pr b;

      private class_b_in_class_adk() {
      }

      public void a(class_adi var1, int var2) {
         var1.b(this.a, this.b, var2);
      }

      // $FF: synthetic method
      class_b_in_class_adk(class_adk.SyntheticClass_1 var1) {
         this();
      }
   }

   static final class class_d_in_class_adk implements class_adk.class_c_in_class_adk {
      public float a;
      public class_qf b;

      private class_d_in_class_adk() {
      }

      public void a(class_adi var1, int var2) {
         this.a += var1.a(var2, this.b);
      }

      // $FF: synthetic method
      class_d_in_class_adk(class_adk.SyntheticClass_1 var1) {
         this();
      }
   }

   static final class class_e_in_class_adk implements class_adk.class_c_in_class_adk {
      public int a;
      public class_pc b;

      private class_e_in_class_adk() {
      }

      public void a(class_adi var1, int var2) {
         this.a += var1.a(var2, this.b);
      }

      // $FF: synthetic method
      class_e_in_class_adk(class_adk.SyntheticClass_1 var1) {
         this();
      }
   }

   interface class_c_in_class_adk {
      void a(class_adi var1, int var2);
   }
}
