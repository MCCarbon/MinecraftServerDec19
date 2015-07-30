package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_agf;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_akg;
import net.minecraft.server.class_alp;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amv;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_asl;
import net.minecraft.server.class_asn;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.BaseBlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_od;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vo;
import net.minecraft.server.class_zy;

public class class_asa {
   private static final List a;

   public static void a() {
      class_asl.a(class_asa.class_a_in_class_asa.class, "MSCorridor");
      class_asl.a(class_asa.class_b_in_class_asa.class, "MSCrossing");
      class_asl.a(class_asa.class_c_in_class_asa.class, "MSRoom");
      class_asl.a(class_asa.class_d_in_class_asa.class, "MSStairs");
   }

   private static class_asn a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
      int var7 = var1.nextInt(100);
      class_arw var8;
      if(var7 >= 80) {
         var8 = class_asa.class_b_in_class_asa.a(var0, var1, var2, var3, var4, var5);
         if(var8 != null) {
            return new class_asa.class_b_in_class_asa(var6, var1, var8, var5);
         }
      } else if(var7 >= 70) {
         var8 = class_asa.class_d_in_class_asa.a(var0, var1, var2, var3, var4, var5);
         if(var8 != null) {
            return new class_asa.class_d_in_class_asa(var6, var1, var8, var5);
         }
      } else {
         var8 = class_asa.class_a_in_class_asa.a(var0, var1, var2, var3, var4, var5);
         if(var8 != null) {
            return new class_asa.class_a_in_class_asa(var6, var1, var8, var5);
         }
      }

