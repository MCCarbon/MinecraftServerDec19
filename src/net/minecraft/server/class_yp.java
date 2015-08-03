package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_act;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.IInventory;
import net.minecraft.server.class_pw;
import net.minecraft.server.PlayerInventory;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;
import net.minecraft.server.class_yg;
import net.minecraft.server.class_yv;
import net.minecraft.server.class_yw;
import net.minecraft.server.class_yx;
import net.minecraft.server.ItemArmor;

public class class_yp extends Container {
   private static final class_pw[] h;
   public class_yg a = new class_yg(this, 2, 2);
   public IInventory f = new class_yv();
   public boolean g;
   private final EntityHuman i;

   public class_yp(final PlayerInventory var1, boolean var2, EntityHuman var3) {
      this.g = var2;
      this.i = var3;
      this.a((class_yx)(new class_yw(var1.e, this.a, this.f, 0, 154, 28)));

      int var4;
      int var5;
      for(var4 = 0; var4 < 2; ++var4) {
         for(var5 = 0; var5 < 2; ++var5) {
            this.a((class_yx)(new class_yx(this.a, var5 + var4 * 2, 98 + var5 * 18, 18 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 4; ++var4) {
         final class_pw var6 = h[var4];
         this.a((class_yx)(new class_yx(var1, 36 + (3 - var4), 8, 8 + var4 * 18) {
            public int a() {
               return 1;
            }

            public boolean a(ItemStack var1) {
               return var1 == null?false:(var1.getItem() instanceof ItemArmor?((ItemArmor)var1.getItem()).b == var6:(var1.getItem() != Item.getItemOf(BlockStainedGlassPane.PUMPKIN) && var1.getItem() != Items.ca?false:var6 == class_pw.f));
            }
         }));
      }

      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 9; ++var5) {
            this.a((class_yx)(new class_yx(var1, var5 + (var4 + 1) * 9, 8 + var5 * 18, 84 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.a((class_yx)(new class_yx(var1, var4, 8 + var4 * 18, 142)));
      }

      this.a((class_yx)(new class_yx(var1, 40, 77, 62) {
         public boolean a(ItemStack var1) {
            return super.a(var1);
         }
      }));
      this.a((IInventory)this.a);
   }

   public void a(IInventory var1) {
      this.f.setItem(0, class_act.a().a(this.a, this.i.o));
   }

   public void b(EntityHuman var1) {
      super.b(var1);

      for(int var2 = 0; var2 < 4; ++var2) {
         ItemStack var3 = this.a.splitWithoutUpdate(var2);
         if(var3 != null) {
            var1.a(var3, false);
         }
      }

      this.f.setItem(0, (ItemStack)null);
   }

   public boolean a(EntityHuman var1) {
      return true;
   }

   public ItemStack b(EntityHuman var1, int var2) {
      ItemStack var3 = null;
      class_yx var4 = (class_yx)this.c.get(var2);
      if(var4 != null && var4.e()) {
         ItemStack var5 = var4.d();
         var3 = var5.clone();
         if(var2 == 0) {
            if(!this.a(var5, 9, 45, true)) {
               return null;
            }

            var4.a(var5, var3);
         } else if(var2 >= 1 && var2 < 5) {
            if(!this.a(var5, 9, 45, false)) {
               return null;
            }
         } else if(var2 >= 5 && var2 < 9) {
            if(!this.a(var5, 9, 45, false)) {
               return null;
            }
         } else if(var3.getItem() instanceof ItemArmor && !((class_yx)this.c.get(8 - ((ItemArmor)var3.getItem()).b.b())).e()) {
            int var6 = 8 - ((ItemArmor)var3.getItem()).b.b();
            if(!this.a(var5, var6, var6 + 1, false)) {
               return null;
            }
         } else if(var2 >= 9 && var2 < 36) {
            if(!this.a(var5, 36, 45, false)) {
               return null;
            }
         } else if(var2 >= 36 && var2 < 45) {
            if(!this.a(var5, 9, 36, false)) {
               return null;
            }
         } else if(!this.a(var5, 9, 45, false)) {
            return null;
         }

         if(var5.count == 0) {
            var4.d((ItemStack)null);
         } else {
            var4.f();
         }

         if(var5.count == var3.count) {
            return null;
         }

         var4.a(var1, var5);
      }

      return var3;
   }

   public boolean a(ItemStack var1, class_yx var2) {
      return var2.d != this.f && super.a(var1, var2);
   }

   static {
      h = new class_pw[]{class_pw.f, class_pw.e, class_pw.d, class_pw.c};
   }
}
