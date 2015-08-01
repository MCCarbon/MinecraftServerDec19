package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.BlockHalfTransparent;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.Entity;
import net.minecraft.server.CreativeTab;

public class class_akw extends BlockHalfTransparent {
   public class_akw() {
      super(Material.CLAY, false, MaterialMapColor.COLOR2);
      this.setCreativeTab(CreativeTab.DECORATIONS);
      this.frictionFactor = 0.8F;
   }

   public void fallOn(World var1, BlockPosition var2, Entity var3, float var4) {
      if(var3.ax()) {
         super.fallOn(var1, var2, var3, var4);
      } else {
         var3.e(var4, 0.0F);
      }

   }

   public void landOn(World var1, Entity var2) {
      if(var2.ax()) {
         super.landOn(var1, var2);
      } else if(var2.motY < 0.0D) {
         var2.motY = -var2.motY;
      }

   }

   public void onCollide(World var1, BlockPosition var2, Entity var3) {
      if(Math.abs(var3.motY) < 0.1D && !var3.ax()) {
         double var4 = 0.4D + Math.abs(var3.motY) * 0.2D;
         var3.v *= var4;
         var3.x *= var4;
      }

      super.onCollide(var1, var2, var3);
   }
}
