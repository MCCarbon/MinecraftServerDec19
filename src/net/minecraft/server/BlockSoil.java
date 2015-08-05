package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class BlockSoil extends Block {
   public static final BlockStateInteger a = BlockStateInteger.of("moisture", 0, 7);

   protected BlockSoil() {
      super(Material.EARTH);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
      this.setTicking(true);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
      this.setLightOpacity(255);
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      return new AxisAlignedBB((double)var2.getX(), (double)var2.getY(), (double)var2.getZ(), (double)(var2.getX() + 1), (double)(var2.getY() + 1), (double)(var2.getZ() + 1));
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      int var5 = ((Integer)var3.get(a)).intValue();
      if(!this.f(var1, var2) && !var1.C(var2.up())) {
         if(var5 > 0) {
            var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(var5 - 1)), 2);
         } else if(!this.e(var1, var2)) {
            var1.setTypeUpdate(var2, Blocks.DIRT.getBlockData());
         }
      } else if(var5 < 7) {
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(7)), 2);
      }

   }

   public void fallOn(World var1, BlockPosition var2, Entity var3, float var4) {
      if(var3 instanceof EntityLiving) {
         if(!var1.isClientSide && var1.random.nextFloat() < var4 - 0.5F) {
            if(!(var3 instanceof EntityHuman) && !var1.R().getBooleanValue("mobGriefing")) {
               return;
            }

            var1.setTypeUpdate(var2, Blocks.DIRT.getBlockData());
         }

         super.fallOn(var1, var2, var3, var4);
      }
   }

   private boolean e(World var1, BlockPosition var2) {
      Block var3 = var1.getType(var2.up()).getBlock();
      return var3 instanceof BlockCrops || var3 instanceof BlockStem;
   }

   private boolean f(World var1, BlockPosition var2) {
      Iterator var3 = BlockPosition.allInCubeM(var2.add(-4, 0, -4), var2.add(4, 1, 4)).iterator();

      BlockPosition.MutableBlockPosition var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (BlockPosition.MutableBlockPosition)var3.next();
      } while(var1.getType(var4).getBlock().getMaterial() != Material.WATER);

      return true;
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      super.doPhysics(var1, var2, var3, var4);
      if(var1.getType(var2.up()).getBlock().getMaterial().isBuildable()) {
         var1.setTypeUpdate(var2, Blocks.DIRT.getBlockData());
      }

   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Blocks.DIRT.getDropType(Blocks.DIRT.getBlockData().set(BlockDirt.VARIANT, BlockDirt.EnumDirtVariant.DIRT), var2, var3);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf(var1 & 7));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
