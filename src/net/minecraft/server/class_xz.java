package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_ye;
import net.minecraft.server.class_yx;

public abstract class class_xz {
   public List b = Lists.newArrayList();
   public List c = Lists.newArrayList();
   public int d;
   private int f = -1;
   private int g;
   private final Set h = Sets.newHashSet();
   protected List e = Lists.newArrayList();
   private Set i = Sets.newHashSet();

   protected class_yx a(class_yx var1) {
      var1.e = this.c.size();
      this.c.add(var1);
      this.b.add((Object)null);
      return var1;
   }

   public void a(class_ye var1) {
      if(this.e.contains(var1)) {
         throw new IllegalArgumentException("Listener already listening");
      } else {
         this.e.add(var1);
         var1.a(this, this.a());
         this.b();
      }
   }

   public List a() {
      ArrayList var1 = Lists.newArrayList();

      for(int var2 = 0; var2 < this.c.size(); ++var2) {
         var1.add(((class_yx)this.c.get(var2)).d());
      }

      return var1;
   }

   public void b() {
      for(int var1 = 0; var1 < this.c.size(); ++var1) {
         class_aas var2 = ((class_yx)this.c.get(var1)).d();
         class_aas var3 = (class_aas)this.b.get(var1);
         if(!class_aas.b(var3, var2)) {
            var3 = var2 == null?null:var2.k();
            this.b.set(var1, var3);

            for(int var4 = 0; var4 < this.e.size(); ++var4) {
               ((class_ye)this.e.get(var4)).a(this, var1, var3);
            }
         }
      }

   }

   public boolean a(class_xa var1, int var2) {
      return false;
   }

   public class_yx a(class_oj var1, int var2) {
      for(int var3 = 0; var3 < this.c.size(); ++var3) {
         class_yx var4 = (class_yx)this.c.get(var3);
         if(var4.a(var1, var2)) {
            return var4;
         }
      }

      return null;
   }

   public class_yx a(int var1) {
      return (class_yx)this.c.get(var1);
   }

   public class_aas b(class_xa var1, int var2) {
      class_yx var3 = (class_yx)this.c.get(var2);
      return var3 != null?var3.d():null;
   }

