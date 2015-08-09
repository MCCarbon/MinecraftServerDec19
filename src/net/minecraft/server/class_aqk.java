package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_aqk extends WorldGenerator {
   public static final BlockPosition a = new BlockPosition(0, 0, 0);
   public static final BlockPosition b;
   private final boolean c;

   public class_aqk(boolean var1) {
      this.c = var1;
   }

   public boolean generate(World var1, Random var2, BlockPosition var3) {
      Iterator var4 = BlockPosition.allInCubeM(new BlockPosition(var3.getX() - 4, var3.getY() - 1, var3.getZ() - 4), new BlockPosition(var3.getX() + 4, var3.getY() + 32, var3.getZ() + 4)).iterator();

      while(var4.hasNext()) {
         BlockPosition.MutableBlockPosition var5 = (BlockPosition.MutableBlockPosition)var4.next();
         double var6 = var5.distance(var3.getX(), var5.getY(), var3.getZ());
         if(var6 <= 3.5D) {
            if(var5.getY() < var3.getY()) {
               if(var6 <= 2.5D) {
                  this.setTypeAndData(var1, var5, Blocks.BEDROCK.getBlockData());
               } else if(var5.getY() < var3.getY()) {
                  this.setTypeAndData(var1, var5, Blocks.END_STONE.getBlockData());
               }
            } else if(var5.getY() > var3.getY()) {
               this.setTypeAndData(var1, var5, Blocks.AIR.getBlockData());
            } else if(var6 > 2.5D) {
               this.setTypeAndData(var1, var5, Blocks.BEDROCK.getBlockData());
            } else if(this.c) {
               this.setTypeAndData(var1, new BlockPosition(var5), Blocks.END_PORTAL.getBlockData());
            } else {
               this.setTypeAndData(var1, new BlockPosition(var5), Blocks.AIR.getBlockData());
            }
         }
      }

      for(int var8 = 0; var8 < 4; ++var8) {
         this.setTypeAndData(var1, var3.up(var8), Blocks.BEDROCK.getBlockData());
      }

      BlockPosition var9 = var3.up(2);
      Iterator var10 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

      while(var10.hasNext()) {
         EnumDirection var11 = (EnumDirection)var10.next();
         this.setTypeAndData(var1, var9.shift(var11), Blocks.TORCH.getBlockData().set(BlockTorch.a, var11));
      }

      if(this.c) {
         this.setTypeAndData(var1, var3.up(4), Blocks.DRAGON_EGG.getBlockData());
      }

      return true;
   }

   static {
      b = new BlockPosition(a.getX() - 4 & -16, 0, a.getZ() - 4 & -16);
   }
}
