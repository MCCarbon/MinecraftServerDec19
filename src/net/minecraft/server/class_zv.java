package net.minecraft.server;

import com.google.common.collect.Multimap;
import java.util.Set;

public class class_zv extends Item {
   private Set c;
   protected float a = 4.0F;
   private float d;
   protected EnumToolMaterial b;

   protected class_zv(float var1, EnumToolMaterial var2, Set var3) {
      this.b = var2;
      this.c = var3;
      this.h = 1;
      this.e(var2.a());
      this.a = var2.b();
      this.d = var1 + var2.c();
      this.registerItemKey(CreativeTab.TOOLS);
   }

   public float registerItemKey(ItemStack var1, Block var2) {
      return this.c.contains(var2)?this.a:1.0F;
   }

   public boolean registerItemKey(ItemStack var1, EntityLiving var2, EntityLiving var3) {
      var1.a(2, (EntityLiving)var3);
      return true;
   }

   public boolean registerItemKey(ItemStack var1, World var2, Block var3, BlockPosition var4, EntityLiving var5) {
      if((double)var3.getStrength(var2, var4) != 0.0D) {
         var1.a(1, (EntityLiving)var5);
      }

      return true;
   }

   public EnumToolMaterial g() {
      return this.b;
   }

   public int c() {
      return this.b.e();
   }

   public String h() {
      return this.b.toString();
   }

   public boolean registerItemKey(ItemStack var1, ItemStack var2) {
      return this.b.f() == var2.getItem()?true:super.registerItemKey(var1, var2);
   }

   public Multimap registerItemKey(EnumWearable var1) {
      Multimap var2 = super.registerItemKey(var1);
      if(var1 == EnumWearable.MAINHAND) {
         var2.put(class_wl.e.a(), new class_qm(uuid, "Tool modifier", (double)this.d, 0));
      }

      return var2;
   }
}
