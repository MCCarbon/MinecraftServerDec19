package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.class_cy;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTag;
import net.minecraft.server.MathHelper;
import net.minecraft.server.Entity;
import net.minecraft.server.class_qi;

public class class_xg extends Entity {
   private static final int a = class_qi.a(class_xg.class);
   private int b;
   private int c;

   public class_xg(World var1) {
      super(var1);
      this.a(0.25F, 0.25F);
   }

   protected void h() {
      this.ac.a(a, 5);
   }

   public class_xg(World var1, double var2, double var4, double var6, ItemStack var8) {
      super(var1);
      this.b = 0;
      this.a(0.25F, 0.25F);
      this.b(var2, var4, var6);
      int var9 = 1;
      if(var8 != null && var8.hasTag()) {
         this.ac.b(a, var8);
         NBTTagCompound var10 = var8.getTag();
         NBTTagCompound var11 = var10.getCompound("Fireworks");
         if(var11 != null) {
            var9 += var11.getByte("Flight");
         }
      }

      this.v = this.V.nextGaussian() * 0.001D;
      this.x = this.V.nextGaussian() * 0.001D;
      this.motY = 0.05D;
      this.c = 10 * var9 + this.V.nextInt(6) + this.V.nextInt(7);
   }

   public void t_() {
      this.P = this.s;
      this.Q = this.t;
      this.R = this.u;
      super.t_();
      this.v *= 1.15D;
      this.x *= 1.15D;
      this.motY += 0.04D;
      this.d(this.v, this.motY, this.x);
      float var1 = MathHelper.sqrt(this.v * this.v + this.x * this.x);
      this.y = (float)(MathHelper.b(this.v, this.x) * 180.0D / 3.1415927410125732D);

      for(this.z = (float)(MathHelper.b(this.motY, (double)var1) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
         ;
      }

      while(this.z - this.B >= 180.0F) {
         this.B += 360.0F;
      }

      while(this.y - this.A < -180.0F) {
         this.A -= 360.0F;
      }

      while(this.y - this.A >= 180.0F) {
         this.A += 360.0F;
      }

      this.z = this.B + (this.z - this.B) * 0.2F;
      this.y = this.A + (this.y - this.A) * 0.2F;
      if(this.b == 0 && !this.R()) {
         this.o.a((Entity)this, "fireworks.launch", 3.0F, 1.0F);
      }

      ++this.b;
      if(this.o.isClientSide && this.b % 2 < 2) {
         this.o.a(class_cy.d, this.s, this.t - 0.3D, this.u, this.V.nextGaussian() * 0.05D, -this.motY * 0.5D, this.V.nextGaussian() * 0.05D, new int[0]);
      }

      if(!this.o.isClientSide && this.b > this.c) {
         this.o.a((Entity)this, (byte)17);
         this.J();
      }

   }

   public void b(NBTTagCompound var1) {
      var1.put("Life", this.b);
      var1.put("LifeTime", this.c);
      ItemStack var2 = this.ac.f(a);
      if(var2 != null) {
         NBTTagCompound var3 = new NBTTagCompound();
         var2.write(var3);
         var1.put((String)"FireworksItem", (NBTTag)var3);
      }

   }

   public void a(NBTTagCompound var1) {
      this.b = var1.getInt("Life");
      this.c = var1.getInt("LifeTime");
      NBTTagCompound var2 = var1.getCompound("FireworksItem");
      if(var2 != null) {
         ItemStack var3 = ItemStack.a(var2);
         if(var3 != null) {
            this.ac.b(a, var3);
         }
      }

   }

   public float c(float var1) {
      return super.c(var1);
   }

   public boolean aF() {
      return false;
   }
}
