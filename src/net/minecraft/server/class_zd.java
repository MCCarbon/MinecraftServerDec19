package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.Material;
import net.minecraft.server.class_zv;

public class class_zd extends class_zv {
   private static final Set c;

   protected class_zd(Item.class_a_in_class_aar var1) {
      super(3.0F, var1, c);
   }

   public float a(class_aas var1, Block var2) {
      return var2.getMaterial() != Material.d && var2.getMaterial() != Material.k && var2.getMaterial() != Material.l?super.a(var1, var2):this.a;
   }

   static {
      c = Sets.newHashSet((Object[])(new Block[]{Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER}));
   }
}
