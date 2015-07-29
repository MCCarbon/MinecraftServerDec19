package net.minecraft.server;

import java.util.Collection;
import java.util.Iterator;
import net.minecraft.server.class_a;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awk;
import net.minecraft.server.class_awl;
import net.minecraft.server.class_awn;
import net.minecraft.server.class_awp;
import net.minecraft.server.class_awt;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_ea;
import net.minecraft.server.class_eb;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_awo extends class_avd {
   private static final Logger b = LogManager.getLogger();
   private class_awn c;
   private class_dn d;

   public class_awo() {
      this("scoreboard");
   }

   public class_awo(String var1) {
      super(var1);
   }

   public void a(class_awn var1) {
      this.c = var1;
      if(this.d != null) {
         this.a(this.d);
      }

   }

   public void a(class_dn var1) {
      if(this.c == null) {
         this.d = var1;
      } else {
         this.b(var1.c("Objectives", 10));
         this.c(var1.c("PlayerScores", 10));
         if(var1.b("DisplaySlots", 10)) {
            this.c(var1.n("DisplaySlots"));
         }

         if(var1.b("Teams", 9)) {
            this.a(var1.c("Teams", 10));
         }

      }
   }

   protected void a(class_du var1) {
      for(int var2 = 0; var2 < var1.c(); ++var2) {
         class_dn var3 = var1.b(var2);
         String var4 = var3.k("Name");
         if(var4.length() > 16) {
            var4 = var4.substring(0, 16);
         }

         class_awk var5 = this.c.e(var4);
         String var6 = var3.k("DisplayName");
         if(var6.length() > 32) {
            var6 = var6.substring(0, 32);
         }

         var5.a(var6);
         if(var3.b("TeamColor", 8)) {
            var5.a(class_a.b(var3.k("TeamColor")));
         }

         var5.b(var3.k("Prefix"));
         var5.c(var3.k("Suffix"));
         if(var3.b("AllowFriendlyFire", 99)) {
            var5.a(var3.o("AllowFriendlyFire"));
         }

         if(var3.b("SeeFriendlyInvisibles", 99)) {
            var5.b(var3.o("SeeFriendlyInvisibles"));
         }

         class_awp.class_a_in_class_awp var7;
         if(var3.b("NameTagVisibility", 8)) {
            var7 = class_awp.class_a_in_class_awp.a(var3.k("NameTagVisibility"));
            if(var7 != null) {
               var5.a(var7);
            }
         }

         if(var3.b("DeathMessageVisibility", 8)) {
            var7 = class_awp.class_a_in_class_awp.a(var3.k("DeathMessageVisibility"));
            if(var7 != null) {
               var5.b(var7);
            }
         }

         this.a(var5, var3.c("Players", 8));
      }

   }

   protected void a(class_awk var1, class_du var2) {
      for(int var3 = 0; var3 < var2.c(); ++var3) {
         this.c.a(var2.g(var3), var1.b());
      }

   }

   protected void c(class_dn var1) {
      for(int var2 = 0; var2 < 19; ++var2) {
         if(var1.b("slot_" + var2, 8)) {
            String var3 = var1.k("slot_" + var2);
            class_awj var4 = this.c.b(var3);
            this.c.a(var2, var4);
         }
      }

   }

   protected void b(class_du var1) {
      for(int var2 = 0; var2 < var1.c(); ++var2) {
         class_dn var3 = var1.b(var2);
         class_awt var4 = (class_awt)class_awt.a.get(var3.k("CriteriaName"));
         if(var4 != null) {
            String var5 = var3.k("Name");
            if(var5.length() > 16) {
               var5 = var5.substring(0, 16);
            }

            class_awj var6 = this.c.a(var5, var4);
            var6.a(var3.k("DisplayName"));
            var6.a(class_awt.class_a_in_class_awt.a(var3.k("RenderType")));
         }
      }

   }

   protected void c(class_du var1) {
      for(int var2 = 0; var2 < var1.c(); ++var2) {
         class_dn var3 = var1.b(var2);
         class_awj var4 = this.c.b(var3.k("Objective"));
         String var5 = var3.k("Name");
         if(var5.length() > 40) {
            var5 = var5.substring(0, 40);
         }

         class_awl var6 = this.c.c(var5, var4);
         var6.c(var3.g("Score"));
         if(var3.d("Locked")) {
            var6.a(var3.o("Locked"));
         }
      }

   }

   public void b(class_dn var1) {
      if(this.c == null) {
         b.warn("Tried to save scoreboard without having a scoreboard...");
      } else {
         var1.a((String)"Objectives", (class_eb)this.b());
         var1.a((String)"PlayerScores", (class_eb)this.e());
         var1.a((String)"Teams", (class_eb)this.a());
         this.d(var1);
      }
   }

   protected class_du a() {
      class_du var1 = new class_du();
      Collection var2 = this.c.g();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         class_awk var4 = (class_awk)var3.next();
         class_dn var5 = new class_dn();
         var5.a("Name", var4.b());
         var5.a("DisplayName", var4.c());
         if(var4.l().b() >= 0) {
            var5.a("TeamColor", var4.l().e());
         }

         var5.a("Prefix", var4.e());
         var5.a("Suffix", var4.f());
         var5.a("AllowFriendlyFire", var4.g());
         var5.a("SeeFriendlyInvisibles", var4.h());
         var5.a("NameTagVisibility", var4.i().e);
         var5.a("DeathMessageVisibility", var4.j().e);
         class_du var6 = new class_du();
         Iterator var7 = var4.d().iterator();

         while(var7.hasNext()) {
            String var8 = (String)var7.next();
            var6.a((class_eb)(new class_ea(var8)));
         }

         var5.a((String)"Players", (class_eb)var6);
         var1.a((class_eb)var5);
      }

      return var1;
   }

   protected void d(class_dn var1) {
      class_dn var2 = new class_dn();
      boolean var3 = false;

      for(int var4 = 0; var4 < 19; ++var4) {
         class_awj var5 = this.c.a(var4);
         if(var5 != null) {
            var2.a("slot_" + var4, var5.b());
            var3 = true;
         }
      }

      if(var3) {
         var1.a((String)"DisplaySlots", (class_eb)var2);
      }

   }

   protected class_du b() {
      class_du var1 = new class_du();
      Collection var2 = this.c.c();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         class_awj var4 = (class_awj)var3.next();
         if(var4.c() != null) {
            class_dn var5 = new class_dn();
            var5.a("Name", var4.b());
            var5.a("CriteriaName", var4.c().a());
            var5.a("DisplayName", var4.d());
            var5.a("RenderType", var4.e().a());
            var1.a((class_eb)var5);
         }
      }

      return var1;
   }

   protected class_du e() {
      class_du var1 = new class_du();
      Collection var2 = this.c.e();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         class_awl var4 = (class_awl)var3.next();
         if(var4.d() != null) {
            class_dn var5 = new class_dn();
            var5.a("Name", var4.e());
            var5.a("Objective", var4.d().b());
            var5.a("Score", var4.c());
            var5.a("Locked", var4.g());
            var1.a((class_eb)var5);
         }
      }

      return var1;
   }
}
