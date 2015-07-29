package net.minecraft.server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.World;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_e;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_l;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;
import net.minecraft.server.class_xa;

public abstract class class_aed implements class_m {
   private static final SimpleDateFormat a = new SimpleDateFormat("HH:mm:ss");
   private int b;
   private boolean c = true;
   private class_eu d = null;
   private String e = "";
   private String f = "@";
   private final class_n g = new class_n();

   public int j() {
      return this.b;
   }

   public class_eu k() {
      return this.d;
   }

   public void a(class_dn var1) {
      var1.a("Command", this.e);
      var1.a("SuccessCount", this.b);
      var1.a("CustomName", this.f);
      var1.a("TrackOutput", this.c);
      if(this.d != null && this.c) {
         var1.a("LastOutput", class_eu.class_a_in_class_eu.a(this.d));
      }

      this.g.b(var1);
   }

   public void b(class_dn var1) {
      this.e = var1.k("Command");
      this.b = var1.g("SuccessCount");
      if(var1.b("CustomName", 8)) {
         this.f = var1.k("CustomName");
      }

      if(var1.b("TrackOutput", 1)) {
         this.c = var1.o("TrackOutput");
      }

      if(var1.b("LastOutput", 8) && this.c) {
         this.d = class_eu.class_a_in_class_eu.a(var1.k("LastOutput"));
      }

      this.g.a(var1);
   }

   public boolean a(int var1, String var2) {
      return var1 <= 2;
   }

   public void a(String var1) {
      this.e = var1;
      this.b = 0;
   }

   public String l() {
      return this.e;
   }

   public void a(World var1) {
      if(var1.D) {
         this.b = 0;
      }

      MinecraftServer var2 = MinecraftServer.N();
      if(var2 != null && var2.O() && var2.al()) {
         class_l var3 = var2.P();

         try {
            this.d = null;
            this.b = var3.a(this, this.e);
         } catch (Throwable var7) {
            class_b var5 = class_b.a(var7, "Executing command block");
            class_c var6 = var5.a("Command to be executed");
            var6.a("Command", new Callable() {
               public String a() throws Exception {
                  return class_aed.this.l();
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            var6.a("Name", new Callable() {
               public String a() throws Exception {
                  return class_aed.this.e_();
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            throw new class_e(var5);
         }
      } else {
         this.b = 0;
      }

   }

   public String e_() {
      return this.f;
   }

   public class_eu f_() {
      return new class_fa(this.e_());
   }

   public void b(String var1) {
      this.f = var1;
   }

   public void a(class_eu var1) {
      if(this.c && this.e() != null && !this.e().D) {
         this.d = (new class_fa("[" + a.format(new Date()) + "] ")).a(var1);
         this.h();
      }

   }

   public boolean u_() {
      MinecraftServer var1 = MinecraftServer.N();
      return var1 == null || !var1.O() || var1.d[0].R().b("commandBlockOutput");
   }

   public void a(class_n.class_a_in_class_n var1, int var2) {
      this.g.a(this, var1, var2);
   }

   public abstract void h();

   public void b(class_eu var1) {
      this.d = var1;
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   public boolean m() {
      return this.c;
   }

   public boolean a(class_xa var1) {
      if(!var1.bH.d) {
         return false;
      } else {
         if(var1.e().D) {
            var1.a(this);
         }

         return true;
      }
   }

   public class_n n() {
      return this.g;
   }
}
