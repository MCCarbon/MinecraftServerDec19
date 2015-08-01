package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.BlockContainer;
import net.minecraft.server.Block;
import net.minecraft.server.BlockDirectional;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityChest;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateDirection;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.StatisticList;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_oi;
import net.minecraft.server.IInventory;
import net.minecraft.server.class_ol;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.ITileInventory;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_uc;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;
import net.minecraft.server.CreativeTab;

public class class_agu extends BlockContainer {
   public static final BlockStateDirection a;
   public final int b;

   protected class_agu(int var1) {
      super(Material.WOOD);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH));
      this.b = var1;
      this.setCreativeTab(CreativeTab.DECORATIONS);
      this.setSizes(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public int getRenderType() {
      return 2;
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      if(var1.getType(var2.north()).getBlock() == this) {
         this.setSizes(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
      } else if(var1.getType(var2.south()).getBlock() == this) {
         this.setSizes(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
      } else if(var1.getType(var2.west()).getBlock() == this) {
         this.setSizes(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      } else if(var1.getType(var2.east()).getBlock() == this) {
         this.setSizes(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
      } else {
         this.setSizes(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      }

   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      this.e(var1, var2, var3);
      Iterator var4 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

      while(var4.hasNext()) {
         EnumDirection var5 = (EnumDirection)var4.next();
         BlockPosition var6 = var2.shift(var5);
         IBlockData var7 = var1.getType(var6);
         if(var7.getBlock() == this) {
            this.e(var1, var6, var7);
         }
      }

   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.getBlockData().set(a, var8.aR());
   }

   public void postPlace(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      EnumDirection var6 = EnumDirection.getByHorizontalId(MathHelper.floor((double)(var4.y * 4.0F / 360.0F) + 0.5D) & 3).opposite();
      var3 = var3.set(a, var6);
      BlockPosition var7 = var2.north();
      BlockPosition var8 = var2.south();
      BlockPosition var9 = var2.west();
      BlockPosition var10 = var2.east();
      boolean var11 = this == var1.getType(var7).getBlock();
      boolean var12 = this == var1.getType(var8).getBlock();
      boolean var13 = this == var1.getType(var9).getBlock();
      boolean var14 = this == var1.getType(var10).getBlock();
      if(!var11 && !var12 && !var13 && !var14) {
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 3);
      } else if(var6.getAxis() == EnumDirection.EnumAxis.X && (var11 || var12)) {
         if(var11) {
            var1.setTypeAndData((BlockPosition)var7, (IBlockData)var3, 3);
         } else {
            var1.setTypeAndData((BlockPosition)var8, (IBlockData)var3, 3);
         }

         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 3);
      } else if(var6.getAxis() == EnumDirection.EnumAxis.Z && (var13 || var14)) {
         if(var13) {
            var1.setTypeAndData((BlockPosition)var9, (IBlockData)var3, 3);
         } else {
            var1.setTypeAndData((BlockPosition)var10, (IBlockData)var3, 3);
         }

         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 3);
      }

      if(var5.hasDisplayName()) {
         TileEntity var15 = var1.getTileEntity(var2);
         if(var15 instanceof TileEntityChest) {
            ((TileEntityChest)var15).a(var5.getDisplayName());
         }
      }

   }

   public IBlockData e(World var1, BlockPosition var2, IBlockData var3) {
      if(var1.isClientSide) {
         return var3;
      } else {
         IBlockData var4 = var1.getType(var2.north());
         IBlockData var5 = var1.getType(var2.south());
         IBlockData var6 = var1.getType(var2.west());
         IBlockData var7 = var1.getType(var2.east());
         EnumDirection var8 = (EnumDirection)var3.get(a);
         Block var9 = var4.getBlock();
         Block var10 = var5.getBlock();
         Block var11 = var6.getBlock();
         Block var12 = var7.getBlock();
         if(var9 != this && var10 != this) {
            boolean var21 = var9.isFullBlock();
            boolean var22 = var10.isFullBlock();
            if(var11 == this || var12 == this) {
               BlockPosition var23 = var11 == this?var2.west():var2.east();
               IBlockData var24 = var1.getType(var23.north());
               IBlockData var25 = var1.getType(var23.south());
               var8 = EnumDirection.SOUTH;
               EnumDirection var26;
               if(var11 == this) {
                  var26 = (EnumDirection)var6.get(a);
               } else {
                  var26 = (EnumDirection)var7.get(a);
               }

               if(var26 == EnumDirection.NORTH) {
                  var8 = EnumDirection.NORTH;
               }

               Block var19 = var24.getBlock();
               Block var20 = var25.getBlock();
               if((var21 || var19.isFullBlock()) && !var22 && !var20.isFullBlock()) {
                  var8 = EnumDirection.SOUTH;
               }

               if((var22 || var20.isFullBlock()) && !var21 && !var19.isFullBlock()) {
                  var8 = EnumDirection.NORTH;
               }
            }
         } else {
            BlockPosition var13 = var9 == this?var2.north():var2.south();
            IBlockData var14 = var1.getType(var13.west());
            IBlockData var15 = var1.getType(var13.east());
            var8 = EnumDirection.EAST;
            EnumDirection var16;
            if(var9 == this) {
               var16 = (EnumDirection)var4.get(a);
            } else {
               var16 = (EnumDirection)var5.get(a);
            }

            if(var16 == EnumDirection.WEST) {
               var8 = EnumDirection.WEST;
            }

            Block var17 = var14.getBlock();
            Block var18 = var15.getBlock();
            if((var11.isFullBlock() || var17.isFullBlock()) && !var12.isFullBlock() && !var18.isFullBlock()) {
               var8 = EnumDirection.EAST;
            }

            if((var12.isFullBlock() || var18.isFullBlock()) && !var11.isFullBlock() && !var17.isFullBlock()) {
               var8 = EnumDirection.WEST;
            }
         }

         var3 = var3.set(a, var8);
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 3);
         return var3;
      }
   }

   public IBlockData f(World var1, BlockPosition var2, IBlockData var3) {
      EnumDirection var4 = null;
      Iterator var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

      while(var5.hasNext()) {
         EnumDirection var6 = (EnumDirection)var5.next();
         IBlockData var7 = var1.getType(var2.shift(var6));
         if(var7.getBlock() == this) {
            return var3;
         }

         if(var7.getBlock().isFullBlock()) {
            if(var4 != null) {
               var4 = null;
               break;
            }

            var4 = var6;
         }
      }

      if(var4 != null) {
         return var3.set(a, var4.opposite());
      } else {
         EnumDirection var8 = (EnumDirection)var3.get(a);
         if(var1.getType(var2.shift(var8)).getBlock().isFullBlock()) {
            var8 = var8.opposite();
         }

         if(var1.getType(var2.shift(var8)).getBlock().isFullBlock()) {
            var8 = var8.rotateY();
         }

         if(var1.getType(var2.shift(var8)).getBlock().isFullBlock()) {
            var8 = var8.opposite();
         }

         return var3.set(a, var8);
      }
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      int var3 = 0;
      BlockPosition var4 = var2.west();
      BlockPosition var5 = var2.east();
      BlockPosition var6 = var2.north();
      BlockPosition var7 = var2.south();
      if(var1.getType(var4).getBlock() == this) {
         if(this.m(var1, var4)) {
            return false;
         }

         ++var3;
      }

      if(var1.getType(var5).getBlock() == this) {
         if(this.m(var1, var5)) {
            return false;
         }

         ++var3;
      }

      if(var1.getType(var6).getBlock() == this) {
         if(this.m(var1, var6)) {
            return false;
         }

         ++var3;
      }

      if(var1.getType(var7).getBlock() == this) {
         if(this.m(var1, var7)) {
            return false;
         }

         ++var3;
      }

      return var3 <= 1;
   }

   private boolean m(World var1, BlockPosition var2) {
      if(var1.getType(var2).getBlock() != this) {
         return false;
      } else {
         Iterator var3 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

         EnumDirection var4;
         do {
            if(!var3.hasNext()) {
               return false;
            }

            var4 = (EnumDirection)var3.next();
         } while(var1.getType(var2.shift(var4)).getBlock() != this);

         return true;
      }
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      super.doPhysics(var1, var2, var3, var4);
      TileEntity var5 = var1.getTileEntity(var2);
      if(var5 instanceof TileEntityChest) {
         var5.resetBlockCache();
      }

   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      TileEntity var4 = var1.getTileEntity(var2);
      if(var4 instanceof IInventory) {
         class_ol.a(var1, var2, (IInventory)var4);
         var1.e(var2, this);
      }

      super.remove(var1, var2, var3);
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.isClientSide) {
         return true;
      } else {
         ITileInventory var11 = this.f(var1, var2);
         if(var11 != null) {
            var4.openContainer((IInventory)var11);
            if(this.b == 0) {
               var4.b(StatisticList.aa);
            } else if(this.b == 1) {
               var4.b(StatisticList.U);
            }
         }

         return true;
      }
   }

   public ITileInventory f(World var1, BlockPosition var2) {
      TileEntity var3 = var1.getTileEntity(var2);
      if(!(var3 instanceof TileEntityChest)) {
         return null;
      } else {
         Object var4 = (TileEntityChest)var3;
         if(this.n(var1, var2)) {
            return null;
         } else {
            Iterator var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

            while(true) {
               while(true) {
                  EnumDirection var6;
                  TileEntity var9;
                  do {
                     BlockPosition var7;
                     Block var8;
                     do {
                        if(!var5.hasNext()) {
                           return (ITileInventory)var4;
                        }

                        var6 = (EnumDirection)var5.next();
                        var7 = var2.shift(var6);
                        var8 = var1.getType(var7).getBlock();
                     } while(var8 != this);

                     if(this.n(var1, var7)) {
                        return null;
                     }

                     var9 = var1.getTileEntity(var7);
                  } while(!(var9 instanceof TileEntityChest));

                  if(var6 != EnumDirection.WEST && var6 != EnumDirection.NORTH) {
                     var4 = new class_oi("container.chestDouble", (ITileInventory)var4, (TileEntityChest)var9);
                  } else {
                     var4 = new class_oi("container.chestDouble", (TileEntityChest)var9, (ITileInventory)var4);
                  }
               }
            }
         }
      }
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityChest();
   }

   public boolean isPowerSource() {
      return this.b == 1;
   }

   public int a(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      if(!this.isPowerSource()) {
         return 0;
      } else {
         int var5 = 0;
         TileEntity var6 = var1.getTileEntity(var2);
         if(var6 instanceof TileEntityChest) {
            var5 = ((TileEntityChest)var6).l;
         }

         return MathHelper.clamp(var5, 0, 15);
      }
   }

   public int b(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return var4 == EnumDirection.UP?this.a(var1, var2, var3, var4):0;
   }

   private boolean n(World var1, BlockPosition var2) {
      return this.o(var1, var2) || this.p(var1, var2);
   }

   private boolean o(World var1, BlockPosition var2) {
      return var1.getType(var2.up()).getBlock().isOccluding();
   }

   private boolean p(World var1, BlockPosition var2) {
      Iterator var3 = var1.getEntities(class_uc.class, new AxisAlignedBB((double)var2.getX(), (double)(var2.getY() + 1), (double)var2.getZ(), (double)(var2.getX() + 1), (double)(var2.getY() + 2), (double)(var2.getZ() + 1))).iterator();

      class_uc var5;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         Entity var4 = (Entity)var3.next();
         var5 = (class_uc)var4;
      } while(!var5.cC());

      return true;
   }

   public boolean isComplexRedstone() {
      return true;
   }

   public int getRedstonePower(World var1, BlockPosition var2) {
      return Container.b((IInventory)this.f(var1, var2));
   }

   public IBlockData fromLegacyData(int var1) {
      EnumDirection var2 = EnumDirection.getById(var1);
      if(var2.getAxis() == EnumDirection.EnumAxis.Y) {
         var2 = EnumDirection.NORTH;
      }

      return this.getBlockData().set(a, var2);
   }

   public int toLegacyData(IBlockData var1) {
      return ((EnumDirection)var1.get(a)).getId();
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

   static {
      a = BlockDirectional.FACING;
   }
}
