package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahh;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_xa;

public class class_ako extends class_ahh {
   public static final class_anw a = class_anw.a("locked");
   public static final class_anz b = class_anz.a("delay", 1, 4);

   protected class_ako(boolean var1) {
      super(var1);
      this.setBlockData(this.blockStateList.getFirst().set(O, EnumDirection.NORTH).set(b, Integer.valueOf(1)).set(a, Boolean.valueOf(false)));
   }

   public String getName() {
      return LocaleI18n.get("item.diode.name");
   }

   public IBlockData a(IBlockData var1, class_aer var2, BlockPosition var3) {
      return var1.set(a, Boolean.valueOf(this.b(var2, var3, var1)));
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(O, var2.a((EnumDirection)var1.get(O)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(O)));
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, EnumDirection var7, float var8, float var9, float var10) {
      if(!var4.bH.e) {
         return false;
      } else {
         var1.a((BlockPosition)var2, (IBlockData)var3.a(b), 3);
         return true;
      }
   }

   protected int d(IBlockData var1) {
      return ((Integer)var1.get(b)).intValue() * 2;
   }

   protected IBlockData e(IBlockData var1) {
      Integer var2 = (Integer)var1.get(b);
      Boolean var3 = (Boolean)var1.get(a);
      EnumDirection var4 = (EnumDirection)var1.get(O);
      return Blocks.POWERED_REPEATER.getBlockData().set(O, var4).set(b, var2).set(a, var3);
   }

   protected IBlockData k(IBlockData var1) {
      Integer var2 = (Integer)var1.get(b);
      Boolean var3 = (Boolean)var1.get(a);
      EnumDirection var4 = (EnumDirection)var1.get(O);
      return Blocks.UNPOWERED_REPEATER.getBlockData().set(O, var4).set(b, var2).set(a, var3);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.bd;
   }

   public boolean b(class_aer var1, BlockPosition var2, IBlockData var3) {
      return this.c(var1, var2, var3) > 0;
   }

   protected boolean c(Block var1) {
      return d(var1);
   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      super.b(var1, var2, var3);
      this.h(var1, var2, var3);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(O, EnumDirection.getByHorizontalId(var1)).set(a, Boolean.valueOf(false)).set(b, Integer.valueOf(1 + (var1 >> 2)));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(O)).getHorizontalId();
      var3 |= ((Integer)var1.get(b)).intValue() - 1 << 2;
      return var3;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{O, b, a});
   }
}
