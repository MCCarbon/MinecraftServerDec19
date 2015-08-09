package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.IInventory;
import net.minecraft.server.ChestLock;
import net.minecraft.server.ITileInventory;
import net.minecraft.server.PlayerInventory;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;
import net.minecraft.server.ContainerChest;

public class class_oi implements ITileInventory {
   private String a;
   private ITileInventory b;
   private ITileInventory c;

   public class_oi(String var1, ITileInventory var2, ITileInventory var3) {
      this.a = var1;
      if(var2 == null) {
         var2 = var3;
      }

      if(var3 == null) {
         var3 = var2;
      }

      this.b = var2;
      this.c = var3;
      if(var2.isLocked()) {
         var3.setChestLock(var2.getChestLock());
      } else if(var3.isLocked()) {
         var2.setChestLock(var3.getChestLock());
      }

   }

   public int getSize() {
      return this.b.getSize() + this.c.getSize();
   }

   public boolean a(IInventory var1) {
      return this.b == var1 || this.c == var1;
   }

   public String getName() {
      return this.b.hasCustomName()?this.b.getName():(this.c.hasCustomName()?this.c.getName():this.a);
   }

   public boolean hasCustomName() {
      return this.b.hasCustomName() || this.c.hasCustomName();
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return (IChatBaseComponent)(this.hasCustomName()?new ChatComponentText(this.getName()):new ChatMessage(this.getName(), new Object[0]));
   }

   public ItemStack getItem(int var1) {
      return var1 >= this.b.getSize()?this.c.getItem(var1 - this.b.getSize()):this.b.getItem(var1);
   }

   public ItemStack splitStack(int var1, int var2) {
      return var1 >= this.b.getSize()?this.c.splitStack(var1 - this.b.getSize(), var2):this.b.splitStack(var1, var2);
   }

   public ItemStack splitWithoutUpdate(int var1) {
      return var1 >= this.b.getSize()?this.c.splitWithoutUpdate(var1 - this.b.getSize()):this.b.splitWithoutUpdate(var1);
   }

   public void setItem(int var1, ItemStack var2) {
      if(var1 >= this.b.getSize()) {
         this.c.setItem(var1 - this.b.getSize(), var2);
      } else {
         this.b.setItem(var1, var2);
      }

   }

   public int getMaxStackSize() {
      return this.b.getMaxStackSize();
   }

   public void update() {
      this.b.update();
      this.c.update();
   }

   public boolean isReachable(EntityHuman var1) {
      return this.b.isReachable(var1) && this.c.isReachable(var1);
   }

   public void startOpen(EntityHuman var1) {
      this.b.startOpen(var1);
      this.c.startOpen(var1);
   }

   public void closeContainer(EntityHuman var1) {
      this.b.closeContainer(var1);
      this.c.closeContainer(var1);
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

   public boolean isLocked() {
      return this.b.isLocked() || this.c.isLocked();
   }

   public void setChestLock(ChestLock var1) {
      this.b.setChestLock(var1);
      this.c.setChestLock(var1);
   }

   public ChestLock getChestLock() {
      return this.b.getChestLock();
   }

   public String getContainerName() {
      return this.b.getContainerName();
   }

   public Container createContainer(PlayerInventory var1, EntityHuman var2) {
      return new ContainerChest(var1, this, var2);
   }

   public void remove() {
      this.b.remove();
      this.c.remove();
   }
}
