package net.minecraft.server;

public class BlockAnvil extends BlockFalling {
   public static final BlockStateDirection a;
   public static final BlockStateInteger b;

   protected BlockAnvil() {
      super(Material.HEAVY);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH).set(b, Integer.valueOf(0)));
      this.setLightOpacity(0);
      this.setCreativeTab((CreativeTab)CreativeTab.DECORATIONS);
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      EnumDirection var9 = var8.aR().rotateY();
      return super.getPlacedState(var1, var2, var3, var4, var5, var6, var7, var8).set(a, var9).set(b, Integer.valueOf(var7 >> 2));
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(!var1.isClientSide) {
         var4.a((ITileEntityContainer)(new BlockAnvil.class_a_in_class_aga(var1, var2)));
      }

      return true;
   }

   public int getDropData(IBlockData var1) {
      return ((Integer)var1.get(b)).intValue();
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      EnumDirection var3 = (EnumDirection)var1.getType(var2).get(a);
      if(var3.getAxis() == EnumDirection.EnumAxis.X) {
         this.setSizes(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
      } else {
         this.setSizes(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
      }

   }

   protected void init(EntityFallingBlock var1) {
      var1.a(true);
   }

   public void a_(World var1, BlockPosition var2) {
      var1.b(1022, var2, 0);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, EnumDirection.getByHorizontalId(var1 & 3)).set(b, Integer.valueOf((var1 & 15) >> 2));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(a)).getHorizontalId();
      var3 |= ((Integer)var1.get(b)).intValue() << 2;
      return var3;
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b});
   }

   static {
      a = BlockDirectional.FACING;
      b = BlockStateInteger.of("damage", 0, 2);
   }

   public static class class_a_in_class_aga implements ITileEntityContainer {
      private final World a;
      private final BlockPosition b;

      public class_a_in_class_aga(World var1, BlockPosition var2) {
         this.a = var1;
         this.b = var2;
      }

      public String getName() {
         return "anvil";
      }

      public boolean hasCustomName() {
         return false;
      }

      public IChatBaseComponent getScoreboardDisplayName() {
         return new ChatMessage(Blocks.ANVIL.getInternalName() + ".name", new Object[0]);
      }

      public Container createContainer(PlayerInventory var1, EntityHuman var2) {
         return new class_yb(var1, this.a, this.b, var2);
      }

      public String getContainerName() {
         return "minecraft:anvil";
      }
   }
}
