package net.minecraft.server;

import java.util.List;
import net.minecraft.server.class_awt;

public class class_awr implements class_awt {
   private final String j;

   public class_awr(String var1) {
      this.j = var1;
      class_awt.a.put(var1, this);
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
