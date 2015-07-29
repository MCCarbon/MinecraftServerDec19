package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahi;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_zu;

public class class_ahu extends class_ahi {
   protected class_ahu() {
      super(class_atk.q);
      this.j(this.M.b().a(b, class_cq.b));
      this.a(class_zu.c);
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      return var1.c() != this?var1:var1.a(b, var2.a((class_cq)var1.b(b)));
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      return var1.c() != this?var1:var1.a(b, var2.b((class_cq)var1.b(b)));
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      class_cq var4 = (class_cq)var3.b(b);
      float var5 = 0.4375F;
      float var6 = 0.5625F;
      return var4 != class_cq.f && var4 != class_cq.e?(var4 != class_cq.d && var4 != class_cq.c?new class_awf((double)((float)var2.n() + var5), (double)(var2.o() + 0), (double)((float)var2.p() + var5), (double)((float)var2.n() + var6), (double)(var2.o() + 1), (double)((float)var2.p() + var6)):new class_awf((double)((float)var2.n() + var5), (double)((float)var2.o() + var5), (double)(var2.p() + 0), (double)((float)var2.n() + var6), (double)((float)var2.o() + var6), (double)(var2.p() + 1))):new class_awf((double)(var2.n() + 0), (double)((float)var2.o() + var5), (double)((float)var2.p() + var5), (double)(var2.n() + 1), (double)((float)var2.o() + var6), (double)((float)var2.p() + var6));
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean d(class_aen var1, class_cj var2) {
      Iterator var3 = b.c().iterator();

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
      return true;
   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      class_anl var9 = var1.p(var2.a(var3.d()));
      if(var9.c() == class_agk.cQ) {
         class_cq var10 = (class_cq)var9.b(b);
         System.out.println("hslsdjfksdlk");
         if(var10 == var3) {
            return this.S().a(b, var3.d());
         }
      }

      return this.S().a(b, var3);
   }

   public void c(class_aen var1, class_cj var2, class_anl var3) {
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
   }

   public class_awg a(class_aen var1, class_cj var2, class_awh var3, class_awh var4) {
      class_cq var5 = (class_cq)var1.p(var2).b(b);
      float var6 = 0.375F;
      float var7 = 0.625F;
      if(var5 != class_cq.f && var5 != class_cq.e) {
         if(var5 != class_cq.d && var5 != class_cq.c) {
            this.a(var6, 0.0F, var6, var7, 1.0F, var7);
         } else {
            this.a(var6, var6, 0.0F, var7, var7, 1.0F);
         }
      } else {
         this.a(0.0F, var6, var6, 1.0F, var7, var7);
      }

      return super.a(var1, var2, var3, var4);
   }

   public class_anl a(int var1) {
      class_anl var2 = this.S();
      var2 = var2.a(b, class_cq.a(var1));
      return var2;
   }

   public int c(class_anl var1) {
      return ((class_cq)var1.b(b)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{b});
   }

   public int k() {
      return 0;
   }
}
