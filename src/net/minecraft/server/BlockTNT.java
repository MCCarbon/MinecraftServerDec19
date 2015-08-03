package net.minecraft.server;

public class BlockTNT extends Block {
   public static final BlockStateBoolean a = BlockStateBoolean.of("explode");

   public BlockTNT() {
      super(Material.TNT);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)));
      this.setCreativeTab(CreativeTab.REDSTONE);
   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      super.onPlace(var1, var2, var3);
      if(var1.isBlockIndirectlyPowered(var2)) {
         this.postBreak(var1, var2, var3.set(a, Boolean.valueOf(true)));
         var1.setAir(var2);
      }

   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(var1.isBlockIndirectlyPowered(var2)) {
         this.postBreak(var1, var2, var3.set(a, Boolean.valueOf(true)));
         var1.setAir(var2);
      }

   }

   public void wasExploded(World var1, BlockPosition var2, Explosion var3) {
      if(!var1.isClientSide) {
         EntityTNTPrimed var4 = new EntityTNTPrimed(var1, (double)((float)var2.getX() + 0.5F), (double)var2.getY(), (double)((float)var2.getZ() + 0.5F), var3.getSource());
         var4.a = var1.random.nextInt(var4.a / 4) + var4.a / 8;
         var1.addEntity((Entity)var4);
      }
   }

   public void postBreak(World var1, BlockPosition var2, IBlockData var3) {
      this.a(var1, var2, var3, (EntityLiving)null);
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4) {
      if(!var1.isClientSide) {
         if(((Boolean)var3.get(a)).booleanValue()) {
            EntityTNTPrimed var5 = new EntityTNTPrimed(var1, (double)((float)var2.getX() + 0.5F), (double)var2.getY(), (double)((float)var2.getZ() + 0.5F), var4);
            var1.addEntity((Entity)var5);
            var1.a((Entity)var5, "game.tnt.primed", 1.0F, 1.0F);
         }

      }
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var6 != null && (var6.getItem() == Items.FLINT_AND_STEEL || var6.getItem() == Items.FIRE_CHARGE)) {
         this.a(var1, var2, var3.set(a, Boolean.valueOf(true)), (EntityLiving)var4);
         var1.setAir(var2);
         if(var6.getItem() == Items.FLINT_AND_STEEL) {
            var6.a(1, (EntityLiving)var4);
         } else if(!var4.abilities.instabuild) {
            --var6.count;
         }

         return true;
      } else {
         return super.interact(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Entity var4) {
      if(!var1.isClientSide && var4 instanceof class_xd) {
         class_xd var5 = (class_xd)var4;
         if(var5.av()) {
            this.a(var1, var2, var1.getType(var2).set(a, Boolean.valueOf(true)), var5.e instanceof EntityLiving?(EntityLiving)var5.e:null);
            var1.setAir(var2);
         }
      }

   }

   public boolean dropsFromExplosion(Explosion var1) {
      return false;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Boolean.valueOf((var1 & 1) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Boolean)var1.get(a)).booleanValue()?1:0;
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
