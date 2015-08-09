package net.minecraft.server;

import java.util.List;

public class EntityMinecartHopper extends class_vq implements class_ams {
   private boolean a = true;
   private int b = -1;
   private BlockPosition c;

   public EntityMinecartHopper(World var1) {
      super(var1);
      this.c = BlockPosition.ZERO;
   }

   public EntityMinecartHopper(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
      this.c = BlockPosition.ZERO;
   }

   public EnumMinecartType s() {
      return EnumMinecartType.HOPPER;
   }

   public IBlockData u() {
      return Blocks.HOPPER.getBlockData();
   }

   public int w() {
      return 1;
   }

   public int getSize() {
      return 5;
   }

   public boolean a(EntityHuman var1, ItemStack var2, EnumUsedHand var3) {
      if(!this.world.isClientSide) {
         var1.openContainer((IInventory)this);
      }

      return true;
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      boolean var5 = !var4;
      if(var5 != this.y()) {
         this.i(var5);
      }

   }

   public boolean y() {
      return this.a;
   }

   public void i(boolean var1) {
      this.a = var1;
   }

   public World getWorld() {
      return this.world;
   }

   public double A() {
      return this.locX;
   }

   public double B() {
      return this.locY + 0.5D;
   }

   public double C() {
      return this.locZ;
   }

   public void t_() {
      super.t_();
      if(!this.world.isClientSide && this.isAlive() && this.y()) {
         BlockPosition var1 = new BlockPosition(this);
         if(var1.equals(this.c)) {
            --this.b;
         } else {
            this.m(0);
         }

         if(!this.E()) {
            this.m(0);
            if(this.D()) {
               this.m(4);
               this.update();
            }
         }
      }

   }

   public boolean D() {
      if(TileEntityHopper.a((class_ams)this)) {
         return true;
      } else {
         List var1 = this.world.a(EntityItem.class, this.getBoundingBox().grow(0.25D, 0.0D, 0.25D), IEntitySelector.IS_ALIVE);
         if(!var1.isEmpty()) {
            TileEntityHopper.a((IInventory)this, (EntityItem)((EntityItem)var1.get(0)));
         }

         return false;
      }
   }

   public void a(DamageSource var1) {
      super.a(var1);
      if(this.world.R().getBooleanValue("doEntityDrops")) {
         this.a(Item.getItemOf((Block)Blocks.HOPPER), 1, 0.0F);
      }

   }

   protected void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("TransferCooldown", this.b);
   }

   protected void read(NBTTagCompound var1) {
      super.read(var1);
      this.b = var1.getInt("TransferCooldown");
   }

   public void m(int var1) {
      this.b = var1;
   }

   public boolean E() {
      return this.b > 0;
   }

   public String getContainerName() {
      return "minecraft:hopper";
   }

   public Container createContainer(PlayerInventory var1, EntityHuman var2) {
      return new ContainerDispenser(var1, this, var2);
   }
}
