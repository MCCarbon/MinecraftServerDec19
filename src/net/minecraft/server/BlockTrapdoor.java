package net.minecraft.server;

public class BlockTrapdoor extends Block {
   public static final BlockStateDirection a;
   public static final BlockStateBoolean b;
   public static final BlockStateEnum N;

   protected BlockTrapdoor(Material var1) {
      super(var1);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH).set(b, Boolean.valueOf(false)).set(N, BlockTrapdoor.class_a_in_class_alr.b));
      float var2 = 0.5F;
      float var3 = 1.0F;
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      this.setCreativeTab(CreativeTab.REDSTONE);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isPassable(IBlockAccess var1, BlockPosition var2) {
      return !((Boolean)var1.getType(var2).get(b)).booleanValue();
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      this.updateShape((IBlockAccess)var1, (BlockPosition)var2);
      return super.getBoundingBox(var1, var2, var3);
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      this.d(var1.getType(var2));
   }

   public void j() {
      float var1 = 0.1875F;
      this.setSizes(0.0F, 0.40625F, 0.0F, 1.0F, 0.59375F, 1.0F);
   }

   public void d(IBlockData var1) {
      if(var1.getBlock() == this) {
         boolean var2 = var1.get(N) == BlockTrapdoor.class_a_in_class_alr.a;
         Boolean var3 = (Boolean)var1.get(b);
         EnumDirection var4 = (EnumDirection)var1.get(a);
         float var5 = 0.1875F;
         if(var2) {
            this.setSizes(0.0F, 0.8125F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else {
            this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.1875F, 1.0F);
         }

         if(var3.booleanValue()) {
            if(var4 == EnumDirection.NORTH) {
               this.setSizes(0.0F, 0.0F, 0.8125F, 1.0F, 1.0F, 1.0F);
            }

            if(var4 == EnumDirection.SOUTH) {
               this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F);
            }

            if(var4 == EnumDirection.WEST) {
               this.setSizes(0.8125F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }

            if(var4 == EnumDirection.EAST) {
               this.setSizes(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F);
            }
         }

      }
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(this.material == Material.ORE) {
         return true;
      } else {
         var3 = var3.a(b);
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 2);
         var1.a(var4, ((Boolean)var3.get(b)).booleanValue()?1003:1006, var2, 0);
         return true;
      }
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!var1.isClientSide) {
         boolean var5 = var1.isBlockIndirectlyPowered(var2);
         if(var5 || var4.isPowerSource()) {
            boolean var6 = ((Boolean)var3.get(b)).booleanValue();
            if(var6 != var5) {
               var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(b, Boolean.valueOf(var5)), 2);
               var1.a((EntityHuman)null, var5?1003:1006, var2, 0);
            }
         }

      }
   }

   public MovingObjectPosition rayTraceCollision(World var1, BlockPosition var2, Vec3D var3, Vec3D var4) {
      this.updateShape((IBlockAccess)var1, (BlockPosition)var2);
      return super.rayTraceCollision(var1, var2, var3, var4);
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      IBlockData var9 = this.getBlockData();
      if(var3.getAxis().isHorizontal()) {
         var9 = var9.set(a, var3).set(b, Boolean.valueOf(false));
         var9 = var9.set(N, var5 > 0.5F? BlockTrapdoor.class_a_in_class_alr.a: BlockTrapdoor.class_a_in_class_alr.b);
      }

      return var9;
   }

   public boolean canPlace(World var1, BlockPosition var2, EnumDirection var3) {
      return true;
   }

   protected static EnumDirection b(int var0) {
      switch(var0 & 3) {
      case 0:
         return EnumDirection.NORTH;
      case 1:
         return EnumDirection.SOUTH;
      case 2:
         return EnumDirection.WEST;
      case 3:
      default:
         return EnumDirection.EAST;
      }
   }

   protected static int a(EnumDirection var0) {
      switch(BlockTrapdoor.SyntheticClass_1.a[var0.ordinal()]) {
      case 1:
         return 0;
      case 2:
         return 1;
      case 3:
         return 2;
      case 4:
      default:
         return 3;
      }
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, b(var1)).set(b, Boolean.valueOf((var1 & 4) != 0)).set(N, (var1 & 8) == 0? BlockTrapdoor.class_a_in_class_alr.b: BlockTrapdoor.class_a_in_class_alr.a);
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | a((EnumDirection)var1.get(a));
      if(((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 4;
      }

      if(var1.get(N) == BlockTrapdoor.class_a_in_class_alr.a) {
         var3 |= 8;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(a)));
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b, N});
   }

   static {
      a = BlockDirectional.FACING;
      b = BlockStateBoolean.of("open");
      N = BlockStateEnum.of("half", BlockTrapdoor.class_a_in_class_alr.class);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumDirection.values().length];

      static {
         try {
            a[EnumDirection.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[EnumDirection.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_alr implements INamable {
      a("top"),
      b("bottom");

      private final String c;

      private class_a_in_class_alr(String var3) {
         this.c = var3;
      }

      public String toString() {
         return this.c;
      }

      public String getName() {
         return this.c;
      }
   }
}
