package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_po;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_re;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_rl;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_se;
import net.minecraft.server.class_sh;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sr;
import net.minecraft.server.class_tw;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;

public class class_tx extends class_tw {
   private static final Set bA;
   public float bs;
   public float bt;
   public float bu;
   public float bw;
   public float bx = 1.0F;
   public int by;
   public boolean bz;

   public class_tx(World var1) {
      super(var1);
      this.a(0.4F, 0.7F);
      this.by = this.V.nextInt(6000) + 6000;
      this.i.a(0, new class_rj(this));
      this.i.a(1, new class_se(this, 1.4D));
      this.i.a(2, new class_re(this, 1.0D));
      this.i.a(3, new class_sr(this, 1.0D, false, bA));
      this.i.a(4, new class_rl(this, 1.1D));
      this.i.a(5, new class_si(this, 1.0D));
      this.i.a(6, new class_rr(this, class_xa.class, 6.0F));
      this.i.a(7, new class_sh(this));
   }

   public float aU() {
      return this.K;
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.a).a(4.0D);
      this.a((class_qk)class_wl.d).a(0.25D);
   }

   public void m() {
      super.m();
      this.bw = this.bs;
      this.bu = this.bt;
      this.bt = (float)((double)this.bt + (double)(this.C?-1:4) * 0.3D);
      this.bt = class_nu.a(this.bt, 0.0F, 1.0F);
      if(!this.C && this.bx < 1.0F) {
         this.bx = 1.0F;
      }

      this.bx = (float)((double)this.bx * 0.9D);
      if(!this.C && this.w < 0.0D) {
         this.w *= 0.6D;
      }

      this.bs += this.bx * 2.0F;
      if(!this.o.D && !this.j_() && !this.cA() && --this.by <= 0) {
         this.a("mob.chicken.plop", 1.0F, (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
         this.a(Items.aR, 1);
         this.by = this.V.nextInt(6000) + 6000;
      }

   }

   public void e(float var1, float var2) {
   }

   protected String C() {
      return "mob.chicken.say";
   }

   protected String bp() {
      return "mob.chicken.hurt";
   }

   protected String bq() {
      return "mob.chicken.hurt";
   }

   protected void a(class_cj var1, Block var2) {
      this.a("mob.chicken.step", 0.15F, 1.0F);
   }

   protected Item D() {
      return Items.I;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3) + this.V.nextInt(1 + var2);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.a(Items.I, 1);
      }

      if(this.av()) {
         this.a(Items.bn, 1);
      } else {
         this.a(Items.bm, 1);
      }

   }

   public class_tx b(class_po var1) {
      return new class_tx(this.o);
   }

   public boolean d(class_aas var1) {
      return var1 != null && bA.contains(var1.b());
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.bz = var1.o("IsChickenJockey");
      if(var1.d("EggLayTime")) {
         this.by = var1.g("EggLayTime");
      }

   }

   protected int b(class_xa var1) {
      return this.cA()?10:super.b(var1);
   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("IsChickenJockey", this.bz);
      var1.a("EggLayTime", this.by);
   }

   protected boolean E() {
      return this.cA() && this.l == null;
   }

   public void al() {
      super.al();
      float var1 = class_nu.a(this.aL * 3.1415927F / 180.0F);
      float var2 = class_nu.b(this.aL * 3.1415927F / 180.0F);
      float var3 = 0.1F;
      float var4 = 0.0F;
      this.l.b(this.s + (double)(var3 * var1), this.t + (double)(this.K * 0.5F) + this.l.am() + (double)var4, this.u - (double)(var3 * var2));
      if(this.l instanceof class_qa) {
         ((class_qa)this.l).aL = this.aL;
      }

   }

   public boolean cA() {
      return this.bz;
   }

   public void m(boolean var1) {
      this.bz = var1;
   }

   // $FF: synthetic method
   public class_po a(class_po var1) {
      return this.b(var1);
   }

   static {
      bA = Sets.newHashSet((Object[])(new Item[]{Items.P, Items.bj, Items.bi, Items.cK}));
   }
}
