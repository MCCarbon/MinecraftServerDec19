package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_acv;
import net.minecraft.server.World;
import net.minecraft.server.class_avf;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_yg;

public class class_acq extends class_acv {
   public class_acq() {
      super(3, 3, new ItemStack[]{new ItemStack(Items.aM), new ItemStack(Items.aM), new ItemStack(Items.aM), new ItemStack(Items.aM), new ItemStack(Items.bf, 0, 32767), new ItemStack(Items.aM), new ItemStack(Items.aM), new ItemStack(Items.aM), new ItemStack(Items.aM)}, new ItemStack(Items.bY, 0, 0));
   }

   public boolean a(class_yg var1, World var2) {
      if(!super.a(var1, var2)) {
         return false;
      } else {
         ItemStack var3 = null;

         for(int var4 = 0; var4 < var1.getSize() && var3 == null; ++var4) {
            ItemStack var5 = var1.getItem(var4);
            if(var5 != null && var5.getItem() == Items.bf) {
               var3 = var5;
            }
         }

         if(var3 == null) {
            return false;
         } else {
            class_avf var6 = Items.bf.a(var3, var2);
            return var6 == null?false:var6.e < 4;
         }
      }
   }

   public ItemStack a(class_yg var1) {
      ItemStack var2 = null;

      for(int var3 = 0; var3 < var1.getSize() && var2 == null; ++var3) {
         ItemStack var4 = var1.getItem(var3);
         if(var4 != null && var4.getItem() == Items.bf) {
            var2 = var4;
         }
      }

      var2 = var2.clone();
      var2.count = 1;
      if(var2.getTag() == null) {
         var2.setTag(new NBTTagCompound());
      }

      var2.getTag().put("map_is_scaling", true);
      return var2;
   }
}
