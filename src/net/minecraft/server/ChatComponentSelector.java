package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.ChatBaseComponent;
import net.minecraft.server.IChatBaseComponent;

public class ChatComponentSelector extends ChatBaseComponent {
   private final String b;

   public ChatComponentSelector(String var1) {
      this.b = var1;
   }

   public String g() {
      return this.b;
   }

   public String getText() {
      return this.b;
   }

   public ChatComponentSelector h() {
      ChatComponentSelector var1 = new ChatComponentSelector(this.b);
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
      } else if(!(var1 instanceof ChatComponentSelector)) {
         return false;
      } else {
         ChatComponentSelector var2 = (ChatComponentSelector)var1;
         return this.b.equals(var2.b) && super.equals(var1);
      }
   }

   public String toString() {
      return "SelectorComponent{pattern=\'" + this.b + '\'' + ", siblings=" + this.a + ", style=" + this.getChatModifier() + '}';
   }

   // $FF: synthetic method
   public IChatBaseComponent f() {
      return this.h();
   }
}
