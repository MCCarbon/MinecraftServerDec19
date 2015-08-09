package net.minecraft.server;

import com.google.common.collect.Maps;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.IMinecraftServer;
import net.minecraft.server.class_mj;
import net.minecraft.server.class_mk;
import net.minecraft.server.class_mn;

public class class_mo extends class_mn {
   private long h;
   private int i;
   private int j;
   private int k;
   private String l;
   private String m;
   private DatagramSocket n;
   private byte[] o = new byte[1460];
   private DatagramPacket p;
   private Map q;
   private String r;
   private String s;
   private Map t;
   private long u;
   private class_mj v;
   private long w;

   public class_mo(IMinecraftServer var1) {
      super(var1, "Query Listener");
      this.i = var1.a("query.port", 0);
      this.s = var1.E();
      this.j = var1.F();
      this.l = var1.G();
      this.k = var1.J();
      this.m = var1.U();
      this.w = 0L;
      this.r = "0.0.0.0";
      if(!this.s.isEmpty() && !this.r.equals(this.s)) {
         this.r = this.s;
      } else {
         this.s = "0.0.0.0";

         try {
            InetAddress var2 = InetAddress.getLocalHost();
            this.r = var2.getHostAddress();
         } catch (UnknownHostException var3) {
            this.c("Unable to determine local host IP, please set server-ip in \'" + var1.b() + "\' : " + var3.getMessage());
         }
      }

      if(0 == this.i) {
         this.i = this.j;
         this.b("Setting default query port to " + this.i);
         var1.a("query.port", (Object)Integer.valueOf(this.i));
         var1.a("debug", (Object)Boolean.valueOf(false));
         var1.a();
      }

      this.q = Maps.newHashMap();
      this.v = new class_mj(1460);
      this.t = Maps.newHashMap();
      this.u = (new Date()).getTime();
   }

   private void a(byte[] var1, DatagramPacket var2) throws IOException {
      this.n.send(new DatagramPacket(var1, var1.length, var2.getSocketAddress()));
   }

   private boolean a(DatagramPacket var1) throws IOException {
      byte[] var2 = var1.getData();
      int var3 = var1.getLength();
      SocketAddress var4 = var1.getSocketAddress();
      this.a((String)("Packet len " + var3 + " [" + var4 + "]"));
      if(3 <= var3 && -2 == var2[0] && -3 == var2[1]) {
         this.a((String)("Packet \'" + class_mk.a(var2[2]) + "\' [" + var4 + "]"));
         switch(var2[2]) {
         case 0:
            if(!this.c(var1).booleanValue()) {
               this.a((String)("Invalid challenge [" + var4 + "]"));
               return false;
            } else if(15 == var3) {
               this.a(this.b(var1), var1);
               this.a((String)("Rules [" + var4 + "]"));
            } else {
               class_mj var5 = new class_mj(1460);
               var5.a((int)0);
               var5.a(this.a(var1.getSocketAddress()));
               var5.a(this.l);
               var5.a("SMP");
               var5.a(this.m);
               var5.a(Integer.toString(this.d()));
               var5.a(Integer.toString(this.k));
               var5.a((short)this.j);
               var5.a(this.r);
               this.a(var5.a(), var1);
               this.a((String)("Status [" + var4 + "]"));
            }
         default:
            return true;
         case 9:
            this.d(var1);
            this.a((String)("Challenge [" + var4 + "]"));
            return true;
         }
      } else {
         this.a((String)("Invalid packet [" + var4 + "]"));
         return false;
      }
   }

