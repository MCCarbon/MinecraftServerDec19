package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_act;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahm;
import net.minecraft.server.class_aic;
import net.minecraft.server.class_zy;

public class class_acl {
   public void a(class_act var1) {
      int var2;
      for(var2 = 0; var2 < 16; ++var2) {
         var1.b(new class_aas(Blocks.WOOL, 1, var2), new Object[]{new class_aas(Items.aY, 1, 15 - var2), new class_aas(Item.getByBlock(Blocks.WOOL))});
         var1.a(new class_aas(Blocks.STAINED_HARDENED_CLAY, 8, 15 - var2), new Object[]{"###", "#X#", "###", Character.valueOf('#'), new class_aas(Blocks.HARDENED_CLAY), Character.valueOf('X'), new class_aas(Items.aY, 1, var2)});
         var1.a(new class_aas(Blocks.STAINED_GLASS, 8, 15 - var2), new Object[]{"###", "#X#", "###", Character.valueOf('#'), new class_aas(Blocks.GLASS), Character.valueOf('X'), new class_aas(Items.aY, 1, var2)});
         var1.a(new class_aas(Blocks.STAINED_GLASS_PANE, 16, var2), new Object[]{"###", "###", Character.valueOf('#'), new class_aas(Blocks.STAINED_GLASS, 1, var2)});
      }

      var1.b(new class_aas(Items.aY, 1, class_zy.e.b()), new Object[]{new class_aas(Blocks.YELLOW_FLOWER, 1, class_aic.class_a_in_class_aic.a.b())});
      var1.b(new class_aas(Items.aY, 1, class_zy.o.b()), new Object[]{new class_aas(Blocks.RED_FLOWER, 1, class_aic.class_a_in_class_aic.b.b())});
      var1.b(new class_aas(Items.aY, 3, class_zy.a.b()), new Object[]{Items.aZ});
      var1.b(new class_aas(Items.aY, 2, class_zy.g.b()), new Object[]{new class_aas(Items.aY, 1, class_zy.o.b()), new class_aas(Items.aY, 1, class_zy.a.b())});
      var1.b(new class_aas(Items.aY, 2, class_zy.b.b()), new Object[]{new class_aas(Items.aY, 1, class_zy.o.b()), new class_aas(Items.aY, 1, class_zy.e.b())});
      var1.b(new class_aas(Items.aY, 2, class_zy.f.b()), new Object[]{new class_aas(Items.aY, 1, class_zy.n.b()), new class_aas(Items.aY, 1, class_zy.a.b())});
      var1.b(new class_aas(Items.aY, 2, class_zy.h.b()), new Object[]{new class_aas(Items.aY, 1, class_zy.p.b()), new class_aas(Items.aY, 1, class_zy.a.b())});
      var1.b(new class_aas(Items.aY, 2, class_zy.i.b()), new Object[]{new class_aas(Items.aY, 1, class_zy.h.b()), new class_aas(Items.aY, 1, class_zy.a.b())});
      var1.b(new class_aas(Items.aY, 3, class_zy.i.b()), new Object[]{new class_aas(Items.aY, 1, class_zy.p.b()), new class_aas(Items.aY, 1, class_zy.a.b()), new class_aas(Items.aY, 1, class_zy.a.b())});
      var1.b(new class_aas(Items.aY, 2, class_zy.d.b()), new Object[]{new class_aas(Items.aY, 1, class_zy.l.b()), new class_aas(Items.aY, 1, class_zy.a.b())});
      var1.b(new class_aas(Items.aY, 2, class_zy.j.b()), new Object[]{new class_aas(Items.aY, 1, class_zy.l.b()), new class_aas(Items.aY, 1, class_zy.n.b())});
      var1.b(new class_aas(Items.aY, 2, class_zy.k.b()), new Object[]{new class_aas(Items.aY, 1, class_zy.l.b()), new class_aas(Items.aY, 1, class_zy.o.b())});
      var1.b(new class_aas(Items.aY, 2, class_zy.c.b()), new Object[]{new class_aas(Items.aY, 1, class_zy.k.b()), new class_aas(Items.aY, 1, class_zy.g.b())});
      var1.b(new class_aas(Items.aY, 3, class_zy.c.b()), new Object[]{new class_aas(Items.aY, 1, class_zy.l.b()), new class_aas(Items.aY, 1, class_zy.o.b()), new class_aas(Items.aY, 1, class_zy.g.b())});
      var1.b(new class_aas(Items.aY, 4, class_zy.c.b()), new Object[]{new class_aas(Items.aY, 1, class_zy.l.b()), new class_aas(Items.aY, 1, class_zy.o.b()), new class_aas(Items.aY, 1, class_zy.o.b()), new class_aas(Items.aY, 1, class_zy.a.b())});
      var1.b(new class_aas(Items.aY, 1, class_zy.d.b()), new Object[]{new class_aas(Blocks.RED_FLOWER, 1, class_aic.class_a_in_class_aic.c.b())});
      var1.b(new class_aas(Items.aY, 1, class_zy.c.b()), new Object[]{new class_aas(Blocks.RED_FLOWER, 1, class_aic.class_a_in_class_aic.d.b())});
      var1.b(new class_aas(Items.aY, 1, class_zy.i.b()), new Object[]{new class_aas(Blocks.RED_FLOWER, 1, class_aic.class_a_in_class_aic.e.b())});
      var1.b(new class_aas(Items.aY, 1, class_zy.o.b()), new Object[]{new class_aas(Blocks.RED_FLOWER, 1, class_aic.class_a_in_class_aic.f.b())});
      var1.b(new class_aas(Items.aY, 1, class_zy.b.b()), new Object[]{new class_aas(Blocks.RED_FLOWER, 1, class_aic.class_a_in_class_aic.g.b())});
      var1.b(new class_aas(Items.aY, 1, class_zy.i.b()), new Object[]{new class_aas(Blocks.RED_FLOWER, 1, class_aic.class_a_in_class_aic.h.b())});
      var1.b(new class_aas(Items.aY, 1, class_zy.g.b()), new Object[]{new class_aas(Blocks.RED_FLOWER, 1, class_aic.class_a_in_class_aic.i.b())});
      var1.b(new class_aas(Items.aY, 1, class_zy.i.b()), new Object[]{new class_aas(Blocks.RED_FLOWER, 1, class_aic.class_a_in_class_aic.j.b())});
      var1.b(new class_aas(Items.aY, 2, class_zy.e.b()), new Object[]{new class_aas(Blocks.DOUBLE_PLANT, 1, class_ahm.class_b_in_class_ahm.a.a())});
      var1.b(new class_aas(Items.aY, 2, class_zy.c.b()), new Object[]{new class_aas(Blocks.DOUBLE_PLANT, 1, class_ahm.class_b_in_class_ahm.b.a())});
      var1.b(new class_aas(Items.aY, 2, class_zy.o.b()), new Object[]{new class_aas(Blocks.DOUBLE_PLANT, 1, class_ahm.class_b_in_class_ahm.e.a())});
      var1.b(new class_aas(Items.aY, 2, class_zy.g.b()), new Object[]{new class_aas(Blocks.DOUBLE_PLANT, 1, class_ahm.class_b_in_class_ahm.f.a())});
      var1.b(new class_aas(Items.aY, 1, class_zy.o.b()), new Object[]{new class_aas(Items.cL, 1)});

      for(var2 = 0; var2 < 16; ++var2) {
         var1.a(new class_aas(Blocks.CARPET, 3, var2), new Object[]{"##", Character.valueOf('#'), new class_aas(Blocks.WOOL, 1, var2)});
      }

   }
}
