package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;

public class class_zd extends class_zv {
   private static final Set c;

   protected class_zd(EnumToolMaterial var1) {
      super(3.0F, var1, c);
   }

   public float registerItemKey(ItemStack var1, Block var2) {
      return var2.getMaterial() != Material.WOOD && var2.getMaterial() != Material.PLANT && var2.getMaterial() != Material.REPLACEABLE_PLANT?super.registerItemKey(var1, var2):this.a;
   }

   static {
      c = Sets.newHashSet((Object[])(new Block[]{Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER}));
   }
}
