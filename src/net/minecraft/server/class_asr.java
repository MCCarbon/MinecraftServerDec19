package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_afd;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahd;
import net.minecraft.server.class_aiz;
import net.minecraft.server.class_akr;
import net.minecraft.server.class_ald;
import net.minecraft.server.class_alp;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_asl;
import net.minecraft.server.class_asn;
import net.minecraft.server.class_asq;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_df;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_od;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_wv;
import net.minecraft.server.class_zy;

public class class_asr {
   public static void a() {
      class_asl.a(class_asr.class_a_in_class_asr.class, "ViBH");
      class_asl.a(class_asr.class_b_in_class_asr.class, "ViDF");
      class_asl.a(class_asr.class_c_in_class_asr.class, "ViF");
      class_asl.a(class_asr.class_d_in_class_asr.class, "ViL");
      class_asl.a(class_asr.class_f_in_class_asr.class, "ViPH");
      class_asl.a(class_asr.class_g_in_class_asr.class, "ViSH");
      class_asl.a(class_asr.class_h_in_class_asr.class, "ViSmH");
      class_asl.a(class_asr.class_i_in_class_asr.class, "ViST");
      class_asl.a(class_asr.class_j_in_class_asr.class, "ViS");
      class_asl.a(class_asr.class_k_in_class_asr.class, "ViStart");
      class_asl.a(class_asr.class_l_in_class_asr.class, "ViSR");
      class_asl.a(class_asr.class_m_in_class_asr.class, "ViTRH");
      class_asl.a(class_asr.class_p_in_class_asr.class, "ViW");
   }

   public static List a(Random var0, int var1) {
      ArrayList var2 = Lists.newArrayList();
      var2.add(new class_asr.class_e_in_class_asr(class_asr.class_g_in_class_asr.class, 4, class_nu.a(var0, 2 + var1, 4 + var1 * 2)));
      var2.add(new class_asr.class_e_in_class_asr(class_asr.class_i_in_class_asr.class, 20, class_nu.a(var0, 0 + var1, 1 + var1)));
      var2.add(new class_asr.class_e_in_class_asr(class_asr.class_a_in_class_asr.class, 20, class_nu.a(var0, 0 + var1, 2 + var1)));
      var2.add(new class_asr.class_e_in_class_asr(class_asr.class_h_in_class_asr.class, 3, class_nu.a(var0, 2 + var1, 5 + var1 * 3)));
      var2.add(new class_asr.class_e_in_class_asr(class_asr.class_f_in_class_asr.class, 15, class_nu.a(var0, 0 + var1, 2 + var1)));
      var2.add(new class_asr.class_e_in_class_asr(class_asr.class_b_in_class_asr.class, 3, class_nu.a(var0, 1 + var1, 4 + var1)));
      var2.add(new class_asr.class_e_in_class_asr(class_asr.class_c_in_class_asr.class, 3, class_nu.a(var0, 2 + var1, 4 + var1 * 2)));
      var2.add(new class_asr.class_e_in_class_asr(class_asr.class_j_in_class_asr.class, 15, class_nu.a((Random)var0, 0, 1 + var1)));
      var2.add(new class_asr.class_e_in_class_asr(class_asr.class_m_in_class_asr.class, 8, class_nu.a(var0, 0 + var1, 3 + var1 * 2)));
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         if(((class_asr.class_e_in_class_asr)var3.next()).d == 0) {
            var3.remove();
         }
      }

