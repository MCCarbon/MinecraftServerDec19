package net.minecraft.server;

import java.util.List;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ams;
import net.minecraft.server.TileEntityHopper;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.IInventory;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pv;
import net.minecraft.server.EntityItem;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_vq;
import net.minecraft.server.PlayerInventory;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;
import net.minecraft.server.class_yn;

public class class_vs extends class_vq implements class_ams {
   private boolean a = true;
   private int b = -1;
   private BlockPosition c;

   public class_vs(World var1) {
      super(var1);
      this.c = BlockPosition.ZERO;
   }

   public class_vs(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
      this.c = BlockPosition.ZERO;
   }

   public class_vn.class_a_in_class_vn s() {
      return class_vn.class_a_in_class_vn.f;
   }

   public IBlockData u() {
      return Blocks.HOPPER.getBlockData();
   }

   public int w() {
      return 1;
   }

   public int getSize() {
      return 5;
   }

   public boolean a(EntityHuman var1, ItemStack var2, EnumUsedHand var3) {
      if(!this.o.isClientSide) {
         var1.openContainer((IInventory)this);
      }

      return true;
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      boolean var5 = !var4;
      if(var5 != this.y()) {
         this.i(var5);
      }

   }

   public boolean y() {
      return this.a;
   }

   public void i(boolean var1) {
      this.a = var1;
   }

   public World getWorld() {
      return this.o;
   }

   public double A() {
      return this.s;
   }

   public double B() {
      return this.t + 0.5D;
   }

   public double C() {
      return this.u;
   }

   public void t_() {
      super.t_();
      if(!this.o.isClientSide && this.ai() && this.y()) {
         BlockPosition var1 = new BlockPosition(this);
         if(var1.equals(this.c)) {
            --this.b;
         } else {
            this.m(0);
         }

         if(!this.E()) {
            this.m(0);
            if(this.D()) {
               this.m(4);
               this.update();
            }
         }
      }

   }

   public boolean D() {
      if(TileEntityHopper.a((class_ams)this)) {
         return true;
      } else {
         List var1 = this.o.a(EntityItem.class, this.aT().grow(0.25D, 0.0D, 0.25D), class_pv.a);
         if(!var1.isEmpty()) {
            TileEntityHopper.a((IInventory)this, (EntityItem)((EntityItem)var1.get(0)));
         }

         return false;
      }
   }

   public void a(class_pc var1) {
      super.a(var1);
      if(this.o.R().b("doEntityDrops")) {
         this.a(Item.getByBlock((Block)Blocks.HOPPER), 1, 0.0F);
      }

   }

   protected void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("TransferCooldown", this.b);
   }

   protected void a(NBTTagCompound var1) {
      super.a(var1);
      this.b = var1.getInt("TransferCooldown");
   }

   public void m(int var1) {
      this.b = var1;
   }

   public boolean E() {
      return this.b > 0;
   }

   public String getContainerName() {
      return "minecraft:hopper";
   }

   public Container createContainer(PlayerInventory var1, EntityHuman var2) {
      return new class_yn(var1, this, var2);
   }
}
