package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.INamable;
import net.minecraft.server.class_qa;
import net.minecraft.server.CreativeTab;

public class class_akf extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("variant", class_akf.class_a_in_class_akf.class);

   public class_akf() {
      super(Material.STONE);
      this.setBlockData(this.blockStateList.getFirst().set(a, class_akf.class_a_in_class_akf.a));
      this.a(CreativeTab.b);
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      if(var7 == class_akf.class_a_in_class_akf.c.a()) {
         switch(class_akf.SyntheticClass_1.a[var3.getAxis().ordinal()]) {
         case 1:
            return this.getBlockData().set(a, class_akf.class_a_in_class_akf.e);
         case 2:
            return this.getBlockData().set(a, class_akf.class_a_in_class_akf.d);
         case 3:
         default:
            return this.getBlockData().set(a, class_akf.class_a_in_class_akf.c);
         }
      } else {
         return var7 == class_akf.class_a_in_class_akf.b.a()?this.getBlockData().set(a, class_akf.class_a_in_class_akf.b):this.getBlockData().set(a, class_akf.class_a_in_class_akf.a);
      }
   }

   public int getDropData(IBlockData var1) {
      class_akf.class_a_in_class_akf var2 = (class_akf.class_a_in_class_akf)var1.get(a);
      return var2 != class_akf.class_a_in_class_akf.d && var2 != class_akf.class_a_in_class_akf.e?var2.a():class_akf.class_a_in_class_akf.c.a();
   }

   protected class_aas i(IBlockData var1) {
      class_akf.class_a_in_class_akf var2 = (class_akf.class_a_in_class_akf)var1.get(a);
      return var2 != class_akf.class_a_in_class_akf.d && var2 != class_akf.class_a_in_class_akf.e?super.i(var1):new class_aas(Item.getByBlock((Block)this), 1, class_akf.class_a_in_class_akf.c.a());
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.COLOR15;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, class_akf.class_a_in_class_akf.a(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((class_akf.class_a_in_class_akf)var1.get(a)).a();
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_akf.SyntheticClass_1.c[var2.ordinal()]) {
         case 1:
         case 2:
            switch(class_akf.SyntheticClass_1.b[((class_akf.class_a_in_class_akf)var1.get(a)).ordinal()]) {
            case 1:
               return var1.set(a, class_akf.class_a_in_class_akf.e);
            case 2:
               return var1.set(a, class_akf.class_a_in_class_akf.d);
            default:
               return var1;
            }
         default:
            return var1;
         }
      }
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c = new int[Block.class_c_in_class_agj.values().length];

      static {
         try {
            c[Block.class_c_in_class_agj.d.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            c[Block.class_c_in_class_agj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
            ;
         }

         b = new int[class_akf.class_a_in_class_akf.values().length];

         try {
            b[class_akf.class_a_in_class_akf.d.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[class_akf.class_a_in_class_akf.e.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[EnumDirection.EnumAxis.values().length];

         try {
            a[EnumDirection.EnumAxis.Z.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.EnumAxis.X.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.EnumAxis.Y.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_akf implements INamable {
      a(0, "default", "default"),
      b(1, "chiseled", "chiseled"),
      c(2, "lines_y", "lines"),
      d(3, "lines_x", "lines"),
      e(4, "lines_z", "lines");

      private static final class_akf.class_a_in_class_akf[] f;
      private final int g;
      private final String h;
      private final String i;

      private class_a_in_class_akf(int var3, String var4, String var5) {
         this.g = var3;
         this.h = var4;
         this.i = var5;
      }

      public int a() {
         return this.g;
      }

      public String toString() {
         return this.i;
      }

      public static class_akf.class_a_in_class_akf a(int var0) {
         if(var0 < 0 || var0 >= f.length) {
            var0 = 0;
         }

         return f[var0];
      }

      public String getName() {
         return this.h;
      }

      static {
         f = new class_akf.class_a_in_class_akf[values().length];
         class_akf.class_a_in_class_akf[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_akf.class_a_in_class_akf var3 = var0[var2];
            f[var3.a()] = var3;
         }

      }
   }
}
