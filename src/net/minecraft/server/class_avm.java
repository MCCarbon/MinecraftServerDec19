package net.minecraft.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import net.minecraft.server.class_avl;
import net.minecraft.server.class_avn;
import net.minecraft.server.class_avo;
import net.minecraft.server.class_avq;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTCompressedStreamTools;
import net.minecraft.server.class_nw;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_avm implements class_avq {
   private static final Logger b = LogManager.getLogger();
   protected final File a;

   public class_avm(File var1) {
      if(!var1.exists()) {
         var1.mkdirs();
      }

      this.a = var1;
   }

   public void d() {
   }

   public class_avn c(String var1) {
      File var2 = new File(this.a, var1);
      if(!var2.exists()) {
         return null;
      } else {
         File var3 = new File(var2, "level.dat");
         NBTTagCompound var4;
         NBTTagCompound var5;
         if(var3.exists()) {
            try {
               var4 = NBTCompressedStreamTools.fromRawInputStream((InputStream)(new FileInputStream(var3)));
               var5 = var4.getCompound("Data");
               return new class_avn(var5);
            } catch (Exception var7) {
               b.error((String)("Exception reading " + var3), (Throwable)var7);
            }
         }

         var3 = new File(var2, "level.dat_old");
         if(var3.exists()) {
            try {
               var4 = NBTCompressedStreamTools.fromRawInputStream((InputStream)(new FileInputStream(var3)));
               var5 = var4.getCompound("Data");
               return new class_avn(var5);
            } catch (Exception var6) {
               b.error((String)("Exception reading " + var3), (Throwable)var6);
            }
         }

         return null;
      }
   }

   public boolean e(String var1) {
      File var2 = new File(this.a, var1);
      if(!var2.exists()) {
         return true;
      } else {
         b.info("Deleting level " + var1);

         for(int var3 = 1; var3 <= 5; ++var3) {
            b.info("Attempt " + var3 + "...");
            if(a(var2.listFiles())) {
               break;
            }

            b.warn("Unsuccessful in deleting contents.");
            if(var3 < 5) {
               try {
                  Thread.sleep(500L);
               } catch (InterruptedException var5) {
                  ;
               }
            }
         }

         return var2.delete();
      }
   }

   protected static boolean a(File[] var0) {
      for(int var1 = 0; var1 < var0.length; ++var1) {
         File var2 = var0[var1];
         b.debug("Deleting " + var2);
         if(var2.isDirectory() && !a(var2.listFiles())) {
            b.warn("Couldn\'STONE_SHOVEL delete directory " + var2);
            return false;
         }

         if(!var2.delete()) {
            b.warn("Couldn\'STONE_SHOVEL delete file " + var2);
            return false;
         }
      }

      return true;
   }

   public class_avo a(String var1, boolean var2) {
      return new class_avl(this.a, var1, var2);
   }

   public boolean b(String var1) {
      return false;
   }

   public boolean a(String var1, class_nw var2) {
      return false;
   }
}
