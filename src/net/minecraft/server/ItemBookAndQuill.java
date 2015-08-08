package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.StatisticList;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.UseResult;
import net.minecraft.server.UseResultWithValue;
import net.minecraft.server.EntityHuman;

public class ItemBookAndQuill extends Item {
   public ItemBookAndQuill() {
      this.d(1);
   }

   public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      var3.a(var1);
      var3.b(StatisticList.ad[Item.getId((Item)this)]);
      return new UseResultWithValue(UseResult.SUCCESS, var1);
   }

   public static boolean b(NBTTagCompound var0) {
      if(var0 == null) {
         return false;
      } else if(!var0.hasOfType("pages", 9)) {
         return false;
      } else {
         NBTTagList var1 = var0.getList("pages", 8);

         for(int var2 = 0; var2 < var1.getSize(); ++var2) {
            String var3 = var1.getString(var2);
            if(var3 == null) {
               return false;
            }

            if(var3.length() > 32767) {
               return false;
            }
         }

         return true;
      }
   }
}
