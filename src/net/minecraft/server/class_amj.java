package net.minecraft.server;

import net.minecraft.server.class_aed;
import net.minecraft.server.World;
import net.minecraft.server.class_amg;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ft;
import net.minecraft.server.class_n;
import net.minecraft.server.class_pr;

public class class_amj extends class_amg {
   private final class_aed a = new class_aed() {
      public BlockPosition c() {
         return class_amj.this.c;
      }

      public Vec3D d() {
         return new Vec3D((double)class_amj.this.c.getX() + 0.5D, (double)class_amj.this.c.getY() + 0.5D, (double)class_amj.this.c.getZ() + 0.5D);
      }

      public World e() {
         return class_amj.this.z();
      }

      public void a(String var1) {
         super.a(var1);
         class_amj.this.p_();
      }

      public void h() {
         class_amj.this.z().h(class_amj.this.c);
      }

      public class_pr f() {
         return null;
      }
   };

   public void b(class_dn var1) {
      super.b(var1);
      this.a.a(var1);
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.a.b(var1);
   }

   public class_ff z_() {
      class_dn var1 = new class_dn();
      this.b(var1);
      return new class_ft(this.c, 2, var1);
   }

   public boolean F() {
      return true;
   }

   public class_aed b() {
      return this.a;
   }

   public class_n c() {
      return this.a.n();
   }
}
