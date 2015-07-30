package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amr;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anx;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ol;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;

public class class_aih extends class_agd {
   public static final class_anx a;
   private final boolean b;
   private static boolean N;

   protected class_aih(boolean var1) {
      super(Material.STONE);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH));
      this.b = var1;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getByBlock(Blocks.FURNACE);
   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      this.e(var1, var2, var3);
   }

   private void e(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.D) {
         Block var4 = var1.p(var2.shiftNorth()).getBlock();
         Block var5 = var1.p(var2.shiftSouth()).getBlock();
         Block var6 = var1.p(var2.shiftWest()).getBlock();
         Block var7 = var1.p(var2.shiftEast()).getBlock();
         EnumDirection var8 = (EnumDirection)var3.get(a);
         if(var8 == EnumDirection.NORTH && var4.isFullBlock() && !var5.isFullBlock()) {
            var8 = EnumDirection.SOUTH;
         } else if(var8 == EnumDirection.SOUTH && var5.isFullBlock() && !var4.isFullBlock()) {
            var8 = EnumDirection.NORTH;
         } else if(var8 == EnumDirection.WEST && var6.isFullBlock() && !var7.isFullBlock()) {
            var8 = EnumDirection.EAST;
         } else if(var8 == EnumDirection.EAST && var7.isFullBlock() && !var6.isFullBlock()) {
            var8 = EnumDirection.WEST;
         }

         var1.a((BlockPosition)var2, (IBlockData)var3.set(a, var8), 2);
      }
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, class_aas var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         if(var11 instanceof class_amr) {
            var4.a((class_oj)((class_amr)var11));
            var4.b(class_nc.Y);
         }

         return true;
      }
   }

   public static void a(boolean var0, World var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      class_amg var4 = var1.s(var2);
      N = true;
      if(var0) {
         var1.a((BlockPosition)var2, (IBlockData)Blocks.LIT_FURNACE.getBlockData().set(a, var3.get(a)), 3);
         var1.a((BlockPosition)var2, (IBlockData)Blocks.LIT_FURNACE.getBlockData().set(a, var3.get(a)), 3);
      } else {
         var1.a((BlockPosition)var2, (IBlockData)Blocks.FURNACE.getBlockData().set(a, var3.get(a)), 3);
         var1.a((BlockPosition)var2, (IBlockData)Blocks.FURNACE.getBlockData().set(a, var3.get(a)), 3);
      }

      N = false;
      if(var4 != null) {
         var4.D();
         var1.a(var2, var4);
      }

   }

   public class_amg a(World var1, int var2) {
      return new class_amr();
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.getBlockData().set(a, var8.aR().getOpposite());
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, class_aas var5) {
      var1.a((BlockPosition)var2, (IBlockData)var3.set(a, var4.aR().getOpposite()), 2);
      if(var5.s()) {
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_amr) {
            ((class_amr)var6).a(var5.q());
         }
      }

   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      if(!N) {
         class_amg var4 = var1.s(var2);
         if(var4 instanceof class_amr) {
            class_ol.a(var1, (BlockPosition)var2, (class_amr)var4);
            var1.e(var2, this);
         }
      }

      super.b(var1, var2, var3);
   }

   public boolean Q() {
      return true;
   }

   public int l(World var1, BlockPosition var2) {
      return class_xz.a(var1.s(var2));
   }

   public int getRenderType() {
      return 3;
   }

   public IBlockData fromLegacyData(int var1) {
      EnumDirection var2 = EnumDirection.getById(var1);
      if(var2.getAxis() == EnumDirection.EnumAxis.Y) {
         var2 = EnumDirection.NORTH;
      }

      return this.getBlockData().set(a, var2);
   }

   public int toLegacyData(IBlockData var1) {
      return ((EnumDirection)var1.get(a)).getId();
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(a)));
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   static {
      a = class_aiv.O;
   }
}
