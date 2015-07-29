package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_afn;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_ahm;
import net.minecraft.server.class_aph;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_arh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_tz;

public class class_afs extends class_aez {
   private static final class_arh aD = new class_arh(false);

   protected class_afs(int var1) {
      super(var1);
      this.au.add(new class_aez.class_c_in_class_aez(class_tz.class, 1, 2, 6));
      this.as.A = 1;
      this.as.B = 4;
      this.as.C = 20;
   }

   public class_apw a(Random var1) {
      return (class_apw)(var1.nextInt(5) > 0?aD:this.aA);
   }

   protected class_aez d(int var1) {
      class_afs.class_a_in_class_afs var2 = new class_afs.class_a_in_class_afs(var1, this);
      var2.ap = (this.ap + 1.0F) * 0.5F;
      var2.an = this.an * 0.5F + 0.3F;
      var2.ao = this.ao * 0.5F + 1.2F;
      return var2;
   }

   public void a(class_aen var1, Random var2, class_cj var3) {
      ag.a(class_ahm.class_b_in_class_ahm.c);

      for(int var4 = 0; var4 < 7; ++var4) {
         int var5 = var2.nextInt(16) + 8;
         int var6 = var2.nextInt(16) + 8;
         int var7 = var2.nextInt(var1.m(var3.a(var5, 0, var6)).o() + 32);
         ag.b(var1, var2, var3.a(var5, var7, var6));
      }

      super.a(var1, var2, var3);
   }

   public static class class_a_in_class_afs extends class_afn {
      public class_a_in_class_afs(int var1, class_aez var2) {
         super(var1, var2);
         this.as.A = 2;
         this.as.B = 2;
         this.as.C = 5;
      }

      public void a(class_aen var1, Random var2, class_aph var3, int var4, int var5, double var6) {
         this.ak = class_agk.c.S();
         this.al = class_agk.d.S();
         if(var6 > 1.75D) {
            this.ak = class_agk.b.S();
            this.al = class_agk.b.S();
         } else if(var6 > -0.5D) {
            this.ak = class_agk.d.S().a(class_ahj.a, class_ahj.class_a_in_class_ahj.b);
         }

         this.b(var1, var2, var3, var4, var5, var6);
      }

      public void a(class_aen var1, Random var2, class_cj var3) {
         this.as.a(var1, var2, this, var3);
      }
   }
}
