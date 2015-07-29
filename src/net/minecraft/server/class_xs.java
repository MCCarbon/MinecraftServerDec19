package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_abe;
import net.minecraft.server.class_acd;
import net.minecraft.server.class_acf;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ajd;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_pk;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xo;

public class class_xs extends class_xo {
   private class_aas d;

   public class_xs(World var1) {
      super(var1);
      this.d = class_abe.a(new class_aas(Items.bB), class_acf.a);
   }

   public class_xs(World var1, class_qa var2, class_aas var3) {
      super(var1, var2);
      this.d = class_abe.a(new class_aas(Items.bB), class_acf.a);
      this.d = var3;
   }

   public class_xs(World var1, double var2, double var4, double var6, class_aas var8) {
      super(var1, var2, var4, var6);
      this.d = class_abe.a(new class_aas(Items.bB), class_acf.a);
      this.d = var8;
   }

   protected float j() {
      return 0.05F;
   }

   protected void a(class_awg var1) {
      if(!this.o.D) {
         class_acd var2 = class_abe.i(this.d);
         if(var1.a == class_awg.class_a_in_class_awg.b && var2 == class_acf.a) {
            class_cj var16 = var1.a().a(var1.b);
            this.a(var16);
            Iterator var17 = class_cq.class_c_in_class_cq.a.iterator();

            while(var17.hasNext()) {
               class_cq var18 = (class_cq)var17.next();
               this.a(var16.a(var18));
            }

            this.o.b(2002, new class_cj(this), class_acd.a(var2));
            this.J();
         } else {
            List var3 = var2.b();
            if(!var3.isEmpty()) {
               class_awf var4 = this.aT().b(4.0D, 2.0D, 4.0D);
               List var5 = this.o.a(class_qa.class, var4);
               if(!var5.isEmpty()) {
                  Iterator var6 = var5.iterator();

                  label54:
                  while(true) {
                     class_qa var7;
                     double var8;
                     do {
                        if(!var6.hasNext()) {
                           break label54;
                        }

                        var7 = (class_qa)var6.next();
                        var8 = this.h(var7);
                     } while(var8 >= 16.0D);

                     double var10 = 1.0D - Math.sqrt(var8) / 4.0D;
                     if(var7 == var1.d) {
                        var10 = 1.0D;
                     }

                     Iterator var12 = var3.iterator();

                     while(var12.hasNext()) {
                        class_pl var13 = (class_pl)var12.next();
                        class_pk var14 = var13.a();
                        if(var14.b()) {
                           var14.a(this, this.l(), var7, var13.c(), var10);
                        } else {
                           int var15 = (int)(var10 * (double)var13.b() + 0.5D);
                           if(var15 > 20) {
                              var7.c(new class_pl(var14, var15, var13.c()));
                           }
                        }
                     }
                  }
               }
            }

            this.o.b(2002, new class_cj(this), class_acd.a(var2));
            this.J();
         }
      }
   }

   private void a(class_cj var1) {
      if(this.o.p(var1).getBlock() == Blocks.FIRE) {
         this.o.a((class_cj)var1, (IBlockData)Blocks.FLOWING_WATER.getBlockData().set(class_ajd.b, Integer.valueOf(7)), 2);
      }

   }

   public void a(class_dn var1) {
      super.a(var1);
      this.d = class_aas.a(var1.n("Potion"));
      if(this.d == null) {
         this.J();
      }

   }

   public void b(class_dn var1) {
      super.b(var1);
      if(this.d != null) {
         var1.a((String)"Potion", (class_eb)this.d.b(new class_dn()));
      }

   }

   public class_aas m() {
      return this.d;
   }
}
