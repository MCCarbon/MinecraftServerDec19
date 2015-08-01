package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.IInventory;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;

public class class_yg implements IInventory {
   private final ItemStack[] a;
   private final int b;
   private final int c;
   private final Container d;

   public class_yg(Container var1, int var2, int var3) {
      int var4 = var2 * var3;
      this.a = new ItemStack[var4];
      this.d = var1;
      this.b = var2;
      this.c = var3;
   }

   public int getSize() {
      return this.a.length;
   }

   public ItemStack getItem(int var1) {
      return var1 >= this.getSize()?null:this.a[var1];
   }

   public ItemStack c(int var1, int var2) {
      return var1 >= 0 && var1 < this.b && var2 >= 0 && var2 <= this.c?this.getItem(var1 + var2 * this.b):null;
   }

   public String getName() {
      return "container.crafting";
   }

   public boolean hasCustomName() {
      return false;
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return (IChatBaseComponent)(this.hasCustomName()?new ChatComponentText(this.getName()):new ChatMessage(this.getName(), new Object[0]));
   }

   public ItemStack splitWithoutUpdate(int var1) {
      if(this.a[var1] != null) {
         ItemStack var2 = this.a[var1];
         this.a[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public ItemStack splitStack(int var1, int var2) {
      if(this.a[var1] != null) {
         ItemStack var3;
         if(this.a[var1].count <= var2) {
            var3 = this.a[var1];
            this.a[var1] = null;
            this.d.a((IInventory)this);
            return var3;
         } else {
            var3 = this.a[var1].a(var2);
            if(this.a[var1].count == 0) {
               this.a[var1] = null;
            }

            this.d.a((IInventory)this);
            return var3;
         }
      } else {
         return null;
      }
   }

   public void setItem(int var1, ItemStack var2) {
      this.a[var1] = var2;
      this.d.a((IInventory)this);
   }

   public int getMaxStackSize() {
      return 64;
   }

   public void update() {
   }

   public boolean isReachable(EntityHuman var1) {
      return true;
   }

   public void startOpen(EntityHuman var1) {
   }

   public void closeContainer(EntityHuman var1) {
   }

   public boolean canPlaceItem(int var1, ItemStack var2) {
      return true;
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
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

   }

   public int h() {
      return this.c;
   }

   public int i() {
      return this.b;
   }
}
