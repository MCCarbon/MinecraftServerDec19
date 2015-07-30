package net.minecraft.server;

import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_pr;

public class class_awg {
   private BlockPosition e;
   public class_awg.class_a_in_class_awg a;
   public EnumDirection b;
   public Vec3D c;
   public class_pr d;

   public class_awg(Vec3D var1, EnumDirection var2, BlockPosition var3) {
      this(class_awg.class_a_in_class_awg.b, var1, var2, var3);
   }

   public class_awg(Vec3D var1, EnumDirection var2) {
      this(class_awg.class_a_in_class_awg.b, var1, var2, BlockPosition.ZERO);
   }

   public class_awg(class_pr var1) {
      this(var1, new Vec3D(var1.s, var1.t, var1.u));
   }

   public class_awg(class_awg.class_a_in_class_awg var1, Vec3D var2, EnumDirection var3, BlockPosition var4) {
      this.a = var1;
      this.e = var4;
      this.b = var3;
      this.c = new Vec3D(var2.x, var2.y, var2.z);
   }

   public class_awg(class_pr var1, Vec3D var2) {
      this.a = class_awg.class_a_in_class_awg.c;
      this.d = var1;
      this.c = var2;
   }

   public BlockPosition a() {
      return this.e;
   }

   public String toString() {
      return "HitResult{type=" + this.a + ", blockpos=" + this.e + ", f=" + this.b + ", pos=" + this.c + ", entity=" + this.d + '}';
   }

   public static enum class_a_in_class_awg {
      a,
      b,
      c;
   }
}
