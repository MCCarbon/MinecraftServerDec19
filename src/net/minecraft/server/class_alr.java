package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_aiv;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anx;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.INamable;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_alr extends Block {
   public static final class_anx a;
   public static final class_anw b;
   public static final BlockStateEnum N;

   protected class_alr(Material var1) {
      super(var1);
      this.setBlockData(this.blockStateList.getFirst().set(a, class_cq.c).set(b, Boolean.valueOf(false)).set(N, class_alr.class_a_in_class_alr.b));
      float var2 = 0.5F;
      float var3 = 1.0F;
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      this.a(CreativeTab.d);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isPassable(class_aer var1, class_cj var2) {
      return !((Boolean)var1.p(var2).get(b)).booleanValue();
   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      this.a((class_aer)var1, (class_cj)var2);
      return super.a(var1, var2, var3);
   }

   public void a(class_aer var1, class_cj var2) {
      this.d(var1.p(var2));
   }

   public void j() {
      float var1 = 0.1875F;
      this.setSizes(0.0F, 0.40625F, 0.0F, 1.0F, 0.59375F, 1.0F);
   }

   public void d(IBlockData var1) {
      if(var1.getBlock() == this) {
         boolean var2 = var1.get(N) == class_alr.class_a_in_class_alr.a;
         Boolean var3 = (Boolean)var1.get(b);
         class_cq var4 = (class_cq)var1.get(a);
         float var5 = 0.1875F;
         if(var2) {
            this.setSizes(0.0F, 0.8125F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else {
            this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.1875F, 1.0F);
         }

         if(var3.booleanValue()) {
            if(var4 == class_cq.c) {
               this.setSizes(0.0F, 0.0F, 0.8125F, 1.0F, 1.0F, 1.0F);
            }

            if(var4 == class_cq.d) {
               this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F);
            }

            if(var4 == class_cq.e) {
               this.setSizes(0.8125F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }

            if(var4 == class_cq.f) {
               this.setSizes(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F);
            }
         }

      }
   }

   public boolean a(World var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(this.material == Material.f) {
         return true;
      } else {
         var3 = var3.a(b);
         var1.a((class_cj)var2, (IBlockData)var3, 2);
         var1.a(var4, ((Boolean)var3.get(b)).booleanValue()?1003:1006, var2, 0);
         return true;
      }
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      if(!var1.D) {
         boolean var5 = var1.z(var2);
         if(var5 || var4.isPowerSource()) {
            boolean var6 = ((Boolean)var3.get(b)).booleanValue();
            if(var6 != var5) {
               var1.a((class_cj)var2, (IBlockData)var3.set(b, Boolean.valueOf(var5)), 2);
               var1.a((class_xa)null, var5?1003:1006, var2, 0);
            }
         }

      }
   }

   public class_awg a(World var1, class_cj var2, class_awh var3, class_awh var4) {
      this.a((class_aer)var1, (class_cj)var2);
      return super.a(var1, var2, var3, var4);
   }

   public IBlockData a(World var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      IBlockData var9 = this.getBlockData();
      if(var3.k().c()) {
         var9 = var9.set(a, var3).set(b, Boolean.valueOf(false));
         var9 = var9.set(N, var5 > 0.5F?class_alr.class_a_in_class_alr.a:class_alr.class_a_in_class_alr.b);
      }

      return var9;
   }

   public boolean b(World var1, class_cj var2, class_cq var3) {
      return true;
   }

   protected static class_cq b(int var0) {
      switch(var0 & 3) {
      case 0:
         return class_cq.c;
      case 1:
         return class_cq.d;
      case 2:
         return class_cq.e;
      case 3:
      default:
         return class_cq.f;
      }
   }

   protected static int a(class_cq var0) {
      switch(class_alr.SyntheticClass_1.a[var0.ordinal()]) {
      case 1:
         return 0;
      case 2:
         return 1;
      case 3:
         return 2;
      case 4:
      default:
         return 3;
      }
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, b(var1)).set(b, Boolean.valueOf((var1 & 4) != 0)).set(N, (var1 & 8) == 0?class_alr.class_a_in_class_alr.b:class_alr.class_a_in_class_alr.a);
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | a((class_cq)var1.get(a));
      if(((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 4;
      }

      if(var1.get(N) == class_alr.class_a_in_class_alr.a) {
         var3 |= 8;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((class_cq)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((class_cq)var1.get(a)));
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b, N});
   }

   static {
      a = class_aiv.O;
      b = class_anw.a("open");
      N = BlockStateEnum.of("half", class_alr.class_a_in_class_alr.class);
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

   public static enum class_a_in_class_alr implements INamable {
      a("top"),
      b("bottom");

      private final String c;

      private class_a_in_class_alr(String var3) {
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
