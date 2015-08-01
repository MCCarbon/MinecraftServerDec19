package net.minecraft.server;

import java.util.UUID;
import net.minecraft.server.World;
import net.minecraft.server.class_awp;
import net.minecraft.server.class_cy;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_ly;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qg;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_so;
import net.minecraft.server.class_tw;

public abstract class class_qj extends class_tw implements class_qg {
   protected static final int bs = class_qi.a(class_qj.class);
   protected static final int bt = class_qi.a(class_qj.class);
   protected class_so bu = new class_so(this);

   public class_qj(World var1) {
      super(var1);
      this.cB();
   }

   protected void h() {
      super.h();
      this.ac.a(bs, Byte.valueOf((byte)0));
      this.ac.a(bt, "");
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      if(this.b() == null) {
         var1.put("OwnerUUID", "");
      } else {
         var1.put("OwnerUUID", this.b());
      }

      var1.put("Sitting", this.cC());
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      String var2 = "";
      if(var1.hasOfType("OwnerUUID", 8)) {
         var2 = var1.getString("OwnerUUID");
      } else {
         String var3 = var1.getString("Owner");
         var2 = class_ly.a(var3);
      }

      if(!var2.isEmpty()) {
         this.b(var2);
         this.n(true);
      }

      this.bu.a(var1.getBoolean("Sitting"));
      this.o(var1.getBoolean("Sitting"));
   }

   protected void m(boolean var1) {
      class_cy var2 = class_cy.I;
      if(!var1) {
         var2 = class_cy.l;
      }

      for(int var3 = 0; var3 < 7; ++var3) {
         double var4 = this.V.nextGaussian() * 0.02D;
         double var6 = this.V.nextGaussian() * 0.02D;
         double var8 = this.V.nextGaussian() * 0.02D;
         this.o.a(var2, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, var4, var6, var8, new int[0]);
      }

   }

   public boolean cA() {
      return (this.ac.a(bs) & 4) != 0;
   }

   public void n(boolean var1) {
      byte var2 = this.ac.a(bs);
      if(var1) {
         this.ac.b(bs, Byte.valueOf((byte)(var2 | 4)));
      } else {
         this.ac.b(bs, Byte.valueOf((byte)(var2 & -5)));
      }

      this.cB();
   }

   protected void cB() {
   }

   public boolean cC() {
      return (this.ac.a(bs) & 1) != 0;
   }

   public void o(boolean var1) {
      byte var2 = this.ac.a(bs);
      if(var1) {
         this.ac.b(bs, Byte.valueOf((byte)(var2 | 1)));
      } else {
         this.ac.b(bs, Byte.valueOf((byte)(var2 & -2)));
      }

   }

   public String b() {
      return this.ac.e(bt);
   }

   public void b(String var1) {
      this.ac.b(bt, var1);
   }

   public EntityLiving cD() {
      try {
         UUID var1 = UUID.fromString(this.b());
         return var1 == null?null:this.o.b(var1);
      } catch (IllegalArgumentException var2) {
         return null;
      }
   }

   public boolean e(EntityLiving var1) {
      return var1 == this.cD();
   }

   public class_so cE() {
      return this.bu;
   }

   public boolean a(EntityLiving var1, EntityLiving var2) {
      return true;
   }

   public class_awp bP() {
      if(this.cA()) {
         EntityLiving var1 = this.cD();
         if(var1 != null) {
            return var1.bP();
         }
      }

      return super.bP();
   }

   public boolean c(EntityLiving var1) {
      if(this.cA()) {
         EntityLiving var2 = this.cD();
         if(var1 == var2) {
            return true;
         }

         if(var2 != null) {
            return var2.c(var1);
         }
      }

      return super.c(var1);
   }

   public void a(class_pc var1) {
      if(!this.o.isClientSide && this.o.R().b("showDeathMessages") && this.hasCustomName() && this.cD() instanceof EntityPlayer) {
         ((EntityPlayer)this.cD()).a(this.bt().b());
      }

      super.a((class_pc)var1);
   }

   // $FF: synthetic method
   public Entity m_() {
      return this.cD();
   }
}
