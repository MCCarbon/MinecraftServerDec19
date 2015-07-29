package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_agf;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_cj;

public class class_akg extends class_agf {
   public static final class_any b = class_any.a("shape", class_agf.class_b_in_class_agf.class);

   protected class_akg() {
      super(false);
      this.j(this.M.b().set(b, class_agf.class_b_in_class_agf.a));
   }

   protected void b(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      if(var4.i() && (new class_agf.class_a_in_class_agf(var1, var2, var3)).a() == 3) {
         this.a(var1, var2, var3, false);
      }

   }

   public IBlockState n() {
      return b;
   }

   public IBlockData a(int var1) {
      return this.S().set(b, class_agf.class_b_in_class_agf.a(var1));
   }

   public int c(IBlockData var1) {
      return ((class_agf.class_b_in_class_agf)var1.get(b)).a();
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_akg.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            switch(class_akg.SyntheticClass_1.a[((class_agf.class_b_in_class_agf)var1.get(b)).ordinal()]) {
            case 1:
               return var1.set(b, class_agf.class_b_in_class_agf.d);
            case 2:
               return var1.set(b, class_agf.class_b_in_class_agf.c);
            case 3:
               return var1.set(b, class_agf.class_b_in_class_agf.f);
            case 4:
               return var1.set(b, class_agf.class_b_in_class_agf.e);
            case 5:
               return var1.set(b, class_agf.class_b_in_class_agf.i);
            case 6:
               return var1.set(b, class_agf.class_b_in_class_agf.j);
            case 7:
               return var1.set(b, class_agf.class_b_in_class_agf.g);
            case 8:
               return var1.set(b, class_agf.class_b_in_class_agf.h);
            }
         case 2:
            switch(class_akg.SyntheticClass_1.a[((class_agf.class_b_in_class_agf)var1.get(b)).ordinal()]) {
            case 1:
               return var1.set(b, class_agf.class_b_in_class_agf.e);
            case 2:
               return var1.set(b, class_agf.class_b_in_class_agf.f);
            case 3:
               return var1.set(b, class_agf.class_b_in_class_agf.d);
            case 4:
               return var1.set(b, class_agf.class_b_in_class_agf.c);
            case 5:
               return var1.set(b, class_agf.class_b_in_class_agf.j);
            case 6:
               return var1.set(b, class_agf.class_b_in_class_agf.g);
            case 7:
               return var1.set(b, class_agf.class_b_in_class_agf.h);
            case 8:
               return var1.set(b, class_agf.class_b_in_class_agf.i);
            case 9:
               return var1.set(b, class_agf.class_b_in_class_agf.b);
            case 10:
               return var1.set(b, class_agf.class_b_in_class_agf.a);
            }
         case 3:
            switch(class_akg.SyntheticClass_1.a[((class_agf.class_b_in_class_agf)var1.get(b)).ordinal()]) {
            case 1:
               return var1.set(b, class_agf.class_b_in_class_agf.f);
            case 2:
               return var1.set(b, class_agf.class_b_in_class_agf.e);
            case 3:
               return var1.set(b, class_agf.class_b_in_class_agf.c);
            case 4:
               return var1.set(b, class_agf.class_b_in_class_agf.d);
            case 5:
               return var1.set(b, class_agf.class_b_in_class_agf.h);
            case 6:
               return var1.set(b, class_agf.class_b_in_class_agf.i);
            case 7:
               return var1.set(b, class_agf.class_b_in_class_agf.j);
            case 8:
               return var1.set(b, class_agf.class_b_in_class_agf.g);
            case 9:
               return var1.set(b, class_agf.class_b_in_class_agf.b);
            case 10:
               return var1.set(b, class_agf.class_b_in_class_agf.a);
            }
         default:
            return var1;
         }
      }
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         class_agf.class_b_in_class_agf var3 = (class_agf.class_b_in_class_agf)var1.get(b);
         switch(class_akg.SyntheticClass_1.c[var2.ordinal()]) {
         case 1:
            switch(class_akg.SyntheticClass_1.a[var3.ordinal()]) {
            case 3:
               return var1.set(b, class_agf.class_b_in_class_agf.f);
            case 4:
               return var1.set(b, class_agf.class_b_in_class_agf.e);
            case 5:
               return var1.set(b, class_agf.class_b_in_class_agf.j);
            case 6:
               return var1.set(b, class_agf.class_b_in_class_agf.i);
            case 7:
               return var1.set(b, class_agf.class_b_in_class_agf.h);
            case 8:
               return var1.set(b, class_agf.class_b_in_class_agf.g);
            default:
               return super.a(var1, var2);
            }
         case 2:
            switch(class_akg.SyntheticClass_1.a[var3.ordinal()]) {
            case 1:
               return var1.set(b, class_agf.class_b_in_class_agf.d);
            case 2:
               return var1.set(b, class_agf.class_b_in_class_agf.c);
            case 3:
            case 4:
            default:
               break;
            case 5:
               return var1.set(b, class_agf.class_b_in_class_agf.h);
            case 6:
               return var1.set(b, class_agf.class_b_in_class_agf.g);
            case 7:
               return var1.set(b, class_agf.class_b_in_class_agf.j);
            case 8:
               return var1.set(b, class_agf.class_b_in_class_agf.i);
            }
         }

         return super.a(var1, var2);
      }
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{b});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            c[Block.class_a_in_class_agj.b.ordinal()] = 1;
         } catch (NoSuchFieldError var15) {
            ;
         }

         try {
            c[Block.class_a_in_class_agj.c.ordinal()] = 2;
         } catch (NoSuchFieldError var14) {
            ;
         }

         b = new int[Block.class_c_in_class_agj.values().length];

         try {
            b[Block.class_c_in_class_agj.c.ordinal()] = 1;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            b[Block.class_c_in_class_agj.d.ordinal()] = 2;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            b[Block.class_c_in_class_agj.b.ordinal()] = 3;
         } catch (NoSuchFieldError var11) {
            ;
         }

         a = new int[class_agf.class_b_in_class_agf.values().length];

         try {
            a[class_agf.class_b_in_class_agf.c.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.d.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.e.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.f.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.g.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.h.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.i.ordinal()] = 7;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.j.ordinal()] = 8;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.a.ordinal()] = 9;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.b.ordinal()] = 10;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
