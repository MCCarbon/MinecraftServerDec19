package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class ItemLeash extends Item {
   public ItemLeash() {
      this.setCreativeTab(CreativeTab.TOOLS);
   }

   public UseResult interactWith(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      Block var10 = var3.getType(var4).getBlock();
      if(var10 instanceof BlockFence) {
         if(var3.isClientSide) {
            return UseResult.SUCCESS;
         } else {
            a(var2, var3, var4);
            return UseResult.SUCCESS;
         }
      } else {
         return UseResult.CANT_USE;
      }
   }

   public static boolean a(EntityHuman var0, World var1, BlockPosition var2) {
      EntityLeash var3 = EntityLeash.b(var1, var2);
      boolean var4 = false;
      double var5 = 7.0D;
      int var7 = var2.getX();
      int var8 = var2.getY();
      int var9 = var2.getZ();
      List var10 = var1.getEntities(EntityInsentient.class, new AxisAlignedBB((double)var7 - var5, (double)var8 - var5, (double)var9 - var5, (double)var7 + var5, (double)var8 + var5, (double)var9 + var5));
      Iterator var11 = var10.iterator();

      while(var11.hasNext()) {
         EntityInsentient var12 = (EntityInsentient)var11.next();
         if(var12.cq() && var12.cr() == var0) {
            if(var3 == null) {
               var3 = EntityLeash.a(var1, var2);
            }

            var12.a(var3, true);
            var4 = true;
         }
      }

      return var4;
   }
}
