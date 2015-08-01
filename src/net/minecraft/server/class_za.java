package net.minecraft.server;

import com.google.common.base.Predicates;
import java.util.List;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.BlockDispenser;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.ISourceBlock;
import net.minecraft.server.DispenseBehaviorItem;
import net.minecraft.server.IDispenseBehavior;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTag;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pv;
import net.minecraft.server.class_pw;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qb;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_za extends Item {
   private static final int[] k = new int[]{13, 15, 16, 11};
   public static final String[] a = new String[]{"minecraft:items/empty_armor_slot_boots", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_helmet"};
   private static final IDispenseBehavior l = new DispenseBehaviorItem() {
      protected ItemStack b(ISourceBlock var1, ItemStack var2) {
         BlockPosition var3 = var1.getPosition().shift(BlockDispenser.b(var1.getData()));
         int var4 = var3.getX();
         int var5 = var3.getY();
         int var6 = var3.getZ();
         AxisAlignedBB var7 = new AxisAlignedBB((double)var4, (double)var5, (double)var6, (double)(var4 + 1), (double)(var5 + 1), (double)(var6 + 1));
         List var8 = var1.getWorld().a(EntityLiving.class, var7, Predicates.and(class_pv.d, new class_pv.class_a_in_class_pv(var2)));
         if(!var8.isEmpty()) {
            EntityLiving var9 = (EntityLiving)var8.get(0);
            class_pw var10 = class_qb.c(var2);
            ItemStack var11 = var2.clone();
            var11.count = 1;
            var9.a(var10, var11);
            if(var9 instanceof class_qb) {
               ((class_qb)var9).a(var10, 2.0F);
            }

            --var2.count;
            return var2;
         } else {
            return super.b(var1, var2);
         }
      }
   };
   public final class_pw b;
   public final int c;
   public final int d;
   private final class_za.class_a_in_class_za m;

   public class_za(class_za.class_a_in_class_za var1, int var2, class_pw var3) {
      this.m = var1;
      this.b = var3;
      this.d = var2;
      this.c = var1.b(var3);
      this.e(var1.a(var3));
      this.h = 1;
      this.a(CreativeTab.COMBAT);
      BlockDispenser.REGISTRY.register(this, l);
   }

   public int c() {
      return this.m.a();
   }

   public class_za.class_a_in_class_za d() {
      return this.m;
   }

   public boolean d_(ItemStack var1) {
      return this.m != class_za.class_a_in_class_za.a?false:(!var1.hasTag()?false:(!var1.getTag().hasOfType("display", 10)?false:var1.getTag().getCompound("display").hasOfType("color", 3)));
   }

   public int b(ItemStack var1) {
      if(this.m != class_za.class_a_in_class_za.a) {
         return -1;
      } else {
         NBTTagCompound var2 = var1.getTag();
         if(var2 != null) {
            NBTTagCompound var3 = var2.getCompound("display");
            if(var3 != null && var3.hasOfType("color", 3)) {
               return var3.getInt("color");
            }
         }

         return 10511680;
      }
   }

   public void c(ItemStack var1) {
      if(this.m == class_za.class_a_in_class_za.a) {
         NBTTagCompound var2 = var1.getTag();
         if(var2 != null) {
            NBTTagCompound var3 = var2.getCompound("display");
            if(var3.has("color")) {
               var3.remove("color");
            }

         }
      }
   }

   public void b(ItemStack var1, int var2) {
      if(this.m != class_za.class_a_in_class_za.a) {
         throw new UnsupportedOperationException("Can\'t dye non-leather!");
      } else {
         NBTTagCompound var3 = var1.getTag();
         if(var3 == null) {
            var3 = new NBTTagCompound();
            var1.setTag(var3);
         }

         NBTTagCompound var4 = var3.getCompound("display");
         if(!var3.hasOfType("display", 10)) {
            var3.put((String)"display", (NBTTag)var4);
         }

         var4.put("color", var2);
      }
   }

   public boolean a(ItemStack var1, ItemStack var2) {
      return this.m.b() == var2.getItem()?true:super.a(var1, var2);
   }

   public class_or a(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      class_pw var5 = class_qb.c(var1);
      ItemStack var6 = var3.a(var5);
      if(var6 == null) {
         var3.a(var5, var1.clone());
         var1.count = 0;
         return new class_or(class_oq.a, var1);
      } else {
         return new class_or(class_oq.b, var1);
      }
   }

   public static enum class_a_in_class_za {
      a("leather", 5, new int[]{1, 2, 3, 1}, 15),
      b("chainmail", 15, new int[]{1, 4, 5, 2}, 12),
      c("iron", 15, new int[]{2, 5, 6, 2}, 9),
      d("gold", 7, new int[]{1, 3, 5, 2}, 25),
      e("diamond", 33, new int[]{3, 6, 8, 3}, 10);

      private final String f;
      private final int g;
      private final int[] h;
      private final int i;

      private class_a_in_class_za(String var3, int var4, int[] var5, int var6) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
         this.i = var6;
      }

      public int a(class_pw var1) {
         return class_za.k[var1.b()] * this.g;
      }

      public int b(class_pw var1) {
         return this.h[var1.b()];
      }

      public int a() {
         return this.i;
      }

      public Item b() {
         return this == a?Items.aH:(this == b?Items.l:(this == d?Items.m:(this == c?Items.l:(this == e?Items.k:null))));
      }
   }
}
