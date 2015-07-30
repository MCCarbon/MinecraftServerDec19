package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_agu;
import net.minecraft.server.class_aiu;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.class_ams;
import net.minecraft.server.class_amu;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_kn;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_oz;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pv;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yn;

public class class_amt extends class_amu implements class_ams, class_kn {
   private class_aas[] a = new class_aas[5];
   private String f;
   private int g = -1;

   public void a(class_dn var1) {
      super.a(var1);
      class_du var2 = var1.c("Items", 10);
      this.a = new class_aas[this.o_()];
      if(var1.b("CustomName", 8)) {
         this.f = var1.k("CustomName");
      }

      this.g = var1.g("TransferCooldown");

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         class_dn var4 = var2.b(var3);
         byte var5 = var4.e("Slot");
         if(var5 >= 0 && var5 < this.a.length) {
            this.a[var5] = class_aas.a(var4);
         }
      }

   }

   public void b(class_dn var1) {
      super.b(var1);
      class_du var2 = new class_du();

      for(int var3 = 0; var3 < this.a.length; ++var3) {
         if(this.a[var3] != null) {
            class_dn var4 = new class_dn();
            var4.a("Slot", (byte)var3);
            this.a[var3].b(var4);
            var2.a((class_eb)var4);
         }
      }

      var1.a((String)"Items", (class_eb)var2);
      var1.a("TransferCooldown", this.g);
      if(this.l_()) {
         var1.a("CustomName", this.f);
      }

   }

   public int o_() {
      return this.a.length;
   }

   public class_aas a(int var1) {
      return this.a[var1];
   }

   public class_aas a(int var1, int var2) {
      if(this.a[var1] != null) {
         class_aas var3;
         if(this.a[var1].b <= var2) {
            var3 = this.a[var1];
            this.a[var1] = null;
            return var3;
         } else {
            var3 = this.a[var1].a(var2);
            if(this.a[var1].b == 0) {
               this.a[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public class_aas b(int var1) {
      if(this.a[var1] != null) {
         class_aas var2 = this.a[var1];
         this.a[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, class_aas var2) {
      this.a[var1] = var2;
      if(var2 != null && var2.b > this.q_()) {
         var2.b = this.q_();
      }

   }

   public String e_() {
      return this.l_()?this.f:"container.hopper";
   }

   public boolean l_() {
      return this.f != null && !this.f.isEmpty();
   }

   public void a(String var1) {
      this.f = var1;
   }

   public int q_() {
      return 64;
   }

   public boolean a(class_xa var1) {
      return this.b.s(this.c) != this?false:var1.e((double)this.c.getX() + 0.5D, (double)this.c.getY() + 0.5D, (double)this.c.getZ() + 0.5D) <= 64.0D;
   }

   public void b(class_xa var1) {
   }

   public void c(class_xa var1) {
   }

   public boolean b(int var1, class_aas var2) {
      return true;
   }

   public void c() {
      if(this.b != null && !this.b.D) {
         --this.g;
         if(!this.n()) {
            this.d(0);
            this.m();
         }

      }
   }

   public boolean m() {
      if(this.b != null && !this.b.D) {
         if(!this.n() && class_aiu.f(this.u())) {
            boolean var1 = false;
            if(!this.p()) {
               var1 = this.r();
            }

            if(!this.q()) {
               var1 = a((class_ams)this) || var1;
            }

            if(var1) {
               this.d(8);
               this.p_();
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean p() {
      class_aas[] var1 = this.a;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         class_aas var4 = var1[var3];
         if(var4 != null) {
            return false;
         }
      }

      return true;
   }

   private boolean q() {
      class_aas[] var1 = this.a;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         class_aas var4 = var1[var3];
         if(var4 == null || var4.b != var4.c()) {
            return false;
         }
      }

      return true;
   }

   private boolean r() {
      class_oj var1 = this.H();
      if(var1 == null) {
         return false;
      } else {
         EnumDirection var2 = class_aiu.b(this.u()).getOpposite();
         if(this.a(var1, var2)) {
            return false;
         } else {
            for(int var3 = 0; var3 < this.o_(); ++var3) {
               if(this.a(var3) != null) {
                  class_aas var4 = this.a(var3).k();
                  class_aas var5 = a(var1, this.a(var3, 1), var2);
                  if(var5 == null || var5.b == 0) {
                     var1.p_();
                     return true;
                  }

                  this.a(var3, var4);
               }
            }

            return false;
         }
      }
   }

   private boolean a(class_oj var1, EnumDirection var2) {
      if(var1 instanceof class_oz) {
         class_oz var7 = (class_oz)var1;
         int[] var8 = var7.a(var2);

         for(int var9 = 0; var9 < var8.length; ++var9) {
            class_aas var6 = var7.a(var8[var9]);
            if(var6 == null || var6.b != var6.c()) {
               return false;
            }
         }
      } else {
         int var3 = var1.o_();

         for(int var4 = 0; var4 < var3; ++var4) {
            class_aas var5 = var1.a(var4);
            if(var5 == null || var5.b != var5.c()) {
               return false;
            }
         }
      }

      return true;
   }

   private static boolean b(class_oj var0, EnumDirection var1) {
      if(var0 instanceof class_oz) {
         class_oz var2 = (class_oz)var0;
         int[] var3 = var2.a(var1);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if(var2.a(var3[var4]) != null) {
               return false;
            }
         }
      } else {
         int var5 = var0.o_();

         for(int var6 = 0; var6 < var5; ++var6) {
            if(var0.a(var6) != null) {
               return false;
            }
         }
      }

      return true;
   }

   public static boolean a(class_ams var0) {
      class_oj var1 = b(var0);
      if(var1 != null) {
         EnumDirection var2 = EnumDirection.DOWN;
         if(b(var1, var2)) {
            return false;
         }

         if(var1 instanceof class_oz) {
            class_oz var3 = (class_oz)var1;
            int[] var4 = var3.a(var2);

            for(int var5 = 0; var5 < var4.length; ++var5) {
               if(a(var0, var1, var4[var5], var2)) {
                  return true;
               }
            }
         } else {
            int var7 = var1.o_();

            for(int var9 = 0; var9 < var7; ++var9) {
               if(a(var0, var1, var9, var2)) {
                  return true;
               }
            }
         }
      } else {
         Iterator var6 = a(var0.z(), var0.A(), var0.B() + 1.0D, var0.C()).iterator();

         while(var6.hasNext()) {
            class_vm var8 = (class_vm)var6.next();
            if(a((class_oj)var0, (class_vm)var8)) {
               return true;
            }
         }
      }

      return false;
   }

   private static boolean a(class_ams var0, class_oj var1, int var2, EnumDirection var3) {
      class_aas var4 = var1.a(var2);
      if(var4 != null && b(var1, var4, var2, var3)) {
         class_aas var5 = var4.k();
         class_aas var6 = a(var0, var1.a(var2, 1), (EnumDirection)null);
         if(var6 == null || var6.b == 0) {
            var1.p_();
            return true;
         }

         var1.a(var2, var5);
      }

      return false;
   }

   public static boolean a(class_oj var0, class_vm var1) {
      boolean var2 = false;
      if(var1 == null) {
         return false;
      } else {
         class_aas var3 = var1.l().k();
         class_aas var4 = a(var0, var3, (EnumDirection)null);
         if(var4 != null && var4.b != 0) {
            var1.a(var4);
         } else {
            var2 = true;
            var1.J();
         }

         return var2;
      }
   }

   public static class_aas a(class_oj var0, class_aas var1, EnumDirection var2) {
      if(var0 instanceof class_oz && var2 != null) {
         class_oz var6 = (class_oz)var0;
         int[] var7 = var6.a(var2);

         for(int var5 = 0; var5 < var7.length && var1 != null && var1.b > 0; ++var5) {
            var1 = c(var0, var1, var7[var5], var2);
         }
      } else {
         int var3 = var0.o_();

         for(int var4 = 0; var4 < var3 && var1 != null && var1.b > 0; ++var4) {
            var1 = c(var0, var1, var4, var2);
         }
      }

      if(var1 != null && var1.b == 0) {
         var1 = null;
      }

      return var1;
   }

   private static boolean a(class_oj var0, class_aas var1, int var2, EnumDirection var3) {
      return !var0.b(var2, var1)?false:!(var0 instanceof class_oz) || ((class_oz)var0).a(var2, var1, var3);
   }

   private static boolean b(class_oj var0, class_aas var1, int var2, EnumDirection var3) {
      return !(var0 instanceof class_oz) || ((class_oz)var0).b(var2, var1, var3);
   }

   private static class_aas c(class_oj var0, class_aas var1, int var2, EnumDirection var3) {
      class_aas var4 = var0.a(var2);
      if(a(var0, var1, var2, var3)) {
         boolean var5 = false;
         if(var4 == null) {
            var0.a(var2, var1);
            var1 = null;
            var5 = true;
         } else if(a(var4, var1)) {
            int var6 = var1.c() - var4.b;
            int var7 = Math.min(var1.b, var6);
            var1.b -= var7;
            var4.b += var7;
            var5 = var7 > 0;
         }

         if(var5) {
            if(var0 instanceof class_amt) {
               class_amt var8 = (class_amt)var0;
               if(var8.o()) {
                  var8.d(8);
               }

               var0.p_();
            }

            var0.p_();
         }
      }

      return var1;
   }

   private class_oj H() {
      EnumDirection var1 = class_aiu.b(this.u());
      return b(this.z(), (double)(this.c.getX() + var1.getAdjacentX()), (double)(this.c.getY() + var1.getAdjacentY()), (double)(this.c.getZ() + var1.getAdjacentZ()));
   }

   public static class_oj b(class_ams var0) {
      return b(var0.z(), var0.A(), var0.B() + 1.0D, var0.C());
   }

   public static List a(World var0, double var1, double var3, double var5) {
      return var0.a(class_vm.class, new class_awf(var1 - 0.5D, var3 - 0.5D, var5 - 0.5D, var1 + 0.5D, var3 + 0.5D, var5 + 0.5D), class_pv.a);
   }

   public static class_oj b(World var0, double var1, double var3, double var5) {
      Object var7 = null;
      int var8 = MathHelper.floor(var1);
      int var9 = MathHelper.floor(var3);
      int var10 = MathHelper.floor(var5);
      BlockPosition var11 = new BlockPosition(var8, var9, var10);
      Block var12 = var0.p(var11).getBlock();
      if(var12.isTileEntity()) {
         class_amg var13 = var0.s(var11);
         if(var13 instanceof class_oj) {
            var7 = (class_oj)var13;
            if(var7 instanceof class_ami && var12 instanceof class_agu) {
               var7 = ((class_agu)var12).f(var0, var11);
            }
         }
      }

      if(var7 == null) {
         List var14 = var0.a((class_pr)null, (class_awf)(new class_awf(var1 - 0.5D, var3 - 0.5D, var5 - 0.5D, var1 + 0.5D, var3 + 0.5D, var5 + 0.5D)), (Predicate)class_pv.c);
         if(!var14.isEmpty()) {
            var7 = (class_oj)var14.get(var0.s.nextInt(var14.size()));
         }
      }

      return (class_oj)var7;
   }

   private static boolean a(class_aas var0, class_aas var1) {
      return var0.b() != var1.b()?false:(var0.i() != var1.i()?false:(var0.b > var0.c()?false:class_aas.a(var0, var1)));
   }

   public double A() {
      return (double)this.c.getX() + 0.5D;
   }

   public double B() {
      return (double)this.c.getY() + 0.5D;
   }

   public double C() {
      return (double)this.c.getZ() + 0.5D;
   }

   public void d(int var1) {
      this.g = var1;
   }

   public boolean n() {
      return this.g > 0;
   }

   public boolean o() {
      return this.g <= 1;
   }

   public String k() {
      return "minecraft:hopper";
   }

   public class_xz a(class_wz var1, class_xa var2) {
      return new class_yn(var1, this, var2);
   }

   public int a_(int var1) {
      return 0;
   }

   public void b(int var1, int var2) {
   }

   public int g() {
      return 0;
   }

   public void l() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

   }
}
