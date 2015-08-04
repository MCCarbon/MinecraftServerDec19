package net.minecraft.server;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import net.minecraft.server.NBTTagCompound;

public class GameRules {
   private TreeMap a = new TreeMap();

   public GameRules() {
      this.a("doFireTick", "true", GameRules.EnumGameRuleType.b);
      this.a("mobGriefing", "true", GameRules.EnumGameRuleType.b);
      this.a("keepInventory", "false", GameRules.EnumGameRuleType.b);
      this.a("doMobSpawning", "true", GameRules.EnumGameRuleType.b);
      this.a("doMobLoot", "true", GameRules.EnumGameRuleType.b);
      this.a("doTileDrops", "true", GameRules.EnumGameRuleType.b);
      this.a("doEntityDrops", "true", GameRules.EnumGameRuleType.b);
      this.a("commandBlockOutput", "true", GameRules.EnumGameRuleType.b);
      this.a("naturalRegeneration", "true", GameRules.EnumGameRuleType.b);
      this.a("doDaylightCycle", "true", GameRules.EnumGameRuleType.b);
      this.a("logAdminCommands", "true", GameRules.EnumGameRuleType.b);
      this.a("showDeathMessages", "true", GameRules.EnumGameRuleType.b);
      this.a("randomTickSpeed", "3", GameRules.EnumGameRuleType.c);
      this.a("sendCommandFeedback", "true", GameRules.EnumGameRuleType.b);
      this.a("reducedDebugInfo", "false", GameRules.EnumGameRuleType.b);
   }

   public void a(String var1, String var2, GameRules.EnumGameRuleType var3) {
      this.a.put(var1, new GameRules.GameRuleValue(var2, var3));
   }

   public void a(String var1, String var2) {
      GameRules.GameRuleValue var3 = (GameRules.GameRuleValue)this.a.get(var1);
      if(var3 != null) {
         var3.a(var2);
      } else {
         this.a(var1, var2, GameRules.EnumGameRuleType.a);
      }

   }

   public String a(String var1) {
      GameRules.GameRuleValue var2 = (GameRules.GameRuleValue)this.a.get(var1);
      return var2 != null?var2.a():"";
   }

   public boolean b(String var1) {
      GameRules.GameRuleValue var2 = (GameRules.GameRuleValue)this.a.get(var1);
      return var2 != null?var2.b():false;
   }

   public int c(String var1) {
      GameRules.GameRuleValue var2 = (GameRules.GameRuleValue)this.a.get(var1);
      return var2 != null?var2.c():0;
   }

   public NBTTagCompound a() {
      NBTTagCompound var1 = new NBTTagCompound();
      Iterator var2 = this.a.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         GameRules.GameRuleValue var4 = (GameRules.GameRuleValue)this.a.get(var3);
         var1.put(var3, var4.a());
      }

      return var1;
   }

   public void a(NBTTagCompound var1) {
      Set var2 = var1.getKeys();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         String var6 = var1.getString(var4);
         this.a(var4, var6);
      }

   }

   public String[] b() {
      Set var1 = this.a.keySet();
      return (String[])var1.toArray(new String[var1.size()]);
   }

   public boolean e(String var1) {
      return this.a.containsKey(var1);
   }

   public boolean a(String var1, GameRules.EnumGameRuleType var2) {
      GameRules.GameRuleValue var3 = (GameRules.GameRuleValue)this.a.get(var1);
      return var3 != null && (var3.e() == var2 || var2 == GameRules.EnumGameRuleType.a);
   }

   public static enum EnumGameRuleType {
      a,
      b,
      c;
   }

   static class GameRuleValue {
      private String a;
      private boolean b;
      private int c;
      private double d;
      private final GameRules.EnumGameRuleType e;

      public GameRuleValue(String var1, GameRules.EnumGameRuleType var2) {
         this.e = var2;
         this.a(var1);
      }

      public void a(String var1) {
         this.a = var1;
         this.b = Boolean.parseBoolean(var1);
         this.c = this.b?1:0;

         try {
            this.c = Integer.parseInt(var1);
         } catch (NumberFormatException var4) {
            ;
         }

         try {
            this.d = Double.parseDouble(var1);
         } catch (NumberFormatException var3) {
            ;
         }

      }

      public String a() {
         return this.a;
      }

      public boolean b() {
         return this.b;
      }

      public int c() {
         return this.c;
      }

      public GameRules.EnumGameRuleType e() {
         return this.e;
      }
   }
}
