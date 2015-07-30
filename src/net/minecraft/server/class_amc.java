package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zy;

public class class_amc extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("color", class_zy.class);

   protected class_amc() {
      super(Material.WOOL);
      this.setBlockData(this.blockStateList.getFirst().set(a, class_zy.a));
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
      this.setTicking(true);
      this.a(CreativeTab.c);
      this.b(0);
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return ((class_zy)var1.get(a)).e();
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public void j() {
      this.b(0);
   }

   public void a(class_aer var1, BlockPosition var2) {
      this.b(0);
   }

   protected void b(int var1) {
      byte var2 = 0;
      float var3 = (float)(1 * (1 + var2)) / 16.0F;
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
   }

   public boolean d(World var1, BlockPosition var2) {
      return super.d(var1, var2) && this.e(var1, var2);
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   private boolean e(World var1, BlockPosition var2, IBlockData var3) {
      if(!this.e(var1, var2)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      } else {
         return true;
      }
   }

   private boolean e(World var1, BlockPosition var2) {
      return !var1.d(var2.shiftDown());
   }

   public int getDropData(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, class_zy.b(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
