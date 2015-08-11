package net.minecraft.server;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class PlayerInventory implements IInventory {
   public final ItemStack[] a = new ItemStack[36];
   public final ItemStack[] b = new ItemStack[4];
   public final ItemStack[] c = new ItemStack[1];
   private final ItemStack[][] g;
   public int itemInHandIndex;
   public EntityHuman e;
   private ItemStack h;
   public boolean f;

   public PlayerInventory(EntityHuman var1) {
      this.g = new ItemStack[][]{this.a, this.b, this.c};
      this.e = var1;
   }

   public ItemStack getItemInHand() {
      return this.itemInHandIndex < 9 && this.itemInHandIndex >= 0?this.a[this.itemInHandIndex]:null;
   }

   public static int i() {
      return 9;
   }

   private int d(ItemStack var1) {
      for(int var2 = 0; var2 < this.a.length; ++var2) {
         if(this.a[var2] != null && this.a[var2].getItem() == var1.getItem() && this.a[var2].d() && this.a[var2].count < this.a[var2].c() && this.a[var2].count < this.getMaxStackSize() && (!this.a[var2].f() || this.a[var2].i() == var1.i()) && ItemStack.a(this.a[var2], var1)) {
            return var2;
         }
      }

      return -1;
   }

   public int j() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         if(this.a[var1] == null) {
            return var1;
         }
      }

      return -1;
   }

   public int a(Item var1, int var2, int var3, NBTTagCompound var4) {
      int var5 = 0;

      int var6;
      for(var6 = 0; var6 < this.getSize(); ++var6) {
         ItemStack var7 = this.getItem(var6);
         if(var7 != null && (var1 == null || var7.getItem() == var1) && (var2 <= -1 || var7.i() == var2) && (var4 == null || NBTStructSerializer.a(var4, var7.getTag(), true))) {
            int var8 = var3 <= 0?var7.count:Math.min(var3 - var5, var7.count);
            var5 += var8;
            if(var3 != 0) {
            	var7.count -= var8;
               if(var7.count == 0) {
                  this.setItem(var6, (ItemStack)null);
               }

               if(var3 > 0 && var5 >= var3) {
                  return var5;
               }
            }
         }
      }

      if(this.h != null) {
         if(var1 != null && this.h.getItem() != var1) {
            return var5;
         }

         if(var2 > -1 && this.h.i() != var2) {
            return var5;
         }

         if(var4 != null && !NBTStructSerializer.a(var4, this.h.getTag(), true)) {
            return var5;
         }

         var6 = var3 <= 0?this.h.count:Math.min(var3 - var5, this.h.count);
         var5 += var6;
         if(var3 != 0) {
            this.h.count -= var6;
            if(this.h.count == 0) {
               this.h = null;
            }

            if(var3 > 0 && var5 >= var3) {
               return var5;
            }
         }
      }

      return var5;
   }

   private int e(ItemStack var1) {
      Item var2 = var1.getItem();
      int var3 = var1.count;
      int var4 = this.d(var1);
      if(var4 < 0) {
         var4 = this.j();
      }

      if(var4 < 0) {
         return var3;
      } else {
         if(this.a[var4] == null) {
            this.a[var4] = new ItemStack(var2, 0, var1.i());
            if(var1.hasTag()) {
               this.a[var4].setTag((NBTTagCompound)var1.getTag().clone());
            }
         }

         int var5 = var3;
         if(var3 > this.a[var4].c() - this.a[var4].count) {
            var5 = this.a[var4].c() - this.a[var4].count;
         }

         if(var5 > this.getMaxStackSize() - this.a[var4].count) {
            var5 = this.getMaxStackSize() - this.a[var4].count;
         }

         if(var5 == 0) {
            return var3;
         } else {
            var3 -= var5;
            this.a[var4].count += var5;
            this.a[var4].c = 5;
            return var3;
         }
      }
   }

   public void k() {
      for(int var1 = 0; var1 < this.g.length; ++var1) {
         ItemStack[] var2 = this.g[var1];

         for(int var3 = 0; var3 < var2.length; ++var3) {
            if(var2[var3] != null) {
               var2[var3].a(this.e.world, this.e, var3, this.itemInHandIndex == var3);
            }
         }
      }

   }

   public boolean pickup(final ItemStack var1) {
      if(var1 != null && var1.count != 0 && var1.getItem() != null) {
         try {
            int var2;
            if(var1.g()) {
               var2 = this.j();
               if(var2 >= 0) {
                  this.a[var2] = ItemStack.b(var1);
                  this.a[var2].c = 5;
                  var1.count = 0;
                  return true;
               } else if(this.e.abilities.instabuild) {
                  var1.count = 0;
                  return true;
               } else {
                  return false;
               }
            } else {
               do {
                  var2 = var1.count;
                  var1.count = this.e(var1);
               } while(var1.count > 0 && var1.count < var2);

               if(var1.count == var2 && this.e.abilities.instabuild) {
                  var1.count = 0;
                  return true;
               } else {
                  return var1.count < var2;
               }
            }
         } catch (Throwable var5) {
            class_b var3 = class_b.a(var5, "Adding item to inventory");
            class_c var4 = var3.a("Item being added");
            var4.a((String)"Item ID", (Object)Integer.valueOf(Item.getId(var1.getItem())));
            var4.a((String)"Item data", (Object)Integer.valueOf(var1.i()));
            var4.a("Item name", new Callable() {
               public String a() throws Exception {
                  return var1.getDisplayName();
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            throw new class_e(var3);
         }
      } else {
         return false;
      }
   }

   public ItemStack splitStack(int var1, int var2) {
      ItemStack[] var3 = null;
      ItemStack[][] var4 = this.g;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ItemStack[] var7 = var4[var6];
         if(var1 < var7.length) {
            var3 = var7;
            break;
         }

         var1 -= var7.length;
      }

      if(var3 != null && var3[var1] != null) {
         ItemStack var8;
         if(var3[var1].count <= var2) {
            var8 = var3[var1];
            var3[var1] = null;
            return var8;
         } else {
            var8 = var3[var1].a(var2);
            if(var3[var1].count == 0) {
               var3[var1] = null;
            }

            return var8;
         }
      } else {
         return null;
      }
   }

   public ItemStack splitWithoutUpdate(int var1) {
      ItemStack[] var2 = null;
      ItemStack[][] var3 = this.g;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         ItemStack[] var6 = var3[var5];
         if(var1 < var6.length) {
            var2 = var6;
            break;
         }

         var1 -= var6.length;
      }

      if(var2 != null && var2[var1] != null) {
         Object var7 = var2[var1];
         var2[var1] = null;
         return (ItemStack)var7;
      } else {
         return null;
      }
   }

   public void setItem(int var1, ItemStack var2) {
      ItemStack[] var3 = null;
      ItemStack[][] var4 = this.g;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ItemStack[] var7 = var4[var6];
         if(var1 < var7.length) {
            var3 = var7;
            break;
         }

         var1 -= var7.length;
      }

      if(var3 != null) {
         var3[var1] = var2;
      }

   }

   public float a(Block var1) {
      float var2 = 1.0F;
      if(this.a[this.itemInHandIndex] != null) {
         var2 *= this.a[this.itemInHandIndex].a(var1);
      }

      return var2;
   }

   public NBTTagList a(NBTTagList var1) {
      int var2;
      NBTTagCompound var3;
      for(var2 = 0; var2 < this.a.length; ++var2) {
         if(this.a[var2] != null) {
            var3 = new NBTTagCompound();
            var3.put("Slot", (byte)var2);
            this.a[var2].write(var3);
            var1.add((NBTTag)var3);
         }
      }

      for(var2 = 0; var2 < this.b.length; ++var2) {
         if(this.b[var2] != null) {
            var3 = new NBTTagCompound();
            var3.put("Slot", (byte)(var2 + 100));
            this.b[var2].write(var3);
            var1.add((NBTTag)var3);
         }
      }

      for(var2 = 0; var2 < this.c.length; ++var2) {
         if(this.c[var2] != null) {
            var3 = new NBTTagCompound();
            var3.put("Slot", (byte)(var2 + 150));
            this.c[var2].write(var3);
            var1.add((NBTTag)var3);
         }
      }

      return var1;
   }

   public void b(NBTTagList var1) {
      Arrays.fill(this.a, (Object)null);
      Arrays.fill(this.b, (Object)null);
      Arrays.fill(this.c, (Object)null);

      for(int var2 = 0; var2 < var1.getSize(); ++var2) {
         NBTTagCompound var3 = var1.getCompound(var2);
         int var4 = var3.getByte("Slot") & 255;
         ItemStack var5 = ItemStack.a(var3);
         if(var5 != null) {
            if(var4 >= 0 && var4 < this.a.length) {
               this.a[var4] = var5;
            } else if(var4 >= 100 && var4 < this.b.length + 100) {
               this.b[var4 - 100] = var5;
            } else if(var4 >= 150 && var4 < this.c.length + 150) {
               this.c[var4 - 150] = var5;
            }
         }
      }

   }

   public int getSize() {
      return this.a.length + this.b.length + this.c.length;
   }

   public ItemStack getItem(int var1) {
      ItemStack[] var2 = null;
      ItemStack[][] var3 = this.g;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         ItemStack[] var6 = var3[var5];
         if(var1 < var6.length) {
            var2 = var6;
            break;
         }

         var1 -= var6.length;
      }

      return var2 == null?null:var2[var1];
   }

   public String getName() {
      return "container.inventory";
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

   public boolean b(Block var1) {
      if(var1.getMaterial().isAlwaysDestroyable()) {
         return true;
      } else {
         ItemStack var2 = this.getItem(this.itemInHandIndex);
         return var2 != null?var2.b(var1):false;
      }
   }

   public int m() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         if(this.b[var2] != null && this.b[var2].getItem() instanceof ItemArmor) {
            int var3 = ((ItemArmor)this.b[var2].getItem()).c;
            var1 += var3;
         }
      }

      return var1;
   }

   public void a(float var1) {
      var1 /= 4.0F;
      if(var1 < 1.0F) {
         var1 = 1.0F;
      }

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         if(this.b[var2] != null && this.b[var2].getItem() instanceof ItemArmor) {
            this.b[var2].a((int)var1, (EntityLiving)this.e);
            if(this.b[var2].count == 0) {
               this.b[var2] = null;
            }
         }
      }

   }

   public void n() {
      ItemStack[][] var1 = this.g;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         ItemStack[] var4 = var1[var3];

         for(int var5 = 0; var5 < var4.length; ++var5) {
            if(var4[var5] != null) {
               this.e.a(var4[var5], true, false);
               var4[var5] = null;
            }
         }
      }

   }

   public void update() {
      this.f = true;
   }

   public void b(ItemStack var1) {
      this.h = var1;
   }

   public ItemStack o() {
      return this.h;
   }

   public boolean isReachable(EntityHuman var1) {
      return this.e.dead?false:var1.h(this.e) <= 64.0D;
   }

   public boolean c(ItemStack var1) {
      ItemStack[][] var2 = this.g;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ItemStack[] var5 = var2[var4];

         for(int var6 = 0; var6 < var5.length; ++var6) {
            if(var5[var6] != null && var5[var6].a(var1)) {
               return true;
            }
         }
      }

      return false;
   }

   public void startOpen(EntityHuman var1) {
   }

   public void closeContainer(EntityHuman var1) {
   }

   public boolean canPlaceItem(int var1, ItemStack var2) {
      return true;
   }

   public void a(PlayerInventory var1) {
      for(int var2 = 0; var2 < this.getSize(); ++var2) {
         this.setItem(var2, var1.getItem(var2));
      }

      this.itemInHandIndex = var1.itemInHandIndex;
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
      ItemStack[][] var1 = this.g;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         ItemStack[] var4 = var1[var3];

         for(int var5 = 0; var5 < var4.length; ++var5) {
            var4[var5] = null;
         }
      }

   }
}
