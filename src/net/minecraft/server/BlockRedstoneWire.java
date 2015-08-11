package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class BlockRedstoneWire extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("north", BlockRedstoneWire.class_a_in_class_akk.class);
   public static final BlockStateEnum b = BlockStateEnum.of("east", BlockRedstoneWire.class_a_in_class_akk.class);
   public static final BlockStateEnum N = BlockStateEnum.of("south", BlockRedstoneWire.class_a_in_class_akk.class);
   public static final BlockStateEnum O = BlockStateEnum.of("west", BlockRedstoneWire.class_a_in_class_akk.class);
   public static final BlockStateInteger P = BlockStateInteger.of("power", 0, 15);
   private boolean Q = true;
   private final Set R = Sets.newHashSet();

   public BlockRedstoneWire() {
      super(Material.ORIENTABLE);
      this.setBlockData(this.blockStateList.getFirst().set(a, BlockRedstoneWire.class_a_in_class_akk.c).set(b, BlockRedstoneWire.class_a_in_class_akk.c).set(N, BlockRedstoneWire.class_a_in_class_akk.c).set(O, BlockRedstoneWire.class_a_in_class_akk.c).set(P, Integer.valueOf(0)));
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
   }

   public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
      var1 = var1.set(O, this.c(var2, var3, EnumDirection.WEST));
      var1 = var1.set(b, this.c(var2, var3, EnumDirection.EAST));
      var1 = var1.set(a, this.c(var2, var3, EnumDirection.NORTH));
      var1 = var1.set(N, this.c(var2, var3, EnumDirection.SOUTH));
      return var1;
   }

   private BlockRedstoneWire.class_a_in_class_akk c(IBlockAccess var1, BlockPosition var2, EnumDirection var3) {
      BlockPosition var4 = var2.shift(var3);
      Block var5 = var1.getType(var2.shift(var3)).getBlock();
      if(a(var1.getType(var4), var3) || !var5.isSoildFullCube() && d(var1.getType(var4.down()))) {
         return BlockRedstoneWire.class_a_in_class_akk.b;
      } else {
         Block var6 = var1.getType(var2.up()).getBlock();
         return !var6.isSoildFullCube() && var5.isSoildFullCube() && d(var1.getType(var4.up()))? BlockRedstoneWire.class_a_in_class_akk.a: BlockRedstoneWire.class_a_in_class_akk.c;
      }
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      return null;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      return World.a((IBlockAccess)var1, (BlockPosition)var2.down()) || var1.getType(var2.down()).getBlock() == Blocks.GLOWSTONE;
   }

   private IBlockData e(World var1, BlockPosition var2, IBlockData var3) {
      var3 = this.a(var1, var2, var2, var3);
      ArrayList var4 = Lists.newArrayList((Iterable)this.R);
      this.R.clear();
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         BlockPosition var6 = (BlockPosition)var5.next();
         var1.applyPhysics((BlockPosition)var6, (Block)this);
      }

      return var3;
   }

   private IBlockData a(World var1, BlockPosition var2, BlockPosition var3, IBlockData var4) {
      IBlockData var5 = var4;
      int var6 = ((Integer)var4.get(P)).intValue();
      byte var7 = 0;
      int var14 = this.a((World)var1, (BlockPosition)var3, var7);
      this.Q = false;
      int var8 = var1.A(var2);
      this.Q = true;
      if(var8 > 0 && var8 > var14 - 1) {
         var14 = var8;
      }

      int var9 = 0;
      Iterator var10 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

      while(true) {
         while(var10.hasNext()) {
            EnumDirection var11 = (EnumDirection)var10.next();
            BlockPosition var12 = var2.shift(var11);
            boolean var13 = var12.getX() != var3.getX() || var12.getZ() != var3.getZ();
            if(var13) {
               var9 = this.a(var1, var12, var9);
            }

            if(var1.getType(var12).getBlock().isOccluding() && !var1.getType(var2.up()).getBlock().isOccluding()) {
               if(var13 && var2.getY() >= var3.getY()) {
                  var9 = this.a(var1, var12.up(), var9);
               }
            } else if(!var1.getType(var12).getBlock().isOccluding() && var13 && var2.getY() <= var3.getY()) {
               var9 = this.a(var1, var12.down(), var9);
            }
         }

         if(var9 > var14) {
            var14 = var9 - 1;
         } else if(var14 > 0) {
            --var14;
         } else {
            var14 = 0;
         }

         if(var8 > var14 - 1) {
            var14 = var8;
         }

         if(var6 != var14) {
            var4 = var4.set(P, Integer.valueOf(var14));
            if(var1.getType(var2) == var5) {
               var1.setTypeAndData((BlockPosition)var2, (IBlockData)var4, 2);
            }

            this.R.add(var2);
            EnumDirection[] var15 = EnumDirection.values();
            int var16 = var15.length;

            for(int var17 = 0; var17 < var16; ++var17) {
               EnumDirection var18 = var15[var17];
               this.R.add(var2.shift(var18));
            }
         }

         return var4;
      }
   }

   private void e(World var1, BlockPosition var2) {
      if(var1.getType(var2).getBlock() == this) {
         var1.applyPhysics((BlockPosition)var2, (Block)this);
         EnumDirection[] var3 = EnumDirection.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            EnumDirection var6 = var3[var5];
            var1.applyPhysics((BlockPosition)var2.shift(var6), (Block)this);
         }

      }
   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.isClientSide) {
         this.e(var1, var2, var3);
         Iterator var4 = EnumDirection.EnumDirectionLimit.VERTICAL.iterator();

         EnumDirection var5;
         while(var4.hasNext()) {
            var5 = (EnumDirection)var4.next();
            var1.applyPhysics((BlockPosition)var2.shift(var5), (Block)this);
         }

         var4 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

         while(var4.hasNext()) {
            var5 = (EnumDirection)var4.next();
            this.e(var1, var2.shift(var5));
         }

         var4 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

         while(var4.hasNext()) {
            var5 = (EnumDirection)var4.next();
            BlockPosition var6 = var2.shift(var5);
            if(var1.getType(var6).getBlock().isOccluding()) {
               this.e(var1, var6.up());
            } else {
               this.e(var1, var6.down());
            }
         }

      }
   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      super.remove(var1, var2, var3);
      if(!var1.isClientSide) {
         EnumDirection[] var4 = EnumDirection.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            EnumDirection var7 = var4[var6];
            var1.applyPhysics((BlockPosition)var2.shift(var7), (Block)this);
         }

         this.e(var1, var2, var3);
         Iterator var8 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

         EnumDirection var9;
         while(var8.hasNext()) {
            var9 = (EnumDirection)var8.next();
            this.e(var1, var2.shift(var9));
         }

         var8 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

         while(var8.hasNext()) {
            var9 = (EnumDirection)var8.next();
            BlockPosition var10 = var2.shift(var9);
            if(var1.getType(var10).getBlock().isOccluding()) {
               this.e(var1, var10.up());
            } else {
               this.e(var1, var10.down());
            }
         }

      }
   }

   private int a(World var1, BlockPosition var2, int var3) {
      if(var1.getType(var2).getBlock() != this) {
         return var3;
      } else {
         int var4 = ((Integer)var1.getType(var2).get(P)).intValue();
         return var4 > var3?var4:var3;
      }
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!var1.isClientSide) {
         if(this.canPlace(var1, var2)) {
            this.e(var1, var2, var3);
         } else {
            this.dropNaturallyForSure(var1, var2, var3, 0);
            var1.setAir(var2);
         }

      }
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.REDSTONE;
   }

   public int b(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return !this.Q?0:this.a(var1, var2, var3, var4);
   }

   public int a(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      if(!this.Q) {
         return 0;
      } else {
         int var5 = ((Integer)var3.get(P)).intValue();
         if(var5 == 0) {
            return 0;
         } else if(var4 == EnumDirection.UP) {
            return var5;
         } else {
            EnumSet var6 = EnumSet.noneOf(EnumDirection.class);
            Iterator var7 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

            while(var7.hasNext()) {
               EnumDirection var8 = (EnumDirection)var7.next();
               if(this.d(var1, var2, var8)) {
                  var6.add(var8);
               }
            }

            if(var4.getAxis().isHorizontal() && var6.isEmpty()) {
               return var5;
            } else if(var6.contains(var4) && !var6.contains(var4.rotateYCCW()) && !var6.contains(var4.rotateY())) {
               return var5;
            } else {
               return 0;
            }
         }
      }
   }

   private boolean d(IBlockAccess var1, BlockPosition var2, EnumDirection var3) {
      BlockPosition var4 = var2.shift(var3);
      IBlockData var5 = var1.getType(var4);
      Block var6 = var5.getBlock();
      boolean var7 = var6.isOccluding();
      boolean var8 = var1.getType(var2.up()).getBlock().isOccluding();
      return !var8 && var7 && e(var1, var4.up())?true:(a(var5, var3)?true:(var6 == Blocks.POWERED_REPEATER && var5.get(class_ahh.FACING) == var3?true:!var7 && e(var1, var4.down())));
   }

   protected static boolean e(IBlockAccess var0, BlockPosition var1) {
      return d(var0.getType(var1));
   }

   protected static boolean d(IBlockData var0) {
      return a(var0, (EnumDirection)null);
   }

   protected static boolean a(IBlockData var0, EnumDirection var1) {
      Block var2 = var0.getBlock();
      if(var2 == Blocks.REDSTONE_WIRE) {
         return true;
      } else if(Blocks.UNPOWERED_REPEATER.e(var2)) {
         EnumDirection var3 = (EnumDirection)var0.get(BlockRedstoneRepeater.FACING);
         return var3 == var1 || var3.opposite() == var1;
      } else {
         return var2.isPowerSource() && var1 != null;
      }
   }

   public boolean isPowerSource() {
      return this.Q;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(P, Integer.valueOf(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(P)).intValue();
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(BlockRedstoneWire.SyntheticClass_1.a[var2.ordinal()]) {
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
         switch(BlockRedstoneWire.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            return var1.set(a, var1.get(N)).set(N, var1.get(a));
         case 2:
            return var1.set(b, var1.get(O)).set(O, var1.get(b));
         default:
            return super.a(var1, var2);
         }
      }
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b, N, O, P});
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

   static enum class_a_in_class_akk implements INamable {
      a("up"),
      b("side"),
      c("none");

      private final String d;

      private class_a_in_class_akk(String var3) {
         this.d = var3;
      }

      public String toString() {
         return this.getName();
      }

      public String getName() {
         return this.d;
      }
   }
}
