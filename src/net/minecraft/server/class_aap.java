package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_uz;
import net.minecraft.server.class_va;
import net.minecraft.server.class_vc;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_aap extends Item {
   private final Class a;

   public class_aap(Class var1) {
      this.a = var1;
      this.a(CreativeTab.c);
   }

   public class_oq a(ItemStack var1, class_xa var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 == EnumDirection.DOWN) {
         return class_oq.b;
      } else if(var6 == EnumDirection.UP) {
         return class_oq.b;
      } else {
         BlockPosition var10 = var4.shift(var6);
         if(!var2.a(var10, var6, var1)) {
            return class_oq.b;
         } else {
            class_uz var11 = this.a(var3, var10, var6);
            if(var11 != null && var11.j()) {
               if(!var3.D) {
                  var3.a((class_pr)var11);
               }

               --var1.count;
            }

            return class_oq.a;
         }
      }
   }

   private class_uz a(World var1, BlockPosition var2, EnumDirection var3) {
      return (class_uz)(this.a == class_vc.class?new class_vc(var1, var2, var3):(this.a == class_va.class?new class_va(var1, var2, var3):null));
   }
}
