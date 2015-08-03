package net.minecraft.server;

public class BlockPrismarine extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("variant", BlockPrismarine.class_a_in_class_akc.class);
   public static final int b;
   public static final int N;
   public static final int O;

   public BlockPrismarine() {
      super(Material.STONE);
      this.setBlockData(this.blockStateList.getFirst().set(a, BlockPrismarine.class_a_in_class_akc.a));
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public String getName() {
      return LocaleI18n.get(this.getInternalName() + "." + BlockPrismarine.class_a_in_class_akc.a.c() + ".name");
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return var1.get(a) == BlockPrismarine.class_a_in_class_akc.a?MaterialMapColor.COLOR24:MaterialMapColor.COLOR32;
   }

   public int getDropData(IBlockData var1) {
      return ((BlockPrismarine.class_a_in_class_akc)var1.get(a)).a();
   }

   public int toLegacyData(IBlockData var1) {
      return ((BlockPrismarine.class_a_in_class_akc)var1.get(a)).a();
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, BlockPrismarine.class_a_in_class_akc.a(var1));
   }

   static {
      b = BlockPrismarine.class_a_in_class_akc.a.a();
      N = BlockPrismarine.class_a_in_class_akc.b.a();
      O = BlockPrismarine.class_a_in_class_akc.c.a();
   }

   public static enum class_a_in_class_akc implements INamable {
      a(0, "prismarine", "rough"),
      b(1, "prismarine_bricks", "bricks"),
      c(2, "dark_prismarine", "dark");

      private static final BlockPrismarine.class_a_in_class_akc[] d;
      private final int e;
      private final String f;
      private final String g;

      private class_a_in_class_akc(int var3, String var4, String var5) {
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

      public static BlockPrismarine.class_a_in_class_akc a(int var0) {
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
         d = new BlockPrismarine.class_a_in_class_akc[values().length];
         BlockPrismarine.class_a_in_class_akc[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockPrismarine.class_a_in_class_akc var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }
   }
}
