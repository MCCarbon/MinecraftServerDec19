package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class BlockCauldron extends Block {
   public static final BlockStateInteger a = BlockStateInteger.of("level", 0, 3);

   public BlockCauldron() {
      super(Material.ORE, MaterialMapColor.COLOR12);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
   }

   public void addBBIfInsideInputBB(World var1, BlockPosition var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      float var7 = 0.125F;
      this.setSizes(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      this.setSizes(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      this.setSizes(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
      super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
      this.j();
   }

   public void j() {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Entity var4) {
      int var5 = ((Integer)var3.get(a)).intValue();
      float var6 = (float)var2.getY() + (6.0F + (float)(3 * var5)) / 16.0F;
      if(!var1.isClientSide && var4.av() && var5 > 0 && var4.getBoundingBox().yMin <= (double)var6) {
         var4.N();
         this.a(var1, var2, var3, var5 - 1);
      }

   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.isClientSide) {
         return true;
      } else if(var6 == null) {
         return true;
      } else {
         int var11 = ((Integer)var3.get(a)).intValue();
         Item var12 = var6.getItem();
         if(var12 == Items.WATER_BUCKET) {
            if(var11 < 3) {
               if(!var4.abilities.instabuild) {
                  var4.a((EnumUsedHand)var5, (ItemStack)(new ItemStack(Items.BUCKET)));
               }

               var4.b(StatisticList.I);
               this.a(var1, var2, var3, 3);
            }

            return true;
         } else {
            ItemStack var14;
            if(var12 == Items.GLASS_BOTTLE) {
               if(var11 > 0) {
                  if(!var4.abilities.instabuild) {
                     var14 = ItemPotion.a(new ItemStack(Items.POTION), class_acf.a);
                     var4.b(StatisticList.J);
                     if(--var6.count == 0) {
                        var4.a((EnumUsedHand)var5, (ItemStack)var14);
                     } else if(!var4.inventory.pickup(var14)) {
                        var4.a(var14, false);
                     } else if(var4 instanceof EntityPlayer) {
                        ((EntityPlayer)var4).a(var4.bq);
                     }
                  }

                  this.a(var1, var2, var3, var11 - 1);
               }

               return true;
            } else {
               if(var11 > 0 && var12 instanceof ItemArmor) {
                  ItemArmor var13 = (ItemArmor)var12;
                  if(var13.d() == ItemArmor.EnumArmorMaterial.LEATHER && var13.d_(var6)) {
                     var13.c(var6);
                     this.a(var1, var2, var3, var11 - 1);
                     var4.b(StatisticList.K);
                     return true;
                  }
               }

               if(var11 > 0 && var12 instanceof ItemBanner && TileEntityBanner.c(var6) > 0) {
                  var14 = var6.clone();
                  var14.count = 1;
                  TileEntityBanner.e(var14);
                  var4.b(StatisticList.L);
                  if(var4.abilities.instabuild) {
                     --var6.count;
                  }

                  if(var6.count == 0) {
                     var4.a((EnumUsedHand)var5, (ItemStack)var14);
                  } else if(!var4.inventory.pickup(var14)) {
                     var4.a(var14, false);
                  } else if(var4 instanceof EntityPlayer) {
                     ((EntityPlayer)var4).a(var4.bq);
                  }

                  if(!var4.abilities.instabuild) {
                     this.a(var1, var2, var3, var11 - 1);
                  }

                  return true;
               } else {
                  return false;
               }
            }
         }
      }
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, int var4) {
      var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(MathHelper.clamp(var4, 0, 3))), 2);
      var1.e(var2, this);
   }

   public void rainTick(World var1, BlockPosition var2) {
      if(var1.random.nextInt(20) == 1) {
         IBlockData var3 = var1.getType(var2);
         if(((Integer)var3.get(a)).intValue() < 3) {
            var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.a(a), 2);
         }

      }
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.CAULDRON;
   }

   public boolean isComplexRedstone() {
      return true;
   }

   public int getRedstonePower(World var1, BlockPosition var2) {
      return ((Integer)var1.getType(var2).get(a)).intValue();
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
