package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_alu extends Block {
   public static final BlockStateBoolean a = BlockStateBoolean.of("up");
   public static final BlockStateBoolean b = BlockStateBoolean.of("north");
   public static final BlockStateBoolean N = BlockStateBoolean.of("east");
   public static final BlockStateBoolean O = BlockStateBoolean.of("south");
   public static final BlockStateBoolean P = BlockStateBoolean.of("west");
   public static final BlockStateBoolean[] Q;

   public class_alu() {
      super(Material.REPLACEABLE_PLANT);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)).set(P, Boolean.valueOf(false)));
      this.setTicking(true);
      this.setCreativeTab((CreativeTab)CreativeTab.DECORATIONS);
   }

   public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
      return var1.set(a, Boolean.valueOf(var2.getType(var3.up()).getBlock().isSoildFullCube()));
   }

   public void j() {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isReplaceable(World var1, BlockPosition var2) {
      return true;
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      float var3 = 0.0625F;
      float var4 = 1.0F;
      float var5 = 1.0F;
      float var6 = 1.0F;
      float var7 = 0.0F;
      float var8 = 0.0F;
      float var9 = 0.0F;
      boolean var10 = false;
      if(((Boolean)var1.getType(var2).get(P)).booleanValue()) {
         var7 = Math.max(var7, 0.0625F);
         var4 = 0.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var6 = 0.0F;
         var9 = 1.0F;
         var10 = true;
      }

      if(((Boolean)var1.getType(var2).get(N)).booleanValue()) {
         var4 = Math.min(var4, 0.9375F);
         var7 = 1.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var6 = 0.0F;
         var9 = 1.0F;
         var10 = true;
      }

      if(((Boolean)var1.getType(var2).get(b)).booleanValue()) {
         var9 = Math.max(var9, 0.0625F);
         var6 = 0.0F;
         var4 = 0.0F;
         var7 = 1.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var10 = true;
      }

      if(((Boolean)var1.getType(var2).get(O)).booleanValue()) {
         var6 = Math.min(var6, 0.9375F);
         var9 = 1.0F;
         var4 = 0.0F;
         var7 = 1.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var10 = true;
      }

      if(!var10 && this.c(var1.getType(var2.up()).getBlock())) {
         var5 = Math.min(var5, 0.9375F);
         var8 = 1.0F;
         var4 = 0.0F;
         var7 = 1.0F;
         var6 = 0.0F;
         var9 = 1.0F;
      }

      this.setSizes(var4, var5, var6, var7, var8, var9);
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      return null;
   }

   public boolean canPlace(World var1, BlockPosition var2, EnumDirection var3) {
      switch(class_alu.SyntheticClass_1.a[var3.ordinal()]) {
      case 1:
         return this.c(var1.getType(var2.up()).getBlock());
      case 2:
      case 3:
      case 4:
      case 5:
         return this.c(var1.getType(var2.shift(var3.opposite())).getBlock());
      default:
         return false;
      }
   }

   private boolean c(Block var1) {
      return var1.isFullCube() && var1.material.isSolid();
   }

   private boolean e(World var1, BlockPosition var2, IBlockData var3) {
      IBlockData var4 = var3;
      Iterator var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

      while(true) {
         BlockStateBoolean var7;
         IBlockData var8;
         do {
            EnumDirection var6;
            do {
               do {
                  if(!var5.hasNext()) {
                     if(d(var3) == 0) {
                        return false;
                     }

                     if(var4 != var3) {
                        var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 2);
                     }

                     return true;
                  }

                  var6 = (EnumDirection)var5.next();
                  var7 = a(var6);
               } while(!((Boolean)var3.get(var7)).booleanValue());
            } while(this.c(var1.getType(var2.shift(var6)).getBlock()));

            var8 = var1.getType(var2.up());
         } while(var8.getBlock() == this && ((Boolean)var8.get(var7)).booleanValue());

         var3 = var3.set(var7, Boolean.valueOf(false));
      }
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!var1.isClientSide && !this.e(var1, var2, var3)) {
         this.dropNaturallyForSure(var1, var2, var3, 0);
         var1.setAir(var2);
      }

   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(!var1.isClientSide) {
         if(var1.random.nextInt(4) == 0) {
            byte var5 = 4;
            int var6 = 5;
            boolean var7 = false;

            label191:
            for(int var8 = -var5; var8 <= var5; ++var8) {
               for(int var9 = -var5; var9 <= var5; ++var9) {
                  for(int var10 = -1; var10 <= 1; ++var10) {
                     if(var1.getType(var2.add(var8, var10, var9)).getBlock() == this) {
                        --var6;
                        if(var6 <= 0) {
                           var7 = true;
                           break label191;
                        }
                     }
                  }
               }
            }

            EnumDirection var18 = EnumDirection.getRandom(var4);
            BlockPosition var19 = var2.up();
            EnumDirection var24;
            if(var18 == EnumDirection.UP && var2.getY() < 255 && var1.isEmpty(var19)) {
               if(!var7) {
                  IBlockData var21 = var3;
                  Iterator var23 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

                  while(true) {
                     do {
                        if(!var23.hasNext()) {
                           if(((Boolean)var21.get(b)).booleanValue() || ((Boolean)var21.get(N)).booleanValue() || ((Boolean)var21.get(O)).booleanValue() || ((Boolean)var21.get(P)).booleanValue()) {
                              var1.setTypeAndData((BlockPosition)var19, (IBlockData)var21, 2);
                           }

                           return;
                        }

                        var24 = (EnumDirection)var23.next();
                     } while(!var4.nextBoolean() && this.c(var1.getType(var19.shift(var24)).getBlock()));

                     var21 = var21.set(a(var24), Boolean.valueOf(false));
                  }
               }
            } else {
               BlockPosition var20;
               if(var18.getAxis().isHorizontal() && !((Boolean)var3.get(a(var18))).booleanValue()) {
                  if(!var7) {
                     var20 = var2.shift(var18);
                     Block var22 = var1.getType(var20).getBlock();
                     if(var22.material == Material.AIR) {
                        var24 = var18.rotateY();
                        EnumDirection var25 = var18.rotateYCCW();
                        boolean var26 = ((Boolean)var3.get(a(var24))).booleanValue();
                        boolean var27 = ((Boolean)var3.get(a(var25))).booleanValue();
                        BlockPosition var28 = var20.shift(var24);
                        BlockPosition var17 = var20.shift(var25);
                        if(var26 && this.c(var1.getType(var28).getBlock())) {
                           var1.setTypeAndData((BlockPosition)var20, (IBlockData)this.getBlockData().set(a(var24), Boolean.valueOf(true)), 2);
                        } else if(var27 && this.c(var1.getType(var17).getBlock())) {
                           var1.setTypeAndData((BlockPosition)var20, (IBlockData)this.getBlockData().set(a(var25), Boolean.valueOf(true)), 2);
                        } else if(var26 && var1.isEmpty(var28) && this.c(var1.getType(var2.shift(var24)).getBlock())) {
                           var1.setTypeAndData((BlockPosition)var28, (IBlockData)this.getBlockData().set(a(var18.opposite()), Boolean.valueOf(true)), 2);
                        } else if(var27 && var1.isEmpty(var17) && this.c(var1.getType(var2.shift(var25)).getBlock())) {
                           var1.setTypeAndData((BlockPosition)var17, (IBlockData)this.getBlockData().set(a(var18.opposite()), Boolean.valueOf(true)), 2);
                        } else if(this.c(var1.getType(var20.up()).getBlock())) {
                           var1.setTypeAndData((BlockPosition)var20, (IBlockData)this.getBlockData(), 2);
                        }
                     } else if(var22.material.isOpaque() && var22.isFullCube()) {
                        var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a(var18), Boolean.valueOf(true)), 2);
                     }

                  }
               } else {
                  if(var2.getY() > 1) {
                     var20 = var2.down();
                     IBlockData var11 = var1.getType(var20);
                     Block var12 = var11.getBlock();
                     IBlockData var13;
                     Iterator var14;
                     EnumDirection var15;
                     if(var12.material == Material.AIR) {
                        var13 = var3;
                        var14 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

                        while(var14.hasNext()) {
                           var15 = (EnumDirection)var14.next();
                           if(var4.nextBoolean()) {
                              var13 = var13.set(a(var15), Boolean.valueOf(false));
                           }
                        }

                        if(((Boolean)var13.get(b)).booleanValue() || ((Boolean)var13.get(N)).booleanValue() || ((Boolean)var13.get(O)).booleanValue() || ((Boolean)var13.get(P)).booleanValue()) {
                           var1.setTypeAndData((BlockPosition)var20, (IBlockData)var13, 2);
                        }
                     } else if(var12 == this) {
                        var13 = var11;
                        var14 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

                        while(var14.hasNext()) {
                           var15 = (EnumDirection)var14.next();
                           BlockStateBoolean var16 = a(var15);
                           if(var4.nextBoolean() && ((Boolean)var3.get(var16)).booleanValue()) {
                              var13 = var13.set(var16, Boolean.valueOf(true));
                           }
                        }

                        if(((Boolean)var13.get(b)).booleanValue() || ((Boolean)var13.get(N)).booleanValue() || ((Boolean)var13.get(O)).booleanValue() || ((Boolean)var13.get(P)).booleanValue()) {
                           var1.setTypeAndData((BlockPosition)var20, (IBlockData)var13, 2);
                        }
                     }
                  }

               }
            }
         }
      }
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      IBlockData var9 = this.getBlockData().set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)).set(P, Boolean.valueOf(false));
      return var3.getAxis().isHorizontal()?var9.set(a(var3.opposite()), Boolean.valueOf(true)):var9;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return null;
   }

   public int getDropCount(Random var1) {
      return 0;
   }

   public void breakBlockNaturally(World var1, EntityHuman var2, BlockPosition var3, IBlockData var4, TileEntity var5, ItemStack var6) {
      if(!var1.isClientSide && var6 != null && var6.getItem() == Items.SHEARS) {
         var2.b(StatisticList.ab[Block.getId((Block)this)]);
         dropItem((World)var1, (BlockPosition)var3, (ItemStack)(new ItemStack(Blocks.VINE, 1, 0)));
      } else {
         super.breakBlockNaturally(var1, var2, var3, var4, var5, var6);
      }

   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(O, Boolean.valueOf((var1 & 1) > 0)).set(P, Boolean.valueOf((var1 & 2) > 0)).set(b, Boolean.valueOf((var1 & 4) > 0)).set(N, Boolean.valueOf((var1 & 8) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      int var2 = 0;
      if(((Boolean)var1.get(O)).booleanValue()) {
         var2 |= 1;
      }

      if(((Boolean)var1.get(P)).booleanValue()) {
         var2 |= 2;
      }

      if(((Boolean)var1.get(b)).booleanValue()) {
         var2 |= 4;
      }

      if(((Boolean)var1.get(N)).booleanValue()) {
         var2 |= 8;
      }

      return var2;
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b, N, O, P});
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_alu.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            return var1.set(b, var1.get(O)).set(N, var1.get(P)).set(O, var1.get(b)).set(P, var1.get(N));
         case 2:
            return var1.set(b, var1.get(N)).set(N, var1.get(O)).set(O, var1.get(P)).set(P, var1.get(b));
         case 3:
            return var1.set(b, var1.get(P)).set(N, var1.get(b)).set(O, var1.get(N)).set(P, var1.get(O));
         default:
            return var1;
         }
      }
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_alu.SyntheticClass_1.c[var2.ordinal()]) {
         case 1:
            return var1.set(b, var1.get(O)).set(O, var1.get(b));
         case 2:
            return var1.set(N, var1.get(P)).set(P, var1.get(N));
         default:
            return super.a(var1, var2);
         }
      }
   }

   public static BlockStateBoolean a(EnumDirection var0) {
      switch(class_alu.SyntheticClass_1.a[var0.ordinal()]) {
      case 1:
         return a;
      case 2:
         return b;
      case 3:
         return O;
      case 4:
         return N;
      case 5:
         return P;
      default:
         throw new IllegalArgumentException(var0 + " is PORKCHOP invalid choice");
      }
   }

   public static int d(IBlockData var0) {
      int var1 = 0;
      BlockStateBoolean[] var2 = Q;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         BlockStateBoolean var5 = var2[var4];
         if(((Boolean)var0.get(var5)).booleanValue()) {
            ++var1;
         }
      }

      return var1;
   }

   static {
      Q = new BlockStateBoolean[]{a, b, O, P, N};
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            c[Block.class_a_in_class_agj.LEFT_RIGHT.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            c[Block.class_a_in_class_agj.FRONT_BACK.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
            ;
         }

         b = new int[Block.EnumRotation.values().length];

         try {
            b[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            b[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            b[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
            ;
         }

         a = new int[EnumDirection.values().length];

         try {
            a[EnumDirection.UP.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[EnumDirection.NORTH.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[EnumDirection.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.WEST.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
