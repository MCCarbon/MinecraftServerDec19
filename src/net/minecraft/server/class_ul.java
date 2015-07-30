package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.class_aan;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_dn;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_po;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qj;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_rc;
import net.minecraft.server.class_re;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_rk;
import net.minecraft.server.class_rq;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_ru;
import net.minecraft.server.class_sh;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sw;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_ta;
import net.minecraft.server.class_tb;
import net.minecraft.server.class_tc;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_tw;
import net.minecraft.server.class_tz;
import net.minecraft.server.class_ue;
import net.minecraft.server.class_uf;
import net.minecraft.server.class_wa;
import net.minecraft.server.class_we;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_wn;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xd;
import net.minecraft.server.class_zy;

public class class_ul extends class_qj {
   private static final int bw = class_qi.a(class_ul.class);
   private static final int bx = class_qi.a(class_ul.class);
   private static final int by = class_qi.a(class_ul.class);
   private float bz;
   private float bA;
   private boolean bB;
   private boolean bC;
   private float bD;
   private float bE;

   public class_ul(World var1) {
      super(var1);
      this.a(0.6F, 0.8F);
      ((class_tf)this.u()).a(true);
      this.i.a(1, new class_rj(this));
      this.i.a(2, this.bu);
      this.i.a(3, new class_rq(this, 0.4F));
      this.i.a(4, new class_ru(this, 1.0D, true));
      this.i.a(5, new class_rk(this, 1.0D, 10.0F, 2.0F));
      this.i.a(6, new class_re(this, 1.0D));
      this.i.a(7, new class_si(this, 1.0D));
      this.i.a(8, new class_rc(this, 8.0F));
      this.i.a(9, new class_rr(this, class_xa.class, 8.0F));
      this.i.a(9, new class_sh(this));
      this.bn.a(1, new class_tb(this));
      this.bn.a(2, new class_tc(this));
      this.bn.a(3, new class_sw(this, true, new Class[0]));
      this.bn.a(4, new class_ta(this, class_tw.class, false, new Predicate() {
         public boolean a(class_pr var1) {
            return var1 instanceof class_uf || var1 instanceof class_ue;
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_pr)var1);
         }
      }));
      this.bn.a(5, new class_sz(this, class_wn.class, false));
      this.n(false);
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.d).a(0.30000001192092896D);
      if(this.cA()) {
         this.a((class_qk)class_wl.a).a(20.0D);
      } else {
         this.a((class_qk)class_wl.a).a(8.0D);
      }

      this.by().b(class_wl.e);
      this.a((class_qk)class_wl.e).a(2.0D);
   }

   public void d(class_qa var1) {
      super.d(var1);
      if(var1 == null) {
         this.p(false);
      } else if(!this.cA()) {
         this.p(true);
      }

   }

   protected void cc() {
      this.ac.b(bw, Float.valueOf(this.bo()));
   }

   protected void h() {
      super.h();
      this.ac.a(bw, new Float(this.bo()));
      this.ac.a(bx, new Byte((byte)0));
      this.ac.a(by, new Byte((byte)class_zy.o.a()));
   }

   protected void a(BlockPosition var1, Block var2) {
      this.a("mob.wolf.step", 0.15F, 1.0F);
   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("Angry", this.cK());
      var1.a("CollarColor", (byte)this.cL().b());
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.p(var1.o("Angry"));
      if(var1.b("CollarColor", 99)) {
         this.a(class_zy.a(var1.e("CollarColor")));
      }

   }

   protected String C() {
      return this.cK()?"mob.wolf.growl":(this.V.nextInt(3) == 0?(this.cA() && this.ac.d(bw) < 10.0F?"mob.wolf.whine":"mob.wolf.panting"):"mob.wolf.bark");
   }

   protected String bp() {
      return "mob.wolf.hurt";
   }

   protected String bq() {
      return "mob.wolf.death";
   }

   protected float bC() {
      return 0.4F;
   }

   protected Item D() {
      return Item.getById(-1);
   }

   public void m() {
      super.m();
      if(!this.o.D && this.bB && !this.bC && !this.cu() && this.C) {
         this.bC = true;
         this.bD = 0.0F;
         this.bE = 0.0F;
         this.o.a((class_pr)this, (byte)8);
      }

      if(!this.o.D && this.w() == null && this.cK()) {
         this.p(false);
      }

   }

   public void t_() {
      super.t_();
      this.bA = this.bz;
      if(this.cM()) {
         this.bz += (1.0F - this.bz) * 0.4F;
      } else {
         this.bz += (0.0F - this.bz) * 0.4F;
      }

      if(this.U()) {
         this.bB = true;
         this.bC = false;
         this.bD = 0.0F;
         this.bE = 0.0F;
      } else if((this.bB || this.bC) && this.bC) {
         if(this.bD == 0.0F) {
            this.a("mob.wolf.shake", this.bC(), (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
         }

         this.bE = this.bD;
         this.bD += 0.05F;
         if(this.bE >= 2.0F) {
            this.bB = false;
            this.bC = false;
            this.bE = 0.0F;
            this.bD = 0.0F;
         }

         if(this.bD > 0.4F) {
            float var1 = (float)this.aT().b;
            int var2 = (int)(MathHelper.sin((this.bD - 0.4F) * 3.1415927F) * 7.0F);

            for(int var3 = 0; var3 < var2; ++var3) {
               float var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J * 0.5F;
               float var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J * 0.5F;
               this.o.a(class_cy.f, this.s + (double)var4, (double)(var1 + 0.8F), this.u + (double)var5, this.v, this.w, this.x, new int[0]);
            }
         }
      }

   }

   public float aU() {
      return this.K * 0.8F;
   }

   public int cd() {
      return this.cC()?20:super.cd();
   }

   public boolean a(class_pc var1, float var2) {
      if(this.b((class_pc)var1)) {
         return false;
      } else {
         class_pr var3 = var1.j();
         this.bu.a(false);
         if(var3 != null && !(var3 instanceof class_xa) && !(var3 instanceof class_xd)) {
            var2 = (var2 + 1.0F) / 2.0F;
         }

         return super.a(var1, var2);
      }
   }

   public boolean r(class_pr var1) {
      boolean var2 = var1.a(class_pc.a((class_qa)this), (float)((int)this.a((class_qk)class_wl.e).e()));
      if(var2) {
         this.a((class_qa)this, (class_pr)var1);
      }

      return var2;
   }

   public void n(boolean var1) {
      super.n(var1);
      if(var1) {
         this.a((class_qk)class_wl.a).a(20.0D);
      } else {
         this.a((class_qk)class_wl.a).a(8.0D);
      }

      this.a((class_qk)class_wl.e).a(4.0D);
   }

   public boolean a(class_xa var1, class_oo var2, class_aas var3) {
      if(this.cA()) {
         if(var3 != null) {
            if(var3.b() instanceof class_aan) {
               class_aan var4 = (class_aan)var3.b();
               if(var4.g() && this.ac.d(bw) < 20.0F) {
                  if(!var1.bH.d) {
                     --var3.b;
                  }

                  this.h((float)var4.h(var3));
                  return true;
               }
            } else if(var3.b() == Items.aY) {
               class_zy var5 = class_zy.a(var3.i());
               if(var5 != this.cL()) {
                  this.a(var5);
                  if(!var1.bH.d) {
                     --var3.b;
                  }

                  return true;
               }
            }
         }

         if(this.e(var1) && !this.o.D && !this.d(var3)) {
            this.bu.a(!this.cC());
            this.bb = false;
            this.h.n();
            this.d((class_qa)null);
         }
      } else if(var3 != null && var3.b() == Items.aZ && !this.cK()) {
         if(!var1.bH.d) {
            --var3.b;
         }

         if(!this.o.D) {
            if(this.V.nextInt(3) == 0) {
               this.n(true);
               this.h.n();
               this.d((class_qa)null);
               this.bu.a(true);
               this.i(20.0F);
               this.b((String)var1.aM().toString());
               this.m(true);
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

   public boolean d(class_aas var1) {
      return var1 == null?false:(!(var1.b() instanceof class_aan)?false:((class_aan)var1.b()).g());
   }

   public int cj() {
      return 8;
   }

   public boolean cK() {
      return (this.ac.a(bs) & 2) != 0;
   }

   public void p(boolean var1) {
      byte var2 = this.ac.a(bs);
      if(var1) {
         this.ac.b(bs, Byte.valueOf((byte)(var2 | 2)));
      } else {
         this.ac.b(bs, Byte.valueOf((byte)(var2 & -3)));
      }

   }

   public class_zy cL() {
      return class_zy.a(this.ac.a(by) & 15);
   }

   public void a(class_zy var1) {
      this.ac.b(by, Byte.valueOf((byte)(var1.b() & 15)));
   }

   public class_ul b(class_po var1) {
      class_ul var2 = new class_ul(this.o);
      String var3 = this.b();
      if(var3 != null && !var3.trim().isEmpty()) {
         var2.b((String)var3);
         var2.n(true);
      }

      return var2;
   }

   public void q(boolean var1) {
      if(var1) {
         this.ac.b(bx, Byte.valueOf((byte)1));
      } else {
         this.ac.b(bx, Byte.valueOf((byte)0));
      }

   }

   public boolean a(class_tw var1) {
      if(var1 == this) {
         return false;
      } else if(!this.cA()) {
         return false;
      } else if(!(var1 instanceof class_ul)) {
         return false;
      } else {
         class_ul var2 = (class_ul)var1;
         return !var2.cA()?false:(var2.cC()?false:this.cG() && var2.cG());
      }
   }

   public boolean cM() {
      return this.ac.a(bx) == 1;
   }

   protected boolean E() {
      return !this.cA() && this.W > 2400;
   }

   public boolean a(class_qa var1, class_qa var2) {
      if(!(var1 instanceof class_wa) && !(var1 instanceof class_we)) {
         if(var1 instanceof class_ul) {
            class_ul var3 = (class_ul)var1;
            if(var3.cA() && var3.cD() == var2) {
               return false;
            }
         }

         return var1 instanceof class_xa && var2 instanceof class_xa && !((class_xa)var2).a((class_xa)var1)?false:!(var1 instanceof class_tz) || !((class_tz)var1).cD();
      } else {
         return false;
      }
   }

   public boolean cp() {
      return !this.cK() && super.cp();
   }

   // $FF: synthetic method
   public class_po a(class_po var1) {
      return this.b(var1);
   }
}
