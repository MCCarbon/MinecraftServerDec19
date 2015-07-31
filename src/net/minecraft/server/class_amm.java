package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_amu;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yi;

public class class_amm extends class_amu implements class_oj {
   private static final Random f = new Random();
   private ItemStack[] g = new ItemStack[9];
   protected String a;

   public int o_() {
      return 9;
   }

   public ItemStack a(int var1) {
      return this.g[var1];
   }

   public ItemStack a(int var1, int var2) {
      if(this.g[var1] != null) {
         ItemStack var3;
         if(this.g[var1].count <= var2) {
            var3 = this.g[var1];
            this.g[var1] = null;
            this.p_();
            return var3;
         } else {
            var3 = this.g[var1].a(var2);
            if(this.g[var1].count == 0) {
               this.g[var1] = null;
            }

            this.p_();
            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack b(int var1) {
      if(this.g[var1] != null) {
         ItemStack var2 = this.g[var1];
         this.g[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public int m() {
      int var1 = -1;
      int var2 = 1;

      for(int var3 = 0; var3 < this.g.length; ++var3) {
         if(this.g[var3] != null && f.nextInt(var2++) == 0) {
            var1 = var3;
         }
      }

      return var1;
   }

   public void a(int var1, ItemStack var2) {
      this.g[var1] = var2;
      if(var2 != null && var2.count > this.q_()) {
         var2.count = this.q_();
      }

      this.p_();
   }

   public int a(ItemStack var1) {
      for(int var2 = 0; var2 < this.g.length; ++var2) {
         if(this.g[var2] == null || this.g[var2].getItem() == null) {
            this.a(var2, var1);
            return var2;
         }
      }

      return -1;
   }

   public String e_() {
      return this.l_()?this.a:"container.dispenser";
   }

   public void a(String var1) {
      this.a = var1;
   }

   public boolean l_() {
      return this.a != null;
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      NBTTagList var2 = var1.getList("Items", 10);
      this.g = new ItemStack[this.o_()];

      for(int var3 = 0; var3 < var2.getSize(); ++var3) {
         NBTTagCompound var4 = var2.getCompound(var3);
         int var5 = var4.getByte("Slot") & 255;
         if(var5 >= 0 && var5 < this.g.length) {
            this.g[var5] = ItemStack.a(var4);
         }
      }

      if(var1.hasOfType("CustomName", 8)) {
         this.a = var1.getString("CustomName");
      }

   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
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
         var1.put("CustomName", this.a);
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
      return true;
   }

   public String k() {
      return "minecraft:dispenser";
   }

   public class_xz a(class_wz var1, class_xa var2) {
      return new class_yi(var1, this);
   }

   public int a_(int var1) {
      return 0;
   }

   public void b(int var1, int var2) {
   }

   public int g() {
      return 0;
   }

   public void l() {
      for(int var1 = 0; var1 < this.g.length; ++var1) {
         this.g[var1] = null;
      }

   }
}
