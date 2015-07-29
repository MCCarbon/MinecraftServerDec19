package net.minecraft.server;

import net.minecraft.server.EnumChatFormat;

public enum class_abf {

   a(EnumChatFormat.WHITE, "Common"),
   b(EnumChatFormat.YELLOW, "Uncommon"),
   c(EnumChatFormat.AQUA, "Rare"),
   d(EnumChatFormat.LIGHT_PURPLE, "Epic");

   public final EnumChatFormat e;
   public final String f;

   private class_abf(EnumChatFormat var3, String var4) {
      this.e = var3;
      this.f = var4;
   }

}
