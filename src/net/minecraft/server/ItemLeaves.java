package net.minecraft.server;

public class ItemLeaves extends ItemBlock {
   private final BlockLeaves b;

   public ItemLeaves(BlockLeaves var1) {
      super(var1);
      this.b = var1;
      this.setMaxDurability(0);
      this.setUsesData(true);
   }

   public int filterData(int var1) {
      return var1 | 4;
   }

   public String getName(ItemStack var1) {
      return super.getName() + "." + this.b.b(var1.i()).d();
   }
}
