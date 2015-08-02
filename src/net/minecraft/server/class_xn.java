package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_cy;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_xd;

public class class_xn extends class_xd {
   private int f = 200;

   public class_xn(World var1) {
      super(var1);
   }

   public class_xn(World var1, EntityLiving var2) {
      super(var1, var2);
   }

   public class_xn(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public void t_() {
      super.t_();
      if(this.o.isClientSide && !this.a) {
         this.o.a(class_cy.o, this.s, this.t, this.u, 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   protected ItemStack j() {
      return new ItemStack(Items.h);
   }

   protected void b(EntityLiving var1) {
      super.b(var1);
      class_pl var2 = new class_pl(class_pm.x, this.f, 0);
      var1.c(var2);
   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      if(var1.has("Duration")) {
         this.f = var1.getInt("Duration");
      }

   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("Duration", this.f);
   }
}
