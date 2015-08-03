package net.minecraft.server;

public class BlockMinecartTrack extends BlockMinecartTrackAbstract {
   public static final BlockStateEnum b = BlockStateEnum.of("shape", BlockMinecartTrackAbstract.EnumTrackPosition.class);

   protected BlockMinecartTrack() {
      super(false);
      this.setBlockData(this.blockStateList.getFirst().set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH));
   }

   protected void b(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(var4.isPowerSource() && (new BlockMinecartTrackAbstract.MinecartTrackLogic(var1, var2, var3)).a() == 3) {
         this.a(var1, var2, var3, false);
      }

   }

   public IBlockState n() {
      return b;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(b, BlockMinecartTrackAbstract.EnumTrackPosition.getById(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((BlockMinecartTrackAbstract.EnumTrackPosition)var1.get(b)).getId();
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(BlockMinecartTrack.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            switch(BlockMinecartTrack.SyntheticClass_1.a[((BlockMinecartTrackAbstract.EnumTrackPosition)var1.get(b)).ordinal()]) {
            case 1:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST);
            case 2:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST);
            case 3:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH);
            case 4:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH);
            case 5:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
            case 6:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
            case 7:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
            case 8:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
            }
         case 2:
            switch(BlockMinecartTrack.SyntheticClass_1.a[((BlockMinecartTrackAbstract.EnumTrackPosition)var1.get(b)).ordinal()]) {
            case 1:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH);
            case 2:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH);
            case 3:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST);
            case 4:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST);
            case 5:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
            case 6:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
            case 7:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
            case 8:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
            case 9:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST);
            case 10:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH);
            }
         case 3:
            switch(BlockMinecartTrack.SyntheticClass_1.a[((BlockMinecartTrackAbstract.EnumTrackPosition)var1.get(b)).ordinal()]) {
            case 1:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH);
            case 2:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH);
            case 3:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST);
            case 4:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST);
            case 5:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
            case 6:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
            case 7:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
            case 8:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
            case 9:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST);
            case 10:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH);
            }
         default:
            return var1;
         }
      }
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         BlockMinecartTrackAbstract.EnumTrackPosition var3 = (BlockMinecartTrackAbstract.EnumTrackPosition)var1.get(b);
         switch(BlockMinecartTrack.SyntheticClass_1.c[var2.ordinal()]) {
         case 1:
            switch(BlockMinecartTrack.SyntheticClass_1.a[var3.ordinal()]) {
            case 3:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH);
            case 4:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH);
            case 5:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
            case 6:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
            case 7:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
            case 8:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
            default:
               return super.a(var1, var2);
            }
         case 2:
            switch(BlockMinecartTrack.SyntheticClass_1.a[var3.ordinal()]) {
            case 1:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST);
            case 2:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST);
            case 3:
            case 4:
            default:
               break;
            case 5:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
            case 6:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
            case 7:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
            case 8:
               return var1.set(b, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
            }
         }

         return super.a(var1, var2);
      }
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{b});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            c[Block.class_a_in_class_agj.LEFT_RIGHT.ordinal()] = 1;
         } catch (NoSuchFieldError var15) {
            ;
         }

         try {
            c[Block.class_a_in_class_agj.FRONT_BACK.ordinal()] = 2;
         } catch (NoSuchFieldError var14) {
            ;
         }

         b = new int[Block.EnumRotation.values().length];

         try {
            b[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 1;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            b[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 2;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            b[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 3;
         } catch (NoSuchFieldError var11) {
            ;
         }

         a = new int[BlockMinecartTrackAbstract.EnumTrackPosition.values().length];

         try {
            a[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            a[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            a[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            a[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            a[BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST.ordinal()] = 7;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST.ordinal()] = 8;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH.ordinal()] = 9;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST.ordinal()] = 10;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
