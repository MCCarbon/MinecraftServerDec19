package net.minecraft.server;

public class ItemLeaves extends ItemBlock {
   private final BlockLeaves b;

   public ItemLeaves(BlockLeaves var1) {
      super(var1);
      this.b = var1;
      this.e(0);
      this.registerItemKey(true);
   }

   public int registerItemKey(int var1) {
      return var1 | 4;
   }

   public String e_(ItemStack var1) {
      return super.registerItemKey() + "." + this.b.b(var1.i()).d();
   }
}
