package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_abz;
import net.minecraft.server.class_acd;
import net.minecraft.server.class_acf;
import net.minecraft.server.World;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_nc;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_abe extends Item {
   public class_abe() {
      this.d(1);
      this.a(true);
      this.a((CreativeTab)CreativeTab.k);
   }

   public static List h(ItemStack var0) {
      ArrayList var1 = Lists.newArrayList();
      var1.addAll(i(var0).b());
      if(var0.hasTag() && var0.getTag().hasOfType("CustomPotionEffects", 9)) {
         NBTTagList var2 = var0.getTag().getList("CustomPotionEffects", 10);

         for(int var3 = 0; var3 < var2.getSize(); ++var3) {
            NBTTagCompound var4 = var2.getCompound(var3);
            class_pl var5 = class_pl.b(var4);
            if(var5 != null) {
               var1.add(var5);
            }
         }
      }

      return var1;
   }

   public ItemStack a(ItemStack var1, World var2, class_qa var3) {
      class_xa var4 = var3 instanceof class_xa?(class_xa)var3:null;
      if(var4 == null || !var4.bH.instabuild) {
         --var1.count;
      }

      if(!var2.D) {
         List var5 = h(var1);
         Iterator var6 = var5.iterator();

         while(var6.hasNext()) {
            class_pl var7 = (class_pl)var6.next();
            var3.c(new class_pl(var7));
         }
      }

      if(var4 != null) {
         var4.b(class_nc.ad[Item.getId((Item)this)]);
      }

      if(var4 == null || !var4.bH.instabuild) {
         if(var1.count <= 0) {
            return new ItemStack(Items.bD);
         }

         if(var4 != null) {
            var4.bp.a(new ItemStack(Items.bD));
         }
      }

      return var1;
   }

   public int e(ItemStack var1) {
      return 32;
   }

   public class_abz f(ItemStack var1) {
      return class_abz.DRINK;
   }

   public class_or a(ItemStack var1, World var2, class_xa var3, EnumUsedHand var4) {
      var3.c(var4);
      return new class_or(class_oq.a, var1);
   }

   public static int a(Collection var0) {
      int var1 = 3694022;
      if(var0.isEmpty()) {
         return 3694022;
      } else {
         float var2 = 0.0F;
         float var3 = 0.0F;
         float var4 = 0.0F;
         int var5 = 0;
         Iterator var6 = var0.iterator();

         while(true) {
            class_pl var7;
            do {
               if(!var6.hasNext()) {
                  if(var5 == 0) {
                     return 0;
                  }

                  var2 = var2 / (float)var5 * 255.0F;
                  var3 = var3 / (float)var5 * 255.0F;
                  var4 = var4 / (float)var5 * 255.0F;
                  return (int)var2 << 16 | (int)var3 << 8 | (int)var4;
               }

               var7 = (class_pl)var6.next();
            } while(!var7.e());

            int var8 = var7.a().g();

            for(int var9 = 0; var9 <= var7.c(); ++var9) {
               var2 += (float)(var8 >> 16 & 255) / 255.0F;
               var3 += (float)(var8 >> 8 & 255) / 255.0F;
               var4 += (float)(var8 >> 0 & 255) / 255.0F;
               ++var5;
            }
         }
      }
   }

   public String getLocalizedName(ItemStack var1) {
      return LocaleI18n.get(i(var1).a());
   }

   public static class_acd i(ItemStack var0) {
      return !var0.hasTag()?class_acf.a:class_acd.a(var0.getTag().getString("Potion"));
   }

   public static ItemStack a(ItemStack var0, class_acd var1) {
      MinecraftKey var2 = (MinecraftKey)class_acd.a.getKey(var1);
      if(var2 != null) {
         NBTTagCompound var3 = var0.hasTag()?var0.getTag():new NBTTagCompound();
         var3.put("Potion", var2.toString());
         var0.setTag(var3);
      }

      return var0;
   }
}
