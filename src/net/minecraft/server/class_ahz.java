package net.minecraft.server;

import java.util.List;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aav;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aia;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_ahz extends Block {
   public static final class_anw a = class_anw.a("north");
   public static final class_anw b = class_anw.a("east");
   public static final class_anw N = class_anw.a("south");
   public static final class_anw O = class_anw.a("west");

   public class_ahz(Material var1) {
      this(var1, var1.getMapColor());
   }

   public class_ahz(Material var1, MaterialMapColor var2) {
      super(var1, var2);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)));
      this.a(CreativeTab.c);
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_awf var4, List var5, class_pr var6) {
      boolean var7 = this.e(var1, var2.shiftNorth());
      boolean var8 = this.e(var1, var2.shiftSouth());
      boolean var9 = this.e(var1, var2.shiftWest());
      boolean var10 = this.e(var1, var2.shiftEast());
      float var11 = 0.375F;
      float var12 = 0.625F;
      float var13 = 0.375F;
      float var14 = 0.625F;
      if(var7) {
         var13 = 0.0F;
      }

      if(var8) {
         var14 = 1.0F;
      }

      if(var7 || var8) {
         this.setSizes(var11, 0.0F, var13, var12, 1.5F, var14);
         super.a(var1, var2, var3, var4, var5, var6);
      }

      var13 = 0.375F;
      var14 = 0.625F;
      if(var9) {
         var11 = 0.0F;
      }

      if(var10) {
         var12 = 1.0F;
      }

      if(var9 || var10 || !var7 && !var8) {
         this.setSizes(var11, 0.0F, var13, var12, 1.5F, var14);
         super.a(var1, var2, var3, var4, var5, var6);
      }

      if(var7) {
         var13 = 0.0F;
      }

      if(var8) {
         var14 = 1.0F;
      }

      this.setSizes(var11, 0.0F, var13, var12, 1.0F, var14);
   }

   public void a(class_aer var1, BlockPosition var2) {
      boolean var3 = this.e(var1, var2.shiftNorth());
      boolean var4 = this.e(var1, var2.shiftSouth());
      boolean var5 = this.e(var1, var2.shiftWest());
      boolean var6 = this.e(var1, var2.shiftEast());
      float var7 = 0.375F;
      float var8 = 0.625F;
      float var9 = 0.375F;
      float var10 = 0.625F;
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

      this.setSizes(var7, 0.0F, var9, var8, 1.0F, var10);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isPassable(class_aer var1, BlockPosition var2) {
      return false;
   }

   public boolean e(class_aer var1, BlockPosition var2) {
      Block var3 = var1.p(var2).getBlock();
      return var3 == Blocks.BARRIER?false:((!(var3 instanceof class_ahz) || var3.material != this.material) && !(var3 instanceof class_aia)?(var3.material.isOpaque() && var3.isFullCube()?var3.material != Material.PUMPKIN:false):true);
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, EnumDirection var7, float var8, float var9, float var10) {
      return var1.D?true:class_aav.a(var4, var1, var2);
   }

   public int toLegacyData(IBlockData var1) {
      return 0;
   }

   public IBlockData a(IBlockData var1, class_aer var2, BlockPosition var3) {
      return var1.set(a, Boolean.valueOf(this.e(var2, var3.shiftNorth()))).set(b, Boolean.valueOf(this.e(var2, var3.shiftEast()))).set(N, Boolean.valueOf(this.e(var2, var3.shiftSouth()))).set(O, Boolean.valueOf(this.e(var2, var3.shiftWest())));
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_ahz.SyntheticClass_1.a[var2.ordinal()]) {
         case 1:
            return var1.set(a, var1.get(N)).set(b, var1.get(O)).set(N, var1.get(a)).set(O, var1.get(b));
         case 2:
            return var1.set(a, var1.get(b)).set(b, var1.get(N)).set(N, var1.get(O)).set(O, var1.get(a));
         case 3:
            return var1.set(a, var1.get(O)).set(b, var1.get(a)).set(N, var1.get(b)).set(O, var1.get(N));
         default:
            return var1;
         }
      }
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_ahz.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            return var1.set(a, var1.get(N)).set(N, var1.get(a));
         case 2:
            return var1.set(b, var1.get(O)).set(O, var1.get(b));
         default:
            return super.a(var1, var2);
         }
      }
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b, O, N});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            b[Block.class_a_in_class_agj.b.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[Block.class_a_in_class_agj.c.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[Block.class_c_in_class_agj.values().length];

         try {
            a[Block.class_c_in_class_agj.c.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.d.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.b.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
