package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zy;

public class class_aju extends Block {
   public class_aju() {
      this(Material.e.getMapColor());
   }

   public class_aju(MaterialMapColor var1) {
      super(Material.e, var1);
      this.a((CreativeTab)CreativeTab.b);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return this == Blocks.COAL_ORE?Items.j:(this == Blocks.DIAMOND_ORE?Items.k:(this == Blocks.LAPIS_ORE?Items.aY:(this == Blocks.EMERALD_ORE?Items.bR:(this == Blocks.QUARTZ_ORE?Items.cj:Item.getByBlock((Block)this)))));
   }

   public int a(Random var1) {
      return this == Blocks.LAPIS_ORE?4 + var1.nextInt(5):1;
   }

   public int a(int var1, Random var2) {
      if(var1 > 0 && Item.getByBlock((Block)this) != this.getDropType((IBlockData)this.getBlockStateList().a().iterator().next(), var2, var1)) {
         int var3 = var2.nextInt(var1 + 2) - 1;
         if(var3 < 0) {
            var3 = 0;
         }

         return this.a(var2) * (var3 + 1);
      } else {
         return this.a(var2);
      }
   }

   public void a(World var1, class_cj var2, IBlockData var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if(this.getDropType(var3, var1.s, var5) != Item.getByBlock((Block)this)) {
         int var6 = 0;
         if(this == Blocks.COAL_ORE) {
            var6 = class_nu.a((Random)var1.s, 0, 2);
         } else if(this == Blocks.DIAMOND_ORE) {
            var6 = class_nu.a((Random)var1.s, 3, 7);
         } else if(this == Blocks.EMERALD_ORE) {
            var6 = class_nu.a((Random)var1.s, 3, 7);
         } else if(this == Blocks.LAPIS_ORE) {
            var6 = class_nu.a((Random)var1.s, 2, 5);
         } else if(this == Blocks.QUARTZ_ORE) {
            var6 = class_nu.a((Random)var1.s, 2, 5);
         }

         this.b(var1, var2, var6);
      }

   }

   public int j(World var1, class_cj var2) {
      return 0;
   }

   public int getDropData(IBlockData var1) {
      return this == Blocks.LAPIS_ORE?class_zy.l.b():0;
   }
}
