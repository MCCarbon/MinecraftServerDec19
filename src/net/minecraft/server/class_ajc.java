package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agp;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_ajc extends class_agj {
   public static final class_any a = class_any.a("facing", class_ajc.class_a_in_class_ajc.class);
   public static final class_anw b = class_anw.a("powered");

   protected class_ajc() {
      super(class_atk.q);
      this.j(this.M.b().a(a, class_ajc.class_a_in_class_ajc.e).a(b, Boolean.valueOf(false)));
      this.a(class_zu.d);
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean b(class_aen var1, class_cj var2, class_cq var3) {
      return a(var1, var2, var3.d());
   }

   public boolean d(class_aen var1, class_cj var2) {
      class_cq[] var3 = class_cq.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_cq var6 = var3[var5];
         if(a(var1, var2, var6)) {
            return true;
         }
      }

      return false;
   }

   protected static boolean a(class_aen var0, class_cj var1, class_cq var2) {
      return class_agp.a(var0, var1, var2);
   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      class_anl var9 = this.S().a(b, Boolean.valueOf(false));
      if(a(var1, var2, var3.d())) {
         return var9.a(a, class_ajc.class_a_in_class_ajc.a(var3, var8.aR()));
      } else {
         Iterator var10 = class_cq.class_c_in_class_cq.a.iterator();

         class_cq var11;
         do {
            if(!var10.hasNext()) {
               if(class_aen.a((class_aer)var1, (class_cj)var2.b())) {
                  return var9.a(a, class_ajc.class_a_in_class_ajc.a(class_cq.b, var8.aR()));
               }

               return var9;
            }

            var11 = (class_cq)var10.next();
         } while(var11 == var3 || !a(var1, var2, var11.d()));

         return var9.a(a, class_ajc.class_a_in_class_ajc.a(var11, var8.aR()));
      }
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      if(this.e(var1, var2, var3) && !a(var1, var2, ((class_ajc.class_a_in_class_ajc)var3.b(a)).c().d())) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   private boolean e(class_aen var1, class_cj var2, class_anl var3) {
      if(this.d(var1, var2)) {
         return true;
      } else {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      }
   }

   public void a(class_aer var1, class_cj var2) {
      float var3 = 0.1875F;
      switch(class_ajc.SyntheticClass_1.b[((class_ajc.class_a_in_class_ajc)var1.p(var2).b(a)).ordinal()]) {
      case 1:
         this.a(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
         break;
      case 2:
         this.a(1.0F - var3 * 2.0F, 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
         break;
      case 3:
         this.a(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
         break;
      case 4:
         this.a(0.5F - var3, 0.2F, 1.0F - var3 * 2.0F, 0.5F + var3, 0.8F, 1.0F);
         break;
      case 5:
      case 6:
         var3 = 0.25F;
         this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.6F, 0.5F + var3);
         break;
      case 7:
      case 8:
         var3 = 0.25F;
         this.a(0.5F - var3, 0.4F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
      }

   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         var3 = var3.a(b);
         var1.a((class_cj)var2, (class_anl)var3, 3);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, ((Boolean)var3.b(b)).booleanValue()?0.6F:0.5F);
         var1.c((class_cj)var2, (class_agj)this);
         class_cq var11 = ((class_ajc.class_a_in_class_ajc)var3.b(a)).c();
         var1.c((class_cj)var2.a(var11.d()), (class_agj)this);
         return true;
      }
   }

   public void b(class_aen var1, class_cj var2, class_anl var3) {
      if(((Boolean)var3.b(b)).booleanValue()) {
         var1.c((class_cj)var2, (class_agj)this);
         class_cq var4 = ((class_ajc.class_a_in_class_ajc)var3.b(a)).c();
         var1.c((class_cj)var2.a(var4.d()), (class_agj)this);
      }

      super.b(var1, var2, var3);
   }

   public int a(class_aer var1, class_cj var2, class_anl var3, class_cq var4) {
      return ((Boolean)var3.b(b)).booleanValue()?15:0;
   }

   public int b(class_aer var1, class_cj var2, class_anl var3, class_cq var4) {
      return !((Boolean)var3.b(b)).booleanValue()?0:(((class_ajc.class_a_in_class_ajc)var3.b(a)).c() == var4?15:0);
   }

   public boolean i() {
      return true;
   }

   public class_anl a(int var1) {
      return this.S().a(a, class_ajc.class_a_in_class_ajc.a(var1 & 7)).a(b, Boolean.valueOf((var1 & 8) > 0));
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_ajc.class_a_in_class_ajc)var1.b(a)).a();
      if(((Boolean)var1.b(b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_ajc.SyntheticClass_1.c[var2.ordinal()]) {
         case 1:
            switch(class_ajc.SyntheticClass_1.b[((class_ajc.class_a_in_class_ajc)var1.b(a)).ordinal()]) {
            case 1:
               return var1.a(a, class_ajc.class_a_in_class_ajc.c);
            case 2:
               return var1.a(a, class_ajc.class_a_in_class_ajc.b);
            case 3:
               return var1.a(a, class_ajc.class_a_in_class_ajc.e);
            case 4:
               return var1.a(a, class_ajc.class_a_in_class_ajc.d);
            default:
               return var1;
            }
         case 2:
            switch(class_ajc.SyntheticClass_1.b[((class_ajc.class_a_in_class_ajc)var1.b(a)).ordinal()]) {
            case 1:
               return var1.a(a, class_ajc.class_a_in_class_ajc.e);
            case 2:
               return var1.a(a, class_ajc.class_a_in_class_ajc.d);
            case 3:
               return var1.a(a, class_ajc.class_a_in_class_ajc.b);
            case 4:
               return var1.a(a, class_ajc.class_a_in_class_ajc.c);
            case 5:
               return var1.a(a, class_ajc.class_a_in_class_ajc.g);
            case 6:
               return var1.a(a, class_ajc.class_a_in_class_ajc.f);
            case 7:
               return var1.a(a, class_ajc.class_a_in_class_ajc.h);
            case 8:
               return var1.a(a, class_ajc.class_a_in_class_ajc.a);
            }
         case 3:
            switch(class_ajc.SyntheticClass_1.b[((class_ajc.class_a_in_class_ajc)var1.b(a)).ordinal()]) {
            case 1:
               return var1.a(a, class_ajc.class_a_in_class_ajc.d);
            case 2:
               return var1.a(a, class_ajc.class_a_in_class_ajc.e);
            case 3:
               return var1.a(a, class_ajc.class_a_in_class_ajc.c);
            case 4:
               return var1.a(a, class_ajc.class_a_in_class_ajc.b);
            case 5:
               return var1.a(a, class_ajc.class_a_in_class_ajc.g);
            case 6:
               return var1.a(a, class_ajc.class_a_in_class_ajc.f);
            case 7:
               return var1.a(a, class_ajc.class_a_in_class_ajc.h);
            case 8:
               return var1.a(a, class_ajc.class_a_in_class_ajc.a);
            }
         default:
            return var1;
         }
      }
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      return var1.c() != this?var1:this.a(var1, var2.a(((class_ajc.class_a_in_class_ajc)var1.b(a)).c()));
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a, b});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c;
      // $FF: synthetic field
      static final int[] d = new int[class_cq.class_a_in_class_cq.values().length];

      static {
         try {
            d[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
         } catch (NoSuchFieldError var19) {
            ;
         }

         try {
            d[class_cq.class_a_in_class_cq.c.ordinal()] = 2;
         } catch (NoSuchFieldError var18) {
            ;
         }

         c = new int[class_agj.class_c_in_class_agj.values().length];

         try {
            c[class_agj.class_c_in_class_agj.c.ordinal()] = 1;
         } catch (NoSuchFieldError var17) {
            ;
         }

         try {
            c[class_agj.class_c_in_class_agj.d.ordinal()] = 2;
         } catch (NoSuchFieldError var16) {
            ;
         }

         try {
            c[class_agj.class_c_in_class_agj.b.ordinal()] = 3;
         } catch (NoSuchFieldError var15) {
            ;
         }

         b = new int[class_ajc.class_a_in_class_ajc.values().length];

         try {
            b[class_ajc.class_a_in_class_ajc.b.ordinal()] = 1;
         } catch (NoSuchFieldError var14) {
            ;
         }

         try {
            b[class_ajc.class_a_in_class_ajc.c.ordinal()] = 2;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            b[class_ajc.class_a_in_class_ajc.d.ordinal()] = 3;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            b[class_ajc.class_a_in_class_ajc.e.ordinal()] = 4;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            b[class_ajc.class_a_in_class_ajc.f.ordinal()] = 5;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            b[class_ajc.class_a_in_class_ajc.g.ordinal()] = 6;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            b[class_ajc.class_a_in_class_ajc.a.ordinal()] = 7;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            b[class_ajc.class_a_in_class_ajc.h.ordinal()] = 8;
         } catch (NoSuchFieldError var7) {
            ;
         }

         a = new int[class_cq.values().length];

         try {
            a[class_cq.a.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_cq.b.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_cq.c.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_cq.d.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_cq.e.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.f.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_ajc implements class_ny {
       a(0, "down_x", class_cq.a),
       b(1, "east", class_cq.f),
       c(2, "west", class_cq.e),
       d(3, "south", class_cq.d),
       e(4, "north", class_cq.c),
       f(5, "up_z", class_cq.b),
       g(6, "up_x", class_cq.b),
       h(7, "down_z", class_cq.a);

      private static final class_ajc.class_a_in_class_ajc[] i;
      private final int j;
      private final String k;
      private final class_cq l;

      private class_a_in_class_ajc(int var3, String var4, class_cq var5) {
         this.j = var3;
         this.k = var4;
         this.l = var5;
      }

      public int a() {
         return this.j;
      }

      public class_cq c() {
         return this.l;
      }

      public String toString() {
         return this.k;
      }

      public static class_ajc.class_a_in_class_ajc a(int var0) {
         if(var0 < 0 || var0 >= i.length) {
            var0 = 0;
         }

         return i[var0];
      }

      public static class_ajc.class_a_in_class_ajc a(class_cq var0, class_cq var1) {
         switch(class_ajc.SyntheticClass_1.a[var0.ordinal()]) {
         case 1:
            switch(class_ajc.SyntheticClass_1.d[var1.k().ordinal()]) {
            case 1:
               return a;
            case 2:
               return h;
            default:
               throw new IllegalArgumentException("Invalid entityFacing " + var1 + " for facing " + var0);
            }
         case 2:
            switch(class_ajc.SyntheticClass_1.d[var1.k().ordinal()]) {
            case 1:
               return g;
            case 2:
               return f;
            default:
               throw new IllegalArgumentException("Invalid entityFacing " + var1 + " for facing " + var0);
            }
         case 3:
            return e;
         case 4:
            return d;
         case 5:
            return c;
         case 6:
            return b;
         default:
            throw new IllegalArgumentException("Invalid facing: " + var0);
         }
      }

      public String l() {
         return this.k;
      }

      static {
         i = new class_ajc.class_a_in_class_ajc[values().length];
         class_ajc.class_a_in_class_ajc[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_ajc.class_a_in_class_ajc var3 = var0[var2];
            i[var3.a()] = var3;
         }

      }
   }
}
