package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Block;
import net.minecraft.server.ItemBlock;
import net.minecraft.server.EnumColor;

public class class_aaa extends ItemBlock {
   public class_aaa(Block var1) {
      super(var1);
      this.e(0);
      this.a(true);
   }

   public int a(int var1) {
      return var1;
   }

   public String e_(ItemStack var1) {
      return super.a() + "." + EnumColor.b(var1.i()).d();
   }
}
