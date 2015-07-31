package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aio;
import net.minecraft.server.class_akq;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.INamable;
import net.minecraft.server.CreativeTab;

public abstract class class_ajp extends class_aio {
   public static final class_anw b = class_anw.a("seamless");
   public static final BlockStateEnum N = BlockStateEnum.of("variant", class_ajp.class_a_in_class_ajp.class);

   public class_ajp() {
      super(Material.STONE);
      IBlockData var1 = this.blockStateList.getFirst();
      if(this.l()) {
         var1 = var1.set(b, Boolean.valueOf(false));
      } else {
         var1 = var1.set(a, class_aio.class_a_in_class_aio.b);
      }

      this.setBlockData(var1.set(N, class_ajp.class_a_in_class_ajp.a));
      this.a((CreativeTab)CreativeTab.b);
   }

   public String getName() {
      return LocaleI18n.get(this.getInternalName() + ".red_sandstone.name");
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getByBlock((Block)Blocks.STONE_SLAB2);
   }

   public String b(int var1) {
      return super.getInternalName() + "." + class_ajp.class_a_in_class_ajp.a(var1).d();
   }

   public IBlockState n() {
      return N;
   }

   public Object a(ItemStack var1) {
      return class_ajp.class_a_in_class_ajp.a(var1.i() & 7);
   }

   public IBlockData fromLegacyData(int var1) {
      IBlockData var2 = this.getBlockData().set(N, class_ajp.class_a_in_class_ajp.a(var1 & 7));
      if(this.l()) {
         var2 = var2.set(b, Boolean.valueOf((var1 & 8) != 0));
      } else {
         var2 = var2.set(a, (var1 & 8) == 0?class_aio.class_a_in_class_aio.b:class_aio.class_a_in_class_aio.a);
      }

      return var2;
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_ajp.class_a_in_class_ajp)var1.get(N)).a();
      if(this.l()) {
         if(((Boolean)var1.get(b)).booleanValue()) {
            var3 |= 8;
         }
      } else if(var1.get(a) == class_aio.class_a_in_class_aio.a) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockStateList createBlockStateList() {
      return this.l()?new BlockStateList(this, new IBlockState[]{b, N}):new BlockStateList(this, new IBlockState[]{a, N});
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return ((class_ajp.class_a_in_class_ajp)var1.get(N)).c();
   }

   public int getDropData(IBlockData var1) {
      return ((class_ajp.class_a_in_class_ajp)var1.get(N)).a();
   }

   public static enum class_a_in_class_ajp implements INamable {
      a(0, "red_sandstone", class_akq.class_a_in_class_akq.b.c());

      private static final class_ajp.class_a_in_class_ajp[] b;
      private final int c;
      private final String d;
      private final MaterialMapColor e;

      private class_a_in_class_ajp(int var3, String var4, MaterialMapColor var5) {
         this.c = var3;
         this.d = var4;
         this.e = var5;
      }

      public int a() {
         return this.c;
      }

      public MaterialMapColor c() {
         return this.e;
      }

      public String toString() {
         return this.d;
      }

      public static class_ajp.class_a_in_class_ajp a(int var0) {
         if(var0 < 0 || var0 >= b.length) {
            var0 = 0;
         }

         return b[var0];
      }

      public String getName() {
         return this.d;
      }

      public String d() {
         return this.d;
      }

      static {
         b = new class_ajp.class_a_in_class_ajp[values().length];
         class_ajp.class_a_in_class_ajp[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_ajp.class_a_in_class_ajp var3 = var0[var2];
            b[var3.a()] = var3;
         }

      }
   }
}
