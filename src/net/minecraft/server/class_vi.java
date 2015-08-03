package net.minecraft.server;

import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_om;
import net.minecraft.server.Entity;
import net.minecraft.server.class_vh;

public class class_vi extends class_vh {
   private int b;
   public long a;
   private int c;

   public class_vi(World var1, double var2, double var4, double var6) {
      super(var1);
      this.b(var2, var4, var6, 0.0F, 0.0F);
      this.b = 2;
      this.a = this.V.nextLong();
      this.c = this.V.nextInt(3) + 1;
      BlockPosition var8 = new BlockPosition(this);
      if(!var1.isClientSide && var1.R().b("doFireTick") && (var1.ab() == class_om.c || var1.ab() == class_om.d) && var1.a((BlockPosition)var8, (int)10)) {
         if(var1.getType(var8).getBlock().getMaterial() == Material.AIR && BlockStainedGlassPane.FIRE.canPlace(var1, var8)) {
            var1.setTypeUpdate(var8, BlockStainedGlassPane.FIRE.getBlockData());
         }

         for(int var9 = 0; var9 < 4; ++var9) {
            BlockPosition var10 = var8.add(this.V.nextInt(3) - 1, this.V.nextInt(3) - 1, this.V.nextInt(3) - 1);
            if(var1.getType(var10).getBlock().getMaterial() == Material.AIR && BlockStainedGlassPane.FIRE.canPlace(var1, var10)) {
               var1.setTypeUpdate(var10, BlockStainedGlassPane.FIRE.getBlockData());
            }
         }
      }

   }

   public void t_() {
      super.t_();
      if(this.b == 2) {
         this.o.a(this.s, this.t, this.u, "ambient.weather.thunder", 10000.0F, 0.8F + this.V.nextFloat() * 0.2F);
         this.o.a(this.s, this.t, this.u, "random.explode", 2.0F, 0.5F + this.V.nextFloat() * 0.2F);
      }

      --this.b;
      if(this.b < 0) {
         if(this.c == 0) {
            this.J();
         } else if(this.b < -this.V.nextInt(10)) {
            --this.c;
            this.b = 1;
            this.a = this.V.nextLong();
            BlockPosition var1 = new BlockPosition(this);
            if(!this.o.isClientSide && this.o.R().b("doFireTick") && this.o.a((BlockPosition)var1, (int)10) && this.o.getType(var1).getBlock().getMaterial() == Material.AIR && BlockStainedGlassPane.FIRE.canPlace(this.o, var1)) {
               this.o.setTypeUpdate(var1, BlockStainedGlassPane.FIRE.getBlockData());
            }
         }
      }

      if(this.b >= 0) {
         if(this.o.isClientSide) {
            this.o.d(2);
         } else {
            double var6 = 3.0D;
            List var3 = this.o.b((Entity)this, (AxisAlignedBB)(new AxisAlignedBB(this.s - var6, this.t - var6, this.u - var6, this.s + var6, this.t + 6.0D + var6, this.u + var6)));

            for(int var4 = 0; var4 < var3.size(); ++var4) {
               Entity var5 = (Entity)var3.get(var4);
               var5.a(this);
            }
         }
      }

   }

   protected void h() {
   }

   protected void a(NBTTagCompound var1) {
   }

   protected void b(NBTTagCompound var1) {
   }
}
