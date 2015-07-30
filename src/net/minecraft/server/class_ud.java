package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_po;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_re;
import net.minecraft.server.class_rf;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_rl;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_se;
import net.minecraft.server.class_sh;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sr;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_tw;
import net.minecraft.server.class_vi;
import net.minecraft.server.class_wj;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;

public class class_ud extends class_tw {
   private static final int bs = class_qi.a(class_ud.class);
   private static final Set bt;
   private final class_rf bu;

   public class_ud(World var1) {
      super(var1);
      this.a(0.9F, 0.9F);
      ((class_tf)this.u()).a(true);
      this.i.a(0, new class_rj(this));
      this.i.a(1, new class_se(this, 1.25D));
      this.i.a(2, this.bu = new class_rf(this, 0.3F));
      this.i.a(3, new class_re(this, 1.0D));
      this.i.a(4, new class_sr(this, 1.2D, Items.cb, false));
      this.i.a(4, new class_sr(this, 1.2D, false, bt));
      this.i.a(5, new class_rl(this, 1.1D));
      this.i.a(6, new class_si(this, 1.0D));
      this.i.a(7, new class_rr(this, class_xa.class, 6.0F));
      this.i.a(8, new class_sh(this));
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.a).a(10.0D);
      this.a((class_qk)class_wl.d).a(0.25D);
   }

   public boolean ck() {
      class_aas var1 = ((class_xa)this.l).bA();
      if(var1 != null && var1.b() == Items.cb) {
         return true;
      } else {
         var1 = ((class_xa)this.l).bB();
         return var1 != null && var1.b() == Items.cb;
      }
   }

   protected void h() {
      super.h();
      this.ac.a(bs, Byte.valueOf((byte)0));
   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("Saddle", this.cA());
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.m(var1.o("Saddle"));
   }

   protected String C() {
      return "mob.pig.say";
   }

   protected String bp() {
      return "mob.pig.say";
   }

   protected String bq() {
      return "mob.pig.death";
   }

   protected void a(BlockPosition var1, Block var2) {
      this.a("mob.pig.step", 0.15F, 1.0F);
   }

   public boolean a(class_xa var1, EnumUsedHand var2, class_aas var3) {
      if(super.a(var1, var2, var3)) {
         return true;
      } else if(!this.cA() || this.o.D || this.l != null && this.l != var1) {
         return false;
      } else {
         var1.a((class_pr)this);
         return true;
      }
   }

   protected Item D() {
      return this.av()?Items.ao:Items.an;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3) + 1 + this.V.nextInt(1 + var2);

      for(int var4 = 0; var4 < var3; ++var4) {
         if(this.av()) {
            this.a(Items.ao, 1);
         } else {
            this.a(Items.an, 1);
         }
      }

      if(this.cA()) {
         this.a(Items.aC, 1);
      }

   }

   public boolean cA() {
      return (this.ac.a(bs) & 1) != 0;
   }

   public void m(boolean var1) {
      if(var1) {
         this.ac.b(bs, Byte.valueOf((byte)1));
      } else {
         this.ac.b(bs, Byte.valueOf((byte)0));
      }

   }

   public void a(class_vi var1) {
      if(!this.o.D && !this.I) {
         class_wj var2 = new class_wj(this.o);
         var2.a((class_pw)class_pw.a, (class_aas)(new class_aas(Items.D)));
         var2.b(this.s, this.t, this.u, this.y, this.z);
         var2.k(this.cs());
         if(this.l_()) {
            var2.a((String)this.aO());
            var2.g(this.aP());
         }

         this.o.a((class_pr)var2);
         this.J();
      }
   }

   public void e(float var1, float var2) {
      super.e(var1, var2);
      if(var1 > 5.0F && this.l instanceof class_xa) {
         ((class_xa)this.l).b((class_my)class_mt.u);
      }

   }

   public class_ud b(class_po var1) {
      return new class_ud(this.o);
   }

   public boolean d(class_aas var1) {
      return var1 != null && bt.contains(var1.b());
   }

   public class_rf cB() {
      return this.bu;
   }

   // $FF: synthetic method
   public class_po a(class_po var1) {
      return this.b(var1);
   }

   static {
      bt = Sets.newHashSet((Object[])(new Item[]{Items.bU, Items.bV, Items.cL}));
   }
}
