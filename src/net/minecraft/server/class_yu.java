package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.class_amp;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_ow;
import net.minecraft.server.class_xa;

public class class_yu extends class_ow {
   private class_amp a;

   public class_yu() {
      super("container.enderchest", false, 27);
   }

   public void a(class_amp var1) {
      this.a = var1;
   }

   public void a(NBTTagList var1) {
      int var2;
      for(var2 = 0; var2 < this.o_(); ++var2) {
         this.a(var2, (ItemStack)null);
      }

      for(var2 = 0; var2 < var1.getSize(); ++var2) {
         NBTTagCompound var3 = var1.getCompound(var2);
         int var4 = var3.getByte("Slot") & 255;
         if(var4 >= 0 && var4 < this.o_()) {
            this.a(var4, ItemStack.a(var3));
         }
      }

   }

   public NBTTagList h() {
      NBTTagList var1 = new NBTTagList();

      for(int var2 = 0; var2 < this.o_(); ++var2) {
         ItemStack var3 = this.a(var2);
         if(var3 != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.put("Slot", (byte)var2);
            var3.write(var4);
            var1.add((NBTTag)var4);
         }
      }

      return var1;
   }

   public boolean a(class_xa var1) {
      return this.a != null && !this.a.a(var1)?false:super.a(var1);
   }

   public void b(class_xa var1) {
      if(this.a != null) {
         this.a.b();
      }

      super.b(var1);
   }

   public void c(class_xa var1) {
      if(this.a != null) {
         this.a.d();
      }

      super.c(var1);
      this.a = null;
   }
}
