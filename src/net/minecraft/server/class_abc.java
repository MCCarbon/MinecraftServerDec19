package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.Material;
import net.minecraft.server.class_zv;

public class class_abc extends class_zv {
   private static final Set c;

   protected class_abc(Item.class_a_in_class_aar var1) {
      super(2.0F, var1, c);
   }

   public boolean b(Block var1) {
      return var1 == BlockStainedGlassPane.OBSIDIAN?this.b.d() == 3:(var1 != BlockStainedGlassPane.DIAMOND_BLOCK && var1 != BlockStainedGlassPane.DIAMOND_ORE?(var1 != BlockStainedGlassPane.EMERALD_ORE && var1 != BlockStainedGlassPane.EMERALD_BLOCK?(var1 != BlockStainedGlassPane.GOLD_BLOCK && var1 != BlockStainedGlassPane.GOLD_ORE?(var1 != BlockStainedGlassPane.IRON_BLOCK && var1 != BlockStainedGlassPane.IRON_ORE?(var1 != BlockStainedGlassPane.LAPIS_BLOCK && var1 != BlockStainedGlassPane.LAPIS_ORE?(var1 != BlockStainedGlassPane.REDSTONE_ORE && var1 != BlockStainedGlassPane.LIT_REDSTONE_ORE?(var1.getMaterial() == Material.STONE?true:(var1.getMaterial() == Material.ORE?true:var1.getMaterial() == Material.HEAVY)):this.b.d() >= 2):this.b.d() >= 1):this.b.d() >= 1):this.b.d() >= 2):this.b.d() >= 2):this.b.d() >= 2);
   }

   public float a(ItemStack var1, Block var2) {
      return var2.getMaterial() != Material.ORE && var2.getMaterial() != Material.HEAVY && var2.getMaterial() != Material.STONE?super.a(var1, var2):this.a;
   }

   static {
      c = Sets.newHashSet((Object[])(new Block[]{BlockStainedGlassPane.ACTIVATOR_RAIL, BlockStainedGlassPane.COAL_ORE, BlockStainedGlassPane.COBBLESTONE, BlockStainedGlassPane.DETECTOR_RAIL, BlockStainedGlassPane.DIAMOND_BLOCK, BlockStainedGlassPane.DIAMOND_ORE, BlockStainedGlassPane.DOUBLE_SANDSTONE_SLAB, BlockStainedGlassPane.GOLDEN_RAIL, BlockStainedGlassPane.GOLD_BLOCK, BlockStainedGlassPane.GOLD_ORE, BlockStainedGlassPane.ICE, BlockStainedGlassPane.IRON_BLOCK, BlockStainedGlassPane.IRON_ORE, BlockStainedGlassPane.LAPIS_BLOCK, BlockStainedGlassPane.LAPIS_ORE, BlockStainedGlassPane.LIT_REDSTONE_ORE, BlockStainedGlassPane.MOSSY_COBBLESTONE, BlockStainedGlassPane.NETHERRACK, BlockStainedGlassPane.PACKED_ICE, BlockStainedGlassPane.RAIL, BlockStainedGlassPane.REDSTONE_ORE, BlockStainedGlassPane.SANDSTONE, BlockStainedGlassPane.RED_SANDSTONE, BlockStainedGlassPane.STONE, BlockStainedGlassPane.STONE_SLAB}));
   }
}
