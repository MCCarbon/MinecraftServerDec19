package net.minecraft.server;

import java.util.ArrayList;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_aea;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.class_dy;
import net.minecraft.server.NBTTag;
import net.minecraft.server.PacketDataSerializer;

public class class_aeb extends ArrayList {
   public class_aeb() {
   }

   public class_aeb(NBTTagCompound var1) {
      this.a(var1);
   }

   public class_aea a(ItemStack var1, ItemStack var2, int var3) {
      if(var3 > 0 && var3 < this.size()) {
         class_aea var6 = (class_aea)this.get(var3);
         return !this.a(var1, var6.a()) || (var2 != null || var6.c()) && (!var6.c() || !this.a(var2, var6.b())) || var1.count < var6.a().count || var6.c() && var2.count < var6.b().count?null:var6;
      } else {
         for(int var4 = 0; var4 < this.size(); ++var4) {
            class_aea var5 = (class_aea)this.get(var4);
            if(this.a(var1, var5.a()) && var1.count >= var5.a().count && (!var5.c() && var2 == null || var5.c() && this.a(var2, var5.b()) && var2.count >= var5.b().count)) {
               return var5;
            }
         }

         return null;
      }
   }

   private boolean a(ItemStack var1, ItemStack var2) {
      return ItemStack.c(var1, var2) && (!var2.hasTag() || var1.hasTag() && class_dy.a(var2.getTag(), var1.getTag(), false));
   }

   public void a(PacketDataSerializer var1) {
      var1.writeByte((byte)(this.size() & 255));

      for(int var2 = 0; var2 < this.size(); ++var2) {
         class_aea var3 = (class_aea)this.get(var2);
         var1.writeItemStack(var3.a());
         var1.writeItemStack(var3.d());
         ItemStack var4 = var3.b();
         var1.writeBoolean(var4 != null);
         if(var4 != null) {
            var1.writeItemStack(var4);
         }

         var1.writeBoolean(var3.h());
         var1.writeInt(var3.e());
         var1.writeInt(var3.f());
      }

   }

   public void a(NBTTagCompound var1) {
      NBTTagList var2 = var1.getList("Recipes", 10);

      for(int var3 = 0; var3 < var2.getSize(); ++var3) {
         NBTTagCompound var4 = var2.getCompound(var3);
         this.add(new class_aea(var4));
      }

   }

   public NBTTagCompound a() {
      NBTTagCompound var1 = new NBTTagCompound();
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.size(); ++var3) {
         class_aea var4 = (class_aea)this.get(var3);
         var2.add((NBTTag)var4.k());
      }

      var1.put((String)"Recipes", (NBTTag)var2);
      return var1;
   }
}
