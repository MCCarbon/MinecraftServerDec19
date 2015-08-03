package net.minecraft.server;

import java.util.Random;

public class class_ahl extends Block {
   public static final BlockStateDirection a;
   public static final BlockStateBoolean b;
   public static final BlockStateEnum N;
   public static final BlockStateBoolean O;
   public static final BlockStateEnum P;

   protected class_ahl(Material var1) {
      super(var1);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH).set(b, Boolean.valueOf(false)).set(N, class_ahl.class_b_in_class_ahl.a).set(O, Boolean.valueOf(false)).set(P, class_ahl.class_a_in_class_ahl.b));
   }

   public String getName() {
      return LocaleI18n.get((this.getInternalName() + ".name").replaceAll("tile", "item"));
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isPassable(IBlockAccess var1, BlockPosition var2) {
      return g(e(var1, var2));
   }

   public boolean isFullCube() {
      return false;
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      this.updateShape((IBlockAccess)var1, (BlockPosition)var2);
      return super.getBoundingBox(var1, var2, var3);
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      this.k(e(var1, var2));
   }

   private void k(int var1) {
      float var2 = 0.1875F;
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
      EnumDirection var3 = f(var1);
      boolean var4 = g(var1);
      boolean var5 = j(var1);
      if(var4) {
         if(var3 == EnumDirection.EAST) {
            if(!var5) {
               this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            } else {
               this.setSizes(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            }
         } else if(var3 == EnumDirection.SOUTH) {
            if(!var5) {
               this.setSizes(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else {
               this.setSizes(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            }
         } else if(var3 == EnumDirection.WEST) {
            if(!var5) {
               this.setSizes(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            } else {
               this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            }
         } else if(var3 == EnumDirection.NORTH) {
            if(!var5) {
               this.setSizes(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            } else {
               this.setSizes(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
         }
      } else if(var3 == EnumDirection.EAST) {
         this.setSizes(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
      } else if(var3 == EnumDirection.SOUTH) {
         this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
      } else if(var3 == EnumDirection.WEST) {
         this.setSizes(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else if(var3 == EnumDirection.NORTH) {
         this.setSizes(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
      }

   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(this.material == Material.ORE) {
         return true;
      } else {
         BlockPosition var11 = var3.get(P) == class_ahl.class_a_in_class_ahl.b?var2:var2.down();
         IBlockData var12 = var2.equals(var11)?var3:var1.getType(var11);
         if(var12.getBlock() != this) {
            return false;
         } else {
            var3 = var12.a(b);
            var1.setTypeAndData((BlockPosition)var11, (IBlockData)var3, 2);
            var1.b(var11, var2);
            var1.a(var4, ((Boolean)var3.get(b)).booleanValue()?1003:1006, var2, 0);
            return true;
         }
      }
   }

   public void a(World var1, BlockPosition var2, boolean var3) {
      IBlockData var4 = var1.getType(var2);
      if(var4.getBlock() == this) {
         BlockPosition var5 = var4.get(P) == class_ahl.class_a_in_class_ahl.b?var2:var2.down();
         IBlockData var6 = var2 == var5?var4:var1.getType(var5);
         if(var6.getBlock() == this && ((Boolean)var6.get(b)).booleanValue() != var3) {
            var1.setTypeAndData((BlockPosition)var5, (IBlockData)var6.set(b, Boolean.valueOf(var3)), 2);
            var1.b(var5, var2);
            var1.a((EntityHuman)null, var3?1003:1006, var2, 0);
         }

      }
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(var3.get(P) == class_ahl.class_a_in_class_ahl.a) {
         BlockPosition var5 = var2.down();
         IBlockData var6 = var1.getType(var5);
         if(var6.getBlock() != this) {
            var1.setAir(var2);
         } else if(var4 != this) {
            this.doPhysics(var1, var5, var6, var4);
         }
      } else {
         boolean var9 = false;
         BlockPosition var10 = var2.up();
         IBlockData var7 = var1.getType(var10);
         if(var7.getBlock() != this) {
            var1.setAir(var2);
            var9 = true;
         }

         if(!World.a((IBlockAccess)var1, (BlockPosition)var2.down())) {
            var1.setAir(var2);
            var9 = true;
            if(var7.getBlock() == this) {
               var1.setAir(var10);
            }
         }

         if(var9) {
            if(!var1.isClientSide) {
               this.dropNaturallyForSure(var1, var2, var3, 0);
            }
         } else {
            boolean var8 = var1.isBlockIndirectlyPowered(var2) || var1.isBlockIndirectlyPowered(var10);
            if((var8 || var4.isPowerSource()) && var4 != this && var8 != ((Boolean)var7.get(O)).booleanValue()) {
               var1.setTypeAndData((BlockPosition)var10, (IBlockData)var7.set(O, Boolean.valueOf(var8)), 2);
               if(var8 != ((Boolean)var3.get(b)).booleanValue()) {
                  var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(b, Boolean.valueOf(var8)), 2);
                  var1.b(var2, var2);
                  var1.a((EntityHuman)null, var8?1003:1006, var2, 0);
               }
            }
         }
      }

   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return var1.get(P) == class_ahl.class_a_in_class_ahl.a?null:this.l();
   }

   public MovingObjectPosition rayTraceCollision(World var1, BlockPosition var2, Vec3D var3, Vec3D var4) {
      this.updateShape((IBlockAccess)var1, (BlockPosition)var2);
      return super.rayTraceCollision(var1, var2, var3, var4);
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      return var2.getY() >= 255?false:World.a((IBlockAccess)var1, (BlockPosition)var2.down()) && super.canPlace(var1, var2) && super.canPlace(var1, var2.up());
   }

   public int getPushReaction() {
      return 1;
   }

   public static int e(IBlockAccess var0, BlockPosition var1) {
      IBlockData var2 = var0.getType(var1);
      int var3 = var2.getBlock().toLegacyData(var2);
      boolean var4 = i(var3);
      IBlockData var5 = var0.getType(var1.down());
      int var6 = var5.getBlock().toLegacyData(var5);
      int var7 = var4?var6:var3;
      IBlockData var8 = var0.getType(var1.up());
      int var9 = var8.getBlock().toLegacyData(var8);
      int var10 = var4?var3:var9;
      boolean var11 = (var10 & 1) != 0;
      boolean var12 = (var10 & 2) != 0;
      return b(var7) | (var4?8:0) | (var11?16:0) | (var12?32:0);
   }

   private Item l() {
      return this == Blocks.IRON_DOOR?Items.IRON_DOOR :(this == Blocks.SPRUCE_DOOR?Items.SPRUCE_DOOR :(this == Blocks.BIRCH_DOOR?Items.BIRCH_DOOR :(this == Blocks.JUNGLE_DOOR?Items.JUNGLE_DOOR :(this == Blocks.ACACIA_DOOR?Items.ACACIA_DOOR :(this == Blocks.DARK_OAK_DOOR?Items.DARK_OAK_DOOR :Items.WOODEN_DOOR)))));
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4) {
      BlockPosition var5 = var2.down();
      if(var4.abilities.instabuild && var3.get(P) == class_ahl.class_a_in_class_ahl.a && var1.getType(var5).getBlock() == this) {
         var1.setAir(var5);
      }

   }

   public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
      IBlockData var4;
      if(var1.get(P) == class_ahl.class_a_in_class_ahl.b) {
         var4 = var2.getType(var3.up());
         if(var4.getBlock() == this) {
            var1 = var1.set(N, var4.get(N)).set(O, var4.get(O));
         }
      } else {
         var4 = var2.getType(var3.down());
         if(var4.getBlock() == this) {
            var1 = var1.set(a, var4.get(a)).set(b, var4.get(b));
         }
      }

      return var1;
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      return var1.getBlock() == this && var1.get(P) == class_ahl.class_a_in_class_ahl.b?var1.set(a, var2.a((EnumDirection)var1.get(a))):var1;
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() == this && var1.get(P) == class_ahl.class_a_in_class_ahl.b?this.a(var1, var2.a((EnumDirection)var1.get(a))):var1;
   }

   public IBlockData fromLegacyData(int var1) {
      return (var1 & 8) > 0?this.getBlockData().set(P, class_ahl.class_a_in_class_ahl.a).set(N, (var1 & 1) > 0?class_ahl.class_b_in_class_ahl.b:class_ahl.class_b_in_class_ahl.a).set(O, Boolean.valueOf((var1 & 2) > 0)):this.getBlockData().set(P, class_ahl.class_a_in_class_ahl.b).set(a, EnumDirection.getByHorizontalId(var1 & 3).rotateYCCW()).set(b, Boolean.valueOf((var1 & 4) > 0));
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
         var3 = var2 | ((EnumDirection)var1.get(a)).rotateY().getHorizontalId();
         if(((Boolean)var1.get(b)).booleanValue()) {
            var3 |= 4;
         }
      }

      return var3;
   }

   protected static int b(int var0) {
      return var0 & 7;
   }

   public static boolean f(IBlockAccess var0, BlockPosition var1) {
      return g(e(var0, var1));
   }

   public static EnumDirection h(IBlockAccess var0, BlockPosition var1) {
      return f(e(var0, var1));
   }

   public static EnumDirection f(int var0) {
      return EnumDirection.getByHorizontalId(var0 & 3).rotateYCCW();
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

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{P, a, b, N, O});
   }

   static {
      a = BlockDirectional.FACING;
      b = BlockStateBoolean.of("open");
      N = BlockStateEnum.of("hinge", class_ahl.class_b_in_class_ahl.class);
      O = BlockStateBoolean.of("powered");
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
