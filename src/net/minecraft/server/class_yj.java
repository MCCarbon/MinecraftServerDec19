package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_adi;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_adl;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ow;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_ye;
import net.minecraft.server.class_yx;
import net.minecraft.server.class_zy;

public class class_yj extends class_xz {
   public class_oj a = new class_ow("Enchant", true, 2) {
      public int q_() {
         return 64;
      }

      public void p_() {
         super.p_();
         class_yj.this.a((class_oj)this);
      }
   };
   private class_aen j;
   private class_cj k;
   private Random l = new Random();
   public int f;
   public int[] g = new int[3];
   public int[] h = new int[]{-1, -1, -1};
   public int[] i = new int[]{-1, -1, -1};

   public class_yj(class_wz var1, class_aen var2, class_cj var3) {
      this.j = var2;
      this.k = var3;
      this.f = var1.e.cl();
      this.a((class_yx)(new class_yx(this.a, 0, 15, 47) {
         public boolean a(class_aas var1) {
            return true;
         }

         public int a() {
            return 1;
         }
      }));
      this.a((class_yx)(new class_yx(this.a, 1, 35, 47) {
         public boolean a(class_aas var1) {
            return var1.b() == class_aau.aY && class_zy.a(var1.i()) == class_zy.l;
         }
      }));

      int var4;
      for(var4 = 0; var4 < 3; ++var4) {
         for(int var5 = 0; var5 < 9; ++var5) {
            this.a((class_yx)(new class_yx(var1, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.a((class_yx)(new class_yx(var1, var4, 8 + var4 * 18, 142)));
      }

   }

   protected void c(class_ye var1) {
      var1.a(this, 0, this.g[0]);
      var1.a(this, 1, this.g[1]);
      var1.a(this, 2, this.g[2]);
      var1.a(this, 3, this.f & -16);
      var1.a(this, 4, this.h[0]);
      var1.a(this, 5, this.h[1]);
      var1.a(this, 6, this.h[2]);
      var1.a(this, 7, this.i[0]);
      var1.a(this, 8, this.i[1]);
      var1.a(this, 9, this.i[2]);
   }

   public void a(class_ye var1) {
      super.a(var1);
      this.c(var1);
   }

   public void b() {
      super.b();

      for(int var1 = 0; var1 < this.e.size(); ++var1) {
         class_ye var2 = (class_ye)this.e.get(var1);
         this.c(var2);
      }

   }

   public void a(class_oj var1) {
      if(var1 == this.a) {
         class_aas var2 = var1.a(0);
         int var3;
         if(var2 != null && var2.v()) {
            if(!this.j.D) {
               var3 = 0;

               int var4;
               for(var4 = -1; var4 <= 1; ++var4) {
                  for(int var5 = -1; var5 <= 1; ++var5) {
                     if((var4 != 0 || var5 != 0) && this.j.d(this.k.a(var5, 0, var4)) && this.j.d(this.k.a(var5, 1, var4))) {
                        if(this.j.p(this.k.a(var5 * 2, 0, var4 * 2)).c() == class_agk.X) {
                           ++var3;
                        }

                        if(this.j.p(this.k.a(var5 * 2, 1, var4 * 2)).c() == class_agk.X) {
                           ++var3;
                        }

                        if(var5 != 0 && var4 != 0) {
                           if(this.j.p(this.k.a(var5 * 2, 0, var4)).c() == class_agk.X) {
                              ++var3;
                           }

                           if(this.j.p(this.k.a(var5 * 2, 1, var4)).c() == class_agk.X) {
                              ++var3;
                           }

                           if(this.j.p(this.k.a(var5, 0, var4 * 2)).c() == class_agk.X) {
                              ++var3;
                           }

                           if(this.j.p(this.k.a(var5, 1, var4 * 2)).c() == class_agk.X) {
                              ++var3;
                           }
                        }
                     }
                  }
               }

               this.l.setSeed((long)this.f);

               for(var4 = 0; var4 < 3; ++var4) {
                  this.g[var4] = class_adk.a(this.l, var4, var3, var2);
                  this.h[var4] = -1;
                  this.i[var4] = -1;
                  if(this.g[var4] < var4 + 1) {
                     this.g[var4] = 0;
                  }
               }

               for(var4 = 0; var4 < 3; ++var4) {
                  if(this.g[var4] > 0) {
                     List var7 = this.a(var2, var4, this.g[var4]);
                     if(var7 != null && !var7.isEmpty()) {
                        class_adl var6 = (class_adl)var7.get(this.l.nextInt(var7.size()));
                        this.h[var4] = class_adi.b(var6.b);
                        this.i[var4] = var6.c;
                     }
                  }
               }

               this.b();
            }
         } else {
            for(var3 = 0; var3 < 3; ++var3) {
               this.g[var3] = 0;
               this.h[var3] = -1;
               this.i[var3] = -1;
            }
         }
      }

   }

   public boolean a(class_xa var1, int var2) {
      class_aas var3 = this.a.a(0);
      class_aas var4 = this.a.a(1);
      int var5 = var2 + 1;
      if((var4 == null || var4.b < var5) && !var1.bH.d) {
         return false;
      } else if(this.g[var2] <= 0 || var3 == null || (var1.bI < var5 || var1.bI < this.g[var2]) && !var1.bH.d) {
         return false;
      } else {
         if(!this.j.D) {
            List var6 = this.a(var3, var2, this.g[var2]);
            boolean var7 = var3.b() == class_aau.aN;
            if(var6 != null) {
               var1.b(var5);
               if(var7) {
                  var3.a((class_aar)class_aau.cg);
               }

               for(int var8 = 0; var8 < var6.size(); ++var8) {
                  class_adl var9 = (class_adl)var6.get(var8);
                  if(var7) {
                     class_aau.cg.a(var3, var9);
                  } else {
                     var3.a(var9.b, var9.c);
                  }
               }

               if(!var1.bH.d) {
                  var4.b -= var5;
                  if(var4.b <= 0) {
                     this.a.a(1, (class_aas)null);
                  }
               }

               var1.b(class_nc.W);
               this.a.p_();
               this.f = var1.cl();
               this.a(this.a);
            }
         }

         return true;
      }
   }

   private List a(class_aas var1, int var2, int var3) {
      this.l.setSeed((long)(this.f + var2));
      List var4 = class_adk.b(this.l, var1, var3);
      if(var1.b() == class_aau.aN && var4 != null && var4.size() > 1) {
         var4.remove(this.l.nextInt(var4.size()));
      }

      return var4;
   }

   public void b(class_xa var1) {
      super.b(var1);
      if(!this.j.D) {
         for(int var2 = 0; var2 < this.a.o_(); ++var2) {
            class_aas var3 = this.a.b(var2);
            if(var3 != null) {
               var1.a(var3, false);
            }
         }

      }
   }

   public boolean a(class_xa var1) {
      return this.j.p(this.k).c() != class_agk.bC?false:var1.e((double)this.k.n() + 0.5D, (double)this.k.o() + 0.5D, (double)this.k.p() + 0.5D) <= 64.0D;
   }

   public class_aas b(class_xa var1, int var2) {
      class_aas var3 = null;
      class_yx var4 = (class_yx)this.c.get(var2);
      if(var4 != null && var4.e()) {
         class_aas var5 = var4.d();
         var3 = var5.k();
         if(var2 == 0) {
            if(!this.a(var5, 2, 38, true)) {
               return null;
            }
         } else if(var2 == 1) {
            if(!this.a(var5, 2, 38, true)) {
               return null;
            }
         } else if(var5.b() == class_aau.aY && class_zy.a(var5.i()) == class_zy.l) {
            if(!this.a(var5, 1, 2, true)) {
               return null;
            }
         } else {
            if(((class_yx)this.c.get(0)).e() || !((class_yx)this.c.get(0)).a(var5)) {
               return null;
            }

            if(var5.n() && var5.b == 1) {
               ((class_yx)this.c.get(0)).d(var5.k());
               var5.b = 0;
            } else if(var5.b >= 1) {
               ((class_yx)this.c.get(0)).d(new class_aas(var5.b(), 1, var5.i()));
               --var5.b;
            }
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
}
