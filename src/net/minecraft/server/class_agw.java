package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_zu;

public class class_agw extends class_agj {
   public static final class_anw a = class_anw.a("north");
   public static final class_anw b = class_anw.a("east");
   public static final class_anw N = class_anw.a("south");
   public static final class_anw O = class_anw.a("west");
   public static final class_anw P = class_anw.a("up");
   public static final class_anw Q = class_anw.a("down");

   protected class_agw() {
      super(class_atk.k);
      this.a(class_zu.c);
      this.j(this.M.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)).a(Q, Boolean.valueOf(false)));
   }

   public class_anl a(class_anl var1, class_aer var2, class_cj var3) {
      class_agj var4 = var2.p(var3.b()).c();
      class_agj var5 = var2.p(var3.a()).c();
      class_agj var6 = var2.p(var3.c()).c();
      class_agj var7 = var2.p(var3.f()).c();
      class_agj var8 = var2.p(var3.d()).c();
      class_agj var9 = var2.p(var3.e()).c();
      return var1.a(Q, Boolean.valueOf(var4 == this || var4 == class_agk.cS || var4 == class_agk.bH)).a(P, Boolean.valueOf(var5 == this || var5 == class_agk.cS)).a(a, Boolean.valueOf(var6 == this || var6 == class_agk.cS)).a(b, Boolean.valueOf(var7 == this || var7 == class_agk.cS)).a(N, Boolean.valueOf(var8 == this || var8 == class_agk.cS)).a(O, Boolean.valueOf(var9 == this || var9 == class_agk.cS));
   }

   public int c(class_anl var1) {
      return 0;
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(!this.e(var1, var2)) {
         var1.b(var2, true);
      }

   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return class_aau.cI;
   }

   public int a(Random var1) {
      return var1.nextInt(2);
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      return super.a(var1, var2, var3);
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public boolean d(class_aen var1, class_cj var2) {
      return super.d(var1, var2)?this.e(var1, var2):false;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      if(!this.e(var1, var2)) {
         var1.a((class_cj)var2, (class_agj)this, 1);
      }

   }

   public boolean e(class_aen var1, class_cj var2) {
      boolean var3 = var1.d(var2.a());
      boolean var4 = var1.d(var2.b());
      Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

      class_agj var9;
      do {
         class_cj var7;
         class_agj var8;
         do {
            if(!var5.hasNext()) {
               class_agj var10 = var1.p(var2.b()).c();
               if(var10 != this && var10 != class_agk.bH) {
                  return false;
               }

               return true;
            }

            class_cq var6 = (class_cq)var5.next();
            var7 = var2.a(var6);
            var8 = var1.p(var7).c();
         } while(var8 != this);

         if(!var3 && !var4) {
            return false;
         }

         var9 = var1.p(var7.b()).c();
      } while(var9 != this && var9 != class_agk.bH);

      return true;
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a, b, N, O, P, Q});
   }
}
