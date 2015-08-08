package net.minecraft.server;

public class ItemWrittenBook extends Item {
   public ItemWrittenBook() {
      this.d(1);
   }

   public static boolean b(NBTTagCompound var0) {
      if(!ItemBookAndQuill.b(var0)) {
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

   public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      if(!var2.isClientSide) {
         this.a(var1, var3);
      }

      var3.a(var1);
      var3.b(StatisticList.ad[Item.getId((Item)this)]);
      return new UseResultWithValue(UseResult.SUCCESS, var1);
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
                  ((EntityPlayer)var2).playerConnection.sendPacket((Packet)(new PacketPlayOutSetSlot(0, var10.e, var1)));
               }

            }
         }
      }
   }
}
