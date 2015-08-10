package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.Validate;

public abstract class class_uz extends Entity {
   private int c;
   protected BlockPosition a;
   public EnumDirection b;

   public class_uz(World var1) {
      super(var1);
      this.setSize(0.5F, 0.5F);
   }

   public class_uz(World var1, BlockPosition var2) {
      this(var1);
      this.a = var2;
   }

   protected void initDatawatcher() {
   }

   protected void a(EnumDirection var1) {
      Validate.notNull(var1);
      Validate.isTrue(var1.getAxis().isHorizontal());
      this.b = var1;
      this.lastYaw = this.yaw = (float)(this.b.getHorizontalId() * 90);
      this.o();
   }

   private void o() {
      if(this.b != null) {
         double var1 = (double)this.a.getX() + 0.5D;
         double var3 = (double)this.a.getY() + 0.5D;
         double var5 = (double)this.a.getZ() + 0.5D;
         double var7 = 0.46875D;
         double var9 = this.a(this.l());
         double var11 = this.a(this.m());
         var1 -= (double)this.b.getAdjacentX() * 0.46875D;
         var5 -= (double)this.b.getAdjacentZ() * 0.46875D;
         var3 += var11;
         EnumDirection var13 = this.b.rotateYCCW();
         var1 += var9 * (double)var13.getAdjacentX();
         var5 += var9 * (double)var13.getAdjacentZ();
         this.locX = var1;
         this.locY = var3;
         this.locZ = var5;
         double var14 = (double)this.l();
         double var16 = (double)this.m();
         double var18 = (double)this.l();
         if(this.b.getAxis() == EnumDirection.EnumAxis.Z) {
            var18 = 1.0D;
         } else {
            var14 = 1.0D;
         }

         var14 /= 32.0D;
         var16 /= 32.0D;
         var18 /= 32.0D;
         this.setBoundingBox((AxisAlignedBB)(new AxisAlignedBB(var1 - var14, var3 - var16, var5 - var18, var1 + var14, var3 + var16, var5 + var18)));
      }
   }

   private double a(int var1) {
      return var1 % 32 == 0?0.5D:0.0D;
   }

   public void t_() {
      this.lastX = this.locX;
      this.lastY = this.locY;
      this.lastZ = this.locZ;
      if(this.c++ == 100 && !this.world.isClientSide) {
         this.c = 0;
         if(!this.dead && !this.j()) {
            this.die();
            this.b((Entity)null);
         }
      }

   }

   public boolean j() {
      if(!this.world.getCubes((Entity)this, (AxisAlignedBB)this.getBoundingBox()).isEmpty()) {
         return false;
      } else {
         int var1 = Math.max(1, this.l() / 16);
         int var2 = Math.max(1, this.m() / 16);
         BlockPosition var3 = this.a.shift(this.b.opposite());
         EnumDirection var4 = this.b.rotateYCCW();

         for(int var5 = 0; var5 < var1; ++var5) {
            for(int var6 = 0; var6 < var2; ++var6) {
               BlockPosition var7 = var3.shift(var4, var5).up(var6);
               Block var8 = this.world.getType(var7).getBlock();
               if(!var8.getMaterial().isBuildable() && !class_ahh.d(var8)) {
                  return false;
               }
            }
         }

         List var9 = this.world.getEntities((Entity)this, (AxisAlignedBB)this.getBoundingBox());
         Iterator var10 = var9.iterator();

         Entity var11;
         do {
            if(!var10.hasNext()) {
               return true;
            }

            var11 = (Entity)var10.next();
         } while(!(var11 instanceof class_uz));

         return false;
      }
   }

   public boolean ad() {
      return true;
   }

   public boolean l(Entity var1) {
      return var1 instanceof EntityHuman?this.damageEntity(DamageSource.playerAttack((EntityHuman) var1), 0.0F):false;
   }

   public EnumDirection aR() {
      return this.b;
   }

   public boolean damageEntity(DamageSource var1, float var2) {
      if(this.b((DamageSource)var1)) {
         return false;
      } else {
         if(!this.dead && !this.world.isClientSide) {
            this.die();
            this.ac();
            this.b(var1.getEntity());
         }

         return true;
      }
   }

   public void d(double var1, double var3, double var5) {
      if(!this.world.isClientSide && !this.dead && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D) {
         this.die();
         this.b((Entity)null);
      }

   }

   public void g(double var1, double var3, double var5) {
      if(!this.world.isClientSide && !this.dead && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D) {
         this.die();
         this.b((Entity)null);
      }

   }

   public void write(NBTTagCompound var1) {
      var1.put("Facing", (byte)this.b.getHorizontalId());
      var1.put("TileX", this.n().getX());
      var1.put("TileY", this.n().getY());
      var1.put("TileZ", this.n().getZ());
   }

   public void read(NBTTagCompound var1) {
      this.a = new BlockPosition(var1.getInt("TileX"), var1.getInt("TileY"), var1.getInt("TileZ"));
      EnumDirection var2;
      if(var1.hasOfType("Direction", 99)) {
         var2 = EnumDirection.getByHorizontalId(var1.getByte("Direction"));
         this.a = this.a.shift(var2);
      } else if(var1.hasOfType("Facing", 99)) {
         var2 = EnumDirection.getByHorizontalId(var1.getByte("Facing"));
      } else {
         var2 = EnumDirection.getByHorizontalId(var1.getByte("Dir"));
      }

      this.a(var2);
   }

   public abstract int l();

   public abstract int m();

   public abstract void b(Entity var1);

   protected boolean af() {
      return false;
   }

   public void setPosition(double var1, double var3, double var5) {
      this.locX = var1;
      this.locY = var3;
      this.locZ = var5;
      BlockPosition var7 = this.a;
      this.a = new BlockPosition(var1, var3, var5);
      if(!this.a.equals(var7)) {
         this.o();
         this.ai = true;
      }

   }

   public BlockPosition n() {
      return this.a;
   }

   public float a(Block.EnumRotation var1) {
      if(this.b.getAxis() != EnumDirection.EnumAxis.Y) {
         switch(class_uz.SyntheticClass_1.a[var1.ordinal()]) {
         case 1:
            this.b = this.b.opposite();
            break;
         case 2:
            this.b = this.b.rotateYCCW();
            break;
         case 3:
            this.b = this.b.rotateY();
         }
      }

      return super.a(var1);
   }

   public float a(Block.class_a_in_class_agj var1) {
      return this.a(var1.a(this.b));
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[Block.EnumRotation.values().length];

      static {
         try {
            a[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
