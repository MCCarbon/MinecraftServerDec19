package net.minecraft.server;

import java.util.Random;

public class BlockMonsterEggs extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("variant", EnumMonsterEggVariant.class);

   public BlockMonsterEggs() {
      super(Material.CLAY);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumMonsterEggVariant.a));
      this.setStrength(0.0F);
      this.setCreativeTab(CreativeTab.DECORATIONS);
   }

   public int getDropCount(Random var1) {
      return 0;
   }

   public static boolean d(IBlockData var0) {
      Block var1 = var0.getBlock();
      return var0 == Blocks.STONE.getBlockData().set(BlockStone.VARIANT, BlockStone.EnumStoneVariant.STONE) || var1 == Blocks.COBBLESTONE || var1 == Blocks.STONEBRICK;
   }

   protected ItemStack createItemStack(IBlockData var1) {
      switch(BlockMonsterEggs.SyntheticClass_1.a[((EnumMonsterEggVariant)var1.get(a)).ordinal()]) {
      case 1:
         return new ItemStack(Blocks.COBBLESTONE);
      case 2:
         return new ItemStack(Blocks.STONEBRICK);
      case 3:
         return new ItemStack(Blocks.STONEBRICK, 1, BlockSmoothBrick.EnumSmoothBrickType.b.a());
      case 4:
         return new ItemStack(Blocks.STONEBRICK, 1, BlockSmoothBrick.EnumSmoothBrickType.c.a());
      case 5:
         return new ItemStack(Blocks.STONEBRICK, 1, BlockSmoothBrick.EnumSmoothBrickType.d.a());
      default:
         return new ItemStack(Blocks.STONE);
      }
   }

   public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
      if(!var1.isClientSide && var1.R().b("doTileDrops")) {
         class_wm var6 = new class_wm(var1);
         var6.b((double)var2.getX() + 0.5D, (double)var2.getY(), (double)var2.getZ() + 0.5D, 0.0F, 0.0F);
         var1.addEntity((Entity)var6);
         var6.A();
      }

   }

   public int getDropData(World var1, BlockPosition var2) {
      IBlockData var3 = var1.getType(var2);
      return var3.getBlock().toLegacyData(var3);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, EnumMonsterEggVariant.a(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((EnumMonsterEggVariant)var1.get(a)).a();
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumMonsterEggVariant.values().length];

      static {
         try {
            a[EnumMonsterEggVariant.b.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[EnumMonsterEggVariant.c.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[EnumMonsterEggVariant.d.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumMonsterEggVariant.e.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumMonsterEggVariant.f.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum EnumMonsterEggVariant implements INamable {
      a(0, "stone") {
         public IBlockData d() {
            return Blocks.STONE.getBlockData().set(BlockStone.VARIANT, BlockStone.EnumStoneVariant.STONE);
         }
      },
      b(1, "cobblestone", "cobble") {
         public IBlockData d() {
            return Blocks.COBBLESTONE.getBlockData();
         }
      },
      c(2, "stone_brick", "brick") {
         public IBlockData d() {
            return Blocks.STONEBRICK.getBlockData().set(BlockSmoothBrick.a, BlockSmoothBrick.EnumSmoothBrickType.a);
         }
      },
      d(3, "mossy_brick", "mossybrick") {
         public IBlockData d() {
            return Blocks.STONEBRICK.getBlockData().set(BlockSmoothBrick.a, BlockSmoothBrick.EnumSmoothBrickType.b);
         }
      },
      e(4, "cracked_brick", "crackedbrick") {
         public IBlockData d() {
            return Blocks.STONEBRICK.getBlockData().set(BlockSmoothBrick.a, BlockSmoothBrick.EnumSmoothBrickType.c);
         }
      },
      f(5, "chiseled_brick", "chiseledbrick") {
         public IBlockData d() {
            return Blocks.STONEBRICK.getBlockData().set(BlockSmoothBrick.a, BlockSmoothBrick.EnumSmoothBrickType.d);
         }
      };

      private static final EnumMonsterEggVariant[] g;
      private final int h;
      private final String i;
      private final String j;

      private EnumMonsterEggVariant(int var3, String var4) {
         this(var3, var4, var4);
      }

      private EnumMonsterEggVariant(int var3, String var4, String var5) {
         this.h = var3;
         this.i = var4;
         this.j = var5;
      }

      public int a() {
         return this.h;
      }

      public String toString() {
         return this.i;
      }

      public static EnumMonsterEggVariant a(int var0) {
         if(var0 < 0 || var0 >= g.length) {
            var0 = 0;
         }

         return g[var0];
      }

      public String getName() {
         return this.i;
      }

      public String c() {
         return this.j;
      }

      public abstract IBlockData d();

      public static EnumMonsterEggVariant a(IBlockData var0) {
         EnumMonsterEggVariant[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            EnumMonsterEggVariant var4 = var1[var3];
            if(var0 == var4.d()) {
               return var4;
            }
         }

         return a;
      }

      // $FF: synthetic method
      EnumMonsterEggVariant(int var3, String var4, BlockMonsterEggs.SyntheticClass_1 var5) {
         this(var3, var4);
      }

      // $FF: synthetic method
      EnumMonsterEggVariant(int var3, String var4, String var5, BlockMonsterEggs.SyntheticClass_1 var6) {
         this(var3, var4, var5);
      }

      static {
         g = new EnumMonsterEggVariant[values().length];
         EnumMonsterEggVariant[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            EnumMonsterEggVariant var3 = var0[var2];
            g[var3.a()] = var3;
         }

      }
   }
}
