package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.Block;
import net.minecraft.server.class_zg;

public class class_abx extends class_zg {
   private final Block b;
   private String[] c;

   public class_abx(Block var1, boolean var2) {
      super(var1);
      this.b = var1;
      if(var2) {
         this.e(0);
         this.a(true);
      }

   }

   public int a(int var1) {
      return var1;
   }

   public class_abx a(String[] var1) {
      this.c = var1;
      return this;
   }

   public String e_(class_aas var1) {
      if(this.c == null) {
         return super.e_(var1);
      } else {
         int var2 = var1.i();
         return var2 >= 0 && var2 < this.c.length?super.e_(var1) + "." + this.c[var2]:super.e_(var1);
      }
   }
}
