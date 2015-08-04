package net.minecraft.server;

import java.util.Random;

public class BlockBanner extends BlockContainer {
   public static final BlockStateDirection a;
   public static final BlockStateInteger b;

   protected BlockBanner() {
      super(Material.WOOD);
      float var1 = 0.25F;
      float var2 = 1.0F;
      this.setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
   }

   public String getName() {
      return LocaleI18n.get("item.banner.white.name");
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      return null;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isPassable(IBlockAccess var1, BlockPosition var2) {
      return true;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean g() {
      return true;
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityBanner();
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.BANNER;
   }

   public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
      TileEntity var6 = var1.getTileEntity(var2);
      if(var6 instanceof TileEntityBanner) {
         ItemStack var7 = new ItemStack(Items.BANNER, 1, ((TileEntityBanner)var6).b());
         NBTTagCompound var8 = new NBTTagCompound();
         var6.write(var8);
         var8.remove("x");
         var8.remove("y");
         var8.remove("z");
         var8.remove("id");
         var7.addTag((String)"BlockEntityTag", (NBTTag)var8);
         dropItem(var1, var2, var7);
      } else {
         super.dropNaturally(var1, var2, var3, var4, var5);
      }

   }

   public boolean canPlace(World var1, BlockPosition var2) {
      return !this.e(var1, var2) && super.canPlace(var1, var2);
   }

   public void breakBlockNaturally(World var1, EntityHuman var2, BlockPosition var3, IBlockData var4, TileEntity var5, ItemStack var6) {
      if(var5 instanceof TileEntityBanner) {
         TileEntityBanner var7 = (TileEntityBanner)var5;
         ItemStack var8 = new ItemStack(Items.BANNER, 1, ((TileEntityBanner)var5).b());
         NBTTagCompound var9 = new NBTTagCompound();
         TileEntityBanner.a(var9, var7.b(), var7.d());
         var8.addTag((String)"BlockEntityTag", (NBTTag)var9);
         dropItem(var1, var3, var8);
      } else {
         super.breakBlockNaturally(var1, var2, var3, var4, (TileEntity)null, var6);
      }

   }

   static {
      a = BlockDirectional.FACING;
      b = BlockStateInteger.of("rotation", 0, 15);
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

   public static class BlockStandingBanner extends BlockBanner {
      public BlockStandingBanner() {
         this.setBlockData(this.blockStateList.getFirst().set(b, Integer.valueOf(0)));
      }

      public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
         return var1.getBlock() != this?var1:var1.set(b, Integer.valueOf(var2.a(((Integer)var1.get(b)).intValue(), 16)));
      }

      public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
         return var1.getBlock() != this?var1:var1.set(b, Integer.valueOf(var2.a(((Integer)var1.get(b)).intValue(), 16)));
      }

      public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
         if(!var1.getType(var2.down()).getBlock().getMaterial().isBuildable()) {
            this.dropNaturallyForSure(var1, var2, var3, 0);
            var1.setAir(var2);
         }

         super.doPhysics(var1, var2, var3, var4);
      }

      public IBlockData fromLegacyData(int var1) {
         return this.getBlockData().set(b, Integer.valueOf(var1));
      }

      public int toLegacyData(IBlockData var1) {
         return ((Integer)var1.get(b)).intValue();
      }

      protected BlockStateList getStateList() {
         return new BlockStateList(this, new IBlockState[]{b});
      }
   }

   public static class BlockWallBanner extends BlockBanner {
      public BlockWallBanner() {
         this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH));
      }

      public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
         return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
      }

      public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
         return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(a)));
      }

      public void updateShape(IBlockAccess var1, BlockPosition var2) {
         EnumDirection var3 = (EnumDirection)var1.getType(var2).get(a);
         float var4 = 0.0F;
         float var5 = 0.78125F;
         float var6 = 0.0F;
         float var7 = 1.0F;
         float var8 = 0.125F;
         this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         switch(BlockBanner.SyntheticClass_1.a[var3.ordinal()]) {
         case 1:
         default:
            this.setSizes(var6, var4, 1.0F - var8, var7, var5, 1.0F);
            break;
         case 2:
            this.setSizes(var6, var4, 0.0F, var7, var5, var8);
            break;
         case 3:
            this.setSizes(1.0F - var8, var4, var6, 1.0F, var5, var7);
            break;
         case 4:
            this.setSizes(0.0F, var4, var6, var8, var5, var7);
         }

      }

      public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
         EnumDirection var5 = (EnumDirection)var3.get(a);
         if(!var1.getType(var2.shift(var5.opposite())).getBlock().getMaterial().isBuildable()) {
            this.dropNaturallyForSure(var1, var2, var3, 0);
            var1.setAir(var2);
         }

         super.doPhysics(var1, var2, var3, var4);
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

      protected BlockStateList getStateList() {
         return new BlockStateList(this, new IBlockState[]{a});
      }
   }
}
