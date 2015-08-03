package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.class_alp;
import net.minecraft.server.class_aql;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;

public class class_aqk extends class_aql {
   public static final BlockPosition a = new BlockPosition(0, 0, 0);
   public static final BlockPosition b;
   private final boolean c;

   public class_aqk(boolean var1) {
      this.c = var1;
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      Iterator var4 = BlockPosition.allInCubeM(new BlockPosition(var3.getX() - 4, var3.getY() - 1, var3.getZ() - 4), new BlockPosition(var3.getX() + 4, var3.getY() + 32, var3.getZ() + 4)).iterator();

      while(var4.hasNext()) {
         BlockPosition.MutableBlockPosition var5 = (BlockPosition.MutableBlockPosition)var4.next();
         double var6 = var5.distance(var3.getX(), var5.getY(), var3.getZ());
         if(var6 <= 3.5D) {
            if(var5.getY() < var3.getY()) {
               if(var6 <= 2.5D) {
                  this.a(var1, var5, BlockStainedGlassPane.BEDROCK.getBlockData());
               } else if(var5.getY() < var3.getY()) {
                  this.a(var1, var5, BlockStainedGlassPane.END_STONE.getBlockData());
               }
            } else if(var5.getY() > var3.getY()) {
               this.a(var1, var5, BlockStainedGlassPane.AIR.getBlockData());
            } else if(var6 > 2.5D) {
               this.a(var1, var5, BlockStainedGlassPane.BEDROCK.getBlockData());
            } else if(this.c) {
               this.a(var1, new BlockPosition(var5), BlockStainedGlassPane.END_PORTAL.getBlockData());
            } else {
               this.a(var1, new BlockPosition(var5), BlockStainedGlassPane.AIR.getBlockData());
            }
         }
      }

      for(int var8 = 0; var8 < 4; ++var8) {
         this.a(var1, var3.up(var8), BlockStainedGlassPane.BEDROCK.getBlockData());
      }

      BlockPosition var9 = var3.up(2);
      Iterator var10 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

      while(var10.hasNext()) {
         EnumDirection var11 = (EnumDirection)var10.next();
         this.a(var1, var9.shift(var11), BlockStainedGlassPane.TORCH.getBlockData().set(class_alp.a, var11));
      }

      if(this.c) {
         this.a(var1, var3.up(4), BlockStainedGlassPane.DRAGON_EGG.getBlockData());
      }

      return true;
   }

   static {
      b = new BlockPosition(a.getX() - 4 & -16, 0, a.getZ() - 4 & -16);
   }
}
