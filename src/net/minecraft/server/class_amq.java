package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_amg;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.Packet;
import net.minecraft.server.class_ft;
import net.minecraft.server.MinecraftKey;

public class class_amq extends class_amg {
   private Item a;
   private int f;

   public class_amq() {
   }

   public class_amq(Item var1, int var2) {
      this.a = var1;
      this.f = var2;
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      MinecraftKey var2 = (MinecraftKey)Item.ITEM_REGISTRY.getKey(this.a);
      var1.put("Item", var2 == null?"":var2.toString());
      var1.put("Data", this.f);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.hasOfType("Item", 8)) {
         this.a = Item.getByName(var1.getString("Item"));
      } else {
         this.a = Item.getById(var1.getInt("Item"));
      }

      this.f = var1.getInt("Data");
   }

   public Packet z_() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.b(var1);
      var1.remove("Item");
      var1.put("Item", Item.getId(this.a));
      return new class_ft(this.c, 5, var1);
   }

   public void a(Item var1, int var2) {
      this.a = var1;
      this.f = var2;
   }

   public Item b() {
      return this.a;
   }

   public int c() {
      return this.f;
   }
}
