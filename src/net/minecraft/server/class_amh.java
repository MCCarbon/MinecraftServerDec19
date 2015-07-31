package net.minecraft.server;

import java.util.Arrays;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_ace;
import net.minecraft.server.class_agn;
import net.minecraft.server.class_amu;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_oz;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yd;

public class class_amh extends class_amu implements class_kn, class_oz {
   private static final int[] a = new int[]{3};
   private static final int[] f = new int[]{0, 1, 2};
   private ItemStack[] g = new ItemStack[4];
   private int h;
   private boolean[] i;
   private Item j;
   private String k;

   public String e_() {
      return this.l_()?this.k:"container.brewing";
   }

   public boolean l_() {
      return this.k != null && !this.k.isEmpty();
   }

   public void a(String var1) {
      this.k = var1;
   }

   public int o_() {
      return this.g.length;
   }

   public void c() {
      boolean var1 = this.n();
      boolean var2 = this.h > 0;
      if(var2) {
         --this.h;
         boolean var3 = this.h == 0;
         if(var3 && var1) {
            this.o();
            this.p_();
         } else if(!var1) {
            this.h = 0;
            this.p_();
         } else if(this.j != this.g[3].getItem()) {
            this.h = 0;
            this.p_();
         }
      } else if(var1) {
         this.h = 400;
         this.j = this.g[3].getItem();
      }

      if(!this.b.D) {
         boolean[] var6 = this.m();
         if(!Arrays.equals(var6, this.i)) {
            this.i = var6;
            IBlockData var4 = this.b.p(this.v());
            if(!(var4.getBlock() instanceof class_agn)) {
               return;
            }

            for(int var5 = 0; var5 < class_agn.a.length; ++var5) {
               var4 = var4.set(class_agn.a[var5], Boolean.valueOf(var6[var5]));
            }

            this.b.a((BlockPosition)this.c, (IBlockData)var4, 2);
         }
      }

   }

   public boolean[] m() {
      boolean[] var1 = new boolean[3];

      for(int var2 = 0; var2 < 3; ++var2) {
         if(this.g[var2] != null) {
            var1[var2] = true;
         }
      }

      return var1;
   }

   private boolean n() {
      if(this.g[3] != null && this.g[3].count > 0) {
         ItemStack var1 = this.g[3];
         if(!class_ace.a(var1)) {
            return false;
         } else {
            for(int var2 = 0; var2 < 3; ++var2) {
               ItemStack var3 = this.g[var2];
               if(var3 != null && class_ace.a(var3, var1)) {
                  return true;
               }
            }

            return false;
         }
      } else {
         return false;
      }
   }

   private void o() {
      ItemStack var1 = this.g[3];

      for(int var2 = 0; var2 < 3; ++var2) {
         this.g[var2] = class_ace.d(var1, this.g[var2]);
      }

      if(var1.getItem().r()) {
         this.g[3] = new ItemStack(var1.getItem().q());
      } else {
         --this.g[3].count;
         if(this.g[3].count <= 0) {
            this.g[3] = null;
         }
      }

   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      NBTTagList var2 = var1.getList("Items", 10);
      this.g = new ItemStack[this.o_()];

      for(int var3 = 0; var3 < var2.getSize(); ++var3) {
         NBTTagCompound var4 = var2.getCompound(var3);
         byte var5 = var4.getByte("Slot");
         if(var5 >= 0 && var5 < this.g.length) {
            this.g[var5] = ItemStack.a(var4);
         }
      }

      this.h = var1.getShort("BrewTime");
      if(var1.hasOfType("CustomName", 8)) {
         this.k = var1.getString("CustomName");
      }

   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("BrewTime", (short)this.h);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.g.length; ++var3) {
         if(this.g[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.put("Slot", (byte)var3);
            this.g[var3].write(var4);
            var2.add((NBTTag)var4);
         }
      }

      var1.put((String)"Items", (NBTTag)var2);
      if(this.l_()) {
         var1.put("CustomName", this.k);
      }

   }

   public ItemStack a(int var1) {
      return var1 >= 0 && var1 < this.g.length?this.g[var1]:null;
   }

   public ItemStack a(int var1, int var2) {
      if(var1 >= 0 && var1 < this.g.length) {
         ItemStack var3 = this.g[var1];
         this.g[var1] = null;
         return var3;
      } else {
         return null;
      }
   }

   public ItemStack b(int var1) {
      if(var1 >= 0 && var1 < this.g.length) {
         ItemStack var2 = this.g[var1];
         this.g[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, ItemStack var2) {
      if(var1 >= 0 && var1 < this.g.length) {
         this.g[var1] = var2;
      }

   }

   public int q_() {
      return 64;
   }

   public boolean a(class_xa var1) {
      return this.b.s(this.c) != this?false:var1.e((double)this.c.getX() + 0.5D, (double)this.c.getY() + 0.5D, (double)this.c.getZ() + 0.5D) <= 64.0D;
   }

   public void b(class_xa var1) {
   }

   public void c(class_xa var1) {
   }

   public boolean b(int var1, ItemStack var2) {
      if(var1 == 3) {
         return class_ace.a(var2);
      } else {
         Item var3 = var2.getItem();
         return var3 == Items.bB || var3 == Items.bD;
      }
   }

   public int[] a(EnumDirection var1) {
      return var1 == EnumDirection.UP?a:f;
   }

   public boolean a(int var1, ItemStack var2, EnumDirection var3) {
      return this.b(var1, var2);
   }

   public boolean b(int var1, ItemStack var2, EnumDirection var3) {
      return true;
   }

   public String k() {
      return "minecraft:brewing_stand";
   }

   public class_xz a(class_wz var1, class_xa var2) {
      return new class_yd(var1, this);
   }

   public int a_(int var1) {
      switch(var1) {
      case 0:
         return this.h;
      default:
         return 0;
      }
   }

   public void b(int var1, int var2) {
      switch(var1) {
      case 0:
         this.h = var2;
      default:
      }
   }

   public int g() {
      return 1;
   }

   public void l() {
      Arrays.fill(this.g, (Object)null);
   }
}
