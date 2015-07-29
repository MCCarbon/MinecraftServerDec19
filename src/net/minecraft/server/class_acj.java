package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_acs;
import net.minecraft.server.class_act;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ame;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_yg;
import net.minecraft.server.class_zy;

public class class_acj {
   void a(class_act var1) {
      class_zy[] var2 = class_zy.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_zy var5 = var2[var4];
         var1.a(new class_aas(class_aau.cH, 1, var5.b()), new Object[]{"###", "###", " | ", Character.valueOf('#'), new class_aas(class_agk.L, 1, var5.a()), Character.valueOf('|'), class_aau.A});
      }

      var1.a(new class_acj.class_b_in_class_acj());
      var1.a(new class_acj.class_a_in_class_acj());
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
   }

   static class class_a_in_class_acj implements class_acs {
      private class_a_in_class_acj() {
      }

      public boolean a(class_yg var1, class_aen var2) {
         boolean var3 = false;

         for(int var4 = 0; var4 < var1.o_(); ++var4) {
            class_aas var5 = var1.a(var4);
            if(var5 != null && var5.b() == class_aau.cH) {
               if(var3) {
                  return false;
               }

               if(class_ame.c(var5) >= 6) {
                  return false;
               }

               var3 = true;
            }
         }

         if(!var3) {
            return false;
         } else {
            return this.c(var1) != null;
         }
      }

      public class_aas a(class_yg var1) {
         class_aas var2 = null;

         for(int var3 = 0; var3 < var1.o_(); ++var3) {
            class_aas var4 = var1.a(var3);
            if(var4 != null && var4.b() == class_aau.cH) {
               var2 = var4.k();
               var2.b = 1;
               break;
            }
         }

         class_ame.class_a_in_class_ame var8 = this.c(var1);
         if(var8 != null) {
            int var9 = 0;

            class_aas var6;
            for(int var5 = 0; var5 < var1.o_(); ++var5) {
               var6 = var1.a(var5);
               if(var6 != null && var6.b() == class_aau.aY) {
                  var9 = var6.i();
                  break;
               }
            }

            class_dn var10 = var2.a("BlockEntityTag", true);
            var6 = null;
            class_du var11;
            if(var10.b("Patterns", 9)) {
               var11 = var10.c("Patterns", 10);
            } else {
               var11 = new class_du();
               var10.a((String)"Patterns", (class_eb)var11);
            }

            class_dn var7 = new class_dn();
            var7.a("Pattern", var8.b());
            var7.a("Color", var9);
            var11.a((class_eb)var7);
         }

         return var2;
      }

      public int a() {
         return 10;
      }

      public class_aas b() {
         return null;
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

      private class_ame.class_a_in_class_ame c(class_yg var1) {
         class_ame.class_a_in_class_ame[] var2 = class_ame.class_a_in_class_ame.values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            class_ame.class_a_in_class_ame var5 = var2[var4];
            if(var5.d()) {
               boolean var6 = true;
               int var9;
               if(var5.e()) {
                  boolean var7 = false;
                  boolean var8 = false;

                  for(var9 = 0; var9 < var1.o_() && var6; ++var9) {
                     class_aas var10 = var1.a(var9);
                     if(var10 != null && var10.b() != class_aau.cH) {
                        if(var10.b() == class_aau.aY) {
                           if(var8) {
                              var6 = false;
                              break;
                           }

                           var8 = true;
                        } else {
                           if(var7 || !var10.a(var5.f())) {
                              var6 = false;
                              break;
                           }

                           var7 = true;
                        }
                     }
                  }

                  if(!var7) {
                     var6 = false;
                  }
               } else if(var1.o_() == var5.c().length * var5.c()[0].length()) {
                  int var12 = -1;

                  for(int var13 = 0; var13 < var1.o_() && var6; ++var13) {
                     var9 = var13 / 3;
                     int var14 = var13 % 3;
                     class_aas var11 = var1.a(var13);
                     if(var11 != null && var11.b() != class_aau.cH) {
                        if(var11.b() != class_aau.aY) {
                           var6 = false;
                           break;
                        }

                        if(var12 != -1 && var12 != var11.i()) {
                           var6 = false;
                           break;
                        }

                        if(var5.c()[var9].charAt(var14) == 32) {
                           var6 = false;
                           break;
                        }

                        var12 = var11.i();
                     } else if(var5.c()[var9].charAt(var14) != 32) {
                        var6 = false;
                        break;
                     }
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  return var5;
               }
            }
         }

         return null;
      }

      // $FF: synthetic method
      class_a_in_class_acj(class_acj.SyntheticClass_1 var1) {
         this();
      }
   }

   static class class_b_in_class_acj implements class_acs {
      private class_b_in_class_acj() {
      }

      public boolean a(class_yg var1, class_aen var2) {
         class_aas var3 = null;
         class_aas var4 = null;

         for(int var5 = 0; var5 < var1.o_(); ++var5) {
            class_aas var6 = var1.a(var5);
            if(var6 != null) {
               if(var6.b() != class_aau.cH) {
                  return false;
               }

               if(var3 != null && var4 != null) {
                  return false;
               }

               int var7 = class_ame.b(var6);
               boolean var8 = class_ame.c(var6) > 0;
               if(var3 != null) {
                  if(var8) {
                     return false;
                  }

                  if(var7 != class_ame.b(var3)) {
                     return false;
                  }

                  var4 = var6;
               } else if(var4 != null) {
                  if(!var8) {
                     return false;
                  }

                  if(var7 != class_ame.b(var4)) {
                     return false;
                  }

                  var3 = var6;
               } else if(var8) {
                  var3 = var6;
               } else {
                  var4 = var6;
               }
            }
         }

         return var3 != null && var4 != null;
      }

      public class_aas a(class_yg var1) {
         for(int var2 = 0; var2 < var1.o_(); ++var2) {
            class_aas var3 = var1.a(var2);
            if(var3 != null && class_ame.c(var3) > 0) {
               class_aas var4 = var3.k();
               var4.b = 1;
               return var4;
            }
         }

         return null;
      }

      public int a() {
         return 2;
      }

      public class_aas b() {
         return null;
      }

      public class_aas[] b(class_yg var1) {
         class_aas[] var2 = new class_aas[var1.o_()];

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class_aas var4 = var1.a(var3);
            if(var4 != null) {
               if(var4.b().r()) {
                  var2[var3] = new class_aas(var4.b().q());
               } else if(var4.n() && class_ame.c(var4) > 0) {
                  var2[var3] = var4.k();
                  var2[var3].b = 1;
               }
            }
         }

         return var2;
      }

      // $FF: synthetic method
      class_b_in_class_acj(class_acj.SyntheticClass_1 var1) {
         this();
      }
   }
}
