package net.minecraft.server;

import com.google.common.base.Function;

public class ItemMultiTexture extends ItemBlock {
   protected final Block b;
   protected final Function c;

   public ItemMultiTexture(Block var1, Block var2, Function var3) {
      super(var1);
      this.b = var2;
      this.c = var3;
      this.e(0);
      this.registerItemKey(true);
   }

   public ItemMultiTexture(Block var1, Block var2, final String[] var3) {
      this(var1, var2, new Function() {
         public String a(ItemStack var1) {
            int var2 = var1.i();
            if(var2 < 0 || var2 >= var3.length) {
               var2 = 0;
            }

            return var3[var2];
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((ItemStack)var1);
         }
      });
   }

   public int registerItemKey(int var1) {
      return var1;
   }

   public String e_(ItemStack var1) {
      return super.registerItemKey() + "." + (String)this.c.apply(var1);
   }
}
