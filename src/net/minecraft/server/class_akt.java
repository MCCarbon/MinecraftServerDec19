package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.MathHelper;
import net.minecraft.server.CreativeTab;

public class class_akt extends Block {
   public class_akt(Material var1) {
      super(var1);
      this.a(CreativeTab.b);
   }

   public int a(Random var1) {
      return 2 + var1.nextInt(2);
   }

   public int a(int var1, Random var2) {
      return MathHelper.clamp(this.a(var2) + var2.nextInt(var1 + 1), 1, 5);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.cG;
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.COLOR15;
   }

   protected boolean K() {
      return true;
   }
}
