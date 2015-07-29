package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agf;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pv;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_vp;
import net.minecraft.server.class_xz;

public class class_ahg extends class_agf {
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

   public class_ahg() {
      super(true);
      this.j(this.M.b().set(N, Boolean.valueOf(false)).set(b, class_agf.class_b_in_class_agf.a));
      this.a(true);
   }

   public int a(class_aen var1) {
      return 20;
   }

   public boolean i() {
      return true;
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_pr var4) {
      if(!var1.D) {
         if(!((Boolean)var3.get(N)).booleanValue()) {
            this.e(var1, var2, var3);
         }
      }
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
   }

   public void b(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
      if(!var1.D && ((Boolean)var3.get(N)).booleanValue()) {
         this.e(var1, var2, var3);
      }
   }

   public int a(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      return ((Boolean)var3.get(N)).booleanValue()?15:0;
   }

   public int b(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      return !((Boolean)var3.get(N)).booleanValue()?0:(var4 == class_cq.b?15:0);
   }

   private void e(class_aen var1, class_cj var2, IBlockData var3) {
      boolean var4 = ((Boolean)var3.get(N)).booleanValue();
      boolean var5 = false;
      List var6 = this.a(var1, var2, class_vn.class, new Predicate[0]);
      if(!var6.isEmpty()) {
         var5 = true;
      }

      if(var5 && !var4) {
         var1.a((class_cj)var2, (IBlockData)var3.set(N, Boolean.valueOf(true)), 3);
         var1.c((class_cj)var2, (Block)this);
         var1.c((class_cj)var2.b(), (Block)this);
         var1.b(var2, var2);
      }

      if(!var5 && var4) {
         var1.a((class_cj)var2, (IBlockData)var3.set(N, Boolean.valueOf(false)), 3);
         var1.c((class_cj)var2, (Block)this);
         var1.c((class_cj)var2.b(), (Block)this);
         var1.b(var2, var2);
      }

      if(var5) {
         var1.a((class_cj)var2, (Block)this, this.a(var1));
      }

      var1.e(var2, this);
   }

   public void c(class_aen var1, class_cj var2, IBlockData var3) {
      super.c(var1, var2, var3);
      this.e(var1, var2, var3);
   }

   public IBlockState n() {
      return b;
   }

   public boolean Q() {
      return true;
   }

   public int l(class_aen var1, class_cj var2) {
      if(((Boolean)var1.p(var2).get(N)).booleanValue()) {
         List var3 = this.a(var1, var2, class_vp.class, new Predicate[0]);
         if(!var3.isEmpty()) {
            return ((class_vp)var3.get(0)).j().j();
         }

         List var4 = this.a(var1, var2, class_vn.class, new Predicate[]{class_pv.c});
         if(!var4.isEmpty()) {
            return class_xz.b((class_oj)var4.get(0));
         }
      }

      return 0;
   }

   protected List a(class_aen var1, class_cj var2, Class var3, Predicate... var4) {
      class_awf var5 = this.a(var2);
      return var4.length != 1?var1.a(var3, var5):var1.a(var3, var5, var4[0]);
   }

   private class_awf a(class_cj var1) {
      float var2 = 0.2F;
      return new class_awf((double)((float)var1.n() + 0.2F), (double)var1.o(), (double)((float)var1.p() + 0.2F), (double)((float)(var1.n() + 1) - 0.2F), (double)((float)(var1.o() + 1) - 0.2F), (double)((float)(var1.p() + 1) - 0.2F));
   }

   public IBlockData a(int var1) {
      return this.S().set(b, class_agf.class_b_in_class_agf.a(var1 & 7)).set(N, Boolean.valueOf((var1 & 8) > 0));
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_agf.class_b_in_class_agf)var1.get(b)).a();
      if(((Boolean)var1.get(N)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_ahg.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            switch(class_ahg.SyntheticClass_1.a[((class_agf.class_b_in_class_agf)var1.get(b)).ordinal()]) {
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
            switch(class_ahg.SyntheticClass_1.a[((class_agf.class_b_in_class_agf)var1.get(b)).ordinal()]) {
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
            switch(class_ahg.SyntheticClass_1.a[((class_agf.class_b_in_class_agf)var1.get(b)).ordinal()]) {
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
         switch(class_ahg.SyntheticClass_1.c[var2.ordinal()]) {
         case 1:
            switch(class_ahg.SyntheticClass_1.a[var3.ordinal()]) {
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
            switch(class_ahg.SyntheticClass_1.a[var3.ordinal()]) {
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
      return new class_anm(this, new IBlockState[]{b, N});
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
