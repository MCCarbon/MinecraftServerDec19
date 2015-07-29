package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_nu;
import net.minecraft.server.CreativeTab;

public class class_aij extends Block {
   public class_aij(Material var1) {
      super(var1);
      this.a(CreativeTab.b);
   }

   public int a(int var1, Random var2) {
      return class_nu.a(this.a(var2) + var2.nextInt(var1 + 1), 1, 4);
   }

   public int a(Random var1) {
      return 2 + var1.nextInt(3);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.aV;
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.d;
   }
}
