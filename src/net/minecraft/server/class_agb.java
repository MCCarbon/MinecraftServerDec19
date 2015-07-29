package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_ame;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anx;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_di;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_xa;

public class class_agb extends class_agd {
   public static final class_anx a;
   public static final class_anz b;

   protected class_agb() {
      super(class_atk.d);
      float var1 = 0.25F;
      float var2 = 1.0F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
   }

   public String f() {
      return class_di.a("item.banner.white.name");
   }

   public class_awf a(class_aen var1, class_cj var2, IBlockData var3) {
      return null;
   }

   public boolean d() {
      return false;
   }

   public boolean b(class_aer var1, class_cj var2) {
      return true;
   }

   public boolean c() {
      return false;
   }

   public boolean g() {
      return true;
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_ame();
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aau.cH;
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, float var4, int var5) {
      class_amg var6 = var1.s(var2);
      if(var6 instanceof class_ame) {
         class_aas var7 = new class_aas(class_aau.cH, 1, ((class_ame)var6).b());
         class_dn var8 = new class_dn();
         var6.b(var8);
         var8.p("x");
         var8.p("y");
         var8.p("z");
         var8.p("id");
         var7.a((String)"BlockEntityTag", (class_eb)var8);
         a(var1, var2, var7);
      } else {
         super.a(var1, var2, var3, var4, var5);
      }

   }

   public boolean d(class_aen var1, class_cj var2) {
      return !this.e(var1, var2) && super.d(var1, var2);
   }

   public void a(class_aen var1, class_xa var2, class_cj var3, IBlockData var4, class_amg var5, class_aas var6) {
      if(var5 instanceof class_ame) {
         class_ame var7 = (class_ame)var5;
         class_aas var8 = new class_aas(class_aau.cH, 1, ((class_ame)var5).b());
         class_dn var9 = new class_dn();
         class_ame.a(var9, var7.b(), var7.d());
         var8.a((String)"BlockEntityTag", (class_eb)var9);
         a(var1, var3, var8);
      } else {
         super.a(var1, var2, var3, var4, (class_amg)null, var6);
      }

   }

   static {
      a = class_aiv.O;
      b = class_anz.a("rotation", 0, 15);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_cq.values().length];

      static {
         try {
            a[class_cq.c.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_cq.d.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_cq.e.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.f.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static class class_a_in_class_agb extends class_agb {
      public class_a_in_class_agb() {
         this.j(this.M.b().set(b, Integer.valueOf(0)));
      }

      public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
         return var1.getBlock() != this?var1:var1.set(b, Integer.valueOf(var2.a(((Integer)var1.get(b)).intValue(), 16)));
      }

      public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
         return var1.getBlock() != this?var1:var1.set(b, Integer.valueOf(var2.a(((Integer)var1.get(b)).intValue(), 16)));
      }

      public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
         if(!var1.p(var2.b()).getBlock().v().a()) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         }

         super.a(var1, var2, var3, var4);
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
   }

   public static class class_b_in_class_agb extends class_agb {
      public class_b_in_class_agb() {
         this.j(this.M.b().set(a, class_cq.c));
      }

      public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
         return var1.getBlock() != this?var1:var1.set(a, var2.a((class_cq)var1.get(a)));
      }

      public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
         return var1.getBlock() != this?var1:this.a(var1, var2.a((class_cq)var1.get(a)));
      }

      public void a(class_aer var1, class_cj var2) {
         class_cq var3 = (class_cq)var1.p(var2).get(a);
         float var4 = 0.0F;
         float var5 = 0.78125F;
         float var6 = 0.0F;
         float var7 = 1.0F;
         float var8 = 0.125F;
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         switch(class_agb.SyntheticClass_1.a[var3.ordinal()]) {
         case 1:
         default:
            this.a(var6, var4, 1.0F - var8, var7, var5, 1.0F);
            break;
         case 2:
            this.a(var6, var4, 0.0F, var7, var5, var8);
            break;
         case 3:
            this.a(1.0F - var8, var4, var6, 1.0F, var5, var7);
            break;
         case 4:
            this.a(0.0F, var4, var6, var8, var5, var7);
         }

      }

      public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
         class_cq var5 = (class_cq)var3.get(a);
         if(!var1.p(var2.a(var5.d())).getBlock().v().a()) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         }

         super.a(var1, var2, var3, var4);
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

      protected class_anm e() {
         return new class_anm(this, new IBlockState[]{a});
      }
   }
}
