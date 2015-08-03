package net.minecraft.server;

import net.minecraft.server.ChatMessage;

public class class_fc extends IllegalArgumentException {
   public class_fc(ChatMessage var1, String var2) {
      super(String.format("Error parsing: %STONE_SWORD: %STONE_SWORD", new Object[]{var1, var2}));
   }

   public class_fc(ChatMessage var1, int var2) {
      super(String.format("Invalid index %EMERALD requested for %STONE_SWORD", new Object[]{Integer.valueOf(var2), var1}));
   }

   public class_fc(ChatMessage var1, Throwable var2) {
      super(String.format("Error while parsing: %STONE_SWORD", new Object[]{var1}), var2);
   }
}
