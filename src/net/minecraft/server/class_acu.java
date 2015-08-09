package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.IRecipe;
import net.minecraft.server.World;
import net.minecraft.server.InventoryCrafting;

public class class_acu implements IRecipe {
   public boolean a(InventoryCrafting var1, World var2) {
      ArrayList var3 = Lists.newArrayList();

      for(int var4 = 0; var4 < var1.getSize(); ++var4) {
         ItemStack var5 = var1.getItem(var4);
         if(var5 != null) {
            var3.add(var5);
            if(var3.size() > 1) {
               ItemStack var6 = (ItemStack)var3.get(0);
               if(var5.getItem() != var6.getItem() || var6.count != 1 || var5.count != 1 || !var6.getItem().usesDurability()) {
                  return false;
               }
            }
         }
      }

      return var3.size() == 2;
   }

   public ItemStack a(InventoryCrafting var1) {
      ArrayList var2 = Lists.newArrayList();

      ItemStack var4;
      for(int var3 = 0; var3 < var1.getSize(); ++var3) {
         var4 = var1.getItem(var3);
         if(var4 != null) {
            var2.add(var4);
            if(var2.size() > 1) {
               ItemStack var5 = (ItemStack)var2.get(0);
               if(var4.getItem() != var5.getItem() || var5.count != 1 || var4.count != 1 || !var5.getItem().usesDurability()) {
                  return null;
               }
            }
         }
      }

      if(var2.size() == 2) {
         ItemStack var10 = (ItemStack)var2.get(0);
         var4 = (ItemStack)var2.get(1);
         if(var10.getItem() == var4.getItem() && var10.count == 1 && var4.count == 1 && var10.getItem().usesDurability()) {
            Item var11 = var10.getItem();
            int var6 = var11.getMaxDurability() - var10.h();
            int var7 = var11.getMaxDurability() - var4.h();
            int var8 = var6 + var7 + var11.getMaxDurability() * 5 / 100;
            int var9 = var11.getMaxDurability() - var8;
            if(var9 < 0) {
               var9 = 0;
            }

            return new ItemStack(var10.getItem(), 1, var9);
         }
      }

      return null;
   }

   public int a() {
      return 4;
   }

   public ItemStack b() {
      return null;
   }

   public ItemStack[] b(InventoryCrafting var1) {
      ItemStack[] var2 = new ItemStack[var1.getSize()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         ItemStack var4 = var1.getItem(var3);
         if(var4 != null && var4.getItem().hasCraftingResult()) {
            var2[var3] = new ItemStack(var4.getItem().getCraftingResult());
         }
      }

      return var2;
   }
}
