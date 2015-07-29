package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_abe;
import net.minecraft.server.class_acd;
import net.minecraft.server.class_acf;
import net.minecraft.server.World;
import net.minecraft.server.Material;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_qm;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_sh;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sj;
import net.minecraft.server.class_sw;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_wi;
import net.minecraft.server.class_wk;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xs;

public class class_wq extends class_wi implements class_wk {
   private static final UUID a = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
   private static final class_qm b;
   private static final int c;
   private static final Item[] bs;
   private int bt;

   public class_wq(World var1) {
      super(var1);
      this.a(0.6F, 1.95F);
      this.i.a(1, new class_rj(this));
      this.i.a(2, new class_sj(this, 1.0D, 60, 10.0F));
      this.i.a(2, new class_si(this, 1.0D));
      this.i.a(3, new class_rr(this, class_xa.class, 8.0F));
      this.i.a(3, new class_sh(this));
      this.bn.a(1, new class_sw(this, false, new Class[0]));
      this.bn.a(2, new class_sz(this, class_xa.class, true));
   }

   protected void h() {
      super.h();
      this.H().a(c, Byte.valueOf((byte)0));
   }

   protected String C() {
      return null;
   }

   protected String bp() {
      return null;
   }

   protected String bq() {
      return null;
   }

   public void a(boolean var1) {
      this.H().b(c, Byte.valueOf((byte)(var1?1:0)));
   }

   public boolean n() {
      return this.H().a(c) == 1;
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(26.0D);
      this.a(class_wl.d).a(0.25D);
   }

   public void m() {
      if(!this.o.D) {
         if(this.n()) {
            if(this.bt-- <= 0) {
               this.a(false);
               class_aas var6 = this.bA();
               this.a(class_pw.a, (class_aas)null);
               if(var6 != null && var6.b() == Items.bB) {
                  List var5 = class_abe.h(var6);
                  if(var5 != null) {
                     Iterator var3 = var5.iterator();

                     while(var3.hasNext()) {
                        class_pl var4 = (class_pl)var3.next();
                        this.c(new class_pl(var4));
                     }
                  }
               }

               this.a(class_wl.d).c(b);
            }
         } else {
            class_acd var1 = null;
            if(this.V.nextFloat() < 0.15F && this.a(Material.h) && !this.a(class_pm.m)) {
               var1 = class_acf.s;
            } else if(this.V.nextFloat() < 0.15F && this.av() && !this.a(class_pm.l)) {
               var1 = class_acf.l;
            } else if(this.V.nextFloat() < 0.05F && this.bo() < this.bv()) {
               var1 = class_acf.u;
            } else if(this.V.nextFloat() < 0.5F && this.w() != null && !this.a(class_pm.a) && this.w().h(this) > 121.0D) {
               var1 = class_acf.n;
            }

            if(var1 != null) {
               this.a(class_pw.a, class_abe.a(new class_aas(Items.bB), var1));
               this.bt = this.bA().l();
               this.a(true);
               class_ql var2 = this.a(class_wl.d);
               var2.c(b);
               var2.b(b);
            }
         }

         if(this.V.nextFloat() < 7.5E-4F) {
            this.o.a((class_pr)this, (byte)15);
         }
      }

      super.m();
   }

   protected float c(class_pc var1, float var2) {
      var2 = super.c(var1, var2);
      if(var1.j() == this) {
         var2 = 0.0F;
      }

      if(var1.s()) {
         var2 = (float)((double)var2 * 0.15D);
      }

      return var2;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3) + 1;

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = this.V.nextInt(3);
         Item var6 = bs[this.V.nextInt(bs.length)];
         if(var2 > 0) {
            var5 += this.V.nextInt(var2 + 1);
         }

         for(int var7 = 0; var7 < var5; ++var7) {
            this.a(var6, 1);
         }
      }

   }

   public void a(class_qa var1, float var2) {
      if(!this.n()) {
         double var3 = var1.t + (double)var1.aU() - 1.100000023841858D;
         double var5 = var1.s + var1.v - this.s;
         double var7 = var3 - this.t;
         double var9 = var1.u + var1.x - this.u;
         float var11 = class_nu.a(var5 * var5 + var9 * var9);
         class_acd var12 = class_acf.w;
         if(var11 >= 8.0F && !var1.a(class_pm.b)) {
            var12 = class_acf.q;
         } else if(var1.bo() >= 8.0F && !var1.a(class_pm.s)) {
            var12 = class_acf.y;
         } else if(var11 <= 3.0F && !var1.a(class_pm.r) && this.V.nextFloat() < 0.25F) {
            var12 = class_acf.H;
         }

         class_xs var13 = new class_xs(this.o, this, class_abe.a(new class_aas(Items.bC), var12));
         var13.z -= -20.0F;
         var13.c(var5, var7 + (double)(var11 * 0.2F), var9, 0.75F, 8.0F);
         this.o.a((class_pr)var13);
      }
   }

   public float aU() {
      return 1.62F;
   }

   static {
      b = (new class_qm(a, "Drinking speed penalty", -0.25D, 0)).a(false);
      c = class_qi.a(class_wq.class);
      bs = new Item[]{Items.aV, Items.ba, Items.aE, Items.bE, Items.bD, Items.J, Items.A, Items.A};
   }
}
