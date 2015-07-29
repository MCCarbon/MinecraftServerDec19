package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_zu;

public class class_aln extends class_agj {
   public static final class_anw b = class_anw.a("north");
   public static final class_anw N = class_anw.a("east");
   public static final class_anw O = class_anw.a("south");
   public static final class_anw P = class_anw.a("west");
   private final boolean a;

   protected class_aln(class_atk var1, boolean var2) {
      super(var1);
      this.j(this.M.b().a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)));
      this.a = var2;
      this.a(class_zu.c);
   }

   public class_anl a(class_anl var1, class_aer var2, class_cj var3) {
      return var1.a(b, Boolean.valueOf(this.c(var2.p(var3.c()).c()))).a(O, Boolean.valueOf(this.c(var2.p(var3.d()).c()))).a(P, Boolean.valueOf(this.c(var2.p(var3.e()).c()))).a(N, Boolean.valueOf(this.c(var2.p(var3.f()).c())));
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return !this.a?null:super.a(var1, var2, var3);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_awf var4, List var5, class_pr var6) {
      boolean var7 = this.c(var1.p(var2.c()).c());
      boolean var8 = this.c(var1.p(var2.d()).c());
      boolean var9 = this.c(var1.p(var2.e()).c());
      boolean var10 = this.c(var1.p(var2.f()).c());
      if(var9 && var10) {
         this.a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
         super.a(var1, var2, var3, var4, var5, var6);
      } else if(!var9 && !var10 && !var7 && !var8) {
         this.a(0.4375F, 0.4375F, 0.4375F, 0.5625F, 0.5625F, 0.5625F);
         super.a(var1, var2, var3, var4, var5, var6);
      } else if(var9) {
         this.a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
         super.a(var1, var2, var3, var4, var5, var6);
      } else if(var10) {
         this.a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
         super.a(var1, var2, var3, var4, var5, var6);
      }

      if(var7 && var8) {
         this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
         super.a(var1, var2, var3, var4, var5, var6);
      } else if(!var9 && !var10 && !var7 && !var8) {
         this.a(0.4375F, 0.0F, 0.4375F, 0.5625F, 1.0F, 0.5625F);
         super.a(var1, var2, var3, var4, var5, var6);
      } else if(var7) {
         this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
         super.a(var1, var2, var3, var4, var5, var6);
      } else if(var8) {
         this.a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
         super.a(var1, var2, var3, var4, var5, var6);
      }

   }

   public void j() {
      this.a(0.4375F, 0.4375F, 0.0F, 0.5625F, 1.0F, 0.5625F);
   }

   public void a(class_aer var1, class_cj var2) {
      float var3 = 0.4375F;
      float var4 = 0.5625F;
      float var5 = 0.4375F;
      float var6 = 0.5625F;
      boolean var7 = this.c(var1.p(var2.c()).c());
      boolean var8 = this.c(var1.p(var2.d()).c());
      boolean var9 = this.c(var1.p(var2.e()).c());
      boolean var10 = this.c(var1.p(var2.f()).c());
      if(var9 && var10) {
         var3 = 0.0F;
         var4 = 1.0F;
      } else if(var9) {
         var3 = 0.0F;
      } else if(var10) {
         var4 = 1.0F;
      }

      if(var7 && var8) {
         var5 = 0.0F;
         var6 = 1.0F;
      } else if(var7) {
         var5 = 0.0F;
      } else if(var8) {
         var6 = 1.0F;
      }

      this.a(var3, 0.0F, var5, var4, 1.0F, var6);
   }

   public final boolean c(class_agj var1) {
      return var1.q() || var1 == this || var1 == class_agk.w || var1 == class_agk.cG || var1 == class_agk.cH || var1 instanceof class_aln;
   }

   protected boolean K() {
      return true;
   }

   public int c(class_anl var1) {
      return 0;
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_aln.SyntheticClass_1.a[var2.ordinal()]) {
         case 1:
            return var1.a(b, var1.b(O)).a(N, var1.b(P)).a(O, var1.b(b)).a(P, var1.b(N));
         case 2:
            return var1.a(b, var1.b(N)).a(N, var1.b(O)).a(O, var1.b(P)).a(P, var1.b(b));
         case 3:
            return var1.a(b, var1.b(P)).a(N, var1.b(b)).a(O, var1.b(N)).a(P, var1.b(O));
         default:
            return var1;
         }
      }
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_aln.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            return var1.a(b, var1.b(O)).a(O, var1.b(b));
         case 2:
            return var1.a(N, var1.b(P)).a(P, var1.b(N));
         default:
            return super.a(var1, var2);
         }
      }
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{b, N, P, O});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[class_agj.class_a_in_class_agj.values().length];

      static {
         try {
            b[class_agj.class_a_in_class_agj.b.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[class_agj.class_a_in_class_agj.c.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[class_agj.class_c_in_class_agj.values().length];

         try {
            a[class_agj.class_c_in_class_agj.c.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_agj.class_c_in_class_agj.d.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_agj.class_c_in_class_agj.b.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
