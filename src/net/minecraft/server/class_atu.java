package net.minecraft.server;

import net.minecraft.server.class_aes;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_api;
import net.minecraft.server.class_aua;
import net.minecraft.server.class_auc;

public class class_atu extends class_auc {
   private BiomeBase[] c;
   private BiomeBase[] d;
   private BiomeBase[] e;
   private BiomeBase[] f;
   private final class_api g;

   public class_atu(long var1, class_auc var3, class_aes var4, String var5) {
      super(var1);
      this.c = new BiomeBase[]{BiomeBase.r, BiomeBase.r, BiomeBase.r, BiomeBase.Y, BiomeBase.Y, BiomeBase.q};
      this.d = new BiomeBase[]{BiomeBase.t, BiomeBase.S, BiomeBase.s, BiomeBase.q, BiomeBase.Q, BiomeBase.v};
      this.e = new BiomeBase[]{BiomeBase.t, BiomeBase.s, BiomeBase.u, BiomeBase.q};
      this.f = new BiomeBase[]{BiomeBase.B, BiomeBase.B, BiomeBase.B, BiomeBase.T};
      this.a = var3;
      if(var4 == class_aes.h) {
         this.c = new BiomeBase[]{BiomeBase.r, BiomeBase.t, BiomeBase.s, BiomeBase.v, BiomeBase.q, BiomeBase.u};
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
            } else if(var9 == BiomeBase.D.az) {
               var6[var8 + var7 * var3] = var9;
            } else if(var9 == 1) {
               if(var10 > 0) {
                  if(this.a(3) == 0) {
                     var6[var8 + var7 * var3] = BiomeBase.ac.az;
                  } else {
                     var6[var8 + var7 * var3] = BiomeBase.ab.az;
                  }
               } else {
                  var6[var8 + var7 * var3] = this.c[this.a(this.c.length)].az;
               }
            } else if(var9 == 2) {
               if(var10 > 0) {
                  var6[var8 + var7 * var3] = BiomeBase.K.az;
               } else {
                  var6[var8 + var7 * var3] = this.d[this.a(this.d.length)].az;
               }
            } else if(var9 == 3) {
               if(var10 > 0) {
                  var6[var8 + var7 * var3] = BiomeBase.V.az;
               } else {
                  var6[var8 + var7 * var3] = this.e[this.a(this.e.length)].az;
               }
            } else if(var9 == 4) {
               var6[var8 + var7 * var3] = this.f[this.a(this.f.length)].az;
            } else {
               var6[var8 + var7 * var3] = BiomeBase.D.az;
            }
         }
      }

      return var6;
   }
}
