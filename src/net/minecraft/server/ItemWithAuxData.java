package net.minecraft.server;

public class ItemWithAuxData extends ItemBlock {
   private final Block b;
   private String[] c;

   public ItemWithAuxData(Block var1, boolean var2) {
      super(var1);
      this.b = var1;
      if(var2) {
         this.setMaxDurability(0);
         this.setUsesData(true);
      }

   }

   public int filterData(int var1) {
      return var1;
   }

   public ItemWithAuxData a(String[] var1) {
      this.c = var1;
      return this;
   }

   public String getName(ItemStack var1) {
      if(this.c == null) {
         return super.getName(var1);
      } else {
         int var2 = var1.i();
         return var2 >= 0 && var2 < this.c.length?super.getName(var1) + "." + this.c[var2]:super.getName(var1);
      }
   }
}
