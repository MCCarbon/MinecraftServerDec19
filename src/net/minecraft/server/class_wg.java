package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;

public class class_wg extends class_wi {
   private static final int a = Datawathcer.claimId(class_wg.class);
   private static final int b = Datawathcer.claimId(class_wg.class);
   private float c;
   private float bs;
   private float bt;
   private float bu;
   private float bv;
   private EntityLiving bw;
   private int bx;
   private boolean by;
   private class_si bz;

   public class_wg(World var1) {
      super(var1);
      this.b_ = 10;
      this.a(0.85F, 0.85F);
      this.i.a(4, new class_wg.class_a_in_class_wg(this));
      class_ry var2;
      this.i.a(5, var2 = new class_ry(this, 1.0D));
      this.i.a(7, this.bz = new class_si(this, 1.0D, 80));
      this.i.a(8, new class_rr(this, EntityHuman.class, 8.0F));
      this.i.a(8, new class_rr(this, class_wg.class, 12.0F, 0.01F));
      this.i.a(9, new class_sh(this));
      this.bz.a(3);
      var2.a(3);
      this.bn.a(1, new class_sz(this, EntityLiving.class, 10, true, false, new class_wg.class_b_in_class_wg(this)));
      this.f = new class_wg.class_c_in_class_wg(this);
      this.bs = this.c = this.random.nextFloat();
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.e).a(6.0D);
      this.a((class_qk)class_wl.d).a(0.5D);
      this.a((class_qk)class_wl.b).a(16.0D);
      this.a((class_qk)class_wl.a).a(30.0D);
   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      this.a(var1.getBoolean("Elder"));
   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("Elder", this.cC());
   }

   protected class_tg b(World var1) {
      return new class_ti(this, var1);
   }

   protected void h() {
      super.h();
      this.datawatcher.add(a, Integer.valueOf(0));
      this.datawatcher.add(b, Integer.valueOf(0));
   }

   private boolean a(int var1) {
      return (this.datawatcher.getInt(a) & var1) != 0;
   }

   private void a(int var1, boolean var2) {
      int var3 = this.datawatcher.getInt(a);
      if(var2) {
         this.datawatcher.update(a, Integer.valueOf(var3 | var1));
      } else {
         this.datawatcher.update(a, Integer.valueOf(var3 & ~var1));
      }

   }

   public boolean n() {
      return this.a(2);
   }

   private void m(boolean var1) {
      this.a(2, var1);
   }

   public int cB() {
      return this.cC()?60:80;
   }

   public boolean cC() {
      return this.a(4);
   }

   public void a(boolean var1) {
      this.a(4, var1);
      if(var1) {
         this.a(1.9975F, 1.9975F);
         this.a((class_qk)class_wl.d).a(0.30000001192092896D);
         this.a((class_qk)class_wl.e).a(8.0D);
         this.a((class_qk)class_wl.a).a(80.0D);
         this.cl();
         this.bz.b(400);
      }

   }

   private void b(int var1) {
      this.datawatcher.update(b, Integer.valueOf(var1));
   }

   public boolean cE() {
      return this.datawatcher.getInt(b) != 0;
   }

   public EntityLiving cF() {
      if(!this.cE()) {
         return null;
      } else if(this.o.isClientSide) {
         if(this.bw != null) {
            return this.bw;
         } else {
            Entity var1 = this.o.getEntityById(this.datawatcher.getInt(b));
            if(var1 instanceof EntityLiving) {
               this.bw = (EntityLiving)var1;
               return this.bw;
            } else {
               return null;
            }
         }
      } else {
         return this.w();
      }
   }

   public void d(int var1) {
      super.d(var1);
      if(var1 == a) {
         if(this.cC() && this.J < 1.0F) {
            this.a(1.9975F, 1.9975F);
         }
      } else if(var1 == b) {
         this.bx = 0;
         this.bw = null;
      }

   }

   public int y() {
      return 160;
   }

   protected String C() {
      return !this.V()?"mob.guardian.land.idle":(this.cC()?"mob.guardian.elder.idle":"mob.guardian.idle");
   }

   protected String bp() {
      return !this.V()?"mob.guardian.land.hit":(this.cC()?"mob.guardian.elder.hit":"mob.guardian.hit");
   }

   protected String bq() {
      return !this.V()?"mob.guardian.land.death":(this.cC()?"mob.guardian.elder.death":"mob.guardian.death");
   }

   protected boolean s_() {
      return false;
   }

   public float aU() {
      return this.K * 0.5F;
   }

   public float a(BlockPosition var1) {
      return this.o.getType(var1).getBlock().getMaterial() == Material.WATER?10.0F + this.o.o(var1) - 0.5F:super.a(var1);
   }

   public void m() {
      if(this.o.isClientSide) {
         this.bs = this.c;
         if(!this.V()) {
            this.bt = 2.0F;
            if(this.motY > 0.0D && this.by && !this.R()) {
               this.o.a(this.s, this.t, this.u, "mob.guardian.flop", 1.0F, 1.0F, false);
            }

            this.by = this.motY < 0.0D && this.o.d((new BlockPosition(this)).down(), false);
         } else if(this.n()) {
            if(this.bt < 0.5F) {
               this.bt = 4.0F;
            } else {
               this.bt += (0.5F - this.bt) * 0.1F;
            }
         } else {
            this.bt += (0.125F - this.bt) * 0.2F;
         }

         this.c += this.bt;
         this.bv = this.bu;
         if(!this.V()) {
            this.bu = this.random.nextFloat();
         } else if(this.n()) {
            this.bu += (0.0F - this.bu) * 0.25F;
         } else {
            this.bu += (1.0F - this.bu) * 0.06F;
         }

         if(this.n() && this.V()) {
            Vec3D var1 = this.d(0.0F);

            for(int var2 = 0; var2 < 2; ++var2) {
               this.o.a(class_cy.e, this.s + (this.random.nextDouble() - 0.5D) * (double)this.J - var1.x * 1.5D, this.t + this.random.nextDouble() * (double)this.K - var1.y * 1.5D, this.u + (this.random.nextDouble() - 0.5D) * (double)this.J - var1.z * 1.5D, 0.0D, 0.0D, 0.0D, new int[0]);
            }
         }

         if(this.cE()) {
            if(this.bx < this.cB()) {
               ++this.bx;
            }

            EntityLiving var14 = this.cF();
            if(var14 != null) {
               this.q().a(var14, 90.0F, 90.0F);
               this.q().a();
               double var15 = (double)this.q(0.0F);
               double var4 = var14.s - this.s;
               double var6 = var14.t + (double)(var14.K * 0.5F) - (this.t + (double)this.aU());
               double var8 = var14.u - this.u;
               double var10 = Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
               var4 /= var10;
               var6 /= var10;
               var8 /= var10;
               double var12 = this.random.nextDouble();

               while(var12 < var10) {
                  var12 += 1.8D - var15 + this.random.nextDouble() * (1.7D - var15);
                  this.o.a(class_cy.e, this.s + var4 * var12, this.t + var6 * var12 + (double)this.aU(), this.u + var8 * var12, 0.0D, 0.0D, 0.0D, new int[0]);
               }
            }
         }
      }

      if(this.Y) {
         this.i(300);
      } else if(this.C) {
         this.motY += 0.5D;
         this.v += (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F);
         this.x += (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F);
         this.y = this.random.nextFloat() * 360.0F;
         this.C = false;
         this.ai = true;
      }

      if(this.cE()) {
         this.y = this.aN;
      }

      super.m();
   }

   public float q(float var1) {
      return ((float)this.bx + var1) / (float)this.cB();
   }

   protected void cc() {
      super.cc();
      if(this.cC()) {
         boolean var1 = true;
         boolean var2 = true;
         boolean var3 = true;
         boolean var4 = true;
         if((this.W + this.getId()) % 1200 == 0) {
            class_pk var5 = class_pm.d;
            List var6 = this.o.getPlayers(EntityPlayer.class, new Predicate() {
               public boolean a(EntityPlayer var1) {
                  return class_wg.this.h(var1) < 2500.0D && var1.playerInteractManager.c();
               }

               // $FF: synthetic method
               public boolean apply(Object var1) {
                  return this.a((EntityPlayer)var1);
               }
            });
            Iterator var7 = var6.iterator();

            label30:
            while(true) {
               EntityPlayer var8;
               do {
                  if(!var7.hasNext()) {
                     break label30;
                  }

                  var8 = (EntityPlayer)var7.next();
               } while(var8.a((class_pk)var5) && var8.b((class_pk)var5).c() >= 2 && var8.b((class_pk)var5).b() >= 1200);

               var8.playerConnection.sendPacket((Packet)(new PacketPlayOutGameStateChange(10, 0.0F)));
               var8.c(new class_pl(var5, 6000, 2));
            }
         }

         if(!this.cz()) {
            this.a(new BlockPosition(this), 16);
         }
      }

   }

   protected void b(boolean var1, int var2) {
      int var3 = this.random.nextInt(3) + this.random.nextInt(var2 + 1);
      if(var3 > 0) {
         this.a(new ItemStack(Items.PRISMARINE_SHARD, var3, 0), 1.0F);
      }

      if(this.random.nextInt(3 + var2) > 1) {
         this.a(new ItemStack(Items.FISH, 1, class_aak.class_a_in_class_aak.a.a()), 1.0F);
      } else if(this.random.nextInt(3 + var2) > 1) {
         this.a(new ItemStack(Items.PRISMARINE_CRYSTALS), 1.0F);
      }

      if(var1 && this.cC()) {
         this.a(new ItemStack(Blocks.SPONGE, 1, 1), 1.0F);
      }

   }

   protected void br() {
      ItemStack var1 = ((class_vf)class_oc.a(this.random, class_ve.j())).a(this.random);
      this.a(var1, 1.0F);
   }

   protected boolean n_() {
      return true;
   }

   public boolean cg() {
      return this.o.a((AxisAlignedBB)this.aT(), (Entity)this) && this.o.a((Entity)this, (AxisAlignedBB)this.aT()).isEmpty();
   }

   public boolean cf() {
      return (this.random.nextInt(20) == 0 || !this.o.j(new BlockPosition(this))) && super.cf();
   }

   public boolean damageEntity(class_pc var1, float var2) {
      if(!this.n() && !var1.s() && var1.i() instanceof EntityLiving) {
         EntityLiving var3 = (EntityLiving)var1.i();
         if(!var1.c()) {
            var3.damageEntity(class_pc.a((Entity)this), 2.0F);
            var3.a("damage.thorns", 0.5F, 1.0F);
         }
      }

      this.bz.f();
      return super.damageEntity(var1, var2);
   }

   public int cd() {
      return 180;
   }

   public void g(float var1, float var2) {
      if(this.bN()) {
         if(this.V()) {
            this.a(var1, var2, 0.1F);
            this.d(this.v, this.motY, this.x);
            this.v *= 0.8999999761581421D;
            this.motY *= 0.8999999761581421D;
            this.x *= 0.8999999761581421D;
            if(!this.n() && this.w() == null) {
               this.motY -= 0.005D;
            }
         } else {
            super.g(var1, var2);
         }
      } else {
         super.g(var1, var2);
      }

   }

   static class class_c_in_class_wg extends class_qz {
      private class_wg g;

      public class_c_in_class_wg(class_wg var1) {
         super(var1);
         this.g = var1;
      }

      public void c() {
         if(this.f && !this.g.u().m()) {
            double var1 = this.b - this.g.s;
            double var3 = this.c - this.g.t;
            double var5 = this.d - this.g.u;
            double var7 = var1 * var1 + var3 * var3 + var5 * var5;
            var7 = (double)MathHelper.sqrt(var7);
            var3 /= var7;
            float var9 = (float)(MathHelper.b(var5, var1) * 180.0D / 3.1415927410125732D) - 90.0F;
            this.g.y = this.a(this.g.y, var9, 30.0F);
            this.g.aL = this.g.y;
            float var10 = (float)(this.e * this.g.a((class_qk)class_wl.d).e());
            this.g.k(this.g.bJ() + (var10 - this.g.bJ()) * 0.125F);
            double var11 = Math.sin((double)(this.g.W + this.g.getId()) * 0.5D) * 0.05D;
            double var13 = Math.cos((double)(this.g.y * 3.1415927F / 180.0F));
            double var15 = Math.sin((double)(this.g.y * 3.1415927F / 180.0F));
            this.g.v += var11 * var13;
            this.g.x += var11 * var15;
            var11 = Math.sin((double)(this.g.W + this.g.getId()) * 0.75D) * 0.05D;
            this.g.motY += var11 * (var15 + var13) * 0.25D;
            this.g.motY += (double)this.g.bJ() * var3 * 0.1D;
            class_qy var17 = this.g.q();
            double var18 = this.g.s + var1 / var7 * 2.0D;
            double var20 = (double)this.g.aU() + this.g.t + var3 / var7 * 1.0D;
            double var22 = this.g.u + var5 / var7 * 2.0D;
            double var24 = var17.e();
            double var26 = var17.f();
            double var28 = var17.g();
            if(!var17.b()) {
               var24 = var18;
               var26 = var20;
               var28 = var22;
            }

            this.g.q().a(var24 + (var18 - var24) * 0.125D, var26 + (var20 - var26) * 0.125D, var28 + (var22 - var28) * 0.125D, 10.0F, 40.0F);
            this.g.m(true);
         } else {
            this.g.k(0.0F);
            this.g.m(false);
         }
      }
   }

   static class class_a_in_class_wg extends class_rm {
      private class_wg a;
      private int b;

      public class_a_in_class_wg(class_wg var1) {
         this.a = var1;
         this.a(3);
      }

      public boolean a() {
         EntityLiving var1 = this.a.w();
         return var1 != null && var1.isAlive();
      }

      public boolean b() {
         return super.b() && (this.a.cC() || this.a.h(this.a.w()) > 9.0D);
      }

      public void c() {
         this.b = -10;
         this.a.u().n();
         this.a.q().a(this.a.w(), 90.0F, 90.0F);
         this.a.ai = true;
      }

      public void d() {
         this.a.b(0);
         this.a.d((EntityLiving)null);
         this.a.bz.f();
      }

      public void e() {
         EntityLiving var1 = this.a.w();
         this.a.u().n();
         this.a.q().a(var1, 90.0F, 90.0F);
         if(!this.a.t(var1)) {
            this.a.d((EntityLiving)null);
         } else {
            ++this.b;
            if(this.b == 0) {
               this.a.b(this.a.w().getId());
               this.a.o.a((Entity)this.a, (byte)21);
            } else if(this.b >= this.a.cB()) {
               float var2 = 1.0F;
               if(this.a.o.ab() == class_om.d) {
                  var2 += 2.0F;
               }

               if(this.a.cC()) {
                  var2 += 2.0F;
               }

               var1.damageEntity(class_pc.b(this.a, this.a), var2);
               var1.damageEntity(class_pc.a((EntityLiving)this.a), (float)this.a.a((class_qk)class_wl.e).e());
               this.a.d((EntityLiving)null);
            } else if(this.b >= 60 && this.b % 20 == 0) {
               ;
            }

            super.e();
         }
      }
   }

   static class class_b_in_class_wg implements Predicate {
      private class_wg a;

      public class_b_in_class_wg(class_wg var1) {
         this.a = var1;
      }

      public boolean a(EntityLiving var1) {
         return (var1 instanceof EntityHuman || var1 instanceof class_ui) && var1.h(this.a) > 9.0D;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((EntityLiving)var1);
      }
   }
}
