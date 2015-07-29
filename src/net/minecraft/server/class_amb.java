package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aio;
import net.minecraft.server.class_ajw;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.CreativeTab;

public abstract class class_amb extends class_aio {
   public static final BlockStateEnum b = BlockStateEnum.of("variant", class_ajw.class_a_in_class_ajw.class);

   public class_amb() {
      super(Material.d);
      IBlockData var1 = this.blockStateList.getFirst();
      if(!this.l()) {
         var1 = var1.set(a, class_aio.class_a_in_class_aio.b);
      }

      this.setBlockData(var1.set(b, class_ajw.class_a_in_class_ajw.a));
      this.a((CreativeTab)CreativeTab.b);
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return ((class_ajw.class_a_in_class_ajw)var1.get(b)).c();
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getByBlock((Block)Blocks.WOODEN_SLAB);
   }

   public String b(int var1) {
      return super.getInternalName() + "." + class_ajw.class_a_in_class_ajw.a(var1).d();
   }

   public IBlockState n() {
      return b;
   }

   public Object a(class_aas var1) {
      return class_ajw.class_a_in_class_ajw.a(var1.i() & 7);
   }

   public IBlockData fromLegacyData(int var1) {
      IBlockData var2 = this.getBlockData().set(b, class_ajw.class_a_in_class_ajw.a(var1 & 7));
      if(!this.l()) {
         var2 = var2.set(a, (var1 & 8) == 0?class_aio.class_a_in_class_aio.b:class_aio.class_a_in_class_aio.a);
      }

      return var2;
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_ajw.class_a_in_class_ajw)var1.get(b)).a();
      if(!this.l() && var1.get(a) == class_aio.class_a_in_class_aio.a) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockStateList createBlockStateList() {
      return this.l()?new BlockStateList(this, new IBlockState[]{b}):new BlockStateList(this, new IBlockState[]{a, b});
   }

   public int getDropData(IBlockData var1) {
      return ((class_ajw.class_a_in_class_ajw)var1.get(b)).a();
   }
}
