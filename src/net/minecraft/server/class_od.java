package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.TileEntityDispenser;
import net.minecraft.server.class_oc;
import net.minecraft.server.IInventory;

public class class_od extends class_oc.WeightedRandomChoice {
   private ItemStack b;
   private int c;
   private int d;

   public class_od(Item var1, int var2, int var3, int var4, int var5) {
      super(var5);
      this.b = new ItemStack(var1, 1, var2);
      this.c = var3;
      this.d = var4;
   }

   public class_od(ItemStack var1, int var2, int var3, int var4) {
      super(var4);
      this.b = var1;
      this.c = var2;
      this.d = var3;
   }

   public static void a(Random var0, List var1, IInventory var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         class_od var5 = (class_od)class_oc.a(var0, var1);
         int var6 = var5.c + var0.nextInt(var5.d - var5.c + 1);
         if(var5.b.c() >= var6) {
            ItemStack var9 = var5.b.clone();
            var9.count = var6;
            var2.setItem(var0.nextInt(var2.getSize()), var9);
         } else {
            for(int var7 = 0; var7 < var6; ++var7) {
               ItemStack var8 = var5.b.clone();
               var8.count = 1;
               var2.setItem(var0.nextInt(var2.getSize()), var8);
            }
         }
      }

   }

   public static void a(Random var0, List var1, TileEntityDispenser var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         class_od var5 = (class_od)class_oc.a(var0, var1);
         int var6 = var5.c + var0.nextInt(var5.d - var5.c + 1);
         if(var5.b.c() >= var6) {
            ItemStack var9 = var5.b.clone();
            var9.count = var6;
            var2.setItem(var0.nextInt(var2.getSize()), var9);
         } else {
            for(int var7 = 0; var7 < var6; ++var7) {
               ItemStack var8 = var5.b.clone();
               var8.count = 1;
               var2.setItem(var0.nextInt(var2.getSize()), var8);
            }
         }
      }

   }

   public static List a(List var0, class_od... var1) {
      ArrayList var2 = Lists.newArrayList((Iterable)var0);
      Collections.addAll(var2, var1);
      return var2;
   }
}
