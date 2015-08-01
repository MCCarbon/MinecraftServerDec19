package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_act;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahm;
import net.minecraft.server.BlockFlowers;
import net.minecraft.server.EnumColor;

public class class_acl {
   public void a(class_act var1) {
      int var2;
      for(var2 = 0; var2 < 16; ++var2) {
         var1.b(new ItemStack(Blocks.WOOL, 1, var2), new Object[]{new ItemStack(Items.aY, 1, 15 - var2), new ItemStack(Item.getItemOf(Blocks.WOOL))});
         var1.a(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 8, 15 - var2), new Object[]{"###", "#X#", "###", Character.valueOf('#'), new ItemStack(Blocks.HARDENED_CLAY), Character.valueOf('X'), new ItemStack(Items.aY, 1, var2)});
         var1.a(new ItemStack(Blocks.STAINED_GLASS, 8, 15 - var2), new Object[]{"###", "#X#", "###", Character.valueOf('#'), new ItemStack(Blocks.GLASS), Character.valueOf('X'), new ItemStack(Items.aY, 1, var2)});
         var1.a(new ItemStack(Blocks.STAINED_GLASS_PANE, 16, var2), new Object[]{"###", "###", Character.valueOf('#'), new ItemStack(Blocks.STAINED_GLASS, 1, var2)});
      }

      var1.b(new ItemStack(Items.aY, 1, EnumColor.e.b()), new Object[]{new ItemStack(Blocks.YELLOW_FLOWER, 1, BlockFlowers.EnumFlowerVarient.DANDELION.getId())});
      var1.b(new ItemStack(Items.aY, 1, EnumColor.o.b()), new Object[]{new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.POPPY.getId())});
      var1.b(new ItemStack(Items.aY, 3, EnumColor.a.b()), new Object[]{Items.aZ});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.g.b()), new Object[]{new ItemStack(Items.aY, 1, EnumColor.o.b()), new ItemStack(Items.aY, 1, EnumColor.a.b())});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.b.b()), new Object[]{new ItemStack(Items.aY, 1, EnumColor.o.b()), new ItemStack(Items.aY, 1, EnumColor.e.b())});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.f.b()), new Object[]{new ItemStack(Items.aY, 1, EnumColor.n.b()), new ItemStack(Items.aY, 1, EnumColor.a.b())});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.h.b()), new Object[]{new ItemStack(Items.aY, 1, EnumColor.p.b()), new ItemStack(Items.aY, 1, EnumColor.a.b())});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.i.b()), new Object[]{new ItemStack(Items.aY, 1, EnumColor.h.b()), new ItemStack(Items.aY, 1, EnumColor.a.b())});
      var1.b(new ItemStack(Items.aY, 3, EnumColor.i.b()), new Object[]{new ItemStack(Items.aY, 1, EnumColor.p.b()), new ItemStack(Items.aY, 1, EnumColor.a.b()), new ItemStack(Items.aY, 1, EnumColor.a.b())});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.d.b()), new Object[]{new ItemStack(Items.aY, 1, EnumColor.l.b()), new ItemStack(Items.aY, 1, EnumColor.a.b())});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.j.b()), new Object[]{new ItemStack(Items.aY, 1, EnumColor.l.b()), new ItemStack(Items.aY, 1, EnumColor.n.b())});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.k.b()), new Object[]{new ItemStack(Items.aY, 1, EnumColor.l.b()), new ItemStack(Items.aY, 1, EnumColor.o.b())});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.c.b()), new Object[]{new ItemStack(Items.aY, 1, EnumColor.k.b()), new ItemStack(Items.aY, 1, EnumColor.g.b())});
      var1.b(new ItemStack(Items.aY, 3, EnumColor.c.b()), new Object[]{new ItemStack(Items.aY, 1, EnumColor.l.b()), new ItemStack(Items.aY, 1, EnumColor.o.b()), new ItemStack(Items.aY, 1, EnumColor.g.b())});
      var1.b(new ItemStack(Items.aY, 4, EnumColor.c.b()), new Object[]{new ItemStack(Items.aY, 1, EnumColor.l.b()), new ItemStack(Items.aY, 1, EnumColor.o.b()), new ItemStack(Items.aY, 1, EnumColor.o.b()), new ItemStack(Items.aY, 1, EnumColor.a.b())});
      var1.b(new ItemStack(Items.aY, 1, EnumColor.d.b()), new Object[]{new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.BLUE_ORCHID.getId())});
      var1.b(new ItemStack(Items.aY, 1, EnumColor.c.b()), new Object[]{new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.ALLIUM.getId())});
      var1.b(new ItemStack(Items.aY, 1, EnumColor.i.b()), new Object[]{new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.HOUSTONIA.getId())});
      var1.b(new ItemStack(Items.aY, 1, EnumColor.o.b()), new Object[]{new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.RED_TULIP.getId())});
      var1.b(new ItemStack(Items.aY, 1, EnumColor.b.b()), new Object[]{new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.ORANGE_TULIP.getId())});
      var1.b(new ItemStack(Items.aY, 1, EnumColor.i.b()), new Object[]{new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.WHITE_TULIP.getId())});
      var1.b(new ItemStack(Items.aY, 1, EnumColor.g.b()), new Object[]{new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.PINK_TULIP.getId())});
      var1.b(new ItemStack(Items.aY, 1, EnumColor.i.b()), new Object[]{new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.OXEYE_DAISY.getId())});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.e.b()), new Object[]{new ItemStack(Blocks.DOUBLE_PLANT, 1, class_ahm.class_b_in_class_ahm.a.a())});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.c.b()), new Object[]{new ItemStack(Blocks.DOUBLE_PLANT, 1, class_ahm.class_b_in_class_ahm.b.a())});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.o.b()), new Object[]{new ItemStack(Blocks.DOUBLE_PLANT, 1, class_ahm.class_b_in_class_ahm.e.a())});
      var1.b(new ItemStack(Items.aY, 2, EnumColor.g.b()), new Object[]{new ItemStack(Blocks.DOUBLE_PLANT, 1, class_ahm.class_b_in_class_ahm.f.a())});
      var1.b(new ItemStack(Items.aY, 1, EnumColor.o.b()), new Object[]{new ItemStack(Items.cL, 1)});

      for(var2 = 0; var2 < 16; ++var2) {
         var1.a(new ItemStack(Blocks.CARPET, 3, var2), new Object[]{"##", Character.valueOf('#'), new ItemStack(Blocks.WOOL, 1, var2)});
      }

   }
}
