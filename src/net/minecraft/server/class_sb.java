package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_agh;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_rx;
import net.minecraft.server.class_uc;

public class class_sb extends class_rx {
   private final class_uc c;

   public class_sb(class_uc var1, double var2) {
      super(var1, var2, 8);
      this.c = var1;
   }

   public boolean a() {
      return this.c.cA() && !this.c.cC() && super.a();
   }

   public boolean b() {
      return super.b();
   }

   public void c() {
      super.c();
      this.c.cE().a(false);
   }

   public void d() {
      super.d();
      this.c.o(false);
   }

   public void e() {
      super.e();
      this.c.cE().a(false);
      if(!this.f()) {
         this.c.o(false);
      } else if(!this.c.cC()) {
         this.c.o(true);
      }

   }

   protected boolean a(World var1, BlockPosition var2) {
      if(!var1.d(var2.shiftUp())) {
         return false;
      } else {
         IBlockData var3 = var1.p(var2);
         Block var4 = var3.getBlock();
         if(var4 == Blocks.CHEST) {
            class_amg var5 = var1.s(var2);
            if(var5 instanceof class_ami && ((class_ami)var5).l < 1) {
               return true;
            }
         } else {
            if(var4 == Blocks.LIT_FURNACE) {
               return true;
            }

            if(var4 == Blocks.BED && var3.get(class_agh.a) != class_agh.class_a_in_class_agh.a) {
               return true;
            }
         }

         return false;
      }
   }
}
