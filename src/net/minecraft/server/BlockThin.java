package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class BlockThin extends Block {
   public static final BlockStateBoolean b = BlockStateBoolean.of("north");
   public static final BlockStateBoolean N = BlockStateBoolean.of("east");
   public static final BlockStateBoolean O = BlockStateBoolean.of("south");
   public static final BlockStateBoolean P = BlockStateBoolean.of("west");
   private final boolean a;

   protected BlockThin(Material var1, boolean var2) {
      super(var1);
      this.setBlockData(this.blockStateList.getFirst().set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)).set(P, Boolean.valueOf(false)));
      this.a = var2;
      this.setCreativeTab(CreativeTab.DECORATIONS);
   }

   public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
      return var1.set(b, Boolean.valueOf(this.c(var2.getType(var3.north()).getBlock()))).set(O, Boolean.valueOf(this.c(var2.getType(var3.south()).getBlock()))).set(P, Boolean.valueOf(this.c(var2.getType(var3.west()).getBlock()))).set(N, Boolean.valueOf(this.c(var2.getType(var3.east()).getBlock())));
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return !this.a?null:super.getDropType(var1, var2, var3);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public void addBBIfInsideInputBB(World var1, BlockPosition var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      boolean var7 = this.c(var1.getType(var2.north()).getBlock());
      boolean var8 = this.c(var1.getType(var2.south()).getBlock());
      boolean var9 = this.c(var1.getType(var2.west()).getBlock());
      boolean var10 = this.c(var1.getType(var2.east()).getBlock());
      if(var9 && var10) {
         this.setSizes(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
         super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      } else if(!var9 && !var10 && !var7 && !var8) {
         this.setSizes(0.4375F, 0.4375F, 0.4375F, 0.5625F, 0.5625F, 0.5625F);
         super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      } else if(var9) {
         this.setSizes(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
         super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      } else if(var10) {
         this.setSizes(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
         super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      }

      if(var7 && var8) {
         this.setSizes(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
         super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      } else if(!var9 && !var10 && !var7 && !var8) {
         this.setSizes(0.4375F, 0.0F, 0.4375F, 0.5625F, 1.0F, 0.5625F);
         super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      } else if(var7) {
         this.setSizes(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
         super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      } else if(var8) {
         this.setSizes(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
         super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      }

   }

   public void j() {
      this.setSizes(0.4375F, 0.4375F, 0.0F, 0.5625F, 1.0F, 0.5625F);
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      float var3 = 0.4375F;
      float var4 = 0.5625F;
      float var5 = 0.4375F;
      float var6 = 0.5625F;
      boolean var7 = this.c(var1.getType(var2.north()).getBlock());
      boolean var8 = this.c(var1.getType(var2.south()).getBlock());
      boolean var9 = this.c(var1.getType(var2.west()).getBlock());
      boolean var10 = this.c(var1.getType(var2.east()).getBlock());
      if(var9 && var10) {
         var3 = 0.0F;
         var4 = 1.0F;
      } else if(var9) {
         var3 = 0.0F;
      } else if(var10) {
         var4 = 1.0F;
      }

      if(var7 && var8) {
         var5 = 0.0F;
         var6 = 1.0F;
      } else if(var7) {
         var5 = 0.0F;
      } else if(var8) {
         var6 = 1.0F;
      }

      this.setSizes(var3, 0.0F, var5, var4, 1.0F, var6);
   }

   public final boolean c(Block var1) {
      return var1.isFullBlock() || var1 == this || var1 == Blocks.GLASS || var1 == Blocks.STAINED_GLASS || var1 == Blocks.STAINED_GLASS_PANE || var1 instanceof BlockThin;
   }

   protected boolean canApplySilkTouch() {
      return true;
   }

   public int toLegacyData(IBlockData var1) {
      return 0;
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(BlockThin.SyntheticClass_1.a[var2.ordinal()]) {
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
         switch(BlockThin.SyntheticClass_1.b[var2.ordinal()]) {
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
      return new BlockStateList(this, new IBlockState[]{b, N, P, O});
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
