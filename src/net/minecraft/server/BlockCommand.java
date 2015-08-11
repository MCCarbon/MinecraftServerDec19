package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_aed;
import net.minecraft.server.World;
import net.minecraft.server.BlockContainer;
import net.minecraft.server.Block;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityCommand;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateBoolean;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityHuman;

public class BlockCommand extends BlockContainer {
   public static final BlockStateBoolean a = BlockStateBoolean.of("triggered");

   public BlockCommand() {
      super(Material.ORE, MaterialMapColor.COLOR16);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)));
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityCommand();
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!var1.isClientSide) {
         boolean var5 = var1.isBlockIndirectlyPowered(var2);
         boolean var6 = ((Boolean)var3.get(a)).booleanValue();
         if(var5 && !var6) {
            var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(true)), 4);
            var1.a((BlockPosition)var2, (Block)this, this.tickInterval(var1));
         } else if(!var5 && var6) {
            var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(false)), 4);
         }
      }

   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      TileEntity var5 = var1.getTileEntity(var2);
      if(var5 instanceof TileEntityCommand) {
         ((TileEntityCommand)var5).b().a(var1);
         var1.updateAdjacentComparators(var2, this);
      }

   }

   public int tickInterval(World var1) {
      return 1;
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      TileEntity var11 = var1.getTileEntity(var2);
      return var11 instanceof TileEntityCommand?((TileEntityCommand)var11).b().a(var4):false;
   }

   public boolean isComplexRedstone() {
      return true;
   }

   public int getRedstonePower(World var1, BlockPosition var2) {
      TileEntity var3 = var1.getTileEntity(var2);
      return var3 instanceof TileEntityCommand?((TileEntityCommand)var3).b().j():0;
   }

   public void postPlace(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      TileEntity var6 = var1.getTileEntity(var2);
      if(var6 instanceof TileEntityCommand) {
         class_aed var7 = ((TileEntityCommand)var6).b();
         if(var5.hasDisplayName()) {
            var7.b(var5.getDisplayName());
         }

         if(!var1.isClientSide) {
            var7.a(var1.R().getBooleanValue("sendCommandFeedback"));
         }

      }
   }

   public int getDropCount(Random var1) {
      return 0;
   }

   public int getRenderType() {
      return 3;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Boolean.valueOf((var1 & 1) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      int var2 = 0;
      if(((Boolean)var1.get(a)).booleanValue()) {
         var2 |= 1;
      }

      return var2;
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.getBlockData().set(a, Boolean.valueOf(false));
   }
}
