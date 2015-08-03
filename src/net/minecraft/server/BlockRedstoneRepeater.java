package net.minecraft.server;

import java.util.Random;

public class BlockRedstoneRepeater extends class_ahh {
   public static final BlockStateBoolean a = BlockStateBoolean.of("locked");
   public static final BlockStateInteger b = BlockStateInteger.of("delay", 1, 4);

   protected BlockRedstoneRepeater(boolean var1) {
      super(var1);
      this.setBlockData(this.blockStateList.getFirst().set(FACING, EnumDirection.NORTH).set(b, Integer.valueOf(1)).set(a, Boolean.valueOf(false)));
   }

   public String getName() {
      return LocaleI18n.get("item.diode.name");
   }

   public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
      return var1.set(a, Boolean.valueOf(this.b(var2, var3, var1)));
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      return var1.getBlock() != this?var1:var1.set(FACING, var2.a((EnumDirection)var1.get(FACING)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(FACING)));
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(!var4.abilities.mayBuild) {
         return false;
      } else {
         var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.a(b), 3);
         return true;
      }
   }

   protected int d(IBlockData var1) {
      return ((Integer)var1.get(b)).intValue() * 2;
   }

   protected IBlockData e(IBlockData var1) {
      Integer var2 = (Integer)var1.get(b);
      Boolean var3 = (Boolean)var1.get(a);
      EnumDirection var4 = (EnumDirection)var1.get(FACING);
      return Blocks.POWERED_REPEATER.getBlockData().set(FACING, var4).set(b, var2).set(a, var3);
   }

   protected IBlockData k(IBlockData var1) {
      Integer var2 = (Integer)var1.get(b);
      Boolean var3 = (Boolean)var1.get(a);
      EnumDirection var4 = (EnumDirection)var1.get(FACING);
      return Blocks.UNPOWERED_REPEATER.getBlockData().set(FACING, var4).set(b, var2).set(a, var3);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.REPEATER;
   }

   public boolean b(IBlockAccess var1, BlockPosition var2, IBlockData var3) {
      return this.c(var1, var2, var3) > 0;
   }

   protected boolean c(Block var1) {
      return d(var1);
   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      super.remove(var1, var2, var3);
      this.h(var1, var2, var3);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(FACING, EnumDirection.getByHorizontalId(var1)).set(a, Boolean.valueOf(false)).set(b, Integer.valueOf(1 + (var1 >> 2)));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(FACING)).getHorizontalId();
      var3 |= ((Integer)var1.get(b)).intValue() - 1 << 2;
      return var3;
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{FACING, b, a});
   }
}
