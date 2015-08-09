package net.minecraft.server;

public class RecipeBookClone implements IRecipe {
   public boolean a(InventoryCrafting var1, World var2) {
      int var3 = 0;
      ItemStack var4 = null;

      for(int var5 = 0; var5 < var1.getSize(); ++var5) {
         ItemStack var6 = var1.getItem(var5);
         if(var6 != null) {
            if(var6.getItem() == Items.WRITTEN_BOOK) {
               if(var4 != null) {
                  return false;
               }

               var4 = var6;
            } else {
               if(var6.getItem() != Items.WRITABLE_BOOK) {
                  return false;
               }

               ++var3;
            }
         }
      }

      return var4 != null && var3 > 0;
   }

   public ItemStack a(InventoryCrafting var1) {
      int var2 = 0;
      ItemStack var3 = null;

      for(int var4 = 0; var4 < var1.getSize(); ++var4) {
         ItemStack var5 = var1.getItem(var4);
         if(var5 != null) {
            if(var5.getItem() == Items.WRITTEN_BOOK) {
               if(var3 != null) {
                  return null;
               }

               var3 = var5;
            } else {
               if(var5.getItem() != Items.WRITABLE_BOOK) {
                  return null;
               }

               ++var2;
            }
         }
      }

      if(var3 != null && var2 >= 1 && ItemWrittenBook.h(var3) < 2) {
         ItemStack var6 = new ItemStack(Items.WRITTEN_BOOK, var2);
         var6.setTag((NBTTagCompound)var3.getTag().clone());
         var6.getTag().put("generation", ItemWrittenBook.h(var3) + 1);
         if(var3.hasDisplayName()) {
            var6.setDisplayName(var3.getDisplayName());
         }

         return var6;
      } else {
         return null;
      }
   }

   public int a() {
      return 9;
   }

   public ItemStack b() {
      return null;
   }

   public ItemStack[] b(InventoryCrafting var1) {
      ItemStack[] var2 = new ItemStack[var1.getSize()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         ItemStack var4 = var1.getItem(var3);
         if(var4 != null && var4.getItem() instanceof ItemWrittenBook) {
            var2[var3] = var4;
            break;
         }
      }

      return var2;
   }
}
