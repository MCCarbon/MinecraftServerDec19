package net.minecraft.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dq;
import net.minecraft.server.class_dw;
import net.minecraft.server.class_e;
import net.minecraft.server.class_eb;

public class class_dx {
   public static class_dn a(InputStream var0) throws IOException {
      DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(var0)));

      class_dn var2;
      try {
         var2 = a((DataInput)var1, (class_dw)class_dw.a);
      } finally {
         var1.close();
      }

      return var2;
   }

   public static void a(class_dn var0, OutputStream var1) throws IOException {
      DataOutputStream var2 = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(var1)));

      try {
         a((class_dn)var0, (DataOutput)var2);
      } finally {
         var2.close();
      }

   }

   public static class_dn a(DataInputStream var0) throws IOException {
      return a((DataInput)var0, (class_dw)class_dw.a);
   }

   public static class_dn a(DataInput var0, class_dw var1) throws IOException {
      class_eb var2 = a(var0, 0, var1);
      if(var2 instanceof class_dn) {
         return (class_dn)var2;
      } else {
         throw new IOException("Root tag must be a named compound tag");
      }
   }

   public static void a(class_dn var0, DataOutput var1) throws IOException {
      a((class_eb)var0, (DataOutput)var1);
   }

   private static void a(class_eb var0, DataOutput var1) throws IOException {
      var1.writeByte(var0.a());
      if(var0.a() != 0) {
         var1.writeUTF("");
         var0.a(var1);
      }
   }

   private static class_eb a(DataInput var0, int var1, class_dw var2) throws IOException {
      byte var3 = var0.readByte();
      if(var3 == 0) {
         return new class_dq();
      } else {
         var0.readUTF();
         class_eb var4 = class_eb.a(var3);

         try {
            var4.a(var0, var1, var2);
            return var4;
         } catch (IOException var8) {
            class_b var6 = class_b.a(var8, "Loading NBT data");
            class_c var7 = var6.a("NBT Tag");
            var7.a((String)"Tag name", (Object)"[UNNAMED TAG]");
            var7.a((String)"Tag type", (Object)Byte.valueOf(var3));
            throw new class_e(var6);
         }
      }
   }
}
