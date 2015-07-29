package net.minecraft.server;

import com.google.common.base.Predicates;
import java.util.List;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_ahk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_ck;
import net.minecraft.server.class_cn;
import net.minecraft.server.class_cr;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pv;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_za extends class_aar {
   private static final int[] k = new int[]{13, 15, 16, 11};
   public static final String[] a = new String[]{"minecraft:items/empty_armor_slot_boots", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_helmet"};
   private static final class_cr l = new class_cn() {
      protected class_aas b(class_ck var1, class_aas var2) {
         class_cj var3 = var1.d().a(class_ahk.b(var1.f()));
         int var4 = var3.n();
         int var5 = var3.o();
         int var6 = var3.p();
         class_awf var7 = new class_awf((double)var4, (double)var5, (double)var6, (double)(var4 + 1), (double)(var5 + 1), (double)(var6 + 1));
         List var8 = var1.i().a(class_qa.class, var7, Predicates.and(class_pv.d, new class_pv.class_a_in_class_pv(var2)));
         if(!var8.isEmpty()) {
            class_qa var9 = (class_qa)var8.get(0);
            class_pw var10 = class_qb.c(var2);
            class_aas var11 = var2.k();
            var11.b = 1;
            var9.a(var10, var11);
            if(var9 instanceof class_qb) {
               ((class_qb)var9).a(var10, 2.0F);
            }

            --var2.b;
            return var2;
         } else {
            return super.b(var1, var2);
         }
      }
   };
   public final class_pw b;
   public final int c;
   public final int d;
   private final class_za.class_a_in_class_za m;

   public class_za(class_za.class_a_in_class_za var1, int var2, class_pw var3) {
      this.m = var1;
      this.b = var3;
      this.d = var2;
      this.c = var1.b(var3);
      this.e(var1.a(var3));
      this.h = 1;
      this.a(class_zu.j);
      class_ahk.N.a(this, l);
   }

   public int c() {
      return this.m.a();
   }

   public class_za.class_a_in_class_za d() {
      return this.m;
   }

   public boolean d_(class_aas var1) {
      return this.m != class_za.class_a_in_class_za.a?false:(!var1.n()?false:(!var1.o().b("display", 10)?false:var1.o().n("display").b("color", 3)));
   }

   public int b(class_aas var1) {
      if(this.m != class_za.class_a_in_class_za.a) {
         return -1;
      } else {
         class_dn var2 = var1.o();
         if(var2 != null) {
            class_dn var3 = var2.n("display");
            if(var3 != null && var3.b("color", 3)) {
               return var3.g("color");
            }
         }

         return 10511680;
      }
   }

   public void c(class_aas var1) {
      if(this.m == class_za.class_a_in_class_za.a) {
         class_dn var2 = var1.o();
         if(var2 != null) {
            class_dn var3 = var2.n("display");
            if(var3.d("color")) {
               var3.p("color");
            }

         }
      }
   }

   public void b(class_aas var1, int var2) {
      if(this.m != class_za.class_a_in_class_za.a) {
         throw new UnsupportedOperationException("Can\'t dye non-leather!");
      } else {
         class_dn var3 = var1.o();
         if(var3 == null) {
            var3 = new class_dn();
            var1.d(var3);
         }

         class_dn var4 = var3.n("display");
         if(!var3.b("display", 10)) {
            var3.a((String)"display", (class_eb)var4);
         }

         var4.a("color", var2);
      }
   }

   public boolean a(class_aas var1, class_aas var2) {
      return this.m.b() == var2.b()?true:super.a(var1, var2);
   }

   public class_or a(class_aas var1, class_aen var2, class_xa var3, class_oo var4) {
      class_pw var5 = class_qb.c(var1);
      class_aas var6 = var3.a(var5);
      if(var6 == null) {
         var3.a(var5, var1.k());
         var1.b = 0;
         return new class_or(class_oq.a, var1);
      } else {
         return new class_or(class_oq.b, var1);
      }
   }

   public static enum class_a_in_class_za {
      a("leather", 5, new int[]{1, 2, 3, 1}, 15),
      b("chainmail", 15, new int[]{1, 4, 5, 2}, 12),
      c("iron", 15, new int[]{2, 5, 6, 2}, 9),
      d("gold", 7, new int[]{1, 3, 5, 2}, 25),
      e("diamond", 33, new int[]{3, 6, 8, 3}, 10);

      private final String f;
      private final int g;
      private final int[] h;
      private final int i;

      private class_a_in_class_za(String var3, int var4, int[] var5, int var6) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
         this.i = var6;
      }

      public int a(class_pw var1) {
         return class_za.k[var1.b()] * this.g;
      }

      public int b(class_pw var1) {
         return this.h[var1.b()];
      }

      public int a() {
         return this.i;
      }

      public class_aar b() {
         return this == a?class_aau.aH:(this == b?class_aau.l:(this == d?class_aau.m:(this == c?class_aau.l:(this == e?class_aau.k:null))));
      }
   }
}
