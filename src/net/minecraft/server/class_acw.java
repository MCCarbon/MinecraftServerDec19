package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_acs;
import net.minecraft.server.World;
import net.minecraft.server.class_yg;

public class class_acw implements class_acs {
   private final ItemStack a;
   private final List b;

   public class_acw(ItemStack var1, List var2) {
      this.a = var1;
      this.b = var2;
   }

   public ItemStack b() {
      return this.a;
   }

   public ItemStack[] b(class_yg var1) {
      ItemStack[] var2 = new ItemStack[var1.getSize()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         ItemStack var4 = var1.getItem(var3);
         if(var4 != null && var4.getItem().r()) {
            var2[var3] = new ItemStack(var4.getItem().q());
         }
      }

      return var2;
   }

   public boolean a(class_yg var1, World var2) {
      ArrayList var3 = Lists.newArrayList((Iterable)this.b);

      for(int var4 = 0; var4 < var1.h(); ++var4) {
         for(int var5 = 0; var5 < var1.i(); ++var5) {
            ItemStack var6 = var1.c(var5, var4);
            if(var6 != null) {
               boolean var7 = false;
               Iterator var8 = var3.iterator();

               while(var8.hasNext()) {
                  ItemStack var9 = (ItemStack)var8.next();
                  if(var6.getItem() == var9.getItem() && (var9.i() == 32767 || var6.i() == var9.i())) {
                     var7 = true;
                     var3.remove(var9);
                     break;
                  }
               }

               if(!var7) {
                  return false;
               }
            }
         }
      }

      return var3.isEmpty();
   }

   public ItemStack a(class_yg var1) {
      return this.a.clone();
   }

   public int a() {
      return this.b.size();
   }
}
