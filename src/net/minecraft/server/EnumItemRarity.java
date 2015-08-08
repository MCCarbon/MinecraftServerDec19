package net.minecraft.server;

import net.minecraft.server.EnumChatFormat;

public enum EnumItemRarity {

   COMMON(EnumChatFormat.WHITE, "Common"),
   UNCOMMON(EnumChatFormat.YELLOW, "Uncommon"),
   RARE(EnumChatFormat.AQUA, "Rare"),
   EPIC(EnumChatFormat.LIGHT_PURPLE, "Epic");

   public final EnumChatFormat color;
   public final String name;

   private EnumItemRarity(EnumChatFormat var3, String var4) {
      this.color = var3;
      this.name = var4;
   }

}
