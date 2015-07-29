package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_qa;

public class class_akp extends Block {
   public static final class_any N = class_any.a("axis", class_cq.class_a_in_class_cq.class);

   protected class_akp(class_atk var1) {
      super(var1, var1.r());
   }

   protected class_akp(class_atk var1, class_atl var2) {
      super(var1, var2);
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_akp.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
         case 2:
            switch(class_akp.SyntheticClass_1.a[((class_cq.class_a_in_class_cq)var1.get(N)).ordinal()]) {
            case 1:
               return var1.set(N, class_cq.class_a_in_class_cq.c);
            case 2:
               return var1.set(N, class_cq.class_a_in_class_cq.a);
            default:
               return var1;
            }
         default:
            return var1;
         }
      }
   }

   public IBlockData a(int var1) {
      class_cq.class_a_in_class_cq var2 = class_cq.class_a_in_class_cq.b;
      int var3 = var1 & 12;
      if(var3 == 4) {
         var2 = class_cq.class_a_in_class_cq.a;
      } else if(var3 == 8) {
         var2 = class_cq.class_a_in_class_cq.c;
      }

      return this.S().set(N, var2);
   }

   public int c(IBlockData var1) {
      int var2 = 0;
      class_cq.class_a_in_class_cq var3 = (class_cq.class_a_in_class_cq)var1.get(N);
      if(var3 == class_cq.class_a_in_class_cq.a) {
         var2 |= 4;
      } else if(var3 == class_cq.class_a_in_class_cq.c) {
         var2 |= 8;
      }

      return var2;
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{N});
   }

   protected class_aas i(IBlockData var1) {
      return new class_aas(class_aar.a((Block)this));
   }

   public IBlockData a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8).set(N, var3.k());
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[Block.class_c_in_class_agj.values().length];

      static {
         try {
            b[Block.class_c_in_class_agj.d.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            b[Block.class_c_in_class_agj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         a = new int[class_cq.class_a_in_class_cq.values().length];

         try {
            a[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.class_a_in_class_cq.c.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
