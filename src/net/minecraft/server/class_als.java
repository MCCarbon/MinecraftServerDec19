package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class class_als extends Block {
   public static final BlockStateBoolean a = BlockStateBoolean.of("powered");
   public static final BlockStateBoolean b = BlockStateBoolean.of("suspended");
   public static final BlockStateBoolean N = BlockStateBoolean.of("attached");
   public static final BlockStateBoolean O = BlockStateBoolean.of("disarmed");
   public static final BlockStateBoolean P = BlockStateBoolean.of("north");
   public static final BlockStateBoolean Q = BlockStateBoolean.of("east");
   public static final BlockStateBoolean R = BlockStateBoolean.of("south");
   public static final BlockStateBoolean S = BlockStateBoolean.of("west");

   public class_als() {
      super(Material.ORIENTABLE);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)).set(P, Boolean.valueOf(false)).set(Q, Boolean.valueOf(false)).set(R, Boolean.valueOf(false)).set(S, Boolean.valueOf(false)));
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.15625F, 1.0F);
      this.setTicking(true);
   }

   public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
      return var1.set(P, Boolean.valueOf(c(var2, var3, var1, EnumDirection.NORTH))).set(Q, Boolean.valueOf(c(var2, var3, var1, EnumDirection.EAST))).set(R, Boolean.valueOf(c(var2, var3, var1, EnumDirection.SOUTH))).set(S, Boolean.valueOf(c(var2, var3, var1, EnumDirection.WEST)));
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      return null;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.STRING;
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      boolean var5 = ((Boolean)var3.get(b)).booleanValue();
      boolean var6 = !World.a((IBlockAccess)var1, (BlockPosition)var2.down());
      if(var5 != var6) {
         this.dropNaturallyForSure(var1, var2, var3, 0);
         var1.setAir(var2);
      }

   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      IBlockData var3 = var1.getType(var2);
      boolean var4 = ((Boolean)var3.get(N)).booleanValue();
      boolean var5 = ((Boolean)var3.get(b)).booleanValue();
      if(!var5) {
         this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.09375F, 1.0F);
      } else if(!var4) {
         this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      } else {
         this.setSizes(0.0F, 0.0625F, 0.0F, 1.0F, 0.15625F, 1.0F);
      }

   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      var3 = var3.set(b, Boolean.valueOf(!World.a((IBlockAccess)var1, (BlockPosition)var2.down())));
      var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 3);
      this.e(var1, var2, var3);
   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      this.e(var1, var2, var3.set(a, Boolean.valueOf(true)));
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4) {
      if(!var1.isClientSide) {
         if(var4.bA() != null && var4.bA().getItem() == Items.SHEARS) {
            var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(O, Boolean.valueOf(true)), 4);
         }

      }
   }

   private void e(World var1, BlockPosition var2, IBlockData var3) {
      EnumDirection[] var4 = new EnumDirection[]{EnumDirection.SOUTH, EnumDirection.WEST};
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         EnumDirection var7 = var4[var6];

         for(int var8 = 1; var8 < 42; ++var8) {
            BlockPosition var9 = var2.shift(var7, var8);
            IBlockData var10 = var1.getType(var9);
            if(var10.getBlock() == Blocks.TRIPWIRE_HOOK) {
               if(var10.get(BlockTripwireHook.a) == var7.opposite()) {
                  Blocks.TRIPWIRE_HOOK.a(var1, var9, var10, false, true, var8, var3);
               }
               break;
            }

            if(var10.getBlock() != Blocks.TRIPWIRE) {
               break;
            }
         }
      }

   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Entity var4) {
      if(!var1.isClientSide) {
         if(!((Boolean)var3.get(a)).booleanValue()) {
            this.e(var1, var2);
         }
      }
   }

   public void randomTick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(!var1.isClientSide) {
         if(((Boolean)var1.getType(var2).get(a)).booleanValue()) {
            this.e(var1, var2);
         }
      }
   }

   private void e(World var1, BlockPosition var2) {
      IBlockData var3 = var1.getType(var2);
      boolean var4 = ((Boolean)var3.get(a)).booleanValue();
      boolean var5 = false;
      List var6 = var1.getEntities((Entity)null, (AxisAlignedBB)(new AxisAlignedBB((double)var2.getX() + this.minX, (double)var2.getY() + this.minY, (double)var2.getZ() + this.minZ, (double)var2.getX() + this.maxX, (double)var2.getY() + this.maxY, (double)var2.getZ() + this.maxZ)));
      if(!var6.isEmpty()) {
         Iterator var7 = var6.iterator();

         while(var7.hasNext()) {
            Entity var8 = (Entity)var7.next();
            if(!var8.aK()) {
               var5 = true;
               break;
            }
         }
      }

      if(var5 != var4) {
         var3 = var3.set(a, Boolean.valueOf(var5));
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 3);
         this.e(var1, var2, var3);
      }

      if(var5) {
         var1.a((BlockPosition)var2, (Block)this, this.tickInterval(var1));
      }

   }

   public static boolean c(IBlockAccess var0, BlockPosition var1, IBlockData var2, EnumDirection var3) {
      BlockPosition var4 = var1.shift(var3);
      IBlockData var5 = var0.getType(var4);
      Block var6 = var5.getBlock();
      if(var6 == Blocks.TRIPWIRE_HOOK) {
         EnumDirection var9 = var3.opposite();
         return var5.get(BlockTripwireHook.a) == var9;
      } else if(var6 == Blocks.TRIPWIRE) {
         boolean var7 = ((Boolean)var2.get(b)).booleanValue();
         boolean var8 = ((Boolean)var5.get(b)).booleanValue();
         return var7 == var8;
      } else {
         return false;
      }
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Boolean.valueOf((var1 & 1) > 0)).set(b, Boolean.valueOf((var1 & 2) > 0)).set(N, Boolean.valueOf((var1 & 4) > 0)).set(O, Boolean.valueOf((var1 & 8) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      int var2 = 0;
      if(((Boolean)var1.get(a)).booleanValue()) {
         var2 |= 1;
      }

      if(((Boolean)var1.get(b)).booleanValue()) {
         var2 |= 2;
      }

      if(((Boolean)var1.get(N)).booleanValue()) {
         var2 |= 4;
      }

      if(((Boolean)var1.get(O)).booleanValue()) {
         var2 |= 8;
      }

      return var2;
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_als.SyntheticClass_1.a[var2.ordinal()]) {
         case 1:
            return var1.set(P, var1.get(R)).set(Q, var1.get(S)).set(R, var1.get(P)).set(S, var1.get(Q));
         case 2:
            return var1.set(P, var1.get(Q)).set(Q, var1.get(R)).set(R, var1.get(S)).set(S, var1.get(P));
         case 3:
            return var1.set(P, var1.get(S)).set(Q, var1.get(P)).set(R, var1.get(Q)).set(S, var1.get(R));
         default:
            return var1;
         }
      }
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_als.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            return var1.set(P, var1.get(R)).set(R, var1.get(P));
         case 2:
            return var1.set(Q, var1.get(S)).set(S, var1.get(Q));
         default:
            return super.a(var1, var2);
         }
      }
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b, N, O, P, Q, S, R});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            b[Block.class_a_in_class_agj.LEFT_RIGHT.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[Block.class_a_in_class_agj.FRONT_BACK.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[Block.EnumRotation.values().length];

         try {
            a[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
