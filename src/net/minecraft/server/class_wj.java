package net.minecraft.server;

import java.util.UUID;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_om;
import net.minecraft.server.class_on;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.class_pw;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_qm;
import net.minecraft.server.class_sw;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_wr;
import net.minecraft.server.EntityHuman;

public class class_wj extends class_wr {
   private static final UUID b = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
   private static final class_qm c;
   private int bs;
   private int bt;
   private UUID bu;

   public class_wj(World var1) {
      super(var1);
      this.ab = true;
   }

   public void b(EntityLiving var1) {
      super.b((EntityLiving)var1);
      if(var1 != null) {
         this.bu = var1.aM();
      }

   }

   protected void n() {
      this.bn.a(1, new class_wj.class_b_in_class_wj(this));
      this.bn.a(2, new class_wj.class_a_in_class_wj(this));
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
         if(!this.j_() && !var1.a(c)) {
            var1.b(c);
         }

         --this.bs;
      } else if(var1.a(c)) {
         var1.c(c);
      }

      if(this.bt > 0 && --this.bt == 0) {
         this.a("mob.zombiepig.zpigangry", this.bC() * 2.0F, ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * 1.8F);
      }

      if(this.bs > 0 && this.bu != null && this.be() == null) {
         EntityHuman var2 = this.o.b(this.bu);
         this.b((EntityLiving)var2);
         this.aQ = var2;
         this.aR = this.bf();
      }

      super.cc();
   }

   public boolean cf() {
      return this.o.ab() != class_om.a;
   }

   public boolean cg() {
      return this.o.a((AxisAlignedBB)this.aT(), (Entity)this) && this.o.a((Entity)this, (AxisAlignedBB)this.aT()).isEmpty() && !this.o.d(this.aT());
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
         EntityHuman var3 = this.o.b(this.bu);
         this.b((EntityLiving)var3);
         if(var3 != null) {
            this.aQ = var3;
            this.aR = this.bf();
         }
      }

   }

   public boolean damageEntity(class_pc var1, float var2) {
      if(this.b((class_pc)var1)) {
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
         this.a(Items.bv, 1);
      }

      var3 = this.random.nextInt(2 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         this.a(Items.bz, 1);
      }

   }

   public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
      return false;
   }

   protected void br() {
      this.a(Items.m, 1);
   }

   protected void a(class_on var1) {
      this.a((class_pw)class_pw.a, (ItemStack)(new ItemStack(Items.D)));
   }

   public class_qd a(class_on var1, class_qd var2) {
      super.a(var1, var2);
      this.n(false);
      return var2;
   }

   static {
      c = (new class_qm(b, "Attacking speed boost", 0.05D, 0)).a(false);
   }

   static class class_a_in_class_wj extends class_sz {
      public class_a_in_class_wj(class_wj var1) {
         super(var1, EntityHuman.class, true);
      }

      public boolean a() {
         return ((class_wj)this.e).cB() && super.a();
      }
   }

   static class class_b_in_class_wj extends class_sw {
      public class_b_in_class_wj(class_wj var1) {
         super(var1, true, new Class[0]);
      }

      protected void a(class_qh var1, EntityLiving var2) {
         super.a(var1, var2);
         if(var1 instanceof class_wj) {
            ((class_wj)var1).b((Entity)var2);
         }

      }
   }
}
