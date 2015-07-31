package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_acs;
import net.minecraft.server.World;
import net.minecraft.server.class_yg;

public class class_acu implements class_acs {
   public boolean a(class_yg var1, World var2) {
      ArrayList var3 = Lists.newArrayList();

      for(int var4 = 0; var4 < var1.o_(); ++var4) {
         ItemStack var5 = var1.a(var4);
         if(var5 != null) {
            var3.add(var5);
            if(var3.size() > 1) {
               ItemStack var6 = (ItemStack)var3.get(0);
               if(var5.getItem() != var6.getItem() || var6.count != 1 || var5.count != 1 || !var6.getItem().m()) {
                  return false;
               }
            }
         }
      }

      return var3.size() == 2;
   }

   public ItemStack a(class_yg var1) {
      ArrayList var2 = Lists.newArrayList();

      ItemStack var4;
      for(int var3 = 0; var3 < var1.o_(); ++var3) {
         var4 = var1.a(var3);
         if(var4 != null) {
            var2.add(var4);
            if(var2.size() > 1) {
               ItemStack var5 = (ItemStack)var2.get(0);
               if(var4.getItem() != var5.getItem() || var5.count != 1 || var4.count != 1 || !var5.getItem().m()) {
                  return null;
               }
            }
         }
      }

      if(var2.size() == 2) {
         ItemStack var10 = (ItemStack)var2.get(0);
         var4 = (ItemStack)var2.get(1);
         if(var10.getItem() == var4.getItem() && var10.count == 1 && var4.count == 1 && var10.getItem().m()) {
            Item var11 = var10.getItem();
            int var6 = var11.l() - var10.h();
            int var7 = var11.l() - var4.h();
            int var8 = var6 + var7 + var11.l() * 5 / 100;
            int var9 = var11.l() - var8;
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

   public ItemStack[] b(class_yg var1) {
      ItemStack[] var2 = new ItemStack[var1.o_()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         ItemStack var4 = var1.a(var3);
         if(var4 != null && var4.getItem().r()) {
            var2[var3] = new ItemStack(var4.getItem().q());
         }
      }

      return var2;
   }
}
