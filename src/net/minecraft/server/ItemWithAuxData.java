package net.minecraft.server;

public class ItemWithAuxData extends ItemBlock {
   private final Block b;
   private String[] c;

   public ItemWithAuxData(Block var1, boolean var2) {
      super(var1);
      this.b = var1;
      if(var2) {
         this.e(0);
         this.registerItemKey(true);
      }

   }

   public int registerItemKey(int var1) {
      return var1;
   }

   public ItemWithAuxData a(String[] var1) {
      this.c = var1;
      return this;
   }

   public String e_(ItemStack var1) {
      if(this.c == null) {
         return super.e_(var1);
      } else {
         int var2 = var1.i();
         return var2 >= 0 && var2 < this.c.length?super.e_(var1) + "." + this.c[var2]:super.e_(var1);
      }
   }
}
