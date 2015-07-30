package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aok;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;

public class class_aew implements class_aer {
   protected int a;
   protected int b;
   protected class_aok[][] c;
   protected boolean d;
   protected World e;

   public class_aew(World var1, BlockPosition var2, BlockPosition var3, int var4) {
      this.e = var1;
      this.a = var2.getX() - var4 >> 4;
      this.b = var2.getZ() - var4 >> 4;
      int var5 = var3.getX() + var4 >> 4;
      int var6 = var3.getZ() + var4 >> 4;
      this.c = new class_aok[var5 - this.a + 1][var6 - this.b + 1];
      this.d = true;

      int var7;
      int var8;
      for(var7 = this.a; var7 <= var5; ++var7) {
         for(var8 = this.b; var8 <= var6; ++var8) {
            this.c[var7 - this.a][var8 - this.b] = var1.a(var7, var8);
         }
      }

      for(var7 = var2.getX() >> 4; var7 <= var3.getX() >> 4; ++var7) {
         for(var8 = var2.getZ() >> 4; var8 <= var3.getZ() >> 4; ++var8) {
            class_aok var9 = this.c[var7 - this.a][var8 - this.b];
            if(var9 != null && !var9.c(var2.getY(), var3.getY())) {
               this.d = false;
            }
         }
      }

   }

   public class_amg s(BlockPosition var1) {
      int var2 = (var1.getX() >> 4) - this.a;
      int var3 = (var1.getZ() >> 4) - this.b;
      return this.c[var2][var3].a(var1, class_aok.class_a_in_class_aok.a);
   }

   public IBlockData p(BlockPosition var1) {
      if(var1.getY() >= 0 && var1.getY() < 256) {
         int var2 = (var1.getX() >> 4) - this.a;
         int var3 = (var1.getZ() >> 4) - this.b;
         if(var2 >= 0 && var2 < this.c.length && var3 >= 0 && var3 < this.c[var2].length) {
            class_aok var4 = this.c[var2][var3];
            if(var4 != null) {
               return var4.g(var1);
            }
         }
      }

      return Blocks.AIR.getBlockData();
   }

   public boolean d(BlockPosition var1) {
      return this.p(var1).getBlock().getMaterial() == Material.AIR;
   }

   public int a(BlockPosition var1, EnumDirection var2) {
      IBlockData var3 = this.p(var1);
      return var3.getBlock().b((class_aer)this, var1, var3, (EnumDirection)var2);
   }
}
