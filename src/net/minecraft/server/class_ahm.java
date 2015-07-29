package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_alm;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;

public class class_ahm extends class_ago implements class_agl {
   public static final class_any a = class_any.a("variant", class_ahm.class_b_in_class_ahm.class);
   public static final class_any b = class_any.a("half", class_ahm.class_a_in_class_ahm.class);
   public static final class_any N;

   public class_ahm() {
      super(class_atk.l);
      this.j(this.M.b().set(a, class_ahm.class_b_in_class_ahm.a).set(b, class_ahm.class_a_in_class_ahm.b).set(N, class_cq.c));
      this.c(0.0F);
      this.a(STEP_SOUND_GRASS);
      this.c("doublePlant");
   }

   public void a(class_aer var1, class_cj var2) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public class_ahm.class_b_in_class_ahm e(class_aer var1, class_cj var2) {
      IBlockData var3 = var1.p(var2);
      if(var3.getBlock() == this) {
         var3 = this.a(var3, var1, var2);
         return (class_ahm.class_b_in_class_ahm)var3.get(a);
      } else {
         return class_ahm.class_b_in_class_ahm.d;
      }
   }

   public boolean d(class_aen var1, class_cj var2) {
      return super.d(var1, var2) && var1.d(var2.a());
   }

   public boolean a(class_aen var1, class_cj var2) {
      IBlockData var3 = var1.p(var2);
      if(var3.getBlock() != this) {
         return true;
      } else {
         class_ahm.class_b_in_class_ahm var4 = (class_ahm.class_b_in_class_ahm)this.a(var3, var1, var2).get(a);
         return var4 == class_ahm.class_b_in_class_ahm.d || var4 == class_ahm.class_b_in_class_ahm.c;
      }
   }

   protected void e(class_aen var1, class_cj var2, IBlockData var3) {
      if(!this.f(var1, var2, var3)) {
         boolean var4 = var3.get(b) == class_ahm.class_a_in_class_ahm.a;
         class_cj var5 = var4?var2:var2.a();
         class_cj var6 = var4?var2.b():var2;
         Object var7 = var4?this:var1.p(var5).getBlock();
         Object var8 = var4?var1.p(var6).getBlock():this;
         if(var7 == this) {
            var1.a((class_cj)var5, (IBlockData)class_agk.a.S(), 2);
         }

         if(var8 == this) {
            var1.a((class_cj)var6, (IBlockData)class_agk.a.S(), 3);
            if(!var4) {
               this.b(var1, var6, var3, 0);
            }
         }

      }
   }

   public boolean f(class_aen var1, class_cj var2, IBlockData var3) {
      if(var3.get(b) == class_ahm.class_a_in_class_ahm.a) {
         return var1.p(var2.b()).getBlock() == this;
      } else {
         IBlockData var4 = var1.p(var2.a());
         return var4.getBlock() == this && super.f(var1, var2, var4);
      }
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      if(var1.get(b) == class_ahm.class_a_in_class_ahm.a) {
         return null;
      } else {
         class_ahm.class_b_in_class_ahm var4 = (class_ahm.class_b_in_class_ahm)var1.get(a);
         return var4 == class_ahm.class_b_in_class_ahm.d?null:(var4 == class_ahm.class_b_in_class_ahm.c?(var2.nextInt(8) == 0?class_aau.P:null):class_aar.a((Block)this));
      }
   }

   public int a(IBlockData var1) {
      return var1.get(b) != class_ahm.class_a_in_class_ahm.a && var1.get(a) != class_ahm.class_b_in_class_ahm.c?((class_ahm.class_b_in_class_ahm)var1.get(a)).a():0;
   }

   public void a(class_aen var1, class_cj var2, class_ahm.class_b_in_class_ahm var3, int var4) {
      var1.a(var2, this.S().set(b, class_ahm.class_a_in_class_ahm.b).set(a, var3), var4);
      var1.a(var2.a(), this.S().set(b, class_ahm.class_a_in_class_ahm.a), var4);
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_qa var4, class_aas var5) {
      var1.a((class_cj)var2.a(), (IBlockData)this.S().set(b, class_ahm.class_a_in_class_ahm.a), 2);
   }

