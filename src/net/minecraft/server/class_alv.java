package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.class_aia;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateBoolean;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.INamable;
import net.minecraft.server.CreativeTab;

public class class_alv extends Block {
   public static final BlockStateBoolean a = BlockStateBoolean.of("up");
   public static final BlockStateBoolean b = BlockStateBoolean.of("north");
   public static final BlockStateBoolean N = BlockStateBoolean.of("east");
   public static final BlockStateBoolean O = BlockStateBoolean.of("south");
   public static final BlockStateBoolean P = BlockStateBoolean.of("west");
   public static final BlockStateEnum Q = BlockStateEnum.of("variant", class_alv.class_a_in_class_alv.class);

   public class_alv(Block var1) {
      super(var1.material);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)).set(P, Boolean.valueOf(false)).set(Q, class_alv.class_a_in_class_alv.a));
      this.setStrength(var1.strength);
      this.setExplosionResist(var1.explosionResist / 3.0F);
      this.setStepSound(var1.stepSound);
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public String getName() {
      return LocaleI18n.get(this.getInternalName() + "." + class_alv.class_a_in_class_alv.a.c() + ".name");
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isPassable(IBlockAccess var1, BlockPosition var2) {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      boolean var3 = this.e(var1, var2.north());
      boolean var4 = this.e(var1, var2.south());
      boolean var5 = this.e(var1, var2.west());
      boolean var6 = this.e(var1, var2.east());
      float var7 = 0.25F;
      float var8 = 0.75F;
      float var9 = 0.25F;
      float var10 = 0.75F;
      float var11 = 1.0F;
      if(var3) {
         var9 = 0.0F;
      }

      if(var4) {
         var10 = 1.0F;
      }

      if(var5) {
         var7 = 0.0F;
      }

      if(var6) {
         var8 = 1.0F;
      }

      if(var3 && var4 && !var5 && !var6) {
         var11 = 0.8125F;
         var7 = 0.3125F;
         var8 = 0.6875F;
      } else if(!var3 && !var4 && var5 && var6) {
         var11 = 0.8125F;
         var9 = 0.3125F;
         var10 = 0.6875F;
      }

      this.setSizes(var7, 0.0F, var9, var8, var11, var10);
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      this.isReplaceable(var1, var2);
      this.maxY = 1.5D;
      return super.getBoundingBox(var1, var2, var3);
   }

   public boolean e(IBlockAccess var1, BlockPosition var2) {
      Block var3 = var1.getType(var2).getBlock();
      return var3 == BlockStainedGlassPane.BARRIER?false:(var3 != this && !(var3 instanceof class_aia)?(var3.material.isOpaque() && var3.isFullCube()?var3.material != Material.PUMPKIN:false):true);
   }

   public int getDropData(IBlockData var1) {
      return ((class_alv.class_a_in_class_alv)var1.get(Q)).a();
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(Q, class_alv.class_a_in_class_alv.a(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((class_alv.class_a_in_class_alv)var1.get(Q)).a();
   }

   public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
      boolean var4 = this.e(var2, var3.north());
      boolean var5 = this.e(var2, var3.east());
      boolean var6 = this.e(var2, var3.south());
      boolean var7 = this.e(var2, var3.west());
      boolean var8 = var4 && !var5 && var6 && !var7 || !var4 && var5 && !var6 && var7;
      return var1.set(a, Boolean.valueOf(!var8 || !var2.isEmpty(var3.up()))).set(b, Boolean.valueOf(var4)).set(N, Boolean.valueOf(var5)).set(O, Boolean.valueOf(var6)).set(P, Boolean.valueOf(var7));
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b, N, P, O, Q});
   }

   public static enum class_a_in_class_alv implements INamable {
      a(0, "cobblestone", "normal"),
      b(1, "mossy_cobblestone", "mossy");

      private static final class_alv.class_a_in_class_alv[] c;
      private final int d;
      private final String e;
      private String f;

      private class_a_in_class_alv(int var3, String var4, String var5) {
         this.d = var3;
         this.e = var4;
         this.f = var5;
      }

      public int a() {
         return this.d;
      }

      public String toString() {
         return this.e;
      }

      public static class_alv.class_a_in_class_alv a(int var0) {
         if(var0 < 0 || var0 >= c.length) {
            var0 = 0;
         }

         return c[var0];
      }

      public String getName() {
         return this.e;
      }

      public String c() {
         return this.f;
      }

      static {
         c = new class_alv.class_a_in_class_alv[values().length];
         class_alv.class_a_in_class_alv[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_alv.class_a_in_class_alv var3 = var0[var2];
            c[var3.a()] = var3;
         }

      }
   }
}
