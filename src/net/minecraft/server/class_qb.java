package net.minecraft.server;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_abw;
import net.minecraft.server.class_adk;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dr;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.Packet;
import net.minecraft.server.class_hl;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_om;
import net.minecraft.server.class_on;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qj;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_qm;
import net.minecraft.server.class_qv;
import net.minecraft.server.class_qx;
import net.minecraft.server.class_qy;
import net.minecraft.server.class_qz;
import net.minecraft.server.class_rn;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_tg;
import net.minecraft.server.class_tk;
import net.minecraft.server.class_uz;
import net.minecraft.server.class_vb;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_wd;
import net.minecraft.server.class_we;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_za;
import net.minecraft.server.ItemBlock;
import net.minecraft.server.class_zl;

public abstract class class_qb extends class_qa {
   private static final int a = class_qi.a(class_qb.class);
   public int a_;
   protected int b_;
   private class_qy b;
   protected class_qz f;
   protected class_qx g;
   private class_qv c;
   protected class_tg h;
   protected final class_rn i;
   protected final class_rn bn;
   private class_qa bq;
   private class_tk br;
   private class_aas[] bs = new class_aas[2];
   protected float[] bo = new float[2];
   private class_aas[] bt = new class_aas[4];
   protected float[] bp = new float[4];
   private boolean bu;
   private boolean bv;
   private boolean bw;
   private class_pr bx;
   private class_dn by;

   public class_qb(World var1) {
      super(var1);
      this.i = new class_rn(var1 != null && var1.B != null?var1.B:null);
      this.bn = new class_rn(var1 != null && var1.B != null?var1.B:null);
      this.b = new class_qy(this);
      this.f = new class_qz(this);
      this.g = new class_qx(this);
      this.c = this.p();
      this.h = this.b(var1);
      this.br = new class_tk(this);

      int var2;
      for(var2 = 0; var2 < this.bp.length; ++var2) {
         this.bp[var2] = 0.085F;
      }

      for(var2 = 0; var2 < this.bo.length; ++var2) {
         this.bo[var2] = 0.085F;
      }

   }

   protected void aY() {
      super.aY();
      this.by().b(class_wl.b).a(16.0D);
   }

   protected class_tg b(World var1) {
      return new class_tf(this, var1);
   }

   protected class_qv p() {
      return new class_qv(this);
   }

   public class_qy q() {
      return this.b;
   }

   public class_qz r() {
      return this.f;
   }

   public class_qx t() {
      return this.g;
   }

   public class_tg u() {
      return this.h;
   }

   public class_tk v() {
      return this.br;
   }

   public class_qa w() {
      return this.bq;
   }

   public void d(class_qa var1) {
      this.bq = var1;
   }

   public boolean a(Class var1) {
      return var1 != class_we.class;
   }

   public void x() {
   }

   protected void h() {
      super.h();
      this.ac.a(a, Byte.valueOf((byte)0));
   }

   public int y() {
      return 80;
   }

   public void z() {
      String var1 = this.C();
      if(var1 != null) {
         this.a(var1, this.bC(), this.bD());
      }

   }

   public void K() {
      super.K();
      this.o.B.a("mobBaseTick");
      if(this.ai() && this.V.nextInt(1000) < this.a_++) {
         this.a_ = -this.y();
         this.z();
      }

      this.o.B.b();
   }

   protected int b(class_xa var1) {
      if(this.b_ > 0) {
         int var2 = this.b_;

         int var3;
         for(var3 = 0; var3 < this.bt.length; ++var3) {
            if(this.bt[var3] != null && this.bp[var3] <= 1.0F) {
               var2 += 1 + this.V.nextInt(3);
            }
         }

         for(var3 = 0; var3 < this.bs.length; ++var3) {
            if(this.bs[var3] != null && this.bo[var3] <= 1.0F) {
               var2 += 1 + this.V.nextInt(3);
            }
         }

         return var2;
      } else {
         return this.b_;
      }
   }

