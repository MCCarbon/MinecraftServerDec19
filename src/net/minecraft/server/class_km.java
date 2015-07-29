package net.minecraft.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_km {
   private static final Logger a = LogManager.getLogger();
   private final Properties b = new Properties();
   private final File c;

   public class_km(File var1) {
      this.c = var1;
      if(var1.exists()) {
         FileInputStream var2 = null;

         try {
            var2 = new FileInputStream(var1);
            this.b.load(var2);
         } catch (Exception var12) {
            a.warn((String)("Failed to load " + var1), (Throwable)var12);
            this.a();
         } finally {
            if(var2 != null) {
               try {
                  var2.close();
               } catch (IOException var11) {
                  ;
               }
            }

         }
      } else {
         a.warn(var1 + " does not exist");
         this.a();
      }

   }

   public void a() {
      a.info("Generating new properties file");
      this.b();
   }

   public void b() {
      FileOutputStream var1 = null;

      try {
         var1 = new FileOutputStream(this.c);
         this.b.store(var1, "Minecraft server properties");
      } catch (Exception var11) {
         a.warn((String)("Failed to save " + this.c), (Throwable)var11);
         this.a();
      } finally {
         if(var1 != null) {
            try {
               var1.close();
            } catch (IOException var10) {
               ;
            }
         }

      }

   }

   public File c() {
      return this.c;
   }

   public String a(String var1, String var2) {
      if(!this.b.containsKey(var1)) {
         this.b.setProperty(var1, var2);
         this.b();
         this.b();
      }

      return this.b.getProperty(var1, var2);
   }

   public int a(String var1, int var2) {
      try {
         return Integer.parseInt(this.a(var1, "" + var2));
      } catch (Exception var4) {
         this.b.setProperty(var1, "" + var2);
         this.b();
         return var2;
      }
   }

   public long a(String var1, long var2) {
      try {
         return Long.parseLong(this.a(var1, "" + var2));
      } catch (Exception var5) {
         this.b.setProperty(var1, "" + var2);
         this.b();
         return var2;
      }
   }

   public boolean a(String var1, boolean var2) {
      try {
         return Boolean.parseBoolean(this.a(var1, "" + var2));
      } catch (Exception var4) {
         this.b.setProperty(var1, "" + var2);
         this.b();
         return var2;
      }
   }

   public void a(String var1, Object var2) {
      this.b.setProperty(var1, "" + var2);
   }
}
