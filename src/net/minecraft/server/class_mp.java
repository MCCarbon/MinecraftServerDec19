package net.minecraft.server;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import net.minecraft.server.class_kk;
import net.minecraft.server.class_mk;
import net.minecraft.server.class_mn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_mp extends class_mn {
   private static final Logger h = LogManager.getLogger();
   private boolean i;
   private Socket j;
   private byte[] k = new byte[1460];
   private String l;

   class_mp(class_kk var1, Socket var2) {
      super(var1, "RCON Client");
      this.j = var2;

      try {
         this.j.setSoTimeout(0);
      } catch (Exception var4) {
         this.a = false;
      }

      this.l = var1.a("rcon.password", "");
      this.b("Rcon connection from: " + var2.getInetAddress());
   }

   public void run() {
      while(true) {
         try {
            if(!this.a) {
               break;
            }

            BufferedInputStream var1 = new BufferedInputStream(this.j.getInputStream());
            int var2 = var1.read(this.k, 0, 1460);
            if(10 > var2) {
               return;
            }

            byte var3 = 0;
            int var4 = class_mk.b(this.k, 0, var2);
            if(var4 == var2 - 4) {
               int var21 = var3 + 4;
               int var5 = class_mk.b(this.k, var21, var2);
               var21 += 4;
               int var6 = class_mk.b(this.k, var21);
               var21 += 4;
               switch(var6) {
               case 2:
                  if(this.i) {
                     String var8 = class_mk.a(this.k, var21, var2);

                     try {
                        this.a(var5, this.b.a_(var8));
                     } catch (Exception var16) {
                        this.a(var5, "Error executing: " + var8 + " (" + var16.getMessage() + ")");
                     }
                     continue;
                  }

                  this.f();
                  continue;
               case 3:
                  String var7 = class_mk.a(this.k, var21, var2);
                  int var10000 = var21 + var7.length();
                  if(!var7.isEmpty() && var7.equals(this.l)) {
                     this.i = true;
                     this.a(var5, 2, "");
                     continue;
                  }

                  this.i = false;
                  this.f();
                  continue;
               default:
                  this.a(var5, String.format("Unknown request %s", new Object[]{Integer.toHexString(var6)}));
                  continue;
               }
            }
         } catch (SocketTimeoutException var17) {
            break;
         } catch (IOException var18) {
            break;
         } catch (Exception var19) {
            h.error((String)"Exception whilst parsing RCON input", (Throwable)var19);
            break;
         } finally {
            this.g();
         }

         return;
      }

   }

   private void a(int var1, int var2, String var3) throws IOException {
      ByteArrayOutputStream var4 = new ByteArrayOutputStream(1248);
      DataOutputStream var5 = new DataOutputStream(var4);
      byte[] var6 = var3.getBytes("UTF-8");
      var5.writeInt(Integer.reverseBytes(var6.length + 10));
      var5.writeInt(Integer.reverseBytes(var1));
      var5.writeInt(Integer.reverseBytes(var2));
      var5.write(var6);
      var5.write(0);
      var5.write(0);
      this.j.getOutputStream().write(var4.toByteArray());
   }

   private void f() throws IOException {
      this.a(-1, 2, "");
   }

   private void a(int var1, String var2) throws IOException {
      int var3 = var2.length();

      do {
         int var4 = 4096 <= var3?4096:var3;
         this.a(var1, 0, var2.substring(0, var4));
         var2 = var2.substring(var4);
         var3 = var2.length();
      } while(0 != var3);

   }

   private void g() {
      if(null != this.j) {
         try {
            this.j.close();
         } catch (IOException var2) {
            this.c("IO: " + var2.getMessage());
         }

         this.j = null;
      }
   }
}
