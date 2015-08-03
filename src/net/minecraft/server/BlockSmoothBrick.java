package net.minecraft.server;

public class BlockSmoothBrick extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("variant", EnumSmoothBrickType.class);
   public static final int b;
   public static final int N;
   public static final int O;
   public static final int P;

   public BlockSmoothBrick() {
      super(Material.STONE);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumSmoothBrickType.a));
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public int getDropData(IBlockData var1) {
      return ((EnumSmoothBrickType)var1.get(a)).a();
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, EnumSmoothBrickType.a(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((EnumSmoothBrickType)var1.get(a)).a();
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   static {
      b = EnumSmoothBrickType.a.a();
      N = EnumSmoothBrickType.b.a();
      O = EnumSmoothBrickType.c.a();
      P = EnumSmoothBrickType.d.a();
   }

   public static enum EnumSmoothBrickType implements INamable {
      a(0, "stonebrick", "default"),
      b(1, "mossy_stonebrick", "mossy"),
      c(2, "cracked_stonebrick", "cracked"),
      d(3, "chiseled_stonebrick", "chiseled");

      private static final EnumSmoothBrickType[] e;
      private final int f;
      private final String g;
      private final String h;

      private EnumSmoothBrickType(int var3, String var4, String var5) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
      }

      public int a() {
         return this.f;
      }

      public String toString() {
         return this.g;
      }

      public static EnumSmoothBrickType a(int var0) {
         if(var0 < 0 || var0 >= e.length) {
            var0 = 0;
         }

         return e[var0];
      }

      public String getName() {
         return this.g;
      }

      public String c() {
         return this.h;
      }

      static {
         e = new EnumSmoothBrickType[values().length];
         EnumSmoothBrickType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            EnumSmoothBrickType var3 = var0[var2];
            e[var3.a()] = var3;
         }

      }
   }
}
