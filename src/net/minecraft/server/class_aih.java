package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amr;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anx;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ol;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;

public class class_aih extends class_agd {
   public static final class_anx a;
   private final boolean b;
   private static boolean N;

   protected class_aih(boolean var1) {
      super(class_atk.e);
      this.j(this.M.b().set(a, class_cq.c));
      this.b = var1;
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aar.a(class_agk.al);
   }

   public void c(class_aen var1, class_cj var2, IBlockData var3) {
      this.e(var1, var2, var3);
   }

   private void e(class_aen var1, class_cj var2, IBlockData var3) {
      if(!var1.D) {
         Block var4 = var1.p(var2.c()).getBlock();
         Block var5 = var1.p(var2.d()).getBlock();
         Block var6 = var1.p(var2.e()).getBlock();
         Block var7 = var1.p(var2.f()).getBlock();
         class_cq var8 = (class_cq)var3.get(a);
         if(var8 == class_cq.c && var4.q() && !var5.q()) {
            var8 = class_cq.d;
         } else if(var8 == class_cq.d && var5.q() && !var4.q()) {
            var8 = class_cq.c;
         } else if(var8 == class_cq.e && var6.q() && !var7.q()) {
            var8 = class_cq.f;
         } else if(var8 == class_cq.f && var7.q() && !var6.q()) {
            var8 = class_cq.e;
         }

         var1.a((class_cj)var2, (IBlockData)var3.set(a, var8), 2);
      }
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         if(var11 instanceof class_amr) {
            var4.a((class_oj)((class_amr)var11));
            var4.b(class_nc.Y);
         }

         return true;
      }
   }

   public static void a(boolean var0, class_aen var1, class_cj var2) {
      IBlockData var3 = var1.p(var2);
      class_amg var4 = var1.s(var2);
      N = true;
      if(var0) {
         var1.a((class_cj)var2, (IBlockData)class_agk.am.S().set(a, var3.get(a)), 3);
         var1.a((class_cj)var2, (IBlockData)class_agk.am.S().set(a, var3.get(a)), 3);
      } else {
         var1.a((class_cj)var2, (IBlockData)class_agk.al.S().set(a, var3.get(a)), 3);
         var1.a((class_cj)var2, (IBlockData)class_agk.al.S().set(a, var3.get(a)), 3);
      }

      N = false;
      if(var4 != null) {
         var4.D();
         var1.a(var2, var4);
      }

   }

   public class_amg a(class_aen var1, int var2) {
      return new class_amr();
   }

   public IBlockData a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.S().set(a, var8.aR().d());
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_qa var4, class_aas var5) {
      var1.a((class_cj)var2, (IBlockData)var3.set(a, var4.aR().d()), 2);
      if(var5.s()) {
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_amr) {
            ((class_amr)var6).a(var5.q());
         }
      }

   }

   public void b(class_aen var1, class_cj var2, IBlockData var3) {
      if(!N) {
         class_amg var4 = var1.s(var2);
         if(var4 instanceof class_amr) {
            class_ol.a(var1, (class_cj)var2, (class_amr)var4);
            var1.e(var2, this);
         }
      }

      super.b(var1, var2, var3);
   }

   public boolean Q() {
      return true;
   }

   public int l(class_aen var1, class_cj var2) {
      return class_xz.a(var1.s(var2));
   }

   public int b() {
      return 3;
   }

   public IBlockData a(int var1) {
      class_cq var2 = class_cq.a(var1);
      if(var2.k() == class_cq.class_a_in_class_cq.b) {
         var2 = class_cq.c;
      }

      return this.S().set(a, var2);
   }

   public int c(IBlockData var1) {
      return ((class_cq)var1.get(a)).a();
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((class_cq)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((class_cq)var1.get(a)));
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a});
   }

   static {
      a = class_aiv.O;
   }
}
