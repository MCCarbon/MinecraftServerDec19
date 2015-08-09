package net.minecraft.server;

public class EntityMinecartChest extends class_vq {
   public EntityMinecartChest(World var1) {
      super(var1);
   }

   public EntityMinecartChest(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public void a(DamageSource var1) {
      super.a(var1);
      if(this.world.R().getBooleanValue("doEntityDrops")) {
         this.a(Item.getItemOf((Block)Blocks.CHEST), 1, 0.0F);
      }

   }

   public int getSize() {
      return 27;
   }

   public EnumMinecartType s() {
      return EnumMinecartType.CHEST;
   }

   public IBlockData u() {
      return Blocks.CHEST.getBlockData().set(BlockChest.a, EnumDirection.NORTH);
   }

   public int w() {
      return 8;
   }

   public String getContainerName() {
      return "minecraft:chest";
   }

   public Container createContainer(PlayerInventory var1, EntityHuman var2) {
      return new ContainerChest(var1, this, var2);
   }
}
