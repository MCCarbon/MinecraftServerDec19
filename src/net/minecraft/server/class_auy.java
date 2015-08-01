package net.minecraft.server;

import net.minecraft.server.IBlockAccess;
import net.minecraft.server.Block;
import net.minecraft.server.Material;
import net.minecraft.server.class_aut;
import net.minecraft.server.class_auu;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.MathHelper;
import net.minecraft.server.Entity;

public class class_auy extends class_auu {
   public void a(IBlockAccess var1, Entity var2) {
      super.a(var1, var2);
   }

   public void a() {
      super.a();
   }

   public class_aut a(Entity var1) {
      return this.a(MathHelper.floor(var1.aT().xMin), MathHelper.floor(var1.aT().yMin + 0.5D), MathHelper.floor(var1.aT().zMin));
   }

   public class_aut a(Entity var1, double var2, double var4, double var6) {
      return this.a(MathHelper.floor(var2 - (double)(var1.J / 2.0F)), MathHelper.floor(var4 + 0.5D), MathHelper.floor(var6 - (double)(var1.J / 2.0F)));
   }

   public int a(class_aut[] var1, Entity var2, class_aut var3, class_aut var4, float var5) {
      int var6 = 0;
      EnumDirection[] var7 = EnumDirection.values();
      int var8 = var7.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         EnumDirection var10 = var7[var9];
         class_aut var11 = this.a(var2, var3.a + var10.getAdjacentX(), var3.b + var10.getAdjacentY(), var3.c + var10.getAdjacentZ());
         if(var11 != null && !var11.i && var11.a(var4) < var5) {
            var1[var6++] = var11;
         }
      }

      return var6;
   }

   private class_aut a(Entity var1, int var2, int var3, int var4) {
      int var5 = this.b(var1, var2, var3, var4);
      return var5 == -1?this.a(var2, var3, var4):null;
   }

   private int b(Entity var1, int var2, int var3, int var4) {
      BlockPosition.MutableBlockPosition var5 = new BlockPosition.MutableBlockPosition();

      for(int var6 = var2; var6 < var2 + this.c; ++var6) {
         for(int var7 = var3; var7 < var3 + this.d; ++var7) {
            for(int var8 = var4; var8 < var4 + this.e; ++var8) {
               Block var9 = this.a.getType(var5.setPosition(var6, var7, var8)).getBlock();
               if(var9.getMaterial() != Material.WATER) {
                  return 0;
               }
            }
         }
      }

      return -1;
   }
}
