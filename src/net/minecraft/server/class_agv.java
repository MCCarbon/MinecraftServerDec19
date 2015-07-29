package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_agv extends Block {
   public static final class_anz a = class_anz.a("age", 0, 5);

   protected class_agv() {
      super(Material.k);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
      this.a(CreativeTab.c);
      this.setTicking(true);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return null;
   }

   public void b(World var1, class_cj var2, IBlockData var3, Random var4) {
      if(!this.e(var1, var2)) {
         var1.b(var2, true);
      } else if(var1.d(var2.a())) {
         int var5 = ((Integer)var3.get(a)).intValue();
         if(var5 < 5 && var4.nextInt(1) == 0) {
            boolean var6 = false;
            boolean var7 = false;
            Block var8 = var1.p(var2.b()).getBlock();
            int var9;
            if(var8 == Blocks.END_STONE) {
               var6 = true;
            } else if(var8 != Blocks.CHORUS_PLANT) {
               if(var8 == Blocks.AIR) {
                  var6 = true;
               }
            } else {
               var9 = 1;

               int var10;
               for(var10 = 0; var10 < 4; ++var10) {
                  Block var11 = var1.p(var2.c(var9 + 1)).getBlock();
                  if(var11 != Blocks.CHORUS_PLANT) {
                     if(var11 == Blocks.END_STONE) {
                        var7 = true;
                     }
                     break;
                  }

                  ++var9;
               }

               var10 = 4;
               if(var7) {
                  ++var10;
               }

               if(var9 < 2 || var4.nextInt(var10) >= var9) {
                  var6 = true;
               }
            }

            if(var6 && a(var1, var2.a(), (class_cq)null) && var1.d(var2.b(2))) {
               var1.a((class_cj)var2, (IBlockData)Blocks.CHORUS_PLANT.getBlockData(), 2);
               var1.a((class_cj)var2.a(), (IBlockData)this.getBlockData().set(a, Integer.valueOf(var5)), 2);
            } else if(var5 < 4) {
               var9 = var4.nextInt(4);
               boolean var15 = false;
               if(var7) {
                  ++var9;
               }

               for(int var14 = 0; var14 < var9; ++var14) {
                  class_cq var12 = class_cq.class_c_in_class_cq.a.a(var4);
                  class_cj var13 = var2.a(var12);
                  if(var1.d(var13) && var1.d(var13.b()) && a(var1, var13, var12.d())) {
                     var1.a((class_cj)var13, (IBlockData)this.getBlockData().set(a, Integer.valueOf(var5 + 1)), 2);
                     var15 = true;
                  }
               }

               if(var15) {
                  var1.a((class_cj)var2, (IBlockData)Blocks.CHORUS_PLANT.getBlockData(), 2);
               } else {
                  var1.a((class_cj)var2, (IBlockData)var3.set(a, Integer.valueOf(5)), 2);
               }
            } else if(var5 == 4) {
               var1.a((class_cj)var2, (IBlockData)var3.set(a, Integer.valueOf(5)), 2);
            }
         }
      }

   }

   private static boolean a(World var0, class_cj var1, class_cq var2) {
      Iterator var3 = class_cq.class_c_in_class_cq.a.iterator();

      class_cq var4;
      do {
         if(!var3.hasNext()) {
            return true;
         }

         var4 = (class_cq)var3.next();
      } while(var4 == var2 || var0.d(var1.a(var4)));

      return false;
   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      return super.a(var1, var2, var3);
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean d(World var1, class_cj var2) {
      return super.d(var1, var2)?this.e(var1, var2):false;
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      if(!this.e(var1, var2)) {
         var1.a((class_cj)var2, (Block)this, 1);
      }

   }

   public boolean e(World var1, class_cj var2) {
      Block var3 = var1.p(var2.b()).getBlock();
      if(var3 != Blocks.CHORUS_PLANT && var3 != Blocks.END_STONE) {
         if(var3 == Blocks.AIR) {
            int var4 = 0;
            Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

            while(var5.hasNext()) {
               class_cq var6 = (class_cq)var5.next();
               Block var7 = var1.p(var2.a(var6)).getBlock();
               if(var7 == Blocks.CHORUS_PLANT) {
                  ++var4;
               } else if(var7 != Blocks.AIR) {
                  return false;
               }
            }

            return var4 == 1;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public void a(World var1, class_xa var2, class_cj var3, IBlockData var4, class_amg var5, class_aas var6) {
      super.a(var1, var2, var3, var4, var5, var6);
      a(var1, var3, (class_aas)(new class_aas(Item.getByBlock((Block)this))));
   }

   protected class_aas i(IBlockData var1) {
      return null;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   public void c(World var1, class_cj var2, IBlockData var3) {
      super.c(var1, var2, var3);
   }

   public static void a(World var0, class_cj var1, Random var2, int var3) {
      var0.a((class_cj)var1, (IBlockData)Blocks.CHORUS_PLANT.getBlockData(), 2);
      a(var0, var1, var2, var1, var3, 0);
   }

   private static void a(World var0, class_cj var1, Random var2, class_cj var3, int var4, int var5) {
      int var6 = var2.nextInt(4) + 1;
      if(var5 == 0) {
         ++var6;
      }

      for(int var7 = 0; var7 < var6; ++var7) {
         class_cj var8 = var1.b(var7 + 1);
         if(!a(var0, var8, (class_cq)null)) {
            return;
         }

         var0.a((class_cj)var8, (IBlockData)Blocks.CHORUS_PLANT.getBlockData(), 2);
      }

      boolean var12 = false;
      if(var5 < 4) {
         int var13 = var2.nextInt(4);
         if(var5 == 0) {
            ++var13;
         }

         for(int var9 = 0; var9 < var13; ++var9) {
            class_cq var10 = class_cq.class_c_in_class_cq.a.a(var2);
            class_cj var11 = var1.b(var6).a(var10);
            if(Math.abs(var11.n() - var3.n()) < var4 && Math.abs(var11.p() - var3.p()) < var4 && var0.d(var11) && var0.d(var11.b()) && a(var0, var11, var10.d())) {
               var12 = true;
               var0.a((class_cj)var11, (IBlockData)Blocks.CHORUS_PLANT.getBlockData(), 2);
               a(var0, var11, var2, var3, var4, var5 + 1);
            }
         }
      }

      if(!var12) {
         var0.a((class_cj)var1.b(var6), (IBlockData)Blocks.CHORUS_FLOWER.getBlockData().set(a, Integer.valueOf(5)), 2);
      }

   }
}
