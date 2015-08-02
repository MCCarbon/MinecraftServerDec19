package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
import net.minecraft.server.IInventory;
import net.minecraft.server.class_ol;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.ChestLock;
import net.minecraft.server.ITileInventory;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.class_vn;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;

public abstract class class_vq extends class_vn implements ITileInventory {
   private ItemStack[] a = new ItemStack[36];
   private boolean b = true;

   public class_vq(World var1) {
      super(var1);
   }

   public class_vq(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public void a(class_pc var1) {
      super.a(var1);
      if(this.o.R().b("doEntityDrops")) {
         class_ol.a(this.o, (Entity)this, this);
      }

   }

   public ItemStack getItem(int var1) {
      return this.a[var1];
   }

   public ItemStack splitStack(int var1, int var2) {
      if(this.a[var1] != null) {
         ItemStack var3;
         if(this.a[var1].count <= var2) {
            var3 = this.a[var1];
            this.a[var1] = null;
            return var3;
         } else {
            var3 = this.a[var1].a(var2);
            if(this.a[var1].count == 0) {
               this.a[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
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

   public void setItem(int var1, ItemStack var2) {
      this.a[var1] = var2;
      if(var2 != null && var2.count > this.getMaxStackSize()) {
         var2.count = this.getMaxStackSize();
      }

   }

   public void update() {
   }

   public boolean isReachable(EntityHuman var1) {
      return this.I?false:var1.h(this) <= 64.0D;
   }

   public void startOpen(EntityHuman var1) {
   }

   public void closeContainer(EntityHuman var1) {
   }

   public boolean canPlaceItem(int var1, ItemStack var2) {
      return true;
   }

   public String getName() {
      return this.hasCustomName()?this.aO():"container.minecart";
   }

   public int getMaxStackSize() {
      return 64;
   }

   public void c(int var1) {
      this.b = false;
      super.c(var1);
   }

   public void J() {
      if(this.b) {
         class_ol.a(this.o, (Entity)this, this);
      }

      super.J();
   }

   protected void write(NBTTagCompound var1) {
      super.write(var1);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.a.length; ++var3) {
         if(this.a[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.put("Slot", (byte)var3);
            this.a[var3].write(var4);
            var2.add((NBTTag)var4);
         }
      }

      var1.put((String)"Items", (NBTTag)var2);
   }

   protected void read(NBTTagCompound var1) {
      super.read(var1);
      NBTTagList var2 = var1.getList("Items", 10);
      this.a = new ItemStack[this.getSize()];

      for(int var3 = 0; var3 < var2.getSize(); ++var3) {
         NBTTagCompound var4 = var2.getCompound(var3);
         int var5 = var4.getByte("Slot") & 255;
         if(var5 >= 0 && var5 < this.a.length) {
            this.a[var5] = ItemStack.a(var4);
         }
      }

   }

   public boolean a(EntityHuman var1, ItemStack var2, EnumUsedHand var3) {
      if(!this.o.isClientSide) {
         var1.openContainer((IInventory)this);
      }

      return true;
   }

   protected void o() {
      int var1 = 15 - Container.b((IInventory)this);
      float var2 = 0.98F + (float)var1 * 0.001F;
      this.v *= (double)var2;
      this.motY *= 0.0D;
      this.x *= (double)var2;
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
      return false;
   }

   public void setChestLock(ChestLock var1) {
   }

   public ChestLock getChestLock() {
      return ChestLock.NO_LOCK;
   }

   public void remove() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

   }
}
