package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_ahd;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_cj;

public class class_agi extends class_ahd {
   public static final class_anz a = class_anz.a("age", 0, 3);

   protected class_anz l() {
      return a;
   }

   public int n() {
      return 3;
   }

   protected Item o() {
      return Items.cK;
   }

   protected Item p() {
      return Items.cL;
   }

   public void b(World var1, class_cj var2, IBlockData var3, Random var4) {
      if(var4.nextInt(3) == 0) {
         this.e(var1, var2, var3);
      } else {
         super.b(var1, var2, var3, var4);
      }

   }

   protected int b(World var1) {
      return super.b(var1) / 3;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
