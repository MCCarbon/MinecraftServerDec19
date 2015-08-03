package net.minecraft.server;

import java.util.Calendar;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_adi;
import net.minecraft.server.EnchantmentManager;
import net.minecraft.server.Enchantment;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.class_apa;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_on;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.Entity;
import net.minecraft.server.class_pw;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_qf;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_rb;
import net.minecraft.server.class_ri;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_ru;
import net.minecraft.server.class_sh;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sk;
import net.minecraft.server.class_sm;
import net.minecraft.server.class_sw;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_uj;
import net.minecraft.server.class_ul;
import net.minecraft.server.class_wa;
import net.minecraft.server.class_wi;
import net.minecraft.server.class_wk;
import net.minecraft.server.class_wl;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_xd;

public class class_wn extends class_wi implements class_wk {
   private static final int a = class_qi.a(class_wn.class);
   private static final int b = class_qi.a(class_wn.class);
   private class_sk c = new class_sk(this, 1.0D, 20, 60, 15.0F);
   private class_ru bs = new class_ru(this, EntityHuman.class, 1.2D, false) {
      public void d() {
         super.d();
         class_wn.this.a(false);
      }

      public void c() {
         super.c();
         class_wn.this.a(true);
      }
   };

   public class_wn(World var1) {
      super(var1);
      this.i.a(1, new class_rj(this));
      this.i.a(2, new class_sm(this));
      this.i.a(3, new class_ri(this, 1.0D));
      this.i.a(3, new class_rb(this, class_ul.class, 6.0F, 1.0D, 1.2D));
      this.i.a(4, new class_si(this, 1.0D));
      this.i.a(6, new class_rr(this, EntityHuman.class, 8.0F));
      this.i.a(6, new class_sh(this));
      this.bn.a(1, new class_sw(this, false, new Class[0]));
      this.bn.a(2, new class_sz(this, EntityHuman.class, true));
      this.bn.a(3, new class_sz(this, class_uj.class, true));
      if(var1 != null && !var1.isClientSide) {
         this.n();
      }

   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.d).a(0.25D);
   }

   protected void h() {
      super.h();
      this.ac.a(a, Byte.valueOf((byte)0));
      this.ac.a(b, Byte.valueOf((byte)0));
   }

   protected String C() {
      return "mob.skeleton.say";
   }

   protected String bp() {
      return "mob.skeleton.hurt";
   }

   protected String bq() {
      return "mob.skeleton.death";
   }

   protected void a(BlockPosition var1, Block var2) {
      this.a("mob.skeleton.step", 0.15F, 1.0F);
   }

   public boolean r(Entity var1) {
      if(super.r(var1)) {
         if(this.cB() == 1 && var1 instanceof EntityLiving) {
            ((EntityLiving)var1).c(new class_pl(class_pm.t, 200));
         }

         return true;
      } else {
         return false;
      }
   }

   public class_qf bz() {
      return class_qf.b;
   }

   public void m() {
      if(this.o.x() && !this.o.isClientSide) {
         float var1 = this.c(1.0F);
         BlockPosition var2 = new BlockPosition(this.s, (double)Math.round(this.t), this.u);
         if(var1 > 0.5F && this.V.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.o.i(var2)) {
            boolean var3 = true;
            ItemStack var4 = this.a((class_pw)class_pw.f);
            if(var4 != null) {
               if(var4.e()) {
                  var4.setData(var4.h() + this.V.nextInt(2));
                  if(var4.h() >= var4.j()) {
                     this.b(var4);
                     this.a((class_pw)class_pw.f, (ItemStack)null);
                  }
               }

               var3 = false;
            }

            if(var3) {
               this.f(8);
            }
         }
      }

      if(this.o.isClientSide && this.cB() == 1) {
         this.a(0.72F, 2.535F);
      }

      super.m();
   }

   public void ak() {
      super.ak();
      if(this.m instanceof class_qh) {
         class_qh var1 = (class_qh)this.m;
         this.aL = var1.aL;
      }

   }

   public void a(class_pc var1) {
      super.a(var1);
      if(var1.i() instanceof class_xd && var1.j() instanceof EntityHuman) {
         EntityHuman var2 = (EntityHuman)var1.j();
         double var3 = var2.s - this.s;
         double var5 = var2.u - this.u;
         if(var3 * var3 + var5 * var5 >= 2500.0D) {
            var2.b((class_my)class_mt.v);
         }
      } else if(var1.j() instanceof class_wa && ((class_wa)var1.j()).n() && ((class_wa)var1.j()).cE()) {
         ((class_wa)var1.j()).cF();
         this.a(new ItemStack(Items.ca, 1, this.cB() == 1?1:0), 0.0F);
      }

   }

   protected Item D() {
      return Items.ARROW;
   }

   protected void b(boolean var1, int var2) {
      int var3;
      int var4;
      if(this.cB() == 1) {
         var3 = this.V.nextInt(3 + var2) - 1;

         for(var4 = 0; var4 < var3; ++var4) {
            this.a(Items.COAL, 1);
         }
      } else {
         var3 = this.V.nextInt(3 + var2);

         for(var4 = 0; var4 < var3; ++var4) {
            this.a(Items.ARROW, 1);
         }
      }

      var3 = this.V.nextInt(3 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         this.a(Items.aZ, 1);
      }

   }

   protected void br() {
      if(this.cB() == 1) {
         this.a(new ItemStack(Items.ca, 1, 1), 0.0F);
      }

   }

   protected void a(class_on var1) {
      super.a(var1);
      this.a(class_pw.a, new ItemStack(Items.BOW));
   }

   public class_qd a(class_on var1, class_qd var2) {
      var2 = super.a(var1, var2);
      if(this.o.worldProvider instanceof class_apa && this.bd().nextInt(5) > 0) {
         this.i.a(4, this.bs);
         this.a(1);
         this.a(class_pw.a, new ItemStack(Items.STONE_SWORD));
         this.a((class_qk)class_wl.e).a(4.0D);
      } else {
         this.i.a(4, this.c);
         this.a(var1);
         this.b(var1);
      }

      this.j(this.V.nextFloat() < 0.55F * var1.c());
      if(this.a((class_pw)class_pw.f) == null) {
         Calendar var3 = this.o.Z();
         if(var3.get(2) + 1 == 10 && var3.get(5) == 31 && this.V.nextFloat() < 0.25F) {
            this.a(class_pw.f, new ItemStack(this.V.nextFloat() < 0.1F?BlockStainedGlassPane.LIT_PUMPKIN:BlockStainedGlassPane.PUMPKIN));
            this.bp[class_pw.f.b()] = 0.0F;
         }
      }

      return var2;
   }

   public void n() {
      this.i.a((class_rm)this.bs);
      this.i.a((class_rm)this.c);
      ItemStack var1 = this.bA();
      if(var1 != null && var1.getItem() == Items.BOW) {
         this.i.a(4, this.c);
      } else {
         this.i.a(4, this.bs);
      }

   }

   public void a(EntityLiving var1, float var2) {
      class_xd var3 = new class_xd(this.o, this);
      double var4 = var1.s - this.s;
      double var6 = var1.aT().yMin + (double)(var1.K / 3.0F) - var3.t;
      double var8 = var1.u - this.u;
      double var10 = (double)MathHelper.sqrt(var4 * var4 + var8 * var8);
      var3.c(var4, var6 + var10 * 0.20000000298023224D, var8, 1.6F, (float)(14 - this.o.ab().a() * 4));
      int var12 = EnchantmentManager.a((class_adi)Enchantment.t, (EntityLiving)this);
      int var13 = EnchantmentManager.a((class_adi)Enchantment.u, (EntityLiving)this);
      var3.b((double)(var2 * 2.0F) + this.V.nextGaussian() * 0.25D + (double)((float)this.o.ab().a() * 0.11F));
      if(var12 > 0) {
         var3.b(var3.l() + (double)var12 * 0.5D + 0.5D);
      }

      if(var13 > 0) {
         var3.a(var13);
      }

      if(EnchantmentManager.a((class_adi)Enchantment.v, (EntityLiving)this) > 0 || this.cB() == 1) {
         var3.f(100);
      }

      this.a("random.bow", 1.0F, 1.0F / (this.bd().nextFloat() * 0.4F + 0.8F));
      this.o.addEntity((Entity)var3);
   }

   public int cB() {
      return this.ac.a(a);
   }

   public void a(int var1) {
      this.ac.b(a, Byte.valueOf((byte)var1));
      this.ab = var1 == 1;
      if(var1 == 1) {
         this.a(0.72F, 2.535F);
      } else {
         this.a(0.6F, 1.95F);
      }

   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.hasOfType("SkeletonType", 99)) {
         byte var2 = var1.getByte("SkeletonType");
         this.a(var2);
      }

      this.n();
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("SkeletonType", (byte)this.cB());
   }

   public void a(class_pw var1, ItemStack var2) {
      super.a(var1, var2);
      if(!this.o.isClientSide && var1 == class_pw.a) {
         this.n();
      }

   }

   public float aU() {
      return this.cB() == 1?super.aU():1.74F;
   }

   public double am() {
      return this.j_()?0.0D:-0.35D;
   }

   public void a(boolean var1) {
      this.ac.b(b, Byte.valueOf((byte)(var1?1:0)));
   }
}
