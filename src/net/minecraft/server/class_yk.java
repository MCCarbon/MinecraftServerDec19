package net.minecraft.server;

public class class_yk extends class_yx {
   public class_yk(IInventory var1, int var2, int var3, int var4) {
      super(var1, var2, var3, var4);
   }

   public boolean a(ItemStack var1) {
      return TileEntityFurnace.c(var1) || c_(var1);
   }

   public int b(ItemStack var1) {
      return c_(var1)?1:super.b(var1);
   }

   public static boolean c_(ItemStack var0) {
      return var0 != null && var0.getItem() != null && var0.getItem() == Items.BUCKET;
   }
}