   private byte[] b(DatagramPacket var1) throws IOException {
      long var2 = MinecraftServer.az();
      if(var2 < this.w + 5000L) {
         byte[] var9 = this.v.a();
         byte[] var10 = this.a(var1.getSocketAddress());
         var9[1] = var10[0];
         var9[2] = var10[1];
         var9[3] = var10[2];
         var9[4] = var10[3];
         return var9;
      } else {
         this.w = var2;
         this.v.b();
         this.v.a((int)0);
         this.v.a(this.a(var1.getSocketAddress()));
         this.v.a("splitnum");
         this.v.a((int)128);
         this.v.a((int)0);
         this.v.a("hostname");
         this.v.a(this.l);
         this.v.a("gametype");
         this.v.a("SMP");
         this.v.a("game_id");
         this.v.a("MINECRAFT");
         this.v.a("version");
         this.v.a(this.b.getVersion());
         this.v.a("plugins");
         this.v.a(this.b.getPlugins());
         this.v.a("map");
         this.v.a(this.m);
         this.v.a("numplayers");
         this.v.a("" + this.d());
         this.v.a("maxplayers");
         this.v.a("" + this.k);
         this.v.a("hostport");
         this.v.a("" + this.j);
         this.v.a("hostip");
         this.v.a(this.r);
         this.v.a((int)0);
         this.v.a((int)1);
         this.v.a("player_");
         this.v.a((int)0);
         String[] var4 = this.b.getPlayers();
         String[] var5 = var4;
         int var6 = var4.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            String var8 = var5[var7];
            this.v.a(var8);
         }

         this.v.a((int)0);
         return this.v.a();
      }
   }

   private byte[] a(SocketAddress var1) {
      return ((class_mo.class_a_in_class_mo)this.t.get(var1)).c();
   }

   private Boolean c(DatagramPacket var1) {
      SocketAddress var2 = var1.getSocketAddress();
      if(!this.t.containsKey(var2)) {
         return Boolean.valueOf(false);
      } else {
         byte[] var3 = var1.getData();
         return ((class_mo.class_a_in_class_mo)this.t.get(var2)).a() != class_mk.c(var3, 7, var1.getLength())?Boolean.valueOf(false):Boolean.valueOf(true);
      }
   }

   private void d(DatagramPacket var1) throws IOException {
      class_mo.class_a_in_class_mo var2 = new class_mo.class_a_in_class_mo(var1);
      this.t.put(var1.getSocketAddress(), var2);
      this.a(var2.b(), var1);
   }

   private void f() {
      if(this.a) {
         long var1 = MinecraftServer.az();
         if(var1 >= this.h + 30000L) {
            this.h = var1;
            Iterator var3 = this.t.entrySet().iterator();

            while(var3.hasNext()) {
               Entry var4 = (Entry)var3.next();
               if(((class_mo.class_a_in_class_mo)var4.getValue()).a(var1).booleanValue()) {
                  var3.remove();
               }
            }

         }
      }
   }

   public void run() {
      this.b("Query running on " + this.s + ":" + this.i);
      this.h = MinecraftServer.az();
      this.p = new DatagramPacket(this.o, this.o.length);

      try {
         while(this.a) {
            try {
               this.n.receive(this.p);
               this.f();
               this.a(this.p);
            } catch (SocketTimeoutException var7) {
               this.f();
            } catch (PortUnreachableException var8) {
               ;
            } catch (IOException var9) {
               this.a((Exception)var9);
            }
         }
      } finally {
         this.e();
      }

   }

   public void a() {
      if(!this.a) {
         if(0 < this.i && '\uffff' >= this.i) {
            if(this.g()) {
               super.a();
            }

         } else {
            this.c("Invalid query port " + this.i + " found in \'" + this.b.b() + "\' (queries disabled)");
         }
      }
   }

   private void a(Exception var1) {
      if(this.a) {
         this.c("Unexpected exception, buggy JRE? (" + var1.toString() + ")");
         if(!this.g()) {
            this.d("Failed to recover from buggy JRE, shutting down!");
            this.a = false;
         }

      }
   }

   private boolean g() {
      try {
         this.n = new DatagramSocket(this.i, InetAddress.getByName(this.s));
         this.a((DatagramSocket)this.n);
         this.n.setSoTimeout(500);
         return true;
      } catch (SocketException var2) {
         this.c("Unable to initialise query system on " + this.s + ":" + this.i + " (Socket): " + var2.getMessage());
      } catch (UnknownHostException var3) {
         this.c("Unable to initialise query system on " + this.s + ":" + this.i + " (Unknown Host): " + var3.getMessage());
      } catch (Exception var4) {
         this.c("Unable to initialise query system on " + this.s + ":" + this.i + " (E): " + var4.getMessage());
      }

      return false;
   }

   class class_a_in_class_mo {
      private long b = (new Date()).getTime();
      private int c;
      private byte[] d;
      private byte[] e;
      private String f;

      public class_a_in_class_mo(DatagramPacket var2) {
         byte[] var3 = var2.getData();
         this.d = new byte[4];
         this.d[0] = var3[3];
         this.d[1] = var3[4];
         this.d[2] = var3[5];
         this.d[3] = var3[6];
         this.f = new String(this.d);
         this.c = (new Random()).nextInt(16777216);
         this.e = String.format("\t%s%d\u0000", new Object[]{this.f, Integer.valueOf(this.c)}).getBytes();
      }

      public Boolean a(long var1) {
         return Boolean.valueOf(this.b < var1);
      }

      public int a() {
         return this.c;
      }

      public byte[] b() {
         return this.e;
      }

      public byte[] c() {
         return this.d;
      }
   }
}
