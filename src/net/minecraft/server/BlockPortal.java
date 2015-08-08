package net.minecraft.server;

import com.google.common.cache.LoadingCache;
import java.util.Random;

public class BlockPortal extends BlockHalfTransparent {
   public static final BlockStateEnum a;

   public BlockPortal() {
      super(Material.PORTAL, false);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.EnumAxis.X));
      this.setTicking(true);
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      super.tick(var1, var2, var3, var4);
      if(var1.worldProvider.d() && var1.R().getBooleanValue("doMobSpawning") && var4.nextInt(2000) < var1.ab().a()) {
         int var5 = var2.getY();

         BlockPosition var6;
         for(var6 = var2; !World.a((IBlockAccess)var1, (BlockPosition)var6) && var6.getY() > 0; var6 = var6.down()) {
            ;
         }

         if(var5 > 0 && !var1.getType(var6.up()).getBlock().isOccluding()) {
            Entity var7 = ItemMonsterEgg.a(var1, 57, (double) var6.getX() + 0.5D, (double) var6.getY() + 1.1D, (double) var6.getZ() + 0.5D);
            if(var7 != null) {
               var7.portalCooldown = var7.aq();
            }
         }
      }

   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      return null;
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      EnumDirection.EnumAxis var3 = (EnumDirection.EnumAxis)var1.getType(var2).get(a);
      float var4 = 0.125F;
      float var5 = 0.125F;
      if(var3 == EnumDirection.EnumAxis.X) {
         var4 = 0.5F;
      }

      if(var3 == EnumDirection.EnumAxis.Z) {
         var5 = 0.5F;
      }

      this.setSizes(0.5F - var4, 0.0F, 0.5F - var5, 0.5F + var4, 1.0F, 0.5F + var5);
   }

   public static int a(EnumDirection.EnumAxis var0) {
      return var0 == EnumDirection.EnumAxis.X?1:(var0 == EnumDirection.EnumAxis.Z?2:0);
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean e(World var1, BlockPosition var2) {
      BlockPortal.class_a_in_class_ajx var3 = new BlockPortal.class_a_in_class_ajx(var1, var2, EnumDirection.EnumAxis.X);
      if(var3.d() && var3.e == 0) {
         var3.e();
         return true;
      } else {
         BlockPortal.class_a_in_class_ajx var4 = new BlockPortal.class_a_in_class_ajx(var1, var2, EnumDirection.EnumAxis.Z);
         if(var4.d() && var4.e == 0) {
            var4.e();
            return true;
         } else {
            return false;
         }
      }
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      EnumDirection.EnumAxis var5 = (EnumDirection.EnumAxis)var3.get(a);
      BlockPortal.class_a_in_class_ajx var6;
      if(var5 == EnumDirection.EnumAxis.X) {
         var6 = new BlockPortal.class_a_in_class_ajx(var1, var2, EnumDirection.EnumAxis.X);
         if(!var6.d() || var6.e < var6.h * var6.g) {
            var1.setTypeUpdate(var2, Blocks.AIR.getBlockData());
         }
      } else if(var5 == EnumDirection.EnumAxis.Z) {
         var6 = new BlockPortal.class_a_in_class_ajx(var1, var2, EnumDirection.EnumAxis.Z);
         if(!var6.d() || var6.e < var6.h * var6.g) {
            var1.setTypeUpdate(var2, Blocks.AIR.getBlockData());
         }
      }

   }

   public int getDropCount(Random var1) {
      return 0;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Entity var4) {
      if(var4.vehicle == null && var4.passenger == null) {
         var4.d(var2);
      }

   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, (var1 & 3) == 2?EnumDirection.EnumAxis.Z:EnumDirection.EnumAxis.X);
   }

   public int toLegacyData(IBlockData var1) {
      return a((EnumDirection.EnumAxis)var1.get(a));
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(BlockPortal.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
         case 2:
            switch(BlockPortal.SyntheticClass_1.a[((EnumDirection.EnumAxis)var1.get(a)).ordinal()]) {
            case 1:
               return var1.set(a, EnumDirection.EnumAxis.Z);
            case 2:
               return var1.set(a, EnumDirection.EnumAxis.X);
            default:
               return var1;
            }
         default:
            return var1;
         }
      }
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   public class_anp.class_b_in_class_anp f(World var1, BlockPosition var2) {
      EnumDirection.EnumAxis var3 = EnumDirection.EnumAxis.Z;
      BlockPortal.class_a_in_class_ajx var4 = new BlockPortal.class_a_in_class_ajx(var1, var2, EnumDirection.EnumAxis.X);
      LoadingCache var5 = class_anp.a(var1, true);
      if(!var4.d()) {
         var3 = EnumDirection.EnumAxis.X;
         var4 = new BlockPortal.class_a_in_class_ajx(var1, var2, EnumDirection.EnumAxis.Z);
      }

      if(!var4.d()) {
         return new class_anp.class_b_in_class_anp(var2, EnumDirection.NORTH, EnumDirection.UP, var5, 1, 1, 1);
      } else {
         int[] var6 = new int[EnumDirection.EnumAxisDirection.values().length];
         EnumDirection var7 = var4.c.rotateYCCW();
         BlockPosition var8 = var4.f.up(var4.a() - 1);
         EnumDirection.EnumAxisDirection[] var9 = EnumDirection.EnumAxisDirection.values();
         int var10 = var9.length;

         int var11;
         for(var11 = 0; var11 < var10; ++var11) {
            EnumDirection.EnumAxisDirection var12 = var9[var11];
            class_anp.class_b_in_class_anp var13 = new class_anp.class_b_in_class_anp(var7.getAxisDirection() == var12?var8:var8.shift(var4.c, var4.b() - 1), EnumDirection.getByAxisDirectionAndAxis(var12, var3), EnumDirection.UP, var5, var4.b(), var4.a(), 1);

            for(int var14 = 0; var14 < var4.b(); ++var14) {
               for(int var15 = 0; var15 < var4.a(); ++var15) {
                  class_ano var16 = var13.a(var14, var15, 1);
                  if(var16.a() != null && var16.a().getBlock().getMaterial() != Material.AIR) {
                     ++var6[var12.ordinal()];
                  }
               }
            }
         }

         EnumDirection.EnumAxisDirection var17 = EnumDirection.EnumAxisDirection.POSITIVE;
         EnumDirection.EnumAxisDirection[] var18 = EnumDirection.EnumAxisDirection.values();
         var11 = var18.length;

         for(int var19 = 0; var19 < var11; ++var19) {
            EnumDirection.EnumAxisDirection var20 = var18[var19];
            if(var6[var20.ordinal()] < var6[var17.ordinal()]) {
               var17 = var20;
            }
         }

         return new class_anp.class_b_in_class_anp(var7.getAxisDirection() == var17?var8:var8.shift(var4.c, var4.b() - 1), EnumDirection.getByAxisDirectionAndAxis(var17, var3), EnumDirection.UP, var5, var4.b(), var4.a(), 1);
      }
   }

   static {
      a = BlockStateEnum.of("axis", EnumDirection.EnumAxis.class, new EnumDirection.EnumAxis[]{EnumDirection.EnumAxis.X, EnumDirection.EnumAxis.Z});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[Block.EnumRotation.values().length];

      static {
         try {
            b[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            b[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         a = new int[EnumDirection.EnumAxis.values().length];

         try {
            a[EnumDirection.EnumAxis.X.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.EnumAxis.Z.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static class class_a_in_class_ajx {
      private final World a;
      private final EnumDirection.EnumAxis b;
      private final EnumDirection c;
      private final EnumDirection d;
      private int e = 0;
      private BlockPosition f;
      private int g;
      private int h;

      public class_a_in_class_ajx(World var1, BlockPosition var2, EnumDirection.EnumAxis var3) {
         this.a = var1;
         this.b = var3;
         if(var3 == EnumDirection.EnumAxis.X) {
            this.d = EnumDirection.EAST;
            this.c = EnumDirection.WEST;
         } else {
            this.d = EnumDirection.NORTH;
            this.c = EnumDirection.SOUTH;
         }

         for(BlockPosition var4 = var2; var2.getY() > var4.getY() - 21 && var2.getY() > 0 && this.a(var1.getType(var2.down()).getBlock()); var2 = var2.down()) {
            ;
         }

         int var5 = this.a(var2, this.d) - 1;
         if(var5 >= 0) {
            this.f = var2.shift(this.d, var5);
            this.h = this.a(this.f, this.c);
            if(this.h < 2 || this.h > 21) {
               this.f = null;
               this.h = 0;
            }
         }

         if(this.f != null) {
            this.g = this.c();
         }

      }

      protected int a(BlockPosition var1, EnumDirection var2) {
         int var3;
         for(var3 = 0; var3 < 22; ++var3) {
            BlockPosition var4 = var1.shift(var2, var3);
            if(!this.a(this.a.getType(var4).getBlock()) || this.a.getType(var4.down()).getBlock() != Blocks.OBSIDIAN) {
               break;
            }
         }

         Block var5 = this.a.getType(var1.shift(var2, var3)).getBlock();
         return var5 == Blocks.OBSIDIAN?var3:0;
      }

      public int a() {
         return this.g;
      }

      public int b() {
         return this.h;
      }

      protected int c() {
         int var1;
         label56:
         for(this.g = 0; this.g < 21; ++this.g) {
            for(var1 = 0; var1 < this.h; ++var1) {
               BlockPosition var2 = this.f.shift(this.c, var1).up(this.g);
               Block var3 = this.a.getType(var2).getBlock();
               if(!this.a(var3)) {
                  break label56;
               }

               if(var3 == Blocks.PORTAL) {
                  ++this.e;
               }

               if(var1 == 0) {
                  var3 = this.a.getType(var2.shift(this.d)).getBlock();
                  if(var3 != Blocks.OBSIDIAN) {
                     break label56;
                  }
               } else if(var1 == this.h - 1) {
                  var3 = this.a.getType(var2.shift(this.c)).getBlock();
                  if(var3 != Blocks.OBSIDIAN) {
                     break label56;
                  }
               }
            }
         }

         for(var1 = 0; var1 < this.h; ++var1) {
            if(this.a.getType(this.f.shift(this.c, var1).up(this.g)).getBlock() != Blocks.OBSIDIAN) {
               this.g = 0;
               break;
            }
         }

         if(this.g <= 21 && this.g >= 3) {
            return this.g;
         } else {
            this.f = null;
            this.h = 0;
            this.g = 0;
            return 0;
         }
      }

      protected boolean a(Block var1) {
         return var1.material == Material.AIR || var1 == Blocks.FIRE || var1 == Blocks.PORTAL;
      }

      public boolean d() {
         return this.f != null && this.h >= 2 && this.h <= 21 && this.g >= 3 && this.g <= 21;
      }

      public void e() {
         for(int var1 = 0; var1 < this.h; ++var1) {
            BlockPosition var2 = this.f.shift(this.c, var1);

            for(int var3 = 0; var3 < this.g; ++var3) {
               this.a.setTypeAndData((BlockPosition)var2.up(var3), (IBlockData)Blocks.PORTAL.getBlockData().set(BlockPortal.a, this.b), 2);
            }
         }

      }
   }
}
