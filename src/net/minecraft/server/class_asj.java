package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class class_asj {
   private static final class_asj.class_f_in_class_asj[] b = new class_asj.class_f_in_class_asj[]{new class_asj.class_f_in_class_asj(class_asj.class_n_in_class_asj.class, 40, 0), new class_asj.class_f_in_class_asj(class_asj.class_h_in_class_asj.class, 5, 5), new class_asj.class_f_in_class_asj(class_asj.class_d_in_class_asj.class, 20, 0), new class_asj.class_f_in_class_asj(class_asj.class_i_in_class_asj.class, 20, 0), new class_asj.class_f_in_class_asj(class_asj.class_j_in_class_asj.class, 10, 6), new class_asj.class_f_in_class_asj(class_asj.class_o_in_class_asj.class, 5, 5), new class_asj.class_f_in_class_asj(class_asj.class_l_in_class_asj.class, 5, 5), new class_asj.class_f_in_class_asj(class_asj.class_c_in_class_asj.class, 5, 4), new class_asj.class_f_in_class_asj(class_asj.class_a_in_class_asj.class, 5, 4), new class_asj.class_f_in_class_asj(class_asj.class_e_in_class_asj.class, 10, 2) {
      public boolean a(int var1) {
         return super.a(var1) && var1 > 4;
      }
   }, new class_asj.class_f_in_class_asj(class_asj.class_g_in_class_asj.class, 20, 1) {
      public boolean a(int var1) {
         return super.a(var1) && var1 > 5;
      }
   }};
   private static List c;
   private static Class d;
   static int a;
   private static final class_asj.class_k_in_class_asj e = new class_asj.class_k_in_class_asj(null);

   public static void a() {
      class_asl.a(class_asj.class_a_in_class_asj.class, "SHCC");
      class_asl.a(class_asj.class_b_in_class_asj.class, "SHFC");
      class_asl.a(class_asj.class_c_in_class_asj.class, "SH5C");
      class_asl.a(class_asj.class_d_in_class_asj.class, "SHLT");
      class_asl.a(class_asj.class_e_in_class_asj.class, "SHLi");
      class_asl.a(class_asj.class_g_in_class_asj.class, "SHPR");
      class_asl.a(class_asj.class_h_in_class_asj.class, "SHPH");
      class_asl.a(class_asj.class_i_in_class_asj.class, "SHRT");
      class_asl.a(class_asj.class_j_in_class_asj.class, "SHRC");
      class_asl.a(class_asj.class_l_in_class_asj.class, "SHSD");
      class_asl.a(class_asj.class_m_in_class_asj.class, "SHStart");
      class_asl.a(class_asj.class_n_in_class_asj.class, "SHS");
      class_asl.a(class_asj.class_o_in_class_asj.class, "SHSSD");
   }

   public static void b() {
      c = Lists.newArrayList();
      class_asj.class_f_in_class_asj[] var0 = b;
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         class_asj.class_f_in_class_asj var3 = var0[var2];
         var3.c = 0;
         c.add(var3);
      }

      d = null;
   }

   private static boolean d() {
      boolean var0 = false;
      a = 0;

      class_asj.class_f_in_class_asj var2;
      for(Iterator var1 = c.iterator(); var1.hasNext(); a += var2.b) {
         var2 = (class_asj.class_f_in_class_asj)var1.next();
         if(var2.d > 0 && var2.c < var2.d) {
            var0 = true;
         }
      }

      return var0;
   }

   private static class_asj.class_p_in_class_asj a(Class var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
      Object var8 = null;
      if(var0 == class_asj.class_n_in_class_asj.class) {
         var8 = class_asj.class_n_in_class_asj.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var0 == class_asj.class_h_in_class_asj.class) {
         var8 = class_asj.class_h_in_class_asj.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var0 == class_asj.class_d_in_class_asj.class) {
         var8 = class_asj.class_d_in_class_asj.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var0 == class_asj.class_i_in_class_asj.class) {
         var8 = class_asj.class_i_in_class_asj.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var0 == class_asj.class_j_in_class_asj.class) {
         var8 = class_asj.class_j_in_class_asj.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var0 == class_asj.class_o_in_class_asj.class) {
         var8 = class_asj.class_o_in_class_asj.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var0 == class_asj.class_l_in_class_asj.class) {
         var8 = class_asj.class_l_in_class_asj.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var0 == class_asj.class_c_in_class_asj.class) {
         var8 = class_asj.class_c_in_class_asj.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var0 == class_asj.class_a_in_class_asj.class) {
         var8 = class_asj.class_a_in_class_asj.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var0 == class_asj.class_e_in_class_asj.class) {
         var8 = class_asj.class_e_in_class_asj.a(var1, var2, var3, var4, var5, var6, var7);
      } else if(var0 == class_asj.class_g_in_class_asj.class) {
         var8 = class_asj.class_g_in_class_asj.a(var1, var2, var3, var4, var5, var6, var7);
      }

      return (class_asj.class_p_in_class_asj)var8;
   }

   private static class_asj.class_p_in_class_asj b(class_asj.class_m_in_class_asj var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
      if(!d()) {
         return null;
      } else {
         if(d != null) {
            class_asj.class_p_in_class_asj var8 = a(d, var1, var2, var3, var4, var5, var6, var7);
            d = null;
            if(var8 != null) {
               return var8;
            }
         }

         int var13 = 0;

         while(var13 < 5) {
            ++var13;
            int var9 = var2.nextInt(a);
            Iterator var10 = c.iterator();

            while(var10.hasNext()) {
               class_asj.class_f_in_class_asj var11 = (class_asj.class_f_in_class_asj)var10.next();
               var9 -= var11.b;
               if(var9 < 0) {
                  if(!var11.a(var7) || var11 == var0.a) {
                     break;
                  }

                  class_asj.class_p_in_class_asj var12 = a(var11.a, var1, var2, var3, var4, var5, var6, var7);
                  if(var12 != null) {
                     ++var11.c;
                     var0.a = var11;
                     if(!var11.a()) {
                        c.remove(var11);
                     }

                     return var12;
                  }
               }
            }
         }

         StructureBoundingBox var14 = class_asj.class_b_in_class_asj.a(var1, var2, var3, var4, var5, var6);
         if(var14 != null && var14.b > 1) {
            return new class_asj.class_b_in_class_asj(var7, var2, var14, var6);
         } else {
            return null;
         }
      }
   }

   private static StructurePiece c(class_asj.class_m_in_class_asj var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
      if(var7 > 50) {
         return null;
      } else if(Math.abs(var3 - var0.c().a) <= 112 && Math.abs(var5 - var0.c().c) <= 112) {
         class_asj.class_p_in_class_asj var8 = b(var0, var1, var2, var3, var4, var5, var6, var7 + 1);
         if(var8 != null) {
            var1.add(var8);
            var0.c.add(var8);
         }

         return var8;
      } else {
         return null;
      }
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[EnumDirection.values().length];

      static {
         try {
            b[EnumDirection.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            b[EnumDirection.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            b[EnumDirection.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            b[EnumDirection.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var5) {
            ;
         }

         a = new int[class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.values().length];

         try {
            a[class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.a.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.c.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.d.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   static class class_k_in_class_asj extends StructurePiece.class_a_in_class_asn {
      private class_k_in_class_asj() {
      }

      public void a(Random var1, int var2, int var3, int var4, boolean var5) {
         if(var5) {
            float var6 = var1.nextFloat();
            if(var6 < 0.2F) {
               this.a = Blocks.STONEBRICK.fromLegacyData(BlockSmoothBrick.O);
            } else if(var6 < 0.5F) {
               this.a = Blocks.STONEBRICK.fromLegacyData(BlockSmoothBrick.N);
            } else if(var6 < 0.55F) {
               this.a = Blocks.MONSTER_EGG.fromLegacyData(BlockMonsterEggs.EnumMonsterEggVariant.c.a());
            } else {
               this.a = Blocks.STONEBRICK.getBlockData();
            }
         } else {
            this.a = Blocks.AIR.getBlockData();
         }

      }

      // $FF: synthetic method
      class_k_in_class_asj(Object var1) {
         this();
      }
   }

   public static class class_g_in_class_asj extends class_asj.class_p_in_class_asj {
      private boolean a;

      public class_g_in_class_asj() {
      }

      public class_g_in_class_asj(int var1, Random var2, StructureBoundingBox var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Mob", this.a);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.a = var1.getBoolean("Mob");
      }

      public void a(StructurePiece var1, List var2, Random var3) {
         if(var1 != null) {
            ((class_asj.class_m_in_class_asj)var1).b = this;
         }

      }

      public static class_asj.class_g_in_class_asj a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         StructureBoundingBox var7 = StructureBoundingBox.a(var2, var3, var4, -4, -1, 0, 11, 8, 16, var5);
         return a(var7) && StructurePiece.a(var0, var7) == null?new class_asj.class_g_in_class_asj(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         this.a(var1, var3, 0, 0, 0, 10, 7, 15, false, var2, class_asj.e);
         this.a(var1, var2, var3, class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.c, 4, 1, 0);
         byte var4 = 6;
         this.a(var1, var3, 1, var4, 1, 1, var4, 14, false, var2, class_asj.e);
         this.a(var1, var3, 9, var4, 1, 9, var4, 14, false, var2, class_asj.e);
         this.a(var1, var3, 2, var4, 1, 8, var4, 2, false, var2, class_asj.e);
         this.a(var1, var3, 2, var4, 14, 8, var4, 14, false, var2, class_asj.e);
         this.a(var1, var3, 1, 1, 1, 2, 1, 4, false, var2, class_asj.e);
         this.a(var1, var3, 8, 1, 1, 9, 1, 4, false, var2, class_asj.e);
         this.a(var1, var3, 1, 1, 1, 1, 1, 3, Blocks.FLOWING_LAVA.getBlockData(), Blocks.FLOWING_LAVA.getBlockData(), false);
         this.a(var1, var3, 9, 1, 1, 9, 1, 3, Blocks.FLOWING_LAVA.getBlockData(), Blocks.FLOWING_LAVA.getBlockData(), false);
         this.a(var1, var3, 3, 1, 8, 7, 1, 12, false, var2, class_asj.e);
         this.a(var1, var3, 4, 1, 9, 6, 1, 11, Blocks.FLOWING_LAVA.getBlockData(), Blocks.FLOWING_LAVA.getBlockData(), false);

         int var5;
         for(var5 = 3; var5 < 14; var5 += 2) {
            this.a(var1, var3, 0, 3, var5, 0, 4, var5, Blocks.IRON_BARS.getBlockData(), Blocks.IRON_BARS.getBlockData(), false);
            this.a(var1, var3, 10, 3, var5, 10, 4, var5, Blocks.IRON_BARS.getBlockData(), Blocks.IRON_BARS.getBlockData(), false);
         }

         for(var5 = 2; var5 < 9; var5 += 2) {
            this.a(var1, var3, var5, 3, 15, var5, 4, 15, Blocks.IRON_BARS.getBlockData(), Blocks.IRON_BARS.getBlockData(), false);
         }

         IBlockData var13 = Blocks.STONE_BRICK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH);
         this.a(var1, var3, 4, 1, 5, 6, 1, 7, false, var2, class_asj.e);
         this.a(var1, var3, 4, 2, 6, 6, 2, 7, false, var2, class_asj.e);
         this.a(var1, var3, 4, 3, 7, 6, 3, 7, false, var2, class_asj.e);

         for(int var6 = 4; var6 <= 6; ++var6) {
            this.a(var1, var13, var6, 1, 4, var3);
            this.a(var1, var13, var6, 2, 5, var3);
            this.a(var1, var13, var6, 3, 6, var3);
         }

         IBlockData var14 = Blocks.END_PORTAL_FRAME.getBlockData().set(BlockEnderPortalFrame.a, EnumDirection.NORTH);
         IBlockData var7 = Blocks.END_PORTAL_FRAME.getBlockData().set(BlockEnderPortalFrame.a, EnumDirection.SOUTH);
         IBlockData var8 = Blocks.END_PORTAL_FRAME.getBlockData().set(BlockEnderPortalFrame.a, EnumDirection.EAST);
         IBlockData var9 = Blocks.END_PORTAL_FRAME.getBlockData().set(BlockEnderPortalFrame.a, EnumDirection.WEST);
         this.a(var1, var14.set(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 4, 3, 8, var3);
         this.a(var1, var14.set(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 5, 3, 8, var3);
         this.a(var1, var14.set(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 6, 3, 8, var3);
         this.a(var1, var7.set(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 4, 3, 12, var3);
         this.a(var1, var7.set(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 5, 3, 12, var3);
         this.a(var1, var7.set(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 6, 3, 12, var3);
         this.a(var1, var8.set(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 3, 3, 9, var3);
         this.a(var1, var8.set(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 3, 3, 10, var3);
         this.a(var1, var8.set(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 3, 3, 11, var3);
         this.a(var1, var9.set(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 7, 3, 9, var3);
         this.a(var1, var9.set(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 7, 3, 10, var3);
         this.a(var1, var9.set(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 7, 3, 11, var3);
         if(!this.a) {
            int var12 = this.d(3);
            BlockPosition var10 = new BlockPosition(this.a(5, 6), var12, this.b(5, 6));
            if(var3.b((BaseBlockPosition)var10)) {
               this.a = true;
               var1.setTypeAndData((BlockPosition)var10, (IBlockData)Blocks.MOB_SPAWNER.getBlockData(), 2);
               TileEntity var11 = var1.getTileEntity(var10);
               if(var11 instanceof TileEntityMobSpawner) {
                  ((TileEntityMobSpawner)var11).b().a("Silverfish");
               }
            }
         }

         return true;
      }
   }

   public static class class_c_in_class_asj extends class_asj.class_p_in_class_asj {
      private boolean a;
      private boolean b;
      private boolean c;
      private boolean e;

      public class_c_in_class_asj() {
      }

      public class_c_in_class_asj(int var1, Random var2, StructureBoundingBox var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.d = this.a(var2);
         this.l = var3;
         this.a = var2.nextBoolean();
         this.b = var2.nextBoolean();
         this.c = var2.nextBoolean();
         this.e = var2.nextInt(3) > 0;
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("leftLow", this.a);
         var1.put("leftHigh", this.b);
         var1.put("rightLow", this.c);
         var1.put("rightHigh", this.e);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.a = var1.getBoolean("leftLow");
         this.b = var1.getBoolean("leftHigh");
         this.c = var1.getBoolean("rightLow");
         this.e = var1.getBoolean("rightHigh");
      }

      public void a(StructurePiece var1, List var2, Random var3) {
         int var4 = 3;
         int var5 = 5;
         EnumDirection var6 = this.e();
         if(var6 == EnumDirection.WEST || var6 == EnumDirection.NORTH) {
            var4 = 8 - var4;
            var5 = 8 - var5;
         }

         this.a((class_asj.class_m_in_class_asj)var1, var2, var3, 5, 1);
         if(this.a) {
            this.b((class_asj.class_m_in_class_asj)var1, var2, var3, var4, 1);
         }

         if(this.b) {
            this.b((class_asj.class_m_in_class_asj)var1, var2, var3, var5, 7);
         }

         if(this.c) {
            this.c((class_asj.class_m_in_class_asj)var1, var2, var3, var4, 1);
         }

         if(this.e) {
            this.c((class_asj.class_m_in_class_asj)var1, var2, var3, var5, 7);
         }

      }

      public static class_asj.class_c_in_class_asj a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         StructureBoundingBox var7 = StructureBoundingBox.a(var2, var3, var4, -4, -3, 0, 10, 9, 11, var5);
         return a(var7) && StructurePiece.a(var0, var7) == null?new class_asj.class_c_in_class_asj(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 9, 8, 10, true, var2, class_asj.e);
            this.a(var1, var2, var3, this.d, 4, 3, 0);
            if(this.a) {
               this.a(var1, var3, 0, 3, 1, 0, 5, 3, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            }

            if(this.c) {
               this.a(var1, var3, 9, 3, 1, 9, 5, 3, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            }

            if(this.b) {
               this.a(var1, var3, 0, 5, 7, 0, 7, 9, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            }

            if(this.e) {
               this.a(var1, var3, 9, 5, 7, 9, 7, 9, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            }

            this.a(var1, var3, 5, 1, 10, 7, 3, 10, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(var1, var3, 1, 2, 1, 8, 2, 6, false, var2, class_asj.e);
            this.a(var1, var3, 4, 1, 5, 4, 4, 9, false, var2, class_asj.e);
            this.a(var1, var3, 8, 1, 5, 8, 4, 9, false, var2, class_asj.e);
            this.a(var1, var3, 1, 4, 7, 3, 4, 9, false, var2, class_asj.e);
            this.a(var1, var3, 1, 3, 5, 3, 3, 6, false, var2, class_asj.e);
            this.a(var1, var3, 1, 3, 4, 3, 3, 4, Blocks.STONE_SLAB.getBlockData(), Blocks.STONE_SLAB.getBlockData(), false);
            this.a(var1, var3, 1, 4, 6, 3, 4, 6, Blocks.STONE_SLAB.getBlockData(), Blocks.STONE_SLAB.getBlockData(), false);
            this.a(var1, var3, 5, 1, 7, 7, 1, 8, false, var2, class_asj.e);
            this.a(var1, var3, 5, 1, 9, 7, 1, 9, Blocks.STONE_SLAB.getBlockData(), Blocks.STONE_SLAB.getBlockData(), false);
            this.a(var1, var3, 5, 2, 7, 7, 2, 7, Blocks.STONE_SLAB.getBlockData(), Blocks.STONE_SLAB.getBlockData(), false);
            this.a(var1, var3, 4, 5, 7, 4, 5, 9, Blocks.STONE_SLAB.getBlockData(), Blocks.STONE_SLAB.getBlockData(), false);
            this.a(var1, var3, 8, 5, 7, 8, 5, 9, Blocks.STONE_SLAB.getBlockData(), Blocks.STONE_SLAB.getBlockData(), false);
            this.a(var1, var3, 5, 5, 7, 7, 5, 9, Blocks.DOUBLE_SANDSTONE_SLAB.getBlockData(), Blocks.DOUBLE_SANDSTONE_SLAB.getBlockData(), false);
            this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.SOUTH), 6, 5, 6, var3);
            return true;
         }
      }
   }

   public static class class_e_in_class_asj extends class_asj.class_p_in_class_asj {
      private static final List a;
      private boolean b;

      public class_e_in_class_asj() {
      }

      public class_e_in_class_asj(int var1, Random var2, StructureBoundingBox var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.d = this.a(var2);
         this.l = var3;
         this.b = var3.d() > 6;
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Tall", this.b);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.b = var1.getBoolean("Tall");
      }

      public static class_asj.class_e_in_class_asj a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         StructureBoundingBox var7 = StructureBoundingBox.a(var2, var3, var4, -4, -1, 0, 14, 11, 15, var5);
         if(!a(var7) || StructurePiece.a(var0, var7) != null) {
            var7 = StructureBoundingBox.a(var2, var3, var4, -4, -1, 0, 14, 6, 15, var5);
            if(!a(var7) || StructurePiece.a(var0, var7) != null) {
               return null;
            }
         }

         return new class_asj.class_e_in_class_asj(var6, var1, var7, var5);
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            byte var4 = 11;
            if(!this.b) {
               var4 = 6;
            }

            this.a(var1, var3, 0, 0, 0, 13, var4 - 1, 14, true, var2, class_asj.e);
            this.a(var1, var2, var3, this.d, 4, 1, 0);
            this.a(var1, var3, var2, 0.07F, 2, 1, 1, 11, 4, 13, Blocks.WEB.getBlockData(), Blocks.WEB.getBlockData(), false);
            boolean var5 = true;
            boolean var6 = true;

            int var7;
            for(var7 = 1; var7 <= 13; ++var7) {
               if((var7 - 1) % 4 == 0) {
                  this.a(var1, var3, 1, 1, var7, 1, 4, var7, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
                  this.a(var1, var3, 12, 1, var7, 12, 4, var7, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
                  this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.EAST), 2, 3, var7, var3);
                  this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.WEST), 11, 3, var7, var3);
                  if(this.b) {
                     this.a(var1, var3, 1, 6, var7, 1, 9, var7, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
                     this.a(var1, var3, 12, 6, var7, 12, 9, var7, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
                  }
               } else {
                  this.a(var1, var3, 1, 1, var7, 1, 4, var7, Blocks.BOOKSHELF.getBlockData(), Blocks.BOOKSHELF.getBlockData(), false);
                  this.a(var1, var3, 12, 1, var7, 12, 4, var7, Blocks.BOOKSHELF.getBlockData(), Blocks.BOOKSHELF.getBlockData(), false);
                  if(this.b) {
                     this.a(var1, var3, 1, 6, var7, 1, 9, var7, Blocks.BOOKSHELF.getBlockData(), Blocks.BOOKSHELF.getBlockData(), false);
                     this.a(var1, var3, 12, 6, var7, 12, 9, var7, Blocks.BOOKSHELF.getBlockData(), Blocks.BOOKSHELF.getBlockData(), false);
                  }
               }
            }

            for(var7 = 3; var7 < 12; var7 += 2) {
               this.a(var1, var3, 3, 1, var7, 4, 3, var7, Blocks.BOOKSHELF.getBlockData(), Blocks.BOOKSHELF.getBlockData(), false);
               this.a(var1, var3, 6, 1, var7, 7, 3, var7, Blocks.BOOKSHELF.getBlockData(), Blocks.BOOKSHELF.getBlockData(), false);
               this.a(var1, var3, 9, 1, var7, 10, 3, var7, Blocks.BOOKSHELF.getBlockData(), Blocks.BOOKSHELF.getBlockData(), false);
            }

            if(this.b) {
               this.a(var1, var3, 1, 5, 1, 3, 5, 13, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
               this.a(var1, var3, 10, 5, 1, 12, 5, 13, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
               this.a(var1, var3, 4, 5, 1, 9, 5, 2, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
               this.a(var1, var3, 4, 5, 12, 9, 5, 13, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
               this.a(var1, Blocks.PLANKS.getBlockData(), 9, 5, 11, var3);
               this.a(var1, Blocks.PLANKS.getBlockData(), 8, 5, 11, var3);
               this.a(var1, Blocks.PLANKS.getBlockData(), 9, 5, 10, var3);
               this.a(var1, var3, 3, 6, 2, 3, 6, 12, Blocks.FENCE.getBlockData(), Blocks.FENCE.getBlockData(), false);
               this.a(var1, var3, 10, 6, 2, 10, 6, 10, Blocks.FENCE.getBlockData(), Blocks.FENCE.getBlockData(), false);
               this.a(var1, var3, 4, 6, 2, 9, 6, 2, Blocks.FENCE.getBlockData(), Blocks.FENCE.getBlockData(), false);
               this.a(var1, var3, 4, 6, 12, 8, 6, 12, Blocks.FENCE.getBlockData(), Blocks.FENCE.getBlockData(), false);
               this.a(var1, Blocks.FENCE.getBlockData(), 9, 6, 11, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), 8, 6, 11, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), 9, 6, 10, var3);
               IBlockData var11 = Blocks.LADDER.getBlockData().set(BlockLadder.a, EnumDirection.SOUTH);
               this.a(var1, var11, 10, 1, 13, var3);
               this.a(var1, var11, 10, 2, 13, var3);
               this.a(var1, var11, 10, 3, 13, var3);
               this.a(var1, var11, 10, 4, 13, var3);
               this.a(var1, var11, 10, 5, 13, var3);
               this.a(var1, var11, 10, 6, 13, var3);
               this.a(var1, var11, 10, 7, 13, var3);
               byte var8 = 7;
               byte var9 = 7;
               this.a(var1, Blocks.FENCE.getBlockData(), var8 - 1, 9, var9, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), var8, 9, var9, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), var8 - 1, 8, var9, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), var8, 8, var9, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), var8 - 1, 7, var9, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), var8, 7, var9, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), var8 - 2, 7, var9, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), var8 + 1, 7, var9, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), var8 - 1, 7, var9 - 1, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), var8 - 1, 7, var9 + 1, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), var8, 7, var9 - 1, var3);
               this.a(var1, Blocks.FENCE.getBlockData(), var8, 7, var9 + 1, var3);
               IBlockData var10 = Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.UP);
               this.a(var1, var10, var8 - 2, 8, var9, var3);
               this.a(var1, var10, var8 + 1, 8, var9, var3);
               this.a(var1, var10, var8 - 1, 8, var9 - 1, var3);
               this.a(var1, var10, var8 - 1, 8, var9 + 1, var3);
               this.a(var1, var10, var8, 8, var9 - 1, var3);
               this.a(var1, var10, var8, 8, var9 + 1, var3);
            }

            this.a(var1, var3, var2, 3, 3, 5, class_od.a(a, new class_od[]{Items.ENCHANTED_BOOK.a(var2, 1, 5, 2)}), 1 + var2.nextInt(4));
            if(this.b) {
               this.a(var1, Blocks.AIR.getBlockData(), 12, 9, 1, var3);
               this.a(var1, var3, var2, 12, 8, 1, class_od.a(a, new class_od[]{Items.ENCHANTED_BOOK.a(var2, 1, 5, 2)}), 1 + var2.nextInt(4));
            }

            return true;
         }
      }

      static {
         a = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.BOOK, 0, 1, 3, 20), new class_od(Items.PAPER, 0, 2, 7, 20), new class_od(Items.MAP, 0, 1, 1, 1), new class_od(Items.COMPASS, 0, 1, 1, 1)}));
      }
   }

   public static class class_h_in_class_asj extends class_asj.class_p_in_class_asj {
      public class_h_in_class_asj() {
      }

      public class_h_in_class_asj(int var1, Random var2, StructureBoundingBox var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.d = this.a(var2);
         this.l = var3;
      }

      public void a(StructurePiece var1, List var2, Random var3) {
         this.a((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 1);
      }

      public static class_asj.class_h_in_class_asj a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         StructureBoundingBox var7 = StructureBoundingBox.a(var2, var3, var4, -1, -1, 0, 9, 5, 11, var5);
         return a(var7) && StructurePiece.a(var0, var7) == null?new class_asj.class_h_in_class_asj(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 8, 4, 10, true, var2, class_asj.e);
            this.a(var1, var2, var3, this.d, 1, 1, 0);
            this.a(var1, var3, 1, 1, 10, 3, 3, 10, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(var1, var3, 4, 1, 1, 4, 3, 1, false, var2, class_asj.e);
            this.a(var1, var3, 4, 1, 3, 4, 3, 3, false, var2, class_asj.e);
            this.a(var1, var3, 4, 1, 7, 4, 3, 7, false, var2, class_asj.e);
            this.a(var1, var3, 4, 1, 9, 4, 3, 9, false, var2, class_asj.e);
            this.a(var1, var3, 4, 1, 4, 4, 3, 6, Blocks.IRON_BARS.getBlockData(), Blocks.IRON_BARS.getBlockData(), false);
            this.a(var1, var3, 5, 1, 5, 7, 3, 5, Blocks.IRON_BARS.getBlockData(), Blocks.IRON_BARS.getBlockData(), false);
            this.a(var1, Blocks.IRON_BARS.getBlockData(), 4, 3, 2, var3);
            this.a(var1, Blocks.IRON_BARS.getBlockData(), 4, 3, 8, var3);
            IBlockData var4 = Blocks.IRON_DOOR.getBlockData().set(BlockDoor.a, EnumDirection.WEST);
            IBlockData var5 = Blocks.IRON_DOOR.getBlockData().set(BlockDoor.a, EnumDirection.WEST).set(BlockDoor.P, BlockDoor.class_a_in_class_ahl.a);
            this.a(var1, var4, 4, 1, 2, var3);
            this.a(var1, var5, 4, 2, 2, var3);
            this.a(var1, var4, 4, 1, 8, var3);
            this.a(var1, var5, 4, 2, 8, var3);
            return true;
         }
      }
   }

   public static class class_j_in_class_asj extends class_asj.class_p_in_class_asj {
      private static final List b;
      protected int a;

      public class_j_in_class_asj() {
      }

      public class_j_in_class_asj(int var1, Random var2, StructureBoundingBox var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.d = this.a(var2);
         this.l = var3;
         this.a = var2.nextInt(5);
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Type", this.a);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.a = var1.getInt("Type");
      }

      public void a(StructurePiece var1, List var2, Random var3) {
         this.a((class_asj.class_m_in_class_asj)var1, var2, var3, 4, 1);
         this.b((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 4);
         this.c((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 4);
      }

      public static class_asj.class_j_in_class_asj a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         StructureBoundingBox var7 = StructureBoundingBox.a(var2, var3, var4, -4, -1, 0, 11, 7, 11, var5);
         return a(var7) && StructurePiece.a(var0, var7) == null?new class_asj.class_j_in_class_asj(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 10, 6, 10, true, var2, class_asj.e);
            this.a(var1, var2, var3, this.d, 4, 1, 0);
            this.a(var1, var3, 4, 1, 10, 6, 3, 10, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(var1, var3, 0, 1, 4, 0, 3, 6, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(var1, var3, 10, 1, 4, 10, 3, 6, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            int var4;
            switch(this.a) {
            case 0:
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 5, 1, 5, var3);
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 5, 2, 5, var3);
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 5, 3, 5, var3);
               this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.WEST), 4, 3, 5, var3);
               this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.EAST), 6, 3, 5, var3);
               this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.SOUTH), 5, 3, 4, var3);
               this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.NORTH), 5, 3, 6, var3);
               this.a(var1, Blocks.STONE_SLAB.getBlockData(), 4, 1, 4, var3);
               this.a(var1, Blocks.STONE_SLAB.getBlockData(), 4, 1, 5, var3);
               this.a(var1, Blocks.STONE_SLAB.getBlockData(), 4, 1, 6, var3);
               this.a(var1, Blocks.STONE_SLAB.getBlockData(), 6, 1, 4, var3);
               this.a(var1, Blocks.STONE_SLAB.getBlockData(), 6, 1, 5, var3);
               this.a(var1, Blocks.STONE_SLAB.getBlockData(), 6, 1, 6, var3);
               this.a(var1, Blocks.STONE_SLAB.getBlockData(), 5, 1, 4, var3);
               this.a(var1, Blocks.STONE_SLAB.getBlockData(), 5, 1, 6, var3);
               break;
            case 1:
               for(var4 = 0; var4 < 5; ++var4) {
                  this.a(var1, Blocks.STONEBRICK.getBlockData(), 3, 1, 3 + var4, var3);
                  this.a(var1, Blocks.STONEBRICK.getBlockData(), 7, 1, 3 + var4, var3);
                  this.a(var1, Blocks.STONEBRICK.getBlockData(), 3 + var4, 1, 3, var3);
                  this.a(var1, Blocks.STONEBRICK.getBlockData(), 3 + var4, 1, 7, var3);
               }

               this.a(var1, Blocks.STONEBRICK.getBlockData(), 5, 1, 5, var3);
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 5, 2, 5, var3);
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 5, 3, 5, var3);
               this.a(var1, Blocks.FLOWING_WATER.getBlockData(), 5, 4, 5, var3);
               break;
            case 2:
               for(var4 = 1; var4 <= 9; ++var4) {
                  this.a(var1, Blocks.COBBLESTONE.getBlockData(), 1, 3, var4, var3);
                  this.a(var1, Blocks.COBBLESTONE.getBlockData(), 9, 3, var4, var3);
               }

               for(var4 = 1; var4 <= 9; ++var4) {
                  this.a(var1, Blocks.COBBLESTONE.getBlockData(), var4, 3, 1, var3);
                  this.a(var1, Blocks.COBBLESTONE.getBlockData(), var4, 3, 9, var3);
               }

               this.a(var1, Blocks.COBBLESTONE.getBlockData(), 5, 1, 4, var3);
               this.a(var1, Blocks.COBBLESTONE.getBlockData(), 5, 1, 6, var3);
               this.a(var1, Blocks.COBBLESTONE.getBlockData(), 5, 3, 4, var3);
               this.a(var1, Blocks.COBBLESTONE.getBlockData(), 5, 3, 6, var3);
               this.a(var1, Blocks.COBBLESTONE.getBlockData(), 4, 1, 5, var3);
               this.a(var1, Blocks.COBBLESTONE.getBlockData(), 6, 1, 5, var3);
               this.a(var1, Blocks.COBBLESTONE.getBlockData(), 4, 3, 5, var3);
               this.a(var1, Blocks.COBBLESTONE.getBlockData(), 6, 3, 5, var3);

               for(var4 = 1; var4 <= 3; ++var4) {
                  this.a(var1, Blocks.COBBLESTONE.getBlockData(), 4, var4, 4, var3);
                  this.a(var1, Blocks.COBBLESTONE.getBlockData(), 6, var4, 4, var3);
                  this.a(var1, Blocks.COBBLESTONE.getBlockData(), 4, var4, 6, var3);
                  this.a(var1, Blocks.COBBLESTONE.getBlockData(), 6, var4, 6, var3);
               }

               this.a(var1, Blocks.TORCH.getBlockData(), 5, 3, 5, var3);

               for(var4 = 2; var4 <= 8; ++var4) {
                  this.a(var1, Blocks.PLANKS.getBlockData(), 2, 3, var4, var3);
                  this.a(var1, Blocks.PLANKS.getBlockData(), 3, 3, var4, var3);
                  if(var4 <= 3 || var4 >= 7) {
                     this.a(var1, Blocks.PLANKS.getBlockData(), 4, 3, var4, var3);
                     this.a(var1, Blocks.PLANKS.getBlockData(), 5, 3, var4, var3);
                     this.a(var1, Blocks.PLANKS.getBlockData(), 6, 3, var4, var3);
                  }

                  this.a(var1, Blocks.PLANKS.getBlockData(), 7, 3, var4, var3);
                  this.a(var1, Blocks.PLANKS.getBlockData(), 8, 3, var4, var3);
               }

               IBlockData var5 = Blocks.LADDER.getBlockData().set(BlockLadder.a, EnumDirection.WEST);
               this.a(var1, var5, 9, 1, 3, var3);
               this.a(var1, var5, 9, 2, 3, var3);
               this.a(var1, var5, 9, 3, 3, var3);
               this.a(var1, var3, var2, 3, 4, 8, class_od.a(b, new class_od[]{Items.ENCHANTED_BOOK.b(var2)}), 1 + var2.nextInt(4));
            }

            return true;
         }
      }

      static {
         b = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.IRON_INGOT, 0, 1, 5, 10), new class_od(Items.GOLD_INGOT, 0, 1, 3, 5), new class_od(Items.REDSTONE, 0, 4, 9, 5), new class_od(Items.COAL, 0, 3, 8, 10), new class_od(Items.BREAD, 0, 1, 3, 15), new class_od(Items.APPLE, 0, 1, 3, 15), new class_od(Items.IRON_PICKAXE, 0, 1, 1, 1)}));
      }
   }

   public static class class_i_in_class_asj extends class_asj.class_d_in_class_asj {
      public void a(StructurePiece var1, List var2, Random var3) {
         EnumDirection var4 = this.e();
         if(var4 != EnumDirection.NORTH && var4 != EnumDirection.EAST) {
            this.b((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 1);
         } else {
            this.c((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 1);
         }

      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 4, 4, 4, true, var2, class_asj.e);
            this.a(var1, var2, var3, this.d, 1, 1, 0);
            EnumDirection var4 = this.e();
            if(var4 != EnumDirection.NORTH && var4 != EnumDirection.EAST) {
               this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            } else {
               this.a(var1, var3, 4, 1, 1, 4, 3, 3, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            }

            return true;
         }
      }
   }

   public static class class_d_in_class_asj extends class_asj.class_p_in_class_asj {
      public class_d_in_class_asj() {
      }

      public class_d_in_class_asj(int var1, Random var2, StructureBoundingBox var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.d = this.a(var2);
         this.l = var3;
      }

      public void a(StructurePiece var1, List var2, Random var3) {
         EnumDirection var4 = this.e();
         if(var4 != EnumDirection.NORTH && var4 != EnumDirection.EAST) {
            this.c((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 1);
         } else {
            this.b((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 1);
         }

      }

      public static class_asj.class_d_in_class_asj a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         StructureBoundingBox var7 = StructureBoundingBox.a(var2, var3, var4, -1, -1, 0, 5, 5, 5, var5);
         return a(var7) && StructurePiece.a(var0, var7) == null?new class_asj.class_d_in_class_asj(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 4, 4, 4, true, var2, class_asj.e);
            this.a(var1, var2, var3, this.d, 1, 1, 0);
            EnumDirection var4 = this.e();
            if(var4 != EnumDirection.NORTH && var4 != EnumDirection.EAST) {
               this.a(var1, var3, 4, 1, 1, 4, 3, 3, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            } else {
               this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            }

            return true;
         }
      }
   }

   public static class class_o_in_class_asj extends class_asj.class_p_in_class_asj {
      public class_o_in_class_asj() {
      }

      public class_o_in_class_asj(int var1, Random var2, StructureBoundingBox var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.d = this.a(var2);
         this.l = var3;
      }

      public void a(StructurePiece var1, List var2, Random var3) {
         this.a((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 1);
      }

      public static class_asj.class_o_in_class_asj a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         StructureBoundingBox var7 = StructureBoundingBox.a(var2, var3, var4, -1, -7, 0, 5, 11, 8, var5);
         return a(var7) && StructurePiece.a(var0, var7) == null?new class_asj.class_o_in_class_asj(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 4, 10, 7, true, var2, class_asj.e);
            this.a(var1, var2, var3, this.d, 1, 7, 0);
            this.a(var1, var2, var3, class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.a, 1, 1, 7);
            IBlockData var4 = Blocks.STONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.SOUTH);

            for(int var5 = 0; var5 < 6; ++var5) {
               this.a(var1, var4, 1, 6 - var5, 1 + var5, var3);
               this.a(var1, var4, 2, 6 - var5, 1 + var5, var3);
               this.a(var1, var4, 3, 6 - var5, 1 + var5, var3);
               if(var5 < 5) {
                  this.a(var1, Blocks.STONEBRICK.getBlockData(), 1, 5 - var5, 1 + var5, var3);
                  this.a(var1, Blocks.STONEBRICK.getBlockData(), 2, 5 - var5, 1 + var5, var3);
                  this.a(var1, Blocks.STONEBRICK.getBlockData(), 3, 5 - var5, 1 + var5, var3);
               }
            }

            return true;
         }
      }
   }

   public static class class_a_in_class_asj extends class_asj.class_p_in_class_asj {
      private static final List a;
      private boolean b;

      public class_a_in_class_asj() {
      }

      public class_a_in_class_asj(int var1, Random var2, StructureBoundingBox var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.d = this.a(var2);
         this.l = var3;
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Chest", this.b);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.b = var1.getBoolean("Chest");
      }

      public void a(StructurePiece var1, List var2, Random var3) {
         this.a((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 1);
      }

      public static class_asj.class_a_in_class_asj a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         StructureBoundingBox var7 = StructureBoundingBox.a(var2, var3, var4, -1, -1, 0, 5, 5, 7, var5);
         return a(var7) && StructurePiece.a(var0, var7) == null?new class_asj.class_a_in_class_asj(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 4, 4, 6, true, var2, class_asj.e);
            this.a(var1, var2, var3, this.d, 1, 1, 0);
            this.a(var1, var2, var3, class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.a, 1, 1, 6);
            this.a(var1, var3, 3, 1, 2, 3, 1, 4, Blocks.STONEBRICK.getBlockData(), Blocks.STONEBRICK.getBlockData(), false);
            this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.SMOOTHBRICK.getId()), 3, 1, 1, var3);
            this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.SMOOTHBRICK.getId()), 3, 1, 5, var3);
            this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.SMOOTHBRICK.getId()), 3, 2, 2, var3);
            this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.SMOOTHBRICK.getId()), 3, 2, 4, var3);

            for(int var4 = 2; var4 <= 4; ++var4) {
               this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.SMOOTHBRICK.getId()), 2, 1, var4, var3);
            }

            if(!this.b && var3.b((BaseBlockPosition)(new BlockPosition(this.a(3, 3), this.d(2), this.b(3, 3))))) {
               this.b = true;
               this.a(var1, var3, var2, 3, 2, 3, class_od.a(a, new class_od[]{Items.ENCHANTED_BOOK.b(var2)}), 2 + var2.nextInt(2));
            }

            return true;
         }
      }

      static {
         a = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.ENDER_PEARL, 0, 1, 1, 10), new class_od(Items.DIAMOND, 0, 1, 3, 3), new class_od(Items.IRON_INGOT, 0, 1, 5, 10), new class_od(Items.GOLD_INGOT, 0, 1, 3, 5), new class_od(Items.REDSTONE, 0, 4, 9, 5), new class_od(Items.BREAD, 0, 1, 3, 15), new class_od(Items.APPLE, 0, 1, 3, 15), new class_od(Items.IRON_PICKAXE, 0, 1, 1, 5), new class_od(Items.IRON_SWORD, 0, 1, 1, 5), new class_od(Items.IRON_CHESTPLATE, 0, 1, 1, 5), new class_od(Items.IRON_HELMET, 0, 1, 1, 5), new class_od(Items.IRON_LEGGINGS, 0, 1, 1, 5), new class_od(Items.IRON_BOOTS, 0, 1, 1, 5), new class_od(Items.GOLDEN_APPLE, 0, 1, 1, 1), new class_od(Items.SADDLE, 0, 1, 1, 1), new class_od(Items.IRON_HORSE_ARMOR, 0, 1, 1, 1), new class_od(Items.GOLDEN_HORSE_ARMOR, 0, 1, 1, 1), new class_od(Items.DIAMOND_HORSE_ARMOR, 0, 1, 1, 1)}));
      }
   }

   public static class class_n_in_class_asj extends class_asj.class_p_in_class_asj {
      private boolean a;
      private boolean b;

      public class_n_in_class_asj() {
      }

      public class_n_in_class_asj(int var1, Random var2, StructureBoundingBox var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.d = this.a(var2);
         this.l = var3;
         this.a = var2.nextInt(2) == 0;
         this.b = var2.nextInt(2) == 0;
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Left", this.a);
         var1.put("Right", this.b);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.a = var1.getBoolean("Left");
         this.b = var1.getBoolean("Right");
      }

      public void a(StructurePiece var1, List var2, Random var3) {
         this.a((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 1);
         if(this.a) {
            this.b((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 2);
         }

         if(this.b) {
            this.c((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 2);
         }

      }

      public static class_asj.class_n_in_class_asj a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         StructureBoundingBox var7 = StructureBoundingBox.a(var2, var3, var4, -1, -1, 0, 5, 5, 7, var5);
         return a(var7) && StructurePiece.a(var0, var7) == null?new class_asj.class_n_in_class_asj(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 4, 4, 6, true, var2, class_asj.e);
            this.a(var1, var2, var3, this.d, 1, 1, 0);
            this.a(var1, var2, var3, class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.a, 1, 1, 6);
            IBlockData var4 = Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.EAST);
            IBlockData var5 = Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.WEST);
            this.a(var1, var3, var2, 0.1F, 1, 2, 1, var4);
            this.a(var1, var3, var2, 0.1F, 3, 2, 1, var5);
            this.a(var1, var3, var2, 0.1F, 1, 2, 5, var4);
            this.a(var1, var3, var2, 0.1F, 3, 2, 5, var5);
            if(this.a) {
               this.a(var1, var3, 0, 1, 2, 0, 3, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            }

            if(this.b) {
               this.a(var1, var3, 4, 1, 2, 4, 3, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            }

            return true;
         }
      }
   }

   public static class class_m_in_class_asj extends class_asj.class_l_in_class_asj {
      public class_asj.class_f_in_class_asj a;
      public class_asj.class_g_in_class_asj b;
      public List c = Lists.newArrayList();

      public class_m_in_class_asj() {
      }

      public class_m_in_class_asj(int var1, Random var2, int var3, int var4) {
         super(0, var2, var3, var4);
      }

      public BlockPosition a() {
         return this.b != null?this.b.a():super.a();
      }
   }

   public static class class_l_in_class_asj extends class_asj.class_p_in_class_asj {
      private boolean a;

      public class_l_in_class_asj() {
      }

      public class_l_in_class_asj(int var1, Random var2, int var3, int var4) {
         super(var1);
         this.a = true;
         this.a(EnumDirection.EnumDirectionLimit.HORIZONTAL.getRandomDirection(var2));
         this.d = class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.a;
         if(this.e().getAxis() == EnumDirection.EnumAxis.Z) {
            this.l = new StructureBoundingBox(var3, 64, var4, var3 + 5 - 1, 74, var4 + 5 - 1);
         } else {
            this.l = new StructureBoundingBox(var3, 64, var4, var3 + 5 - 1, 74, var4 + 5 - 1);
         }

      }

      public class_l_in_class_asj(int var1, Random var2, StructureBoundingBox var3, EnumDirection var4) {
         super(var1);
         this.a = false;
         this.a(var4);
         this.d = this.a(var2);
         this.l = var3;
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Source", this.a);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.a = var1.getBoolean("Source");
      }

      public void a(StructurePiece var1, List var2, Random var3) {
         if(this.a) {
            class_asj.d = class_asj.class_c_in_class_asj.class;
         }

         this.a((class_asj.class_m_in_class_asj)var1, var2, var3, 1, 1);
      }

      public static class_asj.class_l_in_class_asj a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5, int var6) {
         StructureBoundingBox var7 = StructureBoundingBox.a(var2, var3, var4, -1, -7, 0, 5, 11, 5, var5);
         return a(var7) && StructurePiece.a(var0, var7) == null?new class_asj.class_l_in_class_asj(var6, var1, var7, var5):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 4, 10, 4, true, var2, class_asj.e);
            this.a(var1, var2, var3, this.d, 1, 7, 0);
            this.a(var1, var2, var3, class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.a, 1, 1, 4);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), 2, 6, 1, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), 1, 5, 1, var3);
            this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE.getId()), 1, 6, 1, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), 1, 5, 2, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), 1, 4, 3, var3);
            this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE.getId()), 1, 5, 3, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), 2, 4, 3, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), 3, 3, 3, var3);
            this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE.getId()), 3, 4, 3, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), 3, 3, 2, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), 3, 2, 1, var3);
            this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE.getId()), 3, 3, 1, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), 2, 2, 1, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), 1, 1, 1, var3);
            this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE.getId()), 1, 2, 1, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), 1, 1, 2, var3);
            this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE.getId()), 1, 1, 3, var3);
            return true;
         }
      }
   }

   public static class class_b_in_class_asj extends class_asj.class_p_in_class_asj {
      private int a;

      public class_b_in_class_asj() {
      }

      public class_b_in_class_asj(int var1, Random var2, StructureBoundingBox var3, EnumDirection var4) {
         super(var1);
         this.a(var4);
         this.l = var3;
         this.a = var4 != EnumDirection.NORTH && var4 != EnumDirection.SOUTH?var3.c():var3.e();
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Steps", this.a);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.a = var1.getInt("Steps");
      }

      public static StructureBoundingBox a(List var0, Random var1, int var2, int var3, int var4, EnumDirection var5) {
         boolean var6 = true;
         StructureBoundingBox var7 = StructureBoundingBox.a(var2, var3, var4, -1, -1, 0, 5, 5, 4, var5);
         StructurePiece var8 = StructurePiece.a(var0, var7);
         if(var8 == null) {
            return null;
         } else {
            if(var8.c().b == var7.b) {
               for(int var9 = 3; var9 >= 1; --var9) {
                  var7 = StructureBoundingBox.a(var2, var3, var4, -1, -1, 0, 5, 5, var9 - 1, var5);
                  if(!var8.c().a(var7)) {
                     return StructureBoundingBox.a(var2, var3, var4, -1, -1, 0, 5, 5, var9, var5);
                  }
               }
            }

            return null;
         }
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.a(var1, var3)) {
            return false;
         } else {
            for(int var4 = 0; var4 < this.a; ++var4) {
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 0, 0, var4, var3);
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 1, 0, var4, var3);
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 2, 0, var4, var3);
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 3, 0, var4, var3);
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 4, 0, var4, var3);

               for(int var5 = 1; var5 <= 3; ++var5) {
                  this.a(var1, Blocks.STONEBRICK.getBlockData(), 0, var5, var4, var3);
                  this.a(var1, Blocks.AIR.getBlockData(), 1, var5, var4, var3);
                  this.a(var1, Blocks.AIR.getBlockData(), 2, var5, var4, var3);
                  this.a(var1, Blocks.AIR.getBlockData(), 3, var5, var4, var3);
                  this.a(var1, Blocks.STONEBRICK.getBlockData(), 4, var5, var4, var3);
               }

               this.a(var1, Blocks.STONEBRICK.getBlockData(), 0, 4, var4, var3);
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 1, 4, var4, var3);
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 2, 4, var4, var3);
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 3, 4, var4, var3);
               this.a(var1, Blocks.STONEBRICK.getBlockData(), 4, 4, var4, var3);
            }

            return true;
         }
      }
   }

   abstract static class class_p_in_class_asj extends StructurePiece {
      protected class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj d;

      public class_p_in_class_asj() {
         this.d = class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.a;
      }

      protected class_p_in_class_asj(int var1) {
         super(var1);
         this.d = class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.a;
      }

      protected void a(NBTTagCompound var1) {
         var1.put("EntryDoor", this.d.name());
      }

      protected void b(NBTTagCompound var1) {
         this.d = class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.valueOf(var1.getString("EntryDoor"));
      }

      protected void a(World var1, Random var2, StructureBoundingBox var3, class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj var4, int var5, int var6, int var7) {
         switch(class_asj.SyntheticClass_1.a[var4.ordinal()]) {
         case 1:
         default:
            this.a(var1, var3, var5, var6, var7, var5 + 3 - 1, var6 + 3 - 1, var7, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            break;
         case 2:
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5, var6, var7, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5, var6 + 1, var7, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5, var6 + 2, var7, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5 + 1, var6 + 2, var7, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5 + 2, var6 + 2, var7, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5 + 2, var6 + 1, var7, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5 + 2, var6, var7, var3);
            this.a(var1, Blocks.WOODEN_DOOR.getBlockData(), var5 + 1, var6, var7, var3);
            this.a(var1, Blocks.WOODEN_DOOR.getBlockData().set(BlockDoor.P, BlockDoor.class_a_in_class_ahl.a), var5 + 1, var6 + 1, var7, var3);
            break;
         case 3:
            this.a(var1, Blocks.AIR.getBlockData(), var5 + 1, var6, var7, var3);
            this.a(var1, Blocks.AIR.getBlockData(), var5 + 1, var6 + 1, var7, var3);
            this.a(var1, Blocks.IRON_BARS.getBlockData(), var5, var6, var7, var3);
            this.a(var1, Blocks.IRON_BARS.getBlockData(), var5, var6 + 1, var7, var3);
            this.a(var1, Blocks.IRON_BARS.getBlockData(), var5, var6 + 2, var7, var3);
            this.a(var1, Blocks.IRON_BARS.getBlockData(), var5 + 1, var6 + 2, var7, var3);
            this.a(var1, Blocks.IRON_BARS.getBlockData(), var5 + 2, var6 + 2, var7, var3);
            this.a(var1, Blocks.IRON_BARS.getBlockData(), var5 + 2, var6 + 1, var7, var3);
            this.a(var1, Blocks.IRON_BARS.getBlockData(), var5 + 2, var6, var7, var3);
            break;
         case 4:
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5, var6, var7, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5, var6 + 1, var7, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5, var6 + 2, var7, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5 + 1, var6 + 2, var7, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5 + 2, var6 + 2, var7, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5 + 2, var6 + 1, var7, var3);
            this.a(var1, Blocks.STONEBRICK.getBlockData(), var5 + 2, var6, var7, var3);
            this.a(var1, Blocks.IRON_DOOR.getBlockData(), var5 + 1, var6, var7, var3);
            this.a(var1, Blocks.IRON_DOOR.getBlockData().set(BlockDoor.P, BlockDoor.class_a_in_class_ahl.a), var5 + 1, var6 + 1, var7, var3);
            this.a(var1, Blocks.STONE_BUTTON.getBlockData().set(class_agp.FACING, EnumDirection.NORTH), var5 + 2, var6 + 1, var7 + 1, var3);
            this.a(var1, Blocks.STONE_BUTTON.getBlockData().set(class_agp.FACING, EnumDirection.SOUTH), var5 + 2, var6 + 1, var7 - 1, var3);
         }

      }

      protected class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj a(Random var1) {
         int var2 = var1.nextInt(5);
         switch(var2) {
         case 0:
         case 1:
         default:
            return class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.a;
         case 2:
            return class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.b;
         case 3:
            return class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.c;
         case 4:
            return class_asj.class_p_in_class_asj.class_p_in_class_asj$class_a_in_class_p_in_class_asj.d;
         }
      }

      protected StructurePiece a(class_asj.class_m_in_class_asj var1, List var2, Random var3, int var4, int var5) {
         EnumDirection var6 = this.e();
         if(var6 != null) {
            switch(class_asj.SyntheticClass_1.b[var6.ordinal()]) {
            case 1:
               return class_asj.c(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.c - 1, var6, this.d());
            case 2:
               return class_asj.c(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.f + 1, var6, this.d());
            case 3:
               return class_asj.c(var1, var2, var3, this.l.a - 1, this.l.b + var5, this.l.c + var4, var6, this.d());
            case 4:
               return class_asj.c(var1, var2, var3, this.l.d + 1, this.l.b + var5, this.l.c + var4, var6, this.d());
            }
         }

         return null;
      }

      protected StructurePiece b(class_asj.class_m_in_class_asj var1, List var2, Random var3, int var4, int var5) {
         EnumDirection var6 = this.e();
         if(var6 != null) {
            switch(class_asj.SyntheticClass_1.b[var6.ordinal()]) {
            case 1:
               return class_asj.c(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, EnumDirection.WEST, this.d());
            case 2:
               return class_asj.c(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, EnumDirection.WEST, this.d());
            case 3:
               return class_asj.c(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, EnumDirection.NORTH, this.d());
            case 4:
               return class_asj.c(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, EnumDirection.NORTH, this.d());
            }
         }

         return null;
      }

      protected StructurePiece c(class_asj.class_m_in_class_asj var1, List var2, Random var3, int var4, int var5) {
         EnumDirection var6 = this.e();
         if(var6 != null) {
            switch(class_asj.SyntheticClass_1.b[var6.ordinal()]) {
            case 1:
               return class_asj.c(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, EnumDirection.EAST, this.d());
            case 2:
               return class_asj.c(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, EnumDirection.EAST, this.d());
            case 3:
               return class_asj.c(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, EnumDirection.SOUTH, this.d());
            case 4:
               return class_asj.c(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, EnumDirection.SOUTH, this.d());
            }
         }

         return null;
      }

      protected static boolean a(StructureBoundingBox var0) {
         return var0 != null && var0.b > 10;
      }

      public static enum class_p_in_class_asj$class_a_in_class_p_in_class_asj {
         a,
         b,
         c,
         d;
      }
   }

   static class class_f_in_class_asj {
      public Class a;
      public final int b;
      public int c;
      public int d;

      public class_f_in_class_asj(Class var1, int var2, int var3) {
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