      return var2;
   }

   private static int a(List var0) {
      boolean var1 = false;
      int var2 = 0;

      class_asr.class_e_in_class_asr var4;
      for(Iterator var3 = var0.iterator(); var3.hasNext(); var2 += var4.b) {
         var4 = (class_asr.class_e_in_class_asr)var3.next();
         if(var4.d > 0 && var4.c < var4.d) {
            var1 = true;
         }
      }

      return var1?var2:-1;
   }

   private static class_asr.class_n_in_class_asr a(class_asr.class_k_in_class_asr var0, class_asr.class_e_in_class_asr var1, List var2, Random var3, int var4, int var5, int var6, class_cq var7, int var8) {
      Class var9 = var1.a;
      Object var10 = null;
      if(var9 == class_asr.class_g_in_class_asr.class) {
         var10 = class_asr.class_g_in_class_asr.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == class_asr.class_i_in_class_asr.class) {
         var10 = class_asr.class_i_in_class_asr.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == class_asr.class_a_in_class_asr.class) {
         var10 = class_asr.class_a_in_class_asr.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == class_asr.class_h_in_class_asr.class) {
         var10 = class_asr.class_h_in_class_asr.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == class_asr.class_f_in_class_asr.class) {
         var10 = class_asr.class_f_in_class_asr.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == class_asr.class_b_in_class_asr.class) {
         var10 = class_asr.class_b_in_class_asr.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == class_asr.class_c_in_class_asr.class) {
         var10 = class_asr.class_c_in_class_asr.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == class_asr.class_j_in_class_asr.class) {
         var10 = class_asr.class_j_in_class_asr.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == class_asr.class_m_in_class_asr.class) {
         var10 = class_asr.class_m_in_class_asr.a(var0, var2, var3, var4, var5, var6, var7, var8);
      }

      return (class_asr.class_n_in_class_asr)var10;
   }

   private static class_asr.class_n_in_class_asr c(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
      int var8 = a(var0.e);
      if(var8 <= 0) {
         return null;
      } else {
         int var9 = 0;

         while(var9 < 5) {
            ++var9;
            int var10 = var2.nextInt(var8);
            Iterator var11 = var0.e.iterator();

            while(var11.hasNext()) {
               class_asr.class_e_in_class_asr var12 = (class_asr.class_e_in_class_asr)var11.next();
               var10 -= var12.b;
               if(var10 < 0) {
                  if(!var12.a(var7) || var12 == var0.d && var0.e.size() > 1) {
                     break;
                  }

                  class_asr.class_n_in_class_asr var13 = a(var0, var12, var1, var2, var3, var4, var5, var6, var7);
                  if(var13 != null) {
                     ++var12.c;
                     var0.d = var12;
                     if(!var12.a()) {
                        var0.e.remove(var12);
                     }

                     return var13;
                  }
               }
            }
         }

         class_arw var14 = class_asr.class_d_in_class_asr.a(var0, var1, var2, var3, var4, var5, var6);
         if(var14 != null) {
            return new class_asr.class_d_in_class_asr(var0, var7, var2, var14, var6);
         } else {
            return null;
         }
      }
   }

   private static class_asn d(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
      if(var7 > 50) {
         return null;
      } else if(Math.abs(var3 - var0.c().a) <= 112 && Math.abs(var5 - var0.c().c) <= 112) {
         class_asr.class_n_in_class_asr var8 = c(var0, var1, var2, var3, var4, var5, var6, var7 + 1);
         if(var8 != null) {
            int var9 = (var8.l.a + var8.l.d) / 2;
            int var10 = (var8.l.c + var8.l.f) / 2;
            int var11 = var8.l.d - var8.l.a;
            int var12 = var8.l.f - var8.l.c;
            int var13 = var11 > var12?var11:var12;
            if(var0.h().a(var9, var10, var13 / 2 + 4, class_asq.d)) {
               var1.add(var8);
               var0.f.add(var8);
               return var8;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private static class_asn e(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
      if(var7 > 3 + var0.c) {
         return null;
      } else if(Math.abs(var3 - var0.c().a) <= 112 && Math.abs(var5 - var0.c().c) <= 112) {
         class_arw var8 = class_asr.class_l_in_class_asr.a(var0, var1, var2, var3, var4, var5, var6);
         if(var8 != null && var8.b > 10) {
            class_asr.class_l_in_class_asr var9 = new class_asr.class_l_in_class_asr(var0, var7, var2, var8, var6);
            int var10 = (var9.l.a + var9.l.d) / 2;
            int var11 = (var9.l.c + var9.l.f) / 2;
            int var12 = var9.l.d - var9.l.a;
            int var13 = var9.l.f - var9.l.c;
            int var14 = var12 > var13?var12:var13;
            if(var0.h().a(var10, var11, var14 / 2 + 4, class_asq.d)) {
               var1.add(var9);
               var0.g.add(var9);
               return var9;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_cq.values().length];

      static {
         try {
            a[class_cq.c.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_cq.d.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_cq.e.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.f.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static class class_d_in_class_asr extends class_asr.class_n_in_class_asr {
      public class_d_in_class_asr() {
      }

      public class_d_in_class_asr(class_asr.class_k_in_class_asr var1, int var2, Random var3, class_arw var4, class_cq var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
      }

      public static class_arw a(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6) {
         class_arw var7 = class_arw.a(var3, var4, var5, 0, 0, 0, 3, 4, 2, var6);
         return class_asn.a(var1, var7) != null?null:var7;
      }

      public boolean a(class_aen var1, Random var2, class_arw var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 4 - 1, 0);
         }

         this.a(var1, var3, 0, 0, 0, 2, 3, 1, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, class_agk.aO.S(), 1, 0, 0, var3);
         this.a(var1, class_agk.aO.S(), 1, 1, 0, var3);
         this.a(var1, class_agk.aO.S(), 1, 2, 0, var3);
         this.a(var1, class_agk.L.a(class_zy.a.b()), 1, 3, 0, var3);
         this.a(var1, class_agk.aa.S().a(class_alp.a, class_cq.f), 2, 3, 0, var3);
         this.a(var1, class_agk.aa.S().a(class_alp.a, class_cq.c), 1, 3, 1, var3);
         this.a(var1, class_agk.aa.S().a(class_alp.a, class_cq.e), 0, 3, 0, var3);
         this.a(var1, class_agk.aa.S().a(class_alp.a, class_cq.d), 1, 3, -1, var3);
         return true;
      }
   }

   public static class class_b_in_class_asr extends class_asr.class_n_in_class_asr {
      private class_agj a;
      private class_agj b;
      private class_agj c;
      private class_agj d;

      public class_b_in_class_asr() {
      }

      public class_b_in_class_asr(class_asr.class_k_in_class_asr var1, int var2, Random var3, class_arw var4, class_cq var5) {
         super(var1, var2);
         this.a((class_cq)var5);
         this.l = var4;
         this.a = this.a(var3);
         this.b = this.a(var3);
         this.c = this.a(var3);
         this.d = this.a(var3);
      }

      protected void a(class_dn var1) {
         super.a(var1);
         var1.a("CA", class_agj.c.a((Object)this.a));
         var1.a("CB", class_agj.c.a((Object)this.b));
         var1.a("CC", class_agj.c.a((Object)this.c));
         var1.a("CD", class_agj.c.a((Object)this.d));
      }

      protected void b(class_dn var1) {
         super.b(var1);
         this.a = class_agj.c(var1.g("CA"));
         this.b = class_agj.c(var1.g("CB"));
         this.c = class_agj.c(var1.g("CC"));
         this.d = class_agj.c(var1.g("CD"));
      }

      private class_agj a(Random var1) {
         switch(var1.nextInt(10)) {
         case 0:
         case 1:
            return class_agk.cb;
         case 2:
         case 3:
            return class_agk.cc;
         case 4:
            return class_agk.cZ;
         default:
            return class_agk.aj;
         }
      }

      public static class_asr.class_b_in_class_asr a(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
         class_arw var8 = class_arw.a(var3, var4, var5, 0, 0, 0, 13, 4, 9, var6);
         return a((class_arw)var8) && class_asn.a(var1, var8) == null?new class_asr.class_b_in_class_asr(var0, var7, var2, var8, var6):null;
      }

      public boolean a(class_aen var1, Random var2, class_arw var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 4 - 1, 0);
         }

         this.a(var1, var3, 0, 1, 0, 12, 4, 8, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, var3, 1, 0, 1, 2, 0, 7, class_agk.ak.S(), class_agk.ak.S(), false);
         this.a(var1, var3, 4, 0, 1, 5, 0, 7, class_agk.ak.S(), class_agk.ak.S(), false);
         this.a(var1, var3, 7, 0, 1, 8, 0, 7, class_agk.ak.S(), class_agk.ak.S(), false);
         this.a(var1, var3, 10, 0, 1, 11, 0, 7, class_agk.ak.S(), class_agk.ak.S(), false);
         this.a(var1, var3, 0, 0, 0, 0, 0, 8, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 6, 0, 0, 6, 0, 8, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 12, 0, 0, 12, 0, 8, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 1, 0, 0, 11, 0, 0, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 1, 0, 8, 11, 0, 8, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 3, 0, 1, 3, 0, 7, class_agk.j.S(), class_agk.j.S(), false);
         this.a(var1, var3, 9, 0, 1, 9, 0, 7, class_agk.j.S(), class_agk.j.S(), false);

         int var4;
         int var5;
         for(var4 = 1; var4 <= 7; ++var4) {
            var5 = ((class_ahd)this.a).n();
            int var6 = var5 / 3;
            this.a(var1, this.a.a(class_nu.a(var2, var6, var5)), 1, 1, var4, var3);
            this.a(var1, this.a.a(class_nu.a(var2, var6, var5)), 2, 1, var4, var3);
            int var7 = ((class_ahd)this.b).n();
            int var8 = var7 / 3;
            this.a(var1, this.b.a(class_nu.a(var2, var8, var7)), 4, 1, var4, var3);
            this.a(var1, this.b.a(class_nu.a(var2, var8, var7)), 5, 1, var4, var3);
            int var9 = ((class_ahd)this.c).n();
            int var10 = var9 / 3;
            this.a(var1, this.c.a(class_nu.a(var2, var10, var9)), 7, 1, var4, var3);
            this.a(var1, this.c.a(class_nu.a(var2, var10, var9)), 8, 1, var4, var3);
            int var11 = ((class_ahd)this.d).n();
            int var12 = var11 / 3;
            this.a(var1, this.d.a(class_nu.a(var2, var12, var11)), 10, 1, var4, var3);
            this.a(var1, this.d.a(class_nu.a(var2, var12, var11)), 11, 1, var4, var3);
         }

         for(var4 = 0; var4 < 9; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               this.b(var1, var5, 4, var4, var3);
               this.b(var1, class_agk.d.S(), var5, -1, var4, var3);
            }
         }

         return true;
      }
   }

   public static class class_c_in_class_asr extends class_asr.class_n_in_class_asr {
      private class_agj a;
      private class_agj b;

      public class_c_in_class_asr() {
      }

      public class_c_in_class_asr(class_asr.class_k_in_class_asr var1, int var2, Random var3, class_arw var4, class_cq var5) {
         super(var1, var2);
         this.a((class_cq)var5);
         this.l = var4;
         this.a = this.a(var3);
         this.b = this.a(var3);
      }

      protected void a(class_dn var1) {
         super.a(var1);
         var1.a("CA", class_agj.c.a((Object)this.a));
         var1.a("CB", class_agj.c.a((Object)this.b));
      }

      protected void b(class_dn var1) {
         super.b(var1);
         this.a = class_agj.c(var1.g("CA"));
         this.b = class_agj.c(var1.g("CB"));
      }

      private class_agj a(Random var1) {
         switch(var1.nextInt(10)) {
         case 0:
         case 1:
            return class_agk.cb;
         case 2:
         case 3:
            return class_agk.cc;
         case 4:
            return class_agk.cZ;
         default:
            return class_agk.aj;
         }
      }

      public static class_asr.class_c_in_class_asr a(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
         class_arw var8 = class_arw.a(var3, var4, var5, 0, 0, 0, 7, 4, 9, var6);
         return a((class_arw)var8) && class_asn.a(var1, var8) == null?new class_asr.class_c_in_class_asr(var0, var7, var2, var8, var6):null;
      }

      public boolean a(class_aen var1, Random var2, class_arw var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 4 - 1, 0);
         }

         this.a(var1, var3, 0, 1, 0, 6, 4, 8, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, var3, 1, 0, 1, 2, 0, 7, class_agk.ak.S(), class_agk.ak.S(), false);
         this.a(var1, var3, 4, 0, 1, 5, 0, 7, class_agk.ak.S(), class_agk.ak.S(), false);
         this.a(var1, var3, 0, 0, 0, 0, 0, 8, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 6, 0, 0, 6, 0, 8, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 1, 0, 0, 5, 0, 0, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 1, 0, 8, 5, 0, 8, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 3, 0, 1, 3, 0, 7, class_agk.j.S(), class_agk.j.S(), false);

         int var4;
         int var5;
         for(var4 = 1; var4 <= 7; ++var4) {
            var5 = ((class_ahd)this.a).n();
            int var6 = var5 / 3;
            this.a(var1, this.a.a(class_nu.a(var2, var6, var5)), 1, 1, var4, var3);
            this.a(var1, this.a.a(class_nu.a(var2, var6, var5)), 2, 1, var4, var3);
            int var7 = ((class_ahd)this.b).n();
            int var8 = var7 / 3;
            this.a(var1, this.b.a(class_nu.a(var2, var8, var7)), 4, 1, var4, var3);
            this.a(var1, this.b.a(class_nu.a(var2, var8, var7)), 5, 1, var4, var3);
         }

         for(var4 = 0; var4 < 9; ++var4) {
            for(var5 = 0; var5 < 7; ++var5) {
               this.b(var1, var5, 4, var4, var3);
               this.b(var1, class_agk.d.S(), var5, -1, var4, var3);
            }
         }

         return true;
      }
   }

   public static class class_j_in_class_asr extends class_asr.class_n_in_class_asr {
      private static final List a;
      private boolean b;

      public class_j_in_class_asr() {
      }

      public class_j_in_class_asr(class_asr.class_k_in_class_asr var1, int var2, Random var3, class_arw var4, class_cq var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
      }

      public static class_asr.class_j_in_class_asr a(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
         class_arw var8 = class_arw.a(var3, var4, var5, 0, 0, 0, 10, 6, 7, var6);
         return a(var8) && class_asn.a(var1, var8) == null?new class_asr.class_j_in_class_asr(var0, var7, var2, var8, var6):null;
      }

      protected void a(class_dn var1) {
         super.a(var1);
         var1.a("Chest", this.b);
      }

      protected void b(class_dn var1) {
         super.b(var1);
         this.b = var1.o("Chest");
      }

      public boolean a(class_aen var1, Random var2, class_arw var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 6 - 1, 0);
         }

         this.a(var1, var3, 0, 1, 0, 9, 4, 6, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, var3, 0, 0, 0, 9, 0, 6, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 4, 0, 9, 4, 6, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 5, 0, 9, 5, 6, class_agk.U.S(), class_agk.U.S(), false);
         this.a(var1, var3, 1, 5, 1, 8, 5, 5, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, var3, 1, 1, 0, 2, 3, 0, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 0, 1, 0, 0, 4, 0, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 3, 1, 0, 3, 4, 0, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 0, 1, 6, 0, 4, 6, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, class_agk.f.S(), 3, 3, 1, var3);
         this.a(var1, var3, 3, 1, 2, 3, 3, 2, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 4, 1, 3, 5, 3, 3, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 0, 1, 1, 0, 3, 5, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 1, 1, 6, 5, 3, 6, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 5, 1, 0, 5, 3, 0, class_agk.aO.S(), class_agk.aO.S(), false);
         this.a(var1, var3, 9, 1, 0, 9, 3, 0, class_agk.aO.S(), class_agk.aO.S(), false);
         this.a(var1, var3, 6, 1, 4, 9, 4, 6, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, class_agk.k.S(), 7, 1, 5, var3);
         this.a(var1, class_agk.k.S(), 8, 1, 5, var3);
         this.a(var1, class_agk.bi.S(), 9, 2, 5, var3);
         this.a(var1, class_agk.bi.S(), 9, 2, 4, var3);
         this.a(var1, var3, 7, 2, 4, 8, 2, 5, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, class_agk.e.S(), 6, 1, 3, var3);
         this.a(var1, class_agk.al.S(), 6, 2, 3, var3);
         this.a(var1, class_agk.al.S(), 6, 3, 3, var3);
         this.a(var1, class_agk.T.S(), 8, 1, 1, var3);
         this.a(var1, class_agk.bj.S(), 0, 2, 2, var3);
         this.a(var1, class_agk.bj.S(), 0, 2, 4, var3);
         this.a(var1, class_agk.bj.S(), 2, 2, 6, var3);
         this.a(var1, class_agk.bj.S(), 4, 2, 6, var3);
         this.a(var1, class_agk.aO.S(), 2, 1, 4, var3);
         this.a(var1, class_agk.aB.S(), 2, 2, 4, var3);
         this.a(var1, class_agk.f.S(), 1, 1, 5, var3);
         this.a(var1, class_agk.ad.S().a(class_ald.a, class_cq.c), 2, 1, 5, var3);
         this.a(var1, class_agk.ad.S().a(class_ald.a, class_cq.e), 1, 1, 4, var3);
         if(!this.b && var3.b((class_df)(new class_cj(this.a(5, 5), this.d(1), this.b(5, 5))))) {
            this.b = true;
            this.a(var1, var3, var2, 5, 1, 5, a, 3 + var2.nextInt(6));
         }

         int var4;
         for(var4 = 6; var4 <= 8; ++var4) {
            if(this.a(var1, var4, 0, -1, var3).c().v() == class_atk.a && this.a(var1, var4, -1, -1, var3).c().v() != class_atk.a) {
               this.a(var1, class_agk.aw.S().a(class_ald.a, class_cq.c), var4, 0, -1, var3);
            }
         }

         for(var4 = 0; var4 < 7; ++var4) {
            for(int var5 = 0; var5 < 10; ++var5) {
               this.b(var1, var5, 6, var4, var3);
               this.b(var1, class_agk.e.S(), var5, -1, var4, var3);
            }
         }

         this.a(var1, var3, 7, 1, 1, 1);
         return true;
      }

      protected int c(int var1, int var2) {
         return 3;
      }

      static {
         a = Lists.newArrayList((Object[])(new class_od[]{new class_od(class_aau.k, 0, 1, 3, 3), new class_od(class_aau.l, 0, 1, 5, 10), new class_od(class_aau.m, 0, 1, 3, 5), new class_od(class_aau.R, 0, 1, 3, 15), new class_od(class_aau.e, 0, 1, 3, 15), new class_od(class_aau.b, 0, 1, 1, 5), new class_od(class_aau.n, 0, 1, 1, 5), new class_od(class_aau.ab, 0, 1, 1, 5), new class_od(class_aau.aa, 0, 1, 1, 5), new class_od(class_aau.ac, 0, 1, 1, 5), new class_od(class_aau.ad, 0, 1, 1, 5), new class_od(class_aar.a(class_agk.Z), 0, 3, 7, 5), new class_od(class_aar.a(class_agk.g), 0, 3, 7, 5), new class_od(class_aau.aC, 0, 1, 1, 3), new class_od(class_aau.cn, 0, 1, 1, 1), new class_od(class_aau.co, 0, 1, 1, 1), new class_od(class_aau.cp, 0, 1, 1, 1)}));
      }
   }

   public static class class_m_in_class_asr extends class_asr.class_n_in_class_asr {
      public class_m_in_class_asr() {
      }

      public class_m_in_class_asr(class_asr.class_k_in_class_asr var1, int var2, Random var3, class_arw var4, class_cq var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
      }

      public static class_asr.class_m_in_class_asr a(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
         class_arw var8 = class_arw.a(var3, var4, var5, 0, 0, 0, 9, 7, 12, var6);
         return a(var8) && class_asn.a(var1, var8) == null?new class_asr.class_m_in_class_asr(var0, var7, var2, var8, var6):null;
      }

      public boolean a(class_aen var1, Random var2, class_arw var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 7 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 7, 4, 4, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, var3, 2, 1, 6, 8, 4, 10, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, var3, 2, 0, 5, 8, 0, 10, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 1, 0, 1, 7, 0, 4, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 0, 0, 0, 0, 3, 5, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 8, 0, 0, 8, 3, 10, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 1, 0, 0, 7, 2, 0, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 1, 0, 5, 2, 1, 5, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 2, 0, 6, 2, 3, 10, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 3, 0, 10, 7, 3, 10, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 1, 2, 0, 7, 3, 0, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 1, 2, 5, 2, 3, 5, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 0, 4, 1, 8, 4, 1, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 0, 4, 4, 3, 4, 4, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 0, 5, 2, 8, 5, 3, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, class_agk.f.S(), 0, 4, 2, var3);
         this.a(var1, class_agk.f.S(), 0, 4, 3, var3);
         this.a(var1, class_agk.f.S(), 8, 4, 2, var3);
         this.a(var1, class_agk.f.S(), 8, 4, 3, var3);
         this.a(var1, class_agk.f.S(), 8, 4, 4, var3);
         class_anl var4 = class_agk.ad.S().a(class_ald.a, class_cq.c);
         class_anl var5 = class_agk.ad.S().a(class_ald.a, class_cq.d);
         class_anl var6 = class_agk.ad.S().a(class_ald.a, class_cq.e);
         class_anl var7 = class_agk.ad.S().a(class_ald.a, class_cq.f);

         int var8;
         int var9;
         for(var8 = -1; var8 <= 2; ++var8) {
            for(var9 = 0; var9 <= 8; ++var9) {
               this.a(var1, var4, var9, 4 + var8, var8, var3);
               if((var8 > -1 || var9 <= 1) && (var8 > 0 || var9 <= 3) && (var8 > 1 || var9 <= 4 || var9 >= 6)) {
                  this.a(var1, var5, var9, 4 + var8, 5 - var8, var3);
               }
            }
         }

         this.a(var1, var3, 3, 4, 5, 3, 4, 10, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 7, 4, 2, 7, 4, 10, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 4, 5, 4, 4, 5, 10, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 6, 5, 4, 6, 5, 10, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 5, 6, 3, 5, 6, 10, class_agk.f.S(), class_agk.f.S(), false);

         for(var8 = 4; var8 >= 1; --var8) {
            this.a(var1, class_agk.f.S(), var8, 2 + var8, 7 - var8, var3);

            for(var9 = 8 - var8; var9 <= 10; ++var9) {
               this.a(var1, var7, var8, 2 + var8, var9, var3);
            }
         }

         this.a(var1, class_agk.f.S(), 6, 6, 3, var3);
         this.a(var1, class_agk.f.S(), 7, 5, 4, var3);
         this.a(var1, var6, 6, 6, 4, var3);

         for(var8 = 6; var8 <= 8; ++var8) {
            for(var9 = 5; var9 <= 10; ++var9) {
               this.a(var1, var6, var8, 12 - var8, var9, var3);
            }
         }

         this.a(var1, class_agk.r.S(), 0, 2, 1, var3);
         this.a(var1, class_agk.r.S(), 0, 2, 4, var3);
         this.a(var1, class_agk.bj.S(), 0, 2, 2, var3);
         this.a(var1, class_agk.bj.S(), 0, 2, 3, var3);
         this.a(var1, class_agk.r.S(), 4, 2, 0, var3);
         this.a(var1, class_agk.bj.S(), 5, 2, 0, var3);
         this.a(var1, class_agk.r.S(), 6, 2, 0, var3);
         this.a(var1, class_agk.r.S(), 8, 2, 1, var3);
         this.a(var1, class_agk.bj.S(), 8, 2, 2, var3);
         this.a(var1, class_agk.bj.S(), 8, 2, 3, var3);
         this.a(var1, class_agk.r.S(), 8, 2, 4, var3);
         this.a(var1, class_agk.f.S(), 8, 2, 5, var3);
         this.a(var1, class_agk.r.S(), 8, 2, 6, var3);
         this.a(var1, class_agk.bj.S(), 8, 2, 7, var3);
         this.a(var1, class_agk.bj.S(), 8, 2, 8, var3);
         this.a(var1, class_agk.r.S(), 8, 2, 9, var3);
         this.a(var1, class_agk.r.S(), 2, 2, 6, var3);
         this.a(var1, class_agk.bj.S(), 2, 2, 7, var3);
         this.a(var1, class_agk.bj.S(), 2, 2, 8, var3);
         this.a(var1, class_agk.r.S(), 2, 2, 9, var3);
         this.a(var1, class_agk.r.S(), 4, 4, 10, var3);
         this.a(var1, class_agk.bj.S(), 5, 4, 10, var3);
         this.a(var1, class_agk.r.S(), 6, 4, 10, var3);
         this.a(var1, class_agk.f.S(), 5, 5, 10, var3);
         this.a(var1, class_agk.a.S(), 2, 1, 0, var3);
         this.a(var1, class_agk.a.S(), 2, 2, 0, var3);
         this.a(var1, class_agk.aa.S().a(class_alp.a, class_cq.c), 2, 3, 1, var3);
         this.a(var1, var3, var2, 2, 1, 0, class_cq.c);
         this.a(var1, var3, 1, 0, -1, 3, 2, -1, class_agk.a.S(), class_agk.a.S(), false);
         if(this.a(var1, 2, 0, -1, var3).c().v() == class_atk.a && this.a(var1, 2, -1, -1, var3).c().v() != class_atk.a) {
            this.a(var1, var4, 2, 0, -1, var3);
         }

         for(var8 = 0; var8 < 5; ++var8) {
            for(var9 = 0; var9 < 9; ++var9) {
               this.b(var1, var9, 7, var8, var3);
               this.b(var1, class_agk.e.S(), var9, -1, var8, var3);
            }
         }

         for(var8 = 5; var8 < 11; ++var8) {
            for(var9 = 2; var9 < 9; ++var9) {
               this.b(var1, var9, 7, var8, var3);
               this.b(var1, class_agk.e.S(), var9, -1, var8, var3);
            }
         }

         this.a(var1, var3, 4, 1, 2, 2);
         return true;
      }
   }

   public static class class_f_in_class_asr extends class_asr.class_n_in_class_asr {
      public class_f_in_class_asr() {
      }

      public class_f_in_class_asr(class_asr.class_k_in_class_asr var1, int var2, Random var3, class_arw var4, class_cq var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
      }

      public static class_asr.class_f_in_class_asr a(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
         class_arw var8 = class_arw.a(var3, var4, var5, 0, 0, 0, 9, 7, 11, var6);
         return a(var8) && class_asn.a(var1, var8) == null?new class_asr.class_f_in_class_asr(var0, var7, var2, var8, var6):null;
      }

      public boolean a(class_aen var1, Random var2, class_arw var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 7 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 7, 4, 4, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, var3, 2, 1, 6, 8, 4, 10, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, var3, 2, 0, 6, 8, 0, 10, class_agk.d.S(), class_agk.d.S(), false);
         this.a(var1, class_agk.e.S(), 6, 0, 6, var3);
         this.a(var1, var3, 2, 1, 6, 2, 1, 10, class_agk.aO.S(), class_agk.aO.S(), false);
         this.a(var1, var3, 8, 1, 6, 8, 1, 10, class_agk.aO.S(), class_agk.aO.S(), false);
         this.a(var1, var3, 3, 1, 10, 7, 1, 10, class_agk.aO.S(), class_agk.aO.S(), false);
         this.a(var1, var3, 1, 0, 1, 7, 0, 4, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 0, 0, 0, 0, 3, 5, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 8, 0, 0, 8, 3, 5, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 1, 0, 0, 7, 1, 0, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 1, 0, 5, 7, 1, 5, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 1, 2, 0, 7, 3, 0, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 1, 2, 5, 7, 3, 5, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 0, 4, 1, 8, 4, 1, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 0, 4, 4, 8, 4, 4, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 0, 5, 2, 8, 5, 3, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, class_agk.f.S(), 0, 4, 2, var3);
         this.a(var1, class_agk.f.S(), 0, 4, 3, var3);
         this.a(var1, class_agk.f.S(), 8, 4, 2, var3);
         this.a(var1, class_agk.f.S(), 8, 4, 3, var3);
         class_anl var4 = class_agk.ad.S().a(class_ald.a, class_cq.c);
         class_anl var5 = class_agk.ad.S().a(class_ald.a, class_cq.d);
         class_anl var6 = class_agk.ad.S().a(class_ald.a, class_cq.e);

         int var7;
         int var8;
         for(var7 = -1; var7 <= 2; ++var7) {
            for(var8 = 0; var8 <= 8; ++var8) {
               this.a(var1, var4, var8, 4 + var7, var7, var3);
               this.a(var1, var5, var8, 4 + var7, 5 - var7, var3);
            }
         }

         this.a(var1, class_agk.r.S(), 0, 2, 1, var3);
         this.a(var1, class_agk.r.S(), 0, 2, 4, var3);
         this.a(var1, class_agk.r.S(), 8, 2, 1, var3);
         this.a(var1, class_agk.r.S(), 8, 2, 4, var3);
         this.a(var1, class_agk.bj.S(), 0, 2, 2, var3);
         this.a(var1, class_agk.bj.S(), 0, 2, 3, var3);
         this.a(var1, class_agk.bj.S(), 8, 2, 2, var3);
         this.a(var1, class_agk.bj.S(), 8, 2, 3, var3);
         this.a(var1, class_agk.bj.S(), 2, 2, 5, var3);
         this.a(var1, class_agk.bj.S(), 3, 2, 5, var3);
         this.a(var1, class_agk.bj.S(), 5, 2, 0, var3);
         this.a(var1, class_agk.bj.S(), 6, 2, 5, var3);
         this.a(var1, class_agk.aO.S(), 2, 1, 3, var3);
         this.a(var1, class_agk.aB.S(), 2, 2, 3, var3);
         this.a(var1, class_agk.f.S(), 1, 1, 4, var3);
         this.a(var1, var4, 2, 1, 4, var3);
         this.a(var1, var6, 1, 1, 3, var3);
         this.a(var1, var3, 5, 0, 1, 7, 0, 3, class_agk.T.S(), class_agk.T.S(), false);
         this.a(var1, class_agk.T.S(), 6, 1, 1, var3);
         this.a(var1, class_agk.T.S(), 6, 1, 2, var3);
         this.a(var1, class_agk.a.S(), 2, 1, 0, var3);
         this.a(var1, class_agk.a.S(), 2, 2, 0, var3);
         this.a(var1, class_agk.aa.S().a(class_alp.a, class_cq.c), 2, 3, 1, var3);
         this.a(var1, var3, var2, 2, 1, 0, class_cq.c);
         if(this.a(var1, 2, 0, -1, var3).c().v() == class_atk.a && this.a(var1, 2, -1, -1, var3).c().v() != class_atk.a) {
            this.a(var1, var4, 2, 0, -1, var3);
         }

         this.a(var1, class_agk.a.S(), 6, 1, 5, var3);
         this.a(var1, class_agk.a.S(), 6, 2, 5, var3);
         this.a(var1, class_agk.aa.S().a(class_alp.a, class_cq.d), 6, 3, 4, var3);
         this.a(var1, var3, var2, 6, 1, 5, class_cq.d);

         for(var7 = 0; var7 < 5; ++var7) {
            for(var8 = 0; var8 < 9; ++var8) {
               this.b(var1, var8, 7, var7, var3);
               this.b(var1, class_agk.e.S(), var8, -1, var7, var3);
            }
         }

         this.a(var1, var3, 4, 1, 2, 2);
         return true;
      }

      protected int c(int var1, int var2) {
         return var1 == 0?4:super.c(var1, var2);
      }
   }

   public static class class_h_in_class_asr extends class_asr.class_n_in_class_asr {
      private boolean a;
      private int b;

      public class_h_in_class_asr() {
      }

      public class_h_in_class_asr(class_asr.class_k_in_class_asr var1, int var2, Random var3, class_arw var4, class_cq var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
         this.a = var3.nextBoolean();
         this.b = var3.nextInt(3);
      }

      protected void a(class_dn var1) {
         super.a(var1);
         var1.a("T", this.b);
         var1.a("C", this.a);
      }

      protected void b(class_dn var1) {
         super.b(var1);
         this.b = var1.g("T");
         this.a = var1.o("C");
      }

      public static class_asr.class_h_in_class_asr a(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
         class_arw var8 = class_arw.a(var3, var4, var5, 0, 0, 0, 4, 6, 5, var6);
         return a(var8) && class_asn.a(var1, var8) == null?new class_asr.class_h_in_class_asr(var0, var7, var2, var8, var6):null;
      }

      public boolean a(class_aen var1, Random var2, class_arw var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 6 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 3, 5, 4, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, var3, 0, 0, 0, 3, 0, 4, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 1, 0, 1, 2, 0, 3, class_agk.d.S(), class_agk.d.S(), false);
         if(this.a) {
            this.a(var1, var3, 1, 4, 1, 2, 4, 3, class_agk.r.S(), class_agk.r.S(), false);
         } else {
            this.a(var1, var3, 1, 5, 1, 2, 5, 3, class_agk.r.S(), class_agk.r.S(), false);
         }

         this.a(var1, class_agk.r.S(), 1, 4, 0, var3);
         this.a(var1, class_agk.r.S(), 2, 4, 0, var3);
         this.a(var1, class_agk.r.S(), 1, 4, 4, var3);
         this.a(var1, class_agk.r.S(), 2, 4, 4, var3);
         this.a(var1, class_agk.r.S(), 0, 4, 1, var3);
         this.a(var1, class_agk.r.S(), 0, 4, 2, var3);
         this.a(var1, class_agk.r.S(), 0, 4, 3, var3);
         this.a(var1, class_agk.r.S(), 3, 4, 1, var3);
         this.a(var1, class_agk.r.S(), 3, 4, 2, var3);
         this.a(var1, class_agk.r.S(), 3, 4, 3, var3);
         this.a(var1, var3, 0, 1, 0, 0, 3, 0, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 3, 1, 0, 3, 3, 0, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 0, 1, 4, 0, 3, 4, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 3, 1, 4, 3, 3, 4, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 0, 1, 1, 0, 3, 3, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 3, 1, 1, 3, 3, 3, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 1, 1, 0, 2, 3, 0, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 1, 1, 4, 2, 3, 4, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, class_agk.bj.S(), 0, 2, 2, var3);
         this.a(var1, class_agk.bj.S(), 3, 2, 2, var3);
         if(this.b > 0) {
            this.a(var1, class_agk.aO.S(), this.b, 1, 3, var3);
            this.a(var1, class_agk.aB.S(), this.b, 2, 3, var3);
         }

         this.a(var1, class_agk.a.S(), 1, 1, 0, var3);
         this.a(var1, class_agk.a.S(), 1, 2, 0, var3);
         this.a(var1, var3, var2, 1, 1, 0, class_cq.c);
         if(this.a(var1, 1, 0, -1, var3).c().v() == class_atk.a && this.a(var1, 1, -1, -1, var3).c().v() != class_atk.a) {
            this.a(var1, class_agk.aw.S().a(class_ald.a, class_cq.c), 1, 0, -1, var3);
         }

         for(int var4 = 0; var4 < 5; ++var4) {
            for(int var5 = 0; var5 < 4; ++var5) {
               this.b(var1, var5, 6, var4, var3);
               this.b(var1, class_agk.e.S(), var5, -1, var4, var3);
            }
         }

         this.a(var1, var3, 1, 1, 2, 1);
         return true;
      }
   }

   public static class class_a_in_class_asr extends class_asr.class_n_in_class_asr {
      public class_a_in_class_asr() {
      }

      public class_a_in_class_asr(class_asr.class_k_in_class_asr var1, int var2, Random var3, class_arw var4, class_cq var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
      }

      public static class_asr.class_a_in_class_asr a(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
         class_arw var8 = class_arw.a(var3, var4, var5, 0, 0, 0, 9, 9, 6, var6);
         return a(var8) && class_asn.a(var1, var8) == null?new class_asr.class_a_in_class_asr(var0, var7, var2, var8, var6):null;
      }

      public boolean a(class_aen var1, Random var2, class_arw var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 9 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 7, 5, 4, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, var3, 0, 0, 0, 8, 0, 5, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 5, 0, 8, 5, 5, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 6, 1, 8, 6, 4, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 7, 2, 8, 7, 3, class_agk.e.S(), class_agk.e.S(), false);

         int var5;
         for(int var4 = -1; var4 <= 2; ++var4) {
            for(var5 = 0; var5 <= 8; ++var5) {
               this.a(var1, class_agk.ad.S().a(class_ald.a, class_cq.c), var5, 6 + var4, var4, var3);
               this.a(var1, class_agk.ad.S().a(class_ald.a, class_cq.d), var5, 6 + var4, 5 - var4, var3);
            }
         }

         this.a(var1, var3, 0, 1, 0, 0, 1, 5, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 1, 1, 5, 8, 1, 5, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 8, 1, 0, 8, 1, 4, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 2, 1, 0, 7, 1, 0, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 2, 0, 0, 4, 0, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 2, 5, 0, 4, 5, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 8, 2, 5, 8, 4, 5, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 8, 2, 0, 8, 4, 0, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 2, 1, 0, 4, 4, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 1, 2, 5, 7, 4, 5, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 8, 2, 1, 8, 4, 4, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 1, 2, 0, 7, 4, 0, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, class_agk.bj.S(), 4, 2, 0, var3);
         this.a(var1, class_agk.bj.S(), 5, 2, 0, var3);
         this.a(var1, class_agk.bj.S(), 6, 2, 0, var3);
         this.a(var1, class_agk.bj.S(), 4, 3, 0, var3);
         this.a(var1, class_agk.bj.S(), 5, 3, 0, var3);
         this.a(var1, class_agk.bj.S(), 6, 3, 0, var3);
         this.a(var1, class_agk.bj.S(), 0, 2, 2, var3);
         this.a(var1, class_agk.bj.S(), 0, 2, 3, var3);
         this.a(var1, class_agk.bj.S(), 0, 3, 2, var3);
         this.a(var1, class_agk.bj.S(), 0, 3, 3, var3);
         this.a(var1, class_agk.bj.S(), 8, 2, 2, var3);
         this.a(var1, class_agk.bj.S(), 8, 2, 3, var3);
         this.a(var1, class_agk.bj.S(), 8, 3, 2, var3);
         this.a(var1, class_agk.bj.S(), 8, 3, 3, var3);
         this.a(var1, class_agk.bj.S(), 2, 2, 5, var3);
         this.a(var1, class_agk.bj.S(), 3, 2, 5, var3);
         this.a(var1, class_agk.bj.S(), 5, 2, 5, var3);
         this.a(var1, class_agk.bj.S(), 6, 2, 5, var3);
         this.a(var1, var3, 1, 4, 1, 7, 4, 1, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 1, 4, 4, 7, 4, 4, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 1, 3, 4, 7, 3, 4, class_agk.X.S(), class_agk.X.S(), false);
         this.a(var1, class_agk.f.S(), 7, 1, 4, var3);
         this.a(var1, class_agk.ad.S().a(class_ald.a, class_cq.f), 7, 1, 3, var3);
         class_anl var7 = class_agk.ad.S().a(class_ald.a, class_cq.c);
         this.a(var1, var7, 6, 1, 4, var3);
         this.a(var1, var7, 5, 1, 4, var3);
         this.a(var1, var7, 4, 1, 4, var3);
         this.a(var1, var7, 3, 1, 4, var3);
         this.a(var1, class_agk.aO.S(), 6, 1, 3, var3);
         this.a(var1, class_agk.aB.S(), 6, 2, 3, var3);
         this.a(var1, class_agk.aO.S(), 4, 1, 3, var3);
         this.a(var1, class_agk.aB.S(), 4, 2, 3, var3);
         this.a(var1, class_agk.ai.S(), 7, 1, 1, var3);
         this.a(var1, class_agk.a.S(), 1, 1, 0, var3);
         this.a(var1, class_agk.a.S(), 1, 2, 0, var3);
         this.a(var1, var3, var2, 1, 1, 0, class_cq.c);
         if(this.a(var1, 1, 0, -1, var3).c().v() == class_atk.a && this.a(var1, 1, -1, -1, var3).c().v() != class_atk.a) {
            this.a(var1, class_agk.aw.S().a(class_ald.a, class_cq.c), 1, 0, -1, var3);
         }

         for(var5 = 0; var5 < 6; ++var5) {
            for(int var6 = 0; var6 < 9; ++var6) {
               this.b(var1, var6, 9, var5, var3);
               this.b(var1, class_agk.e.S(), var6, -1, var5, var3);
            }
         }

         this.a(var1, var3, 2, 1, 2, 1);
         return true;
      }

      protected int c(int var1, int var2) {
         return 1;
      }
   }

   public static class class_i_in_class_asr extends class_asr.class_n_in_class_asr {
      public class_i_in_class_asr() {
      }

      public class_i_in_class_asr(class_asr.class_k_in_class_asr var1, int var2, Random var3, class_arw var4, class_cq var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
      }

      public static class_asr.class_i_in_class_asr a(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
         class_arw var8 = class_arw.a(var3, var4, var5, 0, 0, 0, 5, 12, 9, var6);
         return a(var8) && class_asn.a(var1, var8) == null?new class_asr.class_i_in_class_asr(var0, var7, var2, var8, var6):null;
      }

      public boolean a(class_aen var1, Random var2, class_arw var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 12 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 3, 3, 7, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, var3, 1, 5, 1, 3, 9, 3, class_agk.a.S(), class_agk.a.S(), false);
         this.a(var1, var3, 1, 0, 0, 3, 0, 8, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 1, 1, 0, 3, 10, 0, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 1, 1, 0, 10, 3, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 4, 1, 1, 4, 10, 3, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 0, 4, 0, 4, 7, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 4, 0, 4, 4, 4, 7, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 1, 1, 8, 3, 4, 8, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 1, 5, 4, 3, 10, 4, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 1, 5, 5, 3, 5, 7, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 9, 0, 4, 9, 4, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 4, 0, 4, 4, 4, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, class_agk.e.S(), 0, 11, 2, var3);
         this.a(var1, class_agk.e.S(), 4, 11, 2, var3);
         this.a(var1, class_agk.e.S(), 2, 11, 0, var3);
         this.a(var1, class_agk.e.S(), 2, 11, 4, var3);
         this.a(var1, class_agk.e.S(), 1, 1, 6, var3);
         this.a(var1, class_agk.e.S(), 1, 1, 7, var3);
         this.a(var1, class_agk.e.S(), 2, 1, 7, var3);
         this.a(var1, class_agk.e.S(), 3, 1, 6, var3);
         this.a(var1, class_agk.e.S(), 3, 1, 7, var3);
         class_anl var4 = class_agk.aw.S().a(class_ald.a, class_cq.c);
         class_anl var5 = class_agk.aw.S().a(class_ald.a, class_cq.e);
         class_anl var6 = class_agk.aw.S().a(class_ald.a, class_cq.f);
         this.a(var1, var4, 1, 1, 5, var3);
         this.a(var1, var4, 2, 1, 6, var3);
         this.a(var1, var4, 3, 1, 5, var3);
         this.a(var1, var5, 1, 2, 7, var3);
         this.a(var1, var6, 3, 2, 7, var3);
         this.a(var1, class_agk.bj.S(), 0, 2, 2, var3);
         this.a(var1, class_agk.bj.S(), 0, 3, 2, var3);
         this.a(var1, class_agk.bj.S(), 4, 2, 2, var3);
         this.a(var1, class_agk.bj.S(), 4, 3, 2, var3);
         this.a(var1, class_agk.bj.S(), 0, 6, 2, var3);
         this.a(var1, class_agk.bj.S(), 0, 7, 2, var3);
         this.a(var1, class_agk.bj.S(), 4, 6, 2, var3);
         this.a(var1, class_agk.bj.S(), 4, 7, 2, var3);
         this.a(var1, class_agk.bj.S(), 2, 6, 0, var3);
         this.a(var1, class_agk.bj.S(), 2, 7, 0, var3);
         this.a(var1, class_agk.bj.S(), 2, 6, 4, var3);
         this.a(var1, class_agk.bj.S(), 2, 7, 4, var3);
         this.a(var1, class_agk.bj.S(), 0, 3, 6, var3);
         this.a(var1, class_agk.bj.S(), 4, 3, 6, var3);
         this.a(var1, class_agk.bj.S(), 2, 3, 8, var3);
         this.a(var1, class_agk.aa.S().a(class_alp.a, class_cq.d), 2, 4, 7, var3);
         this.a(var1, class_agk.aa.S().a(class_alp.a, class_cq.f), 1, 4, 6, var3);
         this.a(var1, class_agk.aa.S().a(class_alp.a, class_cq.e), 3, 4, 6, var3);
         this.a(var1, class_agk.aa.S().a(class_alp.a, class_cq.c), 2, 4, 5, var3);
         class_anl var7 = class_agk.au.S().a(class_aiz.a, class_cq.e);

         int var8;
         for(var8 = 1; var8 <= 9; ++var8) {
            this.a(var1, var7, 3, var8, 3, var3);
         }

         this.a(var1, class_agk.a.S(), 2, 1, 0, var3);
         this.a(var1, class_agk.a.S(), 2, 2, 0, var3);
         this.a(var1, var3, var2, 2, 1, 0, class_cq.c);
         if(this.a(var1, 2, 0, -1, var3).c().v() == class_atk.a && this.a(var1, 2, -1, -1, var3).c().v() != class_atk.a) {
            this.a(var1, var4, 2, 0, -1, var3);
         }

         for(var8 = 0; var8 < 9; ++var8) {
            for(int var9 = 0; var9 < 5; ++var9) {
               this.b(var1, var9, 12, var8, var3);
               this.b(var1, class_agk.e.S(), var9, -1, var8, var3);
            }
         }

         this.a(var1, var3, 2, 1, 2, 1);
         return true;
      }

      protected int c(int var1, int var2) {
         return 2;
      }
   }

   public static class class_g_in_class_asr extends class_asr.class_n_in_class_asr {
      private boolean a;

      public class_g_in_class_asr() {
      }

      public class_g_in_class_asr(class_asr.class_k_in_class_asr var1, int var2, Random var3, class_arw var4, class_cq var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
         this.a = var3.nextBoolean();
      }

      protected void a(class_dn var1) {
         super.a(var1);
         var1.a("Terrace", this.a);
      }

      protected void b(class_dn var1) {
         super.b(var1);
         this.a = var1.o("Terrace");
      }

      public static class_asr.class_g_in_class_asr a(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
         class_arw var8 = class_arw.a(var3, var4, var5, 0, 0, 0, 5, 6, 5, var6);
         return class_asn.a(var1, var8) != null?null:new class_asr.class_g_in_class_asr(var0, var7, var2, var8, var6);
      }

      public boolean a(class_aen var1, Random var2, class_arw var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 6 - 1, 0);
         }

         this.a(var1, var3, 0, 0, 0, 4, 0, 4, class_agk.e.S(), class_agk.e.S(), false);
         this.a(var1, var3, 0, 4, 0, 4, 4, 4, class_agk.r.S(), class_agk.r.S(), false);
         this.a(var1, var3, 1, 4, 1, 3, 4, 3, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, class_agk.e.S(), 0, 1, 0, var3);
         this.a(var1, class_agk.e.S(), 0, 2, 0, var3);
         this.a(var1, class_agk.e.S(), 0, 3, 0, var3);
         this.a(var1, class_agk.e.S(), 4, 1, 0, var3);
         this.a(var1, class_agk.e.S(), 4, 2, 0, var3);
         this.a(var1, class_agk.e.S(), 4, 3, 0, var3);
         this.a(var1, class_agk.e.S(), 0, 1, 4, var3);
         this.a(var1, class_agk.e.S(), 0, 2, 4, var3);
         this.a(var1, class_agk.e.S(), 0, 3, 4, var3);
         this.a(var1, class_agk.e.S(), 4, 1, 4, var3);
         this.a(var1, class_agk.e.S(), 4, 2, 4, var3);
         this.a(var1, class_agk.e.S(), 4, 3, 4, var3);
         this.a(var1, var3, 0, 1, 1, 0, 3, 3, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 4, 1, 1, 4, 3, 3, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, var3, 1, 1, 4, 3, 3, 4, class_agk.f.S(), class_agk.f.S(), false);
         this.a(var1, class_agk.bj.S(), 0, 2, 2, var3);
         this.a(var1, class_agk.bj.S(), 2, 2, 4, var3);
         this.a(var1, class_agk.bj.S(), 4, 2, 2, var3);
         this.a(var1, class_agk.f.S(), 1, 1, 0, var3);
         this.a(var1, class_agk.f.S(), 1, 2, 0, var3);
         this.a(var1, class_agk.f.S(), 1, 3, 0, var3);
         this.a(var1, class_agk.f.S(), 2, 3, 0, var3);
         this.a(var1, class_agk.f.S(), 3, 3, 0, var3);
         this.a(var1, class_agk.f.S(), 3, 2, 0, var3);
         this.a(var1, class_agk.f.S(), 3, 1, 0, var3);
         if(this.a(var1, 2, 0, -1, var3).c().v() == class_atk.a && this.a(var1, 2, -1, -1, var3).c().v() != class_atk.a) {
            this.a(var1, class_agk.aw.S().a(class_ald.a, class_cq.c), 2, 0, -1, var3);
         }

         this.a(var1, var3, 1, 1, 1, 3, 3, 3, class_agk.a.S(), class_agk.a.S(), false);
         if(this.a) {
            this.a(var1, class_agk.aO.S(), 0, 5, 0, var3);
            this.a(var1, class_agk.aO.S(), 1, 5, 0, var3);
            this.a(var1, class_agk.aO.S(), 2, 5, 0, var3);
            this.a(var1, class_agk.aO.S(), 3, 5, 0, var3);
            this.a(var1, class_agk.aO.S(), 4, 5, 0, var3);
            this.a(var1, class_agk.aO.S(), 0, 5, 4, var3);
            this.a(var1, class_agk.aO.S(), 1, 5, 4, var3);
            this.a(var1, class_agk.aO.S(), 2, 5, 4, var3);
            this.a(var1, class_agk.aO.S(), 3, 5, 4, var3);
            this.a(var1, class_agk.aO.S(), 4, 5, 4, var3);
            this.a(var1, class_agk.aO.S(), 4, 5, 1, var3);
            this.a(var1, class_agk.aO.S(), 4, 5, 2, var3);
            this.a(var1, class_agk.aO.S(), 4, 5, 3, var3);
            this.a(var1, class_agk.aO.S(), 0, 5, 1, var3);
            this.a(var1, class_agk.aO.S(), 0, 5, 2, var3);
            this.a(var1, class_agk.aO.S(), 0, 5, 3, var3);
         }

         if(this.a) {
            class_anl var4 = class_agk.au.S().a(class_aiz.a, class_cq.d);
            this.a(var1, var4, 3, 1, 3, var3);
            this.a(var1, var4, 3, 2, 3, var3);
            this.a(var1, var4, 3, 3, 3, var3);
            this.a(var1, var4, 3, 4, 3, var3);
         }

         this.a(var1, class_agk.aa.S().a(class_alp.a, class_cq.c), 2, 3, 1, var3);

         for(int var6 = 0; var6 < 5; ++var6) {
            for(int var5 = 0; var5 < 5; ++var5) {
               this.b(var1, var5, 6, var6, var3);
               this.b(var1, class_agk.e.S(), var5, -1, var6, var3);
            }
         }

         this.a(var1, var3, 1, 1, 2, 1);
         return true;
      }
   }

   public static class class_l_in_class_asr extends class_asr.class_o_in_class_asr {
      private int a;

      public class_l_in_class_asr() {
      }

      public class_l_in_class_asr(class_asr.class_k_in_class_asr var1, int var2, Random var3, class_arw var4, class_cq var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
         this.a = Math.max(var4.c(), var4.e());
      }

      protected void a(class_dn var1) {
         super.a(var1);
         var1.a("Length", this.a);
      }

      protected void b(class_dn var1) {
         super.b(var1);
         this.a = var1.g("Length");
      }

      public void a(class_asn var1, List var2, Random var3) {
         boolean var4 = false;

         int var5;
         class_asn var6;
         for(var5 = var3.nextInt(5); var5 < this.a - 8; var5 += 2 + var3.nextInt(5)) {
            var6 = this.a((class_asr.class_k_in_class_asr)var1, var2, var3, 0, var5);
            if(var6 != null) {
               var5 += Math.max(var6.l.c(), var6.l.e());
               var4 = true;
            }
         }

         for(var5 = var3.nextInt(5); var5 < this.a - 8; var5 += 2 + var3.nextInt(5)) {
            var6 = this.b((class_asr.class_k_in_class_asr)var1, var2, var3, 0, var5);
            if(var6 != null) {
               var5 += Math.max(var6.l.c(), var6.l.e());
               var4 = true;
            }
         }

         class_cq var7 = this.e();
         if(var4 && var3.nextInt(3) > 0 && var7 != null) {
            switch(class_asr.SyntheticClass_1.a[var7.ordinal()]) {
            case 1:
               class_asr.e((class_asr.class_k_in_class_asr)var1, var2, var3, this.l.a - 1, this.l.b, this.l.c, class_cq.e, this.d());
               break;
            case 2:
               class_asr.e((class_asr.class_k_in_class_asr)var1, var2, var3, this.l.a - 1, this.l.b, this.l.f - 2, class_cq.e, this.d());
               break;
            case 3:
               class_asr.e((class_asr.class_k_in_class_asr)var1, var2, var3, this.l.a, this.l.b, this.l.c - 1, class_cq.c, this.d());
               break;
            case 4:
               class_asr.e((class_asr.class_k_in_class_asr)var1, var2, var3, this.l.d - 2, this.l.b, this.l.c - 1, class_cq.c, this.d());
            }
         }

         if(var4 && var3.nextInt(3) > 0 && var7 != null) {
            switch(class_asr.SyntheticClass_1.a[var7.ordinal()]) {
            case 1:
               class_asr.e((class_asr.class_k_in_class_asr)var1, var2, var3, this.l.d + 1, this.l.b, this.l.c, class_cq.f, this.d());
               break;
            case 2:
               class_asr.e((class_asr.class_k_in_class_asr)var1, var2, var3, this.l.d + 1, this.l.b, this.l.f - 2, class_cq.f, this.d());
               break;
            case 3:
               class_asr.e((class_asr.class_k_in_class_asr)var1, var2, var3, this.l.a, this.l.b, this.l.f + 1, class_cq.d, this.d());
               break;
            case 4:
               class_asr.e((class_asr.class_k_in_class_asr)var1, var2, var3, this.l.d - 2, this.l.b, this.l.f + 1, class_cq.d, this.d());
            }
         }

      }

      public static class_arw a(class_asr.class_k_in_class_asr var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6) {
         for(int var7 = 7 * class_nu.a((Random)var2, 3, 5); var7 >= 7; var7 -= 7) {
            class_arw var8 = class_arw.a(var3, var4, var5, 0, 0, 0, 3, 3, var7, var6);
            if(class_asn.a(var1, var8) == null) {
               return var8;
            }
         }

         return null;
      }

      public boolean a(class_aen var1, Random var2, class_arw var3) {
         class_anl var4 = this.a(class_agk.n.S());
         class_anl var5 = this.a(class_agk.e.S());

         for(int var6 = this.l.a; var6 <= this.l.d; ++var6) {
            for(int var7 = this.l.c; var7 <= this.l.f; ++var7) {
               class_cj var8 = new class_cj(var6, 64, var7);
               if(var3.b((class_df)var8)) {
                  var8 = var1.r(var8).b();
                  var1.a((class_cj)var8, (class_anl)var4, 2);
                  var1.a((class_cj)var8.b(), (class_anl)var5, 2);
               }
            }
         }

         return true;
      }
   }

   public abstract static class class_o_in_class_asr extends class_asr.class_n_in_class_asr {
      public class_o_in_class_asr() {
      }

      protected class_o_in_class_asr(class_asr.class_k_in_class_asr var1, int var2) {
         super(var1, var2);
      }
   }

   public static class class_k_in_class_asr extends class_asr.class_p_in_class_asr {
      public class_afd a;
      public boolean b;
      public int c;
      public class_asr.class_e_in_class_asr d;
      public List e;
      public List f = Lists.newArrayList();
      public List g = Lists.newArrayList();

      public class_k_in_class_asr() {
      }

      public class_k_in_class_asr(class_afd var1, int var2, Random var3, int var4, int var5, List var6, int var7) {
         super((class_asr.class_k_in_class_asr)null, 0, var3, var4, var5);
         this.a = var1;
         this.e = var6;
         this.c = var7;
         class_aez var8 = var1.a(new class_cj(var4, 0, var5), class_aez.ad);
         this.b = var8 == class_aez.r || var8 == class_aez.G;
         this.a(this.b);
      }

      public class_afd h() {
         return this.a;
      }
   }

   public static class class_p_in_class_asr extends class_asr.class_n_in_class_asr {
      public class_p_in_class_asr() {
      }

      public class_p_in_class_asr(class_asr.class_k_in_class_asr var1, int var2, Random var3, int var4, int var5) {
         super(var1, var2);
         this.a(class_cq.class_c_in_class_cq.a.a(var3));
         if(this.e().k() == class_cq.class_a_in_class_cq.c) {
            this.l = new class_arw(var4, 64, var5, var4 + 6 - 1, 78, var5 + 6 - 1);
         } else {
            this.l = new class_arw(var4, 64, var5, var4 + 6 - 1, 78, var5 + 6 - 1);
         }

      }

      public void a(class_asn var1, List var2, Random var3) {
         class_asr.e((class_asr.class_k_in_class_asr)var1, var2, var3, this.l.a - 1, this.l.e - 4, this.l.c + 1, class_cq.e, this.d());
         class_asr.e((class_asr.class_k_in_class_asr)var1, var2, var3, this.l.d + 1, this.l.e - 4, this.l.c + 1, class_cq.f, this.d());
         class_asr.e((class_asr.class_k_in_class_asr)var1, var2, var3, this.l.a + 1, this.l.e - 4, this.l.c - 1, class_cq.c, this.d());
         class_asr.e((class_asr.class_k_in_class_asr)var1, var2, var3, this.l.a + 1, this.l.e - 4, this.l.f + 1, class_cq.d, this.d());
      }

      public boolean a(class_aen var1, Random var2, class_arw var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 3, 0);
         }

         this.a(var1, var3, 1, 0, 1, 4, 12, 4, class_agk.e.S(), class_agk.i.S(), false);
         this.a(var1, class_agk.a.S(), 2, 12, 2, var3);
         this.a(var1, class_agk.a.S(), 3, 12, 2, var3);
         this.a(var1, class_agk.a.S(), 2, 12, 3, var3);
         this.a(var1, class_agk.a.S(), 3, 12, 3, var3);
         this.a(var1, class_agk.aO.S(), 1, 13, 1, var3);
         this.a(var1, class_agk.aO.S(), 1, 14, 1, var3);
         this.a(var1, class_agk.aO.S(), 4, 13, 1, var3);
         this.a(var1, class_agk.aO.S(), 4, 14, 1, var3);
         this.a(var1, class_agk.aO.S(), 1, 13, 4, var3);
         this.a(var1, class_agk.aO.S(), 1, 14, 4, var3);
         this.a(var1, class_agk.aO.S(), 4, 13, 4, var3);
         this.a(var1, class_agk.aO.S(), 4, 14, 4, var3);
         this.a(var1, var3, 1, 15, 1, 4, 15, 4, class_agk.e.S(), class_agk.e.S(), false);

         for(int var4 = 0; var4 <= 5; ++var4) {
            for(int var5 = 0; var5 <= 5; ++var5) {
               if(var5 == 0 || var5 == 5 || var4 == 0 || var4 == 5) {
                  this.a(var1, class_agk.n.S(), var5, 11, var4, var3);
                  this.b(var1, var5, 12, var4, var3);
               }
            }
         }

         return true;
      }
   }

   abstract static class class_n_in_class_asr extends class_asn {
      protected int h = -1;
      private int a;
      private boolean b;

      public class_n_in_class_asr() {
      }

      protected class_n_in_class_asr(class_asr.class_k_in_class_asr var1, int var2) {
         super(var2);
         if(var1 != null) {
            this.b = var1.b;
         }

      }

      protected void a(class_dn var1) {
         var1.a("HPos", this.h);
         var1.a("VCount", this.a);
         var1.a("Desert", this.b);
      }

      protected void b(class_dn var1) {
         this.h = var1.g("HPos");
         this.a = var1.g("VCount");
         this.b = var1.o("Desert");
      }

      protected class_asn a(class_asr.class_k_in_class_asr var1, List var2, Random var3, int var4, int var5) {
         class_cq var6 = this.e();
         if(var6 != null) {
            switch(class_asr.SyntheticClass_1.a[var6.ordinal()]) {
            case 1:
               return class_asr.d(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, class_cq.e, this.d());
            case 2:
               return class_asr.d(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, class_cq.e, this.d());
            case 3:
               return class_asr.d(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, class_cq.c, this.d());
            case 4:
               return class_asr.d(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, class_cq.c, this.d());
            }
         }

         return null;
      }

      protected class_asn b(class_asr.class_k_in_class_asr var1, List var2, Random var3, int var4, int var5) {
         class_cq var6 = this.e();
         if(var6 != null) {
            switch(class_asr.SyntheticClass_1.a[var6.ordinal()]) {
            case 1:
               return class_asr.d(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, class_cq.f, this.d());
            case 2:
               return class_asr.d(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, class_cq.f, this.d());
            case 3:
               return class_asr.d(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, class_cq.d, this.d());
            case 4:
               return class_asr.d(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, class_cq.d, this.d());
            }
         }

         return null;
      }

      protected int b(class_aen var1, class_arw var2) {
         int var3 = 0;
         int var4 = 0;
         class_cj.class_a_in_class_cj var5 = new class_cj.class_a_in_class_cj();

         for(int var6 = this.l.c; var6 <= this.l.f; ++var6) {
            for(int var7 = this.l.a; var7 <= this.l.d; ++var7) {
               var5.c(var7, 64, var6);
               if(var2.b((class_df)var5)) {
                  var3 += Math.max(var1.r(var5).o(), var1.t.i());
                  ++var4;
               }
            }
         }

         if(var4 == 0) {
            return -1;
         } else {
            return var3 / var4;
         }
      }

      protected static boolean a(class_arw var0) {
         return var0 != null && var0.b > 10;
      }

      protected void a(class_aen var1, class_arw var2, int var3, int var4, int var5, int var6) {
         if(this.a < var6) {
            for(int var7 = this.a; var7 < var6; ++var7) {
               int var8 = this.a(var3 + var7, var5);
               int var9 = this.d(var4);
               int var10 = this.b(var3 + var7, var5);
               if(!var2.b((class_df)(new class_cj(var8, var9, var10)))) {
                  break;
               }

               ++this.a;
               class_wv var11 = new class_wv(var1);
               var11.b((double)var8 + 0.5D, (double)var9, (double)var10 + 0.5D, 0.0F, 0.0F);
               var11.a(var1.E(new class_cj(var11)), (class_qd)null);
               var11.m(this.c(var7, var11.cA()));
               var1.a((class_pr)var11);
            }

         }
      }

      protected int c(int var1, int var2) {
         return var2;
      }

      protected class_anl a(class_anl var1) {
         if(this.b) {
            if(var1.c() == class_agk.r || var1.c() == class_agk.s) {
               return class_agk.A.S();
            }

            if(var1.c() == class_agk.e) {
               return class_agk.A.a(class_akr.class_a_in_class_akr.a.a());
            }

            if(var1.c() == class_agk.f) {
               return class_agk.A.a(class_akr.class_a_in_class_akr.c.a());
            }

            if(var1.c() == class_agk.ad) {
               return class_agk.bO.S().a(class_ald.a, var1.b(class_ald.a));
            }

            if(var1.c() == class_agk.aw) {
               return class_agk.bO.S().a(class_ald.a, var1.b(class_ald.a));
            }

            if(var1.c() == class_agk.n) {
               return class_agk.A.S();
            }
         }

         return var1;
      }

      protected void a(class_aen var1, class_anl var2, int var3, int var4, int var5, class_arw var6) {
         class_anl var7 = this.a(var2);
         super.a(var1, var7, var3, var4, var5, var6);
      }

      protected void a(class_aen var1, class_arw var2, int var3, int var4, int var5, int var6, int var7, int var8, class_anl var9, class_anl var10, boolean var11) {
         class_anl var12 = this.a(var9);
         class_anl var13 = this.a(var10);
         super.a(var1, var2, var3, var4, var5, var6, var7, var8, var12, var13, var11);
      }

      protected void b(class_aen var1, class_anl var2, int var3, int var4, int var5, class_arw var6) {
         class_anl var7 = this.a(var2);
         super.b(var1, var7, var3, var4, var5, var6);
      }

      protected void a(boolean var1) {
         this.b = var1;
      }
   }

   public static class class_e_in_class_asr {
      public Class a;
      public final int b;
      public int c;
      public int d;

      public class_e_in_class_asr(Class var1, int var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.d = var3;
      }

      public boolean a(int var1) {
         return this.d == 0 || this.c < this.d;
      }

      public boolean a() {
         return this.d == 0 || this.c < this.d;
      }
   }
}
