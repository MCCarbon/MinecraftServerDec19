package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_alh;
import net.minecraft.server.class_ali;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_wm;
import net.minecraft.server.CreativeTab;

public class class_ajh extends Block {
   public static final class_any a = class_any.a("variant", class_ajh.class_a_in_class_ajh.class);

   public class_ajh() {
      super(class_atk.B);
      this.j(this.M.b().set(a, class_ajh.class_a_in_class_ajh.a));
      this.c(0.0F);
      this.a(CreativeTab.c);
   }

   public int a(Random var1) {
      return 0;
   }

   public static boolean d(IBlockData var0) {
      Block var1 = var0.getBlock();
      return var0 == class_agk.b.S().set(class_alh.a, class_alh.class_a_in_class_alh.a) || var1 == class_agk.e || var1 == class_agk.bf;
   }

   protected class_aas i(IBlockData var1) {
      switch(class_ajh.SyntheticClass_1.a[((class_ajh.class_a_in_class_ajh)var1.get(a)).ordinal()]) {
      case 1:
         return new class_aas(class_agk.e);
      case 2:
         return new class_aas(class_agk.bf);
      case 3:
         return new class_aas(class_agk.bf, 1, class_ali.class_a_in_class_ali.b.a());
      case 4:
         return new class_aas(class_agk.bf, 1, class_ali.class_a_in_class_ali.c.a());
      case 5:
         return new class_aas(class_agk.bf, 1, class_ali.class_a_in_class_ali.d.a());
      default:
         return new class_aas(class_agk.b);
      }
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, float var4, int var5) {
      if(!var1.D && var1.R().b("doTileDrops")) {
         class_wm var6 = new class_wm(var1);
         var6.b((double)var2.n() + 0.5D, (double)var2.o(), (double)var2.p() + 0.5D, 0.0F, 0.0F);
         var1.a((class_pr)var6);
         var6.A();
      }

   }

   public int j(class_aen var1, class_cj var2) {
      IBlockData var3 = var1.p(var2);
      return var3.getBlock().c(var3);
   }

   public IBlockData a(int var1) {
      return this.S().set(a, class_ajh.class_a_in_class_ajh.a(var1));
   }

   public int c(IBlockData var1) {
      return ((class_ajh.class_a_in_class_ajh)var1.get(a)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_ajh.class_a_in_class_ajh.values().length];

      static {
         try {
            a[class_ajh.class_a_in_class_ajh.b.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_ajh.class_a_in_class_ajh.c.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_ajh.class_a_in_class_ajh.d.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_ajh.class_a_in_class_ajh.e.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_ajh.class_a_in_class_ajh.f.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_ajh implements class_ny {
      a(0, "stone") {
         public IBlockData d() {
            return class_agk.b.S().set(class_alh.a, class_alh.class_a_in_class_alh.a);
         }
      },
      b(1, "cobblestone", "cobble") {
         public IBlockData d() {
            return class_agk.e.S();
         }
      },
      c(2, "stone_brick", "brick") {
         public IBlockData d() {
            return class_agk.bf.S().set(class_ali.a, class_ali.class_a_in_class_ali.a);
         }
      },
      d(3, "mossy_brick", "mossybrick") {
         public IBlockData d() {
            return class_agk.bf.S().set(class_ali.a, class_ali.class_a_in_class_ali.b);
         }
      },
      e(4, "cracked_brick", "crackedbrick") {
         public IBlockData d() {
            return class_agk.bf.S().set(class_ali.a, class_ali.class_a_in_class_ali.c);
         }
      },
      f(5, "chiseled_brick", "chiseledbrick") {
         public IBlockData d() {
            return class_agk.bf.S().set(class_ali.a, class_ali.class_a_in_class_ali.d);
         }
      };

      private static final class_ajh.class_a_in_class_ajh[] g;
      private final int h;
      private final String i;
      private final String j;

      private class_a_in_class_ajh(int var3, String var4) {
         this(var3, var4, var4);
      }

      private class_a_in_class_ajh(int var3, String var4, String var5) {
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

      public static class_ajh.class_a_in_class_ajh a(int var0) {
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

      public abstract IBlockData d();

      public static class_ajh.class_a_in_class_ajh a(IBlockData var0) {
         class_ajh.class_a_in_class_ajh[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            class_ajh.class_a_in_class_ajh var4 = var1[var3];
            if(var0 == var4.d()) {
               return var4;
            }
         }

         return a;
      }

      // $FF: synthetic method
      class_a_in_class_ajh(int var3, String var4, class_ajh.SyntheticClass_1 var5) {
         this(var3, var4);
      }

      // $FF: synthetic method
      class_a_in_class_ajh(int var3, String var4, String var5, class_ajh.SyntheticClass_1 var6) {
         this(var3, var4, var5);
      }

      static {
         g = new class_ajh.class_a_in_class_ajh[values().length];
         class_ajh.class_a_in_class_ajh[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_ajh.class_a_in_class_ajh var3 = var0[var2];
            g[var3.a()] = var3;
         }

      }
   }
}
