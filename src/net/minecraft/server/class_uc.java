package net.minecraft.server;

import com.google.common.base.Predicate;

public class class_uc extends class_qj {
   private static final int bw = Datawathcer.claimId(class_uc.class);
   private class_rb bx;
   private class_sr by;

   public class_uc(World var1) {
      super(var1);
      this.a(0.6F, 0.7F);
      ((class_tf)this.u()).a(true);
      this.i.a(1, new class_rj(this));
      this.i.a(2, this.bu);
      this.i.a(3, this.by = new class_sr(this, 0.6D, Items.FISH, true));
      this.i.a(5, new class_rk(this, 1.0D, 10.0F, 5.0F));
      this.i.a(6, new class_sb(this, 0.8D));
      this.i.a(7, new class_rq(this, 0.3F));
      this.i.a(8, new class_sa(this));
      this.i.a(9, new class_re(this, 0.8D));
      this.i.a(10, new class_si(this, 0.8D));
      this.i.a(11, new class_rr(this, EntityHuman.class, 10.0F));
      this.bn.a(1, new class_ta(this, class_tx.class, false, (Predicate)null));
   }

   protected void h() {
      super.h();
      this.datawatcher.add(bw, Byte.valueOf((byte)0));
   }

   public void cc() {
      if(this.r().a()) {
         double var1 = this.r().b();
         if(var1 == 0.6D) {
            this.c(true);
            this.d(false);
         } else if(var1 == 1.33D) {
            this.c(false);
            this.d(true);
         } else {
            this.c(false);
            this.d(false);
         }
      } else {
         this.c(false);
         this.d(false);
      }

   }

   protected boolean E() {
      return !this.cA() && this.W > 2400;
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.a).a(10.0D);
      this.a((class_qk)class_wl.d).a(0.30000001192092896D);
   }

   public void e(float var1, float var2) {
   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("CatType", this.cI());
   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      this.m(var1.getInt("CatType"));
   }

   protected String C() {
      return this.cA()?(this.cG()?"mob.cat.purr":(this.random.nextInt(4) == 0?"mob.cat.purreow":"mob.cat.meow")):"";
   }

   protected String bp() {
      return "mob.cat.hitt";
   }

   protected String bq() {
      return "mob.cat.hitt";
   }

   protected float bC() {
      return 0.4F;
   }

   protected Item D() {
      return Items.LEATHER;
   }

   public boolean r(Entity var1) {
      return var1.damageEntity(DamageSource.a((EntityLiving) this), 3.0F);
   }

   public boolean damageEntity(DamageSource var1, float var2) {
      if(this.b((DamageSource)var1)) {
         return false;
      } else {
         this.bu.a(false);
         return super.damageEntity(var1, var2);
      }
   }

   protected void b(boolean var1, int var2) {
   }

   public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
      if(this.cA()) {
         if(this.e(var1) && !this.o.isClientSide && !this.d(var3)) {
            this.bu.a(!this.cC());
         }
      } else if(this.by.f() && var3 != null && var3.getItem() == Items.FISH && var1.h(this) < 9.0D) {
         if(!var1.abilities.instabuild) {
            --var3.count;
         }

         if(!this.o.isClientSide) {
            if(this.random.nextInt(3) == 0) {
               this.n(true);
               this.m(1 + this.o.random.nextInt(3));
               this.b((String)var1.aM().toString());
               this.m(true);
               this.bu.a(true);
               this.o.a((Entity)this, (byte)7);
            } else {
               this.m(false);
               this.o.a((Entity)this, (byte)6);
            }
         }

         return true;
      }

      return super.a(var1, var2, var3);
   }

   public class_uc b(class_po var1) {
      class_uc var2 = new class_uc(this.o);
      if(this.cA()) {
         var2.b((String)this.b());
         var2.n(true);
         var2.m(this.cI());
      }

      return var2;
   }

   public boolean d(ItemStack var1) {
      return var1 != null && var1.getItem() == Items.FISH;
   }

   public boolean a(class_tw var1) {
      if(var1 == this) {
         return false;
      } else if(!this.cA()) {
         return false;
      } else if(!(var1 instanceof class_uc)) {
         return false;
      } else {
         class_uc var2 = (class_uc)var1;
         return !var2.cA()?false:this.cG() && var2.cG();
      }
   }

   public int cI() {
      return this.datawatcher.getByte(bw);
   }

   public void m(int var1) {
      this.datawatcher.update(bw, Byte.valueOf((byte)var1));
   }

   public boolean cf() {
      return this.o.random.nextInt(3) != 0;
   }

   public boolean cg() {
      if(this.o.a((AxisAlignedBB)this.aT(), (Entity)this) && this.o.a((Entity)this, (AxisAlignedBB)this.aT()).isEmpty() && !this.o.d(this.aT())) {
         BlockPosition var1 = new BlockPosition(this.s, this.aT().yMin, this.u);
         if(var1.getY() < this.o.G()) {
            return false;
         }

         Block var2 = this.o.getType(var1.down()).getBlock();
         if(var2 == Blocks.GRASS || var2.getMaterial() == Material.LEAVES) {
            return true;
         }
      }

      return false;
   }

   public String getName() {
      return this.hasCustomName()?this.aO():(this.cA()?LocaleI18n.get("entity.Cat.name"):super.getName());
   }

   public void n(boolean var1) {
      super.n(var1);
   }

   protected void cB() {
      if(this.bx == null) {
         this.bx = new class_rb(this, EntityHuman.class, 16.0F, 0.8D, 1.33D);
      }

      this.i.a((class_rm)this.bx);
      if(!this.cA()) {
         this.i.a(4, this.bx);
      }

   }

   public class_qd a(class_on var1, class_qd var2) {
      var2 = super.a(var1, var2);
      if(this.o.random.nextInt(7) == 0) {
         for(int var3 = 0; var3 < 2; ++var3) {
            class_uc var4 = new class_uc(this.o);
            var4.b(this.s, this.t, this.u, this.y, 0.0F);
            var4.b(-24000);
            this.o.addEntity((Entity)var4);
         }
      }

      return var2;
   }

   // $FF: synthetic method
   public class_po a(class_po var1) {
      return this.b(var1);
   }
}
