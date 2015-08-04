package net.minecraft.server;

public class ItemSpectralArrow extends ItemArrow {
   public EntityArrow a(World var1, ItemStack var2, EntityLiving var3) {
      return new EntitySpectralArrow(var1, var3);
   }
}
