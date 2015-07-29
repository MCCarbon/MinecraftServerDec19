package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_aes;
import net.minecraft.server.class_avn;
import net.minecraft.server.class_avo;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_nv;

public class class_ky extends class_lg {
   private static final long I = (long)"North Carolina".hashCode();
   public static final class_aeq a;

   public class_ky(MinecraftServer var1, class_avo var2, class_avn var3, int var4, class_nv var5) {
      super(var1, var2, var3, var4, var5);
      this.x.a(a);
   }

   static {
      a = (new class_aeq(I, class_aeq.class_a_in_class_aeq.b, true, false, class_aes.b)).a();
   }
}