   public void A() {
      if(this.o.D) {
         for(int var1 = 0; var1 < 20; ++var1) {
            double var2 = this.V.nextGaussian() * 0.02D;
            double var4 = this.V.nextGaussian() * 0.02D;
            double var6 = this.V.nextGaussian() * 0.02D;
            double var8 = 10.0D;
            this.o.a(class_cy.a, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J - var2 * var8, this.t + (double)(this.V.nextFloat() * this.K) - var4 * var8, this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J - var6 * var8, var2, var4, var6, new int[0]);
         }
      } else {
         this.o.a((class_pr)this, (byte)20);
      }

   }

   public void t_() {
      super.t_();
      if(!this.o.D) {
         this.co();
      }

   }

   protected float h(float var1, float var2) {
      this.c.a();
      return var2;
   }

   protected String C() {
      return null;
   }

   protected Item D() {
      return null;
   }

   protected void b(boolean var1, int var2) {
      Item var3 = this.D();
      if(var3 != null) {
         int var4 = this.V.nextInt(3);
         if(var2 > 0) {
            var4 += this.V.nextInt(var2 + 1);
         }

         for(int var5 = 0; var5 < var4; ++var5) {
            this.a(var3, 1);
         }
      }

   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("CanPickUpLoot", this.cm());
      var1.a("PersistenceRequired", this.bv);
      class_du var2 = new class_du();

      for(int var3 = 0; var3 < this.bt.length; ++var3) {
         class_dn var4 = new class_dn();
         if(this.bt[var3] != null) {
            this.bt[var3].b(var4);
         }

         var2.a((class_eb)var4);
      }

      var1.a((String)"ArmorItems", (class_eb)var2);
      class_du var8 = new class_du();

      for(int var9 = 0; var9 < this.bs.length; ++var9) {
         class_dn var5 = new class_dn();
         if(this.bs[var9] != null) {
            this.bs[var9].b(var5);
         }

         var8.a((class_eb)var5);
      }

      var1.a((String)"HandItems", (class_eb)var8);
      class_du var10 = new class_du();

      for(int var11 = 0; var11 < this.bp.length; ++var11) {
         var10.a((class_eb)(new class_dr(this.bp[var11])));
      }

      var1.a((String)"ArmorDropChances", (class_eb)var10);
      class_du var12 = new class_du();

      for(int var6 = 0; var6 < this.bo.length; ++var6) {
         var12.a((class_eb)(new class_dr(this.bo[var6])));
      }

      var1.a((String)"HandDropChances", (class_eb)var12);
      var1.a("Leashed", this.bw);
      if(this.bx != null) {
         class_dn var13 = new class_dn();
         if(this.bx instanceof class_qa) {
            var13.a("UUIDMost", this.bx.aM().getMostSignificantBits());
            var13.a("UUIDLeast", this.bx.aM().getLeastSignificantBits());
         } else if(this.bx instanceof class_uz) {
            BlockPosition var7 = ((class_uz)this.bx).n();
            var13.a("X", var7.getX());
            var13.a("Y", var7.getY());
            var13.a("Z", var7.getZ());
         }

         var1.a((String)"Leash", (class_eb)var13);
      }

      var1.a("LeftHanded", this.ct());
      if(this.cs()) {
         var1.a("NoAI", this.cs());
      }

   }

