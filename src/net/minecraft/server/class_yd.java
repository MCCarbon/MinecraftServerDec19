package net.minecraft.server;

public class class_yd extends Container {
   private IInventory a;
   private final class_yx f;
   private int g;

   public class_yd(PlayerInventory var1, IInventory var2) {
      this.a = var2;
      this.a((class_yx)(new class_yd.class_b_in_class_yd(var1.e, var2, 0, 56, 46)));
      this.a((class_yx)(new class_yd.class_b_in_class_yd(var1.e, var2, 1, 79, 53)));
      this.a((class_yx)(new class_yd.class_b_in_class_yd(var1.e, var2, 2, 102, 46)));
      this.f = this.a((class_yx)(new class_yd.class_a_in_class_yd(var2, 3, 79, 17)));

      int var3;
      for(var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 9; ++var4) {
            this.a((class_yx)(new class_yx(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18)));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.a((class_yx)(new class_yx(var1, var3, 8 + var3 * 18, 142)));
      }

   }

   public void a(class_ye var1) {
      super.a(var1);
      var1.a(this, (IInventory)this.a);
   }

   public void b() {
      super.b();

      for(int var1 = 0; var1 < this.e.size(); ++var1) {
         class_ye var2 = (class_ye)this.e.get(var1);
         if(this.g != this.a.getProperty(0)) {
            var2.a(this, 0, this.a.getProperty(0));
         }
      }

      this.g = this.a.getProperty(0);
   }

   public boolean a(EntityHuman var1) {
      return this.a.isReachable(var1);
   }

   public ItemStack b(EntityHuman var1, int var2) {
      ItemStack var3 = null;
      class_yx var4 = (class_yx)this.c.get(var2);
      if(var4 != null && var4.e()) {
         ItemStack var5 = var4.d();
         var3 = var5.clone();
         if((var2 < 0 || var2 > 2) && var2 != 3) {
            if(!this.f.e() && this.f.a(var5)) {
               if(!this.a(var5, 3, 4, false)) {
                  return null;
               }
            } else if(class_yd.class_b_in_class_yd.b_(var3)) {
               if(!this.a(var5, 0, 3, false)) {
                  return null;
               }
            } else if(var2 >= 4 && var2 < 31) {
               if(!this.a(var5, 31, 40, false)) {
                  return null;
               }
            } else if(var2 >= 31 && var2 < 40) {
               if(!this.a(var5, 4, 31, false)) {
                  return null;
               }
            } else if(!this.a(var5, 4, 40, false)) {
               return null;
            }
         } else {
            if(!this.a(var5, 4, 40, true)) {
               return null;
            }

            var4.a(var5, var3);
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

   static class class_a_in_class_yd extends class_yx {
      public class_a_in_class_yd(IInventory var1, int var2, int var3, int var4) {
         super(var1, var2, var3, var4);
      }

      public boolean a(ItemStack var1) {
         return var1 != null && PotionBrewer.a(var1);
      }

      public int a() {
         return 64;
      }
   }

   static class class_b_in_class_yd extends class_yx {
      private EntityHuman a;

      public class_b_in_class_yd(EntityHuman var1, IInventory var2, int var3, int var4, int var5) {
         super(var2, var3, var4, var5);
         this.a = var1;
      }

      public boolean a(ItemStack var1) {
         return b_(var1);
      }

      public int a() {
         return 1;
      }

      public void a(EntityHuman var1, ItemStack var2) {
         if(ItemPotion.i(var2) != class_acf.a) {
            this.a.b((class_my)class_mt.B);
         }

         super.a(var1, var2);
      }

      public static boolean b_(ItemStack var0) {
         return var0 != null && (var0.getItem() == Items.POTION || var0.getItem() == Items.GLASS_BOTTLE);
      }
   }
}
