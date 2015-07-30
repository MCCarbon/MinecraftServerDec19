package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_awr;
import net.minecraft.server.class_awt;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_xa;

public class class_aws extends class_awr {
   public class_aws(String var1) {
      super(var1);
   }

   public int a(List var1) {
      float var2 = 0.0F;

      class_xa var4;
      for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 += var4.bo() + var4.bO()) {
         var4 = (class_xa)var3.next();
      }

      if(!var1.isEmpty()) {
         var2 /= (float)var1.size();
      }

      return MathHelper.ceil(var2);
   }

   public boolean b() {
      return true;
   }

   public class_awt.class_a_in_class_awt c() {
      return class_awt.class_a_in_class_awt.b;
   }
}
