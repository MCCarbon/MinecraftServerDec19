package net.minecraft.server;

import net.minecraft.server.class_awg;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;

public class class_awf {
   public final double a;
   public final double b;
   public final double c;
   public final double d;
   public final double e;
   public final double f;

   public class_awf(double var1, double var3, double var5, double var7, double var9, double var11) {
      this.a = Math.min(var1, var7);
      this.b = Math.min(var3, var9);
      this.c = Math.min(var5, var11);
      this.d = Math.max(var1, var7);
      this.e = Math.max(var3, var9);
      this.f = Math.max(var5, var11);
   }

   public class_awf(BlockPosition var1) {
      this.a = (double)var1.getX();
      this.b = (double)var1.getY();
      this.c = (double)var1.getZ();
      this.d = (double)(var1.getX() + 1);
      this.e = (double)(var1.getY() + 1);
      this.f = (double)(var1.getZ() + 1);
   }

   public class_awf(BlockPosition var1, BlockPosition var2) {
      this.a = (double)var1.getX();
      this.b = (double)var1.getY();
      this.c = (double)var1.getZ();
      this.d = (double)var2.getX();
      this.e = (double)var2.getY();
      this.f = (double)var2.getZ();
   }

   public class_awf a(double var1, double var3, double var5) {
      double var7 = this.a;
      double var9 = this.b;
      double var11 = this.c;
      double var13 = this.d;
      double var15 = this.e;
      double var17 = this.f;
      if(var1 < 0.0D) {
         var7 += var1;
      } else if(var1 > 0.0D) {
         var13 += var1;
      }

      if(var3 < 0.0D) {
         var9 += var3;
      } else if(var3 > 0.0D) {
         var15 += var3;
      }

      if(var5 < 0.0D) {
         var11 += var5;
      } else if(var5 > 0.0D) {
         var17 += var5;
      }

      return new class_awf(var7, var9, var11, var13, var15, var17);
   }

   public class_awf b(double var1, double var3, double var5) {
      double var7 = this.a - var1;
      double var9 = this.b - var3;
      double var11 = this.c - var5;
      double var13 = this.d + var1;
      double var15 = this.e + var3;
      double var17 = this.f + var5;
      return new class_awf(var7, var9, var11, var13, var15, var17);
   }

   public class_awf a(class_awf var1) {
      double var2 = Math.min(this.a, var1.a);
      double var4 = Math.min(this.b, var1.b);
      double var6 = Math.min(this.c, var1.c);
      double var8 = Math.max(this.d, var1.d);
      double var10 = Math.max(this.e, var1.e);
      double var12 = Math.max(this.f, var1.f);
      return new class_awf(var2, var4, var6, var8, var10, var12);
   }

   public static class_awf a(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = Math.min(var0, var6);
      double var14 = Math.min(var2, var8);
      double var16 = Math.min(var4, var10);
      double var18 = Math.max(var0, var6);
      double var20 = Math.max(var2, var8);
      double var22 = Math.max(var4, var10);
      return new class_awf(var12, var14, var16, var18, var20, var22);
   }

   public class_awf c(double var1, double var3, double var5) {
      return new class_awf(this.a + var1, this.b + var3, this.c + var5, this.d + var1, this.e + var3, this.f + var5);
   }

   public double a(class_awf var1, double var2) {
      if(var1.e > this.b && var1.b < this.e && var1.f > this.c && var1.c < this.f) {
         double var4;
         if(var2 > 0.0D && var1.d <= this.a) {
            var4 = this.a - var1.d;
            if(var4 < var2) {
               var2 = var4;
            }
         } else if(var2 < 0.0D && var1.a >= this.d) {
            var4 = this.d - var1.a;
            if(var4 > var2) {
               var2 = var4;
            }
         }

         return var2;
      } else {
         return var2;
      }
   }

   public double b(class_awf var1, double var2) {
      if(var1.d > this.a && var1.a < this.d && var1.f > this.c && var1.c < this.f) {
         double var4;
         if(var2 > 0.0D && var1.e <= this.b) {
            var4 = this.b - var1.e;
            if(var4 < var2) {
               var2 = var4;
            }
         } else if(var2 < 0.0D && var1.b >= this.e) {
            var4 = this.e - var1.b;
            if(var4 > var2) {
               var2 = var4;
            }
         }

         return var2;
      } else {
         return var2;
      }
   }

