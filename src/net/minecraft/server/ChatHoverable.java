package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.server.IChatBaseComponent;

public class ChatHoverable {
   private final ChatHoverable.class_a_in_class_ew a;
   private final IChatBaseComponent b;

   public ChatHoverable(ChatHoverable.class_a_in_class_ew var1, IChatBaseComponent var2) {
      this.a = var1;
      this.b = var2;
   }

   public ChatHoverable.class_a_in_class_ew a() {
      return this.a;
   }

   public IChatBaseComponent b() {
      return this.b;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         ChatHoverable var2 = (ChatHoverable)var1;
         if(this.a != var2.a) {
            return false;
         } else {
            if(this.b != null) {
               if(!this.b.equals(var2.b)) {
                  return false;
               }
            } else if(var2.b != null) {
               return false;
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public String toString() {
      return "HoverEvent{action=" + this.a + ", value=\'" + this.b + '\'' + '}';
   }

   public int hashCode() {
      int var1 = this.a.hashCode();
      var1 = 31 * var1 + (this.b != null?this.b.hashCode():0);
      return var1;
   }

   public static enum class_a_in_class_ew {
      a("show_text", true),
      b("show_achievement", true),
      c("show_item", true),
      d("show_entity", true);

      private static final Map e;
      private final boolean f;
      private final String g;

      private class_a_in_class_ew(String var3, boolean var4) {
         this.g = var3;
         this.f = var4;
      }

      public boolean a() {
         return this.f;
      }

      public String b() {
         return this.g;
      }

      public static ChatHoverable.class_a_in_class_ew a(String var0) {
         return (ChatHoverable.class_a_in_class_ew)e.get(var0);
      }

      static {
         e = Maps.newHashMap();
         ChatHoverable.class_a_in_class_ew[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            ChatHoverable.class_a_in_class_ew var3 = var0[var2];
            e.put(var3.b(), var3);
         }

      }
   }
}
