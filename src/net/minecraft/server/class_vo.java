package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_agu;
import net.minecraft.server.IBlockData;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_vq;
import net.minecraft.server.PlayerInventory;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;
import net.minecraft.server.class_yf;

public class class_vo extends class_vq {
   public class_vo(World var1) {
      super(var1);
   }

   public class_vo(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public void a(class_pc var1) {
      super.a(var1);
      if(this.o.R().b("doEntityDrops")) {
         this.a(Item.getItemOf((Block)Blocks.CHEST), 1, 0.0F);
      }

   }

   public int getSize() {
      return 27;
   }

   public class_vn.class_a_in_class_vn s() {
      return class_vn.class_a_in_class_vn.b;
   }

   public IBlockData u() {
      return Blocks.CHEST.getBlockData().set(class_agu.a, EnumDirection.NORTH);
   }

   public int w() {
      return 8;
   }

   public String getContainerName() {
      return "minecraft:chest";
   }

   public Container createContainer(PlayerInventory var1, EntityHuman var2) {
      return new class_yf(var1, this, var2);
   }
}
