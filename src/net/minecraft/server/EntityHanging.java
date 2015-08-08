package net.minecraft.server;

public class EntityHanging extends Item {
   private final Class a;

   public EntityHanging(Class var1) {
      this.a = var1;
      this.setCreativeTab(CreativeTab.DECORATIONS);
   }

   public UseResult interactWith(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 == EnumDirection.DOWN) {
         return UseResult.CANT_USE;
      } else if(var6 == EnumDirection.UP) {
         return UseResult.CANT_USE;
      } else {
         BlockPosition var10 = var4.shift(var6);
         if(!var2.a(var10, var6, var1)) {
            return UseResult.CANT_USE;
         } else {
            class_uz var11 = this.a(var3, var10, var6);
            if(var11 != null && var11.j()) {
               if(!var3.isClientSide) {
                  var3.addEntity((Entity)var11);
               }

               --var1.count;
            }

            return UseResult.SUCCESS;
         }
      }
   }

   private class_uz a(World var1, BlockPosition var2, EnumDirection var3) {
      return (class_uz)(this.a == EntityPainting.class?new EntityPainting(var1, var2, var3):(this.a == EntityItemFrame.class?new EntityItemFrame(var1, var2, var3):null));
   }
}
