package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aiv;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anx;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.INamable;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_xa;

public class class_ahl extends Block {
   public static final class_anx a;
   public static final class_anw b;
   public static final BlockStateEnum N;
   public static final class_anw O;
   public static final BlockStateEnum P;

   protected class_ahl(Material var1) {
      super(var1);
      this.setBlockData(this.blockStateList.getFirst().set(a, class_cq.c).set(b, Boolean.valueOf(false)).set(N, class_ahl.class_b_in_class_ahl.a).set(O, Boolean.valueOf(false)).set(P, class_ahl.class_a_in_class_ahl.b));
   }

   public String getName() {
      return LocaleI18n.get((this.getInternalName() + ".name").replaceAll("tile", "item"));
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isPassable(class_aer var1, class_cj var2) {
      return g(e(var1, var2));
   }

   public boolean isFullCube() {
      return false;
   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      this.a((class_aer)var1, (class_cj)var2);
      return super.a(var1, var2, var3);
   }

   public void a(class_aer var1, class_cj var2) {
      this.k(e(var1, var2));
   }

   private void k(int var1) {
      float var2 = 0.1875F;
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
      class_cq var3 = f(var1);
      boolean var4 = g(var1);
      boolean var5 = j(var1);
      if(var4) {
         if(var3 == class_cq.f) {
            if(!var5) {
               this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            } else {
               this.setSizes(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            }
         } else if(var3 == class_cq.d) {
            if(!var5) {
               this.setSizes(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else {
               this.setSizes(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            }
         } else if(var3 == class_cq.e) {
            if(!var5) {
               this.setSizes(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            } else {
               this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            }
         } else if(var3 == class_cq.c) {
            if(!var5) {
               this.setSizes(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            } else {
               this.setSizes(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
         }
      } else if(var3 == class_cq.f) {
         this.setSizes(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
      } else if(var3 == class_cq.d) {
         this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
      } else if(var3 == class_cq.e) {
         this.setSizes(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else if(var3 == class_cq.c) {
         this.setSizes(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
      }

   }

   public boolean a(World var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(this.material == Material.f) {
         return true;
      } else {
         class_cj var11 = var3.get(P) == class_ahl.class_a_in_class_ahl.b?var2:var2.b();
         IBlockData var12 = var2.equals(var11)?var3:var1.p(var11);
         if(var12.getBlock() != this) {
            return false;
         } else {
            var3 = var12.a(b);
            var1.a((class_cj)var11, (IBlockData)var3, 2);
            var1.b(var11, var2);
            var1.a(var4, ((Boolean)var3.get(b)).booleanValue()?1003:1006, var2, 0);
            return true;
         }
      }
   }

   public void a(World var1, class_cj var2, boolean var3) {
      IBlockData var4 = var1.p(var2);
      if(var4.getBlock() == this) {
         class_cj var5 = var4.get(P) == class_ahl.class_a_in_class_ahl.b?var2:var2.b();
         IBlockData var6 = var2 == var5?var4:var1.p(var5);
         if(var6.getBlock() == this && ((Boolean)var6.get(b)).booleanValue() != var3) {
            var1.a((class_cj)var5, (IBlockData)var6.set(b, Boolean.valueOf(var3)), 2);
            var1.b(var5, var2);
            var1.a((class_xa)null, var3?1003:1006, var2, 0);
         }

      }
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      if(var3.get(P) == class_ahl.class_a_in_class_ahl.a) {
         class_cj var5 = var2.b();
         IBlockData var6 = var1.p(var5);
         if(var6.getBlock() != this) {
            var1.g(var2);
         } else if(var4 != this) {
            this.a(var1, var5, var6, var4);
         }
      } else {
         boolean var9 = false;
         class_cj var10 = var2.a();
         IBlockData var7 = var1.p(var10);
         if(var7.getBlock() != this) {
            var1.g(var2);
            var9 = true;
         }

         if(!World.a((class_aer)var1, (class_cj)var2.b())) {
            var1.g(var2);
            var9 = true;
            if(var7.getBlock() == this) {
               var1.g(var10);
            }
         }

         if(var9) {
            if(!var1.D) {
               this.b(var1, var2, var3, 0);
            }
         } else {
            boolean var8 = var1.z(var2) || var1.z(var10);
            if((var8 || var4.isPowerSource()) && var4 != this && var8 != ((Boolean)var7.get(O)).booleanValue()) {
               var1.a((class_cj)var10, (IBlockData)var7.set(O, Boolean.valueOf(var8)), 2);
               if(var8 != ((Boolean)var3.get(b)).booleanValue()) {
                  var1.a((class_cj)var2, (IBlockData)var3.set(b, Boolean.valueOf(var8)), 2);
                  var1.b(var2, var2);
                  var1.a((class_xa)null, var8?1003:1006, var2, 0);
               }
            }
         }
      }

   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return var1.get(P) == class_ahl.class_a_in_class_ahl.a?null:this.l();
   }

   public class_awg a(World var1, class_cj var2, class_awh var3, class_awh var4) {
      this.a((class_aer)var1, (class_cj)var2);
      return super.a(var1, var2, var3, var4);
   }

   public boolean d(World var1, class_cj var2) {
      return var2.o() >= 255?false:World.a((class_aer)var1, (class_cj)var2.b()) && super.d(var1, var2) && super.d(var1, var2.a());
   }

   public int k() {
      return 1;
   }

   public static int e(class_aer var0, class_cj var1) {
      IBlockData var2 = var0.p(var1);
      int var3 = var2.getBlock().toLegacyData(var2);
      boolean var4 = i(var3);
      IBlockData var5 = var0.p(var1.b());
      int var6 = var5.getBlock().toLegacyData(var5);
      int var7 = var4?var6:var3;
      IBlockData var8 = var0.p(var1.a());
      int var9 = var8.getBlock().toLegacyData(var8);
      int var10 = var4?var3:var9;
      boolean var11 = (var10 & 1) != 0;
      boolean var12 = (var10 & 2) != 0;
      return b(var7) | (var4?8:0) | (var11?16:0) | (var12?32:0);
   }

   private Item l() {
      return this == Blocks.IRON_DOOR?Items.aD:(this == Blocks.SPRUCE_DOOR?Items.at:(this == Blocks.BIRCH_DOOR?Items.au:(this == Blocks.JUNGLE_DOOR?Items.av:(this == Blocks.ACACIA_DOOR?Items.aw:(this == Blocks.DARK_OAK_DOOR?Items.ax:Items.as)))));
   }

   public void a(World var1, class_cj var2, IBlockData var3, class_xa var4) {
      class_cj var5 = var2.b();
      if(var4.bH.d && var3.get(P) == class_ahl.class_a_in_class_ahl.a && var1.p(var5).getBlock() == this) {
         var1.g(var5);
      }

   }

   public IBlockData a(IBlockData var1, class_aer var2, class_cj var3) {
      IBlockData var4;
      if(var1.get(P) == class_ahl.class_a_in_class_ahl.b) {
         var4 = var2.p(var3.a());
         if(var4.getBlock() == this) {
            var1 = var1.set(N, var4.get(N)).set(O, var4.get(O));
         }
      } else {
         var4 = var2.p(var3.b());
         if(var4.getBlock() == this) {
            var1 = var1.set(a, var4.get(a)).set(b, var4.get(b));
         }
      }

      return var1;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() == this && var1.get(P) == class_ahl.class_a_in_class_ahl.b?var1.set(a, var2.a((class_cq)var1.get(a))):var1;
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() == this && var1.get(P) == class_ahl.class_a_in_class_ahl.b?this.a(var1, var2.a((class_cq)var1.get(a))):var1;
   }

   public IBlockData fromLegacyData(int var1) {
      return (var1 & 8) > 0?this.getBlockData().set(P, class_ahl.class_a_in_class_ahl.a).set(N, (var1 & 1) > 0?class_ahl.class_b_in_class_ahl.b:class_ahl.class_b_in_class_ahl.a).set(O, Boolean.valueOf((var1 & 2) > 0)):this.getBlockData().set(P, class_ahl.class_a_in_class_ahl.b).set(a, class_cq.b(var1 & 3).f()).set(b, Boolean.valueOf((var1 & 4) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3;
      if(var1.get(P) == class_ahl.class_a_in_class_ahl.a) {
         var3 = var2 | 8;
         if(var1.get(N) == class_ahl.class_b_in_class_ahl.b) {
            var3 |= 1;
         }

         if(((Boolean)var1.get(O)).booleanValue()) {
            var3 |= 2;
         }
      } else {
         var3 = var2 | ((class_cq)var1.get(a)).e().b();
         if(((Boolean)var1.get(b)).booleanValue()) {
            var3 |= 4;
         }
      }

      return var3;
   }

   protected static int b(int var0) {
      return var0 & 7;
   }

   public static boolean f(class_aer var0, class_cj var1) {
      return g(e(var0, var1));
   }

   public static class_cq h(class_aer var0, class_cj var1) {
      return f(e(var0, var1));
   }

   public static class_cq f(int var0) {
      return class_cq.b(var0 & 3).f();
   }

   protected static boolean g(int var0) {
      return (var0 & 4) != 0;
   }

   protected static boolean i(int var0) {
      return (var0 & 8) != 0;
   }

   protected static boolean j(int var0) {
      return (var0 & 16) != 0;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{P, a, b, N, O});
   }

   static {
      a = class_aiv.O;
      b = class_anw.a("open");
      N = BlockStateEnum.of("hinge", class_ahl.class_b_in_class_ahl.class);
      O = class_anw.a("powered");
      P = BlockStateEnum.of("half", class_ahl.class_a_in_class_ahl.class);
   }

   public static enum class_b_in_class_ahl implements INamable {
      a,
      b;

      public String toString() {
         return this.getName();
      }

      public String getName() {
         return this == a?"left":"right";
      }
   }

   public static enum class_a_in_class_ahl implements INamable {
      a,
      b;

      public String toString() {
         return this.getName();
      }

      public String getName() {
         return this == a?"upper":"lower";
      }
   }
}
