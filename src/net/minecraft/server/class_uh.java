package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_sh;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sj;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_ua;
import net.minecraft.server.class_wd;
import net.minecraft.server.class_wk;
import net.minecraft.server.class_wl;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_xm;

public class class_uh extends class_ua implements class_wk {
   public class_uh(World var1) {
      super(var1);
      this.a(0.7F, 1.9F);
      ((class_tf)this.u()).a(true);
      this.i.a(1, new class_sj(this, 1.25D, 20, 10.0F));
      this.i.a(2, new class_si(this, 1.0D));
      this.i.a(3, new class_rr(this, EntityHuman.class, 6.0F));
      this.i.a(4, new class_sh(this));
      this.bn.a(1, new class_sz(this, class_qb.class, 10, true, false, class_wd.d));
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(4.0D);
      this.a(class_wl.d).a(0.20000000298023224D);
   }

   public void m() {
      super.m();
      if(!this.o.isClientSide) {
         int var1 = MathHelper.floor(this.s);
         int var2 = MathHelper.floor(this.t);
         int var3 = MathHelper.floor(this.u);
         if(this.U()) {
            this.a(class_pc.f, 1.0F);
         }

         if(this.o.b(new BlockPosition(var1, 0, var3)).a(new BlockPosition(var1, var2, var3)) > 1.0F) {
            this.a(class_pc.c, 1.0F);
         }

         for(int var4 = 0; var4 < 4; ++var4) {
            var1 = MathHelper.floor(this.s + (double)((float)(var4 % 2 * 2 - 1) * 0.25F));
            var2 = MathHelper.floor(this.t);
            var3 = MathHelper.floor(this.u + (double)((float)(var4 / 2 % 2 * 2 - 1) * 0.25F));
            BlockPosition var5 = new BlockPosition(var1, var2, var3);
            if(this.o.getType(var5).getBlock().getMaterial() == Material.AIR && this.o.b(new BlockPosition(var1, 0, var3)).a(var5) < 0.8F && BlockStainedGlassPane.SNOW_LAYER.canPlace(this.o, var5)) {
               this.o.setTypeUpdate(var5, BlockStainedGlassPane.SNOW_LAYER.getBlockData());
            }
         }
      }

   }

   protected Item D() {
      return Items.aF;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(16);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.a(Items.aF, 1);
      }

   }

   public void a(EntityLiving var1, float var2) {
      class_xm var3 = new class_xm(this.o, this);
      double var4 = var1.t + (double)var1.aU() - 1.100000023841858D;
      double var6 = var1.s - this.s;
      double var8 = var4 - var3.t;
      double var10 = var1.u - this.u;
      float var12 = MathHelper.sqrt(var6 * var6 + var10 * var10) * 0.2F;
      var3.c(var6, var8 + (double)var12, var10, 1.6F, 12.0F);
      this.a("random.bow", 1.0F, 1.0F / (this.bd().nextFloat() * 0.4F + 0.8F));
      this.o.addEntity((Entity)var3);
   }

   public float aU() {
      return 1.7F;
   }
}
