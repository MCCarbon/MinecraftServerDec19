package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.io.IOException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_kp;
import net.minecraft.server.PlayerList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_ko extends PlayerList {
   private static final Logger f = LogManager.getLogger();

   public class_ko(class_kp var1) {
      super(var1);
      this.a(var1.a("view-distance", 10));
      this.maxPlayers = var1.a("max-players", 20);
      this.setHasWhitelist(var1.a("white-list", false));
      if(!var1.isLocal()) {
         this.h().a(true);
         this.i().a(true);
      }

      this.z();
      this.x();
      this.y();
      this.w();
      this.A();
      this.C();
      this.B();
      if(!this.k().c().exists()) {
         this.D();
      }

   }

   public void setHasWhitelist(boolean var1) {
      super.setHasWhitelist(var1);
      this.b().a("white-list", (Object)Boolean.valueOf(var1));
      this.b().a();
   }

   public void a(GameProfile var1) {
      super.a(var1);
      this.B();
   }

   public void b(GameProfile var1) {
      super.b(var1);
      this.B();
   }

   public void c(GameProfile var1) {
      super.c(var1);
      this.D();
   }

   public void d(GameProfile var1) {
      super.d(var1);
      this.D();
   }

   public void a() {
      this.C();
   }

   private void w() {
      try {
         this.i().f();
      } catch (IOException var2) {
         f.warn((String)"Failed to save ip banlist: ", (Throwable)var2);
      }

   }

   private void x() {
      try {
         this.h().f();
      } catch (IOException var2) {
         f.warn((String)"Failed to save user banlist: ", (Throwable)var2);
      }

   }

   private void y() {
      try {
         this.i().g();
      } catch (IOException var2) {
         f.warn((String)"Failed to load ip banlist: ", (Throwable)var2);
      }

   }

   private void z() {
      try {
         this.h().g();
      } catch (IOException var2) {
         f.warn((String)"Failed to load user banlist: ", (Throwable)var2);
      }

   }

   private void A() {
      try {
         this.m().g();
      } catch (Exception var2) {
         f.warn((String)"Failed to load operators list: ", (Throwable)var2);
      }

   }

   private void B() {
      try {
         this.m().f();
      } catch (Exception var2) {
         f.warn((String)"Failed to save operators list: ", (Throwable)var2);
      }

   }

   private void C() {
      try {
         this.k().g();
      } catch (Exception var2) {
         f.warn((String)"Failed to load white-list: ", (Throwable)var2);
      }

   }

   private void D() {
      try {
         this.k().f();
      } catch (Exception var2) {
         f.warn((String)"Failed to save white-list: ", (Throwable)var2);
      }

   }

   public boolean e(GameProfile var1) {
      return !this.hasWhitelist() || this.h(var1) || this.k().a(var1);
   }

   public class_kp b() {
      return (class_kp)super.getMinecraftServer();
   }

   public boolean f(GameProfile var1) {
      return this.m().b(var1);
   }

   // $FF: synthetic method
   public MinecraftServer getMinecraftServer() {
      return this.b();
   }
}
