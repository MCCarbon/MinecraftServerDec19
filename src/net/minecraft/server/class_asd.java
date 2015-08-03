package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockStairs;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityMobSpawner;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_asl;
import net.minecraft.server.class_asn;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.BaseBlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_od;

public class class_asd {
   private static final class_asd.class_n_in_class_asd[] a = new class_asd.class_n_in_class_asd[]{new class_asd.class_n_in_class_asd(class_asd.class_c_in_class_asd.class, 30, 0, true), new class_asd.class_n_in_class_asd(class_asd.class_a_in_class_asd.class, 10, 4), new class_asd.class_n_in_class_asd(class_asd.class_o_in_class_asd.class, 10, 4), new class_asd.class_n_in_class_asd(class_asd.class_p_in_class_asd.class, 10, 3), new class_asd.class_n_in_class_asd(class_asd.class_l_in_class_asd.class, 5, 2), new class_asd.class_n_in_class_asd(class_asd.class_f_in_class_asd.class, 5, 1)};
   private static final class_asd.class_n_in_class_asd[] b = new class_asd.class_n_in_class_asd[]{new class_asd.class_n_in_class_asd(class_asd.class_i_in_class_asd.class, 25, 0, true), new class_asd.class_n_in_class_asd(class_asd.class_g_in_class_asd.class, 15, 5), new class_asd.class_n_in_class_asd(class_asd.class_j_in_class_asd.class, 5, 10), new class_asd.class_n_in_class_asd(class_asd.class_h_in_class_asd.class, 5, 10), new class_asd.class_n_in_class_asd(class_asd.class_d_in_class_asd.class, 10, 3, true), new class_asd.class_n_in_class_asd(class_asd.class_e_in_class_asd.class, 7, 2), new class_asd.class_n_in_class_asd(class_asd.class_k_in_class_asd.class, 5, 2)};

   public static void a() {
      class_asl.a(class_asd.class_a_in_class_asd.class, "NeBCr");
      class_asl.a(class_asd.class_b_in_class_asd.class, "NeBEF");
      class_asl.a(class_asd.class_c_in_class_asd.class, "NeBS");
      class_asl.a(class_asd.class_d_in_class_asd.class, "NeCCS");
      class_asl.a(class_asd.class_e_in_class_asd.class, "NeCTB");
      class_asl.a(class_asd.class_f_in_class_asd.class, "NeCE");
      class_asl.a(class_asd.class_g_in_class_asd.class, "NeSCSC");
      class_asl.a(class_asd.class_h_in_class_asd.class, "NeSCLT");
      class_asl.a(class_asd.class_i_in_class_asd.class, "NeSC");
      class_asl.a(class_asd.class_j_in_class_asd.class, "NeSCRT");
      class_asl.a(class_asd.class_k_in_class_asd.class, "NeCSR");
      class_asl.a(class_asd.class_l_in_class_asd.class, "NeMT");
      class_asl.a(class_asd.class_o_in_class_asd.class, "NeRC");
      class_asl.a(class_asd.class_p_in_class_asd.class, "NeSR");
      class_asl.a(class_asd.class_q_in_class_asd.class, "NeStart");
   }

