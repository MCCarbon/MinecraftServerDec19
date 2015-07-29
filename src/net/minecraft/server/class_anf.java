package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahi;
import net.minecraft.server.class_ane;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.INamable;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;

public class class_anf extends class_ahi {
   public static final BlockStateEnum a = BlockStateEnum.of("type", class_anf.class_a_in_class_anf.class);
   public static final class_anw N = class_anw.a("short");

   public class_anf() {
      super(Material.H);
      this.setBlockData(this.blockStateList.getFirst().set(b, class_cq.c).set(a, class_anf.class_a_in_class_anf.a).set(N, Boolean.valueOf(false)));
      this.setStepSound(STEP_SOUND_STONE2);
      this.setStrength(0.5F);
   }

   public void a(World var1, class_cj var2, IBlockData var3, class_xa var4) {
      if(var4.bH.d) {
         class_cq var5 = (class_cq)var3.get(b);
         if(var5 != null) {
            class_cj var6 = var2.a(var5.d());
            Block var7 = var1.p(var6).getBlock();
            if(var7 == Blocks.PISTON || var7 == Blocks.STICKY_PISTON) {
               var1.g(var6);
            }
         }
      }

      super.a(var1, var2, var3, var4);
   }

   public void b(World var1, class_cj var2, IBlockData var3) {
      super.b(var1, var2, var3);
      class_cq var4 = ((class_cq)var3.get(b)).d();
      var2 = var2.a(var4);
      IBlockData var5 = var1.p(var2);
      if((var5.getBlock() == Blocks.PISTON || var5.getBlock() == Blocks.STICKY_PISTON) && ((Boolean)var5.get(class_ane.a)).booleanValue()) {
         var5.getBlock().b(var1, var2, var5, 0);
         var1.g(var2);
      }

   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean d(World var1, class_cj var2) {
      return false;
   }

   public boolean b(World var1, class_cj var2, class_cq var3) {
      return false;
   }

   public int a(Random var1) {
      return 0;
   }

   public void a(World var1, class_cj var2, IBlockData var3, class_awf var4, List var5, class_pr var6) {
      this.d(var3);
      super.a(var1, var2, var3, var4, var5, var6);
      this.e(var3);
      super.a(var1, var2, var3, var4, var5, var6);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   private void e(IBlockData var1) {
      float var2 = 0.25F;
      float var3 = 0.375F;
      float var4 = 0.625F;
      float var5 = 0.25F;
      float var6 = 0.75F;
      switch(class_anf.SyntheticClass_1.a[((class_cq)var1.get(b)).ordinal()]) {
      case 1:
         this.setSizes(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
         break;
      case 2:
         this.setSizes(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
         break;
      case 3:
         this.setSizes(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
         break;
      case 4:
         this.setSizes(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
         break;
      case 5:
         this.setSizes(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
         break;
      case 6:
         this.setSizes(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
      }

   }

   public void a(class_aer var1, class_cj var2) {
      this.d(var1.p(var2));
   }

   public void d(IBlockData var1) {
      float var2 = 0.25F;
      class_cq var3 = (class_cq)var1.get(b);
      if(var3 != null) {
         switch(class_anf.SyntheticClass_1.a[var3.ordinal()]) {
         case 1:
            this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            break;
         case 2:
            this.setSizes(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 3:
            this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            break;
         case 4:
            this.setSizes(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            break;
         case 5:
            this.setSizes(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            break;
         case 6:
            this.setSizes(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         }

      }
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      class_cq var5 = (class_cq)var3.get(b);
      class_cj var6 = var2.a(var5.d());
      IBlockData var7 = var1.p(var6);
      if(var7.getBlock() != Blocks.PISTON && var7.getBlock() != Blocks.STICKY_PISTON) {
         var1.g(var2);
      } else {
         var7.getBlock().a(var1, var6, var7, var4);
      }

   }

   public static class_cq b(int var0) {
      int var1 = var0 & 7;
      return var1 > 5?null:class_cq.a(var1);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(b, b(var1)).set(a, (var1 & 8) > 0?class_anf.class_a_in_class_anf.b:class_anf.class_a_in_class_anf.a);
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_cq)var1.get(b)).a();
      if(var1.get(a) == class_anf.class_a_in_class_anf.b) {
         var3 |= 8;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(b, var2.a((class_cq)var1.get(b)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((class_cq)var1.get(b)));
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{b, a, N});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_cq.values().length];

      static {
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

   public static enum class_a_in_class_anf implements INamable {
      a("normal"),
      b("sticky");

      private final String c;

      private class_a_in_class_anf(String var3) {
         this.c = var3;
      }

      public String toString() {
         return this.c;
      }

      public String getName() {
         return this.c;
      }
   }
}
