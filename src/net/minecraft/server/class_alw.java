package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_aku;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anx;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_alw extends class_aku {
   public static final class_anx a;

   public class_alw() {
      this.setBlockData(this.blockStateList.getFirst().set(a, class_cq.c));
   }

   public void a(class_aer var1, class_cj var2) {
      class_cq var3 = (class_cq)var1.p(var2).get(a);
      float var4 = 0.28125F;
      float var5 = 0.78125F;
      float var6 = 0.0F;
      float var7 = 1.0F;
      float var8 = 0.125F;
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      switch(class_alw.SyntheticClass_1.a[var3.ordinal()]) {
      case 1:
         this.setSizes(var6, var4, 1.0F - var8, var7, var5, 1.0F);
         break;
      case 2:
         this.setSizes(var6, var4, 0.0F, var7, var5, var8);
         break;
      case 3:
         this.setSizes(1.0F - var8, var4, var6, 1.0F, var5, var7);
         break;
      case 4:
         this.setSizes(0.0F, var4, var6, var8, var5, var7);
      }

   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      class_cq var5 = (class_cq)var3.get(a);
      if(!var1.p(var2.a(var5.d())).getBlock().getMaterial().a()) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

      super.a(var1, var2, var3, var4);
   }

   public IBlockData fromLegacyData(int var1) {
      class_cq var2 = class_cq.a(var1);
      if(var2.k() == class_cq.class_a_in_class_cq.b) {
         var2 = class_cq.c;
      }

      return this.getBlockData().set(a, var2);
   }

   public int toLegacyData(IBlockData var1) {
      return ((class_cq)var1.get(a)).a();
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((class_cq)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((class_cq)var1.get(a)));
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   static {
      a = class_aiv.O;
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_cq.values().length];

      static {
         try {
            a[class_cq.c.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_cq.d.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_cq.e.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.f.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
