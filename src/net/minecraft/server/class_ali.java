package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.INamable;
import net.minecraft.server.CreativeTab;

public class class_ali extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("variant", class_ali.class_a_in_class_ali.class);
   public static final int b;
   public static final int N;
   public static final int O;
   public static final int P;

   public class_ali() {
      super(Material.e);
      this.setBlockData(this.blockStateList.getFirst().set(a, class_ali.class_a_in_class_ali.a));
      this.a(CreativeTab.b);
   }

   public int getDropData(IBlockData var1) {
      return ((class_ali.class_a_in_class_ali)var1.get(a)).a();
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, class_ali.class_a_in_class_ali.a(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((class_ali.class_a_in_class_ali)var1.get(a)).a();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   static {
      b = class_ali.class_a_in_class_ali.a.a();
      N = class_ali.class_a_in_class_ali.b.a();
      O = class_ali.class_a_in_class_ali.c.a();
      P = class_ali.class_a_in_class_ali.d.a();
   }

   public static enum class_a_in_class_ali implements INamable {
      a(0, "stonebrick", "default"),
      b(1, "mossy_stonebrick", "mossy"),
      c(2, "cracked_stonebrick", "cracked"),
      d(3, "chiseled_stonebrick", "chiseled");

      private static final class_ali.class_a_in_class_ali[] e;
      private final int f;
      private final String g;
      private final String h;

      private class_a_in_class_ali(int var3, String var4, String var5) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
      }

      public int a() {
         return this.f;
      }

      public String toString() {
         return this.g;
      }

      public static class_ali.class_a_in_class_ali a(int var0) {
         if(var0 < 0 || var0 >= e.length) {
            var0 = 0;
         }

         return e[var0];
      }

      public String getName() {
         return this.g;
      }

      public String c() {
         return this.h;
      }

      static {
         e = new class_ali.class_a_in_class_ali[values().length];
         class_ali.class_a_in_class_ali[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_ali.class_a_in_class_ali var3 = var0[var2];
            e[var3.a()] = var3;
         }

      }
   }
}
