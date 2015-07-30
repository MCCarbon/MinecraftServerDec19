package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahw;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;

public abstract class class_agd extends Block implements class_ahw {
   protected class_agd(Material var1) {
      this(var1, var1.getMapColor());
   }

   protected class_agd(Material var1, MaterialMapColor var2) {
      super(var1, var2);
      this.isTileEntity = true;
   }

   protected boolean a(World var1, BlockPosition var2, EnumDirection var3) {
      return var1.p(var2.shift(var3)).getBlock().getMaterial() == Material.CACTUS;
   }

   protected boolean e(World var1, BlockPosition var2) {
      return this.a(var1, var2, EnumDirection.NORTH) || this.a(var1, var2, EnumDirection.SOUTH) || this.a(var1, var2, EnumDirection.WEST) || this.a(var1, var2, EnumDirection.EAST);
   }

   public int getRenderType() {
      return -1;
   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      super.b(var1, var2, var3);
      var1.t(var2);
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, int var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      class_amg var6 = var1.s(var2);
      return var6 == null?false:var6.c(var4, var5);
   }
}
