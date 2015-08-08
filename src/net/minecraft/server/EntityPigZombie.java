package net.minecraft.server;

import java.util.UUID;

public class EntityPigZombie extends EntityZombie {
   private static final UUID b = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
   private static final class_qm c;
   private int bs;
   private int bt;
   private UUID bu;

   public EntityPigZombie(World var1) {
      super(var1);
      this.fireProof = true;
   }

   public void b(EntityLiving var1) {
      super.b((EntityLiving)var1);
      if(var1 != null) {
         this.bu = var1.getUniqueId();
      }

   }

   protected void n() {
      this.bn.a(1, new EntityPigZombie.class_b_in_class_wj(this));
      this.bn.a(2, new EntityPigZombie.class_a_in_class_wj(this));
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)a).a(0.0D);
      this.a((class_qk)class_wl.d).a(0.23000000417232513D);
      this.a((class_qk)class_wl.e).a(5.0D);
   }

   public void t_() {
      super.t_();
   }

   protected void cc() {
      class_ql var1 = this.a((class_qk)class_wl.d);
      if(this.cB()) {
         if(!this.isBaby() && !var1.a(c)) {
            var1.b(c);
         }

         --this.bs;
      } else if(var1.a(c)) {
         var1.c(c);
      }

      if(this.bt > 0 && --this.bt == 0) {
         this.makeSound("mob.zombiepig.zpigangry", this.bC() * 2.0F, ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * 1.8F);
      }

      if(this.bs > 0 && this.bu != null && this.be() == null) {
         EntityHuman var2 = this.world.b(this.bu);
         this.b((EntityLiving)var2);
         this.aQ = var2;
         this.aR = this.bf();
      }

      super.cc();
   }

   public boolean cf() {
      return this.world.ab() != class_om.a;
   }

   public boolean cg() {
      return this.world.a((AxisAlignedBB)this.getBoundingBox(), (Entity)this) && this.world.getCubes((Entity)this, (AxisAlignedBB)this.getBoundingBox()).isEmpty() && !this.world.containsLiquid(this.getBoundingBox());
   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("Anger", (short)this.bs);
      if(this.bu != null) {
         var1.put("HurtBy", this.bu.toString());
      } else {
         var1.put("HurtBy", "");
      }

   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      this.bs = var1.getShort("Anger");
      String var2 = var1.getString("HurtBy");
      if(!var2.isEmpty()) {
         this.bu = UUID.fromString(var2);
         EntityHuman var3 = this.world.b(this.bu);
         this.b((EntityLiving)var3);
         if(var3 != null) {
            this.aQ = var3;
            this.aR = this.bf();
         }
      }

   }

   public boolean damageEntity(DamageSource var1, float var2) {
      if(this.b((DamageSource)var1)) {
         return false;
      } else {
         Entity var3 = var1.j();
         if(var3 instanceof EntityHuman) {
            this.b(var3);
         }

         return super.damageEntity(var1, var2);
      }
   }

   private void b(Entity var1) {
      this.bs = 400 + this.random.nextInt(400);
      this.bt = this.random.nextInt(40);
      if(var1 instanceof EntityLiving) {
         this.b((EntityLiving)var1);
      }

   }

   public boolean cB() {
      return this.bs > 0;
   }

   protected String C() {
      return "mob.zombiepig.zpig";
   }

   protected String bp() {
      return "mob.zombiepig.zpighurt";
   }

   protected String bq() {
      return "mob.zombiepig.zpigdeath";
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.random.nextInt(2 + var2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.a(Items.ROTTEN_FLESH, 1);
      }

      var3 = this.random.nextInt(2 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         this.a(Items.GOLD_NUGGEST, 1);
      }

   }

   public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
      return false;
   }

   protected void br() {
      this.a(Items.GOLD_INGOT, 1);
   }

   protected void a(class_on var1) {
      this.a((EnumWearable) EnumWearable.MAINHAND, (ItemStack)(new ItemStack(Items.GOLDEN_SWORD)));
   }

   public class_qd a(class_on var1, class_qd var2) {
      super.a(var1, var2);
      this.setVillager(false);
      return var2;
   }

   static {
      c = (new class_qm(b, "Attacking speed boost", 0.05D, 0)).a(false);
   }

   static class class_a_in_class_wj extends class_sz {
      public class_a_in_class_wj(EntityPigZombie var1) {
         super(var1, EntityHuman.class, true);
      }

      public boolean a() {
         return ((EntityPigZombie)this.e).cB() && super.a();
      }
   }

   static class class_b_in_class_wj extends class_sw {
      public class_b_in_class_wj(EntityPigZombie var1) {
         super(var1, true, new Class[0]);
      }

      protected void a(EntityCreature var1, EntityLiving var2) {
         super.a(var1, var2);
         if(var1 instanceof EntityPigZombie) {
            ((EntityPigZombie)var1).b((Entity)var2);
         }

      }
   }
}
