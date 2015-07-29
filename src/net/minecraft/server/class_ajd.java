package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahp;
import net.minecraft.server.class_alf;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_pr;

public abstract class class_ajd extends Block {
   public static final class_anz b = class_anz.a("level", 0, 15);

   protected class_ajd(class_atk var1) {
      super(var1);
      this.j(this.M.b().set(b, Integer.valueOf(0)));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      this.a(true);
   }

   public boolean b(class_aer var1, class_cj var2) {
      return this.J != class_atk.i;
   }

   public static float b(int var0) {
      if(var0 >= 8) {
         var0 = 0;
      }

      return (float)(var0 + 1) / 9.0F;
   }

   protected int e(class_aer var1, class_cj var2) {
      return var1.p(var2).getBlock().v() == this.J?((Integer)var1.p(var2).get(b)).intValue():-1;
   }

   protected int f(class_aer var1, class_cj var2) {
      int var3 = this.e(var1, var2);
      return var3 >= 8?0:var3;
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public boolean a(IBlockData var1, boolean var2) {
      return var2 && ((Integer)var1.get(b)).intValue() == 0;
   }

   public boolean b(class_aer var1, class_cj var2, class_cq var3) {
      class_atk var4 = var1.p(var2).getBlock().v();
      return var4 == this.J?false:(var3 == class_cq.b?true:(var4 == class_atk.w?false:super.b(var1, var2, var3)));
   }

   public class_awf a(class_aen var1, class_cj var2, IBlockData var3) {
      return null;
   }

   public int b() {
      return 1;
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return null;
   }

   public int a(Random var1) {
      return 0;
   }

   protected class_awh h(class_aer var1, class_cj var2) {
      class_awh var3 = new class_awh(0.0D, 0.0D, 0.0D);
      int var4 = this.f(var1, var2);
      Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

      class_cq var6;
      class_cj var7;
      while(var5.hasNext()) {
         var6 = (class_cq)var5.next();
         var7 = var2.a(var6);
         int var8 = this.f(var1, var7);
         int var9;
         if(var8 < 0) {
            if(!var1.p(var7).getBlock().v().c()) {
               var8 = this.f(var1, var7.b());
               if(var8 >= 0) {
                  var9 = var8 - (var4 - 8);
                  var3 = var3.b((double)((var7.n() - var2.n()) * var9), (double)((var7.o() - var2.o()) * var9), (double)((var7.p() - var2.p()) * var9));
               }
            }
         } else if(var8 >= 0) {
            var9 = var8 - var4;
            var3 = var3.b((double)((var7.n() - var2.n()) * var9), (double)((var7.o() - var2.o()) * var9), (double)((var7.p() - var2.p()) * var9));
         }
      }

      if(((Integer)var1.p(var2).get(b)).intValue() >= 8) {
         var5 = class_cq.class_c_in_class_cq.a.iterator();

         do {
            if(!var5.hasNext()) {
               return var3.a();
            }

            var6 = (class_cq)var5.next();
            var7 = var2.a(var6);
         } while(!this.b(var1, var7, var6) && !this.b(var1, var7.a(), var6));

         var3 = var3.a().b(0.0D, -6.0D, 0.0D);
      }

      return var3.a();
   }

   public class_awh a(class_aen var1, class_cj var2, class_pr var3, class_awh var4) {
      return var4.e(this.h(var1, var2));
   }

   public int a(class_aen var1) {
      return this.J == class_atk.h?5:(this.J == class_atk.i?(var1.t.m()?10:30):0);
   }

   public void c(class_aen var1, class_cj var2, IBlockData var3) {
      this.e(var1, var2, var3);
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   public boolean e(class_aen var1, class_cj var2, IBlockData var3) {
      if(this.J == class_atk.i) {
         boolean var4 = false;
         class_cq[] var5 = class_cq.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            class_cq var8 = var5[var7];
            if(var8 != class_cq.a && var1.p(var2.a(var8)).getBlock().v() == class_atk.h) {
               var4 = true;
               break;
            }
         }

         if(var4) {
            Integer var9 = (Integer)var3.get(b);
            if(var9.intValue() == 0) {
               var1.a(var2, class_agk.Z.S());
               this.e(var1, var2);
               return true;
            }

            if(var9.intValue() <= 4) {
               var1.a(var2, class_agk.e.S());
               this.e(var1, var2);
               return true;
            }
         }
      }

      return false;
   }

   protected void e(class_aen var1, class_cj var2) {
      double var3 = (double)var2.n();
      double var5 = (double)var2.o();
      double var7 = (double)var2.p();
      var1.a(var3 + 0.5D, var5 + 0.5D, var7 + 0.5D, "random.fizz", 0.5F, 2.6F + (var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F);

      for(int var9 = 0; var9 < 8; ++var9) {
         var1.a(class_cy.m, var3 + Math.random(), var5 + 1.2D, var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   public IBlockData a(int var1) {
      return this.S().set(b, Integer.valueOf(var1));
   }

   public int c(IBlockData var1) {
      return ((Integer)var1.get(b)).intValue();
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{b});
   }

   public static class_ahp a(class_atk var0) {
      if(var0 == class_atk.h) {
         return class_agk.i;
      } else if(var0 == class_atk.i) {
         return class_agk.k;
      } else {
         throw new IllegalArgumentException("Invalid material");
      }
   }

   public static class_alf b(class_atk var0) {
      if(var0 == class_atk.h) {
         return class_agk.j;
      } else if(var0 == class_atk.i) {
         return class_agk.l;
      } else {
         throw new IllegalArgumentException("Invalid material");
      }
   }
}
