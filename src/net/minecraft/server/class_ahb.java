package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahh;
import net.minecraft.server.IContainer;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityComparator;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateBoolean;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.INamable;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_va;
import net.minecraft.server.EntityHuman;

public class class_ahb extends class_ahh implements IContainer {
   public static final BlockStateBoolean a = BlockStateBoolean.of("powered");
   public static final BlockStateEnum b = BlockStateEnum.of("mode", class_ahb.class_a_in_class_ahb.class);

   public class_ahb(boolean var1) {
      super(var1);
      this.setBlockData(this.blockStateList.getFirst().set(FACING, EnumDirection.NORTH).set(a, Boolean.valueOf(false)).set(b, class_ahb.class_a_in_class_ahb.a));
      this.isTileEntity = true;
   }

   public String getName() {
      return LocaleI18n.get("item.comparator.name");
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.ch;
   }

   protected int d(IBlockData var1) {
      return 2;
   }

   protected IBlockData e(IBlockData var1) {
      Boolean var2 = (Boolean)var1.get(a);
      class_ahb.class_a_in_class_ahb var3 = (class_ahb.class_a_in_class_ahb)var1.get(b);
      EnumDirection var4 = (EnumDirection)var1.get(FACING);
      return Blocks.POWERED_COMPARATOR.getBlockData().set(FACING, var4).set(a, var2).set(b, var3);
   }

   protected IBlockData k(IBlockData var1) {
      Boolean var2 = (Boolean)var1.get(a);
      class_ahb.class_a_in_class_ahb var3 = (class_ahb.class_a_in_class_ahb)var1.get(b);
      EnumDirection var4 = (EnumDirection)var1.get(FACING);
      return Blocks.UNPOWERED_COMPARATOR.getBlockData().set(FACING, var4).set(a, var2).set(b, var3);
   }

   protected boolean l(IBlockData var1) {
      return this.N || ((Boolean)var1.get(a)).booleanValue();
   }

   protected int a(IBlockAccess var1, BlockPosition var2, IBlockData var3) {
      TileEntity var4 = var1.getTileEntity(var2);
      return var4 instanceof TileEntityComparator?((TileEntityComparator)var4).b():0;
   }

   private int j(World var1, BlockPosition var2, IBlockData var3) {
      return var3.get(b) == class_ahb.class_a_in_class_ahb.b?Math.max(this.f(var1, var2, var3) - this.c((IBlockAccess) var1, var2, var3), 0):this.f(var1, var2, var3);
   }

   protected boolean e(World var1, BlockPosition var2, IBlockData var3) {
      int var4 = this.f(var1, var2, var3);
      if(var4 >= 15) {
         return true;
      } else if(var4 == 0) {
         return false;
      } else {
         int var5 = this.c((IBlockAccess) var1, var2, var3);
         return var5 == 0?true:var4 >= var5;
      }
   }

   protected int f(World var1, BlockPosition var2, IBlockData var3) {
      int var4 = super.f(var1, var2, var3);
      EnumDirection var5 = (EnumDirection)var3.get(FACING);
      BlockPosition var6 = var2.shift(var5);
      Block var7 = var1.getType(var6).getBlock();
      if(var7.isComplexRedstone()) {
         var4 = var7.getRedstonePower(var1, var6);
      } else if(var4 < 15 && var7.isOccluding()) {
         var6 = var6.shift(var5);
         var7 = var1.getType(var6).getBlock();
         if(var7.isComplexRedstone()) {
            var4 = var7.getRedstonePower(var1, var6);
         } else if(var7.getMaterial() == Material.AIR) {
            class_va var8 = this.a(var1, var5, var6);
            if(var8 != null) {
               var4 = var8.q();
            }
         }
      }

      return var4;
   }

