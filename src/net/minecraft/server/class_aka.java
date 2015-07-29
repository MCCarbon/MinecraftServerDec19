package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agf;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_cj;

public class class_aka extends class_agf {
   public static final class_any b = class_any.a("shape", class_agf.class_b_in_class_agf.class, new Predicate() {
      public boolean a(class_agf.class_b_in_class_agf var1) {
         return var1 != class_agf.class_b_in_class_agf.j && var1 != class_agf.class_b_in_class_agf.i && var1 != class_agf.class_b_in_class_agf.g && var1 != class_agf.class_b_in_class_agf.h;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_agf.class_b_in_class_agf)var1);
      }
   });
   public static final class_anw N = class_anw.a("powered");

   protected class_aka() {
      super(true);
      this.j(this.M.b().a(b, class_agf.class_b_in_class_agf.a).a(N, Boolean.valueOf(false)));
   }

   protected boolean a(class_aen var1, class_cj var2, class_anl var3, boolean var4, int var5) {
      if(var5 >= 8) {
         return false;
      } else {
         int var6 = var2.n();
         int var7 = var2.o();
         int var8 = var2.p();
         boolean var9 = true;
         class_agf.class_b_in_class_agf var10 = (class_agf.class_b_in_class_agf)var3.b(b);
         switch(class_aka.SyntheticClass_1.a[var10.ordinal()]) {
         case 1:
            if(var4) {
               ++var8;
            } else {
               --var8;
            }
            break;
         case 2:
            if(var4) {
               --var6;
            } else {
               ++var6;
            }
            break;
         case 3:
            if(var4) {
               --var6;
            } else {
               ++var6;
               ++var7;
               var9 = false;
            }

            var10 = class_agf.class_b_in_class_agf.b;
            break;
         case 4:
            if(var4) {
               --var6;
               ++var7;
               var9 = false;
            } else {
               ++var6;
            }

            var10 = class_agf.class_b_in_class_agf.b;
            break;
         case 5:
            if(var4) {
               ++var8;
            } else {
               --var8;
               ++var7;
               var9 = false;
            }

            var10 = class_agf.class_b_in_class_agf.a;
            break;
         case 6:
            if(var4) {
               ++var8;
               ++var7;
               var9 = false;
            } else {
               --var8;
            }

            var10 = class_agf.class_b_in_class_agf.a;
         }

         return this.a(var1, new class_cj(var6, var7, var8), var4, var5, var10)?true:var9 && this.a(var1, new class_cj(var6, var7 - 1, var8), var4, var5, var10);
      }
   }

   protected boolean a(class_aen var1, class_cj var2, boolean var3, int var4, class_agf.class_b_in_class_agf var5) {
      class_anl var6 = var1.p(var2);
      if(var6.c() != this) {
         return false;
      } else {
         class_agf.class_b_in_class_agf var7 = (class_agf.class_b_in_class_agf)var6.b(b);
         return var5 == class_agf.class_b_in_class_agf.b && (var7 == class_agf.class_b_in_class_agf.a || var7 == class_agf.class_b_in_class_agf.e || var7 == class_agf.class_b_in_class_agf.f)?false:(var5 == class_agf.class_b_in_class_agf.a && (var7 == class_agf.class_b_in_class_agf.b || var7 == class_agf.class_b_in_class_agf.c || var7 == class_agf.class_b_in_class_agf.d)?false:(((Boolean)var6.b(N)).booleanValue()?(var1.z(var2)?true:this.a(var1, var2, var6, var3, var4 + 1)):false));
      }
   }

   protected void b(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      boolean var5 = ((Boolean)var3.b(N)).booleanValue();
      boolean var6 = var1.z(var2) || this.a(var1, var2, var3, true, 0) || this.a(var1, var2, var3, false, 0);
      if(var6 != var5) {
         var1.a((class_cj)var2, (class_anl)var3.a(N, Boolean.valueOf(var6)), 3);
         var1.c((class_cj)var2.b(), (class_agj)this);
         if(((class_agf.class_b_in_class_agf)var3.b(b)).c()) {
            var1.c((class_cj)var2.a(), (class_agj)this);
         }
      }

   }

   public class_aoa n() {
      return b;
   }

   public class_anl a(int var1) {
      return this.S().a(b, class_agf.class_b_in_class_agf.a(var1 & 7)).a(N, Boolean.valueOf((var1 & 8) > 0));
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_agf.class_b_in_class_agf)var1.b(b)).a();
      if(((Boolean)var1.b(N)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_aka.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            switch(class_aka.SyntheticClass_1.a[((class_agf.class_b_in_class_agf)var1.b(b)).ordinal()]) {
            case 3:
               return var1.a(b, class_agf.class_b_in_class_agf.d);
            case 4:
               return var1.a(b, class_agf.class_b_in_class_agf.c);
            case 5:
               return var1.a(b, class_agf.class_b_in_class_agf.f);
            case 6:
               return var1.a(b, class_agf.class_b_in_class_agf.e);
            case 7:
               return var1.a(b, class_agf.class_b_in_class_agf.i);
            case 8:
               return var1.a(b, class_agf.class_b_in_class_agf.j);
            case 9:
               return var1.a(b, class_agf.class_b_in_class_agf.g);
            case 10:
               return var1.a(b, class_agf.class_b_in_class_agf.h);
            }
         case 2:
            switch(class_aka.SyntheticClass_1.a[((class_agf.class_b_in_class_agf)var1.b(b)).ordinal()]) {
            case 1:
               return var1.a(b, class_agf.class_b_in_class_agf.b);
            case 2:
               return var1.a(b, class_agf.class_b_in_class_agf.a);
            case 3:
               return var1.a(b, class_agf.class_b_in_class_agf.e);
            case 4:
               return var1.a(b, class_agf.class_b_in_class_agf.f);
            case 5:
               return var1.a(b, class_agf.class_b_in_class_agf.d);
            case 6:
               return var1.a(b, class_agf.class_b_in_class_agf.c);
            case 7:
               return var1.a(b, class_agf.class_b_in_class_agf.j);
            case 8:
               return var1.a(b, class_agf.class_b_in_class_agf.g);
            case 9:
               return var1.a(b, class_agf.class_b_in_class_agf.h);
            case 10:
               return var1.a(b, class_agf.class_b_in_class_agf.i);
            }
         case 3:
            switch(class_aka.SyntheticClass_1.a[((class_agf.class_b_in_class_agf)var1.b(b)).ordinal()]) {
            case 1:
               return var1.a(b, class_agf.class_b_in_class_agf.b);
            case 2:
               return var1.a(b, class_agf.class_b_in_class_agf.a);
            case 3:
               return var1.a(b, class_agf.class_b_in_class_agf.f);
            case 4:
               return var1.a(b, class_agf.class_b_in_class_agf.e);
            case 5:
               return var1.a(b, class_agf.class_b_in_class_agf.c);
            case 6:
               return var1.a(b, class_agf.class_b_in_class_agf.d);
            case 7:
               return var1.a(b, class_agf.class_b_in_class_agf.h);
            case 8:
               return var1.a(b, class_agf.class_b_in_class_agf.i);
            case 9:
               return var1.a(b, class_agf.class_b_in_class_agf.j);
            case 10:
               return var1.a(b, class_agf.class_b_in_class_agf.g);
            }
         default:
            return var1;
         }
      }
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         class_agf.class_b_in_class_agf var3 = (class_agf.class_b_in_class_agf)var1.b(b);
         switch(class_aka.SyntheticClass_1.c[var2.ordinal()]) {
         case 1:
            switch(class_aka.SyntheticClass_1.a[var3.ordinal()]) {
            case 5:
               return var1.a(b, class_agf.class_b_in_class_agf.f);
            case 6:
               return var1.a(b, class_agf.class_b_in_class_agf.e);
            case 7:
               return var1.a(b, class_agf.class_b_in_class_agf.j);
            case 8:
               return var1.a(b, class_agf.class_b_in_class_agf.i);
            case 9:
               return var1.a(b, class_agf.class_b_in_class_agf.h);
            case 10:
               return var1.a(b, class_agf.class_b_in_class_agf.g);
            default:
               return super.a(var1, var2);
            }
         case 2:
            switch(class_aka.SyntheticClass_1.a[var3.ordinal()]) {
            case 3:
               return var1.a(b, class_agf.class_b_in_class_agf.d);
            case 4:
               return var1.a(b, class_agf.class_b_in_class_agf.c);
            case 5:
            case 6:
            default:
               break;
            case 7:
               return var1.a(b, class_agf.class_b_in_class_agf.h);
            case 8:
               return var1.a(b, class_agf.class_b_in_class_agf.g);
            case 9:
               return var1.a(b, class_agf.class_b_in_class_agf.j);
            case 10:
               return var1.a(b, class_agf.class_b_in_class_agf.i);
            }
         }

         return super.a(var1, var2);
      }
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{b, N});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c = new int[class_agj.class_a_in_class_agj.values().length];

      static {
         try {
            c[class_agj.class_a_in_class_agj.b.ordinal()] = 1;
         } catch (NoSuchFieldError var15) {
            ;
         }

         try {
            c[class_agj.class_a_in_class_agj.c.ordinal()] = 2;
         } catch (NoSuchFieldError var14) {
            ;
         }

         b = new int[class_agj.class_c_in_class_agj.values().length];

         try {
            b[class_agj.class_c_in_class_agj.c.ordinal()] = 1;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            b[class_agj.class_c_in_class_agj.d.ordinal()] = 2;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            b[class_agj.class_c_in_class_agj.b.ordinal()] = 3;
         } catch (NoSuchFieldError var11) {
            ;
         }

         a = new int[class_agf.class_b_in_class_agf.values().length];

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
}
