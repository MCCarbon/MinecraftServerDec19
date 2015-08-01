package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.BlockContainer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockFlowers;
import net.minecraft.server.BlockWood;
import net.minecraft.server.BlockLongGrass;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityFlowerPot;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.BlockStateInteger;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.StatisticList;
import net.minecraft.server.INamable;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.ItemBlock;

public class class_aid extends BlockContainer {
   public static final BlockStateInteger a = BlockStateInteger.of("legacy_data", 0, 15);
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

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var6 != null && var6.getItem() instanceof ItemBlock) {
         TileEntityFlowerPot var11 = this.f(var1, var2);
         if(var11 == null) {
            return false;
         } else if(var11.b() != null) {
            return false;
         } else {
            Block var12 = Block.getByItem(var6.getItem());
            if(!this.a(var12, var6.i())) {
               return false;
            } else {
               var11.a(var6.getItem(), var6.i());
               var11.update();
               var1.h(var2);
               var4.b(StatisticList.T);
               if(!var4.bH.instabuild) {
                  --var6.count;
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }

   private boolean a(Block var1, int var2) {
      return var1 != Blocks.YELLOW_FLOWER && var1 != Blocks.RED_FLOWER && var1 != Blocks.CACTUS && var1 != Blocks.BROWN_MUSHROOM && var1 != Blocks.RED_MUSHROOM && var1 != Blocks.SAPLING && var1 != Blocks.DEADBUSH?var1 == Blocks.TALLGRASS && var2 == BlockLongGrass.EnumTallGrassType.FERN.getId():true;
   }

   public int getDropData(World var1, BlockPosition var2) {
      TileEntityFlowerPot var3 = this.f(var1, var2);
      return var3 != null && var3.b() != null?var3.c():0;
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      return super.canPlace(var1, var2) && World.a((IBlockAccess)var1, (BlockPosition)var2.down());
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!World.a((IBlockAccess)var1, (BlockPosition)var2.down())) {
         this.dropNaturallyForSure(var1, var2, var3, 0);
         var1.setAir(var2);
      }

   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      TileEntityFlowerPot var4 = this.f(var1, var2);
      if(var4 != null && var4.b() != null) {
         dropItem(var1, var2, new ItemStack(var4.b(), 1, var4.c()));
      }

      super.remove(var1, var2, var3);
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4) {
      super.a(var1, var2, var3, var4);
      if(var4.bH.instabuild) {
         TileEntityFlowerPot var5 = this.f(var1, var2);
         if(var5 != null) {
            var5.a((Item)null, 0);
         }
      }

   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.bT;
   }

   private TileEntityFlowerPot f(World var1, BlockPosition var2) {
      TileEntity var3 = var1.getTileEntity(var2);
      return var3 instanceof TileEntityFlowerPot?(TileEntityFlowerPot)var3:null;
   }

   public TileEntity createTileEntity(World var1, int var2) {
      Object var3 = null;
      int var4 = 0;
      switch(var2) {
      case 1:
         var3 = Blocks.RED_FLOWER;
         var4 = BlockFlowers.EnumFlowerVarient.POPPY.getId();
         break;
      case 2:
         var3 = Blocks.YELLOW_FLOWER;
         break;
      case 3:
         var3 = Blocks.SAPLING;
         var4 = BlockWood.EnumLogVariant.OAK.getId();
         break;
      case 4:
         var3 = Blocks.SAPLING;
         var4 = BlockWood.EnumLogVariant.SPRUCE.getId();
         break;
      case 5:
         var3 = Blocks.SAPLING;
         var4 = BlockWood.EnumLogVariant.BIRCH.getId();
         break;
      case 6:
         var3 = Blocks.SAPLING;
         var4 = BlockWood.EnumLogVariant.JUNGLE.getId();
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
         var4 = BlockLongGrass.EnumTallGrassType.FERN.getId();
         break;
      case 12:
         var3 = Blocks.SAPLING;
         var4 = BlockWood.EnumLogVariant.ACACIA.getId();
         break;
      case 13:
         var3 = Blocks.SAPLING;
         var4 = BlockWood.EnumLogVariant.DARK_OAK.getId();
      }

      return new TileEntityFlowerPot(Item.getByBlock((Block)var3), var4);
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{b, a});
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
      class_aid.class_a_in_class_aid var4 = class_aid.class_a_in_class_aid.a;
      TileEntity var5 = var2.getTileEntity(var3);
      if(var5 instanceof TileEntityFlowerPot) {
         TileEntityFlowerPot var6 = (TileEntityFlowerPot)var5;
         Item var7 = var6.b();
         if(var7 instanceof ItemBlock) {
            int var8 = var6.c();
            Block var9 = Block.getByItem(var7);
            if(var9 == Blocks.SAPLING) {
               switch(class_aid.SyntheticClass_1.a[BlockWood.EnumLogVariant.getById(var8).ordinal()]) {
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
               switch(class_aid.SyntheticClass_1.b[BlockFlowers.EnumFlowerVarient.getById(BlockFlowers.EnumFlowerType.RED, var8).ordinal()]) {
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
      static final int[] b = new int[BlockFlowers.EnumFlowerVarient.values().length];

      static {
         try {
            b[BlockFlowers.EnumFlowerVarient.POPPY.ordinal()] = 1;
         } catch (NoSuchFieldError var15) {
            ;
         }

         try {
            b[BlockFlowers.EnumFlowerVarient.BLUE_ORCHID.ordinal()] = 2;
         } catch (NoSuchFieldError var14) {
            ;
         }

         try {
            b[BlockFlowers.EnumFlowerVarient.ALLIUM.ordinal()] = 3;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            b[BlockFlowers.EnumFlowerVarient.HOUSTONIA.ordinal()] = 4;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            b[BlockFlowers.EnumFlowerVarient.RED_TULIP.ordinal()] = 5;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            b[BlockFlowers.EnumFlowerVarient.ORANGE_TULIP.ordinal()] = 6;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            b[BlockFlowers.EnumFlowerVarient.WHITE_TULIP.ordinal()] = 7;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            b[BlockFlowers.EnumFlowerVarient.PINK_TULIP.ordinal()] = 8;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            b[BlockFlowers.EnumFlowerVarient.OXEYE_DAISY.ordinal()] = 9;
         } catch (NoSuchFieldError var7) {
            ;
         }

         a = new int[BlockWood.EnumLogVariant.values().length];

         try {
            a[BlockWood.EnumLogVariant.OAK.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[BlockWood.EnumLogVariant.SPRUCE.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[BlockWood.EnumLogVariant.BIRCH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[BlockWood.EnumLogVariant.JUNGLE.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[BlockWood.EnumLogVariant.ACACIA.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[BlockWood.EnumLogVariant.DARK_OAK.ordinal()] = 6;
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
