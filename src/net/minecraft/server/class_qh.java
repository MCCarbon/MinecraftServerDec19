package net.minecraft.server;

import java.util.UUID;

public abstract class class_qh extends EntityInsentient {
   public static final UUID bq = UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A");
   public static final class_qm br;
   private BlockPosition a;
   private float b;
   private class_rm c;
   private boolean bs;

   public class_qh(World var1) {
      super(var1);
      this.a = BlockPosition.ZERO;
      this.b = -1.0F;
      this.c = new class_ry(this, 1.0D);
   }

   public float a(BlockPosition var1) {
      return 0.0F;
   }

   public boolean cf() {
      return super.cf() && this.a(new BlockPosition(this.s, this.aT().yMin, this.u)) >= 0.0F;
   }

   public boolean cu() {
      return !this.h.m();
   }

   public boolean cv() {
      return this.e(new BlockPosition(this));
   }

   public boolean e(BlockPosition var1) {
      return this.b == -1.0F?true:this.a.distanceSquared(var1) < (double)(this.b * this.b);
   }

   public void a(BlockPosition var1, int var2) {
      this.a = var1;
      this.b = (float)var2;
   }

   public BlockPosition cw() {
      return this.a;
   }

   public float cx() {
      return this.b;
   }

   public void cy() {
      this.b = -1.0F;
   }

   public boolean cz() {
      return this.b != -1.0F;
   }

   protected void co() {
      super.co();
      if(this.cq() && this.cr() != null && this.cr().o == this.o) {
         Entity var1 = this.cr();
         this.a(new BlockPosition((int)var1.s, (int)var1.t, (int)var1.u), 5);
         float var2 = this.g(var1);
         if(this instanceof class_qj && ((class_qj)this).cC()) {
            if(var2 > 10.0F) {
               this.a(true, true);
            }

            return;
         }

         if(!this.bs) {
            this.i.a(2, this.c);
            if(this.u() instanceof class_tf) {
               ((class_tf)this.u()).a(false);
            }

            this.bs = true;
         }

         this.o(var2);
         if(var2 > 4.0F) {
            this.u().a(var1, 1.0D);
         }

         if(var2 > 6.0F) {
            double var3 = (var1.s - this.s) / (double)var2;
            double var5 = (var1.t - this.t) / (double)var2;
            double var7 = (var1.u - this.u) / (double)var2;
            this.v += var3 * Math.abs(var3) * 0.4D;
            this.motY += var5 * Math.abs(var5) * 0.4D;
            this.x += var7 * Math.abs(var7) * 0.4D;
         }

         if(var2 > 10.0F) {
            this.a(true, true);
         }
      } else if(!this.cq() && this.bs) {
         this.bs = false;
         this.i.a(this.c);
         if(this.u() instanceof class_tf) {
            ((class_tf)this.u()).a(true);
         }

         this.cy();
      }

   }

   protected void o(float var1) {
   }

   static {
      br = (new class_qm(bq, "Fleeing speed bonus", 2.0D, 2)).a(false);
   }
}
