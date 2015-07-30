package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aic;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_alm;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amq;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.class_nc;
import net.minecraft.server.INamable;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_xa;
import net.minecraft.server.ItemBlock;

public class class_aid extends class_agd {
   public static final class_anz a = class_anz.a("legacy_data", 0, 15);
   public static final BlockStateEnum b = BlockStateEnum.of("contents", class_aid.class_a_in_class_aid.class);

   public class_aid() {
      super(Material.ORIENTABLE);
      this.setBlockData(this.blockStateList.getFirst().set(b, class_aid.class_a_in_class_aid.a).set(a, Integer.valueOf(0)));
      this.j();
   }

   public String getName() {
      return LocaleI18n.get("item.flowerPot.name");
   }

   public void j() {
      float var1 = 0.375F;
      float var2 = var1 / 2.0F;
      this.setSizes(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var1, 0.5F + var2);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public int getRenderType() {
      return 3;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var6 != null && var6.b() instanceof ItemBlock) {
         class_amq var11 = this.f(var1, var2);
         if(var11 == null) {
            return false;
         } else if(var11.b() != null) {
            return false;
         } else {
            Block var12 = Block.getByItem(var6.b());
            if(!this.a(var12, var6.i())) {
               return false;
            } else {
               var11.a(var6.b(), var6.i());
               var11.p_();
               var1.h(var2);
               var4.b(class_nc.T);
               if(!var4.bH.d) {
                  --var6.b;
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }

   private boolean a(Block var1, int var2) {
      return var1 != Blocks.YELLOW_FLOWER && var1 != Blocks.RED_FLOWER && var1 != Blocks.CACTUS && var1 != Blocks.BROWN_MUSHROOM && var1 != Blocks.RED_MUSHROOM && var1 != Blocks.SAPLING && var1 != Blocks.DEADBUSH?var1 == Blocks.TALLGRASS && var2 == class_alm.class_a_in_class_alm.c.a():true;
   }

   public int j(World var1, BlockPosition var2) {
      class_amq var3 = this.f(var1, var2);
      return var3 != null && var3.b() != null?var3.c():0;
   }

   public boolean d(World var1, BlockPosition var2) {
      return super.d(var1, var2) && World.a((class_aer)var1, (BlockPosition)var2.shiftDown());
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!World.a((class_aer)var1, (BlockPosition)var2.shiftDown())) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      class_amq var4 = this.f(var1, var2);
      if(var4 != null && var4.b() != null) {
         a(var1, var2, new class_aas(var4.b(), 1, var4.c()));
      }

      super.b(var1, var2, var3);
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_xa var4) {
      super.a(var1, var2, var3, var4);
      if(var4.bH.d) {
         class_amq var5 = this.f(var1, var2);
         if(var5 != null) {
            var5.a((Item)null, 0);
         }
      }

   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.bT;
   }

   private class_amq f(World var1, BlockPosition var2) {
      class_amg var3 = var1.s(var2);
      return var3 instanceof class_amq?(class_amq)var3:null;
   }

   public class_amg a(World var1, int var2) {
      Object var3 = null;
      int var4 = 0;
      switch(var2) {
      case 1:
         var3 = Blocks.RED_FLOWER;
         var4 = class_aic.class_a_in_class_aic.b.b();
         break;
      case 2:
         var3 = Blocks.YELLOW_FLOWER;
         break;
      case 3:
         var3 = Blocks.SAPLING;
         var4 = class_ajw.class_a_in_class_ajw.a.a();
         break;
      case 4:
         var3 = Blocks.SAPLING;
         var4 = class_ajw.class_a_in_class_ajw.b.a();
         break;
      case 5:
         var3 = Blocks.SAPLING;
         var4 = class_ajw.class_a_in_class_ajw.c.a();
         break;
      case 6:
         var3 = Blocks.SAPLING;
         var4 = class_ajw.class_a_in_class_ajw.d.a();
         break;
      case 7:
         var3 = Blocks.RED_MUSHROOM;
         break;
      case 8:
         var3 = Blocks.BROWN_MUSHROOM;
         break;
      case 9:
         var3 = Blocks.CACTUS;
         break;
      case 10:
         var3 = Blocks.DEADBUSH;
         break;
      case 11:
         var3 = Blocks.TALLGRASS;
         var4 = class_alm.class_a_in_class_alm.c.a();
         break;
      case 12:
         var3 = Blocks.SAPLING;
         var4 = class_ajw.class_a_in_class_ajw.e.a();
         break;
      case 13:
         var3 = Blocks.SAPLING;
         var4 = class_ajw.class_a_in_class_ajw.f.a();
      }

      return new class_amq(Item.getByBlock((Block)var3), var4);
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{b, a});
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   public IBlockData a(IBlockData var1, class_aer var2, BlockPosition var3) {
      class_aid.class_a_in_class_aid var4 = class_aid.class_a_in_class_aid.a;
      class_amg var5 = var2.s(var3);
      if(var5 instanceof class_amq) {
         class_amq var6 = (class_amq)var5;
         Item var7 = var6.b();
         if(var7 instanceof ItemBlock) {
            int var8 = var6.c();
            Block var9 = Block.getByItem(var7);
            if(var9 == Blocks.SAPLING) {
               switch(class_aid.SyntheticClass_1.a[class_ajw.class_a_in_class_ajw.a(var8).ordinal()]) {
               case 1:
                  var4 = class_aid.class_a_in_class_aid.l;
                  break;
               case 2:
                  var4 = class_aid.class_a_in_class_aid.m;
                  break;
               case 3:
                  var4 = class_aid.class_a_in_class_aid.n;
                  break;
               case 4:
                  var4 = class_aid.class_a_in_class_aid.o;
                  break;
               case 5:
                  var4 = class_aid.class_a_in_class_aid.p;
                  break;
               case 6:
                  var4 = class_aid.class_a_in_class_aid.q;
                  break;
               default:
                  var4 = class_aid.class_a_in_class_aid.a;
               }
            } else if(var9 == Blocks.TALLGRASS) {
               switch(var8) {
               case 0:
                  var4 = class_aid.class_a_in_class_aid.t;
                  break;
               case 2:
                  var4 = class_aid.class_a_in_class_aid.u;
                  break;
               default:
                  var4 = class_aid.class_a_in_class_aid.a;
               }
            } else if(var9 == Blocks.YELLOW_FLOWER) {
               var4 = class_aid.class_a_in_class_aid.k;
            } else if(var9 == Blocks.RED_FLOWER) {
               switch(class_aid.SyntheticClass_1.b[class_aic.class_a_in_class_aic.a(class_aic.class_b_in_class_aic.b, var8).ordinal()]) {
               case 1:
                  var4 = class_aid.class_a_in_class_aid.b;
                  break;
               case 2:
                  var4 = class_aid.class_a_in_class_aid.c;
                  break;
               case 3:
                  var4 = class_aid.class_a_in_class_aid.d;
                  break;
               case 4:
                  var4 = class_aid.class_a_in_class_aid.e;
                  break;
               case 5:
                  var4 = class_aid.class_a_in_class_aid.f;
                  break;
               case 6:
                  var4 = class_aid.class_a_in_class_aid.g;
                  break;
               case 7:
                  var4 = class_aid.class_a_in_class_aid.h;
                  break;
               case 8:
                  var4 = class_aid.class_a_in_class_aid.i;
                  break;
               case 9:
                  var4 = class_aid.class_a_in_class_aid.j;
                  break;
               default:
                  var4 = class_aid.class_a_in_class_aid.a;
               }
            } else if(var9 == Blocks.RED_MUSHROOM) {
               var4 = class_aid.class_a_in_class_aid.r;
            } else if(var9 == Blocks.BROWN_MUSHROOM) {
               var4 = class_aid.class_a_in_class_aid.s;
            } else if(var9 == Blocks.DEADBUSH) {
               var4 = class_aid.class_a_in_class_aid.t;
            } else if(var9 == Blocks.CACTUS) {
               var4 = class_aid.class_a_in_class_aid.v;
            }
         }
      }

      return var1.set(b, var4);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[class_aic.class_a_in_class_aic.values().length];

      static {
         try {
            b[class_aic.class_a_in_class_aic.b.ordinal()] = 1;
         } catch (NoSuchFieldError var15) {
            ;
         }

         try {
            b[class_aic.class_a_in_class_aic.c.ordinal()] = 2;
         } catch (NoSuchFieldError var14) {
            ;
         }

         try {
            b[class_aic.class_a_in_class_aic.d.ordinal()] = 3;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            b[class_aic.class_a_in_class_aic.e.ordinal()] = 4;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            b[class_aic.class_a_in_class_aic.f.ordinal()] = 5;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            b[class_aic.class_a_in_class_aic.g.ordinal()] = 6;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            b[class_aic.class_a_in_class_aic.h.ordinal()] = 7;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            b[class_aic.class_a_in_class_aic.i.ordinal()] = 8;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            b[class_aic.class_a_in_class_aic.j.ordinal()] = 9;
         } catch (NoSuchFieldError var7) {
            ;
         }

         a = new int[class_ajw.class_a_in_class_ajw.values().length];

         try {
            a[class_ajw.class_a_in_class_ajw.a.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_ajw.class_a_in_class_ajw.b.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_ajw.class_a_in_class_ajw.c.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_ajw.class_a_in_class_ajw.d.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_ajw.class_a_in_class_ajw.e.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_ajw.class_a_in_class_ajw.f.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_aid implements INamable {
      a("empty"),
      b("rose"),
      c("blue_orchid"),
      d("allium"),
      e("houstonia"),
      f("red_tulip"),
      g("orange_tulip"),
      h("white_tulip"),
      i("pink_tulip"),
      j("oxeye_daisy"),
      k("dandelion"),
      l("oak_sapling"),
      m("spruce_sapling"),
      n("birch_sapling"),
      o("jungle_sapling"),
      p("acacia_sapling"),
      q("dark_oak_sapling"),
      r("mushroom_red"),
      s("mushroom_brown"),
      t("dead_bush"),
      u("fern"),
      v("cactus");

      private final String w;

      private class_a_in_class_aid(String var3) {
         this.w = var3;
      }

      public String toString() {
         return this.w;
      }

      public String getName() {
         return this.w;
      }
   }
}
