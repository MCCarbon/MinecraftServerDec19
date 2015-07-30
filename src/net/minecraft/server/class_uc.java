package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_on;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_po;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qj;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_rb;
import net.minecraft.server.class_re;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_rk;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_rq;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_sa;
import net.minecraft.server.class_sb;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sr;
import net.minecraft.server.class_ta;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_tw;
import net.minecraft.server.class_tx;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;

public class class_uc extends class_qj {
   private static final int bw = class_qi.a(class_uc.class);
   private class_rb bx;
   private class_sr by;

   public class_uc(World var1) {
      super(var1);
      this.a(0.6F, 0.7F);
      ((class_tf)this.u()).a(true);
      this.i.a(1, new class_rj(this));
      this.i.a(2, this.bu);
      this.i.a(3, this.by = new class_sr(this, 0.6D, Items.aW, true));
      this.i.a(5, new class_rk(this, 1.0D, 10.0F, 5.0F));
      this.i.a(6, new class_sb(this, 0.8D));
      this.i.a(7, new class_rq(this, 0.3F));
      this.i.a(8, new class_sa(this));
      this.i.a(9, new class_re(this, 0.8D));
      this.i.a(10, new class_si(this, 0.8D));
      this.i.a(11, new class_rr(this, class_xa.class, 10.0F));
      this.bn.a(1, new class_ta(this, class_tx.class, false, (Predicate)null));
   }

   protected void h() {
      super.h();
      this.ac.a(bw, Byte.valueOf((byte)0));
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

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("CatType", this.cI());
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.m(var1.g("CatType"));
   }

   protected String C() {
      return this.cA()?(this.cG()?"mob.cat.purr":(this.V.nextInt(4) == 0?"mob.cat.purreow":"mob.cat.meow")):"";
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
      return Items.aH;
   }

   public boolean r(class_pr var1) {
      return var1.a(class_pc.a((class_qa)this), 3.0F);
   }

   public boolean a(class_pc var1, float var2) {
      if(this.b((class_pc)var1)) {
         return false;
      } else {
         this.bu.a(false);
         return super.a(var1, var2);
      }
   }

   protected void b(boolean var1, int var2) {
   }

   public boolean a(class_xa var1, class_oo var2, class_aas var3) {
      if(this.cA()) {
         if(this.e(var1) && !this.o.D && !this.d(var3)) {
            this.bu.a(!this.cC());
         }
      } else if(this.by.f() && var3 != null && var3.b() == Items.aW && var1.h(this) < 9.0D) {
         if(!var1.bH.d) {
            --var3.b;
         }

         if(!this.o.D) {
            if(this.V.nextInt(3) == 0) {
               this.n(true);
               this.m(1 + this.o.s.nextInt(3));
               this.b((String)var1.aM().toString());
               this.m(true);
               this.bu.a(true);
               this.o.a((class_pr)this, (byte)7);
            } else {
               this.m(false);
               this.o.a((class_pr)this, (byte)6);
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

   public boolean d(class_aas var1) {
      return var1 != null && var1.b() == Items.aW;
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
      return this.ac.a(bw);
   }

   public void m(int var1) {
      this.ac.b(bw, Byte.valueOf((byte)var1));
   }

   public boolean cf() {
      return this.o.s.nextInt(3) != 0;
   }

   public boolean cg() {
      if(this.o.a((class_awf)this.aT(), (class_pr)this) && this.o.a((class_pr)this, (class_awf)this.aT()).isEmpty() && !this.o.d(this.aT())) {
         BlockPosition var1 = new BlockPosition(this.s, this.aT().b, this.u);
         if(var1.getY() < this.o.G()) {
            return false;
         }

         Block var2 = this.o.p(var1.shiftDown()).getBlock();
         if(var2 == Blocks.GRASS || var2.getMaterial() == Material.LEAVES) {
            return true;
         }
      }

      return false;
   }

   public String e_() {
      return this.l_()?this.aO():(this.cA()?LocaleI18n.get("entity.Cat.name"):super.e_());
   }

   public void n(boolean var1) {
      super.n(var1);
   }

   protected void cB() {
      if(this.bx == null) {
         this.bx = new class_rb(this, class_xa.class, 16.0F, 0.8D, 1.33D);
      }

      this.i.a((class_rm)this.bx);
      if(!this.cA()) {
         this.i.a(4, this.bx);
      }

   }

   public class_qd a(class_on var1, class_qd var2) {
      var2 = super.a(var1, var2);
      if(this.o.s.nextInt(7) == 0) {
         for(int var3 = 0; var3 < 2; ++var3) {
            class_uc var4 = new class_uc(this.o);
            var4.b(this.s, this.t, this.u, this.y, 0.0F);
            var4.b(-24000);
            this.o.a((class_pr)var4);
         }
      }

      return var2;
   }

   // $FF: synthetic method
   public class_po a(class_po var1) {
      return this.b(var1);
   }
}
