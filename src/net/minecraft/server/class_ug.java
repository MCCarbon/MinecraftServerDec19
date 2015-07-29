package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ane;
import net.minecraft.server.class_anf;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aoe;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_qv;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_sh;
import net.minecraft.server.class_sw;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_ua;
import net.minecraft.server.class_wd;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xd;
import net.minecraft.server.class_xk;

public class class_ug extends class_ua implements class_wd {
   protected static final int a = class_qi.a(class_ug.class);
   protected static final int b = class_qi.a(class_ug.class);
   protected static final int c = class_qi.a(class_ug.class);
   public static final class_cj bs = new class_cj(-666, -666, -666);
   private float bt;
   private float bu;
   private class_cj bv;
   private int bw;

   public class_ug(World var1) {
      super(var1);
      this.a(1.0F, 1.0F);
      this.aM = 180.0F;
      this.aL = 180.0F;
      this.ab = true;
      this.bv = bs;
      this.i.a(1, new class_rr(this, class_xa.class, 8.0F));
      this.i.a(4, new class_ug.class_a_in_class_ug());
      this.i.a(7, new class_ug.class_e_in_class_ug((class_ug.SyntheticClass_1)null));
      this.i.a(8, new class_sh(this));
      this.bn.a(1, new class_sw(this, true, new Class[0]));
      this.bn.a(2, new class_ug.class_d_in_class_ug(this));
      this.bn.a(3, new class_ug.class_c_in_class_ug(this));
   }

