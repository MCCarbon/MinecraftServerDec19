package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_aio;
import net.minecraft.server.IBlockData;
import net.minecraft.server.IBlockState;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.ItemBlock;

public class class_abq extends ItemBlock {
   private final class_aio b;
   private final class_aio c;

   public class_abq(Block var1, class_aio var2, class_aio var3) {
      super(var1);
      this.b = var2;
      this.c = var3;
      this.e(0);
      this.a(true);
   }

   public int a(int var1) {
      return var1;
   }

   public String e_(class_aas var1) {
      return this.b.b(var1.i());
   }

   public class_oq a(class_aas var1, class_xa var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var1.b == 0) {
         return class_oq.b;
      } else if(!var2.a(var4.shift(var6), var6, var1)) {
         return class_oq.b;
      } else {
         Object var10 = this.b.a(var1);
         IBlockData var11 = var3.p(var4);
         if(var11.getBlock() == this.b) {
            IBlockState var12 = this.b.n();
            Comparable var13 = var11.get(var12);
            class_aio.class_a_in_class_aio var14 = (class_aio.class_a_in_class_aio)var11.get(class_aio.a);
            if((var6 == EnumDirection.UP && var14 == class_aio.class_a_in_class_aio.b || var6 == EnumDirection.DOWN && var14 == class_aio.class_a_in_class_aio.a) && var13 == var10) {
               IBlockData var15 = this.c.getBlockData().set(var12, var13);
               if(var3.b(this.c.a(var3, var4, var15)) && var3.a((BlockPosition)var4, (IBlockData)var15, 3)) {
                  var3.a((double)((float)var4.getX() + 0.5F), (double)((float)var4.getY() + 0.5F), (double)((float)var4.getZ() + 0.5F), this.c.stepSound.b(), (this.c.stepSound.d() + 1.0F) / 2.0F, this.c.stepSound.e() * 0.8F);
                  --var1.b;
               }

               return class_oq.a;
            }
         }

         return this.a(var1, var3, var4.shift(var6), var10)?class_oq.a:super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }
   }

   private boolean a(class_aas var1, World var2, BlockPosition var3, Object var4) {
      IBlockData var5 = var2.p(var3);
      if(var5.getBlock() == this.b) {
         Comparable var6 = var5.get(this.b.n());
         if(var6 == var4) {
            IBlockData var7 = this.c.getBlockData().set(this.b.n(), var6);
            if(var2.b(this.c.a(var2, var3, var7)) && var2.a((BlockPosition)var3, (IBlockData)var7, 3)) {
               var2.a((double)((float)var3.getX() + 0.5F), (double)((float)var3.getY() + 0.5F), (double)((float)var3.getZ() + 0.5F), this.c.stepSound.b(), (this.c.stepSound.d() + 1.0F) / 2.0F, this.c.stepSound.e() * 0.8F);
               --var1.b;
            }

            return true;
         }
      }

      return false;
   }
}