   private static class_asd.class_m_in_class_asd b(class_asd.class_n_in_class_asd var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
      Class var8 = var0.a;
      Object var9 = null;
      if(var8 == class_asd.class_c_in_class_asd.class) {
         var9 = class_asd.class_c_in_class_asd.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var8 == class_asd.class_a_in_class_asd.class) {
         var9 = class_asd.class_a_in_class_asd.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var8 == class_asd.class_o_in_class_asd.class) {
         var9 = class_asd.class_o_in_class_asd.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var8 == class_asd.class_p_in_class_asd.class) {
         var9 = class_asd.class_p_in_class_asd.a(var1, var2, var3, var4, var5, var7, var6);
      } else if(var8 == class_asd.class_l_in_class_asd.class) {
         var9 = class_asd.class_l_in_class_asd.a(var1, var2, var3, var4, var5, var7, var6);
      } else if(var8 == class_asd.class_f_in_class_asd.class) {
         var9 = class_asd.class_f_in_class_asd.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var8 == class_asd.class_i_in_class_asd.class) {
         var9 = class_asd.class_i_in_class_asd.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var8 == class_asd.class_j_in_class_asd.class) {
         var9 = class_asd.class_j_in_class_asd.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var8 == class_asd.class_h_in_class_asd.class) {
         var9 = class_asd.class_h_in_class_asd.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var8 == class_asd.class_d_in_class_asd.class) {
         var9 = class_asd.class_d_in_class_asd.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var8 == class_asd.class_e_in_class_asd.class) {
         var9 = class_asd.class_e_in_class_asd.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var8 == class_asd.class_g_in_class_asd.class) {
         var9 = class_asd.class_g_in_class_asd.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var8 == class_asd.class_k_in_class_asd.class) {
         var9 = class_asd.class_k_in_class_asd.a(var1, var2, var3, var4, var5, var6, var7);
      }

      return (class_asd.class_m_in_class_asd)var9;
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

   public static class class_e_in_class_asd extends class_asd.class_m_in_class_asd {
      public class_e_in_class_asd() {
      }

      public class_e_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      public void a(class_asn var1, List var2, Random var3) {
         byte var4 = 1;
         EnumDirection var5 = this.e();
         if(var5 == EnumDirection.WEST || var5 == EnumDirection.NORTH) {
            var4 = 5;
         }

         this.b((class_asd.class_q_in_class_asd)var1, var2, var3, 0, var4, var3.nextInt(8) > 0);
         this.c((class_asd.class_q_in_class_asd)var1, var2, var3, 0, var4, var3.nextInt(8) > 0);
      }

      public static class_asd.class_e_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -3, 0, 0, 9, 7, 9, var5);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_e_in_class_asd(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         this.a(var1, var3, 0, 0, 0, 8, 1, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 8, 5, 8, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 6, 0, 8, 6, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 2, 5, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 6, 2, 0, 8, 5, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 3, 0, 1, 4, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 7, 3, 0, 7, 4, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 0, 2, 4, 8, 2, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 1, 4, 2, 2, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 6, 1, 4, 7, 2, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 3, 8, 8, 3, 8, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 0, 3, 6, 0, 3, 7, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 8, 3, 6, 8, 3, 7, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 0, 3, 4, 0, 5, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 8, 3, 4, 8, 5, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 3, 5, 2, 5, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 6, 3, 5, 7, 5, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 4, 5, 1, 5, 5, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 7, 4, 5, 7, 5, 5, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);

         for(int var4 = 0; var4 <= 5; ++var4) {
            for(int var5 = 0; var5 <= 8; ++var5) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var5, -1, var4, var3);
            }
         }

