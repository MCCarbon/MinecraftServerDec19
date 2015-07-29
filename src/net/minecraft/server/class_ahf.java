package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_xa;

public class class_ahf extends class_ago {
   protected class_ahf() {
      super(Material.l);
      float var1 = 0.4F;
      this.setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.o;
   }

   protected boolean c(Block var1) {
      return var1 == Blocks.SAND || var1 == Blocks.HARDENED_CLAY || var1 == Blocks.STAINED_HARDENED_CLAY || var1 == Blocks.DIRT;
   }

   public boolean isReplaceable(World var1, class_cj var2) {
      return true;
   }

   public int a(Random var1) {
      return var1.nextInt(3);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.A;
   }

   public void a(World var1, class_xa var2, class_cj var3, IBlockData var4, class_amg var5, class_aas var6) {
      if(!var1.D && var6 != null && var6.b() == Items.bg) {
         var2.b(class_nc.ab[Block.getId((Block)this)]);
         a(var1, var3, new class_aas(Blocks.DEADBUSH, 1, 0));
      } else {
         super.a(var1, var2, var3, var4, var5, var6);
      }

   }
}
