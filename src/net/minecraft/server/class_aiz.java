package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_aiv;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anx;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_qa;
import net.minecraft.server.CreativeTab;

public class class_aiz extends Block {
   public static final class_anx a;

   protected class_aiz() {
      super(class_atk.q);
      this.j(this.M.b().set(a, class_cq.c));
      this.a(CreativeTab.c);
   }

   public class_awf a(class_aen var1, class_cj var2, IBlockData var3) {
      this.a((class_aer)var1, (class_cj)var2);
      return super.a(var1, var2, var3);
   }

   public void a(class_aer var1, class_cj var2) {
      IBlockData var3 = var1.p(var2);
      if(var3.getBlock() == this) {
         float var4 = 0.1875F;
         switch(class_aiz.SyntheticClass_1.a[((class_cq)var3.get(a)).ordinal()]) {
         case 1:
            this.a(0.0F, 0.0F, 1.0F - var4, 1.0F, 1.0F, 1.0F);
            break;
         case 2:
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var4);
            break;
         case 3:
            this.a(1.0F - var4, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 4:
         default:
            this.a(0.0F, 0.0F, 0.0F, var4, 1.0F, 1.0F);
         }

      }
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean d(class_aen var1, class_cj var2) {
      return var1.p(var2.e()).getBlock().x()?true:(var1.p(var2.f()).getBlock().x()?true:(var1.p(var2.c()).getBlock().x()?true:var1.p(var2.d()).getBlock().x()));
   }

   public IBlockData a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      if(var3.k().c() && this.a(var1, var2, var3)) {
         return this.S().set(a, var3);
      } else {
         Iterator var9 = class_cq.class_c_in_class_cq.a.iterator();

         class_cq var10;
         do {
            if(!var9.hasNext()) {
               return this.S();
            }

            var10 = (class_cq)var9.next();
         } while(!this.a(var1, var2, var10));

         return this.S().set(a, var10);
      }
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      class_cq var5 = (class_cq)var3.get(a);
      if(!this.a(var1, var2, var5)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

      super.a(var1, var2, var3, var4);
   }

   protected boolean a(class_aen var1, class_cj var2, class_cq var3) {
      return var1.p(var2.a(var3.d())).getBlock().x();
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
}
