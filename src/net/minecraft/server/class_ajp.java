package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockStepAbstract;
import net.minecraft.server.BlockSand;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateBoolean;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.INamable;
import net.minecraft.server.CreativeTab;

public abstract class class_ajp extends BlockStepAbstract {
   public static final BlockStateBoolean b = BlockStateBoolean.of("seamless");
   public static final BlockStateEnum N = BlockStateEnum.of("variant", class_ajp.class_a_in_class_ajp.class);

   public class_ajp() {
      super(Material.STONE);
      IBlockData var1 = this.blockStateList.getFirst();
      if(this.isDouble()) {
         var1 = var1.set(b, Boolean.valueOf(false));
      } else {
         var1 = var1.set(HALF, BlockStepAbstract.EnumSlabHalf.BOTTOM);
      }

      this.setBlockData(var1.set(N, class_ajp.class_a_in_class_ajp.a));
      this.setCreativeTab((CreativeTab)CreativeTab.BUILDING_BLOCKS);
   }

   public String getName() {
      return LocaleI18n.get(this.getInternalName() + ".red_sandstone.name");
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getItemOf((Block)Blocks.STONE_SLAB2);
   }

   public String b(int var1) {
      return super.getInternalName() + "." + class_ajp.class_a_in_class_ajp.a(var1).d();
   }

   public IBlockState getVariant() {
      return N;
   }

   public Object a(ItemStack var1) {
      return class_ajp.class_a_in_class_ajp.a(var1.i() & 7);
   }

   public IBlockData fromLegacyData(int var1) {
      IBlockData var2 = this.getBlockData().set(N, class_ajp.class_a_in_class_ajp.a(var1 & 7));
      if(this.isDouble()) {
         var2 = var2.set(b, Boolean.valueOf((var1 & 8) != 0));
      } else {
         var2 = var2.set(HALF, (var1 & 8) == 0?BlockStepAbstract.EnumSlabHalf.BOTTOM:BlockStepAbstract.EnumSlabHalf.TOP);
      }

      return var2;
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_ajp.class_a_in_class_ajp)var1.get(N)).a();
      if(this.isDouble()) {
         if(((Boolean)var1.get(b)).booleanValue()) {
            var3 |= 8;
         }
      } else if(var1.get(HALF) == BlockStepAbstract.EnumSlabHalf.TOP) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockStateList getStateList() {
      return this.isDouble()?new BlockStateList(this, new IBlockState[]{b, N}):new BlockStateList(this, new IBlockState[]{HALF, N});
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return ((class_ajp.class_a_in_class_ajp)var1.get(N)).c();
   }

   public int getDropData(IBlockData var1) {
      return ((class_ajp.class_a_in_class_ajp)var1.get(N)).a();
   }

   public static enum class_a_in_class_ajp implements INamable {
      a(0, "red_sandstone", BlockSand.EnumSandVariant.RED_SAND.getMapColor());

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
