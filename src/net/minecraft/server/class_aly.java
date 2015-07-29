package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.CreativeTab;

public class class_aly extends Block {
   public class_aly() {
      super(Material.G);
      this.a(CreativeTab.c);
   }

   public void a(World var1, class_cj var2, IBlockData var3, class_pr var4) {
      var4.aC();
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      return null;
   }

   public boolean isFullCube() {
      return false;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.H;
   }

   protected boolean K() {
      return true;
   }
}
