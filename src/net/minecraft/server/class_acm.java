package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_acs;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_yg;
import net.minecraft.server.class_zz;

public class class_acm implements class_acs {
   private class_aas a;

   public boolean a(class_yg var1, class_aen var2) {
      this.a = null;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.o_(); ++var9) {
         class_aas var10 = var1.a(var9);
         if(var10 != null) {
            if(var10.b() == class_aau.J) {
               ++var4;
            } else if(var10.b() == class_aau.cf) {
               ++var6;
            } else if(var10.b() == class_aau.aY) {
               ++var5;
            } else if(var10.b() == class_aau.aM) {
               ++var3;
            } else if(var10.b() == class_aau.aV) {
               ++var7;
            } else if(var10.b() == class_aau.k) {
               ++var7;
            } else if(var10.b() == class_aau.bO) {
               ++var8;
            } else if(var10.b() == class_aau.I) {
               ++var8;
            } else if(var10.b() == class_aau.bz) {
               ++var8;
            } else {
               if(var10.b() != class_aau.ca) {
                  return false;
               }

               ++var8;
            }
         }
      }

      var7 += var5 + var8;
      if(var4 <= 3 && var3 <= 1) {
         class_dn var16;
         class_dn var19;
         if(var4 >= 1 && var3 == 1 && var7 == 0) {
            this.a = new class_aas(class_aau.ce);
            if(var6 > 0) {
               var16 = new class_dn();
               var19 = new class_dn();
               class_du var25 = new class_du();

               for(int var22 = 0; var22 < var1.o_(); ++var22) {
                  class_aas var26 = var1.a(var22);
                  if(var26 != null && var26.b() == class_aau.cf && var26.n() && var26.o().b("Explosion", 10)) {
                     var25.a((class_eb)var26.o().n("Explosion"));
                  }
               }

               var19.a((String)"Explosions", (class_eb)var25);
               var19.a("Flight", (byte)var4);
               var16.a((String)"Fireworks", (class_eb)var19);
               this.a.d(var16);
            }

            return true;
         } else if(var4 == 1 && var3 == 0 && var6 == 0 && var5 > 0 && var8 <= 1) {
            this.a = new class_aas(class_aau.cf);
            var16 = new class_dn();
            var19 = new class_dn();
            byte var23 = 0;
            ArrayList var12 = Lists.newArrayList();

            for(int var13 = 0; var13 < var1.o_(); ++var13) {
               class_aas var14 = var1.a(var13);
               if(var14 != null) {
                  if(var14.b() == class_aau.aY) {
                     var12.add(Integer.valueOf(class_zz.a[var14.i() & 15]));
                  } else if(var14.b() == class_aau.aV) {
                     var19.a("Flicker", true);
                  } else if(var14.b() == class_aau.k) {
                     var19.a("Trail", true);
                  } else if(var14.b() == class_aau.bO) {
                     var23 = 1;
                  } else if(var14.b() == class_aau.I) {
                     var23 = 4;
                  } else if(var14.b() == class_aau.bz) {
                     var23 = 2;
                  } else if(var14.b() == class_aau.ca) {
                     var23 = 3;
                  }
               }
            }

            int[] var24 = new int[var12.size()];

            for(int var27 = 0; var27 < var24.length; ++var27) {
               var24[var27] = ((Integer)var12.get(var27)).intValue();
            }

            var19.a("Colors", var24);
            var19.a("Type", var23);
            var16.a((String)"Explosion", (class_eb)var19);
            this.a.d(var16);
            return true;
         } else if(var4 == 0 && var3 == 0 && var6 == 1 && var5 > 0 && var5 == var7) {
            ArrayList var15 = Lists.newArrayList();

            for(int var17 = 0; var17 < var1.o_(); ++var17) {
               class_aas var11 = var1.a(var17);
               if(var11 != null) {
                  if(var11.b() == class_aau.aY) {
                     var15.add(Integer.valueOf(class_zz.a[var11.i() & 15]));
                  } else if(var11.b() == class_aau.cf) {
                     this.a = var11.k();
                     this.a.b = 1;
                  }
               }
            }

            int[] var18 = new int[var15.size()];

            for(int var20 = 0; var20 < var18.length; ++var20) {
               var18[var20] = ((Integer)var15.get(var20)).intValue();
            }

            if(this.a != null && this.a.n()) {
               class_dn var21 = this.a.o().n("Explosion");
               if(var21 == null) {
                  return false;
               } else {
                  var21.a("FadeColors", var18);
                  return true;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public class_aas a(class_yg var1) {
      return this.a.k();
   }

   public int a() {
      return 10;
   }

   public class_aas b() {
      return this.a;
   }

   public class_aas[] b(class_yg var1) {
      class_aas[] var2 = new class_aas[var1.o_()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class_aas var4 = var1.a(var3);
         if(var4 != null && var4.b().r()) {
            var2[var3] = new class_aas(var4.b().q());
         }
      }

      return var2;
   }
}
