package net.minecraft.server;

public class class_aal extends Item {
   public class_aal() {
      this.e(64);
      this.d(1);
      this.registerItemKey(CreativeTab.TOOLS);
      this.registerItemKey(new MinecraftKey("cast"), new class_aat() {
      });
   }

   public class_or registerItemKey(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      if(var3.bN != null) {
         int var5 = var3.bN.l();
         var1.a(var5, (EntityLiving)var3);
         var3.a((EnumUsedHand)var4);
         return new class_or(UseResult.CANT_USE, var1);
      } else {
         var2.a((Entity)var3, "random.bow", 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
         if(!var2.isClientSide) {
            var2.addEntity((Entity)(new class_ve(var2, var3)));
         }

         var3.a((EnumUsedHand)var4);
         var3.b(StatisticList.ad[Item.getId((Item)this)]);
         return new class_or(UseResult.SUCCESS, var1);
      }
   }

   public boolean f_(ItemStack var1) {
      return super.f_(var1);
   }

   public int c() {
      return 1;
   }
}
