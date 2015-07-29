package net.minecraft.server;

import net.minecraft.server.class_aes;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_api;
import net.minecraft.server.class_aua;
import net.minecraft.server.class_auc;

public class class_atu extends class_auc {
   private class_aez[] c;
   private class_aez[] d;
   private class_aez[] e;
   private class_aez[] f;
   private final class_api g;

   public class_atu(long var1, class_auc var3, class_aes var4, String var5) {
      super(var1);
      this.c = new class_aez[]{class_aez.r, class_aez.r, class_aez.r, class_aez.Y, class_aez.Y, class_aez.q};
      this.d = new class_aez[]{class_aez.t, class_aez.S, class_aez.s, class_aez.q, class_aez.Q, class_aez.v};
      this.e = new class_aez[]{class_aez.t, class_aez.s, class_aez.u, class_aez.q};
      this.f = new class_aez[]{class_aez.B, class_aez.B, class_aez.B, class_aez.T};
      this.a = var3;
      if(var4 == class_aes.h) {
         this.c = new class_aez[]{class_aez.r, class_aez.t, class_aez.s, class_aez.v, class_aez.q, class_aez.u};
         this.g = null;
      } else if(var4 == class_aes.f) {
         this.g = class_api.class_a_in_class_api.a(var5).b();
      } else {
         this.g = null;
      }

   }

   public int[] a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.a.a(var1, var2, var3, var4);
      int[] var6 = class_aua.a(var3 * var4);

      for(int var7 = 0; var7 < var4; ++var7) {
         for(int var8 = 0; var8 < var3; ++var8) {
            this.a((long)(var8 + var1), (long)(var7 + var2));
            int var9 = var5[var8 + var7 * var3];
            int var10 = (var9 & 3840) >> 8;
            var9 &= -3841;
            if(this.g != null && this.g.F >= 0) {
               var6[var8 + var7 * var3] = this.g.F;
            } else if(b(var9)) {
               var6[var8 + var7 * var3] = var9;
            } else if(var9 == class_aez.D.az) {
               var6[var8 + var7 * var3] = var9;
            } else if(var9 == 1) {
               if(var10 > 0) {
                  if(this.a(3) == 0) {
                     var6[var8 + var7 * var3] = class_aez.ac.az;
                  } else {
                     var6[var8 + var7 * var3] = class_aez.ab.az;
                  }
               } else {
                  var6[var8 + var7 * var3] = this.c[this.a(this.c.length)].az;
               }
            } else if(var9 == 2) {
               if(var10 > 0) {
                  var6[var8 + var7 * var3] = class_aez.K.az;
               } else {
                  var6[var8 + var7 * var3] = this.d[this.a(this.d.length)].az;
               }
            } else if(var9 == 3) {
               if(var10 > 0) {
                  var6[var8 + var7 * var3] = class_aez.V.az;
               } else {
                  var6[var8 + var7 * var3] = this.e[this.a(this.e.length)].az;
               }
            } else if(var9 == 4) {
               var6[var8 + var7 * var3] = this.f[this.a(this.f.length)].az;
            } else {
               var6[var8 + var7 * var3] = class_aez.D.az;
            }
         }
      }

      return var6;
   }
}
