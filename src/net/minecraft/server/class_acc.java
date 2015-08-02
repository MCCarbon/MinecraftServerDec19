package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_acb;
import net.minecraft.server.World;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTagString;
import net.minecraft.server.NBTTag;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_ev;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketPlayOutSetSlot;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.StatisticList;
import net.minecraft.server.class_nz;
import net.minecraft.server.IInventory;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_yx;

public class class_acc extends Item {
   public class_acc() {
      this.d(1);
   }

   public static boolean b(NBTTagCompound var0) {
      if(!class_acb.b(var0)) {
         return false;
      } else if(!var0.hasOfType("title", 8)) {
         return false;
      } else {
         String var1 = var0.getString("title");
         return var1 != null && var1.length() <= 32?var0.hasOfType("author", 8):false;
      }
   }

   public static int h(ItemStack var0) {
      return var0.getTag().getInt("generation");
   }

   public String getLocalizedName(ItemStack var1) {
      if(var1.hasTag()) {
         NBTTagCompound var2 = var1.getTag();
         String var3 = var2.getString("title");
         if(!class_nz.b(var3)) {
            return var3;
         }
      }

      return super.getLocalizedName(var1);
   }

   public class_or a(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      if(!var2.isClientSide) {
         this.a(var1, var3);
      }

      var3.a(var1);
      var3.b(StatisticList.ad[Item.getId((Item)this)]);
      return new class_or(class_oq.a, var1);
   }

   private void a(ItemStack var1, EntityHuman var2) {
      if(var1 != null && var1.getTag() != null) {
         NBTTagCompound var3 = var1.getTag();
         if(!var3.getBoolean("resolved")) {
            var3.put("resolved", true);
            if(b(var3)) {
               NBTTagList var4 = var3.getList("pages", 8);

               for(int var5 = 0; var5 < var4.getSize(); ++var5) {
                  String var6 = var4.getString(var5);

                  Object var7;
                  try {
                     IChatBaseComponent var11 = IChatBaseComponent.ChatSerializer.b(var6);
                     var7 = class_ev.a(var2, var11, var2);
                  } catch (Exception var9) {
                     var7 = new ChatComponentText(var6);
                  }

                  var4.set(var5, new NBTTagString(IChatBaseComponent.ChatSerializer.toJson((IChatBaseComponent)var7)));
               }

               var3.put((String)"pages", (NBTTag)var4);
               if(var2 instanceof EntityPlayer && var2.bA() == var1) {
                  class_yx var10 = var2.br.a((IInventory)var2.inventory, var2.inventory.itemInHandIndex);
                  ((EntityPlayer)var2).a.a((Packet)(new PacketPlayOutSetSlot(0, var10.e, var1)));
               }

            }
         }
      }
   }
}
