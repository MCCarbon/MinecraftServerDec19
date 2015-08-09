package net.minecraft.server;

import java.util.Random;

public class ItemEnchantedBook extends Item {
   public boolean isTool(ItemStack var1) {
      return false;
   }

   public EnumItemRarity getRarity(ItemStack var1) {
      return !this.h(var1).isEmpty()?EnumItemRarity.UNCOMMON:super.getRarity(var1);
   }

   public NBTTagList h(ItemStack var1) {
      NBTTagCompound var2 = var1.getTag();
      return var2 != null && var2.hasOfType("StoredEnchantments", 9)?(NBTTagList)var2.getTag("StoredEnchantments"):new NBTTagList();
   }

   public void a(ItemStack var1, class_adl var2) {
      NBTTagList var3 = this.h(var1);
      boolean var4 = true;

      for(int var5 = 0; var5 < var3.getSize(); ++var5) {
         NBTTagCompound var6 = var3.getCompound(var5);
         if(Enchantment.c(var6.getShort("id")) == var2.b) {
            if(var6.getShort("lvl") < var2.c) {
               var6.put("lvl", (short)var2.c);
            }

            var4 = false;
            break;
         }
      }

      if(var4) {
         NBTTagCompound var7 = new NBTTagCompound();
         var7.put("id", (short)Enchantment.b(var2.b));
         var7.put("lvl", (short)var2.c);
         var3.add((NBTTag)var7);
      }

      if(!var1.hasTag()) {
         var1.setTag(new NBTTagCompound());
      }

      var1.getTag().put((String)"StoredEnchantments", (NBTTag)var3);
   }

   public ItemStack a(class_adl var1) {
      ItemStack var2 = new ItemStack(this);
      this.a(var2, var1);
      return var2;
   }

   public class_od b(Random var1) {
      return this.a(var1, 1, 1, 1);
   }

   public class_od a(Random var1, int var2, int var3, int var4) {
      ItemStack var5 = new ItemStack(Items.BOOK);
      EnchantmentManager.a(var1, var5, 30);
      return new class_od(var5, var2, var3, var4);
   }
}
