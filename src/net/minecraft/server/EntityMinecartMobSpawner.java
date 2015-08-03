package net.minecraft.server;

public class EntityMinecartMobSpawner extends EntityMinecartAbstract {
   private final class_aee a = new class_aee() {
      public void a(int var1) {
         EntityMinecartMobSpawner.this.o.a((Entity)EntityMinecartMobSpawner.this, (byte)((byte)var1));
      }

      public World a() {
         return EntityMinecartMobSpawner.this.o;
      }

      public BlockPosition b() {
         return new BlockPosition(EntityMinecartMobSpawner.this);
      }
   };

   public EntityMinecartMobSpawner(World var1) {
      super(var1);
   }

   public EntityMinecartMobSpawner(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public EnumMinecartType s() {
      return EnumMinecartType.SPAWNER;
   }

   public IBlockData u() {
      return Blocks.MOB_SPAWNER.getBlockData();
   }

   protected void read(NBTTagCompound var1) {
      super.read(var1);
      this.a.a(var1);
   }

   protected void write(NBTTagCompound var1) {
      super.write(var1);
      this.a.b(var1);
   }

   public void t_() {
      super.t_();
      this.a.c();
   }
}
