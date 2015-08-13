package net.minecraft.server;

public class EntityMinecartCommandBlock extends EntityMinecartAbstract {
   private static final int a = Datawatcher.claimId(EntityMinecartCommandBlock.class);
   private static final int b = Datawatcher.claimId(EntityMinecartCommandBlock.class);
   private final class_aed c = new class_aed() {
      public void h() {
         EntityMinecartCommandBlock.this.H().update(EntityMinecartCommandBlock.a, this.l());
         EntityMinecartCommandBlock.this.H().update(EntityMinecartCommandBlock.b, IChatBaseComponent.ChatSerializer.toJson(this.k()));
      }

      public BlockPosition c() {
         return new BlockPosition(EntityMinecartCommandBlock.this.locX, EntityMinecartCommandBlock.this.locY + 0.5D, EntityMinecartCommandBlock.this.locZ);
      }

      public Vec3D d() {
         return new Vec3D(EntityMinecartCommandBlock.this.locX, EntityMinecartCommandBlock.this.locY, EntityMinecartCommandBlock.this.locZ);
      }

      public World e() {
         return EntityMinecartCommandBlock.this.world;
      }

      public Entity f() {
         return EntityMinecartCommandBlock.this;
      }
   };
   private int d = 0;

   public EntityMinecartCommandBlock(World var1) {
      super(var1);
   }

   public EntityMinecartCommandBlock(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected void initDatawatcher() {
      super.initDatawatcher();
      this.H().add(a, "");
      this.H().add(b, "");
   }

   protected void read(NBTTagCompound var1) {
      super.read(var1);
      this.c.b(var1);
      this.H().update(a, this.j().l());
      this.H().update(b, IChatBaseComponent.ChatSerializer.toJson(this.j().k()));
   }

   protected void write(NBTTagCompound var1) {
      super.write(var1);
      this.c.a(var1);
   }

   public EnumMinecartType s() {
      return EnumMinecartType.COMMAND_BLOCK;
   }

   public IBlockData u() {
      return Blocks.COMMAND_BLOCK.getBlockData();
   }

   public class_aed j() {
      return this.c;
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      if(var4 && this.ticksLived - this.d >= 4) {
         this.j().a(this.world);
         this.d = this.ticksLived;
      }

   }

   public boolean a(EntityHuman var1, ItemStack var2, EnumUsedHand var3) {
      this.c.a(var1);
      return false;
   }

   public void d(int var1) {
      super.d(var1);
      if(var1 == b) {
         try {
            this.c.b(IChatBaseComponent.ChatSerializer.fromJson(this.H().getString(b)));
         } catch (Throwable var3) {
            ;
         }
      } else if(var1 == a) {
         this.c.a(this.H().getString(a));
      }

   }
}
