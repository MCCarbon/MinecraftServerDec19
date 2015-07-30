package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aed;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_xa;

public class class_vp extends class_vn {
   private static final int a = class_qi.a(class_vp.class);
   private static final int b = class_qi.a(class_vp.class);
   private final class_aed c = new class_aed() {
      public void h() {
         class_vp.this.H().b(class_vp.a, this.l());
         class_vp.this.H().b(class_vp.b, IChatBaseComponent.class_a_in_class_eu.a(this.k()));
      }

      public BlockPosition c() {
         return new BlockPosition(class_vp.this.s, class_vp.this.t + 0.5D, class_vp.this.u);
      }

      public Vec3D d() {
         return new Vec3D(class_vp.this.s, class_vp.this.t, class_vp.this.u);
      }

      public World e() {
         return class_vp.this.o;
      }

      public class_pr f() {
         return class_vp.this;
      }
   };
   private int d = 0;

   public class_vp(World var1) {
      super(var1);
   }

   public class_vp(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected void h() {
      super.h();
      this.H().a(a, "");
      this.H().a(b, "");
   }

   protected void a(class_dn var1) {
      super.a(var1);
      this.c.b(var1);
      this.H().b(a, this.j().l());
      this.H().b(b, IChatBaseComponent.class_a_in_class_eu.a(this.j().k()));
   }

   protected void b(class_dn var1) {
      super.b(var1);
      this.c.a(var1);
   }

   public class_vn.class_a_in_class_vn s() {
      return class_vn.class_a_in_class_vn.g;
   }

   public IBlockData u() {
      return Blocks.COMMAND_BLOCK.getBlockData();
   }

   public class_aed j() {
      return this.c;
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      if(var4 && this.W - this.d >= 4) {
         this.j().a(this.o);
         this.d = this.W;
      }

   }

   public boolean a(class_xa var1, class_aas var2, EnumUsedHand var3) {
      this.c.a(var1);
      return false;
   }

   public void d(int var1) {
      super.d(var1);
      if(var1 == b) {
         try {
            this.c.b(IChatBaseComponent.class_a_in_class_eu.a(this.H().e(b)));
         } catch (Throwable var3) {
            ;
         }
      } else if(var1 == a) {
         this.c.a(this.H().e(a));
      }

   }
}
