package net.minecraft.server;

import net.minecraft.server.IBlockAccess;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;

public class class_ajz extends Block {
   public class_ajz(Material var1, MaterialMapColor var2) {
      super(var1, var2);
   }

   public boolean isPowerSource() {
      return true;
   }

   public int a(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return 15;
   }
}
