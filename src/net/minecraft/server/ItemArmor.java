package net.minecraft.server;

import com.google.common.base.Predicates;
import java.util.List;

public class ItemArmor extends Item {
   private static final int[] k = new int[]{13, 15, 16, 11};
   public static final String[] a = new String[]{"minecraft:items/empty_armor_slot_boots", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_helmet"};
   private static final IDispenseBehavior l = new DispenseBehaviorItem() {
      protected ItemStack b(ISourceBlock var1, ItemStack var2) {
         BlockPosition var3 = var1.getPosition().shift(BlockDispenser.b(var1.getData()));
         int var4 = var3.getX();
         int var5 = var3.getY();
         int var6 = var3.getZ();
         AxisAlignedBB var7 = new AxisAlignedBB((double)var4, (double)var5, (double)var6, (double)(var4 + 1), (double)(var5 + 1), (double)(var6 + 1));
         List var8 = var1.getWorld().a(EntityLiving.class, var7, Predicates.and(IEntitySelector.NOT_PLAYER_SPECTATOR, new IEntitySelector.class_a_in_class_pv(var2)));
         if(!var8.isEmpty()) {
            EntityLiving var9 = (EntityLiving)var8.get(0);
            EnumWearable var10 = EntityInsentient.c(var2);
            ItemStack var11 = var2.clone();
            var11.count = 1;
            var9.a(var10, var11);
            if(var9 instanceof EntityInsentient) {
               ((EntityInsentient)var9).a(var10, 2.0F);
            }

            --var2.count;
            return var2;
         } else {
            return super.b(var1, var2);
         }
      }
   };
   public final EnumWearable b;
   public final int c;
   public final int d;
   private final EnumArmorMaterial m;

   public ItemArmor(EnumArmorMaterial var1, int var2, EnumWearable var3) {
      this.m = var1;
      this.b = var3;
      this.d = var2;
      this.c = var1.b(var3);
      this.setMaxDurability(var1.a(var3));
      this.maxStackSize = 1;
      this.setCreativeTab(CreativeTab.COMBAT);
      BlockDispenser.REGISTRY.register(this, l);
   }

   public int getItemEnchantability() {
      return this.m.a();
   }

   public EnumArmorMaterial d() {
      return this.m;
   }

   public boolean d_(ItemStack var1) {
      return this.m != EnumArmorMaterial.LEATHER ?false:(!var1.hasTag()?false:(!var1.getTag().hasOfType("display", 10)?false:var1.getTag().getCompound("display").hasOfType("color", 3)));
   }

   public int b(ItemStack var1) {
      if(this.m != EnumArmorMaterial.LEATHER) {
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
      if(this.m == EnumArmorMaterial.LEATHER) {
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
      if(this.m != EnumArmorMaterial.LEATHER) {
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

   public boolean canRepairWith(ItemStack var1, ItemStack var2) {
      return this.m.b() == var2.getItem()?true:super.canRepairWith(var1, var2);
   }

   public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      EnumWearable var5 = EntityInsentient.c(var1);
      ItemStack var6 = var3.a(var5);
      if(var6 == null) {
         var3.a(var5, var1.clone());
         var1.count = 0;
         return new UseResultWithValue(UseResult.SUCCESS, var1);
      } else {
         return new UseResultWithValue(UseResult.CANT_USE, var1);
      }
   }

   public static enum EnumArmorMaterial {
      LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15),
      CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12),
      IRON("iron", 15, new int[]{2, 5, 6, 2}, 9),
      GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25),
      DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10);

      private final String f;
      private final int g;
      private final int[] h;
      private final int i;

      private EnumArmorMaterial(String var3, int var4, int[] var5, int var6) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
         this.i = var6;
      }

      public int a(EnumWearable var1) {
         return ItemArmor.k[var1.getRelative()] * this.g;
      }

      public int b(EnumWearable var1) {
         return this.h[var1.getRelative()];
      }

      public int a() {
         return this.i;
      }

      public Item b() {
         return this == LEATHER ?Items.LEATHER :(this == CHAIN ?Items.IRON_INGOT :(this == GOLD ?Items.GOLD_INGOT :(this == IRON ?Items.IRON_INGOT :(this == DIAMOND ?Items.DIAMOND :null))));
      }
   }
}
