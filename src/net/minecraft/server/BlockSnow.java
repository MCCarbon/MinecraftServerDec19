package net.minecraft.server;

import java.util.Random;

public class BlockSnow extends Block {
   public static final BlockStateInteger a = BlockStateInteger.of("layers", 1, 8);

   protected BlockSnow() {
      super(Material.PACKED_ICE);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(1)));
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.setTicking(true);
      this.setCreativeTab(CreativeTab.DECORATIONS);
      this.j();
   }

   public boolean isPassable(IBlockAccess var1, BlockPosition var2) {
      return ((Integer)var1.getType(var2).get(a)).intValue() < 5;
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      int var4 = ((Integer)var3.get(a)).intValue() - 1;
      float var5 = 0.125F;
      return new AxisAlignedBB((double)var2.getX() + this.minX, (double)var2.getY() + this.minY, (double)var2.getZ() + this.minZ, (double)var2.getX() + this.maxX, (double)((float)var2.getY() + (float)var4 * var5), (double)var2.getZ() + this.maxZ);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public void j() {
      this.b(0);
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      IBlockData var3 = var1.getType(var2);
      this.b(((Integer)var3.get(a)).intValue());
   }

   protected void b(int var1) {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, (float)var1 / 8.0F, 1.0F);
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      IBlockData var3 = var1.getType(var2.down());
      Block var4 = var3.getBlock();
      return var4 != Blocks.ICE && var4 != Blocks.PACKED_ICE?(var4.getMaterial() == Material.LEAVES?true:(var4 == this && ((Integer)var3.get(a)).intValue() >= 7?true:var4.isOpaqueCube() && var4.material.isSolid())):false;
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   private boolean e(World var1, BlockPosition var2, IBlockData var3) {
      if(!this.canPlace(var1, var2)) {
         this.dropNaturallyForSure(var1, var2, var3, 0);
         var1.setAir(var2);
         return false;
      } else {
         return true;
      }
   }

   public void breakBlockNaturally(World var1, EntityHuman var2, BlockPosition var3, IBlockData var4, TileEntity var5, ItemStack var6) {
      dropItem(var1, var3, new ItemStack(Items.SNOWBALL, ((Integer)var4.get(a)).intValue() + 1, 0));
      var1.setAir(var3);
      var2.b(StatisticList.ab[Block.getId((Block)this)]);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.SNOWBALL;
   }

   public int getDropCount(Random var1) {
      return 0;
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(var1.b(class_aet.b, var2) > 11) {
         this.dropNaturallyForSure(var1, var2, var1.getType(var2), 0);
         var1.setAir(var2);
      }

   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf((var1 & 7) + 1));
   }

   public boolean isReplaceable(World var1, BlockPosition var2) {
      return ((Integer)var1.getType(var2).get(a)).intValue() == 1;
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue() - 1;
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
