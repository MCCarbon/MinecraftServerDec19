package net.minecraft.server;

import net.minecraft.server.class_aan;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;

public class class_abj extends class_aan {
   private Block b;
   private Block c;

   public class_abj(int var1, float var2, Block var3, Block var4) {
      super(var1, var2, false);
      this.b = var3;
      this.c = var4;
   }

   public class_oq a(class_aas var1, class_xa var2, World var3, BlockPosition var4, class_oo var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 != EnumDirection.UP) {
         return class_oq.b;
      } else if(!var2.a(var4.shift(var6), var6, var1)) {
         return class_oq.b;
      } else if(var3.p(var4).getBlock() == this.c && var3.d(var4.shiftUp())) {
         var3.a(var4.shiftUp(), this.b.getBlockData());
         --var1.b;
         return class_oq.a;
      } else {
         return class_oq.b;
      }
   }
}