      return null;
   }

   private static class_asn b(class_asn var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
      if(var7 > 8) {
         return null;
      } else if(Math.abs(var3 - var0.c().a) <= 80 && Math.abs(var5 - var0.c().c) <= 80) {
         class_asn var8 = a(var1, var2, var3, var4, var5, var6, var7 + 1);
         if(var8 != null) {
            var1.add(var8);
            var8.a(var0, var1, var2);
         }

         return var8;
      } else {
         return null;
      }
   }

   static {
      a = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.l, 0, 1, 5, 10), new class_od(Items.m, 0, 1, 3, 5), new class_od(Items.aE, 0, 4, 9, 5), new class_od(Items.aY, class_zy.l.b(), 4, 9, 5), new class_od(Items.k, 0, 1, 2, 3), new class_od(Items.j, 0, 3, 8, 10), new class_od(Items.R, 0, 1, 3, 15), new class_od(Items.b, 0, 1, 1, 1), new class_od(Item.getByBlock(Blocks.RAIL), 0, 4, 8, 1), new class_od(Items.bj, 0, 2, 4, 10), new class_od(Items.bi, 0, 2, 4, 10), new class_od(Items.aC, 0, 1, 1, 3), new class_od(Items.cn, 0, 1, 1, 1)}));
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumDirection.values().length];

      static {
         try {
            a[EnumDirection.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[EnumDirection.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static class class_d_in_class_asa extends class_asn {
      public class_d_in_class_asa() {
      }

      public class_d_in_class_asa(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      protected void a(class_dn var1) {
      }

      protected void b(class_dn var1) {
      }

      public static class_arw a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5) {
         class_arw var6 = new class_arw(var2, var3 - 5, var4, var2, var3 + 2, var4);
         switch(class_asa.SyntheticClass_1.a[var5.ordinal()]) {
         case 1:
            var6.d = var2 + 2;
            var6.c = var4 - 8;
            break;
         case 2:
            var6.d = var2 + 2;
            var6.f = var4 + 8;
            break;
         case 3:
            var6.a = var2 - 8;
            var6.f = var4 + 2;
            break;
         case 4:
            var6.d = var2 + 8;
            var6.f = var4 + 2;
         }

         return class_asn.a(var0, var6) != null?null:var6;
      }

      public void a(class_asn var1, List var2, Random var3) {
         int var4 = this.d();
         EnumDirection var5 = this.e();
         if(var5 != null) {
            switch(class_asa.SyntheticClass_1.a[var5.ordinal()]) {
            case 1:
               class_asa.b(var1, var2, var3, this.l.a, this.l.b, this.l.c - 1, EnumDirection.NORTH, var4);
               break;
            case 2:
               class_asa.b(var1, var2, var3, this.l.a, this.l.b, this.l.f + 1, EnumDirection.SOUTH, var4);
               break;
            case 3:
               class_asa.b(var1, var2, var3, this.l.a - 1, this.l.b, this.l.c, EnumDirection.WEST, var4);
               break;
            case 4:
               class_asa.b(var1, var2, var3, this.l.d + 1, this.l.b, this.l.c, EnumDirection.EAST, var4);
            }
         }

      }

      public boolean a(World var1, Random var2, class_arw var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 5, 0, 2, 7, 1, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(var1, var3, 0, 0, 7, 2, 2, 8, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);

            for(int var4 = 0; var4 < 5; ++var4) {
               this.a(var1, var3, 0, 5 - var4 - (var4 < 4?1:0), 2 + var4, 2, 7 - var4, 2 + var4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            }

            return true;
         }
      }
   }

   public static class class_b_in_class_asa extends class_asn {
      private EnumDirection a;
      private boolean b;

      public class_b_in_class_asa() {
      }

      protected void a(class_dn var1) {
         var1.a("tf", this.b);
         var1.a("D", this.a.getHorizontalId());
      }

      protected void b(class_dn var1) {
         this.b = var1.o("tf");
         this.a = EnumDirection.getByHorizontalId(var1.g("D"));
      }

      public class_b_in_class_asa(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a = var4;
         this.l = var3;
         this.b = var3.d() > 3;
      }

      public static class_arw a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5) {
         class_arw var6 = new class_arw(var2, var3, var4, var2, var3 + 2, var4);
         if(var1.nextInt(4) == 0) {
            var6.e += 4;
         }

         switch(class_asa.SyntheticClass_1.a[var5.ordinal()]) {
         case 1:
            var6.a = var2 - 1;
            var6.d = var2 + 3;
            var6.c = var4 - 4;
            break;
         case 2:
            var6.a = var2 - 1;
            var6.d = var2 + 3;
            var6.f = var4 + 4;
            break;
         case 3:
            var6.a = var2 - 4;
            var6.c = var4 - 1;
            var6.f = var4 + 3;
            break;
         case 4:
            var6.d = var2 + 4;
            var6.c = var4 - 1;
            var6.f = var4 + 3;
         }

         return class_asn.a(var0, var6) != null?null:var6;
      }

      public void a(class_asn var1, List var2, Random var3) {
         int var4 = this.d();
         switch(class_asa.SyntheticClass_1.a[this.a.ordinal()]) {
         case 1:
            class_asa.b(var1, var2, var3, this.l.a + 1, this.l.b, this.l.c - 1, EnumDirection.NORTH, var4);
            class_asa.b(var1, var2, var3, this.l.a - 1, this.l.b, this.l.c + 1, EnumDirection.WEST, var4);
            class_asa.b(var1, var2, var3, this.l.d + 1, this.l.b, this.l.c + 1, EnumDirection.EAST, var4);
            break;
         case 2:
            class_asa.b(var1, var2, var3, this.l.a + 1, this.l.b, this.l.f + 1, EnumDirection.SOUTH, var4);
            class_asa.b(var1, var2, var3, this.l.a - 1, this.l.b, this.l.c + 1, EnumDirection.WEST, var4);
            class_asa.b(var1, var2, var3, this.l.d + 1, this.l.b, this.l.c + 1, EnumDirection.EAST, var4);
            break;
         case 3:
            class_asa.b(var1, var2, var3, this.l.a + 1, this.l.b, this.l.c - 1, EnumDirection.NORTH, var4);
            class_asa.b(var1, var2, var3, this.l.a + 1, this.l.b, this.l.f + 1, EnumDirection.SOUTH, var4);
            class_asa.b(var1, var2, var3, this.l.a - 1, this.l.b, this.l.c + 1, EnumDirection.WEST, var4);
            break;
         case 4:
            class_asa.b(var1, var2, var3, this.l.a + 1, this.l.b, this.l.c - 1, EnumDirection.NORTH, var4);
            class_asa.b(var1, var2, var3, this.l.a + 1, this.l.b, this.l.f + 1, EnumDirection.SOUTH, var4);
            class_asa.b(var1, var2, var3, this.l.d + 1, this.l.b, this.l.c + 1, EnumDirection.EAST, var4);
         }

         if(this.b) {
            if(var3.nextBoolean()) {
               class_asa.b(var1, var2, var3, this.l.a + 1, this.l.b + 3 + 1, this.l.c - 1, EnumDirection.NORTH, var4);
            }

            if(var3.nextBoolean()) {
               class_asa.b(var1, var2, var3, this.l.a - 1, this.l.b + 3 + 1, this.l.c + 1, EnumDirection.WEST, var4);
            }

            if(var3.nextBoolean()) {
               class_asa.b(var1, var2, var3, this.l.d + 1, this.l.b + 3 + 1, this.l.c + 1, EnumDirection.EAST, var4);
            }

            if(var3.nextBoolean()) {
               class_asa.b(var1, var2, var3, this.l.a + 1, this.l.b + 3 + 1, this.l.f + 1, EnumDirection.SOUTH, var4);
            }
         }

      }

      public boolean a(World var1, Random var2, class_arw var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            if(this.b) {
               this.a(var1, var3, this.l.a + 1, this.l.b, this.l.c, this.l.d - 1, this.l.b + 3 - 1, this.l.f, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
               this.a(var1, var3, this.l.a, this.l.b, this.l.c + 1, this.l.d, this.l.b + 3 - 1, this.l.f - 1, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
               this.a(var1, var3, this.l.a + 1, this.l.e - 2, this.l.c, this.l.d - 1, this.l.e, this.l.f, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
               this.a(var1, var3, this.l.a, this.l.e - 2, this.l.c + 1, this.l.d, this.l.e, this.l.f - 1, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
               this.a(var1, var3, this.l.a + 1, this.l.b + 3, this.l.c + 1, this.l.d - 1, this.l.b + 3, this.l.f - 1, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            } else {
               this.a(var1, var3, this.l.a + 1, this.l.b, this.l.c, this.l.d - 1, this.l.e, this.l.f, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
               this.a(var1, var3, this.l.a, this.l.b, this.l.c + 1, this.l.d, this.l.e, this.l.f - 1, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            }

            this.a(var1, var3, this.l.a + 1, this.l.b, this.l.c + 1, this.l.a + 1, this.l.e, this.l.c + 1, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(var1, var3, this.l.a + 1, this.l.b, this.l.f - 1, this.l.a + 1, this.l.e, this.l.f - 1, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(var1, var3, this.l.d - 1, this.l.b, this.l.c + 1, this.l.d - 1, this.l.e, this.l.c + 1, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(var1, var3, this.l.d - 1, this.l.b, this.l.f - 1, this.l.d - 1, this.l.e, this.l.f - 1, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);

            for(int var4 = this.l.a; var4 <= this.l.d; ++var4) {
               for(int var5 = this.l.c; var5 <= this.l.f; ++var5) {
                  if(this.a(var1, var4, this.l.b - 1, var5, var3).getBlock().getMaterial() == Material.AIR) {
                     this.a(var1, Blocks.PLANKS.getBlockData(), var4, this.l.b - 1, var5, var3);
                  }
               }
            }

            return true;
         }
      }
   }

   public static class class_a_in_class_asa extends class_asn {
      private boolean a;
      private boolean b;
      private boolean c;
      private int d;

      public class_a_in_class_asa() {
      }

      protected void a(class_dn var1) {
         var1.a("hr", this.a);
         var1.a("sc", this.b);
         var1.a("hps", this.c);
         var1.a("Num", this.d);
      }

      protected void b(class_dn var1) {
         this.a = var1.o("hr");
         this.b = var1.o("sc");
         this.c = var1.o("hps");
         this.d = var1.g("Num");
      }

      public class_a_in_class_asa(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
         this.a = var2.nextInt(3) == 0;
         this.b = !this.a && var2.nextInt(23) == 0;
         if(this.e().getAxis() == EnumDirection.EnumAxis.Z) {
            this.d = var3.e() / 5;
         } else {
            this.d = var3.c() / 5;
         }

      }

      public static class_arw a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5) {
         class_arw var6 = new class_arw(var2, var3, var4, var2, var3 + 2, var4);

         int var7;
         for(var7 = var1.nextInt(3) + 2; var7 > 0; --var7) {
            int var8 = var7 * 5;
            switch(class_asa.SyntheticClass_1.a[var5.ordinal()]) {
            case 1:
               var6.d = var2 + 2;
               var6.c = var4 - (var8 - 1);
               break;
            case 2:
               var6.d = var2 + 2;
               var6.f = var4 + (var8 - 1);
               break;
            case 3:
               var6.a = var2 - (var8 - 1);
               var6.f = var4 + 2;
               break;
            case 4:
               var6.d = var2 + (var8 - 1);
               var6.f = var4 + 2;
            }

            if(class_asn.a(var0, var6) == null) {
               break;
            }
         }

         return var7 > 0?var6:null;
      }

      public void a(class_asn var1, List var2, Random var3) {
         int var4 = this.d();
         int var5 = var3.nextInt(4);
         EnumDirection var6 = this.e();
         if(var6 != null) {
            switch(class_asa.SyntheticClass_1.a[var6.ordinal()]) {
            case 1:
               if(var5 <= 1) {
                  class_asa.b(var1, var2, var3, this.l.a, this.l.b - 1 + var3.nextInt(3), this.l.c - 1, var6, var4);
               } else if(var5 == 2) {
                  class_asa.b(var1, var2, var3, this.l.a - 1, this.l.b - 1 + var3.nextInt(3), this.l.c, EnumDirection.WEST, var4);
               } else {
                  class_asa.b(var1, var2, var3, this.l.d + 1, this.l.b - 1 + var3.nextInt(3), this.l.c, EnumDirection.EAST, var4);
               }
               break;
            case 2:
               if(var5 <= 1) {
                  class_asa.b(var1, var2, var3, this.l.a, this.l.b - 1 + var3.nextInt(3), this.l.f + 1, var6, var4);
               } else if(var5 == 2) {
                  class_asa.b(var1, var2, var3, this.l.a - 1, this.l.b - 1 + var3.nextInt(3), this.l.f - 3, EnumDirection.WEST, var4);
               } else {
                  class_asa.b(var1, var2, var3, this.l.d + 1, this.l.b - 1 + var3.nextInt(3), this.l.f - 3, EnumDirection.EAST, var4);
               }
               break;
            case 3:
               if(var5 <= 1) {
                  class_asa.b(var1, var2, var3, this.l.a - 1, this.l.b - 1 + var3.nextInt(3), this.l.c, var6, var4);
               } else if(var5 == 2) {
                  class_asa.b(var1, var2, var3, this.l.a, this.l.b - 1 + var3.nextInt(3), this.l.c - 1, EnumDirection.NORTH, var4);
               } else {
                  class_asa.b(var1, var2, var3, this.l.a, this.l.b - 1 + var3.nextInt(3), this.l.f + 1, EnumDirection.SOUTH, var4);
               }
               break;
            case 4:
               if(var5 <= 1) {
                  class_asa.b(var1, var2, var3, this.l.d + 1, this.l.b - 1 + var3.nextInt(3), this.l.c, var6, var4);
               } else if(var5 == 2) {
                  class_asa.b(var1, var2, var3, this.l.d - 3, this.l.b - 1 + var3.nextInt(3), this.l.c - 1, EnumDirection.NORTH, var4);
               } else {
                  class_asa.b(var1, var2, var3, this.l.d - 3, this.l.b - 1 + var3.nextInt(3), this.l.f + 1, EnumDirection.SOUTH, var4);
               }
            }
         }

         if(var4 < 8) {
            int var7;
            int var8;
            if(var6 != EnumDirection.NORTH && var6 != EnumDirection.SOUTH) {
               for(var7 = this.l.a + 3; var7 + 3 <= this.l.d; var7 += 5) {
                  var8 = var3.nextInt(5);
                  if(var8 == 0) {
                     class_asa.b(var1, var2, var3, var7, this.l.b, this.l.c - 1, EnumDirection.NORTH, var4 + 1);
                  } else if(var8 == 1) {
                     class_asa.b(var1, var2, var3, var7, this.l.b, this.l.f + 1, EnumDirection.SOUTH, var4 + 1);
                  }
               }
            } else {
               for(var7 = this.l.c + 3; var7 + 3 <= this.l.f; var7 += 5) {
                  var8 = var3.nextInt(5);
                  if(var8 == 0) {
                     class_asa.b(var1, var2, var3, this.l.a - 1, this.l.b, var7, EnumDirection.WEST, var4 + 1);
                  } else if(var8 == 1) {
                     class_asa.b(var1, var2, var3, this.l.d + 1, this.l.b, var7, EnumDirection.EAST, var4 + 1);
                  }
               }
            }
         }

      }

      protected boolean a(World var1, class_arw var2, Random var3, int var4, int var5, int var6, List var7, int var8) {
         BlockPosition var9 = new BlockPosition(this.a(var4, var6), this.d(var5), this.b(var4, var6));
         if(var2.b((BaseBlockPosition)var9) && var1.p(var9).getBlock().getMaterial() == Material.AIR) {
            IBlockData var10 = Blocks.RAIL.getBlockData().set(class_akg.b, var3.nextBoolean()?class_agf.class_b_in_class_agf.a:class_agf.class_b_in_class_agf.b);
            this.a(var1, var10, var4, var5, var6, var2);
            class_vo var11 = new class_vo(var1, (double)((float)var9.getX() + 0.5F), (double)((float)var9.getY() + 0.5F), (double)((float)var9.getZ() + 0.5F));
            class_od.a(var3, var7, (class_oj)var11, var8);
            var1.a((class_pr)var11);
            return true;
         } else {
            return false;
         }
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            boolean var4 = false;
            boolean var5 = true;
            boolean var6 = false;
            boolean var7 = true;
            int var8 = this.d * 5 - 1;
            this.a(var1, var3, 0, 0, 0, 2, 1, var8, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(var1, var3, var2, 0.8F, 0, 2, 0, 2, 2, var8, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            if(this.b) {
               this.a(var1, var3, var2, 0.6F, 0, 0, 0, 2, 1, var8, Blocks.WEB.getBlockData(), Blocks.AIR.getBlockData(), false);
            }

            int var9;
            int var10;
            for(var9 = 0; var9 < this.d; ++var9) {
               var10 = 2 + var9 * 5;
               this.a(var1, var3, 0, 0, var10, 0, 1, var10, Blocks.FENCE.getBlockData(), Blocks.AIR.getBlockData(), false);
               this.a(var1, var3, 2, 0, var10, 2, 1, var10, Blocks.FENCE.getBlockData(), Blocks.AIR.getBlockData(), false);
               if(var2.nextInt(4) == 0) {
                  this.a(var1, var3, 0, 2, var10, 0, 2, var10, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);
                  this.a(var1, var3, 2, 2, var10, 2, 2, var10, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);
               } else {
                  this.a(var1, var3, 0, 2, var10, 2, 2, var10, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);
               }

               this.a(var1, var3, var2, 0.1F, 0, 2, var10 - 1, Blocks.WEB.getBlockData());
               this.a(var1, var3, var2, 0.1F, 2, 2, var10 - 1, Blocks.WEB.getBlockData());
               this.a(var1, var3, var2, 0.1F, 0, 2, var10 + 1, Blocks.WEB.getBlockData());
               this.a(var1, var3, var2, 0.1F, 2, 2, var10 + 1, Blocks.WEB.getBlockData());
               this.a(var1, var3, var2, 0.05F, 0, 2, var10 - 2, Blocks.WEB.getBlockData());
               this.a(var1, var3, var2, 0.05F, 2, 2, var10 - 2, Blocks.WEB.getBlockData());
               this.a(var1, var3, var2, 0.05F, 0, 2, var10 + 2, Blocks.WEB.getBlockData());
               this.a(var1, var3, var2, 0.05F, 2, 2, var10 + 2, Blocks.WEB.getBlockData());
               this.a(var1, var3, var2, 0.05F, 1, 2, var10 - 1, Blocks.TORCH.getBlockData().set(class_alp.a, EnumDirection.SOUTH));
               this.a(var1, var3, var2, 0.05F, 1, 2, var10 + 1, Blocks.TORCH.getBlockData().set(class_alp.a, EnumDirection.NORTH));
               if(var2.nextInt(100) == 0) {
                  this.a(var1, var3, var2, 2, 0, var10 - 1, class_od.a(class_asa.a, new class_od[]{Items.cg.b(var2)}), 3 + var2.nextInt(4));
               }

               if(var2.nextInt(100) == 0) {
                  this.a(var1, var3, var2, 0, 0, var10 + 1, class_od.a(class_asa.a, new class_od[]{Items.cg.b(var2)}), 3 + var2.nextInt(4));
               }

               if(this.b && !this.c) {
                  int var11 = this.d(0);
                  int var12 = var10 - 1 + var2.nextInt(3);
                  int var13 = this.a(1, var12);
                  var12 = this.b(1, var12);
                  BlockPosition var14 = new BlockPosition(var13, var11, var12);
                  if(var3.b((BaseBlockPosition)var14)) {
                     this.c = true;
                     var1.a((BlockPosition)var14, (IBlockData)Blocks.MOB_SPAWNER.getBlockData(), 2);
                     class_amg var15 = var1.s(var14);
                     if(var15 instanceof class_amv) {
                        ((class_amv)var15).b().a("CaveSpider");
                     }
                  }
               }
            }

            for(var9 = 0; var9 <= 2; ++var9) {
               for(var10 = 0; var10 <= var8; ++var10) {
                  byte var17 = -1;
                  IBlockData var19 = this.a(var1, var9, var17, var10, var3);
                  if(var19.getBlock().getMaterial() == Material.AIR) {
                     byte var20 = -1;
                     this.a(var1, Blocks.PLANKS.getBlockData(), var9, var20, var10, var3);
                  }
               }
            }

            if(this.a) {
               IBlockData var16 = Blocks.RAIL.getBlockData().set(class_akg.b, class_agf.class_b_in_class_agf.a);

               for(var10 = 0; var10 <= var8; ++var10) {
                  IBlockData var18 = this.a(var1, 1, -1, var10, var3);
                  if(var18.getBlock().getMaterial() != Material.AIR && var18.getBlock().isFullBlock()) {
                     this.a(var1, var3, var2, 0.7F, 1, 0, var10, var16);
                  }
               }
            }

            return true;
         }
      }
   }

   public static class class_c_in_class_asa extends class_asn {
      private List a = Lists.newLinkedList();

      public class_c_in_class_asa() {
      }

      public class_c_in_class_asa(int var1, Random var2, int var3, int var4) {
         super(var1);
         this.l = new class_arw(var3, 50, var4, var3 + 7 + var2.nextInt(6), 54 + var2.nextInt(6), var4 + 7 + var2.nextInt(6));
      }

      public void a(class_asn var1, List var2, Random var3) {
         int var4 = this.d();
         int var6 = this.l.d() - 3 - 1;
         if(var6 <= 0) {
            var6 = 1;
         }

         int var5;
         class_asn var7;
         class_arw var8;
         for(var5 = 0; var5 < this.l.c(); var5 += 4) {
            var5 += var3.nextInt(this.l.c());
            if(var5 + 3 > this.l.c()) {
               break;
            }

            var7 = class_asa.b(var1, var2, var3, this.l.a + var5, this.l.b + var3.nextInt(var6) + 1, this.l.c - 1, EnumDirection.NORTH, var4);
            if(var7 != null) {
               var8 = var7.c();
               this.a.add(new class_arw(var8.a, var8.b, this.l.c, var8.d, var8.e, this.l.c + 1));
            }
         }

         for(var5 = 0; var5 < this.l.c(); var5 += 4) {
            var5 += var3.nextInt(this.l.c());
            if(var5 + 3 > this.l.c()) {
               break;
            }

            var7 = class_asa.b(var1, var2, var3, this.l.a + var5, this.l.b + var3.nextInt(var6) + 1, this.l.f + 1, EnumDirection.SOUTH, var4);
            if(var7 != null) {
               var8 = var7.c();
               this.a.add(new class_arw(var8.a, var8.b, this.l.f - 1, var8.d, var8.e, this.l.f));
            }
         }

         for(var5 = 0; var5 < this.l.e(); var5 += 4) {
            var5 += var3.nextInt(this.l.e());
            if(var5 + 3 > this.l.e()) {
               break;
            }

            var7 = class_asa.b(var1, var2, var3, this.l.a - 1, this.l.b + var3.nextInt(var6) + 1, this.l.c + var5, EnumDirection.WEST, var4);
            if(var7 != null) {
               var8 = var7.c();
               this.a.add(new class_arw(this.l.a, var8.b, var8.c, this.l.a + 1, var8.e, var8.f));
            }
         }

         for(var5 = 0; var5 < this.l.e(); var5 += 4) {
            var5 += var3.nextInt(this.l.e());
            if(var5 + 3 > this.l.e()) {
               break;
            }

            var7 = class_asa.b(var1, var2, var3, this.l.d + 1, this.l.b + var3.nextInt(var6) + 1, this.l.c + var5, EnumDirection.EAST, var4);
            if(var7 != null) {
               var8 = var7.c();
               this.a.add(new class_arw(this.l.d - 1, var8.b, var8.c, this.l.d, var8.e, var8.f));
            }
         }

      }

      public boolean a(World var1, Random var2, class_arw var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, this.l.a, this.l.b, this.l.c, this.l.d, this.l.b, this.l.f, Blocks.DIRT.getBlockData(), Blocks.AIR.getBlockData(), true);
            this.a(var1, var3, this.l.a, this.l.b + 1, this.l.c, this.l.d, Math.min(this.l.b + 3, this.l.e), this.l.f, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            Iterator var4 = this.a.iterator();

            while(var4.hasNext()) {
               class_arw var5 = (class_arw)var4.next();
               this.a(var1, var3, var5.a, var5.e - 2, var5.c, var5.d, var5.e, var5.f, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            }

            this.a(var1, var3, this.l.a, this.l.b + 4, this.l.c, this.l.d, this.l.e, this.l.f, Blocks.AIR.getBlockData(), false);
            return true;
         }
      }

      public void a(int var1, int var2, int var3) {
         super.a(var1, var2, var3);
         Iterator var4 = this.a.iterator();

         while(var4.hasNext()) {
            class_arw var5 = (class_arw)var4.next();
            var5.a(var1, var2, var3);
         }

      }

      protected void a(class_dn var1) {
         class_du var2 = new class_du();
         Iterator var3 = this.a.iterator();

         while(var3.hasNext()) {
            class_arw var4 = (class_arw)var3.next();
            var2.a((class_eb)var4.g());
         }

         var1.a((String)"Entrances", (class_eb)var2);
      }

      protected void b(class_dn var1) {
         class_du var2 = var1.c("Entrances", 11);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            this.a.add(new class_arw(var2.d(var3)));
         }

      }
   }
}
