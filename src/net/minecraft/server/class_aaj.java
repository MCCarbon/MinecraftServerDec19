package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xg;

public class class_aaj extends Item {
   public class_oq a(class_aas var1, class_xa var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(!var3.D) {
         class_xg var10 = new class_xg(var3, (double)((float)var4.getX() + var7), (double)((float)var4.getY() + var8), (double)((float)var4.getZ() + var9), var1);
         var3.a((class_pr)var10);
         if(!var2.bH.d) {
            --var1.b;
         }

         return class_oq.a;
      } else {
         return class_oq.b;
      }
   }
}
