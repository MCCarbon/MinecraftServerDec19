package net.minecraft.server;

import net.minecraft.server.class_eu;
import net.minecraft.server.class_fb;

public enum class_pz {
   a(new class_fb("options.mainHand.left", new Object[0])),
   b(new class_fb("options.mainHand.right", new Object[0]));

   private final class_eu c;

   private class_pz(class_eu var3) {
      this.c = var3;
   }

   public String toString() {
      return this.c.c();
   }
}
