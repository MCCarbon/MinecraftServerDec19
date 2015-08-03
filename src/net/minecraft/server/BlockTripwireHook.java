package net.minecraft.server;

import com.google.common.base.Objects;
import java.util.Iterator;
import java.util.Random;

public class BlockTripwireHook extends Block {
   public static final BlockStateDirection a;
   public static final BlockStateBoolean b;
   public static final BlockStateBoolean N;
   public static final BlockStateBoolean O;

   public BlockTripwireHook() {
      super(Material.ORIENTABLE);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)));
      this.setCreativeTab(CreativeTab.REDSTONE);
      this.setTicking(true);
   }

   public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
      return var1.set(O, Boolean.valueOf(!World.a(var2, var3.down())));
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

   public boolean canPlace(World var1, BlockPosition var2, EnumDirection var3) {
      return var3.getAxis().isHorizontal() && var1.getType(var2.shift(var3.opposite())).getBlock().isOccluding();
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      Iterator var3 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

      EnumDirection var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (EnumDirection)var3.next();
      } while(!var1.getType(var2.shift(var4)).getBlock().isOccluding());

      return true;
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      IBlockData var9 = this.getBlockData().set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false));
      if(var3.getAxis().isHorizontal()) {
         var9 = var9.set(a, var3);
      }

      return var9;
   }

   public void postPlace(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      this.a(var1, var2, var3, false, false, -1, (IBlockData)null);
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(var4 != this) {
         if(this.e(var1, var2, var3)) {
            EnumDirection var5 = (EnumDirection)var3.get(a);
            if(!var1.getType(var2.shift(var5.opposite())).getBlock().isOccluding()) {
               this.dropNaturallyForSure(var1, var2, var3, 0);
               var1.setAir(var2);
            }
         }

      }
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, boolean var4, boolean var5, int var6, IBlockData var7) {
      EnumDirection var8 = (EnumDirection)var3.get(a);
      boolean var9 = ((Boolean)var3.get(N)).booleanValue();
      boolean var10 = ((Boolean)var3.get(b)).booleanValue();
      boolean var11 = !World.a((IBlockAccess)var1, (BlockPosition)var2.down());
      boolean var12 = !var4;
      boolean var13 = false;
      int var14 = 0;
      IBlockData[] var15 = new IBlockData[42];

      BlockPosition var17;
      for(int var16 = 1; var16 < 42; ++var16) {
         var17 = var2.shift(var8, var16);
         IBlockData var18 = var1.getType(var17);
         if(var18.getBlock() == Blocks.TRIPWIRE_HOOK) {
            if(var18.get(a) == var8.opposite()) {
               var14 = var16;
            }
            break;
         }

         if(var18.getBlock() != Blocks.TRIPWIRE && var16 != var6) {
            var15[var16] = null;
            var12 = false;
         } else {
            if(var16 == var6) {
               var18 = (IBlockData)Objects.firstNonNull(var7, var18);
            }

            boolean var19 = !((Boolean)var18.get(BlockTripwire.O)).booleanValue();
            boolean var20 = ((Boolean)var18.get(BlockTripwire.a)).booleanValue();
            boolean var21 = ((Boolean)var18.get(BlockTripwire.b)).booleanValue();
            var12 &= var21 == var11;
            var13 |= var19 && var20;
            var15[var16] = var18;
            if(var16 == var6) {
               var1.a((BlockPosition)var2, (Block)this, this.tickInterval(var1));
               var12 &= var19;
            }
         }
      }

      var12 &= var14 > 1;
      var13 &= var12;
      IBlockData var22 = this.getBlockData().set(N, Boolean.valueOf(var12)).set(b, Boolean.valueOf(var13));
      if(var14 > 0) {
         var17 = var2.shift(var8, var14);
         EnumDirection var24 = var8.opposite();
         var1.setTypeAndData((BlockPosition)var17, (IBlockData)var22.set(a, var24), 3);
         this.a(var1, var17, var24);
         this.a(var1, var17, var12, var13, var9, var10);
      }

      this.a(var1, var2, var12, var13, var9, var10);
      if(!var4) {
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var22.set(a, var8), 3);
         if(var5) {
            this.a(var1, var2, var8);
         }
      }

      if(var9 != var12) {
         for(int var23 = 1; var23 < var14; ++var23) {
            BlockPosition var25 = var2.shift(var8, var23);
            IBlockData var26 = var15[var23];
            if(var26 != null && var1.getType(var25).getBlock() != Blocks.AIR) {
               var1.setTypeAndData((BlockPosition)var25, (IBlockData)var26.set(N, Boolean.valueOf(var12)), 3);
            }
         }
      }

   }

   public void randomTick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      this.a(var1, var2, var3, false, true, -1, (IBlockData)null);
   }

   private void a(World var1, BlockPosition var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      if(var4 && !var6) {
         var1.a((double)var2.getX() + 0.5D, (double)var2.getY() + 0.1D, (double)var2.getZ() + 0.5D, "random.click", 0.4F, 0.6F);
      } else if(!var4 && var6) {
         var1.a((double)var2.getX() + 0.5D, (double)var2.getY() + 0.1D, (double)var2.getZ() + 0.5D, "random.click", 0.4F, 0.5F);
      } else if(var3 && !var5) {
         var1.a((double)var2.getX() + 0.5D, (double)var2.getY() + 0.1D, (double)var2.getZ() + 0.5D, "random.click", 0.4F, 0.7F);
      } else if(!var3 && var5) {
         var1.a((double)var2.getX() + 0.5D, (double)var2.getY() + 0.1D, (double)var2.getZ() + 0.5D, "random.bowhit", 0.4F, 1.2F / (var1.random.nextFloat() * 0.2F + 0.9F));
      }

   }

   private void a(World var1, BlockPosition var2, EnumDirection var3) {
      var1.c((BlockPosition)var2, (Block)this);
      var1.c((BlockPosition)var2.shift(var3.opposite()), (Block)this);
   }

   private boolean e(World var1, BlockPosition var2, IBlockData var3) {
      if(!this.canPlace(var1, var2)) {
         this.dropNaturallyForSure(var1, var2, var3, 0);
         var1.setAir(var2);
         return false;
      } else {
         return true;
      }
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      float var3 = 0.1875F;
      switch(BlockTripwireHook.SyntheticClass_1.a[((EnumDirection)var1.getType(var2).get(a)).ordinal()]) {
      case 1:
         this.setSizes(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
         break;
      case 2:
         this.setSizes(1.0F - var3 * 2.0F, 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
         break;
      case 3:
         this.setSizes(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
         break;
      case 4:
         this.setSizes(0.5F - var3, 0.2F, 1.0F - var3 * 2.0F, 0.5F + var3, 0.8F, 1.0F);
      }

   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      boolean var4 = ((Boolean)var3.get(N)).booleanValue();
      boolean var5 = ((Boolean)var3.get(b)).booleanValue();
      if(var4 || var5) {
         this.a(var1, var2, var3, true, false, -1, (IBlockData)null);
      }

      if(var5) {
         var1.c((BlockPosition)var2, (Block)this);
         var1.c((BlockPosition)var2.shift(((EnumDirection)var3.get(a)).opposite()), (Block)this);
      }

      super.remove(var1, var2, var3);
   }

   public int a(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return ((Boolean)var3.get(b)).booleanValue()?15:0;
   }

   public int b(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return !((Boolean)var3.get(b)).booleanValue()?0:(var3.get(a) == var4?15:0);
   }

   public boolean isPowerSource() {
      return true;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, EnumDirection.getByHorizontalId(var1 & 3)).set(b, Boolean.valueOf((var1 & 8) > 0)).set(N, Boolean.valueOf((var1 & 4) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(a)).getHorizontalId();
      if(((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 8;
      }

      if(((Boolean)var1.get(N)).booleanValue()) {
         var3 |= 4;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(a)));
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b, N, O});
   }

   static {
      a = BlockDirectional.FACING;
      b = BlockStateBoolean.of("powered");
      N = BlockStateBoolean.of("attached");
      O = BlockStateBoolean.of("suspended");
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumDirection.values().length];

      static {
         try {
            a[EnumDirection.EAST.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[EnumDirection.WEST.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.NORTH.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