   public void a(class_dn var1) {
      super.a(var1);
      if(var1.b("CanPickUpLoot", 1)) {
         this.j(var1.o("CanPickUpLoot"));
      }

      this.bv = var1.o("PersistenceRequired");
      class_du var3;
      int var4;
      class_du var5;
      int var7;
      if(var1.b("Equipment", 9)) {
         class_aas[] var2 = new class_aas[5];
         var3 = var1.c("Equipment", 10);

         for(var4 = 0; var4 < var2.length; ++var4) {
            var2[var4] = class_aas.a(var3.b(var4));
         }

         this.bs[class_pw.a.b()] = var2[0];
         this.bt[class_pw.c.b()] = var2[1];
         this.bt[class_pw.d.b()] = var2[2];
         this.bt[class_pw.e.b()] = var2[3];
         this.bt[class_pw.f.b()] = var2[4];
      } else {
         if(var1.b("ArmorItems", 9)) {
            var5 = var1.c("ArmorItems", 10);

            for(var7 = 0; var7 < this.bt.length; ++var7) {
               this.bt[var7] = class_aas.a(var5.b(var7));
            }
         }

         if(var1.b("HandItems", 9)) {
            var5 = var1.c("HandItems", 10);

            for(var7 = 0; var7 < this.bs.length; ++var7) {
               this.bs[var7] = class_aas.a(var5.b(var7));
            }
         }
      }

      if(var1.b("DropChances", 9)) {
         float[] var6 = new float[5];
         var3 = var1.c("DropChances", 5);

         for(var4 = 0; var4 < var3.c(); ++var4) {
            var6[var4] = var3.f(var4);
         }

         this.bo[0] = var6[0];
         this.bp[0] = var6[1];
         this.bp[1] = var6[2];
         this.bp[2] = var6[3];
         this.bp[3] = var6[4];
      } else {
         if(var1.b("ArmorDropChances", 9)) {
            var5 = var1.c("ArmorDropChances", 5);

            for(var7 = 0; var7 < var5.c(); ++var7) {
               this.bp[var7] = var5.f(var7);
            }
         }

         if(var1.b("HandDropChances", 9)) {
            var5 = var1.c("HandDropChances", 5);

            for(var7 = 0; var7 < var5.c(); ++var7) {
               this.bo[var7] = var5.f(var7);
            }
         }
      }

      this.bw = var1.o("Leashed");
      if(this.bw && var1.b("Leash", 10)) {
         this.by = var1.n("Leash");
      }

      this.l(var1.o("LeftHanded"));
      this.k(var1.o("NoAI"));
   }

   public void n(float var1) {
      this.bd = var1;
   }

   public void k(float var1) {
      super.k(var1);
      this.n(var1);
   }

   public void m() {
      super.m();
      this.o.B.a("looting");
      if(!this.o.D && this.cm() && !this.aS && this.o.R().b("mobGriefing")) {
         List var1 = this.o.a(class_vm.class, this.aT().b(1.0D, 0.0D, 1.0D));
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            class_vm var3 = (class_vm)var2.next();
            if(!var3.I && var3.l() != null && !var3.s()) {
               this.a(var3);
            }
         }
      }