   public class_aas a(int var1, int var2, int var3, class_xa var4) {
      class_aas var5 = null;
      class_wz var6 = var4.bp;
      int var9;
      class_aas var17;
      if(var3 == 5) {
         int var7 = this.g;
         this.g = c(var2);
         if((var7 != 1 || this.g != 2) && var7 != this.g) {
            this.d();
         } else if(var6.o() == null) {
            this.d();
         } else if(this.g == 0) {
            this.f = b(var2);
            if(a(this.f, var4)) {
               this.g = 1;
               this.h.clear();
            } else {
               this.d();
            }
         } else if(this.g == 1) {
            class_yx var8 = (class_yx)this.c.get(var1);
            if(var8 != null && a(var8, var6.o(), true) && var8.a(var6.o()) && var6.o().b > this.h.size() && this.b(var8)) {
               this.h.add(var8);
            }
         } else if(this.g == 2) {
            if(!this.h.isEmpty()) {
               var17 = var6.o().k();
               var9 = var6.o().b;
               Iterator var10 = this.h.iterator();

               while(var10.hasNext()) {
                  class_yx var11 = (class_yx)var10.next();
                  if(var11 != null && a(var11, var6.o(), true) && var11.a(var6.o()) && var6.o().b >= this.h.size() && this.b(var11)) {
                     class_aas var12 = var17.k();
                     int var13 = var11.e()?var11.d().b:0;
                     a(this.h, this.f, var12, var13);
                     if(var12.b > var12.c()) {
                        var12.b = var12.c();
                     }

                     if(var12.b > var11.b(var12)) {
                        var12.b = var11.b(var12);
                     }

                     var9 -= var12.b - var13;
                     var11.d(var12);
                  }
               }

               var17.b = var9;
               if(var17.b <= 0) {
                  var17 = null;
               }

               var6.b(var17);
            }

            this.d();
         } else {
            this.d();
         }
      } else if(this.g != 0) {
         this.d();
      } else {
         class_yx var16;
         int var19;
         class_aas var23;
         if((var3 == 0 || var3 == 1) && (var2 == 0 || var2 == 1)) {
            if(var1 == -999) {
               if(var6.o() != null) {
                  if(var2 == 0) {
                     var4.a(var6.o(), true);
                     var6.b((class_aas)null);
                  }

                  if(var2 == 1) {
                     var4.a(var6.o().a(1), true);
                     if(var6.o().b == 0) {
                        var6.b((class_aas)null);
                     }
                  }
               }
            } else if(var3 == 1) {
               if(var1 < 0) {
                  return null;
               }

               var16 = (class_yx)this.c.get(var1);
               if(var16 != null && var16.a(var4)) {
                  var17 = this.b(var4, var1);
                  if(var17 != null) {
                     class_aar var20 = var17.b();
                     var5 = var17.k();
                     if(var16.d() != null && var16.d().b() == var20) {
                        this.a(var1, var2, true, var4);
                     }
                  }
               }
            } else {
               if(var1 < 0) {
                  return null;
               }

               var16 = (class_yx)this.c.get(var1);
               if(var16 != null) {
                  var17 = var16.d();
                  class_aas var21 = var6.o();
                  if(var17 != null) {
                     var5 = var17.k();
                  }

                  if(var17 == null) {
                     if(var21 != null && var16.a(var21)) {
                        var19 = var2 == 0?var21.b:1;
                        if(var19 > var16.b(var21)) {
                           var19 = var16.b(var21);
                        }

                        if(var21.b >= var19) {
                           var16.d(var21.a(var19));
                        }

                        if(var21.b == 0) {
                           var6.b((class_aas)null);
                        }
                     }
                  } else if(var16.a(var4)) {
                     if(var21 == null) {
                        var19 = var2 == 0?var17.b:(var17.b + 1) / 2;
                        var23 = var16.a(var19);
                        var6.b(var23);
                        if(var17.b == 0) {
                           var16.d((class_aas)null);
                        }

                        var16.a(var4, var6.o());
                     } else if(var16.a(var21)) {
                        if(var17.b() == var21.b() && var17.i() == var21.i() && class_aas.a(var17, var21)) {
                           var19 = var2 == 0?var21.b:1;
                           if(var19 > var16.b(var21) - var17.b) {
                              var19 = var16.b(var21) - var17.b;
                           }

                           if(var19 > var21.c() - var17.b) {
                              var19 = var21.c() - var17.b;
                           }

                           var21.a(var19);
                           if(var21.b == 0) {
                              var6.b((class_aas)null);
                           }

                           var17.b += var19;
                        } else if(var21.b <= var16.b(var21)) {
                           var16.d(var21);
                           var6.b(var17);
                        }
                     } else if(var17.b() == var21.b() && var21.c() > 1 && (!var17.f() || var17.i() == var21.i()) && class_aas.a(var17, var21)) {
                        var19 = var17.b;
                        if(var19 > 0 && var19 + var21.b <= var21.c()) {
                           var21.b += var19;
                           var17 = var16.a(var19);
                           if(var17.b == 0) {
                              var16.d((class_aas)null);
                           }

                           var16.a(var4, var6.o());
                        }
                     }
                  }

                  var16.f();
               }
            }
         } else if(var3 == 2 && var2 >= 0 && var2 < 9) {
            var16 = (class_yx)this.c.get(var1);
            if(var16.a(var4)) {
               var17 = var6.a(var2);
               boolean var18 = var17 == null || var16.d == var6 && var16.a(var17);
               var19 = -1;
               if(!var18) {
                  var19 = var6.j();
                  var18 |= var19 > -1;
               }

               if(var16.e() && var18) {
                  var23 = var16.d();
                  var6.a(var2, var23.k());
                  if((var16.d != var6 || !var16.a(var17)) && var17 != null) {
                     if(var19 > -1) {
                        var6.a(var17);
                        var16.a(var23.b);
                        var16.d((class_aas)null);
                        var16.a(var4, var23);
                     }
                  } else {
                     var16.a(var23.b);
                     var16.d(var17);
                     var16.a(var4, var23);
                  }
               } else if(!var16.e() && var17 != null && var16.a(var17)) {
                  var6.a(var2, (class_aas)null);
                  var16.d(var17);
               }
            }
         } else if(var3 == 3 && var4.bH.d && var6.o() == null && var1 >= 0) {
            var16 = (class_yx)this.c.get(var1);
            if(var16 != null && var16.e()) {
               var17 = var16.d().k();
               var17.b = var17.c();
               var6.b(var17);
            }
         } else if(var3 == 4 && var6.o() == null && var1 >= 0) {
            var16 = (class_yx)this.c.get(var1);
            if(var16 != null && var16.e() && var16.a(var4)) {
               var17 = var16.a(var2 == 0?1:var16.d().b);
               var16.a(var4, var17);
               var4.a(var17, true);
            }
         } else if(var3 == 6 && var1 >= 0) {
            var16 = (class_yx)this.c.get(var1);
            var17 = var6.o();
            if(var17 != null && (var16 == null || !var16.e() || !var16.a(var4))) {
               var9 = var2 == 0?0:this.c.size() - 1;
               var19 = var2 == 0?1:-1;

               for(int var22 = 0; var22 < 2; ++var22) {
                  for(int var24 = var9; var24 >= 0 && var24 < this.c.size() && var17.b < var17.c(); var24 += var19) {
                     class_yx var25 = (class_yx)this.c.get(var24);
                     if(var25.e() && a(var25, var17, true) && var25.a(var4) && this.a(var17, var25) && (var22 != 0 || var25.d().b != var25.d().c())) {
                        int var14 = Math.min(var17.c() - var17.b, var25.d().b);
                        class_aas var15 = var25.a(var14);
                        var17.b += var14;
                        if(var15.b <= 0) {
                           var25.d((class_aas)null);
                        }

                        var25.a(var4, var15);
                     }
                  }
               }
            }

            this.b();
         }
      }

      return var5;
   }

