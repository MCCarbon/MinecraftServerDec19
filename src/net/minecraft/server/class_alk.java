package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aio;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.INamable;
import net.minecraft.server.CreativeTab;

public abstract class class_alk extends class_aio {
   public static final class_anw b = class_anw.a("seamless");
   public static final BlockStateEnum N = BlockStateEnum.of("variant", class_alk.class_a_in_class_alk.class);

   public class_alk() {
      super(Material.STONE);
      IBlockData var1 = this.blockStateList.getFirst();
      if(this.l()) {
         var1 = var1.set(b, Boolean.valueOf(false));
      } else {
         var1 = var1.set(a, class_aio.class_a_in_class_aio.b);
      }

      this.setBlockData(var1.set(N, class_alk.class_a_in_class_alk.a));
      this.a((CreativeTab)CreativeTab.b);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getByBlock((Block)Blocks.STONE_SLAB);
   }

   public String b(int var1) {
      return super.getInternalName() + "." + class_alk.class_a_in_class_alk.a(var1).d();
   }

   public IBlockState n() {
      return N;
   }

   public Object a(ItemStack var1) {
      return class_alk.class_a_in_class_alk.a(var1.i() & 7);
   }

   public IBlockData fromLegacyData(int var1) {
      IBlockData var2 = this.getBlockData().set(N, class_alk.class_a_in_class_alk.a(var1 & 7));
      if(this.l()) {
         var2 = var2.set(b, Boolean.valueOf((var1 & 8) != 0));
      } else {
         var2 = var2.set(a, (var1 & 8) == 0?class_aio.class_a_in_class_aio.b:class_aio.class_a_in_class_aio.a);
      }

      return var2;
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_alk.class_a_in_class_alk)var1.get(N)).a();
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

   public int getDropData(IBlockData var1) {
      return ((class_alk.class_a_in_class_alk)var1.get(N)).a();
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return ((class_alk.class_a_in_class_alk)var1.get(N)).c();
   }

   public static enum class_a_in_class_alk implements INamable {
       a(0, MaterialMapColor.COLOR12, "stone"),
       b(1, MaterialMapColor.COLOR3, "sandstone", "sand"),
       c(2, MaterialMapColor.COLOR14, "wood_old", "wood"),
       d(3, MaterialMapColor.COLOR12, "cobblestone", "cobble"),
       e(4, MaterialMapColor.COLOR29, "brick"),
       f(5, MaterialMapColor.COLOR12, "stone_brick", "smoothStoneBrick"),
       g(6, MaterialMapColor.COLOR36, "nether_brick", "netherBrick"),
       h(7, MaterialMapColor.COLOR15, "quartz");

      private static final class_alk.class_a_in_class_alk[] i;
      private final int j;
      private final MaterialMapColor k;
      private final String l;
      private final String m;

      private class_a_in_class_alk(int var3, MaterialMapColor var4, String var5) {
         this(var3, var4, var5, var5);
      }

      private class_a_in_class_alk(int var3, MaterialMapColor var4, String var5, String var6) {
         this.j = var3;
         this.k = var4;
         this.l = var5;
         this.m = var6;
      }

      public int a() {
         return this.j;
      }

      public MaterialMapColor c() {
         return this.k;
      }

      public String toString() {
         return this.l;
      }

      public static class_alk.class_a_in_class_alk a(int var0) {
         if(var0 < 0 || var0 >= i.length) {
            var0 = 0;
         }

         return i[var0];
      }

      public String getName() {
         return this.l;
      }

      public String d() {
         return this.m;
      }

      static {
         i = new class_alk.class_a_in_class_alk[values().length];
         class_alk.class_a_in_class_alk[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_alk.class_a_in_class_alk var3 = var0[var2];
            i[var3.a()] = var3;
         }

      }
   }
}
