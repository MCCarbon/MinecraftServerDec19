package net.minecraft.server;

public class class_st extends class_rp {
   private int e;
   private class_wv f;

   public class_st(class_wv var1) {
      super(var1, class_wv.class, 3.0F, 0.02F);
      this.f = var1;
   }

   public void c() {
      super.c();
      if(this.f.cH() && this.b instanceof class_wv && ((class_wv)this.b).cI()) {
         this.e = 10;
      } else {
         this.e = 0;
      }

   }

   public void e() {
      super.e();
      if(this.e > 0) {
         --this.e;
         if(this.e == 0) {
            class_ow var1 = this.f.cF();

            for(int var2 = 0; var2 < var1.getSize(); ++var2) {
               ItemStack var3 = var1.getItem(var2);
               ItemStack var4 = null;
               if(var3 != null) {
                  Item var5 = var3.getItem();
                  int var6;
                  if((var5 == Items.BREAD || var5 == Items.POTATO || var5 == Items.CARROT) && var3.count > 3) {
                     var6 = var3.count / 2;
                     var3.count -= var6;
                     var4 = new ItemStack(var5, var6, var3.i());
                  } else if(var5 == Items.WHEAT && var3.count > 5) {
                     var6 = var3.count / 2 / 3 * 3;
                     int var7 = var6 / 3;
                     var3.count -= var6;
                     var4 = new ItemStack(Items.BREAD, var7, 0);
                  }

                  if(var3.count <= 0) {
                     var1.setItem(var2, (ItemStack)null);
                  }
               }

               if(var4 != null) {
                  double var11 = this.f.t - 0.30000001192092896D + (double)this.f.aU();
                  EntityItem var12 = new EntityItem(this.f.o, this.f.s, var11, this.f.u, var4);
                  float var8 = 0.3F;
                  float var9 = this.f.aN;
                  float var10 = this.f.z;
                  var12.v = (double)(-MathHelper.sin(var9 / 180.0F * 3.1415927F) * MathHelper.cos(var10 / 180.0F * 3.1415927F) * var8);
                  var12.x = (double)(MathHelper.cos(var9 / 180.0F * 3.1415927F) * MathHelper.cos(var10 / 180.0F * 3.1415927F) * var8);
                  var12.motY = (double)(-MathHelper.sin(var10 / 180.0F * 3.1415927F) * var8 + 0.1F);
                  var12.setPickupDelay();
                  this.f.o.addEntity((Entity)var12);
                  break;
               }
            }
         }
      }

   }
}
