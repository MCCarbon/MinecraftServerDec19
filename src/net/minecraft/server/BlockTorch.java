package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Iterator;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahz;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateDirection;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.CreativeTab;

public class BlockTorch extends Block {
   public static final BlockStateDirection a = BlockStateDirection.of("facing", new Predicate() {
      public boolean a(EnumDirection var1) {
         return var1 != EnumDirection.DOWN;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((EnumDirection)var1);
      }
   });

   protected BlockTorch() {
      super(Material.ORIENTABLE);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.UP));
      this.setTicking(true);
      this.setCreativeTab(CreativeTab.DECORATIONS);
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

   private boolean e(World var1, BlockPosition var2) {
      if(World.a((IBlockAccess)var1, (BlockPosition)var2)) {
         return true;
      } else {
         Block var3 = var1.getType(var2).getBlock();
         return var3 instanceof class_ahz || var3 == Blocks.GLASS || var3 == Blocks.COBBLESTONE_WALL || var3 == Blocks.STAINED_GLASS;
      }
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      Iterator var3 = a.getValues().iterator();

      EnumDirection var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (EnumDirection)var3.next();
      } while(!this.a(var1, var2, var4));

      return true;
   }

   private boolean a(World var1, BlockPosition var2, EnumDirection var3) {
      BlockPosition var4 = var2.shift(var3.opposite());
      boolean var5 = var3.getAxis().isHorizontal();
      return var5 && var1.d(var4, true) || var3.equals(EnumDirection.UP) && this.e(var1, var4);
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      if(this.a(var1, var2, var3)) {
         return this.getBlockData().set(a, var3);
      } else {
         Iterator var9 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

         EnumDirection var10;
         do {
            if(!var9.hasNext()) {
               return this.getBlockData();
            }

            var10 = (EnumDirection)var9.next();
         } while(!var1.d(var2.shift(var10.opposite()), true));

         return this.getBlockData().set(a, var10);
      }
   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      this.f(var1, var2, var3);
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   protected boolean e(World var1, BlockPosition var2, IBlockData var3) {
      if(!this.f(var1, var2, var3)) {
         return true;
      } else {
         EnumDirection var4 = (EnumDirection)var3.get(a);
         EnumDirection.EnumAxis var5 = var4.getAxis();
         EnumDirection var6 = var4.opposite();
         boolean var7 = false;
         if(var5.isHorizontal() && !var1.d(var2.shift(var6), true)) {
            var7 = true;
         } else if(var5.isVertical() && !this.e(var1, var2.shift(var6))) {
            var7 = true;
         }

         if(var7) {
            this.dropNaturallyForSure(var1, var2, var3, 0);
            var1.setAir(var2);
            return true;
         } else {
            return false;
         }
      }
   }

   protected boolean f(World var1, BlockPosition var2, IBlockData var3) {
      if(var3.getBlock() == this && this.a(var1, var2, (EnumDirection)var3.get(a))) {
         return true;
      } else {
         if(var1.getType(var2).getBlock() == this) {
            this.dropNaturallyForSure(var1, var2, var3, 0);
            var1.setAir(var2);
         }

         return false;
      }
   }

   public MovingObjectPosition rayTraceCollision(World var1, BlockPosition var2, Vec3D var3, Vec3D var4) {
      EnumDirection var5 = (EnumDirection)var1.getType(var2).get(a);
      float var6 = 0.15F;
      if(var5 == EnumDirection.EAST) {
         this.setSizes(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
      } else if(var5 == EnumDirection.WEST) {
         this.setSizes(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
      } else if(var5 == EnumDirection.SOUTH) {
         this.setSizes(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
      } else if(var5 == EnumDirection.NORTH) {
         this.setSizes(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
      } else {
         var6 = 0.1F;
         this.setSizes(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
      }

      return super.rayTraceCollision(var1, var2, var3, var4);
   }

   public IBlockData fromLegacyData(int var1) {
      IBlockData var2 = this.getBlockData();
      switch(var1) {
      case 1:
         var2 = var2.set(a, EnumDirection.EAST);
         break;
      case 2:
         var2 = var2.set(a, EnumDirection.WEST);
         break;
      case 3:
         var2 = var2.set(a, EnumDirection.SOUTH);
         break;
      case 4:
         var2 = var2.set(a, EnumDirection.NORTH);
         break;
      case 5:
      default:
         var2 = var2.set(a, EnumDirection.UP);
      }

      return var2;
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3;
      switch(BlockTorch.SyntheticClass_1.a[((EnumDirection)var1.get(a)).ordinal()]) {
      case 1:
         var3 = var2 | 1;
         break;
      case 2:
         var3 = var2 | 2;
         break;
      case 3:
         var3 = var2 | 3;
         break;
      case 4:
         var3 = var2 | 4;
         break;
      case 5:
      case 6:
      default:
         var3 = var2 | 5;
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
      return new BlockStateList(this, new IBlockState[]{a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumDirection.values().length];

      static {
         try {
            a[EnumDirection.EAST.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[EnumDirection.WEST.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[EnumDirection.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[EnumDirection.NORTH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.DOWN.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.UP.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
