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
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ali;
import net.minecraft.server.class_zy;

public class class_aco {
   private static final class_aco a = new class_aco();
   private Map b = Maps.newHashMap();
   private Map c = Maps.newHashMap();

   public static class_aco a() {
      return a;
   }

   private class_aco() {
      this.a(Blocks.IRON_ORE, new ItemStack(Items.l), 0.7F);
      this.a(Blocks.GOLD_ORE, new ItemStack(Items.m), 1.0F);
      this.a(Blocks.DIAMOND_ORE, new ItemStack(Items.k), 1.0F);
      this.a((Block)Blocks.SAND, new ItemStack(Blocks.GLASS), 0.1F);
      this.a(Items.an, new ItemStack(Items.ao), 0.35F);
      this.a(Items.bk, new ItemStack(Items.bl), 0.35F);
      this.a(Items.bm, new ItemStack(Items.bn), 0.35F);
      this.a(Items.bq, new ItemStack(Items.br), 0.35F);
      this.a(Items.bo, new ItemStack(Items.bp), 0.35F);
      this.a(Blocks.COBBLESTONE, new ItemStack(Blocks.STONE), 0.1F);
      this.a(new ItemStack(Blocks.STONEBRICK, 1, class_ali.b), new ItemStack(Blocks.STONEBRICK, 1, class_ali.O), 0.1F);
      this.a(Items.aK, new ItemStack(Items.aJ), 0.3F);
      this.a(Blocks.CLAY, new ItemStack(Blocks.HARDENED_CLAY), 0.35F);
      this.a((Block)Blocks.CACTUS, new ItemStack(Items.aY, 1, class_zy.n.b()), 0.2F);
      this.a(Blocks.LOG, new ItemStack(Items.j, 1, 1), 0.15F);
      this.a(Blocks.LOG2, new ItemStack(Items.j, 1, 1), 0.15F);
      this.a(Blocks.EMERALD_ORE, new ItemStack(Items.bR), 1.0F);
      this.a(Items.bV, new ItemStack(Items.bW), 0.35F);
      this.a(Blocks.NETHERRACK, new ItemStack(Items.ci), 0.1F);
      this.a(new ItemStack(Blocks.SPONGE, 1, 1), new ItemStack(Blocks.SPONGE, 1, 0), 0.15F);
      this.a(Items.cI, new ItemStack(Items.cJ), 0.1F);
      class_aak.class_a_in_class_aak[] var1 = class_aak.class_a_in_class_aak.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         class_aak.class_a_in_class_aak var4 = var1[var3];
         if(var4.g()) {
            this.a(new ItemStack(Items.aW, 1, var4.a()), new ItemStack(Items.aX, 1, var4.a()), 0.35F);
         }
      }

      this.a(Blocks.COAL_ORE, new ItemStack(Items.j), 0.1F);
      this.a(Blocks.REDSTONE_ORE, new ItemStack(Items.aE), 0.7F);
      this.a(Blocks.LAPIS_ORE, new ItemStack(Items.aY, 1, class_zy.l.b()), 0.2F);
      this.a(Blocks.QUARTZ_ORE, new ItemStack(Items.cj), 0.2F);
   }

   public void a(Block var1, ItemStack var2, float var3) {
      this.a(Item.getByBlock(var1), var2, var3);
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
