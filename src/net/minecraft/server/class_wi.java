package net.minecraft.server;

import net.minecraft.server.class_adk;
import net.minecraft.server.World;
import net.minecraft.server.class_aet;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_om;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_wd;
import net.minecraft.server.class_wl;

public abstract class class_wi extends class_qh implements class_wd {
   public class_wi(World var1) {
      super(var1);
      this.b_ = 5;
   }

   public void m() {
      this.bx();
      float var1 = this.c(1.0F);
      if(var1 > 0.5F) {
         this.aT += 2;
      }

      super.m();
   }

   public void t_() {
      super.t_();
      if(!this.o.D && this.o.ab() == class_om.a) {
         this.J();
      }

   }

   protected String P() {
      return "game.hostile.swim";
   }

   protected String aa() {
      return "game.hostile.swim.splash";
   }

   public boolean a(class_pc var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else if(super.a(var1, var2)) {
         class_pr var3 = var1.j();
         return this.l != var3 && this.m != var3?true:true;
      } else {
         return false;
      }
   }

   protected String bp() {
      return "game.hostile.hurt";
   }

   protected String bq() {
      return "game.hostile.die";
   }

   protected String k(int var1) {
      return var1 > 4?"game.hostile.hurt.fall.big":"game.hostile.hurt.fall.small";
   }

   public boolean r(class_pr var1) {
      float var2 = (float)this.a(class_wl.e).e();
      int var3 = 0;
      if(var1 instanceof class_qa) {
         var2 += class_adk.a(this.bA(), ((class_qa)var1).bz());
         var3 += class_adk.a((class_qa)this);
      }

      boolean var4 = var1.a(class_pc.a((class_qa)this), var2);
      if(var4) {
         if(var3 > 0) {
            var1.g((double)(-MathHelper.sin(this.y * 3.1415927F / 180.0F) * (float)var3 * 0.5F), 0.1D, (double)(MathHelper.cos(this.y * 3.1415927F / 180.0F) * (float)var3 * 0.5F));
            this.v *= 0.6D;
            this.x *= 0.6D;
         }

         int var5 = class_adk.b(this);
         if(var5 > 0) {
            var1.f(var5 * 4);
         }

         this.a(this, var1);
      }

      return var4;
   }

   public float a(BlockPosition var1) {
      return 0.5F - this.o.o(var1);
   }

   protected boolean n_() {
      BlockPosition var1 = new BlockPosition(this.s, this.aT().b, this.u);
      if(this.o.b(class_aet.a, var1) > this.V.nextInt(32)) {
         return false;
      } else {
         int var2 = this.o.l(var1);
         if(this.o.S()) {
            int var3 = this.o.ac();
            this.o.c(10);
            var2 = this.o.l(var1);
            this.o.c(var3);
         }

         return var2 <= this.V.nextInt(8);
      }
   }

   public boolean cf() {
      return this.o.ab() != class_om.a && this.n_() && super.cf();
   }

   protected void aY() {
      super.aY();
      this.by().b(class_wl.e);
   }

   protected boolean bb() {
      return true;
   }
}
