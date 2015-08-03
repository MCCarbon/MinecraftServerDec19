package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_xd;
import net.minecraft.server.CreativeTab;

public class ItemArrow extends Item {
   public ItemArrow() {
      this.a(CreativeTab.COMBAT);
   }

   public class_xd a(World var1, ItemStack var2, EntityLiving var3) {
      return new class_xd(var1, var3);
   }
}
