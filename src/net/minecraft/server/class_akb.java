package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_age;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;

public class class_akb extends class_age {
   public static final class_anw a = class_anw.a("powered");
   private final class_akb.class_a_in_class_akb b;

   protected class_akb(class_atk var1, class_akb.class_a_in_class_akb var2) {
      super(var1);
      this.j(this.M.b().a(a, Boolean.valueOf(false)));
      this.b = var2;
   }

   protected int e(class_anl var1) {
      return ((Boolean)var1.b(a)).booleanValue()?15:0;
   }

   protected class_anl a(class_anl var1, int var2) {
      return var1.a(a, Boolean.valueOf(var2 > 0));
   }

   protected int f(class_aen var1, class_cj var2) {
      class_awf var3 = this.a(var2);
      List var4;
      switch(class_akb.SyntheticClass_1.a[this.b.ordinal()]) {
      case 1:
         var4 = var1.b((class_pr)null, (class_awf)var3);
         break;
      case 2:
         var4 = var1.a(class_qa.class, var3);
         break;
      default:
         return 0;
      }

      if(!var4.isEmpty()) {
         Iterator var5 = var4.iterator();

         while(var5.hasNext()) {
            class_pr var6 = (class_pr)var5.next();
            if(!var6.aK()) {
               return 15;
            }
         }
      }

      return 0;
   }

   public class_anl a(int var1) {
      return this.S().a(a, Boolean.valueOf(var1 == 1));
   }

   public int c(class_anl var1) {
      return ((Boolean)var1.b(a)).booleanValue()?1:0;
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_akb.class_a_in_class_akb.values().length];

      static {
         try {
            a[class_akb.class_a_in_class_akb.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_akb.class_a_in_class_akb.b.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_akb {
      a,
      b;
   }
}
