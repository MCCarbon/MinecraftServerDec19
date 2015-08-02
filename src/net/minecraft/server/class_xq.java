package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityEndGateway;
import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_wc;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_xo;

public class class_xq extends class_xo {
   private EntityLiving d;

   public class_xq(World var1) {
      super(var1);
   }

   public class_xq(World var1, EntityLiving var2) {
      super(var1, var2);
      this.d = var2;
   }

   protected void a(MovingObjectPosition var1) {
      EntityLiving var2 = this.l();
      if(var1.d != null) {
         if(var1.d == this.d) {
            return;
         }

         var1.d.damageEntity(class_pc.a((Entity)this, (Entity)var2), 0.0F);
      }

      if(var1.a == MovingObjectPosition.class_a_in_class_awg.b) {
         BlockPosition var3 = var1.a();
         TileEntity var4 = this.o.getTileEntity(var3);
         if(var4 instanceof TileEntityEndGateway) {
            TileEntityEndGateway var5 = (TileEntityEndGateway)var4;
            if(var2 != null) {
               var5.a((Entity)var2);
               this.J();
               return;
            }

            var5.a((Entity)this);
            return;
         }
      }

      for(int var6 = 0; var6 < 32; ++var6) {
         this.o.a(class_cy.y, this.s, this.t + this.random.nextDouble() * 2.0D, this.u, this.random.nextGaussian(), 0.0D, this.random.nextGaussian(), new int[0]);
      }

      if(!this.o.isClientSide) {
         if(var2 instanceof EntityPlayer) {
            EntityPlayer var7 = (EntityPlayer)var2;
            if(var7.a.a().isActive() && var7.o == this.o && !var7.isSleeping()) {
               if(this.random.nextFloat() < 0.05F && this.o.R().b("doMobSpawning")) {
                  class_wc var8 = new class_wc(this.o);
                  var8.a(true);
                  var8.b(var2.s, var2.t, var2.u, var2.y, var2.z);
                  this.o.addEntity((Entity)var8);
               }

               if(var2.aw()) {
                  var2.a((Entity)null);
               }

               var2.a(this.s, this.t, this.u);
               var2.O = 0.0F;
               var2.damageEntity(class_pc.i, 5.0F);
            }
         } else if(var2 != null) {
            var2.a(this.s, this.t, this.u);
            var2.O = 0.0F;
         }

         this.J();
      }

   }

   public void t_() {
      EntityLiving var1 = this.l();
      if(var1 != null && var1 instanceof EntityHuman && !var1.isAlive()) {
         this.J();
      } else {
         super.t_();
      }

   }
}
