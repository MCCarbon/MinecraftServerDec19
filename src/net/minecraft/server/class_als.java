package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_alt;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;

public class class_als extends Block {
   public static final class_anw a = class_anw.a("powered");
   public static final class_anw b = class_anw.a("suspended");
   public static final class_anw N = class_anw.a("attached");
   public static final class_anw O = class_anw.a("disarmed");
   public static final class_anw P = class_anw.a("north");
   public static final class_anw Q = class_anw.a("east");
   public static final class_anw R = class_anw.a("south");
   public static final class_anw S = class_anw.a("west");

   public class_als() {
      super(Material.ORIENTABLE);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)).set(P, Boolean.valueOf(false)).set(Q, Boolean.valueOf(false)).set(R, Boolean.valueOf(false)).set(S, Boolean.valueOf(false)));
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.15625F, 1.0F);
      this.setTicking(true);
   }

   public IBlockData a(IBlockData var1, class_aer var2, BlockPosition var3) {
      return var1.set(P, Boolean.valueOf(c(var2, var3, var1, EnumDirection.NORTH))).set(Q, Boolean.valueOf(c(var2, var3, var1, EnumDirection.EAST))).set(R, Boolean.valueOf(c(var2, var3, var1, EnumDirection.SOUTH))).set(S, Boolean.valueOf(c(var2, var3, var1, EnumDirection.WEST)));
   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
      return null;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.H;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      boolean var5 = ((Boolean)var3.get(b)).booleanValue();
      boolean var6 = !World.a((class_aer)var1, (BlockPosition)var2.shiftDown());
      if(var5 != var6) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   public void a(class_aer var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      boolean var4 = ((Boolean)var3.get(N)).booleanValue();
      boolean var5 = ((Boolean)var3.get(b)).booleanValue();
      if(!var5) {
         this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.09375F, 1.0F);
      } else if(!var4) {
         this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      } else {
         this.setSizes(0.0F, 0.0625F, 0.0F, 1.0F, 0.15625F, 1.0F);
      }

   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      var3 = var3.set(b, Boolean.valueOf(!World.a((class_aer)var1, (BlockPosition)var2.shiftDown())));
      var1.a((BlockPosition)var2, (IBlockData)var3, 3);
      this.e(var1, var2, var3);
   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      this.e(var1, var2, var3.set(a, Boolean.valueOf(true)));
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_xa var4) {
      if(!var1.D) {
         if(var4.bA() != null && var4.bA().b() == Items.bg) {
            var1.a((BlockPosition)var2, (IBlockData)var3.set(O, Boolean.valueOf(true)), 4);
         }

      }
   }

   private void e(World var1, BlockPosition var2, IBlockData var3) {
      EnumDirection[] var4 = new EnumDirection[]{EnumDirection.SOUTH, EnumDirection.WEST};
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         EnumDirection var7 = var4[var6];

         for(int var8 = 1; var8 < 42; ++var8) {
            BlockPosition var9 = var2.shift(var7, var8);
            IBlockData var10 = var1.p(var9);
            if(var10.getBlock() == Blocks.TRIPWIRE_HOOK) {
               if(var10.get(class_alt.a) == var7.getOpposite()) {
                  Blocks.TRIPWIRE_HOOK.a(var1, var9, var10, false, true, var8, var3);
               }
               break;
            }

            if(var10.getBlock() != Blocks.TRIPWIRE) {
               break;
            }
         }
      }

   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_pr var4) {
      if(!var1.D) {
         if(!((Boolean)var3.get(a)).booleanValue()) {
            this.e(var1, var2);
         }
      }
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Random var4) {
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(!var1.D) {
         if(((Boolean)var1.p(var2).get(a)).booleanValue()) {
            this.e(var1, var2);
         }
      }
   }

   private void e(World var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      boolean var4 = ((Boolean)var3.get(a)).booleanValue();
      boolean var5 = false;
      List var6 = var1.b((class_pr)null, (class_awf)(new class_awf((double)var2.getX() + this.minX, (double)var2.getY() + this.minY, (double)var2.getZ() + this.minZ, (double)var2.getX() + this.maxX, (double)var2.getY() + this.maxY, (double)var2.getZ() + this.maxZ)));
      if(!var6.isEmpty()) {
         Iterator var7 = var6.iterator();

         while(var7.hasNext()) {
            class_pr var8 = (class_pr)var7.next();
            if(!var8.aK()) {
               var5 = true;
               break;
            }
         }
      }

      if(var5 != var4) {
         var3 = var3.set(a, Boolean.valueOf(var5));
         var1.a((BlockPosition)var2, (IBlockData)var3, 3);
         this.e(var1, var2, var3);
      }

      if(var5) {
         var1.a((BlockPosition)var2, (Block)this, this.a(var1));
      }

   }

   public static boolean c(class_aer var0, BlockPosition var1, IBlockData var2, EnumDirection var3) {
      BlockPosition var4 = var1.shift(var3);
      IBlockData var5 = var0.p(var4);
      Block var6 = var5.getBlock();
      if(var6 == Blocks.TRIPWIRE_HOOK) {
         EnumDirection var9 = var3.getOpposite();
         return var5.get(class_alt.a) == var9;
      } else if(var6 == Blocks.TRIPWIRE) {
         boolean var7 = ((Boolean)var2.get(b)).booleanValue();
         boolean var8 = ((Boolean)var5.get(b)).booleanValue();
         return var7 == var8;
      } else {
         return false;
      }
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Boolean.valueOf((var1 & 1) > 0)).set(b, Boolean.valueOf((var1 & 2) > 0)).set(N, Boolean.valueOf((var1 & 4) > 0)).set(O, Boolean.valueOf((var1 & 8) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      int var2 = 0;
      if(((Boolean)var1.get(a)).booleanValue()) {
         var2 |= 1;
      }

      if(((Boolean)var1.get(b)).booleanValue()) {
         var2 |= 2;
      }

      if(((Boolean)var1.get(N)).booleanValue()) {
         var2 |= 4;
      }

      if(((Boolean)var1.get(O)).booleanValue()) {
         var2 |= 8;
      }

      return var2;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_als.SyntheticClass_1.a[var2.ordinal()]) {
         case 1:
            return var1.set(P, var1.get(R)).set(Q, var1.get(S)).set(R, var1.get(P)).set(S, var1.get(Q));
         case 2:
            return var1.set(P, var1.get(Q)).set(Q, var1.get(R)).set(R, var1.get(S)).set(S, var1.get(P));
         case 3:
            return var1.set(P, var1.get(S)).set(Q, var1.get(P)).set(R, var1.get(Q)).set(S, var1.get(R));
         default:
            return var1;
         }
      }
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_als.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            return var1.set(P, var1.get(R)).set(R, var1.get(P));
         case 2:
            return var1.set(Q, var1.get(S)).set(S, var1.get(Q));
         default:
            return super.a(var1, var2);
         }
      }
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b, N, O, P, Q, S, R});
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
