package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;

public class class_ans implements Predicate {
   private final Block a;

   private class_ans(Block var1) {
      this.a = var1;
   }

   public static class_ans a(Block var0) {
      return new class_ans(var0);
   }

   public boolean a(IBlockData var1) {
      return var1 != null && var1.getBlock() == this.a;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((IBlockData)var1);
   }
}
