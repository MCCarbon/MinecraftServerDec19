package net.minecraft.server;

public class BlockRedSandstone extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("type", BlockRedSandstone.class_a_in_class_aki.class);

   public BlockRedSandstone() {
      super(Material.STONE, BlockSand.EnumSandVariant.RED_SAND.getMapColor());
      this.setBlockData(this.blockStateList.getFirst().set(a, BlockRedSandstone.class_a_in_class_aki.a));
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public int getDropData(IBlockData var1) {
      return ((BlockRedSandstone.class_a_in_class_aki)var1.get(a)).a();
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, BlockRedSandstone.class_a_in_class_aki.a(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((BlockRedSandstone.class_a_in_class_aki)var1.get(a)).a();
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   public static enum class_a_in_class_aki implements INamable {
      a(0, "red_sandstone", "default"),
      b(1, "chiseled_red_sandstone", "chiseled"),
      c(2, "smooth_red_sandstone", "smooth");

      private static final BlockRedSandstone.class_a_in_class_aki[] d;
      private final int e;
      private final String f;
      private final String g;

      private class_a_in_class_aki(int var3, String var4, String var5) {
         this.e = var3;
         this.f = var4;
         this.g = var5;
      }

      public int a() {
         return this.e;
      }

      public String toString() {
         return this.f;
      }

      public static BlockRedSandstone.class_a_in_class_aki a(int var0) {
         if(var0 < 0 || var0 >= d.length) {
            var0 = 0;
         }

         return d[var0];
      }

      public String getName() {
         return this.f;
      }

      public String c() {
         return this.g;
      }

      static {
         d = new BlockRedSandstone.class_a_in_class_aki[values().length];
         BlockRedSandstone.class_a_in_class_aki[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockRedSandstone.class_a_in_class_aki var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }
   }
}
