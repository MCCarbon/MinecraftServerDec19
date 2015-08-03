package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.Material;
import net.minecraft.server.class_zv;

public class class_zd extends class_zv {
   private static final Set c;

   protected class_zd(Item.class_a_in_class_aar var1) {
      super(3.0F, var1, c);
   }

   public float a(ItemStack var1, Block var2) {
      return var2.getMaterial() != Material.WOOD && var2.getMaterial() != Material.PLANT && var2.getMaterial() != Material.REPLACEABLE_PLANT?super.a(var1, var2):this.a;
   }

   static {
      c = Sets.newHashSet((Object[])(new Block[]{BlockStainedGlassPane.PLANKS, BlockStainedGlassPane.BOOKSHELF, BlockStainedGlassPane.LOG, BlockStainedGlassPane.LOG2, BlockStainedGlassPane.CHEST, BlockStainedGlassPane.PUMPKIN, BlockStainedGlassPane.LIT_PUMPKIN, BlockStainedGlassPane.MELON_BLOCK, BlockStainedGlassPane.LADDER}));
   }
}
