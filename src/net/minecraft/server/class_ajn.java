package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockLeaves;
import net.minecraft.server.BlockWood;
import net.minecraft.server.TileEntity;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.StatisticList;
import net.minecraft.server.EntityHuman;

public class class_ajn extends BlockLeaves {
   public static final BlockStateEnum Q = BlockStateEnum.of("variant", BlockWood.EnumLogVariant.class, new Predicate() {
      public boolean a(BlockWood.EnumLogVariant var1) {
         return var1.getId() >= 4;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((BlockWood.EnumLogVariant)var1);
      }
   });

   public class_ajn() {
      this.setBlockData(this.blockStateList.getFirst().set(Q, BlockWood.EnumLogVariant.ACACIA).set(CHECK_DECAY, Boolean.valueOf(true)).set(DECAYABLE, Boolean.valueOf(true)));
   }

   protected void a(World var1, BlockPosition var2, IBlockData var3, int var4) {
      if(var3.get(Q) == BlockWood.EnumLogVariant.DARK_OAK && var1.random.nextInt(var4) == 0) {
         dropItem(var1, var2, new ItemStack(Items.APPLE));
      }

   }

   public int getDropData(IBlockData var1) {
      return ((BlockWood.EnumLogVariant)var1.get(Q)).getId();
   }

   public int getDropData(World var1, BlockPosition var2) {
      IBlockData var3 = var1.getType(var2);
      return var3.getBlock().toLegacyData(var3) & 3;
   }

   protected ItemStack createItemStack(IBlockData var1) {
      return new ItemStack(Item.getItemOf((Block)this), 1, ((BlockWood.EnumLogVariant)var1.get(Q)).getId() - 4);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(Q, this.b(var1)).set(DECAYABLE, Boolean.valueOf((var1 & 4) == 0)).set(CHECK_DECAY, Boolean.valueOf((var1 & 8) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((BlockWood.EnumLogVariant)var1.get(Q)).getId() - 4;
      if(!((Boolean)var1.get(DECAYABLE)).booleanValue()) {
         var3 |= 4;
      }

      if(((Boolean)var1.get(CHECK_DECAY)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public BlockWood.EnumLogVariant b(int var1) {
      return BlockWood.EnumLogVariant.getById((var1 & 3) + 4);
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{Q, CHECK_DECAY, DECAYABLE});
   }

   public void breakBlockNaturally(World var1, EntityHuman var2, BlockPosition var3, IBlockData var4, TileEntity var5, ItemStack var6) {
      if(!var1.isClientSide && var6 != null && var6.getItem() == Items.bg) {
         var2.b(StatisticList.ab[Block.getId((Block)this)]);
         dropItem(var1, var3, new ItemStack(Item.getItemOf((Block)this), 1, ((BlockWood.EnumLogVariant)var4.get(Q)).getId() - 4));
      } else {
         super.breakBlockNaturally(var1, var2, var3, var4, var5, var6);
      }
   }
}
