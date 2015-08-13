package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class WorldGenMonumetPieces {
   public static void a() {
      WorldGenFactory.a(WorldGenMonumetPieces.WorldGenMonumentPiece1.class, "OMB");
      WorldGenFactory.a(WorldGenMonumetPieces.WorldGenMonumentPiece2.class, "OMCR");
      WorldGenFactory.a(WorldGenMonumetPieces.WorldGenMonumentPiece3.class, "OMDXR");
      WorldGenFactory.a(WorldGenMonumetPieces.WorldGenMonumentPiece4.class, "OMDXYR");
      WorldGenFactory.a(WorldGenMonumetPieces.WorldGenMonumentPiece5.class, "OMDYR");
      WorldGenFactory.a(WorldGenMonumetPieces.WorldGenMonumentPiece6.class, "OMDYZR");
      WorldGenFactory.a(WorldGenMonumetPieces.WorldGenMonumentPiece7.class, "OMDZR");
      WorldGenFactory.a(WorldGenMonumetPieces.WorldGenMonumentPieceEntry.class, "OMEntry");
      WorldGenFactory.a(WorldGenMonumetPieces.WorldGenMonumentPiecePenthouse.class, "OMPenthouse");
      WorldGenFactory.a(WorldGenMonumetPieces.WorldGenMonumentPieceSimple.class, "OMSimple");
      WorldGenFactory.a(WorldGenMonumetPieces.WorldGenMonumentPieceSimpleT.class, "OMSimpleT");
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumDirection.values().length];

      static {
         try {
            a[EnumDirection.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   static class class_d_in_class_asf implements WorldGenMonumetPieces.class_i_in_class_asf {
      private class_d_in_class_asf() {
      }

      public boolean a(WorldGenMonumetPieces.class_v_in_class_asf var1) {
         if(var1.c[EnumDirection.NORTH.getId()] && !var1.b[EnumDirection.NORTH.getId()].d && var1.c[EnumDirection.UP.getId()] && !var1.b[EnumDirection.UP.getId()].d) {
            WorldGenMonumetPieces.class_v_in_class_asf var2 = var1.b[EnumDirection.NORTH.getId()];
            return var2.c[EnumDirection.UP.getId()] && !var2.b[EnumDirection.UP.getId()].d;
         } else {
            return false;
         }
      }

      public WorldGenMonumetPieces.class_r_in_class_asf a(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         var2.d = true;
         var2.b[EnumDirection.NORTH.getId()].d = true;
         var2.b[EnumDirection.UP.getId()].d = true;
         var2.b[EnumDirection.NORTH.getId()].b[EnumDirection.UP.getId()].d = true;
         return new WorldGenMonumetPieces.WorldGenMonumentPiece6(var1, var2, var3);
      }

      // $FF: synthetic method
      class_d_in_class_asf(WorldGenMonumetPieces.SyntheticClass_1 var1) {
         this();
      }
   }

   static class class_b_in_class_asf implements WorldGenMonumetPieces.class_i_in_class_asf {
      private class_b_in_class_asf() {
      }

      public boolean a(WorldGenMonumetPieces.class_v_in_class_asf var1) {
         if(var1.c[EnumDirection.EAST.getId()] && !var1.b[EnumDirection.EAST.getId()].d && var1.c[EnumDirection.UP.getId()] && !var1.b[EnumDirection.UP.getId()].d) {
            WorldGenMonumetPieces.class_v_in_class_asf var2 = var1.b[EnumDirection.EAST.getId()];
            return var2.c[EnumDirection.UP.getId()] && !var2.b[EnumDirection.UP.getId()].d;
         } else {
            return false;
         }
      }

      public WorldGenMonumetPieces.class_r_in_class_asf a(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         var2.d = true;
         var2.b[EnumDirection.EAST.getId()].d = true;
         var2.b[EnumDirection.UP.getId()].d = true;
         var2.b[EnumDirection.EAST.getId()].b[EnumDirection.UP.getId()].d = true;
         return new WorldGenMonumetPieces.WorldGenMonumentPiece4(var1, var2, var3);
      }

      // $FF: synthetic method
      class_b_in_class_asf(WorldGenMonumetPieces.SyntheticClass_1 var1) {
         this();
      }
   }

   static class class_e_in_class_asf implements WorldGenMonumetPieces.class_i_in_class_asf {
      private class_e_in_class_asf() {
      }

      public boolean a(WorldGenMonumetPieces.class_v_in_class_asf var1) {
         return var1.c[EnumDirection.NORTH.getId()] && !var1.b[EnumDirection.NORTH.getId()].d;
      }

      public WorldGenMonumetPieces.class_r_in_class_asf a(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         WorldGenMonumetPieces.class_v_in_class_asf var4 = var2;
         if(!var2.c[EnumDirection.NORTH.getId()] || var2.b[EnumDirection.NORTH.getId()].d) {
            var4 = var2.b[EnumDirection.SOUTH.getId()];
         }

         var4.d = true;
         var4.b[EnumDirection.NORTH.getId()].d = true;
         return new WorldGenMonumetPieces.WorldGenMonumentPiece7(var1, var4, var3);
      }

      // $FF: synthetic method
      class_e_in_class_asf(WorldGenMonumetPieces.SyntheticClass_1 var1) {
         this();
      }
   }

   static class class_a_in_class_asf implements WorldGenMonumetPieces.class_i_in_class_asf {
      private class_a_in_class_asf() {
      }

      public boolean a(WorldGenMonumetPieces.class_v_in_class_asf var1) {
         return var1.c[EnumDirection.EAST.getId()] && !var1.b[EnumDirection.EAST.getId()].d;
      }

      public WorldGenMonumetPieces.class_r_in_class_asf a(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         var2.d = true;
         var2.b[EnumDirection.EAST.getId()].d = true;
         return new WorldGenMonumetPieces.WorldGenMonumentPiece3(var1, var2, var3);
      }

      // $FF: synthetic method
      class_a_in_class_asf(WorldGenMonumetPieces.SyntheticClass_1 var1) {
         this();
      }
   }

   static class class_c_in_class_asf implements WorldGenMonumetPieces.class_i_in_class_asf {
      private class_c_in_class_asf() {
      }

      public boolean a(WorldGenMonumetPieces.class_v_in_class_asf var1) {
         return var1.c[EnumDirection.UP.getId()] && !var1.b[EnumDirection.UP.getId()].d;
      }

      public WorldGenMonumetPieces.class_r_in_class_asf a(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         var2.d = true;
         var2.b[EnumDirection.UP.getId()].d = true;
         return new WorldGenMonumetPieces.WorldGenMonumentPiece5(var1, var2, var3);
      }

      // $FF: synthetic method
      class_c_in_class_asf(WorldGenMonumetPieces.SyntheticClass_1 var1) {
         this();
      }
   }

   static class class_g_in_class_asf implements WorldGenMonumetPieces.class_i_in_class_asf {
      private class_g_in_class_asf() {
      }

      public boolean a(WorldGenMonumetPieces.class_v_in_class_asf var1) {
         return !var1.c[EnumDirection.WEST.getId()] && !var1.c[EnumDirection.EAST.getId()] && !var1.c[EnumDirection.NORTH.getId()] && !var1.c[EnumDirection.SOUTH.getId()] && !var1.c[EnumDirection.UP.getId()];
      }

      public WorldGenMonumetPieces.class_r_in_class_asf a(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         var2.d = true;
         return new WorldGenMonumetPieces.WorldGenMonumentPieceSimpleT(var1, var2, var3);
      }

      // $FF: synthetic method
      class_g_in_class_asf(WorldGenMonumetPieces.SyntheticClass_1 var1) {
         this();
      }
   }

   static class class_f_in_class_asf implements WorldGenMonumetPieces.class_i_in_class_asf {
      private class_f_in_class_asf() {
      }

      public boolean a(WorldGenMonumetPieces.class_v_in_class_asf var1) {
         return true;
      }

      public WorldGenMonumetPieces.class_r_in_class_asf a(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         var2.d = true;
         return new WorldGenMonumetPieces.WorldGenMonumentPieceSimple(var1, var2, var3);
      }

      // $FF: synthetic method
      class_f_in_class_asf(WorldGenMonumetPieces.SyntheticClass_1 var1) {
         this();
      }
   }

   interface class_i_in_class_asf {
      boolean a(WorldGenMonumetPieces.class_v_in_class_asf var1);

      WorldGenMonumetPieces.class_r_in_class_asf a(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3);
   }

   static class class_v_in_class_asf {
      int a;
      WorldGenMonumetPieces.class_v_in_class_asf[] b = new WorldGenMonumetPieces.class_v_in_class_asf[6];
      boolean[] c = new boolean[6];
      boolean d;
      boolean e;
      int f;

      public class_v_in_class_asf(int var1) {
         this.a = var1;
      }

      public void a(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2) {
         this.b[var1.getId()] = var2;
         var2.b[var1.opposite().getId()] = this;
      }

      public void a() {
         for(int var1 = 0; var1 < 6; ++var1) {
            this.c[var1] = this.b[var1] != null;
         }

      }

      public boolean a(int var1) {
         if(this.e) {
            return true;
         } else {
            this.f = var1;

            for(int var2 = 0; var2 < 6; ++var2) {
               if(this.b[var2] != null && this.c[var2] && this.b[var2].f != var1 && this.b[var2].a(var1)) {
                  return true;
               }
            }

            return false;
         }
      }

      public boolean b() {
         return this.a >= 75;
      }

      public int c() {
         int var1 = 0;

         for(int var2 = 0; var2 < 6; ++var2) {
            if(this.c[var2]) {
               ++var1;
            }
         }

         return var1;
      }
   }

   public static class WorldGenMonumentPiecePenthouse extends WorldGenMonumetPieces.class_r_in_class_asf {
      public WorldGenMonumentPiecePenthouse() {
      }

      public WorldGenMonumentPiecePenthouse(EnumDirection var1, StructureBoundingBox var2) {
         super(var1, var2);
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         this.a(var1, var3, 2, -1, 2, 11, -1, 11, b, b, false);
         this.a(var1, var3, 0, -1, 0, 1, -1, 11, a, a, false);
         this.a(var1, var3, 12, -1, 0, 13, -1, 11, a, a, false);
         this.a(var1, var3, 2, -1, 0, 11, -1, 1, a, a, false);
         this.a(var1, var3, 2, -1, 12, 11, -1, 13, a, a, false);
         this.a(var1, var3, 0, 0, 0, 0, 0, 13, b, b, false);
         this.a(var1, var3, 13, 0, 0, 13, 0, 13, b, b, false);
         this.a(var1, var3, 1, 0, 0, 12, 0, 0, b, b, false);
         this.a(var1, var3, 1, 0, 13, 12, 0, 13, b, b, false);

         for(int var4 = 2; var4 <= 11; var4 += 3) {
            this.a(var1, e, 0, 0, var4, var3);
            this.a(var1, e, 13, 0, var4, var3);
            this.a(var1, e, var4, 0, 0, var3);
         }

         this.a(var1, var3, 2, 0, 3, 4, 0, 9, b, b, false);
         this.a(var1, var3, 9, 0, 3, 11, 0, 9, b, b, false);
         this.a(var1, var3, 4, 0, 9, 9, 0, 11, b, b, false);
         this.a(var1, b, 5, 0, 8, var3);
         this.a(var1, b, 8, 0, 8, var3);
         this.a(var1, b, 10, 0, 10, var3);
         this.a(var1, b, 3, 0, 10, var3);
         this.a(var1, var3, 3, 0, 3, 3, 0, 7, c, c, false);
         this.a(var1, var3, 10, 0, 3, 10, 0, 7, c, c, false);
         this.a(var1, var3, 6, 0, 10, 7, 0, 10, c, c, false);
         byte var7 = 3;

         for(int var5 = 0; var5 < 2; ++var5) {
            for(int var6 = 2; var6 <= 8; var6 += 3) {
               this.a(var1, var3, var7, 0, var6, var7, 2, var6, b, b, false);
            }

            var7 = 10;
         }

         this.a(var1, var3, 5, 0, 10, 5, 2, 10, b, b, false);
         this.a(var1, var3, 8, 0, 10, 8, 2, 10, b, b, false);
         this.a(var1, var3, 6, -1, 7, 7, -1, 8, c, c, false);
         this.a(var1, var3, 6, -1, 3, 7, -1, 4, false);
         this.a(var1, var3, 6, 1, 6);
         return true;
      }
   }

   public static class class_u_in_class_asf extends WorldGenMonumetPieces.class_r_in_class_asf {
      private int n;

      public class_u_in_class_asf() {
      }

      public class_u_in_class_asf(EnumDirection var1, StructureBoundingBox var2, int var3) {
         super(var1, var2);
         this.n = var3 & 1;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.n == 0) {
            int var4;
            for(var4 = 0; var4 < 4; ++var4) {
               this.a(var1, var3, 10 - var4, 3 - var4, 20 - var4, 12 + var4, 3 - var4, 20, b, b, false);
            }

            this.a(var1, var3, 7, 0, 6, 15, 0, 16, b, b, false);
            this.a(var1, var3, 6, 0, 6, 6, 3, 20, b, b, false);
            this.a(var1, var3, 16, 0, 6, 16, 3, 20, b, b, false);
            this.a(var1, var3, 7, 1, 7, 7, 1, 20, b, b, false);
            this.a(var1, var3, 15, 1, 7, 15, 1, 20, b, b, false);
            this.a(var1, var3, 7, 1, 6, 9, 3, 6, b, b, false);
            this.a(var1, var3, 13, 1, 6, 15, 3, 6, b, b, false);
            this.a(var1, var3, 8, 1, 7, 9, 1, 7, b, b, false);
            this.a(var1, var3, 13, 1, 7, 14, 1, 7, b, b, false);
            this.a(var1, var3, 9, 0, 5, 13, 0, 5, b, b, false);
            this.a(var1, var3, 10, 0, 7, 12, 0, 7, c, c, false);
            this.a(var1, var3, 8, 0, 10, 8, 0, 12, c, c, false);
            this.a(var1, var3, 14, 0, 10, 14, 0, 12, c, c, false);

            for(var4 = 18; var4 >= 7; var4 -= 3) {
               this.a(var1, e, 6, 3, var4, var3);
               this.a(var1, e, 16, 3, var4, var3);
            }

            this.a(var1, e, 10, 0, 10, var3);
            this.a(var1, e, 12, 0, 10, var3);
            this.a(var1, e, 10, 0, 12, var3);
            this.a(var1, e, 12, 0, 12, var3);
            this.a(var1, e, 8, 3, 6, var3);
            this.a(var1, e, 14, 3, 6, var3);
            this.a(var1, b, 4, 2, 4, var3);
            this.a(var1, e, 4, 1, 4, var3);
            this.a(var1, b, 4, 0, 4, var3);
            this.a(var1, b, 18, 2, 4, var3);
            this.a(var1, e, 18, 1, 4, var3);
            this.a(var1, b, 18, 0, 4, var3);
            this.a(var1, b, 4, 2, 18, var3);
            this.a(var1, e, 4, 1, 18, var3);
            this.a(var1, b, 4, 0, 18, var3);
            this.a(var1, b, 18, 2, 18, var3);
            this.a(var1, e, 18, 1, 18, var3);
            this.a(var1, b, 18, 0, 18, var3);
            this.a(var1, b, 9, 7, 20, var3);
            this.a(var1, b, 13, 7, 20, var3);
            this.a(var1, var3, 6, 0, 21, 7, 4, 21, b, b, false);
            this.a(var1, var3, 15, 0, 21, 16, 4, 21, b, b, false);
            this.a(var1, var3, 11, 2, 16);
         } else if(this.n == 1) {
            this.a(var1, var3, 9, 3, 18, 13, 3, 20, b, b, false);
            this.a(var1, var3, 9, 0, 18, 9, 2, 18, b, b, false);
            this.a(var1, var3, 13, 0, 18, 13, 2, 18, b, b, false);
            byte var8 = 9;
            byte var5 = 20;
            byte var6 = 5;

            int var7;
            for(var7 = 0; var7 < 2; ++var7) {
               this.a(var1, b, var8, var6 + 1, var5, var3);
               this.a(var1, e, var8, var6, var5, var3);
               this.a(var1, b, var8, var6 - 1, var5, var3);
               var8 = 13;
            }

            this.a(var1, var3, 7, 3, 7, 15, 3, 14, b, b, false);
            var8 = 10;

            for(var7 = 0; var7 < 2; ++var7) {
               this.a(var1, var3, var8, 0, 10, var8, 6, 10, b, b, false);
               this.a(var1, var3, var8, 0, 12, var8, 6, 12, b, b, false);
               this.a(var1, e, var8, 0, 10, var3);
               this.a(var1, e, var8, 0, 12, var3);
               this.a(var1, e, var8, 4, 10, var3);
               this.a(var1, e, var8, 4, 12, var3);
               var8 = 12;
            }

            var8 = 8;

            for(var7 = 0; var7 < 2; ++var7) {
               this.a(var1, var3, var8, 0, 7, var8, 2, 7, b, b, false);
               this.a(var1, var3, var8, 0, 14, var8, 2, 14, b, b, false);
               var8 = 14;
            }

            this.a(var1, var3, 8, 3, 8, 8, 3, 13, c, c, false);
            this.a(var1, var3, 14, 3, 8, 14, 3, 13, c, c, false);
            this.a(var1, var3, 11, 5, 13);
         }

         return true;
      }
   }

   public static class WorldGenMonumentPiece2 extends WorldGenMonumetPieces.class_r_in_class_asf {
      public WorldGenMonumentPiece2() {
      }

      public WorldGenMonumentPiece2(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         super(1, var1, var2, 2, 2, 2);
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         this.a(var1, var3, 1, 8, 0, 14, 8, 14, a);
         byte var4 = 7;
         IBlockData var5 = b;
         this.a(var1, var3, 0, var4, 0, 0, var4, 15, var5, var5, false);
         this.a(var1, var3, 15, var4, 0, 15, var4, 15, var5, var5, false);
         this.a(var1, var3, 1, var4, 0, 15, var4, 0, var5, var5, false);
         this.a(var1, var3, 1, var4, 15, 14, var4, 15, var5, var5, false);

         int var7;
         for(var7 = 1; var7 <= 6; ++var7) {
            var5 = b;
            if(var7 == 2 || var7 == 6) {
               var5 = a;
            }

            for(int var6 = 0; var6 <= 15; var6 += 15) {
               this.a(var1, var3, var6, var7, 0, var6, var7, 1, var5, var5, false);
               this.a(var1, var3, var6, var7, 6, var6, var7, 9, var5, var5, false);
               this.a(var1, var3, var6, var7, 14, var6, var7, 15, var5, var5, false);
            }

            this.a(var1, var3, 1, var7, 0, 1, var7, 0, var5, var5, false);
            this.a(var1, var3, 6, var7, 0, 9, var7, 0, var5, var5, false);
            this.a(var1, var3, 14, var7, 0, 14, var7, 0, var5, var5, false);
            this.a(var1, var3, 1, var7, 15, 14, var7, 15, var5, var5, false);
         }

         this.a(var1, var3, 6, 3, 6, 9, 6, 9, c, c, false);
         this.a(var1, var3, 7, 4, 7, 8, 5, 8, Blocks.GOLD_BLOCK.getBlockData(), Blocks.GOLD_BLOCK.getBlockData(), false);

         for(var7 = 3; var7 <= 6; var7 += 3) {
            for(int var8 = 6; var8 <= 9; var8 += 3) {
               this.a(var1, e, var8, var7, 6, var3);
               this.a(var1, e, var8, var7, 9, var3);
            }
         }

         this.a(var1, var3, 5, 1, 6, 5, 2, 6, b, b, false);
         this.a(var1, var3, 5, 1, 9, 5, 2, 9, b, b, false);
         this.a(var1, var3, 10, 1, 6, 10, 2, 6, b, b, false);
         this.a(var1, var3, 10, 1, 9, 10, 2, 9, b, b, false);
         this.a(var1, var3, 6, 1, 5, 6, 2, 5, b, b, false);
         this.a(var1, var3, 9, 1, 5, 9, 2, 5, b, b, false);
         this.a(var1, var3, 6, 1, 10, 6, 2, 10, b, b, false);
         this.a(var1, var3, 9, 1, 10, 9, 2, 10, b, b, false);
         this.a(var1, var3, 5, 2, 5, 5, 6, 5, b, b, false);
         this.a(var1, var3, 5, 2, 10, 5, 6, 10, b, b, false);
         this.a(var1, var3, 10, 2, 5, 10, 6, 5, b, b, false);
         this.a(var1, var3, 10, 2, 10, 10, 6, 10, b, b, false);
         this.a(var1, var3, 5, 7, 1, 5, 7, 6, b, b, false);
         this.a(var1, var3, 10, 7, 1, 10, 7, 6, b, b, false);
         this.a(var1, var3, 5, 7, 9, 5, 7, 14, b, b, false);
         this.a(var1, var3, 10, 7, 9, 10, 7, 14, b, b, false);
         this.a(var1, var3, 1, 7, 5, 6, 7, 5, b, b, false);
         this.a(var1, var3, 1, 7, 10, 6, 7, 10, b, b, false);
         this.a(var1, var3, 9, 7, 5, 14, 7, 5, b, b, false);
         this.a(var1, var3, 9, 7, 10, 14, 7, 10, b, b, false);
         this.a(var1, var3, 2, 1, 2, 2, 1, 3, b, b, false);
         this.a(var1, var3, 3, 1, 2, 3, 1, 2, b, b, false);
         this.a(var1, var3, 13, 1, 2, 13, 1, 3, b, b, false);
         this.a(var1, var3, 12, 1, 2, 12, 1, 2, b, b, false);
         this.a(var1, var3, 2, 1, 12, 2, 1, 13, b, b, false);
         this.a(var1, var3, 3, 1, 13, 3, 1, 13, b, b, false);
         this.a(var1, var3, 13, 1, 12, 13, 1, 13, b, b, false);
         this.a(var1, var3, 12, 1, 13, 12, 1, 13, b, b, false);
         return true;
      }
   }

   public static class WorldGenMonumentPiece6 extends WorldGenMonumetPieces.class_r_in_class_asf {
      public WorldGenMonumentPiece6() {
      }

      public WorldGenMonumentPiece6(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         super(1, var1, var2, 1, 2, 2);
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         WorldGenMonumetPieces.class_v_in_class_asf var4 = this.k.b[EnumDirection.NORTH.getId()];
         WorldGenMonumetPieces.class_v_in_class_asf var5 = this.k;
         WorldGenMonumetPieces.class_v_in_class_asf var6 = var4.b[EnumDirection.UP.getId()];
         WorldGenMonumetPieces.class_v_in_class_asf var7 = var5.b[EnumDirection.UP.getId()];
         if(this.k.a / 25 > 0) {
            this.a(var1, var3, 0, 8, var4.c[EnumDirection.DOWN.getId()]);
            this.a(var1, var3, 0, 0, var5.c[EnumDirection.DOWN.getId()]);
         }

         if(var7.b[EnumDirection.UP.getId()] == null) {
            this.a(var1, var3, 1, 8, 1, 6, 8, 7, a);
         }

         if(var6.b[EnumDirection.UP.getId()] == null) {
            this.a(var1, var3, 1, 8, 8, 6, 8, 14, a);
         }

         int var8;
         IBlockData var9;
         for(var8 = 1; var8 <= 7; ++var8) {
            var9 = b;
            if(var8 == 2 || var8 == 6) {
               var9 = a;
            }

            this.a(var1, var3, 0, var8, 0, 0, var8, 15, var9, var9, false);
            this.a(var1, var3, 7, var8, 0, 7, var8, 15, var9, var9, false);
            this.a(var1, var3, 1, var8, 0, 6, var8, 0, var9, var9, false);
            this.a(var1, var3, 1, var8, 15, 6, var8, 15, var9, var9, false);
         }

         for(var8 = 1; var8 <= 7; ++var8) {
            var9 = c;
            if(var8 == 2 || var8 == 6) {
               var9 = e;
            }

            this.a(var1, var3, 3, var8, 7, 4, var8, 8, var9, var9, false);
         }

         if(var5.c[EnumDirection.SOUTH.getId()]) {
            this.a(var1, var3, 3, 1, 0, 4, 2, 0, false);
         }

         if(var5.c[EnumDirection.EAST.getId()]) {
            this.a(var1, var3, 7, 1, 3, 7, 2, 4, false);
         }

         if(var5.c[EnumDirection.WEST.getId()]) {
            this.a(var1, var3, 0, 1, 3, 0, 2, 4, false);
         }

         if(var4.c[EnumDirection.NORTH.getId()]) {
            this.a(var1, var3, 3, 1, 15, 4, 2, 15, false);
         }

         if(var4.c[EnumDirection.WEST.getId()]) {
            this.a(var1, var3, 0, 1, 11, 0, 2, 12, false);
         }

         if(var4.c[EnumDirection.EAST.getId()]) {
            this.a(var1, var3, 7, 1, 11, 7, 2, 12, false);
         }

         if(var7.c[EnumDirection.SOUTH.getId()]) {
            this.a(var1, var3, 3, 5, 0, 4, 6, 0, false);
         }

         if(var7.c[EnumDirection.EAST.getId()]) {
            this.a(var1, var3, 7, 5, 3, 7, 6, 4, false);
            this.a(var1, var3, 5, 4, 2, 6, 4, 5, b, b, false);
            this.a(var1, var3, 6, 1, 2, 6, 3, 2, b, b, false);
            this.a(var1, var3, 6, 1, 5, 6, 3, 5, b, b, false);
         }

         if(var7.c[EnumDirection.WEST.getId()]) {
            this.a(var1, var3, 0, 5, 3, 0, 6, 4, false);
            this.a(var1, var3, 1, 4, 2, 2, 4, 5, b, b, false);
            this.a(var1, var3, 1, 1, 2, 1, 3, 2, b, b, false);
            this.a(var1, var3, 1, 1, 5, 1, 3, 5, b, b, false);
         }

         if(var6.c[EnumDirection.NORTH.getId()]) {
            this.a(var1, var3, 3, 5, 15, 4, 6, 15, false);
         }

         if(var6.c[EnumDirection.WEST.getId()]) {
            this.a(var1, var3, 0, 5, 11, 0, 6, 12, false);
            this.a(var1, var3, 1, 4, 10, 2, 4, 13, b, b, false);
            this.a(var1, var3, 1, 1, 10, 1, 3, 10, b, b, false);
            this.a(var1, var3, 1, 1, 13, 1, 3, 13, b, b, false);
         }

         if(var6.c[EnumDirection.EAST.getId()]) {
            this.a(var1, var3, 7, 5, 11, 7, 6, 12, false);
            this.a(var1, var3, 5, 4, 10, 6, 4, 13, b, b, false);
            this.a(var1, var3, 6, 1, 10, 6, 3, 10, b, b, false);
            this.a(var1, var3, 6, 1, 13, 6, 3, 13, b, b, false);
         }

         return true;
      }
   }

   public static class WorldGenMonumentPiece4 extends WorldGenMonumetPieces.class_r_in_class_asf {
      public WorldGenMonumentPiece4() {
      }

      public WorldGenMonumentPiece4(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         super(1, var1, var2, 2, 2, 1);
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         WorldGenMonumetPieces.class_v_in_class_asf var4 = this.k.b[EnumDirection.EAST.getId()];
         WorldGenMonumetPieces.class_v_in_class_asf var5 = this.k;
         WorldGenMonumetPieces.class_v_in_class_asf var6 = var5.b[EnumDirection.UP.getId()];
         WorldGenMonumetPieces.class_v_in_class_asf var7 = var4.b[EnumDirection.UP.getId()];
         if(this.k.a / 25 > 0) {
            this.a(var1, var3, 8, 0, var4.c[EnumDirection.DOWN.getId()]);
            this.a(var1, var3, 0, 0, var5.c[EnumDirection.DOWN.getId()]);
         }

         if(var6.b[EnumDirection.UP.getId()] == null) {
            this.a(var1, var3, 1, 8, 1, 7, 8, 6, a);
         }

         if(var7.b[EnumDirection.UP.getId()] == null) {
            this.a(var1, var3, 8, 8, 1, 14, 8, 6, a);
         }

         for(int var8 = 1; var8 <= 7; ++var8) {
            IBlockData var9 = b;
            if(var8 == 2 || var8 == 6) {
               var9 = a;
            }

            this.a(var1, var3, 0, var8, 0, 0, var8, 7, var9, var9, false);
            this.a(var1, var3, 15, var8, 0, 15, var8, 7, var9, var9, false);
            this.a(var1, var3, 1, var8, 0, 15, var8, 0, var9, var9, false);
            this.a(var1, var3, 1, var8, 7, 14, var8, 7, var9, var9, false);
         }

         this.a(var1, var3, 2, 1, 3, 2, 7, 4, b, b, false);
         this.a(var1, var3, 3, 1, 2, 4, 7, 2, b, b, false);
         this.a(var1, var3, 3, 1, 5, 4, 7, 5, b, b, false);
         this.a(var1, var3, 13, 1, 3, 13, 7, 4, b, b, false);
         this.a(var1, var3, 11, 1, 2, 12, 7, 2, b, b, false);
         this.a(var1, var3, 11, 1, 5, 12, 7, 5, b, b, false);
         this.a(var1, var3, 5, 1, 3, 5, 3, 4, b, b, false);
         this.a(var1, var3, 10, 1, 3, 10, 3, 4, b, b, false);
         this.a(var1, var3, 5, 7, 2, 10, 7, 5, b, b, false);
         this.a(var1, var3, 5, 5, 2, 5, 7, 2, b, b, false);
         this.a(var1, var3, 10, 5, 2, 10, 7, 2, b, b, false);
         this.a(var1, var3, 5, 5, 5, 5, 7, 5, b, b, false);
         this.a(var1, var3, 10, 5, 5, 10, 7, 5, b, b, false);
         this.a(var1, b, 6, 6, 2, var3);
         this.a(var1, b, 9, 6, 2, var3);
         this.a(var1, b, 6, 6, 5, var3);
         this.a(var1, b, 9, 6, 5, var3);
         this.a(var1, var3, 5, 4, 3, 6, 4, 4, b, b, false);
         this.a(var1, var3, 9, 4, 3, 10, 4, 4, b, b, false);
         this.a(var1, e, 5, 4, 2, var3);
         this.a(var1, e, 5, 4, 5, var3);
         this.a(var1, e, 10, 4, 2, var3);
         this.a(var1, e, 10, 4, 5, var3);
         if(var5.c[EnumDirection.SOUTH.getId()]) {
            this.a(var1, var3, 3, 1, 0, 4, 2, 0, false);
         }

         if(var5.c[EnumDirection.NORTH.getId()]) {
            this.a(var1, var3, 3, 1, 7, 4, 2, 7, false);
         }

         if(var5.c[EnumDirection.WEST.getId()]) {
            this.a(var1, var3, 0, 1, 3, 0, 2, 4, false);
         }

         if(var4.c[EnumDirection.SOUTH.getId()]) {
            this.a(var1, var3, 11, 1, 0, 12, 2, 0, false);
         }

         if(var4.c[EnumDirection.NORTH.getId()]) {
            this.a(var1, var3, 11, 1, 7, 12, 2, 7, false);
         }

         if(var4.c[EnumDirection.EAST.getId()]) {
            this.a(var1, var3, 15, 1, 3, 15, 2, 4, false);
         }

         if(var6.c[EnumDirection.SOUTH.getId()]) {
            this.a(var1, var3, 3, 5, 0, 4, 6, 0, false);
         }

         if(var6.c[EnumDirection.NORTH.getId()]) {
            this.a(var1, var3, 3, 5, 7, 4, 6, 7, false);
         }

         if(var6.c[EnumDirection.WEST.getId()]) {
            this.a(var1, var3, 0, 5, 3, 0, 6, 4, false);
         }

         if(var7.c[EnumDirection.SOUTH.getId()]) {
            this.a(var1, var3, 11, 5, 0, 12, 6, 0, false);
         }

         if(var7.c[EnumDirection.NORTH.getId()]) {
            this.a(var1, var3, 11, 5, 7, 12, 6, 7, false);
         }

         if(var7.c[EnumDirection.EAST.getId()]) {
            this.a(var1, var3, 15, 5, 3, 15, 6, 4, false);
         }

         return true;
      }
   }

   public static class WorldGenMonumentPiece7 extends WorldGenMonumetPieces.class_r_in_class_asf {
      public WorldGenMonumentPiece7() {
      }

      public WorldGenMonumentPiece7(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         super(1, var1, var2, 1, 1, 2);
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         WorldGenMonumetPieces.class_v_in_class_asf var4 = this.k.b[EnumDirection.NORTH.getId()];
         WorldGenMonumetPieces.class_v_in_class_asf var5 = this.k;
         if(this.k.a / 25 > 0) {
            this.a(var1, var3, 0, 8, var4.c[EnumDirection.DOWN.getId()]);
            this.a(var1, var3, 0, 0, var5.c[EnumDirection.DOWN.getId()]);
         }

         if(var5.b[EnumDirection.UP.getId()] == null) {
            this.a(var1, var3, 1, 4, 1, 6, 4, 7, a);
         }

         if(var4.b[EnumDirection.UP.getId()] == null) {
            this.a(var1, var3, 1, 4, 8, 6, 4, 14, a);
         }

         this.a(var1, var3, 0, 3, 0, 0, 3, 15, b, b, false);
         this.a(var1, var3, 7, 3, 0, 7, 3, 15, b, b, false);
         this.a(var1, var3, 1, 3, 0, 7, 3, 0, b, b, false);
         this.a(var1, var3, 1, 3, 15, 6, 3, 15, b, b, false);
         this.a(var1, var3, 0, 2, 0, 0, 2, 15, a, a, false);
         this.a(var1, var3, 7, 2, 0, 7, 2, 15, a, a, false);
         this.a(var1, var3, 1, 2, 0, 7, 2, 0, a, a, false);
         this.a(var1, var3, 1, 2, 15, 6, 2, 15, a, a, false);
         this.a(var1, var3, 0, 1, 0, 0, 1, 15, b, b, false);
         this.a(var1, var3, 7, 1, 0, 7, 1, 15, b, b, false);
         this.a(var1, var3, 1, 1, 0, 7, 1, 0, b, b, false);
         this.a(var1, var3, 1, 1, 15, 6, 1, 15, b, b, false);
         this.a(var1, var3, 1, 1, 1, 1, 1, 2, b, b, false);
         this.a(var1, var3, 6, 1, 1, 6, 1, 2, b, b, false);
         this.a(var1, var3, 1, 3, 1, 1, 3, 2, b, b, false);
         this.a(var1, var3, 6, 3, 1, 6, 3, 2, b, b, false);
         this.a(var1, var3, 1, 1, 13, 1, 1, 14, b, b, false);
         this.a(var1, var3, 6, 1, 13, 6, 1, 14, b, b, false);
         this.a(var1, var3, 1, 3, 13, 1, 3, 14, b, b, false);
         this.a(var1, var3, 6, 3, 13, 6, 3, 14, b, b, false);
         this.a(var1, var3, 2, 1, 6, 2, 3, 6, b, b, false);
         this.a(var1, var3, 5, 1, 6, 5, 3, 6, b, b, false);
         this.a(var1, var3, 2, 1, 9, 2, 3, 9, b, b, false);
         this.a(var1, var3, 5, 1, 9, 5, 3, 9, b, b, false);
         this.a(var1, var3, 3, 2, 6, 4, 2, 6, b, b, false);
         this.a(var1, var3, 3, 2, 9, 4, 2, 9, b, b, false);
         this.a(var1, var3, 2, 2, 7, 2, 2, 8, b, b, false);
         this.a(var1, var3, 5, 2, 7, 5, 2, 8, b, b, false);
         this.a(var1, e, 2, 2, 5, var3);
         this.a(var1, e, 5, 2, 5, var3);
         this.a(var1, e, 2, 2, 10, var3);
         this.a(var1, e, 5, 2, 10, var3);
         this.a(var1, b, 2, 3, 5, var3);
         this.a(var1, b, 5, 3, 5, var3);
         this.a(var1, b, 2, 3, 10, var3);
         this.a(var1, b, 5, 3, 10, var3);
         if(var5.c[EnumDirection.SOUTH.getId()]) {
            this.a(var1, var3, 3, 1, 0, 4, 2, 0, false);
         }

         if(var5.c[EnumDirection.EAST.getId()]) {
            this.a(var1, var3, 7, 1, 3, 7, 2, 4, false);
         }

         if(var5.c[EnumDirection.WEST.getId()]) {
            this.a(var1, var3, 0, 1, 3, 0, 2, 4, false);
         }

         if(var4.c[EnumDirection.NORTH.getId()]) {
            this.a(var1, var3, 3, 1, 15, 4, 2, 15, false);
         }

         if(var4.c[EnumDirection.WEST.getId()]) {
            this.a(var1, var3, 0, 1, 11, 0, 2, 12, false);
         }

         if(var4.c[EnumDirection.EAST.getId()]) {
            this.a(var1, var3, 7, 1, 11, 7, 2, 12, false);
         }

         return true;
      }
   }

   public static class WorldGenMonumentPiece3 extends WorldGenMonumetPieces.class_r_in_class_asf {
      public WorldGenMonumentPiece3() {
      }

      public WorldGenMonumentPiece3(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         super(1, var1, var2, 2, 1, 1);
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         WorldGenMonumetPieces.class_v_in_class_asf var4 = this.k.b[EnumDirection.EAST.getId()];
         WorldGenMonumetPieces.class_v_in_class_asf var5 = this.k;
         if(this.k.a / 25 > 0) {
            this.a(var1, var3, 8, 0, var4.c[EnumDirection.DOWN.getId()]);
            this.a(var1, var3, 0, 0, var5.c[EnumDirection.DOWN.getId()]);
         }

         if(var5.b[EnumDirection.UP.getId()] == null) {
            this.a(var1, var3, 1, 4, 1, 7, 4, 6, a);
         }

         if(var4.b[EnumDirection.UP.getId()] == null) {
            this.a(var1, var3, 8, 4, 1, 14, 4, 6, a);
         }

         this.a(var1, var3, 0, 3, 0, 0, 3, 7, b, b, false);
         this.a(var1, var3, 15, 3, 0, 15, 3, 7, b, b, false);
         this.a(var1, var3, 1, 3, 0, 15, 3, 0, b, b, false);
         this.a(var1, var3, 1, 3, 7, 14, 3, 7, b, b, false);
         this.a(var1, var3, 0, 2, 0, 0, 2, 7, a, a, false);
         this.a(var1, var3, 15, 2, 0, 15, 2, 7, a, a, false);
         this.a(var1, var3, 1, 2, 0, 15, 2, 0, a, a, false);
         this.a(var1, var3, 1, 2, 7, 14, 2, 7, a, a, false);
         this.a(var1, var3, 0, 1, 0, 0, 1, 7, b, b, false);
         this.a(var1, var3, 15, 1, 0, 15, 1, 7, b, b, false);
         this.a(var1, var3, 1, 1, 0, 15, 1, 0, b, b, false);
         this.a(var1, var3, 1, 1, 7, 14, 1, 7, b, b, false);
         this.a(var1, var3, 5, 1, 0, 10, 1, 4, b, b, false);
         this.a(var1, var3, 6, 2, 0, 9, 2, 3, a, a, false);
         this.a(var1, var3, 5, 3, 0, 10, 3, 4, b, b, false);
         this.a(var1, e, 6, 2, 3, var3);
         this.a(var1, e, 9, 2, 3, var3);
         if(var5.c[EnumDirection.SOUTH.getId()]) {
            this.a(var1, var3, 3, 1, 0, 4, 2, 0, false);
         }

         if(var5.c[EnumDirection.NORTH.getId()]) {
            this.a(var1, var3, 3, 1, 7, 4, 2, 7, false);
         }

         if(var5.c[EnumDirection.WEST.getId()]) {
            this.a(var1, var3, 0, 1, 3, 0, 2, 4, false);
         }

         if(var4.c[EnumDirection.SOUTH.getId()]) {
            this.a(var1, var3, 11, 1, 0, 12, 2, 0, false);
         }

         if(var4.c[EnumDirection.NORTH.getId()]) {
            this.a(var1, var3, 11, 1, 7, 12, 2, 7, false);
         }

         if(var4.c[EnumDirection.EAST.getId()]) {
            this.a(var1, var3, 15, 1, 3, 15, 2, 4, false);
         }

         return true;
      }
   }

   public static class WorldGenMonumentPiece5 extends WorldGenMonumetPieces.class_r_in_class_asf {
      public WorldGenMonumentPiece5() {
      }

      public WorldGenMonumentPiece5(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         super(1, var1, var2, 1, 2, 1);
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.k.a / 25 > 0) {
            this.a(var1, var3, 0, 0, this.k.c[EnumDirection.DOWN.getId()]);
         }

         WorldGenMonumetPieces.class_v_in_class_asf var4 = this.k.b[EnumDirection.UP.getId()];
         if(var4.b[EnumDirection.UP.getId()] == null) {
            this.a(var1, var3, 1, 8, 1, 6, 8, 6, a);
         }

         this.a(var1, var3, 0, 4, 0, 0, 4, 7, b, b, false);
         this.a(var1, var3, 7, 4, 0, 7, 4, 7, b, b, false);
         this.a(var1, var3, 1, 4, 0, 6, 4, 0, b, b, false);
         this.a(var1, var3, 1, 4, 7, 6, 4, 7, b, b, false);
         this.a(var1, var3, 2, 4, 1, 2, 4, 2, b, b, false);
         this.a(var1, var3, 1, 4, 2, 1, 4, 2, b, b, false);
         this.a(var1, var3, 5, 4, 1, 5, 4, 2, b, b, false);
         this.a(var1, var3, 6, 4, 2, 6, 4, 2, b, b, false);
         this.a(var1, var3, 2, 4, 5, 2, 4, 6, b, b, false);
         this.a(var1, var3, 1, 4, 5, 1, 4, 5, b, b, false);
         this.a(var1, var3, 5, 4, 5, 5, 4, 6, b, b, false);
         this.a(var1, var3, 6, 4, 5, 6, 4, 5, b, b, false);
         WorldGenMonumetPieces.class_v_in_class_asf var5 = this.k;

         for(int var6 = 1; var6 <= 5; var6 += 4) {
            byte var7 = 0;
            if(var5.c[EnumDirection.SOUTH.getId()]) {
               this.a(var1, var3, 2, var6, var7, 2, var6 + 2, var7, b, b, false);
               this.a(var1, var3, 5, var6, var7, 5, var6 + 2, var7, b, b, false);
               this.a(var1, var3, 3, var6 + 2, var7, 4, var6 + 2, var7, b, b, false);
            } else {
               this.a(var1, var3, 0, var6, var7, 7, var6 + 2, var7, b, b, false);
               this.a(var1, var3, 0, var6 + 1, var7, 7, var6 + 1, var7, a, a, false);
            }

            var7 = 7;
            if(var5.c[EnumDirection.NORTH.getId()]) {
               this.a(var1, var3, 2, var6, var7, 2, var6 + 2, var7, b, b, false);
               this.a(var1, var3, 5, var6, var7, 5, var6 + 2, var7, b, b, false);
               this.a(var1, var3, 3, var6 + 2, var7, 4, var6 + 2, var7, b, b, false);
            } else {
               this.a(var1, var3, 0, var6, var7, 7, var6 + 2, var7, b, b, false);
               this.a(var1, var3, 0, var6 + 1, var7, 7, var6 + 1, var7, a, a, false);
            }

            byte var8 = 0;
            if(var5.c[EnumDirection.WEST.getId()]) {
               this.a(var1, var3, var8, var6, 2, var8, var6 + 2, 2, b, b, false);
               this.a(var1, var3, var8, var6, 5, var8, var6 + 2, 5, b, b, false);
               this.a(var1, var3, var8, var6 + 2, 3, var8, var6 + 2, 4, b, b, false);
            } else {
               this.a(var1, var3, var8, var6, 0, var8, var6 + 2, 7, b, b, false);
               this.a(var1, var3, var8, var6 + 1, 0, var8, var6 + 1, 7, a, a, false);
            }

            var8 = 7;
            if(var5.c[EnumDirection.EAST.getId()]) {
               this.a(var1, var3, var8, var6, 2, var8, var6 + 2, 2, b, b, false);
               this.a(var1, var3, var8, var6, 5, var8, var6 + 2, 5, b, b, false);
               this.a(var1, var3, var8, var6 + 2, 3, var8, var6 + 2, 4, b, b, false);
            } else {
               this.a(var1, var3, var8, var6, 0, var8, var6 + 2, 7, b, b, false);
               this.a(var1, var3, var8, var6 + 1, 0, var8, var6 + 1, 7, a, a, false);
            }

            var5 = var4;
         }

         return true;
      }
   }

   public static class WorldGenMonumentPieceSimpleT extends WorldGenMonumetPieces.class_r_in_class_asf {
      public WorldGenMonumentPieceSimpleT() {
      }

      public WorldGenMonumentPieceSimpleT(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         super(1, var1, var2, 1, 1, 1);
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.k.a / 25 > 0) {
            this.a(var1, var3, 0, 0, this.k.c[EnumDirection.DOWN.getId()]);
         }

         if(this.k.b[EnumDirection.UP.getId()] == null) {
            this.a(var1, var3, 1, 4, 1, 6, 4, 6, a);
         }

         for(int var4 = 1; var4 <= 6; ++var4) {
            for(int var5 = 1; var5 <= 6; ++var5) {
               if(var2.nextInt(3) != 0) {
                  int var6 = 2 + (var2.nextInt(4) == 0?0:1);
                  this.a(var1, var3, var4, var6, var5, var4, 3, var5, Blocks.SPONGE.fromLegacyData(1), Blocks.SPONGE.fromLegacyData(1), false);
               }
            }
         }

         this.a(var1, var3, 0, 1, 0, 0, 1, 7, b, b, false);
         this.a(var1, var3, 7, 1, 0, 7, 1, 7, b, b, false);
         this.a(var1, var3, 1, 1, 0, 6, 1, 0, b, b, false);
         this.a(var1, var3, 1, 1, 7, 6, 1, 7, b, b, false);
         this.a(var1, var3, 0, 2, 0, 0, 2, 7, c, c, false);
         this.a(var1, var3, 7, 2, 0, 7, 2, 7, c, c, false);
         this.a(var1, var3, 1, 2, 0, 6, 2, 0, c, c, false);
         this.a(var1, var3, 1, 2, 7, 6, 2, 7, c, c, false);
         this.a(var1, var3, 0, 3, 0, 0, 3, 7, b, b, false);
         this.a(var1, var3, 7, 3, 0, 7, 3, 7, b, b, false);
         this.a(var1, var3, 1, 3, 0, 6, 3, 0, b, b, false);
         this.a(var1, var3, 1, 3, 7, 6, 3, 7, b, b, false);
         this.a(var1, var3, 0, 1, 3, 0, 2, 4, c, c, false);
         this.a(var1, var3, 7, 1, 3, 7, 2, 4, c, c, false);
         this.a(var1, var3, 3, 1, 0, 4, 2, 0, c, c, false);
         this.a(var1, var3, 3, 1, 7, 4, 2, 7, c, c, false);
         if(this.k.c[EnumDirection.SOUTH.getId()]) {
            this.a(var1, var3, 3, 1, 0, 4, 2, 0, false);
         }

         return true;
      }
   }

   public static class WorldGenMonumentPieceSimple extends WorldGenMonumetPieces.class_r_in_class_asf {
      private int n;

      public WorldGenMonumentPieceSimple() {
      }

      public WorldGenMonumentPieceSimple(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2, Random var3) {
         super(1, var1, var2, 1, 1, 1);
         this.n = var3.nextInt(3);
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.k.a / 25 > 0) {
            this.a(var1, var3, 0, 0, this.k.c[EnumDirection.DOWN.getId()]);
         }

         if(this.k.b[EnumDirection.UP.getId()] == null) {
            this.a(var1, var3, 1, 4, 1, 6, 4, 6, a);
         }

         boolean var4 = this.n != 0 && var2.nextBoolean() && !this.k.c[EnumDirection.DOWN.getId()] && !this.k.c[EnumDirection.UP.getId()] && this.k.c() > 1;
         if(this.n == 0) {
            this.a(var1, var3, 0, 1, 0, 2, 1, 2, b, b, false);
            this.a(var1, var3, 0, 3, 0, 2, 3, 2, b, b, false);
            this.a(var1, var3, 0, 2, 0, 0, 2, 2, a, a, false);
            this.a(var1, var3, 1, 2, 0, 2, 2, 0, a, a, false);
            this.a(var1, e, 1, 2, 1, var3);
            this.a(var1, var3, 5, 1, 0, 7, 1, 2, b, b, false);
            this.a(var1, var3, 5, 3, 0, 7, 3, 2, b, b, false);
            this.a(var1, var3, 7, 2, 0, 7, 2, 2, a, a, false);
            this.a(var1, var3, 5, 2, 0, 6, 2, 0, a, a, false);
            this.a(var1, e, 6, 2, 1, var3);
            this.a(var1, var3, 0, 1, 5, 2, 1, 7, b, b, false);
            this.a(var1, var3, 0, 3, 5, 2, 3, 7, b, b, false);
            this.a(var1, var3, 0, 2, 5, 0, 2, 7, a, a, false);
            this.a(var1, var3, 1, 2, 7, 2, 2, 7, a, a, false);
            this.a(var1, e, 1, 2, 6, var3);
            this.a(var1, var3, 5, 1, 5, 7, 1, 7, b, b, false);
            this.a(var1, var3, 5, 3, 5, 7, 3, 7, b, b, false);
            this.a(var1, var3, 7, 2, 5, 7, 2, 7, a, a, false);
            this.a(var1, var3, 5, 2, 7, 6, 2, 7, a, a, false);
            this.a(var1, e, 6, 2, 6, var3);
            if(this.k.c[EnumDirection.SOUTH.getId()]) {
               this.a(var1, var3, 3, 3, 0, 4, 3, 0, b, b, false);
            } else {
               this.a(var1, var3, 3, 3, 0, 4, 3, 1, b, b, false);
               this.a(var1, var3, 3, 2, 0, 4, 2, 0, a, a, false);
               this.a(var1, var3, 3, 1, 0, 4, 1, 1, b, b, false);
            }

            if(this.k.c[EnumDirection.NORTH.getId()]) {
               this.a(var1, var3, 3, 3, 7, 4, 3, 7, b, b, false);
            } else {
               this.a(var1, var3, 3, 3, 6, 4, 3, 7, b, b, false);
               this.a(var1, var3, 3, 2, 7, 4, 2, 7, a, a, false);
               this.a(var1, var3, 3, 1, 6, 4, 1, 7, b, b, false);
            }

            if(this.k.c[EnumDirection.WEST.getId()]) {
               this.a(var1, var3, 0, 3, 3, 0, 3, 4, b, b, false);
            } else {
               this.a(var1, var3, 0, 3, 3, 1, 3, 4, b, b, false);
               this.a(var1, var3, 0, 2, 3, 0, 2, 4, a, a, false);
               this.a(var1, var3, 0, 1, 3, 1, 1, 4, b, b, false);
            }

            if(this.k.c[EnumDirection.EAST.getId()]) {
               this.a(var1, var3, 7, 3, 3, 7, 3, 4, b, b, false);
            } else {
               this.a(var1, var3, 6, 3, 3, 7, 3, 4, b, b, false);
               this.a(var1, var3, 7, 2, 3, 7, 2, 4, a, a, false);
               this.a(var1, var3, 6, 1, 3, 7, 1, 4, b, b, false);
            }
         } else if(this.n == 1) {
            this.a(var1, var3, 2, 1, 2, 2, 3, 2, b, b, false);
            this.a(var1, var3, 2, 1, 5, 2, 3, 5, b, b, false);
            this.a(var1, var3, 5, 1, 5, 5, 3, 5, b, b, false);
            this.a(var1, var3, 5, 1, 2, 5, 3, 2, b, b, false);
            this.a(var1, e, 2, 2, 2, var3);
            this.a(var1, e, 2, 2, 5, var3);
            this.a(var1, e, 5, 2, 5, var3);
            this.a(var1, e, 5, 2, 2, var3);
            this.a(var1, var3, 0, 1, 0, 1, 3, 0, b, b, false);
            this.a(var1, var3, 0, 1, 1, 0, 3, 1, b, b, false);
            this.a(var1, var3, 0, 1, 7, 1, 3, 7, b, b, false);
            this.a(var1, var3, 0, 1, 6, 0, 3, 6, b, b, false);
            this.a(var1, var3, 6, 1, 7, 7, 3, 7, b, b, false);
            this.a(var1, var3, 7, 1, 6, 7, 3, 6, b, b, false);
            this.a(var1, var3, 6, 1, 0, 7, 3, 0, b, b, false);
            this.a(var1, var3, 7, 1, 1, 7, 3, 1, b, b, false);
            this.a(var1, a, 1, 2, 0, var3);
            this.a(var1, a, 0, 2, 1, var3);
            this.a(var1, a, 1, 2, 7, var3);
            this.a(var1, a, 0, 2, 6, var3);
            this.a(var1, a, 6, 2, 7, var3);
            this.a(var1, a, 7, 2, 6, var3);
            this.a(var1, a, 6, 2, 0, var3);
            this.a(var1, a, 7, 2, 1, var3);
            if(!this.k.c[EnumDirection.SOUTH.getId()]) {
               this.a(var1, var3, 1, 3, 0, 6, 3, 0, b, b, false);
               this.a(var1, var3, 1, 2, 0, 6, 2, 0, a, a, false);
               this.a(var1, var3, 1, 1, 0, 6, 1, 0, b, b, false);
            }

            if(!this.k.c[EnumDirection.NORTH.getId()]) {
               this.a(var1, var3, 1, 3, 7, 6, 3, 7, b, b, false);
               this.a(var1, var3, 1, 2, 7, 6, 2, 7, a, a, false);
               this.a(var1, var3, 1, 1, 7, 6, 1, 7, b, b, false);
            }

            if(!this.k.c[EnumDirection.WEST.getId()]) {
               this.a(var1, var3, 0, 3, 1, 0, 3, 6, b, b, false);
               this.a(var1, var3, 0, 2, 1, 0, 2, 6, a, a, false);
               this.a(var1, var3, 0, 1, 1, 0, 1, 6, b, b, false);
            }

            if(!this.k.c[EnumDirection.EAST.getId()]) {
               this.a(var1, var3, 7, 3, 1, 7, 3, 6, b, b, false);
               this.a(var1, var3, 7, 2, 1, 7, 2, 6, a, a, false);
               this.a(var1, var3, 7, 1, 1, 7, 1, 6, b, b, false);
            }
         } else if(this.n == 2) {
            this.a(var1, var3, 0, 1, 0, 0, 1, 7, b, b, false);
            this.a(var1, var3, 7, 1, 0, 7, 1, 7, b, b, false);
            this.a(var1, var3, 1, 1, 0, 6, 1, 0, b, b, false);
            this.a(var1, var3, 1, 1, 7, 6, 1, 7, b, b, false);
            this.a(var1, var3, 0, 2, 0, 0, 2, 7, c, c, false);
            this.a(var1, var3, 7, 2, 0, 7, 2, 7, c, c, false);
            this.a(var1, var3, 1, 2, 0, 6, 2, 0, c, c, false);
            this.a(var1, var3, 1, 2, 7, 6, 2, 7, c, c, false);
            this.a(var1, var3, 0, 3, 0, 0, 3, 7, b, b, false);
            this.a(var1, var3, 7, 3, 0, 7, 3, 7, b, b, false);
            this.a(var1, var3, 1, 3, 0, 6, 3, 0, b, b, false);
            this.a(var1, var3, 1, 3, 7, 6, 3, 7, b, b, false);
            this.a(var1, var3, 0, 1, 3, 0, 2, 4, c, c, false);
            this.a(var1, var3, 7, 1, 3, 7, 2, 4, c, c, false);
            this.a(var1, var3, 3, 1, 0, 4, 2, 0, c, c, false);
            this.a(var1, var3, 3, 1, 7, 4, 2, 7, c, c, false);
            if(this.k.c[EnumDirection.SOUTH.getId()]) {
               this.a(var1, var3, 3, 1, 0, 4, 2, 0, false);
            }

            if(this.k.c[EnumDirection.NORTH.getId()]) {
               this.a(var1, var3, 3, 1, 7, 4, 2, 7, false);
            }

            if(this.k.c[EnumDirection.WEST.getId()]) {
               this.a(var1, var3, 0, 1, 3, 0, 2, 4, false);
            }

            if(this.k.c[EnumDirection.EAST.getId()]) {
               this.a(var1, var3, 7, 1, 3, 7, 2, 4, false);
            }
         }

         if(var4) {
            this.a(var1, var3, 3, 1, 3, 4, 1, 4, b, b, false);
            this.a(var1, var3, 3, 2, 3, 4, 2, 4, a, a, false);
            this.a(var1, var3, 3, 3, 3, 4, 3, 4, b, b, false);
         }

         return true;
      }
   }

   public static class WorldGenMonumentPieceEntry extends WorldGenMonumetPieces.class_r_in_class_asf {
      public WorldGenMonumentPieceEntry() {
      }

      public WorldGenMonumentPieceEntry(EnumDirection var1, WorldGenMonumetPieces.class_v_in_class_asf var2) {
         super(1, var1, var2, 1, 1, 1);
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         this.a(var1, var3, 0, 3, 0, 2, 3, 7, b, b, false);
         this.a(var1, var3, 5, 3, 0, 7, 3, 7, b, b, false);
         this.a(var1, var3, 0, 2, 0, 1, 2, 7, b, b, false);
         this.a(var1, var3, 6, 2, 0, 7, 2, 7, b, b, false);
         this.a(var1, var3, 0, 1, 0, 0, 1, 7, b, b, false);
         this.a(var1, var3, 7, 1, 0, 7, 1, 7, b, b, false);
         this.a(var1, var3, 0, 1, 7, 7, 3, 7, b, b, false);
         this.a(var1, var3, 1, 1, 0, 2, 3, 0, b, b, false);
         this.a(var1, var3, 5, 1, 0, 6, 3, 0, b, b, false);
         if(this.k.c[EnumDirection.NORTH.getId()]) {
            this.a(var1, var3, 3, 1, 7, 4, 2, 7, false);
         }

         if(this.k.c[EnumDirection.WEST.getId()]) {
            this.a(var1, var3, 0, 1, 3, 1, 2, 4, false);
         }

         if(this.k.c[EnumDirection.EAST.getId()]) {
            this.a(var1, var3, 6, 1, 3, 7, 2, 4, false);
         }

         return true;
      }
   }

   public static class WorldGenMonumentPiece1 extends WorldGenMonumetPieces.class_r_in_class_asf {
      private WorldGenMonumetPieces.class_v_in_class_asf n;
      private WorldGenMonumetPieces.class_v_in_class_asf o;
      private List p = Lists.newArrayList();

      public WorldGenMonumentPiece1() {
      }

      public WorldGenMonumentPiece1(Random var1, int var2, int var3, EnumDirection var4) {
         super(0);
         this.a(var4);
         EnumDirection var5 = this.e();
         if(var5.getAxis() == EnumDirection.EnumAxis.Z) {
            this.l = new StructureBoundingBox(var2, 39, var3, var2 + 58 - 1, 61, var3 + 58 - 1);
         } else {
            this.l = new StructureBoundingBox(var2, 39, var3, var2 + 58 - 1, 61, var3 + 58 - 1);
         }

         List var6 = this.a(var1);
         this.n.d = true;
         this.p.add(new WorldGenMonumetPieces.WorldGenMonumentPieceEntry(var5, this.n));
         this.p.add(new WorldGenMonumetPieces.WorldGenMonumentPiece2(var5, this.o, var1));
         ArrayList var7 = Lists.newArrayList();
         var7.add(new WorldGenMonumetPieces.class_b_in_class_asf((WorldGenMonumetPieces.SyntheticClass_1)null));
         var7.add(new WorldGenMonumetPieces.class_d_in_class_asf((WorldGenMonumetPieces.SyntheticClass_1)null));
         var7.add(new WorldGenMonumetPieces.class_e_in_class_asf((WorldGenMonumetPieces.SyntheticClass_1)null));
         var7.add(new WorldGenMonumetPieces.class_a_in_class_asf((WorldGenMonumetPieces.SyntheticClass_1)null));
         var7.add(new WorldGenMonumetPieces.class_c_in_class_asf((WorldGenMonumetPieces.SyntheticClass_1)null));
         var7.add(new WorldGenMonumetPieces.class_g_in_class_asf((WorldGenMonumetPieces.SyntheticClass_1)null));
         var7.add(new WorldGenMonumetPieces.class_f_in_class_asf((WorldGenMonumetPieces.SyntheticClass_1)null));
         Iterator var8 = var6.iterator();

         while(true) {
            while(true) {
               WorldGenMonumetPieces.class_v_in_class_asf var9;
               do {
                  do {
                     if(!var8.hasNext()) {
                        int var15 = this.l.minY;
                        int var16 = this.a(9, 22);
                        int var17 = this.b(9, 22);
                        Iterator var18 = this.p.iterator();

                        while(var18.hasNext()) {
                           WorldGenMonumetPieces.class_r_in_class_asf var12 = (WorldGenMonumetPieces.class_r_in_class_asf)var18.next();
                           var12.c().a(var16, var15, var17);
                        }

                        StructureBoundingBox var19 = StructureBoundingBox.create(this.a(1, 1), this.d(1), this.b(1, 1), this.a(23, 21), this.d(8), this.b(23, 21));
                        StructureBoundingBox var20 = StructureBoundingBox.create(this.a(34, 1), this.d(1), this.b(34, 1), this.a(56, 21), this.d(8), this.b(56, 21));
                        StructureBoundingBox var13 = StructureBoundingBox.create(this.a(22, 22), this.d(13), this.b(22, 22), this.a(35, 35), this.d(17), this.b(35, 35));
                        int var14 = var1.nextInt();
                        this.p.add(new WorldGenMonumetPieces.class_u_in_class_asf(var5, var19, var14++));
                        this.p.add(new WorldGenMonumetPieces.class_u_in_class_asf(var5, var20, var14++));
                        this.p.add(new WorldGenMonumetPieces.WorldGenMonumentPiecePenthouse(var5, var13));
                        return;
                     }

                     var9 = (WorldGenMonumetPieces.class_v_in_class_asf)var8.next();
                  } while(var9.d);
               } while(var9.b());

               Iterator var10 = var7.iterator();

               while(var10.hasNext()) {
                  WorldGenMonumetPieces.class_i_in_class_asf var11 = (WorldGenMonumetPieces.class_i_in_class_asf)var10.next();
                  if(var11.a(var9)) {
                     this.p.add(var11.a(var5, var9, var1));
                     break;
                  }
               }
            }
         }
      }

      private List a(Random var1) {
         WorldGenMonumetPieces.class_v_in_class_asf[] var2 = new WorldGenMonumetPieces.class_v_in_class_asf[75];

         int var3;
         int var4;
         byte var5;
         int var6;
         for(var3 = 0; var3 < 5; ++var3) {
            for(var4 = 0; var4 < 4; ++var4) {
               var5 = 0;
               var6 = b(var3, var5, var4);
               var2[var6] = new WorldGenMonumetPieces.class_v_in_class_asf(var6);
            }
         }

         for(var3 = 0; var3 < 5; ++var3) {
            for(var4 = 0; var4 < 4; ++var4) {
               var5 = 1;
               var6 = b(var3, var5, var4);
               var2[var6] = new WorldGenMonumetPieces.class_v_in_class_asf(var6);
            }
         }

         for(var3 = 1; var3 < 4; ++var3) {
            for(var4 = 0; var4 < 2; ++var4) {
               var5 = 2;
               var6 = b(var3, var5, var4);
               var2[var6] = new WorldGenMonumetPieces.class_v_in_class_asf(var6);
            }
         }

         this.n = var2[g];

         int var8;
         int var9;
         int var11;
         int var12;
         int var13;
         for(var3 = 0; var3 < 5; ++var3) {
            for(var4 = 0; var4 < 5; ++var4) {
               for(int var16 = 0; var16 < 3; ++var16) {
                  var6 = b(var3, var16, var4);
                  if(var2[var6] != null) {
                     EnumDirection[] var7 = EnumDirection.values();
                     var8 = var7.length;

                     for(var9 = 0; var9 < var8; ++var9) {
                        EnumDirection var10 = var7[var9];
                        var11 = var3 + var10.getAdjacentX();
                        var12 = var16 + var10.getAdjacentY();
                        var13 = var4 + var10.getAdjacentZ();
                        if(var11 >= 0 && var11 < 5 && var13 >= 0 && var13 < 5 && var12 >= 0 && var12 < 3) {
                           int var14 = b(var11, var12, var13);
                           if(var2[var14] != null) {
                              if(var13 != var4) {
                                 var2[var6].a(var10.opposite(), var2[var14]);
                              } else {
                                 var2[var6].a(var10, var2[var14]);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         WorldGenMonumetPieces.class_v_in_class_asf var15;
         var2[h].a(EnumDirection.UP, var15 = new WorldGenMonumetPieces.class_v_in_class_asf(1003));
         WorldGenMonumetPieces.class_v_in_class_asf var17;
         var2[i].a(EnumDirection.SOUTH, var17 = new WorldGenMonumetPieces.class_v_in_class_asf(1001));
         WorldGenMonumetPieces.class_v_in_class_asf var18;
         var2[j].a(EnumDirection.SOUTH, var18 = new WorldGenMonumetPieces.class_v_in_class_asf(1002));
         var15.d = true;
         var17.d = true;
         var18.d = true;
         this.n.e = true;
         this.o = var2[b(var1.nextInt(4), 0, 2)];
         this.o.d = true;
         this.o.b[EnumDirection.EAST.getId()].d = true;
         this.o.b[EnumDirection.NORTH.getId()].d = true;
         this.o.b[EnumDirection.EAST.getId()].b[EnumDirection.NORTH.getId()].d = true;
         this.o.b[EnumDirection.UP.getId()].d = true;
         this.o.b[EnumDirection.EAST.getId()].b[EnumDirection.UP.getId()].d = true;
         this.o.b[EnumDirection.NORTH.getId()].b[EnumDirection.UP.getId()].d = true;
         this.o.b[EnumDirection.EAST.getId()].b[EnumDirection.NORTH.getId()].b[EnumDirection.UP.getId()].d = true;
         ArrayList var19 = Lists.newArrayList();
         WorldGenMonumetPieces.class_v_in_class_asf[] var20 = var2;
         var8 = var2.length;

         for(var9 = 0; var9 < var8; ++var9) {
            WorldGenMonumetPieces.class_v_in_class_asf var23 = var20[var9];
            if(var23 != null) {
               var23.a();
               var19.add(var23);
            }
         }

         var15.a();
         Collections.shuffle(var19, var1);
         int var21 = 1;
         Iterator var22 = var19.iterator();

         label95:
         while(var22.hasNext()) {
            WorldGenMonumetPieces.class_v_in_class_asf var24 = (WorldGenMonumetPieces.class_v_in_class_asf)var22.next();
            int var25 = 0;
            var11 = 0;

            while(true) {
               while(true) {
                  do {
                     if(var25 >= 2 || var11 >= 5) {
                        continue label95;
                     }

                     ++var11;
                     var12 = var1.nextInt(6);
                  } while(!var24.c[var12]);

                  var13 = EnumDirection.getById(var12).opposite().getId();
                  var24.c[var12] = false;
                  var24.b[var12].c[var13] = false;
                  if(var24.a(var21++) && var24.b[var12].a(var21++)) {
                     ++var25;
                  } else {
                     var24.c[var12] = true;
                     var24.b[var12].c[var13] = true;
                  }
               }
            }
         }

         var19.add(var15);
         var19.add(var17);
         var19.add(var18);
         return var19;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         int var4 = Math.max(var1.G(), 64) - this.l.minY;
         this.a(var1, var3, 0, 0, 0, 58, var4, 58, false);
         this.a(false, 0, var1, var2, var3);
         this.a(true, 33, var1, var2, var3);
         this.b(var1, var2, var3);
         this.c(var1, var2, var3);
         this.d(var1, var2, var3);
         this.e(var1, var2, var3);
         this.f(var1, var2, var3);
         this.g(var1, var2, var3);

         int var5;
         label72:
         for(var5 = 0; var5 < 7; ++var5) {
            int var6 = 0;

            while(true) {
               while(true) {
                  if(var6 >= 7) {
                     continue label72;
                  }

                  if(var6 == 0 && var5 == 3) {
                     var6 = 6;
                  }

                  int var7 = var5 * 9;
                  int var8 = var6 * 9;

                  for(int var9 = 0; var9 < 4; ++var9) {
                     for(int var10 = 0; var10 < 4; ++var10) {
                        this.a(var1, b, var7 + var9, 0, var8 + var10, var3);
                        this.b(var1, b, var7 + var9, -1, var8 + var10, var3);
                     }
                  }

                  if(var5 != 0 && var5 != 6) {
                     var6 += 6;
                  } else {
                     ++var6;
                  }
               }
            }
         }

         for(var5 = 0; var5 < 5; ++var5) {
            this.a(var1, var3, -1 - var5, 0 + var5 * 2, -1 - var5, -1 - var5, 23, 58 + var5, false);
            this.a(var1, var3, 58 + var5, 0 + var5 * 2, -1 - var5, 58 + var5, 23, 58 + var5, false);
            this.a(var1, var3, 0 - var5, 0 + var5 * 2, -1 - var5, 57 + var5, 23, -1 - var5, false);
            this.a(var1, var3, 0 - var5, 0 + var5 * 2, 58 + var5, 57 + var5, 23, 58 + var5, false);
         }

         Iterator var11 = this.p.iterator();

         while(var11.hasNext()) {
            WorldGenMonumetPieces.class_r_in_class_asf var12 = (WorldGenMonumetPieces.class_r_in_class_asf)var11.next();
            if(var12.c().a(var3)) {
               var12.a(var1, var2, var3);
            }
         }

         return true;
      }

      private void a(boolean var1, int var2, World var3, Random var4, StructureBoundingBox var5) {
         boolean var6 = true;
         if(this.a(var5, var2, 0, var2 + 23, 20)) {
            this.a(var3, var5, var2 + 0, 0, 0, var2 + 24, 0, 20, a, a, false);
            this.a(var3, var5, var2 + 0, 1, 0, var2 + 24, 10, 20, false);

            int var7;
            for(var7 = 0; var7 < 4; ++var7) {
               this.a(var3, var5, var2 + var7, var7 + 1, var7, var2 + var7, var7 + 1, 20, b, b, false);
               this.a(var3, var5, var2 + var7 + 7, var7 + 5, var7 + 7, var2 + var7 + 7, var7 + 5, 20, b, b, false);
               this.a(var3, var5, var2 + 17 - var7, var7 + 5, var7 + 7, var2 + 17 - var7, var7 + 5, 20, b, b, false);
               this.a(var3, var5, var2 + 24 - var7, var7 + 1, var7, var2 + 24 - var7, var7 + 1, 20, b, b, false);
               this.a(var3, var5, var2 + var7 + 1, var7 + 1, var7, var2 + 23 - var7, var7 + 1, var7, b, b, false);
               this.a(var3, var5, var2 + var7 + 8, var7 + 5, var7 + 7, var2 + 16 - var7, var7 + 5, var7 + 7, b, b, false);
            }

            this.a(var3, var5, var2 + 4, 4, 4, var2 + 6, 4, 20, a, a, false);
            this.a(var3, var5, var2 + 7, 4, 4, var2 + 17, 4, 6, a, a, false);
            this.a(var3, var5, var2 + 18, 4, 4, var2 + 20, 4, 20, a, a, false);
            this.a(var3, var5, var2 + 11, 8, 11, var2 + 13, 8, 20, a, a, false);
            this.a(var3, d, var2 + 12, 9, 12, var5);
            this.a(var3, d, var2 + 12, 9, 15, var5);
            this.a(var3, d, var2 + 12, 9, 18, var5);
            var7 = var1?var2 + 19:var2 + 5;
            int var8 = var1?var2 + 5:var2 + 19;

            int var9;
            for(var9 = 20; var9 >= 5; var9 -= 3) {
               this.a(var3, d, var7, 5, var9, var5);
            }

            for(var9 = 19; var9 >= 7; var9 -= 3) {
               this.a(var3, d, var8, 5, var9, var5);
            }

            for(var9 = 0; var9 < 4; ++var9) {
               int var10 = var1?var2 + (24 - (17 - var9 * 3)):var2 + 17 - var9 * 3;
               this.a(var3, d, var10, 5, 5, var5);
            }

            this.a(var3, d, var8, 5, 5, var5);
            this.a(var3, var5, var2 + 11, 1, 12, var2 + 13, 7, 12, a, a, false);
            this.a(var3, var5, var2 + 12, 1, 11, var2 + 12, 7, 13, a, a, false);
         }

      }

      private void b(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var3, 22, 5, 35, 17)) {
            this.a(var1, var3, 25, 0, 0, 32, 8, 20, false);

            for(int var4 = 0; var4 < 4; ++var4) {
               this.a(var1, var3, 24, 2, 5 + var4 * 4, 24, 4, 5 + var4 * 4, b, b, false);
               this.a(var1, var3, 22, 4, 5 + var4 * 4, 23, 4, 5 + var4 * 4, b, b, false);
               this.a(var1, b, 25, 5, 5 + var4 * 4, var3);
               this.a(var1, b, 26, 6, 5 + var4 * 4, var3);
               this.a(var1, e, 26, 5, 5 + var4 * 4, var3);
               this.a(var1, var3, 33, 2, 5 + var4 * 4, 33, 4, 5 + var4 * 4, b, b, false);
               this.a(var1, var3, 34, 4, 5 + var4 * 4, 35, 4, 5 + var4 * 4, b, b, false);
               this.a(var1, b, 32, 5, 5 + var4 * 4, var3);
               this.a(var1, b, 31, 6, 5 + var4 * 4, var3);
               this.a(var1, e, 31, 5, 5 + var4 * 4, var3);
               this.a(var1, var3, 27, 6, 5 + var4 * 4, 30, 6, 5 + var4 * 4, a, a, false);
            }
         }

      }

      private void c(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var3, 15, 20, 42, 21)) {
            this.a(var1, var3, 15, 0, 21, 42, 0, 21, a, a, false);
            this.a(var1, var3, 26, 1, 21, 31, 3, 21, false);
            this.a(var1, var3, 21, 12, 21, 36, 12, 21, a, a, false);
            this.a(var1, var3, 17, 11, 21, 40, 11, 21, a, a, false);
            this.a(var1, var3, 16, 10, 21, 41, 10, 21, a, a, false);
            this.a(var1, var3, 15, 7, 21, 42, 9, 21, a, a, false);
            this.a(var1, var3, 16, 6, 21, 41, 6, 21, a, a, false);
            this.a(var1, var3, 17, 5, 21, 40, 5, 21, a, a, false);
            this.a(var1, var3, 21, 4, 21, 36, 4, 21, a, a, false);
            this.a(var1, var3, 22, 3, 21, 26, 3, 21, a, a, false);
            this.a(var1, var3, 31, 3, 21, 35, 3, 21, a, a, false);
            this.a(var1, var3, 23, 2, 21, 25, 2, 21, a, a, false);
            this.a(var1, var3, 32, 2, 21, 34, 2, 21, a, a, false);
            this.a(var1, var3, 28, 4, 20, 29, 4, 21, b, b, false);
            this.a(var1, b, 27, 3, 21, var3);
            this.a(var1, b, 30, 3, 21, var3);
            this.a(var1, b, 26, 2, 21, var3);
            this.a(var1, b, 31, 2, 21, var3);
            this.a(var1, b, 25, 1, 21, var3);
            this.a(var1, b, 32, 1, 21, var3);

            int var4;
            for(var4 = 0; var4 < 7; ++var4) {
               this.a(var1, c, 28 - var4, 6 + var4, 21, var3);
               this.a(var1, c, 29 + var4, 6 + var4, 21, var3);
            }

            for(var4 = 0; var4 < 4; ++var4) {
               this.a(var1, c, 28 - var4, 9 + var4, 21, var3);
               this.a(var1, c, 29 + var4, 9 + var4, 21, var3);
            }

            this.a(var1, c, 28, 12, 21, var3);
            this.a(var1, c, 29, 12, 21, var3);

            for(var4 = 0; var4 < 3; ++var4) {
               this.a(var1, c, 22 - var4 * 2, 8, 21, var3);
               this.a(var1, c, 22 - var4 * 2, 9, 21, var3);
               this.a(var1, c, 35 + var4 * 2, 8, 21, var3);
               this.a(var1, c, 35 + var4 * 2, 9, 21, var3);
            }

            this.a(var1, var3, 15, 13, 21, 42, 15, 21, false);
            this.a(var1, var3, 15, 1, 21, 15, 6, 21, false);
            this.a(var1, var3, 16, 1, 21, 16, 5, 21, false);
            this.a(var1, var3, 17, 1, 21, 20, 4, 21, false);
            this.a(var1, var3, 21, 1, 21, 21, 3, 21, false);
            this.a(var1, var3, 22, 1, 21, 22, 2, 21, false);
            this.a(var1, var3, 23, 1, 21, 24, 1, 21, false);
            this.a(var1, var3, 42, 1, 21, 42, 6, 21, false);
            this.a(var1, var3, 41, 1, 21, 41, 5, 21, false);
            this.a(var1, var3, 37, 1, 21, 40, 4, 21, false);
            this.a(var1, var3, 36, 1, 21, 36, 3, 21, false);
            this.a(var1, var3, 33, 1, 21, 34, 1, 21, false);
            this.a(var1, var3, 35, 1, 21, 35, 2, 21, false);
         }

      }

      private void d(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var3, 21, 21, 36, 36)) {
            this.a(var1, var3, 21, 0, 22, 36, 0, 36, a, a, false);
            this.a(var1, var3, 21, 1, 22, 36, 23, 36, false);

            for(int var4 = 0; var4 < 4; ++var4) {
               this.a(var1, var3, 21 + var4, 13 + var4, 21 + var4, 36 - var4, 13 + var4, 21 + var4, b, b, false);
               this.a(var1, var3, 21 + var4, 13 + var4, 36 - var4, 36 - var4, 13 + var4, 36 - var4, b, b, false);
               this.a(var1, var3, 21 + var4, 13 + var4, 22 + var4, 21 + var4, 13 + var4, 35 - var4, b, b, false);
               this.a(var1, var3, 36 - var4, 13 + var4, 22 + var4, 36 - var4, 13 + var4, 35 - var4, b, b, false);
            }

            this.a(var1, var3, 25, 16, 25, 32, 16, 32, a, a, false);
            this.a(var1, var3, 25, 17, 25, 25, 19, 25, b, b, false);
            this.a(var1, var3, 32, 17, 25, 32, 19, 25, b, b, false);
            this.a(var1, var3, 25, 17, 32, 25, 19, 32, b, b, false);
            this.a(var1, var3, 32, 17, 32, 32, 19, 32, b, b, false);
            this.a(var1, b, 26, 20, 26, var3);
            this.a(var1, b, 27, 21, 27, var3);
            this.a(var1, e, 27, 20, 27, var3);
            this.a(var1, b, 26, 20, 31, var3);
            this.a(var1, b, 27, 21, 30, var3);
            this.a(var1, e, 27, 20, 30, var3);
            this.a(var1, b, 31, 20, 31, var3);
            this.a(var1, b, 30, 21, 30, var3);
            this.a(var1, e, 30, 20, 30, var3);
            this.a(var1, b, 31, 20, 26, var3);
            this.a(var1, b, 30, 21, 27, var3);
            this.a(var1, e, 30, 20, 27, var3);
            this.a(var1, var3, 28, 21, 27, 29, 21, 27, a, a, false);
            this.a(var1, var3, 27, 21, 28, 27, 21, 29, a, a, false);
            this.a(var1, var3, 28, 21, 30, 29, 21, 30, a, a, false);
            this.a(var1, var3, 30, 21, 28, 30, 21, 29, a, a, false);
         }

      }

      private void e(World var1, Random var2, StructureBoundingBox var3) {
         int var4;
         if(this.a(var3, 0, 21, 6, 58)) {
            this.a(var1, var3, 0, 0, 21, 6, 0, 57, a, a, false);
            this.a(var1, var3, 0, 1, 21, 6, 7, 57, false);
            this.a(var1, var3, 4, 4, 21, 6, 4, 53, a, a, false);

            for(var4 = 0; var4 < 4; ++var4) {
               this.a(var1, var3, var4, var4 + 1, 21, var4, var4 + 1, 57 - var4, b, b, false);
            }

            for(var4 = 23; var4 < 53; var4 += 3) {
               this.a(var1, d, 5, 5, var4, var3);
            }

            this.a(var1, d, 5, 5, 52, var3);

            for(var4 = 0; var4 < 4; ++var4) {
               this.a(var1, var3, var4, var4 + 1, 21, var4, var4 + 1, 57 - var4, b, b, false);
            }

            this.a(var1, var3, 4, 1, 52, 6, 3, 52, a, a, false);
            this.a(var1, var3, 5, 1, 51, 5, 3, 53, a, a, false);
         }

         if(this.a(var3, 51, 21, 58, 58)) {
            this.a(var1, var3, 51, 0, 21, 57, 0, 57, a, a, false);
            this.a(var1, var3, 51, 1, 21, 57, 7, 57, false);
            this.a(var1, var3, 51, 4, 21, 53, 4, 53, a, a, false);

            for(var4 = 0; var4 < 4; ++var4) {
               this.a(var1, var3, 57 - var4, var4 + 1, 21, 57 - var4, var4 + 1, 57 - var4, b, b, false);
            }

            for(var4 = 23; var4 < 53; var4 += 3) {
               this.a(var1, d, 52, 5, var4, var3);
            }

            this.a(var1, d, 52, 5, 52, var3);
            this.a(var1, var3, 51, 1, 52, 53, 3, 52, a, a, false);
            this.a(var1, var3, 52, 1, 51, 52, 3, 53, a, a, false);
         }

         if(this.a(var3, 0, 51, 57, 57)) {
            this.a(var1, var3, 7, 0, 51, 50, 0, 57, a, a, false);
            this.a(var1, var3, 7, 1, 51, 50, 10, 57, false);

            for(var4 = 0; var4 < 4; ++var4) {
               this.a(var1, var3, var4 + 1, var4 + 1, 57 - var4, 56 - var4, var4 + 1, 57 - var4, b, b, false);
            }
         }

      }

      private void f(World var1, Random var2, StructureBoundingBox var3) {
         int var4;
         if(this.a(var3, 7, 21, 13, 50)) {
            this.a(var1, var3, 7, 0, 21, 13, 0, 50, a, a, false);
            this.a(var1, var3, 7, 1, 21, 13, 10, 50, false);
            this.a(var1, var3, 11, 8, 21, 13, 8, 53, a, a, false);

            for(var4 = 0; var4 < 4; ++var4) {
               this.a(var1, var3, var4 + 7, var4 + 5, 21, var4 + 7, var4 + 5, 54, b, b, false);
            }

            for(var4 = 21; var4 <= 45; var4 += 3) {
               this.a(var1, d, 12, 9, var4, var3);
            }
         }

         if(this.a(var3, 44, 21, 50, 54)) {
            this.a(var1, var3, 44, 0, 21, 50, 0, 50, a, a, false);
            this.a(var1, var3, 44, 1, 21, 50, 10, 50, false);
            this.a(var1, var3, 44, 8, 21, 46, 8, 53, a, a, false);

            for(var4 = 0; var4 < 4; ++var4) {
               this.a(var1, var3, 50 - var4, var4 + 5, 21, 50 - var4, var4 + 5, 54, b, b, false);
            }

            for(var4 = 21; var4 <= 45; var4 += 3) {
               this.a(var1, d, 45, 9, var4, var3);
            }
         }

         if(this.a(var3, 8, 44, 49, 54)) {
            this.a(var1, var3, 14, 0, 44, 43, 0, 50, a, a, false);
            this.a(var1, var3, 14, 1, 44, 43, 10, 50, false);

            for(var4 = 12; var4 <= 45; var4 += 3) {
               this.a(var1, d, var4, 9, 45, var3);
               this.a(var1, d, var4, 9, 52, var3);
               if(var4 == 12 || var4 == 18 || var4 == 24 || var4 == 33 || var4 == 39 || var4 == 45) {
                  this.a(var1, d, var4, 9, 47, var3);
                  this.a(var1, d, var4, 9, 50, var3);
                  this.a(var1, d, var4, 10, 45, var3);
                  this.a(var1, d, var4, 10, 46, var3);
                  this.a(var1, d, var4, 10, 51, var3);
                  this.a(var1, d, var4, 10, 52, var3);
                  this.a(var1, d, var4, 11, 47, var3);
                  this.a(var1, d, var4, 11, 50, var3);
                  this.a(var1, d, var4, 12, 48, var3);
                  this.a(var1, d, var4, 12, 49, var3);
               }
            }

            for(var4 = 0; var4 < 3; ++var4) {
               this.a(var1, var3, 8 + var4, 5 + var4, 54, 49 - var4, 5 + var4, 54, a, a, false);
            }

            this.a(var1, var3, 11, 8, 54, 46, 8, 54, b, b, false);
            this.a(var1, var3, 14, 8, 44, 43, 8, 53, a, a, false);
         }

      }

      private void g(World var1, Random var2, StructureBoundingBox var3) {
         int var4;
         if(this.a(var3, 14, 21, 20, 43)) {
            this.a(var1, var3, 14, 0, 21, 20, 0, 43, a, a, false);
            this.a(var1, var3, 14, 1, 22, 20, 14, 43, false);
            this.a(var1, var3, 18, 12, 22, 20, 12, 39, a, a, false);
            this.a(var1, var3, 18, 12, 21, 20, 12, 21, b, b, false);

            for(var4 = 0; var4 < 4; ++var4) {
               this.a(var1, var3, var4 + 14, var4 + 9, 21, var4 + 14, var4 + 9, 43 - var4, b, b, false);
            }

            for(var4 = 23; var4 <= 39; var4 += 3) {
               this.a(var1, d, 19, 13, var4, var3);
            }
         }

         if(this.a(var3, 37, 21, 43, 43)) {
            this.a(var1, var3, 37, 0, 21, 43, 0, 43, a, a, false);
            this.a(var1, var3, 37, 1, 22, 43, 14, 43, false);
            this.a(var1, var3, 37, 12, 22, 39, 12, 39, a, a, false);
            this.a(var1, var3, 37, 12, 21, 39, 12, 21, b, b, false);

            for(var4 = 0; var4 < 4; ++var4) {
               this.a(var1, var3, 43 - var4, var4 + 9, 21, 43 - var4, var4 + 9, 43 - var4, b, b, false);
            }

            for(var4 = 23; var4 <= 39; var4 += 3) {
               this.a(var1, d, 38, 13, var4, var3);
            }
         }

         if(this.a(var3, 15, 37, 42, 43)) {
            this.a(var1, var3, 21, 0, 37, 36, 0, 43, a, a, false);
            this.a(var1, var3, 21, 1, 37, 36, 14, 43, false);
            this.a(var1, var3, 21, 12, 37, 36, 12, 39, a, a, false);

            for(var4 = 0; var4 < 4; ++var4) {
               this.a(var1, var3, 15 + var4, var4 + 9, 43 - var4, 42 - var4, var4 + 9, 43 - var4, b, b, false);
            }

            for(var4 = 21; var4 <= 36; var4 += 3) {
               this.a(var1, d, var4, 13, 38, var3);
            }
         }

      }
   }

   public abstract static class class_r_in_class_asf extends StructurePiece {
      protected static final IBlockData a;
      protected static final IBlockData b;
      protected static final IBlockData c;
      protected static final IBlockData d;
      protected static final IBlockData e;
      protected static final IBlockData f;
      protected static final int g;
      protected static final int h;
      protected static final int i;
      protected static final int j;
      protected WorldGenMonumetPieces.class_v_in_class_asf k;

      protected static final int b(int var0, int var1, int var2) {
         return var1 * 25 + var2 * 5 + var0;
      }

      public class_r_in_class_asf() {
         super(0);
      }

      public class_r_in_class_asf(int var1) {
         super(var1);
      }

      public class_r_in_class_asf(EnumDirection var1, StructureBoundingBox var2) {
         super(1);
         this.a(var1);
         this.l = var2;
      }

      protected class_r_in_class_asf(int var1, EnumDirection var2, WorldGenMonumetPieces.class_v_in_class_asf var3, int var4, int var5, int var6) {
         super(var1);
         this.a(var2);
         this.k = var3;
         int var7 = var3.a;
         int var8 = var7 % 5;
         int var9 = var7 / 5 % 5;
         int var10 = var7 / 25;
         if(var2 != EnumDirection.NORTH && var2 != EnumDirection.SOUTH) {
            this.l = new StructureBoundingBox(0, 0, 0, var6 * 8 - 1, var5 * 4 - 1, var4 * 8 - 1);
         } else {
            this.l = new StructureBoundingBox(0, 0, 0, var4 * 8 - 1, var5 * 4 - 1, var6 * 8 - 1);
         }

         switch(WorldGenMonumetPieces.SyntheticClass_1.a[var2.ordinal()]) {
         case 1:
            this.l.a(var8 * 8, var10 * 4, -(var9 + var6) * 8 + 1);
            break;
         case 2:
            this.l.a(var8 * 8, var10 * 4, var9 * 8);
            break;
         case 3:
            this.l.a(-(var9 + var6) * 8 + 1, var10 * 4, var8 * 8);
            break;
         default:
            this.l.a(var9 * 8, var10 * 4, var8 * 8);
         }

      }

      protected void a(NBTTagCompound var1) {
      }

      protected void b(NBTTagCompound var1) {
      }

      protected void a(World var1, StructureBoundingBox var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
         for(int var10 = var4; var10 <= var7; ++var10) {
            for(int var11 = var3; var11 <= var6; ++var11) {
               for(int var12 = var5; var12 <= var8; ++var12) {
                  if(!var9 || this.a(var1, var11, var10, var12, var2).getBlock().getMaterial() != Material.AIR) {
                     if(this.d(var10) >= var1.G()) {
                        this.a(var1, Blocks.AIR.getBlockData(), var11, var10, var12, var2);
                     } else {
                        this.a(var1, f, var11, var10, var12, var2);
                     }
                  }
               }
            }
         }

      }

      protected void a(World var1, StructureBoundingBox var2, int var3, int var4, boolean var5) {
         if(var5) {
            this.a(var1, var2, var3 + 0, 0, var4 + 0, var3 + 2, 0, var4 + 8 - 1, a, a, false);
            this.a(var1, var2, var3 + 5, 0, var4 + 0, var3 + 8 - 1, 0, var4 + 8 - 1, a, a, false);
            this.a(var1, var2, var3 + 3, 0, var4 + 0, var3 + 4, 0, var4 + 2, a, a, false);
            this.a(var1, var2, var3 + 3, 0, var4 + 5, var3 + 4, 0, var4 + 8 - 1, a, a, false);
            this.a(var1, var2, var3 + 3, 0, var4 + 2, var3 + 4, 0, var4 + 2, b, b, false);
            this.a(var1, var2, var3 + 3, 0, var4 + 5, var3 + 4, 0, var4 + 5, b, b, false);
            this.a(var1, var2, var3 + 2, 0, var4 + 3, var3 + 2, 0, var4 + 4, b, b, false);
            this.a(var1, var2, var3 + 5, 0, var4 + 3, var3 + 5, 0, var4 + 4, b, b, false);
         } else {
            this.a(var1, var2, var3 + 0, 0, var4 + 0, var3 + 8 - 1, 0, var4 + 8 - 1, a, a, false);
         }

      }

      protected void a(World var1, StructureBoundingBox var2, int var3, int var4, int var5, int var6, int var7, int var8, IBlockData var9) {
         for(int var10 = var4; var10 <= var7; ++var10) {
            for(int var11 = var3; var11 <= var6; ++var11) {
               for(int var12 = var5; var12 <= var8; ++var12) {
                  if(this.a(var1, var11, var10, var12, var2) == f) {
                     this.a(var1, var9, var11, var10, var12, var2);
                  }
               }
            }
         }

      }

      protected boolean a(StructureBoundingBox var1, int var2, int var3, int var4, int var5) {
         int var6 = this.a(var2, var3);
         int var7 = this.b(var2, var3);
         int var8 = this.a(var4, var5);
         int var9 = this.b(var4, var5);
         return var1.a(Math.min(var6, var8), Math.min(var7, var9), Math.max(var6, var8), Math.max(var7, var9));
      }

      protected boolean a(World var1, StructureBoundingBox var2, int var3, int var4, int var5) {
         int var6 = this.a(var3, var5);
         int var7 = this.d(var4);
         int var8 = this.b(var3, var5);
         if(var2.b((BaseBlockPosition)(new BlockPosition(var6, var7, var8)))) {
            EntityGuardian var9 = new EntityGuardian(var1);
            var9.a(true);
            var9.heal(var9.getMaxHealth());
            var9.setPositionRotation((double) var6 + 0.5D, (double) var7, (double) var8 + 0.5D, 0.0F, 0.0F);
            var9.a(var1.E(new BlockPosition(var9)), (class_qd)null);
            var1.addEntity((Entity)var9);
            return true;
         } else {
            return false;
         }
      }

      static {
         a = Blocks.PRISMARINE.fromLegacyData(BlockPrismarine.b);
         b = Blocks.PRISMARINE.fromLegacyData(BlockPrismarine.N);
         c = Blocks.PRISMARINE.fromLegacyData(BlockPrismarine.O);
         d = b;
         e = Blocks.SEA_LANTERN.getBlockData();
         f = Blocks.WATER.getBlockData();
         g = b(2, 0, 0);
         h = b(2, 2, 0);
         i = b(0, 1, 0);
         j = b(4, 1, 0);
      }
   }
}
