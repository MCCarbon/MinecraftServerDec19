package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_ahm;
import net.minecraft.server.class_aic;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_tz;

public class class_afp extends class_aez {
   protected boolean aD;

   protected class_afp(int var1) {
      super(var1);
      this.a(0.8F, 0.4F);
      this.a(e);
      this.au.add(new class_aez.class_c_in_class_aez(class_tz.class, 5, 2, 6));
      this.as.A = -999;
      this.as.B = 4;
      this.as.C = 10;
   }

   public class_aic.class_a_in_class_aic a(Random var1, BlockPosition var2) {
      double var3 = af.a((double)var2.getX() / 200.0D, (double)var2.getZ() / 200.0D);
      int var5;
      if(var3 < -0.8D) {
         var5 = var1.nextInt(4);
         switch(var5) {
         case 0:
            return class_aic.class_a_in_class_aic.g;
         case 1:
            return class_aic.class_a_in_class_aic.f;
         case 2:
            return class_aic.class_a_in_class_aic.i;
         case 3:
         default:
            return class_aic.class_a_in_class_aic.h;
         }
      } else if(var1.nextInt(3) > 0) {
         var5 = var1.nextInt(3);
         return var5 == 0?class_aic.class_a_in_class_aic.b:(var5 == 1?class_aic.class_a_in_class_aic.e:class_aic.class_a_in_class_aic.j);
      } else {
         return class_aic.class_a_in_class_aic.a;
      }
   }

   public void a(World var1, Random var2, BlockPosition var3) {
      double var4 = af.a((double)(var3.getX() + 8) / 200.0D, (double)(var3.getZ() + 8) / 200.0D);
      int var6;
      int var7;
      int var8;
      int var9;
      if(var4 < -0.8D) {
         this.as.B = 15;
         this.as.C = 5;
      } else {
         this.as.B = 4;
         this.as.C = 10;
         ag.a(class_ahm.class_b_in_class_ahm.c);

         for(var6 = 0; var6 < 7; ++var6) {
            var7 = var2.nextInt(16) + 8;
            var8 = var2.nextInt(16) + 8;
            var9 = var2.nextInt(var1.m(var3.add(var7, 0, var8)).getY() + 32);
            ag.b(var1, var2, var3.add(var7, var9, var8));
         }
      }

      if(this.aD) {
         ag.a(class_ahm.class_b_in_class_ahm.a);

         for(var6 = 0; var6 < 10; ++var6) {
            var7 = var2.nextInt(16) + 8;
            var8 = var2.nextInt(16) + 8;
            var9 = var2.nextInt(var1.m(var3.add(var7, 0, var8)).getY() + 32);
            ag.b(var1, var2, var3.add(var7, var9, var8));
         }
      }

      super.a(var1, var2, var3);
   }

   protected class_aez d(int var1) {
      class_afp var2 = new class_afp(var1);
      var2.a("Sunflower Plains");
      var2.aD = true;
      var2.b(9286496);
      var2.aj = 14273354;
      return var2;
   }
}
