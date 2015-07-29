package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.CreativeTab;

public class class_agm extends Block {
   public class_agm() {
      super(Material.d);
      this.a(CreativeTab.b);
   }

   public int a(Random var1) {
      return 3;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.aN;
   }
}
