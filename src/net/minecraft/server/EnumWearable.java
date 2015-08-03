package net.minecraft.server;

public enum EnumWearable {
    MAINHAND(SLOT.HAND, 0, 0, "mainhand"),
    OFFHAND(SLOT.HAND, 1, 5, "offhand"),
    FEET(SLOT.ARMOR, 0, 1, "feet"),
    LEGS(SLOT.ARMOR, 1, 2, "legs"),
    TORSO(SLOT.ARMOR, 2, 3, "torso"),
    HEAD(SLOT.ARMOR, 3, 4, "head");

   private final SLOT g;
   private final int h;
   private final int i;
   private final String j;

   private EnumWearable(SLOT var3, int var4, int var5, String var6) {
      this.g = var3;
      this.h = var4;
      this.i = var5;
      this.j = var6;
   }

   public SLOT getSlot() {
      return this.g;
   }

   public int getRelative() {
      return this.h;
   }

   public int getAbsolute() {
      return this.i;
   }

   public enum SLOT {
       HAND,
       ARMOR;
   }
}