      this.o.B.b();
   }

   protected void a(class_vm var1) {
      class_aas var2 = var1.l();
      class_pw var3 = c(var2);
      boolean var4 = true;
      class_aas var5 = this.a(var3);
      if(var5 != null) {
         if(var3.a() == class_pw.class_a_in_class_pw.a) {
            if(var2.b() instanceof class_abw && !(var5.b() instanceof class_abw)) {
               var4 = true;
            } else if(var2.b() instanceof class_abw && var5.b() instanceof class_abw) {
               class_abw var6 = (class_abw)var2.b();
               class_abw var7 = (class_abw)var5.b();
               if(var6.g() == var7.g()) {
                  var4 = var2.i() > var5.i() || var2.n() && !var5.n();
               } else {
                  var4 = var6.g() > var7.g();
               }
            } else if(var2.b() instanceof class_zl && var5.b() instanceof class_zl) {
               var4 = var2.n() && !var5.n();
            } else {
               var4 = false;
            }
         } else if(var2.b() instanceof class_za && !(var5.b() instanceof class_za)) {
            var4 = true;
         } else if(var2.b() instanceof class_za && var5.b() instanceof class_za) {
            class_za var9 = (class_za)var2.b();
            class_za var11 = (class_za)var5.b();
            if(var9.c == var11.c) {
               var4 = var2.i() > var5.i() || var2.n() && !var5.n();
            } else {
               var4 = var9.c > var11.c;
            }
         } else {
            var4 = false;
         }
      }

      if(var4 && this.a(var2)) {
         double var10;
         switch(class_qb.SyntheticClass_1.a[var3.a().ordinal()]) {
         case 1:
            var10 = (double)this.bo[var3.b()];
            break;
         case 2:
            var10 = (double)this.bp[var3.b()];
            break;
         default:
            var10 = 0.0D;
         }

         if(var5 != null && (double)(this.V.nextFloat() - 0.1F) < var10) {
            this.a(var5, 0.0F);
         }

         if(var2.b() == Items.k && var1.n() != null) {
            class_xa var8 = this.o.a(var1.n());
            if(var8 != null) {
               var8.b((class_my)class_mt.x);
            }
         }

         this.a(var3, var2);
         switch(class_qb.SyntheticClass_1.a[var3.a().ordinal()]) {
         case 1:
            this.bo[var3.b()] = 2.0F;
            break;
         case 2:
            this.bp[var3.b()] = 2.0F;
         }

         this.bv = true;
         this.a(var1, 1);
         var1.J();
      }

   }

   protected boolean a(class_aas var1) {
      return true;
   }

   protected boolean E() {
      return true;
   }

   protected void cb() {
      if(this.bv) {
         this.aT = 0;
      } else {
         class_xa var1 = this.o.a(this, -1.0D);
         if(var1 != null) {
            double var2 = var1.s - this.s;
            double var4 = var1.t - this.t;
            double var6 = var1.u - this.u;
            double var8 = var2 * var2 + var4 * var4 + var6 * var6;
            if(this.E() && var8 > 16384.0D) {
               this.J();
            }

            if(this.aT > 600 && this.V.nextInt(800) == 0 && var8 > 1024.0D && this.E()) {
               this.J();
            } else if(var8 < 1024.0D) {
               this.aT = 0;
            }
         }

      }
   }

   protected final void bL() {
      ++this.aT;
      this.o.B.a("checkDespawn");
      this.cb();
      this.o.B.b();
      this.o.B.a("sensing");
      this.br.a();
      this.o.B.b();
      this.o.B.a("targetSelector");
      this.bn.a();
      this.o.B.b();
      this.o.B.a("goalSelector");
      this.i.a();
      this.o.B.b();
      this.o.B.a("navigation");
      this.h.k();
      this.o.B.b();
      this.o.B.a("mob tick");
      this.cc();
      this.o.B.b();
      this.o.B.a("controls");
      this.o.B.a("move");
      this.f.c();
      this.o.B.c("look");
      this.b.a();
      this.o.B.c("jump");
      this.g.b();
      this.o.B.b();
      this.o.B.b();
   }

   protected void cc() {
   }

   public int cd() {
      return 40;
   }

   public int ce() {
      return 10;
   }

   public void a(class_pr var1, float var2, float var3) {
      double var4 = var1.s - this.s;
      double var8 = var1.u - this.u;
      double var6;
      if(var1 instanceof class_qa) {
         class_qa var10 = (class_qa)var1;
         var6 = var10.t + (double)var10.aU() - (this.t + (double)this.aU());
      } else {
         var6 = (var1.aT().b + var1.aT().e) / 2.0D - (this.t + (double)this.aU());
      }

      double var14 = (double)MathHelper.sqrt(var4 * var4 + var8 * var8);
      float var12 = (float)(MathHelper.b(var8, var4) * 180.0D / 3.1415927410125732D) - 90.0F;
      float var13 = (float)(-(MathHelper.b(var6, var14) * 180.0D / 3.1415927410125732D));
      this.z = this.b(this.z, var13, var3);
      this.y = this.b(this.y, var12, var2);
   }

   private float b(float var1, float var2, float var3) {
      float var4 = MathHelper.clampAngle(var2 - var1);
      if(var4 > var3) {
         var4 = var3;
      }

      if(var4 < -var3) {
         var4 = -var3;
      }

      return var1 + var4;
   }

   public boolean cf() {
      return true;
   }

   public boolean cg() {
      return this.o.a((class_awf)this.aT(), (class_pr)this) && this.o.a((class_pr)this, (class_awf)this.aT()).isEmpty() && !this.o.d(this.aT());
   }

   public int cj() {
      return 4;
   }

   public int aG() {
      if(this.w() == null) {
         return 3;
      } else {
         int var1 = (int)(this.bo() - this.bv() * 0.33F);
         var1 -= (3 - this.o.ab().a()) * 4;
         if(var1 < 0) {
            var1 = 0;
         }

         return var1 + 3;
      }
   }

   public Iterable as() {
      return Arrays.asList(this.bs);
   }

   public Iterable at() {
      return Arrays.asList(this.bt);
   }

   public class_aas a(class_pw var1) {
      class_aas var2 = null;
      switch(class_qb.SyntheticClass_1.a[var1.a().ordinal()]) {
      case 1:
         var2 = this.bs[var1.b()];
         break;
      case 2:
         var2 = this.bt[var1.b()];
      }

      return var2;
   }

   public void a(class_pw var1, class_aas var2) {
      switch(class_qb.SyntheticClass_1.a[var1.a().ordinal()]) {
      case 1:
         this.bs[var1.b()] = var2;
         break;
      case 2:
         this.bt[var1.b()] = var2;
      }

   }

   protected void a(boolean var1, int var2) {
      class_pw[] var3 = class_pw.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_pw var6 = var3[var5];
         class_aas var7 = this.a(var6);
         double var8;
         switch(class_qb.SyntheticClass_1.a[var6.a().ordinal()]) {
         case 1:
            var8 = (double)this.bo[var6.b()];
            break;
         case 2:
            var8 = (double)this.bp[var6.b()];
            break;
         default:
            var8 = 0.0D;
         }

         boolean var10 = var8 > 1.0D;
         if(var7 != null && (var1 || var10) && (double)(this.V.nextFloat() - (float)var2 * 0.01F) < var8) {
            if(!var10 && var7.e()) {
               int var11 = Math.max(var7.j() - 25, 1);
               int var12 = var7.j() - this.V.nextInt(this.V.nextInt(var11) + 1);
               if(var12 > var11) {
                  var12 = var11;
               }

               if(var12 < 1) {
                  var12 = 1;
               }

               var7.b(var12);
            }

            this.a(var7, 0.0F);
         }
      }

   }

   protected void a(class_on var1) {
      if(this.V.nextFloat() < 0.15F * var1.c()) {
         int var2 = this.V.nextInt(2);
         float var3 = this.o.ab() == class_om.d?0.1F:0.25F;
         if(this.V.nextFloat() < 0.095F) {
            ++var2;
         }

         if(this.V.nextFloat() < 0.095F) {
            ++var2;
         }

         if(this.V.nextFloat() < 0.095F) {
            ++var2;
         }

         boolean var4 = true;
         class_pw[] var5 = class_pw.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            class_pw var8 = var5[var7];
            if(var8.a() == class_pw.class_a_in_class_pw.b) {
               class_aas var9 = this.a(var8);
               if(!var4 && this.V.nextFloat() < var3) {
                  break;
               }

               var4 = false;
               if(var9 == null) {
                  Item var10 = a(var8, var2);
                  if(var10 != null) {
                     this.a(var8, new class_aas(var10));
                  }
               }
            }
         }
      }

   }

   public static class_pw c(class_aas var0) {
      return var0.b() != Item.getByBlock(Blocks.PUMPKIN) && var0.b() != Items.ca?(var0.b() instanceof class_za?((class_za)var0.b()).b:class_pw.a):class_pw.f;
   }

   public static Item a(class_pw var0, int var1) {
      switch(class_qb.SyntheticClass_1.b[var0.ordinal()]) {
      case 1:
         if(var1 == 0) {
            return Items.S;
         } else if(var1 == 1) {
            return Items.ai;
         } else if(var1 == 2) {
            return Items.W;
         } else if(var1 == 3) {
            return Items.aa;
         } else if(var1 == 4) {
            return Items.ae;
         }
      case 2:
         if(var1 == 0) {
            return Items.T;
         } else if(var1 == 1) {
            return Items.aj;
         } else if(var1 == 2) {
            return Items.X;
         } else if(var1 == 3) {
            return Items.ab;
         } else if(var1 == 4) {
            return Items.af;
         }
      case 3:
         if(var1 == 0) {
            return Items.U;
         } else if(var1 == 1) {
            return Items.ak;
         } else if(var1 == 2) {
            return Items.Y;
         } else if(var1 == 3) {
            return Items.ac;
         } else if(var1 == 4) {
            return Items.ag;
         }
      case 4:
         if(var1 == 0) {
            return Items.V;
         } else if(var1 == 1) {
            return Items.al;
         } else if(var1 == 2) {
            return Items.Z;
         } else if(var1 == 3) {
            return Items.ad;
         } else if(var1 == 4) {
            return Items.ah;
         }
      default:
         return null;
      }
   }

   protected void b(class_on var1) {
      float var2 = var1.c();
      if(this.bA() != null && this.V.nextFloat() < 0.25F * var2) {
         class_adk.a(this.V, this.bA(), (int)(5.0F + var2 * (float)this.V.nextInt(18)));
      }

      class_pw[] var3 = class_pw.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_pw var6 = var3[var5];
         if(var6.a() == class_pw.class_a_in_class_pw.b) {
            class_aas var7 = this.a(var6);
            if(var7 != null && this.V.nextFloat() < 0.5F * var2) {
               class_adk.a(this.V, var7, (int)(5.0F + var2 * (float)this.V.nextInt(18)));
            }
         }
      }

   }

   public class_qd a(class_on var1, class_qd var2) {
      this.a((class_qk)class_wl.b).b(new class_qm("Random spawn bonus", this.V.nextGaussian() * 0.05D, 1));
      if(this.V.nextFloat() < 0.05F) {
         this.l(true);
      } else {
         this.l(false);
      }

      return var2;
   }

   public boolean ck() {
      return false;
   }

   public void cl() {
      this.bv = true;
   }

   public void a(class_pw var1, float var2) {
      switch(class_qb.SyntheticClass_1.a[var1.a().ordinal()]) {
      case 1:
         this.bo[var1.b()] = var2;
         break;
      case 2:
         this.bp[var1.b()] = var2;
      }

   }

   public boolean cm() {
      return this.bu;
   }

   public void j(boolean var1) {
      this.bu = var1;
   }

   public boolean cn() {
      return this.bv;
   }

   public final boolean a(class_xa var1, class_aas var2, EnumUsedHand var3) {
      if(this.cq() && this.cr() == var1) {
         this.a(true, !var1.bH.d);
         return true;
      } else {
         if(var2 != null && var2.b() == Items.cq && this.cp()) {
            if(!(this instanceof class_qj) || !((class_qj)this).cA()) {
               this.a(var1, true);
               --var2.b;
               return true;
            }

            if(((class_qj)this).e(var1)) {
               this.a(var1, true);
               --var2.b;
               return true;
            }
         }

         return this.a(var1, var3, var2)?true:super.a(var1, var2, var3);
      }
   }

   protected boolean a(class_xa var1, EnumUsedHand var2, class_aas var3) {
      return false;
   }

   protected void co() {
      if(this.by != null) {
         this.n();
      }

      if(this.bw) {
         if(!this.ai()) {
            this.a(true, true);
         }

         if(this.bx == null || this.bx.I) {
            this.a(true, true);
         }
      }
   }

   public void a(boolean var1, boolean var2) {
      if(this.bw) {
         this.bw = false;
         this.bx = null;
         if(!this.o.D && var2) {
            this.a(Items.cq, 1);
         }

         if(!this.o.D && var1 && this.o instanceof class_lg) {
            ((class_lg)this.o).t().a((class_pr)this, (Packet)(new class_hl(1, this, (class_pr)null)));
         }
      }

   }

   public boolean cp() {
      return !this.cq() && !(this instanceof class_wd);
   }

   public boolean cq() {
      return this.bw;
   }

   public class_pr cr() {
      return this.bx;
   }

   public void a(class_pr var1, boolean var2) {
      this.bw = true;
      this.bx = var1;
      if(!this.o.D && var2 && this.o instanceof class_lg) {
         ((class_lg)this.o).t().a((class_pr)this, (Packet)(new class_hl(1, this, this.bx)));
      }

   }

   private void n() {
      if(this.bw && this.by != null) {
         if(this.by.b("UUIDMost", 4) && this.by.b("UUIDLeast", 4)) {
            UUID var5 = new UUID(this.by.h("UUIDMost"), this.by.h("UUIDLeast"));
            List var6 = this.o.a(class_qa.class, this.aT().b(10.0D, 10.0D, 10.0D));
            Iterator var3 = var6.iterator();

            while(var3.hasNext()) {
               class_qa var4 = (class_qa)var3.next();
               if(var4.aM().equals(var5)) {
                  this.bx = var4;
                  break;
               }
            }
         } else if(this.by.b("X", 99) && this.by.b("Y", 99) && this.by.b("Z", 99)) {
            BlockPosition var1 = new BlockPosition(this.by.g("X"), this.by.g("Y"), this.by.g("Z"));
            class_vb var2 = class_vb.b(this.o, var1);
            if(var2 == null) {
               var2 = class_vb.a(this.o, var1);
            }

            this.bx = var2;
         } else {
            this.a(false, true);
         }
      }

      this.by = null;
   }

   public boolean c(int var1, class_aas var2) {
      class_pw var3;
      if(var1 == 98) {
         var3 = class_pw.a;
      } else if(var1 == 99) {
         var3 = class_pw.b;
      } else if(var1 == 100 + class_pw.f.b()) {
         var3 = class_pw.f;
      } else if(var1 == 100 + class_pw.e.b()) {
         var3 = class_pw.e;
      } else if(var1 == 100 + class_pw.d.b()) {
         var3 = class_pw.d;
      } else {
         if(var1 != 100 + class_pw.c.b()) {
            return false;
         }

         var3 = class_pw.c;
      }

      if(var2 != null && c(var2) != var3 && (var3 != class_pw.f || !(var2.b() instanceof ItemBlock))) {
         return false;
      } else {
         this.a(var3, var2);
         return true;
      }
   }

   public boolean bN() {
      return super.bN() && !this.cs();
   }

   public void k(boolean var1) {
      byte var2 = this.ac.a(a);
      this.ac.b(a, Byte.valueOf(var1?(byte)(var2 | 1):(byte)(var2 & -2)));
   }

   public void l(boolean var1) {
      byte var2 = this.ac.a(a);
      this.ac.b(a, Byte.valueOf(var1?(byte)(var2 | 2):(byte)(var2 & -3)));
   }

   public boolean cs() {
      return (this.ac.a(a) & 1) != 0;
   }

   public boolean ct() {
      return (this.ac.a(a) & 2) != 0;
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[class_pw.values().length];

      static {
         try {
            b[class_pw.f.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            b[class_pw.e.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[class_pw.d.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            b[class_pw.c.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         a = new int[class_pw.class_a_in_class_pw.values().length];

         try {
            a[class_pw.class_a_in_class_pw.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_pw.class_a_in_class_pw.b.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_qb {
      a,
      b,
      c;
   }
}
