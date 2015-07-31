package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_oc;

public class class_vf extends class_oc.class_a_in_class_oc {
   private final ItemStack b;
   private float c;
   private boolean d;

   public class_vf(ItemStack var1, int var2) {
      super(var2);
      this.b = var1;
   }

   public ItemStack a(Random var1) {
      ItemStack var2 = this.b.clone();
      if(this.c > 0.0F) {
         int var3 = (int)(this.c * (float)this.b.j());
         int var4 = var2.j() - var1.nextInt(var1.nextInt(var3) + 1);
         if(var4 > var3) {
            var4 = var3;
         }

         if(var4 < 1) {
            var4 = 1;
         }

         var2.setData(var4);
      }

      if(this.d) {
         class_adk.a(var1, var2, 30);
      }

      return var2;
   }

   public class_vf a(float var1) {
      this.c = var1;
      return this;
   }

   public class_vf a() {
      this.d = true;
      return this;
   }
}
