package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Iterator;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahz;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anx;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_qa;
import net.minecraft.server.CreativeTab;

public class class_alp extends Block {
   public static final class_anx a = class_anx.a("facing", new Predicate() {
      public boolean a(class_cq var1) {
         return var1 != class_cq.a;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_cq)var1);
      }
   });

   protected class_alp() {
      super(class_atk.q);
      this.j(this.M.b().set(a, class_cq.b));
      this.a(true);
      this.a(CreativeTab.c);
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

   private boolean e(class_aen var1, class_cj var2) {
      if(class_aen.a((class_aer)var1, (class_cj)var2)) {
         return true;
      } else {
         Block var3 = var1.p(var2).getBlock();
         return var3 instanceof class_ahz || var3 == class_agk.w || var3 == class_agk.bZ || var3 == class_agk.cG;
      }
   }

   public boolean d(class_aen var1, class_cj var2) {
      Iterator var3 = a.c().iterator();

      class_cq var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (class_cq)var3.next();
      } while(!this.a(var1, var2, var4));

      return true;
   }

   private boolean a(class_aen var1, class_cj var2, class_cq var3) {
      class_cj var4 = var2.a(var3.d());
      boolean var5 = var3.k().c();
      return var5 && var1.d(var4, true) || var3.equals(class_cq.b) && this.e(var1, var4);
   }

   public IBlockData a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      if(this.a(var1, var2, var3)) {
         return this.S().set(a, var3);
      } else {
         Iterator var9 = class_cq.class_c_in_class_cq.a.iterator();

         class_cq var10;
         do {
            if(!var9.hasNext()) {
               return this.S();
            }

            var10 = (class_cq)var9.next();
         } while(!var1.d(var2.a(var10.d()), true));

         return this.S().set(a, var10);
      }
   }

   public void c(class_aen var1, class_cj var2, IBlockData var3) {
      this.f(var1, var2, var3);
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   protected boolean e(class_aen var1, class_cj var2, IBlockData var3) {
      if(!this.f(var1, var2, var3)) {
         return true;
      } else {
         class_cq var4 = (class_cq)var3.get(a);
         class_cq.class_a_in_class_cq var5 = var4.k();
         class_cq var6 = var4.d();
         boolean var7 = false;
         if(var5.c() && !var1.d(var2.a(var6), true)) {
            var7 = true;
         } else if(var5.b() && !this.e(var1, var2.a(var6))) {
            var7 = true;
         }

         if(var7) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
            return true;
         } else {
            return false;
         }
      }
   }

   protected boolean f(class_aen var1, class_cj var2, IBlockData var3) {
      if(var3.getBlock() == this && this.a(var1, var2, (class_cq)var3.get(a))) {
         return true;
      } else {
         if(var1.p(var2).getBlock() == this) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         }

         return false;
      }
   }

   public class_awg a(class_aen var1, class_cj var2, class_awh var3, class_awh var4) {
      class_cq var5 = (class_cq)var1.p(var2).get(a);
      float var6 = 0.15F;
      if(var5 == class_cq.f) {
         this.a(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
      } else if(var5 == class_cq.e) {
         this.a(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
      } else if(var5 == class_cq.d) {
         this.a(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
      } else if(var5 == class_cq.c) {
         this.a(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
      } else {
         var6 = 0.1F;
         this.a(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
      }

      return super.a(var1, var2, var3, var4);
   }

   public IBlockData a(int var1) {
      IBlockData var2 = this.S();
      switch(var1) {
      case 1:
         var2 = var2.set(a, class_cq.f);
         break;
      case 2:
         var2 = var2.set(a, class_cq.e);
         break;
      case 3:
         var2 = var2.set(a, class_cq.d);
         break;
      case 4:
         var2 = var2.set(a, class_cq.c);
         break;
      case 5:
      default:
         var2 = var2.set(a, class_cq.b);
      }

      return var2;
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3;
      switch(class_alp.SyntheticClass_1.a[((class_cq)var1.get(a)).ordinal()]) {
      case 1:
         var3 = var2 | 1;
         break;
      case 2:
         var3 = var2 | 2;
         break;
      case 3:
         var3 = var2 | 3;
         break;
      case 4:
         var3 = var2 | 4;
         break;
      case 5:
      case 6:
      default:
         var3 = var2 | 5;
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
      return new class_anm(this, new IBlockState[]{a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_cq.values().length];

      static {
         try {
            a[class_cq.f.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_cq.e.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_cq.d.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_cq.c.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_cq.a.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.b.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
