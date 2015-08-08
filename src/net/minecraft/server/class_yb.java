package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_yb extends Container {
   private static final Logger f = LogManager.getLogger();
   private IInventory g = new class_yv();
   private IInventory h = new class_ow("Repair", true, 2) {
      public void update() {
         super.update();
         class_yb.this.a((IInventory)this);
      }
   };
   private World i;
   private BlockPosition j;
   public int a;
   private int k;
   private String l;
   private final EntityHuman m;

   public class_yb(PlayerInventory var1, final World var2, final BlockPosition var3, EntityHuman var4) {
      this.j = var3;
      this.i = var2;
      this.m = var4;
      this.a((class_yx)(new class_yx(this.h, 0, 27, 47)));
      this.a((class_yx)(new class_yx(this.h, 1, 76, 47)));
      this.a((class_yx)(new class_yx(this.g, 2, 134, 47) {
         public boolean a(ItemStack var1) {
            return false;
         }

         public boolean a(EntityHuman var1) {
            return (var1.abilities.instabuild || var1.expLevel >= class_yb.this.a) && class_yb.this.a > 0 && this.e();
         }

         public void a(EntityHuman var1, ItemStack var2x) {
            if(!var1.abilities.instabuild) {
               var1.a(-class_yb.this.a);
            }

            class_yb.this.h.setItem(0, (ItemStack)null);
            if(class_yb.this.k > 0) {
               ItemStack var3x = class_yb.this.h.getItem(1);
               if(var3x != null && var3x.count > class_yb.this.k) {
                  var3x.count -= class_yb.this.k;
                  class_yb.this.h.setItem(1, var3x);
               } else {
                  class_yb.this.h.setItem(1, (ItemStack)null);
               }
            } else {
               class_yb.this.h.setItem(1, (ItemStack)null);
            }

            class_yb.this.a = 0;
            IBlockData var5 = var2.getType(var3);
            if(!var1.abilities.instabuild && !var2.isClientSide && var5.getBlock() == Blocks.ANVIL && var1.getRandom().nextFloat() < 0.12F) {
               int var4 = ((Integer)var5.get(BlockAnvil.b)).intValue();
               ++var4;
               if(var4 > 2) {
                  var2.setAir(var3);
                  var2.b(1020, var3, 0);
               } else {
                  var2.setTypeAndData((BlockPosition)var3, (IBlockData)var5.set(BlockAnvil.b, Integer.valueOf(var4)), 2);
                  var2.b(1021, var3, 0);
               }
            } else if(!var2.isClientSide) {
               var2.b(1021, var3, 0);
            }

         }
      }));

      int var5;
      for(var5 = 0; var5 < 3; ++var5) {
         for(int var6 = 0; var6 < 9; ++var6) {
            this.a((class_yx)(new class_yx(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, 84 + var5 * 18)));
         }
      }

      for(var5 = 0; var5 < 9; ++var5) {
         this.a((class_yx)(new class_yx(var1, var5, 8 + var5 * 18, 142)));
      }

   }

   public void a(IInventory var1) {
      super.a(var1);
      if(var1 == this.h) {
         this.e();
      }

   }

   public void e() {
      ItemStack var1 = this.h.getItem(0);
      this.a = 1;
      int var2 = 0;
      byte var3 = 0;
      byte var4 = 0;
      if(var1 == null) {
         this.g.setItem(0, (ItemStack)null);
         this.a = 0;
      } else {
         ItemStack var5 = var1.clone();
         ItemStack var6 = this.h.getItem(1);
         Map var7 = EnchantmentManager.a(var5);
         int var17 = var3 + var1.getRepairCost() + (var6 == null?0:var6.getRepairCost());
         this.k = 0;
         if(var6 != null) {
            boolean var8 = var6.getItem() == Items.ENCHANTED_BOOK && !Items.ENCHANTED_BOOK.h(var6).isEmpty();
            int var9;
            int var10;
            int var11;
            if(var5.e() && var5.getItem().canRepairWith(var1, var6)) {
               var9 = Math.min(var5.h(), var5.j() / 4);
               if(var9 <= 0) {
                  this.g.setItem(0, (ItemStack)null);
                  this.a = 0;
                  return;
               }

               for(var10 = 0; var9 > 0 && var10 < var6.count; ++var10) {
                  var11 = var5.h() - var9;
                  var5.setData(var11);
                  ++var2;
                  var9 = Math.min(var5.h(), var5.j() / 4);
               }

               this.k = var10;
            } else {
               if(!var8 && (var5.getItem() != var6.getItem() || !var5.e())) {
                  this.g.setItem(0, (ItemStack)null);
                  this.a = 0;
                  return;
               }

               int var12;
               int var13;
               if(var5.e() && !var8) {
                  var9 = var1.j() - var1.h();
                  var10 = var6.j() - var6.h();
                  var11 = var10 + var5.j() * 12 / 100;
                  var12 = var9 + var11;
                  var13 = var5.j() - var12;
                  if(var13 < 0) {
                     var13 = 0;
                  }

                  if(var13 < var5.i()) {
                     var5.setData(var13);
                     var2 += 2;
                  }
               }

               Map var19 = EnchantmentManager.a(var6);
               Iterator var20 = var19.keySet().iterator();

               label144:
               while(true) {
                  class_adi var21;
                  do {
                     if(!var20.hasNext()) {
                        break label144;
                     }

                     var21 = (class_adi)var20.next();
                  } while(var21 == null);

                  var12 = var7.containsKey(var21)?((Integer)var7.get(var21)).intValue():0;
                  var13 = ((Integer)var19.get(var21)).intValue();
                  var13 = var12 == var13?var13 + 1:Math.max(var13, var12);
                  boolean var14 = var21.a(var1);
                  if(this.m.abilities.instabuild || var1.getItem() == Items.ENCHANTED_BOOK) {
                     var14 = true;
                  }

                  Iterator var15 = var7.keySet().iterator();

                  while(var15.hasNext()) {
                     class_adi var16 = (class_adi)var15.next();
                     if(var16 != var21 && !var21.a(var16)) {
                        var14 = false;
                        ++var2;
                     }
                  }

                  if(var14) {
                     if(var13 > var21.b()) {
                        var13 = var21.b();
                     }

                     var7.put(var21, Integer.valueOf(var13));
                     int var22 = 0;
                     switch(class_yb.SyntheticClass_1.a[var21.c().ordinal()]) {
                     case 1:
                        var22 = 1;
                        break;
                     case 2:
                        var22 = 2;
                        break;
                     case 3:
                        var22 = 4;
                        break;
                     case 4:
                        var22 = 8;
                     }

                     if(var8) {
                        var22 = Math.max(1, var22 / 2);
                     }

                     var2 += var22 * var13;
                  }
               }
            }
         }

         if(StringUtils.isBlank(this.l)) {
            if(var1.hasDisplayName()) {
               var4 = 1;
               var2 += var4;
               var5.removeDisplayName();
            }
         } else if(!this.l.equals(var1.getDisplayName())) {
            var4 = 1;
            var2 += var4;
            var5.setDisplayName(this.l);
         }

         this.a = var17 + var2;
         if(var2 <= 0) {
            var5 = null;
         }

         if(var4 == var2 && var4 > 0 && this.a >= 40) {
            this.a = 39;
         }

         if(this.a >= 40 && !this.m.abilities.instabuild) {
            var5 = null;
         }

         if(var5 != null) {
            int var18 = var5.getRepairCost();
            if(var6 != null && var18 < var6.getRepairCost()) {
               var18 = var6.getRepairCost();
            }

            var18 = var18 * 2 + 1;
            var5.setRepairCost(var18);
            EnchantmentManager.a(var7, var5);
         }

         this.g.setItem(0, var5);
         this.b();
      }
   }

   public void a(class_ye var1) {
      super.a(var1);
      var1.a(this, 0, this.a);
   }

   public void b(EntityHuman var1) {
      super.b(var1);
      if(!this.i.isClientSide) {
         for(int var2 = 0; var2 < this.h.getSize(); ++var2) {
            ItemStack var3 = this.h.splitWithoutUpdate(var2);
            if(var3 != null) {
               var1.a(var3, false);
            }
         }

      }
   }

   public boolean a(EntityHuman var1) {
      return this.i.getType(this.j).getBlock() != Blocks.ANVIL?false:var1.e((double)this.j.getX() + 0.5D, (double)this.j.getY() + 0.5D, (double)this.j.getZ() + 0.5D) <= 64.0D;
   }

   public ItemStack b(EntityHuman var1, int var2) {
      ItemStack var3 = null;
      class_yx var4 = (class_yx)this.c.get(var2);
      if(var4 != null && var4.e()) {
         ItemStack var5 = var4.d();
         var3 = var5.clone();
         if(var2 == 2) {
            if(!this.a(var5, 3, 39, true)) {
               return null;
            }

            var4.a(var5, var3);
         } else if(var2 != 0 && var2 != 1) {
            if(var2 >= 3 && var2 < 39 && !this.a(var5, 0, 2, false)) {
               return null;
            }
         } else if(!this.a(var5, 3, 39, false)) {
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

   public void a(String var1) {
      this.l = var1;
      if(this.a(2).e()) {
         ItemStack var2 = this.a(2).d();
         if(StringUtils.isBlank(var1)) {
            var2.removeDisplayName();
         } else {
            var2.setDisplayName(this.l);
         }
      }

      this.e();
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_adi.class_a_in_class_adi.values().length];

      static {
         try {
            a[class_adi.class_a_in_class_adi.a.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_adi.class_a_in_class_adi.b.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_adi.class_a_in_class_adi.c.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_adi.class_a_in_class_adi.d.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
