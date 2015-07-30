package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public abstract class class_apw extends class_aql {
   public class_apw(boolean var1) {
      super(var1);
   }

   protected boolean a(Block var1) {
      Material var2 = var1.getMaterial();
      return var2 == Material.AIR || var2 == Material.LEAVES || var1 == Blocks.GRASS || var1 == Blocks.DIRT || var1 == Blocks.LOG || var1 == Blocks.LOG2 || var1 == Blocks.SAPLING || var1 == Blocks.VINE;
   }

   public void a(World var1, Random var2, BlockPosition var3) {
   }

   protected void a(World var1, BlockPosition var2) {
      if(var1.p(var2).getBlock() != Blocks.DIRT) {
         this.a(var1, var2, Blocks.DIRT.getBlockData());
      }

   }
}
