package net.minecraft.server;

import java.util.List;

public class ItemBoat extends Item {
   public ItemBoat() {
      this.maxStackSize = 1;
      this.setCreativeTab(CreativeTab.TRANSPORTATION);
   }

   public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      float var5 = 1.0F;
      float var6 = var3.lastPitch + (var3.pitch - var3.lastPitch) * var5;
      float var7 = var3.lastYaw + (var3.yaw - var3.lastYaw) * var5;
      double var8 = var3.lastX + (var3.locX - var3.lastX) * (double)var5;
      double var10 = var3.lastY + (var3.locY - var3.lastY) * (double)var5 + (double)var3.aU();
      double var12 = var3.lastZ + (var3.locZ - var3.lastZ) * (double)var5;
      Vec3D var14 = new Vec3D(var8, var10, var12);
      float var15 = MathHelper.cos(-var7 * 0.017453292F - 3.1415927F);
      float var16 = MathHelper.sin(-var7 * 0.017453292F - 3.1415927F);
      float var17 = -MathHelper.cos(-var6 * 0.017453292F);
      float var18 = MathHelper.sin(-var6 * 0.017453292F);
      float var19 = var16 * var17;
      float var21 = var15 * var17;
      double var22 = 5.0D;
      Vec3D var24 = var14.add((double)var19 * var22, (double)var18 * var22, (double)var21 * var22);
      MovingObjectPosition var25 = var2.a(var14, var24, true);
      if(var25 == null) {
         return new UseResultWithValue(UseResult.CANT_USE, var1);
      } else {
         Vec3D var26 = var3.d(var5);
         boolean var27 = false;
         float var28 = 1.0F;
         List var29 = var2.getEntities((Entity)var3, (AxisAlignedBB)var3.getBoundingBox().add(var26.x * var22, var26.y * var22, var26.z * var22).grow((double)var28, (double)var28, (double)var28));

         for(int var30 = 0; var30 < var29.size(); ++var30) {
            Entity var31 = (Entity)var29.get(var30);
            if(var31.ad()) {
               float var32 = var31.ao();
               AxisAlignedBB var33 = var31.getBoundingBox().grow((double)var32, (double)var32, (double)var32);
               if(var33.a(var14)) {
                  var27 = true;
               }
            }
         }

         if(var27) {
            return new UseResultWithValue(UseResult.CANT_USE, var1);
         } else if(var25.a == MovingObjectPosition.class_a_in_class_awg.b) {
            BlockPosition var34 = var25.a();
            if(var2.getType(var34).getBlock() == Blocks.SNOW_LAYER) {
               var34 = var34.down();
            }

            EntityBoat var35 = new EntityBoat(var2, (double)((float)var34.getX() + 0.5F), (double)((float)var34.getY() + 1.0F), (double)((float)var34.getZ() + 0.5F));
            var35.yaw = (float)(((MathHelper.floor((double)(var3.yaw * 4.0F / 360.0F) + 0.5D) & 3) - 1) * 90);
            if(!var2.getCubes((Entity)var35, (AxisAlignedBB)var35.getBoundingBox().grow(-0.1D, -0.1D, -0.1D)).isEmpty()) {
               return new UseResultWithValue(UseResult.CANT_USE, var1);
            } else {
               if(!var2.isClientSide) {
                  var2.addEntity((Entity)var35);
               }

               if(!var3.abilities.instabuild) {
                  --var1.count;
               }

               var3.b(StatisticList.ad[Item.getId((Item)this)]);
               return new UseResultWithValue(UseResult.SUCCESS, var1);
            }
         } else {
            return new UseResultWithValue(UseResult.CANT_USE, var1);
         }
      }
   }
}
