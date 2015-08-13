package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_ari extends WorldGenerator {
   private class_ari.class_a_in_class_ari a = null;

   public void a(class_ari.class_a_in_class_ari var1) {
      this.a = var1;
   }

   public boolean generate(World var1, Random var2, BlockPosition var3) {
      if(this.a == null) {
         throw new IllegalStateException("Decoration requires priming with a spike");
      } else {
         Iterator var4 = BlockPosition.allInCubeM(var3.add(-this.a.c(), -10, -this.a.c()), var3.add(this.a.c(), this.a.d() - 1, this.a.c())).iterator();

         while(var4.hasNext()) {
            BlockPosition.MutableBlockPosition var5 = (BlockPosition.MutableBlockPosition)var4.next();
            if(var5.distanceSquared((double)var3.getX(), (double)var5.getY(), (double)var3.getZ()) <= (double)(this.a.c() * this.a.c() + 1)) {
               this.setTypeAndData(var1, var5, Blocks.OBSIDIAN.getBlockData());
            }
         }

         if(this.a.e()) {
            for(int var6 = -2; var6 <= 2; ++var6) {
               for(int var8 = -2; var8 <= 2; ++var8) {
                  if(MathHelper.abs(var6) == 2 || MathHelper.abs(var8) == 2) {
                     this.setTypeAndData(var1, var3.add(var6, this.a.d(), var8), Blocks.IRON_BARS.getBlockData());
                     this.setTypeAndData(var1, var3.add(var6, this.a.d() + 1, var8), Blocks.IRON_BARS.getBlockData());
                     this.setTypeAndData(var1, var3.add(var6, this.a.d() + 2, var8), Blocks.IRON_BARS.getBlockData());
                  }

                  this.setTypeAndData(var1, var3.add(var6, this.a.d() + 3, var8), Blocks.IRON_BARS.getBlockData());
               }
            }
         }

         EntityEnderCrystal var7 = new EntityEnderCrystal(var1);
         var7.setPositionRotation((double) ((float) var3.getX() + 0.5F), (double) (var3.getY() + this.a.d() + 1), (double) ((float) var3.getZ() + 0.5F), var2.nextFloat() * 360.0F, 0.0F);
         var1.addEntity((Entity)var7);
         this.setTypeAndData(var1, var3.up(this.a.d()), Blocks.BEDROCK.getBlockData());
         return true;
      }
   }

   public static class class_a_in_class_ari {
      private final int a;
      private final int b;
      private final int c;
      private final int d;
      private final boolean e;
      private final AxisAlignedBB f;

      public class_a_in_class_ari(int var1, int var2, int var3, int var4, boolean var5) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = new AxisAlignedBB((double)(var1 - var3), 0.0D, (double)(var2 - var3), (double)(var1 + var3), 256.0D, (double)(var2 + var3));
      }

      public boolean a(BlockPosition var1) {
         int var2 = this.a - this.c;
         int var3 = this.b - this.c;
         return var1.getX() == (var2 & -16) && var1.getZ() == (var3 & -16);
      }

      public int a() {
         return this.a;
      }

      public int b() {
         return this.b;
      }

      public int c() {
         return this.c;
      }

      public int d() {
         return this.d;
      }

      public boolean e() {
         return this.e;
      }

      public AxisAlignedBB f() {
         return this.f;
      }
   }
}
