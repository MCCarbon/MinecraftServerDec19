package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.BlockDispenser;
import net.minecraft.server.ISourceBlock;
import net.minecraft.server.DispenseBehaviorItem;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_cz;
import net.minecraft.server.Entity;
import net.minecraft.server.class_xi;

public abstract class class_kb extends DispenseBehaviorItem {
   public ItemStack b(ISourceBlock var1, ItemStack var2) {
      World var3 = var1.getWorld();
      class_cz var4 = BlockDispenser.a(var1);
      EnumDirection var5 = BlockDispenser.b(var1.getData());
      class_xi var6 = this.a(var3, var4, var2);
      var6.shoot((double)var5.getAdjacentX(), (double)((float)var5.getAdjacentY() + 0.1F), (double)var5.getAdjacentZ(), this.b(), this.a());
      var3.addEntity((Entity)var6);
      var2.a(1);
      return var2;
   }

   protected void a(ISourceBlock var1) {
      var1.getWorld().b(1002, var1.getPosition(), 0);
   }

   protected abstract class_xi a(World var1, class_cz var2, ItemStack var3);

   protected float a() {
      return 6.0F;
   }

   protected float b() {
      return 1.1F;
   }
}
