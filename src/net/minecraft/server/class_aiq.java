package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;

public class class_aiq extends Block {
   private boolean a;

   protected class_aiq(class_atk var1, boolean var2) {
      this(var1, var2, var1.r());
   }

   protected class_aiq(class_atk var1, boolean var2, class_atl var3) {
      super(var1, var3);
      this.a = var2;
   }

   public boolean c() {
      return false;
   }
}
