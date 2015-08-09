package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class EntityLeash extends class_uz {
   public EntityLeash(World var1) {
      super(var1);
   }

   public EntityLeash(World var1, BlockPosition var2) {
      super(var1, var2);
      this.setPosition((double)var2.getX() + 0.5D, (double)var2.getY() + 0.5D, (double)var2.getZ() + 0.5D);
      float var3 = 0.125F;
      float var4 = 0.1875F;
      float var5 = 0.25F;
      this.setBoundingBox((AxisAlignedBB)(new AxisAlignedBB(this.locX - 0.1875D, this.locY - 0.25D + 0.125D, this.locZ - 0.1875D, this.locX + 0.1875D, this.locY + 0.25D + 0.125D, this.locZ + 0.1875D)));
   }

   public void a(EnumDirection var1) {
   }

   public int l() {
      return 9;
   }

   public int m() {
      return 9;
   }

   public float getHeadHeight() {
      return -0.0625F;
   }

   public void b(Entity var1) {
   }

   public boolean d(NBTTagCompound var1) {
      return false;
   }

   public void write(NBTTagCompound var1) {
   }

   public void read(NBTTagCompound var1) {
   }

   public boolean a(EntityHuman var1, ItemStack var2, EnumUsedHand var3) {
      if(this.world.isClientSide) {
         return true;
      } else {
         boolean var4 = false;
         double var5;
         List var7;
         Iterator var8;
         EntityInsentient var9;
         if(var2 != null && var2.getItem() == Items.LEAD) {
            var5 = 7.0D;
            var7 = this.world.getEntities(EntityInsentient.class, new AxisAlignedBB(this.locX - var5, this.locY - var5, this.locZ - var5, this.locX + var5, this.locY + var5, this.locZ + var5));
            var8 = var7.iterator();

            while(var8.hasNext()) {
               var9 = (EntityInsentient)var8.next();
               if(var9.cq() && var9.cr() == var1) {
                  var9.a(this, true);
                  var4 = true;
               }
            }
         }

         if(!var4) {
            this.die();
            if(var1.abilities.instabuild) {
               var5 = 7.0D;
               var7 = this.world.getEntities(EntityInsentient.class, new AxisAlignedBB(this.locX - var5, this.locY - var5, this.locZ - var5, this.locX + var5, this.locY + var5, this.locZ + var5));
               var8 = var7.iterator();

               while(var8.hasNext()) {
                  var9 = (EntityInsentient)var8.next();
                  if(var9.cq() && var9.cr() == this) {
                     var9.a(true, false);
                  }
               }
            }
         }

         return true;
      }
   }

   public boolean j() {
      return this.world.getType(this.a).getBlock() instanceof BlockFence;
   }

   public static EntityLeash a(World var0, BlockPosition var1) {
      EntityLeash var2 = new EntityLeash(var0, var1);
      var2.attachedToPlayer = true;
      var0.addEntity((Entity)var2);
      return var2;
   }

   public static EntityLeash b(World var0, BlockPosition var1) {
      int var2 = var1.getX();
      int var3 = var1.getY();
      int var4 = var1.getZ();
      List var5 = var0.getEntities(EntityLeash.class, new AxisAlignedBB((double)var2 - 1.0D, (double)var3 - 1.0D, (double)var4 - 1.0D, (double)var2 + 1.0D, (double)var3 + 1.0D, (double)var4 + 1.0D));
      Iterator var6 = var5.iterator();

      EntityLeash var7;
      do {
         if(!var6.hasNext()) {
            return null;
         }

         var7 = (EntityLeash)var6.next();
      } while(!var7.n().equals(var1));

      return var7;
   }
}
