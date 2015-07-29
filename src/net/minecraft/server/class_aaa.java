package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.Block;
import net.minecraft.server.class_zg;
import net.minecraft.server.class_zy;

public class class_aaa extends class_zg {
   public class_aaa(Block var1) {
      super(var1);
      this.e(0);
      this.a(true);
   }

   public int a(int var1) {
      return var1;
   }

   public String e_(class_aas var1) {
      return super.a() + "." + class_zy.b(var1.i()).d();
   }
}
