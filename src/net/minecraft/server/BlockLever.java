package net.minecraft.server;

import java.util.Iterator;

public class BlockLever extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("facing", BlockLever.class_a_in_class_ajc.class);
   public static final BlockStateBoolean b = BlockStateBoolean.of("powered");

   protected BlockLever() {
      super(Material.ORIENTABLE);
      this.setBlockData(this.blockStateList.getFirst().set(a, BlockLever.class_a_in_class_ajc.e).set(b, Boolean.valueOf(false)));
      this.setCreativeTab(CreativeTab.REDSTONE);
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

   public boolean canPlace(World var1, BlockPosition var2, EnumDirection var3) {
      return a(var1, var2, var3.opposite());
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      EnumDirection[] var3 = EnumDirection.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumDirection var6 = var3[var5];
         if(a(var1, var2, var6)) {
            return true;
         }
      }

      return false;
   }

   protected static boolean a(World var0, BlockPosition var1, EnumDirection var2) {
      return class_agp.a(var0, var1, var2);
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      IBlockData var9 = this.getBlockData().set(b, Boolean.valueOf(false));
      if(a(var1, var2, var3.opposite())) {
         return var9.set(a, BlockLever.class_a_in_class_ajc.a(var3, var8.aR()));
      } else {
         Iterator var10 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

         EnumDirection var11;
         do {
            if(!var10.hasNext()) {
               if(World.a((IBlockAccess)var1, (BlockPosition)var2.down())) {
                  return var9.set(a, BlockLever.class_a_in_class_ajc.a(EnumDirection.UP, var8.aR()));
               }

               return var9;
            }

            var11 = (EnumDirection)var10.next();
         } while(var11 == var3 || !a(var1, var2, var11.opposite()));

         return var9.set(a, BlockLever.class_a_in_class_ajc.a(var11, var8.aR()));
      }
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(this.e(var1, var2, var3) && !a(var1, var2, ((BlockLever.class_a_in_class_ajc)var3.get(a)).c().opposite())) {
         this.dropNaturallyForSure(var1, var2, var3, 0);
         var1.setAir(var2);
      }

   }

   private boolean e(World var1, BlockPosition var2, IBlockData var3) {
      if(this.canPlace(var1, var2)) {
         return true;
      } else {
         this.dropNaturallyForSure(var1, var2, var3, 0);
         var1.setAir(var2);
         return false;
      }
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      float var3 = 0.1875F;
      switch(BlockLever.SyntheticClass_1.b[((BlockLever.class_a_in_class_ajc)var1.getType(var2).get(a)).ordinal()]) {
      case 1:
         this.setSizes(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
         break;
      case 2:
         this.setSizes(1.0F - var3 * 2.0F, 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
         break;
      case 3:
         this.setSizes(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
         break;
      case 4:
         this.setSizes(0.5F - var3, 0.2F, 1.0F - var3 * 2.0F, 0.5F + var3, 0.8F, 1.0F);
         break;
      case 5:
      case 6:
         var3 = 0.25F;
         this.setSizes(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.6F, 0.5F + var3);
         break;
      case 7:
      case 8:
         var3 = 0.25F;
         this.setSizes(0.5F - var3, 0.4F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
      }

   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.isClientSide) {
         return true;
      } else {
         var3 = var3.a(b);
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 3);
         var1.a((double)var2.getX() + 0.5D, (double)var2.getY() + 0.5D, (double)var2.getZ() + 0.5D, "random.click", 0.3F, ((Boolean)var3.get(b)).booleanValue()?0.6F:0.5F);
         var1.c((BlockPosition)var2, (Block)this);
         EnumDirection var11 = ((BlockLever.class_a_in_class_ajc)var3.get(a)).c();
         var1.c((BlockPosition)var2.shift(var11.opposite()), (Block)this);
         return true;
      }
   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      if(((Boolean)var3.get(b)).booleanValue()) {
         var1.c((BlockPosition)var2, (Block)this);
         EnumDirection var4 = ((BlockLever.class_a_in_class_ajc)var3.get(a)).c();
         var1.c((BlockPosition)var2.shift(var4.opposite()), (Block)this);
      }

      super.remove(var1, var2, var3);
   }

   public int a(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return ((Boolean)var3.get(b)).booleanValue()?15:0;
   }

   public int b(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return !((Boolean)var3.get(b)).booleanValue()?0:(((BlockLever.class_a_in_class_ajc)var3.get(a)).c() == var4?15:0);
   }

   public boolean isPowerSource() {
      return true;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, BlockLever.class_a_in_class_ajc.a(var1 & 7)).set(b, Boolean.valueOf((var1 & 8) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((BlockLever.class_a_in_class_ajc)var1.get(a)).a();
      if(((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(BlockLever.SyntheticClass_1.c[var2.ordinal()]) {
         case 1:
            switch(BlockLever.SyntheticClass_1.b[((BlockLever.class_a_in_class_ajc)var1.get(a)).ordinal()]) {
            case 1:
               return var1.set(a, BlockLever.class_a_in_class_ajc.c);
            case 2:
               return var1.set(a, BlockLever.class_a_in_class_ajc.b);
            case 3:
               return var1.set(a, BlockLever.class_a_in_class_ajc.e);
            case 4:
               return var1.set(a, BlockLever.class_a_in_class_ajc.d);
            default:
               return var1;
            }
         case 2:
            switch(BlockLever.SyntheticClass_1.b[((BlockLever.class_a_in_class_ajc)var1.get(a)).ordinal()]) {
            case 1:
               return var1.set(a, BlockLever.class_a_in_class_ajc.e);
            case 2:
               return var1.set(a, BlockLever.class_a_in_class_ajc.d);
            case 3:
               return var1.set(a, BlockLever.class_a_in_class_ajc.b);
            case 4:
               return var1.set(a, BlockLever.class_a_in_class_ajc.c);
            case 5:
               return var1.set(a, BlockLever.class_a_in_class_ajc.g);
            case 6:
               return var1.set(a, BlockLever.class_a_in_class_ajc.f);
            case 7:
               return var1.set(a, BlockLever.class_a_in_class_ajc.h);
            case 8:
               return var1.set(a, BlockLever.class_a_in_class_ajc.a);
            }
         case 3:
            switch(BlockLever.SyntheticClass_1.b[((BlockLever.class_a_in_class_ajc)var1.get(a)).ordinal()]) {
            case 1:
               return var1.set(a, BlockLever.class_a_in_class_ajc.d);
            case 2:
               return var1.set(a, BlockLever.class_a_in_class_ajc.e);
            case 3:
               return var1.set(a, BlockLever.class_a_in_class_ajc.c);
            case 4:
               return var1.set(a, BlockLever.class_a_in_class_ajc.b);
            case 5:
               return var1.set(a, BlockLever.class_a_in_class_ajc.g);
            case 6:
               return var1.set(a, BlockLever.class_a_in_class_ajc.f);
            case 7:
               return var1.set(a, BlockLever.class_a_in_class_ajc.h);
            case 8:
               return var1.set(a, BlockLever.class_a_in_class_ajc.a);
            }
         default:
            return var1;
         }
      }
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a(((BlockLever.class_a_in_class_ajc)var1.get(a)).c()));
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c;
      // $FF: synthetic field
      static final int[] d = new int[EnumDirection.EnumAxis.values().length];

      static {
         try {
            d[EnumDirection.EnumAxis.X.ordinal()] = 1;
         } catch (NoSuchFieldError var19) {
            ;
         }

         try {
            d[EnumDirection.EnumAxis.Z.ordinal()] = 2;
         } catch (NoSuchFieldError var18) {
            ;
         }

         c = new int[Block.EnumRotation.values().length];

         try {
            c[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 1;
         } catch (NoSuchFieldError var17) {
            ;
         }

         try {
            c[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 2;
         } catch (NoSuchFieldError var16) {
            ;
         }

         try {
            c[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 3;
         } catch (NoSuchFieldError var15) {
            ;
         }

         b = new int[BlockLever.class_a_in_class_ajc.values().length];

         try {
            b[BlockLever.class_a_in_class_ajc.b.ordinal()] = 1;
         } catch (NoSuchFieldError var14) {
            ;
         }

         try {
            b[BlockLever.class_a_in_class_ajc.c.ordinal()] = 2;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            b[BlockLever.class_a_in_class_ajc.d.ordinal()] = 3;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            b[BlockLever.class_a_in_class_ajc.e.ordinal()] = 4;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            b[BlockLever.class_a_in_class_ajc.f.ordinal()] = 5;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            b[BlockLever.class_a_in_class_ajc.g.ordinal()] = 6;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            b[BlockLever.class_a_in_class_ajc.a.ordinal()] = 7;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            b[BlockLever.class_a_in_class_ajc.h.ordinal()] = 8;
         } catch (NoSuchFieldError var7) {
            ;
         }

         a = new int[EnumDirection.values().length];

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

   public static enum class_a_in_class_ajc implements INamable {
       a(0, "down_x", EnumDirection.DOWN),
       b(1, "east", EnumDirection.EAST),
       c(2, "west", EnumDirection.WEST),
       d(3, "south", EnumDirection.SOUTH),
       e(4, "north", EnumDirection.NORTH),
       f(5, "up_z", EnumDirection.UP),
       g(6, "up_x", EnumDirection.UP),
       h(7, "down_z", EnumDirection.DOWN);

      private static final BlockLever.class_a_in_class_ajc[] i;
      private final int j;
      private final String k;
      private final EnumDirection l;

      private class_a_in_class_ajc(int var3, String var4, EnumDirection var5) {
         this.j = var3;
         this.k = var4;
         this.l = var5;
      }

      public int a() {
         return this.j;
      }

      public EnumDirection c() {
         return this.l;
      }

      public String toString() {
         return this.k;
      }

      public static BlockLever.class_a_in_class_ajc a(int var0) {
         if(var0 < 0 || var0 >= i.length) {
            var0 = 0;
         }

         return i[var0];
      }

      public static BlockLever.class_a_in_class_ajc a(EnumDirection var0, EnumDirection var1) {
         switch(BlockLever.SyntheticClass_1.a[var0.ordinal()]) {
         case 1:
            switch(BlockLever.SyntheticClass_1.d[var1.getAxis().ordinal()]) {
            case 1:
               return a;
            case 2:
               return h;
            default:
               throw new IllegalArgumentException("Invalid entityFacing " + var1 + " for facing " + var0);
            }
         case 2:
            switch(BlockLever.SyntheticClass_1.d[var1.getAxis().ordinal()]) {
            case 1:
               return g;
            case 2:
               return f;
            default:
               throw new IllegalArgumentException("Invalid entityFacing " + var1 + " for facing " + var0);
            }
         case 3:
            return e;
         case 4:
            return d;
         case 5:
            return c;
         case 6:
            return b;
         default:
            throw new IllegalArgumentException("Invalid facing: " + var0);
         }
      }

      public String getName() {
         return this.k;
      }

      static {
         i = new BlockLever.class_a_in_class_ajc[values().length];
         BlockLever.class_a_in_class_ajc[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockLever.class_a_in_class_ajc var3 = var0[var2];
            i[var3.a()] = var3;
         }

      }
   }
}