   public double c(class_awf var1, double var2) {
      if(var1.d > this.a && var1.a < this.d && var1.e > this.b && var1.b < this.e) {
         double var4;
         if(var2 > 0.0D && var1.f <= this.c) {
            var4 = this.c - var1.f;
            if(var4 < var2) {
               var2 = var4;
            }
         } else if(var2 < 0.0D && var1.c >= this.f) {
            var4 = this.f - var1.c;
            if(var4 > var2) {
               var2 = var4;
            }
         }

         return var2;
      } else {
         return var2;
      }
   }

   public boolean b(class_awf var1) {
      return var1.d > this.a && var1.a < this.d?(var1.e > this.b && var1.b < this.e?var1.f > this.c && var1.c < this.f:false):false;
   }

   public boolean a(Vec3D var1) {
      return var1.x > this.a && var1.x < this.d?(var1.y > this.b && var1.y < this.e?var1.z > this.c && var1.z < this.f:false):false;
   }

   public double a() {
      double var1 = this.d - this.a;
      double var3 = this.e - this.b;
      double var5 = this.f - this.c;
      return (var1 + var3 + var5) / 3.0D;
   }

   public class_awf d(double var1, double var3, double var5) {
      double var7 = this.a + var1;
      double var9 = this.b + var3;
      double var11 = this.c + var5;
      double var13 = this.d - var1;
      double var15 = this.e - var3;
      double var17 = this.f - var5;
      return new class_awf(var7, var9, var11, var13, var15, var17);
   }

   public class_awg a(Vec3D var1, Vec3D var2) {
      Vec3D var3 = var1.getIntermediateWithXValue(var2, this.a);
      Vec3D var4 = var1.getIntermediateWithXValue(var2, this.d);
      Vec3D var5 = var1.getIntermediateWithYValue(var2, this.b);
      Vec3D var6 = var1.getIntermediateWithYValue(var2, this.e);
      Vec3D var7 = var1.getIntermediateWithZValue(var2, this.c);
      Vec3D var8 = var1.getIntermediateWithZValue(var2, this.f);
      if(!this.b(var3)) {
         var3 = null;
      }

      if(!this.b(var4)) {
         var4 = null;
      }

      if(!this.c(var5)) {
         var5 = null;
      }

      if(!this.c(var6)) {
         var6 = null;
      }

      if(!this.d(var7)) {
         var7 = null;
      }

      if(!this.d(var8)) {
         var8 = null;
      }

      Vec3D var9 = null;
      if(var3 != null) {
         var9 = var3;
      }

      if(var4 != null && (var9 == null || var1.distanceSquared(var4) < var1.distanceSquared(var9))) {
         var9 = var4;
      }

      if(var5 != null && (var9 == null || var1.distanceSquared(var5) < var1.distanceSquared(var9))) {
         var9 = var5;
      }

      if(var6 != null && (var9 == null || var1.distanceSquared(var6) < var1.distanceSquared(var9))) {
         var9 = var6;
      }

      if(var7 != null && (var9 == null || var1.distanceSquared(var7) < var1.distanceSquared(var9))) {
         var9 = var7;
      }

      if(var8 != null && (var9 == null || var1.distanceSquared(var8) < var1.distanceSquared(var9))) {
         var9 = var8;
      }

      if(var9 == null) {
         return null;
      } else {
         EnumDirection var10 = null;
         if(var9 == var3) {
            var10 = EnumDirection.WEST;
         } else if(var9 == var4) {
            var10 = EnumDirection.EAST;
         } else if(var9 == var5) {
            var10 = EnumDirection.DOWN;
         } else if(var9 == var6) {
            var10 = EnumDirection.UP;
         } else if(var9 == var7) {
            var10 = EnumDirection.NORTH;
         } else {
            var10 = EnumDirection.SOUTH;
         }

         return new class_awg(var9, var10);
      }
   }

   private boolean b(Vec3D var1) {
      return var1 == null?false:var1.y >= this.b && var1.y <= this.e && var1.z >= this.c && var1.z <= this.f;
   }

   private boolean c(Vec3D var1) {
      return var1 == null?false:var1.x >= this.a && var1.x <= this.d && var1.z >= this.c && var1.z <= this.f;
   }

   private boolean d(Vec3D var1) {
      return var1 == null?false:var1.x >= this.a && var1.x <= this.d && var1.y >= this.b && var1.y <= this.e;
   }

   public String toString() {
      return "box[" + this.a + ", " + this.b + ", " + this.c + " -> " + this.d + ", " + this.e + ", " + this.f + "]";
   }
}