package net.minecraft.server;

import java.util.List;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahi;
import net.minecraft.server.class_ahw;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anf;
import net.minecraft.server.class_ang;
import net.minecraft.server.class_anh;
import net.minecraft.server.class_ani;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.CreativeTab;

public class class_ane extends class_ahi {
   public static final class_anw a = class_anw.a("extended");
   private final boolean N;

   public class_ane(boolean var1) {
      super(Material.PISTON);
      this.setBlockData(this.blockStateList.getFirst().set(b, EnumDirection.NORTH).set(a, Boolean.valueOf(false)));
      this.N = var1;
      this.setStepSound(STEP_SOUND_STONE2);
      this.setStrength(0.5F);
      this.a(CreativeTab.d);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, class_aas var5) {
      var1.a((BlockPosition)var2, (IBlockData)var3.set(b, a(var1, var2, var4)), 2);
      if(!var1.D) {
         this.e(var1, var2, var3);
      }

   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!var1.D) {
         this.e(var1, var2, var3);
      }

   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.D && var1.s(var2) == null) {
         this.e(var1, var2, var3);
      }

   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.getBlockData().set(b, a(var1, var2, var8)).set(a, Boolean.valueOf(false));
   }

   private void e(World var1, BlockPosition var2, IBlockData var3) {
      EnumDirection var4 = (EnumDirection)var3.get(b);
      boolean var5 = this.a(var1, var2, var4);
      if(var5 && !((Boolean)var3.get(a)).booleanValue()) {
         if((new class_ani(var1, var2, var4, true)).a()) {
            var1.c(var2, this, 0, var4.getId());
         }
      } else if(!var5 && ((Boolean)var3.get(a)).booleanValue()) {
         var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(false)), 2);
         var1.c(var2, this, 1, var4.getId());
      }

   }

   private boolean a(World var1, BlockPosition var2, EnumDirection var3) {
      EnumDirection[] var4 = EnumDirection.values();
      int var5 = var4.length;

      int var6;
      for(var6 = 0; var6 < var5; ++var6) {
         EnumDirection var7 = var4[var6];
         if(var7 != var3 && var1.b(var2.shift(var7), var7)) {
            return true;
         }
      }

      if(var1.b(var2, EnumDirection.DOWN)) {
         return true;
      } else {
         BlockPosition var9 = var2.shiftUp();
         EnumDirection[] var10 = EnumDirection.values();
         var6 = var10.length;

         for(int var11 = 0; var11 < var6; ++var11) {
            EnumDirection var8 = var10[var11];
            if(var8 != EnumDirection.DOWN && var1.b(var9.shift(var8), var8)) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, int var4, int var5) {
      EnumDirection var6 = (EnumDirection)var3.get(b);
      if(!var1.D) {
         boolean var7 = this.a(var1, var2, var6);
         if(var7 && var4 == 1) {
            var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(true)), 2);
            return false;
         }

         if(!var7 && var4 == 0) {
            return false;
         }
      }

      if(var4 == 0) {
         if(!this.a(var1, var2, var6, true)) {
            return false;
         }

         var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(true)), 2);
         var1.a((double)var2.getX() + 0.5D, (double)var2.getY() + 0.5D, (double)var2.getZ() + 0.5D, "tile.piston.out", 0.5F, var1.s.nextFloat() * 0.25F + 0.6F);
      } else if(var4 == 1) {
         class_amg var13 = var1.s(var2.shift(var6));
         if(var13 instanceof class_ang) {
            ((class_ang)var13).h();
         }

         var1.a((BlockPosition)var2, (IBlockData)Blocks.PISTON_EXTENSION.getBlockData().set(class_anh.a, var6).set(class_anh.b, this.N?class_anf.class_a_in_class_anf.b:class_anf.class_a_in_class_anf.a), 3);
         var1.a(var2, class_anh.a(this.fromLegacyData(var5), var6, false, true));
         if(this.N) {
            BlockPosition var8 = var2.add(var6.getAdjacentX() * 2, var6.getAdjacentY() * 2, var6.getAdjacentZ() * 2);
            Block var9 = var1.p(var8).getBlock();
            boolean var10 = false;
            if(var9 == Blocks.PISTON_EXTENSION) {
               class_amg var11 = var1.s(var8);
               if(var11 instanceof class_ang) {
                  class_ang var12 = (class_ang)var11;
                  if(var12.e() == var6 && var12.d()) {
                     var12.h();
                     var10 = true;
                  }
               }
            }

            if(!var10 && var9.getMaterial() != Material.AIR && a(var9, var1, var8, var6.getOpposite(), false) && (var9.getPushReaction() == 0 || var9 == Blocks.PISTON || var9 == Blocks.STICKY_PISTON)) {
               this.a(var1, var2, var6, false);
            }
         } else {
            var1.g(var2.shift(var6));
         }

         var1.a((double)var2.getX() + 0.5D, (double)var2.getY() + 0.5D, (double)var2.getZ() + 0.5D, "tile.piston.in", 0.5F, var1.s.nextFloat() * 0.15F + 0.6F);
      }

      return true;
   }

   public void a(class_aer var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      if(var3.getBlock() == this && ((Boolean)var3.get(a)).booleanValue()) {
         float var4 = 0.25F;
         EnumDirection var5 = (EnumDirection)var3.get(b);
         if(var5 != null) {
            switch(class_ane.SyntheticClass_1.a[var5.ordinal()]) {
            case 1:
               this.setSizes(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case 2:
               this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
               break;
            case 3:
               this.setSizes(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
               break;
            case 4:
               this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
               break;
            case 5:
               this.setSizes(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case 6:
               this.setSizes(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
            }
         }
      } else {
         this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public void j() {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_awf var4, List var5, class_pr var6) {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
      this.a((class_aer)var1, (BlockPosition)var2);
      return super.a(var1, var2, var3);
   }

   public boolean isFullCube() {
      return false;
   }

   public static EnumDirection b(int var0) {
      int var1 = var0 & 7;
      return var1 > 5?null:EnumDirection.getById(var1);
   }

   public static EnumDirection a(World var0, BlockPosition var1, class_qa var2) {
      if(MathHelper.abs((float)var2.s - (float)var1.getX()) < 2.0F && MathHelper.abs((float)var2.u - (float)var1.getZ()) < 2.0F) {
         double var3 = var2.t + (double)var2.aU();
         if(var3 - (double)var1.getY() > 2.0D) {
            return EnumDirection.UP;
         }

         if((double)var1.getY() - var3 > 0.0D) {
            return EnumDirection.DOWN;
         }
      }

      return var2.aR().getOpposite();
   }

   public static boolean a(Block var0, World var1, BlockPosition var2, EnumDirection var3, boolean var4) {
      if(var0 == Blocks.OBSIDIAN) {
         return false;
      } else if(!var1.ag().a(var2)) {
         return false;
      } else if(var2.getY() < 0 || var3 == EnumDirection.DOWN && var2.getY() == 0) {
         return false;
      } else if(var2.getY() <= var1.V() - 1 && (var3 != EnumDirection.UP || var2.getY() != var1.V() - 1)) {
         if(var0 != Blocks.PISTON && var0 != Blocks.STICKY_PISTON) {
            if(var0.getStrength(var1, var2) == -1.0F) {
               return false;
            }

            if(var0.getPushReaction() == 2) {
               return false;
            }

            if(var0.getPushReaction() == 1) {
               if(!var4) {
                  return false;
               }

               return true;
            }
         } else if(((Boolean)var1.p(var2).get(a)).booleanValue()) {
            return false;
         }

         return !(var0 instanceof class_ahw);
      } else {
         return false;
      }
   }

   private boolean a(World var1, BlockPosition var2, EnumDirection var3, boolean var4) {
      if(!var4) {
         var1.g(var2.shift(var3));
      }

      class_ani var5 = new class_ani(var1, var2, var3, var4);
      List var6 = var5.c();
      List var7 = var5.d();
      if(!var5.a()) {
         return false;
      } else {
         int var8 = var6.size() + var7.size();
         Block[] var9 = new Block[var8];
         EnumDirection var10 = var4?var3:var3.getOpposite();

         int var11;
         BlockPosition var12;
         for(var11 = var7.size() - 1; var11 >= 0; --var11) {
            var12 = (BlockPosition)var7.get(var11);
            Block var13 = var1.p(var12).getBlock();
            var13.b(var1, var12, var1.p(var12), 0);
            var1.g(var12);
            --var8;
            var9[var8] = var13;
         }

         IBlockData var18;
         for(var11 = var6.size() - 1; var11 >= 0; --var11) {
            var12 = (BlockPosition)var6.get(var11);
            var18 = var1.p(var12);
            Block var14 = var18.getBlock();
            var14.toLegacyData(var18);
            var1.g(var12);
            var12 = var12.shift(var10);
            var1.a((BlockPosition)var12, (IBlockData)Blocks.PISTON_EXTENSION.getBlockData().set(b, var3), 4);
            var1.a(var12, class_anh.a(var18, var3, var4, false));
            --var8;
            var9[var8] = var14;
         }

         BlockPosition var16 = var2.shift(var3);
         if(var4) {
            class_anf.class_a_in_class_anf var17 = this.N?class_anf.class_a_in_class_anf.b:class_anf.class_a_in_class_anf.a;
            var18 = Blocks.PISTON_HEAD.getBlockData().set(class_anf.b, var3).set(class_anf.a, var17);
            IBlockData var20 = Blocks.PISTON_EXTENSION.getBlockData().set(class_anh.a, var3).set(class_anh.b, this.N?class_anf.class_a_in_class_anf.b:class_anf.class_a_in_class_anf.a);
            var1.a((BlockPosition)var16, (IBlockData)var20, 4);
            var1.a(var16, class_anh.a(var18, var3, true, false));
         }

         int var19;
         for(var19 = var7.size() - 1; var19 >= 0; --var19) {
            var1.c((BlockPosition)var7.get(var19), var9[var8++]);
         }

         for(var19 = var6.size() - 1; var19 >= 0; --var19) {
            var1.c((BlockPosition)var6.get(var19), var9[var8++]);
         }

         if(var4) {
            var1.c((BlockPosition)var16, (Block)Blocks.PISTON_HEAD);
            var1.c((BlockPosition)var2, (Block)this);
         }

         return true;
      }
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(b, b(var1)).set(a, Boolean.valueOf((var1 & 8) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(b)).getId();
      if(((Boolean)var1.get(a)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(b, var2.a((EnumDirection)var1.get(b)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(b)));
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{b, a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumDirection.values().length];

      static {
         try {
            a[EnumDirection.DOWN.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[EnumDirection.UP.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[EnumDirection.NORTH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[EnumDirection.SOUTH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.WEST.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.EAST.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
