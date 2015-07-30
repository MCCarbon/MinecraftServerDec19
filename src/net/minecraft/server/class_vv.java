package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aej;
import net.minecraft.server.World;
import net.minecraft.server.class_agf;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_xd;

public class class_vv extends class_vn {
   private int a = -1;

   public class_vv(World var1) {
      super(var1);
   }

   public class_vv(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public class_vn.class_a_in_class_vn s() {
      return class_vn.class_a_in_class_vn.d;
   }

   public IBlockData u() {
      return Blocks.TNT.getBlockData();
   }

   public void t_() {
      super.t_();
      if(this.a > 0) {
         --this.a;
         this.o.a(class_cy.l, this.s, this.t + 0.5D, this.u, 0.0D, 0.0D, 0.0D, new int[0]);
      } else if(this.a == 0) {
         this.b(this.v * this.v + this.x * this.x);
      }

      if(this.D) {
         double var1 = this.v * this.v + this.x * this.x;
         if(var1 >= 0.009999999776482582D) {
            this.b(var1);
         }
      }

   }

   public boolean a(class_pc var1, float var2) {
      class_pr var3 = var1.i();
      if(var3 instanceof class_xd) {
         class_xd var4 = (class_xd)var3;
         if(var4.av()) {
            this.b(var4.v * var4.v + var4.w * var4.w + var4.x * var4.x);
         }
      }

      return super.a(var1, var2);
   }

   public void a(class_pc var1) {
      super.a(var1);
      double var2 = this.v * this.v + this.x * this.x;
      if(!var1.c() && this.o.R().b("doEntityDrops")) {
         this.a(new class_aas(Blocks.TNT, 1), 0.0F);
      }

      if(var1.o() || var1.c() || var2 >= 0.009999999776482582D) {
         this.b(var2);
      }

   }

   protected void b(double var1) {
      if(!this.o.D) {
         double var3 = Math.sqrt(var1);
         if(var3 > 5.0D) {
            var3 = 5.0D;
         }

         this.o.a(this, this.s, this.t, this.u, (float)(4.0D + this.V.nextDouble() * 1.5D * var3), true);
         this.J();
      }

   }

   public void e(float var1, float var2) {
      if(var1 >= 3.0F) {
         float var3 = var1 / 10.0F;
         this.b((double)(var3 * var3));
      }

      super.e(var1, var2);
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      if(var4 && this.a < 0) {
         this.j();
      }

   }

   public void j() {
      this.a = 80;
      if(!this.o.D) {
         this.o.a((class_pr)this, (byte)10);
         if(!this.R()) {
            this.o.a((class_pr)this, "game.tnt.primed", 1.0F, 1.0F);
         }
      }

   }

   public boolean y() {
      return this.a > -1;
   }

   public float a(class_aej var1, World var2, BlockPosition var3, IBlockData var4) {
      return !this.y() || !class_agf.d(var4) && !class_agf.e(var2, var3.shiftUp())?super.a(var1, var2, var3, var4):0.0F;
   }

   public boolean a(class_aej var1, World var2, BlockPosition var3, IBlockData var4, float var5) {
      return !this.y() || !class_agf.d(var4) && !class_agf.e(var2, var3.shiftUp())?super.a(var1, var2, var3, var4, var5):false;
   }

   protected void a(class_dn var1) {
      super.a(var1);
      if(var1.b("TNTFuse", 99)) {
         this.a = var1.g("TNTFuse");
      }

   }

   protected void b(class_dn var1) {
      super.b(var1);
      var1.a("TNTFuse", this.a);
   }
}
