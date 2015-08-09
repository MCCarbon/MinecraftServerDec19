package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.IMerchant;
import net.minecraft.server.MerchantRecipe;
import net.minecraft.server.MerchantRecipeList;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.IInventory;
import net.minecraft.server.EntityHuman;

public class InventoryMerchant implements IInventory {
   private final IMerchant a;
   private ItemStack[] b = new ItemStack[3];
   private final EntityHuman c;
   private MerchantRecipe d;
   private int e;

   public InventoryMerchant(EntityHuman var1, IMerchant var2) {
      this.c = var1;
      this.a = var2;
   }

   public int getSize() {
      return this.b.length;
   }

   public ItemStack getItem(int var1) {
      return this.b[var1];
   }

   public ItemStack splitStack(int var1, int var2) {
      if(this.b[var1] != null) {
         ItemStack var3;
         if(var1 == 2) {
            var3 = this.b[var1];
            this.b[var1] = null;
            return var3;
         } else if(this.b[var1].count <= var2) {
            var3 = this.b[var1];
            this.b[var1] = null;
            if(this.e(var1)) {
               this.h();
            }

            return var3;
         } else {
            var3 = this.b[var1].a(var2);
            if(this.b[var1].count == 0) {
               this.b[var1] = null;
            }

            if(this.e(var1)) {
               this.h();
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   private boolean e(int var1) {
      return var1 == 0 || var1 == 1;
   }

   public ItemStack splitWithoutUpdate(int var1) {
      if(this.b[var1] != null) {
         ItemStack var2 = this.b[var1];
         this.b[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void setItem(int var1, ItemStack var2) {
      this.b[var1] = var2;
      if(var2 != null && var2.count > this.getMaxStackSize()) {
         var2.count = this.getMaxStackSize();
      }

      if(this.e(var1)) {
         this.h();
      }

   }

   public String getName() {
      return "mob.villager";
   }

   public boolean hasCustomName() {
      return false;
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return (IChatBaseComponent)(this.hasCustomName()?new ChatComponentText(this.getName()):new ChatMessage(this.getName(), new Object[0]));
   }

   public int getMaxStackSize() {
      return 64;
   }

   public boolean isReachable(EntityHuman var1) {
      return this.a.v_() == var1;
   }

   public void startOpen(EntityHuman var1) {
   }

   public void closeContainer(EntityHuman var1) {
   }

   public boolean canPlaceItem(int var1, ItemStack var2) {
      return true;
   }

   public void update() {
      this.h();
   }

   public void h() {
      this.d = null;
      ItemStack var1 = this.b[0];
      ItemStack var2 = this.b[1];
      if(var1 == null) {
         var1 = var2;
         var2 = null;
      }

      if(var1 == null) {
         this.setItem(2, (ItemStack)null);
      } else {
         MerchantRecipeList var3 = this.a.getOffers(this.c);
         if(var3 != null) {
            MerchantRecipe var4 = var3.a(var1, var2, this.e);
            if(var4 != null && !var4.h()) {
               this.d = var4;
               this.setItem(2, var4.d().clone());
            } else if(var2 != null) {
               var4 = var3.a(var2, var1, this.e);
               if(var4 != null && !var4.h()) {
                  this.d = var4;
                  this.setItem(2, var4.d().clone());
               } else {
                  this.setItem(2, (ItemStack)null);
               }
            } else {
               this.setItem(2, (ItemStack)null);
            }
         }
      }

      this.a.a_(this.getItem(2));
   }

   public MerchantRecipe i() {
      return this.d;
   }

   public void d(int var1) {
      this.e = var1;
      this.h();
   }

   public int getProperty(int var1) {
      return 0;
   }

   public void setProperty(int var1, int var2) {
   }

   public int getPropertyCount() {
      return 0;
   }

   public void remove() {
      for(int var1 = 0; var1 < this.b.length; ++var1) {
         this.b[var1] = null;
      }

   }
}
