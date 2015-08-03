package net.minecraft.server;

public class class_abb extends Item {
   public class_abb() {
      this.registerItemKey(CreativeTab.TOOLS);
   }

   public boolean registerItemKey(ItemStack var1, EntityHuman var2, EntityLiving var3, EnumUsedHand var4) {
      if(!var1.hasDisplayName()) {
         return false;
      } else if(var3 instanceof class_qb) {
         class_qb var5 = (class_qb)var3;
         var5.a((String)var1.getDisplayName());
         var5.cl();
         --var1.count;
         return true;
      } else {
         return super.registerItemKey(var1, var2, var3, var4);
      }
   }
}
