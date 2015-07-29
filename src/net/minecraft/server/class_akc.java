package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.INamable;
import net.minecraft.server.CreativeTab;

public class class_akc extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("variant", class_akc.class_a_in_class_akc.class);
   public static final int b;
   public static final int N;
   public static final int O;

   public class_akc() {
      super(Material.e);
      this.setBlockData(this.blockStateList.getFirst().set(a, class_akc.class_a_in_class_akc.a));
      this.a(CreativeTab.b);
   }

   public String getName() {
      return LocaleI18n.get(this.getInternalName() + "." + class_akc.class_a_in_class_akc.a.c() + ".name");
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return var1.get(a) == class_akc.class_a_in_class_akc.a?MaterialMapColor.y:MaterialMapColor.G;
   }

   public int getDropData(IBlockData var1) {
      return ((class_akc.class_a_in_class_akc)var1.get(a)).a();
   }

   public int toLegacyData(IBlockData var1) {
      return ((class_akc.class_a_in_class_akc)var1.get(a)).a();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, class_akc.class_a_in_class_akc.a(var1));
   }

   static {
      b = class_akc.class_a_in_class_akc.a.a();
      N = class_akc.class_a_in_class_akc.b.a();
      O = class_akc.class_a_in_class_akc.c.a();
   }

   public static enum class_a_in_class_akc implements INamable {
      a(0, "prismarine", "rough"),
      b(1, "prismarine_bricks", "bricks"),
      c(2, "dark_prismarine", "dark");

      private static final class_akc.class_a_in_class_akc[] d;
      private final int e;
      private final String f;
      private final String g;

      private class_a_in_class_akc(int var3, String var4, String var5) {
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

      public static class_akc.class_a_in_class_akc a(int var0) {
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
         d = new class_akc.class_a_in_class_akc[values().length];
         class_akc.class_a_in_class_akc[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_akc.class_a_in_class_akc var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }
   }
}
