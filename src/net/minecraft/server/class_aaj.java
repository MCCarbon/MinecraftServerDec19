package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_xg;

public class class_aaj extends Item {
   public class_oq a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(!var3.isClientSide) {
         class_xg var10 = new class_xg(var3, (double)((float)var4.getX() + var7), (double)((float)var4.getY() + var8), (double)((float)var4.getZ() + var9), var1);
         var3.addEntity((Entity)var10);
         if(!var2.abilities.instabuild) {
            --var1.count;
         }

         return class_oq.a;
      } else {
         return class_oq.b;
      }
   }
}
