package net.minecraft.server;

import java.util.Random;

public class EntitySpider extends EntityMonster {
   private static final int a = Datawathcer.claimId(EntitySpider.class);

   public EntitySpider(World var1) {
      super(var1);
      this.a(1.4F, 0.9F);
      this.i.a(1, new class_rj(this));
      this.i.a(3, new class_rq(this, 0.4F));
      this.i.a(4, new EntitySpider.class_a_in_class_wp(this, EntityHuman.class));
      this.i.a(4, new EntitySpider.class_a_in_class_wp(this, EntityVillagerGolem.class));
      this.i.a(5, new class_si(this, 0.8D));
      this.i.a(6, new class_rr(this, EntityHuman.class, 8.0F));
      this.i.a(6, new class_sh(this));
      this.bn.a(1, new class_sw(this, false, new Class[0]));
      this.bn.a(2, new EntitySpider.class_c_in_class_wp(this, EntityHuman.class));
      this.bn.a(3, new EntitySpider.class_c_in_class_wp(this, EntityVillagerGolem.class));
   }

   public double an() {
      return (double)(this.K * 0.5F);
   }

   protected class_tg b(World var1) {
      return new class_th(this, var1);
   }

   protected void h() {
      super.h();
      this.datawatcher.add(a, new Byte((byte)0));
   }

   public void t_() {
      super.t_();
      if(!this.o.isClientSide) {
         this.a(this.D);
      }

   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(16.0D);
      this.a(class_wl.d).a(0.30000001192092896D);
   }

   protected String C() {
      return "mob.spider.say";
   }

   protected String bp() {
      return "mob.spider.say";
   }

   protected String bq() {
      return "mob.spider.death";
   }

   protected void a(BlockPosition var1, Block var2) {
      this.a("mob.spider.step", 0.15F, 1.0F);
   }

   protected Item D() {
      return Items.STRING;
   }

   protected void b(boolean var1, int var2) {
      super.b(var1, var2);
      if(var1 && (this.random.nextInt(3) == 0 || this.random.nextInt(1 + var2) > 0)) {
         this.a(Items.SPIDER_EYE, 1);
      }

   }

   public boolean k_() {
      return this.n();
   }

   public void aC() {
   }

   public class_qf bz() {
      return class_qf.c;
   }

   public boolean d(class_pl var1) {
      return var1.a() == MobEffectList.s?false:super.d(var1);
   }

   public boolean n() {
      return (this.datawatcher.getByte(a) & 1) != 0;
   }

   public void a(boolean var1) {
      byte var2 = this.datawatcher.getByte(a);
      if(var1) {
         var2 = (byte)(var2 | 1);
      } else {
         var2 &= -2;
      }

      this.datawatcher.update(a, Byte.valueOf(var2));
   }

   public class_qd a(class_on var1, class_qd var2) {
      Object var4 = super.a(var1, var2);
      if(this.o.random.nextInt(100) == 0) {
         EntitySkeleton var3 = new EntitySkeleton(this.o);
         var3.b(this.s, this.t, this.u, this.y, 0.0F);
         var3.a((class_on)var1, (class_qd)null);
         this.o.addEntity((Entity)var3);
         var3.a((Entity)this);
      }

      if(var4 == null) {
         var4 = new EntitySpider.class_b_in_class_wp();
         if(this.o.ab() == class_om.d && this.o.random.nextFloat() < 0.1F * var1.c()) {
            ((EntitySpider.class_b_in_class_wp)var4).a(this.o.random);
         }
      }

      if(var4 instanceof EntitySpider.class_b_in_class_wp) {
         MobEffect var5 = ((EntitySpider.class_b_in_class_wp)var4).a;
         if(var5 != null) {
            this.c(new class_pl(var5, Integer.MAX_VALUE));
         }
      }

      return (class_qd)var4;
   }

   public float aU() {
      return 0.65F;
   }

   static class class_c_in_class_wp extends class_sz {
      public class_c_in_class_wp(EntitySpider var1, Class var2) {
         super(var1, var2, true);
      }

      public boolean a() {
         float var1 = this.e.c(1.0F);
         return var1 >= 0.5F?false:super.a();
      }
   }

   static class class_a_in_class_wp extends class_ru {
      public class_a_in_class_wp(EntitySpider var1, Class var2) {
         super(var1, var2, 1.0D, true);
      }

      public boolean b() {
         float var1 = this.b.c(1.0F);
         if(var1 >= 0.5F && this.b.bd().nextInt(100) == 0) {
            this.b.d((EntityLiving)null);
            return false;
         } else {
            return super.b();
         }
      }

      protected double a(EntityLiving var1) {
         return (double)(4.0F + var1.J);
      }
   }

   public static class class_b_in_class_wp implements class_qd {
      public MobEffect a;

      public void a(Random var1) {
         int var2 = var1.nextInt(5);
         if(var2 <= 1) {
            this.a = MobEffectList.a;
         } else if(var2 <= 2) {
            this.a = MobEffectList.e;
         } else if(var2 <= 3) {
            this.a = MobEffectList.j;
         } else if(var2 <= 4) {
            this.a = MobEffectList.n;
         }

      }
   }
}
