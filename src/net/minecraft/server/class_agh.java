package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_aez;
import net.minecraft.server.Block;
import net.minecraft.server.class_aiv;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fb;
import net.minecraft.server.INamable;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;

public class class_agh extends class_aiv {
   public static final BlockStateEnum a = BlockStateEnum.of("part", class_agh.class_a_in_class_agh.class);
   public static final class_anw b = class_anw.a("occupied");

   public class_agh() {
      super(Material.n);
      this.setBlockData(this.blockStateList.getFirst().set(a, class_agh.class_a_in_class_agh.b).set(b, Boolean.valueOf(false)));
      this.l();
   }

   public boolean a(World var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         if(var3.get(a) != class_agh.class_a_in_class_agh.a) {
            var2 = var2.a((class_cq)var3.get(O));
            var3 = var1.p(var2);
            if(var3.getBlock() != this) {
               return true;
            }
         }

         if(var1.t.e() && var1.b(var2) != class_aez.x) {
            if(((Boolean)var3.get(b)).booleanValue()) {
               class_xa var12 = this.f(var1, var2);
               if(var12 != null) {
                  var4.b((class_eu)(new class_fb("tile.bed.occupied", new Object[0])));
                  return true;
               }

               var3 = var3.set(b, Boolean.valueOf(false));
               var1.a((class_cj)var2, (IBlockData)var3, 4);
            }

            class_xa.class_a_in_class_xa var13 = var4.a(var2);
            if(var13 == class_xa.class_a_in_class_xa.a) {
               var3 = var3.set(b, Boolean.valueOf(true));
               var1.a((class_cj)var2, (IBlockData)var3, 4);
               return true;
            } else {
               if(var13 == class_xa.class_a_in_class_xa.c) {
                  var4.b((class_eu)(new class_fb("tile.bed.noSleep", new Object[0])));
               } else if(var13 == class_xa.class_a_in_class_xa.f) {
                  var4.b((class_eu)(new class_fb("tile.bed.notSafe", new Object[0])));
               }

               return true;
            }
         } else {
            var1.g(var2);
            class_cj var11 = var2.a(((class_cq)var3.get(O)).d());
            if(var1.p(var11).getBlock() == this) {
               var1.g(var11);
            }

            var1.a((class_pr)null, (double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, 5.0F, true, true);
            return true;
         }
      }
   }

   private class_xa f(World var1, class_cj var2) {
      Iterator var3 = var1.j.iterator();

      class_xa var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (class_xa)var3.next();
      } while(!var4.bK() || !var4.bE.equals(var2));

      return var4;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public void a(class_aer var1, class_cj var2) {
      this.l();
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      class_cq var5 = (class_cq)var3.get(O);
      if(var3.get(a) == class_agh.class_a_in_class_agh.a) {
         if(var1.p(var2.a(var5.d())).getBlock() != this) {
            var1.g(var2);
         }
      } else if(var1.p(var2.a(var5)).getBlock() != this) {
         var1.g(var2);
         if(!var1.D) {
            this.b(var1, var2, var3, 0);
         }
      }

   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return var1.get(a) == class_agh.class_a_in_class_agh.a?null:Items.bc;
   }

   private void l() {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
   }

   public static class_cj a(World var0, class_cj var1, int var2) {
      class_cq var3 = (class_cq)var0.p(var1).get(O);
      int var4 = var1.n();
      int var5 = var1.o();
      int var6 = var1.p();

      for(int var7 = 0; var7 <= 1; ++var7) {
         int var8 = var4 - var3.g() * var7 - 1;
         int var9 = var6 - var3.i() * var7 - 1;
         int var10 = var8 + 2;
         int var11 = var9 + 2;

         for(int var12 = var8; var12 <= var10; ++var12) {
            for(int var13 = var9; var13 <= var11; ++var13) {
               class_cj var14 = new class_cj(var12, var5, var13);
               if(e(var0, var14)) {
                  if(var2 <= 0) {
                     return var14;
                  }

                  --var2;
               }
            }
         }
      }

      return null;
   }

   protected static boolean e(World var0, class_cj var1) {
      return World.a((class_aer)var0, (class_cj)var1.b()) && !var0.p(var1).getBlock().getMaterial().a() && !var0.p(var1.a()).getBlock().getMaterial().a();
   }

   public void a(World var1, class_cj var2, IBlockData var3, float var4, int var5) {
      if(var3.get(a) == class_agh.class_a_in_class_agh.b) {
         super.a(var1, var2, var3, var4, 0);
      }

   }

   public int k() {
      return 1;
   }

   public void a(World var1, class_cj var2, IBlockData var3, class_xa var4) {
      if(var4.bH.d && var3.get(a) == class_agh.class_a_in_class_agh.a) {
         class_cj var5 = var2.a(((class_cq)var3.get(O)).d());
         if(var1.p(var5).getBlock() == this) {
            var1.g(var5);
         }
      }

   }

   public IBlockData fromLegacyData(int var1) {
      class_cq var2 = class_cq.b(var1);
      return (var1 & 8) > 0?this.getBlockData().set(a, class_agh.class_a_in_class_agh.a).set(O, var2).set(b, Boolean.valueOf((var1 & 4) > 0)):this.getBlockData().set(a, class_agh.class_a_in_class_agh.b).set(O, var2);
   }

   public IBlockData a(IBlockData var1, class_aer var2, class_cj var3) {
      if(var1.get(a) == class_agh.class_a_in_class_agh.b) {
         IBlockData var4 = var2.p(var3.a((class_cq)var1.get(O)));
         if(var4.getBlock() == this) {
            var1 = var1.set(b, var4.get(b));
         }
      }

      return var1;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(O, var2.a((class_cq)var1.get(O)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((class_cq)var1.get(O)));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_cq)var1.get(O)).b();
      if(var1.get(a) == class_agh.class_a_in_class_agh.a) {
         var3 |= 8;
         if(((Boolean)var1.get(b)).booleanValue()) {
            var3 |= 4;
         }
      }

      return var3;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{O, a, b});
   }

   public static enum class_a_in_class_agh implements INamable {
      a("head"),
      b("foot");

      private final String c;

      private class_a_in_class_agh(String var3) {
         this.c = var3;
      }

      public String toString() {
         return this.c;
      }

      public String getName() {
         return this.c;
      }
   }
}