   public void a(class_aen var1, class_xa var2, class_cj var3, IBlockData var4, class_amg var5, class_aas var6) {
      if(var1.D || var6 == null || var6.b() != class_aau.bg || var4.get(b) != class_ahm.class_a_in_class_ahm.b || !this.b(var1, var3, var4, var2)) {
         super.a(var1, var2, var3, var4, var5, var6);
      }
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_xa var4) {
      if(var3.get(b) == class_ahm.class_a_in_class_ahm.a) {
         if(var1.p(var2.b()).getBlock() == this) {
            if(!var4.bH.d) {
               IBlockData var5 = var1.p(var2.b());
               class_ahm.class_b_in_class_ahm var6 = (class_ahm.class_b_in_class_ahm)var5.get(a);
               if(var6 != class_ahm.class_b_in_class_ahm.d && var6 != class_ahm.class_b_in_class_ahm.c) {
                  var1.b(var2.b(), true);
               } else if(!var1.D) {
                  if(var4.bA() != null && var4.bA().b() == class_aau.bg) {
                     this.b(var1, var2, var5, var4);
                     var1.g(var2.b());
                  } else {
                     var1.b(var2.b(), true);
                  }
               } else {
                  var1.g(var2.b());
               }
            } else {
               var1.g(var2.b());
            }
         }
      } else if(var4.bH.d && var1.p(var2.a()).getBlock() == this) {
         var1.a((class_cj)var2.a(), (IBlockData)class_agk.a.S(), 2);
      }

      super.a(var1, var2, var3, var4);
   }

   private boolean b(class_aen var1, class_cj var2, IBlockData var3, class_xa var4) {
      class_ahm.class_b_in_class_ahm var5 = (class_ahm.class_b_in_class_ahm)var3.get(a);
      if(var5 != class_ahm.class_b_in_class_ahm.d && var5 != class_ahm.class_b_in_class_ahm.c) {
         return false;
      } else {
         var4.b(class_nc.ab[Block.getId((Block)this)]);
         int var6 = (var5 == class_ahm.class_b_in_class_ahm.c?class_alm.class_a_in_class_alm.b:class_alm.class_a_in_class_alm.c).a();
         a(var1, var2, new class_aas(class_agk.H, 2, var6));
         return true;
      }
   }

   public int j(class_aen var1, class_cj var2) {
      return this.e(var1, var2).a();
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, boolean var4) {
      class_ahm.class_b_in_class_ahm var5 = this.e(var1, var2);
      return var5 != class_ahm.class_b_in_class_ahm.c && var5 != class_ahm.class_b_in_class_ahm.d;
   }

   public boolean a(class_aen var1, Random var2, class_cj var3, IBlockData var4) {
      return true;
   }

   public void b(class_aen var1, Random var2, class_cj var3, IBlockData var4) {
      a(var1, var3, new class_aas(this, 1, this.e(var1, var3).a()));
   }

   public IBlockData a(int var1) {
      return (var1 & 8) > 0?this.S().set(b, class_ahm.class_a_in_class_ahm.a):this.S().set(b, class_ahm.class_a_in_class_ahm.b).set(a, class_ahm.class_b_in_class_ahm.a(var1 & 7));
   }

   public IBlockData a(IBlockData var1, class_aer var2, class_cj var3) {
      if(var1.get(b) == class_ahm.class_a_in_class_ahm.a) {
         IBlockData var4 = var2.p(var3.b());
         if(var4.getBlock() == this) {
            var1 = var1.set(a, var4.get(a));
         }
      }

      return var1;
   }

   public int c(IBlockData var1) {
      return var1.get(b) == class_ahm.class_a_in_class_ahm.a?8 | ((class_cq)var1.get(N)).b():((class_ahm.class_b_in_class_ahm)var1.get(a)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{b, a, N});
   }

   static {
      N = class_aiv.O;
   }

   public static enum class_a_in_class_ahm implements class_ny {
      a,
      b;

      public String toString() {
         return this.l();
      }

      public String l() {
         return this == a?"upper":"lower";
      }
   }

   public static enum class_b_in_class_ahm implements class_ny {
      a(0, "sunflower"),
      b(1, "syringa"),
      c(2, "double_grass", "grass"),
      d(3, "double_fern", "fern"),
      e(4, "double_rose", "rose"),
      f(5, "paeonia");

      private static final class_ahm.class_b_in_class_ahm[] g;
      private final int h;
      private final String i;
      private final String j;

      private class_b_in_class_ahm(int var3, String var4) {
         this(var3, var4, var4);
      }

      private class_b_in_class_ahm(int var3, String var4, String var5) {
         this.h = var3;
         this.i = var4;
         this.j = var5;
      }

      public int a() {
         return this.h;
      }

      public String toString() {
         return this.i;
      }

      public static class_ahm.class_b_in_class_ahm a(int var0) {
         if(var0 < 0 || var0 >= g.length) {
            var0 = 0;
         }

         return g[var0];
      }

      public String l() {
         return this.i;
      }

      public String c() {
         return this.j;
      }

      static {
         g = new class_ahm.class_b_in_class_ahm[values().length];
         class_ahm.class_b_in_class_ahm[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_ahm.class_b_in_class_ahm var3 = var0[var2];
            g[var3.a()] = var3;
         }

      }
   }
}
