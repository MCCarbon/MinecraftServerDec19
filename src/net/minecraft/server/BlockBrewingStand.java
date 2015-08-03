package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class BlockBrewingStand extends BlockContainer {
   public static final BlockStateBoolean[] a = new BlockStateBoolean[]{BlockStateBoolean.of("has_bottle_0"), BlockStateBoolean.of("has_bottle_1"), BlockStateBoolean.of("has_bottle_2")};

   public BlockBrewingStand() {
      super(Material.ORE);
      this.setBlockData(this.blockStateList.getFirst().set(a[0], Boolean.valueOf(false)).set(a[1], Boolean.valueOf(false)).set(a[2], Boolean.valueOf(false)));
   }

   public String getName() {
      return LocaleI18n.get("item.brewingStand.name");
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public int getRenderType() {
      return 3;
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityBrewingStand();
   }

   public boolean isFullCube() {
      return false;
   }

   public void addBBIfInsideInputBB(World var1, BlockPosition var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      this.setSizes(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      this.j();
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
   }

   public void j() {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.isClientSide) {
         return true;
      } else {
         TileEntity var11 = var1.getTileEntity(var2);
         if(var11 instanceof TileEntityBrewingStand) {
            var4.openContainer((IInventory)((TileEntityBrewingStand)var11));
            var4.b(StatisticList.M);
         }

         return true;
      }
   }

   public void postPlace(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      if(var5.hasDisplayName()) {
         TileEntity var6 = var1.getTileEntity(var2);
         if(var6 instanceof TileEntityBrewingStand) {
            ((TileEntityBrewingStand)var6).a(var5.getDisplayName());
         }
      }

   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      TileEntity var4 = var1.getTileEntity(var2);
      if(var4 instanceof TileEntityBrewingStand) {
         class_ol.a(var1, (BlockPosition)var2, (TileEntityBrewingStand)var4);
      }

      super.remove(var1, var2, var3);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.BREWING_STAND;
   }

   public boolean isComplexRedstone() {
      return true;
   }

   public int getRedstonePower(World var1, BlockPosition var2) {
      return Container.a(var1.getTileEntity(var2));
   }

   public IBlockData fromLegacyData(int var1) {
      IBlockData var2 = this.getBlockData();

      for(int var3 = 0; var3 < 3; ++var3) {
         var2 = var2.set(a[var3], Boolean.valueOf((var1 & 1 << var3) > 0));
      }

      return var2;
   }

   public int toLegacyData(IBlockData var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < 3; ++var3) {
         if(((Boolean)var1.get(a[var3])).booleanValue()) {
            var2 |= 1 << var3;
         }
      }

      return var2;
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a[0], a[1], a[2]});
   }
}
