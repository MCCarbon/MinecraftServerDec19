package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.server.class_aak;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.class_ali;
import net.minecraft.server.EnumColor;

public class class_aco {
   private static final class_aco a = new class_aco();
   private Map b = Maps.newHashMap();
   private Map c = Maps.newHashMap();

   public static class_aco a() {
      return a;
   }

   private class_aco() {
      this.a(BlockStainedGlassPane.IRON_ORE, new ItemStack(Items.IRON_INGOT), 0.7F);
      this.a(BlockStainedGlassPane.GOLD_ORE, new ItemStack(Items.GOLD_INGOT), 1.0F);
      this.a(BlockStainedGlassPane.DIAMOND_ORE, new ItemStack(Items.DIAMOND), 1.0F);
      this.a((Block)BlockStainedGlassPane.SAND, new ItemStack(BlockStainedGlassPane.GLASS), 0.1F);
      this.a(Items.an, new ItemStack(Items.ao), 0.35F);
      this.a(Items.bk, new ItemStack(Items.bl), 0.35F);
      this.a(Items.bm, new ItemStack(Items.bn), 0.35F);
      this.a(Items.bq, new ItemStack(Items.br), 0.35F);
      this.a(Items.bo, new ItemStack(Items.bp), 0.35F);
      this.a(BlockStainedGlassPane.COBBLESTONE, new ItemStack(BlockStainedGlassPane.STONE), 0.1F);
      this.a(new ItemStack(BlockStainedGlassPane.STONEBRICK, 1, class_ali.b), new ItemStack(BlockStainedGlassPane.STONEBRICK, 1, class_ali.O), 0.1F);
      this.a(Items.aK, new ItemStack(Items.aJ), 0.3F);
      this.a(BlockStainedGlassPane.CLAY, new ItemStack(BlockStainedGlassPane.HARDENED_CLAY), 0.35F);
      this.a((Block)BlockStainedGlassPane.CACTUS, new ItemStack(Items.aY, 1, EnumColor.n.b()), 0.2F);
      this.a(BlockStainedGlassPane.LOG, new ItemStack(Items.COAL, 1, 1), 0.15F);
      this.a(BlockStainedGlassPane.LOG2, new ItemStack(Items.COAL, 1, 1), 0.15F);
      this.a(BlockStainedGlassPane.EMERALD_ORE, new ItemStack(Items.bR), 1.0F);
      this.a(Items.bV, new ItemStack(Items.bW), 0.35F);
      this.a(BlockStainedGlassPane.NETHERRACK, new ItemStack(Items.ci), 0.1F);
      this.a(new ItemStack(BlockStainedGlassPane.SPONGE, 1, 1), new ItemStack(BlockStainedGlassPane.SPONGE, 1, 0), 0.15F);
      this.a(Items.cI, new ItemStack(Items.cJ), 0.1F);
      class_aak.class_a_in_class_aak[] var1 = class_aak.class_a_in_class_aak.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         class_aak.class_a_in_class_aak var4 = var1[var3];
         if(var4.g()) {
            this.a(new ItemStack(Items.aW, 1, var4.a()), new ItemStack(Items.aX, 1, var4.a()), 0.35F);
         }
      }

      this.a(BlockStainedGlassPane.COAL_ORE, new ItemStack(Items.COAL), 0.1F);
      this.a(BlockStainedGlassPane.REDSTONE_ORE, new ItemStack(Items.aE), 0.7F);
      this.a(BlockStainedGlassPane.LAPIS_ORE, new ItemStack(Items.aY, 1, EnumColor.l.b()), 0.2F);
      this.a(BlockStainedGlassPane.QUARTZ_ORE, new ItemStack(Items.cj), 0.2F);
   }

   public void a(Block var1, ItemStack var2, float var3) {
      this.a(Item.getItemOf(var1), var2, var3);
   }

   public void a(Item var1, ItemStack var2, float var3) {
      this.a(new ItemStack(var1, 1, 32767), var2, var3);
   }

   public void a(ItemStack var1, ItemStack var2, float var3) {
      this.b.put(var1, var2);
      this.c.put(var2, Float.valueOf(var3));
   }

   public ItemStack a(ItemStack var1) {
      Iterator var2 = this.b.entrySet().iterator();

      Entry var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (Entry)var2.next();
      } while(!this.a(var1, (ItemStack)var3.getKey()));

      return (ItemStack)var3.getValue();
   }

   private boolean a(ItemStack var1, ItemStack var2) {
      return var2.getItem() == var1.getItem() && (var2.i() == 32767 || var2.i() == var1.i());
   }

   public Map b() {
      return this.b;
   }

   public float b(ItemStack var1) {
      Iterator var2 = this.c.entrySet().iterator();

      Entry var3;
      do {
         if(!var2.hasNext()) {
            return 0.0F;
         }

         var3 = (Entry)var2.next();
      } while(!this.a(var1, (ItemStack)var3.getKey()));

      return ((Float)var3.getValue()).floatValue();
   }
}
