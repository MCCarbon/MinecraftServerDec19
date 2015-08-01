package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.BlockLeaves;
import net.minecraft.server.ItemBlock;

public class class_aaw extends ItemBlock {
   private final BlockLeaves b;

   public class_aaw(BlockLeaves var1) {
      super(var1);
      this.b = var1;
      this.e(0);
      this.a(true);
   }

   public int a(int var1) {
      return var1 | 4;
   }

   public String e_(ItemStack var1) {
      return super.a() + "." + this.b.b(var1.i()).d();
   }
}
