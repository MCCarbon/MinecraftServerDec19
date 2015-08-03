package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_tx;
import net.minecraft.server.class_xo;

public class class_xp extends class_xo {
   public class_xp(World var1) {
      super(var1);
   }

   public class_xp(World var1, EntityLiving var2) {
      super(var1, var2);
   }

   public class_xp(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected void a(MovingObjectPosition var1) {
      if(var1.d != null) {
         var1.d.damageEntity(class_pc.a((Entity)this, (Entity)this.l()), 0.0F);
      }

      if(!this.o.isClientSide && this.random.nextInt(8) == 0) {
         byte var2 = 1;
         if(this.random.nextInt(32) == 0) {
            var2 = 4;
         }

         for(int var3 = 0; var3 < var2; ++var3) {
            class_tx var4 = new class_tx(this.o);
            var4.b(-24000);
            var4.b(this.s, this.t, this.u, this.y, 0.0F);
            this.o.addEntity((Entity)var4);
         }
      }

      double var5 = 0.08D;

      for(int var6 = 0; var6 < 8; ++var6) {
         this.o.a(class_cy.K, this.s, this.t, this.u, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, new int[]{Item.getId(Items.aR)});
      }

      if(!this.o.isClientSide) {
         this.J();
      }

   }
}
