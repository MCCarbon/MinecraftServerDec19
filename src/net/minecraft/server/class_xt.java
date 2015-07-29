package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_abe;
import net.minecraft.server.World;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_xd;

public class class_xt extends class_xd {
   private static final int f = class_qi.a(class_xt.class);
   private final Set g;
   private class_aas h;

   public class_xt(World var1) {
      super(var1);
      this.g = Sets.newHashSet();
   }

   public class_xt(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
      this.g = Sets.newHashSet();
   }

   public class_xt(World var1, double var2, double var4, double var6, class_aas var8) {
      this(var1, var2, var4, var6);
      this.a(var8);
   }

   public class_xt(World var1, class_qa var2, class_aas var3) {
      super(var1, var2);
      this.g = Sets.newHashSet();
      this.a(var3);
   }

   private void a(class_aas var1) {
      List var2 = class_abe.h(var1);
      if(!var2.isEmpty()) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            class_pl var4 = (class_pl)var3.next();
            this.g.add(new class_pl(var4));
         }

         this.ac.b(f, Integer.valueOf(class_abe.a((Collection)this.g)));
      }

      this.h = var1.k();
   }

   protected void h() {
      super.h();
      this.ac.a(f, Integer.valueOf(0));
   }

   public void t_() {
      super.t_();
      int var1;
      double var2;
      double var4;
      double var6;
      if(this.a) {
         if(this.o.D) {
            var1 = this.ac.c(f);
            if(var1 > 0 && this.b % 5 == 0) {
               var2 = (double)(var1 >> 16 & 255) / 255.0D;
               var4 = (double)(var1 >> 8 & 255) / 255.0D;
               var6 = (double)(var1 >> 0 & 255) / 255.0D;
               this.o.a(class_cy.p, this.s + (this.V.nextDouble() - 0.5D) * (double)this.J, this.t + this.V.nextDouble() * (double)this.K, this.u + (this.V.nextDouble() - 0.5D) * (double)this.J, var2, var4, var6, new int[0]);
            }
         } else if(!this.g.isEmpty() && this.b >= 200) {
            this.o.a((class_pr)this, (byte)0);
            this.g.clear();
            this.ac.b(f, Integer.valueOf(0));
         }
      } else if(this.o.D) {
         var1 = this.ac.c(f);
         if(var1 > 0) {
            var2 = (double)(var1 >> 16 & 255) / 255.0D;
            var4 = (double)(var1 >> 8 & 255) / 255.0D;
            var6 = (double)(var1 >> 0 & 255) / 255.0D;

            for(int var8 = 0; var8 < 2; ++var8) {
               this.o.a(class_cy.p, this.s + (this.V.nextDouble() - 0.5D) * (double)this.J, this.t + this.V.nextDouble() * (double)this.K, this.u + (this.V.nextDouble() - 0.5D) * (double)this.J, var2, var4, var6, new int[0]);
            }
         }
      }

   }

   public void b(class_dn var1) {
      super.b(var1);
      if(this.h != null) {
         var1.a((String)"Item", (class_eb)this.h.b(new class_dn()));
      }

   }

   public void a(class_dn var1) {
      super.a(var1);
      if(var1.b("Item", 10)) {
         this.h = class_aas.a(var1.n("Item"));
      }

   }

   protected void b(class_qa var1) {
      super.b(var1);
      if(!this.g.isEmpty()) {
         Iterator var2 = this.g.iterator();

         while(var2.hasNext()) {
            class_pl var3 = (class_pl)var2.next();
            var1.c(var3);
         }
      }

   }

   protected class_aas j() {
      return this.g.isEmpty()?new class_aas(Items.g):this.h;
   }
}
