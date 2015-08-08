package net.minecraft.server;

public class class_aaa extends ItemBlock {
   public class_aaa(Block var1) {
      super(var1);
      this.setMaxDurability(0);
      this.setUsesData(true);
   }

   public int filterData(int var1) {
      return var1;
   }

   public String getName(ItemStack var1) {
      return super.getName() + "." + EnumColor.b(var1.i()).d();
   }
}
