package net.minecraft.server;

import java.util.UUID;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_om;
import net.minecraft.server.class_on;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_qm;
import net.minecraft.server.class_sw;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_wr;
import net.minecraft.server.class_xa;

public class class_wj extends class_wr {
   private static final UUID b = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
   private static final class_qm c;
   private int bs;
   private int bt;
   private UUID bu;

   public class_wj(class_aen var1) {
      super(var1);
      this.ab = true;
   }

   public void b(class_qa var1) {
      super.b((class_qa)var1);
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
         this.a("mob.zombiepig.zpigangry", this.bC() * 2.0F, ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F) * 1.8F);
      }

      if(this.bs > 0 && this.bu != null && this.be() == null) {
         class_xa var2 = this.o.b(this.bu);
         this.b((class_qa)var2);
         this.aQ = var2;
         this.aR = this.bf();
      }

      super.cc();
   }

   public boolean cf() {
      return this.o.ab() != class_om.a;
   }

   public boolean cg() {
      return this.o.a((class_awf)this.aT(), (class_pr)this) && this.o.a((class_pr)this, (class_awf)this.aT()).isEmpty() && !this.o.d(this.aT());
   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("Anger", (short)this.bs);
      if(this.bu != null) {
         var1.a("HurtBy", this.bu.toString());
      } else {
         var1.a("HurtBy", "");
      }

   }

   public void a(class_dn var1) {
      super.a(var1);
      this.bs = var1.f("Anger");
      String var2 = var1.k("HurtBy");
      if(!var2.isEmpty()) {
         this.bu = UUID.fromString(var2);
         class_xa var3 = this.o.b(this.bu);
         this.b((class_qa)var3);
         if(var3 != null) {
            this.aQ = var3;
            this.aR = this.bf();
         }
      }

   }

   public boolean a(class_pc var1, float var2) {
      if(this.b((class_pc)var1)) {
         return false;
      } else {
         class_pr var3 = var1.j();
         if(var3 instanceof class_xa) {
            this.b(var3);
         }

         return super.a(var1, var2);
      }
   }

   private void b(class_pr var1) {
      this.bs = 400 + this.V.nextInt(400);
      this.bt = this.V.nextInt(40);
      if(var1 instanceof class_qa) {
         this.b((class_qa)var1);
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
      int var3 = this.V.nextInt(2 + var2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.a(class_aau.bv, 1);
      }

      var3 = this.V.nextInt(2 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         this.a(class_aau.bz, 1);
      }

   }

   public boolean a(class_xa var1, class_oo var2, class_aas var3) {
      return false;
   }

   protected void br() {
      this.a(class_aau.m, 1);
   }

   protected void a(class_on var1) {
      this.a((class_pw)class_pw.a, (class_aas)(new class_aas(class_aau.D)));
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
         super(var1, class_xa.class, true);
      }

      public boolean a() {
         return ((class_wj)this.e).cB() && super.a();
      }
   }

   static class class_b_in_class_wj extends class_sw {
      public class_b_in_class_wj(class_wj var1) {
         super(var1, true, new Class[0]);
      }

      protected void a(class_qh var1, class_qa var2) {
         super.a(var1, var2);
         if(var1 instanceof class_wj) {
            ((class_wj)var1).b((class_pr)var2);
         }

      }
   }
}
