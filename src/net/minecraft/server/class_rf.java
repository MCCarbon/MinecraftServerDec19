package net.minecraft.server;

public class class_rf extends class_rm {
   private final class_qb a;
   private final float b;
   private float c;
   private boolean d;
   private int e;
   private int f;

   public class_rf(class_qb var1, float var2) {
      this.a = var1;
      this.b = var2;
      this.a(7);
   }

   public void c() {
      this.c = 0.0F;
   }

   public void d() {
      this.d = false;
      this.c = 0.0F;
   }

   public boolean a() {
      return this.a.isAlive() && this.a.passenger != null && this.a.passenger instanceof EntityHuman && (this.d || this.a.ck());
   }

   public void e() {
      EntityHuman var1 = (EntityHuman)this.a.passenger;
      class_qh var2 = (class_qh)this.a;
      float var3 = MathHelper.clampAngle(var1.y - this.a.y) * 0.5F;
      if(var3 > 5.0F) {
         var3 = 5.0F;
      }

      if(var3 < -5.0F) {
         var3 = -5.0F;
      }

      this.a.y = MathHelper.clampAngle(this.a.y + var3);
      if(this.c < this.b) {
         this.c += (this.b - this.c) * 0.01F;
      }

      if(this.c > this.b) {
         this.c = this.b;
      }

      int var4 = MathHelper.floor(this.a.s);
      int var5 = MathHelper.floor(this.a.t);
      int var6 = MathHelper.floor(this.a.u);
      float var7 = this.c;
      if(this.d) {
         if(this.e++ > this.f) {
            this.d = false;
         }

         var7 += var7 * 1.15F * MathHelper.sin((float)this.e / (float)this.f * 3.1415927F);
      }

      float var8 = 0.91F;
      if(this.a.C) {
         var8 = this.a.o.getType(new BlockPosition(MathHelper.floor((float)var4), MathHelper.floor((float)var5) - 1, MathHelper.floor((float)var6))).getBlock().frictionFactor * 0.91F;
      }

      float var9 = 0.16277136F / (var8 * var8 * var8);
      float var10 = MathHelper.sin(var2.y * 3.1415927F / 180.0F);
      float var11 = MathHelper.cos(var2.y * 3.1415927F / 180.0F);
      float var12 = var2.bJ() * var9;
      float var13 = Math.max(var7, 1.0F);
      var13 = var12 / var13;
      float var14 = var7 * var13;
      float var15 = -(var14 * var10);
      float var16 = var14 * var11;
      if(MathHelper.abs(var15) > MathHelper.abs(var16)) {
         if(var15 < 0.0F) {
            var15 -= this.a.J / 2.0F;
         }

         if(var15 > 0.0F) {
            var15 += this.a.J / 2.0F;
         }

         var16 = 0.0F;
      } else {
         var15 = 0.0F;
         if(var16 < 0.0F) {
            var16 -= this.a.J / 2.0F;
         }

         if(var16 > 0.0F) {
            var16 += this.a.J / 2.0F;
         }
      }

      int var17 = MathHelper.floor(this.a.s + (double)var15);
      int var18 = MathHelper.floor(this.a.u + (double)var16);
      int var19 = MathHelper.floor(this.a.J + 1.0F);
      int var20 = MathHelper.floor(this.a.K + var1.K + 1.0F);
      int var21 = MathHelper.floor(this.a.J + 1.0F);
      if(var4 != var17 || var6 != var18) {
         Block var22 = this.a.o.getType(new BlockPosition(var4, var5, var6)).getBlock();
         boolean var23 = !this.a(var22) && (var22.getMaterial() != Material.AIR || !this.a(this.a.o.getType(new BlockPosition(var4, var5 - 1, var6)).getBlock()));
         if(var23 && 0 == class_auz.a(this.a.o, this.a, var17, var5, var18, var19, var20, var21, false, false, true) && 1 == class_auz.a(this.a.o, this.a, var4, var5 + 1, var6, var19, var20, var21, false, false, true) && 1 == class_auz.a(this.a.o, this.a, var17, var5 + 1, var18, var19, var20, var21, false, false, true)) {
            var2.t().a();
         }
      }

      if(!var1.abilities.instabuild && this.c >= this.b * 0.5F && this.a.bd().nextFloat() < 0.006F && !this.d) {
         EnumUsedHand var25 = this.a(var1);
         if(var25 != null) {
            ItemStack var26 = var1.getItemInHand((EnumUsedHand)var25);
            if(var26 != null && var26.getItem() == Items.CARROT_ON_A_STICK) {
               var26.a(1, (EntityLiving)var1);
               if(var26.count == 0) {
                  ItemStack var24 = new ItemStack(Items.FISHING_ROD);
                  var24.setTag(var26.getTag());
                  var1.a((EnumUsedHand)var25, (ItemStack)var24);
               }
            }
         }
      }

      this.a.g(0.0F, var7);
   }

   protected EnumUsedHand a(EntityHuman var1) {
      EnumUsedHand[] var2 = EnumUsedHand.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         EnumUsedHand var5 = var2[var4];
         ItemStack var6 = var1.getItemInHand((EnumUsedHand)var5);
         if(var6 != null && var6.getItem() == Items.CARROT_ON_A_STICK) {
            return var5;
         }
      }

      return null;
   }

   private boolean a(Block var1) {
      return var1 instanceof BlockStairs || var1 instanceof BlockStepAbstract;
   }

   public boolean f() {
      return this.d;
   }

   public void g() {
      this.d = true;
      this.e = 0;
      this.f = this.a.bd().nextInt(841) + 140;
   }

   public boolean h() {
      return !this.f() && this.c > this.b * 0.3F;
   }
}
