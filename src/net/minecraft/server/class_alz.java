package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_age;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;

public class class_alz extends class_age {
   public static final class_anz a = class_anz.a("power", 0, 15);
   private final int b;

   protected class_alz(Material var1, int var2) {
      this(var1, var2, var1.getMapColor());
   }

   protected class_alz(Material var1, int var2, MaterialMapColor var3) {
      super(var1, var3);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
      this.b = var2;
   }

   protected int f(World var1, class_cj var2) {
      int var3 = Math.min(var1.a(class_pr.class, this.a(var2)).size(), this.b);
      if(var3 > 0) {
         float var4 = (float)Math.min(this.b, var3) / (float)this.b;
         return class_nu.f(var4 * 15.0F);
      } else {
         return 0;
      }
   }

   protected int e(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected IBlockData a(IBlockData var1, int var2) {
      return var1.set(a, Integer.valueOf(var2));
   }

   public int a(World var1) {
      return 10;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
