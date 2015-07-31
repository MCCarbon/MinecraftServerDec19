package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahd;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_ow;
import net.minecraft.server.class_rx;
import net.minecraft.server.class_wv;

public class class_ro extends class_rx {
   private final class_wv c;
   private boolean d;
   private boolean e;
   private int f;

   public class_ro(class_wv var1, double var2) {
      super(var1, var2, 16);
      this.c = var1;
   }

   public boolean a() {
      if(this.a <= 0) {
         if(!this.c.o.R().b("mobGriefing")) {
            return false;
         }

         this.f = -1;
         this.d = this.c.cJ();
         this.e = this.c.cI();
      }

      return super.a();
   }

   public boolean b() {
      return this.f >= 0 && super.b();
   }

   public void c() {
      super.c();
   }

   public void d() {
      super.d();
   }

   public void e() {
      super.e();
      this.c.q().a((double)this.b.getX() + 0.5D, (double)(this.b.getY() + 1), (double)this.b.getZ() + 0.5D, 10.0F, (float)this.c.cd());
      if(this.f()) {
         World var1 = this.c.o;
         BlockPosition var2 = this.b.shiftUp();
         IBlockData var3 = var1.p(var2);
         Block var4 = var3.getBlock();
         if(this.f == 0 && var4 instanceof class_ahd && ((class_ahd)var4).e(var3)) {
            var1.b(var2, true);
         } else if(this.f == 1 && var4 == Blocks.AIR) {
            class_ow var5 = this.c.cF();

            for(int var6 = 0; var6 < var5.o_(); ++var6) {
               ItemStack var7 = var5.a(var6);
               boolean var8 = false;
               if(var7 != null) {
                  if(var7.getItem() == Items.P) {
                     var1.a((BlockPosition)var2, (IBlockData)Blocks.WHEAT.getBlockData(), 3);
                     var8 = true;
                  } else if(var7.getItem() == Items.bV) {
                     var1.a((BlockPosition)var2, (IBlockData)Blocks.POTATOES.getBlockData(), 3);
                     var8 = true;
                  } else if(var7.getItem() == Items.bU) {
                     var1.a((BlockPosition)var2, (IBlockData)Blocks.CARROTS.getBlockData(), 3);
                     var8 = true;
                  }
               }

               if(var8) {
                  --var7.count;
                  if(var7.count <= 0) {
                     var5.a(var6, (ItemStack)null);
                  }
                  break;
               }
            }
         }

         this.f = -1;
         this.a = 10;
      }

   }

   protected boolean a(World var1, BlockPosition var2) {
      Block var3 = var1.p(var2).getBlock();
      if(var3 == Blocks.FARMLAND) {
         var2 = var2.shiftUp();
         IBlockData var4 = var1.p(var2);
         var3 = var4.getBlock();
         if(var3 instanceof class_ahd && ((class_ahd)var3).e(var4) && this.e && (this.f == 0 || this.f < 0)) {
            this.f = 0;
            return true;
         }

         if(var3 == Blocks.AIR && this.d && (this.f == 1 || this.f < 0)) {
            this.f = 1;
            return true;
         }
      }

      return false;
   }
}
