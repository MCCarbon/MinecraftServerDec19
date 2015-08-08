package net.minecraft.server;

public enum class_adj {
   a,
   b,
   c,
   d,
   e,
   f,
   g,
   h,
   i,
   j,
   k;

   public boolean a(Item var1) {
      if(this == a) {
         return true;
      } else if(this == j && var1.usesDurability()) {
         return true;
      } else if(var1 instanceof ItemArmor) {
         if(this == b) {
            return true;
         } else {
            ItemArmor var2 = (ItemArmor)var1;
            return var2.b == EnumWearable.HEAD ?this == f:(var2.b == EnumWearable.LEGS ?this == d:(var2.b == EnumWearable.TORSO ?this == e:(var2.b == EnumWearable.FEET ?this == c:false)));
         }
      } else {
         return var1 instanceof ItemSword ?this == g:(var1 instanceof class_zv?this == h:(var1 instanceof ItemBow ?this == k:(var1 instanceof ItemFishingRod ?this == i:false)));
      }
   }
}
