package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_apc;
import net.minecraft.server.class_apd;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.Datawathcer;
import net.minecraft.server.class_ur;

public class class_uq extends Entity {
   public int a;
   public int b;
   private static final int c = Datawathcer.claimId(class_uq.class);

   public class_uq(World var1) {
      super(var1);
      this.k = true;
      this.a(2.0F, 2.0F);
      this.b = 5;
      this.a = this.random.nextInt(100000);
   }

   protected boolean s_() {
      return false;
   }

   protected void h() {
      this.datawatcher.add(c, Integer.valueOf(this.b));
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      ++this.a;
      this.datawatcher.update(c, Integer.valueOf(this.b));
      if(!this.o.isClientSide) {
         BlockPosition var1 = new BlockPosition(this);
         if(this.o.worldProvider instanceof class_apd && this.o.getType(var1).getBlock() != Blocks.FIRE) {
            this.o.setTypeUpdate(var1, Blocks.FIRE.getBlockData());
         }
      }

   }

   protected void write(NBTTagCompound var1) {
   }

   protected void read(NBTTagCompound var1) {
   }

   public boolean ad() {
      return true;
   }

   public boolean damageEntity(class_pc var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else if(var1.j() instanceof class_ur) {
         return false;
      } else {
         if(!this.I && !this.o.isClientSide) {
            this.b = 0;
            this.J();
            if(!this.o.isClientSide) {
               this.o.a((Entity)null, this.s, this.t, this.u, 6.0F, true);
               if(this.o.worldProvider instanceof class_apd) {
                  class_apd var3 = (class_apd)this.o.worldProvider;
                  class_apc var4 = var3.s();
                  if(var4 != null) {
                     var4.a(this, var1);
                  }
               }
            }
         }

         return true;
      }
   }
}
