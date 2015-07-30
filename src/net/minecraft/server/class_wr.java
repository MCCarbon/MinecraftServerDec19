package net.minecraft.server;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_om;
import net.minecraft.server.class_on;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pk;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pv;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_qf;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_qm;
import net.minecraft.server.class_qs;
import net.minecraft.server.class_rd;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_ru;
import net.minecraft.server.class_rw;
import net.minecraft.server.class_ry;
import net.minecraft.server.class_sh;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sw;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_tx;
import net.minecraft.server.class_uj;
import net.minecraft.server.class_wa;
import net.minecraft.server.class_wi;
import net.minecraft.server.class_wj;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_wv;
import net.minecraft.server.class_xa;

public class class_wr extends class_wi {
   protected static final class_qk a = (new class_qs((class_qk)null, "zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).a("Spawn Reinforcements Chance");
   private static final UUID b = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
   private static final class_qm c;
   private static final int bs;
   private static final int bt;
   private static final int bu;
   private final class_rd bv = new class_rd(this);
   private int bw;
   private boolean bx = false;
   private float by = -1.0F;
   private float bz;

   public class_wr(World var1) {
      super(var1);
      ((class_tf)this.u()).b(true);
      this.i.a(0, new class_rj(this));
      this.i.a(2, new class_ru(this, class_xa.class, 1.0D, false));
      this.i.a(5, new class_ry(this, 1.0D));
      this.i.a(7, new class_si(this, 1.0D));
      this.i.a(8, new class_rr(this, class_xa.class, 8.0F));
      this.i.a(8, new class_sh(this));
      this.n();
      this.a(0.6F, 1.95F);
   }

   protected void n() {
      this.i.a(4, new class_ru(this, class_wv.class, 1.0D, true));
      this.i.a(4, new class_ru(this, class_uj.class, 1.0D, true));
      this.i.a(6, new class_rw(this, 1.0D, false));
      this.bn.a(1, new class_sw(this, true, new Class[]{class_wj.class}));
      this.bn.a(2, new class_sz(this, class_xa.class, true));
      this.bn.a(2, new class_sz(this, class_wv.class, false));
      this.bn.a(2, new class_sz(this, class_uj.class, true));
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.b).a(35.0D);
      this.a((class_qk)class_wl.d).a(0.23000000417232513D);
      this.a((class_qk)class_wl.e).a(3.0D);
      this.by().b(a).a(this.V.nextDouble() * 0.10000000149011612D);
   }

   protected void h() {
      super.h();
      this.H().a(bs, Byte.valueOf((byte)0));
      this.H().a(bt, Byte.valueOf((byte)0));
      this.H().a(bu, Byte.valueOf((byte)0));
   }

   public int bs() {
      int var1 = super.bs() + 2;
      if(var1 > 20) {
         var1 = 20;
      }

      return var1;
   }

   public boolean cC() {
      return this.bx;
   }

   public void a(boolean var1) {
      if(this.bx != var1) {
         this.bx = var1;
         if(var1) {
            this.i.a(1, this.bv);
         } else {
            this.i.a((class_rm)this.bv);
         }
      }

   }

   public boolean j_() {
      return this.H().a(bs) == 1;
   }

   protected int b(class_xa var1) {
      if(this.j_()) {
         this.b_ = (int)((float)this.b_ * 2.5F);
      }

      return super.b(var1);
   }

   public void m(boolean var1) {
      this.H().b(bs, Byte.valueOf((byte)(var1?1:0)));
      if(this.o != null && !this.o.D) {
         class_ql var2 = this.a((class_qk)class_wl.d);
         var2.c(c);
         if(var1) {
            var2.b(c);
         }
      }

      this.o(var1);
   }

   public boolean cD() {
      return this.H().a(bt) == 1;
   }

   public void n(boolean var1) {
      this.H().b(bt, Byte.valueOf((byte)(var1?1:0)));
   }

   public void d(int var1) {
      if(var1 == bs) {
         this.o(this.j_());
      }

      super.d(var1);
   }

   public void m() {
      if(this.o.x() && !this.o.D && !this.j_()) {
         float var1 = this.c(1.0F);
         BlockPosition var2 = new BlockPosition(this.s, (double)Math.round(this.t), this.u);
         if(var1 > 0.5F && this.V.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.o.i(var2)) {
            boolean var3 = true;
            class_aas var4 = this.a((class_pw)class_pw.f);
            if(var4 != null) {
               if(var4.e()) {
                  var4.b(var4.h() + this.V.nextInt(2));
                  if(var4.h() >= var4.j()) {
                     this.b((class_aas)var4);
                     this.a((class_pw)class_pw.f, (class_aas)null);
                  }
               }

               var3 = false;
            }

            if(var3) {
               this.f(8);
            }
         }
      }

      if(this.aw() && this.w() != null && this.m instanceof class_tx) {
         ((class_qb)this.m).u().a(this.u().j(), 1.5D);
      }

      super.m();
   }

   public boolean a(class_pc var1, float var2) {
      if(super.a(var1, var2)) {
         class_qa var3 = this.w();
         if(var3 == null && var1.j() instanceof class_qa) {
            var3 = (class_qa)var1.j();
         }

         if(var3 != null && this.o.ab() == class_om.d && (double)this.V.nextFloat() < this.a((class_qk)a).e()) {
            int var4 = MathHelper.floor(this.s);
            int var5 = MathHelper.floor(this.t);
            int var6 = MathHelper.floor(this.u);
            class_wr var7 = new class_wr(this.o);

            for(int var8 = 0; var8 < 50; ++var8) {
               int var9 = var4 + MathHelper.getRandomIntInRange((Random)this.V, 7, 40) * MathHelper.getRandomIntInRange((Random)this.V, -1, 1);
               int var10 = var5 + MathHelper.getRandomIntInRange((Random)this.V, 7, 40) * MathHelper.getRandomIntInRange((Random)this.V, -1, 1);
               int var11 = var6 + MathHelper.getRandomIntInRange((Random)this.V, 7, 40) * MathHelper.getRandomIntInRange((Random)this.V, -1, 1);
               if(World.a((class_aer)this.o, (BlockPosition)(new BlockPosition(var9, var10 - 1, var11))) && this.o.l(new BlockPosition(var9, var10, var11)) < 10) {
                  var7.b((double)var9, (double)var10, (double)var11);
                  if(!this.o.b((double)var9, (double)var10, (double)var11, 7.0D) && this.o.a((class_awf)var7.aT(), (class_pr)var7) && this.o.a((class_pr)var7, (class_awf)var7.aT()).isEmpty() && !this.o.d(var7.aT())) {
                     this.o.a((class_pr)var7);
                     var7.d(var3);
                     var7.a((class_on)this.o.E(new BlockPosition(var7)), (class_qd)null);
                     this.a((class_qk)a).b(new class_qm("Zombie reinforcement caller charge", -0.05000000074505806D, 0));
                     var7.a((class_qk)a).b(new class_qm("Zombie reinforcement callee charge", -0.05000000074505806D, 0));
                     break;
                  }
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public void t_() {
      if(!this.o.D && this.cE()) {
         int var1 = this.cG();
         this.bw -= var1;
         if(this.bw <= 0) {
            this.cF();
         }
      }

      super.t_();
   }

   public boolean r(class_pr var1) {
      boolean var2 = super.r(var1);
      if(var2) {
         int var3 = this.o.ab().a();
         if(this.bA() == null && this.av() && this.V.nextFloat() < (float)var3 * 0.3F) {
            var1.f(2 * var3);
         }
      }

      return var2;
   }

   protected String C() {
      return "mob.zombie.say";
   }

   protected String bp() {
      return "mob.zombie.hurt";
   }

   protected String bq() {
      return "mob.zombie.death";
   }

   protected void a(BlockPosition var1, Block var2) {
      this.a("mob.zombie.step", 0.15F, 1.0F);
   }

   protected Item D() {
      return Items.bv;
   }

   public class_qf bz() {
      return class_qf.b;
   }

   protected void br() {
      switch(this.V.nextInt(3)) {
      case 0:
         this.a(Items.l, 1);
         break;
      case 1:
         this.a(Items.bU, 1);
         break;
      case 2:
         this.a(Items.bV, 1);
      }

   }

   protected void a(class_on var1) {
      super.a(var1);
      if(this.V.nextFloat() < (this.o.ab() == class_om.d?0.05F:0.01F)) {
         int var2 = this.V.nextInt(3);
         if(var2 == 0) {
            this.a((class_pw)class_pw.a, (class_aas)(new class_aas(Items.n)));
         } else {
            this.a((class_pw)class_pw.a, (class_aas)(new class_aas(Items.a)));
         }
      }

   }

   public void b(class_dn var1) {
      super.b(var1);
      if(this.j_()) {
         var1.a("IsBaby", true);
      }

      if(this.cD()) {
         var1.a("IsVillager", true);
      }

      var1.a("ConversionTime", this.cE()?this.bw:-1);
      var1.a("CanBreakDoors", this.cC());
   }

   public void a(class_dn var1) {
      super.a(var1);
      if(var1.o("IsBaby")) {
         this.m(true);
      }

      if(var1.o("IsVillager")) {
         this.n(true);
      }

      if(var1.b("ConversionTime", 99) && var1.g("ConversionTime") > -1) {
         this.a(var1.g("ConversionTime"));
      }

      this.a(var1.o("CanBreakDoors"));
   }

   public void a(class_qa var1) {
      super.a(var1);
      if((this.o.ab() == class_om.c || this.o.ab() == class_om.d) && var1 instanceof class_wv) {
         if(this.o.ab() != class_om.d && this.V.nextBoolean()) {
            return;
         }

         class_qb var2 = (class_qb)var1;
         class_wr var3 = new class_wr(this.o);
         var3.m(var1);
         this.o.e((class_pr)var1);
         var3.a((class_on)this.o.E(new BlockPosition(var3)), (class_qd)null);
         var3.n(true);
         if(var1.j_()) {
            var3.m(true);
         }

         var3.k(var2.cs());
         if(var2.l_()) {
            var3.a((String)var2.aO());
            var3.g(var2.aP());
         }

         this.o.a((class_pr)var3);
         this.o.a((class_xa)null, 1016, new BlockPosition((int)this.s, (int)this.t, (int)this.u), 0);
      }

   }

   public float aU() {
      float var1 = 1.74F;
      if(this.j_()) {
         var1 = (float)((double)var1 - 0.81D);
      }

      return var1;
   }

   protected boolean a(class_aas var1) {
      return var1.b() == Items.aR && this.j_() && this.aw()?false:super.a(var1);
   }

   public class_qd a(class_on var1, class_qd var2) {
      Object var7 = super.a(var1, var2);
      float var3 = var1.c();
      this.j(this.V.nextFloat() < 0.55F * var3);
      if(var7 == null) {
         var7 = new class_wr.class_a_in_class_wr(this.o.s.nextFloat() < 0.05F, this.o.s.nextFloat() < 0.05F);
      }

      if(var7 instanceof class_wr.class_a_in_class_wr) {
         class_wr.class_a_in_class_wr var4 = (class_wr.class_a_in_class_wr)var7;
         if(var4.b) {
            this.n(true);
         }

         if(var4.a) {
            this.m(true);
            if((double)this.o.s.nextFloat() < 0.05D) {
               List var5 = this.o.a(class_tx.class, this.aT().b(5.0D, 3.0D, 5.0D), class_pv.b);
               if(!var5.isEmpty()) {
                  class_tx var6 = (class_tx)var5.get(0);
                  var6.m(true);
                  this.a((class_pr)var6);
               }
            } else if((double)this.o.s.nextFloat() < 0.05D) {
               class_tx var10 = new class_tx(this.o);
               var10.b(this.s, this.t, this.u, this.y, 0.0F);
               var10.a(var1, (class_qd)null);
               var10.m(true);
               this.o.a((class_pr)var10);
               this.a((class_pr)var10);
            }
         }
      }

      this.a(this.V.nextFloat() < var3 * 0.1F);
      this.a(var1);
      this.b((class_on)var1);
      if(this.a((class_pw)class_pw.f) == null) {
         Calendar var8 = this.o.Z();
         if(var8.get(2) + 1 == 10 && var8.get(5) == 31 && this.V.nextFloat() < 0.25F) {
            this.a((class_pw)class_pw.f, (class_aas)(new class_aas(this.V.nextFloat() < 0.1F?Blocks.LIT_PUMPKIN:Blocks.PUMPKIN)));
            this.bp[class_pw.f.b()] = 0.0F;
         }
      }

      this.a((class_qk)class_wl.c).b(new class_qm("Random spawn bonus", this.V.nextDouble() * 0.05000000074505806D, 0));
      double var9 = this.V.nextDouble() * 1.5D * (double)var3;
      if(var9 > 1.0D) {
         this.a((class_qk)class_wl.b).b(new class_qm("Random zombie-spawn bonus", var9, 2));
      }

      if(this.V.nextFloat() < var3 * 0.05F) {
         this.a((class_qk)a).b(new class_qm("Leader zombie bonus", this.V.nextDouble() * 0.25D + 0.5D, 0));
         this.a((class_qk)class_wl.a).b(new class_qm("Leader zombie bonus", this.V.nextDouble() * 3.0D + 1.0D, 2));
         this.a(true);
      }

      return (class_qd)var7;
   }

   public boolean a(class_xa var1, EnumUsedHand var2, class_aas var3) {
      if(var3 != null && var3.b() == Items.aq && var3.i() == 0 && this.cD() && this.a((class_pk)class_pm.r)) {
         if(!var1.bH.d) {
            --var3.b;
         }

         if(!this.o.D) {
            this.a(this.V.nextInt(2401) + 3600);
         }

         return true;
      } else {
         return false;
      }
   }

   protected void a(int var1) {
      this.bw = var1;
      this.H().b(bu, Byte.valueOf((byte)1));
      this.d(class_pm.r);
      this.c(new class_pl(class_pm.e, var1, Math.min(this.o.ab().a() - 1, 0)));
      this.o.a((class_pr)this, (byte)16);
   }

   protected boolean E() {
      return !this.cE();
   }

   public boolean cE() {
      return this.H().a(bu) == 1;
   }

   protected void cF() {
      class_wv var1 = new class_wv(this.o);
      var1.m(this);
      var1.a(this.o.E(new BlockPosition(var1)), (class_qd)null);
      var1.cE();
      if(this.j_()) {
         var1.b(-24000);
      }

      this.o.e((class_pr)this);
      var1.k(this.cs());
      if(this.l_()) {
         var1.a((String)this.aO());
         var1.g(this.aP());
      }

      this.o.a((class_pr)var1);
      var1.c(new class_pl(class_pm.i, 200, 0));
      this.o.a((class_xa)null, 1017, new BlockPosition((int)this.s, (int)this.t, (int)this.u), 0);
   }

   protected int cG() {
      int var1 = 1;
      if(this.V.nextFloat() < 0.01F) {
         int var2 = 0;
         BlockPosition.MutableBlockPosition var3 = new BlockPosition.MutableBlockPosition();

         for(int var4 = (int)this.s - 4; var4 < (int)this.s + 4 && var2 < 14; ++var4) {
            for(int var5 = (int)this.t - 4; var5 < (int)this.t + 4 && var2 < 14; ++var5) {
               for(int var6 = (int)this.u - 4; var6 < (int)this.u + 4 && var2 < 14; ++var6) {
                  Block var7 = this.o.p(var3.setPosition(var4, var5, var6)).getBlock();
                  if(var7 == Blocks.IRON_BARS || var7 == Blocks.BED) {
                     if(this.V.nextFloat() < 0.3F) {
                        ++var1;
                     }

                     ++var2;
                  }
               }
            }
         }
      }

      return var1;
   }

   public void o(boolean var1) {
      this.a(var1?0.5F:1.0F);
   }

   protected final void a(float var1, float var2) {
      boolean var3 = this.by > 0.0F && this.bz > 0.0F;
      this.by = var1;
      this.bz = var2;
      if(!var3) {
         this.a(1.0F);
      }

   }

   protected final void a(float var1) {
      super.a(this.by * var1, this.bz * var1);
   }

   public double am() {
      return this.j_()?0.0D:-0.35D;
   }

   public void a(class_pc var1) {
      super.a(var1);
      if(var1.j() instanceof class_wa && !(this instanceof class_wj) && ((class_wa)var1.j()).n() && ((class_wa)var1.j()).cE()) {
         ((class_wa)var1.j()).cF();
         this.a(new class_aas(Items.ca, 1, 2), 0.0F);
      }

   }

   static {
      c = new class_qm(b, "Baby speed boost", 0.5D, 1);
      bs = class_qi.a(class_wr.class);
      bt = class_qi.a(class_wr.class);
      bu = class_qi.a(class_wr.class);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
   }

   class class_a_in_class_wr implements class_qd {
      public boolean a;
      public boolean b;

      private class_a_in_class_wr(boolean var2, boolean var3) {
         this.a = false;
         this.b = false;
         this.a = var2;
         this.b = var3;
      }

      // $FF: synthetic method
      class_a_in_class_wr(boolean var2, boolean var3, class_wr.SyntheticClass_1 var4) {
         this(var2, var3);
      }
   }
}
