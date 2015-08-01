package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_dc;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.MathHelper;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.Entity;
import net.minecraft.server.class_uy;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_zb extends Item {
   public class_zb() {
      this.a(CreativeTab.DECORATIONS);
   }

   public class_oq a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 == EnumDirection.DOWN) {
         return class_oq.b;
      } else {
         boolean var10 = var3.getType(var4).getBlock().isReplaceable(var3, var4);
         BlockPosition var11 = var10?var4:var4.shift(var6);
         if(!var2.a(var11, var6, var1)) {
            return class_oq.b;
         } else {
            BlockPosition var12 = var11.up();
            boolean var13 = !var3.isEmpty(var11) && !var3.getType(var11).getBlock().isReplaceable(var3, var11);
            var13 |= !var3.isEmpty(var12) && !var3.getType(var12).getBlock().isReplaceable(var3, var12);
            if(var13) {
               return class_oq.b;
            } else {
               double var14 = (double)var11.getX();
               double var16 = (double)var11.getY();
               double var18 = (double)var11.getZ();
               List var20 = var3.b((Entity)null, (AxisAlignedBB)AxisAlignedBB.a(var14, var16, var18, var14 + 1.0D, var16 + 2.0D, var18 + 1.0D));
               if(!var20.isEmpty()) {
                  return class_oq.b;
               } else {
                  if(!var3.isClientSide) {
                     var3.setAir(var11);
                     var3.setAir(var12);
                     class_uy var21 = new class_uy(var3, var14 + 0.5D, var16, var18 + 0.5D);
                     float var22 = (float)MathHelper.floor((MathHelper.clampAngle(var2.y - 180.0F) + 22.5F) / 45.0F) * 45.0F;
                     var21.b(var14 + 0.5D, var16, var18 + 0.5D, var22, 0.0F);
                     this.a(var21, var3.random);
                     NBTTagCompound var23 = var1.getTag();
                     if(var23 != null && var23.hasOfType("EntityTag", 10)) {
                        NBTTagCompound var24 = new NBTTagCompound();
                        var21.d(var24);
                        var24.copyFrom(var23.getCompound("EntityTag"));
                        var21.f(var24);
                     }

                     var3.addEntity((Entity)var21);
                  }

                  --var1.count;
                  return class_oq.a;
               }
            }
         }
      }
   }

   private void a(class_uy var1, Random var2) {
      class_dc var3 = var1.u();
      float var5 = var2.nextFloat() * 5.0F;
      float var6 = var2.nextFloat() * 20.0F - 10.0F;
      class_dc var4 = new class_dc(var3.b() + var5, var3.c() + var6, var3.d());
      var1.a(var4);
      var3 = var1.v();
      var5 = var2.nextFloat() * 10.0F - 5.0F;
      var4 = new class_dc(var3.b(), var3.c() + var5, var3.d());
      var1.b(var4);
   }
}