   private class_va a(World var1, final EnumDirection var2, BlockPosition var3) {
      List var4 = var1.a(class_va.class, new AxisAlignedBB((double)var3.getX(), (double)var3.getY(), (double)var3.getZ(), (double)(var3.getX() + 1), (double)(var3.getY() + 1), (double)(var3.getZ() + 1)), new Predicate() {
         public boolean a(Entity var1) {
            return var1 != null && var1.aR() == var2;
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((Entity)var1);
         }
      });
      return var4.size() == 1?(class_va)var4.get(0):null;
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(!var4.bH.mayBuild) {
         return false;
      } else {
         var3 = var3.a(b);
         var1.a((double)var2.getX() + 0.5D, (double)var2.getY() + 0.5D, (double)var2.getZ() + 0.5D, "random.click", 0.3F, var3.get(b) == class_ahb.class_a_in_class_ahb.b?0.55F:0.5F);
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3, 2);
         this.k(var1, var2, var3);
         return true;
      }
   }

   protected void g(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.a((BlockPosition)var2, (Block)this)) {
         int var4 = this.j(var1, var2, var3);
         TileEntity var5 = var1.getTileEntity(var2);
         int var6 = var5 instanceof TileEntityComparator?((TileEntityComparator)var5).b():0;
         if(var4 != var6 || this.l(var3) != this.e(var1, var2, var3)) {
            if(this.i(var1, var2, var3)) {
               var1.a(var2, this, 2, -1);
            } else {
               var1.a(var2, this, 2, 0);
            }
         }

      }
   }

   private void k(World var1, BlockPosition var2, IBlockData var3) {
      int var4 = this.j(var1, var2, var3);
      TileEntity var5 = var1.getTileEntity(var2);
      int var6 = 0;
      if(var5 instanceof TileEntityComparator) {
         TileEntityComparator var7 = (TileEntityComparator)var5;
         var6 = var7.b();
         var7.a(var4);
      }

      if(var6 != var4 || var3.get(b) == class_ahb.class_a_in_class_ahb.a) {
         boolean var9 = this.e(var1, var2, var3);
         boolean var8 = this.l(var3);
         if(var8 && !var9) {
            var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(false)), 2);
         } else if(!var8 && var9) {
            var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(true)), 2);
         }

         this.h(var1, var2, var3);
      }

   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(this.N) {
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)this.k(var3).set(a, Boolean.valueOf(true)), 4);
      }

      this.k(var1, var2, var3);
   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      super.onPlace(var1, var2, var3);
      var1.a(var2, this.createTileEntity(var1, 0));
   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      super.remove(var1, var2, var3);
      var1.t(var2);
      this.h(var1, var2, var3);
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, int var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      TileEntity var6 = var1.getTileEntity(var2);
      return var6 == null?false:var6.handleClientInput(var4, var5);
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityComparator();
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(FACING, EnumDirection.getByHorizontalId(var1)).set(a, Boolean.valueOf((var1 & 8) > 0)).set(b, (var1 & 4) > 0?class_ahb.class_a_in_class_ahb.b:class_ahb.class_a_in_class_ahb.a);
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(FACING)).getHorizontalId();
      if(((Boolean)var1.get(a)).booleanValue()) {
         var3 |= 8;
      }

      if(var1.get(b) == class_ahb.class_a_in_class_ahb.b) {
         var3 |= 4;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      return var1.getBlock() != this?var1:var1.set(FACING, var2.a((EnumDirection)var1.get(FACING)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(FACING)));
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{FACING, b, a});
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.getBlockData().set(FACING, var8.aR().getOpposite()).set(a, Boolean.valueOf(false)).set(b, class_ahb.class_a_in_class_ahb.a);
   }

   public static enum class_a_in_class_ahb implements INamable {
      a("compare"),
      b("subtract");

      private final String c;

      private class_a_in_class_ahb(String var3) {
         this.c = var3;
      }

      public String toString() {
         return this.c;
      }

      public String getName() {
         return this.c;
      }
   }
}
