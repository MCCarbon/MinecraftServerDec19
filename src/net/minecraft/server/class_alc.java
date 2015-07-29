package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_agg;
import net.minecraft.server.Block;
import net.minecraft.server.class_aln;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zy;

public class class_alc extends class_aln {
   public static final class_any a = class_any.a("color", class_zy.class);

   public class_alc() {
      super(class_atk.s, false);
      this.j(this.M.b().set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)).set(P, Boolean.valueOf(false)).set(a, class_zy.a));
      this.a(CreativeTab.c);
   }

   public int a(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   public class_atl g(IBlockData var1) {
      return ((class_zy)var1.get(a)).e();
   }

   public IBlockData a(int var1) {
      return this.S().set(a, class_zy.b(var1));
   }

   public int c(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_alc.SyntheticClass_1.a[var2.ordinal()]) {
         case 1:
            return var1.set(b, var1.get(O)).set(N, var1.get(P)).set(O, var1.get(b)).set(P, var1.get(N));
         case 2:
            return var1.set(b, var1.get(N)).set(N, var1.get(O)).set(O, var1.get(P)).set(P, var1.get(b));
         case 3:
            return var1.set(b, var1.get(P)).set(N, var1.get(b)).set(O, var1.get(N)).set(P, var1.get(O));
         default:
            return var1;
         }
      }
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_alc.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            return var1.set(b, var1.get(O)).set(O, var1.get(b));
         case 2:
            return var1.set(N, var1.get(P)).set(P, var1.get(N));
         default:
            return super.a(var1, var2);
         }
      }
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{b, N, P, O, a});
   }

   public void c(class_aen var1, class_cj var2, IBlockData var3) {
      if(!var1.D) {
         class_agg.f(var1, var2);
      }

   }

   public void b(class_aen var1, class_cj var2, IBlockData var3) {
      if(!var1.D) {
         class_agg.f(var1, var2);
      }

   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            b[Block.class_a_in_class_agj.b.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[Block.class_a_in_class_agj.c.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[Block.class_c_in_class_agj.values().length];

         try {
            a[Block.class_c_in_class_agj.c.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.d.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.b.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
