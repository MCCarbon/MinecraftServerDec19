package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import net.minecraft.server.class_awc;

public class class_awb implements Runnable {
   private static final class_awb a = new class_awb();
   private List b = Collections.synchronizedList(Lists.newArrayList());
   private volatile long c;
   private volatile long d;
   private volatile boolean e;

   private class_awb() {
      Thread var1 = new Thread(this, "File IO Thread");
      var1.setPriority(1);
      var1.start();
   }

   public static class_awb a() {
      return a;
   }

   public void run() {
      while(true) {
         this.c();
      }
   }

   private void c() {
      for(int var1 = 0; var1 < this.b.size(); ++var1) {
         class_awc var2 = (class_awc)this.b.get(var1);
         boolean var3 = var2.c();
         if(!var3) {
            this.b.remove(var1--);
            ++this.d;
         }

         try {
            Thread.sleep(this.e?0L:10L);
         } catch (InterruptedException var6) {
            var6.printStackTrace();
         }
      }

      if(this.b.isEmpty()) {
         try {
            Thread.sleep(25L);
         } catch (InterruptedException var5) {
            var5.printStackTrace();
         }
      }

   }

   public void a(class_awc var1) {
      if(!this.b.contains(var1)) {
         ++this.c;
         this.b.add(var1);
      }
   }

   public void b() throws InterruptedException {
      this.e = true;

      while(this.c != this.d) {
         Thread.sleep(10L);
      }

      this.e = false;
   }
}
