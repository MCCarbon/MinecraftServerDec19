package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.class_akq;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.INamable;
import net.minecraft.server.CreativeTab;

public class class_aki extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("type", class_aki.class_a_in_class_aki.class);

   public class_aki() {
      super(Material.e, class_akq.class_a_in_class_akq.b.c());
      this.setBlockData(this.blockStateList.getFirst().set(a, class_aki.class_a_in_class_aki.a));
      this.a(CreativeTab.b);
   }

   public int getDropData(IBlockData var1) {
      return ((class_aki.class_a_in_class_aki)var1.get(a)).a();
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, class_aki.class_a_in_class_aki.a(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((class_aki.class_a_in_class_aki)var1.get(a)).a();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   public static enum class_a_in_class_aki implements INamable {
      a(0, "red_sandstone", "default"),
      b(1, "chiseled_red_sandstone", "chiseled"),
      c(2, "smooth_red_sandstone", "smooth");

      private static final class_aki.class_a_in_class_aki[] d;
      private final int e;
      private final String f;
      private final String g;

      private class_a_in_class_aki(int var3, String var4, String var5) {
         this.e = var3;
         this.f = var4;
         this.g = var5;
      }

      public int a() {
         return this.e;
      }

      public String toString() {
         return this.f;
      }

      public static class_aki.class_a_in_class_aki a(int var0) {
         if(var0 < 0 || var0 >= d.length) {
            var0 = 0;
         }

         return d[var0];
      }

      public String getName() {
         return this.f;
      }

      public String c() {
         return this.g;
      }

      static {
         d = new class_aki.class_a_in_class_aki[values().length];
         class_aki.class_a_in_class_aki[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_aki.class_a_in_class_aki var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }
   }
}
