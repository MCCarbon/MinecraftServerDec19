package net.minecraft.server;

import java.util.List;
import net.minecraft.server.EnumChatFormat;
import net.minecraft.server.class_awt;

public class class_awq implements class_awt {
   private final String j;

   public class_awq(String var1, EnumChatFormat var2) {
      this.j = var1 + var2.getName();
      class_awt.a.put(this.j, this);
   }

   public String a() {
      return this.j;
   }

   public int a(List var1) {
      return 0;
   }

   public boolean b() {
      return false;
   }

   public class_awt.class_a_in_class_awt c() {
      return class_awt.class_a_in_class_awt.a;
   }
}
