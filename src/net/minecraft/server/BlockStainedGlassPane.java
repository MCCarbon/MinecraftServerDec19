package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.BlockBeacon;
import net.minecraft.server.Block;
import net.minecraft.server.class_aln;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.EnumColor;

public class BlockStainedGlassPane extends class_aln {
   public static final BlockStateEnum a = BlockStateEnum.of("color", EnumColor.class);

   public BlockStainedGlassPane() {
      super(Material.SHATTERABLE, false);
      this.setBlockData(this.blockStateList.getFirst().set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)).set(P, Boolean.valueOf(false)).set(a, EnumColor.a));
      this.setCreativeTab(CreativeTab.DECORATIONS);
   }

   public int getDropData(IBlockData var1) {
      return ((EnumColor)var1.get(a)).a();
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return ((EnumColor)var1.get(a)).e();
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, EnumColor.b(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((EnumColor)var1.get(a)).a();
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(BlockStainedGlassPane.SyntheticClass_1.a[var2.ordinal()]) {
         case 1:
            return var1.set(b, var1.get(O)).set(N, var1.get(P)).set(O, var1.get(b)).set(P, var1.get(N));
         case 2:
            return var1.set(b, var1.get(N)).set(N, var1.get(O)).set(O, var1.get(P)).set(P, var1.get(b));
         case 3:
            return var1.set(b, var1.get(P)).set(N, var1.get(b)).set(O, var1.get(N)).set(P, var1.get(O));
         default:
            return var1;
         }
      }
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(BlockStainedGlassPane.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            return var1.set(b, var1.get(O)).set(O, var1.get(b));
         case 2:
            return var1.set(N, var1.get(P)).set(P, var1.get(N));
         default:
            return super.a(var1, var2);
         }
      }
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{b, N, P, O, a});
   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.isClientSide) {
         BlockBeacon.f(var1, var2);
      }

   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.isClientSide) {
         BlockBeacon.f(var1, var2);
      }

   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            b[Block.class_a_in_class_agj.LEFT_RIGHT.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[Block.class_a_in_class_agj.FRONT_BACK.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[Block.EnumRotation.values().length];

         try {
            a[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