         return true;
      }
   }

   public static class class_d_in_class_asd extends class_asd.class_m_in_class_asd {
      public class_d_in_class_asd() {
      }

      public class_d_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      public void a(class_asn var1, List var2, Random var3) {
         this.a((class_asd.class_q_in_class_asd)var1, var2, var3, 1, 0, true);
      }

      public static class_asd.class_d_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -1, -7, 0, 5, 14, 10, var5);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_d_in_class_asd(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         IBlockData var4 = Blocks.NETHER_BTICK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.SOUTH);

         for(int var5 = 0; var5 <= 9; ++var5) {
            int var6 = Math.max(1, 7 - var5);
            int var7 = Math.min(Math.max(var6 + 5, 14 - var5), 13);
            int var8 = var5;
            this.a(var1, var3, 0, 0, var5, 4, var6, var5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(var1, var3, 1, var6 + 1, var5, 3, var7 - 1, var5, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            if(var5 <= 6) {
               this.a(var1, var4, 1, var6 + 1, var5, var3);
               this.a(var1, var4, 2, var6 + 1, var5, var3);
               this.a(var1, var4, 3, var6 + 1, var5, var3);
            }

            this.a(var1, var3, 0, var7, var5, 4, var7, var5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(var1, var3, 0, var6 + 1, var5, 0, var7 - 1, var5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(var1, var3, 4, var6 + 1, var5, 4, var7 - 1, var5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            if((var5 & 1) == 0) {
               this.a(var1, var3, 0, var6 + 2, var5, 0, var6 + 3, var5, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
               this.a(var1, var3, 4, var6 + 2, var5, 4, var6 + 3, var5, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            }

            for(int var9 = 0; var9 <= 4; ++var9) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var9, -1, var8, var3);
            }
         }

         return true;
      }
   }

   public static class class_h_in_class_asd extends class_asd.class_m_in_class_asd {
      private boolean b;

      public class_h_in_class_asd() {
      }

      public class_h_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
         this.b = var2.nextInt(3) == 0;
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.b = var1.getBoolean("Chest");
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Chest", this.b);
      }

      public void a(class_asn var1, List var2, Random var3) {
         this.b((class_asd.class_q_in_class_asd)var1, var2, var3, 0, 1, true);
      }

      public static class_asd.class_h_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -1, 0, 0, 5, 7, 5, var5);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_h_in_class_asd(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         this.a(var1, var3, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 4, 5, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 4, 2, 0, 4, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 4, 3, 1, 4, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 4, 3, 3, 4, 4, 3, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 0, 5, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 4, 3, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 3, 4, 1, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 3, 3, 4, 3, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         if(this.b && var3.b((BaseBlockPosition)(new BlockPosition(this.a(3, 3), this.d(2), this.b(3, 3))))) {
            this.b = false;
            this.a(var1, var3, var2, 3, 2, 3, a, 2 + var2.nextInt(4));
         }

         this.a(var1, var3, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

         for(int var4 = 0; var4 <= 4; ++var4) {
            for(int var5 = 0; var5 <= 4; ++var5) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, var5, var3);
            }
         }

         return true;
      }
   }

   public static class class_j_in_class_asd extends class_asd.class_m_in_class_asd {
      private boolean b;

      public class_j_in_class_asd() {
      }

      public class_j_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
         this.b = var2.nextInt(3) == 0;
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.b = var1.getBoolean("Chest");
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Chest", this.b);
      }

      public void a(class_asn var1, List var2, Random var3) {
         this.c((class_asd.class_q_in_class_asd)var1, var2, var3, 0, 1, true);
      }

      public static class_asd.class_j_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -1, 0, 0, 5, 7, 5, var5);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_j_in_class_asd(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         this.a(var1, var3, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 4, 5, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 0, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 3, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 0, 3, 3, 0, 4, 3, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 2, 4, 4, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 3, 4, 1, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 3, 3, 4, 3, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         if(this.b && var3.b((BaseBlockPosition)(new BlockPosition(this.a(1, 3), this.d(2), this.b(1, 3))))) {
            this.b = false;
            this.a(var1, var3, var2, 1, 2, 3, a, 2 + var2.nextInt(4));
         }

         this.a(var1, var3, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

         for(int var4 = 0; var4 <= 4; ++var4) {
            for(int var5 = 0; var5 <= 4; ++var5) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, var5, var3);
            }
         }

         return true;
      }
   }

   public static class class_g_in_class_asd extends class_asd.class_m_in_class_asd {
      public class_g_in_class_asd() {
      }

      public class_g_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      public void a(class_asn var1, List var2, Random var3) {
         this.a((class_asd.class_q_in_class_asd)var1, var2, var3, 1, 0, true);
         this.b((class_asd.class_q_in_class_asd)var1, var2, var3, 0, 1, true);
         this.c((class_asd.class_q_in_class_asd)var1, var2, var3, 0, 1, true);
      }

      public static class_asd.class_g_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -1, 0, 0, 5, 7, 5, var5);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_g_in_class_asd(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         this.a(var1, var3, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 4, 5, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 0, 5, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 4, 0, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 4, 2, 4, 4, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

         for(int var4 = 0; var4 <= 4; ++var4) {
            for(int var5 = 0; var5 <= 4; ++var5) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, var5, var3);
            }
         }

         return true;
      }
   }

   public static class class_i_in_class_asd extends class_asd.class_m_in_class_asd {
      public class_i_in_class_asd() {
      }

      public class_i_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      public void a(class_asn var1, List var2, Random var3) {
         this.a((class_asd.class_q_in_class_asd)var1, var2, var3, 1, 0, true);
      }

      public static class_asd.class_i_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -1, 0, 0, 5, 7, 5, var5);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_i_in_class_asd(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         this.a(var1, var3, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 4, 5, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 0, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 4, 2, 0, 4, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 3, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 0, 3, 3, 0, 4, 3, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 4, 3, 1, 4, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 4, 3, 3, 4, 4, 3, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

         for(int var4 = 0; var4 <= 4; ++var4) {
            for(int var5 = 0; var5 <= 4; ++var5) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, var5, var3);
            }
         }

         return true;
      }
   }

   public static class class_k_in_class_asd extends class_asd.class_m_in_class_asd {
      public class_k_in_class_asd() {
      }

      public class_k_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      public void a(class_asn var1, List var2, Random var3) {
         this.a((class_asd.class_q_in_class_asd)var1, var2, var3, 5, 3, true);
         this.a((class_asd.class_q_in_class_asd)var1, var2, var3, 5, 11, true);
      }

      public static class_asd.class_k_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -5, -3, 0, 13, 14, 13, var5);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_k_in_class_asd(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         this.a(var1, var3, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 5, 0, 12, 13, 12, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

         int var4;
         for(var4 = 1; var4 <= 11; var4 += 2) {
            this.a(var1, var3, var4, 10, 0, var4, 11, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(var1, var3, var4, 10, 12, var4, 11, 12, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(var1, var3, 0, 10, var4, 0, 11, var4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(var1, var3, 12, 10, var4, 12, 11, var4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(var1, Blocks.NETHER_BRICK.getBlockData(), var4, 13, 0, var3);
            this.a(var1, Blocks.NETHER_BRICK.getBlockData(), var4, 13, 12, var3);
            this.a(var1, Blocks.NETHER_BRICK.getBlockData(), 0, 13, var4, var3);
            this.a(var1, Blocks.NETHER_BRICK.getBlockData(), 12, 13, var4, var3);
            this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), var4 + 1, 13, 0, var3);
            this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), var4 + 1, 13, 12, var3);
            this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, var4 + 1, var3);
            this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 12, 13, var4 + 1, var3);
         }

         this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, 0, var3);
         this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, 12, var3);
         this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, 0, var3);
         this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 12, 13, 0, var3);

         for(var4 = 3; var4 <= 9; var4 += 2) {
            this.a(var1, var3, 1, 7, var4, 1, 8, var4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(var1, var3, 11, 7, var4, 11, 8, var4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         }

         IBlockData var9 = Blocks.NETHER_BTICK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH);

         int var5;
         int var7;
         for(var5 = 0; var5 <= 6; ++var5) {
            int var6 = var5 + 4;

            for(var7 = 5; var7 <= 7; ++var7) {
               this.a(var1, var9, var7, 5 + var5, var6, var3);
            }

            if(var6 >= 5 && var6 <= 8) {
               this.a(var1, var3, 5, 5, var6, 7, var5 + 4, var6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            } else if(var6 >= 9 && var6 <= 10) {
               this.a(var1, var3, 5, 8, var6, 7, var5 + 4, var6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            }

            if(var5 >= 1) {
               this.a(var1, var3, 5, 6 + var5, var6, 7, 9 + var5, var6, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            }
         }

         for(var5 = 5; var5 <= 7; ++var5) {
            this.a(var1, var9, var5, 12, 11, var3);
         }

         this.a(var1, var3, 5, 6, 7, 5, 7, 7, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 7, 6, 7, 7, 7, 7, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 5, 13, 12, 7, 13, 12, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 2, 5, 2, 3, 5, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 5, 9, 3, 5, 10, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 5, 4, 2, 5, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 9, 5, 2, 10, 5, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 9, 5, 9, 10, 5, 10, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 10, 5, 4, 10, 5, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         IBlockData var10 = var9.set(BlockStairs.a, EnumDirection.EAST);
         IBlockData var11 = var9.set(BlockStairs.a, EnumDirection.WEST);
         this.a(var1, var11, 4, 5, 2, var3);
         this.a(var1, var11, 4, 5, 3, var3);
         this.a(var1, var11, 4, 5, 9, var3);
         this.a(var1, var11, 4, 5, 10, var3);
         this.a(var1, var10, 8, 5, 2, var3);
         this.a(var1, var10, 8, 5, 3, var3);
         this.a(var1, var10, 8, 5, 9, var3);
         this.a(var1, var10, 8, 5, 10, var3);
         this.a(var1, var3, 3, 4, 4, 4, 4, 8, Blocks.SOUL_SAND.getBlockData(), Blocks.SOUL_SAND.getBlockData(), false);
         this.a(var1, var3, 8, 4, 4, 9, 4, 8, Blocks.SOUL_SAND.getBlockData(), Blocks.SOUL_SAND.getBlockData(), false);
         this.a(var1, var3, 3, 5, 4, 4, 5, 8, Blocks.NETHER_WART.getBlockData(), Blocks.NETHER_WART.getBlockData(), false);
         this.a(var1, var3, 8, 5, 4, 9, 5, 8, Blocks.NETHER_WART.getBlockData(), Blocks.NETHER_WART.getBlockData(), false);
         this.a(var1, var3, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

         int var8;
         for(var7 = 4; var7 <= 8; ++var7) {
            for(var8 = 0; var8 <= 2; ++var8) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var7, -1, var8, var3);
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var7, -1, 12 - var8, var3);
            }
         }

         for(var7 = 0; var7 <= 2; ++var7) {
            for(var8 = 4; var8 <= 8; ++var8) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var7, -1, var8, var3);
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), 12 - var7, -1, var8, var3);
            }
         }

         return true;
      }
   }

   public static class class_f_in_class_asd extends class_asd.class_m_in_class_asd {
      public class_f_in_class_asd() {
      }

      public class_f_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      public void a(class_asn var1, List var2, Random var3) {
         this.a((class_asd.class_q_in_class_asd)var1, var2, var3, 5, 3, true);
      }

      public static class_asd.class_f_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -5, -3, 0, 13, 14, 13, var5);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_f_in_class_asd(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         this.a(var1, var3, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 5, 0, 12, 13, 12, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 5, 8, 0, 7, 8, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);

         int var4;
         for(var4 = 1; var4 <= 11; var4 += 2) {
            this.a(var1, var3, var4, 10, 0, var4, 11, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(var1, var3, var4, 10, 12, var4, 11, 12, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(var1, var3, 0, 10, var4, 0, 11, var4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(var1, var3, 12, 10, var4, 12, 11, var4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(var1, Blocks.NETHER_BRICK.getBlockData(), var4, 13, 0, var3);
            this.a(var1, Blocks.NETHER_BRICK.getBlockData(), var4, 13, 12, var3);
            this.a(var1, Blocks.NETHER_BRICK.getBlockData(), 0, 13, var4, var3);
            this.a(var1, Blocks.NETHER_BRICK.getBlockData(), 12, 13, var4, var3);
            this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), var4 + 1, 13, 0, var3);
            this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), var4 + 1, 13, 12, var3);
            this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, var4 + 1, var3);
            this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 12, 13, var4 + 1, var3);
         }

         this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, 0, var3);
         this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, 12, var3);
         this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, 0, var3);
         this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 12, 13, 0, var3);

         for(var4 = 3; var4 <= 9; var4 += 2) {
            this.a(var1, var3, 1, 7, var4, 1, 8, var4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(var1, var3, 11, 7, var4, 11, 8, var4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         }

         this.a(var1, var3, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

         int var5;
         for(var4 = 4; var4 <= 8; ++var4) {
            for(var5 = 0; var5 <= 2; ++var5) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, var5, var3);
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, 12 - var5, var3);
            }
         }

         for(var4 = 0; var4 <= 2; ++var4) {
            for(var5 = 4; var5 <= 8; ++var5) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, var5, var3);
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), 12 - var4, -1, var5, var3);
            }
         }

         this.a(var1, var3, 5, 5, 5, 7, 5, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 6, 1, 6, 6, 4, 6, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, Blocks.NETHER_BRICK.getBlockData(), 6, 0, 6, var3);
         this.a(var1, Blocks.FLOWING_LAVA.getBlockData(), 6, 5, 6, var3);
         BlockPosition var6 = new BlockPosition(this.a(6, 6), this.d(5), this.b(6, 6));
         if(var3.b((BaseBlockPosition)var6)) {
            var1.a((Block)Blocks.FLOWING_LAVA, (BlockPosition)var6, (Random)var2);
         }

         return true;
      }
   }

   public static class class_l_in_class_asd extends class_asd.class_m_in_class_asd {
      private boolean b;

      public class_l_in_class_asd() {
      }

      public class_l_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.b = var1.getBoolean("Mob");
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Mob", this.b);
      }

      public static class_asd.class_l_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, int var5, EnumDirection var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -2, 0, 0, 7, 8, 9, var6);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_l_in_class_asd(var5, var1, var7, var6):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         this.a(var1, var3, 0, 2, 0, 6, 7, 7, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 1, 0, 0, 5, 1, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 2, 1, 5, 2, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 3, 2, 5, 3, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 4, 3, 5, 4, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 2, 0, 1, 4, 2, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 5, 2, 0, 5, 4, 2, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 5, 2, 1, 5, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 5, 5, 2, 5, 5, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 5, 3, 0, 5, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 6, 5, 3, 6, 5, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 5, 8, 5, 5, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 1, 6, 3, var3);
         this.a(var1, Blocks.NETHER_BRICK_FENCE.getBlockData(), 5, 6, 3, var3);
         this.a(var1, var3, 0, 6, 3, 0, 6, 8, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 6, 6, 3, 6, 6, 8, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 1, 6, 8, 5, 7, 8, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 2, 8, 8, 4, 8, 8, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         if(!this.b) {
            BlockPosition var4 = new BlockPosition(this.a(3, 5), this.d(5), this.b(3, 5));
            if(var3.b((BaseBlockPosition)var4)) {
               this.b = true;
               var1.setTypeAndData((BlockPosition)var4, (IBlockData)Blocks.MOB_SPAWNER.getBlockData(), 2);
               TileEntity var5 = var1.getTileEntity(var4);
               if(var5 instanceof TileEntityMobSpawner) {
                  ((TileEntityMobSpawner)var5).b().a("Blaze");
               }
            }
         }

         for(int var6 = 0; var6 <= 6; ++var6) {
            for(int var7 = 0; var7 <= 6; ++var7) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var6, -1, var7, var3);
            }
         }

         return true;
      }
   }

   public static class class_p_in_class_asd extends class_asd.class_m_in_class_asd {
      public class_p_in_class_asd() {
      }

      public class_p_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      public void a(class_asn var1, List var2, Random var3) {
         this.c((class_asd.class_q_in_class_asd)var1, var2, var3, 6, 2, false);
      }

      public static class_asd.class_p_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, int var5, EnumDirection var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -2, 0, 0, 7, 11, 7, var6);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_p_in_class_asd(var5, var1, var7, var6):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         this.a(var1, var3, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 6, 10, 6, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 1, 8, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 5, 2, 0, 6, 8, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 1, 0, 8, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 6, 2, 1, 6, 8, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 2, 6, 5, 8, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 3, 2, 0, 5, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 6, 3, 2, 6, 5, 2, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 6, 3, 4, 6, 5, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, Blocks.NETHER_BRICK.getBlockData(), 5, 2, 5, var3);
         this.a(var1, var3, 4, 2, 5, 4, 3, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 3, 2, 5, 3, 4, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 2, 5, 2, 5, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 2, 5, 1, 6, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 7, 1, 5, 7, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 6, 8, 2, 6, 8, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 2, 6, 0, 4, 8, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 5, 0, 4, 5, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);

         for(int var4 = 0; var4 <= 6; ++var4) {
            for(int var5 = 0; var5 <= 6; ++var5) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, var5, var3);
            }
         }

         return true;
      }
   }

   public static class class_o_in_class_asd extends class_asd.class_m_in_class_asd {
      public class_o_in_class_asd() {
      }

      public class_o_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      public void a(class_asn var1, List var2, Random var3) {
         this.a((class_asd.class_q_in_class_asd)var1, var2, var3, 2, 0, false);
         this.b((class_asd.class_q_in_class_asd)var1, var2, var3, 0, 2, false);
         this.c((class_asd.class_q_in_class_asd)var1, var2, var3, 0, 2, false);
      }

      public static class_asd.class_o_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -2, 0, 0, 7, 9, 7, var5);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_o_in_class_asd(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         this.a(var1, var3, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 6, 7, 6, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 1, 6, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 6, 1, 6, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 5, 2, 0, 6, 6, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 5, 2, 6, 6, 6, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 0, 6, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 5, 0, 6, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 6, 2, 0, 6, 6, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 6, 2, 5, 6, 6, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 6, 0, 4, 6, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 5, 0, 4, 5, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 2, 6, 6, 4, 6, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 2, 5, 6, 4, 5, 6, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 0, 6, 2, 0, 6, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 5, 2, 0, 5, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 6, 6, 2, 6, 6, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 6, 5, 2, 6, 5, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);

         for(int var4 = 0; var4 <= 6; ++var4) {
            for(int var5 = 0; var5 <= 6; ++var5) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, var5, var3);
            }
         }

         return true;
      }
   }

   public static class class_a_in_class_asd extends class_asd.class_m_in_class_asd {
      public class_a_in_class_asd() {
      }

      public class_a_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      protected class_a_in_class_asd(Random var1, int var2, int var3) {
         super(0);
         this.a(EnumDirection.EnumDirectionLimit.HORIZONTAL.getRandomDirection(var1));
         if(this.e().getAxis() == EnumDirection.EnumAxis.Z) {
            this.l = new class_arw(var2, 64, var3, var2 + 19 - 1, 73, var3 + 19 - 1);
         } else {
            this.l = new class_arw(var2, 64, var3, var2 + 19 - 1, 73, var3 + 19 - 1);
         }

      }

      public void a(class_asn var1, List var2, Random var3) {
         this.a((class_asd.class_q_in_class_asd)var1, var2, var3, 8, 3, false);
         this.b((class_asd.class_q_in_class_asd)var1, var2, var3, 3, 8, false);
         this.c((class_asd.class_q_in_class_asd)var1, var2, var3, 3, 8, false);
      }

      public static class_asd.class_a_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -8, -3, 0, 19, 10, 19, var5);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_a_in_class_asd(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         this.a(var1, var3, 7, 3, 0, 11, 4, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 3, 7, 18, 4, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 8, 5, 0, 10, 7, 18, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 5, 8, 18, 7, 10, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 7, 5, 0, 7, 5, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 7, 5, 11, 7, 5, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 11, 5, 0, 11, 5, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 11, 5, 11, 11, 5, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 5, 7, 7, 5, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 11, 5, 7, 18, 5, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 5, 11, 7, 5, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 11, 5, 11, 18, 5, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 7, 2, 0, 11, 2, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 7, 2, 13, 11, 2, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 7, 0, 0, 11, 1, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 7, 0, 15, 11, 1, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

         int var4;
         int var5;
         for(var4 = 7; var4 <= 11; ++var4) {
            for(var5 = 0; var5 <= 2; ++var5) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, var5, var3);
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, 18 - var5, var3);
            }
         }

         this.a(var1, var3, 0, 2, 7, 5, 2, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 13, 2, 7, 18, 2, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 0, 7, 3, 1, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 15, 0, 7, 18, 1, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

         for(var4 = 0; var4 <= 2; ++var4) {
            for(var5 = 7; var5 <= 11; ++var5) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, var5, var3);
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), 18 - var4, -1, var5, var3);
            }
         }

         return true;
      }
   }

   public static class class_b_in_class_asd extends class_asd.class_m_in_class_asd {
      private int b;

      public class_b_in_class_asd() {
      }

      public class_b_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
         this.b = var2.nextInt();
      }

      public static class_asd.class_b_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -1, -3, 0, 5, 10, 8, var5);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_b_in_class_asd(var6, var1, var7, var5):null;
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.b = var1.getInt("Seed");
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Seed", this.b);
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         Random var4 = new Random((long)this.b);

         int var5;
         int var6;
         int var7;
         for(var5 = 0; var5 <= 4; ++var5) {
            for(var6 = 3; var6 <= 4; ++var6) {
               var7 = var4.nextInt(8);
               this.a(var1, var3, var5, var6, 0, var5, var6, var7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            }
         }

         var5 = var4.nextInt(8);
         this.a(var1, var3, 0, 5, 0, 0, 5, var5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         var5 = var4.nextInt(8);
         this.a(var1, var3, 4, 5, 0, 4, 5, var5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

         for(var5 = 0; var5 <= 4; ++var5) {
            var6 = var4.nextInt(5);
            this.a(var1, var3, var5, 2, 0, var5, 2, var6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         }

         for(var5 = 0; var5 <= 4; ++var5) {
            for(var6 = 0; var6 <= 1; ++var6) {
               var7 = var4.nextInt(3);
               this.a(var1, var3, var5, var6, 0, var5, var6, var7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            }
         }

         return true;
      }
   }

   public static class class_c_in_class_asd extends class_asd.class_m_in_class_asd {
      public class_c_in_class_asd() {
      }

      public class_c_in_class_asd(int var1, Random var2, class_arw var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      public void a(class_asn var1, List var2, Random var3) {
         this.a((class_asd.class_q_in_class_asd)var1, var2, var3, 1, 3, false);
      }

      public static class_asd.class_c_in_class_asd a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         class_arw var7 = class_arw.a(var2, var3, var4, -1, -3, 0, 5, 10, 19, var5);
         return a(var7) && class_asn.a(var0, var7) == null?new class_asd.class_c_in_class_asd(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, class_arw var3) {
         this.a(var1, var3, 0, 3, 0, 4, 4, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 1, 5, 0, 3, 7, 18, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 5, 0, 0, 5, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 4, 5, 0, 4, 5, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 4, 2, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 2, 13, 4, 2, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 0, 0, 4, 1, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
         this.a(var1, var3, 0, 0, 15, 4, 1, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

         for(int var4 = 0; var4 <= 4; ++var4) {
            for(int var5 = 0; var5 <= 2; ++var5) {
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, var5, var3);
               this.b(var1, Blocks.NETHER_BRICK.getBlockData(), var4, -1, 18 - var5, var3);
            }
         }

         this.a(var1, var3, 0, 1, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 0, 3, 4, 0, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 0, 3, 14, 0, 4, 14, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 0, 1, 17, 0, 4, 17, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 4, 1, 1, 4, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 4, 3, 4, 4, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 4, 3, 14, 4, 4, 14, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         this.a(var1, var3, 4, 1, 17, 4, 4, 17, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
         return true;
      }
   }

   public static class class_q_in_class_asd extends class_asd.class_a_in_class_asd {
      public class_asd.class_n_in_class_asd b;
      public List c;
      public List d;
      public List e = Lists.newArrayList();

      public class_q_in_class_asd() {
      }

      public class_q_in_class_asd(Random var1, int var2, int var3) {
         super(var1, var2, var3);
         this.c = Lists.newArrayList();
         class_asd.class_n_in_class_asd[] var4 = class_asd.a;
         int var5 = var4.length;

         int var6;
         class_asd.class_n_in_class_asd var7;
         for(var6 = 0; var6 < var5; ++var6) {
            var7 = var4[var6];
            var7.c = 0;
            this.c.add(var7);
         }

         this.d = Lists.newArrayList();
         var4 = class_asd.b;
         var5 = var4.length;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = var4[var6];
            var7.c = 0;
            this.d.add(var7);
         }

      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
      }
   }

   abstract static class class_m_in_class_asd extends class_asn {
      protected static final List a;

      public class_m_in_class_asd() {
      }

      protected class_m_in_class_asd(int var1) {
         super(var1);
      }

      protected void b(NBTTagCompound var1) {
      }

      protected void a(NBTTagCompound var1) {
      }

      private int a(List var1) {
         boolean var2 = false;
         int var3 = 0;

         class_asd.class_n_in_class_asd var5;
         for(Iterator var4 = var1.iterator(); var4.hasNext(); var3 += var5.b) {
            var5 = (class_asd.class_n_in_class_asd)var4.next();
            if(var5.d > 0 && var5.c < var5.d) {
               var2 = true;
            }
         }

         return var2?var3:-1;
      }

      private class_asd.class_m_in_class_asd a(class_asd.class_q_in_class_asd var1, List var2, List var3, Random var4, int var5, int var6, int var7, EnumDirection var8, int var9) {
         int var10 = this.a(var2);
         boolean var11 = var10 > 0 && var9 <= 30;
         int var12 = 0;

         while(var12 < 5 && var11) {
            ++var12;
            int var13 = var4.nextInt(var10);
            Iterator var14 = var2.iterator();

            while(var14.hasNext()) {
               class_asd.class_n_in_class_asd var15 = (class_asd.class_n_in_class_asd)var14.next();
               var13 -= var15.b;
               if(var13 < 0) {
                  if(!var15.a(var9) || var15 == var1.b && !var15.e) {
                     break;
                  }

                  class_asd.class_m_in_class_asd var16 = class_asd.b(var15, var3, var4, var5, var6, var7, var8, var9);
                  if(var16 != null) {
                     ++var15.c;
                     var1.b = var15;
                     if(!var15.a()) {
                        var2.remove(var15);
                     }

                     return var16;
                  }
               }
            }
         }

         return class_asd.class_b_in_class_asd.a(var3, var4, var5, var6, var7, var8, var9);
      }

      private class_asn a(class_asd.class_q_in_class_asd var1, List var2, Random var3, int var4, int var5, int var6, EnumDirection var7, int var8, boolean var9) {
         if(Math.abs(var4 - var1.c().a) <= 112 && Math.abs(var6 - var1.c().c) <= 112) {
            List var10 = var1.c;
            if(var9) {
               var10 = var1.d;
            }

            class_asd.class_m_in_class_asd var11 = this.a(var1, var10, var2, var3, var4, var5, var6, var7, var8 + 1);
            if(var11 != null) {
               var2.add(var11);
               var1.e.add(var11);
            }

            return var11;
         } else {
            return class_asd.class_b_in_class_asd.a(var2, var3, var4, var5, var6, var7, var8);
         }
      }

      protected class_asn a(class_asd.class_q_in_class_asd var1, List var2, Random var3, int var4, int var5, boolean var6) {
         EnumDirection var7 = this.e();
         if(var7 != null) {
            switch(class_asd.SyntheticClass_1.a[var7.ordinal()]) {
            case 1:
               return this.a(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.c - 1, var7, this.d(), var6);
            case 2:
               return this.a(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.f + 1, var7, this.d(), var6);
            case 3:
               return this.a(var1, var2, var3, this.l.a - 1, this.l.b + var5, this.l.c + var4, var7, this.d(), var6);
            case 4:
               return this.a(var1, var2, var3, this.l.d + 1, this.l.b + var5, this.l.c + var4, var7, this.d(), var6);
            }
         }

         return null;
      }

      protected class_asn b(class_asd.class_q_in_class_asd var1, List var2, Random var3, int var4, int var5, boolean var6) {
         EnumDirection var7 = this.e();
         if(var7 != null) {
            switch(class_asd.SyntheticClass_1.a[var7.ordinal()]) {
            case 1:
               return this.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, EnumDirection.WEST, this.d(), var6);
            case 2:
               return this.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, EnumDirection.WEST, this.d(), var6);
            case 3:
               return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, EnumDirection.NORTH, this.d(), var6);
            case 4:
               return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, EnumDirection.NORTH, this.d(), var6);
            }
         }

         return null;
      }

      protected class_asn c(class_asd.class_q_in_class_asd var1, List var2, Random var3, int var4, int var5, boolean var6) {
         EnumDirection var7 = this.e();
         if(var7 != null) {
            switch(class_asd.SyntheticClass_1.a[var7.ordinal()]) {
            case 1:
               return this.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, EnumDirection.EAST, this.d(), var6);
            case 2:
               return this.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, EnumDirection.EAST, this.d(), var6);
            case 3:
               return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, EnumDirection.SOUTH, this.d(), var6);
            case 4:
               return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, EnumDirection.SOUTH, this.d(), var6);
            }
         }

         return null;
      }

      protected static boolean a(class_arw var0) {
         return var0 != null && var0.b > 10;
      }

      static {
         a = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.k, 0, 1, 3, 5), new class_od(Items.l, 0, 1, 5, 5), new class_od(Items.m, 0, 1, 3, 15), new class_od(Items.D, 0, 1, 1, 5), new class_od(Items.aj, 0, 1, 1, 5), new class_od(Items.d, 0, 1, 1, 5), new class_od(Items.bA, 0, 3, 7, 5), new class_od(Items.aC, 0, 1, 1, 10), new class_od(Items.co, 0, 1, 1, 8), new class_od(Items.cn, 0, 1, 1, 5), new class_od(Items.cp, 0, 1, 1, 3), new class_od(Item.getItemOf(Blocks.OBSIDIAN), 0, 2, 4, 2)}));
      }
   }

   static class class_n_in_class_asd {
      public Class a;
      public final int b;
      public int c;
      public int d;
      public boolean e;

      public class_n_in_class_asd(Class var1, int var2, int var3, boolean var4) {
         this.a = var1;
         this.b = var2;
         this.d = var3;
         this.e = var4;
      }

      public class_n_in_class_asd(Class var1, int var2, int var3) {
         this(var1, var2, var3, false);
      }

      public boolean a(int var1) {
         return this.d == 0 || this.c < this.d;
      }

      public boolean a() {
         return this.d == 0 || this.c < this.d;
      }
   }
}
