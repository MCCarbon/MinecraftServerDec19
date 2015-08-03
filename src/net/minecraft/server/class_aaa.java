package net.minecraft.server;

public class class_aaa extends ItemBlock {
   public class_aaa(Block var1) {
      super(var1);
      this.e(0);
      this.registerItemKey(true);
   }

   public int registerItemKey(int var1) {
      return var1;
   }

   public String e_(ItemStack var1) {
      return super.registerItemKey() + "." + EnumColor.b(var1.i()).d();
   }
}
