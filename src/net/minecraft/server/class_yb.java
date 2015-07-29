package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_adi;
import net.minecraft.server.class_adk;
import net.minecraft.server.World;
import net.minecraft.server.class_aga;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ow;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_ye;
import net.minecraft.server.class_yv;
import net.minecraft.server.class_yx;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_yb extends class_xz {
   private static final Logger f = LogManager.getLogger();
   private class_oj g = new class_yv();
   private class_oj h = new class_ow("Repair", true, 2) {
      public void p_() {
         super.p_();
         class_yb.this.a((class_oj)this);
      }
   };
   private World i;
   private class_cj j;
   public int a;
   private int k;
   private String l;
   private final class_xa m;

   public class_yb(class_wz var1, final World var2, final class_cj var3, class_xa var4) {
      this.j = var3;
      this.i = var2;
      this.m = var4;
      this.a((class_yx)(new class_yx(this.h, 0, 27, 47)));
      this.a((class_yx)(new class_yx(this.h, 1, 76, 47)));
      this.a((class_yx)(new class_yx(this.g, 2, 134, 47) {
         public boolean a(class_aas var1) {
            return false;
         }

         public boolean a(class_xa var1) {
            return (var1.bH.d || var1.bI >= class_yb.this.a) && class_yb.this.a > 0 && this.e();
         }

         public void a(class_xa var1, class_aas var2x) {
            if(!var1.bH.d) {
               var1.a(-class_yb.this.a);
            }

            class_yb.this.h.a(0, (class_aas)null);
            if(class_yb.this.k > 0) {
               class_aas var3x = class_yb.this.h.a(1);
               if(var3x != null && var3x.b > class_yb.this.k) {
                  var3x.b -= class_yb.this.k;
                  class_yb.this.h.a(1, var3x);
               } else {
                  class_yb.this.h.a(1, (class_aas)null);
               }
            } else {
               class_yb.this.h.a(1, (class_aas)null);
            }

            class_yb.this.a = 0;
            IBlockData var5 = var2.p(var3);
            if(!var1.bH.d && !var2.D && var5.getBlock() == Blocks.ANVIL && var1.bd().nextFloat() < 0.12F) {
               int var4 = ((Integer)var5.get(class_aga.b)).intValue();
               ++var4;
               if(var4 > 2) {
                  var2.g(var3);
                  var2.b(1020, var3, 0);
               } else {
                  var2.a((class_cj)var3, (IBlockData)var5.set(class_aga.b, Integer.valueOf(var4)), 2);
                  var2.b(1021, var3, 0);
               }
            } else if(!var2.D) {
               var2.b(1021, var3, 0);
            }

         }
      }));

      int var5;
      for(var5 = 0; var5 < 3; ++var5) {
         for(int var6 = 0; var6 < 9; ++var6) {
            this.a((class_yx)(new class_yx(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, 84 + var5 * 18)));
         }
      }

      for(var5 = 0; var5 < 9; ++var5) {
         this.a((class_yx)(new class_yx(var1, var5, 8 + var5 * 18, 142)));
      }

   }

   public void a(class_oj var1) {
      super.a(var1);
      if(var1 == this.h) {
         this.e();
      }

   }

   public void e() {
      class_aas var1 = this.h.a(0);
      this.a = 1;
      int var2 = 0;
      byte var3 = 0;
      byte var4 = 0;
      if(var1 == null) {
         this.g.a(0, (class_aas)null);
         this.a = 0;
      } else {
         class_aas var5 = var1.k();
         class_aas var6 = this.h.a(1);
         Map var7 = class_adk.a(var5);
         int var17 = var3 + var1.A() + (var6 == null?0:var6.A());
         this.k = 0;
         if(var6 != null) {
            boolean var8 = var6.b() == Items.cg && !Items.cg.h(var6).c_();
            int var9;
            int var10;
            int var11;
            if(var5.e() && var5.b().a(var1, var6)) {
               var9 = Math.min(var5.h(), var5.j() / 4);
               if(var9 <= 0) {
                  this.g.a(0, (class_aas)null);
                  this.a = 0;
                  return;
               }

               for(var10 = 0; var9 > 0 && var10 < var6.b; ++var10) {
                  var11 = var5.h() - var9;
                  var5.b(var11);
                  ++var2;
                  var9 = Math.min(var5.h(), var5.j() / 4);
               }

               this.k = var10;
            } else {
               if(!var8 && (var5.b() != var6.b() || !var5.e())) {
                  this.g.a(0, (class_aas)null);
                  this.a = 0;
                  return;
               }

               int var12;
               int var13;
               if(var5.e() && !var8) {
                  var9 = var1.j() - var1.h();
                  var10 = var6.j() - var6.h();
                  var11 = var10 + var5.j() * 12 / 100;
                  var12 = var9 + var11;
                  var13 = var5.j() - var12;
                  if(var13 < 0) {
                     var13 = 0;
                  }

                  if(var13 < var5.i()) {
                     var5.b(var13);
                     var2 += 2;
                  }
               }

               Map var19 = class_adk.a(var6);
               Iterator var20 = var19.keySet().iterator();

               label144:
               while(true) {
                  class_adi var21;
                  do {
                     if(!var20.hasNext()) {
                        break label144;
                     }

                     var21 = (class_adi)var20.next();
                  } while(var21 == null);

                  var12 = var7.containsKey(var21)?((Integer)var7.get(var21)).intValue():0;
                  var13 = ((Integer)var19.get(var21)).intValue();
                  var13 = var12 == var13?var13 + 1:Math.max(var13, var12);
                  boolean var14 = var21.a(var1);
                  if(this.m.bH.d || var1.b() == Items.cg) {
                     var14 = true;
                  }

                  Iterator var15 = var7.keySet().iterator();

                  while(var15.hasNext()) {
                     class_adi var16 = (class_adi)var15.next();
                     if(var16 != var21 && !var21.a(var16)) {
                        var14 = false;
                        ++var2;
                     }
                  }

                  if(var14) {
                     if(var13 > var21.b()) {
                        var13 = var21.b();
                     }

                     var7.put(var21, Integer.valueOf(var13));
                     int var22 = 0;
                     switch(class_yb.SyntheticClass_1.a[var21.c().ordinal()]) {
                     case 1:
                        var22 = 1;
                        break;
                     case 2:
                        var22 = 2;
                        break;
                     case 3:
                        var22 = 4;
                        break;
                     case 4:
                        var22 = 8;
                     }

                     if(var8) {
                        var22 = Math.max(1, var22 / 2);
                     }

                     var2 += var22 * var13;
                  }
               }
            }
         }

         if(StringUtils.isBlank(this.l)) {
            if(var1.s()) {
               var4 = 1;
               var2 += var4;
               var5.r();
            }
         } else if(!this.l.equals(var1.q())) {
            var4 = 1;
            var2 += var4;
            var5.c(this.l);
         }

         this.a = var17 + var2;
         if(var2 <= 0) {
            var5 = null;
         }

         if(var4 == var2 && var4 > 0 && this.a >= 40) {
            this.a = 39;
         }

         if(this.a >= 40 && !this.m.bH.d) {
            var5 = null;
         }

         if(var5 != null) {
            int var18 = var5.A();
            if(var6 != null && var18 < var6.A()) {
               var18 = var6.A();
            }

            var18 = var18 * 2 + 1;
            var5.c(var18);
            class_adk.a(var7, var5);
         }

         this.g.a(0, var5);
         this.b();
      }
   }

   public void a(class_ye var1) {
      super.a(var1);
      var1.a(this, 0, this.a);
   }

   public void b(class_xa var1) {
      super.b(var1);
      if(!this.i.D) {
         for(int var2 = 0; var2 < this.h.o_(); ++var2) {
            class_aas var3 = this.h.b(var2);
            if(var3 != null) {
               var1.a(var3, false);
            }
         }

      }
   }

   public boolean a(class_xa var1) {
      return this.i.p(this.j).getBlock() != Blocks.ANVIL?false:var1.e((double)this.j.n() + 0.5D, (double)this.j.o() + 0.5D, (double)this.j.p() + 0.5D) <= 64.0D;
   }

   public class_aas b(class_xa var1, int var2) {
      class_aas var3 = null;
      class_yx var4 = (class_yx)this.c.get(var2);
      if(var4 != null && var4.e()) {
         class_aas var5 = var4.d();
         var3 = var5.k();
         if(var2 == 2) {
            if(!this.a(var5, 3, 39, true)) {
               return null;
            }

            var4.a(var5, var3);
         } else if(var2 != 0 && var2 != 1) {
            if(var2 >= 3 && var2 < 39 && !this.a(var5, 0, 2, false)) {
               return null;
            }
         } else if(!this.a(var5, 3, 39, false)) {
            return null;
         }

         if(var5.b == 0) {
            var4.d((class_aas)null);
         } else {
            var4.f();
         }

         if(var5.b == var3.b) {
            return null;
         }

         var4.a(var1, var5);
      }

      return var3;
   }

   public void a(String var1) {
      this.l = var1;
      if(this.a(2).e()) {
         class_aas var2 = this.a(2).d();
         if(StringUtils.isBlank(var1)) {
            var2.r();
         } else {
            var2.c(this.l);
         }
      }

      this.e();
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_adi.class_a_in_class_adi.values().length];

      static {
         try {
            a[class_adi.class_a_in_class_adi.a.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_adi.class_a_in_class_adi.b.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_adi.class_a_in_class_adi.c.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_adi.class_a_in_class_adi.d.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
