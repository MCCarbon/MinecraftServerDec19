package net.minecraft.server;

import com.google.common.base.Objects;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_als;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anx;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_qa;
import net.minecraft.server.CreativeTab;

public class class_alt extends Block {
   public static final class_anx a;
   public static final class_anw b;
   public static final class_anw N;
   public static final class_anw O;

   public class_alt() {
      super(class_atk.q);
      this.j(this.M.b().set(a, class_cq.c).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)));
      this.a(CreativeTab.d);
      this.a(true);
   }

   public IBlockData a(IBlockData var1, class_aer var2, class_cj var3) {
      return var1.set(O, Boolean.valueOf(!class_aen.a(var2, var3.b())));
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

   public boolean b(class_aen var1, class_cj var2, class_cq var3) {
      return var3.k().c() && var1.p(var2.a(var3.d())).getBlock().x();
   }

   public boolean d(class_aen var1, class_cj var2) {
      Iterator var3 = class_cq.class_c_in_class_cq.a.iterator();

      class_cq var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (class_cq)var3.next();
      } while(!var1.p(var2.a(var4)).getBlock().x());

      return true;
   }

   public IBlockData a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      IBlockData var9 = this.S().set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false));
      if(var3.k().c()) {
         var9 = var9.set(a, var3);
      }

      return var9;
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_qa var4, class_aas var5) {
      this.a(var1, var2, var3, false, false, -1, (IBlockData)null);
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      if(var4 != this) {
         if(this.e(var1, var2, var3)) {
            class_cq var5 = (class_cq)var3.get(a);
            if(!var1.p(var2.a(var5.d())).getBlock().x()) {
               this.b(var1, var2, var3, 0);
               var1.g(var2);
            }
         }

      }
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, boolean var4, boolean var5, int var6, IBlockData var7) {
      class_cq var8 = (class_cq)var3.get(a);
      boolean var9 = ((Boolean)var3.get(N)).booleanValue();
      boolean var10 = ((Boolean)var3.get(b)).booleanValue();
      boolean var11 = !class_aen.a((class_aer)var1, (class_cj)var2.b());
      boolean var12 = !var4;
      boolean var13 = false;
      int var14 = 0;
      IBlockData[] var15 = new IBlockData[42];

      class_cj var17;
      for(int var16 = 1; var16 < 42; ++var16) {
         var17 = var2.a(var8, var16);
         IBlockData var18 = var1.p(var17);
         if(var18.getBlock() == class_agk.bR) {
            if(var18.get(a) == var8.d()) {
               var14 = var16;
            }
            break;
         }

         if(var18.getBlock() != class_agk.bS && var16 != var6) {
            var15[var16] = null;
            var12 = false;
         } else {
            if(var16 == var6) {
               var18 = (IBlockData)Objects.firstNonNull(var7, var18);
            }

            boolean var19 = !((Boolean)var18.get(class_als.O)).booleanValue();
            boolean var20 = ((Boolean)var18.get(class_als.a)).booleanValue();
            boolean var21 = ((Boolean)var18.get(class_als.b)).booleanValue();
            var12 &= var21 == var11;
            var13 |= var19 && var20;
            var15[var16] = var18;
            if(var16 == var6) {
               var1.a((class_cj)var2, (Block)this, this.a(var1));
               var12 &= var19;
            }
         }
      }

      var12 &= var14 > 1;
      var13 &= var12;
      IBlockData var22 = this.S().set(N, Boolean.valueOf(var12)).set(b, Boolean.valueOf(var13));
      if(var14 > 0) {
         var17 = var2.a(var8, var14);
         class_cq var24 = var8.d();
         var1.a((class_cj)var17, (IBlockData)var22.set(a, var24), 3);
         this.a(var1, var17, var24);
         this.a(var1, var17, var12, var13, var9, var10);
      }

      this.a(var1, var2, var12, var13, var9, var10);
      if(!var4) {
         var1.a((class_cj)var2, (IBlockData)var22.set(a, var8), 3);
         if(var5) {
            this.a(var1, var2, var8);
         }
      }

      if(var9 != var12) {
         for(int var23 = 1; var23 < var14; ++var23) {
            class_cj var25 = var2.a(var8, var23);
            IBlockData var26 = var15[var23];
            if(var26 != null && var1.p(var25).getBlock() != class_agk.a) {
               var1.a((class_cj)var25, (IBlockData)var26.set(N, Boolean.valueOf(var12)), 3);
            }
         }
      }

   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
   }

   public void b(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
      this.a(var1, var2, var3, false, true, -1, (IBlockData)null);
   }

   private void a(class_aen var1, class_cj var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      if(var4 && !var6) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.4F, 0.6F);
      } else if(!var4 && var6) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.4F, 0.5F);
      } else if(var3 && !var5) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.4F, 0.7F);
      } else if(!var3 && var5) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.bowhit", 0.4F, 1.2F / (var1.s.nextFloat() * 0.2F + 0.9F));
      }

   }

   private void a(class_aen var1, class_cj var2, class_cq var3) {
      var1.c((class_cj)var2, (Block)this);
      var1.c((class_cj)var2.a(var3.d()), (Block)this);
   }

   private boolean e(class_aen var1, class_cj var2, IBlockData var3) {
      if(!this.d(var1, var2)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      } else {
         return true;
      }
   }

   public void a(class_aer var1, class_cj var2) {
      float var3 = 0.1875F;
      switch(class_alt.SyntheticClass_1.a[((class_cq)var1.p(var2).get(a)).ordinal()]) {
      case 1:
         this.a(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
         break;
      case 2:
         this.a(1.0F - var3 * 2.0F, 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
         break;
      case 3:
         this.a(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
         break;
      case 4:
         this.a(0.5F - var3, 0.2F, 1.0F - var3 * 2.0F, 0.5F + var3, 0.8F, 1.0F);
      }

   }

   public void b(class_aen var1, class_cj var2, IBlockData var3) {
      boolean var4 = ((Boolean)var3.get(N)).booleanValue();
      boolean var5 = ((Boolean)var3.get(b)).booleanValue();
      if(var4 || var5) {
         this.a(var1, var2, var3, true, false, -1, (IBlockData)null);
      }

      if(var5) {
         var1.c((class_cj)var2, (Block)this);
         var1.c((class_cj)var2.a(((class_cq)var3.get(a)).d()), (Block)this);
      }

      super.b(var1, var2, var3);
   }

   public int a(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      return ((Boolean)var3.get(b)).booleanValue()?15:0;
   }

   public int b(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      return !((Boolean)var3.get(b)).booleanValue()?0:(var3.get(a) == var4?15:0);
   }

   public boolean i() {
      return true;
   }

   public IBlockData a(int var1) {
      return this.S().set(a, class_cq.b(var1 & 3)).set(b, Boolean.valueOf((var1 & 8) > 0)).set(N, Boolean.valueOf((var1 & 4) > 0));
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_cq)var1.get(a)).b();
      if(((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 8;
      }

      if(((Boolean)var1.get(N)).booleanValue()) {
         var3 |= 4;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((class_cq)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((class_cq)var1.get(a)));
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a, b, N, O});
   }

   static {
      a = class_aiv.O;
      b = class_anw.a("powered");
      N = class_anw.a("attached");
      O = class_anw.a("suspended");
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_cq.values().length];

      static {
         try {
            a[class_cq.f.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_cq.e.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_cq.d.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.c.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
