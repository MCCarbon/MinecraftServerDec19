package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_aax;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_avf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTag;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.Datawathcer;
import net.minecraft.server.class_uz;
import net.minecraft.server.EntityHuman;

public class class_va extends class_uz {
   private static final int c = Datawathcer.claimId(class_va.class);
   private static final int d = Datawathcer.claimId(class_va.class);
   private float e = 1.0F;

   public class_va(World var1) {
      super(var1);
   }

   public class_va(World var1, BlockPosition var2, EnumDirection var3) {
      super(var1, var2);
      this.a((EnumDirection)var3);
   }

   protected void h() {
      this.H().addNull(c, 5);
      this.H().add(d, Byte.valueOf((byte)0));
   }

   public float ao() {
      return 0.0F;
   }

   public boolean damageEntity(class_pc var1, float var2) {
      if(this.b((class_pc)var1)) {
         return false;
      } else if(!var1.c() && this.o() != null) {
         if(!this.o.isClientSide) {
            this.a(var1.j(), false);
            this.a((ItemStack)null);
         }

         return true;
      } else {
         return super.damageEntity(var1, var2);
      }
   }

   public int l() {
      return 12;
   }

   public int m() {
      return 12;
   }

   public void b(Entity var1) {
      this.a(var1, true);
   }

   public void a(Entity var1, boolean var2) {
      if(this.o.R().b("doEntityDrops")) {
         ItemStack var3 = this.o();
         if(var1 instanceof EntityHuman) {
            EntityHuman var4 = (EntityHuman)var1;
            if(var4.abilities.instabuild) {
               this.b(var3);
               return;
            }
         }

         if(var2) {
            this.a(new ItemStack(Items.bS), 0.0F);
         }

         if(var3 != null && this.random.nextFloat() < this.e) {
            var3 = var3.clone();
            this.b(var3);
            this.a(var3, 0.0F);
         }

      }
   }

   private void b(ItemStack var1) {
      if(var1 != null) {
         if(var1.getItem() == Items.bf) {
            class_avf var2 = ((class_aax)var1.getItem()).a(var1, this.o);
            var2.h.remove("frame-" + this.getId());
         }

         var1.setItemFrame((class_va)null);
      }
   }

   public ItemStack o() {
      return this.H().getItemStack(c);
   }

   public void a(ItemStack var1) {
      this.a(var1, true);
   }

   private void a(ItemStack var1, boolean var2) {
      if(var1 != null) {
         var1 = var1.clone();
         var1.count = 1;
         var1.setItemFrame(this);
      }

      this.H().update(c, var1);
      this.H().i(c);
      if(var2 && this.a != null) {
         this.o.e(this.a, Blocks.AIR);
      }

   }

   public int p() {
      return this.H().getByte(d);
   }

   public void a(int var1) {
      this.a(var1, true);
   }

   private void a(int var1, boolean var2) {
      this.H().update(d, Byte.valueOf((byte)(var1 % 8)));
      if(var2 && this.a != null) {
         this.o.e(this.a, Blocks.AIR);
      }

   }

   public void write(NBTTagCompound var1) {
      if(this.o() != null) {
         var1.put((String)"Item", (NBTTag)this.o().write(new NBTTagCompound()));
         var1.put("ItemRotation", (byte)this.p());
         var1.put("ItemDropChance", this.e);
      }

      super.write(var1);
   }

   public void read(NBTTagCompound var1) {
      NBTTagCompound var2 = var1.getCompound("Item");
      if(var2 != null && !var2.isEmpty()) {
         this.a(ItemStack.a(var2), false);
         this.a(var1.getByte("ItemRotation"), false);
         if(var1.hasOfType("ItemDropChance", 99)) {
            this.e = var1.getFloat("ItemDropChance");
         }

         if(var1.has("Direction")) {
            this.a(this.p() * 2, false);
         }
      }

      super.read(var1);
   }

   public boolean a(EntityHuman var1, ItemStack var2, EnumUsedHand var3) {
      if(this.o() == null) {
         if(var2 != null && !this.o.isClientSide) {
            this.a(var2);
            if(!var1.abilities.instabuild) {
               --var2.count;
            }
         }
      } else if(!this.o.isClientSide) {
         this.a(this.p() + 1);
      }

      return true;
   }

   public int q() {
      return this.o() == null?0:this.p() % 8 + 1;
   }
}
