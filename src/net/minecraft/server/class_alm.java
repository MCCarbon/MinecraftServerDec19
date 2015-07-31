package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_ahm;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_nc;
import net.minecraft.server.INamable;
import net.minecraft.server.class_xa;

public class class_alm extends class_ago implements class_agl {
   public static final BlockStateEnum a = BlockStateEnum.of("type", class_alm.class_a_in_class_alm.class);

   protected class_alm() {
      super(Material.REPLACEABLE_PLANT);
      this.setBlockData(this.blockStateList.getFirst().set(a, class_alm.class_a_in_class_alm.a));
      float var1 = 0.4F;
      this.setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
   }

   public boolean f(World var1, BlockPosition var2, IBlockData var3) {
      return this.c(var1.p(var2.shiftDown()).getBlock());
   }

   public boolean isReplaceable(World var1, BlockPosition var2) {
      return true;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return var2.nextInt(8) == 0?Items.P:null;
   }

   public int a(int var1, Random var2) {
      return 1 + var2.nextInt(var1 * 2 + 1);
   }

   public void a(World var1, class_xa var2, BlockPosition var3, IBlockData var4, class_amg var5, ItemStack var6) {
      if(!var1.D && var6 != null && var6.getItem() == Items.bg) {
         var2.b(class_nc.ab[Block.getId((Block)this)]);
         a(var1, var3, new ItemStack(Blocks.TALLGRASS, 1, ((class_alm.class_a_in_class_alm)var4.get(a)).a()));
      } else {
         super.a(var1, var2, var3, var4, var5, var6);
      }

   }

   public int j(World var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      return var3.getBlock().toLegacyData(var3);
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, boolean var4) {
      return var3.get(a) != class_alm.class_a_in_class_alm.a;
   }

   public boolean a(World var1, Random var2, BlockPosition var3, IBlockData var4) {
      return true;
   }

   public void b(World var1, Random var2, BlockPosition var3, IBlockData var4) {
      class_ahm.class_b_in_class_ahm var5 = class_ahm.class_b_in_class_ahm.c;
      if(var4.get(a) == class_alm.class_a_in_class_alm.c) {
         var5 = class_ahm.class_b_in_class_ahm.d;
      }

      if(Blocks.DOUBLE_PLANT.d(var1, var3)) {
         Blocks.DOUBLE_PLANT.a(var1, var3, var5, 2);
      }

   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, class_alm.class_a_in_class_alm.a(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((class_alm.class_a_in_class_alm)var1.get(a)).a();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   public static enum class_a_in_class_alm implements INamable {
      a(0, "dead_bush"),
      b(1, "tall_grass"),
      c(2, "fern");

      private static final class_alm.class_a_in_class_alm[] d;
      private final int e;
      private final String f;

      private class_a_in_class_alm(int var3, String var4) {
         this.e = var3;
         this.f = var4;
      }

      public int a() {
         return this.e;
      }

      public String toString() {
         return this.f;
      }

      public static class_alm.class_a_in_class_alm a(int var0) {
         if(var0 < 0 || var0 >= d.length) {
            var0 = 0;
         }

         return d[var0];
      }

      public String getName() {
         return this.f;
      }

      static {
         d = new class_alm.class_a_in_class_alm[values().length];
         class_alm.class_a_in_class_alm[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_alm.class_a_in_class_alm var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }
   }
}