   protected void h() {
      super.h();
      this.ac.a(a, Byte.valueOf((byte)class_cq.a.a()));
      this.ac.a(b, bs);
      this.ac.a(c, Byte.valueOf((byte)0));
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.a).a(30.0D);
   }

   protected class_qv p() {
      return new class_ug.class_b_in_class_ug(this);
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.ac.b(a, Byte.valueOf(var1.e("AttachFace")));
      this.ac.b(c, Byte.valueOf(var1.e("Peek")));
      if(var1.d("APX")) {
         int var2 = var1.g("APX");
         int var3 = var1.g("APY");
         int var4 = var1.g("APZ");
         this.ac.b(b, new class_cj(var2, var3, var4));
      } else {
         this.ac.b(b, bs);
      }

   }

   public void t_() {
      super.t_();
      class_cj var1 = this.ac.g(b);
      if((var1 == null || bs.equals(var1)) && !this.o.D) {
         var1 = new class_cj(this);
         this.ac.b(b, var1);
      }

      if(!this.o.D) {
         IBlockData var2 = this.o.p(var1);
         if(var2.getBlock() != Blocks.AIR) {
            class_cq var3;
            if(var2.getBlock() == Blocks.PISTON_EXTENSION) {
               var3 = (class_cq)var2.get(class_ane.b);
               var1 = var1.a(var3);
               this.ac.b(b, var1);
            } else if(var2.getBlock() == Blocks.PISTON_HEAD) {
               var3 = (class_cq)var2.get(class_anf.b);
               var1 = var1.a(var3);
               this.ac.b(b, var1);
            } else {
               this.n();
            }
         }
      }

      if(!this.o.D) {
         class_cj var15 = var1.a(this.cA());
         if(!this.o.d(var15, false)) {
            boolean var17 = false;
            class_cq[] var4 = class_cq.values();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               class_cq var7 = var4[var6];
               var15 = var1.a(var7);
               if(this.o.d(var15, false)) {
                  this.ac.b(a, Byte.valueOf((byte)var7.a()));
                  var17 = true;
                  break;
               }
            }

            if(!var17) {
               this.n();
            }
         }
      }

      float var16 = (float)this.cC() * 0.01F;
      this.bt = this.bu;
      if(this.bu > var16) {
         this.bu = class_nu.a(this.bu - 0.05F, var16, 1.0F);
      } else if(this.bu < var16) {
         this.bu = class_nu.a(this.bu + 0.05F, 0.0F, var16);
      }

      if(var1 != null && !bs.equals(var1)) {
         double var18 = (double)(this.bu - this.bt);
         double var19 = 0.0D;
         double var20 = 0.0D;
         double var9 = 0.0D;
         if(this.o.D) {
            if(this.bw > 0 && !bs.equals(this.bv)) {
               --this.bw;
            } else {
               this.bv = var1;
            }
         }

         this.P = this.p = this.s = (double)var1.n() + 0.5D;
         this.Q = this.q = this.t = (double)var1.o();
         this.R = this.r = this.u = (double)var1.p() + 0.5D;
         class_cq var11 = this.cA();
         switch(class_ug.SyntheticClass_1.a[var11.ordinal()]) {
         case 1:
         default:
            this.a((class_awf)(new class_awf(this.s - 0.5D, this.t, this.u - 0.5D, this.s + 0.5D, this.t + 1.0D + (double)this.bu, this.u + 0.5D)));
            var20 = var18;
            break;
         case 2:
            this.a((class_awf)(new class_awf(this.s - 0.5D, this.t - (double)this.bu, this.u - 0.5D, this.s + 0.5D, this.t + 1.0D, this.u + 0.5D)));
            var20 = -var18;
            break;
         case 3:
            this.a((class_awf)(new class_awf(this.s - 0.5D, this.t, this.u - 0.5D, this.s + 0.5D, this.t + 1.0D, this.u + 0.5D + (double)this.bu)));
            var9 = var18;
            break;
         case 4:
            this.a((class_awf)(new class_awf(this.s - 0.5D, this.t, this.u - 0.5D - (double)this.bu, this.s + 0.5D, this.t + 1.0D, this.u + 0.5D)));
            var9 = -var18;
            break;
         case 5:
            this.a((class_awf)(new class_awf(this.s - 0.5D, this.t, this.u - 0.5D, this.s + 0.5D + (double)this.bu, this.t + 1.0D, this.u + 0.5D)));
            var19 = var18;
            break;
         case 6:
            this.a((class_awf)(new class_awf(this.s - 0.5D - (double)this.bu, this.t, this.u - 0.5D, this.s + 0.5D, this.t + 1.0D, this.u + 0.5D)));
            var19 = -var18;
         }

         if(var18 > 0.0D) {
            List var12 = this.o.b((class_pr)this, (class_awf)this.aT());
            if(!var12.isEmpty()) {
               Iterator var13 = var12.iterator();

               while(var13.hasNext()) {
                  class_pr var14 = (class_pr)var13.next();
                  if(!(var14 instanceof class_ug) && !var14.T) {
                     var14.d(var19, var20, var9);
                  }
               }
            }
         }
      }

   }

   protected boolean n() {
      class_cj var1 = new class_cj(this);

      for(int var2 = 0; var2 < 5; ++var2) {
         class_cj var3 = var1.a(8 - this.V.nextInt(17), 8 - this.V.nextInt(17), 8 - this.V.nextInt(17));
         if(var3.o() > 0 && this.o.d(var3) && this.o.a((class_aoe)this.o.ag(), (class_pr)this)) {
            boolean var4 = false;
            class_cq[] var5 = class_cq.values();
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
               class_cq var8 = var5[var7];
               if(this.o.d(var3.a(var8), false)) {
                  this.ac.b(a, Byte.valueOf((byte)var8.a()));
                  var4 = true;
                  break;
               }
            }

            if(var4) {
               this.a("mob.endermen.portal", 1.0F, 1.0F);
               this.ac.b(b, var3);
               this.ac.b(c, Byte.valueOf((byte)0));
               this.d((class_qa)null);
               return true;
            }
         }
      }

      return false;
   }

   public void m() {
      super.m();
      this.v = 0.0D;
      this.w = 0.0D;
      this.x = 0.0D;
      this.aM = 180.0F;
      this.aL = 180.0F;
      this.y = 180.0F;
   }

   public void d(int var1) {
      if(var1 == b && this.o.D) {
         class_cj var2 = this.cB();
         if(!bs.equals(var2)) {
            if(bs.equals(this.bv)) {
               this.bv = var2;
            } else {
               this.bw = 6;
            }

            this.P = this.p = this.s = (double)var2.n() + 0.5D;
            this.Q = this.q = this.t = (double)var2.o();
            this.R = this.r = this.u = (double)var2.p() + 0.5D;
         }
      }

      super.d(var1);
   }

   public int bs() {
      return this.cC() == 0?20:super.bs();
   }

   public boolean a(class_pc var1, float var2) {
      if(this.cC() == 0) {
         class_pr var3 = var1.i();
         if(var3 instanceof class_xd) {
            return false;
         }
      }

      if(super.a(var1, var2)) {
         if((double)this.bo() < (double)this.bv() * 0.5D && this.V.nextInt(4) == 0) {
            this.n();
         }

         return true;
      } else {
         return false;
      }
   }

   public class_awf S() {
      return this.ai()?this.aT():null;
   }

   public class_cq cA() {
      return class_cq.a(this.ac.a(a));
   }

   public class_cj cB() {
      return this.ac.g(b);
   }

   public void f(class_cj var1) {
      this.ac.b(b, var1);
   }

   public int cC() {
      return this.ac.a(c);
   }

   public void a(int var1) {
      this.ac.b(c, Byte.valueOf((byte)var1));
   }

   public float aU() {
      return 0.5F;
   }

   public int cd() {
      return 180;
   }

   public int ce() {
      return 180;
   }

   public void i(class_pr var1) {
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_cq.values().length];

      static {
         try {
            a[class_cq.a.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_cq.b.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_cq.c.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_cq.d.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_cq.e.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.f.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   static class class_c_in_class_ug extends class_sz {
      public class_c_in_class_ug(class_ug var1) {
         super(var1, class_qa.class, 10, true, false, new Predicate() {
            public boolean a(class_qa var1) {
               return var1 instanceof class_wd;
            }

            // $FF: synthetic method
            public boolean apply(Object var1) {
               return this.a((class_qa)var1);
            }
         });
      }

      public boolean a() {
         return this.e.bP() == null?false:super.a();
      }

      protected class_awf a(double var1) {
         class_cq var3 = ((class_ug)this.e).cA();
         return var3.k() == class_cq.class_a_in_class_cq.a?this.e.aT().b(4.0D, var1, var1):(var3.k() == class_cq.class_a_in_class_cq.c?this.e.aT().b(var1, var1, 4.0D):this.e.aT().b(var1, 4.0D, var1));
      }
   }

   static class class_d_in_class_ug extends class_sz {
      public class_d_in_class_ug(class_ug var1) {
         super(var1, class_xa.class, true);
      }

      protected class_awf a(double var1) {
         class_cq var3 = ((class_ug)this.e).cA();
         return var3.k() == class_cq.class_a_in_class_cq.a?this.e.aT().b(4.0D, var1, var1):(var3.k() == class_cq.class_a_in_class_cq.c?this.e.aT().b(var1, var1, 4.0D):this.e.aT().b(var1, 4.0D, var1));
      }
   }

   class class_a_in_class_ug extends class_rm {
      private int b;

      public class_a_in_class_ug() {
         this.a(3);
      }

      public boolean a() {
         class_qa var1 = class_ug.this.w();
         return var1 != null && var1.ai();
      }

      public void c() {
         this.b = 20;
         class_ug.this.a(100);
      }

      public void d() {
         class_ug.this.a(0);
      }

      public void e() {
         --this.b;
         class_qa var1 = class_ug.this.w();
         class_ug.this.q().a(var1, 180.0F, 180.0F);
         double var2 = class_ug.this.h(var1);
         if(var2 < 400.0D) {
            if(this.b <= 0) {
               this.b = 20 + class_ug.this.V.nextInt(10) * 20 / 2;
               class_xk var4 = new class_xk(class_ug.this.o, class_ug.this, var1, class_ug.this.cA().k());
               class_ug.this.o.a((class_pr)var4);
               class_ug.this.a("mob.ghast.fireball", 2.0F, (class_ug.this.V.nextFloat() - class_ug.this.V.nextFloat()) * 0.2F + 1.0F);
            }
         } else {
            class_ug.this.d((class_qa)null);
         }

         super.e();
      }
   }

   class class_e_in_class_ug extends class_rm {
      private int b;

      private class_e_in_class_ug() {
      }

      public boolean a() {
         return class_ug.this.w() == null && class_ug.this.V.nextInt(40) == 0;
      }

      public boolean b() {
         return class_ug.this.w() == null && this.b > 0;
      }

      public void c() {
         this.b = 20 * (1 + class_ug.this.V.nextInt(3));
         class_ug.this.a(30);
      }

      public void d() {
         if(class_ug.this.w() == null) {
            class_ug.this.a(0);
         }

      }

      public void e() {
         --this.b;
      }

      // $FF: synthetic method
      class_e_in_class_ug(class_ug.SyntheticClass_1 var2) {
         this();
      }
   }

   class class_b_in_class_ug extends class_qv {
      public class_b_in_class_ug(class_qa var2) {
         super(var2);
      }

      public void a() {
      }
   }
}
