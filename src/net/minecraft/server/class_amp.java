package net.minecraft.server;

import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.ITickAble;
import net.minecraft.server.class_xa;

public class class_amp extends class_amg implements ITickAble {
   public float a;
   public float f;
   public int g;
   private int h;

   public void tick() {
      if(++this.h % 20 * 4 == 0) {
         this.b.c(this.c, Blocks.ENDER_CHEST, 1, this.g);
      }

      this.f = this.a;
      int var1 = this.c.getX();
      int var2 = this.c.getY();
      int var3 = this.c.getZ();
      float var4 = 0.1F;
      double var7;
      if(this.g > 0 && this.a == 0.0F) {
         double var5 = (double)var1 + 0.5D;
         var7 = (double)var3 + 0.5D;
         this.b.a(var5, (double)var2 + 0.5D, var7, "random.chestopen", 0.5F, this.b.s.nextFloat() * 0.1F + 0.9F);
      }

      if(this.g == 0 && this.a > 0.0F || this.g > 0 && this.a < 1.0F) {
         float var11 = this.a;
         if(this.g > 0) {
            this.a += var4;
         } else {
            this.a -= var4;
         }

         if(this.a > 1.0F) {
            this.a = 1.0F;
         }

         float var6 = 0.5F;
         if(this.a < var6 && var11 >= var6) {
            var7 = (double)var1 + 0.5D;
            double var9 = (double)var3 + 0.5D;
            this.b.a(var7, (double)var2 + 0.5D, var9, "random.chestclosed", 0.5F, this.b.s.nextFloat() * 0.1F + 0.9F);
         }

         if(this.a < 0.0F) {
            this.a = 0.0F;
         }
      }

   }

   public boolean c(int var1, int var2) {
      if(var1 == 1) {
         this.g = var2;
         return true;
      } else {
         return super.c(var1, var2);
      }
   }

   public void y() {
      this.E();
      super.y();
   }

   public void b() {
      ++this.g;
      this.b.c(this.c, Blocks.ENDER_CHEST, 1, this.g);
   }

   public void d() {
      --this.g;
      this.b.c(this.c, Blocks.ENDER_CHEST, 1, this.g);
   }

   public boolean a(class_xa var1) {
      return this.b.s(this.c) != this?false:var1.e((double)this.c.getX() + 0.5D, (double)this.c.getY() + 0.5D, (double)this.c.getZ() + 0.5D) <= 64.0D;
   }
}
