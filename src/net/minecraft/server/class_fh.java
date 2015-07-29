package net.minecraft.server;

import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_kj;
import net.minecraft.server.class_of;

public class class_fh {
   public static void a(final class_ff var0, final class_ep var1, class_of var2) throws class_kj {
      if(!var2.aJ()) {
         var2.a(new Runnable() {
            public void run() {
               var0.a(var1);
            }
         });
         throw class_kj.a;
      }
   }
}
