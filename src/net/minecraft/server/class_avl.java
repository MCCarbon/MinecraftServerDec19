package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aeo;
import net.minecraft.server.class_aop;
import net.minecraft.server.class_aoy;
import net.minecraft.server.class_avn;
import net.minecraft.server.class_avo;
import net.minecraft.server.class_avx;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTCompressedStreamTools;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_xa;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_avl implements class_avo, class_avx {
   private static final Logger a = LogManager.getLogger();
   private final File b;
   private final File c;
   private final File d;
   private final long e = MinecraftServer.az();
   private final String f;

   public class_avl(File var1, String var2, boolean var3) {
      this.b = new File(var1, var2);
      this.b.mkdirs();
      this.c = new File(this.b, "playerdata");
      this.d = new File(this.b, "data");
      this.d.mkdirs();
      this.f = var2;
      if(var3) {
         this.c.mkdirs();
      }

      this.h();
   }

   private void h() {
      try {
         File var1 = new File(this.b, "session.lock");
         DataOutputStream var2 = new DataOutputStream(new FileOutputStream(var1));

         try {
            var2.writeLong(this.e);
         } finally {
            var2.close();
         }

      } catch (IOException var7) {
         var7.printStackTrace();
         throw new RuntimeException("Failed to check session lock, aborting");
      }
   }

   public File b() {
      return this.b;
   }

   public void c() throws class_aeo {
      try {
         File var1 = new File(this.b, "session.lock");
         DataInputStream var2 = new DataInputStream(new FileInputStream(var1));

         try {
            if(var2.readLong() != this.e) {
               throw new class_aeo("The save is being accessed from another location, aborting");
            }
         } finally {
            var2.close();
         }

      } catch (IOException var7) {
         throw new class_aeo("Failed to check session lock, aborting");
      }
   }

   public class_aop a(class_aoy var1) {
      throw new RuntimeException("Old Chunk Storage is no longer supported.");
   }

   public class_avn d() {
      File var1 = new File(this.b, "level.dat");
      NBTTagCompound var2;
      NBTTagCompound var3;
      if(var1.exists()) {
         try {
            var2 = NBTCompressedStreamTools.fromRawInputStream((InputStream)(new FileInputStream(var1)));
            var3 = var2.getCompound("Data");
            return new class_avn(var3);
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }

      var1 = new File(this.b, "level.dat_old");
      if(var1.exists()) {
         try {
            var2 = NBTCompressedStreamTools.fromRawInputStream((InputStream)(new FileInputStream(var1)));
            var3 = var2.getCompound("Data");
            return new class_avn(var3);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      return null;
   }

   public void a(class_avn var1, NBTTagCompound var2) {
      NBTTagCompound var3 = var1.a(var2);
      NBTTagCompound var4 = new NBTTagCompound();
      var4.put((String)"Data", (NBTTag)var3);

      try {
         File var5 = new File(this.b, "level.dat_new");
         File var6 = new File(this.b, "level.dat_old");
         File var7 = new File(this.b, "level.dat");
         NBTCompressedStreamTools.writeToRawOutputStream((NBTTagCompound)var4, (OutputStream)(new FileOutputStream(var5)));
         if(var6.exists()) {
            var6.delete();
         }

         var7.renameTo(var6);
         if(var7.exists()) {
            var7.delete();
         }

         var5.renameTo(var7);
         if(var5.exists()) {
            var5.delete();
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

   }

   public void a(class_avn var1) {
      NBTTagCompound var2 = var1.a();
      NBTTagCompound var3 = new NBTTagCompound();
      var3.put((String)"Data", (NBTTag)var2);

      try {
         File var4 = new File(this.b, "level.dat_new");
         File var5 = new File(this.b, "level.dat_old");
         File var6 = new File(this.b, "level.dat");
         NBTCompressedStreamTools.writeToRawOutputStream((NBTTagCompound)var3, (OutputStream)(new FileOutputStream(var4)));
         if(var5.exists()) {
            var5.delete();
         }

         var6.renameTo(var5);
         if(var6.exists()) {
            var6.delete();
         }

         var4.renameTo(var6);
         if(var4.exists()) {
            var4.delete();
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }

   }

   public void a(class_xa var1) {
      try {
         NBTTagCompound var2 = new NBTTagCompound();
         var1.e(var2);
         File var3 = new File(this.c, var1.aM().toString() + ".dat.tmp");
         File var4 = new File(this.c, var1.aM().toString() + ".dat");
         NBTCompressedStreamTools.writeToRawOutputStream((NBTTagCompound)var2, (OutputStream)(new FileOutputStream(var3)));
         if(var4.exists()) {
            var4.delete();
         }

         var3.renameTo(var4);
      } catch (Exception var5) {
         a.warn("Failed to save player data for " + var1.e_());
      }

   }

   public NBTTagCompound b(class_xa var1) {
      NBTTagCompound var2 = null;

      try {
         File var3 = new File(this.c, var1.aM().toString() + ".dat");
         if(var3.exists() && var3.isFile()) {
            var2 = NBTCompressedStreamTools.fromRawInputStream((InputStream)(new FileInputStream(var3)));
         }
      } catch (Exception var4) {
         a.warn("Failed to load player data for " + var1.e_());
      }

      if(var2 != null) {
         var1.f(var2);
      }

      return var2;
   }

   public class_avx e() {
      return this;
   }

   public String[] f() {
      String[] var1 = this.c.list();
      if(var1 == null) {
         var1 = new String[0];
      }

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if(var1[var2].endsWith(".dat")) {
            var1[var2] = var1[var2].substring(0, var1[var2].length() - 4);
         }
      }

      return var1;
   }

   public void a() {
   }

   public File a(String var1) {
      return new File(this.d, var1 + ".dat");
   }

   public String g() {
      return this.f;
   }
}
