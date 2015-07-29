package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahh;
import net.minecraft.server.class_ahw;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_di;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_va;
import net.minecraft.server.class_xa;

public class class_ahb extends class_ahh implements class_ahw {
   public static final class_anw a = class_anw.a("powered");
   public static final class_any b = class_any.a("mode", class_ahb.class_a_in_class_ahb.class);

   public class_ahb(boolean var1) {
      super(var1);
      this.j(this.M.b().set(O, class_cq.c).set(a, Boolean.valueOf(false)).set(b, class_ahb.class_a_in_class_ahb.a));
      this.A = true;
   }

   public String f() {
      return class_di.a("item.comparator.name");
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aau.ch;
   }

   protected int d(IBlockData var1) {
      return 2;
   }

   protected IBlockData e(IBlockData var1) {
      Boolean var2 = (Boolean)var1.get(a);
      class_ahb.class_a_in_class_ahb var3 = (class_ahb.class_a_in_class_ahb)var1.get(b);
      class_cq var4 = (class_cq)var1.get(O);
      return class_agk.ck.S().set(O, var4).set(a, var2).set(b, var3);
   }

   protected IBlockData k(IBlockData var1) {
      Boolean var2 = (Boolean)var1.get(a);
      class_ahb.class_a_in_class_ahb var3 = (class_ahb.class_a_in_class_ahb)var1.get(b);
      class_cq var4 = (class_cq)var1.get(O);
      return class_agk.cj.S().set(O, var4).set(a, var2).set(b, var3);
   }

   protected boolean l(IBlockData var1) {
      return this.N || ((Boolean)var1.get(a)).booleanValue();
   }

   protected int a(class_aer var1, class_cj var2, IBlockData var3) {
      class_amg var4 = var1.s(var2);
      return var4 instanceof class_amk?((class_amk)var4).b():0;
   }

   private int j(class_aen var1, class_cj var2, IBlockData var3) {
      return var3.get(b) == class_ahb.class_a_in_class_ahb.b?Math.max(this.f(var1, var2, var3) - this.c((class_aer) var1, var2, var3), 0):this.f(var1, var2, var3);
   }

   protected boolean e(class_aen var1, class_cj var2, IBlockData var3) {
      int var4 = this.f(var1, var2, var3);
      if(var4 >= 15) {
         return true;
      } else if(var4 == 0) {
         return false;
      } else {
         int var5 = this.c((class_aer) var1, var2, var3);
         return var5 == 0?true:var4 >= var5;
      }
   }

   protected int f(class_aen var1, class_cj var2, IBlockData var3) {
      int var4 = super.f(var1, var2, var3);
      class_cq var5 = (class_cq)var3.get(O);
      class_cj var6 = var2.a(var5);
      Block var7 = var1.p(var6).getBlock();
      if(var7.Q()) {
         var4 = var7.l(var1, var6);
      } else if(var4 < 15 && var7.x()) {
         var6 = var6.a(var5);
         var7 = var1.p(var6).getBlock();
         if(var7.Q()) {
            var4 = var7.l(var1, var6);
         } else if(var7.v() == class_atk.a) {
            class_va var8 = this.a(var1, var5, var6);
            if(var8 != null) {
               var4 = var8.q();
            }
         }
      }

      return var4;
   }

   private class_va a(class_aen var1, final class_cq var2, class_cj var3) {
      List var4 = var1.a(class_va.class, new class_awf((double)var3.n(), (double)var3.o(), (double)var3.p(), (double)(var3.n() + 1), (double)(var3.o() + 1), (double)(var3.p() + 1)), new Predicate() {
         public boolean a(class_pr var1) {
            return var1 != null && var1.aR() == var2;
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_pr)var1);
         }
      });
      return var4.size() == 1?(class_va)var4.get(0):null;
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(!var4.bH.e) {
         return false;
      } else {
         var3 = var3.a(b);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, var3.get(b) == class_ahb.class_a_in_class_ahb.b?0.55F:0.5F);
         var1.a((class_cj)var2, (IBlockData)var3, 2);
         this.k(var1, var2, var3);
         return true;
      }
   }

   protected void g(class_aen var1, class_cj var2, IBlockData var3) {
      if(!var1.a((class_cj)var2, (Block)this)) {
         int var4 = this.j(var1, var2, var3);
         class_amg var5 = var1.s(var2);
         int var6 = var5 instanceof class_amk?((class_amk)var5).b():0;
         if(var4 != var6 || this.l(var3) != this.e(var1, var2, var3)) {
            if(this.i(var1, var2, var3)) {
               var1.a(var2, this, 2, -1);
            } else {
               var1.a(var2, this, 2, 0);
            }
         }

      }
   }

   private void k(class_aen var1, class_cj var2, IBlockData var3) {
      int var4 = this.j(var1, var2, var3);
      class_amg var5 = var1.s(var2);
      int var6 = 0;
      if(var5 instanceof class_amk) {
         class_amk var7 = (class_amk)var5;
         var6 = var7.b();
         var7.a(var4);
      }

      if(var6 != var4 || var3.get(b) == class_ahb.class_a_in_class_ahb.a) {
         boolean var9 = this.e(var1, var2, var3);
         boolean var8 = this.l(var3);
         if(var8 && !var9) {
            var1.a((class_cj)var2, (IBlockData)var3.set(a, Boolean.valueOf(false)), 2);
         } else if(!var8 && var9) {
            var1.a((class_cj)var2, (IBlockData)var3.set(a, Boolean.valueOf(true)), 2);
         }

         this.h(var1, var2, var3);
      }

   }

   public void b(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
      if(this.N) {
         var1.a((class_cj)var2, (IBlockData)this.k(var3).set(a, Boolean.valueOf(true)), 4);
      }

      this.k(var1, var2, var3);
   }

   public void c(class_aen var1, class_cj var2, IBlockData var3) {
      super.c(var1, var2, var3);
      var1.a(var2, this.a(var1, 0));
   }

   public void b(class_aen var1, class_cj var2, IBlockData var3) {
      super.b(var1, var2, var3);
      var1.t(var2);
      this.h(var1, var2, var3);
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, int var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      class_amg var6 = var1.s(var2);
      return var6 == null?false:var6.c(var4, var5);
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_amk();
   }

   public IBlockData a(int var1) {
      return this.S().set(O, class_cq.b(var1)).set(a, Boolean.valueOf((var1 & 8) > 0)).set(b, (var1 & 4) > 0?class_ahb.class_a_in_class_ahb.b:class_ahb.class_a_in_class_ahb.a);
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_cq)var1.get(O)).b();
      if(((Boolean)var1.get(a)).booleanValue()) {
         var3 |= 8;
      }

      if(var1.get(b) == class_ahb.class_a_in_class_ahb.b) {
         var3 |= 4;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(O, var2.a((class_cq)var1.get(O)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((class_cq)var1.get(O)));
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{O, b, a});
   }

   public IBlockData a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.S().set(O, var8.aR().d()).set(a, Boolean.valueOf(false)).set(b, class_ahb.class_a_in_class_ahb.a);
   }

   public static enum class_a_in_class_ahb implements class_ny {
      a("compare"),
      b("subtract");

      private final String c;

      private class_a_in_class_ahb(String var3) {
         this.c = var3;
      }

      public String toString() {
         return this.c;
      }

      public String l() {
         return this.c;
      }
   }
}
