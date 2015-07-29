package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_akk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_qa;

public abstract class class_ahh extends class_aiv {
   protected final boolean N;

   protected class_ahh(boolean var1) {
      super(class_atk.q);
      this.N = var1;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean d() {
      return false;
   }

   public boolean d(class_aen var1, class_cj var2) {
      return class_aen.a((class_aer)var1, (class_cj)var2.b())?super.d(var1, var2):false;
   }

   public boolean e(class_aen var1, class_cj var2) {
      return class_aen.a((class_aer)var1, (class_cj)var2.b());
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
   }

   public void b(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
      if(!this.b((class_aer) var1, var2, var3)) {
         boolean var5 = this.e(var1, var2, var3);
         if(this.N && !var5) {
            var1.a((class_cj)var2, (IBlockData)this.k(var3), 2);
         } else if(!this.N) {
            var1.a((class_cj)var2, (IBlockData)this.e(var3), 2);
            if(!var5) {
               var1.a(var2, this.e(var3).getBlock(), this.m(var3), -1);
            }
         }

      }
   }

   protected boolean l(IBlockData var1) {
      return this.N;
   }

   public int b(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      return this.a(var1, var2, var3, var4);
   }

   public int a(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      return !this.l(var3)?0:(var3.get(O) == var4?this.a(var1, var2, var3):0);
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      if(this.e(var1, var2)) {
         this.g(var1, var2, var3);
      } else {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         class_cq[] var5 = class_cq.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            class_cq var8 = var5[var7];
            var1.c((class_cj)var2.a(var8), (Block)this);
         }

      }
   }

   protected void g(class_aen var1, class_cj var2, IBlockData var3) {
      if(!this.b((class_aer) var1, var2, var3)) {
         boolean var4 = this.e(var1, var2, var3);
         if((this.N && !var4 || !this.N && var4) && !var1.a((class_cj)var2, (Block)this)) {
            byte var5 = -1;
            if(this.i(var1, var2, var3)) {
               var5 = -3;
            } else if(this.N) {
               var5 = -2;
            }

            var1.a(var2, this, this.d(var3), var5);
         }

      }
   }

   public boolean b(class_aer var1, class_cj var2, IBlockData var3) {
      return false;
   }

   protected boolean e(class_aen var1, class_cj var2, IBlockData var3) {
      return this.f(var1, var2, var3) > 0;
   }

   protected int f(class_aen var1, class_cj var2, IBlockData var3) {
      class_cq var4 = (class_cq)var3.get(O);
      class_cj var5 = var2.a(var4);
      int var6 = var1.c(var5, var4);
      if(var6 >= 15) {
         return var6;
      } else {
         IBlockData var7 = var1.p(var5);
         return Math.max(var6, var7.getBlock() == class_agk.af?((Integer)var7.get(class_akk.P)).intValue():0);
      }
   }

   protected int c(class_aer var1, class_cj var2, IBlockData var3) {
      class_cq var4 = (class_cq)var3.get(O);
      class_cq var5 = var4.e();
      class_cq var6 = var4.f();
      return Math.max(this.c(var1, var2.a(var5), var5), this.c(var1, var2.a(var6), var6));
   }

   protected int c(class_aer var1, class_cj var2, class_cq var3) {
      IBlockData var4 = var1.p(var2);
      Block var5 = var4.getBlock();
      return this.c(var5)?(var5 == class_agk.af?((Integer)var4.get(class_akk.P)).intValue():var1.a(var2, var3)):0;
   }

   public boolean i() {
      return true;
   }

   public IBlockData a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.S().set(O, var8.aR().d());
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_qa var4, class_aas var5) {
      if(this.e(var1, var2, var3)) {
         var1.a((class_cj)var2, (Block)this, 1);
      }

   }

   public void c(class_aen var1, class_cj var2, IBlockData var3) {
      this.h(var1, var2, var3);
   }

   protected void h(class_aen var1, class_cj var2, IBlockData var3) {
      class_cq var4 = (class_cq)var3.get(O);
      class_cj var5 = var2.a(var4.d());
      var1.d(var5, this);
      var1.a((class_cj)var5, (Block)this, (class_cq)var4);
   }

   public void d(class_aen var1, class_cj var2, IBlockData var3) {
      if(this.N) {
         class_cq[] var4 = class_cq.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            class_cq var7 = var4[var6];
            var1.c((class_cj)var2.a(var7), (Block)this);
         }
      }

      super.d(var1, var2, var3);
   }

   public boolean c() {
      return false;
   }

   protected boolean c(Block var1) {
      return var1.i();
   }

   protected int a(class_aer var1, class_cj var2, IBlockData var3) {
      return 15;
   }

   public static boolean d(Block var0) {
      return class_agk.bb.e(var0) || class_agk.cj.e(var0);
   }

   public boolean e(Block var1) {
      return var1 == this.e(this.S()).getBlock() || var1 == this.k(this.S()).getBlock();
   }

   public boolean i(class_aen var1, class_cj var2, IBlockData var3) {
      class_cq var4 = ((class_cq)var3.get(O)).d();
      class_cj var5 = var2.a(var4);
      return d(var1.p(var5).getBlock())?var1.p(var5).get(O) != var4:false;
   }

   protected int m(IBlockData var1) {
      return this.d(var1);
   }

   protected abstract int d(IBlockData var1);

   protected abstract IBlockData e(IBlockData var1);

   protected abstract IBlockData k(IBlockData var1);

   public boolean b(Block var1) {
      return this.e(var1);
   }
}
