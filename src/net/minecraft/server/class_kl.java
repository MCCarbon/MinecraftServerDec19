package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awk;
import net.minecraft.server.class_awl;
import net.minecraft.server.class_awn;
import net.minecraft.server.class_awo;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.server.PacketPlayOutScoreboardObjective;
import net.minecraft.server.PacketPlayOutScoreboardTeam;
import net.minecraft.server.PacketPlayOutScoreboardScore;
import net.minecraft.server.class_lh;

public class class_kl extends class_awn {
   private final MinecraftServer a;
   private final Set b = Sets.newHashSet();
   private class_awo c;

   public class_kl(MinecraftServer var1) {
      this.a = var1;
   }

   public void a(class_awl var1) {
      super.a(var1);
      if(this.b.contains(var1.d())) {
         this.a.getPlayerList().a((Packet)(new PacketPlayOutScoreboardScore(var1)));
      }

      this.b();
   }

   public void a(String var1) {
      super.a(var1);
      this.a.getPlayerList().a((Packet)(new PacketPlayOutScoreboardScore(var1)));
      this.b();
   }

   public void a(String var1, class_awj var2) {
      super.a(var1, var2);
      this.a.getPlayerList().a((Packet)(new PacketPlayOutScoreboardScore(var1, var2)));
      this.b();
   }

   public void a(int var1, class_awj var2) {
      class_awj var3 = this.a(var1);
      super.a(var1, var2);
      if(var3 != var2 && var3 != null) {
         if(this.h(var3) > 0) {
            this.a.getPlayerList().a((Packet)(new PacketPlayOutScoreboardDisplayObjective(var1, var2)));
         } else {
            this.g(var3);
         }
      }

      if(var2 != null) {
         if(this.b.contains(var2)) {
            this.a.getPlayerList().a((Packet)(new PacketPlayOutScoreboardDisplayObjective(var1, var2)));
         } else {
            this.e(var2);
         }
      }

      this.b();
   }

   public boolean a(String var1, String var2) {
      if(super.a(var1, var2)) {
         class_awk var3 = this.d(var2);
         this.a.getPlayerList().a((Packet)(new PacketPlayOutScoreboardTeam(var3, Arrays.asList(new String[]{var1}), 3)));
         this.b();
         return true;
      } else {
         return false;
      }
   }

   public void a(String var1, class_awk var2) {
      super.a(var1, var2);
      this.a.getPlayerList().a((Packet)(new PacketPlayOutScoreboardTeam(var2, Arrays.asList(new String[]{var1}), 4)));
      this.b();
   }

   public void a(class_awj var1) {
      super.a(var1);
      this.b();
   }

   public void b(class_awj var1) {
      super.b(var1);
      if(this.b.contains(var1)) {
         this.a.getPlayerList().a((Packet)(new PacketPlayOutScoreboardObjective(var1, 2)));
      }

      this.b();
   }

   public void c(class_awj var1) {
      super.c(var1);
      if(this.b.contains(var1)) {
         this.g(var1);
      }

      this.b();
   }

   public void a(class_awk var1) {
      super.a(var1);
      this.a.getPlayerList().a((Packet)(new PacketPlayOutScoreboardTeam(var1, 0)));
      this.b();
   }

   public void b(class_awk var1) {
      super.b(var1);
      this.a.getPlayerList().a((Packet)(new PacketPlayOutScoreboardTeam(var1, 2)));
      this.b();
   }

   public void c(class_awk var1) {
      super.c(var1);
      this.a.getPlayerList().a((Packet)(new PacketPlayOutScoreboardTeam(var1, 1)));
      this.b();
   }

   public void a(class_awo var1) {
      this.c = var1;
   }

   protected void b() {
      if(this.c != null) {
         this.c.c();
      }

   }

   public List d(class_awj var1) {
      ArrayList var2 = Lists.newArrayList();
      var2.add(new PacketPlayOutScoreboardObjective(var1, 0));

      for(int var3 = 0; var3 < 19; ++var3) {
         if(this.a(var3) == var1) {
            var2.add(new PacketPlayOutScoreboardDisplayObjective(var3, var1));
         }
      }

      Iterator var5 = this.i(var1).iterator();

      while(var5.hasNext()) {
         class_awl var4 = (class_awl)var5.next();
         var2.add(new PacketPlayOutScoreboardScore(var4));
      }

      return var2;
   }

   public void e(class_awj var1) {
      List var2 = this.d(var1);
      Iterator var3 = this.a.getPlayerList().v().iterator();

      while(var3.hasNext()) {
         class_lh var4 = (class_lh)var3.next();
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            Packet var6 = (Packet)var5.next();
            var4.a.a(var6);
         }
      }

      this.b.add(var1);
   }

   public List f(class_awj var1) {
      ArrayList var2 = Lists.newArrayList();
      var2.add(new PacketPlayOutScoreboardObjective(var1, 1));

      for(int var3 = 0; var3 < 19; ++var3) {
         if(this.a(var3) == var1) {
            var2.add(new PacketPlayOutScoreboardDisplayObjective(var3, var1));
         }
      }

      return var2;
   }

   public void g(class_awj var1) {
      List var2 = this.f(var1);
      Iterator var3 = this.a.getPlayerList().v().iterator();

      while(var3.hasNext()) {
         class_lh var4 = (class_lh)var3.next();
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            Packet var6 = (Packet)var5.next();
            var4.a.a(var6);
         }
      }

      this.b.remove(var1);
   }

   public int h(class_awj var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < 19; ++var3) {
         if(this.a(var3) == var1) {
            ++var2;
         }
      }

      return var2;
   }
}
