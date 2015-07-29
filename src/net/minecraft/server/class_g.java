package net.minecraft.server;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.apache.logging.log4j.Logger;

public class class_g {
   public static Object a(FutureTask var0, Logger var1) {
      try {
         var0.run();
         return var0.get();
      } catch (ExecutionException var3) {
         var1.fatal((String)"Error executing task", (Throwable)var3);
      } catch (InterruptedException var4) {
         var1.fatal((String)"Error executing task", (Throwable)var4);
      }

      return null;
   }

   public static Object a(List var0) {
      return var0.get(var0.size() - 1);
   }
}