   public boolean a(class_aas var1, class_yx var2) {
      return true;
   }

   protected void a(int var1, int var2, boolean var3, class_xa var4) {
      this.a(var1, var2, 1, var4);
   }

   public void b(class_xa var1) {
      class_wz var2 = var1.bp;
      if(var2.o() != null) {
         var1.a(var2.o(), false);
         var2.b((class_aas)null);
      }

   }

   public void a(class_oj var1) {
      this.b();
   }

   public void a(int var1, class_aas var2) {
      this.a(var1).d(var2);
   }

   public boolean c(class_xa var1) {
      return !this.i.contains(var1);
   }

   public void a(class_xa var1, boolean var2) {
      if(var2) {
         this.i.remove(var1);
      } else {
         this.i.add(var1);
      }

   }

   public abstract boolean a(class_xa var1);

   protected boolean a(class_aas var1, int var2, int var3, boolean var4) {
      boolean var5 = false;
      int var6 = var2;
      if(var4) {
         var6 = var3 - 1;
      }

      class_yx var7;
      class_aas var8;
      if(var1.d()) {
         while(var1.b > 0 && (!var4 && var6 < var3 || var4 && var6 >= var2)) {
            var7 = (class_yx)this.c.get(var6);
            var8 = var7.d();
            if(var8 != null && var8.b() == var1.b() && (!var1.f() || var1.i() == var8.i()) && class_aas.a(var1, var8)) {
               int var9 = var8.b + var1.b;
               if(var9 <= var1.c()) {
                  var1.b = 0;
                  var8.b = var9;
                  var7.f();
                  var5 = true;
               } else if(var8.b < var1.c()) {
                  var1.b -= var1.c() - var8.b;
                  var8.b = var1.c();
                  var7.f();
                  var5 = true;
               }
            }

            if(var4) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      if(var1.b > 0) {
         if(var4) {
            var6 = var3 - 1;
         } else {
            var6 = var2;
         }

         while(!var4 && var6 < var3 || var4 && var6 >= var2) {
            var7 = (class_yx)this.c.get(var6);
            var8 = var7.d();
            if(var8 == null) {
               var7.d(var1.k());
               var7.f();
               var1.b = 0;
               var5 = true;
               break;
            }

            if(var4) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      return var5;
   }

   public static int b(int var0) {
      return var0 >> 2 & 3;
   }

   public static int c(int var0) {
      return var0 & 3;
   }

   public static boolean a(int var0, class_xa var1) {
      return var0 == 0?true:(var0 == 1?true:var0 == 2 && var1.bH.d);
   }

   protected void d() {
      this.g = 0;
      this.h.clear();
   }

   public static boolean a(class_yx var0, class_aas var1, boolean var2) {
      boolean var3 = var0 == null || !var0.e();
      if(var0 != null && var0.e() && var1 != null && var1.a(var0.d()) && class_aas.a(var0.d(), var1)) {
         var3 |= var0.d().b + (var2?0:var1.b) <= var1.c();
      }

      return var3;
   }

   public static void a(Set var0, int var1, class_aas var2, int var3) {
      switch(var1) {
      case 0:
         var2.b = class_nu.d((float)var2.b / (float)var0.size());
         break;
      case 1:
         var2.b = 1;
         break;
      case 2:
         var2.b = var2.b().j();
      }

      var2.b += var3;
   }

   public boolean b(class_yx var1) {
      return true;
   }

   public static int a(class_amg var0) {
      return var0 instanceof class_oj?b((class_oj)var0):0;
   }

   public static int b(class_oj var0) {
      if(var0 == null) {
         return 0;
      } else {
         int var1 = 0;
         float var2 = 0.0F;

         for(int var3 = 0; var3 < var0.o_(); ++var3) {
            class_aas var4 = var0.a(var3);
            if(var4 != null) {
               var2 += (float)var4.b / (float)Math.min(var0.q_(), var4.c());
               ++var1;
            }
         }

         var2 /= (float)var0.o_();
         return class_nu.d(var2 * 14.0F) + (var1 > 0?1:0);
      }
   }
}
