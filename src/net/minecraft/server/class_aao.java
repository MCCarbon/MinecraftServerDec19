package net.minecraft.server;

public class class_aao extends ItemFood {
   public class_aao(int var1, float var2, boolean var3) {
      super(var1, var2, var3);
      this.registerItemKey(true);
   }

   public class_abf g(ItemStack var1) {
      return var1.i() == 0?class_abf.c:class_abf.d;
   }

   protected void a(ItemStack var1, World var2, EntityHuman var3) {
      if(!var2.isClientSide) {
         var3.c(new class_pl(class_pm.v, 2400, 0));
      }

      if(var1.i() > 0) {
         if(!var2.isClientSide) {
            var3.c(new class_pl(class_pm.j, 600, 4));
            var3.c(new class_pl(class_pm.k, 6000, 0));
            var3.c(new class_pl(class_pm.l, 6000, 0));
         }
      } else {
         super.a(var1, var2, var3);
      }

   }
}
