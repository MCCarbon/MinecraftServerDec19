package net.minecraft.server;

public class class_yz extends ItemMultiTexture {
   public class_yz(Block var1) {
      super(var1, var1, new String[]{"intact", "slightlyDamaged", "veryDamaged"});
   }

   public int registerItemKey(int var1) {
      return var1 << 2;
   }
}
