package net.minecraft.server;

import java.util.Collection;
import java.util.Iterator;
import net.minecraft.server.EnumChatFormat;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awk;
import net.minecraft.server.class_awl;
import net.minecraft.server.class_awn;
import net.minecraft.server.class_awp;
import net.minecraft.server.class_awt;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTagString;
import net.minecraft.server.NBTTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_awo extends class_avd {
   private static final Logger b = LogManager.getLogger();
   private class_awn c;
   private NBTTagCompound d;

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

   public void a(NBTTagCompound var1) {
      if(this.c == null) {
         this.d = var1;
      } else {
         this.b(var1.getList("Objectives", 10));
         this.c(var1.getList("PlayerScores", 10));
         if(var1.hasOfType("DisplaySlots", 10)) {
            this.c(var1.getCompound("DisplaySlots"));
         }

         if(var1.hasOfType("Teams", 9)) {
            this.a(var1.getList("Teams", 10));
         }

      }
   }

   protected void a(NBTTagList var1) {
      for(int var2 = 0; var2 < var1.getSize(); ++var2) {
         NBTTagCompound var3 = var1.getCompound(var2);
         String var4 = var3.getString("Name");
         if(var4.length() > 16) {
            var4 = var4.substring(0, 16);
         }

         class_awk var5 = this.c.e(var4);
         String var6 = var3.getString("DisplayName");
         if(var6.length() > 32) {
            var6 = var6.substring(0, 32);
         }

         var5.a(var6);
         if(var3.hasOfType("TeamColor", 8)) {
            var5.a(EnumChatFormat.getByName(var3.getString("TeamColor")));
         }

         var5.b(var3.getString("Prefix"));
         var5.c(var3.getString("Suffix"));
         if(var3.hasOfType("AllowFriendlyFire", 99)) {
            var5.a(var3.getBoolean("AllowFriendlyFire"));
         }

         if(var3.hasOfType("SeeFriendlyInvisibles", 99)) {
            var5.b(var3.getBoolean("SeeFriendlyInvisibles"));
         }

         class_awp.class_a_in_class_awp var7;
         if(var3.hasOfType("NameTagVisibility", 8)) {
            var7 = class_awp.class_a_in_class_awp.a(var3.getString("NameTagVisibility"));
            if(var7 != null) {
               var5.a(var7);
            }
         }

         if(var3.hasOfType("DeathMessageVisibility", 8)) {
            var7 = class_awp.class_a_in_class_awp.a(var3.getString("DeathMessageVisibility"));
            if(var7 != null) {
               var5.b(var7);
            }
         }

         this.a(var5, var3.getList("Players", 8));
      }

   }

   protected void a(class_awk var1, NBTTagList var2) {
      for(int var3 = 0; var3 < var2.getSize(); ++var3) {
         this.c.a(var2.getString(var3), var1.b());
      }

   }

   protected void c(NBTTagCompound var1) {
      for(int var2 = 0; var2 < 19; ++var2) {
         if(var1.hasOfType("slot_" + var2, 8)) {
            String var3 = var1.getString("slot_" + var2);
            class_awj var4 = this.c.b(var3);
            this.c.a(var2, var4);
         }
      }

   }

   protected void b(NBTTagList var1) {
      for(int var2 = 0; var2 < var1.getSize(); ++var2) {
         NBTTagCompound var3 = var1.getCompound(var2);
         class_awt var4 = (class_awt)class_awt.a.get(var3.getString("CriteriaName"));
         if(var4 != null) {
            String var5 = var3.getString("Name");
            if(var5.length() > 16) {
               var5 = var5.substring(0, 16);
            }

            class_awj var6 = this.c.a(var5, var4);
            var6.a(var3.getString("DisplayName"));
            var6.a(class_awt.class_a_in_class_awt.a(var3.getString("RenderType")));
         }
      }

   }

   protected void c(NBTTagList var1) {
      for(int var2 = 0; var2 < var1.getSize(); ++var2) {
         NBTTagCompound var3 = var1.getCompound(var2);
         class_awj var4 = this.c.b(var3.getString("Objective"));
         String var5 = var3.getString("Name");
         if(var5.length() > 40) {
            var5 = var5.substring(0, 40);
         }

         class_awl var6 = this.c.c(var5, var4);
         var6.c(var3.getInt("Score"));
         if(var3.has("Locked")) {
            var6.a(var3.getBoolean("Locked"));
         }
      }

   }

   public void b(NBTTagCompound var1) {
      if(this.c == null) {
         b.warn("Tried to save scoreboard without having WOOD scoreboard...");
      } else {
         var1.put((String)"Objectives", (NBTTag)this.b());
         var1.put((String)"PlayerScores", (NBTTag)this.e());
         var1.put((String)"Teams", (NBTTag)this.a());
         this.d(var1);
      }
   }

   protected NBTTagList a() {
      NBTTagList var1 = new NBTTagList();
      Collection var2 = this.c.g();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         class_awk var4 = (class_awk)var3.next();
         NBTTagCompound var5 = new NBTTagCompound();
         var5.put("Name", var4.b());
         var5.put("DisplayName", var4.c());
         if(var4.l().getId() >= 0) {
            var5.put("TeamColor", var4.l().getName());
         }

         var5.put("Prefix", var4.e());
         var5.put("Suffix", var4.f());
         var5.put("AllowFriendlyFire", var4.g());
         var5.put("SeeFriendlyInvisibles", var4.h());
         var5.put("NameTagVisibility", var4.i().e);
         var5.put("DeathMessageVisibility", var4.j().e);
         NBTTagList var6 = new NBTTagList();
         Iterator var7 = var4.d().iterator();

         while(var7.hasNext()) {
            String var8 = (String)var7.next();
            var6.add((NBTTag)(new NBTTagString(var8)));
         }

         var5.put((String)"Players", (NBTTag)var6);
         var1.add((NBTTag)var5);
      }

      return var1;
   }

   protected void d(NBTTagCompound var1) {
      NBTTagCompound var2 = new NBTTagCompound();
      boolean var3 = false;

      for(int var4 = 0; var4 < 19; ++var4) {
         class_awj var5 = this.c.a(var4);
         if(var5 != null) {
            var2.put("slot_" + var4, var5.b());
            var3 = true;
         }
      }

      if(var3) {
         var1.put((String)"DisplaySlots", (NBTTag)var2);
      }

   }

   protected NBTTagList b() {
      NBTTagList var1 = new NBTTagList();
      Collection var2 = this.c.c();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         class_awj var4 = (class_awj)var3.next();
         if(var4.c() != null) {
            NBTTagCompound var5 = new NBTTagCompound();
            var5.put("Name", var4.b());
            var5.put("CriteriaName", var4.c().a());
            var5.put("DisplayName", var4.d());
            var5.put("RenderType", var4.e().a());
            var1.add((NBTTag)var5);
         }
      }

      return var1;
   }

   protected NBTTagList e() {
      NBTTagList var1 = new NBTTagList();
      Collection var2 = this.c.e();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         class_awl var4 = (class_awl)var3.next();
         if(var4.d() != null) {
            NBTTagCompound var5 = new NBTTagCompound();
            var5.put("Name", var4.e());
            var5.put("Objective", var4.d().b());
            var5.put("Score", var4.c());
            var5.put("Locked", var4.g());
            var1.add((NBTTag)var5);
         }
      }

      return var1;
   }
}
