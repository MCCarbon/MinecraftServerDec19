package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahx;
import net.minecraft.server.class_aiv;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anx;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fb;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_op;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_vl;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yb;
import net.minecraft.server.CreativeTab;

public class class_aga extends class_ahx {
   public static final class_anx a;
   public static final class_anz b;

   protected class_aga() {
      super(Material.HEAVY);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH).set(b, Integer.valueOf(0)));
      this.setLightOpacity(0);
      this.a((CreativeTab)CreativeTab.c);
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      EnumDirection var9 = var8.aR().rotateY();
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8).set(a, var9).set(b, Integer.valueOf(var7 >> 2));
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, class_aas var6, EnumDirection var7, float var8, float var9, float var10) {
      if(!var1.D) {
         var4.a((class_op)(new class_aga.class_a_in_class_aga(var1, var2)));
      }

      return true;
   }

   public int getDropData(IBlockData var1) {
      return ((Integer)var1.get(b)).intValue();
   }

   public void a(class_aer var1, BlockPosition var2) {
      EnumDirection var3 = (EnumDirection)var1.p(var2).get(a);
      if(var3.getAxis() == EnumDirection.EnumAxis.X) {
         this.setSizes(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
      } else {
         this.setSizes(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
      }

   }

   protected void a(class_vl var1) {
      var1.a(true);
   }

   public void a_(World var1, BlockPosition var2) {
      var1.b(1022, var2, 0);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, EnumDirection.getByHorizontalId(var1 & 3)).set(b, Integer.valueOf((var1 & 15) >> 2));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(a)).getHorizontalId();
      var3 |= ((Integer)var1.get(b)).intValue() << 2;
      return var3;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b});
   }

   static {
      a = class_aiv.O;
      b = class_anz.a("damage", 0, 2);
   }

   public static class class_a_in_class_aga implements class_op {
      private final World a;
      private final BlockPosition b;

      public class_a_in_class_aga(World var1, BlockPosition var2) {
         this.a = var1;
         this.b = var2;
      }

      public String e_() {
         return "anvil";
      }

      public boolean l_() {
         return false;
      }

      public IChatBaseComponent f_() {
         return new class_fb(Blocks.ANVIL.getInternalName() + ".name", new Object[0]);
      }

      public class_xz a(class_wz var1, class_xa var2) {
         return new class_yb(var1, this.a, this.b, var2);
      }

      public String k() {
         return "minecraft:anvil";
      }
   }
}
