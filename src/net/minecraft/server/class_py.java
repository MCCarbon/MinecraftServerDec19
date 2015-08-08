package net.minecraft.server;

public abstract class class_py extends EntityInsentient {
   public class_py(World var1) {
      super(var1);
   }

   public void e(float var1, float var2) {
   }

   protected void a(double var1, boolean var3, Block var4, BlockPosition var5) {
   }

   public void g(float var1, float var2) {
      if(this.V()) {
         this.a(var1, var2, 0.02F);
         this.d(this.motX, this.motY, this.motZ);
         this.motX *= 0.800000011920929D;
         this.motY *= 0.800000011920929D;
         this.motZ *= 0.800000011920929D;
      } else if(this.ab()) {
         this.a(var1, var2, 0.02F);
         this.d(this.motX, this.motY, this.motZ);
         this.motX *= 0.5D;
         this.motY *= 0.5D;
         this.motZ *= 0.5D;
      } else {
         float var3 = 0.91F;
         if(this.onGround) {
            var3 = this.world.getType(new BlockPosition(MathHelper.floor(this.locX), MathHelper.floor(this.aT().yMin) - 1, MathHelper.floor(this.locZ))).getBlock().frictionFactor * 0.91F;
         }

         float var4 = 0.16277136F / (var3 * var3 * var3);
         this.a(var1, var2, this.onGround?0.1F * var4:0.02F);
         var3 = 0.91F;
         if(this.onGround) {
            var3 = this.world.getType(new BlockPosition(MathHelper.floor(this.locX), MathHelper.floor(this.aT().yMin) - 1, MathHelper.floor(this.locZ))).getBlock().frictionFactor * 0.91F;
         }

         this.d(this.motX, this.motY, this.motZ);
         this.motX *= (double)var3;
         this.motY *= (double)var3;
         this.motZ *= (double)var3;
      }

      this.aD = this.aE;
      double var8 = this.locX - this.lastX;
      double var5 = this.locZ - this.lastZ;
      float var7 = MathHelper.sqrt(var8 * var8 + var5 * var5) * 4.0F;
      if(var7 > 1.0F) {
         var7 = 1.0F;
      }

      this.aE += (var7 - this.aE) * 0.4F;
      this.aF += this.aE;
   }

   public boolean k_() {
      return false;
   }
}
