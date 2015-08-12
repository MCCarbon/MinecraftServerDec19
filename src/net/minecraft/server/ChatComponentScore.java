package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awl;
import net.minecraft.server.Scoreboard;
import net.minecraft.server.ChatBaseComponent;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.UtilColor;

public class ChatComponentScore extends ChatBaseComponent {
   private final String b;
   private final String c;
   private String d = "";

   public ChatComponentScore(String var1, String var2) {
      this.b = var1;
      this.c = var2;
   }

   public String g() {
      return this.b;
   }

   public String h() {
      return this.c;
   }

   public void b(String var1) {
      this.d = var1;
   }

   public String getText() {
      MinecraftServer var1 = MinecraftServer.getServer();
      if(var1 != null && var1.O() && UtilColor.isStringEmpty(this.d)) {
         Scoreboard var2 = var1.getWorldServer(0).aa();
         class_awj var3 = var2.b(this.c);
         if(var2.b(this.b, var3)) {
            class_awl var4 = var2.c(this.b, var3);
            this.b(String.format("%d", new Object[]{Integer.valueOf(var4.c())}));
         } else {
            this.d = "";
         }
      }

      return this.d;
   }

   public ChatComponentScore i() {
      ChatComponentScore var1 = new ChatComponentScore(this.b, this.c);
      var1.b(this.d);
      var1.setChatModifier(this.getChatModifier().m());
      Iterator var2 = this.a().iterator();

      while(var2.hasNext()) {
         IChatBaseComponent var3 = (IChatBaseComponent)var2.next();
         var1.addSibling(var3.f());
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof ChatComponentScore)) {
         return false;
      } else {
         ChatComponentScore var2 = (ChatComponentScore)var1;
         return this.b.equals(var2.b) && this.c.equals(var2.c) && super.equals(var1);
      }
   }

   public String toString() {
      return "ScoreComponent{name=\'" + this.b + '\'' + "objective=\'" + this.c + '\'' + ", siblings=" + this.a + ", style=" + this.getChatModifier() + '}';
   }

   // $FF: synthetic method
   public IChatBaseComponent f() {
      return this.i();
   }
}
