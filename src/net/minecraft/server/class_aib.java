package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_alo;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_apd;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_aib extends Block {
   public static final class_anz a = class_anz.a("age", 0, 15);
   public static final class_anw b = class_anw.a("north");
   public static final class_anw N = class_anw.a("east");
   public static final class_anw O = class_anw.a("south");
   public static final class_anw P = class_anw.a("west");
   public static final class_anw Q = class_anw.a("up");
   private final Map R = Maps.newIdentityHashMap();
   private final Map S = Maps.newIdentityHashMap();

   public IBlockData a(IBlockData var1, class_aer var2, class_cj var3) {
      return !class_aen.a(var2, var3.b()) && !class_agk.ab.e(var2, var3.b())?var1.set(b, Boolean.valueOf(this.e(var2, var3.c()))).set(N, Boolean.valueOf(this.e(var2, var3.f()))).set(O, Boolean.valueOf(this.e(var2, var3.d()))).set(P, Boolean.valueOf(this.e(var2, var3.e()))).set(Q, Boolean.valueOf(this.e(var2, var3.a()))):this.S();
   }

   protected class_aib() {
      super(class_atk.o);
      this.j(this.M.b().set(a, Integer.valueOf(0)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)).set(P, Boolean.valueOf(false)).set(Q, Boolean.valueOf(false)));
      this.a(true);
   }

   public static void l() {
      class_agk.ab.a(class_agk.f, 5, 20);
      class_agk.ab.a(class_agk.bL, 5, 20);
      class_agk.ab.a(class_agk.bM, 5, 20);
      class_agk.ab.a(class_agk.bo, 5, 20);
      class_agk.ab.a(class_agk.bp, 5, 20);
      class_agk.ab.a(class_agk.bq, 5, 20);
      class_agk.ab.a(class_agk.br, 5, 20);
      class_agk.ab.a(class_agk.bs, 5, 20);
      class_agk.ab.a(class_agk.bt, 5, 20);
      class_agk.ab.a(class_agk.aO, 5, 20);
      class_agk.ab.a(class_agk.aP, 5, 20);
      class_agk.ab.a(class_agk.aQ, 5, 20);
      class_agk.ab.a(class_agk.aR, 5, 20);
      class_agk.ab.a(class_agk.aS, 5, 20);
      class_agk.ab.a(class_agk.aT, 5, 20);
      class_agk.ab.a(class_agk.ad, 5, 20);
      class_agk.ab.a(class_agk.bV, 5, 20);
      class_agk.ab.a(class_agk.bU, 5, 20);
      class_agk.ab.a(class_agk.bW, 5, 20);
      class_agk.ab.a(class_agk.r, 5, 5);
      class_agk.ab.a(class_agk.s, 5, 5);
      class_agk.ab.a(class_agk.t, 30, 60);
      class_agk.ab.a(class_agk.u, 30, 60);
      class_agk.ab.a(class_agk.X, 30, 20);
      class_agk.ab.a(class_agk.W, 15, 100);
      class_agk.ab.a(class_agk.H, 60, 100);
      class_agk.ab.a(class_agk.cF, 60, 100);
      class_agk.ab.a(class_agk.N, 60, 100);
      class_agk.ab.a(class_agk.O, 60, 100);
      class_agk.ab.a(class_agk.I, 60, 100);
      class_agk.ab.a(class_agk.L, 30, 60);
      class_agk.ab.a(class_agk.bn, 15, 100);
      class_agk.ab.a(class_agk.cA, 5, 5);
      class_agk.ab.a(class_agk.cx, 60, 20);
      class_agk.ab.a(class_agk.cy, 60, 20);
   }

   public void a(Block var1, int var2, int var3) {
      this.R.put(var1, Integer.valueOf(var2));
      this.S.put(var1, Integer.valueOf(var3));
   }

   public class_awf a(class_aen var1, class_cj var2, IBlockData var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public int a(Random var1) {
      return 0;
   }

   public int a(class_aen var1) {
      return 30;
   }

   public void b(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
      if(var1.R().b("doFireTick")) {
         if(!this.d(var1, var2)) {
            var1.g(var2);
         }

         Block var5 = var1.p(var2.b()).getBlock();
         boolean var6 = var5 == class_agk.aV;
         if(var1.t instanceof class_apd && var5 == class_agk.h) {
            var6 = true;
         }

         if(!var6 && var1.T() && this.e(var1, var2)) {
            var1.g(var2);
         } else {
            int var7 = ((Integer)var3.get(a)).intValue();
            if(var7 < 15) {
               var3 = var3.set(a, Integer.valueOf(var7 + var4.nextInt(3) / 2));
               var1.a((class_cj)var2, (IBlockData)var3, 4);
            }

            var1.a((class_cj)var2, (Block)this, this.a(var1) + var4.nextInt(10));
            if(!var6) {
               if(!this.f(var1, var2)) {
                  if(!class_aen.a((class_aer)var1, (class_cj)var2.b()) || var7 > 3) {
                     var1.g(var2);
                  }

                  return;
               }

               if(!this.e((class_aer)var1, var2.b()) && var7 == 15 && var4.nextInt(4) == 0) {
                  var1.g(var2);
                  return;
               }
            }

            boolean var8 = var1.D(var2);
            byte var9 = 0;
            if(var8) {
               var9 = -50;
            }

            this.a(var1, var2.f(), 300 + var9, var4, var7);
            this.a(var1, var2.e(), 300 + var9, var4, var7);
            this.a(var1, var2.b(), 250 + var9, var4, var7);
            this.a(var1, var2.a(), 250 + var9, var4, var7);
            this.a(var1, var2.c(), 300 + var9, var4, var7);
            this.a(var1, var2.d(), 300 + var9, var4, var7);

            for(int var10 = -1; var10 <= 1; ++var10) {
               for(int var11 = -1; var11 <= 1; ++var11) {
                  for(int var12 = -1; var12 <= 4; ++var12) {
                     if(var10 != 0 || var12 != 0 || var11 != 0) {
                        int var13 = 100;
                        if(var12 > 1) {
                           var13 += (var12 - 1) * 100;
                        }

                        class_cj var14 = var2.a(var10, var12, var11);
                        int var15 = this.m(var1, var14);
                        if(var15 > 0) {
                           int var16 = (var15 + 40 + var1.ab().a() * 7) / (var7 + 30);
                           if(var8) {
                              var16 /= 2;
                           }

                           if(var16 > 0 && var4.nextInt(var13) <= var16 && (!var1.T() || !this.e(var1, var14))) {
                              int var17 = var7 + var4.nextInt(5) / 4;
                              if(var17 > 15) {
                                 var17 = 15;
                              }

                              var1.a((class_cj)var14, (IBlockData)var3.set(a, Integer.valueOf(var17)), 3);
                           }
                        }
                     }
                  }
               }
            }

         }
      }
   }

   protected boolean e(class_aen var1, class_cj var2) {
      return var1.C(var2) || var1.C(var2.e()) || var1.C(var2.f()) || var1.C(var2.c()) || var1.C(var2.d());
   }

   public boolean P() {
      return false;
   }

   private int c(Block var1) {
      Integer var2 = (Integer)this.S.get(var1);
      return var2 == null?0:var2.intValue();
   }

   private int d(Block var1) {
      Integer var2 = (Integer)this.R.get(var1);
      return var2 == null?0:var2.intValue();
   }

   private void a(class_aen var1, class_cj var2, int var3, Random var4, int var5) {
      int var6 = this.c(var1.p(var2).getBlock());
      if(var4.nextInt(var3) < var6) {
         IBlockData var7 = var1.p(var2);
         if(var4.nextInt(var5 + 10) < 5 && !var1.C(var2)) {
            int var8 = var5 + var4.nextInt(5) / 4;
            if(var8 > 15) {
               var8 = 15;
            }

            var1.a((class_cj)var2, (IBlockData)this.S().set(a, Integer.valueOf(var8)), 3);
         } else {
            var1.g(var2);
         }

         if(var7.getBlock() == class_agk.W) {
            class_agk.W.d(var1, var2, var7.set(class_alo.a, Boolean.valueOf(true)));
         }
      }

   }

   private boolean f(class_aen var1, class_cj var2) {
      class_cq[] var3 = class_cq.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_cq var6 = var3[var5];
         if(this.e((class_aer)var1, var2.a(var6))) {
            return true;
         }
      }

      return false;
   }

   private int m(class_aen var1, class_cj var2) {
      if(!var1.d(var2)) {
         return 0;
      } else {
         int var3 = 0;
         class_cq[] var4 = class_cq.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            class_cq var7 = var4[var6];
            var3 = Math.max(this.d(var1.p(var2.a(var7)).getBlock()), var3);
         }

         return var3;
      }
   }

   public boolean C() {
      return false;
   }

   public boolean e(class_aer var1, class_cj var2) {
      return this.d(var1.p(var2).getBlock()) > 0;
   }

   public boolean d(class_aen var1, class_cj var2) {
      return class_aen.a((class_aer)var1, (class_cj)var2.b()) || this.f(var1, var2);
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      if(!class_aen.a((class_aer)var1, (class_cj)var2.b()) && !this.f(var1, var2)) {
         var1.g(var2);
      }

   }

   public void c(class_aen var1, class_cj var2, IBlockData var3) {
      if(var1.t.p().a() > 0 || !class_agk.aY.e(var1, var2)) {
         if(!class_aen.a((class_aer)var1, (class_cj)var2.b()) && !this.f(var1, var2)) {
            var1.g(var2);
         } else {
            var1.a((class_cj)var2, (Block)this, this.a(var1) + var1.s.nextInt(10));
         }
      }
   }

   public class_atl g(IBlockData var1) {
      return class_atl.f;
   }

   public IBlockData a(int var1) {
      return this.S().set(a, Integer.valueOf(var1));
   }

   public int c(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a, b, N, O, P, Q});
   }
}
