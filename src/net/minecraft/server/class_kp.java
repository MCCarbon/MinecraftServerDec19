package net.minecraft.server;

import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Proxy;
import java.security.KeyPair;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.World;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_aes;
import net.minecraft.server.class_b;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_ke;
import net.minecraft.server.class_kg;
import net.minecraft.server.class_kk;
import net.minecraft.server.class_km;
import net.minecraft.server.class_ko;
import net.minecraft.server.class_kq;
import net.minecraft.server.class_ks;
import net.minecraft.server.class_ly;
import net.minecraft.server.class_lz;
import net.minecraft.server.class_m;
import net.minecraft.server.class_ml;
import net.minecraft.server.class_mo;
import net.minecraft.server.class_mq;
import net.minecraft.server.class_ni;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_om;
import net.minecraft.server.class_ox;
import net.minecraft.server.class_xa;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_kp extends MinecraftServer implements class_kk {
   private static final Logger k = LogManager.getLogger();
   private final List l = Collections.synchronizedList(Lists.newArrayList());
   private class_mo m;
   private class_mq n;
   private class_km o;
   private class_kg p;
   private boolean q;
   private class_aeq.class_a_in_class_aeq r;
   private boolean s;

   public class_kp(File var1) {
      super(var1, Proxy.NO_PROXY, a);
      Thread var10001 = new Thread("Server Infinisleeper") {
         {
            this.setDaemon(true);
            this.start();
         }

         public void run() {
            while(true) {
               try {
                  Thread.sleep(2147483647L);
               } catch (InterruptedException var2) {
                  ;
               }
            }
         }
      };
   }

   protected boolean i() throws IOException {
      Thread var1 = new Thread("Server console handler") {
         public void run() {
            BufferedReader var1 = new BufferedReader(new InputStreamReader(System.in));

            String var2;
            try {
               while(!class_kp.this.ao() && class_kp.this.v() && (var2 = var1.readLine()) != null) {
                  class_kp.this.a(var2, (class_m)class_kp.this);
               }
            } catch (IOException var4) {
               class_kp.k.error((String)"Exception handling console input", (Throwable)var4);
            }

         }
      };
      var1.setDaemon(true);
      var1.start();
      k.info("Starting minecraft server version 15w31a");
      if(Runtime.getRuntime().maxMemory() / 1024L / 1024L < 512L) {
         k.warn("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
      }

      k.info("Loading properties");
      this.o = new class_km(new File("server.properties"));
      this.p = new class_kg(new File("eula.txt"));
      if(!this.p.a()) {
         k.info("You need to agree to the EULA in order to run the server. Go to eula.txt for more info.");
         this.p.b();
         return false;
      } else {
         if(this.T()) {
            this.c("127.0.0.1");
         } else {
            this.d(this.o.a("online-mode", true));
            this.c(this.o.a("server-ip", ""));
         }

         this.e(this.o.a("spawn-animals", true));
         this.f(this.o.a("spawn-npcs", true));
         this.g(this.o.a("pvp", true));
         this.h(this.o.a("allow-flight", false));
         this.a_(this.o.a("resource-pack", ""), this.o.a("resource-pack-hash", ""));
         this.l(this.o.a("motd", "A Minecraft Server"));
         this.i(this.o.a("force-gamemode", false));
         this.d(this.o.a("player-idle-timeout", 0));
         if(this.o.a("difficulty", 1) < 0) {
            this.o.a("difficulty", (Object)Integer.valueOf(0));
         } else if(this.o.a("difficulty", 1) > 3) {
            this.o.a("difficulty", (Object)Integer.valueOf(3));
         }

         this.q = this.o.a("generate-structures", true);
         int var2 = this.o.a("gamemode", class_aeq.class_a_in_class_aeq.b.a());
         this.r = class_aeq.a(var2);
         k.info("Default game type: " + this.r);
         InetAddress var3 = null;
         if(!this.u().isEmpty()) {
            var3 = InetAddress.getByName(this.u());
         }

         if(this.R() < 0) {
            this.b(this.o.a("server-port", 25565));
         }

         k.info("Generating keypair");
         this.a((KeyPair)class_ni.b());
         k.info("Starting Minecraft server on " + (this.u().isEmpty()?"*":this.u()) + ":" + this.R());

         try {
            this.aq().a(var3, this.R());
         } catch (IOException var17) {
            k.warn("**** FAILED TO BIND TO PORT!");
            k.warn("The exception was: {}", new Object[]{var17.toString()});
            k.warn("Perhaps a server is already running on that port?");
            return false;
         }

         if(!this.af()) {
            k.warn("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
            k.warn("The server will make no attempt to authenticate usernames. Beware.");
            k.warn("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
            k.warn("To change this, set \"online-mode\" to \"true\" in the server.properties file.");
         }

         if(this.aR()) {
            this.aF().c();
         }

         if(!class_ly.a(this.o)) {
            return false;
         } else {
            this.a((class_lz)(new class_ko(this)));
            long var4 = System.nanoTime();
            if(this.U() == null) {
               this.j(this.o.a("level-name", "world"));
            }

            String var6 = this.o.a("level-seed", "");
            String var7 = this.o.a("level-type", "DEFAULT");
            String var8 = this.o.a("generator-settings", "");
            long var9 = (new Random()).nextLong();
            if(!var6.isEmpty()) {
               try {
                  long var11 = Long.parseLong(var6);
                  if(var11 != 0L) {
                     var9 = var11;
                  }
               } catch (NumberFormatException var16) {
                  var9 = (long)var6.hashCode();
               }
            }

            class_aes var18 = class_aes.a(var7);
            if(var18 == null) {
               var18 = class_aes.b;
            }

            this.aB();
            this.al();
            this.p();
            this.ad();
            this.aK();
            this.c(this.o.a("max-build-height", 256));
            this.c((this.an() + 8) / 16 * 16);
            this.c(class_nu.a(this.an(), 64, 256));
            this.o.a("max-build-height", (Object)Integer.valueOf(this.an()));
            k.info("Preparing level \"" + this.U() + "\"");
            this.a(this.U(), this.U(), var9, var18, var8);
            long var12 = System.nanoTime() - var4;
            String var14 = String.format("%.3fs", new Object[]{Double.valueOf((double)var12 / 1.0E9D)});
            k.info("Done (" + var14 + ")! For help, type \"help\" or \"?\"");
            if(this.o.a("enable-query", false)) {
               k.info("Starting GS4 status listener");
               this.m = new class_mo(this);
               this.m.a();
            }

            if(this.o.a("enable-rcon", false)) {
               k.info("Starting remote control listener");
               this.n = new class_mq(this);
               this.n.a();
            }

            if(this.aS() > 0L) {
               Thread var15 = new Thread(new class_kq(this));
               var15.setName("Server Watchdog");
               var15.setDaemon(true);
               var15.start();
            }

            return true;
         }
      }
   }

   public void a(class_aeq.class_a_in_class_aeq var1) {
      super.a(var1);
      this.r = var1;
   }

   public boolean l() {
      return this.q;
   }

   public class_aeq.class_a_in_class_aeq m() {
      return this.r;
   }

   public class_om n() {
      return class_om.a(this.o.a("difficulty", class_om.c.a()));
   }

   public boolean o() {
      return this.o.a("hardcore", false);
   }

   protected void a(class_b var1) {
   }

   public class_b b(class_b var1) {
      var1 = super.b(var1);
      var1.g().a("Is Modded", new Callable() {
         public String a() throws Exception {
            String var1 = class_kp.this.getServerModName();
            return !var1.equals("vanilla")?"Definitely; Server brand changed to \'" + var1 + "\'":"Unknown (can\'t tell)";
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.g().a("Type", new Callable() {
         public String a() throws Exception {
            return "Dedicated Server (map_server.txt)";
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      return var1;
   }

   protected void z() {
      System.exit(0);
   }

   public void B() {
      super.B();
      this.aO();
   }

   public boolean C() {
      return this.o.a("allow-nether", true);
   }

   public boolean W() {
      return this.o.a("spawn-monsters", true);
   }

   public void a(class_ox var1) {
      var1.a("whitelist_enabled", Boolean.valueOf(this.aP().r()));
      var1.a("whitelist_count", Integer.valueOf(this.aP().l().length));
      super.a(var1);
   }

   public boolean ad() {
      return this.o.a("snooper-enabled", true);
   }

   public void a(String var1, class_m var2) {
      this.l.add(new class_ke(var1, var2));
   }

   public void aO() {
      while(!this.l.isEmpty()) {
         class_ke var1 = (class_ke)this.l.remove(0);
         this.P().a(var1.b, var1.a);
      }

   }

   public boolean ae() {
      return true;
   }

   public boolean ai() {
      return this.o.a("use-native-transport", true);
   }

   public class_ko aP() {
      return (class_ko)super.ap();
   }

   public int a(String var1, int var2) {
      return this.o.a(var1, var2);
   }

   public String a(String var1, String var2) {
      return this.o.a(var1, var2);
   }

   public boolean a(String var1, boolean var2) {
      return this.o.a(var1, var2);
   }

   public void a(String var1, Object var2) {
      this.o.a(var1, var2);
   }

   public void a() {
      this.o.b();
   }

   public String b() {
      File var1 = this.o.c();
      return var1 != null?var1.getAbsolutePath():"No settings file";
   }

   public void aQ() {
      class_ks.a(this);
      this.s = true;
   }

   public boolean as() {
      return this.s;
   }

   public String a(class_aeq.class_a_in_class_aeq var1, boolean var2) {
      return "";
   }

   public boolean al() {
      return this.o.a("enable-command-block", false);
   }

   public int aw() {
      return this.o.a("spawn-protection", super.aw());
   }

   public boolean a(World var1, class_cj var2, class_xa var3) {
      if(var1.t.p().a() != 0) {
         return false;
      } else if(this.aP().m().d()) {
         return false;
      } else if(this.aP().h(var3.cf())) {
         return false;
      } else if(this.aw() <= 0) {
         return false;
      } else {
         class_cj var4 = var1.N();
         int var5 = class_nu.a(var2.n() - var4.n());
         int var6 = class_nu.a(var2.p() - var4.p());
         int var7 = Math.max(var5, var6);
         return var7 <= this.aw();
      }
   }

   public int p() {
      return this.o.a("op-permission-level", 4);
   }

   public void d(int var1) {
      super.d(var1);
      this.o.a("player-idle-timeout", (Object)Integer.valueOf(var1));
      this.a();
   }

   public boolean q() {
      return this.o.a("broadcast-rcon-to-ops", true);
   }

   public boolean r() {
      return this.o.a("broadcast-console-to-ops", true);
   }

   public boolean aB() {
      return this.o.a("announce-player-achievements", true);
   }

   public int aI() {
      int var1 = this.o.a("max-world-size", super.aI());
      if(var1 < 1) {
         var1 = 1;
      } else if(var1 > super.aI()) {
         var1 = super.aI();
      }

      return var1;
   }

   public int aK() {
      return this.o.a("network-compression-threshold", super.aK());
   }

   protected boolean aR() {
      boolean var2 = false;

      int var1;
      for(var1 = 0; !var2 && var1 <= 2; ++var1) {
         if(var1 > 0) {
            k.warn("Encountered a problem while converting the user banlist, retrying in a few seconds");
            this.aU();
         }

         var2 = class_ly.a((MinecraftServer)this);
      }

      boolean var3 = false;

      for(var1 = 0; !var3 && var1 <= 2; ++var1) {
         if(var1 > 0) {
            k.warn("Encountered a problem while converting the ip banlist, retrying in a few seconds");
            this.aU();
         }

         var3 = class_ly.b((MinecraftServer)this);
      }

      boolean var4 = false;

      for(var1 = 0; !var4 && var1 <= 2; ++var1) {
         if(var1 > 0) {
            k.warn("Encountered a problem while converting the op list, retrying in a few seconds");
            this.aU();
         }

         var4 = class_ly.c((MinecraftServer)this);
      }

      boolean var5 = false;

      for(var1 = 0; !var5 && var1 <= 2; ++var1) {
         if(var1 > 0) {
            k.warn("Encountered a problem while converting the whitelist, retrying in a few seconds");
            this.aU();
         }

         var5 = class_ly.d((MinecraftServer)this);
      }

      boolean var6 = false;

      for(var1 = 0; !var6 && var1 <= 2; ++var1) {
         if(var1 > 0) {
            k.warn("Encountered a problem while converting the player save files, retrying in a few seconds");
            this.aU();
         }

         var6 = class_ly.a(this, this.o);
      }

      return var2 || var3 || var4 || var5 || var6;
   }

   private void aU() {
      try {
         Thread.sleep(5000L);
      } catch (InterruptedException var2) {
         ;
      }
   }

   public long aS() {
      return this.o.a("max-tick-time", TimeUnit.MINUTES.toMillis(1L));
   }

   public String d_() {
      return "";
   }

   public String a_(String var1) {
      class_ml.h().i();
      this.b.a(class_ml.h(), var1);
      return class_ml.h().j();
   }

   // $FF: synthetic method
   public class_lz ap() {
      return this.aP();
   }
}
