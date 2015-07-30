package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vl;
import net.minecraft.server.CreativeTab;

public class class_ahx extends Block {
   public static boolean N;

   public class_ahx() {
      super(Material.SAND);
      this.a((CreativeTab)CreativeTab.b);
   }

   public class_ahx(Material var1) {
      super(var1);
   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      var1.a((BlockPosition)var2, (Block)this, this.a(var1));
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      var1.a((BlockPosition)var2, (Block)this, this.a(var1));
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(!var1.D) {
         this.f(var1, var2);
      }

   }

   private void f(World var1, BlockPosition var2) {
      if(e(var1, var2.shiftDown()) && var2.getY() >= 0) {
         byte var3 = 32;
         if(!N && var1.a(var2.add(-var3, -var3, -var3), var2.add(var3, var3, var3))) {
            if(!var1.D) {
               class_vl var5 = new class_vl(var1, (double)var2.getX() + 0.5D, (double)var2.getY(), (double)var2.getZ() + 0.5D, var1.p(var2));
               this.a(var5);
               var1.a((class_pr)var5);
            }
         } else {
            var1.g(var2);

            BlockPosition var4;
            for(var4 = var2.shiftDown(); e(var1, var4) && var4.getY() > 0; var4 = var4.shiftDown()) {
               ;
            }

            if(var4.getY() > 0) {
               var1.a(var4.shiftUp(), this.getBlockData());
            }
         }

      }
   }

   protected void a(class_vl var1) {
   }

   public int a(World var1) {
      return 2;
   }

   public static boolean e(World var0, BlockPosition var1) {
      Block var2 = var0.p(var1).getBlock();
      Material var3 = var2.material;
      return var2 == Blocks.FIRE || var3 == Material.AIR || var3 == Material.WATER || var3 == Material.LAVA;
   }

   public void a_(World var1, BlockPosition var2) {
   }
}
